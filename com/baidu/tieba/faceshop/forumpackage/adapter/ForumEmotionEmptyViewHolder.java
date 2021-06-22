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
    public ForumEmotionEmptyView f15014a;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.m0.z.b.b f15015e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.m0.z.a.a f15016f;

        public a(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.a.o0.m0.z.b.b bVar, d.a.o0.m0.z.a.a aVar) {
            this.f15015e = bVar;
            this.f15016f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.o0.m0.z.b.b bVar = this.f15015e;
            bVar.c(!bVar.b());
            d.a.o0.m0.z.a.a aVar = this.f15016f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.m0.z.b.b f15017e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.m0.z.a.a f15018f;

        public b(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.a.o0.m0.z.b.b bVar, d.a.o0.m0.z.a.a aVar) {
            this.f15017e = bVar;
            this.f15018f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15017e.c(false);
            this.f15017e.d(0);
            d.a.o0.m0.z.a.a aVar = this.f15018f;
            if (aVar != null) {
                aVar.a(this.f15017e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.m0.z.b.b f15019e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.m0.z.a.a f15020f;

        public c(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.a.o0.m0.z.b.b bVar, d.a.o0.m0.z.a.a aVar) {
            this.f15019e = bVar;
            this.f15020f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15019e.c(false);
            this.f15019e.d(1);
            d.a.o0.m0.z.a.a aVar = this.f15020f;
            if (aVar != null) {
                aVar.a(this.f15019e.a());
            }
        }
    }

    public ForumEmotionEmptyViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.f15014a = (ForumEmotionEmptyView) view;
    }

    public final void b(d.a.o0.m0.z.b.b bVar, d.a.o0.m0.z.a.a aVar) {
        String string;
        ViewGroup filterDropDownView = this.f15014a.getFilterDropDownView();
        if (bVar != null) {
            Resources resources = this.f15014a.getResources();
            TextView filterView = this.f15014a.getFilterView();
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

    public void c(d.a.o0.m0.z.b.a aVar, int i2, d.a.o0.m0.z.b.b bVar, d.a.o0.m0.z.a.a aVar2) {
        b(bVar, aVar2);
    }
}
