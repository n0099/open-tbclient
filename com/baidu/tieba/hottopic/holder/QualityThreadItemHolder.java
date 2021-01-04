package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class QualityThreadItemHolder extends TypeAdapter.ViewHolder {
    public int akW;
    public TextView eKc;
    public View ksi;
    public TextView ksj;
    public RelativeLayout ksp;
    public View ksq;
    public TbImageView ksr;
    public TextView kss;
    public TextView kst;
    public TextView ksu;
    public TextView ksv;
    public View rootView;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.akW = 3;
        this.rootView = null;
        this.ksi = null;
        this.ksj = null;
        this.ksp = null;
        this.ksq = null;
        this.ksr = null;
        this.rootView = view;
        dl(this.rootView);
    }

    private void dl(View view) {
        if (view != null) {
            this.ksi = view.findViewById(R.id.top_divider_line);
            this.ksj = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.ksq = view.findViewById(R.id.divider_line);
            this.ksp = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.ksr = (TbImageView) view.findViewById(R.id.img);
            this.eKc = (TextView) view.findViewById(R.id.title);
            this.kss = (TextView) view.findViewById(R.id.desc);
            this.kst = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.ksu = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.ksv = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
