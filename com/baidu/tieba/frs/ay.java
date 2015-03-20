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
    LinearLayout aKJ;
    LinearLayout aKK;
    az aKL;
    View aKM;
    TextView azi;
    TextView azj;
    TextView azk;
    TextView azl;
    TbImageView azm;
    TbImageView azn;
    TbImageView azo;
    LinearLayout azp;
    LinearLayout azq;

    public ay(View view) {
        super(view);
        this.aKJ = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_recommend_friend_item_root);
        this.aKK = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_recommend_friend_item_top);
        this.aKM = view.findViewById(com.baidu.tieba.v.line_3);
        this.aKL = new az();
        View findViewById = view.findViewById(com.baidu.tieba.v.recommend_similar_top);
        this.aKL.azr = (HeadImageView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_head);
        this.aKL.azs = (UserIconBox) findViewById.findViewById(com.baidu.tieba.v.recommend_new_crown);
        this.aKL.azt = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_user_name);
        this.aKL.azu = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_introduce);
        this.aKL.axL = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommond_detail_info_distance);
        this.aKL.azx = (TextView) findViewById.findViewById(com.baidu.tieba.v.recommend_new_add_friend);
        this.aKL.azy = (ImageView) view.findViewById(com.baidu.tieba.v.recommend_new_user_sex);
        this.azi = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_bar_names);
        this.azj = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_bar_desc);
        this.azm = (TbImageView) view.findViewById(com.baidu.tieba.v.recommend_similar_pic_one);
        this.azn = (TbImageView) view.findViewById(com.baidu.tieba.v.recommend_similar_pic_two);
        this.azo = (TbImageView) view.findViewById(com.baidu.tieba.v.recommend_similar_pic_thr);
        this.azk = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_forum);
        this.azl = (TextView) view.findViewById(com.baidu.tieba.v.recommend_similar_common_conern);
        this.azp = (LinearLayout) view.findViewById(com.baidu.tieba.v.recommend_similar_forum_container);
        this.azq = (LinearLayout) view.findViewById(com.baidu.tieba.v.recommend_similar_commom_conern_container);
    }
}
