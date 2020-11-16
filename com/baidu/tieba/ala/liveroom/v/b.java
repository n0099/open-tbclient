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
    private int aIL;
    private String aZH;
    private long fYO;
    private c hsd;
    private long hse;
    private String hsf;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aIL = i;
        this.hse = j;
        this.hsf = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aZH = str4;
        this.fYO = j2;
        this.otherParams = str3;
    }

    public void setCanVisible(boolean z) {
        if (this.hsd != null) {
            this.hsd.setCanVisible(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        aC(viewGroup);
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            setCanVisible(true);
        }
    }

    private void aC(ViewGroup viewGroup) {
        if (this.hsd == null) {
            com.baidu.live.u.a aVar = new com.baidu.live.u.a(getPageContext().getPageActivity(), this.aIL, this.hse, this.mIsHost, this.mPortrait, this.otherParams, this.aZH, this.fYO);
            aVar.userName = this.hsf;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hsd = (c) runTask.getData();
            }
        }
        aB(viewGroup);
    }

    private void aB(ViewGroup viewGroup) {
        if (this.hsd != null && viewGroup != null && this.hsd.Ow() != null && viewGroup.indexOfChild(this.hsd.Ow()) < 0) {
            this.hsd.Ow().setId(a.f.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.f.ala_rank_level_entry);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            viewGroup.addView(this.hsd.Ow(), layoutParams);
            this.hsd.setCanVisible(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CD() {
        super.CD();
        if (this.hsd != null && this.hsd.Ow() != null && this.hsd.Ow().getParent() != null) {
            ((ViewGroup) this.hsd.Ow().getParent()).removeView(this.hsd.Ow());
        }
        if (this.hsd != null) {
            this.hsd.destory();
            this.hsd = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hsd != null) {
            this.hsd.destory();
            this.hsd = null;
        }
    }

    public void cgu() {
        if (this.hsd != null) {
            this.hsd.Oz();
        }
    }

    public void cgv() {
        if (this.hsd != null) {
            this.hsd.OA();
        }
    }
}
