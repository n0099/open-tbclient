package com.baidu.tieba.frs.forumRule.adapter;

import android.view.View;
import android.widget.ImageView;
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
import com.repackage.oi;
import com.repackage.vr4;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class ForumRuleDetailBottomVH extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public BarImageView b;
    public ImageView c;
    public EMTextView d;
    public EMTextView e;
    public HeadImageView f;
    public EMTextView g;
    public EMTextView h;
    public View i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailBottomVH(View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
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
        this.a = view2;
        BarImageView barImageView = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a75);
        this.b = barImageView;
        barImageView.setShowOval(true);
        this.b.setShowOuterBorder(false);
        this.b.setShowInnerBorder(true);
        this.b.setStrokeWith(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.b.setStrokeColorResId(R.color.CAM_X0401);
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a76);
        this.d = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090a79);
        this.e = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090a78);
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a7b);
        this.f = headImageView;
        headImageView.setBorderWidth(R.dimen.L_X01);
        this.f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f.setRadius(R.dimen.tbds42);
        this.f.setConrers(15);
        this.g = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090a7c);
        this.h = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090a87);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f09072f);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
                this.h.setText(String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f069f), e(str)));
                this.e.setText(String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f069f), e(str)));
                return;
            }
            this.h.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0205);
            vr4 d = vr4.d(this.d);
            d.A(R.string.F_X01);
            d.v(R.color.CAM_X0105);
            vr4 d2 = vr4.d(this.e);
            d2.A(R.string.F_X01);
            d2.v(R.color.CAM_X0109);
            vr4 d3 = vr4.d(this.g);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0105);
            vr4 d4 = vr4.d(this.h);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0109);
            this.c.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080807, WebPManager.ResourceStateType.NORMAL));
            this.f.setSkinType(i);
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
