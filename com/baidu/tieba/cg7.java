package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public final View b;
    public final RelativeLayout c;
    public final EditText d;
    public final ImageView e;
    public final TextView f;
    public final BdTypeListView g;
    public final ImageView h;
    public int i;

    public cg7(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 3;
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0315, (ViewGroup) null);
        this.b = inflate;
        this.c = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09210c);
        this.h = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09210f);
        this.d = (EditText) this.b.findViewById(R.id.obfuscated_res_0x7f090f7a);
        this.e = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090f6a);
        this.d.setHint(R.string.obfuscated_res_0x7f0f130f);
        TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090f69);
        this.f = textView;
        textView.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f03cf));
        this.g = (BdTypeListView) this.b.findViewById(R.id.obfuscated_res_0x7f092110);
        a();
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.height = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070420);
            int dimens = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f07041c);
            layoutParams.rightMargin = dimens;
            layoutParams.leftMargin = dimens;
            int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
            if (immersiveStickyBarHeight > 0) {
                layoutParams.topMargin = immersiveStickyBarHeight;
            }
            this.c.setLayoutParams(layoutParams);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || this.i == i) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f, R.color.CAM_X0302, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (i == 2) {
            this.d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.i = i;
    }
}
