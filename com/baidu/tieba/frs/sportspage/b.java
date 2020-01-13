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
/* loaded from: classes7.dex */
public class b {
    private TbPageContext cRe;
    private String dUk;
    private TextView gHa;
    private TbImageView gHb;
    private TbImageView gHc;
    private TextView gHd;
    private TextView gHe;
    private TextView gHf;
    private TextView gHg;
    private TextView gHh;
    private final View.OnClickListener gon = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.dUk)) {
                ba.aEt().a(b.this.cRe, new String[]{b.this.dUk}, true);
                TiebaStatic.log(new an("c13418").cp("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cRe = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.gHa = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.gHb = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.gHc = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.gHd = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.gHe = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.gHf = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.gHg = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.gHh = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.gHb.setPageId(uniqueId);
            this.gHc.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.gHa.setVisibility(0);
            this.gHa.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.gHa.setVisibility(8);
        this.gHb.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.gHc.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.getChineseAndEnglishLength(str2) > 14) {
            str2 = aq.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.getChineseAndEnglishLength(str3) > 14) {
            str3 = aq.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.gHd.setText(str2);
        this.gHe.setText(str3);
        this.gHf.setText(sportScheduleInfo.match_top_info);
        this.gHg.setText(sportScheduleInfo.match_middle_info);
        this.gHh.setText(sportScheduleInfo.match_bottom_info);
        this.dUk = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.gon);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setBackgroundResource(this.gHa, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setViewTextColor(this.gHa, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gHd, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gHe, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gHf, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.gHg, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gHh, (int) R.color.cp_cont_c);
    }
}
