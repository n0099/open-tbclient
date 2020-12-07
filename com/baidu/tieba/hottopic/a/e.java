package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class e extends af.a {
    public int aku;
    public TextView eAz;
    public View keU;
    public TextView keV;
    public RelativeLayout kfb;
    public View kfc;
    public TbImageView kfd;
    public TextView kfe;
    public TextView kff;
    public TextView kfg;
    public TextView kfh;
    public View rootView;

    public e(View view) {
        super(view);
        this.aku = 3;
        this.rootView = null;
        this.keU = null;
        this.keV = null;
        this.kfb = null;
        this.kfc = null;
        this.kfd = null;
        this.rootView = view;
        db(this.rootView);
    }

    private void db(View view) {
        if (view != null) {
            this.keU = view.findViewById(R.id.top_divider_line);
            this.keV = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.kfc = view.findViewById(R.id.divider_line);
            this.kfb = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.kfd = (TbImageView) view.findViewById(R.id.img);
            this.eAz = (TextView) view.findViewById(R.id.title);
            this.kfe = (TextView) view.findViewById(R.id.desc);
            this.kff = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.kfg = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.kfh = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
