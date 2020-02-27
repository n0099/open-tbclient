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
    private int Yx;
    private String alG;
    private long ehK;
    private c fjM;
    private long fjN;
    private String fjO;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.Yx = i;
        this.fjN = j;
        this.fjO = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.alG = str4;
        this.ehK = j2;
        this.otherParams = str3;
    }

    public void setVisible(int i) {
        if (this.fjM != null && this.fjM.yZ() != null) {
            this.fjM.yZ().setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void af(ViewGroup viewGroup) {
        super.af(viewGroup);
        if (this.fjM == null) {
            com.baidu.live.p.a aVar = new com.baidu.live.p.a(getPageContext().getPageActivity(), this.Yx, this.fjN, this.mIsHost, this.mPortrait, this.otherParams, this.alG, this.ehK);
            aVar.userName = this.fjO;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fjM = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            am(viewGroup);
        }
    }

    private void am(ViewGroup viewGroup) {
        if (this.fjM != null && this.fjM.yZ() != null && viewGroup.indexOfChild(this.fjM.yZ()) < 0) {
            this.fjM.yZ().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            viewGroup.addView(this.fjM.yZ(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pK() {
        super.pK();
        if (this.fjM != null && this.fjM.yZ() != null && this.fjM.yZ().getParent() != null) {
            ((ViewGroup) this.fjM.yZ().getParent()).removeView(this.fjM.yZ());
        }
        if (this.fjM != null) {
            this.fjM.destory();
            this.fjM = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fjM != null) {
            this.fjM.destory();
            this.fjM = null;
        }
    }
}
