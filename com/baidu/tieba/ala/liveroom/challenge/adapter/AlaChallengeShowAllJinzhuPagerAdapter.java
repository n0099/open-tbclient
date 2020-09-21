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
    private long bhr;
    private long fxY;
    private ArrayList<d> ghK = new ArrayList<>();
    private long gta;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;

    public AlaChallengeShowAllJinzhuPagerAdapter(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gta = j;
        this.bhr = j2;
        this.fxY = j3;
        bMd();
    }

    private void bMd() {
        com.baidu.tieba.ala.liveroom.challenge.view.b bVar = new com.baidu.tieba.ala.liveroom.challenge.view.b(this.mTbPageContext, 1, this.mIsHost);
        bVar.e(this.gta, this.bhr, this.fxY);
        this.ghK.add(bVar);
        com.baidu.tieba.ala.liveroom.challenge.view.b bVar2 = new com.baidu.tieba.ala.liveroom.challenge.view.b(this.mTbPageContext, 2, this.mIsHost);
        bVar2.e(this.gta, this.bhr, this.fxY);
        this.ghK.add(bVar2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.ghK != null) {
            return this.ghK.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.ghK;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.ghK, i);
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
