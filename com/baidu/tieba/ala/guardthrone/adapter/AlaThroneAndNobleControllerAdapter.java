package com.baidu.tieba.ala.guardthrone.adapter;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.j.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class AlaThroneAndNobleControllerAdapter extends PagerAdapter {
    private String aOA;
    private String bwh;
    private ArrayList<c> hey = new ArrayList<>();
    private ArrayList<com.baidu.tieba.ala.guardthrone.b.b> hez = new ArrayList<>();
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;

    public AlaThroneAndNobleControllerAdapter(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bwh = str2;
        this.aOA = str3;
        this.mTabId = i;
        this.mIsHost = z;
        bWA();
    }

    private void bWA() {
        com.baidu.tieba.ala.guardthrone.b.b bVar = new com.baidu.tieba.ala.guardthrone.b.b();
        com.baidu.tieba.ala.guardthrone.a.a aVar = new com.baidu.tieba.ala.guardthrone.a.a();
        aVar.a(this.mTbPageContext, this.mLiveId, this.bwh, this.aOA, this.mTabId, this.mIsHost);
        this.hey.add(aVar);
        bVar.tabName = this.mTbPageContext.getString(a.h.guard_throne_title);
        bVar.heN = "guard_throne";
        this.hez.add(bVar);
        c cVar = null;
        com.baidu.live.noble.data.c cVar2 = new com.baidu.live.noble.data.c();
        cVar2.mTbPageContext = this.mTbPageContext;
        cVar2.mLiveId = this.mLiveId;
        cVar2.bwh = this.bwh;
        cVar2.aOA = this.aOA;
        cVar2.mTabId = this.mTabId;
        cVar2.mIsHost = this.mIsHost;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913204, c.class, cVar2);
        if (runTask != null && runTask.getData() != null) {
            cVar = (c) runTask.getData();
        }
        if (cVar != null) {
            this.hey.add(cVar);
            com.baidu.tieba.ala.guardthrone.b.b bVar2 = new com.baidu.tieba.ala.guardthrone.b.b();
            bVar2.tabName = this.mTbPageContext.getString(a.h.noble_title);
            bVar2.heN = "noble";
            this.hez.add(bVar2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.hey != null) {
            return this.hey.size();
        }
        return 0;
    }

    public ArrayList<c> getDataList() {
        return this.hey;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        c cVar = (c) ListUtils.getItem(this.hey, i);
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

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof c) && ((c) obj).getView() == view;
    }

    public void tq(int i) {
        if (i >= 0 && i < this.hez.size()) {
            for (int i2 = 0; i2 < this.hey.size(); i2++) {
                c cVar = this.hey.get(i2);
                if (i2 == i) {
                    cVar.cb(true);
                } else {
                    cVar.cb(false);
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!ListUtils.isEmpty(this.hey)) {
            Iterator<c> it = this.hey.iterator();
            while (it.hasNext()) {
                it.next().onConfigurationChanged(configuration);
            }
        }
    }

    public void onDestroy() {
        if (!ListUtils.isEmpty(this.hey)) {
            Iterator<c> it = this.hey.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
    }
}
