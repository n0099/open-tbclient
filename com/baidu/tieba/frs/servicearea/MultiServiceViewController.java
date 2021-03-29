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
    public final Context f16574a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f16575b;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f16577d;

    /* renamed from: c  reason: collision with root package name */
    public List<b0> f16576c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f16578e = new a();

    /* loaded from: classes4.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f16579a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f16580b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f16581c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16582d;

        /* renamed from: e  reason: collision with root package name */
        public b0 f16583e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f16584f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f16585g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f16586h;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.equals(view.getResources().getString(R.string.hot_user_rank), ServiceViewHolder.this.f16583e.f53318b) || ServiceViewHolder.this.f16585g == null || ServiceViewHolder.this.f16585g.getForum() == null || TextUtils.isEmpty(ServiceViewHolder.this.f16585g.getForum().getId())) {
                    if (ServiceViewHolder.this.f16583e != null && ServiceViewHolder.this.f16583e.f53322f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", ServiceViewHolder.this.f16583e.f53323g).param("obj_source", "frs_card").param("obj_id", ServiceViewHolder.this.f16583e.f53322f.f53326b).param("obj_name", ServiceViewHolder.this.f16583e.f53322f.f53325a).param("obj_param1", ServiceViewHolder.this.f16583e.f53322f.f53328d.intValue()));
                    }
                    d.a(view.getContext(), ServiceViewHolder.this.f16583e);
                    d.b(ServiceViewHolder.this.f16583e);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(d.b.b.e.m.b.f(ServiceViewHolder.this.f16585g.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", ServiceViewHolder.this.f16585g.getForum().getId());
                TiebaStatic.log(statisticItem);
            }
        }

        public ServiceViewHolder(View view, FrsViewData frsViewData) {
            super(view);
            this.f16584f = new ArrayList();
            this.f16586h = new a();
            Context context = view.getContext();
            this.f16585g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.f16579a = linearLayout;
            linearLayout.setGravity(16);
            this.f16579a.setOrientation(0);
            this.f16580b = new FrameLayout(context);
            this.f16581c = new TbClipImageView(context);
            int g2 = l.g(context, R.dimen.tbds57);
            this.f16581c.setDrawerType(1);
            this.f16581c.setIsRound(true);
            this.f16581c.setBorderWidth(R.dimen.L_X01);
            this.f16581c.setBorderColor(R.color.CAM_X0401);
            this.f16581c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f16581c.setPlaceHolder(1);
            this.f16580b.addView(this.f16581c, new FrameLayout.LayoutParams(g2, g2));
            this.f16579a.addView(this.f16580b, new LinearLayout.LayoutParams(-2, l.g(this.f16581c.getContext(), R.dimen.tbds62)));
            TextView textView = new TextView(context);
            this.f16582d = textView;
            textView.setTextSize(0, l.g(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.g(context, R.dimen.tbds10);
            layoutParams.rightMargin = l.g(context, R.dimen.M_W_X008);
            this.f16579a.addView(this.f16582d, layoutParams);
            view.setOnClickListener(this.f16586h);
        }

        public void c(b0 b0Var) {
            if (b0Var == null) {
                return;
            }
            this.f16583e = b0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), b0Var.f53318b)) {
                this.f16581c.setImageResource(R.drawable.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f16581c.getLayoutParams();
                layoutParams.width = l.g(this.f16581c.getContext(), R.dimen.tbds62);
                layoutParams.height = l.g(this.f16581c.getContext(), R.dimen.tbds62);
            } else {
                this.f16581c.W(b0Var.f53318b, 10, false);
            }
            this.f16582d.setText(StringHelper.cutChineseAndEnglishWithSuffix(b0Var.f53319c, 10, ""));
            SkinManager.setViewTextColor(this.f16582d, R.color.CAM_X0105);
            if (this.f16584f.contains(b0Var.f53319c)) {
                return;
            }
            d.c(b0Var);
            this.f16584f.add(b0Var.f53319c);
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
            serviceViewHolder.c((b0) MultiServiceViewController.this.f16576c.get(i));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), MultiServiceViewController.this.f16577d);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return MultiServiceViewController.this.f16576c.size();
        }
    }

    public MultiServiceViewController(Context context) {
        this.f16574a = context;
        this.f16575b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f16575b.setLayoutManager(linearLayoutManager);
        this.f16575b.setAdapter(this.f16578e);
    }

    @Override // d.b.i0.p0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        if (a0Var == null || ListUtils.isEmpty(a0Var.f53316b)) {
            return;
        }
        this.f16576c = a0Var.f53316b;
        this.f16577d = frsViewData;
        this.f16578e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f16575b;
        recyclerView.setPadding(l.g(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
        this.f16575b.setClipToPadding(false);
    }

    @Override // d.b.i0.p0.g2.b
    public View getView() {
        return this.f16575b;
    }

    @Override // d.b.i0.p0.g2.b
    public void onChangeSkinType(int i) {
        this.f16578e.notifyDataSetChanged();
    }
}
