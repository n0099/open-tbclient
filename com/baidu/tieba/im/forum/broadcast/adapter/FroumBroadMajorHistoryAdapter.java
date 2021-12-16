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
import c.a.d.f.p.m;
import c.a.r0.n.f;
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
/* loaded from: classes12.dex */
public class FroumBroadMajorHistoryAdapter extends RecyclerView.Adapter<FroumBroadMajorHistoryItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.s0.s1.i.a.b.b> f46448b;

    /* renamed from: c  reason: collision with root package name */
    public f<c.a.s0.s1.i.a.b.b> f46449c;

    /* loaded from: classes12.dex */
    public static class FroumBroadMajorHistoryItemViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46450b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f46451c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f46452d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f46453e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f46454f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f46455g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f46456h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f46457i;

        /* renamed from: j  reason: collision with root package name */
        public LinearLayout f46458j;

        /* renamed from: k  reason: collision with root package name */
        public LinearLayout f46459k;
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
            this.a = (TextView) view.findViewById(R.id.bcast_time);
            this.f46450b = (TextView) view.findViewById(R.id.forum_name);
            this.f46451c = (TextView) view.findViewById(R.id.bcast_title);
            this.f46452d = (TextView) view.findViewById(R.id.bcast_content);
            this.f46453e = (TextView) view.findViewById(R.id.publish_number);
            this.f46454f = (TextView) view.findViewById(R.id.pv_number);
            this.f46455g = (TextView) view.findViewById(R.id.ctr_number);
            this.f46458j = (LinearLayout) view.findViewById(R.id.bcast_item_ll);
            this.f46459k = (LinearLayout) view.findViewById(R.id.bcast_main);
            this.n = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.o = (TbImageView) view.findViewById(R.id.iv_imageView);
            this.p = view.findViewById(R.id.forum_bg_line);
            this.l = (LinearLayout) view.findViewById(R.id.forum_bcast_status_ll);
            this.f46456h = (TextView) view.findViewById(R.id.forum_bcast_status);
            this.s = (TBSpecificationBtn) view.findViewById(R.id.forum_fail_edit);
            this.m = (LinearLayout) view.findViewById(R.id.forum_pv_uv_item_ll);
            this.t = (RelativeLayout) view.findViewById(R.id.container_image);
            this.f46457i = (TextView) view.findViewById(R.id.bcast_no_image_title);
            this.r = view.findViewById(R.id.bg_item_mian_view);
            this.q = view.findViewById(R.id.gradient_cover);
        }
    }

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s1.i.a.b.b f46460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46461f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FroumBroadMajorHistoryAdapter f46462g;

        public a(FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter, c.a.s0.s1.i.a.b.b bVar, int i2) {
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
            this.f46462g = froumBroadMajorHistoryAdapter;
            this.f46460e = bVar;
            this.f46461f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f46462g.f46449c == null) {
                return;
            }
            f fVar = this.f46462g.f46449c;
            c.a.s0.s1.i.a.b.b bVar = this.f46460e;
            int i2 = this.f46461f;
            fVar.a(view, bVar, i2, i2);
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s1.i.a.b.b f46463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46464f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FroumBroadMajorHistoryAdapter f46465g;

        public b(FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter, c.a.s0.s1.i.a.b.b bVar, int i2) {
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
            this.f46465g = froumBroadMajorHistoryAdapter;
            this.f46463e = bVar;
            this.f46464f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f46465g.f46449c == null) {
                return;
            }
            f fVar = this.f46465g.f46449c;
            c.a.s0.s1.i.a.b.b bVar = this.f46463e;
            int i2 = this.f46464f;
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
        this.a = context;
        this.f46448b = new ArrayList();
    }

    public final void b(FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, c.a.s0.s1.i.a.b.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, froumBroadMajorHistoryItemViewHolder, bVar, i2) == null) {
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.a, R.color.CAM_X0109);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f46450b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f46451c, R.color.CAM_X0101);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f46452d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f46453e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f46454f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f46455g, R.color.CAM_X0107);
            SkinManager.setBackgroundColor(froumBroadMajorHistoryItemViewHolder.p, R.color.CAM_X0203);
            SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f46457i, R.color.CAM_X0105);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606).blRadius(m.f(this.a, R.dimen.tbds21)).brRadius(m.f(this.a, R.dimen.tbds21)).into(froumBroadMajorHistoryItemViewHolder.q);
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.f46459k.getLayoutParams();
                layoutParams.leftMargin = m.f(this.a, R.dimen.tbds21);
                layoutParams.rightMargin = m.f(this.a, R.dimen.tbds21);
                layoutParams.topMargin = m.f(this.a, R.dimen.tbds21);
                froumBroadMajorHistoryItemViewHolder.f46459k.setLayoutParams(layoutParams);
                froumBroadMajorHistoryItemViewHolder.f46459k.setPadding(0, 0, 0, this.a.getResources().getDimensionPixelOffset(R.dimen.tbds54));
                froumBroadMajorHistoryItemViewHolder.r.setVisibility(8);
                TBSelector.makeDrawableSelector().setShape(0).cornerRadius(m.f(this.a, R.dimen.tbds31)).defaultColor(R.color.CAM_X0205).into(froumBroadMajorHistoryItemViewHolder.f46459k);
            } else {
                if (i2 != 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.a.getLayoutParams();
                    layoutParams2.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds57);
                    froumBroadMajorHistoryItemViewHolder.a.setLayoutParams(layoutParams2);
                }
                froumBroadMajorHistoryItemViewHolder.f46459k.setPadding(this.a.getResources().getDimensionPixelOffset(R.dimen.tbds23), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds21), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds75));
                froumBroadMajorHistoryItemViewHolder.r.setVisibility(0);
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(m.f(this.a, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(m.f(this.a, R.dimen.tbds10)).setOffsetX(0).setOffsetY(m.f(this.a, R.dimen.tbds5)).into(froumBroadMajorHistoryItemViewHolder.r);
            }
            if (bVar.j() == null) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f46456h, R.color.CAM_X0109);
            } else if (bVar.j().is_deleted.intValue() == 1) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f46456h, R.color.CAM_X0109);
            } else if (bVar.a() == 1) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f46456h, R.color.CAM_X0107);
            } else if (bVar.a() == 6) {
                SkinManager.setViewTextColor(froumBroadMajorHistoryItemViewHolder.f46456h, R.color.CAM_X0301);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<c.a.s0.s1.i.a.b.b> list = this.f46448b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void setContentOnClickListener(f<c.a.s0.s1.i.a.b.b> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f46449c = fVar;
        }
    }

    public void setFoumListData(List<c.a.s0.s1.i.a.b.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || list == null) {
            return;
        }
        this.f46448b = list;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull FroumBroadMajorHistoryItemViewHolder froumBroadMajorHistoryItemViewHolder, int i2) {
        c.a.s0.s1.i.a.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, froumBroadMajorHistoryItemViewHolder, i2) == null) || (bVar = this.f46448b.get(i2)) == null) {
            return;
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) froumBroadMajorHistoryItemViewHolder.a.getLayoutParams();
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds62);
            froumBroadMajorHistoryItemViewHolder.a.setLayoutParams(layoutParams);
        }
        if (TimeHelper.isSameYear(bVar.g() * 1000)) {
            froumBroadMajorHistoryItemViewHolder.a.setText(StringHelper.getDateStringMHH(bVar.g() * 1000));
        } else {
            froumBroadMajorHistoryItemViewHolder.a.setText(StringHelper.getDateStringYMH(bVar.g() * 1000));
        }
        if (StringUtils.isNull(bVar.f())) {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f46457i.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f46457i.setText(bVar.k());
        } else {
            froumBroadMajorHistoryItemViewHolder.t.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f46457i.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f46451c.setText(bVar.k());
            froumBroadMajorHistoryItemViewHolder.o.setConrers(15);
            froumBroadMajorHistoryItemViewHolder.o.setRadius(m.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            froumBroadMajorHistoryItemViewHolder.o.setDrawCorner(true);
            froumBroadMajorHistoryItemViewHolder.o.setPlaceHolder(2);
            froumBroadMajorHistoryItemViewHolder.o.startLoad(bVar.f(), 10, false);
            froumBroadMajorHistoryItemViewHolder.o.setGifIconSupport(false);
        }
        if (StringUtils.isNull(bVar.c())) {
            froumBroadMajorHistoryItemViewHolder.f46452d.setVisibility(8);
        } else {
            froumBroadMajorHistoryItemViewHolder.f46452d.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f46452d.setText(bVar.c());
        }
        froumBroadMajorHistoryItemViewHolder.f46450b.setText(bVar.e().forum_name);
        froumBroadMajorHistoryItemViewHolder.n.setShowOval(true);
        froumBroadMajorHistoryItemViewHolder.n.setAutoChangeStyle(true);
        froumBroadMajorHistoryItemViewHolder.n.setStrokeWith(m.f(this.a, R.dimen.tbds1));
        froumBroadMajorHistoryItemViewHolder.n.setStrokeColorResId(R.color.CAM_X0401);
        froumBroadMajorHistoryItemViewHolder.n.setShowOuterBorder(false);
        froumBroadMajorHistoryItemViewHolder.n.setShowInnerBorder(true);
        froumBroadMajorHistoryItemViewHolder.n.setPlaceHolder(1);
        froumBroadMajorHistoryItemViewHolder.n.startLoad(bVar.e().avatar, 10, false);
        froumBroadMajorHistoryItemViewHolder.f46453e.setText(this.a.getString(R.string.forum_broadcast_major_history_reacht_number, StringHelper.numberUniformFormatExtraWithRoundVote(bVar.h())));
        froumBroadMajorHistoryItemViewHolder.f46454f.setText(this.a.getString(R.string.forum_broadcast_major_history_read_number, StringHelper.numberUniformFormatExtraWithRoundVote(bVar.i())));
        int parseFloat = (int) (Float.parseFloat(bVar.d()) * 100.0f);
        if (parseFloat < 0) {
            parseFloat = 0;
        } else if (parseFloat > 100) {
            parseFloat = 100;
        }
        if (!StringUtils.isNull(bVar.d())) {
            froumBroadMajorHistoryItemViewHolder.f46455g.setText(this.a.getString(R.string.forum_broadcast_major_history_ctr_number, Integer.valueOf(parseFloat), "%"));
        } else {
            froumBroadMajorHistoryItemViewHolder.f46455g.setText("0%");
        }
        if (bVar.j() == null) {
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.f46456h.setText(this.a.getString(R.string.forum_broadcast_major_history_pb_deleted));
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
            froumBroadMajorHistoryItemViewHolder.f46456h.setText(this.a.getString(R.string.forum_broadcast_major_history_pb_deleted));
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
            froumBroadMajorHistoryItemViewHolder.f46456h.setText(this.a.getString(R.string.video_review_state));
        } else if (bVar.a() == 6) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(8);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.s.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.f46456h.setText(this.a.getString(R.string.forum_broadcast_major_history_check_failed));
            froumBroadMajorHistoryItemViewHolder.s.setText(this.a.getString(R.string.edit));
            froumBroadMajorHistoryItemViewHolder.s.setTextSize(R.dimen.tbds34);
            c.a.r0.s.i0.n.b bVar2 = new c.a.r0.s.i0.n.b();
            bVar2.r(R.color.CAM_X0302);
            froumBroadMajorHistoryItemViewHolder.s.setConfig(bVar2);
            froumBroadMajorHistoryItemViewHolder.s.setOnClickListener(new a(this, bVar, i2));
        } else if (bVar.a() == 10) {
            froumBroadMajorHistoryItemViewHolder.m.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.p.setVisibility(0);
            froumBroadMajorHistoryItemViewHolder.l.setVisibility(8);
        }
        froumBroadMajorHistoryItemViewHolder.f46459k.setOnClickListener(new b(this, bVar, i2));
        b(froumBroadMajorHistoryItemViewHolder, bVar, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public FroumBroadMajorHistoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) ? new FroumBroadMajorHistoryItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.forum_bcast_major_history_item, viewGroup, false)) : (FroumBroadMajorHistoryItemViewHolder) invokeLI.objValue;
    }
}
