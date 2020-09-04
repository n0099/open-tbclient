package com.baidu.tieba.ala.liveroom.u;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.q.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int aEF;
    private String aTe;
    private long fvG;
    private c gIk;
    private long gIl;
    private String gIm;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aEF = i;
        this.gIl = j;
        this.gIm = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aTe = str4;
        this.fvG = j2;
        this.otherParams = str3;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void as(ViewGroup viewGroup) {
        super.as(viewGroup);
        if (this.gIk == null) {
            com.baidu.live.q.a aVar = new com.baidu.live.q.a(getPageContext().getPageActivity(), this.aEF, this.gIl, this.mIsHost, this.mPortrait, this.otherParams, this.aTe, this.fvG);
            aVar.userName = this.gIm;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gIk = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            aA(viewGroup);
        }
    }

    private void aA(ViewGroup viewGroup) {
        if (this.gIk != null && this.gIk.Mu() != null && viewGroup.indexOfChild(this.gIk.Mu()) < 0) {
            this.gIk.Mu().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            viewGroup.addView(this.gIk.Mu(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BB() {
        super.BB();
        if (this.gIk != null && this.gIk.Mu() != null && this.gIk.Mu().getParent() != null) {
            ((ViewGroup) this.gIk.Mu().getParent()).removeView(this.gIk.Mu());
        }
        if (this.gIk != null) {
            this.gIk.destory();
            this.gIk = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gIk != null) {
            this.gIk.destory();
            this.gIk = null;
        }
    }

    public void bWk() {
        if (this.gIk != null) {
            this.gIk.Mx();
        }
    }

    public void bWl() {
        if (this.gIk != null) {
            this.gIk.My();
        }
    }
}
