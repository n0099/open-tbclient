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
    private TbPageContext efr;
    private TextView fCp;
    private String fnP;
    private final View.OnClickListener hVH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!at.isEmpty(b.this.fnP)) {
                be.bju().a(b.this.efr, new String[]{b.this.fnP}, true);
                TiebaStatic.log(new aq("c13418").dD("fid", b.this.mForumId));
            }
        }
    };
    private TbImageView iqP;
    private TbImageView iqQ;
    private TextView iqR;
    private TextView iqS;
    private TextView iqT;
    private TextView iqU;
    private TextView iqV;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.efr = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.fCp = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.iqP = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.iqQ = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.iqR = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.iqS = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.iqT = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.iqU = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.iqV = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.iqP.setPageId(uniqueId);
            this.iqQ.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fCp.setVisibility(0);
            this.fCp.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fCp.setVisibility(8);
        this.iqP.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.iqQ.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (at.getChineseAndEnglishLength(str2) > 14) {
            str2 = at.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (at.getChineseAndEnglishLength(str3) > 14) {
            str3 = at.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.iqR.setText(str2);
        this.iqS.setText(str3);
        this.iqT.setText(sportScheduleInfo.match_top_info);
        this.iqU.setText(sportScheduleInfo.match_middle_info);
        this.iqV.setText(sportScheduleInfo.match_bottom_info);
        this.fnP = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.hVH);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setBackgroundResource(this.fCp, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setViewTextColor(this.fCp, R.color.cp_cont_b);
        ap.setViewTextColor(this.iqR, R.color.cp_cont_b);
        ap.setViewTextColor(this.iqS, R.color.cp_cont_b);
        ap.setViewTextColor(this.iqT, R.color.cp_cont_c);
        ap.setViewTextColor(this.iqU, R.color.cp_cont_b);
        ap.setViewTextColor(this.iqV, R.color.cp_cont_c);
    }
}
