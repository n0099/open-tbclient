package com.baidu.tieba;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bv5 extends ClickableSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public String d;
    public String e;
    public int f;
    public int g;
    public int h;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public String b;
        public String c;
        public int d;

        public a(int i, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = i2;
        }
    }

    public bv5(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = -1;
        this.h = 0;
        this.d = str;
        this.c = i;
    }

    public bv5(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = -1;
        this.h = 0;
        this.d = str;
        this.c = i;
        this.g = i2;
    }

    public static void a(Context context, ev5 ev5Var, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{context, ev5Var, Integer.valueOf(i), str, str2}) != null) || ev5Var == null) {
            return;
        }
        if (i != 2) {
            if (i != 16) {
                if (i != 18) {
                    if (i != 32) {
                        if (i != 64) {
                            if (i != 128) {
                                if (i != 256) {
                                    if (i != 1024) {
                                        if (i == 1282) {
                                            ev5Var.Z(context, str, true);
                                            return;
                                        }
                                        return;
                                    }
                                    ev5Var.j0(context, str);
                                    return;
                                }
                                ev5Var.f0(context, str, str2);
                                return;
                            }
                            ev5Var.Y(context, str);
                            return;
                        }
                        ev5Var.g1(context, str);
                        return;
                    }
                    ev5Var.K(context, str);
                    return;
                }
                ev5Var.Z(context, str, true);
                return;
            }
            ev5Var.I(context, str);
            return;
        }
        ev5Var.Z(context, str, false);
    }

    public static void b(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65539, null, tbPageContext, i, str, str2) != null) || tbPageContext == null || !(tbPageContext.getOrignalPage() instanceof ev5)) {
            return;
        }
        a(tbPageContext.getPageActivity(), (ev5) tbPageContext.getOrignalPage(), i, str, str2);
    }

    public static void c(TbPageContext<?> tbPageContext, ev5 ev5Var, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{tbPageContext, ev5Var, Integer.valueOf(i), str, str2}) == null) && tbPageContext != null && ev5Var != null) {
            a(tbPageContext.getPageActivity(), ev5Var, i, str, str2);
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.c;
            if (i != 2 && i != 16 && i != 18 && i != 35 && i != 39) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.c;
            if (i != 2 && i != 16 && i != 18 && i != 35 && i != 39 && i != 1282) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a = i;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f = i;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.e = str;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b = i;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.g = i;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.h = i;
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001332, new a(this.c, this.d, this.e, this.g));
            int i2 = 2;
            if (this.c == 2) {
                int i3 = this.h;
                if (i3 == 1) {
                    i = 2;
                } else if (i3 == 2) {
                    i = 1;
                } else {
                    i = 1;
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PB_URL_CLICK_KEY).param("obj_source", i2).param("obj_type", i));
                }
                i2 = 1;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.PB_URL_CLICK_KEY).param("obj_source", i2).param("obj_type", i));
            }
            if (view2 instanceof TbListTextView) {
                ((TbRichTextView) view2.getParent()).setPressed(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, textPaint) == null) {
            int i = this.b;
            if (i != -1) {
                textPaint.setColor(SkinManager.getColor(i));
            } else if (f()) {
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
            } else {
                textPaint.setColor(textPaint.linkColor);
            }
            textPaint.setUnderlineText(false);
            int i2 = this.a;
            if (i2 != -1) {
                textPaint.bgColor = i2;
            } else if (this.f == 1 && e()) {
                textPaint.bgColor = SkinManager.getColor(R.color.CAM_X0210);
            } else if (this.f == 2) {
                textPaint.bgColor = SkinManager.getColor(R.color.transparent);
            }
        }
    }
}
