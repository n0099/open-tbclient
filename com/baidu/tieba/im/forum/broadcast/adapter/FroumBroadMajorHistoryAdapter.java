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
import d.a.c.e.p.l;
import d.a.m0.m.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FroumBroadMajorHistoryAdapter extends RecyclerView.Adapter<FroumBroadMajorHistoryItemViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17139a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.n0.f1.i.a.b.b> f17140b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public f<d.a.n0.f1.i.a.b.b> f17141c;

    /* loaded from: classes4.dex */
    public static class FroumBroadMajorHistoryItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17142a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17143b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17144c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17145d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17146e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17147f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17148g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f17149h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f17150i;
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
            this.f17142a = (TextView) view.findViewById(R.id.bcast_time);
            this.f17143b = (TextView) view.findViewById(R.id.forum_name);
            this.f17144c = (TextView) view.findViewById(R.id.bcast_title);
            this.f17145d = (TextView) view.findViewById(R.id.bcast_content);
            this.f17146e = (TextView) view.findViewById(R.id.publish_number);
            this.f17147f = (TextView) view.findViewById(R.id.pv_number);
            this.f17148g = (TextView) view.findViewById(R.id.ctr_number);
            this.j = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.k = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.n = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.o = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.p = view.findViewById(R.id.forum_bg_line);
            this.l = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.f17149h = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.s = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.m = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.t = (RelativeLayout) view.findViewById(R.id.container_image);
            this.f17150i = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.r = view.findViewById(R.id.bg_item_mian_view);
            this.q = view.findViewById(R.id.gradient_cover);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.f1.i.a.b.b f17151e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17152f;

        public a(d.a.n0.f1.i.a.b.b bVar, int i2) {
            this.f17151e = bVar;
            this.f17152f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FroumBroadMajorHistoryAdapter.this.f17141c != null) {
                f fVar = FroumBroadMajorHistoryAdapter.this.f17141c;
                d.a.n0.f1.i.a.b.b bVar = this.f17151e;
                int i2 = this.f17152f;
                fVar.a(view, bVar, i2, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.f1.i.a.b.b f17154e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17155f;

        public b(d.a.n0.f1.i.a.b.b bVar, int i2) {
            this.f17154e = bVar;
            this.f17155f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FroumBroadMajorHistoryAdapter.this.f17141c != null) {
                f fVar = FroumBroadMajorHistoryAdapter.this.f17141c;
                d.a.n0.f1.i.a.b.b bVar = this.f17154e;
                int i2 = this.f17155f;
                fVar.a(view, bVar, i2, i2);
            }
        }
    }

    public FroumBroadMajorHistoryAdapter(Context context) {
        this.f17139a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(@NonNull FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, int i2) {
        d.a.n0.f1.i.a.b.b bVar = this.f17140b.get(i2);
        if (bVar == null) {
            return;
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.f17142a.getLayoutParams();
            layoutParams.topMargin = this.f17139a.getResources().getDimensionPixelOffset(R.dimen.tbds62);
            froumBroadMajorHistoryItemViewHolder.f17142a.setLayoutParams(layoutParams);
        }
        if (TimeHelper.isSameYear(bVar.g() * 1000)) {
            froumBroadMajorHistoryItemViewHolder.f17142a.setText(StringHelper.getDateStringMHH(bVar.g() * 1000));
        } else {
            froumBroadMajorHistoryItemViewHolder.f17142a.setText(StringHelper.getDateStringYMH(bVar.g() * 1000));
        }
        if (StringUtils.isNull(bVar.f())) {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f17150i.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f17150i.setText(bVar.k());
        } else {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f17150i.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f17144c.setText(bVar.k());
            froumBroadMajorHistoryItemViewHolder.o.setConrers(15);
            froumBroadMajorHistoryItemViewHolder.o.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            froumBroadMajorHistoryItemViewHolder.o.setDrawCorner(true);
            froumBroadMajorHistoryItemViewHolder.o.setPlaceHolder(2);
            froumBroadMajorHistoryItemViewHolder.o.V(bVar.f(), 10, false);
            froumBroadMajorHistoryItemViewHolder.o.setGifIconSupport(false);
        }
        if (StringUtils.isNull(bVar.c())) {
            froumBroadMajorHistoryItemViewHolder.f17145d.setVisibility(8);
        } else {
            froumBroadMajorHistoryItemViewHolder.f17145d.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f17145d.setText(bVar.c());
        }
        froumBroadMajorHistoryItemViewHolder.f17143b.setText(bVar.e().forum_name);
        froumBroadMajorHistoryItemViewHolder.n.setShowOval(true);
        froumBroadMajorHistoryItemViewHolder.n.setAutoChangeStyle(true);
        froumBroadMajorHistoryItemViewHolder.n.setStrokeWith(l.g(this.f17139a, R.dimen.tbds1));
        froumBroadMajorHistoryItemViewHolder.n.setStrokeColorResId(R.color.CAM_X0401);
        froumBroadMajorHistoryItemViewHolder.n.setShowOuterBorder(false);
        froumBroadMajorHistoryItemViewHolder.n.setShowInnerBorder(true);
        froumBroadMajorHistoryItemViewHolder.n.setPlaceHolder(1);
        froumBroadMajorHistoryItemViewHolder.n.V(bVar.e().avatar, 10, false);
        froumBroadMajorHistoryItemViewHolder.f17146e.setText(this.f17139a.getString(R.string.forum_broadcast_major_history_reacht_number, StringHelper.numberUniformFormatExtraWithRoundVote(bVar.h())));
        froumBroadMajorHistoryItemViewHolder.f17147f.setText(this.f17139a.getString(R.string.forum_broadcast_major_history_read_number, StringHelper.numberUniformFormatExtraWithRoundVote(bVar.i())));
        int parseFloat = (int) (Float.parseFloat(bVar.d()) * 100.0f);
        if (parseFloat < 0) {
            parseFloat = 0;
        } else if (parseFloat > 100) {
            parseFloat = 100;
        }
        if (!StringUtils.isNull(bVar.d())) {
            froumBroadMajorHistoryItemViewHolder.f17148g.setText(this.f17139a.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
        } else {
            froumBroadMajorHistoryItemViewHolder.f17148g.setText("0%");
        }
        if (bVar.j() == null) {
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f17149h.setText(this.f17139a.getString(R.string.forum_broadcast_major_history_pb_deleted));
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
            froumBroadMajorHistoryItemViewHolder.f17149h.setText(this.f17139a.getString(R.string.forum_broadcast_major_history_pb_deleted));
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
            froumBroadMajorHistoryItemViewHolder.f17149h.setText(this.f17139a.getString(R.string.video_review_state));
        } else if (bVar.a() == 6) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f17149h.setText(this.f17139a.getString(R.string.forum_broadcast_major_history_check_failed));
            froumBroadMajorHistoryItemViewHolder.s.setText(this.f17139a.getString(R.string.edit));
            froumBroadMajorHistoryItemViewHolder.s.setTextSize(R.dimen.tbds34);
            d.a.m0.r.f0.m.b bVar2 = new d.a.m0.r.f0.m.b();
            bVar2.q(R.color.CAM_X0302);
            froumBroadMajorHistoryItemViewHolder.s.setConfig(bVar2);
            froumBroadMajorHistoryItemViewHolder.s.setOnClickListener(new a(bVar, i2));
        } else if (bVar.a() == 10) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(8);
        }
        froumBroadMajorHistoryItemViewHolder.k.setOnClickListener(new b(bVar, i2));
        e(froumBroadMajorHistoryItemViewHolder, bVar, i2);
    }

    public final void e(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, d.a.n0.f1.i.a.b.b bVar, int i2) {
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17142a, R.color.CAM_X0109);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17143b, R.color.CAM_X0105);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17144c, R.color.CAM_X0101);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17145d, R.color.CAM_X0107);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17146e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17147f, R.color.CAM_X0107);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17148g, R.color.CAM_X0107);
        SkinManager.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.p, R.color.CAM_X0203);
        SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17150i, R.color.CAM_X0105);
        TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606).blRadius(l.g(this.f17139a, R.dimen.tbds21)).brRadius(l.g(this.f17139a, R.dimen.tbds21)).into(froumBroadMajorHistoryItemViewHolder.q);
        if (TbadkCoreApplication.getInst().getSkinType() != 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.k.getLayoutParams();
            layoutParams.leftMargin = l.g(this.f17139a, R.dimen.tbds21);
            layoutParams.rightMargin = l.g(this.f17139a, R.dimen.tbds21);
            layoutParams.topMargin = l.g(this.f17139a, R.dimen.tbds21);
            froumBroadMajorHistoryItemViewHolder.k.setLayoutParams(layoutParams);
            froumBroadMajorHistoryItemViewHolder.k.setPadding(0, 0, 0, this.f17139a.getResources().getDimensionPixelOffset(R.dimen.tbds54));
            froumBroadMajorHistoryItemViewHolder.r.setVisibility(8);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f17139a, R.dimen.tbds31)).defaultColor(R.color.CAM_X0205).into(froumBroadMajorHistoryItemViewHolder.k);
        } else {
            if (i2 != 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.f17142a.getLayoutParams();
                layoutParams2.topMargin = this.f17139a.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                froumBroadMajorHistoryItemViewHolder.f17142a.setLayoutParams(layoutParams2);
            }
            froumBroadMajorHistoryItemViewHolder.k.setPadding(this.f17139a.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.f17139a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.f17139a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.f17139a.getResources().getDimensionPixelOffset(R.dimen.tbds75));
            froumBroadMajorHistoryItemViewHolder.r.setVisibility(0);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.f17139a, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f17139a, R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.f17139a, R.dimen.tbds5)).into(froumBroadMajorHistoryItemViewHolder.r);
        }
        if (bVar.j() == null) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17149h, R.color.CAM_X0109);
        } else if (bVar.j().is_deleted.intValue() == 1) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17149h, R.color.CAM_X0109);
        } else if (bVar.a() == 1) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17149h, R.color.CAM_X0107);
        } else if (bVar.a() == 6) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17149h, R.color.CAM_X0301);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public FroumBroadMajorHistoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new FroumBroadMajorHistoryItemViewHolder(LayoutInflater.from(this.f17139a).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false));
    }

    public void g(f<d.a.n0.f1.i.a.b.b> fVar) {
        this.f17141c = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d.a.n0.f1.i.a.b.b> list = this.f17140b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void h(List<d.a.n0.f1.i.a.b.b> list) {
        if (list != null) {
            this.f17140b = list;
            notifyDataSetChanged();
        }
    }
}
