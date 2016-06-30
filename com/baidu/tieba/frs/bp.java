package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bp extends y.a {
    public TextView aOM;
    public TextView aON;
    public TextView aOO;
    public TextView aOP;
    public TbImageView aOQ;
    public TbImageView aOR;
    public TbImageView aOS;
    public LinearLayout aOT;
    public LinearLayout aOU;
    public LinearLayout bEO;
    public LinearLayout bEP;
    public a bEQ;
    public View bER;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aNp;
        public HeadImageView aOV;
        public UserIconBox aOW;
        public TextView aOX;
        public TextView aOY;
        public TextView aPb;
        public ImageView aPc;
    }

    public bp(View view) {
        super(view);
        this.bEO = (LinearLayout) view.findViewById(u.g.frs_recommend_friend_item_root);
        this.bEP = (LinearLayout) view.findViewById(u.g.frs_recommend_friend_item_top);
        this.bER = view.findViewById(u.g.line_3);
        this.bEQ = new a();
        View findViewById = view.findViewById(u.g.recommend_similar_top);
        this.bEQ.aOV = (HeadImageView) findViewById.findViewById(u.g.recommend_new_head);
        this.bEQ.aOW = (UserIconBox) findViewById.findViewById(u.g.recommend_new_crown);
        this.bEQ.aOX = (TextView) findViewById.findViewById(u.g.recommend_new_user_name);
        this.bEQ.aOY = (TextView) findViewById.findViewById(u.g.recommend_new_introduce);
        this.bEQ.aNp = (TextView) findViewById.findViewById(u.g.recommond_detail_info_distance);
        this.bEQ.aPb = (TextView) findViewById.findViewById(u.g.recommend_new_add_friend);
        this.bEQ.aPc = (ImageView) view.findViewById(u.g.recommend_new_user_sex);
        this.aOM = (TextView) view.findViewById(u.g.recommend_similar_bar_names);
        this.aON = (TextView) view.findViewById(u.g.recommend_similar_bar_desc);
        this.aOQ = (TbImageView) view.findViewById(u.g.recommend_similar_pic_one);
        this.aOR = (TbImageView) view.findViewById(u.g.recommend_similar_pic_two);
        this.aOS = (TbImageView) view.findViewById(u.g.recommend_similar_pic_thr);
        this.aOO = (TextView) view.findViewById(u.g.recommend_similar_forum);
        this.aOP = (TextView) view.findViewById(u.g.recommend_similar_common_conern);
        this.aOT = (LinearLayout) view.findViewById(u.g.recommend_similar_forum_container);
        this.aOU = (LinearLayout) view.findViewById(u.g.recommend_similar_commom_conern_container);
    }
}
