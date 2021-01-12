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
    private TbPageContext eSJ;
    private String gej;
    private TextView gvl;
    private TextView jBA;
    private TextView jBB;
    private TextView jBC;
    private TbImageView jBw;
    private TbImageView jBx;
    private TextView jBy;
    private TextView jBz;
    private final View.OnClickListener jdo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!at.isEmpty(b.this.gej)) {
                be.bsB().a(b.this.eSJ, new String[]{b.this.gej}, true);
                TiebaStatic.log(new aq("c13418").dW("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eSJ = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.gvl = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.jBw = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.jBx = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.jBy = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.jBz = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.jBA = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.jBB = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.jBC = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.jBw.setPageId(uniqueId);
            this.jBx.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.gvl.setVisibility(0);
            this.gvl.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.gvl.setVisibility(8);
        this.jBw.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.jBx.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (at.getChineseAndEnglishLength(str2) > 14) {
            str2 = at.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (at.getChineseAndEnglishLength(str3) > 14) {
            str3 = at.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.jBy.setText(str2);
        this.jBz.setText(str3);
        this.jBA.setText(sportScheduleInfo.match_top_info);
        this.jBB.setText(sportScheduleInfo.match_middle_info);
        this.jBC.setText(sportScheduleInfo.match_bottom_info);
        this.gej = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.jdo);
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ao.setBackgroundResource(this.gvl, R.drawable.bg_sports_frs_schedule_card_shape);
        ao.setViewTextColor(this.gvl, R.color.CAM_X0105);
        ao.setViewTextColor(this.jBy, R.color.CAM_X0105);
        ao.setViewTextColor(this.jBz, R.color.CAM_X0105);
        ao.setViewTextColor(this.jBA, R.color.CAM_X0108);
        ao.setViewTextColor(this.jBB, R.color.CAM_X0105);
        ao.setViewTextColor(this.jBC, R.color.CAM_X0108);
    }
}
