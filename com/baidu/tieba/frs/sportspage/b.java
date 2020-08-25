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
/* loaded from: classes16.dex */
public class b {
    private TbPageContext efn;
    private TextView fCl;
    private String fnL;
    private final View.OnClickListener hVB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!at.isEmpty(b.this.fnL)) {
                be.bju().a(b.this.efn, new String[]{b.this.fnL}, true);
                TiebaStatic.log(new aq("c13418").dD("fid", b.this.mForumId));
            }
        }
    };
    private TbImageView iqJ;
    private TbImageView iqK;
    private TextView iqL;
    private TextView iqM;
    private TextView iqN;
    private TextView iqO;
    private TextView iqP;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.efn = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.fCl = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.iqJ = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.iqK = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.iqL = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.iqM = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.iqN = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.iqO = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.iqP = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.iqJ.setPageId(uniqueId);
            this.iqK.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fCl.setVisibility(0);
            this.fCl.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fCl.setVisibility(8);
        this.iqJ.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.iqK.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (at.getChineseAndEnglishLength(str2) > 14) {
            str2 = at.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (at.getChineseAndEnglishLength(str3) > 14) {
            str3 = at.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.iqL.setText(str2);
        this.iqM.setText(str3);
        this.iqN.setText(sportScheduleInfo.match_top_info);
        this.iqO.setText(sportScheduleInfo.match_middle_info);
        this.iqP.setText(sportScheduleInfo.match_bottom_info);
        this.fnL = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.hVB);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setBackgroundResource(this.fCl, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setViewTextColor(this.fCl, R.color.cp_cont_b);
        ap.setViewTextColor(this.iqL, R.color.cp_cont_b);
        ap.setViewTextColor(this.iqM, R.color.cp_cont_b);
        ap.setViewTextColor(this.iqN, R.color.cp_cont_c);
        ap.setViewTextColor(this.iqO, R.color.cp_cont_b);
        ap.setViewTextColor(this.iqP, R.color.cp_cont_c);
    }
}
