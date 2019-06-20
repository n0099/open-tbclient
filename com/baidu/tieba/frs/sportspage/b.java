package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.SportScheduleInfo;
/* loaded from: classes4.dex */
public class b {
    private String cVn;
    private TextView fJA;
    private TextView fJB;
    private TextView fJu;
    private TbImageView fJv;
    private TbImageView fJw;
    private TextView fJx;
    private TextView fJy;
    private TextView fJz;
    private final View.OnClickListener fra = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ap.isEmpty(b.this.cVn)) {
                ba.aiz().a(b.this.mContext, new String[]{b.this.cVn}, true);
                TiebaStatic.log(new am("c13418").bT("fid", b.this.mForumId));
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
            this.fJu = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.fJv = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.fJw = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.fJx = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.fJy = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.fJz = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.fJA = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.fJB = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.fJv.setPageId(uniqueId);
            this.fJw.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fJu.setVisibility(0);
            this.fJu.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fJu.setVisibility(8);
        this.fJv.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.fJw.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (ap.nO(str2) > 14) {
            str2 = ap.k(str2, 14, "...");
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (ap.nO(str3) > 14) {
            str3 = ap.k(str3, 14, "...");
        }
        this.fJx.setText(str2);
        this.fJy.setText(str3);
        this.fJz.setText(sportScheduleInfo.match_top_info);
        this.fJA.setText(sportScheduleInfo.match_middle_info);
        this.fJB.setText(sportScheduleInfo.match_bottom_info);
        this.cVn = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.fra);
    }

    public void onChangeSkinType() {
        al.k(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        al.k(this.fJu, R.drawable.bg_sports_frs_schedule_card_shape);
        al.j(this.fJu, R.color.cp_cont_b);
        al.j(this.fJx, R.color.cp_cont_b);
        al.j(this.fJy, R.color.cp_cont_b);
        al.j(this.fJz, R.color.cp_cont_c);
        al.j(this.fJA, R.color.cp_cont_b);
        al.j(this.fJB, R.color.cp_cont_c);
    }
}
