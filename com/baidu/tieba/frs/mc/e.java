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
    private CustomMessageListener cFi = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cFj = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.d(customResponsedMessage);
        }
    };
    private CustomMessageListener cFk = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.cru != null && e.this.cru.agK() != null && e.this.cru.agK().akc() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.g(str, e.this.cru.agK().akc().aMU().getBannerListData().getAllAdvertList());
                e.this.h(str, e.this.cru.agP().getListView().getData());
                e.this.h(str, e.this.cru.agL().akM().getDataList());
                e.this.cru.agK().kM(str);
                if (e.this.cru.agP() != null && e.this.cru.agP().ahF() != null) {
                    e.this.cru.agP().ahF().notifyDataSetChanged();
                }
            }
        }
    };
    private j cru;

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.cru = jVar;
        this.cFi.setTag(bdUniqueId);
        this.cFk.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cFi);
        MessageManager.getInstance().registerListener(this.cFk);
        this.cFj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cFj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && this.cru != null && this.cru.agK() != null && this.cru.agK().akc() != null) {
            final String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (!StringUtils.isNull(optString) && this.cru.agP() != null && this.cru.agP().ahF() != null) {
                final View childAt = this.cru.agP().getListView().getChildAt(a(optString, this.cru.agP().getListView()));
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
                            e.this.kN(optString);
                            childAt.setVisibility(8);
                            if (e.this.cru.agP() != null && e.this.cru.agP().ahF() != null) {
                                e.this.cru.agP().ahF().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                kN(optString);
                this.cru.agP().ahF().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kN(String str) {
        ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cru.agK().akc().getThreadList();
        f(str, threadList);
        f(str, this.cru.agP().getListView().getData());
        this.cru.agK().kL(str);
        if (threadList != null && threadList.size() < 5) {
            this.cru.Ns();
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
                if (next != null && str.equals(next.TO)) {
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
                    Object JB = ((com.baidu.tieba.InjectPlugin.a) next).JB();
                    if ((JB instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) JB).TO)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
