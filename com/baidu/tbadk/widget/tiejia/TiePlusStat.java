package com.baidu.tbadk.widget.tiejia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d.a;
import c.a.q0.d1.c0;
import c.a.q0.d1.e0;
import c.a.q0.s.q.d2;
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
/* loaded from: classes9.dex */
public final class TiePlusStat {
    public static /* synthetic */ Interceptable $ic;
    public static final e0<Integer> a;

    /* renamed from: b  reason: collision with root package name */
    public static final e0<Integer> f42405b;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class CardBtnType {
        public static final /* synthetic */ CardBtnType[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final CardBtnType DOWNLOAD;
        public static final CardBtnType H5;
        public static final String STAT_KEY = "a_type";
        public transient /* synthetic */ FieldHolder $fh;
        public final int statValue;

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
            DOWNLOAD = new CardBtnType("DOWNLOAD", 0, 1);
            CardBtnType cardBtnType = new CardBtnType("H5", 1, 2);
            H5 = cardBtnType;
            $VALUES = new CardBtnType[]{DOWNLOAD, cardBtnType};
        }

        public CardBtnType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.statValue = i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0012, code lost:
            if (r5 != 4) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static CardBtnType create(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
                if (i2 == 36) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            return DOWNLOAD;
                        }
                        if (i3 != 3) {
                        }
                    }
                    return H5;
                }
                return null;
            }
            return (CardBtnType) invokeII.objValue;
        }

        public static CardBtnType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (CardBtnType) Enum.valueOf(CardBtnType.class, str) : (CardBtnType) invokeL.objValue;
        }

        public static CardBtnType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (CardBtnType[]) $VALUES.clone() : (CardBtnType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class LandingType {
        public static final /* synthetic */ LandingType[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final LandingType APPOINT;
        public static final LandingType DIALOG_DOWNLOAD;
        public static final LandingType H5;
        public static final LandingType MESSAGE;
        public static final String STAT_KEY = "l_type";
        public static final LandingType WECHAT;
        public static final LandingType WECHAT_MINIAPP;
        public transient /* synthetic */ FieldHolder $fh;
        public final int statValue;

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
            H5 = new LandingType("H5", 0, 1);
            DIALOG_DOWNLOAD = new LandingType("DIALOG_DOWNLOAD", 1, 2);
            WECHAT = new LandingType("WECHAT", 2, 3);
            WECHAT_MINIAPP = new LandingType("WECHAT_MINIAPP", 3, 4);
            MESSAGE = new LandingType("MESSAGE", 4, 5);
            LandingType landingType = new LandingType("APPOINT", 5, 6);
            APPOINT = landingType;
            $VALUES = new LandingType[]{H5, DIALOG_DOWNLOAD, WECHAT, WECHAT_MINIAPP, MESSAGE, landingType};
        }

        public LandingType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.statValue = i3;
        }

        @NonNull
        public static LandingType create(int i2) {
            InterceptResult invokeI;
            LandingType landingType;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                switch (i2) {
                    case 1:
                        landingType = H5;
                        break;
                    case 2:
                        landingType = DIALOG_DOWNLOAD;
                        break;
                    case 3:
                        landingType = WECHAT;
                        break;
                    case 4:
                        landingType = WECHAT_MINIAPP;
                        break;
                    case 5:
                        landingType = MESSAGE;
                        break;
                    case 6:
                        landingType = APPOINT;
                        break;
                    default:
                        landingType = null;
                        break;
                }
                c0.b(landingType);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (LandingType[]) $VALUES.clone() : (LandingType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Locate {
        public static final /* synthetic */ Locate[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final Locate FRS;
        public static final Locate HOME;
        public static final Locate PB;
        public static final Locate PB_COMMENT;
        public static final String STAT_KEY = "obj_locate";
        public static final Locate VIDEO_COMMENT_TOP;
        public static final Locate VIDEO_MIDDLE_COMMENT;
        public static final Locate VIDEO_MOUNT;
        public transient /* synthetic */ FieldHolder $fh;
        public final int statValue;

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
            HOME = new Locate("HOME", 0, 1);
            FRS = new Locate("FRS", 1, 2);
            PB = new Locate("PB", 2, 3);
            PB_COMMENT = new Locate("PB_COMMENT", 3, 4);
            VIDEO_MIDDLE_COMMENT = new Locate("VIDEO_MIDDLE_COMMENT", 4, 5);
            VIDEO_MOUNT = new Locate("VIDEO_MOUNT", 5, 6);
            Locate locate = new Locate("VIDEO_COMMENT_TOP", 6, 7);
            VIDEO_COMMENT_TOP = locate;
            $VALUES = new Locate[]{HOME, FRS, PB, PB_COMMENT, VIDEO_MIDDLE_COMMENT, VIDEO_MOUNT, locate};
        }

        public Locate(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.statValue = i3;
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
    /* loaded from: classes9.dex */
    public static final class RichTextType {
        public static final /* synthetic */ RichTextType[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final RichTextType CARD;
        public static final RichTextType LINK;
        public static final RichTextType MESSAGE;
        public static final String STAT_KEY = "c_type";
        public transient /* synthetic */ FieldHolder $fh;
        public final int statValue;

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
            LINK = new RichTextType("LINK", 0, 1);
            CARD = new RichTextType("CARD", 1, 2);
            RichTextType richTextType = new RichTextType("MESSAGE", 2, 3);
            MESSAGE = richTextType;
            $VALUES = new RichTextType[]{LINK, CARD, richTextType};
        }

        public RichTextType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.statValue = i3;
        }

        public static RichTextType create(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                if (i2 != 35) {
                    if (i2 != 36) {
                        return null;
                    }
                    return CARD;
                }
                return LINK;
            }
            return (RichTextType) invokeI.objValue;
        }

        public static RichTextType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (RichTextType) Enum.valueOf(RichTextType.class, str) : (RichTextType) invokeL.objValue;
        }

        public static RichTextType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (RichTextType[]) $VALUES.clone() : (RichTextType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class StatType {
        public static final /* synthetic */ StatType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final StatType CLICK;
        public static final StatType DIALOG_CLICK;
        public static final StatType DIALOG_EXPOSE;
        public static final StatType DOWNLOAD_FINISHED;
        public static final StatType EXPOSE;
        public transient /* synthetic */ FieldHolder $fh;
        public final int billingTypeValue;
        public final String urlKey;

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
            EXPOSE = new StatType("EXPOSE", 0, CommonStatisticKey.KEY_TIE_PLUS_RICH_TEXT_EXPOSE, a.f11805h);
            CLICK = new StatType("CLICK", 1, CommonStatisticKey.KEY_TIE_PLUS_RICH_TEXT_CLICK, a.f11806i);
            DIALOG_EXPOSE = new StatType("DIALOG_EXPOSE", 2, CommonStatisticKey.KEY_TIE_PLUS_DIALOG_EXPOSE, -1);
            DIALOG_CLICK = new StatType("DIALOG_CLICK", 3, CommonStatisticKey.kEY_TIE_PLUS_DIAGLO_CLICK, -1);
            StatType statType = new StatType("DOWNLOAD_FINISHED", 4, CommonStatisticKey.KEY_TIE_PLUS_DOWNLOAD_FINISHED, -1);
            DOWNLOAD_FINISHED = statType;
            $VALUES = new StatType[]{EXPOSE, CLICK, DIALOG_EXPOSE, DIALOG_CLICK, statType};
        }

        public StatType(@NonNull String str, int i2, String str2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, Integer.valueOf(i3)};
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
            this.urlKey = str2;
            this.billingTypeValue = i3;
        }

        public static StatType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (StatType) Enum.valueOf(StatType.class, str) : (StatType) invokeL.objValue;
        }

        public static StatType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (StatType[]) $VALUES.clone() : (StatType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class ThreadType {
        public static final /* synthetic */ ThreadType[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final ThreadType IMAGE_TEXT;
        public static final String STAT_KEY = "obj_type";
        public static final ThreadType VIDEO_NORMAL;
        public static final ThreadType VIDEO_WORK;
        public transient /* synthetic */ FieldHolder $fh;
        public final int statValue;

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
            IMAGE_TEXT = new ThreadType("IMAGE_TEXT", 0, 1);
            VIDEO_NORMAL = new ThreadType("VIDEO_NORMAL", 1, 2);
            ThreadType threadType = new ThreadType("VIDEO_WORK", 2, 3);
            VIDEO_WORK = threadType;
            $VALUES = new ThreadType[]{IMAGE_TEXT, VIDEO_NORMAL, threadType};
        }

        public ThreadType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.statValue = i3;
        }

        public static ThreadType create(@NonNull d2 d2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, d2Var)) == null) {
                if (d2Var.I2()) {
                    return VIDEO_WORK;
                }
                if (d2Var.H2()) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (ThreadType[]) $VALUES.clone() : (ThreadType[]) invokeV.objValue;
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
        a = new e0<>(3000, TimeUnit.MILLISECONDS);
        f42405b = new e0<>(3000, TimeUnit.MILLISECONDS);
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
            sb.append(tiebaPlusInfo.jump_type);
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
            if (statType != StatType.EXPOSE || a.a(Integer.valueOf(i2))) {
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
            if (statType != StatType.EXPOSE || f42405b.a(Integer.valueOf(i2))) {
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

    public static void e(@NonNull StatType statType, @NonNull RichTextType richTextType, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, statType, richTextType, str, str2) == null) {
            TiebaStatic.log(new StatisticItem(statType.urlKey).addParam(RichTextType.STAT_KEY, richTextType.statValue).addParam("tid", str).addParam("order_id", str2));
        }
    }
}
