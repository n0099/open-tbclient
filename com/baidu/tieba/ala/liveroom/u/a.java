package com.baidu.tieba.ala.liveroom.u;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.m.c;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private int WL;
    private String ajy;
    private long edH;
    private c fgG;
    private long fgH;
    private String fgI;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.WL = i;
        this.fgH = j;
        this.fgI = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.ajy = str4;
        this.edH = j2;
        this.otherParams = str3;
    }

    public void setVisible(int i) {
        if (this.fgG != null && this.fgG.wI() != null) {
            this.fgG.wI().setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ad(ViewGroup viewGroup) {
        super.ad(viewGroup);
        if (this.fgG == null) {
            com.baidu.live.m.a aVar = new com.baidu.live.m.a(getPageContext().getPageActivity(), this.WL, this.fgH, this.mIsHost, this.mPortrait, this.otherParams, this.ajy, this.edH);
            aVar.userName = this.fgI;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fgG = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            al(viewGroup);
        }
    }

    private void al(ViewGroup viewGroup) {
        if (this.fgG != null && this.fgG.wI() != null && viewGroup.indexOfChild(this.fgG.wI()) < 0) {
            this.fgG.wI().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            viewGroup.addView(this.fgG.wI(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void oZ() {
        super.oZ();
        if (this.fgG != null && this.fgG.wI() != null && this.fgG.wI().getParent() != null) {
            ((ViewGroup) this.fgG.wI().getParent()).removeView(this.fgG.wI());
        }
        if (this.fgG != null) {
            this.fgG.destory();
            this.fgG = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fgG != null) {
            this.fgG.destory();
            this.fgG = null;
        }
    }
}
