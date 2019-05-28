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
    private String cVm;
    private TextView fJs;
    private TbImageView fJt;
    private TbImageView fJu;
    private TextView fJv;
    private TextView fJw;
    private TextView fJx;
    private TextView fJy;
    private TextView fJz;
    private final View.OnClickListener fra = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ap.isEmpty(b.this.cVm)) {
                ba.aiz().a(b.this.mContext, new String[]{b.this.cVm}, true);
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
            this.fJs = (TextView) view.findViewById(R.id.frs_sports_tab_view);
            this.fJt = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
            this.fJu = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
            this.fJv = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
            this.fJw = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
            this.fJx = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
            this.fJy = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
            this.fJz = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
            this.fJt.setPageId(uniqueId);
            this.fJu.setPageId(uniqueId);
        }
    }

    public void a(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.mRootView.setVisibility(8);
            this.fJs.setVisibility(0);
            this.fJs.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.mRootView.setVisibility(0);
        this.fJs.setVisibility(8);
        this.fJt.startLoad(sportScheduleInfo.home_team_icon, 10, false);
        this.fJu.startLoad(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (ap.nP(str2) > 14) {
            str2 = ap.k(str2, 14, "...");
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (ap.nP(str3) > 14) {
            str3 = ap.k(str3, 14, "...");
        }
        this.fJv.setText(str2);
        this.fJw.setText(str3);
        this.fJx.setText(sportScheduleInfo.match_top_info);
        this.fJy.setText(sportScheduleInfo.match_middle_info);
        this.fJz.setText(sportScheduleInfo.match_bottom_info);
        this.cVm = sportScheduleInfo.msg_url;
        this.mForumId = str;
        this.mRootView.setOnClickListener(this.fra);
    }

    public void onChangeSkinType() {
        al.k(this.mRootView, R.drawable.bg_sports_frs_schedule_card_shape);
        al.k(this.fJs, R.drawable.bg_sports_frs_schedule_card_shape);
        al.j(this.fJs, R.color.cp_cont_b);
        al.j(this.fJv, R.color.cp_cont_b);
        al.j(this.fJw, R.color.cp_cont_b);
        al.j(this.fJx, R.color.cp_cont_c);
        al.j(this.fJy, R.color.cp_cont_b);
        al.j(this.fJz, R.color.cp_cont_c);
    }
}
