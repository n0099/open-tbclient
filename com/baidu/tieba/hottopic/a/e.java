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
    public View keW;
    public TextView keX;
    public RelativeLayout kfd;
    public View kfe;
    public TbImageView kff;
    public TextView kfg;
    public TextView kfh;
    public TextView kfi;
    public TextView kfj;
    public View rootView;

    public e(View view) {
        super(view);
        this.aku = 3;
        this.rootView = null;
        this.keW = null;
        this.keX = null;
        this.kfd = null;
        this.kfe = null;
        this.kff = null;
        this.rootView = view;
        db(this.rootView);
    }

    private void db(View view) {
        if (view != null) {
            this.keW = view.findViewById(R.id.top_divider_line);
            this.keX = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.kfe = view.findViewById(R.id.divider_line);
            this.kfd = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.kff = (TbImageView) view.findViewById(R.id.img);
            this.eAz = (TextView) view.findViewById(R.id.title);
            this.kfg = (TextView) view.findViewById(R.id.desc);
            this.kfh = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.kfi = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.kfj = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
