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
    public TbPageContext<?> f17122a;

    /* renamed from: b  reason: collision with root package name */
    public c f17123b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<d.a.m0.g0.b.a> f17124c = new ArrayList<>();

    /* loaded from: classes4.dex */
    public static class a implements d.a.m0.g0.b.a {

        /* renamed from: e  reason: collision with root package name */
        public String f17125e;

        /* renamed from: f  reason: collision with root package name */
        public String f17126f;

        /* renamed from: g  reason: collision with root package name */
        public long f17127g;

        /* renamed from: h  reason: collision with root package name */
        public int f17128h;

        /* renamed from: i  reason: collision with root package name */
        public long f17129i;

        public String a() {
            return this.f17125e;
        }

        public String b() {
            return this.f17126f;
        }

        public long c() {
            return this.f17127g;
        }

        public int d() {
            return this.f17128h;
        }

        public long f() {
            return this.f17129i;
        }

        public void g(String str) {
            this.f17125e = str;
        }

        public void i(String str) {
            this.f17126f = str;
        }

        public void j(long j) {
            this.f17127g = j;
        }

        public void k(int i2) {
            this.f17128h = i2;
        }

        public void m(int i2) {
        }

        public void o(long j) {
            this.f17129i = j;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public BarImageView f17130e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17131f;

        /* renamed from: g  reason: collision with root package name */
        public View f17132g;

        /* renamed from: h  reason: collision with root package name */
        public a f17133h;

        public b(View view) {
            super(view);
            this.f17130e = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.f17131f = (TextView) view.findViewById(R.id.official_bar_name);
            this.f17132g = view.findViewById(R.id.official_bar_feed_red_dot);
            this.f17130e.setShowOval(true);
            this.f17130e.setPlaceHolder(2);
            this.f17130e.setShowOuterBorder(false);
            this.f17130e.setShowInnerBorder(true);
            this.f17130e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        public void a(d.a.m0.g0.b.a aVar) {
            this.f17133h = (a) aVar;
            SkinManager.setViewTextColor(this.f17131f, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f17132g, R.drawable.icon_official_bar_red_dot);
            this.f17130e.setStrokeColorResId(R.color.CAM_X0401);
            this.f17130e.U(this.f17133h.a(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(this.f17133h.b()) <= 10) {
                this.f17131f.setText(this.f17133h.b());
            } else {
                this.f17131f.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f17133h.b(), 8, StringHelper.STRING_MORE));
            }
            this.f17130e.setOnClickListener(this);
            if (this.f17133h.d() > 0 && (this.f17133h.f() <= 0 || System.currentTimeMillis() - this.f17133h.f() < ImageLoader.f3777d)) {
                this.f17132g.setVisibility(0);
            } else {
                this.f17132g.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17132g.setVisibility(8);
            if (OfficialBarFeedMsglistAdapter.this.f17123b != null) {
                OfficialBarFeedMsglistAdapter.this.f17123b.a(view, this.f17133h, getAdapterPosition(), getItemId());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view, Object obj, int i2, long j);
    }

    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        this.f17122a = tbPageContext;
        this.f17123b = cVar;
    }

    public void d(ArrayList<? extends d.a.m0.g0.b.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f17124c.clear();
        this.f17124c.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d.a.m0.g0.b.a> arrayList = this.f17124c;
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
        ArrayList<d.a.m0.g0.b.a> arrayList = this.f17124c;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.a.m0.g0.b.a aVar = this.f17124c.get(i2);
        if ((viewHolder instanceof b) && (aVar instanceof a)) {
            ((b) viewHolder).a(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b(this.f17122a.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }
}
