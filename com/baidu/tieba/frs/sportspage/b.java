package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SportScheduleInfo;
/* loaded from: classes16.dex */
public class b {
    private TbPageContext dVN;
    private String fcs;
    private TextView fqP;
    private final View.OnClickListener hIl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!as.isEmpty(b.this.fcs)) {
                bd.baV().a(b.this.dVN, new String[]{b.this.fcs}, true);
                TiebaStatic.log(new ap("c13418").dn("fid", b.this.mForumId));
            }
        }
    };
    private TbImageView icC;
    private TbImageView icD;
    private TextView icE;
    private TextView icF;
    private TextView icG;
    private TextView icH;
    private TextView icI;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.dVN = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.fqP = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.icC = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.icD = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.icE = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.icF = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.icG = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.icH = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.icI = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.icC.setPageId(uniqueId);
            this.icD.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fqP.setVisibility(0);
            this.fqP.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fqP.setVisibility(8);
        this.icC.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.icD.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (as.getChineseAndEnglishLength(str2) > 14) {
            str2 = as.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (as.getChineseAndEnglishLength(str3) > 14) {
            str3 = as.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.icE.setText(str2);
        this.icF.setText(str3);
        this.icG.setText(sportScheduleInfo.match_top_info);
        this.icH.setText(sportScheduleInfo.match_middle_info);
        this.icI.setText(sportScheduleInfo.match_bottom_info);
        this.fcs = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.hIl);
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ao.setBackgroundResource(this.fqP, R.drawable.bg_sports_frs_schedule_card_shape);
        ao.setViewTextColor(this.fqP, R.color.cp_cont_b);
        ao.setViewTextColor(this.icE, R.color.cp_cont_b);
        ao.setViewTextColor(this.icF, R.color.cp_cont_b);
        ao.setViewTextColor(this.icG, R.color.cp_cont_c);
        ao.setViewTextColor(this.icH, R.color.cp_cont_b);
        ao.setViewTextColor(this.icI, R.color.cp_cont_c);
    }
}
