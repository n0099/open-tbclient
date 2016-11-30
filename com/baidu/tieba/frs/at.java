package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class at extends y.a {
    public TextView aXV;
    public TextView aXW;
    public TextView aXX;
    public TextView aXY;
    public TbImageView aXZ;
    public TbImageView aYa;
    public TbImageView aYb;
    public LinearLayout aYc;
    public LinearLayout aYd;
    public LinearLayout bTv;
    public LinearLayout bTw;
    public a bTx;
    public View bTy;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aWy;
        public HeadImageView aYe;
        public UserIconBox aYf;
        public TextView aYg;
        public TextView aYh;
        public TextView aYk;
        public ImageView aYl;
    }

    public at(View view) {
        super(view);
        this.bTv = (LinearLayout) view.findViewById(r.g.frs_recommend_friend_item_root);
        this.bTw = (LinearLayout) view.findViewById(r.g.frs_recommend_friend_item_top);
        this.bTy = view.findViewById(r.g.line_3);
        this.bTx = new a();
        View findViewById = view.findViewById(r.g.recommend_similar_top);
        this.bTx.aYe = (HeadImageView) findViewById.findViewById(r.g.recommend_new_head);
        this.bTx.aYf = (UserIconBox) findViewById.findViewById(r.g.recommend_new_crown);
        this.bTx.aYg = (TextView) findViewById.findViewById(r.g.recommend_new_user_name);
        this.bTx.aYh = (TextView) findViewById.findViewById(r.g.recommend_new_introduce);
        this.bTx.aWy = (TextView) findViewById.findViewById(r.g.recommond_detail_info_distance);
        this.bTx.aYk = (TextView) findViewById.findViewById(r.g.recommend_new_add_friend);
        this.bTx.aYl = (ImageView) view.findViewById(r.g.recommend_new_user_sex);
        this.aXV = (TextView) view.findViewById(r.g.recommend_similar_bar_names);
        this.aXW = (TextView) view.findViewById(r.g.recommend_similar_bar_desc);
        this.aXZ = (TbImageView) view.findViewById(r.g.recommend_similar_pic_one);
        this.aYa = (TbImageView) view.findViewById(r.g.recommend_similar_pic_two);
        this.aYb = (TbImageView) view.findViewById(r.g.recommend_similar_pic_thr);
        this.aXX = (TextView) view.findViewById(r.g.recommend_similar_forum);
        this.aXY = (TextView) view.findViewById(r.g.recommend_similar_common_conern);
        this.aYc = (LinearLayout) view.findViewById(r.g.recommend_similar_forum_container);
        this.aYd = (LinearLayout) view.findViewById(r.g.recommend_similar_commom_conern_container);
    }
}
