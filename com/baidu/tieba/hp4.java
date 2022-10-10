package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class hp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public ImageView B;
    public TextView C;
    public LinearLayout D;
    public ImageView E;
    public TextView F;
    public View G;
    public View H;
    public View I;
    public final View a;
    public final ThreadAchievementShareInfo.ParamBean b;
    public final Context c;
    public List<ThreadAchievementShareInfo.ThreadListBean> d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public View o;
    public View p;
    public TextView q;
    public TbImageView r;
    public TbImageView s;
    public TbImageView t;
    public View u;
    public View v;
    public View w;
    public LinearLayout x;
    public ImageView y;
    public TextView z;

    public hp4(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, threadAchievementShareInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = context;
        this.a = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d03a2, (ViewGroup) null);
        ThreadAchievementShareInfo.ParamBean params = threadAchievementShareInfo.getParams();
        this.b = params;
        if (params != null) {
            this.d = params.getThread_list();
        }
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public final void b() {
        List<ThreadAchievementShareInfo.ThreadListBean> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.b == null || (list = this.d) == null || list.size() < 2) {
            return;
        }
        int rank = this.b.getRank();
        if (rank == 0) {
            ThreadAchievementShareInfo.ThreadListBean threadListBean = this.d.get(rank);
            threadListBean.setDuration(500);
            int i = rank + 1;
            e(i, threadListBean);
            f(rank + 2, this.d.get(i));
            this.u.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.w.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = ej.f(this.c, R.dimen.tbds8);
        } else if (rank == 1) {
            d(rank, this.d.get(rank - 1));
            f(rank + 1, this.d.get(rank));
            this.v.setVisibility(4);
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = ej.f(this.c, R.dimen.tbds5);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0310);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0310);
            SkinManager.setBackgroundColor(this.p, R.color.cp_other_b_alpha20);
        } else {
            int i2 = rank - 1;
            e(i2, this.d.get(rank - 2));
            d(rank, this.d.get(i2));
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = ej.f(this.c, R.dimen.tbds230);
            this.w.setVisibility(4);
        }
    }

    @SuppressLint({"CutPasteId"})
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092219);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909ce);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909d0);
            this.r = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0909d1);
            this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909c6);
            this.n = this.a.findViewById(R.id.obfuscated_res_0x7f0909c7);
            this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091e2b);
            this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091e2d);
            this.s = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091e2e);
            this.j = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091e21);
            this.o = this.a.findViewById(R.id.obfuscated_res_0x7f091e22);
            this.k = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090746);
            this.l = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090748);
            this.t = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090749);
            this.m = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090742);
            this.p = this.a.findViewById(R.id.obfuscated_res_0x7f090743);
            this.v = this.a.findViewById(R.id.obfuscated_res_0x7f0909c9);
            this.w = this.a.findViewById(R.id.obfuscated_res_0x7f091e25);
            this.u = this.a.findViewById(R.id.obfuscated_res_0x7f090744);
            this.I = this.a.findViewById(R.id.obfuscated_res_0x7f0909d2);
            this.H = this.a.findViewById(R.id.obfuscated_res_0x7f091e2f);
            this.G = this.a.findViewById(R.id.obfuscated_res_0x7f09074a);
            this.x = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0909d3);
            this.y = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0909d5);
            this.z = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909d4);
            this.A = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091e30);
            this.B = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091e32);
            this.C = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091e31);
            this.D = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09074b);
            this.E = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09074d);
            this.F = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09074c);
            this.r.setRadius(ej.f(this.c, R.dimen.tbds10));
            this.r.setConrers(15);
            this.r.setPlaceHolder(2);
            this.s.setRadius(ej.f(this.c, R.dimen.tbds10));
            this.s.setConrers(15);
            this.s.setPlaceHolder(2);
            this.t.setRadius(ej.f(this.c, R.dimen.tbds10));
            this.t.setConrers(15);
            this.t.setPlaceHolder(2);
            this.f.setLineSpacing(ej.f(this.c, R.dimen.tbds13), 1.0f);
            this.i.setLineSpacing(ej.f(this.c, R.dimen.tbds13), 1.0f);
            this.l.setLineSpacing(ej.f(this.c, R.dimen.tbds13), 1.0f);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.e, R.drawable.cp_other_d_round_bg);
            SkinManager.setBackgroundResource(this.n, R.drawable.obfuscated_res_0x7f080479);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0310);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.h, R.drawable.cp_link_tip_d_round_bg);
            SkinManager.setBackgroundResource(this.o, R.drawable.obfuscated_res_0x7f080476);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0305);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.k, R.drawable.cp_link_tip_d_round_bg);
            SkinManager.setBackgroundResource(this.p, R.drawable.obfuscated_res_0x7f080476);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0305);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(0).setBgColor(SkinManager.getResourceId(R.color.CAM_X0201)).setShadowColor(SkinManager.getResourceId(R.color.CAM_X0806)).setShadowSide(UIMsg.k_event.MV_MAP_CHANGETO2D).setShadowRadius(ej.f(this.c, R.dimen.tbds16)).setOffsetX(0).setOffsetY(ej.f(this.c, R.dimen.tbds5)).into(this.u);
            this.y.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            this.B.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            this.E.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0101);
        }
    }

    public final void d(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, threadListBean) == null) {
            this.u.setVisibility(0);
            this.k.setText(String.valueOf(i));
            this.l.setText(threadListBean.getTitle());
            if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
                this.p.setVisibility(0);
                TextView textView = this.m;
                textView.setText("热度 " + StringHelper.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
            }
            if (threadListBean.getDuration() > 0) {
                this.D.setVisibility(0);
                this.G.setVisibility(0);
                this.F.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
            }
            if (!TextUtils.isEmpty(threadListBean.getImg())) {
                this.t.setVisibility(0);
                this.t.K(threadListBean.getImg(), 10, false);
                return;
            }
            this.t.setVisibility(8);
            this.D.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.l.getLayoutParams()).rightMargin = ej.f(this.c, R.dimen.tbds44);
        }
    }

    public final void e(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, threadListBean) == null) {
            this.v.setVisibility(0);
            this.e.setText(String.valueOf(i));
            this.f.setText(threadListBean.getTitle());
            if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
                this.n.setVisibility(0);
                TextView textView = this.g;
                textView.setText("热度 " + StringHelper.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
            }
            if (threadListBean.getDuration() > 0) {
                this.x.setVisibility(0);
                this.I.setVisibility(0);
                this.z.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
            }
            if (!TextUtils.isEmpty(threadListBean.getImg())) {
                this.r.setVisibility(0);
                this.r.K(threadListBean.getImg(), 10, false);
                return;
            }
            this.r.setVisibility(8);
            this.x.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.f.getLayoutParams()).rightMargin = ej.f(this.c, R.dimen.tbds44);
        }
    }

    public final void f(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, threadListBean) == null) {
            this.w.setVisibility(0);
            this.h.setText(String.valueOf(i));
            this.i.setText(threadListBean.getTitle());
            if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
                this.o.setVisibility(0);
                TextView textView = this.j;
                textView.setText("热度 " + StringHelper.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
            }
            if (threadListBean.getDuration() > 0) {
                this.A.setVisibility(0);
                this.H.setVisibility(0);
                this.C.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
            }
            if (!TextUtils.isEmpty(threadListBean.getImg())) {
                this.s.setVisibility(0);
                this.s.K(threadListBean.getImg(), 10, false);
                return;
            }
            this.s.setVisibility(8);
            this.A.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.i.getLayoutParams()).rightMargin = ej.f(this.c, R.dimen.tbds44);
        }
    }
}
