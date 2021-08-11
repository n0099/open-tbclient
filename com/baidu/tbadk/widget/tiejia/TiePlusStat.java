package com.baidu.tbadk.widget.tiejia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.b1.b0;
import c.a.o0.b1.z;
import c.a.o0.d.a;
import c.a.o0.s.q.c2;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public final class TiePlusStat {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final b0<Integer> f48719a;

    /* renamed from: b  reason: collision with root package name */
    public static final b0<Integer> f48720b;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class CardBtnType {
        public static final /* synthetic */ CardBtnType[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final CardBtnType DOWNLOAD;
        public static final CardBtnType H5;
        public static final String STAT_KEY = "a_type";
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String desc;
        public int statValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1269735248, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$CardBtnType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1269735248, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$CardBtnType;");
                    return;
                }
            }
            DOWNLOAD = new CardBtnType("DOWNLOAD", 0, 1, "下载");
            CardBtnType cardBtnType = new CardBtnType("H5", 1, 2, "查看");
            H5 = cardBtnType;
            $VALUES = new CardBtnType[]{DOWNLOAD, cardBtnType};
        }

        public CardBtnType(String str, @NonNull int i2, int i3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.statValue = i3;
            this.desc = str2;
        }

        public static CardBtnType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (CardBtnType) Enum.valueOf(CardBtnType.class, str) : (CardBtnType) invokeL.objValue;
        }

        public static CardBtnType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (CardBtnType[]) $VALUES.clone() : (CardBtnType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class LandingType {
        public static final /* synthetic */ LandingType[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final LandingType DIALOG_DOWNLOAD;
        public static final LandingType H5;
        public static final String STAT_KEY = "l_type";
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String desc;
        public int statValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1237201221, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$LandingType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1237201221, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$LandingType;");
                    return;
                }
            }
            H5 = new LandingType("H5", 0, 1, "H5");
            LandingType landingType = new LandingType("DIALOG_DOWNLOAD", 1, 2, "下载弹窗");
            DIALOG_DOWNLOAD = landingType;
            $VALUES = new LandingType[]{H5, landingType};
        }

        public LandingType(String str, @NonNull int i2, int i3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.statValue = i3;
            this.desc = str2;
        }

        @NonNull
        public static LandingType create(int i2) {
            InterceptResult invokeI;
            LandingType landingType;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                if (i2 != 30) {
                    if (i2 == 31 || i2 == 33) {
                        landingType = DIALOG_DOWNLOAD;
                    } else if (i2 != 50) {
                        landingType = null;
                    }
                    z.a(landingType);
                    return landingType;
                }
                landingType = H5;
                z.a(landingType);
                return landingType;
            }
            return (LandingType) invokeI.objValue;
        }

        public static LandingType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (LandingType) Enum.valueOf(LandingType.class, str) : (LandingType) invokeL.objValue;
        }

        public static LandingType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (LandingType[]) $VALUES.clone() : (LandingType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class Locate {
        public static final /* synthetic */ Locate[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final Locate FRS;
        public static final Locate HOME;
        public static final Locate PB;
        public static final Locate PB_COMMENT;
        public static final String STAT_KEY = "obj_locate";
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String desc;
        public int statValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(975810926, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$Locate;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(975810926, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$Locate;");
                    return;
                }
            }
            HOME = new Locate("HOME", 0, 1, "首页");
            FRS = new Locate("FRS", 1, 2, "FRS页");
            PB = new Locate("PB", 2, 3, "PB页");
            Locate locate = new Locate("PB_COMMENT", 3, 4, "PB评论页");
            PB_COMMENT = locate;
            $VALUES = new Locate[]{HOME, FRS, PB, locate};
        }

        public Locate(String str, @NonNull int i2, int i3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.statValue = i3;
            this.desc = str2;
        }

        public static Locate valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Locate) Enum.valueOf(Locate.class, str) : (Locate) invokeL.objValue;
        }

        public static Locate[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Locate[]) $VALUES.clone() : (Locate[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class RichTextType {
        public static final /* synthetic */ RichTextType[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final RichTextType CARD;
        public static final RichTextType LINK;
        public static final String STAT_KEY = "c_type";
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String desc;
        public int statValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(357667869, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$RichTextType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(357667869, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$RichTextType;");
                    return;
                }
            }
            LINK = new RichTextType("LINK", 0, 1, "短链");
            RichTextType richTextType = new RichTextType("CARD", 1, 2, "卡片");
            CARD = richTextType;
            $VALUES = new RichTextType[]{LINK, richTextType};
        }

        public RichTextType(String str, @NonNull int i2, int i3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.statValue = i3;
            this.desc = str2;
        }

        public static RichTextType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (RichTextType) Enum.valueOf(RichTextType.class, str) : (RichTextType) invokeL.objValue;
        }

        public static RichTextType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (RichTextType[]) $VALUES.clone() : (RichTextType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class StatType {
        public static final /* synthetic */ StatType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final StatType CLICK;
        public static final StatType DIALOG_CLICK;
        public static final StatType DIALOG_EXPOSE;
        public static final StatType EXPOSE;
        public transient /* synthetic */ FieldHolder $fh;
        public int billingTypeValue;
        @NonNull
        public String desc;
        @NonNull
        public String urlKey;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(548310866, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$StatType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(548310866, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$StatType;");
                    return;
                }
            }
            EXPOSE = new StatType("EXPOSE", 0, CommonStatisticKey.KEY_TIE_PLUS_RICH_TEXT_EXPOSE, a.f12745h, "曝光");
            CLICK = new StatType("CLICK", 1, CommonStatisticKey.KEY_TIE_PLUS_RICH_TEXT_CLICK, a.f12746i, "点击");
            DIALOG_EXPOSE = new StatType("DIALOG_EXPOSE", 2, CommonStatisticKey.KEY_TIE_PLUS_DIALOG_EXPOSE, -1, "弹窗曝光");
            StatType statType = new StatType("DIALOG_CLICK", 3, CommonStatisticKey.kEY_TIE_PLUS_DIAGLO_CLICK, -1, "弹窗下载点击");
            DIALOG_CLICK = statType;
            $VALUES = new StatType[]{EXPOSE, CLICK, DIALOG_EXPOSE, statType};
        }

        public StatType(@NonNull String str, int i2, @NonNull String str2, int i3, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str4 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.urlKey = str2;
            this.billingTypeValue = i3;
            this.desc = str3;
        }

        public static StatType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (StatType) Enum.valueOf(StatType.class, str) : (StatType) invokeL.objValue;
        }

        public static StatType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (StatType[]) $VALUES.clone() : (StatType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class ThreadType {
        public static final /* synthetic */ ThreadType[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final ThreadType IMAGE_TEXT;
        public static final String STAT_KEY = "obj_type";
        public static final ThreadType VIDEO_NORMAL;
        public static final ThreadType VIDEO_WORK;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public String desc;
        public int statValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(493861916, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$ThreadType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(493861916, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat$ThreadType;");
                    return;
                }
            }
            IMAGE_TEXT = new ThreadType("IMAGE_TEXT", 0, 1, "图文");
            VIDEO_NORMAL = new ThreadType("VIDEO_NORMAL", 1, 2, "普通视频");
            ThreadType threadType = new ThreadType("VIDEO_WORK", 2, 3, "作品视频");
            VIDEO_WORK = threadType;
            $VALUES = new ThreadType[]{IMAGE_TEXT, VIDEO_NORMAL, threadType};
        }

        public ThreadType(String str, @NonNull int i2, int i3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.statValue = i3;
            this.desc = str2;
        }

        public static ThreadType create(@NonNull c2 c2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c2Var)) == null) {
                if (c2Var.B2()) {
                    return VIDEO_WORK;
                }
                if (c2Var.A2()) {
                    return VIDEO_NORMAL;
                }
                return IMAGE_TEXT;
            }
            return (ThreadType) invokeL.objValue;
        }

        public static ThreadType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (ThreadType) Enum.valueOf(ThreadType.class, str) : (ThreadType) invokeL.objValue;
        }

        public static ThreadType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (ThreadType[]) $VALUES.clone() : (ThreadType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-819594926, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-819594926, "Lcom/baidu/tbadk/widget/tiejia/TiePlusStat;");
                return;
            }
        }
        f48719a = new b0<>(3000, TimeUnit.MILLISECONDS);
        f48720b = new b0<>(3000, TimeUnit.MILLISECONDS);
    }

    public static int a(@NonNull TiebaPlusInfo tiebaPlusInfo, @Nullable Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tiebaPlusInfo, obj)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(tiebaPlusInfo.title);
            sb.append(tiebaPlusInfo.desc);
            sb.append(tiebaPlusInfo.jump_url);
            sb.append(tiebaPlusInfo.download_url);
            sb.append(tiebaPlusInfo.app_id);
            sb.append(tiebaPlusInfo.app_icon);
            sb.append(tiebaPlusInfo.app_package);
            sb.append(tiebaPlusInfo.app_version);
            sb.append(tiebaPlusInfo.app_privacy);
            sb.append(tiebaPlusInfo.app_power);
            sb.append(tiebaPlusInfo.app_company);
            sb.append(tiebaPlusInfo.target_type);
            sb.append(tiebaPlusInfo.h5_jump_type);
            if (obj != null) {
                sb.append(obj.hashCode());
            }
            return sb.toString().hashCode();
        }
        return invokeLL.intValue;
    }

    public static void b(int i2, @NonNull StatType statType, @NonNull Locate locate, @NonNull ThreadType threadType, @NonNull RichTextType richTextType, int i3, @NonNull LandingType landingType, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @Nullable CardBtnType cardBtnType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), statType, locate, threadType, richTextType, Integer.valueOf(i3), landingType, str, str2, str3, str4, cardBtnType}) == null) {
            if (statType != StatType.EXPOSE || f48719a.a(Integer.valueOf(i2))) {
                StatisticItem addParam = new StatisticItem(statType.urlKey).addParam("obj_locate", locate.statValue).addParam("obj_type", threadType.statValue).addParam(RichTextType.STAT_KEY, richTextType.statValue).addParam("t_obj", i3).addParam(LandingType.STAT_KEY, landingType.statValue).addParam("tid", str).addParam(TiebaStatic.Params.FID_1, str2).addParam(TiebaStatic.Params.FID_2, str3).addParam("order_id", str4);
                if (cardBtnType != null) {
                    addParam.addParam(CardBtnType.STAT_KEY, cardBtnType.statValue);
                }
                TiebaStatic.log(addParam);
            }
        }
    }

    public static void c(int i2, @NonNull StatType statType, @NonNull Locate locate, @NonNull String str, @NonNull String str2, @NonNull String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), statType, locate, str, str2, str3, Integer.valueOf(i3)}) == null) {
            if (statType != StatType.EXPOSE || f48720b.a(Integer.valueOf(i2))) {
                a.a(statType.billingTypeValue, locate.statValue, str, str2, str3, i3);
            }
        }
    }

    public static void d(@NonNull StatType statType, @NonNull Locate locate, @NonNull ThreadType threadType, @NonNull RichTextType richTextType, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{statType, locate, threadType, richTextType, str, str2, str3, str4}) == null) {
            TiebaStatic.log(new StatisticItem(statType.urlKey).addParam("obj_locate", locate.statValue).addParam("obj_type", threadType.statValue).addParam(RichTextType.STAT_KEY, richTextType.statValue).addParam("tid", str).addParam(TiebaStatic.Params.FID_1, str2).addParam(TiebaStatic.Params.FID_2, str3).addParam("order_id", str4));
        }
    }
}
