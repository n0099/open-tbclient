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
    public ForumEmotionEmptyView f15492a;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.b.b f15493e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.a.a f15494f;

        public a(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
            this.f15493e = bVar;
            this.f15494f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.l0.z.b.b bVar = this.f15493e;
            bVar.c(!bVar.b());
            d.b.i0.l0.z.a.a aVar = this.f15494f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.b.b f15495e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.a.a f15496f;

        public b(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
            this.f15495e = bVar;
            this.f15496f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15495e.c(false);
            this.f15495e.d(0);
            d.b.i0.l0.z.a.a aVar = this.f15496f;
            if (aVar != null) {
                aVar.a(this.f15495e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.b.b f15497e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.a.a f15498f;

        public c(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
            this.f15497e = bVar;
            this.f15498f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15497e.c(false);
            this.f15497e.d(1);
            d.b.i0.l0.z.a.a aVar = this.f15498f;
            if (aVar != null) {
                aVar.a(this.f15497e.a());
            }
        }
    }

    public ForumEmotionEmptyViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.f15492a = (ForumEmotionEmptyView) view;
    }

    public final void b(d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
        String string;
        ViewGroup filterDropDownView = this.f15492a.getFilterDropDownView();
        if (bVar != null) {
            Resources resources = this.f15492a.getResources();
            TextView filterView = this.f15492a.getFilterView();
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

    public void c(d.b.i0.l0.z.b.a aVar, int i, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar2) {
        b(bVar, aVar2);
    }
}
