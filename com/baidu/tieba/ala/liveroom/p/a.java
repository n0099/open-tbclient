package com.baidu.tieba.ala.liveroom.p;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.h.c;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private int Pw;
    private String aaL;
    private long dtM;
    private c enb;
    private long enc;
    private String ene;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.Pw = i;
        this.enc = j;
        this.ene = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aaL = str4;
        this.dtM = j2;
        this.otherParams = str3;
    }

    public void setVisible(int i) {
        if (this.enb != null && this.enb.uw() != null) {
            this.enb.uw().setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Z(ViewGroup viewGroup) {
        super.Z(viewGroup);
        if (this.enb == null) {
            com.baidu.live.h.a aVar = new com.baidu.live.h.a(getPageContext().getPageActivity(), this.Pw, this.enc, this.mIsHost, this.mPortrait, this.otherParams, this.aaL, this.dtM);
            aVar.userName = this.ene;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.enb = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            ai(viewGroup);
        }
    }

    private void ai(ViewGroup viewGroup) {
        if (this.enb != null && this.enb.uw() != null && viewGroup.indexOfChild(this.enb.uw()) < 0) {
            this.enb.uw().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            viewGroup.addView(this.enb.uw(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void nA() {
        super.nA();
        if (this.enb != null && this.enb.uw() != null && this.enb.uw().getParent() != null) {
            ((ViewGroup) this.enb.uw().getParent()).removeView(this.enb.uw());
        }
        if (this.enb != null) {
            this.enb.destory();
            this.enb = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.enb != null) {
            this.enb.destory();
            this.enb = null;
        }
    }
}
