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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private k ckl;
    private CustomMessageListener cvf = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && f.this.ckl != null && f.this.ckl.aeU() != null && f.this.ckl.aeU().ahS() != null) {
                String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                if (!StringUtils.isNull(optString)) {
                    boolean z = false;
                    if (f.this.ckl.aeZ() != null && f.this.ckl.aeZ().afR() != null) {
                        View childAt = f.this.ckl.aeZ().getListView().getChildAt(f.this.a(optString, f.this.ckl.aeZ().getListView()));
                        if (childAt != null) {
                            f.this.an(childAt);
                            z = true;
                        } else {
                            f.this.ckl.aeZ().afR().notifyDataSetChanged();
                        }
                    }
                    ArrayList<com.baidu.adp.widget.ListView.f> threadList = f.this.ckl.aeU().ahS().getThreadList();
                    f.this.g(optString, threadList);
                    f.this.g(optString, f.this.ckl.aeZ().getListView().getData());
                    f.this.ckl.aeU().kr(optString);
                    if (!z && f.this.ckl.aeZ() != null && f.this.ckl.aeZ().afR() != null) {
                        f.this.ckl.aeZ().afR().notifyDataSetChanged();
                    }
                    if (threadList != null && threadList.size() < 5) {
                        f.this.ckl.MS();
                    }
                }
            }
        }
    };
    private CustomMessageListener cvg = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && f.this.ckl != null && f.this.ckl.aeU() != null && f.this.ckl.aeU().ahS() != null) {
                String str = (String) customResponsedMessage.getData();
                f.this.h(str, f.this.ckl.aeU().ahS().aPh().getBannerListData().getAllAdvertList());
                f.this.i(str, f.this.ckl.aeZ().getListView().getData());
                f.this.i(str, f.this.ckl.aeV().ais().getDataList());
                f.this.ckl.aeU().ks(str);
                if (f.this.ckl.aeZ() != null && f.this.ckl.aeZ().afR() != null) {
                    f.this.ckl.aeZ().afR().notifyDataSetChanged();
                }
            }
        }
    };

    public f(k kVar, BdUniqueId bdUniqueId) {
        this.ckl = kVar;
        this.cvf.setTag(bdUniqueId);
        this.cvg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cvf);
        MessageManager.getInstance().registerListener(this.cvg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<com.baidu.adp.widget.ListView.f> list) {
        if (u.u(list) != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof bl) {
                    bl blVar = (bl) fVar;
                    if (blVar.getTid() != null && blVar.getTid().equals(str)) {
                        arrayList.add(blVar);
                    }
                }
            }
            list.removeAll(arrayList);
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) u.c(list, 0);
            if (fVar2 instanceof p) {
                list.remove(fVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, BdTypeListView bdTypeListView) {
        int headerViewsCount = bdTypeListView.getHeaderViewsCount();
        int firstVisiblePosition = bdTypeListView.getFirstVisiblePosition();
        int i = 0;
        for (int i2 = 0; i2 < bdTypeListView.getAdapter().getCount(); i2++) {
            com.baidu.adp.widget.ListView.f item = bdTypeListView.getItem(i2);
            if (item instanceof bl) {
                bl blVar = (bl) item;
                if (blVar.getTid() != null && blVar.getTid().equals(str)) {
                    i = i2;
                }
            }
        }
        return (i + headerViewsCount) - firstVisiblePosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        Animation animation = new Animation() { // from class: com.baidu.tieba.frs.mc.f.2
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
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.frs.mc.f.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                view.setVisibility(8);
                if (f.this.ckl.aeZ() != null && f.this.ckl.aeZ().afR() != null) {
                    f.this.ckl.aeZ().afR().notifyDataSetChanged();
                }
            }
        });
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, List<AdvertAppInfo> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                if (next != null && str.equals(next.UH)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, List<com.baidu.adp.widget.ListView.f> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object Jq = ((com.baidu.tieba.InjectPlugin.a) next).Jq();
                    if ((Jq instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) Jq).UH)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
