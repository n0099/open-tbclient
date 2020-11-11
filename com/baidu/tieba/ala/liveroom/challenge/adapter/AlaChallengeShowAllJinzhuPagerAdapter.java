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
    private long bnV;
    private long fYr;
    private ArrayList<d> gJQ = new ArrayList<>();
    private long gZp;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;

    public AlaChallengeShowAllJinzhuPagerAdapter(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.gZp = j;
        this.bnV = j2;
        this.fYr = j3;
        bTR();
    }

    private void bTR() {
        com.baidu.tieba.ala.liveroom.challenge.view.b bVar = new com.baidu.tieba.ala.liveroom.challenge.view.b(this.mTbPageContext, 1, this.mIsHost);
        bVar.e(this.gZp, this.bnV, this.fYr);
        this.gJQ.add(bVar);
        com.baidu.tieba.ala.liveroom.challenge.view.b bVar2 = new com.baidu.tieba.ala.liveroom.challenge.view.b(this.mTbPageContext, 2, this.mIsHost);
        bVar2.e(this.gZp, this.bnV, this.fYr);
        this.gJQ.add(bVar2);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.gJQ != null) {
            return this.gJQ.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.gJQ;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.gJQ, i);
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
