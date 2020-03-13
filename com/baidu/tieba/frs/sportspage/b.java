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
    private TbPageContext cVi;
    private String dYC;
    private TextView gJn;
    private TbImageView gJo;
    private TbImageView gJp;
    private TextView gJq;
    private TextView gJr;
    private TextView gJs;
    private TextView gJt;
    private TextView gJu;
    private final View.OnClickListener gqD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.dYC)) {
                ba.aGG().a(b.this.cVi, new String[]{b.this.dYC}, true);
                TiebaStatic.log(new an("c13418").cy("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cVi = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.gJn = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.gJo = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.gJp = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.gJq = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.gJr = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.gJs = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.gJt = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.gJu = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.gJo.setPageId(uniqueId);
            this.gJp.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.gJn.setVisibility(0);
            this.gJn.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.gJn.setVisibility(8);
        this.gJo.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.gJp.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.getChineseAndEnglishLength(str2) > 14) {
            str2 = aq.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.getChineseAndEnglishLength(str3) > 14) {
            str3 = aq.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.gJq.setText(str2);
        this.gJr.setText(str3);
        this.gJs.setText(sportScheduleInfo.match_top_info);
        this.gJt.setText(sportScheduleInfo.match_middle_info);
        this.gJu.setText(sportScheduleInfo.match_bottom_info);
        this.dYC = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.gqD);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setBackgroundResource(this.gJn, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setViewTextColor(this.gJn, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJq, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJr, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJs, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.gJt, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJu, (int) R.color.cp_cont_c);
    }
}
