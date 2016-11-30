package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.frs.entelechy.j {
    private HeadImageView bWV;
    private TextView bWW;
    private TextView bWX;
    private View bWY;
    private View bWZ;
    private View mRootView;

    public q(FrsActivity frsActivity, String str, String str2, int i, AcrossForumViewData acrossForumViewData) {
        super(frsActivity, str, str2, i);
        if (acrossForumViewData != null) {
            this.aUH.setPadding(0, 0, 0, 0);
            this.mRootView = ((ViewStub) this.Ge.findViewById(r.g.across_forum_view_stub)).inflate();
            this.bWV = (HeadImageView) this.mRootView.findViewById(r.g.across_forum_user_header);
            this.bWV.setDefaultResource(17170445);
            this.bWV.setDefaultErrorResource(r.f.icon_default_avatar100);
            this.bWV.setDefaultBgResource(r.d.cp_bg_line_e);
            this.bWV.setIsRound(true);
            this.bWW = (TextView) this.mRootView.findViewById(r.g.across_forum_again);
            this.bWX = (TextView) this.mRootView.findViewById(r.g.across_forum_tips);
            this.bWY = this.mRootView.findViewById(r.g.across_forum_share);
            this.bWZ = this.mRootView.findViewById(r.g.across_forum_rules);
            this.bWV.c(acrossForumViewData.userPortrait, 28, false);
            this.bWW.setOnClickListener(new r(this, frsActivity, acrossForumViewData));
            if (!StringUtils.isNull(acrossForumViewData.describe)) {
                this.bWX.setText(acrossForumViewData.describe);
            }
            this.bWY.setOnClickListener(new s(this, frsActivity, acrossForumViewData, str2));
            this.bWZ.setOnClickListener(new t(this, frsActivity, acrossForumViewData));
            TiebaStatic.log(new av("c11728").ab("fid", str2));
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        this.bWV.invalidate();
        at.j((View) this.bWW, r.d.cp_cont_g);
        at.j((View) this.bWX, r.d.cp_cont_g);
    }
}
