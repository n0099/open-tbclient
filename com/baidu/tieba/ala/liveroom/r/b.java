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
public class b extends com.baidu.tieba.ala.liveroom.a {
    private String aEh;
    private int aqR;
    private long eId;
    private c fOR;
    private long fOS;
    private String fOT;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.aqR = i;
        this.fOS = j;
        this.fOT = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aEh = str4;
        this.eId = j2;
        this.otherParams = str3;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ah(ViewGroup viewGroup) {
        super.ah(viewGroup);
        if (this.fOR == null) {
            com.baidu.live.p.a aVar = new com.baidu.live.p.a(getPageContext().getPageActivity(), this.aqR, this.fOS, this.mIsHost, this.mPortrait, this.otherParams, this.aEh, this.eId);
            aVar.userName = this.fOT;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fOR = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            ao(viewGroup);
        }
    }

    private void ao(ViewGroup viewGroup) {
        if (this.fOR != null && this.fOR.Ed() != null && viewGroup.indexOfChild(this.fOR.Ed()) < 0) {
            this.fOR.Ed().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            viewGroup.addView(this.fOR.Ed(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ug() {
        super.ug();
        if (this.fOR != null && this.fOR.Ed() != null && this.fOR.Ed().getParent() != null) {
            ((ViewGroup) this.fOR.Ed().getParent()).removeView(this.fOR.Ed());
        }
        if (this.fOR != null) {
            this.fOR.destory();
            this.fOR = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fOR != null) {
            this.fOR.destory();
            this.fOR = null;
        }
    }

    public void bzN() {
        if (this.fOR != null) {
            this.fOR.Eg();
        }
    }

    public void bzO() {
        if (this.fOR != null) {
            this.fOR.Eh();
        }
    }
}
