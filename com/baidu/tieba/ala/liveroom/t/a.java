package com.baidu.tieba.ala.liveroom.t;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.x.c;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private int aKa;
    private String bdj;
    private long gpP;
    private c hNQ;
    private long hNR;
    private String hNS;
    private boolean isShowing;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.isShowing = false;
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aKa = i;
        this.hNR = j;
        this.hNS = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bdj = str4;
        this.gpP = j2;
        this.otherParams = str3;
    }

    public void setVisible(int i) {
        if (this.hNQ != null && this.hNQ.Px() != null) {
            this.hNQ.Px().setVisibility(i);
        }
    }

    public void setCanVisible(boolean z) {
        this.isShowing = z;
        if (this.hNQ != null) {
            this.hNQ.setCanVisible(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (this.hNQ == null) {
            com.baidu.live.x.a aVar = new com.baidu.live.x.a(getPageContext().getPageActivity(), this.aKa, this.hNR, this.mIsHost, this.mPortrait, this.otherParams, this.bdj, this.gpP);
            aVar.userName = this.hNS;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hNQ = (c) runTask.getData();
            }
        }
        aN(viewGroup);
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            setCanVisible(true);
        }
    }

    private void aN(ViewGroup viewGroup) {
        if (this.hNQ != null && viewGroup != null && this.hNQ.Px() != null && viewGroup.indexOfChild(this.hNQ.Px()) < 0) {
            this.hNQ.Px().setId(a.f.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.f.ala_rank_level_entry);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
            viewGroup.addView(this.hNQ.Px(), layoutParams);
            setCanVisible(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Ar() {
        super.Ar();
        if (this.hNQ != null && this.hNQ.Px() != null && this.hNQ.Px().getParent() != null) {
            ((ViewGroup) this.hNQ.Px().getParent()).removeView(this.hNQ.Px());
        }
        if (this.hNQ != null) {
            this.hNQ.destory();
            this.hNQ = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hNQ != null) {
            this.hNQ.destory();
            this.hNQ = null;
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
