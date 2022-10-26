package com.baidu.tieba.frs.forumRule.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.baidu.tieba.fj;
import com.baidu.tieba.nv4;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class ForumRuleDetailSelfVH extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public HeadImageView b;
    public TextView c;
    public TextView d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public TBSpecificationBtn h;
    public LinearLayout i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public final int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailSelfVH(View view2) {
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
        this.m = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.a = view2;
        a(view2);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090aaf);
            this.b = headImageView;
            headImageView.setRadius(R.dimen.tbds47);
            this.b.setConrers(15);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090abc);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090aba);
            this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ab9);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090aaa);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ab6);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090aae);
            this.h = tBSpecificationBtn;
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f06ce));
            EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090aad);
            this.l = eMTextView;
            eMTextView.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f06d3));
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ab4);
            this.j = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090ab5);
            this.k = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090ab3);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (!"manager".equals(str) && !PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(str)) {
                return;
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{DrawableSelector.make().setShape(0).radius(this.m).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0303, R.color.CAM_X0303).build(), DrawableSelector.make().setShape(0).radius(this.m).defaultColor("#4D000000").build()});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.d.setBackgroundDrawable(layerDrawable);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i > 0) {
            SkinManager.setImageResource(this.e, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.k != null && this.i != null) {
            if (StringUtils.isNull(str)) {
                this.i.setVisibility(8);
                return;
            }
            this.k.setText(str);
            this.i.setVisibility(0);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i == 1) {
                this.h.setVisibility(8);
                this.l.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
            this.h.setVisibility(0);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (str != null && !str.isEmpty() && !str.equals(StringUtil.NULL_STRING)) {
                this.g.setText(h(str));
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            nv4 d = nv4.d(this.c);
            d.A(R.string.F_X01);
            d.v(R.color.CAM_X0105);
            nv4 d2 = nv4.d(this.g);
            d2.A(R.string.F_X01);
            d2.v(R.color.CAM_X0109);
            nv4 d3 = nv4.d(this.l);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0107);
            nv4.d(this.k).v(R.color.CAM_X0105);
            nv4 d4 = nv4.d(this.j);
            d4.A(R.string.F_X02);
            d4.v(R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            this.b.setSkinType(i);
            this.h.setTextSize(R.dimen.T_X08);
        }
    }

    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
        }
        return (String) invokeL.objValue;
    }
}
