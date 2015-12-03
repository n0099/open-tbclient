package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class cc extends x.a {
    public TextView aJG;
    public TextView aJH;
    public TextView aJI;
    public TextView aJJ;
    public TbImageView aJK;
    public TbImageView aJL;
    public TbImageView aJM;
    public LinearLayout aJN;
    public LinearLayout aJO;
    public LinearLayout bcu;
    public LinearLayout bcv;
    public a bcw;
    public View bcx;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aIi;
        public HeadImageView aJP;
        public UserIconBox aJQ;
        public TextView aJR;
        public TextView aJS;
        public TextView aJV;
        public ImageView aJW;
    }

    public cc(View view) {
        super(view);
        this.bcu = (LinearLayout) view.findViewById(n.f.frs_recommend_friend_item_root);
        this.bcv = (LinearLayout) view.findViewById(n.f.frs_recommend_friend_item_top);
        this.bcx = view.findViewById(n.f.line_3);
        this.bcw = new a();
        View findViewById = view.findViewById(n.f.recommend_similar_top);
        this.bcw.aJP = (HeadImageView) findViewById.findViewById(n.f.recommend_new_head);
        this.bcw.aJQ = (UserIconBox) findViewById.findViewById(n.f.recommend_new_crown);
        this.bcw.aJR = (TextView) findViewById.findViewById(n.f.recommend_new_user_name);
        this.bcw.aJS = (TextView) findViewById.findViewById(n.f.recommend_new_introduce);
        this.bcw.aIi = (TextView) findViewById.findViewById(n.f.recommond_detail_info_distance);
        this.bcw.aJV = (TextView) findViewById.findViewById(n.f.recommend_new_add_friend);
        this.bcw.aJW = (ImageView) view.findViewById(n.f.recommend_new_user_sex);
        this.aJG = (TextView) view.findViewById(n.f.recommend_similar_bar_names);
        this.aJH = (TextView) view.findViewById(n.f.recommend_similar_bar_desc);
        this.aJK = (TbImageView) view.findViewById(n.f.recommend_similar_pic_one);
        this.aJL = (TbImageView) view.findViewById(n.f.recommend_similar_pic_two);
        this.aJM = (TbImageView) view.findViewById(n.f.recommend_similar_pic_thr);
        this.aJI = (TextView) view.findViewById(n.f.recommend_similar_forum);
        this.aJJ = (TextView) view.findViewById(n.f.recommend_similar_common_conern);
        this.aJN = (LinearLayout) view.findViewById(n.f.recommend_similar_forum_container);
        this.aJO = (LinearLayout) view.findViewById(n.f.recommend_similar_commom_conern_container);
    }
}
