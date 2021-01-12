package com.baidu.tieba.ala.guardthrone.adapter;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.k.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class AlaThroneAndNobleControllerAdapter extends PagerAdapter {
    private String aKn;
    private String bre;
    private ArrayList<c> gZR = new ArrayList<>();
    private ArrayList<com.baidu.tieba.ala.guardthrone.b.b> gZS = new ArrayList<>();
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;

    public AlaThroneAndNobleControllerAdapter(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bre = str2;
        this.aKn = str3;
        this.mTabId = i;
        this.mIsHost = z;
        bVJ();
    }

    private void bVJ() {
        com.baidu.tieba.ala.guardthrone.b.b bVar = new com.baidu.tieba.ala.guardthrone.b.b();
        com.baidu.tieba.ala.guardthrone.a.a aVar = new com.baidu.tieba.ala.guardthrone.a.a();
        aVar.a(this.mTbPageContext, this.mLiveId, this.bre, this.aKn, this.mTabId, this.mIsHost);
        this.gZR.add(aVar);
        bVar.tabName = this.mTbPageContext.getString(a.h.guard_throne_title);
        bVar.hag = "guard_throne";
        this.gZS.add(bVar);
        c cVar = null;
        com.baidu.live.noble.data.c cVar2 = new com.baidu.live.noble.data.c();
        cVar2.mTbPageContext = this.mTbPageContext;
        cVar2.mLiveId = this.mLiveId;
        cVar2.bre = this.bre;
        cVar2.aKn = this.aKn;
        cVar2.mTabId = this.mTabId;
        cVar2.mIsHost = this.mIsHost;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913204, c.class, cVar2);
        if (runTask != null && runTask.getData() != null) {
            cVar = (c) runTask.getData();
        }
        if (cVar != null) {
            this.gZR.add(cVar);
            com.baidu.tieba.ala.guardthrone.b.b bVar2 = new com.baidu.tieba.ala.guardthrone.b.b();
            bVar2.tabName = this.mTbPageContext.getString(a.h.noble_title);
            bVar2.hag = "noble";
            this.gZS.add(bVar2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.gZR != null) {
            return this.gZR.size();
        }
        return 0;
    }

    public ArrayList<c> getDataList() {
        return this.gZR;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        c cVar = (c) ListUtils.getItem(this.gZR, i);
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

    public void ti(int i) {
        if (i >= 0 && i < this.gZS.size()) {
            for (int i2 = 0; i2 < this.gZR.size(); i2++) {
                c cVar = this.gZR.get(i2);
                if (i2 == i) {
                    cVar.bW(true);
                } else {
                    cVar.bW(false);
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!ListUtils.isEmpty(this.gZR)) {
            Iterator<c> it = this.gZR.iterator();
            while (it.hasNext()) {
                it.next().onConfigurationChanged(configuration);
            }
        }
    }

    public void onDestroy() {
        if (!ListUtils.isEmpty(this.gZR)) {
            Iterator<c> it = this.gZR.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
    }
}
