package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class co extends x.a {
    public TextView aPe;
    public TextView aPf;
    public TextView aPg;
    public TextView aPh;
    public TbImageView aPi;
    public TbImageView aPj;
    public TbImageView aPk;
    public LinearLayout aPl;
    public LinearLayout aPm;
    public LinearLayout bnP;
    public LinearLayout bnQ;
    public a bnR;
    public View bnS;

    /* loaded from: classes.dex */
    public static class a {
        public TextView aNH;
        public HeadImageView aPn;
        public UserIconBox aPo;
        public TextView aPp;
        public TextView aPq;
        public TextView aPt;
        public ImageView aPu;
    }

    public co(View view) {
        super(view);
        this.bnP = (LinearLayout) view.findViewById(t.g.frs_recommend_friend_item_root);
        this.bnQ = (LinearLayout) view.findViewById(t.g.frs_recommend_friend_item_top);
        this.bnS = view.findViewById(t.g.line_3);
        this.bnR = new a();
        View findViewById = view.findViewById(t.g.recommend_similar_top);
        this.bnR.aPn = (HeadImageView) findViewById.findViewById(t.g.recommend_new_head);
        this.bnR.aPo = (UserIconBox) findViewById.findViewById(t.g.recommend_new_crown);
        this.bnR.aPp = (TextView) findViewById.findViewById(t.g.recommend_new_user_name);
        this.bnR.aPq = (TextView) findViewById.findViewById(t.g.recommend_new_introduce);
        this.bnR.aNH = (TextView) findViewById.findViewById(t.g.recommond_detail_info_distance);
        this.bnR.aPt = (TextView) findViewById.findViewById(t.g.recommend_new_add_friend);
        this.bnR.aPu = (ImageView) view.findViewById(t.g.recommend_new_user_sex);
        this.aPe = (TextView) view.findViewById(t.g.recommend_similar_bar_names);
        this.aPf = (TextView) view.findViewById(t.g.recommend_similar_bar_desc);
        this.aPi = (TbImageView) view.findViewById(t.g.recommend_similar_pic_one);
        this.aPj = (TbImageView) view.findViewById(t.g.recommend_similar_pic_two);
        this.aPk = (TbImageView) view.findViewById(t.g.recommend_similar_pic_thr);
        this.aPg = (TextView) view.findViewById(t.g.recommend_similar_forum);
        this.aPh = (TextView) view.findViewById(t.g.recommend_similar_common_conern);
        this.aPl = (LinearLayout) view.findViewById(t.g.recommend_similar_forum_container);
        this.aPm = (LinearLayout) view.findViewById(t.g.recommend_similar_commom_conern_container);
    }
}
