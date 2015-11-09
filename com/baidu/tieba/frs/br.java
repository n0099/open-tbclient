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
    public TextView aGH;
    public TextView aGI;
    public TextView aGJ;
    public TextView aGK;
    public TbImageView aGL;
    public TbImageView aGM;
    public TbImageView aGN;
    public LinearLayout aGO;
    public LinearLayout aGP;
    public LinearLayout aWA;
    public a aWB;
    public View aWC;
    public LinearLayout aWz;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aFj;
        public HeadImageView aGQ;
        public UserIconBox aGR;
        public TextView aGS;
        public TextView aGT;
        public TextView aGW;
        public ImageView aGX;
    }

    public br(View view) {
        super(view);
        this.aWz = (LinearLayout) view.findViewById(i.f.frs_recommend_friend_item_root);
        this.aWA = (LinearLayout) view.findViewById(i.f.frs_recommend_friend_item_top);
        this.aWC = view.findViewById(i.f.line_3);
        this.aWB = new a();
        View findViewById = view.findViewById(i.f.recommend_similar_top);
        this.aWB.aGQ = (HeadImageView) findViewById.findViewById(i.f.recommend_new_head);
        this.aWB.aGR = (UserIconBox) findViewById.findViewById(i.f.recommend_new_crown);
        this.aWB.aGS = (TextView) findViewById.findViewById(i.f.recommend_new_user_name);
        this.aWB.aGT = (TextView) findViewById.findViewById(i.f.recommend_new_introduce);
        this.aWB.aFj = (TextView) findViewById.findViewById(i.f.recommond_detail_info_distance);
        this.aWB.aGW = (TextView) findViewById.findViewById(i.f.recommend_new_add_friend);
        this.aWB.aGX = (ImageView) view.findViewById(i.f.recommend_new_user_sex);
        this.aGH = (TextView) view.findViewById(i.f.recommend_similar_bar_names);
        this.aGI = (TextView) view.findViewById(i.f.recommend_similar_bar_desc);
        this.aGL = (TbImageView) view.findViewById(i.f.recommend_similar_pic_one);
        this.aGM = (TbImageView) view.findViewById(i.f.recommend_similar_pic_two);
        this.aGN = (TbImageView) view.findViewById(i.f.recommend_similar_pic_thr);
        this.aGJ = (TextView) view.findViewById(i.f.recommend_similar_forum);
        this.aGK = (TextView) view.findViewById(i.f.recommend_similar_common_conern);
        this.aGO = (LinearLayout) view.findViewById(i.f.recommend_similar_forum_container);
        this.aGP = (LinearLayout) view.findViewById(i.f.recommend_similar_commom_conern_container);
    }
}
