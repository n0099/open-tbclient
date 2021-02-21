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
/* loaded from: classes11.dex */
public class AlaThroneAndNobleControllerAdapter extends PagerAdapter {
    private String aNa;
    private String buH;
    private ArrayList<c> hcP = new ArrayList<>();
    private ArrayList<com.baidu.tieba.ala.guardthrone.b.b> hcQ = new ArrayList<>();
    private boolean mIsHost;
    private String mLiveId;
    private int mTabId;
    private TbPageContext mTbPageContext;

    public AlaThroneAndNobleControllerAdapter(TbPageContext tbPageContext, String str, String str2, String str3, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.buH = str2;
        this.aNa = str3;
        this.mTabId = i;
        this.mIsHost = z;
        bWu();
    }

    private void bWu() {
        com.baidu.tieba.ala.guardthrone.b.b bVar = new com.baidu.tieba.ala.guardthrone.b.b();
        com.baidu.tieba.ala.guardthrone.a.a aVar = new com.baidu.tieba.ala.guardthrone.a.a();
        aVar.a(this.mTbPageContext, this.mLiveId, this.buH, this.aNa, this.mTabId, this.mIsHost);
        this.hcP.add(aVar);
        bVar.tabName = this.mTbPageContext.getString(a.h.guard_throne_title);
        bVar.hde = "guard_throne";
        this.hcQ.add(bVar);
        c cVar = null;
        com.baidu.live.noble.data.c cVar2 = new com.baidu.live.noble.data.c();
        cVar2.mTbPageContext = this.mTbPageContext;
        cVar2.mLiveId = this.mLiveId;
        cVar2.buH = this.buH;
        cVar2.aNa = this.aNa;
        cVar2.mTabId = this.mTabId;
        cVar2.mIsHost = this.mIsHost;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913204, c.class, cVar2);
        if (runTask != null && runTask.getData() != null) {
            cVar = (c) runTask.getData();
        }
        if (cVar != null) {
            this.hcP.add(cVar);
            com.baidu.tieba.ala.guardthrone.b.b bVar2 = new com.baidu.tieba.ala.guardthrone.b.b();
            bVar2.tabName = this.mTbPageContext.getString(a.h.noble_title);
            bVar2.hde = "noble";
            this.hcQ.add(bVar2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.hcP != null) {
            return this.hcP.size();
        }
        return 0;
    }

    public ArrayList<c> getDataList() {
        return this.hcP;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        c cVar = (c) ListUtils.getItem(this.hcP, i);
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

    public void to(int i) {
        if (i >= 0 && i < this.hcQ.size()) {
            for (int i2 = 0; i2 < this.hcP.size(); i2++) {
                c cVar = this.hcP.get(i2);
                if (i2 == i) {
                    cVar.cb(true);
                } else {
                    cVar.cb(false);
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!ListUtils.isEmpty(this.hcP)) {
            Iterator<c> it = this.hcP.iterator();
            while (it.hasNext()) {
                it.next().onConfigurationChanged(configuration);
            }
        }
    }

    public void onDestroy() {
        if (!ListUtils.isEmpty(this.hcP)) {
            Iterator<c> it = this.hcP.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
    }
}
