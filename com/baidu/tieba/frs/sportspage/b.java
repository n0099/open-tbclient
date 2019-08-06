package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SportScheduleInfo;
/* loaded from: classes4.dex */
public class b {
    private String cWQ;
    private TextView fPg;
    private TbImageView fPh;
    private TbImageView fPi;
    private TextView fPj;
    private TextView fPk;
    private TextView fPl;
    private TextView fPm;
    private TextView fPn;
    private final View.OnClickListener fwx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.cWQ)) {
                bb.ajE().a(b.this.mContext, new String[]{b.this.cWQ}, true);
                TiebaStatic.log(new an("c13418").bT("fid", b.this.mForumId));
            }
        }
    };
    private TbPageContext mContext;
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.mContext = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.fPg = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.fPh = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.fPi = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.fPj = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.fPk = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.fPl = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.fPm = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.fPn = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.fPh.setPageId(uniqueId);
            this.fPi.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fPg.setVisibility(0);
            this.fPg.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fPg.setVisibility(8);
        this.fPh.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.fPi.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.ob(str2) > 14) {
            str2 = aq.k(str2, 14, "...");
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.ob(str3) > 14) {
            str3 = aq.k(str3, 14, "...");
        }
        this.fPj.setText(str2);
        this.fPk.setText(str3);
        this.fPl.setText(sportScheduleInfo.match_top_info);
        this.fPm.setText(sportScheduleInfo.match_middle_info);
        this.fPn.setText(sportScheduleInfo.match_bottom_info);
        this.cWQ = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.fwx);
    }

    public void onChangeSkinType() {
        am.k(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.k(this.fPg, R.drawable.bg_sports_frs_schedule_card_shape);
        am.j(this.fPg, R.color.cp_cont_b);
        am.j(this.fPj, R.color.cp_cont_b);
        am.j(this.fPk, R.color.cp_cont_b);
        am.j(this.fPl, R.color.cp_cont_c);
        am.j(this.fPm, R.color.cp_cont_b);
        am.j(this.fPn, R.color.cp_cont_c);
    }
}
