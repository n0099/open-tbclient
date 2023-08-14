package com.baidu.tieba;

import android.graphics.Path;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import java.util.StringTokenizer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes5.dex */
public final class frb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public Path b;

    public frb(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) ",", false, 2, (Object) null) ? StringsKt__StringsJVMKt.replace$default(str, ",", " ", false, 4, (Object) null) : str;
    }

    public final void a(Path path) {
        boolean z;
        Set set;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, path) == null) {
            Path path2 = this.b;
            if (path2 != null) {
                path.set(path2);
                return;
            }
            Path path3 = new Path();
            StringTokenizer stringTokenizer = new StringTokenizer(this.a, "MLHVCSQRAZmlhvcsqraz", true);
            String str = "";
            while (stringTokenizer.hasMoreTokens()) {
                String segment = stringTokenizer.nextToken();
                Intrinsics.checkExpressionValueIsNotNull(segment, "segment");
                if (segment.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    set = grb.a;
                    if (set.contains(segment)) {
                        if (Intrinsics.areEqual(segment, "Z") || Intrinsics.areEqual(segment, "z")) {
                            b(path3, segment, new StringTokenizer("", ""));
                        }
                        str = segment;
                    } else {
                        b(path3, str, new StringTokenizer(segment, " "));
                    }
                }
            }
            this.b = path3;
            path.set(path3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Path path, String str, StringTokenizer stringTokenizer) {
        lrb lrbVar;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, path, str, stringTokenizer) == null) {
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                try {
                    String s = stringTokenizer.nextToken();
                    Intrinsics.checkExpressionValueIsNotNull(s, "s");
                    if (s.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (i == 0) {
                            f = Float.parseFloat(s);
                        }
                        if (i == 1) {
                            f2 = Float.parseFloat(s);
                        }
                        if (i == 2) {
                            f3 = Float.parseFloat(s);
                        }
                        if (i == 3) {
                            f4 = Float.parseFloat(s);
                        }
                        if (i == 4) {
                            f5 = Float.parseFloat(s);
                        }
                        if (i == 5) {
                            f6 = Float.parseFloat(s);
                        }
                        i++;
                    }
                } catch (Exception unused) {
                }
            }
            float f7 = f;
            float f8 = f2;
            float f9 = f3;
            float f10 = f4;
            lrb lrbVar2 = new lrb(0.0f, 0.0f, 0.0f);
            if (Intrinsics.areEqual(str, "M")) {
                path.moveTo(f7, f8);
                lrbVar2 = new lrb(f7, f8, 0.0f);
            } else if (Intrinsics.areEqual(str, "m")) {
                path.rMoveTo(f7, f8);
                lrbVar = new lrb(lrbVar2.a() + f7, lrbVar2.b() + f8, 0.0f);
                if (!Intrinsics.areEqual(str, "L")) {
                    path.lineTo(f7, f8);
                } else if (Intrinsics.areEqual(str, "l")) {
                    path.rLineTo(f7, f8);
                }
                if (!Intrinsics.areEqual(str, "C")) {
                    path.cubicTo(f7, f8, f9, f10, f5, f6);
                } else if (Intrinsics.areEqual(str, "c")) {
                    path.rCubicTo(f7, f8, f9, f10, f5, f6);
                }
                if (!Intrinsics.areEqual(str, "Q")) {
                    path.quadTo(f7, f8, f9, f10);
                } else if (Intrinsics.areEqual(str, "q")) {
                    path.rQuadTo(f7, f8, f9, f10);
                }
                if (!Intrinsics.areEqual(str, IEruptionStrategyGroup.STRATEGY_MODIFIER_H)) {
                    path.lineTo(f7, lrbVar.b());
                } else if (Intrinsics.areEqual(str, "h")) {
                    path.rLineTo(f7, 0.0f);
                }
                if (!Intrinsics.areEqual(str, ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                    path.lineTo(lrbVar.a(), f7);
                } else if (Intrinsics.areEqual(str, "v")) {
                    path.rLineTo(0.0f, f7);
                }
                if (!Intrinsics.areEqual(str, "Z")) {
                    path.close();
                    return;
                } else if (Intrinsics.areEqual(str, "z")) {
                    path.close();
                    return;
                } else {
                    return;
                }
            }
            lrbVar = lrbVar2;
            if (!Intrinsics.areEqual(str, "L")) {
            }
            if (!Intrinsics.areEqual(str, "C")) {
            }
            if (!Intrinsics.areEqual(str, "Q")) {
            }
            if (!Intrinsics.areEqual(str, IEruptionStrategyGroup.STRATEGY_MODIFIER_H)) {
            }
            if (!Intrinsics.areEqual(str, ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            }
            if (!Intrinsics.areEqual(str, "Z")) {
            }
        }
    }
}
