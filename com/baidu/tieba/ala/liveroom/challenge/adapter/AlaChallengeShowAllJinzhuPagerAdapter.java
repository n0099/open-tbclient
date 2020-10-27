package com.baidu.tieba.ala.liveroom.challenge.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaChallengeShowAllJinzhuPagerAdapter extends PagerAdapter {
    private long bmB;
    private long fSB;
    private ArrayList<d> gEd = new ArrayList<>();
    private long gTk;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;

    public AlaChallengeShowAllJinzhuPagerAdapter(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gTk = j;
        this.bmB = j2;
        this.fSB = j3;
        bRs();
    }

    private void bRs() {
        com.baidu.tieba.ala.liveroom.challenge.view.b bVar = new com.baidu.tieba.ala.liveroom.challenge.view.b(this.mTbPageContext, 1, this.mIsHost);
        bVar.e(this.gTk, this.bmB, this.fSB);
        this.gEd.add(bVar);
        com.baidu.tieba.ala.liveroom.challenge.view.b bVar2 = new com.baidu.tieba.ala.liveroom.challenge.view.b(this.mTbPageContext, 2, this.mIsHost);
        bVar2.e(this.gTk, this.bmB, this.fSB);
        this.gEd.add(bVar2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.gEd != null) {
            return this.gEd.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.gEd;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.gEd, i);
        if (dVar != null && dVar.getPanelView() != null) {
            View panelView = dVar.getPanelView();
            if (panelView.getParent() != null) {
                ((ViewGroup) panelView.getParent()).removeView(panelView);
            }
            viewGroup.addView(panelView);
            return dVar;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
