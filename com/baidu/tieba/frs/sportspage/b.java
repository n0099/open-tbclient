package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SportScheduleInfo;
/* loaded from: classes22.dex */
public class b {
    private TbPageContext eIc;
    private String fRs;
    private TextView ghC;
    private final View.OnClickListener iKb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!at.isEmpty(b.this.fRs)) {
                be.brr().a(b.this.eIc, new String[]{b.this.fRs}, true);
                TiebaStatic.log(new aq("c13418").dR("fid", b.this.mForumId));
            }
        }
    };
    private TbImageView jfr;
    private TbImageView jfs;
    private TextView jft;
    private TextView jfu;
    private TextView jfv;
    private TextView jfw;
    private TextView jfx;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eIc = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.ghC = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.jfr = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.jfs = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.jft = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.jfu = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.jfv = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.jfw = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.jfx = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.jfr.setPageId(uniqueId);
            this.jfs.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.ghC.setVisibility(0);
            this.ghC.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.ghC.setVisibility(8);
        this.jfr.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.jfs.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (at.getChineseAndEnglishLength(str2) > 14) {
            str2 = at.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (at.getChineseAndEnglishLength(str3) > 14) {
            str3 = at.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.jft.setText(str2);
        this.jfu.setText(str3);
        this.jfv.setText(sportScheduleInfo.match_top_info);
        this.jfw.setText(sportScheduleInfo.match_middle_info);
        this.jfx.setText(sportScheduleInfo.match_bottom_info);
        this.fRs = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.iKb);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setBackgroundResource(this.ghC, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setViewTextColor(this.ghC, R.color.cp_cont_b);
        ap.setViewTextColor(this.jft, R.color.cp_cont_b);
        ap.setViewTextColor(this.jfu, R.color.cp_cont_b);
        ap.setViewTextColor(this.jfv, R.color.cp_cont_c);
        ap.setViewTextColor(this.jfw, R.color.cp_cont_b);
        ap.setViewTextColor(this.jfx, R.color.cp_cont_c);
    }
}
