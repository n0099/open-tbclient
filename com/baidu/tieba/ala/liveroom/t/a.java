package com.baidu.tieba.ala.liveroom.t;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.x.c;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private int aLA;
    private String beL;
    private long gry;
    private long hPA;
    private String hPB;
    private c hPz;
    private boolean isShowing;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.isShowing = false;
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aLA = i;
        this.hPA = j;
        this.hPB = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.beL = str4;
        this.gry = j2;
        this.otherParams = str3;
    }

    public void setVisible(int i) {
        if (this.hPz != null && this.hPz.PA() != null) {
            this.hPz.PA().setVisibility(i);
        }
    }

    public void setCanVisible(boolean z) {
        this.isShowing = z;
        if (this.hPz != null) {
            this.hPz.setCanVisible(z);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (this.hPz == null) {
            com.baidu.live.x.a aVar = new com.baidu.live.x.a(getPageContext().getPageActivity(), this.aLA, this.hPA, this.mIsHost, this.mPortrait, this.otherParams, this.beL, this.gry);
            aVar.userName = this.hPB;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hPz = (c) runTask.getData();
            }
        }
        aN(viewGroup);
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            setCanVisible(true);
        }
    }

    private void aN(ViewGroup viewGroup) {
        if (this.hPz != null && viewGroup != null && this.hPz.PA() != null && viewGroup.indexOfChild(this.hPz.PA()) < 0) {
            this.hPz.PA().setId(a.f.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.f.ala_rank_level_entry);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
            viewGroup.addView(this.hPz.PA(), layoutParams);
            setCanVisible(false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Au() {
        super.Au();
        if (this.hPz != null && this.hPz.PA() != null && this.hPz.PA().getParent() != null) {
            ((ViewGroup) this.hPz.PA().getParent()).removeView(this.hPz.PA());
        }
        if (this.hPz != null) {
            this.hPz.destory();
            this.hPz = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hPz != null) {
            this.hPz.destory();
            this.hPz = null;
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
