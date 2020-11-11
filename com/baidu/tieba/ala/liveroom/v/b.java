package com.baidu.tieba.ala.liveroom.v;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.c;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int aKw;
    private String bbt;
    private long fZh;
    private c hsw;
    private long hsx;
    private String hsy;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aKw = i;
        this.hsx = j;
        this.hsy = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bbt = str4;
        this.fZh = j2;
        this.otherParams = str3;
    }

    public void setCanVisible(boolean z) {
        if (this.hsw != null) {
            this.hsw.setCanVisible(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ax(ViewGroup viewGroup) {
        aG(viewGroup);
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            setCanVisible(true);
        }
    }

    private void aG(ViewGroup viewGroup) {
        if (this.hsw == null) {
            com.baidu.live.u.a aVar = new com.baidu.live.u.a(getPageContext().getPageActivity(), this.aKw, this.hsx, this.mIsHost, this.mPortrait, this.otherParams, this.bbt, this.fZh);
            aVar.userName = this.hsy;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hsw = (c) runTask.getData();
            }
        }
        aF(viewGroup);
    }

    private void aF(ViewGroup viewGroup) {
        if (this.hsw != null && viewGroup != null && this.hsw.Pf() != null && viewGroup.indexOfChild(this.hsw.Pf()) < 0) {
            this.hsw.Pf().setId(a.f.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.f.ala_rank_level_entry);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            viewGroup.addView(this.hsw.Pf(), layoutParams);
            this.hsw.setCanVisible(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Dm() {
        super.Dm();
        if (this.hsw != null && this.hsw.Pf() != null && this.hsw.Pf().getParent() != null) {
            ((ViewGroup) this.hsw.Pf().getParent()).removeView(this.hsw.Pf());
        }
        if (this.hsw != null) {
            this.hsw.destory();
            this.hsw = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hsw != null) {
            this.hsw.destory();
            this.hsw = null;
        }
    }

    public void chb() {
        if (this.hsw != null) {
            this.hsw.Pi();
        }
    }

    public void chc() {
        if (this.hsw != null) {
            this.hsw.Pj();
        }
    }
}
