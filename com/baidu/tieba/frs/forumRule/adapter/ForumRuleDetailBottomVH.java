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
import com.baidu.tieba.ii;
import com.baidu.tieba.r25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
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
        BarImageView barImageView = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b99);
        this.b = barImageView;
        barImageView.setShowOval(true);
        this.b.setShowOuterBorder(false);
        this.b.setShowInnerBorder(true);
        this.b.setStrokeWith(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.b.setStrokeColorResId(R.color.CAM_X0401);
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b9a);
        this.d = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090b9d);
        this.e = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090b9c);
        HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b9f);
        this.f = headImageView;
        headImageView.setBorderWidth(R.dimen.L_X01);
        this.f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.f.setRadius(R.dimen.tbds42);
        this.f.setConrers(15);
        this.g = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090ba0);
        this.h = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090bab);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f0907e4);
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
                this.h.setText(String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0712), c(str)));
                this.e.setText(String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0712), c(str)));
                return;
            }
            this.h.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0205);
            r25 d = r25.d(this.d);
            d.C(R.string.F_X01);
            d.w(R.color.CAM_X0105);
            r25 d2 = r25.d(this.e);
            d2.C(R.string.F_X01);
            d2.w(R.color.CAM_X0109);
            r25 d3 = r25.d(this.g);
            d3.C(R.string.F_X01);
            d3.w(R.color.CAM_X0105);
            r25 d4 = r25.d(this.h);
            d4.C(R.string.F_X01);
            d4.w(R.color.CAM_X0109);
            this.c.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080862, WebPManager.ResourceStateType.NORMAL));
            this.f.setSkinType(i);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0111);
        }
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
        }
        return (String) invokeL.objValue;
    }
}
