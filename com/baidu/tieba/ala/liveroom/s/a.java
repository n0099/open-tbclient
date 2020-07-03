package com.baidu.tieba.ala.liveroom.s;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.q.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private String aMu;
    private int ayf;
    private long ffd;
    private c gqh;
    private long gqi;
    private String gqj;
    private boolean isShowing;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.isShowing = false;
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.ayf = i;
        this.gqi = j;
        this.gqj = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aMu = str4;
        this.ffd = j2;
        this.otherParams = str3;
    }

    public void setVisible(int i) {
        if (this.gqh != null && this.gqh.GB() != null) {
            this.gqh.GB().setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aq(ViewGroup viewGroup) {
        super.aq(viewGroup);
        if (this.gqh == null) {
            com.baidu.live.q.a aVar = new com.baidu.live.q.a(getPageContext().getPageActivity(), this.ayf, this.gqi, this.mIsHost, this.mPortrait, this.otherParams, this.aMu, this.ffd);
            aVar.userName = this.gqj;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gqh = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            ay(viewGroup);
        }
    }

    private void ay(ViewGroup viewGroup) {
        if (this.gqh != null && this.gqh.GB() != null && viewGroup.indexOfChild(this.gqh.GB()) < 0) {
            this.gqh.GB().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            viewGroup.addView(this.gqh.GB(), layoutParams);
            this.isShowing = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vH() {
        super.vH();
        if (this.gqh != null && this.gqh.GB() != null && this.gqh.GB().getParent() != null) {
            ((ViewGroup) this.gqh.GB().getParent()).removeView(this.gqh.GB());
        }
        if (this.gqh != null) {
            this.gqh.destory();
            this.gqh = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gqh != null) {
            this.gqh.destory();
            this.gqh = null;
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
