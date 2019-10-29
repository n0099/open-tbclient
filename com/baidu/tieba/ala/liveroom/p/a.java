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
    private int Qc;
    private String abe;
    private long duD;
    private c enU;
    private long enV;
    private String enW;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.Qc = i;
        this.enV = j;
        this.enW = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.abe = str4;
        this.duD = j2;
        this.otherParams = str3;
    }

    public void setVisible(int i) {
        if (this.enU != null && this.enU.uv() != null) {
            this.enU.uv().setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Z(ViewGroup viewGroup) {
        super.Z(viewGroup);
        if (this.enU == null) {
            com.baidu.live.h.a aVar = new com.baidu.live.h.a(getPageContext().getPageActivity(), this.Qc, this.enV, this.mIsHost, this.mPortrait, this.otherParams, this.abe, this.duD);
            aVar.userName = this.enW;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.enU = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            ai(viewGroup);
        }
    }

    private void ai(ViewGroup viewGroup) {
        if (this.enU != null && this.enU.uv() != null && viewGroup.indexOfChild(this.enU.uv()) < 0) {
            this.enU.uv().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            viewGroup.addView(this.enU.uv(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void nA() {
        super.nA();
        if (this.enU != null && this.enU.uv() != null && this.enU.uv().getParent() != null) {
            ((ViewGroup) this.enU.uv().getParent()).removeView(this.enU.uv());
        }
        if (this.enU != null) {
            this.enU.destory();
            this.enU = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.enU != null) {
            this.enU.destory();
            this.enU = null;
        }
    }
}
