package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class e extends af.a {
    public int aiB;
    public TextView dSz;
    public TextView jaA;
    public RelativeLayout jaG;
    public View jaH;
    public TbImageView jaI;
    public TextView jaJ;
    public TextView jaK;
    public TextView jaL;
    public TextView jaM;
    public View jaz;
    public View rootView;

    public e(View view) {
        super(view);
        this.aiB = 3;
        this.rootView = null;
        this.jaz = null;
        this.jaA = null;
        this.jaG = null;
        this.jaH = null;
        this.jaI = null;
        this.rootView = view;
        ct(this.rootView);
    }

    private void ct(View view) {
        if (view != null) {
            this.jaz = view.findViewById(R.id.top_divider_line);
            this.jaA = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.jaH = view.findViewById(R.id.divider_line);
            this.jaG = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.jaI = (TbImageView) view.findViewById(R.id.img);
            this.dSz = (TextView) view.findViewById(R.id.title);
            this.jaJ = (TextView) view.findViewById(R.id.desc);
            this.jaK = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.jaL = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.jaM = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
