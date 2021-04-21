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
    public ForumEmotionEmptyView f15500a;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.l0.z.b.b f15501e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.l0.z.a.a f15502f;

        public a(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.b.j0.l0.z.b.b bVar, d.b.j0.l0.z.a.a aVar) {
            this.f15501e = bVar;
            this.f15502f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.j0.l0.z.b.b bVar = this.f15501e;
            bVar.c(!bVar.b());
            d.b.j0.l0.z.a.a aVar = this.f15502f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.l0.z.b.b f15503e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.l0.z.a.a f15504f;

        public b(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.b.j0.l0.z.b.b bVar, d.b.j0.l0.z.a.a aVar) {
            this.f15503e = bVar;
            this.f15504f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15503e.c(false);
            this.f15503e.d(0);
            d.b.j0.l0.z.a.a aVar = this.f15504f;
            if (aVar != null) {
                aVar.a(this.f15503e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.l0.z.b.b f15505e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.l0.z.a.a f15506f;

        public c(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.b.j0.l0.z.b.b bVar, d.b.j0.l0.z.a.a aVar) {
            this.f15505e = bVar;
            this.f15506f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15505e.c(false);
            this.f15505e.d(1);
            d.b.j0.l0.z.a.a aVar = this.f15506f;
            if (aVar != null) {
                aVar.a(this.f15505e.a());
            }
        }
    }

    public ForumEmotionEmptyViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.f15500a = (ForumEmotionEmptyView) view;
    }

    public final void b(d.b.j0.l0.z.b.b bVar, d.b.j0.l0.z.a.a aVar) {
        String string;
        ViewGroup filterDropDownView = this.f15500a.getFilterDropDownView();
        if (bVar != null) {
            Resources resources = this.f15500a.getResources();
            TextView filterView = this.f15500a.getFilterView();
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

    public void c(d.b.j0.l0.z.b.a aVar, int i, d.b.j0.l0.z.b.b bVar, d.b.j0.l0.z.a.a aVar2) {
        b(bVar, aVar2);
    }
}
