package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends x.a {
    public TextView aNy;
    public int afY;
    public View bES;
    public TextView bET;
    public View bEY;
    public RelativeLayout bEZ;
    public TbImageView bFa;
    public TextView bFb;
    public TextView bFc;
    public TextView bFd;
    public TextView bFe;
    public View rootView;

    public e(View view) {
        super(view);
        this.afY = 3;
        this.rootView = null;
        this.bES = null;
        this.bET = null;
        this.bEZ = null;
        this.bEY = null;
        this.bFa = null;
        this.rootView = view;
        P(this.rootView);
    }

    private void P(View view) {
        if (view != null) {
            this.bES = view.findViewById(n.f.top_divider_line);
            this.bET = (TextView) view.findViewById(n.f.quality_item_theme_title);
            this.bEY = view.findViewById(n.f.divider_line);
            this.bEZ = (RelativeLayout) view.findViewById(n.f.quality_thread_view);
            this.bFa = (TbImageView) view.findViewById(n.f.img);
            this.aNy = (TextView) view.findViewById(n.f.title);
            this.bFb = (TextView) view.findViewById(n.f.desc);
            this.bFc = (TextView) view.findViewById(n.f.hot_thread_comment).findViewById(n.f.hot_thread_line_tag);
            this.bFd = (TextView) view.findViewById(n.f.hot_thread_comment).findViewById(n.f.hot_thread_line_praise);
            this.bFe = (TextView) view.findViewById(n.f.hot_thread_comment).findViewById(n.f.hot_thread_line_comment);
        }
    }
}
