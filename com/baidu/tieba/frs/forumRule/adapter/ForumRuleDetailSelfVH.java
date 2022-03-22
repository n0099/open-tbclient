package com.baidu.tieba.frs.forumRule.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.o0.r.v.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes5.dex */
public class ForumRuleDetailSelfVH extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f32503b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32504c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32505d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f32506e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f32507f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f32508g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f32509h;
    public LinearLayout i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public final int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailSelfVH(View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.a = view;
        c(view);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090a7c);
            this.f32503b = headImageView;
            headImageView.setRadius(R.dimen.tbds47);
            this.f32503b.setConrers(15);
            this.f32504c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a89);
            this.f32505d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a87);
            this.f32506e = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090a86);
            this.f32507f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a77);
            this.f32508g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a83);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view.findViewById(R.id.obfuscated_res_0x7f090a7b);
            this.f32509h = tBSpecificationBtn;
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0694));
            EMTextView eMTextView = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f090a7a);
            this.l = eMTextView;
            eMTextView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0699));
            this.i = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090a81);
            this.j = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f090a82);
            this.k = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f090a80);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || i <= 0) {
            return;
        }
        SkinManager.setImageResource(this.f32506e, BitmapHelper.getGradeResourceIdInEnterForum(i));
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.k == null || this.i == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            this.i.setVisibility(8);
            return;
        }
        this.k.setText(str);
        this.i.setVisibility(0);
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            c d2 = c.d(this.f32504c);
            d2.A(R.string.F_X01);
            d2.v(R.color.CAM_X0105);
            c d3 = c.d(this.f32508g);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0109);
            c d4 = c.d(this.l);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0107);
            c.d(this.k).v(R.color.CAM_X0105);
            c d5 = c.d(this.j);
            d5.A(R.string.F_X02);
            d5.v(R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f32507f, (int) R.color.CAM_X0109);
            this.f32503b.setSkinType(i);
            this.f32509h.setTextSize(R.dimen.T_X08);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i == 1) {
                this.f32509h.setVisibility(8);
                this.l.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
            this.f32509h.setVisibility(0);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
                this.f32508g.setText(j(str));
            } else {
                this.f32508g.setVisibility(8);
            }
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if ("manager".equals(str) || PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(str)) {
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{DrawableSelector.make().setShape(0).radius(this.m).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0303, R.color.CAM_X0303).build(), DrawableSelector.make().setShape(0).radius(this.m).defaultColor("#4D000000").build()});
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (layerDrawable.getDrawable(1) != null) {
                        layerDrawable.getDrawable(1).setAlpha(255);
                    }
                } else if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(0);
                }
                this.f32505d.setBackgroundDrawable(layerDrawable);
                SkinManager.setViewTextColor(this.f32505d, (int) R.color.CAM_X0101);
            }
        }
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
        }
        return (String) invokeL.objValue;
    }
}
