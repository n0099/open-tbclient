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
    private TbPageContext dIF;
    private String eNF;
    private TextView fax;
    private TbImageView hJq;
    private TbImageView hJr;
    private TextView hJs;
    private TextView hJt;
    private TextView hJu;
    private TextView hJv;
    private TextView hJw;
    private final View.OnClickListener hpF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.eNF)) {
                ba.aVa().a(b.this.dIF, new String[]{b.this.eNF}, true);
                TiebaStatic.log(new an("c13418").dh("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.dIF = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.fax = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.hJq = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.hJr = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.hJs = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.hJt = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.hJu = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.hJv = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.hJw = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.hJq.setPageId(uniqueId);
            this.hJr.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fax.setVisibility(0);
            this.fax.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fax.setVisibility(8);
        this.hJq.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.hJr.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.getChineseAndEnglishLength(str2) > 14) {
            str2 = aq.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.getChineseAndEnglishLength(str3) > 14) {
            str3 = aq.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.hJs.setText(str2);
        this.hJt.setText(str3);
        this.hJu.setText(sportScheduleInfo.match_top_info);
        this.hJv.setText(sportScheduleInfo.match_middle_info);
        this.hJw.setText(sportScheduleInfo.match_bottom_info);
        this.eNF = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.hpF);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setBackgroundResource(this.fax, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setViewTextColor(this.fax, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hJs, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hJt, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hJu, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.hJv, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hJw, (int) R.color.cp_cont_c);
    }
}
