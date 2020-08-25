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
    private int aED;
    private String aTc;
    private long fvC;
    private c gIg;
    private long gIh;
    private String gIi;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aED = i;
        this.gIh = j;
        this.gIi = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aTc = str4;
        this.fvC = j2;
        this.otherParams = str3;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void as(ViewGroup viewGroup) {
        super.as(viewGroup);
        if (this.gIg == null) {
            com.baidu.live.q.a aVar = new com.baidu.live.q.a(getPageContext().getPageActivity(), this.aED, this.gIh, this.mIsHost, this.mPortrait, this.otherParams, this.aTc, this.fvC);
            aVar.userName = this.gIi;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gIg = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            aA(viewGroup);
        }
    }

    private void aA(ViewGroup viewGroup) {
        if (this.gIg != null && this.gIg.Mu() != null && viewGroup.indexOfChild(this.gIg.Mu()) < 0) {
            this.gIg.Mu().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            viewGroup.addView(this.gIg.Mu(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BB() {
        super.BB();
        if (this.gIg != null && this.gIg.Mu() != null && this.gIg.Mu().getParent() != null) {
            ((ViewGroup) this.gIg.Mu().getParent()).removeView(this.gIg.Mu());
        }
        if (this.gIg != null) {
            this.gIg.destory();
            this.gIg = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gIg != null) {
            this.gIg.destory();
            this.gIg = null;
        }
    }

    public void bWj() {
        if (this.gIg != null) {
            this.gIg.Mx();
        }
    }

    public void bWk() {
        if (this.gIg != null) {
            this.gIg.My();
        }
    }
}
