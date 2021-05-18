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
    public int f16889a;

    /* renamed from: b  reason: collision with root package name */
    public View f16890b;

    /* renamed from: c  reason: collision with root package name */
    public View f16891c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16892d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f16893e;

    /* renamed from: f  reason: collision with root package name */
    public View f16894f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16895g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16896h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16897i;
    public TextView j;
    public TextView k;
    public TextView l;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.f16889a = 3;
        this.f16890b = null;
        this.f16891c = null;
        this.f16892d = null;
        this.f16893e = null;
        this.f16894f = null;
        this.f16895g = null;
        this.f16890b = view;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f16891c = view.findViewById(R.id.top_divider_line);
        this.f16892d = (TextView) view.findViewById(R.id.quality_item_theme_title);
        this.f16894f = view.findViewById(R.id.divider_line);
        this.f16893e = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
        this.f16895g = (TbImageView) view.findViewById(R.id.img);
        this.f16896h = (TextView) view.findViewById(R.id.title);
        this.f16897i = (TextView) view.findViewById(R.id.desc);
        this.j = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
        this.k = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
        this.l = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
    }
}
