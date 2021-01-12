package com.baidu.tieba.ala.liveroom.u;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.z.c;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private int aHv;
    private String bac;
    private long gmS;
    private c hJe;
    private long hJf;
    private String hJg;
    private boolean isShowing;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.isShowing = false;
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aHv = i;
        this.hJf = j;
        this.hJg = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bac = str4;
        this.gmS = j2;
        this.otherParams = str3;
    }

    public void setVisible(int i) {
        if (this.hJe != null && this.hJe.NY() != null) {
            this.hJe.NY().setVisibility(i);
        }
    }

    public void setCanVisible(boolean z) {
        this.isShowing = z;
        if (this.hJe != null) {
            this.hJe.setCanVisible(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (this.hJe == null) {
            com.baidu.live.z.a aVar = new com.baidu.live.z.a(getPageContext().getPageActivity(), this.aHv, this.hJf, this.mIsHost, this.mPortrait, this.otherParams, this.bac, this.gmS);
            aVar.userName = this.hJg;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hJe = (c) runTask.getData();
            }
        }
        aN(viewGroup);
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            setCanVisible(true);
        }
    }

    private void aN(ViewGroup viewGroup) {
        if (this.hJe != null && viewGroup != null && this.hJe.NY() != null && viewGroup.indexOfChild(this.hJe.NY()) < 0) {
            this.hJe.NY().setId(a.f.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.f.ala_rank_level_entry);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
            viewGroup.addView(this.hJe.NY(), layoutParams);
            setCanVisible(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void zH() {
        super.zH();
        if (this.hJe != null && this.hJe.NY() != null && this.hJe.NY().getParent() != null) {
            ((ViewGroup) this.hJe.NY().getParent()).removeView(this.hJe.NY());
        }
        if (this.hJe != null) {
            this.hJe.destory();
            this.hJe = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hJe != null) {
            this.hJe.destory();
            this.hJe = null;
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
