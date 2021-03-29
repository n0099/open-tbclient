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
/* loaded from: classes3.dex */
public class HotTopicTabRankListLayout extends RecyclerView {

    /* renamed from: e  reason: collision with root package name */
    public int f17178e;

    /* renamed from: f  reason: collision with root package name */
    public a f17179f;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.Adapter<b> {

        /* renamed from: a  reason: collision with root package name */
        public List<c> f17180a;

        /* renamed from: b  reason: collision with root package name */
        public f<c> f17181b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.f17180a;
            if (list == null || list.size() <= i) {
                return;
            }
            c cVar = list.get(i);
            bVar.b(cVar);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            f<c> fVar = this.f17181b;
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
            bVar.d(this.f17181b);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        public void e(f<c> fVar) {
            this.f17181b = fVar;
        }

        public void f(@NonNull List<c> list) {
            this.f17180a = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<c> list = this.f17180a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f17182a;

        /* renamed from: b  reason: collision with root package name */
        public View f17183b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17184c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17185d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17186e;

        /* renamed from: f  reason: collision with root package name */
        public View f17187f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17188g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f17189h;
        public f<c> i;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f17190e;

            public a(c cVar) {
                this.f17190e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                if (b.this.i != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    b.this.i.a(view, this.f17190e, adapterPosition, adapterPosition);
                }
            }
        }

        /* renamed from: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0192b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f17192e;

            public View$OnClickListenerC0192b(c cVar) {
                this.f17192e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(view.getContext());
                hotTopicActivityConfig.createNormalConfig("" + this.f17192e.f62968a, null, "3").start();
                if (b.this.i != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    b.this.i.a(view, this.f17192e, adapterPosition, adapterPosition);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f17182a = 3;
            this.f17183b = view.findViewById(R.id.itemLayout);
            this.f17184c = (TextView) view.findViewById(R.id.indexView);
            this.f17185d = (TextView) view.findViewById(R.id.titleView);
            this.f17186e = (TextView) view.findViewById(R.id.tagView);
            this.f17187f = view.findViewById(R.id.moreLayout);
            this.f17188g = (TextView) view.findViewById(R.id.moreText);
            this.f17189h = (ImageView) view.findViewById(R.id.moreIcon);
        }

        public void b(c cVar) {
            if (cVar != null) {
                if (cVar.f62972e) {
                    this.f17183b.setVisibility(8);
                    this.f17187f.setVisibility(0);
                    this.f17187f.setOnClickListener(new a(cVar));
                    return;
                }
                this.f17183b.setVisibility(0);
                this.f17183b.setOnClickListener(new View$OnClickListenerC0192b(cVar));
                this.f17187f.setVisibility(8);
                int i = cVar.f62971d;
                if (i > 0) {
                    this.f17184c.setText(String.valueOf(i));
                    this.f17184c.setVisibility(0);
                } else {
                    this.f17184c.setVisibility(8);
                }
                this.f17185d.setText(cVar.f62969b);
                String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f17186e.getContext(), cVar.f62970c);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f17185d.getLayoutParams();
                if (TextUtils.isEmpty(hotTopicTagStr)) {
                    this.f17186e.setVisibility(8);
                    marginLayoutParams.rightMargin = l.g(this.f17186e.getContext(), R.dimen.tbds22);
                    this.f17185d.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.g(this.f17186e.getContext(), R.dimen.tbds74);
                    this.f17185d.setLayoutParams(marginLayoutParams);
                    this.f17186e.setVisibility(0);
                    this.f17186e.setText(hotTopicTagStr);
                }
                SkinManager.setViewTextColor(this.f17184c, TagTextHelper.getIndexTextColorRes(cVar.f62971d));
                int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(cVar.f62970c);
                d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f17186e);
                a2.h(R.string.J_X04);
                a2.c(hotTopicTagColorRes);
            }
        }

        public void c(int i) {
            if (this.f17182a != i) {
                int i2 = R.color.CAM_X0204;
                TBSelector.setViewBackgroundColorWithPressedState(this.f17183b, R.color.CAM_X0205, i2);
                TBSelector.setViewBackgroundColorWithPressedState(this.f17187f, R.color.CAM_X0205, i2);
                SkinManager.setViewTextColor(this.f17185d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f17186e, R.color.CAM_X0101);
                if (this.f17187f.getVisibility() == 0) {
                    SkinManager.setViewTextColor(this.f17188g, R.color.CAM_X0304);
                    int color = SkinManager.getColor(R.color.CAM_X0304);
                    Drawable drawable = this.f17189h.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.f17189h.setImageDrawable(drawable);
                }
                this.f17182a = i;
            }
        }

        public void d(f<c> fVar) {
            this.i = fVar;
        }
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.f17178e = 3;
        c();
    }

    public void b(d dVar) {
        if (dVar == null || dVar.z() == null) {
            return;
        }
        this.f17179f.f(dVar.z());
    }

    public final void c() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        a aVar = new a();
        this.f17179f = aVar;
        setAdapter(aVar);
    }

    public void d(int i) {
        if (this.f17178e != i) {
            this.f17179f.notifyDataSetChanged();
            this.f17178e = i;
        }
    }

    public void setOnItemCoverListener(f<c> fVar) {
        this.f17179f.e(fVar);
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17178e = 3;
        c();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17178e = 3;
        c();
    }
}
