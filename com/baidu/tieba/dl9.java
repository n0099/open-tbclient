package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c05;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes4.dex */
public class dl9 {
    public static /* synthetic */ Interceptable $ic;
    public static ye a;
    public static Runnable b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface f {
        void onRefresh();
    }

    /* loaded from: classes4.dex */
    public static class c implements xe {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ SpannableString c;
        public final /* synthetic */ int d;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (dl9.a != null) {
                        dl9.a.d();
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getPageActivity(), true, 23004, "expiring");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            }
        }

        public c(TbPageContext tbPageContext, boolean z, SpannableString spannableString, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, Boolean.valueOf(z), spannableString, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = z;
            this.c = spannableString;
            this.d = i;
        }

        @Override // com.baidu.tieba.xe
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.b) {
                    return 4;
                }
                return 2;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.b) {
                    return 32;
                }
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.b) {
                    return 0;
                }
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.b) {
                    return 5;
                }
                return 30;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                TextView textView = new TextView(this.a.getPageActivity());
                if (this.b) {
                    textView.setBackgroundResource(R.drawable.pop_float_top);
                } else {
                    textView.setBackgroundResource(R.drawable.pop_float);
                }
                int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
                int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027a);
                if (this.b) {
                    textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
                } else {
                    textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
                }
                textView.setGravity(17);
                textView.setText(this.c);
                textView.setCompoundDrawablePadding(dimensionPixelSize);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(this.d), (Drawable) null);
                textView.setOnClickListener(new a(this));
                return textView;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class a implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public a(TbPageContext tbPageContext) {
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
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.getPageActivity(), true, 23004, "remind");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                c05Var.dismiss();
                TiebaStatic.log(TbadkCoreStatisticKey.REMIND_EXPIRED);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ boolean b;

        public d(TbPageContext tbPageContext, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dl9.e(this.a.getPageActivity(), this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && dl9.a != null) {
                dl9.a.d();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947708536, "Lcom/baidu/tieba/dl9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947708536, "Lcom/baidu/tieba/dl9;");
                return;
            }
        }
        b = new e();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && b != null) {
            jg.a().removeCallbacks(b);
        }
    }

    public static void e(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, null, activity, z) == null) {
            ye yeVar = a;
            if (yeVar != null) {
                yeVar.m(activity);
            }
            if (z) {
                return;
            }
            jg.a().postDelayed(b, 5000L);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: com.baidu.tieba.ze */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v7 */
    public static void c(TbPageContext tbPageContext, View view2, boolean z, f fVar) {
        int i;
        SpannableString spannableString;
        ?? r12;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{tbPageContext, view2, Boolean.valueOf(z), fVar}) != null) || !TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class)) {
            return;
        }
        long defaultBubbleEndTime = TbadkCoreApplication.getInst().getDefaultBubbleEndTime();
        if (defaultBubbleEndTime <= 0) {
            return;
        }
        long currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis >= defaultBubbleEndTime) {
            MessageManager.getInstance().runTask(2001283, TbPageContext.class, tbPageContext);
            TbadkCoreApplication.getInst().setDefaultBubble(null);
            TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(null);
            TbadkCoreApplication.getInst().setDefaultBubbleEndTime(0);
            if (fVar != null) {
                fVar.onRefresh();
            }
            c05 c05Var = new c05(tbPageContext.getPageActivity());
            c05Var.setCanceledOnTouchOutside(false);
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.bubble_free_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0923c8);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0923c9);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
            textView.setText(tbPageContext.getPageActivity().getString(R.string.bubble_ended_tip));
            textView2.setText(tbPageContext.getPageActivity().getString(R.string.bubble_ended_tip2));
            textView2.setTextSize(0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b7));
            c05Var.setContentView(inflate);
            c05Var.setPositiveButton(R.string.open_now, new a(tbPageContext));
            c05Var.setNegativeButton(R.string.group_create_private_isee, new b());
            c05Var.create(tbPageContext);
            c05Var.show();
            return;
        }
        long j = (defaultBubbleEndTime - currentTimeMillis) / 86400;
        if (j <= 3 && j >= 0) {
            if (System.currentTimeMillis() / 86400000 == p45.m().o("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                return;
            }
            if (i == 0) {
                if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                    spannableString = new SpannableString(tbPageContext.getPageActivity().getString(R.string.bubble_end_time_tip_today));
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0111)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), 9, 13, 34);
                } else {
                    spannableString = new SpannableString(String.format(tbPageContext.getPageActivity().getString(R.string.bubble_end_time_tip), 1));
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0111)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), 10, 14, 34);
                }
                r12 = 0;
            } else {
                String string = tbPageContext.getPageActivity().getString(R.string.bubble_end_time_tip);
                Long valueOf = Long.valueOf(j);
                r12 = 0;
                spannableString = new SpannableString(String.format(string, valueOf));
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0111)), 0, spannableString.length(), 34);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), 10, 14, 34);
            }
            ze zeVar = new ze();
            zeVar.k(view2);
            zeVar.c(r12);
            zeVar.j(r12);
            zeVar.a(new c(tbPageContext, z, spannableString, R.drawable.pop_float_arrow));
            zeVar.d(true);
            zeVar.i(r12);
            a = zeVar.b();
            new Handler().postDelayed(new d(tbPageContext, z), 1000L);
            p45.m().A("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
        }
    }
}
