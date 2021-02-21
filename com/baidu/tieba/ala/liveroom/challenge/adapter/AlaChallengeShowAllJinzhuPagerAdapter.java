package com.baidu.tieba.ala.liveroom.challenge.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaChallengeShowAllJinzhuPagerAdapter extends PagerAdapter {
    private long buN;
    private long goZ;
    private ArrayList<d> hcP = new ArrayList<>();
    private long huu;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;

    public AlaChallengeShowAllJinzhuPagerAdapter(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsHost = z;
        this.huu = j;
        this.buN = j2;
        this.goZ = j3;
        bWu();
    }

    private void bWu() {
        com.baidu.tieba.ala.liveroom.challenge.view.b bVar = new com.baidu.tieba.ala.liveroom.challenge.view.b(this.mTbPageContext, 1, this.mIsHost);
        bVar.e(this.huu, this.buN, this.goZ);
        this.hcP.add(bVar);
        com.baidu.tieba.ala.liveroom.challenge.view.b bVar2 = new com.baidu.tieba.ala.liveroom.challenge.view.b(this.mTbPageContext, 2, this.mIsHost);
        bVar2.e(this.huu, this.buN, this.goZ);
        this.hcP.add(bVar2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.hcP != null) {
            return this.hcP.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.hcP;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.hcP, i);
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
