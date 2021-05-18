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
    public TbPageContext<?> f17136a;

    /* renamed from: b  reason: collision with root package name */
    public c f17137b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<d.a.j0.g0.b.a> f17138c = new ArrayList<>();

    /* loaded from: classes4.dex */
    public static class a implements d.a.j0.g0.b.a {

        /* renamed from: e  reason: collision with root package name */
        public String f17139e;

        /* renamed from: f  reason: collision with root package name */
        public String f17140f;

        /* renamed from: g  reason: collision with root package name */
        public long f17141g;

        /* renamed from: h  reason: collision with root package name */
        public int f17142h;

        /* renamed from: i  reason: collision with root package name */
        public long f17143i;

        public String a() {
            return this.f17139e;
        }

        public String b() {
            return this.f17140f;
        }

        public long d() {
            return this.f17141g;
        }

        public int e() {
            return this.f17142h;
        }

        public long g() {
            return this.f17143i;
        }

        public void h(String str) {
            this.f17139e = str;
        }

        public void j(String str) {
            this.f17140f = str;
        }

        public void l(long j) {
            this.f17141g = j;
        }

        public void m(int i2) {
            this.f17142h = i2;
        }

        public void n(int i2) {
        }

        public void p(long j) {
            this.f17143i = j;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public BarImageView f17144e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17145f;

        /* renamed from: g  reason: collision with root package name */
        public View f17146g;

        /* renamed from: h  reason: collision with root package name */
        public a f17147h;

        public b(View view) {
            super(view);
            this.f17144e = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.f17145f = (TextView) view.findViewById(R.id.official_bar_name);
            this.f17146g = view.findViewById(R.id.official_bar_feed_red_dot);
            this.f17144e.setShowOval(true);
            this.f17144e.setPlaceHolder(2);
            this.f17144e.setShowOuterBorder(false);
            this.f17144e.setShowInnerBorder(true);
            this.f17144e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        public void a(d.a.j0.g0.b.a aVar) {
            this.f17147h = (a) aVar;
            SkinManager.setViewTextColor(this.f17145f, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f17146g, R.drawable.icon_official_bar_red_dot);
            this.f17144e.setStrokeColorResId(R.color.CAM_X0401);
            this.f17144e.V(this.f17147h.a(), 10, false);
            if (StringHelper.getChineseAndEnglishLength(this.f17147h.b()) <= 10) {
                this.f17145f.setText(this.f17147h.b());
            } else {
                this.f17145f.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f17147h.b(), 8, StringHelper.STRING_MORE));
            }
            this.f17144e.setOnClickListener(this);
            if (this.f17147h.e() > 0 && (this.f17147h.g() <= 0 || System.currentTimeMillis() - this.f17147h.g() < ImageLoader.f3755d)) {
                this.f17146g.setVisibility(0);
            } else {
                this.f17146g.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f17146g.setVisibility(8);
            if (OfficialBarFeedMsglistAdapter.this.f17137b != null) {
                OfficialBarFeedMsglistAdapter.this.f17137b.a(view, this.f17147h, getAdapterPosition(), getItemId());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view, Object obj, int i2, long j);
    }

    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        this.f17136a = tbPageContext;
        this.f17137b = cVar;
    }

    public void d(ArrayList<? extends d.a.j0.g0.b.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.f17138c.clear();
        this.f17138c.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<d.a.j0.g0.b.a> arrayList = this.f17138c;
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
        ArrayList<d.a.j0.g0.b.a> arrayList = this.f17138c;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        d.a.j0.g0.b.a aVar = this.f17138c.get(i2);
        if ((viewHolder instanceof b) && (aVar instanceof a)) {
            ((b) viewHolder).a(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b(this.f17136a.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }
}
