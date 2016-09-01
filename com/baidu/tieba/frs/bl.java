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
public class bl extends y.a {
    public TextView aVa;
    public TextView aVb;
    public TextView aVc;
    public TextView aVd;
    public TbImageView aVe;
    public TbImageView aVf;
    public TbImageView aVg;
    public LinearLayout aVh;
    public LinearLayout aVi;
    public LinearLayout bRk;
    public LinearLayout bRl;
    public a bRm;
    public View bRn;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aTD;
        public HeadImageView aVj;
        public UserIconBox aVk;
        public TextView aVl;
        public TextView aVm;
        public TextView aVp;
        public ImageView aVq;
    }

    public bl(View view) {
        super(view);
        this.bRk = (LinearLayout) view.findViewById(t.g.frs_recommend_friend_item_root);
        this.bRl = (LinearLayout) view.findViewById(t.g.frs_recommend_friend_item_top);
        this.bRn = view.findViewById(t.g.line_3);
        this.bRm = new a();
        View findViewById = view.findViewById(t.g.recommend_similar_top);
        this.bRm.aVj = (HeadImageView) findViewById.findViewById(t.g.recommend_new_head);
        this.bRm.aVk = (UserIconBox) findViewById.findViewById(t.g.recommend_new_crown);
        this.bRm.aVl = (TextView) findViewById.findViewById(t.g.recommend_new_user_name);
        this.bRm.aVm = (TextView) findViewById.findViewById(t.g.recommend_new_introduce);
        this.bRm.aTD = (TextView) findViewById.findViewById(t.g.recommond_detail_info_distance);
        this.bRm.aVp = (TextView) findViewById.findViewById(t.g.recommend_new_add_friend);
        this.bRm.aVq = (ImageView) view.findViewById(t.g.recommend_new_user_sex);
        this.aVa = (TextView) view.findViewById(t.g.recommend_similar_bar_names);
        this.aVb = (TextView) view.findViewById(t.g.recommend_similar_bar_desc);
        this.aVe = (TbImageView) view.findViewById(t.g.recommend_similar_pic_one);
        this.aVf = (TbImageView) view.findViewById(t.g.recommend_similar_pic_two);
        this.aVg = (TbImageView) view.findViewById(t.g.recommend_similar_pic_thr);
        this.aVc = (TextView) view.findViewById(t.g.recommend_similar_forum);
        this.aVd = (TextView) view.findViewById(t.g.recommend_similar_common_conern);
        this.aVh = (LinearLayout) view.findViewById(t.g.recommend_similar_forum_container);
        this.aVi = (LinearLayout) view.findViewById(t.g.recommend_similar_commom_conern_container);
    }
}
