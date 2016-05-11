package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cl extends y.a {
    public TextView aLo;
    public TextView aLp;
    public TextView aLq;
    public TextView aLr;
    public TbImageView aLs;
    public TbImageView aLt;
    public TbImageView aLu;
    public LinearLayout aLv;
    public LinearLayout aLw;
    public LinearLayout bjj;
    public LinearLayout bjk;
    public a bjl;
    public View bjm;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aJR;
        public TextView aLA;
        public TextView aLD;
        public ImageView aLE;
        public HeadImageView aLx;
        public UserIconBox aLy;
        public TextView aLz;
    }

    public cl(View view) {
        super(view);
        this.bjj = (LinearLayout) view.findViewById(t.g.frs_recommend_friend_item_root);
        this.bjk = (LinearLayout) view.findViewById(t.g.frs_recommend_friend_item_top);
        this.bjm = view.findViewById(t.g.line_3);
        this.bjl = new a();
        View findViewById = view.findViewById(t.g.recommend_similar_top);
        this.bjl.aLx = (HeadImageView) findViewById.findViewById(t.g.recommend_new_head);
        this.bjl.aLy = (UserIconBox) findViewById.findViewById(t.g.recommend_new_crown);
        this.bjl.aLz = (TextView) findViewById.findViewById(t.g.recommend_new_user_name);
        this.bjl.aLA = (TextView) findViewById.findViewById(t.g.recommend_new_introduce);
        this.bjl.aJR = (TextView) findViewById.findViewById(t.g.recommond_detail_info_distance);
        this.bjl.aLD = (TextView) findViewById.findViewById(t.g.recommend_new_add_friend);
        this.bjl.aLE = (ImageView) view.findViewById(t.g.recommend_new_user_sex);
        this.aLo = (TextView) view.findViewById(t.g.recommend_similar_bar_names);
        this.aLp = (TextView) view.findViewById(t.g.recommend_similar_bar_desc);
        this.aLs = (TbImageView) view.findViewById(t.g.recommend_similar_pic_one);
        this.aLt = (TbImageView) view.findViewById(t.g.recommend_similar_pic_two);
        this.aLu = (TbImageView) view.findViewById(t.g.recommend_similar_pic_thr);
        this.aLq = (TextView) view.findViewById(t.g.recommend_similar_forum);
        this.aLr = (TextView) view.findViewById(t.g.recommend_similar_common_conern);
        this.aLv = (LinearLayout) view.findViewById(t.g.recommend_similar_forum_container);
        this.aLw = (LinearLayout) view.findViewById(t.g.recommend_similar_commom_conern_container);
    }
}
