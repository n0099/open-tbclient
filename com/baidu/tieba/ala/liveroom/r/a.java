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
    private String aJO;
    private int avX;
    private long eUS;
    private c gdn;
    private long gdo;
    private String gdp;
    private boolean isShowing;
    private boolean mIsHost;
    private String mPortrait;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.isShowing = false;
    }

    public void a(int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.avX = i;
        this.gdo = j;
        this.gdp = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aJO = str4;
        this.eUS = j2;
        this.otherParams = str3;
    }

    public void setVisible(int i) {
        if (this.gdn != null && this.gdn.FS() != null) {
            this.gdn.FS().setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ao(ViewGroup viewGroup) {
        super.ao(viewGroup);
        if (this.gdn == null) {
            com.baidu.live.p.a aVar = new com.baidu.live.p.a(getPageContext().getPageActivity(), this.avX, this.gdo, this.mIsHost, this.mPortrait, this.otherParams, this.aJO, this.eUS);
            aVar.userName = this.gdp;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913036, c.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gdn = (c) runTask.getData();
            }
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            av(viewGroup);
        }
    }

    private void av(ViewGroup viewGroup) {
        if (this.gdn != null && this.gdn.FS() != null && viewGroup.indexOfChild(this.gdn.FS()) < 0) {
            this.gdn.FS().setId(a.g.ala_liveroom_ranklist);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.addRule(1, a.g.guard_club_entry_id);
            layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            viewGroup.addView(this.gdn.FS(), layoutParams);
            this.isShowing = true;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vm() {
        super.vm();
        if (this.gdn != null && this.gdn.FS() != null && this.gdn.FS().getParent() != null) {
            ((ViewGroup) this.gdn.FS().getParent()).removeView(this.gdn.FS());
        }
        if (this.gdn != null) {
            this.gdn.destory();
            this.gdn = null;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gdn != null) {
            this.gdn.destory();
            this.gdn = null;
        }
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
