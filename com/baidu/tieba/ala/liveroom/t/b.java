package com.baidu.tieba.ala.liveroom.t;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.q.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private String aNP;
    private int azs;
    private long fkg;
    private c gvi;
    private long gvj;
    private String gvk;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.azs = i;
        this.gvj = j;
        this.gvk = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aNP = str4;
        this.fkg = j2;
        this.otherParams = str3;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ar(ViewGroup viewGroup) {
        super.ar(viewGroup);
        if (this.gvi == null) {
            com.baidu.live.q.a aVar = new com.baidu.live.q.a(getPageContext().getPageActivity(), this.azs, this.gvj, this.mIsHost, this.mPortrait, this.otherParams, this.aNP, this.fkg);
            aVar.userName = this.gvk;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gvi = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            az(viewGroup);
        }
    }

    private void az(ViewGroup viewGroup) {
        if (this.gvi != null && this.gvi.GI() != null && viewGroup.indexOfChild(this.gvi.GI()) < 0) {
            this.gvi.GI().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            viewGroup.addView(this.gvi.GI(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void wd() {
        super.wd();
        if (this.gvi != null && this.gvi.GI() != null && this.gvi.GI().getParent() != null) {
            ((ViewGroup) this.gvi.GI().getParent()).removeView(this.gvi.GI());
        }
        if (this.gvi != null) {
            this.gvi.destory();
            this.gvi = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gvi != null) {
            this.gvi.destory();
            this.gvi = null;
        }
    }

    public void bMh() {
        if (this.gvi != null) {
            this.gvi.GL();
        }
    }

    public void bMi() {
        if (this.gvi != null) {
            this.gvi.GM();
        }
    }
}
