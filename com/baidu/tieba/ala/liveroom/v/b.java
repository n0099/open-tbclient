package com.baidu.tieba.ala.liveroom.v;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.t.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int aJw;
    private String baa;
    private long fTr;
    private String hmA;
    private c hmy;
    private long hmz;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aJw = i;
        this.hmz = j;
        this.hmA = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.baa = str4;
        this.fTr = j2;
        this.otherParams = str3;
    }

    public void setCanVisible(boolean z) {
        if (this.hmy != null) {
            this.hmy.setCanVisible(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void av(ViewGroup viewGroup) {
        aE(viewGroup);
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            setCanVisible(true);
        }
    }

    private void aE(ViewGroup viewGroup) {
        if (this.hmy == null) {
            com.baidu.live.t.a aVar = new com.baidu.live.t.a(getPageContext().getPageActivity(), this.aJw, this.hmz, this.mIsHost, this.mPortrait, this.otherParams, this.baa, this.fTr);
            aVar.userName = this.hmA;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hmy = (c) runTask.getData();
            }
        }
        aD(viewGroup);
    }

    private void aD(ViewGroup viewGroup) {
        if (this.hmy != null && viewGroup != null && this.hmy.OF() != null && viewGroup.indexOfChild(this.hmy.OF()) < 0) {
            this.hmy.OF().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.g.ala_rank_level_entry);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            viewGroup.addView(this.hmy.OF(), layoutParams);
            this.hmy.setCanVisible(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CT() {
        super.CT();
        if (this.hmy != null && this.hmy.OF() != null && this.hmy.OF().getParent() != null) {
            ((ViewGroup) this.hmy.OF().getParent()).removeView(this.hmy.OF());
        }
        if (this.hmy != null) {
            this.hmy.destory();
            this.hmy = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hmy != null) {
            this.hmy.destory();
            this.hmy = null;
        }
    }

    public void cey() {
        if (this.hmy != null) {
            this.hmy.OI();
        }
    }

    public void cez() {
        if (this.hmy != null) {
            this.hmy.OJ();
        }
    }
}
