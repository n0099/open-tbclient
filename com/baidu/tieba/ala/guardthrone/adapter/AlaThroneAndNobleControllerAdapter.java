package com.baidu.tieba.ala.guardthrone.adapter;

import android.content.res.Configuration;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.noble.data.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class AlaThroneAndNobleControllerAdapter extends PagerAdapter {
    private String aNj;
    private String bnP;
    private ArrayList<com.baidu.live.h.b> gJQ = new ArrayList<>();
    private ArrayList<com.baidu.tieba.ala.guardthrone.b.b> gJR = new ArrayList<>();
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;

    public AlaThroneAndNobleControllerAdapter(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bnP = str2;
        this.aNj = str3;
        this.mTabId = i;
        this.mIsHost = z;
        bTR();
    }

    private void bTR() {
        com.baidu.tieba.ala.guardthrone.b.b bVar = new com.baidu.tieba.ala.guardthrone.b.b();
        com.baidu.tieba.ala.guardthrone.a.a aVar = new com.baidu.tieba.ala.guardthrone.a.a();
        aVar.a(this.mTbPageContext, this.mLiveId, this.bnP, this.aNj, this.mTabId, this.mIsHost);
        this.gJQ.add(aVar);
        bVar.tabName = this.mTbPageContext.getString(a.h.guard_throne_title);
        bVar.gKf = "guard_throne";
        this.gJR.add(bVar);
        com.baidu.live.h.b bVar2 = null;
        c cVar = new c();
        cVar.mTbPageContext = this.mTbPageContext;
        cVar.mLiveId = this.mLiveId;
        cVar.bnP = this.bnP;
        cVar.aNj = this.aNj;
        cVar.mTabId = this.mTabId;
        cVar.mIsHost = this.mIsHost;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913204, com.baidu.live.h.b.class, cVar);
        if (runTask != null && runTask.getData() != null) {
            bVar2 = (com.baidu.live.h.b) runTask.getData();
        }
        if (bVar2 != null) {
            this.gJQ.add(bVar2);
            com.baidu.tieba.ala.guardthrone.b.b bVar3 = new com.baidu.tieba.ala.guardthrone.b.b();
            bVar3.tabName = this.mTbPageContext.getString(a.h.noble_title);
            bVar3.gKf = "noble";
            this.gJR.add(bVar3);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.gJQ != null) {
            return this.gJQ.size();
        }
        return 0;
    }

    public ArrayList<com.baidu.live.h.b> getDataList() {
        return this.gJQ;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        com.baidu.live.h.b bVar = (com.baidu.live.h.b) ListUtils.getItem(this.gJQ, i);
        if (bVar != null && bVar.getView() != null) {
            View view = bVar.getView();
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return bVar;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof com.baidu.live.h.b) && ((com.baidu.live.h.b) obj).getView() == view;
    }

    public void tA(int i) {
        if (i >= 0 && i < this.gJR.size()) {
            for (int i2 = 0; i2 < this.gJQ.size(); i2++) {
                com.baidu.live.h.b bVar = this.gJQ.get(i2);
                if (i2 == i) {
                    bVar.bQ(true);
                } else {
                    bVar.bQ(false);
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!ListUtils.isEmpty(this.gJQ)) {
            Iterator<com.baidu.live.h.b> it = this.gJQ.iterator();
            while (it.hasNext()) {
                it.next().onConfigurationChanged(configuration);
            }
        }
    }

    public void onDestroy() {
        if (!ListUtils.isEmpty(this.gJQ)) {
            Iterator<com.baidu.live.h.b> it = this.gJQ.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
    }
}
