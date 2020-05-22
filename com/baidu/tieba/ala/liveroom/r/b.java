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
    private String aJO;
    private int avX;
    private long eUH;
    private c gdc;
    private long gdd;
    private String gde;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.avX = i;
        this.gdd = j;
        this.gde = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aJO = str4;
        this.eUH = j2;
        this.otherParams = str3;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ao(ViewGroup viewGroup) {
        super.ao(viewGroup);
        if (this.gdc == null) {
            com.baidu.live.p.a aVar = new com.baidu.live.p.a(getPageContext().getPageActivity(), this.avX, this.gdd, this.mIsHost, this.mPortrait, this.otherParams, this.aJO, this.eUH);
            aVar.userName = this.gde;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gdc = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            av(viewGroup);
        }
    }

    private void av(ViewGroup viewGroup) {
        if (this.gdc != null && this.gdc.FS() != null && viewGroup.indexOfChild(this.gdc.FS()) < 0) {
            this.gdc.FS().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            viewGroup.addView(this.gdc.FS(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vm() {
        super.vm();
        if (this.gdc != null && this.gdc.FS() != null && this.gdc.FS().getParent() != null) {
            ((ViewGroup) this.gdc.FS().getParent()).removeView(this.gdc.FS());
        }
        if (this.gdc != null) {
            this.gdc.destory();
            this.gdc = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gdc != null) {
            this.gdc.destory();
            this.gdc = null;
        }
    }

    public void bFU() {
        if (this.gdc != null) {
            this.gdc.FV();
        }
    }

    public void bFV() {
        if (this.gdc != null) {
            this.gdc.FW();
        }
    }
}
