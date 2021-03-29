package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class QualityThreadItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f17594a;

    /* renamed from: b  reason: collision with root package name */
    public View f17595b;

    /* renamed from: c  reason: collision with root package name */
    public View f17596c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17597d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f17598e;

    /* renamed from: f  reason: collision with root package name */
    public View f17599f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17600g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17601h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.f17594a = 3;
        this.f17595b = null;
        this.f17596c = null;
        this.f17597d = null;
        this.f17598e = null;
        this.f17599f = null;
        this.f17600g = null;
        this.f17595b = view;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f17596c = view.findViewById(R.id.top_divider_line);
        this.f17597d = (TextView) view.findViewById(R.id.quality_item_theme_title);
        this.f17599f = view.findViewById(R.id.divider_line);
        this.f17598e = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
        this.f17600g = (TbImageView) view.findViewById(R.id.img);
        this.f17601h = (TextView) view.findViewById(R.id.title);
        this.i = (TextView) view.findViewById(R.id.desc);
        this.j = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
        this.k = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
        this.l = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
    }
}
