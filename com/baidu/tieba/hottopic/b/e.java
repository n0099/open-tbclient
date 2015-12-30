package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends x.a {
    public TextView aOS;
    public int ahf;
    public View bIE;
    public RelativeLayout bIF;
    public TbImageView bIG;
    public TextView bIH;
    public TextView bII;
    public TextView bIJ;
    public TextView bIK;
    public View bIw;
    public TextView bIx;
    public View rootView;

    public e(View view) {
        super(view);
        this.ahf = 3;
        this.rootView = null;
        this.bIw = null;
        this.bIx = null;
        this.bIF = null;
        this.bIE = null;
        this.bIG = null;
        this.rootView = view;
        U(this.rootView);
    }

    private void U(View view) {
        if (view != null) {
            this.bIw = view.findViewById(n.g.top_divider_line);
            this.bIx = (TextView) view.findViewById(n.g.quality_item_theme_title);
            this.bIE = view.findViewById(n.g.divider_line);
            this.bIF = (RelativeLayout) view.findViewById(n.g.quality_thread_view);
            this.bIG = (TbImageView) view.findViewById(n.g.img);
            this.aOS = (TextView) view.findViewById(n.g.title);
            this.bIH = (TextView) view.findViewById(n.g.desc);
            this.bII = (TextView) view.findViewById(n.g.hot_thread_comment).findViewById(n.g.hot_thread_line_tag);
            this.bIJ = (TextView) view.findViewById(n.g.hot_thread_comment).findViewById(n.g.hot_thread_line_praise);
            this.bIK = (TextView) view.findViewById(n.g.hot_thread_comment).findViewById(n.g.hot_thread_line_comment);
        }
    }
}
