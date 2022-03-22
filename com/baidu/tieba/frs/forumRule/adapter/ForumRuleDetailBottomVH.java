package com.baidu.tieba.frs.forumRule.adapter;

import android.view.View;
import android.widget.ImageView;
import c.a.d.f.p.n;
import c.a.o0.r.v.c;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes5.dex */
public class ForumRuleDetailBottomVH extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public BarImageView f32492b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f32493c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f32494d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f32495e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f32496f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f32497g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f32498h;
    public View i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailBottomVH(View view) {
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
        this.a = view;
        BarImageView barImageView = (BarImageView) view.findViewById(R.id.obfuscated_res_0x7f090a72);
        this.f32492b = barImageView;
        barImageView.setShowOval(true);
        this.f32492b.setShowOuterBorder(false);
        this.f32492b.setShowInnerBorder(true);
        this.f32492b.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f32492b.setStrokeColorResId(R.color.CAM_X0401);
        this.f32493c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090a73);
        this.f32494d = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f090a76);
        this.f32495e = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f090a75);
        HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090a78);
        this.f32496f = headImageView;
        headImageView.setBorderWidth(R.dimen.L_X01);
        this.f32496f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f32496f.setRadius(R.dimen.tbds42);
        this.f32496f.setConrers(15);
        this.f32497g = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f090a79);
        this.f32498h = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f090a84);
        this.i = view.findViewById(R.id.obfuscated_res_0x7f090726);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
                this.f32498h.setText(String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f069a), e(str)));
                this.f32495e.setText(String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f069a), e(str)));
                return;
            }
            this.f32498h.setVisibility(8);
            this.f32495e.setVisibility(8);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0205);
            c d2 = c.d(this.f32494d);
            d2.A(R.string.F_X01);
            d2.v(R.color.CAM_X0105);
            c d3 = c.d(this.f32495e);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0109);
            c d4 = c.d(this.f32497g);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0105);
            c d5 = c.d(this.f32498h);
            d5.A(R.string.F_X01);
            d5.v(R.color.CAM_X0109);
            this.f32493c.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080804, WebPManager.ResourceStateType.NORMAL));
            this.f32496f.setSkinType(i);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0111);
        }
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
        }
        return (String) invokeL.objValue;
    }
}
