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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private j cIw;
    private CustomMessageListener cYq = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.e(customResponsedMessage);
        }
    };
    private CustomMessageListener cYr = new CustomMessageListener(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB) { // from class: com.baidu.tieba.frs.mc.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.this.ly(e.this.d(customResponsedMessage));
            e.this.cIw.aln().amd().notifyDataSetChanged();
        }
    };
    private CustomMessageListener cYs = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && e.this.cIw != null && e.this.cIw.ali() != null && e.this.cIw.ali().aoH() != null) {
                String str = (String) customResponsedMessage.getData();
                e.this.e(str, e.this.cIw.ali().aoH().aRn().getBannerListData().getAllAdvertList());
                e.this.f(str, e.this.cIw.aln().getListView().getData());
                e.this.f(str, e.this.cIw.alj().apO().getDataList());
                e.this.cIw.ali().lx(str);
                if (e.this.cIw.aln() != null && e.this.cIw.aln().amd() != null) {
                    e.this.cIw.aln().amd().notifyDataSetChanged();
                }
            }
        }
    };

    public e(j jVar, BdUniqueId bdUniqueId) {
        this.cIw = jVar;
        this.cYq.setTag(bdUniqueId);
        this.cYs.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cYq);
        MessageManager.getInstance().registerListener(this.cYs);
        this.cYr.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cYr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(CustomResponsedMessage customResponsedMessage) {
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
            return null;
        }
        return ((JSONObject) customResponsedMessage.getData()).optString("tid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (this.cIw != null && this.cIw.ali() != null && this.cIw.ali().aoH() != null) {
            final String d = d(customResponsedMessage);
            if (!StringUtils.isNull(d) && this.cIw.aln() != null && this.cIw.aln().amd() != null) {
                final View childAt = this.cIw.aln().getListView().getChildAt(a(d, this.cIw.aln().getListView()));
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
                            e.this.ly(d);
                            childAt.setVisibility(8);
                            if (e.this.cIw.aln() != null && e.this.cIw.aln().amd() != null) {
                                e.this.cIw.aln().amd().notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
                ly(d);
                this.cIw.aln().amd().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly(String str) {
        if (!StringUtils.isNull(str)) {
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = this.cIw.ali().aoH().getThreadList();
            d(str, threadList);
            d(str, this.cIw.aln().getListView().getData());
            this.cIw.ali().lw(str);
            if (threadList != null && threadList.size() < 5) {
                this.cIw.OI();
            }
        }
    }

    private void d(String str, List<com.baidu.adp.widget.ListView.f> list) {
        if (v.v(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof bd) {
                    bd bdVar = (bd) fVar;
                    if (bdVar.getTid() != null && bdVar.getTid().equals(str)) {
                        arrayList.add(bdVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) v.c(list, 0);
            if (fVar2 instanceof q) {
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
            if (item instanceof bd) {
                bd bdVar = (bd) item;
                if (bdVar.getTid() != null && bdVar.getTid().equals(str)) {
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
    public void e(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.UK)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, List<com.baidu.adp.widget.ListView.f> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object Ku = ((com.baidu.tieba.InjectPlugin.a) next).Ku();
                    if ((Ku instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) Ku).UK)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
