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
    private int Yx;
    private String alH;
    private long ehY;
    private c fka;
    private long fkb;
    private String fkc;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.Yx = i;
        this.fkb = j;
        this.fkc = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.alH = str4;
        this.ehY = j2;
        this.otherParams = str3;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void af(ViewGroup viewGroup) {
        super.af(viewGroup);
        if (this.fka == null) {
            com.baidu.live.p.a aVar = new com.baidu.live.p.a(getPageContext().getPageActivity(), this.Yx, this.fkb, this.mIsHost, this.mPortrait, this.otherParams, this.alH, this.ehY);
            aVar.userName = this.fkc;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fka = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            am(viewGroup);
        }
    }

    private void am(ViewGroup viewGroup) {
        if (this.fka != null && this.fka.zb() != null && viewGroup.indexOfChild(this.fka.zb()) < 0) {
            this.fka.zb().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            viewGroup.addView(this.fka.zb(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pK() {
        super.pK();
        if (this.fka != null && this.fka.zb() != null && this.fka.zb().getParent() != null) {
            ((ViewGroup) this.fka.zb().getParent()).removeView(this.fka.zb());
        }
        if (this.fka != null) {
            this.fka.destory();
            this.fka = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fka != null) {
            this.fka.destory();
            this.fka = null;
        }
    }

    public void bqn() {
        if (this.fka != null) {
            this.fka.ze();
        }
    }

    public void bqo() {
        if (this.fka != null) {
            this.fka.zf();
        }
    }
}
