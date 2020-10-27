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
    private TbPageContext eCn;
    private String fLC;
    private TextView gbN;
    private final View.OnClickListener iEe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!at.isEmpty(b.this.fLC)) {
                be.boR().a(b.this.eCn, new String[]{b.this.fLC}, true);
                TiebaStatic.log(new aq("c13418").dR("fid", b.this.mForumId));
            }
        }
    };
    private TextView iZA;
    private TbImageView iZu;
    private TbImageView iZv;
    private TextView iZw;
    private TextView iZx;
    private TextView iZy;
    private TextView iZz;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eCn = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.gbN = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.iZu = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.iZv = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.iZw = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.iZx = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.iZy = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.iZz = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.iZA = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.iZu.setPageId(uniqueId);
            this.iZv.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.gbN.setVisibility(0);
            this.gbN.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.gbN.setVisibility(8);
        this.iZu.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.iZv.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (at.getChineseAndEnglishLength(str2) > 14) {
            str2 = at.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (at.getChineseAndEnglishLength(str3) > 14) {
            str3 = at.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.iZw.setText(str2);
        this.iZx.setText(str3);
        this.iZy.setText(sportScheduleInfo.match_top_info);
        this.iZz.setText(sportScheduleInfo.match_middle_info);
        this.iZA.setText(sportScheduleInfo.match_bottom_info);
        this.fLC = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.iEe);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setBackgroundResource(this.gbN, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setViewTextColor(this.gbN, R.color.cp_cont_b);
        ap.setViewTextColor(this.iZw, R.color.cp_cont_b);
        ap.setViewTextColor(this.iZx, R.color.cp_cont_b);
        ap.setViewTextColor(this.iZy, R.color.cp_cont_c);
        ap.setViewTextColor(this.iZz, R.color.cp_cont_b);
        ap.setViewTextColor(this.iZA, R.color.cp_cont_c);
    }
}
