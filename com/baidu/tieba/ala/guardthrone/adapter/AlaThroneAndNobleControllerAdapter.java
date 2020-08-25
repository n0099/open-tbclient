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
/* loaded from: classes7.dex */
public class AlaThroneAndNobleControllerAdapter extends PagerAdapter {
    private String aHi;
    private String ber;
    private ArrayList<com.baidu.live.h.b> gev = new ArrayList<>();
    private ArrayList<com.baidu.tieba.ala.guardthrone.b.b> gew = new ArrayList<>();
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;

    public AlaThroneAndNobleControllerAdapter(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.ber = str2;
        this.aHi = str3;
        this.mTabId = i;
        this.mIsHost = z;
        bKS();
    }

    private void bKS() {
        com.baidu.tieba.ala.guardthrone.b.b bVar = new com.baidu.tieba.ala.guardthrone.b.b();
        com.baidu.tieba.ala.guardthrone.a.a aVar = new com.baidu.tieba.ala.guardthrone.a.a();
        aVar.a(this.mTbPageContext, this.mLiveId, this.ber, this.aHi, this.mTabId, this.mIsHost);
        this.gev.add(aVar);
        bVar.tabName = this.mTbPageContext.getString(a.i.guard_throne_title);
        bVar.geM = "guard_throne";
        this.gew.add(bVar);
        com.baidu.live.h.b bVar2 = null;
        c cVar = new c();
        cVar.mTbPageContext = this.mTbPageContext;
        cVar.mLiveId = this.mLiveId;
        cVar.ber = this.ber;
        cVar.aHi = this.aHi;
        cVar.mTabId = this.mTabId;
        cVar.mIsHost = this.mIsHost;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913204, com.baidu.live.h.b.class, cVar);
        if (runTask != null && runTask.getData() != null) {
            bVar2 = (com.baidu.live.h.b) runTask.getData();
        }
        if (bVar2 != null) {
            this.gev.add(bVar2);
            com.baidu.tieba.ala.guardthrone.b.b bVar3 = new com.baidu.tieba.ala.guardthrone.b.b();
            bVar3.tabName = this.mTbPageContext.getString(a.i.noble_title);
            bVar3.geM = "noble";
            this.gew.add(bVar3);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.gev != null) {
            return this.gev.size();
        }
        return 0;
    }

    public ArrayList<com.baidu.live.h.b> getDataList() {
        return this.gev;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        com.baidu.live.h.b bVar = (com.baidu.live.h.b) ListUtils.getItem(this.gev, i);
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

    public void sq(int i) {
        if (i >= 0 && i < this.gew.size()) {
            for (int i2 = 0; i2 < this.gev.size(); i2++) {
                com.baidu.live.h.b bVar = this.gev.get(i2);
                if (i2 == i) {
                    bVar.bJ(true);
                } else {
                    bVar.bJ(false);
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!ListUtils.isEmpty(this.gev)) {
            Iterator<com.baidu.live.h.b> it = this.gev.iterator();
            while (it.hasNext()) {
                it.next().onConfigurationChanged(configuration);
            }
        }
    }

    public void onDestroy() {
        if (!ListUtils.isEmpty(this.gev)) {
            Iterator<com.baidu.live.h.b> it = this.gev.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
    }
}
