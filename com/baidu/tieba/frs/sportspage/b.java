package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SportScheduleInfo;
/* loaded from: classes4.dex */
public class b {
    private TbPageContext cfl;
    private String dhg;
    private TextView fQp;
    private TbImageView fQq;
    private TbImageView fQr;
    private TextView fQs;
    private TextView fQt;
    private TextView fQu;
    private TextView fQv;
    private TextView fQw;
    private final View.OnClickListener fxy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.dhg)) {
                ba.amQ().a(b.this.cfl, new String[]{b.this.dhg}, true);
                TiebaStatic.log(new an("c13418").bS("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cfl = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.fQp = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.fQq = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.fQr = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.fQs = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.fQt = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.fQu = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.fQv = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.fQw = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.fQq.setPageId(uniqueId);
            this.fQr.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fQp.setVisibility(0);
            this.fQp.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fQp.setVisibility(8);
        this.fQq.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.fQr.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.getChineseAndEnglishLength(str2) > 14) {
            str2 = aq.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.getChineseAndEnglishLength(str3) > 14) {
            str3 = aq.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.fQs.setText(str2);
        this.fQt.setText(str3);
        this.fQu.setText(sportScheduleInfo.match_top_info);
        this.fQv.setText(sportScheduleInfo.match_middle_info);
        this.fQw.setText(sportScheduleInfo.match_bottom_info);
        this.dhg = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.fxy);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setBackgroundResource(this.fQp, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setViewTextColor(this.fQp, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fQs, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fQt, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fQu, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.fQv, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fQw, (int) R.color.cp_cont_c);
    }
}
