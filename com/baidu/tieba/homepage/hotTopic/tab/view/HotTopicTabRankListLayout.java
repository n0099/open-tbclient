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
import d.b.c.e.p.l;
import d.b.h0.m.f;
import d.b.i0.a1.e.a.e.c;
import d.b.i0.a1.e.a.e.d;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabRankListLayout extends RecyclerView {

    /* renamed from: e  reason: collision with root package name */
    public int f16851e;

    /* renamed from: f  reason: collision with root package name */
    public a f16852f;

    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.Adapter<b> {

        /* renamed from: a  reason: collision with root package name */
        public List<c> f16853a;

        /* renamed from: b  reason: collision with root package name */
        public f<c> f16854b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public void onBindViewHolder(@NonNull b bVar, int i) {
            List<c> list = this.f16853a;
            if (list == null || list.size() <= i) {
                return;
            }
            c cVar = list.get(i);
            bVar.b(cVar);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            f<c> fVar = this.f16854b;
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
            bVar.d(this.f16854b);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        public void e(f<c> fVar) {
            this.f16854b = fVar;
        }

        public void f(@NonNull List<c> list) {
            this.f16853a = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<c> list = this.f16853a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f16855a;

        /* renamed from: b  reason: collision with root package name */
        public View f16856b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16857c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16858d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f16859e;

        /* renamed from: f  reason: collision with root package name */
        public View f16860f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16861g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f16862h;
        public f<c> i;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16863e;

            public a(c cVar) {
                this.f16863e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                if (b.this.i != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    b.this.i.a(view, this.f16863e, adapterPosition, adapterPosition);
                }
            }
        }

        /* renamed from: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0194b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16865e;

            public View$OnClickListenerC0194b(c cVar) {
                this.f16865e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(view.getContext());
                hotTopicActivityConfig.createNormalConfig("" + this.f16865e.f52587a, null, "3").start();
                if (b.this.i != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    b.this.i.a(view, this.f16865e, adapterPosition, adapterPosition);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f16855a = 3;
            this.f16856b = view.findViewById(R.id.itemLayout);
            this.f16857c = (TextView) view.findViewById(R.id.indexView);
            this.f16858d = (TextView) view.findViewById(R.id.titleView);
            this.f16859e = (TextView) view.findViewById(R.id.tagView);
            this.f16860f = view.findViewById(R.id.moreLayout);
            this.f16861g = (TextView) view.findViewById(R.id.moreText);
            this.f16862h = (ImageView) view.findViewById(R.id.moreIcon);
        }

        public void b(c cVar) {
            if (cVar != null) {
                if (cVar.f52591e) {
                    this.f16856b.setVisibility(8);
                    this.f16860f.setVisibility(0);
                    this.f16860f.setOnClickListener(new a(cVar));
                    return;
                }
                this.f16856b.setVisibility(0);
                this.f16856b.setOnClickListener(new View$OnClickListenerC0194b(cVar));
                this.f16860f.setVisibility(8);
                int i = cVar.f52590d;
                if (i > 0) {
                    this.f16857c.setText(String.valueOf(i));
                    this.f16857c.setVisibility(0);
                } else {
                    this.f16857c.setVisibility(8);
                }
                this.f16858d.setText(cVar.f52588b);
                String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f16859e.getContext(), cVar.f52589c);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f16858d.getLayoutParams();
                if (TextUtils.isEmpty(hotTopicTagStr)) {
                    this.f16859e.setVisibility(8);
                    marginLayoutParams.rightMargin = l.g(this.f16859e.getContext(), R.dimen.tbds22);
                    this.f16858d.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.g(this.f16859e.getContext(), R.dimen.tbds74);
                    this.f16858d.setLayoutParams(marginLayoutParams);
                    this.f16859e.setVisibility(0);
                    this.f16859e.setText(hotTopicTagStr);
                }
                SkinManager.setViewTextColor(this.f16857c, TagTextHelper.getIndexTextColorRes(cVar.f52590d));
                int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(cVar.f52589c);
                d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.f16859e);
                d2.k(R.string.J_X04);
                d2.f(hotTopicTagColorRes);
            }
        }

        public void c(int i) {
            if (this.f16855a != i) {
                int i2 = R.color.CAM_X0204;
                TBSelector.setViewBackgroundColorWithPressedState(this.f16856b, R.color.CAM_X0205, i2);
                TBSelector.setViewBackgroundColorWithPressedState(this.f16860f, R.color.CAM_X0205, i2);
                SkinManager.setViewTextColor(this.f16858d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f16859e, R.color.CAM_X0101);
                if (this.f16860f.getVisibility() == 0) {
                    SkinManager.setViewTextColor(this.f16861g, R.color.CAM_X0304);
                    int color = SkinManager.getColor(R.color.CAM_X0304);
                    Drawable drawable = this.f16862h.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.f16862h.setImageDrawable(drawable);
                }
                this.f16855a = i;
            }
        }

        public void d(f<c> fVar) {
            this.i = fVar;
        }
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.f16851e = 3;
        c();
    }

    public void b(d dVar) {
        if (dVar == null || dVar.z() == null) {
            return;
        }
        this.f16852f.f(dVar.z());
    }

    public final void c() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        a aVar = new a();
        this.f16852f = aVar;
        setAdapter(aVar);
    }

    public void d(int i) {
        if (this.f16851e != i) {
            this.f16852f.notifyDataSetChanged();
            this.f16851e = i;
        }
    }

    public void setOnItemCoverListener(f<c> fVar) {
        this.f16852f.e(fVar);
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16851e = 3;
        c();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16851e = 3;
        c();
    }
}
