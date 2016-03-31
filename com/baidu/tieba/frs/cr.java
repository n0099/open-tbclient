package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cr extends x.a {
    public TbImageView bof;
    public TextView bog;
    public TbImageView boh;
    public TextView boi;
    public TextView boj;
    public TextView bok;
    public ViewStub bol;
    public ViewStub bom;
    public TextView bon;
    public VerticalScrollNumberView boo;
    public FrsLotteryCountDownView bop;
    public RelativeLayout boq;
    public RelativeLayout bor;
    public int mSkinType;

    public cr(View view) {
        super(view);
        this.mSkinType = 3;
        this.boo = null;
        this.bop = null;
        this.bor = (RelativeLayout) view.findViewById(t.g.frs_list_item_top_linear_layout);
        this.bof = (TbImageView) view.findViewById(t.g.lottery_banner);
        this.bof.setScaleType(ImageView.ScaleType.FIT_XY);
        this.bog = (TextView) view.findViewById(t.g.lottery_title);
        this.boh = (TbImageView) view.findViewById(t.g.lottery_page);
        this.boi = (TextView) view.findViewById(t.g.lottery_description);
        this.boj = (TextView) view.findViewById(t.g.lottery_status_txt);
        this.bok = (TextView) view.findViewById(t.g.frs_reply_num);
        this.bol = (ViewStub) view.findViewById(t.g.view_count_down);
        this.bom = (ViewStub) view.findViewById(t.g.view_join_num);
        this.bon = (TextView) view.findViewById(t.g.lottery_click);
        this.boq = (RelativeLayout) view.findViewById(t.g.lottery_info_container);
    }
}
