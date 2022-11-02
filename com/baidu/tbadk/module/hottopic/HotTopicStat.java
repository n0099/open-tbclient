package com.baidu.tbadk.module.hottopic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes3.dex */
public final class HotTopicStat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class Locate {
        public static final /* synthetic */ Locate[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final Locate HOT_RANK;
        public static final String STAT_KEY = "obj_locate";
        public static final Locate THREAD_CARD;
        public static final Locate TOPIC_RANK;
        public static final Locate UNDEFINED;
        public static final Locate VIDEO_MIDDLE;
        public static final Locate VIDEO_MIDDLE_COMMENT;
        public transient /* synthetic */ FieldHolder $fh;
        public final String desc;
        public final int statValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1393939560, "Lcom/baidu/tbadk/module/hottopic/HotTopicStat$Locate;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1393939560, "Lcom/baidu/tbadk/module/hottopic/HotTopicStat$Locate;");
                    return;
                }
            }
            UNDEFINED = new Locate("UNDEFINED", 0, -1, "未定义");
            HOT_RANK = new Locate("HOT_RANK", 1, 1, "热榜页");
            TOPIC_RANK = new Locate("TOPIC_RANK", 2, 2, "话题榜");
            VIDEO_MIDDLE = new Locate("VIDEO_MIDDLE", 3, 3, "视频沉浸态");
            THREAD_CARD = new Locate("THREAD_CARD", 4, 4, "帖子卡片");
            Locate locate = new Locate("VIDEO_MIDDLE_COMMENT", 5, 5, "评论浮层");
            VIDEO_MIDDLE_COMMENT = locate;
            $VALUES = new Locate[]{UNDEFINED, HOT_RANK, TOPIC_RANK, VIDEO_MIDDLE, THREAD_CARD, locate};
        }

        public Locate(String str, @NonNull int i, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.statValue = i2;
            this.desc = str2;
        }

        public static Locate valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (Locate) Enum.valueOf(Locate.class, str);
            }
            return (Locate) invokeL.objValue;
        }

        @NonNull
        public static Locate valueOfIgnoreCase(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
                try {
                    return valueOf(str.toUpperCase());
                } catch (IllegalArgumentException unused) {
                    return UNDEFINED;
                }
            }
            return (Locate) invokeL.objValue;
        }

        public static Locate[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                return (Locate[]) $VALUES.clone();
            }
            return (Locate[]) invokeV.objValue;
        }

        public int getStatValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.statValue;
            }
            return invokeV.intValue;
        }
    }

    public static void a(@NonNull String str, @NonNull String str2, @NonNull Locate locate, @Nullable String str3, @Nullable String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65536, null, str, str2, locate, str3, str4) == null) {
            StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_CLICK_VIDEO_TOPIC).addParam("uid", TbadkCoreApplication.getCurrentAccountId()).addParam("topic_id", str).addParam("topic_id", str2).addParam("obj_locate", locate.statValue);
            if (str3 != null) {
                addParam.addParam("fid", str3);
            }
            if (str4 != null) {
                addParam.addParam("post_id", str4);
            }
            TiebaStatic.log(addParam);
        }
    }
}
