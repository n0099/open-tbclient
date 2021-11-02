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
import b.a.e.e.p.l;
import b.a.q0.n.f;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class FroumBroadMajorHistoryAdapter extends RecyclerView.Adapter<FroumBroadMajorHistoryItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f50346a;

    /* renamed from: b  reason: collision with root package name */
    public List<b.a.r0.l1.i.a.b.b> f50347b;

    /* renamed from: c  reason: collision with root package name */
    public f<b.a.r0.l1.i.a.b.b> f50348c;

    /* loaded from: classes9.dex */
    public static class FroumBroadMajorHistoryItemViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f50349a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f50350b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f50351c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f50352d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f50353e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f50354f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f50355g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f50356h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f50357i;
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
            this.f50349a = (TextView) view.findViewById(R.id.bcast_time);
            this.f50350b = (TextView) view.findViewById(R.id.forum_name);
            this.f50351c = (TextView) view.findViewById(R.id.bcast_title);
            this.f50352d = (TextView) view.findViewById(R.id.bcast_content);
            this.f50353e = (TextView) view.findViewById(R.id.publish_number);
            this.f50354f = (TextView) view.findViewById(R.id.pv_number);
            this.f50355g = (TextView) view.findViewById(R.id.ctr_number);
            this.j = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.k = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.n = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.o = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.p = view.findViewById(R.id.forum_bg_line);
            this.l = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.f50356h = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.s = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.m = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.t = (RelativeLayout) view.findViewById(R.id.container_image);
            this.f50357i = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.r = view.findViewById(R.id.bg_item_mian_view);
            this.q = view.findViewById(R.id.gradient_cover);
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.l1.i.a.b.b f50358e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50359f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FroumBroadMajorHistoryAdapter f50360g;

        public a(FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter, b.a.r0.l1.i.a.b.b bVar, int i2) {
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
            this.f50360g = froumBroadMajorHistoryAdapter;
            this.f50358e = bVar;
            this.f50359f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50360g.f50348c == null) {
                return;
            }
            f fVar = this.f50360g.f50348c;
            b.a.r0.l1.i.a.b.b bVar = this.f50358e;
            int i2 = this.f50359f;
            fVar.a(view, bVar, i2, i2);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.l1.i.a.b.b f50361e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50362f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FroumBroadMajorHistoryAdapter f50363g;

        public b(FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter, b.a.r0.l1.i.a.b.b bVar, int i2) {
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
            this.f50363g = froumBroadMajorHistoryAdapter;
            this.f50361e = bVar;
            this.f50362f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50363g.f50348c == null) {
                return;
            }
            f fVar = this.f50363g.f50348c;
            b.a.r0.l1.i.a.b.b bVar = this.f50361e;
            int i2 = this.f50362f;
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
        this.f50346a = context;
        this.f50347b = new ArrayList();
    }

    public final void b(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, b.a.r0.l1.i.a.b.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, froumBroadMajorHistoryItemViewHolder, bVar, i2) == null) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f50349a, R.color.CAM_X0109);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f50350b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f50351c, R.color.CAM_X0101);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f50352d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f50353e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f50354f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f50355g, R.color.CAM_X0107);
            SkinManager.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.p, R.color.CAM_X0203);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f50357i, R.color.CAM_X0105);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606).blRadius(l.g(this.f50346a, R.dimen.tbds21)).brRadius(l.g(this.f50346a, R.dimen.tbds21)).into(froumBroadMajorHistoryItemViewHolder.q);
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.k.getLayoutParams();
                layoutParams.leftMargin = l.g(this.f50346a, R.dimen.tbds21);
                layoutParams.rightMargin = l.g(this.f50346a, R.dimen.tbds21);
                layoutParams.topMargin = l.g(this.f50346a, R.dimen.tbds21);
                froumBroadMajorHistoryItemViewHolder.k.setLayoutParams(layoutParams);
                froumBroadMajorHistoryItemViewHolder.k.setPadding(0, 0, 0, this.f50346a.getResources().getDimensionPixelOffset(R.dimen.tbds54));
                froumBroadMajorHistoryItemViewHolder.r.setVisibility(8);
                TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f50346a, R.dimen.tbds31)).defaultColor(R.color.CAM_X0205).into(froumBroadMajorHistoryItemViewHolder.k);
            } else {
                if (i2 != 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.f50349a.getLayoutParams();
                    layoutParams2.topMargin = this.f50346a.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                    froumBroadMajorHistoryItemViewHolder.f50349a.setLayoutParams(layoutParams2);
                }
                froumBroadMajorHistoryItemViewHolder.k.setPadding(this.f50346a.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.f50346a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.f50346a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.f50346a.getResources().getDimensionPixelOffset(R.dimen.tbds75));
                froumBroadMajorHistoryItemViewHolder.r.setVisibility(0);
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.f50346a, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f50346a, R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.f50346a, R.dimen.tbds5)).into(froumBroadMajorHistoryItemViewHolder.r);
            }
            if (bVar.j() == null) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f50356h, R.color.CAM_X0109);
            } else if (bVar.j().is_deleted.intValue() == 1) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f50356h, R.color.CAM_X0109);
            } else if (bVar.a() == 1) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f50356h, R.color.CAM_X0107);
            } else if (bVar.a() == 6) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f50356h, R.color.CAM_X0301);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<b.a.r0.l1.i.a.b.b> list = this.f50347b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void setContentOnClickListener(f<b.a.r0.l1.i.a.b.b> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f50348c = fVar;
        }
    }

    public void setFoumListData(List<b.a.r0.l1.i.a.b.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || list == null) {
            return;
        }
        this.f50347b = list;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, int i2) {
        b.a.r0.l1.i.a.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, froumBroadMajorHistoryItemViewHolder, i2) == null) || (bVar = this.f50347b.get(i2)) == null) {
            return;
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.f50349a.getLayoutParams();
            layoutParams.topMargin = this.f50346a.getResources().getDimensionPixelOffset(R.dimen.tbds62);
            froumBroadMajorHistoryItemViewHolder.f50349a.setLayoutParams(layoutParams);
        }
        if (TimeHelper.isSameYear(bVar.g() * 1000)) {
            froumBroadMajorHistoryItemViewHolder.f50349a.setText(StringHelper.getDateStringMHH(bVar.g() * 1000));
        } else {
            froumBroadMajorHistoryItemViewHolder.f50349a.setText(StringHelper.getDateStringYMH(bVar.g() * 1000));
        }
        if (StringUtils.isNull(bVar.f())) {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f50357i.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f50357i.setText(bVar.k());
        } else {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f50357i.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f50351c.setText(bVar.k());
            froumBroadMajorHistoryItemViewHolder.o.setConrers(15);
            froumBroadMajorHistoryItemViewHolder.o.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            froumBroadMajorHistoryItemViewHolder.o.setDrawCorner(true);
            froumBroadMajorHistoryItemViewHolder.o.setPlaceHolder(2);
            froumBroadMajorHistoryItemViewHolder.o.startLoad(bVar.f(), 10, false);
            froumBroadMajorHistoryItemViewHolder.o.setGifIconSupport(false);
        }
        if (StringUtils.isNull(bVar.c())) {
            froumBroadMajorHistoryItemViewHolder.f50352d.setVisibility(8);
        } else {
            froumBroadMajorHistoryItemViewHolder.f50352d.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f50352d.setText(bVar.c());
        }
        froumBroadMajorHistoryItemViewHolder.f50350b.setText(bVar.e().forum_name);
        froumBroadMajorHistoryItemViewHolder.n.setShowOval(true);
        froumBroadMajorHistoryItemViewHolder.n.setAutoChangeStyle(true);
        froumBroadMajorHistoryItemViewHolder.n.setStrokeWith(l.g(this.f50346a, R.dimen.tbds1));
        froumBroadMajorHistoryItemViewHolder.n.setStrokeColorResId(R.color.CAM_X0401);
        froumBroadMajorHistoryItemViewHolder.n.setShowOuterBorder(false);
        froumBroadMajorHistoryItemViewHolder.n.setShowInnerBorder(true);
        froumBroadMajorHistoryItemViewHolder.n.setPlaceHolder(1);
        froumBroadMajorHistoryItemViewHolder.n.startLoad(bVar.e().avatar, 10, false);
        froumBroadMajorHistoryItemViewHolder.f50353e.setText(this.f50346a.getString(R.string.forum_broadcast_major_history_reacht_number, StringHelper.numberUniformFormatExtraWithRoundVote(bVar.h())));
        froumBroadMajorHistoryItemViewHolder.f50354f.setText(this.f50346a.getString(R.string.forum_broadcast_major_history_read_number, StringHelper.numberUniformFormatExtraWithRoundVote(bVar.i())));
        int parseFloat = (int) (Float.parseFloat(bVar.d()) * 100.0f);
        if (parseFloat < 0) {
            parseFloat = 0;
        } else if (parseFloat > 100) {
            parseFloat = 100;
        }
        if (!StringUtils.isNull(bVar.d())) {
            froumBroadMajorHistoryItemViewHolder.f50355g.setText(this.f50346a.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
        } else {
            froumBroadMajorHistoryItemViewHolder.f50355g.setText("0%");
        }
        if (bVar.j() == null) {
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f50356h.setText(this.f50346a.getString(R.string.forum_broadcast_major_history_pb_deleted));
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
            froumBroadMajorHistoryItemViewHolder.f50356h.setText(this.f50346a.getString(R.string.forum_broadcast_major_history_pb_deleted));
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
            froumBroadMajorHistoryItemViewHolder.f50356h.setText(this.f50346a.getString(R.string.video_review_state));
        } else if (bVar.a() == 6) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f50356h.setText(this.f50346a.getString(R.string.forum_broadcast_major_history_check_failed));
            froumBroadMajorHistoryItemViewHolder.s.setText(this.f50346a.getString(R.string.edit));
            froumBroadMajorHistoryItemViewHolder.s.setTextSize(R.dimen.tbds34);
            b.a.q0.s.g0.n.b bVar2 = new b.a.q0.s.g0.n.b();
            bVar2.r(R.color.CAM_X0302);
            froumBroadMajorHistoryItemViewHolder.s.setConfig(bVar2);
            froumBroadMajorHistoryItemViewHolder.s.setOnClickListener(new a(this, bVar, i2));
        } else if (bVar.a() == 10) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(8);
        }
        froumBroadMajorHistoryItemViewHolder.k.setOnClickListener(new b(this, bVar, i2));
        b(froumBroadMajorHistoryItemViewHolder, bVar, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public FroumBroadMajorHistoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) ? new FroumBroadMajorHistoryItemViewHolder(LayoutInflater.from(this.f50346a).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false)) : (FroumBroadMajorHistoryItemViewHolder) invokeLI.objValue;
    }
}
