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
/* loaded from: classes9.dex */
public class b {
    private TbPageContext duK;
    private String eyU;
    private final View.OnClickListener haG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.eyU)) {
                ba.aOV().a(b.this.duK, new String[]{b.this.eyU}, true);
                TiebaStatic.log(new an("c13418").cI("fid", b.this.mForumId));
            }
        }
    };
    private TextView htP;
    private TbImageView htQ;
    private TbImageView htR;
    private TextView htS;
    private TextView htT;
    private TextView htU;
    private TextView htV;
    private TextView htW;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.duK = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.htP = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.htQ = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.htR = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.htS = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.htT = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.htU = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.htV = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.htW = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.htQ.setPageId(uniqueId);
            this.htR.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.htP.setVisibility(0);
            this.htP.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.htP.setVisibility(8);
        this.htQ.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.htR.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.getChineseAndEnglishLength(str2) > 14) {
            str2 = aq.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.getChineseAndEnglishLength(str3) > 14) {
            str3 = aq.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.htS.setText(str2);
        this.htT.setText(str3);
        this.htU.setText(sportScheduleInfo.match_top_info);
        this.htV.setText(sportScheduleInfo.match_middle_info);
        this.htW.setText(sportScheduleInfo.match_bottom_info);
        this.eyU = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.haG);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setBackgroundResource(this.htP, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setViewTextColor(this.htP, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.htS, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.htT, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.htU, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.htV, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.htW, (int) R.color.cp_cont_c);
    }
}
