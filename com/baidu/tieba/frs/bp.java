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
    public TextView aPG;
    public TextView aPH;
    public TextView aPI;
    public TextView aPJ;
    public TbImageView aPK;
    public TbImageView aPL;
    public TbImageView aPM;
    public LinearLayout aPN;
    public LinearLayout aPO;
    public LinearLayout bGc;
    public LinearLayout bGd;
    public a bGe;
    public View bGf;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aOj;
        public HeadImageView aPP;
        public UserIconBox aPQ;
        public TextView aPR;
        public TextView aPS;
        public TextView aPV;
        public ImageView aPW;
    }

    public bp(View view) {
        super(view);
        this.bGc = (LinearLayout) view.findViewById(u.g.frs_recommend_friend_item_root);
        this.bGd = (LinearLayout) view.findViewById(u.g.frs_recommend_friend_item_top);
        this.bGf = view.findViewById(u.g.line_3);
        this.bGe = new a();
        View findViewById = view.findViewById(u.g.recommend_similar_top);
        this.bGe.aPP = (HeadImageView) findViewById.findViewById(u.g.recommend_new_head);
        this.bGe.aPQ = (UserIconBox) findViewById.findViewById(u.g.recommend_new_crown);
        this.bGe.aPR = (TextView) findViewById.findViewById(u.g.recommend_new_user_name);
        this.bGe.aPS = (TextView) findViewById.findViewById(u.g.recommend_new_introduce);
        this.bGe.aOj = (TextView) findViewById.findViewById(u.g.recommond_detail_info_distance);
        this.bGe.aPV = (TextView) findViewById.findViewById(u.g.recommend_new_add_friend);
        this.bGe.aPW = (ImageView) view.findViewById(u.g.recommend_new_user_sex);
        this.aPG = (TextView) view.findViewById(u.g.recommend_similar_bar_names);
        this.aPH = (TextView) view.findViewById(u.g.recommend_similar_bar_desc);
        this.aPK = (TbImageView) view.findViewById(u.g.recommend_similar_pic_one);
        this.aPL = (TbImageView) view.findViewById(u.g.recommend_similar_pic_two);
        this.aPM = (TbImageView) view.findViewById(u.g.recommend_similar_pic_thr);
        this.aPI = (TextView) view.findViewById(u.g.recommend_similar_forum);
        this.aPJ = (TextView) view.findViewById(u.g.recommend_similar_common_conern);
        this.aPN = (LinearLayout) view.findViewById(u.g.recommend_similar_forum_container);
        this.aPO = (LinearLayout) view.findViewById(u.g.recommend_similar_commom_conern_container);
    }
}
