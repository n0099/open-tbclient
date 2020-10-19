package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class e extends af.a {
    public int ajp;
    public TextView egP;
    public View jyj;
    public TextView jyk;
    public RelativeLayout jyq;
    public View jyr;
    public TbImageView jys;
    public TextView jyt;
    public TextView jyu;
    public TextView jyv;
    public TextView jyw;
    public View rootView;

    public e(View view) {
        super(view);
        this.ajp = 3;
        this.rootView = null;
        this.jyj = null;
        this.jyk = null;
        this.jyq = null;
        this.jyr = null;
        this.jys = null;
        this.rootView = view;
        cG(this.rootView);
    }

    private void cG(View view) {
        if (view != null) {
            this.jyj = view.findViewById(R.id.top_divider_line);
            this.jyk = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.jyr = view.findViewById(R.id.divider_line);
            this.jyq = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.jys = (TbImageView) view.findViewById(R.id.img);
            this.egP = (TextView) view.findViewById(R.id.title);
            this.jyt = (TextView) view.findViewById(R.id.desc);
            this.jyu = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.jyv = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.jyw = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
