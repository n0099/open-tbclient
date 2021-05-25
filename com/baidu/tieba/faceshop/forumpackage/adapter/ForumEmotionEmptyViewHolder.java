package com.baidu.tieba.faceshop.forumpackage.adapter;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionEmptyView;
/* loaded from: classes4.dex */
public class ForumEmotionEmptyViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public ForumEmotionEmptyView f14875a;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.b.b f14876e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.a.a f14877f;

        public a(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar) {
            this.f14876e = bVar;
            this.f14877f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.m0.z.b.b bVar = this.f14876e;
            bVar.c(!bVar.b());
            d.a.n0.m0.z.a.a aVar = this.f14877f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.b.b f14878e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.a.a f14879f;

        public b(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar) {
            this.f14878e = bVar;
            this.f14879f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14878e.c(false);
            this.f14878e.d(0);
            d.a.n0.m0.z.a.a aVar = this.f14879f;
            if (aVar != null) {
                aVar.a(this.f14878e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.b.b f14880e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.a.a f14881f;

        public c(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar) {
            this.f14880e = bVar;
            this.f14881f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14880e.c(false);
            this.f14880e.d(1);
            d.a.n0.m0.z.a.a aVar = this.f14881f;
            if (aVar != null) {
                aVar.a(this.f14880e.a());
            }
        }
    }

    public ForumEmotionEmptyViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.f14875a = (ForumEmotionEmptyView) view;
    }

    public final void b(d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar) {
        String string;
        ViewGroup filterDropDownView = this.f14875a.getFilterDropDownView();
        if (bVar != null) {
            Resources resources = this.f14875a.getResources();
            TextView filterView = this.f14875a.getFilterView();
            filterDropDownView.setVisibility(0);
            if (bVar.a() == 0) {
                string = resources.getString(R.string.forum_emotion_filter_all_bar);
            } else {
                string = resources.getString(R.string.forum_emotion_filter_my_bar);
            }
            filterView.setText(string);
            if (bVar.b()) {
                filterDropDownView.setVisibility(0);
            } else {
                filterDropDownView.setVisibility(8);
            }
            filterView.setOnClickListener(new a(this, bVar, aVar));
            if (filterDropDownView.getChildCount() >= 2) {
                filterDropDownView.getChildAt(0).setOnClickListener(new b(this, bVar, aVar));
                filterDropDownView.getChildAt(1).setOnClickListener(new c(this, bVar, aVar));
            }
        }
    }

    public void c(d.a.n0.m0.z.b.a aVar, int i2, d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar2) {
        b(bVar, aVar2);
    }
}
