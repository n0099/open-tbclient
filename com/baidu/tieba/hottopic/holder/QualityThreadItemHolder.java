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
    public View kvK;
    public TextView kvL;
    public RelativeLayout kvR;
    public View kvS;
    public TbImageView kvT;
    public TextView kvU;
    public TextView kvV;
    public TextView kvW;
    public TextView kvX;
    public View rootView;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.ajU = 3;
        this.rootView = null;
        this.kvK = null;
        this.kvL = null;
        this.kvR = null;
        this.kvS = null;
        this.kvT = null;
        this.rootView = view;
        dj(this.rootView);
    }

    private void dj(View view) {
        if (view != null) {
            this.kvK = view.findViewById(R.id.top_divider_line);
            this.kvL = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.kvS = view.findViewById(R.id.divider_line);
            this.kvR = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.kvT = (TbImageView) view.findViewById(R.id.img);
            this.eHx = (TextView) view.findViewById(R.id.title);
            this.kvU = (TextView) view.findViewById(R.id.desc);
            this.kvV = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.kvW = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.kvX = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
