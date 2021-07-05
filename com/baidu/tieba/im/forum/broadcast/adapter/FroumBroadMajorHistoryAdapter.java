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
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.m.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FroumBroadMajorHistoryAdapter extends RecyclerView.Adapter<FroumBroadMajorHistoryItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f17423a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.s0.i1.i.a.b.b> f17424b;

    /* renamed from: c  reason: collision with root package name */
    public f<d.a.s0.i1.i.a.b.b> f17425c;

    /* loaded from: classes5.dex */
    public static class FroumBroadMajorHistoryItemViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f17426a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17427b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17428c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f17429d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f17430e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f17431f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f17432g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f17433h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f17434i;
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FroumBroadMajorHistoryItemViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17426a = (TextView) view.findViewById(R.id.bcast_time);
            this.f17427b = (TextView) view.findViewById(R.id.forum_name);
            this.f17428c = (TextView) view.findViewById(R.id.bcast_title);
            this.f17429d = (TextView) view.findViewById(R.id.bcast_content);
            this.f17430e = (TextView) view.findViewById(R.id.publish_number);
            this.f17431f = (TextView) view.findViewById(R.id.pv_number);
            this.f17432g = (TextView) view.findViewById(R.id.ctr_number);
            this.j = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.k = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.n = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.o = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.p = view.findViewById(R.id.forum_bg_line);
            this.l = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.f17433h = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.s = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.m = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.t = (RelativeLayout) view.findViewById(R.id.container_image);
            this.f17434i = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.r = view.findViewById(R.id.bg_item_mian_view);
            this.q = view.findViewById(R.id.gradient_cover);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.i1.i.a.b.b f17435e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17436f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FroumBroadMajorHistoryAdapter f17437g;

        public a(FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter, d.a.s0.i1.i.a.b.b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {froumBroadMajorHistoryAdapter, bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17437g = froumBroadMajorHistoryAdapter;
            this.f17435e = bVar;
            this.f17436f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17437g.f17425c == null) {
                return;
            }
            f fVar = this.f17437g.f17425c;
            d.a.s0.i1.i.a.b.b bVar = this.f17435e;
            int i2 = this.f17436f;
            fVar.a(view, bVar, i2, i2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.i1.i.a.b.b f17438e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17439f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FroumBroadMajorHistoryAdapter f17440g;

        public b(FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter, d.a.s0.i1.i.a.b.b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {froumBroadMajorHistoryAdapter, bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17440g = froumBroadMajorHistoryAdapter;
            this.f17438e = bVar;
            this.f17439f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17440g.f17425c == null) {
                return;
            }
            f fVar = this.f17440g.f17425c;
            d.a.s0.i1.i.a.b.b bVar = this.f17438e;
            int i2 = this.f17439f;
            fVar.a(view, bVar, i2, i2);
        }
    }

    public FroumBroadMajorHistoryAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17423a = context;
        this.f17424b = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, int i2) {
        d.a.s0.i1.i.a.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, froumBroadMajorHistoryItemViewHolder, i2) == null) || (bVar = this.f17424b.get(i2)) == null) {
            return;
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.f17426a.getLayoutParams();
            layoutParams.topMargin = this.f17423a.getResources().getDimensionPixelOffset(R.dimen.tbds62);
            froumBroadMajorHistoryItemViewHolder.f17426a.setLayoutParams(layoutParams);
        }
        if (TimeHelper.isSameYear(bVar.g() * 1000)) {
            froumBroadMajorHistoryItemViewHolder.f17426a.setText(StringHelper.getDateStringMHH(bVar.g() * 1000));
        } else {
            froumBroadMajorHistoryItemViewHolder.f17426a.setText(StringHelper.getDateStringYMH(bVar.g() * 1000));
        }
        if (StringUtils.isNull(bVar.f())) {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f17434i.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f17434i.setText(bVar.k());
        } else {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f17434i.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f17428c.setText(bVar.k());
            froumBroadMajorHistoryItemViewHolder.o.setConrers(15);
            froumBroadMajorHistoryItemViewHolder.o.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            froumBroadMajorHistoryItemViewHolder.o.setDrawCorner(true);
            froumBroadMajorHistoryItemViewHolder.o.setPlaceHolder(2);
            froumBroadMajorHistoryItemViewHolder.o.M(bVar.f(), 10, false);
            froumBroadMajorHistoryItemViewHolder.o.setGifIconSupport(false);
        }
        if (StringUtils.isNull(bVar.c())) {
            froumBroadMajorHistoryItemViewHolder.f17429d.setVisibility(8);
        } else {
            froumBroadMajorHistoryItemViewHolder.f17429d.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f17429d.setText(bVar.c());
        }
        froumBroadMajorHistoryItemViewHolder.f17427b.setText(bVar.e().forum_name);
        froumBroadMajorHistoryItemViewHolder.n.setShowOval(true);
        froumBroadMajorHistoryItemViewHolder.n.setAutoChangeStyle(true);
        froumBroadMajorHistoryItemViewHolder.n.setStrokeWith(l.g(this.f17423a, R.dimen.tbds1));
        froumBroadMajorHistoryItemViewHolder.n.setStrokeColorResId(R.color.CAM_X0401);
        froumBroadMajorHistoryItemViewHolder.n.setShowOuterBorder(false);
        froumBroadMajorHistoryItemViewHolder.n.setShowInnerBorder(true);
        froumBroadMajorHistoryItemViewHolder.n.setPlaceHolder(1);
        froumBroadMajorHistoryItemViewHolder.n.M(bVar.e().avatar, 10, false);
        froumBroadMajorHistoryItemViewHolder.f17430e.setText(this.f17423a.getString(R.string.forum_broadcast_major_history_reacht_number, StringHelper.numberUniformFormatExtraWithRoundVote(bVar.h())));
        froumBroadMajorHistoryItemViewHolder.f17431f.setText(this.f17423a.getString(R.string.forum_broadcast_major_history_read_number, StringHelper.numberUniformFormatExtraWithRoundVote(bVar.i())));
        int parseFloat = (int) (Float.parseFloat(bVar.d()) * 100.0f);
        if (parseFloat < 0) {
            parseFloat = 0;
        } else if (parseFloat > 100) {
            parseFloat = 100;
        }
        if (!StringUtils.isNull(bVar.d())) {
            froumBroadMajorHistoryItemViewHolder.f17432g.setText(this.f17423a.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
        } else {
            froumBroadMajorHistoryItemViewHolder.f17432g.setText("0%");
        }
        if (bVar.j() == null) {
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f17433h.setText(this.f17423a.getString(R.string.forum_broadcast_major_history_pb_deleted));
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
            froumBroadMajorHistoryItemViewHolder.f17433h.setText(this.f17423a.getString(R.string.forum_broadcast_major_history_pb_deleted));
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
            froumBroadMajorHistoryItemViewHolder.f17433h.setText(this.f17423a.getString(R.string.video_review_state));
        } else if (bVar.a() == 6) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f17433h.setText(this.f17423a.getString(R.string.forum_broadcast_major_history_check_failed));
            froumBroadMajorHistoryItemViewHolder.s.setText(this.f17423a.getString(R.string.edit));
            froumBroadMajorHistoryItemViewHolder.s.setTextSize(R.dimen.tbds34);
            d.a.r0.r.f0.m.b bVar2 = new d.a.r0.r.f0.m.b();
            bVar2.q(R.color.CAM_X0302);
            froumBroadMajorHistoryItemViewHolder.s.setConfig(bVar2);
            froumBroadMajorHistoryItemViewHolder.s.setOnClickListener(new a(this, bVar, i2));
        } else if (bVar.a() == 10) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(8);
        }
        froumBroadMajorHistoryItemViewHolder.k.setOnClickListener(new b(this, bVar, i2));
        f(froumBroadMajorHistoryItemViewHolder, bVar, i2);
    }

    public final void f(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, d.a.s0.i1.i.a.b.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, froumBroadMajorHistoryItemViewHolder, bVar, i2) == null) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17426a, R.color.CAM_X0109);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17427b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17428c, R.color.CAM_X0101);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17429d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17430e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17431f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17432g, R.color.CAM_X0107);
            SkinManager.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.p, R.color.CAM_X0203);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17434i, R.color.CAM_X0105);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606).blRadius(l.g(this.f17423a, R.dimen.tbds21)).brRadius(l.g(this.f17423a, R.dimen.tbds21)).into(froumBroadMajorHistoryItemViewHolder.q);
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.k.getLayoutParams();
                layoutParams.leftMargin = l.g(this.f17423a, R.dimen.tbds21);
                layoutParams.rightMargin = l.g(this.f17423a, R.dimen.tbds21);
                layoutParams.topMargin = l.g(this.f17423a, R.dimen.tbds21);
                froumBroadMajorHistoryItemViewHolder.k.setLayoutParams(layoutParams);
                froumBroadMajorHistoryItemViewHolder.k.setPadding(0, 0, 0, this.f17423a.getResources().getDimensionPixelOffset(R.dimen.tbds54));
                froumBroadMajorHistoryItemViewHolder.r.setVisibility(8);
                TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f17423a, R.dimen.tbds31)).defaultColor(R.color.CAM_X0205).into(froumBroadMajorHistoryItemViewHolder.k);
            } else {
                if (i2 != 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.f17426a.getLayoutParams();
                    layoutParams2.topMargin = this.f17423a.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                    froumBroadMajorHistoryItemViewHolder.f17426a.setLayoutParams(layoutParams2);
                }
                froumBroadMajorHistoryItemViewHolder.k.setPadding(this.f17423a.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.f17423a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.f17423a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.f17423a.getResources().getDimensionPixelOffset(R.dimen.tbds75));
                froumBroadMajorHistoryItemViewHolder.r.setVisibility(0);
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.f17423a, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f17423a, R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.f17423a, R.dimen.tbds5)).into(froumBroadMajorHistoryItemViewHolder.r);
            }
            if (bVar.j() == null) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17433h, R.color.CAM_X0109);
            } else if (bVar.j().is_deleted.intValue() == 1) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17433h, R.color.CAM_X0109);
            } else if (bVar.a() == 1) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17433h, R.color.CAM_X0107);
            } else if (bVar.a() == 6) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f17433h, R.color.CAM_X0301);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: g */
    public FroumBroadMajorHistoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) ? new FroumBroadMajorHistoryItemViewHolder(LayoutInflater.from(this.f17423a).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false)) : (FroumBroadMajorHistoryItemViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<d.a.s0.i1.i.a.b.b> list = this.f17424b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void h(f<d.a.s0.i1.i.a.b.b> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f17425c = fVar;
        }
    }

    public void i(List<d.a.s0.i1.i.a.b.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        this.f17424b = list;
        notifyDataSetChanged();
    }
}
