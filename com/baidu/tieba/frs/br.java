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
public class br extends x.a {
    public TextView aHN;
    public TextView aHO;
    public TextView aHP;
    public TextView aHQ;
    public TbImageView aHR;
    public TbImageView aHS;
    public TbImageView aHT;
    public LinearLayout aHU;
    public LinearLayout aHV;
    public LinearLayout aWr;
    public LinearLayout aWs;
    public a aWt;
    public View aWu;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aGp;
        public HeadImageView aHW;
        public UserIconBox aHX;
        public TextView aHY;
        public TextView aHZ;
        public TextView aIc;
        public ImageView aId;
    }

    public br(View view) {
        super(view);
        this.aWr = (LinearLayout) view.findViewById(i.f.frs_recommend_friend_item_root);
        this.aWs = (LinearLayout) view.findViewById(i.f.frs_recommend_friend_item_top);
        this.aWu = view.findViewById(i.f.line_3);
        this.aWt = new a();
        View findViewById = view.findViewById(i.f.recommend_similar_top);
        this.aWt.aHW = (HeadImageView) findViewById.findViewById(i.f.recommend_new_head);
        this.aWt.aHX = (UserIconBox) findViewById.findViewById(i.f.recommend_new_crown);
        this.aWt.aHY = (TextView) findViewById.findViewById(i.f.recommend_new_user_name);
        this.aWt.aHZ = (TextView) findViewById.findViewById(i.f.recommend_new_introduce);
        this.aWt.aGp = (TextView) findViewById.findViewById(i.f.recommond_detail_info_distance);
        this.aWt.aIc = (TextView) findViewById.findViewById(i.f.recommend_new_add_friend);
        this.aWt.aId = (ImageView) view.findViewById(i.f.recommend_new_user_sex);
        this.aHN = (TextView) view.findViewById(i.f.recommend_similar_bar_names);
        this.aHO = (TextView) view.findViewById(i.f.recommend_similar_bar_desc);
        this.aHR = (TbImageView) view.findViewById(i.f.recommend_similar_pic_one);
        this.aHS = (TbImageView) view.findViewById(i.f.recommend_similar_pic_two);
        this.aHT = (TbImageView) view.findViewById(i.f.recommend_similar_pic_thr);
        this.aHP = (TextView) view.findViewById(i.f.recommend_similar_forum);
        this.aHQ = (TextView) view.findViewById(i.f.recommend_similar_common_conern);
        this.aHU = (LinearLayout) view.findViewById(i.f.recommend_similar_forum_container);
        this.aHV = (LinearLayout) view.findViewById(i.f.recommend_similar_commom_conern_container);
    }
}
