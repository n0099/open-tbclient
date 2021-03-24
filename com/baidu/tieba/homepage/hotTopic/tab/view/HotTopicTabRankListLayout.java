package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.m.f;
import d.b.i0.z0.e.a.e.c;
import d.b.i0.z0.e.a.e.d;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabRankListLayout extends RecyclerView {

    /* renamed from: e  reason: collision with root package name */
    public int f17177e;

    /* renamed from: f  reason: collision with root package name */
    public a f17178f;

    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.Adapter<b> {

        /* renamed from: a  reason: collision with root package name */
        public List<c> f17179a;

        /* renamed from: b  reason: collision with root package name */
        public f<c> f17180b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.f17179a;
            if (list == null || list.size() <= i) {
                return;
            }
            c cVar = list.get(i);
            bVar.b(cVar);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            f<c> fVar = this.f17180b;
            if (fVar != null) {
                fVar.c(bVar.itemView, cVar, i, i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: d */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.d(this.f17180b);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        public void e(f<c> fVar) {
            this.f17180b = fVar;
        }

        public void f(@NonNull List<c> list) {
            this.f17179a = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<c> list = this.f17179a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f17181a;

        /* renamed from: b  reason: collision with root package name */
        public View f17182b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17183c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17184d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17185e;

        /* renamed from: f  reason: collision with root package name */
        public View f17186f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17187g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f17188h;
        public f<c> i;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f17189e;

            public a(c cVar) {
                this.f17189e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                if (b.this.i != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    b.this.i.a(view, this.f17189e, adapterPosition, adapterPosition);
                }
            }
        }

        /* renamed from: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0191b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f17191e;

            public View$OnClickListenerC0191b(c cVar) {
                this.f17191e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(view.getContext());
                hotTopicActivityConfig.createNormalConfig("" + this.f17191e.f62967a, null, "3").start();
                if (b.this.i != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    b.this.i.a(view, this.f17191e, adapterPosition, adapterPosition);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f17181a = 3;
            this.f17182b = view.findViewById(R.id.itemLayout);
            this.f17183c = (TextView) view.findViewById(R.id.indexView);
            this.f17184d = (TextView) view.findViewById(R.id.titleView);
            this.f17185e = (TextView) view.findViewById(R.id.tagView);
            this.f17186f = view.findViewById(R.id.moreLayout);
            this.f17187g = (TextView) view.findViewById(R.id.moreText);
            this.f17188h = (ImageView) view.findViewById(R.id.moreIcon);
        }

        public void b(c cVar) {
            if (cVar != null) {
                if (cVar.f62971e) {
                    this.f17182b.setVisibility(8);
                    this.f17186f.setVisibility(0);
                    this.f17186f.setOnClickListener(new a(cVar));
                    return;
                }
                this.f17182b.setVisibility(0);
                this.f17182b.setOnClickListener(new View$OnClickListenerC0191b(cVar));
                this.f17186f.setVisibility(8);
                int i = cVar.f62970d;
                if (i > 0) {
                    this.f17183c.setText(String.valueOf(i));
                    this.f17183c.setVisibility(0);
                } else {
                    this.f17183c.setVisibility(8);
                }
                this.f17184d.setText(cVar.f62968b);
                String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f17185e.getContext(), cVar.f62969c);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f17184d.getLayoutParams();
                if (TextUtils.isEmpty(hotTopicTagStr)) {
                    this.f17185e.setVisibility(8);
                    marginLayoutParams.rightMargin = l.g(this.f17185e.getContext(), R.dimen.tbds22);
                    this.f17184d.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.g(this.f17185e.getContext(), R.dimen.tbds74);
                    this.f17184d.setLayoutParams(marginLayoutParams);
                    this.f17185e.setVisibility(0);
                    this.f17185e.setText(hotTopicTagStr);
                }
                SkinManager.setViewTextColor(this.f17183c, TagTextHelper.getIndexTextColorRes(cVar.f62970d));
                int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(cVar.f62969c);
                d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f17185e);
                a2.h(R.string.J_X04);
                a2.c(hotTopicTagColorRes);
            }
        }

        public void c(int i) {
            if (this.f17181a != i) {
                int i2 = R.color.CAM_X0204;
                TBSelector.setViewBackgroundColorWithPressedState(this.f17182b, R.color.CAM_X0205, i2);
                TBSelector.setViewBackgroundColorWithPressedState(this.f17186f, R.color.CAM_X0205, i2);
                SkinManager.setViewTextColor(this.f17184d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f17185e, R.color.CAM_X0101);
                if (this.f17186f.getVisibility() == 0) {
                    SkinManager.setViewTextColor(this.f17187g, R.color.CAM_X0304);
                    int color = SkinManager.getColor(R.color.CAM_X0304);
                    Drawable drawable = this.f17188h.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.f17188h.setImageDrawable(drawable);
                }
                this.f17181a = i;
            }
        }

        public void d(f<c> fVar) {
            this.i = fVar;
        }
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.f17177e = 3;
        c();
    }

    public void b(d dVar) {
        if (dVar == null || dVar.z() == null) {
            return;
        }
        this.f17178f.f(dVar.z());
    }

    public final void c() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        a aVar = new a();
        this.f17178f = aVar;
        setAdapter(aVar);
    }

    public void d(int i) {
        if (this.f17177e != i) {
            this.f17178f.notifyDataSetChanged();
            this.f17177e = i;
        }
    }

    public void setOnItemCoverListener(f<c> fVar) {
        this.f17178f.e(fVar);
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17177e = 3;
        c();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17177e = 3;
        c();
    }
}
