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
public class a extends com.baidu.tieba.ala.liveroom.a {
    private String aJO;
    private int avX;
    private long eUH;
    private c gdc;
    private long gdd;
    private String gde;
    private boolean isShowing;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.isShowing = false;
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

    public void setVisible(int i) {
        if (this.gdc != null && this.gdc.FS() != null) {
            this.gdc.FS().setVisibility(i);
        }
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
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            viewGroup.addView(this.gdc.FS(), layoutParams);
            this.isShowing = true;
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

    public boolean isShowing() {
        return this.isShowing;
    }
}
