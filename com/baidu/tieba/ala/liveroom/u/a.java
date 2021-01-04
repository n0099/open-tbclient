package com.baidu.tieba.ala.liveroom.u;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.z.c;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private int aMi;
    private String beS;
    private long grz;
    private c hNK;
    private long hNL;
    private String hNM;
    private boolean isShowing;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.isShowing = false;
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aMi = i;
        this.hNL = j;
        this.hNM = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.beS = str4;
        this.grz = j2;
        this.otherParams = str3;
    }

    public void setVisible(int i) {
        if (this.hNK != null && this.hNK.RT() != null) {
            this.hNK.RT().setVisibility(i);
        }
    }

    public void setCanVisible(boolean z) {
        this.isShowing = z;
        if (this.hNK != null) {
            this.hNK.setCanVisible(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (this.hNK == null) {
            com.baidu.live.z.a aVar = new com.baidu.live.z.a(getPageContext().getPageActivity(), this.aMi, this.hNL, this.mIsHost, this.mPortrait, this.otherParams, this.beS, this.grz);
            aVar.userName = this.hNM;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hNK = (c) runTask.getData();
            }
        }
        aN(viewGroup);
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            setCanVisible(true);
        }
    }

    private void aN(ViewGroup viewGroup) {
        if (this.hNK != null && viewGroup != null && this.hNK.RT() != null && viewGroup.indexOfChild(this.hNK.RT()) < 0) {
            this.hNK.RT().setId(a.f.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.f.ala_rank_level_entry);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
            viewGroup.addView(this.hNK.RT(), layoutParams);
            setCanVisible(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void DC() {
        super.DC();
        if (this.hNK != null && this.hNK.RT() != null && this.hNK.RT().getParent() != null) {
            ((ViewGroup) this.hNK.RT().getParent()).removeView(this.hNK.RT());
        }
        if (this.hNK != null) {
            this.hNK.destory();
            this.hNK = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hNK != null) {
            this.hNK.destory();
            this.hNK = null;
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
