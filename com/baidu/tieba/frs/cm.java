package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cm extends x.a {
    public TextView aMj;
    public TextView aMk;
    public TextView aMl;
    public TextView aMm;
    public TbImageView aMn;
    public TbImageView aMo;
    public TbImageView aMp;
    public LinearLayout aMq;
    public LinearLayout aMr;
    public LinearLayout bje;
    public LinearLayout bjf;
    public a bjg;
    public View bjh;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aKL;
        public HeadImageView aMs;
        public UserIconBox aMt;
        public TextView aMu;
        public TextView aMv;
        public TextView aMy;
        public ImageView aMz;
    }

    public cm(View view) {
        super(view);
        this.bje = (LinearLayout) view.findViewById(t.g.frs_recommend_friend_item_root);
        this.bjf = (LinearLayout) view.findViewById(t.g.frs_recommend_friend_item_top);
        this.bjh = view.findViewById(t.g.line_3);
        this.bjg = new a();
        View findViewById = view.findViewById(t.g.recommend_similar_top);
        this.bjg.aMs = (HeadImageView) findViewById.findViewById(t.g.recommend_new_head);
        this.bjg.aMt = (UserIconBox) findViewById.findViewById(t.g.recommend_new_crown);
        this.bjg.aMu = (TextView) findViewById.findViewById(t.g.recommend_new_user_name);
        this.bjg.aMv = (TextView) findViewById.findViewById(t.g.recommend_new_introduce);
        this.bjg.aKL = (TextView) findViewById.findViewById(t.g.recommond_detail_info_distance);
        this.bjg.aMy = (TextView) findViewById.findViewById(t.g.recommend_new_add_friend);
        this.bjg.aMz = (ImageView) view.findViewById(t.g.recommend_new_user_sex);
        this.aMj = (TextView) view.findViewById(t.g.recommend_similar_bar_names);
        this.aMk = (TextView) view.findViewById(t.g.recommend_similar_bar_desc);
        this.aMn = (TbImageView) view.findViewById(t.g.recommend_similar_pic_one);
        this.aMo = (TbImageView) view.findViewById(t.g.recommend_similar_pic_two);
        this.aMp = (TbImageView) view.findViewById(t.g.recommend_similar_pic_thr);
        this.aMl = (TextView) view.findViewById(t.g.recommend_similar_forum);
        this.aMm = (TextView) view.findViewById(t.g.recommend_similar_common_conern);
        this.aMq = (LinearLayout) view.findViewById(t.g.recommend_similar_forum_container);
        this.aMr = (LinearLayout) view.findViewById(t.g.recommend_similar_commom_conern_container);
    }
}
