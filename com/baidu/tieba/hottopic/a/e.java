package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class e extends af.a {
    public int ajv;
    public TextView etx;
    public TextView jRA;
    public TextView jRB;
    public TextView jRC;
    public TextView jRD;
    public View jRq;
    public TextView jRr;
    public RelativeLayout jRx;
    public View jRy;
    public TbImageView jRz;
    public View rootView;

    public e(View view) {
        super(view);
        this.ajv = 3;
        this.rootView = null;
        this.jRq = null;
        this.jRr = null;
        this.jRx = null;
        this.jRy = null;
        this.jRz = null;
        this.rootView = view;
        cU(this.rootView);
    }

    private void cU(View view) {
        if (view != null) {
            this.jRq = view.findViewById(R.id.top_divider_line);
            this.jRr = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.jRy = view.findViewById(R.id.divider_line);
            this.jRx = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.jRz = (TbImageView) view.findViewById(R.id.img);
            this.etx = (TextView) view.findViewById(R.id.title);
            this.jRA = (TextView) view.findViewById(R.id.desc);
            this.jRB = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.jRC = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.jRD = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
