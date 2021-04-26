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
    public int f17574a;

    /* renamed from: b  reason: collision with root package name */
    public View f17575b;

    /* renamed from: c  reason: collision with root package name */
    public View f17576c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17577d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f17578e;

    /* renamed from: f  reason: collision with root package name */
    public View f17579f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f17580g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17581h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17582i;
    public TextView j;
    public TextView k;
    public TextView l;

    public QualityThreadItemHolder(View view) {
        super(view);
        this.f17574a = 3;
        this.f17575b = null;
        this.f17576c = null;
        this.f17577d = null;
        this.f17578e = null;
        this.f17579f = null;
        this.f17580g = null;
        this.f17575b = view;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f17576c = view.findViewById(R.id.top_divider_line);
        this.f17577d = (TextView) view.findViewById(R.id.quality_item_theme_title);
        this.f17579f = view.findViewById(R.id.divider_line);
        this.f17578e = (RelativeLayout) view.findViewById(R.id.quality_thread_view);
        this.f17580g = (TbImageView) view.findViewById(R.id.img);
        this.f17581h = (TextView) view.findViewById(R.id.title);
        this.f17582i = (TextView) view.findViewById(R.id.desc);
        this.j = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_tag);
        this.k = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_praise);
        this.l = (TextView) view.findViewById(R.id.hot_thread_comment).findViewById(R.id.hot_thread_line_comment);
    }
}
