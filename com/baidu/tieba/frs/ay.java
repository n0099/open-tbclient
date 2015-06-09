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
    TextView aBc;
    TextView aBd;
    TextView aBe;
    TextView aBf;
    TbImageView aBg;
    TbImageView aBh;
    TbImageView aBi;
    LinearLayout aBj;
    LinearLayout aBk;
    LinearLayout aNb;
    LinearLayout aNc;
    az aNd;
    View aNe;

    public ay(View view) {
        super(view);
        this.aNb = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_recommend_friend_item_root);
        this.aNc = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_recommend_friend_item_top);
        this.aNe = view.findViewById(com.baidu.tieba.q.line_3);
        this.aNd = new az();
        View findViewById = view.findViewById(com.baidu.tieba.q.recommend_similar_top);
        this.aNd.aBl = (HeadImageView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_head);
        this.aNd.aBm = (UserIconBox) findViewById.findViewById(com.baidu.tieba.q.recommend_new_crown);
        this.aNd.aBn = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_user_name);
        this.aNd.aBo = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_introduce);
        this.aNd.azF = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommond_detail_info_distance);
        this.aNd.aBr = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_add_friend);
        this.aNd.aBs = (ImageView) view.findViewById(com.baidu.tieba.q.recommend_new_user_sex);
        this.aBc = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_bar_names);
        this.aBd = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_bar_desc);
        this.aBg = (TbImageView) view.findViewById(com.baidu.tieba.q.recommend_similar_pic_one);
        this.aBh = (TbImageView) view.findViewById(com.baidu.tieba.q.recommend_similar_pic_two);
        this.aBi = (TbImageView) view.findViewById(com.baidu.tieba.q.recommend_similar_pic_thr);
        this.aBe = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_forum);
        this.aBf = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_common_conern);
        this.aBj = (LinearLayout) view.findViewById(com.baidu.tieba.q.recommend_similar_forum_container);
        this.aBk = (LinearLayout) view.findViewById(com.baidu.tieba.q.recommend_similar_commom_conern_container);
    }
}
