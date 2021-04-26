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
import d.a.c.e.p.l;
import d.a.j0.d3.a0;
import d.a.j0.d3.b0;
import d.a.j0.q0.g2.b;
import d.a.j0.q0.g2.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MultiServiceViewController implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f16458a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f16459b;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f16461d;

    /* renamed from: c  reason: collision with root package name */
    public List<b0> f16460c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f16462e = new a();

    /* loaded from: classes4.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f16463a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f16464b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f16465c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16466d;

        /* renamed from: e  reason: collision with root package name */
        public b0 f16467e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f16468f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f16469g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f16470h;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.equals(view.getResources().getString(R.string.hot_user_rank), ServiceViewHolder.this.f16467e.f53017b) || ServiceViewHolder.this.f16469g == null || ServiceViewHolder.this.f16469g.getForum() == null || TextUtils.isEmpty(ServiceViewHolder.this.f16469g.getForum().getId())) {
                    if (ServiceViewHolder.this.f16467e != null && ServiceViewHolder.this.f16467e.f53021f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", ServiceViewHolder.this.f16467e.f53022g).param("obj_source", "frs_card").param("obj_id", ServiceViewHolder.this.f16467e.f53021f.f53026b).param("obj_name", ServiceViewHolder.this.f16467e.f53021f.f53025a).param("obj_param1", ServiceViewHolder.this.f16467e.f53021f.f53028d.intValue()));
                    }
                    d.a(view.getContext(), ServiceViewHolder.this.f16467e);
                    d.b(ServiceViewHolder.this.f16467e);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(ServiceViewHolder.this.f16469g.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", ServiceViewHolder.this.f16469g.getForum().getId());
                TiebaStatic.log(statisticItem);
            }
        }

        public ServiceViewHolder(View view, FrsViewData frsViewData) {
            super(view);
            this.f16468f = new ArrayList();
            this.f16470h = new a();
            Context context = view.getContext();
            this.f16469g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.f16463a = linearLayout;
            linearLayout.setGravity(16);
            this.f16463a.setOrientation(0);
            this.f16464b = new FrameLayout(context);
            this.f16465c = new TbClipImageView(context);
            int g2 = l.g(context, R.dimen.tbds57);
            this.f16465c.setDrawerType(1);
            this.f16465c.setIsRound(true);
            this.f16465c.setBorderWidth(R.dimen.L_X01);
            this.f16465c.setBorderColor(R.color.CAM_X0401);
            this.f16465c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f16465c.setPlaceHolder(1);
            this.f16464b.addView(this.f16465c, new FrameLayout.LayoutParams(g2, g2));
            this.f16463a.addView(this.f16464b, new LinearLayout.LayoutParams(-2, l.g(this.f16465c.getContext(), R.dimen.tbds62)));
            TextView textView = new TextView(context);
            this.f16466d = textView;
            textView.setTextSize(0, l.g(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.g(context, R.dimen.tbds10);
            layoutParams.rightMargin = l.g(context, R.dimen.M_W_X008);
            this.f16463a.addView(this.f16466d, layoutParams);
            view.setOnClickListener(this.f16470h);
        }

        public void c(b0 b0Var) {
            if (b0Var == null) {
                return;
            }
            this.f16467e = b0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), b0Var.f53017b)) {
                this.f16465c.setImageResource(R.drawable.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f16465c.getLayoutParams();
                layoutParams.width = l.g(this.f16465c.getContext(), R.dimen.tbds62);
                layoutParams.height = l.g(this.f16465c.getContext(), R.dimen.tbds62);
            } else {
                this.f16465c.V(b0Var.f53017b, 10, false);
            }
            this.f16466d.setText(StringHelper.cutChineseAndEnglishWithSuffix(b0Var.f53018c, 10, ""));
            SkinManager.setViewTextColor(this.f16466d, R.color.CAM_X0105);
            if (this.f16468f.contains(b0Var.f53018c)) {
                return;
            }
            d.c(b0Var);
            this.f16468f.add(b0Var.f53018c);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.Adapter<ServiceViewHolder> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c */
        public void onBindViewHolder(ServiceViewHolder serviceViewHolder, int i2) {
            serviceViewHolder.c((b0) MultiServiceViewController.this.f16460c.get(i2));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            return new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), MultiServiceViewController.this.f16461d);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return MultiServiceViewController.this.f16460c.size();
        }
    }

    public MultiServiceViewController(Context context) {
        this.f16458a = context;
        this.f16459b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f16459b.setLayoutManager(linearLayoutManager);
        this.f16459b.setAdapter(this.f16462e);
    }

    @Override // d.a.j0.q0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        if (a0Var == null || ListUtils.isEmpty(a0Var.f53015b)) {
            return;
        }
        this.f16460c = a0Var.f53015b;
        this.f16461d = frsViewData;
        this.f16462e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f16459b;
        recyclerView.setPadding(l.g(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
        this.f16459b.setClipToPadding(false);
    }

    @Override // d.a.j0.q0.g2.b
    public View getView() {
        return this.f16459b;
    }

    @Override // d.a.j0.q0.g2.b
    public void onChangeSkinType(int i2) {
        this.f16462e.notifyDataSetChanged();
    }
}
