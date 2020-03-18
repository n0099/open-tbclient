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
    private TbPageContext cVv;
    private String dYS;
    private TextView gKs;
    private TbImageView gKt;
    private TbImageView gKu;
    private TextView gKv;
    private TextView gKw;
    private TextView gKx;
    private TextView gKy;
    private TextView gKz;
    private final View.OnClickListener grn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.dYS)) {
                ba.aGK().a(b.this.cVv, new String[]{b.this.dYS}, true);
                TiebaStatic.log(new an("c13418").cx("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cVv = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.gKs = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.gKt = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.gKu = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.gKv = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.gKw = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.gKx = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.gKy = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.gKz = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.gKt.setPageId(uniqueId);
            this.gKu.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.gKs.setVisibility(0);
            this.gKs.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.gKs.setVisibility(8);
        this.gKt.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.gKu.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.getChineseAndEnglishLength(str2) > 14) {
            str2 = aq.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.getChineseAndEnglishLength(str3) > 14) {
            str3 = aq.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.gKv.setText(str2);
        this.gKw.setText(str3);
        this.gKx.setText(sportScheduleInfo.match_top_info);
        this.gKy.setText(sportScheduleInfo.match_middle_info);
        this.gKz.setText(sportScheduleInfo.match_bottom_info);
        this.dYS = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.grn);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setBackgroundResource(this.gKs, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setViewTextColor(this.gKs, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gKv, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gKw, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gKx, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.gKy, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gKz, (int) R.color.cp_cont_c);
    }
}
