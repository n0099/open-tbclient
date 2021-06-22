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
import d.a.o0.e3.a0;
import d.a.o0.e3.b0;
import d.a.o0.r0.g2.b;
import d.a.o0.r0.g2.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MultiServiceViewController implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f15820a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f15821b;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f15823d;

    /* renamed from: c  reason: collision with root package name */
    public List<b0> f15822c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f15824e = new a();

    /* loaded from: classes4.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f15825a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f15826b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f15827c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15828d;

        /* renamed from: e  reason: collision with root package name */
        public b0 f15829e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f15830f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f15831g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f15832h;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.equals(view.getResources().getString(R.string.hot_user_rank), ServiceViewHolder.this.f15829e.f57751b) || ServiceViewHolder.this.f15831g == null || ServiceViewHolder.this.f15831g.getForum() == null || TextUtils.isEmpty(ServiceViewHolder.this.f15831g.getForum().getId())) {
                    if (ServiceViewHolder.this.f15829e != null && ServiceViewHolder.this.f15829e.f57755f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", ServiceViewHolder.this.f15829e.f57756g).param("obj_source", "frs_card").param("obj_id", ServiceViewHolder.this.f15829e.f57755f.f57760b).param("obj_name", ServiceViewHolder.this.f15829e.f57755f.f57759a).param("obj_param1", ServiceViewHolder.this.f15829e.f57755f.f57762d.intValue()));
                    }
                    d.a(view.getContext(), ServiceViewHolder.this.f15829e);
                    d.b(ServiceViewHolder.this.f15829e);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(ServiceViewHolder.this.f15831g.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", ServiceViewHolder.this.f15831g.getForum().getId());
                TiebaStatic.log(statisticItem);
            }
        }

        public ServiceViewHolder(View view, FrsViewData frsViewData) {
            super(view);
            this.f15830f = new ArrayList();
            this.f15832h = new a();
            Context context = view.getContext();
            this.f15831g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.f15825a = linearLayout;
            linearLayout.setGravity(16);
            this.f15825a.setOrientation(0);
            this.f15826b = new FrameLayout(context);
            this.f15827c = new TbClipImageView(context);
            int g2 = l.g(context, R.dimen.tbds57);
            this.f15827c.setDrawerType(1);
            this.f15827c.setIsRound(true);
            this.f15827c.setBorderWidth(R.dimen.L_X01);
            this.f15827c.setBorderColor(R.color.CAM_X0401);
            this.f15827c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f15827c.setPlaceHolder(1);
            this.f15826b.addView(this.f15827c, new FrameLayout.LayoutParams(g2, g2));
            this.f15825a.addView(this.f15826b, new LinearLayout.LayoutParams(-2, l.g(this.f15827c.getContext(), R.dimen.tbds62)));
            TextView textView = new TextView(context);
            this.f15828d = textView;
            textView.setTextSize(0, l.g(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.g(context, R.dimen.tbds10);
            layoutParams.rightMargin = l.g(context, R.dimen.M_W_X008);
            this.f15825a.addView(this.f15828d, layoutParams);
            view.setOnClickListener(this.f15832h);
        }

        public void c(b0 b0Var) {
            if (b0Var == null) {
                return;
            }
            this.f15829e = b0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), b0Var.f57751b)) {
                this.f15827c.setImageResource(R.drawable.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15827c.getLayoutParams();
                layoutParams.width = l.g(this.f15827c.getContext(), R.dimen.tbds62);
                layoutParams.height = l.g(this.f15827c.getContext(), R.dimen.tbds62);
            } else {
                this.f15827c.U(b0Var.f57751b, 10, false);
            }
            this.f15828d.setText(StringHelper.cutChineseAndEnglishWithSuffix(b0Var.f57752c, 10, ""));
            SkinManager.setViewTextColor(this.f15828d, R.color.CAM_X0105);
            if (this.f15830f.contains(b0Var.f57752c)) {
                return;
            }
            d.c(b0Var);
            this.f15830f.add(b0Var.f57752c);
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
            serviceViewHolder.c((b0) MultiServiceViewController.this.f15822c.get(i2));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            return new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), MultiServiceViewController.this.f15823d);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return MultiServiceViewController.this.f15822c.size();
        }
    }

    public MultiServiceViewController(Context context) {
        this.f15820a = context;
        this.f15821b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f15821b.setLayoutManager(linearLayoutManager);
        this.f15821b.setAdapter(this.f15824e);
    }

    @Override // d.a.o0.r0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        if (a0Var == null || ListUtils.isEmpty(a0Var.f57749b)) {
            return;
        }
        this.f15822c = a0Var.f57749b;
        this.f15823d = frsViewData;
        this.f15824e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f15821b;
        recyclerView.setPadding(l.g(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
        this.f15821b.setClipToPadding(false);
    }

    @Override // d.a.o0.r0.g2.b
    public View getView() {
        return this.f15821b;
    }

    @Override // d.a.o0.r0.g2.b
    public void onChangeSkinType(int i2) {
        this.f15824e.notifyDataSetChanged();
    }
}
