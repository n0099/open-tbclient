package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SportScheduleInfo;
/* loaded from: classes22.dex */
public class b {
    private TbPageContext etO;
    private String fDh;
    private TextView fRK;
    private TbImageView iMY;
    private TbImageView iMZ;
    private TextView iNa;
    private TextView iNb;
    private TextView iNc;
    private TextView iNd;
    private TextView iNe;
    private final View.OnClickListener irI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!at.isEmpty(b.this.fDh)) {
                be.bmY().a(b.this.etO, new String[]{b.this.fDh}, true);
                TiebaStatic.log(new aq("c13418").dK("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.etO = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.fRK = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.iMY = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.iMZ = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.iNa = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.iNb = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.iNc = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.iNd = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.iNe = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.iMY.setPageId(uniqueId);
            this.iMZ.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fRK.setVisibility(0);
            this.fRK.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fRK.setVisibility(8);
        this.iMY.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.iMZ.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (at.getChineseAndEnglishLength(str2) > 14) {
            str2 = at.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (at.getChineseAndEnglishLength(str3) > 14) {
            str3 = at.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.iNa.setText(str2);
        this.iNb.setText(str3);
        this.iNc.setText(sportScheduleInfo.match_top_info);
        this.iNd.setText(sportScheduleInfo.match_middle_info);
        this.iNe.setText(sportScheduleInfo.match_bottom_info);
        this.fDh = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.irI);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setBackgroundResource(this.fRK, R.drawable.bg_sports_frs_schedule_card_shape);
        ap.setViewTextColor(this.fRK, R.color.cp_cont_b);
        ap.setViewTextColor(this.iNa, R.color.cp_cont_b);
        ap.setViewTextColor(this.iNb, R.color.cp_cont_b);
        ap.setViewTextColor(this.iNc, R.color.cp_cont_c);
        ap.setViewTextColor(this.iNd, R.color.cp_cont_b);
        ap.setViewTextColor(this.iNe, R.color.cp_cont_c);
    }
}
