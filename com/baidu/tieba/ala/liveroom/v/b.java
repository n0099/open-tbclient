package com.baidu.tieba.ala.liveroom.v;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.s.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int aFQ;
    private String aVs;
    private long fyR;
    private c gLL;
    private long gLM;
    private String gLN;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aFQ = i;
        this.gLM = j;
        this.gLN = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aVs = str4;
        this.fyR = j2;
        this.otherParams = str3;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        if (this.gLL == null) {
            com.baidu.live.s.a aVar = new com.baidu.live.s.a(getPageContext().getPageActivity(), this.aFQ, this.gLM, this.mIsHost, this.mPortrait, this.otherParams, this.aVs, this.fyR);
            aVar.userName = this.gLN;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gLL = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            aB(viewGroup);
        }
    }

    private void aB(ViewGroup viewGroup) {
        if (this.gLL != null && this.gLL.Nc() != null && viewGroup.indexOfChild(this.gLL.Nc()) < 0) {
            this.gLL.Nc().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.g.ala_rank_level_entry);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            viewGroup.addView(this.gLL.Nc(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BQ() {
        super.BQ();
        if (this.gLL != null && this.gLL.Nc() != null && this.gLL.Nc().getParent() != null) {
            ((ViewGroup) this.gLL.Nc().getParent()).removeView(this.gLL.Nc());
        }
        if (this.gLL != null) {
            this.gLL.destory();
            this.gLL = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gLL != null) {
            this.gLL.destory();
            this.gLL = null;
        }
    }

    public void bXU() {
        if (this.gLL != null) {
            this.gLL.Nf();
        }
    }

    public void bXV() {
        if (this.gLL != null) {
            this.gLL.Ng();
        }
    }
}
