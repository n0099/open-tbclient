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
    private TbPageContext cVh;
    private String dYp;
    private TextView gJb;
    private TbImageView gJc;
    private TbImageView gJd;
    private TextView gJe;
    private TextView gJf;
    private TextView gJg;
    private TextView gJh;
    private TextView gJi;
    private final View.OnClickListener gqq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!aq.isEmpty(b.this.dYp)) {
                ba.aGG().a(b.this.cVh, new String[]{b.this.dYp}, true);
                TiebaStatic.log(new an("c13418").cy("fid", b.this.mForumId));
            }
        }
    };
    private String mForumId;
    private View mRootView;

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cVh = frsSportsRecommendFragment.getPageContext();
            BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
            this.mRootView = view.findViewById(R.id.frs_sports_schedule_card_layout);
            this.gJb = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.gJc = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.gJd = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.gJe = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.gJf = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.gJg = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.gJh = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.gJi = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.gJc.setPageId(uniqueId);
            this.gJd.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.gJb.setVisibility(0);
            this.gJb.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.gJb.setVisibility(8);
        this.gJc.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.gJd.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (aq.getChineseAndEnglishLength(str2) > 14) {
            str2 = aq.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (aq.getChineseAndEnglishLength(str3) > 14) {
            str3 = aq.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.gJe.setText(str2);
        this.gJf.setText(str3);
        this.gJg.setText(sportScheduleInfo.match_top_info);
        this.gJh.setText(sportScheduleInfo.match_middle_info);
        this.gJi.setText(sportScheduleInfo.match_bottom_info);
        this.dYp = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.gqq);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setBackgroundResource(this.gJb, R.drawable.bg_sports_frs_schedule_card_shape);
        am.setViewTextColor(this.gJb, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJe, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJf, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJg, (int) R.color.cp_cont_c);
        am.setViewTextColor(this.gJh, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJi, (int) R.color.cp_cont_c);
    }
}
