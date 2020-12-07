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
    private String fZj;
    private TextView gpt;
    private final View.OnClickListener iVH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!au.isEmpty(b.this.fZj)) {
                bf.bua().a(b.this.eNx, new String[]{b.this.fZj}, true);
                TiebaStatic.log(new ar("c13418").dY("fid", b.this.mForumId));
            }
        }
    };
    private TbImageView jtF;
    private TbImageView jtG;
    private TextView jtH;
    private TextView jtI;
    private TextView jtJ;
    private TextView jtK;
    private TextView jtL;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eNx = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.gpt = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.jtF = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.jtG = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.jtH = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.jtI = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.jtJ = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.jtK = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.jtL = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.jtF.setPageId(uniqueId);
            this.jtG.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.gpt.setVisibility(0);
            this.gpt.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.gpt.setVisibility(8);
        this.jtF.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.jtG.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (au.getChineseAndEnglishLength(str2) > 14) {
            str2 = au.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (au.getChineseAndEnglishLength(str3) > 14) {
            str3 = au.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.jtH.setText(str2);
        this.jtI.setText(str3);
        this.jtJ.setText(sportScheduleInfo.match_top_info);
        this.jtK.setText(sportScheduleInfo.match_middle_info);
        this.jtL.setText(sportScheduleInfo.match_bottom_info);
        this.fZj = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.iVH);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setBackgroundResource(this.gpt, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setViewTextColor(this.gpt, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtH, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtI, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtJ, R.color.CAM_X0108);
        ap.setViewTextColor(this.jtK, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtL, R.color.CAM_X0108);
    }
}
