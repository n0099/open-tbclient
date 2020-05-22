package com.baidu.tieba.ala.guardthrone.adapter;

import android.content.res.Configuration;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.noble.data.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class AlaThroneAndNobleControllerAdapter extends PagerAdapter {
    private String aWr;
    private String ayw;
    private ArrayList<com.baidu.live.h.b> fBJ = new ArrayList<>();
    private ArrayList<com.baidu.tieba.ala.guardthrone.b.b> fBK = new ArrayList<>();
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;

    public AlaThroneAndNobleControllerAdapter(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.aWr = str2;
        this.ayw = str3;
        this.mTabId = i;
        this.mIsHost = z;
        bvm();
    }

    private void bvm() {
        com.baidu.tieba.ala.guardthrone.b.b bVar = new com.baidu.tieba.ala.guardthrone.b.b();
        com.baidu.tieba.ala.guardthrone.a.a aVar = new com.baidu.tieba.ala.guardthrone.a.a();
        aVar.a(this.mTbPageContext, this.mLiveId, this.aWr, this.ayw, this.mTabId, this.mIsHost);
        this.fBJ.add(aVar);
        bVar.tabName = this.mTbPageContext.getString(a.i.guard_throne_title);
        bVar.fCa = "guard_throne";
        this.fBK.add(bVar);
        com.baidu.live.h.b bVar2 = null;
        c cVar = new c();
        cVar.mTbPageContext = this.mTbPageContext;
        cVar.mLiveId = this.mLiveId;
        cVar.aWr = this.aWr;
        cVar.ayw = this.ayw;
        cVar.mTabId = this.mTabId;
        cVar.mIsHost = this.mIsHost;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913204, com.baidu.live.h.b.class, cVar);
        if (runTask != null && runTask.getData() != null) {
            bVar2 = (com.baidu.live.h.b) runTask.getData();
        }
        if (bVar2 != null) {
            this.fBJ.add(bVar2);
            com.baidu.tieba.ala.guardthrone.b.b bVar3 = new com.baidu.tieba.ala.guardthrone.b.b();
            bVar3.tabName = this.mTbPageContext.getString(a.i.noble_title);
            bVar3.fCa = "noble";
            this.fBK.add(bVar3);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fBJ != null) {
            return this.fBJ.size();
        }
        return 0;
    }

    public ArrayList<com.baidu.live.h.b> getDataList() {
        return this.fBJ;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        com.baidu.live.h.b bVar = (com.baidu.live.h.b) ListUtils.getItem(this.fBJ, i);
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

    public void pp(int i) {
        if (i >= 0 && i < this.fBK.size()) {
            for (int i2 = 0; i2 < this.fBJ.size(); i2++) {
                com.baidu.live.h.b bVar = this.fBJ.get(i2);
                if (i2 == i) {
                    bVar.bB(true);
                } else {
                    bVar.bB(false);
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!ListUtils.isEmpty(this.fBJ)) {
            Iterator<com.baidu.live.h.b> it = this.fBJ.iterator();
            while (it.hasNext()) {
                it.next().onConfigurationChanged(configuration);
            }
        }
    }

    public void onDestroy() {
        if (!ListUtils.isEmpty(this.fBJ)) {
            Iterator<com.baidu.live.h.b> it = this.fBJ.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
    }
}
