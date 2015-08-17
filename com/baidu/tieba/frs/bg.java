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
public class bg extends x.a {
    public TextView aIA;
    public TbImageView aIB;
    public TbImageView aIC;
    public TbImageView aID;
    public LinearLayout aIE;
    public LinearLayout aIF;
    public TextView aIx;
    public TextView aIy;
    public TextView aIz;
    public LinearLayout aWv;
    public LinearLayout aWw;
    public a aWx;
    public View aWy;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aGY;
        public HeadImageView aIG;
        public UserIconBox aIH;
        public TextView aII;
        public TextView aIJ;
        public TextView aIM;
        public ImageView aIN;
    }

    public bg(View view) {
        super(view);
        this.aWv = (LinearLayout) view.findViewById(i.f.frs_recommend_friend_item_root);
        this.aWw = (LinearLayout) view.findViewById(i.f.frs_recommend_friend_item_top);
        this.aWy = view.findViewById(i.f.line_3);
        this.aWx = new a();
        View findViewById = view.findViewById(i.f.recommend_similar_top);
        this.aWx.aIG = (HeadImageView) findViewById.findViewById(i.f.recommend_new_head);
        this.aWx.aIH = (UserIconBox) findViewById.findViewById(i.f.recommend_new_crown);
        this.aWx.aII = (TextView) findViewById.findViewById(i.f.recommend_new_user_name);
        this.aWx.aIJ = (TextView) findViewById.findViewById(i.f.recommend_new_introduce);
        this.aWx.aGY = (TextView) findViewById.findViewById(i.f.recommond_detail_info_distance);
        this.aWx.aIM = (TextView) findViewById.findViewById(i.f.recommend_new_add_friend);
        this.aWx.aIN = (ImageView) view.findViewById(i.f.recommend_new_user_sex);
        this.aIx = (TextView) view.findViewById(i.f.recommend_similar_bar_names);
        this.aIy = (TextView) view.findViewById(i.f.recommend_similar_bar_desc);
        this.aIB = (TbImageView) view.findViewById(i.f.recommend_similar_pic_one);
        this.aIC = (TbImageView) view.findViewById(i.f.recommend_similar_pic_two);
        this.aID = (TbImageView) view.findViewById(i.f.recommend_similar_pic_thr);
        this.aIz = (TextView) view.findViewById(i.f.recommend_similar_forum);
        this.aIA = (TextView) view.findViewById(i.f.recommend_similar_common_conern);
        this.aIE = (LinearLayout) view.findViewById(i.f.recommend_similar_forum_container);
        this.aIF = (LinearLayout) view.findViewById(i.f.recommend_similar_commom_conern_container);
    }
}
