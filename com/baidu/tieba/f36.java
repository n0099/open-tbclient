package com.baidu.tieba;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.Nullable;
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
import java.util.Map;
/* loaded from: classes5.dex */
public class f36 extends ClickableSpan {
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
    public b i;
    public String j;
    @Nullable
    public Map<String, Object> k;

    /* loaded from: classes5.dex */
    public interface b {
        void a(f36 f36Var);
    }

    /* loaded from: classes5.dex */
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

    public f36(int i, String str) {
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

    public f36(int i, String str, int i2) {
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

    public static void a(Context context, i36 i36Var, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{context, i36Var, Integer.valueOf(i), str, str2}) != null) || i36Var == null) {
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
                                            i36Var.Z(context, str, true);
                                            return;
                                        }
                                        return;
                                    }
                                    i36Var.i0(context, str);
                                    return;
                                }
                                i36Var.e0(context, str, str2);
                                return;
                            }
                            i36Var.Y(context, str);
                            return;
                        }
                        i36Var.i1(context, str);
                        return;
                    }
                    i36Var.J(context, str);
                    return;
                }
                i36Var.Z(context, str, true);
                return;
            }
            i36Var.H(context, str);
            return;
        }
        i36Var.Z(context, str, false);
    }

    public static void b(TbPageContext<?> tbPageContext, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65539, null, tbPageContext, i, str, str2) != null) || tbPageContext == null || !(tbPageContext.getOrignalPage() instanceof i36)) {
            return;
        }
        a(tbPageContext.getPageActivity(), (i36) tbPageContext.getOrignalPage(), i, str, str2);
    }

    public static void c(TbPageContext<?> tbPageContext, i36 i36Var, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{tbPageContext, i36Var, Integer.valueOf(i), str, str2}) == null) && tbPageContext != null && i36Var != null) {
            a(tbPageContext.getPageActivity(), i36Var, i, str, str2);
        }
    }

    @Nullable
    public Map<String, Object> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return (Map) invokeV.objValue;
    }

    @Nullable
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.c;
            if (i != 2 && i != 16 && i != 18 && i != 35 && i != 39) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.c;
            if (i != 2 && i != 16 && i != 18 && i != 35 && i != 39 && i != 1282) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void j(@Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, map) == null) {
            this.k = map;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.j = str;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.a = i;
        }
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f = i;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.e = str;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.b = i;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.g = i;
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.h = i;
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            b bVar = this.i;
            if (bVar != null) {
                bVar.a(this);
                return;
            }
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
        if (interceptable == null || interceptable.invokeL(1048593, this, textPaint) == null) {
            int i = this.b;
            if (i != -1) {
                textPaint.setColor(SkinManager.getColor(i));
            } else if (i()) {
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
            } else {
                textPaint.setColor(textPaint.linkColor);
            }
            textPaint.setUnderlineText(false);
            int i2 = this.a;
            if (i2 != -1) {
                textPaint.bgColor = i2;
            } else if (this.f == 1 && h()) {
                textPaint.bgColor = SkinManager.getColor(R.color.CAM_X0210);
            } else if (this.f == 2) {
                textPaint.bgColor = SkinManager.getColor(R.color.transparent);
            }
        }
    }
}
