package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class QualityThreadItemHolder extends TypeAdapter.ViewHolder {
    public int aln;
    public TextView eIY;
    public View kya;
    public TextView kyb;
    public RelativeLayout kyh;
    public View kyi;
    public TbImageView kyj;
    public TextView kyk;
    public TextView kyl;
    public TextView kym;
    public TextView kyn;
    public View rootView;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.aln = 3;
        this.rootView = null;
        this.kya = null;
        this.kyb = null;
        this.kyh = null;
        this.kyi = null;
        this.kyj = null;
        this.rootView = view;
        dj(this.rootView);
    }

    private void dj(View view) {
        if (view != null) {
            this.kya = view.findViewById(R.id.top_divider_line);
            this.kyb = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.kyi = view.findViewById(R.id.divider_line);
            this.kyh = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.kyj = (TbImageView) view.findViewById(R.id.img);
            this.eIY = (TextView) view.findViewById(R.id.title);
            this.kyk = (TextView) view.findViewById(R.id.desc);
            this.kyl = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.kym = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.kyn = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
