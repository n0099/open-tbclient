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
/* loaded from: classes21.dex */
public class b {
    private TbPageContext eGu;
    private String fRa;
    private TextView ghj;
    private final View.OnClickListener iKO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!au.isEmpty(b.this.fRa)) {
                bf.bqF().a(b.this.eGu, new String[]{b.this.fRa}, true);
                TiebaStatic.log(new ar("c13418").dR("fid", b.this.mForumId));
            }
        }
    };
    private TbImageView jgc;
    private TbImageView jgd;
    private TextView jge;
    private TextView jgf;
    private TextView jgg;
    private TextView jgh;
    private TextView jgi;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eGu = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.ghj = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.jgc = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.jgd = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.jge = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.jgf = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.jgg = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.jgh = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.jgi = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.jgc.setPageId(uniqueId);
            this.jgd.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.ghj.setVisibility(0);
            this.ghj.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.ghj.setVisibility(8);
        this.jgc.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.jgd.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (au.getChineseAndEnglishLength(str2) > 14) {
            str2 = au.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (au.getChineseAndEnglishLength(str3) > 14) {
            str3 = au.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.jge.setText(str2);
        this.jgf.setText(str3);
        this.jgg.setText(sportScheduleInfo.match_top_info);
        this.jgh.setText(sportScheduleInfo.match_middle_info);
        this.jgi.setText(sportScheduleInfo.match_bottom_info);
        this.fRa = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.iKO);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setBackgroundResource(this.ghj, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setViewTextColor(this.ghj, R.color.CAM_X0105);
        ap.setViewTextColor(this.jge, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgf, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgg, R.color.CAM_X0108);
        ap.setViewTextColor(this.jgh, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgi, R.color.CAM_X0108);
    }
}
