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
public class bl extends y.a {
    public TextView aVJ;
    public TextView aVK;
    public TextView aVL;
    public TextView aVM;
    public TbImageView aVN;
    public TbImageView aVO;
    public TbImageView aVP;
    public LinearLayout aVQ;
    public LinearLayout aVR;
    public LinearLayout bRd;
    public LinearLayout bRe;
    public a bRf;
    public View bRg;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aUn;
        public HeadImageView aVS;
        public UserIconBox aVT;
        public TextView aVU;
        public TextView aVV;
        public TextView aVY;
        public ImageView aVZ;
    }

    public bl(View view) {
        super(view);
        this.bRd = (LinearLayout) view.findViewById(r.g.frs_recommend_friend_item_root);
        this.bRe = (LinearLayout) view.findViewById(r.g.frs_recommend_friend_item_top);
        this.bRg = view.findViewById(r.g.line_3);
        this.bRf = new a();
        View findViewById = view.findViewById(r.g.recommend_similar_top);
        this.bRf.aVS = (HeadImageView) findViewById.findViewById(r.g.recommend_new_head);
        this.bRf.aVT = (UserIconBox) findViewById.findViewById(r.g.recommend_new_crown);
        this.bRf.aVU = (TextView) findViewById.findViewById(r.g.recommend_new_user_name);
        this.bRf.aVV = (TextView) findViewById.findViewById(r.g.recommend_new_introduce);
        this.bRf.aUn = (TextView) findViewById.findViewById(r.g.recommond_detail_info_distance);
        this.bRf.aVY = (TextView) findViewById.findViewById(r.g.recommend_new_add_friend);
        this.bRf.aVZ = (ImageView) view.findViewById(r.g.recommend_new_user_sex);
        this.aVJ = (TextView) view.findViewById(r.g.recommend_similar_bar_names);
        this.aVK = (TextView) view.findViewById(r.g.recommend_similar_bar_desc);
        this.aVN = (TbImageView) view.findViewById(r.g.recommend_similar_pic_one);
        this.aVO = (TbImageView) view.findViewById(r.g.recommend_similar_pic_two);
        this.aVP = (TbImageView) view.findViewById(r.g.recommend_similar_pic_thr);
        this.aVL = (TextView) view.findViewById(r.g.recommend_similar_forum);
        this.aVM = (TextView) view.findViewById(r.g.recommend_similar_common_conern);
        this.aVQ = (LinearLayout) view.findViewById(r.g.recommend_similar_forum_container);
        this.aVR = (LinearLayout) view.findViewById(r.g.recommend_similar_commom_conern_container);
    }
}
