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
    public int f16875a;

    /* renamed from: b  reason: collision with root package name */
    public View f16876b;

    /* renamed from: c  reason: collision with root package name */
    public View f16877c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16878d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f16879e;

    /* renamed from: f  reason: collision with root package name */
    public View f16880f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f16881g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16882h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f16883i;
    public TextView j;
    public TextView k;
    public TextView l;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.f16875a = 3;
        this.f16876b = null;
        this.f16877c = null;
        this.f16878d = null;
        this.f16879e = null;
        this.f16880f = null;
        this.f16881g = null;
        this.f16876b = view;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f16877c = view.findViewById(R.id.top_divider_line);
        this.f16878d = (TextView) view.findViewById(R.id.quality_item_theme_title);
        this.f16880f = view.findViewById(R.id.divider_line);
        this.f16879e = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
        this.f16881g = (TbImageView) view.findViewById(R.id.img);
        this.f16882h = (TextView) view.findViewById(R.id.title);
        this.f16883i = (TextView) view.findViewById(R.id.desc);
        this.j = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
        this.k = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
        this.l = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
    }
}
