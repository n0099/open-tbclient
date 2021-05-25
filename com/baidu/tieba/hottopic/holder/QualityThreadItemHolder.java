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
    public int f16799a;

    /* renamed from: b  reason: collision with root package name */
    public View f16800b;

    /* renamed from: c  reason: collision with root package name */
    public View f16801c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16802d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f16803e;

    /* renamed from: f  reason: collision with root package name */
    public View f16804f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16805g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16806h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16807i;
    public TextView j;
    public TextView k;
    public TextView l;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.f16799a = 3;
        this.f16800b = null;
        this.f16801c = null;
        this.f16802d = null;
        this.f16803e = null;
        this.f16804f = null;
        this.f16805g = null;
        this.f16800b = view;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f16801c = view.findViewById(R.id.top_divider_line);
        this.f16802d = (TextView) view.findViewById(R.id.quality_item_theme_title);
        this.f16804f = view.findViewById(R.id.divider_line);
        this.f16803e = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
        this.f16805g = (TbImageView) view.findViewById(R.id.img);
        this.f16806h = (TextView) view.findViewById(R.id.title);
        this.f16807i = (TextView) view.findViewById(R.id.desc);
        this.j = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
        this.k = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
        this.l = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
    }
}
