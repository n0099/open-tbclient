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
import d.b.b.e.p.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class OfficialBarFeedMsglistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f17823a;

    /* renamed from: b  reason: collision with root package name */
    public c f17824b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<d.b.h0.g0.b.a> f17825c = new ArrayList<>();

    /* loaded from: classes3.dex */
    public static class a implements d.b.h0.g0.b.a {

        /* renamed from: e  reason: collision with root package name */
        public String f17826e;

        /* renamed from: f  reason: collision with root package name */
        public String f17827f;

        /* renamed from: g  reason: collision with root package name */
        public long f17828g;

        /* renamed from: h  reason: collision with root package name */
        public int f17829h;
        public long i;

        public String b() {
            return this.f17826e;
        }

        public String c() {
            return this.f17827f;
        }

        public long d() {
            return this.f17828g;
        }

        public int f() {
            return this.f17829h;
        }

        public long g() {
            return this.i;
        }

        public void h(String str) {
            this.f17826e = str;
        }

        public void i(String str) {
            this.f17827f = str;
        }

        public void j(long j) {
            this.f17828g = j;
        }

        public void m(int i) {
            this.f17829h = i;
        }

        public void n(int i) {
        }

        public void o(long j) {
            this.i = j;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public BarImageView f17830e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17831f;

        /* renamed from: g  reason: collision with root package name */
        public View f17832g;

        /* renamed from: h  reason: collision with root package name */
        public a f17833h;

        public b(View view) {
            super(view);
            this.f17830e = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.f17831f = (TextView) view.findViewById(R.id.official_bar_name);
            this.f17832g = view.findViewById(R.id.official_bar_feed_red_dot);
            this.f17830e.setShowOval(true);
            this.f17830e.setPlaceHolder(2);
            this.f17830e.setShowOuterBorder(false);
            this.f17830e.setShowInnerBorder(true);
            this.f17830e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        public void a(d.b.h0.g0.b.a aVar) {
            this.f17833h = (a) aVar;
            SkinManager.setViewTextColor(this.f17831f, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f17832g, R.drawable.icon_official_bar_red_dot);
            this.f17830e.setStrokeColorResId(R.color.CAM_X0401);
            this.f17830e.W(this.f17833h.b(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(this.f17833h.c()) <= 10) {
                this.f17831f.setText(this.f17833h.c());
            } else {
                this.f17831f.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f17833h.c(), 8, StringHelper.STRING_MORE));
            }
            this.f17830e.setOnClickListener(this);
            if (this.f17833h.f() > 0 && (this.f17833h.g() <= 0 || System.currentTimeMillis() - this.f17833h.g() < ImageLoader.f3673d)) {
                this.f17832g.setVisibility(0);
            } else {
                this.f17832g.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17832g.setVisibility(8);
            if (OfficialBarFeedMsglistAdapter.this.f17824b != null) {
                OfficialBarFeedMsglistAdapter.this.f17824b.a(view, this.f17833h, getAdapterPosition(), getItemId());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        this.f17823a = tbPageContext;
        this.f17824b = cVar;
    }

    public void d(ArrayList<? extends d.b.h0.g0.b.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f17825c.clear();
        this.f17825c.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d.b.h0.g0.b.a> arrayList = this.f17825c;
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
        ArrayList<d.b.h0.g0.b.a> arrayList = this.f17825c;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.b.h0.g0.b.a aVar = this.f17825c.get(i);
        if ((viewHolder instanceof b) && (aVar instanceof a)) {
            ((b) viewHolder).a(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.f17823a.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }
}
