package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(ClogBuilder.Page page, ClogBuilder.LogType logType, String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{page, logType, str, str2, str3, str4, str5, str6}) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.j(str2);
            clogBuilder.u(page);
            clogBuilder.p(str);
            clogBuilder.k(str3);
            clogBuilder.l(str4);
            clogBuilder.m(str5);
            clogBuilder.n(str6);
            n31.b(clogBuilder);
        }
    }

    public static /* synthetic */ void b(ClogBuilder.Page page, ClogBuilder.LogType logType, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        ClogBuilder.Page page2;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        if ((i & 1) != 0) {
            page2 = ClogBuilder.Page.WELFAREMAXLP;
        } else {
            page2 = page;
        }
        if ((i & 8) != 0) {
            str7 = "";
        } else {
            str7 = str2;
        }
        if ((i & 16) != 0) {
            str8 = "";
        } else {
            str8 = str3;
        }
        if ((i & 32) != 0) {
            str9 = "";
        } else {
            str9 = str4;
        }
        if ((i & 64) != 0) {
            str10 = "";
        } else {
            str10 = str5;
        }
        if ((i & 128) != 0) {
            str11 = "";
        } else {
            str11 = str6;
        }
        a(page2, logType, str, str7, str8, str9, str10, str11);
    }

    public static final void c(String str, String type, String coin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, type, coin) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(coin, "coin");
            if (str != null) {
                b(null, ClogBuilder.LogType.REWARD_ACTIVATE_TASK, str, null, type, coin, null, null, 201, null);
            }
        }
    }

    public static final void e(String str, String ext1, String ext2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, ext1, ext2) == null) {
            Intrinsics.checkNotNullParameter(ext1, "ext1");
            Intrinsics.checkNotNullParameter(ext2, "ext2");
            if (str != null) {
                b(null, ClogBuilder.LogType.CHECK, str, null, ext1, ext2, null, null, 201, null);
            }
        }
    }

    public static final void g(String str, String type, String coin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, type, coin) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(coin, "coin");
            if (str != null) {
                b(null, ClogBuilder.LogType.REWARD_COMPLETE_TASK, str, null, type, coin, null, null, 201, null);
            }
        }
    }

    public static final void k(String str, String ext1, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, str, ext1, str2) == null) {
            Intrinsics.checkNotNullParameter(ext1, "ext1");
            if (str != null) {
                ClogBuilder.LogType logType = ClogBuilder.LogType.REWARD_COMPLETE_TASK;
                if (str2 == null) {
                    str2 = "";
                }
                b(null, logType, str, null, ext1, str2, null, null, 201, null);
            }
        }
    }

    public static final void l(String str, String ext1, String ext2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, str, ext1, ext2) == null) {
            Intrinsics.checkNotNullParameter(ext1, "ext1");
            Intrinsics.checkNotNullParameter(ext2, "ext2");
            if (str != null) {
                b(null, ClogBuilder.LogType.REWARD_COIN_FAIL, str, null, ext1, ext2, null, null, 201, null);
            }
        }
    }

    public static final void t(String str, String str2, String str3) {
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65555, null, str, str2, str3) == null) && str != null) {
            ClogBuilder.Page page = ClogBuilder.Page.WELFARETAIL;
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_SHOW;
            if (str2 == null) {
                str4 = "0";
            } else {
                str4 = str2;
            }
            if (str3 == null) {
                str5 = "0";
            } else {
                str5 = str3;
            }
            b(page, logType, str, null, str4, str5, null, null, 200, null);
        }
    }

    public static final void u(String str, String type, String coin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, str, type, coin) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(coin, "coin");
            if (str != null) {
                b(null, ClogBuilder.LogType.REWARD_SHOW_TASK, str, null, type, coin, null, null, 201, null);
            }
        }
    }

    public static final void d(String str, String coin, String sessionInfo, String upperLimit, String videoDownloadCoin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, str, coin, sessionInfo, upperLimit, videoDownloadCoin) == null) {
            Intrinsics.checkNotNullParameter(coin, "coin");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            Intrinsics.checkNotNullParameter(upperLimit, "upperLimit");
            Intrinsics.checkNotNullParameter(videoDownloadCoin, "videoDownloadCoin");
            if (str != null) {
                b(null, ClogBuilder.LogType.FREE_SHOW, str, "popper", coin, sessionInfo, upperLimit, videoDownloadCoin, 1, null);
            }
        }
    }

    public static final void f(ur0 model) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, model) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            String ext = model.f.d;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            Intrinsics.checkNotNullExpressionValue(ext, "ext");
            b(null, logType, ext, "arrow", null, null, null, null, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, null);
            hj0.b(model.e);
        }
    }

    public static final void q(ur0 model) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, model) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            String ext = model.f.d;
            ClogBuilder.LogType logType = ClogBuilder.LogType.SHOW;
            Intrinsics.checkNotNullExpressionValue(ext, "ext");
            b(null, logType, ext, null, null, null, null, null, 249, null);
            hj0.c(model.e);
        }
    }

    public static final void r(ur0 model) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, model) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            String ext = model.f.d;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            Intrinsics.checkNotNullExpressionValue(ext, "ext");
            b(null, logType, ext, "sv_button", null, null, null, null, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, null);
            hj0.b(model.e);
        }
    }

    public static final void s(ur0 model) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, model) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            String ext = model.f.d;
            ClogBuilder.LogType logType = ClogBuilder.LogType.CLICK;
            String str = ClogBuilder.Area.SWIPE_UP.type;
            Intrinsics.checkNotNullExpressionValue(str, "ClogBuilder.Area.SWIPE_UP.type");
            Intrinsics.checkNotNullExpressionValue(ext, "ext");
            b(null, logType, ext, str, null, null, null, null, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, null);
            hj0.b(model.e);
        }
    }

    public static final void h(String str, String type, String str2, String str3) {
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, str, type, str2, str3) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (str != null) {
                ClogBuilder.Page page = ClogBuilder.Page.WELFAREPANEL;
                ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_SHOW;
                if (str2 == null) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if (str3 == null) {
                    str5 = "";
                } else {
                    str5 = str3;
                }
                b(page, logType, str, null, null, type, str4, str5, 24, null);
            }
        }
    }

    public static final void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, str) == null) && str != null) {
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            String str2 = ClogBuilder.Area.DOWN_ARROW.type;
            Intrinsics.checkNotNullExpressionValue(str2, "ClogBuilder.Area.DOWN_ARROW.type");
            b(null, logType, str, str2, null, null, null, null, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, null);
        }
    }

    public static final void j(String str, String ext1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, ext1) == null) {
            Intrinsics.checkNotNullParameter(ext1, "ext1");
            if (str != null) {
                b(null, ClogBuilder.LogType.REWARD_COIN_FAIL, str, null, ext1, null, null, null, 233, null);
            }
        }
    }

    public static final void n(String str, String type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, type) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (str != null) {
                b(null, ClogBuilder.LogType.REWARD_TOKEN_FAIL, str, null, type, null, null, null, 233, null);
            }
        }
    }

    public static final void p(String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65551, null, str, z) == null) && str != null) {
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            b(null, logType, str, "close", str2, null, null, null, 225, null);
        }
    }

    public static /* synthetic */ void m(String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        l(str, str2, str3);
    }

    public static final void o(ur0 model, String area, ClogBuilder.LogType logType, String ext1, String ext2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65550, null, model, area, logType, ext1, ext2) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            Intrinsics.checkNotNullParameter(area, "area");
            Intrinsics.checkNotNullParameter(logType, "logType");
            Intrinsics.checkNotNullParameter(ext1, "ext1");
            Intrinsics.checkNotNullParameter(ext2, "ext2");
            String ext = model.f.d;
            Intrinsics.checkNotNullExpressionValue(ext, "ext");
            b(null, logType, ext, area, ext1, ext2, null, null, 193, null);
            if (logType == ClogBuilder.LogType.CLICK) {
                hj0.b(model.e);
            }
        }
    }
}
