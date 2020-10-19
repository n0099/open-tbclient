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
    private int aIU;
    private String aYD;
    private long fLa;
    private c haI;
    private long haJ;
    private String haK;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aIU = i;
        this.haJ = j;
        this.haK = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aYD = str4;
        this.fLa = j2;
        this.otherParams = str3;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void av(ViewGroup viewGroup) {
        super.av(viewGroup);
        if (this.haI == null) {
            com.baidu.live.s.a aVar = new com.baidu.live.s.a(getPageContext().getPageActivity(), this.aIU, this.haJ, this.mIsHost, this.mPortrait, this.otherParams, this.aYD, this.fLa);
            aVar.userName = this.haK;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.haI = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            aD(viewGroup);
        }
    }

    private void aD(ViewGroup viewGroup) {
        if (this.haI != null && this.haI.Oh() != null && viewGroup.indexOfChild(this.haI.Oh()) < 0) {
            this.haI.Oh().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.g.ala_rank_level_entry);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            viewGroup.addView(this.haI.Oh(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CN() {
        super.CN();
        if (this.haI != null && this.haI.Oh() != null && this.haI.Oh().getParent() != null) {
            ((ViewGroup) this.haI.Oh().getParent()).removeView(this.haI.Oh());
        }
        if (this.haI != null) {
            this.haI.destory();
            this.haI = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.haI != null) {
            this.haI.destory();
            this.haI = null;
        }
    }

    public void cbu() {
        if (this.haI != null) {
            this.haI.Ok();
        }
    }

    public void cbv() {
        if (this.haI != null) {
            this.haI.Ol();
        }
    }
}
