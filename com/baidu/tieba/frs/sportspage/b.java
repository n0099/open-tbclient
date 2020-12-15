package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SportScheduleInfo;
/* loaded from: classes22.dex */
public class b {
    private TbPageContext eNx;
    private String fZl;
    private TextView gpv;
    private final View.OnClickListener iVJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!au.isEmpty(b.this.fZl)) {
                bf.bua().a(b.this.eNx, new String[]{b.this.fZl}, true);
                TiebaStatic.log(new ar("c13418").dY("fid", b.this.mForumId));
            }
        }
    };
    private TbImageView jtH;
    private TbImageView jtI;
    private TextView jtJ;
    private TextView jtK;
    private TextView jtL;
    private TextView jtM;
    private TextView jtN;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eNx = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.gpv = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.jtH = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.jtI = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.jtJ = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.jtK = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.jtL = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.jtM = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.jtN = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.jtH.setPageId(uniqueId);
            this.jtI.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.gpv.setVisibility(0);
            this.gpv.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.gpv.setVisibility(8);
        this.jtH.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.jtI.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (au.getChineseAndEnglishLength(str2) > 14) {
            str2 = au.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (au.getChineseAndEnglishLength(str3) > 14) {
            str3 = au.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.jtJ.setText(str2);
        this.jtK.setText(str3);
        this.jtL.setText(sportScheduleInfo.match_top_info);
        this.jtM.setText(sportScheduleInfo.match_middle_info);
        this.jtN.setText(sportScheduleInfo.match_bottom_info);
        this.fZl = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.iVJ);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setBackgroundResource(this.gpv, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setViewTextColor(this.gpv, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtJ, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtK, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtL, R.color.CAM_X0108);
        ap.setViewTextColor(this.jtM, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtN, R.color.CAM_X0108);
    }
}
