package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SportScheduleInfo;
/* loaded from: classes4.dex */
public class b {
    private String cXJ;
    private TextView fQW;
    private TbImageView fQX;
    private TbImageView fQY;
    private TextView fQZ;
    private TextView fRa;
    private TextView fRb;
    private TextView fRc;
    private TextView fRd;
    private final View.OnClickListener fyk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.cXJ)) {
                ba.ajK().a(b.this.mContext, new String[]{b.this.cXJ}, true);
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
            this.fQW = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.fQX = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.fQY = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.fQZ = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.fRa = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.fRb = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.fRc = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.fRd = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.fQX.setPageId(uniqueId);
            this.fQY.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fQW.setVisibility(0);
            this.fQW.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fQW.setVisibility(8);
        this.fQX.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.fQY.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.od(str2) > 14) {
            str2 = aq.k(str2, 14, "...");
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.od(str3) > 14) {
            str3 = aq.k(str3, 14, "...");
        }
        this.fQZ.setText(str2);
        this.fRa.setText(str3);
        this.fRb.setText(sportScheduleInfo.match_top_info);
        this.fRc.setText(sportScheduleInfo.match_middle_info);
        this.fRd.setText(sportScheduleInfo.match_bottom_info);
        this.cXJ = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.fyk);
    }

    public void onChangeSkinType() {
        am.k(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.k(this.fQW, R.drawable.bg_sports_frs_schedule_card_shape);
        am.j(this.fQW, R.color.cp_cont_b);
        am.j(this.fQZ, R.color.cp_cont_b);
        am.j(this.fRa, R.color.cp_cont_b);
        am.j(this.fRb, R.color.cp_cont_c);
        am.j(this.fRc, R.color.cp_cont_b);
        am.j(this.fRd, R.color.cp_cont_c);
    }
}
