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
import d.a.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class OfficialBarFeedMsglistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f17046a;

    /* renamed from: b  reason: collision with root package name */
    public c f17047b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<d.a.m0.g0.b.a> f17048c = new ArrayList<>();

    /* loaded from: classes4.dex */
    public static class a implements d.a.m0.g0.b.a {

        /* renamed from: e  reason: collision with root package name */
        public String f17049e;

        /* renamed from: f  reason: collision with root package name */
        public String f17050f;

        /* renamed from: g  reason: collision with root package name */
        public long f17051g;

        /* renamed from: h  reason: collision with root package name */
        public int f17052h;

        /* renamed from: i  reason: collision with root package name */
        public long f17053i;

        public String a() {
            return this.f17049e;
        }

        public String b() {
            return this.f17050f;
        }

        public long d() {
            return this.f17051g;
        }

        public int e() {
            return this.f17052h;
        }

        public long g() {
            return this.f17053i;
        }

        public void h(String str) {
            this.f17049e = str;
        }

        public void j(String str) {
            this.f17050f = str;
        }

        public void l(long j) {
            this.f17051g = j;
        }

        public void m(int i2) {
            this.f17052h = i2;
        }

        public void n(int i2) {
        }

        public void p(long j) {
            this.f17053i = j;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public BarImageView f17054e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17055f;

        /* renamed from: g  reason: collision with root package name */
        public View f17056g;

        /* renamed from: h  reason: collision with root package name */
        public a f17057h;

        public b(View view) {
            super(view);
            this.f17054e = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.f17055f = (TextView) view.findViewById(R.id.official_bar_name);
            this.f17056g = view.findViewById(R.id.official_bar_feed_red_dot);
            this.f17054e.setShowOval(true);
            this.f17054e.setPlaceHolder(2);
            this.f17054e.setShowOuterBorder(false);
            this.f17054e.setShowInnerBorder(true);
            this.f17054e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        public void a(d.a.m0.g0.b.a aVar) {
            this.f17057h = (a) aVar;
            SkinManager.setViewTextColor(this.f17055f, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f17056g, R.drawable.icon_official_bar_red_dot);
            this.f17054e.setStrokeColorResId(R.color.CAM_X0401);
            this.f17054e.V(this.f17057h.a(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(this.f17057h.b()) <= 10) {
                this.f17055f.setText(this.f17057h.b());
            } else {
                this.f17055f.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f17057h.b(), 8, StringHelper.STRING_MORE));
            }
            this.f17054e.setOnClickListener(this);
            if (this.f17057h.e() > 0 && (this.f17057h.g() <= 0 || System.currentTimeMillis() - this.f17057h.g() < ImageLoader.f3758d)) {
                this.f17056g.setVisibility(0);
            } else {
                this.f17056g.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17056g.setVisibility(8);
            if (OfficialBarFeedMsglistAdapter.this.f17047b != null) {
                OfficialBarFeedMsglistAdapter.this.f17047b.a(view, this.f17057h, getAdapterPosition(), getItemId());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view, Object obj, int i2, long j);
    }

    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        this.f17046a = tbPageContext;
        this.f17047b = cVar;
    }

    public void d(ArrayList<? extends d.a.m0.g0.b.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f17048c.clear();
        this.f17048c.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d.a.m0.g0.b.a> arrayList = this.f17048c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ArrayList<d.a.m0.g0.b.a> arrayList = this.f17048c;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.a.m0.g0.b.a aVar = this.f17048c.get(i2);
        if ((viewHolder instanceof b) && (aVar instanceof a)) {
            ((b) viewHolder).a(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b(this.f17046a.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }
}
