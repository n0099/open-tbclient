package com.baidu.tieba.ala.liveroom.r;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.l.c;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private int Ws;
    private String aiO;
    private long edz;
    private c fdA;
    private long fdB;
    private String fdC;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.Ws = i;
        this.fdB = j;
        this.fdC = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aiO = str4;
        this.edz = j2;
        this.otherParams = str3;
    }

    public void setVisible(int i) {
        if (this.fdA != null && this.fdA.wr() != null) {
            this.fdA.wr().setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Z(ViewGroup viewGroup) {
        super.Z(viewGroup);
        if (this.fdA == null) {
            com.baidu.live.l.a aVar = new com.baidu.live.l.a(getPageContext().getPageActivity(), this.Ws, this.fdB, this.mIsHost, this.mPortrait, this.otherParams, this.aiO, this.edz);
            aVar.userName = this.fdC;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fdA = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            ah(viewGroup);
        }
    }

    private void ah(ViewGroup viewGroup) {
        if (this.fdA != null && this.fdA.wr() != null && viewGroup.indexOfChild(this.fdA.wr()) < 0) {
            this.fdA.wr().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            viewGroup.addView(this.fdA.wr(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void oS() {
        super.oS();
        if (this.fdA != null && this.fdA.wr() != null && this.fdA.wr().getParent() != null) {
            ((ViewGroup) this.fdA.wr().getParent()).removeView(this.fdA.wr());
        }
        if (this.fdA != null) {
            this.fdA.destory();
            this.fdA = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fdA != null) {
            this.fdA.destory();
            this.fdA = null;
        }
    }
}
