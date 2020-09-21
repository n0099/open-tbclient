package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class e extends af.a {
    public int aiX;
    public TextView dUN;
    public View jjl;
    public TextView jjm;
    public RelativeLayout jjs;
    public View jjt;
    public TbImageView jju;
    public TextView jjv;
    public TextView jjw;
    public TextView jjx;
    public TextView jjy;
    public View rootView;

    public e(View view) {
        super(view);
        this.aiX = 3;
        this.rootView = null;
        this.jjl = null;
        this.jjm = null;
        this.jjs = null;
        this.jjt = null;
        this.jju = null;
        this.rootView = view;
        cC(this.rootView);
    }

    private void cC(View view) {
        if (view != null) {
            this.jjl = view.findViewById(R.id.top_divider_line);
            this.jjm = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.jjt = view.findViewById(R.id.divider_line);
            this.jjs = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.jju = (TbImageView) view.findViewById(R.id.img);
            this.dUN = (TextView) view.findViewById(R.id.title);
            this.jjv = (TextView) view.findViewById(R.id.desc);
            this.jjw = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.jjx = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.jjy = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
