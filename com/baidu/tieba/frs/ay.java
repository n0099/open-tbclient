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
    TextView aBb;
    TextView aBc;
    TextView aBd;
    TextView aBe;
    TbImageView aBf;
    TbImageView aBg;
    TbImageView aBh;
    LinearLayout aBi;
    LinearLayout aBj;
    LinearLayout aNa;
    LinearLayout aNb;
    az aNc;
    View aNd;

    public ay(View view) {
        super(view);
        this.aNa = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_recommend_friend_item_root);
        this.aNb = (LinearLayout) view.findViewById(com.baidu.tieba.q.frs_recommend_friend_item_top);
        this.aNd = view.findViewById(com.baidu.tieba.q.line_3);
        this.aNc = new az();
        View findViewById = view.findViewById(com.baidu.tieba.q.recommend_similar_top);
        this.aNc.aBk = (HeadImageView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_head);
        this.aNc.aBl = (UserIconBox) findViewById.findViewById(com.baidu.tieba.q.recommend_new_crown);
        this.aNc.aBm = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_user_name);
        this.aNc.aBn = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_introduce);
        this.aNc.azE = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommond_detail_info_distance);
        this.aNc.aBq = (TextView) findViewById.findViewById(com.baidu.tieba.q.recommend_new_add_friend);
        this.aNc.aBr = (ImageView) view.findViewById(com.baidu.tieba.q.recommend_new_user_sex);
        this.aBb = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_bar_names);
        this.aBc = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_bar_desc);
        this.aBf = (TbImageView) view.findViewById(com.baidu.tieba.q.recommend_similar_pic_one);
        this.aBg = (TbImageView) view.findViewById(com.baidu.tieba.q.recommend_similar_pic_two);
        this.aBh = (TbImageView) view.findViewById(com.baidu.tieba.q.recommend_similar_pic_thr);
        this.aBd = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_forum);
        this.aBe = (TextView) view.findViewById(com.baidu.tieba.q.recommend_similar_common_conern);
        this.aBi = (LinearLayout) view.findViewById(com.baidu.tieba.q.recommend_similar_forum_container);
        this.aBj = (LinearLayout) view.findViewById(com.baidu.tieba.q.recommend_similar_commom_conern_container);
    }
}
