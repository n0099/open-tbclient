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
    private String aIB;
    private String bhk;
    private ArrayList<com.baidu.live.h.b> ghK = new ArrayList<>();
    private ArrayList<com.baidu.tieba.ala.guardthrone.b.b> ghL = new ArrayList<>();
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;

    public AlaThroneAndNobleControllerAdapter(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bhk = str2;
        this.aIB = str3;
        this.mTabId = i;
        this.mIsHost = z;
        bMd();
    }

    private void bMd() {
        com.baidu.tieba.ala.guardthrone.b.b bVar = new com.baidu.tieba.ala.guardthrone.b.b();
        com.baidu.tieba.ala.guardthrone.a.a aVar = new com.baidu.tieba.ala.guardthrone.a.a();
        aVar.a(this.mTbPageContext, this.mLiveId, this.bhk, this.aIB, this.mTabId, this.mIsHost);
        this.ghK.add(aVar);
        bVar.tabName = this.mTbPageContext.getString(a.i.guard_throne_title);
        bVar.gia = "guard_throne";
        this.ghL.add(bVar);
        com.baidu.live.h.b bVar2 = null;
        c cVar = new c();
        cVar.mTbPageContext = this.mTbPageContext;
        cVar.mLiveId = this.mLiveId;
        cVar.bhk = this.bhk;
        cVar.aIB = this.aIB;
        cVar.mTabId = this.mTabId;
        cVar.mIsHost = this.mIsHost;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913204, com.baidu.live.h.b.class, cVar);
        if (runTask != null && runTask.getData() != null) {
            bVar2 = (com.baidu.live.h.b) runTask.getData();
        }
        if (bVar2 != null) {
            this.ghK.add(bVar2);
            com.baidu.tieba.ala.guardthrone.b.b bVar3 = new com.baidu.tieba.ala.guardthrone.b.b();
            bVar3.tabName = this.mTbPageContext.getString(a.i.noble_title);
            bVar3.gia = "noble";
            this.ghL.add(bVar3);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.ghK != null) {
            return this.ghK.size();
        }
        return 0;
    }

    public ArrayList<com.baidu.live.h.b> getDataList() {
        return this.ghK;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        com.baidu.live.h.b bVar = (com.baidu.live.h.b) ListUtils.getItem(this.ghK, i);
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

    public void sI(int i) {
        if (i >= 0 && i < this.ghL.size()) {
            for (int i2 = 0; i2 < this.ghK.size(); i2++) {
                com.baidu.live.h.b bVar = this.ghK.get(i2);
                if (i2 == i) {
                    bVar.bL(true);
                } else {
                    bVar.bL(false);
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!ListUtils.isEmpty(this.ghK)) {
            Iterator<com.baidu.live.h.b> it = this.ghK.iterator();
            while (it.hasNext()) {
                it.next().onConfigurationChanged(configuration);
            }
        }
    }

    public void onDestroy() {
        if (!ListUtils.isEmpty(this.ghK)) {
            Iterator<com.baidu.live.h.b> it = this.ghK.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
    }
}
