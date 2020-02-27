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
    private TbPageContext cVg;
    private String dYo;
    private TextView gIZ;
    private TbImageView gJa;
    private TbImageView gJb;
    private TextView gJc;
    private TextView gJd;
    private TextView gJe;
    private TextView gJf;
    private TextView gJg;
    private final View.OnClickListener gqo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.dYo)) {
                ba.aGE().a(b.this.cVg, new String[]{b.this.dYo}, true);
                TiebaStatic.log(new an("c13418").cy("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cVg = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.gIZ = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.gJa = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.gJb = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.gJc = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.gJd = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.gJe = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.gJf = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.gJg = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.gJa.setPageId(uniqueId);
            this.gJb.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.gIZ.setVisibility(0);
            this.gIZ.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.gIZ.setVisibility(8);
        this.gJa.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.gJb.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.getChineseAndEnglishLength(str2) > 14) {
            str2 = aq.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.getChineseAndEnglishLength(str3) > 14) {
            str3 = aq.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.gJc.setText(str2);
        this.gJd.setText(str3);
        this.gJe.setText(sportScheduleInfo.match_top_info);
        this.gJf.setText(sportScheduleInfo.match_middle_info);
        this.gJg.setText(sportScheduleInfo.match_bottom_info);
        this.dYo = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.gqo);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setBackgroundResource(this.gIZ, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setViewTextColor(this.gIZ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJc, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJd, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJe, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.gJf, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJg, (int) R.color.cp_cont_c);
    }
}
