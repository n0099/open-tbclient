package com.baidu.tieba.ala.liveroom.u;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.y.c;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int aLE;
    private String bdh;
    private long ggZ;
    private c hBH;
    private long hBI;
    private String hBJ;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aLE = i;
        this.hBI = j;
        this.hBJ = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bdh = str4;
        this.ggZ = j2;
        this.otherParams = str3;
    }

    public void setCanVisible(boolean z) {
        if (this.hBH != null) {
            this.hBH.setCanVisible(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        aC(viewGroup);
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            setCanVisible(true);
        }
    }

    private void aC(ViewGroup viewGroup) {
        if (this.hBH == null) {
            com.baidu.live.y.a aVar = new com.baidu.live.y.a(getPageContext().getPageActivity(), this.aLE, this.hBI, this.mIsHost, this.mPortrait, this.otherParams, this.bdh, this.ggZ);
            aVar.userName = this.hBJ;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hBH = (c) runTask.getData();
            }
        }
        aB(viewGroup);
    }

    private void aB(ViewGroup viewGroup) {
        if (this.hBH != null && viewGroup != null && this.hBH.QQ() != null && viewGroup.indexOfChild(this.hBH.QQ()) < 0) {
            this.hBH.QQ().setId(a.f.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.f.ala_rank_level_entry);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            viewGroup.addView(this.hBH.QQ(), layoutParams);
            this.hBH.setCanVisible(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void En() {
        super.En();
        if (this.hBH != null && this.hBH.QQ() != null && this.hBH.QQ().getParent() != null) {
            ((ViewGroup) this.hBH.QQ().getParent()).removeView(this.hBH.QQ());
        }
        if (this.hBH != null) {
            this.hBH.destory();
            this.hBH = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hBH != null) {
            this.hBH.destory();
            this.hBH = null;
        }
    }

    public void cko() {
        if (this.hBH != null) {
            this.hBH.QT();
        }
    }

    public void ckp() {
        if (this.hBH != null) {
            this.hBH.QU();
        }
    }
}
