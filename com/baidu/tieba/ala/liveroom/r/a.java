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
    private String aEn;
    private int aqX;
    private long eIi;
    private c fOW;
    private long fOX;
    private String fOY;
    private boolean isShowing;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.isShowing = false;
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aqX = i;
        this.fOX = j;
        this.fOY = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aEn = str4;
        this.eIi = j2;
        this.otherParams = str3;
    }

    public void setVisible(int i) {
        if (this.fOW != null && this.fOW.Ec() != null) {
            this.fOW.Ec().setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ah(ViewGroup viewGroup) {
        super.ah(viewGroup);
        if (this.fOW == null) {
            com.baidu.live.p.a aVar = new com.baidu.live.p.a(getPageContext().getPageActivity(), this.aqX, this.fOX, this.mIsHost, this.mPortrait, this.otherParams, this.aEn, this.eIi);
            aVar.userName = this.fOY;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fOW = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            ao(viewGroup);
        }
    }

    private void ao(ViewGroup viewGroup) {
        if (this.fOW != null && this.fOW.Ec() != null && viewGroup.indexOfChild(this.fOW.Ec()) < 0) {
            this.fOW.Ec().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            viewGroup.addView(this.fOW.Ec(), layoutParams);
            this.isShowing = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void uf() {
        super.uf();
        if (this.fOW != null && this.fOW.Ec() != null && this.fOW.Ec().getParent() != null) {
            ((ViewGroup) this.fOW.Ec().getParent()).removeView(this.fOW.Ec());
        }
        if (this.fOW != null) {
            this.fOW.destory();
            this.fOW = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fOW != null) {
            this.fOW.destory();
            this.fOW = null;
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
