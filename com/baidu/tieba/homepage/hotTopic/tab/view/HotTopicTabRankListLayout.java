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
import d.a.i0.m.f;
import d.a.j0.a1.e.a.e.c;
import d.a.j0.a1.e.a.e.d;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicTabRankListLayout extends RecyclerView {

    /* renamed from: e  reason: collision with root package name */
    public int f17125e;

    /* renamed from: f  reason: collision with root package name */
    public a f17126f;

    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.Adapter<b> {

        /* renamed from: a  reason: collision with root package name */
        public List<c> f17127a;

        /* renamed from: b  reason: collision with root package name */
        public f<c> f17128b;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public void onBindViewHolder(@NonNull b bVar, int i2) {
            List<c> list = this.f17127a;
            if (list == null || list.size() <= i2) {
                return;
            }
            c cVar = list.get(i2);
            bVar.b(cVar);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            f<c> fVar = this.f17128b;
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
            bVar.d(this.f17128b);
            bVar.c(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }

        public void e(f<c> fVar) {
            this.f17128b = fVar;
        }

        public void f(@NonNull List<c> list) {
            this.f17127a = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<c> list = this.f17127a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f17129a;

        /* renamed from: b  reason: collision with root package name */
        public View f17130b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17131c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17132d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17133e;

        /* renamed from: f  reason: collision with root package name */
        public View f17134f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17135g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f17136h;

        /* renamed from: i  reason: collision with root package name */
        public f<c> f17137i;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f17138e;

            public a(c cVar) {
                this.f17138e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new HotRanklistActivityConfig(view.getContext()).createNormalConfig("hotforum", "all").start();
                if (b.this.f17137i != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    b.this.f17137i.a(view, this.f17138e, adapterPosition, adapterPosition);
                }
            }
        }

        /* renamed from: com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0191b implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f17140e;

            public View$OnClickListenerC0191b(c cVar) {
                this.f17140e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(view.getContext());
                hotTopicActivityConfig.createNormalConfig("" + this.f17140e.f50711a, null, "3").start();
                if (b.this.f17137i != null) {
                    int adapterPosition = b.this.getAdapterPosition();
                    b.this.f17137i.a(view, this.f17140e, adapterPosition, adapterPosition);
                }
            }
        }

        public b(View view) {
            super(view);
            this.f17129a = 3;
            this.f17130b = view.findViewById(R.id.itemLayout);
            this.f17131c = (TextView) view.findViewById(R.id.indexView);
            this.f17132d = (TextView) view.findViewById(R.id.titleView);
            this.f17133e = (TextView) view.findViewById(R.id.tagView);
            this.f17134f = view.findViewById(R.id.moreLayout);
            this.f17135g = (TextView) view.findViewById(R.id.moreText);
            this.f17136h = (ImageView) view.findViewById(R.id.moreIcon);
        }

        public void b(c cVar) {
            if (cVar != null) {
                if (cVar.f50715e) {
                    this.f17130b.setVisibility(8);
                    this.f17134f.setVisibility(0);
                    this.f17134f.setOnClickListener(new a(cVar));
                    return;
                }
                this.f17130b.setVisibility(0);
                this.f17130b.setOnClickListener(new View$OnClickListenerC0191b(cVar));
                this.f17134f.setVisibility(8);
                int i2 = cVar.f50714d;
                if (i2 > 0) {
                    this.f17131c.setText(String.valueOf(i2));
                    this.f17131c.setVisibility(0);
                } else {
                    this.f17131c.setVisibility(8);
                }
                this.f17132d.setText(cVar.f50712b);
                String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f17133e.getContext(), cVar.f50713c);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f17132d.getLayoutParams();
                if (TextUtils.isEmpty(hotTopicTagStr)) {
                    this.f17133e.setVisibility(8);
                    marginLayoutParams.rightMargin = l.g(this.f17133e.getContext(), R.dimen.tbds22);
                    this.f17132d.setLayoutParams(marginLayoutParams);
                } else {
                    marginLayoutParams.rightMargin = l.g(this.f17133e.getContext(), R.dimen.tbds74);
                    this.f17132d.setLayoutParams(marginLayoutParams);
                    this.f17133e.setVisibility(0);
                    this.f17133e.setText(hotTopicTagStr);
                }
                SkinManager.setViewTextColor(this.f17131c, TagTextHelper.getIndexTextColorRes(cVar.f50714d));
                int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(cVar.f50713c);
                d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(this.f17133e);
                d2.k(R.string.J_X04);
                d2.f(hotTopicTagColorRes);
            }
        }

        public void c(int i2) {
            if (this.f17129a != i2) {
                int i3 = R.color.CAM_X0204;
                TBSelector.setViewBackgroundColorWithPressedState(this.f17130b, R.color.CAM_X0205, i3);
                TBSelector.setViewBackgroundColorWithPressedState(this.f17134f, R.color.CAM_X0205, i3);
                SkinManager.setViewTextColor(this.f17132d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f17133e, R.color.CAM_X0101);
                if (this.f17134f.getVisibility() == 0) {
                    SkinManager.setViewTextColor(this.f17135g, R.color.CAM_X0304);
                    int color = SkinManager.getColor(R.color.CAM_X0304);
                    Drawable drawable = this.f17136h.getDrawable();
                    DrawableCompat.setTint(drawable, color);
                    this.f17136h.setImageDrawable(drawable);
                }
                this.f17129a = i2;
            }
        }

        public void d(f<c> fVar) {
            this.f17137i = fVar;
        }
    }

    public HotTopicTabRankListLayout(Context context) {
        super(context);
        this.f17125e = 3;
        c();
    }

    public void b(d dVar) {
        if (dVar == null || dVar.z() == null) {
            return;
        }
        this.f17126f.f(dVar.z());
    }

    public final void c() {
        setLayoutManager(new GridLayoutManager(getContext(), 2));
        setOverScrollMode(2);
        a aVar = new a();
        this.f17126f = aVar;
        setAdapter(aVar);
    }

    public void d(int i2) {
        if (this.f17125e != i2) {
            this.f17126f.notifyDataSetChanged();
            this.f17125e = i2;
        }
    }

    public void setOnItemCoverListener(f<c> fVar) {
        this.f17126f.e(fVar);
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17125e = 3;
        c();
    }

    public HotTopicTabRankListLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17125e = 3;
        c();
    }
}
