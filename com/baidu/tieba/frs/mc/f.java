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
    private k ckY;
    private CustomMessageListener cxi = new CustomMessageListener(CmdConfigCustom.NEG_FEED_BACK_DELETE) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && f.this.ckY != null && f.this.ckY.afk() != null && f.this.ckY.afk().aig() != null) {
                String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                if (!StringUtils.isNull(optString)) {
                    boolean z = false;
                    if (f.this.ckY.afp() != null && f.this.ckY.afp().agi() != null) {
                        View childAt = f.this.ckY.afp().getListView().getChildAt(f.this.a(optString, f.this.ckY.afp().getListView()));
                        if (childAt != null) {
                            f.this.ao(childAt);
                            z = true;
                        } else {
                            f.this.ckY.afp().agi().notifyDataSetChanged();
                        }
                    }
                    ArrayList<com.baidu.adp.widget.ListView.f> threadList = f.this.ckY.afk().aig().getThreadList();
                    f.this.f(optString, threadList);
                    f.this.f(optString, f.this.ckY.afp().getListView().getData());
                    f.this.ckY.afk().ky(optString);
                    if (!z && f.this.ckY.afp() != null && f.this.ckY.afp().agi() != null) {
                        f.this.ckY.afp().agi().notifyDataSetChanged();
                    }
                    if (threadList != null && threadList.size() < 5) {
                        f.this.ckY.MS();
                    }
                }
            }
        }
    };
    private CustomMessageListener cxj = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.frs.mc.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && f.this.ckY != null && f.this.ckY.afk() != null && f.this.ckY.afk().aig() != null) {
                String str = (String) customResponsedMessage.getData();
                f.this.g(str, f.this.ckY.afk().aig().aPJ().getBannerListData().getAllAdvertList());
                f.this.h(str, f.this.ckY.afp().getListView().getData());
                f.this.h(str, f.this.ckY.afl().aiT().getDataList());
                f.this.ckY.afk().kz(str);
                if (f.this.ckY.afp() != null && f.this.ckY.afp().agi() != null) {
                    f.this.ckY.afp().agi().notifyDataSetChanged();
                }
            }
        }
    };

    public f(k kVar, BdUniqueId bdUniqueId) {
        this.ckY = kVar;
        this.cxi.setTag(bdUniqueId);
        this.cxj.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.cxi);
        MessageManager.getInstance().registerListener(this.cxj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, List<com.baidu.adp.widget.ListView.f> list) {
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
    public void ao(final View view) {
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
                if (f.this.ckY.afp() != null && f.this.ckY.afp().agi() != null) {
                    f.this.ckY.afp().agi().notifyDataSetChanged();
                }
            }
        });
        animation.setDuration(300L);
        view.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, List<AdvertAppInfo> list) {
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
    public void h(String str, List<com.baidu.adp.widget.ListView.f> list) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.baidu.adp.widget.ListView.f> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof com.baidu.tieba.InjectPlugin.a) {
                    Object Jq = ((com.baidu.tieba.InjectPlugin.a) next).Jq();
                    if ((Jq instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) Jq).UK)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
