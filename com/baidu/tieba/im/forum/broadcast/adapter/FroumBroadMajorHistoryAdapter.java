package com.baidu.tieba.im.forum.broadcast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.m.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FroumBroadMajorHistoryAdapter extends RecyclerView.Adapter<FroumBroadMajorHistoryItemViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17595a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.j0.e1.i.a.b.b> f17596b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public f<d.b.j0.e1.i.a.b.b> f17597c;

    /* loaded from: classes4.dex */
    public static class FroumBroadMajorHistoryItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17598a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17599b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17600c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17601d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17602e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17603f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17604g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f17605h;
        public TextView i;
        public LinearLayout j;
        public LinearLayout k;
        public LinearLayout l;
        public LinearLayout m;
        public BarImageView n;
        public TbImageView o;
        public View p;
        public View q;
        public View r;
        public TBSpecificationBtn s;
        public RelativeLayout t;

        public FroumBroadMajorHistoryItemViewHolder(View view) {
            super(view);
            this.f17598a = (TextView) view.findViewById(R.id.bcast_time);
            this.f17599b = (TextView) view.findViewById(R.id.forum_name);
            this.f17600c = (TextView) view.findViewById(R.id.bcast_title);
            this.f17601d = (TextView) view.findViewById(R.id.bcast_content);
            this.f17602e = (TextView) view.findViewById(R.id.publish_number);
            this.f17603f = (TextView) view.findViewById(R.id.pv_number);
            this.f17604g = (TextView) view.findViewById(R.id.ctr_number);
            this.j = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.k = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.n = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.o = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.p = view.findViewById(R.id.forum_bg_line);
            this.l = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.f17605h = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.s = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.m = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.t = (RelativeLayout) view.findViewById(R.id.container_image);
            this.i = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.r = view.findViewById(R.id.bg_item_mian_view);
            this.q = view.findViewById(R.id.gradient_cover);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.e1.i.a.b.b f17606e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17607f;

        public a(d.b.j0.e1.i.a.b.b bVar, int i) {
            this.f17606e = bVar;
            this.f17607f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FroumBroadMajorHistoryAdapter.this.f17597c != null) {
                f fVar = FroumBroadMajorHistoryAdapter.this.f17597c;
                d.b.j0.e1.i.a.b.b bVar = this.f17606e;
                int i = this.f17607f;
                fVar.a(view, bVar, i, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.e1.i.a.b.b f17609e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17610f;

        public b(d.b.j0.e1.i.a.b.b bVar, int i) {
            this.f17609e = bVar;
            this.f17610f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FroumBroadMajorHistoryAdapter.this.f17597c != null) {
                f fVar = FroumBroadMajorHistoryAdapter.this.f17597c;
                d.b.j0.e1.i.a.b.b bVar = this.f17609e;
                int i = this.f17610f;
                fVar.a(view, bVar, i, i);
            }
        }
    }

    public FroumBroadMajorHistoryAdapter(Context context) {
        this.f17595a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(@NonNull FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, int i) {
        d.b.j0.e1.i.a.b.b bVar = this.f17596b.get(i);
        if (bVar == null) {
            return;
        }
        if (i == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.f17598a.getLayoutParams();
            layoutParams.topMargin = this.f17595a.getResources().getDimensionPixelOffset(R.dimen.tbds62);
            froumBroadMajorHistoryItemViewHolder.f17598a.setLayoutParams(layoutParams);
        }
        if (TimeHelper.isSameYear(bVar.g() * 1000)) {
            froumBroadMajorHistoryItemViewHolder.f17598a.setText(StringHelper.getDateStringMHH(bVar.g() * 1000));
        } else {
            froumBroadMajorHistoryItemViewHolder.f17598a.setText(StringHelper.getDateStringYMH(bVar.g() * 1000));
        }
        if (StringUtils.isNull(bVar.f())) {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.i.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.i.setText(bVar.k());
        } else {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.i.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f17600c.setText(bVar.k());
            froumBroadMajorHistoryItemViewHolder.o.setConrers(15);
            froumBroadMajorHistoryItemViewHolder.o.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            froumBroadMajorHistoryItemViewHolder.o.setDrawCorner(true);
            froumBroadMajorHistoryItemViewHolder.o.setPlaceHolder(2);
            froumBroadMajorHistoryItemViewHolder.o.W(bVar.f(), 10, false);
            froumBroadMajorHistoryItemViewHolder.o.setGifIconSupport(false);
        }
        if (StringUtils.isNull(bVar.c())) {
            froumBroadMajorHistoryItemViewHolder.f17601d.setVisibility(8);
        } else {
            froumBroadMajorHistoryItemViewHolder.f17601d.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f17601d.setText(bVar.c());
        }
        froumBroadMajorHistoryItemViewHolder.f17599b.setText(bVar.e().forum_name);
        froumBroadMajorHistoryItemViewHolder.n.setShowOval(true);
        froumBroadMajorHistoryItemViewHolder.n.setAutoChangeStyle(true);
        froumBroadMajorHistoryItemViewHolder.n.setStrokeWith(l.g(this.f17595a, R.dimen.tbds1));
        froumBroadMajorHistoryItemViewHolder.n.setStrokeColorResId(R.color.CAM_X0401);
        froumBroadMajorHistoryItemViewHolder.n.setShowOuterBorder(false);
        froumBroadMajorHistoryItemViewHolder.n.setShowInnerBorder(true);
        froumBroadMajorHistoryItemViewHolder.n.setPlaceHolder(1);
        froumBroadMajorHistoryItemViewHolder.n.W(bVar.e().avatar, 10, false);
        froumBroadMajorHistoryItemViewHolder.f17602e.setText(this.f17595a.getString(R.string.forum_broadcast_major_history_reacht_number, StringHelper.numberUniformFormatExtraWithRoundVote(bVar.h())));
        froumBroadMajorHistoryItemViewHolder.f17603f.setText(this.f17595a.getString(R.string.forum_broadcast_major_history_read_number, StringHelper.numberUniformFormatExtraWithRoundVote(bVar.i())));
        int parseFloat = (int) (Float.parseFloat(bVar.d()) * 100.0f);
        if (parseFloat < 0) {
            parseFloat = 0;
        } else if (parseFloat > 100) {
            parseFloat = 100;
        }
        if (!StringUtils.isNull(bVar.d())) {
            froumBroadMajorHistoryItemViewHolder.f17604g.setText(this.f17595a.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
        } else {
            froumBroadMajorHistoryItemViewHolder.f17604g.setText("0%");
        }
        if (bVar.j() == null) {
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f17605h.setText(this.f17595a.getString(R.string.forum_broadcast_major_history_pb_deleted));
            if (bVar.a() == 1 || bVar.a() == 6) {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            } else {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
            }
        } else if (bVar.j().is_deleted.intValue() == 1) {
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f17605h.setText(this.f17595a.getString(R.string.forum_broadcast_major_history_pb_deleted));
            if (bVar.a() == 1 || bVar.a() == 6) {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            } else {
                froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
                froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
            }
        } else if (bVar.a() == 1) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f17605h.setText(this.f17595a.getString(R.string.video_review_state));
        } else if (bVar.a() == 6) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f17605h.setText(this.f17595a.getString(R.string.forum_broadcast_major_history_check_failed));
            froumBroadMajorHistoryItemViewHolder.s.setText(this.f17595a.getString(R.string.edit));
            froumBroadMajorHistoryItemViewHolder.s.setTextSize(R.dimen.tbds34);
            d.b.i0.r.f0.m.b bVar2 = new d.b.i0.r.f0.m.b();
            bVar2.q(R.color.CAM_X0302);
            froumBroadMajorHistoryItemViewHolder.s.setConfig(bVar2);
            froumBroadMajorHistoryItemViewHolder.s.setOnClickListener(new a(bVar, i));
        } else if (bVar.a() == 10) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(8);
        }
        froumBroadMajorHistoryItemViewHolder.k.setOnClickListener(new b(bVar, i));
        e(froumBroadMajorHistoryItemViewHolder, bVar, i);
    }

    public final void e(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, d.b.j0.e1.i.a.b.b bVar, int i) {
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17598a, R.color.CAM_X0109);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17599b, R.color.CAM_X0105);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17600c, R.color.CAM_X0101);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17601d, R.color.CAM_X0107);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17602e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17603f, R.color.CAM_X0107);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17604g, R.color.CAM_X0107);
        SkinManager.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.p, R.color.CAM_X0203);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.i, R.color.CAM_X0105);
        TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606).blRadius(l.g(this.f17595a, R.dimen.tbds21)).brRadius(l.g(this.f17595a, R.dimen.tbds21)).into(froumBroadMajorHistoryItemViewHolder.q);
        if (TbadkCoreApplication.getInst().getSkinType() != 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.k.getLayoutParams();
            layoutParams.leftMargin = l.g(this.f17595a, R.dimen.tbds21);
            layoutParams.rightMargin = l.g(this.f17595a, R.dimen.tbds21);
            layoutParams.topMargin = l.g(this.f17595a, R.dimen.tbds21);
            froumBroadMajorHistoryItemViewHolder.k.setLayoutParams(layoutParams);
            froumBroadMajorHistoryItemViewHolder.k.setPadding(0, 0, 0, this.f17595a.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            froumBroadMajorHistoryItemViewHolder.r.setVisibility(8);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f17595a, R.dimen.tbds31)).defaultColor(R.color.CAM_X0205).into(froumBroadMajorHistoryItemViewHolder.k);
        } else {
            if (i != 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.f17598a.getLayoutParams();
                layoutParams2.topMargin = this.f17595a.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                froumBroadMajorHistoryItemViewHolder.f17598a.setLayoutParams(layoutParams2);
            }
            froumBroadMajorHistoryItemViewHolder.k.setPadding(this.f17595a.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.f17595a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.f17595a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.f17595a.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            froumBroadMajorHistoryItemViewHolder.r.setVisibility(0);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.f17595a, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f17595a, R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.f17595a, R.dimen.tbds5)).into(froumBroadMajorHistoryItemViewHolder.r);
        }
        if (bVar.j() == null) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17605h, R.color.CAM_X0109);
        } else if (bVar.j().is_deleted.intValue() == 1) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17605h, R.color.CAM_X0109);
        } else if (bVar.a() == 1) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17605h, R.color.CAM_X0107);
        } else if (bVar.a() == 6) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17605h, R.color.CAM_X0301);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public FroumBroadMajorHistoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FroumBroadMajorHistoryItemViewHolder(LayoutInflater.from(this.f17595a).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false));
    }

    public void g(f<d.b.j0.e1.i.a.b.b> fVar) {
        this.f17597c = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d.b.j0.e1.i.a.b.b> list = this.f17596b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void h(List<d.b.j0.e1.i.a.b.b> list) {
        if (list != null) {
            this.f17596b = list;
            notifyDataSetChanged();
        }
    }
}
