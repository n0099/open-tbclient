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
    public TbPageContext<?> f17204a;

    /* renamed from: b  reason: collision with root package name */
    public c f17205b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<d.a.n0.g0.b.a> f17206c = new ArrayList<>();

    /* loaded from: classes4.dex */
    public static class a implements d.a.n0.g0.b.a {

        /* renamed from: e  reason: collision with root package name */
        public String f17207e;

        /* renamed from: f  reason: collision with root package name */
        public String f17208f;

        /* renamed from: g  reason: collision with root package name */
        public long f17209g;

        /* renamed from: h  reason: collision with root package name */
        public int f17210h;

        /* renamed from: i  reason: collision with root package name */
        public long f17211i;

        public String a() {
            return this.f17207e;
        }

        public String b() {
            return this.f17208f;
        }

        public long c() {
            return this.f17209g;
        }

        public int d() {
            return this.f17210h;
        }

        public long f() {
            return this.f17211i;
        }

        public void g(String str) {
            this.f17207e = str;
        }

        public void i(String str) {
            this.f17208f = str;
        }

        public void j(long j) {
            this.f17209g = j;
        }

        public void k(int i2) {
            this.f17210h = i2;
        }

        public void m(int i2) {
        }

        public void o(long j) {
            this.f17211i = j;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public BarImageView f17212e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17213f;

        /* renamed from: g  reason: collision with root package name */
        public View f17214g;

        /* renamed from: h  reason: collision with root package name */
        public a f17215h;

        public b(View view) {
            super(view);
            this.f17212e = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.f17213f = (TextView) view.findViewById(R.id.official_bar_name);
            this.f17214g = view.findViewById(R.id.official_bar_feed_red_dot);
            this.f17212e.setShowOval(true);
            this.f17212e.setPlaceHolder(2);
            this.f17212e.setShowOuterBorder(false);
            this.f17212e.setShowInnerBorder(true);
            this.f17212e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        public void a(d.a.n0.g0.b.a aVar) {
            this.f17215h = (a) aVar;
            SkinManager.setViewTextColor(this.f17213f, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f17214g, R.drawable.icon_official_bar_red_dot);
            this.f17212e.setStrokeColorResId(R.color.CAM_X0401);
            this.f17212e.U(this.f17215h.a(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(this.f17215h.b()) <= 10) {
                this.f17213f.setText(this.f17215h.b());
            } else {
                this.f17213f.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f17215h.b(), 8, StringHelper.STRING_MORE));
            }
            this.f17212e.setOnClickListener(this);
            if (this.f17215h.d() > 0 && (this.f17215h.f() <= 0 || System.currentTimeMillis() - this.f17215h.f() < ImageLoader.f3777d)) {
                this.f17214g.setVisibility(0);
            } else {
                this.f17214g.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17214g.setVisibility(8);
            if (OfficialBarFeedMsglistAdapter.this.f17205b != null) {
                OfficialBarFeedMsglistAdapter.this.f17205b.a(view, this.f17215h, getAdapterPosition(), getItemId());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view, Object obj, int i2, long j);
    }

    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        this.f17204a = tbPageContext;
        this.f17205b = cVar;
    }

    public void d(ArrayList<? extends d.a.n0.g0.b.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f17206c.clear();
        this.f17206c.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d.a.n0.g0.b.a> arrayList = this.f17206c;
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
        ArrayList<d.a.n0.g0.b.a> arrayList = this.f17206c;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.a.n0.g0.b.a aVar = this.f17206c.get(i2);
        if ((viewHolder instanceof b) && (aVar instanceof a)) {
            ((b) viewHolder).a(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b(this.f17204a.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }
}
