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
import d.a.j0.m.f;
import d.a.k0.a1.e.a.e.c;
import d.a.k0.a1.e.a.e.d;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabRankListLayout extends RecyclerView {

    /* renamed from: e  reason: collision with root package name */
    public int f16440e;

    /* renamed from: f  reason: collision with root package name */
    public a f16441f;

    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.Adapter<b> {

        /* renamed from: a  reason: collision with root package name */
        public List<c> f16442a;

        /* renamed from: b  reason: collision with root package name */
        public f<c> f16443b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public void onBindViewHolder(@NonNull b bVar, int i2) {
            List<c> list = this.f16442a;
            if (list == null || list.size() <= i2) {
                return;
            }
            c cVar = list.get(i2);
            bVar.b(cVar);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            f<c> fVar = this.f16443b;
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
            bVar.d(this.f16443b);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        public void e(f<c> fVar) {
            this.f16443b = fVar;
        }

        public void f(@NonNull List<c> list) {
            this.f16442a = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<c> list = this.f16442a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f16444a;

        /* renamed from: b  reason: collision with root package name */
        public View f16445b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16446c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16447d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f16448e;

        /* renamed from: f  reason: collision with root package name */
        public View f16449f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16450g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f16451h;

        /* renamed from: i  reason: collision with root package name */
        public f<c> f16452i;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16453e;

            public a(c cVar) {
                this.f16453e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                if (b.this.f16452i != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    b.this.f16452i.a(view, this.f16453e, adapterPosition, adapterPosition);
                }
            }
        }

        /* renamed from: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0178b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f16455e;

            public View$OnClickListenerC0178b(c cVar) {
                this.f16455e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(view.getContext());
                hotTopicActivityConfig.createNormalConfig("" + this.f16455e.f51408a, null, "3").start();
                if (b.this.f16452i != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    b.this.f16452i.a(view, this.f16455e, adapterPosition, adapterPosition);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f16444a = 3;
            this.f16445b = view.findViewById(R.id.itemLayout);
            this.f16446c = (TextView) view.findViewById(R.id.indexView);
            this.f16447d = (TextView) view.findViewById(R.id.titleView);
            this.f16448e = (TextView) view.findViewById(R.id.tagView);
            this.f16449f = view.findViewById(R.id.moreLayout);
            this.f16450g = (TextView) view.findViewById(R.id.moreText);
            this.f16451h = (ImageView) view.findViewById(R.id.moreIcon);
        }

        public void b(c cVar) {
            if (cVar != null) {
                if (cVar.f51412e) {
                    this.f16445b.setVisibility(8);
                    this.f16449f.setVisibility(0);
                    this.f16449f.setOnClickListener(new a(cVar));
                    return;
                }
                this.f16445b.setVisibility(0);
                this.f16445b.setOnClickListener(new View$OnClickListenerC0178b(cVar));
                this.f16449f.setVisibility(8);
                int i2 = cVar.f51411d;
                if (i2 > 0) {
                    this.f16446c.setText(String.valueOf(i2));
                    this.f16446c.setVisibility(0);
                } else {
                    this.f16446c.setVisibility(8);
                }
                this.f16447d.setText(cVar.f51409b);
                String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f16448e.getContext(), cVar.f51410c);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f16447d.getLayoutParams();
                if (TextUtils.isEmpty(hotTopicTagStr)) {
                    this.f16448e.setVisibility(8);
                    marginLayoutParams.rightMargin = l.g(this.f16448e.getContext(), R.dimen.tbds22);
                    this.f16447d.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.g(this.f16448e.getContext(), R.dimen.tbds74);
                    this.f16447d.setLayoutParams(marginLayoutParams);
                    this.f16448e.setVisibility(0);
                    this.f16448e.setText(hotTopicTagStr);
                }
                SkinManager.setViewTextColor(this.f16446c, TagTextHelper.getIndexTextColorRes(cVar.f51411d));
                int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(cVar.f51410c);
                d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(this.f16448e);
                d2.k(R.string.J_X04);
                d2.f(hotTopicTagColorRes);
            }
        }

        public void c(int i2) {
            if (this.f16444a != i2) {
                int i3 = R.color.CAM_X0204;
                TBSelector.setViewBackgroundColorWithPressedState(this.f16445b, R.color.CAM_X0205, i3);
                TBSelector.setViewBackgroundColorWithPressedState(this.f16449f, R.color.CAM_X0205, i3);
                SkinManager.setViewTextColor(this.f16447d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f16448e, R.color.CAM_X0101);
                if (this.f16449f.getVisibility() == 0) {
                    SkinManager.setViewTextColor(this.f16450g, R.color.CAM_X0304);
                    int color = SkinManager.getColor(R.color.CAM_X0304);
                    Drawable drawable = this.f16451h.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.f16451h.setImageDrawable(drawable);
                }
                this.f16444a = i2;
            }
        }

        public void d(f<c> fVar) {
            this.f16452i = fVar;
        }
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.f16440e = 3;
        c();
    }

    public void b(d dVar) {
        if (dVar == null || dVar.z() == null) {
            return;
        }
        this.f16441f.f(dVar.z());
    }

    public final void c() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        a aVar = new a();
        this.f16441f = aVar;
        setAdapter(aVar);
    }

    public void d(int i2) {
        if (this.f16440e != i2) {
            this.f16441f.notifyDataSetChanged();
            this.f16440e = i2;
        }
    }

    public void setOnItemCoverListener(f<c> fVar) {
        this.f16441f.e(fVar);
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16440e = 3;
        c();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16440e = 3;
        c();
    }
}
