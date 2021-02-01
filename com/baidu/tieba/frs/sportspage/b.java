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
/* loaded from: classes2.dex */
public class b {
    private TbPageContext eUY;
    private String ggy;
    private TextView gxV;
    private TbImageView jHa;
    private TbImageView jHb;
    private TextView jHc;
    private TextView jHd;
    private TextView jHe;
    private TextView jHf;
    private TextView jHg;
    private final View.OnClickListener jiV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!au.isEmpty(b.this.ggy)) {
                bf.bsV().a(b.this.eUY, new String[]{b.this.ggy}, true);
                TiebaStatic.log(new ar("c13418").dR("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eUY = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.gxV = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.jHa = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.jHb = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.jHc = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.jHd = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.jHe = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.jHf = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.jHg = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.jHa.setPageId(uniqueId);
            this.jHb.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.gxV.setVisibility(0);
            this.gxV.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.gxV.setVisibility(8);
        this.jHa.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.jHb.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (au.getChineseAndEnglishLength(str2) > 14) {
            str2 = au.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (au.getChineseAndEnglishLength(str3) > 14) {
            str3 = au.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.jHc.setText(str2);
        this.jHd.setText(str3);
        this.jHe.setText(sportScheduleInfo.match_top_info);
        this.jHf.setText(sportScheduleInfo.match_middle_info);
        this.jHg.setText(sportScheduleInfo.match_bottom_info);
        this.ggy = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.jiV);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setBackgroundResource(this.gxV, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setViewTextColor(this.gxV, R.color.CAM_X0105);
        ap.setViewTextColor(this.jHc, R.color.CAM_X0105);
        ap.setViewTextColor(this.jHd, R.color.CAM_X0105);
        ap.setViewTextColor(this.jHe, R.color.CAM_X0108);
        ap.setViewTextColor(this.jHf, R.color.CAM_X0105);
        ap.setViewTextColor(this.jHg, R.color.CAM_X0108);
    }
}
