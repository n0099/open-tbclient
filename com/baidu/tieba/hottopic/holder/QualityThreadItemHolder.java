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
    public int f16957a;

    /* renamed from: b  reason: collision with root package name */
    public View f16958b;

    /* renamed from: c  reason: collision with root package name */
    public View f16959c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16960d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f16961e;

    /* renamed from: f  reason: collision with root package name */
    public View f16962f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16963g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16964h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16965i;
    public TextView j;
    public TextView k;
    public TextView l;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.f16957a = 3;
        this.f16958b = null;
        this.f16959c = null;
        this.f16960d = null;
        this.f16961e = null;
        this.f16962f = null;
        this.f16963g = null;
        this.f16958b = view;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f16959c = view.findViewById(R.id.top_divider_line);
        this.f16960d = (TextView) view.findViewById(R.id.quality_item_theme_title);
        this.f16962f = view.findViewById(R.id.divider_line);
        this.f16961e = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
        this.f16963g = (TbImageView) view.findViewById(R.id.img);
        this.f16964h = (TextView) view.findViewById(R.id.title);
        this.f16965i = (TextView) view.findViewById(R.id.desc);
        this.j = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
        this.k = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
        this.l = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
    }
}
