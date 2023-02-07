package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.UnSupportedMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.Action;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cr7 implements gg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<Class<? extends BaseMsg>> a;
    @NonNull
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<BaseMsg>> b;
    @NonNull
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<BaseMsg>> c;
    @NonNull
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<BaseMsg>> d;
    @Nullable
    public h e;
    @Nullable
    public j f;

    /* loaded from: classes4.dex */
    public interface h {
        @MainThread
        void a(long j, @NonNull List<BaseMsg> list, @NonNull i iVar);
    }

    /* loaded from: classes4.dex */
    public interface j<T extends BaseSysMsg> {
        @MainThread
        void a(@NonNull T t);

        @MainThread
        void b(@NonNull ChatMsg chatMsg);
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ TreeSet b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ cr7 f;

        public a(cr7 cr7Var, long j, TreeSet treeSet, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr7Var, Long.valueOf(j), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = cr7Var;
            this.a = j;
            this.b = treeSet;
            this.c = z;
            this.d = z2;
            this.e = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.f.g(this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ List b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ cr7 f;

        public b(cr7 cr7Var, long j, List list, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr7Var, Long.valueOf(j), list, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = cr7Var;
            this.a = j;
            this.b = list;
            this.c = z;
            this.d = z2;
            this.e = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f.e != null) {
                this.f.e.a(this.a, this.b, i.a(this.c, this.d, this.e));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements SizedSyncTreeSet.a<BaseMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ cr7 b;

        public c(cr7 cr7Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr7Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cr7Var;
            this.a = j;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet.a
        public void a(boolean z, Collection<BaseMsg> collection) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZL(1048576, this, z, collection) != null) || z) {
                return;
            }
            SizedSyncTreeSet r = this.b.r(this.a);
            if (r.isEmpty()) {
                r.addAll(collection);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseSysMsg a;
        public final /* synthetic */ cr7 b;

        public d(cr7 cr7Var, BaseSysMsg baseSysMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr7Var, baseSysMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cr7Var;
            this.a = baseSysMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.f != null) {
                this.b.f.a(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMsg a;
        public final /* synthetic */ cr7 b;

        public e(cr7 cr7Var, ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr7Var, chatMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cr7Var;
            this.a = chatMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.f != null) {
                this.b.f.b(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ List b;
        public final /* synthetic */ i c;
        public final /* synthetic */ cr7 d;

        public f(cr7 cr7Var, long j, List list, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr7Var, Long.valueOf(j), list, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = cr7Var;
            this.a = j;
            this.b = list;
            this.c = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.d.e != null) {
                this.d.e.a(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class g {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-881004418, "Lcom/baidu/tieba/cr7$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-881004418, "Lcom/baidu/tieba/cr7$g;");
                    return;
                }
            }
            int[] iArr = new int[Action.Op.values().length];
            a = iArr;
            try {
                iArr[Action.Op.DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Action.Op.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final boolean b;
        public final boolean c;

        public i(boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = z2;
            this.c = z3;
        }

        @NonNull
        public static i a(boolean z, boolean z2, boolean z3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
                return new i(z, z2, z3);
            }
            return (i) invokeCommon.objValue;
        }
    }

    public cr7() {
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
        this.a = new SparseArray<>();
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        new ConcurrentHashMap();
    }

    public static void K(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, chatMsg) == null) {
            long millis = TimeUnit.MICROSECONDS.toMillis(chatMsg.getMsgId());
            if (millis == 0) {
                millis = System.currentTimeMillis();
            }
            chatMsg.setMsgTime(millis);
        }
    }

    public static TreeSet<ChatMsg> M(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMsg)) == null) {
            TreeSet<ChatMsg> treeSet = new TreeSet<>(bg5.b);
            treeSet.add(chatMsg);
            return treeSet;
        }
        return (TreeSet) invokeL.objValue;
    }

    public final void B(@NonNull ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMsg) == null) {
            kh.c(new e(this, chatMsg));
        }
    }

    public final void C(@NonNull BaseSysMsg baseSysMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseSysMsg) == null) {
            kh.c(new d(this, baseSysMsg));
        }
    }

    public void H(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            I(j2, true);
        }
    }

    public void J(@Nullable h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
            this.e = hVar;
        }
    }

    public void L(@Nullable j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jVar) == null) {
            this.f = jVar;
        }
    }

    public void j(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            SizedSyncTreeSet<BaseMsg> r = r(j2);
            if (!r.isEmpty()) {
                return;
            }
            SizedSyncTreeSet<BaseMsg> n = n(j2);
            r.addAll(n);
            n.clear();
        }
    }

    @Nullable
    public BaseMsg p(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048598, this, j2)) == null) {
            SizedSyncTreeSet<BaseMsg> n = n(j2);
            if (n.isEmpty()) {
                return null;
            }
            return n.first();
        }
        return (BaseMsg) invokeJ.objValue;
    }

    public boolean v(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048604, this, j2)) == null) {
            return !r(j2).isEmpty();
        }
        return invokeJ.booleanValue;
    }

    public void A(long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j2, treeSet) == null) {
            h(j2, treeSet, true, false, false);
        }
    }

    public void F(int i2, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, cls) == null) {
            this.a.put(i2, cls);
        }
    }

    public void G(List<Integer> list, Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, cls) == null) {
            for (Integer num : list) {
                this.a.put(num.intValue(), cls);
            }
        }
    }

    @NonNull
    public ChatMsg k(long j2, @NonNull String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048595, this, j2, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("managerTips", str);
            return f(j2, -7014, l(), m(), hashMap);
        }
        return (ChatMsg) invokeJL.objValue;
    }

    public int t(@NonNull TreeSet<ChatMsg> treeSet, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, treeSet, str)) == null) {
            Iterator<ChatMsg> it = treeSet.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getMsgKey(), str)) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public void y(long j2, @NonNull i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048607, this, j2, iVar) == null) {
            kh.c(new f(this, j2, new ArrayList(n(j2)), iVar));
        }
    }

    public static long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        }
        return invokeV.longValue;
    }

    @NonNull
    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return String.valueOf(l());
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public final BaseMsg D(long j2, @NonNull ChatMsg chatMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j2, chatMsg)) == null) {
            CommonMsgField commonMsgField = (CommonMsgField) DataExt.toEntity(chatMsg.getChatRoomContentExt(), CommonMsgField.class);
            commonMsgField.setMsgId(chatMsg.getMsgId());
            commonMsgField.setMsgKey(chatMsg.getMsgKey());
            commonMsgField.setRoomId(j2);
            commonMsgField.setUserId(Long.parseLong(chatMsg.getSenderUid()));
            commonMsgField.setUserName(chatMsg.getNickName());
            commonMsgField.setPortrait(chatMsg.getPortrait());
            if (commonMsgField.getContent() == null) {
                commonMsgField.setContent(new HashMap());
            }
            BaseChatMsg baseChatMsg = (BaseChatMsg) DataExt.toEntity(commonMsgField.getContent(), this.a.get(commonMsgField.getType()));
            baseChatMsg.parseSdkMsg4Base(chatMsg);
            baseChatMsg.fromSdkMsg(chatMsg);
            baseChatMsg.setCommonMsgField(commonMsgField);
            baseChatMsg.setSdkMsg(chatMsg);
            return baseChatMsg;
        }
        return (BaseMsg) invokeJL.objValue;
    }

    public final boolean N(long j2, @NonNull BaseMsg baseMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048587, this, j2, baseMsg)) == null) {
            Action provideAction = baseMsg.provideAction();
            boolean z = false;
            if (provideAction == null) {
                return false;
            }
            Action.a b2 = provideAction.b();
            Action.Op c2 = provideAction.c();
            String e2 = provideAction.e();
            BaseMsg baseMsg2 = null;
            int i2 = g.a[c2.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    BaseMsg o = o(u(j2), e2);
                    if (o == null) {
                        o = o(r(j2), e2);
                    }
                    baseMsg2 = o;
                    if (baseMsg2 == null) {
                        baseMsg2 = o(n(j2), e2);
                        z = true;
                    }
                } else {
                    throw new IllegalStateException("Unexpected value: " + c2);
                }
            } else {
                BaseMsg createShadowMsg = BaseMsg.createShadowMsg(provideAction.d(), e2);
                boolean remove = u(j2).remove(createShadowMsg);
                if (!remove) {
                    remove = r(j2).remove(createShadowMsg);
                }
                if (!remove) {
                    z = n(j2).remove(createShadowMsg);
                }
            }
            if (b2 != null) {
                b2.a(c2, baseMsg2);
            }
            return z;
        }
        return invokeJL.booleanValue;
    }

    @NonNull
    public final BaseSysMsg E(@NonNull ChatMsg chatMsg) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, chatMsg)) == null) {
            JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
            int optInt = jSONObject.optInt(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
            BaseSysMsg baseSysMsg = (BaseSysMsg) DataExt.toEntity(jSONObject.optString("service_info"), this.a.get(optInt));
            baseSysMsg.parseSdkMsg4Base(chatMsg);
            baseSysMsg.setSdkMsg(chatMsg);
            baseSysMsg.setSysMsg(!baseSysMsg.isConvertToNormalMsg());
            CommonMsgField commonMsgField = new CommonMsgField();
            commonMsgField.setMsgId(chatMsg.getMsgId());
            commonMsgField.setMsgKey(chatMsg.getMsgKey());
            commonMsgField.setType(optInt);
            commonMsgField.setRoomId(baseSysMsg.getRoomId());
            BaseSysMsg.User userFrom = baseSysMsg.getUserFrom();
            if (userFrom != null) {
                commonMsgField.setUserId(userFrom.getUserId());
                commonMsgField.setUserName(userFrom.getUsername());
                commonMsgField.setPortrait(userFrom.getPortrait());
                commonMsgField.setRole(userFrom.getRole());
                commonMsgField.setLevel(userFrom.getLevel());
            }
            baseSysMsg.setCommonMsgField(commonMsgField);
            return baseSysMsg;
        }
        return (BaseSysMsg) invokeL.objValue;
    }

    public void I(long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            SizedSyncTreeSet<BaseMsg> r = r(j2);
            if (!r.isEmpty()) {
                SizedSyncTreeSet<BaseMsg> n = n(j2);
                if (z) {
                    n.clear();
                }
                n.addAll(r, true);
                r.clear();
            }
        }
    }

    @Nullable
    public final BaseMsg o(@NonNull SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, sizedSyncTreeSet, str)) == null) {
            Iterator<BaseMsg> descendingIterator = sizedSyncTreeSet.descendingIterator();
            while (descendingIterator.hasNext()) {
                BaseMsg next = descendingIterator.next();
                if (TextUtils.equals(next.getCommonMsgField().getMsgKey(), str)) {
                    BaseMsg shallowClone = next.shallowClone();
                    if (shallowClone != null) {
                        descendingIterator.remove();
                        sizedSyncTreeSet.add(shallowClone);
                    }
                    return shallowClone;
                }
            }
            return null;
        }
        return (BaseMsg) invokeLL.objValue;
    }

    public int s(long j2, @NonNull String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048601, this, j2, str)) == null) {
            Iterator<BaseMsg> it = n(j2).iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getCommonMsgField().getMsgKey(), str)) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeJL.intValue;
    }

    public boolean x(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            BaseMsg p = p(j2);
            if (p == null || p.getCommonMsgField().getMsgId() > j3) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Nullable
    public final ChatMsg O(long j2, @NonNull ChatMsg chatMsg, @NonNull SortedSet<BaseMsg> sortedSet) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j2), chatMsg, sortedSet})) == null) {
            if (chatMsg.getMsgType() == 10000) {
                return null;
            }
            if (sortedSet.isEmpty()) {
                K(chatMsg);
            } else {
                K(chatMsg);
                ChatMsg sdkMsg = sortedSet.last().getSdkMsg();
                K(sdkMsg);
                long msgTime = chatMsg.getMsgTime() - sdkMsg.getMsgTime();
                String msgKey = chatMsg.getMsgKey();
                String msgKey2 = sortedSet.first().getCommonMsgField().getMsgKey();
                if (msgTime <= TimeUnit.MINUTES.toMillis(3L) && (msgTime >= 0 || !TextUtils.equals(msgKey, msgKey2))) {
                    chatMsg = null;
                }
            }
            if (chatMsg == null) {
                return null;
            }
            long msgTime2 = chatMsg.getMsgTime();
            long msgId = chatMsg.getMsgId();
            HashMap hashMap = new HashMap();
            hashMap.put("timestamp", Long.valueOf(msgTime2));
            return f(j2, -7013, msgId - 1, String.valueOf(msgTime2), hashMap);
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.gg5
    public void a(int i2, long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), treeSet}) == null) {
            h(j2, treeSet, false, false, true);
        }
    }

    public void z(int i2, long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), treeSet}) == null) {
            h(j2, treeSet, false, true, false);
        }
    }

    @NonNull
    public final ChatMsg f(long j2, int i2, long j3, @NonNull String str, @NonNull Map<String, Object> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, map})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, Integer.valueOf(i2));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("msg_type", Integer.valueOf(i2));
            hashMap2.put("chatroom_id", Long.valueOf(j2));
            hashMap2.putAll(map);
            hashMap.put("service_info", hashMap2);
            UnSupportedMsg unSupportedMsg = new UnSupportedMsg();
            unSupportedMsg.setMsgContent(DataExt.toJson(hashMap));
            unSupportedMsg.setMsgId(j3);
            unSupportedMsg.setMsgKey(str);
            unSupportedMsg.setNotifyCmd(109);
            return unSupportedMsg;
        }
        return (ChatMsg) invokeCommon.objValue;
    }

    @WorkerThread
    public final void g(long j2, @NonNull TreeSet<ChatMsg> treeSet, boolean z, boolean z2, boolean z3) {
        SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet;
        BaseMsg i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j2), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            SizedSyncTreeSet<BaseMsg> n = n(j2);
            SizedSyncTreeSet<BaseMsg> u = u(j2);
            SizedSyncTreeSet<BaseMsg> r = r(j2);
            u.clear();
            i a2 = i.a(z, z2, z3);
            Iterator<ChatMsg> it = treeSet.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                if (next != null) {
                    try {
                        BaseMsg i3 = i(j2, next, a2);
                        if (i3 != null) {
                            if (u.isEmpty()) {
                                sizedSyncTreeSet = n;
                            } else {
                                sizedSyncTreeSet = u;
                            }
                            ChatMsg O = O(j2, next, sizedSyncTreeSet);
                            if (O != null && (i2 = i(j2, O, a2)) != null) {
                                u.add(i2);
                            }
                            u.add(i3);
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                }
            }
            if (!u.isEmpty()) {
                if (!r.isEmpty() && z3) {
                    r.addAll(u);
                    return;
                }
                n.addAll(u);
                kh.c(new b(this, j2, new ArrayList(n), z, z2, z3));
            }
        }
    }

    public final void h(long j2, @NonNull TreeSet<ChatMsg> treeSet, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            kh.d(new a(this, j2, treeSet, z, z2, z3));
        }
    }

    @Nullable
    public final BaseMsg i(long j2, @NonNull ChatMsg chatMsg, @NonNull i iVar) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j2), chatMsg, iVar})) == null) {
            if (chatMsg.getMsgType() == 10000) {
                if (chatMsg.getNotifyCmd() == 109) {
                    BaseSysMsg E = E(chatMsg);
                    if (E.isNoUISysMsg()) {
                        if (!iVar.b) {
                            C(E);
                            if (N(j2, E)) {
                                y(j2, iVar);
                            }
                        }
                        return null;
                    }
                    N(j2, E);
                    return E;
                }
                if (!iVar.b) {
                    B(chatMsg);
                }
                return null;
            }
            BaseMsg D = D(j2, chatMsg);
            N(j2, D);
            return D;
        }
        return (BaseMsg) invokeCommon.objValue;
    }

    @NonNull
    public final SizedSyncTreeSet<BaseMsg> n(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j2)) == null) {
            SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet = this.b.get(Long.valueOf(j2));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(600, new TreeSet(BaseMsg.CHAT_MSG_COMPARATOR));
                sizedSyncTreeSet2.setCallback(new c(this, j2));
                this.b.put(Long.valueOf(j2), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    @NonNull
    public final SizedSyncTreeSet<BaseMsg> r(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048600, this, j2)) == null) {
            SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet = this.d.get(Long.valueOf(j2));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(200, new TreeSet(BaseMsg.CHAT_MSG_COMPARATOR));
                this.d.put(Long.valueOf(j2), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    @NonNull
    public final SizedSyncTreeSet<BaseMsg> u(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048603, this, j2)) == null) {
            SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet = this.c.get(Long.valueOf(j2));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<BaseMsg> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(new TreeSet(BaseMsg.CHAT_MSG_COMPARATOR));
                this.c.put(Long.valueOf(j2), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    @Nullable
    public BaseMsg q(long j2) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048599, this, j2)) == null) {
            Iterator<BaseMsg> descendingIterator = n(j2).descendingIterator();
            while (descendingIterator.hasNext()) {
                BaseMsg next = descendingIterator.next();
                if (!(next instanceof BaseSysMsg)) {
                    return next;
                }
                BaseSysMsg baseSysMsg = (BaseSysMsg) next;
                int type = baseSysMsg.getCommonMsgField().getType();
                if (baseSysMsg.getMsgConf() != null && baseSysMsg.getMsgConf().isVisible()) {
                    z = true;
                } else {
                    z = false;
                }
                if (-7013 != type && -7014 != type && z) {
                    return next;
                }
            }
            return null;
        }
        return (BaseMsg) invokeJ.objValue;
    }

    public boolean w(long j2, @NonNull TreeSet<ChatMsg> treeSet) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048605, this, j2, treeSet)) == null) {
            ChatMsg last = treeSet.last();
            BaseMsg createShadowMsg = BaseMsg.createShadowMsg(last.getMsgId(), last.getMsgKey());
            SizedSyncTreeSet<BaseMsg> r = r(j2);
            Iterator<ChatMsg> descendingIterator = treeSet.descendingIterator();
            while (descendingIterator.hasNext()) {
                ChatMsg next = descendingIterator.next();
                CommonMsgField commonMsgField = createShadowMsg.getCommonMsgField();
                commonMsgField.setMsgId(next.getMsgId());
                commonMsgField.setMsgKey(next.getMsgKey());
                if (r.contains(createShadowMsg)) {
                    return true;
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
