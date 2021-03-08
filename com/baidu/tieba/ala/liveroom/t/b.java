package com.baidu.tieba.ala.liveroom.t;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.x.c;
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int aLA;
    private String beL;
    private long gry;
    private long hPA;
    private String hPB;
    private c hPz;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aLA = i;
        this.hPA = j;
        this.hPB = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.beL = str4;
        this.gry = j2;
        this.otherParams = str3;
    }

    public void setCanVisible(boolean z) {
        if (this.hPz != null) {
            this.hPz.setCanVisible(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        aO(viewGroup);
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            setCanVisible(true);
        }
    }

    private void aO(ViewGroup viewGroup) {
        if (this.hPz == null) {
            com.baidu.live.x.a aVar = new com.baidu.live.x.a(getPageContext().getPageActivity(), this.aLA, this.hPA, this.mIsHost, this.mPortrait, this.otherParams, this.beL, this.gry);
            aVar.userName = this.hPB;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hPz = (c) runTask.getData();
            }
        }
        aN(viewGroup);
    }

    private void aN(ViewGroup viewGroup) {
        if (this.hPz != null && viewGroup != null && this.hPz.PA() != null && viewGroup.indexOfChild(this.hPz.PA()) < 0) {
            this.hPz.PA().setId(a.f.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.f.ala_rank_level_entry);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            viewGroup.addView(this.hPz.PA(), layoutParams);
            this.hPz.setCanVisible(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Au() {
        super.Au();
        if (this.hPz != null && this.hPz.PA() != null && this.hPz.PA().getParent() != null) {
            ((ViewGroup) this.hPz.PA().getParent()).removeView(this.hPz.PA());
        }
        if (this.hPz != null) {
            this.hPz.destory();
            this.hPz = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hPz != null) {
            this.hPz.destory();
            this.hPz = null;
        }
    }

    public void cky() {
        if (this.hPz != null) {
            this.hPz.PD();
        }
    }

    public void ckz() {
        if (this.hPz != null) {
            this.hPz.PE();
        }
    }
}
