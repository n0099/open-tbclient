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
public class cf extends x.a {
    public TextView aLe;
    public TextView aLf;
    public TextView aLg;
    public TextView aLh;
    public TbImageView aLi;
    public TbImageView aLj;
    public TbImageView aLk;
    public LinearLayout aLl;
    public LinearLayout aLm;
    public LinearLayout bgu;
    public LinearLayout bgv;
    public a bgw;
    public View bgx;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aJG;
        public HeadImageView aLn;
        public UserIconBox aLo;
        public TextView aLp;
        public TextView aLq;
        public TextView aLt;
        public ImageView aLu;
    }

    public cf(View view) {
        super(view);
        this.bgu = (LinearLayout) view.findViewById(n.g.frs_recommend_friend_item_root);
        this.bgv = (LinearLayout) view.findViewById(n.g.frs_recommend_friend_item_top);
        this.bgx = view.findViewById(n.g.line_3);
        this.bgw = new a();
        View findViewById = view.findViewById(n.g.recommend_similar_top);
        this.bgw.aLn = (HeadImageView) findViewById.findViewById(n.g.recommend_new_head);
        this.bgw.aLo = (UserIconBox) findViewById.findViewById(n.g.recommend_new_crown);
        this.bgw.aLp = (TextView) findViewById.findViewById(n.g.recommend_new_user_name);
        this.bgw.aLq = (TextView) findViewById.findViewById(n.g.recommend_new_introduce);
        this.bgw.aJG = (TextView) findViewById.findViewById(n.g.recommond_detail_info_distance);
        this.bgw.aLt = (TextView) findViewById.findViewById(n.g.recommend_new_add_friend);
        this.bgw.aLu = (ImageView) view.findViewById(n.g.recommend_new_user_sex);
        this.aLe = (TextView) view.findViewById(n.g.recommend_similar_bar_names);
        this.aLf = (TextView) view.findViewById(n.g.recommend_similar_bar_desc);
        this.aLi = (TbImageView) view.findViewById(n.g.recommend_similar_pic_one);
        this.aLj = (TbImageView) view.findViewById(n.g.recommend_similar_pic_two);
        this.aLk = (TbImageView) view.findViewById(n.g.recommend_similar_pic_thr);
        this.aLg = (TextView) view.findViewById(n.g.recommend_similar_forum);
        this.aLh = (TextView) view.findViewById(n.g.recommend_similar_common_conern);
        this.aLl = (LinearLayout) view.findViewById(n.g.recommend_similar_forum_container);
        this.aLm = (LinearLayout) view.findViewById(n.g.recommend_similar_commom_conern_container);
    }
}
