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
    private TbPageContext dIF;
    private String eNu;
    private TextView fam;
    private TbImageView hID;
    private TbImageView hIE;
    private TextView hIF;
    private TextView hIG;
    private TextView hIH;
    private TextView hII;
    private TextView hIJ;
    private final View.OnClickListener hpu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.eNu)) {
                ba.aUZ().a(b.this.dIF, new String[]{b.this.eNu}, true);
                TiebaStatic.log(new an("c13418").dh("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.dIF = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.fam = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.hID = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.hIE = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.hIF = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.hIG = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.hIH = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.hII = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.hIJ = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.hID.setPageId(uniqueId);
            this.hIE.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fam.setVisibility(0);
            this.fam.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fam.setVisibility(8);
        this.hID.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.hIE.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.getChineseAndEnglishLength(str2) > 14) {
            str2 = aq.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.getChineseAndEnglishLength(str3) > 14) {
            str3 = aq.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.hIF.setText(str2);
        this.hIG.setText(str3);
        this.hIH.setText(sportScheduleInfo.match_top_info);
        this.hII.setText(sportScheduleInfo.match_middle_info);
        this.hIJ.setText(sportScheduleInfo.match_bottom_info);
        this.eNu = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.hpu);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setBackgroundResource(this.fam, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setViewTextColor(this.fam, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hIF, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hIG, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hIH, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.hII, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hIJ, (int) R.color.cp_cont_c);
    }
}
