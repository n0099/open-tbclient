package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class OfficialBarFeedMsglistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f17508a;

    /* renamed from: b  reason: collision with root package name */
    public c f17509b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<d.b.i0.g0.b.a> f17510c = new ArrayList<>();

    /* loaded from: classes4.dex */
    public static class a implements d.b.i0.g0.b.a {

        /* renamed from: e  reason: collision with root package name */
        public String f17511e;

        /* renamed from: f  reason: collision with root package name */
        public String f17512f;

        /* renamed from: g  reason: collision with root package name */
        public long f17513g;

        /* renamed from: h  reason: collision with root package name */
        public int f17514h;
        public long i;

        public String b() {
            return this.f17511e;
        }

        public String c() {
            return this.f17512f;
        }

        public long d() {
            return this.f17513g;
        }

        public int f() {
            return this.f17514h;
        }

        public long g() {
            return this.i;
        }

        public void h(String str) {
            this.f17511e = str;
        }

        public void i(String str) {
            this.f17512f = str;
        }

        public void j(long j) {
            this.f17513g = j;
        }

        public void m(int i) {
            this.f17514h = i;
        }

        public void n(int i) {
        }

        public void o(long j) {
            this.i = j;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public BarImageView f17515e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17516f;

        /* renamed from: g  reason: collision with root package name */
        public View f17517g;

        /* renamed from: h  reason: collision with root package name */
        public a f17518h;

        public b(View view) {
            super(view);
            this.f17515e = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.f17516f = (TextView) view.findViewById(R.id.official_bar_name);
            this.f17517g = view.findViewById(R.id.official_bar_feed_red_dot);
            this.f17515e.setShowOval(true);
            this.f17515e.setPlaceHolder(2);
            this.f17515e.setShowOuterBorder(false);
            this.f17515e.setShowInnerBorder(true);
            this.f17515e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        public void a(d.b.i0.g0.b.a aVar) {
            this.f17518h = (a) aVar;
            SkinManager.setViewTextColor(this.f17516f, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f17517g, R.drawable.icon_official_bar_red_dot);
            this.f17515e.setStrokeColorResId(R.color.CAM_X0401);
            this.f17515e.W(this.f17518h.b(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(this.f17518h.c()) <= 10) {
                this.f17516f.setText(this.f17518h.c());
            } else {
                this.f17516f.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f17518h.c(), 8, StringHelper.STRING_MORE));
            }
            this.f17515e.setOnClickListener(this);
            if (this.f17518h.f() > 0 && (this.f17518h.g() <= 0 || System.currentTimeMillis() - this.f17518h.g() < ImageLoader.f3708d)) {
                this.f17517g.setVisibility(0);
            } else {
                this.f17517g.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17517g.setVisibility(8);
            if (OfficialBarFeedMsglistAdapter.this.f17509b != null) {
                OfficialBarFeedMsglistAdapter.this.f17509b.a(view, this.f17518h, getAdapterPosition(), getItemId());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        this.f17508a = tbPageContext;
        this.f17509b = cVar;
    }

    public void d(ArrayList<? extends d.b.i0.g0.b.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f17510c.clear();
        this.f17510c.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d.b.i0.g0.b.a> arrayList = this.f17510c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ArrayList<d.b.i0.g0.b.a> arrayList = this.f17510c;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.b.i0.g0.b.a aVar = this.f17510c.get(i);
        if ((viewHolder instanceof b) && (aVar instanceof a)) {
            ((b) viewHolder).a(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.f17508a.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }
}
