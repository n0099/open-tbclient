package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends x.a {
    public TextView aQR;
    public int ahU;
    public View azA;
    public View bMi;
    public TextView bMj;
    public RelativeLayout bMp;
    public View bMq;
    public TbImageView bMr;
    public TextView bMs;
    public TextView bMt;
    public TextView bMu;
    public TextView bMv;

    public g(View view) {
        super(view);
        this.ahU = 3;
        this.azA = null;
        this.bMi = null;
        this.bMj = null;
        this.bMp = null;
        this.bMq = null;
        this.bMr = null;
        this.azA = view;
        ai(this.azA);
    }

    private void ai(View view) {
        if (view != null) {
            this.bMi = view.findViewById(t.g.top_divider_line);
            this.bMj = (TextView) view.findViewById(t.g.quality_item_theme_title);
            this.bMq = view.findViewById(t.g.divider_line);
            this.bMp = (RelativeLayout) view.findViewById(t.g.quality_thread_view);
            this.bMr = (TbImageView) view.findViewById(t.g.img);
            this.aQR = (TextView) view.findViewById(t.g.title);
            this.bMs = (TextView) view.findViewById(t.g.desc);
            this.bMt = (TextView) view.findViewById(t.g.hot_thread_comment).findViewById(t.g.hot_thread_line_tag);
            this.bMu = (TextView) view.findViewById(t.g.hot_thread_comment).findViewById(t.g.hot_thread_line_praise);
            this.bMv = (TextView) view.findViewById(t.g.hot_thread_comment).findViewById(t.g.hot_thread_line_comment);
        }
    }
}
