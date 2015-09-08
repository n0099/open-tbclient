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
public class bh extends x.a {
    public TextView aIK;
    public TextView aIL;
    public TextView aIM;
    public TextView aIN;
    public TbImageView aIO;
    public TbImageView aIP;
    public TbImageView aIQ;
    public LinearLayout aIR;
    public LinearLayout aIS;
    public LinearLayout aWN;
    public LinearLayout aWO;
    public a aWP;
    public View aWQ;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aHl;
        public HeadImageView aIT;
        public UserIconBox aIU;
        public TextView aIV;
        public TextView aIW;
        public TextView aIZ;
        public ImageView aJa;
    }

    public bh(View view) {
        super(view);
        this.aWN = (LinearLayout) view.findViewById(i.f.frs_recommend_friend_item_root);
        this.aWO = (LinearLayout) view.findViewById(i.f.frs_recommend_friend_item_top);
        this.aWQ = view.findViewById(i.f.line_3);
        this.aWP = new a();
        View findViewById = view.findViewById(i.f.recommend_similar_top);
        this.aWP.aIT = (HeadImageView) findViewById.findViewById(i.f.recommend_new_head);
        this.aWP.aIU = (UserIconBox) findViewById.findViewById(i.f.recommend_new_crown);
        this.aWP.aIV = (TextView) findViewById.findViewById(i.f.recommend_new_user_name);
        this.aWP.aIW = (TextView) findViewById.findViewById(i.f.recommend_new_introduce);
        this.aWP.aHl = (TextView) findViewById.findViewById(i.f.recommond_detail_info_distance);
        this.aWP.aIZ = (TextView) findViewById.findViewById(i.f.recommend_new_add_friend);
        this.aWP.aJa = (ImageView) view.findViewById(i.f.recommend_new_user_sex);
        this.aIK = (TextView) view.findViewById(i.f.recommend_similar_bar_names);
        this.aIL = (TextView) view.findViewById(i.f.recommend_similar_bar_desc);
        this.aIO = (TbImageView) view.findViewById(i.f.recommend_similar_pic_one);
        this.aIP = (TbImageView) view.findViewById(i.f.recommend_similar_pic_two);
        this.aIQ = (TbImageView) view.findViewById(i.f.recommend_similar_pic_thr);
        this.aIM = (TextView) view.findViewById(i.f.recommend_similar_forum);
        this.aIN = (TextView) view.findViewById(i.f.recommend_similar_common_conern);
        this.aIR = (LinearLayout) view.findViewById(i.f.recommend_similar_forum_container);
        this.aIS = (LinearLayout) view.findViewById(i.f.recommend_similar_commom_conern_container);
    }
}
