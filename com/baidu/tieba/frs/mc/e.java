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
    private CustomMessageListener cFu = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cFv = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cFw = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.crG != null && e.this.crG.agP() != null && e.this.crG.agP().akh() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.crG.agP().akh().aMZ().getBannerListData().getAllAdvertList());
                e.this.h(str, e.this.crG.agU().getListView().getData());
                e.this.h(str, e.this.crG.agQ().akR().getDataList());
                e.this.crG.agP().kN(str);
                if (e.this.crG.agU() != null && e.this.crG.agU().ahK() != null) {
                    e.this.crG.agU().ahK().notifyDataSetChanged();
                }
            }
        }
    };
    private j crG;

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.crG = jVar;
        this.cFu.setTag(bdUniqueId);
        this.cFw.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cFu);
        MessageManager.getInstance().registerListener(this.cFw);
        this.cFv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cFv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.crG != null && this.crG.agP() != null && this.crG.agP().akh() != null) {
            final String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.crG.agU() != null && this.crG.agU().ahK() != null) {
                final View childAt = this.crG.agU().getListView().getChildAt(a(optString, this.crG.agU().getListView()));
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
                            e.this.kO(optString);
                            childAt.setVisibility(8);
                            if (e.this.crG.agU() != null && e.this.crG.agU().ahK() != null) {
                                e.this.crG.agU().ahK().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                kO(optString);
                this.crG.agU().ahK().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kO(String str) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.crG.agP().akh().getThreadList();
        f(str, threadList);
        f(str, this.crG.agU().getListView().getData());
        this.crG.agP().kM(str);
        if (threadList != null && threadList.size() < 5) {
            this.crG.Ny();
        }
    }

    private void f(String str, List<com.baidu.adp.widget.ListView.f> list) {
        if (v.t(list) != 0) {
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
                if (next != null && str.equals(next.Ua)) {
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
                    Object JH = ((com.baidu.tieba.InjectPlugin.a) next).JH();
                    if ((JH instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) JH).Ua)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
