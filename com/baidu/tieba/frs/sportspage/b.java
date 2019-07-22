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
    private String cWJ;
    private TextView fOs;
    private TbImageView fOt;
    private TbImageView fOu;
    private TextView fOv;
    private TextView fOw;
    private TextView fOx;
    private TextView fOy;
    private TextView fOz;
    private final View.OnClickListener fvY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.cWJ)) {
                bb.ajC().a(b.this.mContext, new String[]{b.this.cWJ}, true);
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
            this.fOs = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.fOt = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.fOu = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.fOv = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.fOw = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.fOx = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.fOy = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.fOz = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.fOt.setPageId(uniqueId);
            this.fOu.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fOs.setVisibility(0);
            this.fOs.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fOs.setVisibility(8);
        this.fOt.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.fOu.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.ob(str2) > 14) {
            str2 = aq.k(str2, 14, "...");
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.ob(str3) > 14) {
            str3 = aq.k(str3, 14, "...");
        }
        this.fOv.setText(str2);
        this.fOw.setText(str3);
        this.fOx.setText(sportScheduleInfo.match_top_info);
        this.fOy.setText(sportScheduleInfo.match_middle_info);
        this.fOz.setText(sportScheduleInfo.match_bottom_info);
        this.cWJ = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.fvY);
    }

    public void onChangeSkinType() {
        am.k(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.k(this.fOs, R.drawable.bg_sports_frs_schedule_card_shape);
        am.j(this.fOs, R.color.cp_cont_b);
        am.j(this.fOv, R.color.cp_cont_b);
        am.j(this.fOw, R.color.cp_cont_b);
        am.j(this.fOx, R.color.cp_cont_c);
        am.j(this.fOy, R.color.cp_cont_b);
        am.j(this.fOz, R.color.cp_cont_c);
    }
}
