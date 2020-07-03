package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class e extends ad.a {
    public int ahx;
    public TextView dDu;
    public RelativeLayout iFC;
    public View iFD;
    public TbImageView iFE;
    public TextView iFF;
    public TextView iFG;
    public TextView iFH;
    public TextView iFI;
    public View iFv;
    public TextView iFw;
    public View rootView;

    public e(View view) {
        super(view);
        this.ahx = 3;
        this.rootView = null;
        this.iFv = null;
        this.iFw = null;
        this.iFC = null;
        this.iFD = null;
        this.iFE = null;
        this.rootView = view;
        ck(this.rootView);
    }

    private void ck(View view) {
        if (view != null) {
            this.iFv = view.findViewById(R.id.top_divider_line);
            this.iFw = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.iFD = view.findViewById(R.id.divider_line);
            this.iFC = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.iFE = (TbImageView) view.findViewById(R.id.img);
            this.dDu = (TextView) view.findViewById(R.id.title);
            this.iFF = (TextView) view.findViewById(R.id.desc);
            this.iFG = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.iFH = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.iFI = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
