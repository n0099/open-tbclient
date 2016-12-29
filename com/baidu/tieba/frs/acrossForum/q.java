package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.frs.entelechy.j {
    private HeadImageView bDf;
    private TextView bDg;
    private TextView bDh;
    private View bDi;
    private View bDj;
    private View mRootView;

    public q(FrsActivity frsActivity, String str, String str2, int i, AcrossForumViewData acrossForumViewData) {
        super(frsActivity, str, str2, i);
        if (acrossForumViewData != null) {
            this.aTY.setPadding(0, 0, 0, 0);
            this.mRootView = ((ViewStub) this.Ge.findViewById(r.g.across_forum_view_stub)).inflate();
            this.bDf = (HeadImageView) this.mRootView.findViewById(r.g.across_forum_user_header);
            this.bDf.setDefaultResource(17170445);
            this.bDf.setDefaultErrorResource(r.f.icon_default_avatar100);
            this.bDf.setDefaultBgResource(r.d.cp_bg_line_e);
            this.bDf.setIsRound(true);
            this.bDg = (TextView) this.mRootView.findViewById(r.g.across_forum_again);
            this.bDh = (TextView) this.mRootView.findViewById(r.g.across_forum_tips);
            this.bDi = this.mRootView.findViewById(r.g.across_forum_share);
            this.bDj = this.mRootView.findViewById(r.g.across_forum_rules);
            this.bDf.c(acrossForumViewData.userPortrait, 28, false);
            this.bDg.setOnClickListener(new r(this, frsActivity, acrossForumViewData));
            if (!StringUtils.isNull(acrossForumViewData.describe)) {
                this.bDh.setText(acrossForumViewData.describe);
            }
            this.bDi.setOnClickListener(new s(this, frsActivity, acrossForumViewData, str2));
            this.bDj.setOnClickListener(new t(this, frsActivity, acrossForumViewData));
            TiebaStatic.log(new at("c11728").ab("fid", str2));
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        this.bDf.invalidate();
        ar.j((View) this.bDg, r.d.cp_cont_g);
        ar.j((View) this.bDh, r.d.cp_cont_g);
    }
}
