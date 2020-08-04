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
    public View iLB;
    public TextView iLC;
    public RelativeLayout iLI;
    public View iLJ;
    public TbImageView iLK;
    public TextView iLL;
    public TextView iLM;
    public TextView iLN;
    public TextView iLO;
    public View rootView;

    public e(View view) {
        super(view);
        this.aho = 3;
        this.rootView = null;
        this.iLB = null;
        this.iLC = null;
        this.iLI = null;
        this.iLJ = null;
        this.iLK = null;
        this.rootView = view;
        cq(this.rootView);
    }

    private void cq(View view) {
        if (view != null) {
            this.iLB = view.findViewById(R.id.top_divider_line);
            this.iLC = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.iLJ = view.findViewById(R.id.divider_line);
            this.iLI = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.iLK = (TbImageView) view.findViewById(R.id.img);
            this.dJr = (TextView) view.findViewById(R.id.title);
            this.iLL = (TextView) view.findViewById(R.id.desc);
            this.iLM = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.iLN = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.iLO = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
