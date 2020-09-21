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
/* loaded from: classes21.dex */
public class b {
    private TbPageContext ehG;
    private TextView fFB;
    private String fqU;
    private final View.OnClickListener icH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!at.isEmpty(b.this.fqU)) {
                be.bkp().a(b.this.ehG, new String[]{b.this.fqU}, true);
                TiebaStatic.log(new aq("c13418").dF("fid", b.this.mForumId));
            }
        }
    };
    private TbImageView iyf;
    private TbImageView iyg;
    private TextView iyh;
    private TextView iyi;
    private TextView iyj;
    private TextView iyk;
    private TextView iyl;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.ehG = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.fFB = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.iyf = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.iyg = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.iyh = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.iyi = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.iyj = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.iyk = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.iyl = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.iyf.setPageId(uniqueId);
            this.iyg.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fFB.setVisibility(0);
            this.fFB.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fFB.setVisibility(8);
        this.iyf.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.iyg.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (at.getChineseAndEnglishLength(str2) > 14) {
            str2 = at.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (at.getChineseAndEnglishLength(str3) > 14) {
            str3 = at.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.iyh.setText(str2);
        this.iyi.setText(str3);
        this.iyj.setText(sportScheduleInfo.match_top_info);
        this.iyk.setText(sportScheduleInfo.match_middle_info);
        this.iyl.setText(sportScheduleInfo.match_bottom_info);
        this.fqU = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.icH);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setBackgroundResource(this.fFB, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setViewTextColor(this.fFB, R.color.cp_cont_b);
        ap.setViewTextColor(this.iyh, R.color.cp_cont_b);
        ap.setViewTextColor(this.iyi, R.color.cp_cont_b);
        ap.setViewTextColor(this.iyj, R.color.cp_cont_c);
        ap.setViewTextColor(this.iyk, R.color.cp_cont_b);
        ap.setViewTextColor(this.iyl, R.color.cp_cont_c);
    }
}
