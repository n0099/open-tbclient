package com.baidu.tieba.frs.voiceroom;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u0000:\u0002\u001f B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005JG\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010JE\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u00132\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019¨\u0006!"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat;", "", "fid", "", "isValidFid", "(Ljava/lang/Long;)Z", "", "index", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$StatType;", "statType", "itemPos", ILiveNPSPlugin.PARAMS_ROOM_ID, "", "forumName", "Lcom/baidu/tbadk/core/util/StatisticItem;", "makeStatisticItem", "(ILcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$StatType;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/baidu/tbadk/core/util/StatisticItem;", "Lcom/baidu/tbadk/module/frs/Frs$From;", "from", "", "statRoomListEvent", "(Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$StatType;Lcom/baidu/tbadk/module/frs/Frs$From;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "statStartRoomEvent", "(Ljava/lang/Long;Ljava/lang/String;)V", "STAT_KEY_FID", "Ljava/lang/String;", "STAT_KEY_FORUM_NAME", "STAT_KEY_ITEM_POS", "STAT_KEY_ROOM_ID", "<init>", "()V", "PageType", "StatType", "frs_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class VoiceRoomStat {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final VoiceRoomStat f50093a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\b\u0082\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\b\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$PageType;", "Ljava/lang/Enum;", "", "index", "", "getPage", "(I)Ljava/lang/String;", "", "pageArray", "[Ljava/lang/String;", "getPageArray", "()[Ljava/lang/String;", "<init>", "(Ljava/lang/String;I[Ljava/lang/String;)V", "Companion", "ROOM_LIST_EVENT", "START_ROOM_EVENT", "frs_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class PageType {
        public static final /* synthetic */ PageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic = null;
        public static final a Companion;
        public static final PageType ROOM_LIST_EVENT;
        public static final PageType START_ROOM_EVENT;
        public static final String STAT_KEY = "obj_param1";
        public transient /* synthetic */ FieldHolder $fh;
        public final String[] pageArray;

        /* loaded from: classes9.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
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
            PageType pageType = new PageType("ROOM_LIST_EVENT", 0, new String[]{"into_page_second", "inside_second"});
            ROOM_LIST_EVENT = pageType;
            PageType pageType2 = new PageType("START_ROOM_EVENT", 1, new String[]{"home_page", "inside_second"});
            START_ROOM_EVENT = pageType2;
            $VALUES = new PageType[]{pageType, pageType2};
            Companion = new a(null);
        }

        public PageType(String str, int i2, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), strArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.pageArray = strArr;
        }

        public static PageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PageType) Enum.valueOf(PageType.class, str) : (PageType) invokeL.objValue;
        }

        public static PageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PageType[]) $VALUES.clone() : (PageType[]) invokeV.objValue;
        }

        public final String getPage(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.pageArray[i2] : (String) invokeI.objValue;
        }

        public final String[] getPageArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.pageArray : (String[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\b\u0086\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomStat$StatType;", "Ljava/lang/Enum;", "", "index", "", "getUrlKey", "(I)Ljava/lang/String;", "", "urlKeyArray", "[Ljava/lang/String;", "<init>", "(Ljava/lang/String;I[Ljava/lang/String;)V", "PAGE_ENTER", "ITEM_EXPOSE", "ITEM_CLICK", "START_VOICE_ROOM", "frs_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class StatType {
        public static final /* synthetic */ StatType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final StatType ITEM_CLICK;
        public static final StatType ITEM_EXPOSE;
        public static final StatType PAGE_ENTER;
        public static final StatType START_VOICE_ROOM;
        public transient /* synthetic */ FieldHolder $fh;
        public final String[] urlKeyArray;

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
            StatType statType = new StatType("PAGE_ENTER", 0, new String[]{TbadkCoreStatisticKey.KEY_VOICE_ROOM_LIST_PAGE_ENTER, TbadkCoreStatisticKey.KEY_FROM_FRS_VOICE_ROOM_LIST_PAGE_ENTER});
            PAGE_ENTER = statType;
            StatType statType2 = new StatType("ITEM_EXPOSE", 1, new String[]{TbadkCoreStatisticKey.KEY_VOICE_ROOM_LIST_ITEM_EXPOSE, TbadkCoreStatisticKey.KEY_FROM_FRS_VOICE_ROOM_LIST_ITEM_EXPOSE});
            ITEM_EXPOSE = statType2;
            StatType statType3 = new StatType("ITEM_CLICK", 2, new String[]{TbadkCoreStatisticKey.KEY_VOICE_ROOM_LIST_ITEM_CLICK, TbadkCoreStatisticKey.KEY_FROM_FRS_VOICE_ROOM_LIST_ITEM_CLICK});
            ITEM_CLICK = statType3;
            StatType statType4 = new StatType("START_VOICE_ROOM", 3, new String[]{TbadkCoreStatisticKey.KEY_START_VOICE_ROOM, TbadkCoreStatisticKey.KEY_FROM_FRS_START_VOICE_ROOM});
            START_VOICE_ROOM = statType4;
            $VALUES = new StatType[]{statType, statType2, statType3, statType4};
        }

        public StatType(String str, int i2, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), strArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.urlKeyArray = strArr;
        }

        public static StatType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (StatType) Enum.valueOf(StatType.class, str) : (StatType) invokeL.objValue;
        }

        public static StatType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (StatType[]) $VALUES.clone() : (StatType[]) invokeV.objValue;
        }

        public final String getUrlKey(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.urlKeyArray[i2] : (String) invokeI.objValue;
        }
    }

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
        f50093a = new VoiceRoomStat();
    }

    public VoiceRoomStat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final void d(Long l, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, l, str) == null) {
            boolean a2 = f50093a.a(l);
            StatisticItem b2 = f50093a.b(a2 ? 1 : 0, StatType.START_VOICE_ROOM, null, null, l, str);
            b2.addParam("obj_param1", PageType.START_ROOM_EVENT.getPage(a2 ? 1 : 0));
            TiebaStatic.log(b2);
        }
    }

    public final boolean a(Long l) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l)) == null) ? (l == null || l.longValue() == 0) ? false : true : invokeL.booleanValue;
    }

    public final StatisticItem b(int i2, StatType statType, Integer num, Long l, Long l2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), statType, num, l, l2, str})) == null) {
            StatisticItem statisticItem = new StatisticItem(statType.getUrlKey(i2));
            if (num != null) {
                statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, num.intValue());
            }
            if (l != null) {
                statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, l.longValue());
            }
            if (a(l2)) {
                if (l2 == null) {
                    Intrinsics.throwNpe();
                }
                statisticItem.addParam("fid", l2.longValue());
            }
            if (str != null) {
                statisticItem.addParam("fname", str);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public final void c(StatType statType, Frs$From frs$From, Integer num, Long l, Long l2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{statType, frs$From, num, l, l2, str}) == null) {
            int ordinal = frs$From.ordinal();
            StatisticItem b2 = b(ordinal, statType, num, l, l2, str);
            b2.addParam("obj_param1", PageType.ROOM_LIST_EVENT.getPage(ordinal));
            TiebaStatic.log(b2);
        }
    }
}
