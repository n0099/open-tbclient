package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private CustomMessageListener cOv = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cOw = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cOx = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.cyP != null && e.this.cyP.aiR() != null && e.this.cyP.aiR().amp() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.cyP.aiR().amp().aPM().getBannerListData().getAllAdvertList());
                e.this.h(str, e.this.cyP.aiW().getListView().getData());
                e.this.h(str, e.this.cyP.aiS().anx().getDataList());
                e.this.cyP.aiR().ln(str);
                if (e.this.cyP.aiW() != null && e.this.cyP.aiW().ajN() != null) {
                    e.this.cyP.aiW().ajN().notifyDataSetChanged();
                }
            }
        }
    };
    private j cyP;

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.cyP = jVar;
        this.cOv.setTag(bdUniqueId);
        this.cOx.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cOv);
        MessageManager.getInstance().registerListener(this.cOx);
        this.cOw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cOw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.cyP != null && this.cyP.aiR() != null && this.cyP.aiR().amp() != null) {
            final String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.cyP.aiW() != null && this.cyP.aiW().ajN() != null) {
                final View childAt = this.cyP.aiW().getListView().getChildAt(a(optString, this.cyP.aiW().getListView()));
                if (childAt != null) {
                    a(childAt, new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.mc.e.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            e.this.lo(optString);
                            childAt.setVisibility(8);
                            if (e.this.cyP.aiW() != null && e.this.cyP.aiW().ajN() != null) {
                                e.this.cyP.aiW().ajN().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                lo(optString);
                this.cyP.aiW().ajN().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lo(String str) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cyP.aiR().amp().getThreadList();
        f(str, threadList);
        f(str, this.cyP.aiW().getListView().getData());
        this.cyP.aiR().lm(str);
        if (threadList != null && threadList.size() < 5) {
            this.cyP.NF();
        }
    }

    private void f(String str, List<com.baidu.adp.widget.ListView.f> list) {
        if (v.u(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof bh) {
                    bh bhVar = (bh) fVar;
                    if (bhVar.getTid() != null && bhVar.getTid().equals(str)) {
                        arrayList.add(bhVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) v.c(list, 0);
            if (fVar2 instanceof p) {
                list.remove(fVar2);
            }
        }
    }

    private int a(String str, BdTypeListView bdTypeListView) {
        int headerViewsCount = bdTypeListView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeListView.getFirstVisiblePosition();
        int i = 0;
        for (int i2 = 0; i2 < bdTypeListView.getAdapter().getCount(); i2++) {
            com.baidu.adp.widget.ListView.f item = bdTypeListView.getItem(i2);
            if (item instanceof bh) {
                bh bhVar = (bh) item;
                if (bhVar.getTid() != null && bhVar.getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    private void a(final View view, Animation.AnimationListener animationListener) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.frs.mc.e.4
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                view.getLayoutParams().height = measuredHeight - ((int) (measuredHeight * f));
                view.requestLayout();
            }

            @Override // android.view.animation.Animation
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setAnimationListener(animationListener);
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.Ug)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, List<com.baidu.adp.widget.ListView.f> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object JL = ((com.baidu.tieba.InjectPlugin.a) next).JL();
                    if ((JL instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) JL).Ug)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
