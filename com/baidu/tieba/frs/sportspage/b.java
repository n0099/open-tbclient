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
    private String ggD;
    private TextView gyj;
    private TbImageView jHo;
    private TbImageView jHp;
    private TextView jHq;
    private TextView jHr;
    private TextView jHs;
    private TextView jHt;
    private TextView jHu;
    private final View.OnClickListener jjj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!au.isEmpty(b.this.ggD)) {
                bf.bsV().a(b.this.eUY, new String[]{b.this.ggD}, true);
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
            this.gyj = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.jHo = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.jHp = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.jHq = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.jHr = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.jHs = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.jHt = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.jHu = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.jHo.setPageId(uniqueId);
            this.jHp.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.gyj.setVisibility(0);
            this.gyj.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.gyj.setVisibility(8);
        this.jHo.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.jHp.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (au.getChineseAndEnglishLength(str2) > 14) {
            str2 = au.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (au.getChineseAndEnglishLength(str3) > 14) {
            str3 = au.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.jHq.setText(str2);
        this.jHr.setText(str3);
        this.jHs.setText(sportScheduleInfo.match_top_info);
        this.jHt.setText(sportScheduleInfo.match_middle_info);
        this.jHu.setText(sportScheduleInfo.match_bottom_info);
        this.ggD = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.jjj);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setBackgroundResource(this.gyj, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setViewTextColor(this.gyj, R.color.CAM_X0105);
        ap.setViewTextColor(this.jHq, R.color.CAM_X0105);
        ap.setViewTextColor(this.jHr, R.color.CAM_X0105);
        ap.setViewTextColor(this.jHs, R.color.CAM_X0108);
        ap.setViewTextColor(this.jHt, R.color.CAM_X0105);
        ap.setViewTextColor(this.jHu, R.color.CAM_X0108);
    }
}
