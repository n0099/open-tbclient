package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.widget.ListView.am {
    LinearLayout aKT;
    LinearLayout aKU;
    az aKV;
    View aKW;
    TextView azq;
    TextView azr;
    TextView azs;
    TextView azt;
    TbImageView azu;
    TbImageView azv;
    TbImageView azw;
    LinearLayout azx;
    LinearLayout azy;

    public ay(View view) {
        super(view);
        this.aKT = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_recommend_friend_item_root);
        this.aKU = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_recommend_friend_item_top);
        this.aKW = view.findViewById(com.baidu.tieba.v.line_3);
        this.aKV = new az();
        View findViewById = view.findViewById(com.baidu.tieba.v.recommend_similar_top);
        this.aKV.azz = (HeadImageView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_head);
        this.aKV.azA = (UserIconBox) findViewById.findViewById(com.baidu.tieba.v.recommend_new_crown);
        this.aKV.azB = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_user_name);
        this.aKV.azC = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_introduce);
        this.aKV.axT = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommond_detail_info_distance);
        this.aKV.azF = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_add_friend);
        this.aKV.azG = (ImageView) view.findViewById(com.baidu.tieba.v.recommend_new_user_sex);
        this.azq = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_bar_names);
        this.azr = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_bar_desc);
        this.azu = (TbImageView) view.findViewById(com.baidu.tieba.v.recommend_similar_pic_one);
        this.azv = (TbImageView) view.findViewById(com.baidu.tieba.v.recommend_similar_pic_two);
        this.azw = (TbImageView) view.findViewById(com.baidu.tieba.v.recommend_similar_pic_thr);
        this.azs = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_forum);
        this.azt = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_common_conern);
        this.azx = (LinearLayout) view.findViewById(com.baidu.tieba.v.recommend_similar_forum_container);
        this.azy = (LinearLayout) view.findViewById(com.baidu.tieba.v.recommend_similar_commom_conern_container);
    }
}
