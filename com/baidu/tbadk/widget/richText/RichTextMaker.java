package com.baidu.tbadk.widget.richText;

import android.text.SpannableString;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.f26;
import com.baidu.tieba.rx5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes5.dex */
public abstract class RichTextMaker<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IconPos a;
    public int b;
    public int c;
    public int d;
    public int e;

    public abstract void c(@NonNull View view2, int i, @NonNull T t);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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
            NONE = new IconPos(HlsPlaylistParser.METHOD_NONE, 2);
            IconPos iconPos = new IconPos("START_OFFSET", 3);
            START_OFFSET = iconPos;
            $VALUES = new IconPos[]{START, END, NONE, iconPos};
        }

        public IconPos(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (IconPos) Enum.valueOf(IconPos.class, str);
            }
            return (IconPos) invokeL.objValue;
        }

        public IconPos setOffset(int i) {
            InterceptResult invokeI;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                boolean z2 = true;
                if (i >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                rx5.a(z);
                if (this != START_OFFSET) {
                    z2 = false;
                }
                rx5.d(z2);
                this.offset = i;
                return this;
            }
            return (IconPos) invokeI.objValue;
        }

        public static IconPos[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (IconPos[]) $VALUES.clone();
            }
            return (IconPos[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends f26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int m;
        public final /* synthetic */ Object n;
        public final /* synthetic */ RichTextMaker o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RichTextMaker richTextMaker, int i, String str, int i2, Object obj) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {richTextMaker, Integer.valueOf(i), str, Integer.valueOf(i2), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = richTextMaker;
            this.m = i2;
            this.n = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tbadk.widget.richText.RichTextMaker */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tieba.f26, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                f26.b bVar = this.j;
                if (bVar != null) {
                    bVar.a(this);
                }
                this.o.c(view2, this.m, this.n);
                view2.setTag(R.id.tag_first, Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int g = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final SpannableString a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

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

        public c(@NonNull SpannableString spannableString, int i, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableString, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = spannableString;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
        }

        @NonNull
        public static c g(@NonNull String str, @NonNull IconPos iconPos) {
            InterceptResult invokeLL;
            int i;
            int i2;
            SpannableString spannableString;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, iconPos)) == null) {
                int length = str.length();
                int i5 = b.a[iconPos.ordinal()];
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 4) {
                                int i6 = iconPos.offset;
                                if (i6 > length) {
                                    i6 = length;
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(str.substring(0, i6));
                                sb.append("m");
                                sb.append(str.substring(i6));
                                SpannableString spannableString2 = new SpannableString(sb);
                                int i7 = g;
                                spannableString = spannableString2;
                                i4 = i6;
                                i3 = (i7 + length) - 1;
                                i = i6 + i7;
                            } else {
                                throw new IllegalArgumentException("IconPos 参数异常");
                            }
                        } else {
                            spannableString = new SpannableString(str);
                            i3 = length - 1;
                            i4 = 0;
                            i = 0;
                        }
                    } else {
                        SpannableString spannableString3 = new SpannableString(str + "m");
                        i = g + length;
                        spannableString = spannableString3;
                        i4 = length + (-1);
                        i3 = i4;
                    }
                    i2 = 0;
                } else {
                    SpannableString spannableString4 = new SpannableString("m" + str);
                    int i8 = g;
                    i = i8;
                    i2 = i;
                    spannableString = spannableString4;
                    i3 = (length + i8) - 1;
                    i4 = 0;
                }
                return new c(spannableString, i4, i, i2, i3, 33);
            }
            return (c) invokeLL.objValue;
        }

        @NonNull
        public SpannableString h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (SpannableString) invokeV.objValue;
        }
    }

    public RichTextMaker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = IconPos.NONE;
    }

    public RichTextMaker(@NonNull IconPos iconPos, @DrawableRes int i, @ColorRes int i2, @DimenRes int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iconPos, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        g(iconPos);
        h(i);
        f(i2);
        i(i3);
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

    public void f(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.c = i;
        }
    }

    public void g(@NonNull IconPos iconPos) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iconPos) == null) {
            this.a = iconPos;
        }
    }

    public void h(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b = i;
        }
    }

    public void i(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.e = UtilHelper.getDimenPixelSize(i);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.d = i;
        }
    }

    @NonNull
    public SpannableString b(int i, @NonNull String str, @NonNull T t) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, t)) == null) {
            c a2 = a(str);
            e(a2);
            d(a2, i, t);
            return a2.h();
        }
        return (SpannableString) invokeILL.objValue;
    }

    public void d(@NonNull c cVar, int i, @NonNull T t) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, cVar, i, t) == null) {
            if (t instanceof String) {
                str = (String) t;
            } else {
                str = "";
            }
            a aVar = new a(this, i, str, i, t);
            aVar.r(this.c);
            aVar.t(this.d);
            cVar.a.setSpan(aVar, cVar.d, cVar.e, cVar.f);
        }
    }

    public void e(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) && this.a != IconPos.NONE) {
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(this.b, this.c, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.i(this.e);
            eMRichTextAnyIconSpan.h(true);
            cVar.a.setSpan(eMRichTextAnyIconSpan, cVar.b, cVar.c, cVar.f);
        }
    }
}
