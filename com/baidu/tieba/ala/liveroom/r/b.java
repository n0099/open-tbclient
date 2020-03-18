package com.baidu.tieba.ala.liveroom.r;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.p.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int YH;
    private String alR;
    private long eio;
    private long fkA;
    private String fkB;
    private c fkz;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.YH = i;
        this.fkA = j;
        this.fkB = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.alR = str4;
        this.eio = j2;
        this.otherParams = str3;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ag(ViewGroup viewGroup) {
        super.ag(viewGroup);
        if (this.fkz == null) {
            com.baidu.live.p.a aVar = new com.baidu.live.p.a(getPageContext().getPageActivity(), this.YH, this.fkA, this.mIsHost, this.mPortrait, this.otherParams, this.alR, this.eio);
            aVar.userName = this.fkB;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fkz = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            an(viewGroup);
        }
    }

    private void an(ViewGroup viewGroup) {
        if (this.fkz != null && this.fkz.zi() != null && viewGroup.indexOfChild(this.fkz.zi()) < 0) {
            this.fkz.zi().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            viewGroup.addView(this.fkz.zi(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pP() {
        super.pP();
        if (this.fkz != null && this.fkz.zi() != null && this.fkz.zi().getParent() != null) {
            ((ViewGroup) this.fkz.zi().getParent()).removeView(this.fkz.zi());
        }
        if (this.fkz != null) {
            this.fkz.destory();
            this.fkz = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fkz != null) {
            this.fkz.destory();
            this.fkz = null;
        }
    }

    public void bqs() {
        if (this.fkz != null) {
            this.fkz.zl();
        }
    }

    public void bqt() {
        if (this.fkz != null) {
            this.fkz.zm();
        }
    }
}
