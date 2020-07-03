package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SportScheduleInfo;
/* loaded from: classes9.dex */
public class b {
    private TbPageContext dPv;
    private String eXQ;
    private TextView flH;
    private final View.OnClickListener hCn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ar.isEmpty(b.this.eXQ)) {
                bc.aWU().a(b.this.dPv, new String[]{b.this.eXQ}, true);
                TiebaStatic.log(new ao("c13418").dk("fid", b.this.mForumId));
            }
        }
    };
    private TbImageView hWC;
    private TbImageView hWD;
    private TextView hWE;
    private TextView hWF;
    private TextView hWG;
    private TextView hWH;
    private TextView hWI;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.dPv = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.flH = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.hWC = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.hWD = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.hWE = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.hWF = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.hWG = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.hWH = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.hWI = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.hWC.setPageId(uniqueId);
            this.hWD.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.flH.setVisibility(0);
            this.flH.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.flH.setVisibility(8);
        this.hWC.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.hWD.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (ar.getChineseAndEnglishLength(str2) > 14) {
            str2 = ar.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (ar.getChineseAndEnglishLength(str3) > 14) {
            str3 = ar.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.hWE.setText(str2);
        this.hWF.setText(str3);
        this.hWG.setText(sportScheduleInfo.match_top_info);
        this.hWH.setText(sportScheduleInfo.match_middle_info);
        this.hWI.setText(sportScheduleInfo.match_bottom_info);
        this.eXQ = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.hCn);
    }

    public void onChangeSkinType() {
        an.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        an.setBackgroundResource(this.flH, R.drawable.bg_sports_frs_schedule_card_shape);
        an.setViewTextColor(this.flH, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hWE, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hWF, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hWG, (int) R.color.cp_cont_c);
        an.setViewTextColor(this.hWH, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hWI, (int) R.color.cp_cont_c);
    }
}
