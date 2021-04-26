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
    public TbPageContext<?> f17821a;

    /* renamed from: b  reason: collision with root package name */
    public c f17822b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<d.a.i0.g0.b.a> f17823c = new ArrayList<>();

    /* loaded from: classes4.dex */
    public static class a implements d.a.i0.g0.b.a {

        /* renamed from: e  reason: collision with root package name */
        public String f17824e;

        /* renamed from: f  reason: collision with root package name */
        public String f17825f;

        /* renamed from: g  reason: collision with root package name */
        public long f17826g;

        /* renamed from: h  reason: collision with root package name */
        public int f17827h;

        /* renamed from: i  reason: collision with root package name */
        public long f17828i;

        public String a() {
            return this.f17824e;
        }

        public String b() {
            return this.f17825f;
        }

        public long d() {
            return this.f17826g;
        }

        public int e() {
            return this.f17827h;
        }

        public long g() {
            return this.f17828i;
        }

        public void h(String str) {
            this.f17824e = str;
        }

        public void j(String str) {
            this.f17825f = str;
        }

        public void l(long j) {
            this.f17826g = j;
        }

        public void m(int i2) {
            this.f17827h = i2;
        }

        public void n(int i2) {
        }

        public void p(long j) {
            this.f17828i = j;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public BarImageView f17829e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17830f;

        /* renamed from: g  reason: collision with root package name */
        public View f17831g;

        /* renamed from: h  reason: collision with root package name */
        public a f17832h;

        public b(View view) {
            super(view);
            this.f17829e = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.f17830f = (TextView) view.findViewById(R.id.official_bar_name);
            this.f17831g = view.findViewById(R.id.official_bar_feed_red_dot);
            this.f17829e.setShowOval(true);
            this.f17829e.setPlaceHolder(2);
            this.f17829e.setShowOuterBorder(false);
            this.f17829e.setShowInnerBorder(true);
            this.f17829e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        public void a(d.a.i0.g0.b.a aVar) {
            this.f17832h = (a) aVar;
            SkinManager.setViewTextColor(this.f17830f, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f17831g, R.drawable.icon_official_bar_red_dot);
            this.f17829e.setStrokeColorResId(R.color.CAM_X0401);
            this.f17829e.V(this.f17832h.a(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(this.f17832h.b()) <= 10) {
                this.f17830f.setText(this.f17832h.b());
            } else {
                this.f17830f.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f17832h.b(), 8, StringHelper.STRING_MORE));
            }
            this.f17829e.setOnClickListener(this);
            if (this.f17832h.e() > 0 && (this.f17832h.g() <= 0 || System.currentTimeMillis() - this.f17832h.g() < ImageLoader.f3754d)) {
                this.f17831g.setVisibility(0);
            } else {
                this.f17831g.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17831g.setVisibility(8);
            if (OfficialBarFeedMsglistAdapter.this.f17822b != null) {
                OfficialBarFeedMsglistAdapter.this.f17822b.a(view, this.f17832h, getAdapterPosition(), getItemId());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view, Object obj, int i2, long j);
    }

    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        this.f17821a = tbPageContext;
        this.f17822b = cVar;
    }

    public void d(ArrayList<? extends d.a.i0.g0.b.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f17823c.clear();
        this.f17823c.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d.a.i0.g0.b.a> arrayList = this.f17823c;
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
        ArrayList<d.a.i0.g0.b.a> arrayList = this.f17823c;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.a.i0.g0.b.a aVar = this.f17823c.get(i2);
        if ((viewHolder instanceof b) && (aVar instanceof a)) {
            ((b) viewHolder).a(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b(this.f17821a.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }
}
