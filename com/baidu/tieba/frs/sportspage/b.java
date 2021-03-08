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
    private TbPageContext eWx;
    private String gih;
    private TextView gzS;
    private TbImageView jIX;
    private TbImageView jIY;
    private TextView jIZ;
    private TextView jJa;
    private TextView jJb;
    private TextView jJc;
    private TextView jJd;
    private final View.OnClickListener jkS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!au.isEmpty(b.this.gih)) {
                bf.bsY().a(b.this.eWx, new String[]{b.this.gih}, true);
                TiebaStatic.log(new ar("c13418").dR("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eWx = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.gzS = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.jIX = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.jIY = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.jIZ = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.jJa = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.jJb = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.jJc = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.jJd = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.jIX.setPageId(uniqueId);
            this.jIY.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.gzS.setVisibility(0);
            this.gzS.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.gzS.setVisibility(8);
        this.jIX.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.jIY.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (au.getChineseAndEnglishLength(str2) > 14) {
            str2 = au.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (au.getChineseAndEnglishLength(str3) > 14) {
            str3 = au.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.jIZ.setText(str2);
        this.jJa.setText(str3);
        this.jJb.setText(sportScheduleInfo.match_top_info);
        this.jJc.setText(sportScheduleInfo.match_middle_info);
        this.jJd.setText(sportScheduleInfo.match_bottom_info);
        this.gih = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.jkS);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setBackgroundResource(this.gzS, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setViewTextColor(this.gzS, R.color.CAM_X0105);
        ap.setViewTextColor(this.jIZ, R.color.CAM_X0105);
        ap.setViewTextColor(this.jJa, R.color.CAM_X0105);
        ap.setViewTextColor(this.jJb, R.color.CAM_X0108);
        ap.setViewTextColor(this.jJc, R.color.CAM_X0105);
        ap.setViewTextColor(this.jJd, R.color.CAM_X0108);
    }
}
