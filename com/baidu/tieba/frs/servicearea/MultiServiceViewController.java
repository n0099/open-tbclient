package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.b.e.p.l;
import d.b.i0.c3.a0;
import d.b.i0.c3.b0;
import d.b.i0.p0.g2.b;
import d.b.i0.p0.g2.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MultiServiceViewController implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f16573a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f16574b;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f16576d;

    /* renamed from: c  reason: collision with root package name */
    public List<b0> f16575c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f16577e = new a();

    /* loaded from: classes4.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f16578a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f16579b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f16580c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16581d;

        /* renamed from: e  reason: collision with root package name */
        public b0 f16582e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f16583f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f16584g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f16585h;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.equals(view.getResources().getString(R.string.hot_user_rank), ServiceViewHolder.this.f16582e.f53317b) || ServiceViewHolder.this.f16584g == null || ServiceViewHolder.this.f16584g.getForum() == null || TextUtils.isEmpty(ServiceViewHolder.this.f16584g.getForum().getId())) {
                    if (ServiceViewHolder.this.f16582e != null && ServiceViewHolder.this.f16582e.f53321f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", ServiceViewHolder.this.f16582e.f53322g).param("obj_source", "frs_card").param("obj_id", ServiceViewHolder.this.f16582e.f53321f.f53325b).param("obj_name", ServiceViewHolder.this.f16582e.f53321f.f53324a).param("obj_param1", ServiceViewHolder.this.f16582e.f53321f.f53327d.intValue()));
                    }
                    d.a(view.getContext(), ServiceViewHolder.this.f16582e);
                    d.b(ServiceViewHolder.this.f16582e);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(d.b.b.e.m.b.f(ServiceViewHolder.this.f16584g.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", ServiceViewHolder.this.f16584g.getForum().getId());
                TiebaStatic.log(statisticItem);
            }
        }

        public ServiceViewHolder(View view, FrsViewData frsViewData) {
            super(view);
            this.f16583f = new ArrayList();
            this.f16585h = new a();
            Context context = view.getContext();
            this.f16584g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.f16578a = linearLayout;
            linearLayout.setGravity(16);
            this.f16578a.setOrientation(0);
            this.f16579b = new FrameLayout(context);
            this.f16580c = new TbClipImageView(context);
            int g2 = l.g(context, R.dimen.tbds57);
            this.f16580c.setDrawerType(1);
            this.f16580c.setIsRound(true);
            this.f16580c.setBorderWidth(R.dimen.L_X01);
            this.f16580c.setBorderColor(R.color.CAM_X0401);
            this.f16580c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f16580c.setPlaceHolder(1);
            this.f16579b.addView(this.f16580c, new FrameLayout.LayoutParams(g2, g2));
            this.f16578a.addView(this.f16579b, new LinearLayout.LayoutParams(-2, l.g(this.f16580c.getContext(), R.dimen.tbds62)));
            TextView textView = new TextView(context);
            this.f16581d = textView;
            textView.setTextSize(0, l.g(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.g(context, R.dimen.tbds10);
            layoutParams.rightMargin = l.g(context, R.dimen.M_W_X008);
            this.f16578a.addView(this.f16581d, layoutParams);
            view.setOnClickListener(this.f16585h);
        }

        public void c(b0 b0Var) {
            if (b0Var == null) {
                return;
            }
            this.f16582e = b0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), b0Var.f53317b)) {
                this.f16580c.setImageResource(R.drawable.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f16580c.getLayoutParams();
                layoutParams.width = l.g(this.f16580c.getContext(), R.dimen.tbds62);
                layoutParams.height = l.g(this.f16580c.getContext(), R.dimen.tbds62);
            } else {
                this.f16580c.W(b0Var.f53317b, 10, false);
            }
            this.f16581d.setText(StringHelper.cutChineseAndEnglishWithSuffix(b0Var.f53318c, 10, ""));
            SkinManager.setViewTextColor(this.f16581d, R.color.CAM_X0105);
            if (this.f16583f.contains(b0Var.f53318c)) {
                return;
            }
            d.c(b0Var);
            this.f16583f.add(b0Var.f53318c);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.Adapter<ServiceViewHolder> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i) {
            serviceViewHolder.c((b0) MultiServiceViewController.this.f16575c.get(i));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), MultiServiceViewController.this.f16576d);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return MultiServiceViewController.this.f16575c.size();
        }
    }

    public MultiServiceViewController(Context context) {
        this.f16573a = context;
        this.f16574b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f16574b.setLayoutManager(linearLayoutManager);
        this.f16574b.setAdapter(this.f16577e);
    }

    @Override // d.b.i0.p0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        if (a0Var == null || ListUtils.isEmpty(a0Var.f53315b)) {
            return;
        }
        this.f16575c = a0Var.f53315b;
        this.f16576d = frsViewData;
        this.f16577e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f16574b;
        recyclerView.setPadding(l.g(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
        this.f16574b.setClipToPadding(false);
    }

    @Override // d.b.i0.p0.g2.b
    public View getView() {
        return this.f16574b;
    }

    @Override // d.b.i0.p0.g2.b
    public void onChangeSkinType(int i) {
        this.f16577e.notifyDataSetChanged();
    }
}
