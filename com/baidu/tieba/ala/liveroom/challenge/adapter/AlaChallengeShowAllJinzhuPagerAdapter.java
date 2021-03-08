package com.baidu.tieba.ala.liveroom.challenge.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class AlaChallengeShowAllJinzhuPagerAdapter extends PagerAdapter {
    private long bwn;
    private long gqI;
    private ArrayList<d> hey = new ArrayList<>();
    private long hwd;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;

    public AlaChallengeShowAllJinzhuPagerAdapter(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.hwd = j;
        this.bwn = j2;
        this.gqI = j3;
        bWA();
    }

    private void bWA() {
        com.baidu.tieba.ala.liveroom.challenge.view.b bVar = new com.baidu.tieba.ala.liveroom.challenge.view.b(this.mTbPageContext, 1, this.mIsHost);
        bVar.f(this.hwd, this.bwn, this.gqI);
        this.hey.add(bVar);
        com.baidu.tieba.ala.liveroom.challenge.view.b bVar2 = new com.baidu.tieba.ala.liveroom.challenge.view.b(this.mTbPageContext, 2, this.mIsHost);
        bVar2.f(this.hwd, this.bwn, this.gqI);
        this.hey.add(bVar2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.hey != null) {
            return this.hey.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.hey;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.hey, i);
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

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
