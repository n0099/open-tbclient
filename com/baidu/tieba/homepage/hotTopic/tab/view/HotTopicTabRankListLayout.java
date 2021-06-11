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
import d.a.c.e.p.l;
import d.a.m0.m.f;
import d.a.n0.b1.f.a.e.c;
import d.a.n0.b1.f.a.e.d;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabRankListLayout extends RecyclerView {

    /* renamed from: e  reason: collision with root package name */
    public int f16413e;

    /* renamed from: f  reason: collision with root package name */
    public a f16414f;

    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.Adapter<b> {

        /* renamed from: a  reason: collision with root package name */
        public List<c> f16415a;

        /* renamed from: b  reason: collision with root package name */
        public f<c> f16416b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public void onBindViewHolder(@NonNull b bVar, int i2) {
            List<c> list = this.f16415a;
            if (list == null || list.size() <= i2) {
                return;
            }
            c cVar = list.get(i2);
            bVar.b(cVar);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            f<c> fVar = this.f16416b;
            if (fVar != null) {
                fVar.c(bVar.itemView, cVar, i2, i2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: d */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hot_topic_tab_rank_list_item, viewGroup, false));
            bVar.d(this.f16416b);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        public void e(f<c> fVar) {
            this.f16416b = fVar;
        }

        public void f(@NonNull List<c> list) {
            this.f16415a = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<c> list = this.f16415a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f16417a;

        /* renamed from: b  reason: collision with root package name */
        public View f16418b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16419c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16420d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f16421e;

        /* renamed from: f  reason: collision with root package name */
        public View f16422f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16423g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f16424h;

        /* renamed from: i  reason: collision with root package name */
        public f<c> f16425i;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16426e;

            public a(c cVar) {
                this.f16426e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                if (b.this.f16425i != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    b.this.f16425i.a(view, this.f16426e, adapterPosition, adapterPosition);
                }
            }
        }

        /* renamed from: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0179b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16428e;

            public View$OnClickListenerC0179b(c cVar) {
                this.f16428e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(view.getContext());
                hotTopicActivityConfig.createNormalConfig("" + this.f16428e.f55256a, null, "3").start();
                if (b.this.f16425i != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    b.this.f16425i.a(view, this.f16428e, adapterPosition, adapterPosition);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f16417a = 3;
            this.f16418b = view.findViewById(R.id.itemLayout);
            this.f16419c = (TextView) view.findViewById(R.id.indexView);
            this.f16420d = (TextView) view.findViewById(R.id.titleView);
            this.f16421e = (TextView) view.findViewById(R.id.tagView);
            this.f16422f = view.findViewById(R.id.moreLayout);
            this.f16423g = (TextView) view.findViewById(R.id.moreText);
            this.f16424h = (ImageView) view.findViewById(R.id.moreIcon);
        }

        public void b(c cVar) {
            if (cVar != null) {
                if (cVar.f55260e) {
                    this.f16418b.setVisibility(8);
                    this.f16422f.setVisibility(0);
                    this.f16422f.setOnClickListener(new a(cVar));
                    return;
                }
                this.f16418b.setVisibility(0);
                this.f16418b.setOnClickListener(new View$OnClickListenerC0179b(cVar));
                this.f16422f.setVisibility(8);
                int i2 = cVar.f55259d;
                if (i2 > 0) {
                    this.f16419c.setText(String.valueOf(i2));
                    this.f16419c.setVisibility(0);
                } else {
                    this.f16419c.setVisibility(8);
                }
                this.f16420d.setText(cVar.f55257b);
                String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f16421e.getContext(), cVar.f55258c);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f16420d.getLayoutParams();
                if (TextUtils.isEmpty(hotTopicTagStr)) {
                    this.f16421e.setVisibility(8);
                    marginLayoutParams.rightMargin = l.g(this.f16421e.getContext(), R.dimen.tbds22);
                    this.f16420d.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.g(this.f16421e.getContext(), R.dimen.tbds74);
                    this.f16420d.setLayoutParams(marginLayoutParams);
                    this.f16421e.setVisibility(0);
                    this.f16421e.setText(hotTopicTagStr);
                }
                int indexTextColorRes = TagTextHelper.getIndexTextColorRes(cVar.f55259d);
                d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.f16419c);
                d2.m(R.string.J_X04);
                d2.f(indexTextColorRes);
                int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(cVar.f55258c);
                d.a.m0.r.u.c d3 = d.a.m0.r.u.c.d(this.f16421e);
                d3.m(R.string.J_X04);
                d3.e(R.string.A_X12);
                d3.f(hotTopicTagColorRes);
            }
        }

        public void c(int i2) {
            if (this.f16417a != i2) {
                int i3 = R.color.CAM_X0204;
                TBSelector.setViewBackgroundColorWithPressedState(this.f16418b, R.color.CAM_X0205, i3);
                TBSelector.setViewBackgroundColorWithPressedState(this.f16422f, R.color.CAM_X0205, i3);
                SkinManager.setViewTextColor(this.f16420d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f16421e, R.color.CAM_X0101);
                SkinManager.setViewTextColor(this.f16419c, R.color.CAM_X0101);
                if (this.f16422f.getVisibility() == 0) {
                    SkinManager.setViewTextColor(this.f16423g, R.color.CAM_X0304);
                    int color = SkinManager.getColor(R.color.CAM_X0304);
                    Drawable drawable = this.f16424h.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.f16424h.setImageDrawable(drawable);
                }
                this.f16417a = i2;
            }
        }

        public void d(f<c> fVar) {
            this.f16425i = fVar;
        }
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.f16413e = 3;
        c();
    }

    public void b(d dVar) {
        if (dVar == null || dVar.z() == null) {
            return;
        }
        this.f16414f.f(dVar.z());
    }

    public final void c() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        a aVar = new a();
        this.f16414f = aVar;
        setAdapter(aVar);
    }

    public void d(int i2) {
        if (this.f16413e != i2) {
            this.f16414f.notifyDataSetChanged();
            this.f16413e = i2;
        }
    }

    public void setOnItemCoverListener(f<c> fVar) {
        this.f16414f.e(fVar);
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16413e = 3;
        c();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16413e = 3;
        c();
    }
}
