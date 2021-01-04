package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SportScheduleInfo;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext eXu;
    private String giS;
    private TextView gzS;
    private TbImageView jGc;
    private TbImageView jGd;
    private TextView jGe;
    private TextView jGf;
    private TextView jGg;
    private TextView jGh;
    private TextView jGi;
    private final View.OnClickListener jhV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!at.isEmpty(b.this.giS)) {
                be.bwu().a(b.this.eXu, new String[]{b.this.giS}, true);
                TiebaStatic.log(new aq("c13418").dX("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eXu = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.gzS = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.jGc = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.jGd = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.jGe = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.jGf = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.jGg = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.jGh = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.jGi = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.jGc.setPageId(uniqueId);
            this.jGd.setPageId(uniqueId);
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
        this.jGc.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.jGd.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (at.getChineseAndEnglishLength(str2) > 14) {
            str2 = at.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (at.getChineseAndEnglishLength(str3) > 14) {
            str3 = at.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.jGe.setText(str2);
        this.jGf.setText(str3);
        this.jGg.setText(sportScheduleInfo.match_top_info);
        this.jGh.setText(sportScheduleInfo.match_middle_info);
        this.jGi.setText(sportScheduleInfo.match_bottom_info);
        this.giS = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.jhV);
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ao.setBackgroundResource(this.gzS, R.drawable.bg_sports_frs_schedule_card_shape);
        ao.setViewTextColor(this.gzS, R.color.CAM_X0105);
        ao.setViewTextColor(this.jGe, R.color.CAM_X0105);
        ao.setViewTextColor(this.jGf, R.color.CAM_X0105);
        ao.setViewTextColor(this.jGg, R.color.CAM_X0108);
        ao.setViewTextColor(this.jGh, R.color.CAM_X0105);
        ao.setViewTextColor(this.jGi, R.color.CAM_X0108);
    }
}
