package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class QualityThreadItemHolder extends TypeAdapter.ViewHolder {
    public int ajU;
    public TextView eHx;
    public View kvY;
    public TextView kvZ;
    public RelativeLayout kwf;
    public View kwg;
    public TbImageView kwh;
    public TextView kwi;
    public TextView kwj;
    public TextView kwk;
    public TextView kwl;
    public View rootView;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.ajU = 3;
        this.rootView = null;
        this.kvY = null;
        this.kvZ = null;
        this.kwf = null;
        this.kwg = null;
        this.kwh = null;
        this.rootView = view;
        dj(this.rootView);
    }

    private void dj(View view) {
        if (view != null) {
            this.kvY = view.findViewById(R.id.top_divider_line);
            this.kvZ = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.kwg = view.findViewById(R.id.divider_line);
            this.kwf = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.kwh = (TbImageView) view.findViewById(R.id.img);
            this.eHx = (TextView) view.findViewById(R.id.title);
            this.kwi = (TextView) view.findViewById(R.id.desc);
            this.kwj = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.kwk = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.kwl = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
