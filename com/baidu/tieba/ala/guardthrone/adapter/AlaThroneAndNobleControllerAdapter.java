package com.baidu.tieba.ala.guardthrone.adapter;

import android.content.res.Configuration;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.j.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class AlaThroneAndNobleControllerAdapter extends PagerAdapter {
    private String aOt;
    private String brl;
    private ArrayList<c> gSK = new ArrayList<>();
    private ArrayList<com.baidu.tieba.ala.guardthrone.b.b> gSL = new ArrayList<>();
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;

    public AlaThroneAndNobleControllerAdapter(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.brl = str2;
        this.aOt = str3;
        this.mTabId = i;
        this.mIsHost = z;
        bWV();
    }

    private void bWV() {
        com.baidu.tieba.ala.guardthrone.b.b bVar = new com.baidu.tieba.ala.guardthrone.b.b();
        com.baidu.tieba.ala.guardthrone.a.a aVar = new com.baidu.tieba.ala.guardthrone.a.a();
        aVar.a(this.mTbPageContext, this.mLiveId, this.brl, this.aOt, this.mTabId, this.mIsHost);
        this.gSK.add(aVar);
        bVar.tabName = this.mTbPageContext.getString(a.h.guard_throne_title);
        bVar.gSZ = "guard_throne";
        this.gSL.add(bVar);
        c cVar = null;
        com.baidu.live.noble.data.c cVar2 = new com.baidu.live.noble.data.c();
        cVar2.mTbPageContext = this.mTbPageContext;
        cVar2.mLiveId = this.mLiveId;
        cVar2.brl = this.brl;
        cVar2.aOt = this.aOt;
        cVar2.mTabId = this.mTabId;
        cVar2.mIsHost = this.mIsHost;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913204, c.class, cVar2);
        if (runTask != null && runTask.getData() != null) {
            cVar = (c) runTask.getData();
        }
        if (cVar != null) {
            this.gSK.add(cVar);
            com.baidu.tieba.ala.guardthrone.b.b bVar2 = new com.baidu.tieba.ala.guardthrone.b.b();
            bVar2.tabName = this.mTbPageContext.getString(a.h.noble_title);
            bVar2.gSZ = "noble";
            this.gSL.add(bVar2);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.gSK != null) {
            return this.gSK.size();
        }
        return 0;
    }

    public ArrayList<c> getDataList() {
        return this.gSK;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        c cVar = (c) ListUtils.getItem(this.gSK, i);
        if (cVar != null && cVar.getView() != null) {
            View view = cVar.getView();
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return cVar;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof c) && ((c) obj).getView() == view;
    }

    public void uC(int i) {
        if (i >= 0 && i < this.gSL.size()) {
            for (int i2 = 0; i2 < this.gSK.size(); i2++) {
                c cVar = this.gSK.get(i2);
                if (i2 == i) {
                    cVar.cb(true);
                } else {
                    cVar.cb(false);
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!ListUtils.isEmpty(this.gSK)) {
            Iterator<c> it = this.gSK.iterator();
            while (it.hasNext()) {
                it.next().onConfigurationChanged(configuration);
            }
        }
    }

    public void onDestroy() {
        if (!ListUtils.isEmpty(this.gSK)) {
            Iterator<c> it = this.gSK.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
    }
}
