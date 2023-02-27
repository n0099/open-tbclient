package com.baidu.tieba.frs.voiceroom;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\fJE\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u0016JC\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat;", "", "()V", "STAT_KEY_FID", "", "STAT_KEY_FORUM_NAME", "STAT_KEY_ITEM_POS", "STAT_KEY_ROOM_ID", "isValidFid", "", "fid", "", "(Ljava/lang/Long;)Z", "makeStatisticItem", "Lcom/baidu/tbadk/core/util/StatisticItem;", "index", "", "statType", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$StatType;", "itemPos", "roomId", "forumName", "(ILcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$StatType;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/baidu/tbadk/core/util/StatisticItem;", "statRoomListEvent", "", "from", "Lcom/baidu/tbadk/module/frs/Frs$From;", "(Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$StatType;Lcom/baidu/tbadk/module/frs/Frs$From;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "statStartRoomEvent", "(Ljava/lang/Long;Ljava/lang/String;)V", "PageType", "StatType", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VoiceRoomStat {
    public static /* synthetic */ Interceptable $ic;
    public static final VoiceRoomStat a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-201620142, "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-201620142, "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat;");
                return;
            }
        }
        a = new VoiceRoomStat();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bR\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$PageType;", "", "pageArray", "", "", "(Ljava/lang/String;I[Ljava/lang/String;)V", "getPageArray", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getPage", "index", "", "ROOM_LIST_EVENT", "START_ROOM_EVENT", "Companion", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class PageType {
        public static final /* synthetic */ PageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final a Companion;
        public static final PageType ROOM_LIST_EVENT;
        public static final PageType START_ROOM_EVENT;
        public static final String STAT_KEY = "obj_param1";
        public transient /* synthetic */ FieldHolder $fh;
        public final String[] pageArray;

        public static final /* synthetic */ PageType[] $values() {
            return new PageType[]{ROOM_LIST_EVENT, START_ROOM_EVENT};
        }

        public static PageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (PageType) Enum.valueOf(PageType.class, str) : (PageType) invokeL.objValue;
        }

        public static PageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (PageType[]) $VALUES.clone() : (PageType[]) invokeV.objValue;
        }

        /* loaded from: classes4.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public a() {
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
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1990169591, "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$PageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1990169591, "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$PageType;");
                    return;
                }
            }
            ROOM_LIST_EVENT = new PageType("ROOM_LIST_EVENT", 0, new String[]{"into_page_second", "inside_second"});
            START_ROOM_EVENT = new PageType("START_ROOM_EVENT", 1, new String[]{"home_page", "inside_second"});
            $VALUES = $values();
            Companion = new a(null);
        }

        public PageType(String str, int i, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), strArr};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.pageArray = strArr;
        }

        public final String getPage(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return this.pageArray[i];
            }
            return (String) invokeI.objValue;
        }

        public final String[] getPageArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.pageArray;
            }
            return (String[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$StatType;", "", "urlKeyArray", "", "", "(Ljava/lang/String;I[Ljava/lang/String;)V", "[Ljava/lang/String;", "getUrlKey", "index", "", "PAGE_ENTER", "ITEM_EXPOSE", "ITEM_CLICK", "START_VOICE_ROOM", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class StatType {
        public static final /* synthetic */ StatType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final StatType ITEM_CLICK;
        public static final StatType ITEM_EXPOSE;
        public static final StatType PAGE_ENTER;
        public static final StatType START_VOICE_ROOM;
        public transient /* synthetic */ FieldHolder $fh;
        public final String[] urlKeyArray;

        public static final /* synthetic */ StatType[] $values() {
            return new StatType[]{PAGE_ENTER, ITEM_EXPOSE, ITEM_CLICK, START_VOICE_ROOM};
        }

        public static StatType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (StatType) Enum.valueOf(StatType.class, str) : (StatType) invokeL.objValue;
        }

        public static StatType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (StatType[]) $VALUES.clone() : (StatType[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-984186030, "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$StatType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-984186030, "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$StatType;");
                    return;
                }
            }
            PAGE_ENTER = new StatType("PAGE_ENTER", 0, new String[]{TbadkCoreStatisticKey.KEY_VOICE_ROOM_LIST_PAGE_ENTER, TbadkCoreStatisticKey.KEY_FROM_FRS_VOICE_ROOM_LIST_PAGE_ENTER});
            ITEM_EXPOSE = new StatType("ITEM_EXPOSE", 1, new String[]{TbadkCoreStatisticKey.KEY_VOICE_ROOM_LIST_ITEM_EXPOSE, TbadkCoreStatisticKey.KEY_FROM_FRS_VOICE_ROOM_LIST_ITEM_EXPOSE});
            ITEM_CLICK = new StatType("ITEM_CLICK", 2, new String[]{TbadkCoreStatisticKey.KEY_VOICE_ROOM_LIST_ITEM_CLICK, TbadkCoreStatisticKey.KEY_FROM_FRS_VOICE_ROOM_LIST_ITEM_CLICK});
            START_VOICE_ROOM = new StatType("START_VOICE_ROOM", 3, new String[]{TbadkCoreStatisticKey.KEY_START_VOICE_ROOM, TbadkCoreStatisticKey.KEY_FROM_FRS_START_VOICE_ROOM});
            $VALUES = $values();
        }

        public StatType(String str, int i, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), strArr};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.urlKeyArray = strArr;
        }

        public final String getUrlKey(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return this.urlKeyArray[i];
            }
            return (String) invokeI.objValue;
        }
    }

    public VoiceRoomStat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final boolean a(Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l)) == null) {
            if (l != null && l.longValue() != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final StatisticItem b(int i, StatType statType, Integer num, Long l, Long l2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), statType, num, l, l2, str})) == null) {
            StatisticItem statisticItem = new StatisticItem(statType.getUrlKey(i));
            if (num != null) {
                statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, num.intValue());
            }
            if (l != null) {
                statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, l.longValue());
            }
            if (a(l2)) {
                Intrinsics.checkNotNull(l2);
                statisticItem.addParam("fid", l2.longValue());
            }
            if (str != null) {
                statisticItem.addParam("fname", str);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public final void c(StatType statType, Frs$From from, Integer num, Long l, Long l2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{statType, from, num, l, l2, str}) == null) {
            Intrinsics.checkNotNullParameter(statType, "statType");
            Intrinsics.checkNotNullParameter(from, "from");
            int ordinal = from.ordinal();
            StatisticItem b = b(ordinal, statType, num, l, l2, str);
            b.addParam("obj_param1", PageType.ROOM_LIST_EVENT.getPage(ordinal));
            TiebaStatic.log(b);
        }
    }
}
