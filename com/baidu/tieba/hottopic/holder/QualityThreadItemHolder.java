package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class QualityThreadItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f17271a;

    /* renamed from: b  reason: collision with root package name */
    public View f17272b;

    /* renamed from: c  reason: collision with root package name */
    public View f17273c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17274d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f17275e;

    /* renamed from: f  reason: collision with root package name */
    public View f17276f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17277g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17278h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.f17271a = 3;
        this.f17272b = null;
        this.f17273c = null;
        this.f17274d = null;
        this.f17275e = null;
        this.f17276f = null;
        this.f17277g = null;
        this.f17272b = view;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f17273c = view.findViewById(R.id.top_divider_line);
        this.f17274d = (TextView) view.findViewById(R.id.quality_item_theme_title);
        this.f17276f = view.findViewById(R.id.divider_line);
        this.f17275e = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
        this.f17277g = (TbImageView) view.findViewById(R.id.img);
        this.f17278h = (TextView) view.findViewById(R.id.title);
        this.i = (TextView) view.findViewById(R.id.desc);
        this.j = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
        this.k = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
        this.l = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
    }
}
