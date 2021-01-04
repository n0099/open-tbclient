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
/* loaded from: classes11.dex */
public class AlaThroneAndNobleControllerAdapter extends PagerAdapter {
    private String aPa;
    private String bvS;
    private ArrayList<c> hex = new ArrayList<>();
    private ArrayList<com.baidu.tieba.ala.guardthrone.b.b> hey = new ArrayList<>();
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;

    public AlaThroneAndNobleControllerAdapter(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bvS = str2;
        this.aPa = str3;
        this.mTabId = i;
        this.mIsHost = z;
        bZA();
    }

    private void bZA() {
        com.baidu.tieba.ala.guardthrone.b.b bVar = new com.baidu.tieba.ala.guardthrone.b.b();
        com.baidu.tieba.ala.guardthrone.a.a aVar = new com.baidu.tieba.ala.guardthrone.a.a();
        aVar.a(this.mTbPageContext, this.mLiveId, this.bvS, this.aPa, this.mTabId, this.mIsHost);
        this.hex.add(aVar);
        bVar.tabName = this.mTbPageContext.getString(a.h.guard_throne_title);
        bVar.heM = "guard_throne";
        this.hey.add(bVar);
        c cVar = null;
        com.baidu.live.noble.data.c cVar2 = new com.baidu.live.noble.data.c();
        cVar2.mTbPageContext = this.mTbPageContext;
        cVar2.mLiveId = this.mLiveId;
        cVar2.bvS = this.bvS;
        cVar2.aPa = this.aPa;
        cVar2.mTabId = this.mTabId;
        cVar2.mIsHost = this.mIsHost;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913204, c.class, cVar2);
        if (runTask != null && runTask.getData() != null) {
            cVar = (c) runTask.getData();
        }
        if (cVar != null) {
            this.hex.add(cVar);
            com.baidu.tieba.ala.guardthrone.b.b bVar2 = new com.baidu.tieba.ala.guardthrone.b.b();
            bVar2.tabName = this.mTbPageContext.getString(a.h.noble_title);
            bVar2.heM = "noble";
            this.hey.add(bVar2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.hex != null) {
            return this.hex.size();
        }
        return 0;
    }

    public ArrayList<c> getDataList() {
        return this.hex;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        c cVar = (c) ListUtils.getItem(this.hex, i);
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

    public void uO(int i) {
        if (i >= 0 && i < this.hey.size()) {
            for (int i2 = 0; i2 < this.hex.size(); i2++) {
                c cVar = this.hex.get(i2);
                if (i2 == i) {
                    cVar.ca(true);
                } else {
                    cVar.ca(false);
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!ListUtils.isEmpty(this.hex)) {
            Iterator<c> it = this.hex.iterator();
            while (it.hasNext()) {
                it.next().onConfigurationChanged(configuration);
            }
        }
    }

    public void onDestroy() {
        if (!ListUtils.isEmpty(this.hex)) {
            Iterator<c> it = this.hex.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
    }
}
