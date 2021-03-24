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
    public ForumEmotionEmptyView f15828a;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.b.b f15829e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.a.a f15830f;

        public a(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
            this.f15829e = bVar;
            this.f15830f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.l0.z.b.b bVar = this.f15829e;
            bVar.c(!bVar.b());
            d.b.i0.l0.z.a.a aVar = this.f15830f;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.b.b f15831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.a.a f15832f;

        public b(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
            this.f15831e = bVar;
            this.f15832f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15831e.c(false);
            this.f15831e.d(0);
            d.b.i0.l0.z.a.a aVar = this.f15832f;
            if (aVar != null) {
                aVar.a(this.f15831e.a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.b.b f15833e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.l0.z.a.a f15834f;

        public c(ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder, d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
            this.f15833e = bVar;
            this.f15834f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f15833e.c(false);
            this.f15833e.d(1);
            d.b.i0.l0.z.a.a aVar = this.f15834f;
            if (aVar != null) {
                aVar.a(this.f15833e.a());
            }
        }
    }

    public ForumEmotionEmptyViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        this.f15828a = (ForumEmotionEmptyView) view;
    }

    public final void b(d.b.i0.l0.z.b.b bVar, d.b.i0.l0.z.a.a aVar) {
        String string;
        ViewGroup filterDropDownView = this.f15828a.getFilterDropDownView();
        if (bVar != null) {
            Resources resources = this.f15828a.getResources();
            TextView filterView = this.f15828a.getFilterView();
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
