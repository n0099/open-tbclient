package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class br extends x.a {
    public TextView aHC;
    public TextView aHD;
    public TextView aHE;
    public TextView aHF;
    public TbImageView aHG;
    public TbImageView aHH;
    public TbImageView aHI;
    public LinearLayout aHJ;
    public LinearLayout aHK;
    public LinearLayout aWg;
    public LinearLayout aWh;
    public a aWi;
    public View aWj;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aGe;
        public HeadImageView aHL;
        public UserIconBox aHM;
        public TextView aHN;
        public TextView aHO;
        public TextView aHR;
        public ImageView aHS;
    }

    public br(View view) {
        super(view);
        this.aWg = (LinearLayout) view.findViewById(i.f.frs_recommend_friend_item_root);
        this.aWh = (LinearLayout) view.findViewById(i.f.frs_recommend_friend_item_top);
        this.aWj = view.findViewById(i.f.line_3);
        this.aWi = new a();
        View findViewById = view.findViewById(i.f.recommend_similar_top);
        this.aWi.aHL = (HeadImageView) findViewById.findViewById(i.f.recommend_new_head);
        this.aWi.aHM = (UserIconBox) findViewById.findViewById(i.f.recommend_new_crown);
        this.aWi.aHN = (TextView) findViewById.findViewById(i.f.recommend_new_user_name);
        this.aWi.aHO = (TextView) findViewById.findViewById(i.f.recommend_new_introduce);
        this.aWi.aGe = (TextView) findViewById.findViewById(i.f.recommond_detail_info_distance);
        this.aWi.aHR = (TextView) findViewById.findViewById(i.f.recommend_new_add_friend);
        this.aWi.aHS = (ImageView) view.findViewById(i.f.recommend_new_user_sex);
        this.aHC = (TextView) view.findViewById(i.f.recommend_similar_bar_names);
        this.aHD = (TextView) view.findViewById(i.f.recommend_similar_bar_desc);
        this.aHG = (TbImageView) view.findViewById(i.f.recommend_similar_pic_one);
        this.aHH = (TbImageView) view.findViewById(i.f.recommend_similar_pic_two);
        this.aHI = (TbImageView) view.findViewById(i.f.recommend_similar_pic_thr);
        this.aHE = (TextView) view.findViewById(i.f.recommend_similar_forum);
        this.aHF = (TextView) view.findViewById(i.f.recommend_similar_common_conern);
        this.aHJ = (LinearLayout) view.findViewById(i.f.recommend_similar_forum_container);
        this.aHK = (LinearLayout) view.findViewById(i.f.recommend_similar_commom_conern_container);
    }
}
