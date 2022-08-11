package com.baidu.tbadk.widget.ad;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ms4;
import com.repackage.ul5;
/* loaded from: classes3.dex */
public class VipAdFreeGuideLayout extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public LinearLayout d;
    public TextView e;
    public ImageView f;
    public boolean g;
    public int h;
    public String i;
    public String j;
    public AbsDataRecorder.Scene k;
    public String l;
    public boolean m;
    public boolean n;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(172270432, "Lcom/baidu/tbadk/widget/ad/VipAdFreeGuideLayout$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(172270432, "Lcom/baidu/tbadk/widget/ad/VipAdFreeGuideLayout$a;");
                    return;
                }
            }
            int[] iArr = new int[AbsDataRecorder.Scene.values().length];
            a = iArr;
            try {
                iArr[AbsDataRecorder.Scene.RECOMMEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AbsDataRecorder.Scene.FRS_HOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AbsDataRecorder.Scene.FRS_NEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AbsDataRecorder.Scene.PB.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1724958467, "Lcom/baidu/tbadk/widget/ad/VipAdFreeGuideLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1724958467, "Lcom/baidu/tbadk/widget/ad/VipAdFreeGuideLayout;");
                return;
            }
        }
        o = UtilHelper.getDimenPixelSize(R.dimen.M_H_X001);
        p = UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        q = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
        r = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        s = UtilHelper.getDimenPixelSize(R.dimen.M_H_X008);
        t = UtilHelper.getDimenPixelSize(R.dimen.M_W_X013);
        u = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        v = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
        w = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VipAdFreeGuideLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private int getFromScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int i = a.a[this.k.ordinal()];
            if (i != 1) {
                if (i == 2 || i == 3) {
                    return 100015;
                }
                return i != 4 ? 0 : 100017;
            }
            return 100013;
        }
        return invokeV.intValue;
    }

    private String getReferPageAndClickZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            int i = a.a[this.k.ordinal()];
            return i != 1 ? (i == 2 || i == 3) ? MemberPayActivityConfig.AUTOPAY_FROM_LOW_INCOME_FRS : i != 4 ? "" : MemberPayActivityConfig.AUTOPAY_FROM_LOW_INCOME_PB : MemberPayActivityConfig.AUTOPAY_FROM_LOW_INCOME_HOME;
        }
        return (String) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e(CommonStatisticKey.KEY_VIP_AD_FREE_GUID_TIP_CLICK);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09257e);
            this.f = imageView;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            if (layoutParams == null) {
                int i = this.h;
                layoutParams = new LinearLayout.LayoutParams(i, i);
            }
            int i2 = this.h;
            layoutParams.width = i2;
            layoutParams.height = i2;
            this.f.setLayoutParams(layoutParams);
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040330, R.attr.obfuscated_res_0x7f04035b});
            this.g = obtainStyledAttributes.getBoolean(1, false);
            this.h = obtainStyledAttributes.getDimensionPixelOffset(0, u);
            obtainStyledAttributes.recycle();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setClipToPadding(false);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d08e1, (ViewGroup) null);
            this.d = linearLayout;
            this.e = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09257d);
            b();
            if (this.g) {
                this.c = t;
                this.a = r;
                this.b = s;
            }
            int i = this.c;
            setPadding(i, this.a, i, this.b);
            addView(this.d);
            f();
        }
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            int i = a.a[this.k.ordinal()];
            int i2 = 3;
            if (i == 1) {
                i2 = 1;
            } else if (i == 2 || i == 3) {
                i2 = 2;
            } else if (i != 4) {
                i2 = 0;
            }
            statisticItem.addParam("obj_source", i2);
            statisticItem.addParam("fid", this.l);
            TiebaStatic.log(statisticItem);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.j = "#4DFFE1C0";
            } else {
                this.j = "#1AFFE1C0";
            }
            String[] strArr = this.g ? new String[]{this.j, this.i} : new String[]{this.i, this.j};
            if (this.n) {
                TBSelector.makeDrawableSelector().setShape(0).defaultColor(this.j).radius(v).into(this);
            } else {
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TOP_BOTTOM, strArr).blRadius(this.m ? v : 0.0f).brRadius(this.m ? v : 0.0f).into(this);
            }
            ms4 d = ms4.d(this.e);
            d.z(R.dimen.T_X07);
            d.v(R.color.CAM_X0311);
            if (this.g) {
                WebPManager.setPureDrawable(this.f, R.drawable.obfuscated_res_0x7f080a2a, R.color.CAM_X0626, null);
            } else {
                WebPManager.setPureDrawable(this.f, R.drawable.obfuscated_res_0x7f080a29, R.color.CAM_X0311, null);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.g) {
                this.f.setOnClickListener(this);
            } else {
                setOnClickListener(this);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            e(CommonStatisticKey.KEY_VIP_AD_FREE_GUID_TIP_SHOW);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            setGuideContent(ul5.e().h(), ul5.e().g());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if (this.g) {
                view2.getId();
                this.f.getId();
                return;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(getContext(), TbadkCoreApplication.getCurrentMemberType(), "", 27, true);
            memberPayActivityConfig.setFid(this.l);
            memberPayActivityConfig.setFromScence(getFromScene());
            String referPageAndClickZone = getReferPageAndClickZone();
            memberPayActivityConfig.setReferPageClickZone(referPageAndClickZone, referPageAndClickZone);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            a();
        }
    }

    public void setAllCornerRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.n = z;
            if (z) {
                int i = this.c;
                int i2 = w;
                setPadding(i, i2, i, i2);
            }
        }
    }

    public void setBottomCornerRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.m = z;
        }
    }

    public void setCloseClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.f.setOnClickListener(onClickListener);
        }
    }

    public void setGuideContent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) || StringUtils.isNull(str) || this.e == null) {
            return;
        }
        if (!StringUtils.isNull(str2)) {
            int indexOf = str.indexOf(str2);
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), indexOf, str2.length() + indexOf, 33);
            this.e.setText(spannableString);
            return;
        }
        this.e.setText(str);
    }

    public void setInfo(AbsDataRecorder.Scene scene, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, scene, str) == null) {
            this.k = scene;
            this.l = str;
            if (this.g) {
                return;
            }
            h();
        }
    }

    public void setLayoutPadding(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048591, this, i, i2, i3) == null) {
            if (i < 0) {
                this.a = o;
            } else {
                this.a = i;
            }
            if (i2 < 0) {
                this.b = p;
            } else {
                this.b = i2;
            }
            if (i3 < 0) {
                this.c = q;
            } else {
                this.c = i3;
            }
            int i4 = this.c;
            setPadding(i4, this.a, i4, this.b);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VipAdFreeGuideLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipAdFreeGuideLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = o;
        this.b = p;
        this.c = q;
        this.i = "#00000000";
        this.j = "#4DFFE1C0";
        c(context, attributeSet);
        d();
        g();
    }
}
