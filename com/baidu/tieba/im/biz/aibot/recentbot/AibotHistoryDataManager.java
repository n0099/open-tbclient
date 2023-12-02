package com.baidu.tieba.im.biz.aibot.recentbot;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.cs8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet;
import com.baidu.tieba.rd;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0003#$%B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u001c\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u0010\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u0005R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006&"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/recentbot/AibotHistoryDataManager;", "", "()V", "AllBotChatList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/baidu/tieba/im/biz/aibot/recentbot/AibotHistoryDataManager$BotChatListByFid;", "getAllBotChatList", "()Ljava/util/concurrent/ConcurrentHashMap;", "setAllBotChatList", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "findHistoryBot", "", "uk", "set", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/SizedSyncTreeSet;", "Lcom/baidu/tieba/im/biz/aibot/recentbot/AibotHistoryDataManager$BotChatData;", "findHistoryBotAndReplace", "getAllDataByJson", "getBotListByFid", "Ljava/util/ArrayList;", "fid", "getBotSetByFid", "getLastBotDataByFid", "getLastBotUkByFid", "getLastPaidByFid", "getMapByJson", "jsonString", "getRecentBotDataListByFid", "updateDataByFid", "", "paid", TaskUIData.keyBgUrl, "updateLocalDataByBD", "bdData", "BotChatData", "BotChatListByFid", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotHistoryDataManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, BotChatListByFid> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1715991353, "Lcom/baidu/tieba/im/biz/aibot/recentbot/AibotHistoryDataManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1715991353, "Lcom/baidu/tieba/im/biz/aibot/recentbot/AibotHistoryDataManager;");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/recentbot/AibotHistoryDataManager$BotChatData;", "Ljava/io/Serializable;", "()V", TaskUIData.keyBgUrl, "", "getBgUrl", "()Ljava/lang/String;", "setBgUrl", "(Ljava/lang/String;)V", "paid", "getPaid", "setPaid", "timestamp", "", "getTimestamp", "()J", "setTimestamp", "(J)V", "uk", "getUk", "setUk", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class BotChatData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bgUrl;
        public String paid;
        public long timestamp;
        public String uk;

        public BotChatData() {
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

        public final String getBgUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.bgUrl;
            }
            return (String) invokeV.objValue;
        }

        public final String getPaid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.paid;
            }
            return (String) invokeV.objValue;
        }

        public final long getTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.timestamp;
            }
            return invokeV.longValue;
        }

        public final String getUk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.uk;
            }
            return (String) invokeV.objValue;
        }

        public final void setBgUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.bgUrl = str;
            }
        }

        public final void setPaid(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.paid = str;
            }
        }

        public final void setTimestamp(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
                this.timestamp = j;
            }
        }

        public final void setUk(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.uk = str;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/recentbot/AibotHistoryDataManager$BotChatListByFid;", "Ljava/io/Serializable;", "()V", "botChatList", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/SizedSyncTreeSet;", "Lcom/baidu/tieba/im/biz/aibot/recentbot/AibotHistoryDataManager$BotChatData;", "getBotChatList", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/SizedSyncTreeSet;", "setBotChatList", "(Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/SizedSyncTreeSet;)V", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class BotChatListByFid implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SizedSyncTreeSet<BotChatData> botChatList;

        public BotChatListByFid() {
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
            this.botChatList = new SizedSyncTreeSet<>(10, new TreeSet(cs8.d.a().c()));
        }

        public final SizedSyncTreeSet<BotChatData> getBotChatList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.botChatList;
            }
            return (SizedSyncTreeSet) invokeV.objValue;
        }

        public final void setBotChatList(SizedSyncTreeSet<BotChatData> sizedSyncTreeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sizedSyncTreeSet) == null) {
                Intrinsics.checkNotNullParameter(sizedSyncTreeSet, "<set-?>");
                this.botChatList = sizedSyncTreeSet;
            }
        }
    }

    public AibotHistoryDataManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return DataExt.toJson(this.a);
        }
        return (String) invokeV.objValue;
    }

    public final boolean a(String uk, SizedSyncTreeSet<BotChatData> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uk, set)) == null) {
            Intrinsics.checkNotNullParameter(uk, "uk");
            Intrinsics.checkNotNullParameter(set, "set");
            Iterator<BotChatData> it = set.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "set.iterator()");
            while (it.hasNext()) {
                if (rd.isEquals(it.next().getUk(), uk)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean b(String uk, SizedSyncTreeSet<BotChatData> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uk, set)) == null) {
            Intrinsics.checkNotNullParameter(uk, "uk");
            Intrinsics.checkNotNullParameter(set, "set");
            Iterator<BotChatData> it = set.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "set.iterator()");
            while (it.hasNext()) {
                if (rd.isEquals(it.next().getUk(), uk)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final SizedSyncTreeSet<BotChatData> d(String fid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fid)) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            BotChatListByFid botChatListByFid = this.a.get(fid);
            if (botChatListByFid != null) {
                return botChatListByFid.getBotChatList();
            }
            return null;
        }
        return (SizedSyncTreeSet) invokeL.objValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.a = f(str);
        }
    }

    public final String e(String fid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fid)) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            BotChatListByFid botChatListByFid = this.a.get(fid);
            if (botChatListByFid != null) {
                BotChatData first = botChatListByFid.getBotChatList().first();
                Intrinsics.checkNotNullExpressionValue(first, "it.botChatList.first()");
                return DataExt.toJson(first);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final ConcurrentHashMap<String, BotChatListByFid> f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
                ConcurrentHashMap<String, BotChatListByFid> concurrentHashMap = new ConcurrentHashMap<>();
                while (keys.hasNext()) {
                    String next = keys.next();
                    BotChatListByFid botChatListByFid = new BotChatListByFid();
                    Object obj = new JSONObject(jSONObject.get(next).toString()).get("botChatList");
                    if (obj != null) {
                        SizedSyncTreeSet<BotChatData> botChatList = botChatListByFid.getBotChatList();
                        String jSONArray = ((JSONArray) obj).toString();
                        Intrinsics.checkNotNullExpressionValue(jSONArray, "list.toString()");
                        botChatList.addAll(DataExt.toEntityList(jSONArray, BotChatData.class));
                        concurrentHashMap.put(next, botChatListByFid);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                    }
                }
                return concurrentHashMap;
            } catch (JSONException e) {
                e.printStackTrace();
                return new ConcurrentHashMap<>();
            }
        }
        return (ConcurrentHashMap) invokeL.objValue;
    }

    public final String g(String fid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fid)) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            BotChatListByFid botChatListByFid = this.a.get(fid);
            if (botChatListByFid != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<BotChatData> it = botChatListByFid.getBotChatList().iterator();
                Intrinsics.checkNotNullExpressionValue(it, "it.botChatList.iterator()");
                while (it.hasNext()) {
                    BotChatData next = it.next();
                    if (!rd.isEmpty(sb.toString())) {
                        sb.append(",");
                    }
                    sb.append(next.getUk());
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "ukString.toString()");
                return sb2;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final void h(String fid, String uk, String paid, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, fid, uk, paid, str) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            Intrinsics.checkNotNullParameter(uk, "uk");
            Intrinsics.checkNotNullParameter(paid, "paid");
            BotChatData botChatData = new BotChatData();
            botChatData.setUk(uk);
            botChatData.setPaid(paid);
            botChatData.setTimestamp(System.currentTimeMillis());
            botChatData.setBgUrl(str);
            BotChatListByFid botChatListByFid = this.a.get(fid);
            if (botChatListByFid != null) {
                b(uk, botChatListByFid.getBotChatList());
                botChatListByFid.getBotChatList().add(botChatData);
                return;
            }
            BotChatListByFid botChatListByFid2 = new BotChatListByFid();
            botChatListByFid2.getBotChatList().add(botChatData);
            this.a.put(fid, botChatListByFid2);
        }
    }
}
