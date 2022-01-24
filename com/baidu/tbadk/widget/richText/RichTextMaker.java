package com.baidu.tbadk.widget.richText;

import android.text.SpannableString;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.d1.e0;
import c.a.s0.f1.n.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public abstract class RichTextMaker<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IconPos a;

    /* renamed from: b  reason: collision with root package name */
    public int f41461b;

    /* renamed from: c  reason: collision with root package name */
    public int f41462c;

    /* renamed from: d  reason: collision with root package name */
    public int f41463d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class IconPos {
        public static final /* synthetic */ IconPos[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final IconPos END;
        public static final IconPos NONE;
        public static final IconPos START;
        public static final IconPos START_OFFSET;
        public transient /* synthetic */ FieldHolder $fh;
        public int offset;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1775302457, "Lcom/baidu/tbadk/widget/richText/RichTextMaker$IconPos;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1775302457, "Lcom/baidu/tbadk/widget/richText/RichTextMaker$IconPos;");
                    return;
                }
            }
            START = new IconPos("START", 0);
            END = new IconPos("END", 1);
            NONE = new IconPos(PolyActivity.NONE_PANEL_TYPE, 2);
            IconPos iconPos = new IconPos("START_OFFSET", 3);
            START_OFFSET = iconPos;
            $VALUES = new IconPos[]{START, END, NONE, iconPos};
        }

        public IconPos(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static IconPos valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (IconPos) Enum.valueOf(IconPos.class, str) : (IconPos) invokeL.objValue;
        }

        public static IconPos[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (IconPos[]) $VALUES.clone() : (IconPos[]) invokeV.objValue;
        }

        public IconPos setOffset(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                e0.a(i2 >= 0);
                e0.c(this == START_OFFSET);
                this.offset = i2;
                return this;
            }
            return (IconPos) invokeI.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int l;
        public final /* synthetic */ Object m;
        public final /* synthetic */ RichTextMaker n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RichTextMaker richTextMaker, int i2, String str, int i3, Object obj) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richTextMaker, Integer.valueOf(i2), str, Integer.valueOf(i3), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = richTextMaker;
            this.l = i3;
            this.m = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tbadk.widget.richText.RichTextMaker */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.a.s0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.n.c(view, this.l, this.m);
                view.setTag(R.id.tag_first, Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-126667392, "Lcom/baidu/tbadk/widget/richText/RichTextMaker$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-126667392, "Lcom/baidu/tbadk/widget/richText/RichTextMaker$b;");
                    return;
                }
            }
            int[] iArr = new int[IconPos.values().length];
            a = iArr;
            try {
                iArr[IconPos.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[IconPos.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[IconPos.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[IconPos.START_OFFSET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: g  reason: collision with root package name */
        public static final int f41464g = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final SpannableString a;

        /* renamed from: b  reason: collision with root package name */
        public final int f41465b;

        /* renamed from: c  reason: collision with root package name */
        public final int f41466c;

        /* renamed from: d  reason: collision with root package name */
        public final int f41467d;

        /* renamed from: e  reason: collision with root package name */
        public final int f41468e;

        /* renamed from: f  reason: collision with root package name */
        public final int f41469f;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-126667361, "Lcom/baidu/tbadk/widget/richText/RichTextMaker$c;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-126667361, "Lcom/baidu/tbadk/widget/richText/RichTextMaker$c;");
            }
        }

        public c(@NonNull SpannableString spannableString, int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableString, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = spannableString;
            this.f41465b = i2;
            this.f41466c = i3;
            this.f41467d = i4;
            this.f41468e = i5;
            this.f41469f = i6;
        }

        @NonNull
        public static c g(@NonNull String str, @NonNull IconPos iconPos) {
            InterceptResult invokeLL;
            int i2;
            int i3;
            SpannableString spannableString;
            int i4;
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, iconPos)) == null) {
                int length = str.length();
                int i6 = b.a[iconPos.ordinal()];
                if (i6 != 1) {
                    if (i6 == 2) {
                        SpannableString spannableString2 = new SpannableString(str + "m");
                        i2 = f41464g + length;
                        spannableString = spannableString2;
                        i5 = length + (-1);
                        i4 = i5;
                    } else if (i6 == 3) {
                        spannableString = new SpannableString(str);
                        i4 = length - 1;
                        i5 = 0;
                        i2 = 0;
                    } else if (i6 == 4) {
                        int i7 = iconPos.offset;
                        if (i7 > length) {
                            i7 = length;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(str.substring(0, i7));
                        sb.append("m");
                        sb.append(str.substring(i7));
                        SpannableString spannableString3 = new SpannableString(sb);
                        int i8 = f41464g;
                        spannableString = spannableString3;
                        i5 = i7;
                        i4 = (i8 + length) - 1;
                        i2 = i7 + i8;
                    } else {
                        throw new IllegalArgumentException("IconPos 参数异常");
                    }
                    i3 = 0;
                } else {
                    SpannableString spannableString4 = new SpannableString("m" + str);
                    int i9 = f41464g;
                    i2 = i9;
                    i3 = i2;
                    spannableString = spannableString4;
                    i4 = (length + i9) - 1;
                    i5 = 0;
                }
                return new c(spannableString, i5, i2, i3, i4, 33);
            }
            return (c) invokeLL.objValue;
        }

        @NonNull
        public SpannableString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (SpannableString) invokeV.objValue;
        }
    }

    public RichTextMaker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = IconPos.NONE;
    }

    @NonNull
    public c a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!str.endsWith(" ")) {
                str = str + " ";
            }
            return c.g(str, this.a);
        }
        return (c) invokeL.objValue;
    }

    @NonNull
    public SpannableString b(int i2, @NonNull String str, @NonNull T t) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, t)) == null) {
            c a2 = a(str);
            e(a2);
            d(a2, i2, t);
            return a2.h();
        }
        return (SpannableString) invokeILL.objValue;
    }

    public abstract void c(@NonNull View view, int i2, @NonNull T t);

    public void d(@NonNull c cVar, int i2, @NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, cVar, i2, t) == null) {
            a aVar = new a(this, i2, t instanceof String ? (String) t : "", i2, t);
            aVar.j(this.f41462c);
            cVar.a.setSpan(aVar, cVar.f41467d, cVar.f41468e, cVar.f41469f);
        }
    }

    public void e(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || this.a == IconPos.NONE) {
            return;
        }
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(this.f41461b, this.f41462c, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan.c(this.f41463d);
        if (DeviceInfoUtil.isXiaoMi()) {
            eMRichTextAnyIconSpan.a(R.dimen.tbds6);
        }
        cVar.a.setSpan(eMRichTextAnyIconSpan, cVar.f41465b, cVar.f41466c, cVar.f41469f);
    }

    public void f(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f41462c = i2;
        }
    }

    public void g(@NonNull IconPos iconPos) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iconPos) == null) {
            this.a = iconPos;
        }
    }

    public void h(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f41461b = i2;
        }
    }

    public void i(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f41463d = UtilHelper.getDimenPixelSize(i2);
        }
    }

    public RichTextMaker(@NonNull IconPos iconPos, @DrawableRes int i2, @ColorRes int i3, @DimenRes int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iconPos, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        g(iconPos);
        h(i2);
        f(i3);
        i(i4);
    }
}
