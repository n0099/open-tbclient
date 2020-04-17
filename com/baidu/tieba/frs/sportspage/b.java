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
    private TbPageContext duG;
    private String eyP;
    private final View.OnClickListener haA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.eyP)) {
                ba.aOY().a(b.this.duG, new String[]{b.this.eyP}, true);
                TiebaStatic.log(new an("c13418").cI("fid", b.this.mForumId));
            }
        }
    };
    private TextView htJ;
    private TbImageView htK;
    private TbImageView htL;
    private TextView htM;
    private TextView htN;
    private TextView htO;
    private TextView htP;
    private TextView htQ;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.duG = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.htJ = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.htK = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.htL = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.htM = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.htN = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.htO = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.htP = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.htQ = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.htK.setPageId(uniqueId);
            this.htL.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.htJ.setVisibility(0);
            this.htJ.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.htJ.setVisibility(8);
        this.htK.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.htL.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.getChineseAndEnglishLength(str2) > 14) {
            str2 = aq.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.getChineseAndEnglishLength(str3) > 14) {
            str3 = aq.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.htM.setText(str2);
        this.htN.setText(str3);
        this.htO.setText(sportScheduleInfo.match_top_info);
        this.htP.setText(sportScheduleInfo.match_middle_info);
        this.htQ.setText(sportScheduleInfo.match_bottom_info);
        this.eyP = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.haA);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setBackgroundResource(this.htJ, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setViewTextColor(this.htJ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.htM, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.htN, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.htO, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.htP, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.htQ, (int) R.color.cp_cont_c);
    }
}
