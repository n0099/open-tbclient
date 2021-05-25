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
import d.a.n0.e3.a0;
import d.a.n0.e3.b0;
import d.a.n0.r0.g2.b;
import d.a.n0.r0.g2.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MultiServiceViewController implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f15676a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f15677b;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f15679d;

    /* renamed from: c  reason: collision with root package name */
    public List<b0> f15678c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.Adapter f15680e = new a();

    /* loaded from: classes4.dex */
    public static class ServiceViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f15681a;

        /* renamed from: b  reason: collision with root package name */
        public FrameLayout f15682b;

        /* renamed from: c  reason: collision with root package name */
        public TbClipImageView f15683c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15684d;

        /* renamed from: e  reason: collision with root package name */
        public b0 f15685e;

        /* renamed from: f  reason: collision with root package name */
        public List<String> f15686f;

        /* renamed from: g  reason: collision with root package name */
        public FrsViewData f15687g;

        /* renamed from: h  reason: collision with root package name */
        public View.OnClickListener f15688h;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.equals(view.getResources().getString(R.string.hot_user_rank), ServiceViewHolder.this.f15685e.f53937b) || ServiceViewHolder.this.f15687g == null || ServiceViewHolder.this.f15687g.getForum() == null || TextUtils.isEmpty(ServiceViewHolder.this.f15687g.getForum().getId())) {
                    if (ServiceViewHolder.this.f15685e != null && ServiceViewHolder.this.f15685e.f53941f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", ServiceViewHolder.this.f15685e.f53942g).param("obj_source", "frs_card").param("obj_id", ServiceViewHolder.this.f15685e.f53941f.f53946b).param("obj_name", ServiceViewHolder.this.f15685e.f53941f.f53945a).param("obj_param1", ServiceViewHolder.this.f15685e.f53941f.f53948d.intValue()));
                    }
                    d.a(view.getContext(), ServiceViewHolder.this.f15685e);
                    d.b(ServiceViewHolder.this.f15685e);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(ServiceViewHolder.this.f15687g.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", ServiceViewHolder.this.f15687g.getForum().getId());
                TiebaStatic.log(statisticItem);
            }
        }

        public ServiceViewHolder(View view, FrsViewData frsViewData) {
            super(view);
            this.f15686f = new ArrayList();
            this.f15688h = new a();
            Context context = view.getContext();
            this.f15687g = frsViewData;
            LinearLayout linearLayout = (LinearLayout) view;
            this.f15681a = linearLayout;
            linearLayout.setGravity(16);
            this.f15681a.setOrientation(0);
            this.f15682b = new FrameLayout(context);
            this.f15683c = new TbClipImageView(context);
            int g2 = l.g(context, R.dimen.tbds57);
            this.f15683c.setDrawerType(1);
            this.f15683c.setIsRound(true);
            this.f15683c.setBorderWidth(R.dimen.L_X01);
            this.f15683c.setBorderColor(R.color.CAM_X0401);
            this.f15683c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f15683c.setPlaceHolder(1);
            this.f15682b.addView(this.f15683c, new FrameLayout.LayoutParams(g2, g2));
            this.f15681a.addView(this.f15682b, new LinearLayout.LayoutParams(-2, l.g(this.f15683c.getContext(), R.dimen.tbds62)));
            TextView textView = new TextView(context);
            this.f15684d = textView;
            textView.setTextSize(0, l.g(context, R.dimen.T_X08));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = l.g(context, R.dimen.tbds10);
            layoutParams.rightMargin = l.g(context, R.dimen.M_W_X008);
            this.f15681a.addView(this.f15684d, layoutParams);
            view.setOnClickListener(this.f15688h);
        }

        public void c(b0 b0Var) {
            if (b0Var == null) {
                return;
            }
            this.f15685e = b0Var;
            if (TextUtils.equals(this.itemView.getResources().getString(R.string.hot_user_rank), b0Var.f53937b)) {
                this.f15683c.setImageResource(R.drawable.icon_mask_service_celebrity24);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15683c.getLayoutParams();
                layoutParams.width = l.g(this.f15683c.getContext(), R.dimen.tbds62);
                layoutParams.height = l.g(this.f15683c.getContext(), R.dimen.tbds62);
            } else {
                this.f15683c.V(b0Var.f53937b, 10, false);
            }
            this.f15684d.setText(StringHelper.cutChineseAndEnglishWithSuffix(b0Var.f53938c, 10, ""));
            SkinManager.setViewTextColor(this.f15684d, R.color.CAM_X0105);
            if (this.f15686f.contains(b0Var.f53938c)) {
                return;
            }
            d.c(b0Var);
            this.f15686f.add(b0Var.f53938c);
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
            serviceViewHolder.c((b0) MultiServiceViewController.this.f15678c.get(i2));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            return new ServiceViewHolder(new LinearLayout(viewGroup.getContext()), MultiServiceViewController.this.f15679d);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return MultiServiceViewController.this.f15678c.size();
        }
    }

    public MultiServiceViewController(Context context) {
        this.f15676a = context;
        this.f15677b = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f15677b.setLayoutManager(linearLayoutManager);
        this.f15677b.setAdapter(this.f15680e);
    }

    @Override // d.a.n0.r0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        if (a0Var == null || ListUtils.isEmpty(a0Var.f53935b)) {
            return;
        }
        this.f15678c = a0Var.f53935b;
        this.f15679d = frsViewData;
        this.f15680e.notifyDataSetChanged();
        RecyclerView recyclerView = this.f15677b;
        recyclerView.setPadding(l.g(recyclerView.getContext(), R.dimen.M_W_X007), 0, 0, 0);
        this.f15677b.setClipToPadding(false);
    }

    @Override // d.a.n0.r0.g2.b
    public View getView() {
        return this.f15677b;
    }

    @Override // d.a.n0.r0.g2.b
    public void onChangeSkinType(int i2) {
        this.f15680e.notifyDataSetChanged();
    }
}
