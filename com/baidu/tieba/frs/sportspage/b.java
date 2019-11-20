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
    private TbPageContext ceu;
    private String dgp;
    private TbImageView fPA;
    private TextView fPB;
    private TextView fPC;
    private TextView fPD;
    private TextView fPE;
    private TextView fPF;
    private TextView fPy;
    private TbImageView fPz;
    private final View.OnClickListener fwH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.dgp)) {
                ba.amO().a(b.this.ceu, new String[]{b.this.dgp}, true);
                TiebaStatic.log(new an("c13418").bS("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.ceu = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.fPy = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.fPz = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.fPA = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.fPB = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.fPC = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.fPD = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.fPE = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.fPF = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.fPz.setPageId(uniqueId);
            this.fPA.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fPy.setVisibility(0);
            this.fPy.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fPy.setVisibility(8);
        this.fPz.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.fPA.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.getChineseAndEnglishLength(str2) > 14) {
            str2 = aq.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.getChineseAndEnglishLength(str3) > 14) {
            str3 = aq.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.fPB.setText(str2);
        this.fPC.setText(str3);
        this.fPD.setText(sportScheduleInfo.match_top_info);
        this.fPE.setText(sportScheduleInfo.match_middle_info);
        this.fPF.setText(sportScheduleInfo.match_bottom_info);
        this.dgp = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.fwH);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setBackgroundResource(this.fPy, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setViewTextColor(this.fPy, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fPB, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fPC, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fPD, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.fPE, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fPF, (int) R.color.cp_cont_c);
    }
}
