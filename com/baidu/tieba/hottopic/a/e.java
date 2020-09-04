package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class e extends af.a {
    public int aiD;
    public TextView dSD;
    public View jaF;
    public TextView jaG;
    public RelativeLayout jaM;
    public View jaN;
    public TbImageView jaO;
    public TextView jaP;
    public TextView jaQ;
    public TextView jaR;
    public TextView jaS;
    public View rootView;

    public e(View view) {
        super(view);
        this.aiD = 3;
        this.rootView = null;
        this.jaF = null;
        this.jaG = null;
        this.jaM = null;
        this.jaN = null;
        this.jaO = null;
        this.rootView = view;
        ct(this.rootView);
    }

    private void ct(View view) {
        if (view != null) {
            this.jaF = view.findViewById(R.id.top_divider_line);
            this.jaG = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.jaN = view.findViewById(R.id.divider_line);
            this.jaM = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.jaO = (TbImageView) view.findViewById(R.id.img);
            this.dSD = (TextView) view.findViewById(R.id.title);
            this.jaP = (TextView) view.findViewById(R.id.desc);
            this.jaQ = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.jaR = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.jaS = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
