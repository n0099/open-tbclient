package com.baidu.tieba;

import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cz extends zx implements ry<s35>, sy {
    public static /* synthetic */ Interceptable $ic;
    public static final int h;
    public transient /* synthetic */ FieldHolder $fh;
    public NEGFeedBackView e;
    public Align f;
    public boolean g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302102, "Lcom/baidu/tieba/cz;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302102, "Lcom/baidu/tieba/cz;");
                return;
            }
        }
        h = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zx
    /* renamed from: n */
    public NEGFeedBackView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (NEGFeedBackView) invokeV.objValue;
    }

    public cz(TbPageContext tbPageContext, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, align};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        h(-1);
        NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(tbPageContext);
        this.e = nEGFeedBackView;
        nEGFeedBackView.setId(R.id.decor_item_right_id);
        g(this.e);
        l(align);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public cz(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, r9);
        Align align;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (Align) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (z) {
            align = Align.ALIGN_RIGHT_BOTTOM;
        } else {
            align = Align.ALIGN_RIGHT_TOP;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ry
    /* renamed from: o */
    public void b(s35 s35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, s35Var) == null) {
            if (s35Var == null) {
                this.e.setVisibility(8);
                return;
            }
            this.e.setData(s35Var);
            this.e.setFirstRowSingleColumn(true);
            this.e.setVisibility(0);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.e.setAutoProcess(z);
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.e.setHeadText(str);
        }
    }

    public void s(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.e.setEventCallback(bVar);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.e.y(z);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds57);
            int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
            int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds34);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = g2;
            layoutParams.topMargin = g3;
            i(layoutParams);
            this.e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.e.setPadding(0, 0, 0, 0);
            this.e.setLayoutParams(layoutParams);
        }
    }

    public void l(Align align) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, align) != null) || this.f == align) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds80);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds88);
        if (align == Align.ALIGN_RIGHT_TOP) {
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds50);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimenPixelSize3;
            layoutParams.topMargin = dimenPixelSize4;
            i(layoutParams);
            this.e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.e.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.e.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = dimenPixelSize5;
            layoutParams2.bottomMargin = 0;
            i(layoutParams2);
            this.e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.e.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.e.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            int i = h;
            int g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = g2;
            layoutParams3.bottomMargin = g3;
            i(layoutParams3);
            this.e.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.e.setPadding(g, g, g, g);
            this.e.setLayoutParams(layoutParams3);
        }
        this.f = align;
    }

    public void m(t15 t15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, t15Var) == null) && t15Var != null && t15Var.getNegFeedBackData() != null) {
            if (t15Var.getNegFeedBackData().h() <= 0 && t15Var.getThreadData() != null) {
                if (!t15Var.showCardBottomOpWeight() && !t15Var.isFromFrs()) {
                    l(Align.ALIGN_RIGHT_BOTTOM);
                } else if (t15Var.isSupportTop()) {
                    t(UtilHelper.getDimenPixelSize(R.dimen.tbds50));
                } else if (t15Var.isSupportBottom()) {
                    mz mzVar = this.d;
                    if (mzVar != null) {
                        mzVar.o(this);
                    }
                } else {
                    l(Align.ALIGN_RIGHT_TOP);
                }
            } else if (this.g) {
                k();
            } else {
                p(t15Var);
            }
        }
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            if (this.e.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds80);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds88);
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.rightMargin = dimenPixelSize3;
                layoutParams2.topMargin = i;
                i(layoutParams2);
                this.e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.e.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.e.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.baidu.tieba.sy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            this.e.u();
        }
    }

    public final void p(t15 t15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t15Var) == null) {
            if (t15Var.showCardBottomOpWeight()) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds80);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds88);
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds50);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimenPixelSize3;
                layoutParams.topMargin = dimenPixelSize4;
                i(layoutParams);
                this.e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.e.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.e.setLayoutParams(layoutParams);
                return;
            }
            int i = h;
            int g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds17);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = g2;
            layoutParams2.topMargin = g3;
            i(layoutParams2);
            this.e.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.e.setPadding(g, g, g, g);
            this.e.setLayoutParams(layoutParams2);
        }
    }
}
