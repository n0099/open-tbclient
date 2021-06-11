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
    public ForumEmotionEmptyView f14932a;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.b.b f14933e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.a.a f14934f;

        public a(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar) {
            this.f14933e = bVar;
            this.f14934f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.m0.z.b.b bVar = this.f14933e;
            bVar.c(!bVar.b());
            d.a.n0.m0.z.a.a aVar = this.f14934f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.b.b f14935e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.a.a f14936f;

        public b(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar) {
            this.f14935e = bVar;
            this.f14936f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14935e.c(false);
            this.f14935e.d(0);
            d.a.n0.m0.z.a.a aVar = this.f14936f;
            if (aVar != null) {
                aVar.a(this.f14935e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.b.b f14937e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.m0.z.a.a f14938f;

        public c(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar) {
            this.f14937e = bVar;
            this.f14938f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f14937e.c(false);
            this.f14937e.d(1);
            d.a.n0.m0.z.a.a aVar = this.f14938f;
            if (aVar != null) {
                aVar.a(this.f14937e.a());
            }
        }
    }

    public ForumEmotionEmptyViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.f14932a = (ForumEmotionEmptyView) view;
    }

    public final void b(d.a.n0.m0.z.b.b bVar, d.a.n0.m0.z.a.a aVar) {
        String string;
        ViewGroup filterDropDownView = this.f14932a.getFilterDropDownView();
        if (bVar != null) {
            Resources resources = this.f14932a.getResources();
            TextView filterView = this.f14932a.getFilterView();
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
