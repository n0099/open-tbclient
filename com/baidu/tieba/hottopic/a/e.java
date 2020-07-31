package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class e extends ad.a {
    public int aho;
    public TextView dJr;
    public TextView iLA;
    public RelativeLayout iLG;
    public View iLH;
    public TbImageView iLI;
    public TextView iLJ;
    public TextView iLK;
    public TextView iLL;
    public TextView iLM;
    public View iLz;
    public View rootView;

    public e(View view) {
        super(view);
        this.aho = 3;
        this.rootView = null;
        this.iLz = null;
        this.iLA = null;
        this.iLG = null;
        this.iLH = null;
        this.iLI = null;
        this.rootView = view;
        cq(this.rootView);
    }

    private void cq(View view) {
        if (view != null) {
            this.iLz = view.findViewById(R.id.top_divider_line);
            this.iLA = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.iLH = view.findViewById(R.id.divider_line);
            this.iLG = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.iLI = (TbImageView) view.findViewById(R.id.img);
            this.dJr = (TextView) view.findViewById(R.id.title);
            this.iLJ = (TextView) view.findViewById(R.id.desc);
            this.iLK = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.iLL = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.iLM = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
