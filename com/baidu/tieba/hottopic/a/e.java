package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class e extends af.a {
    public int ajq;
    public TextView epn;
    public View jKI;
    public TextView jKJ;
    public RelativeLayout jKP;
    public View jKQ;
    public TbImageView jKR;
    public TextView jKS;
    public TextView jKT;
    public TextView jKU;
    public TextView jKV;
    public View rootView;

    public e(View view) {
        super(view);
        this.ajq = 3;
        this.rootView = null;
        this.jKI = null;
        this.jKJ = null;
        this.jKP = null;
        this.jKQ = null;
        this.jKR = null;
        this.rootView = view;
        cK(this.rootView);
    }

    private void cK(View view) {
        if (view != null) {
            this.jKI = view.findViewById(R.id.top_divider_line);
            this.jKJ = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.jKQ = view.findViewById(R.id.divider_line);
            this.jKP = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.jKR = (TbImageView) view.findViewById(R.id.img);
            this.epn = (TextView) view.findViewById(R.id.title);
            this.jKS = (TextView) view.findViewById(R.id.desc);
            this.jKT = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.jKU = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.jKV = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
