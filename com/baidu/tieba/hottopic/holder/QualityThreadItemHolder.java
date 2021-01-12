package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class QualityThreadItemHolder extends TypeAdapter.ViewHolder {
    public int akf;
    public TextView eFr;
    public View knD;
    public TextView knE;
    public RelativeLayout knK;
    public View knL;
    public TbImageView knM;
    public TextView knN;
    public TextView knO;
    public TextView knP;
    public TextView knQ;
    public View rootView;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.akf = 3;
        this.rootView = null;
        this.knD = null;
        this.knE = null;
        this.knK = null;
        this.knL = null;
        this.knM = null;
        this.rootView = view;
        dl(this.rootView);
    }

    private void dl(View view) {
        if (view != null) {
            this.knD = view.findViewById(R.id.top_divider_line);
            this.knE = (TextView) view.findViewById(R.id.quality_item_theme_title);
            this.knL = view.findViewById(R.id.divider_line);
            this.knK = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
            this.knM = (TbImageView) view.findViewById(R.id.img);
            this.eFr = (TextView) view.findViewById(R.id.title);
            this.knN = (TextView) view.findViewById(R.id.desc);
            this.knO = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
            this.knP = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
            this.knQ = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
        }
    }
}
