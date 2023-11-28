package com.baidu.tieba.im.base.core.repo;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tieba.im.base.core.repo.MsgProcessor;
import com.baidu.tieba.im.base.core.repo.SizedSyncTreeSet;
import com.baidu.tieba.im.base.core.uilist.Action;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTimestampSysMsg;
import com.baidu.tieba.lv8;
import com.baidu.tieba.np8;
import com.baidu.tieba.pq8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 N2\u00020\u0001:\u0006NOPQRSB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J*\u0010\u001c\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0003J*\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0005J\u001a\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J0\u0010#\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00072\u0014\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u00062\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u0005J\u0018\u0010(\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010)\u001a\u00020\u0005J\u0018\u0010*\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u0005J\u001a\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0016\u0010,\u001a\u00020-2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005J4\u0010/\u001a\u0018\u0012\u0004\u0012\u000201\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0018\u0001002\u0006\u00102\u001a\u00020-2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&J\u001c\u00103\u001a\u0002012\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00172\u0006\u0010%\u001a\u00020&J\u001a\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00062\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u000e\u00107\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0005J\u001c\u00108\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017J\u0016\u00109\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u0002012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016J*\u0010<\u001a\u00020\u00152\u0006\u0010;\u001a\u0002012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u001a\u0010=\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020@H\u0002J*\u0010A\u001a\u00020\u00152\"\u0010B\u001a\u001e\u0012\u0004\u0012\u00020C\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u000b00J\u001a\u0010D\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010E\u001a\u00020\u0010H\u0007J\u0010\u0010F\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010G\u001a\u00020\u00152\u0010\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020@\u0018\u00010\u0012J(\u0010H\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00052\u000e\u0010I\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010J\u001a\u0004\u0018\u00010@2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030\u00072\u0010\u0010L\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070MH\u0002R(\u0010\u0003\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/baidu/tieba/im/base/core/repo/MsgProcessor;", "Lcom/baidu/tieba/im/lib/socket/listener/MsgReceiveListener;", "()V", "chatMsgSetMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/baidu/tieba/im/base/core/repo/SizedSyncTreeSet;", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "classMap", "Landroid/util/SparseArray;", "Ljava/lang/Class;", "latestTmpSetMap", "msgCallback", "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$MsgCallback;", "setTailStatusMap", "", "sysMsgCallback", "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$SysMsgCallback;", "tmpSetMap", "doParse", "", "msgSet", "Ljava/util/TreeSet;", "source", "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$Source;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$ParsedCallback;", "doParseOnBgThread", "doParseOneMsg", "sessionId", "tbMsg", "faultChatMsgSet", "forceClearMasterSet", "getChatMsgSet", "getClonedBaseMsgByMsgKey", "set", "msgKey", "", "getFarthestMsg", "getFarthestTmpMsg", "roomId", "getLatestMsg", "getLatestTmpSet", "getMsgPosAtWhichMemory", "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$MemoryFlag;", "msgId", "getPairByMsgKey", "Lkotlin/Pair;", "", "flag", "getPositionByMsgKeyWithTargetSet", "targetSet", "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsg;", "getTmpSet", "isChatMsgSetFaulted", "isLatestTmpSetContains", "manualUpdateData", "onReceiveMessage", StatConstants.KEY_EXT_ERR_CODE, "onReceiveMessageByHttp", "onReceiveMessageByLocal", "onSysMsgArrive", "tbSysMsg", "Lcom/baidu/tieba/im/lib/socket/msg/TbSysMsg;", "putParseClass", "pair", "", "resumeFaultChatMsgSet", "clearBefore", "setMsgCallback", "setSysMsgCallback", "tryExecMsgAction", "baseItem", "tryGenerateTimestampSysMsg", "arriveItem", "currentSet", "Ljava/util/SortedSet;", "Companion", "MemoryFlag", "MsgCallback", "ParsedCallback", "Source", "SysMsgCallback", "im-base-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgProcessor implements lv8 {
    public static /* synthetic */ Interceptable $ic;
    public static final a g;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<Class<? extends BaseItem<? extends TbBaseMsg>>> a;
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<BaseItem<? extends TbBaseMsg>>> b;
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<BaseItem<? extends TbBaseMsg>>> c;
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<BaseItem<? extends TbBaseMsg>>> d;
    public b e;
    public e<?> f;

    /* loaded from: classes6.dex */
    public interface b {
        @MainThread
        void a(long j, List<? extends BaseItem<? extends TbBaseMsg>> list, d dVar);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(BaseItem<? extends TbBaseMsg> baseItem);
    }

    /* loaded from: classes6.dex */
    public interface e<T extends TbSysMsg> {
        @MainThread
        void a(T t);
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class f {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1323010106, "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1323010106, "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$f;");
                    return;
                }
            }
            int[] iArr = new int[Action.Op.values().length];
            iArr[Action.Op.DELETE.ordinal()] = 1;
            iArr[Action.Op.UPDATE.ordinal()] = 2;
            iArr[Action.Op.EXEC.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MemoryFlag.values().length];
            iArr2[MemoryFlag.MASTER.ordinal()] = 1;
            iArr2[MemoryFlag.TMP.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1717575932, "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1717575932, "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor;");
                return;
            }
        }
        g = new a(null);
    }

    @JvmOverloads
    public final void B(TbBaseMsg tbMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbMsg) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            D(this, tbMsg, null, 2, null);
        }
    }

    @JvmOverloads
    public final void H(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            J(this, j, false, 2, null);
        }
    }

    @JvmOverloads
    public final void y(int i, TreeSet<TbBaseMsg> msgSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048605, this, i, msgSet) == null) {
            Intrinsics.checkNotNullParameter(msgSet, "msgSet");
            A(this, i, msgSet, null, 4, null);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final a g;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public Runnable d;
        public boolean e;
        public int f;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1323010044, "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1323010044, "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$d;");
                    return;
                }
            }
            g = new a(null);
        }

        public /* synthetic */ d(boolean z, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, z2, z3);
        }

        @JvmStatic
        @JvmOverloads
        public static final d a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? g.b() : (d) invokeV.objValue;
        }

        @JvmStatic
        @JvmOverloads
        public static final d b(boolean z, int i) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) ? g.c(z, i) : (d) invokeCommon.objValue;
        }

        /* loaded from: classes6.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @JvmOverloads
            public final d b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d(this, false, 0, 3, null) : (d) invokeV.objValue;
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

            public static /* synthetic */ d d(a aVar, boolean z, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    z = true;
                }
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                return aVar.c(z, i);
            }

            @JvmStatic
            public final d a(boolean z, boolean z2, boolean z3) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
                    return new d(z, z2, z3, null);
                }
                return (d) invokeCommon.objValue;
            }

            @JvmStatic
            @JvmOverloads
            public final d c(boolean z, int i) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
                    d a = a(true, false, false);
                    a.j(z);
                    a.i(i);
                    return a;
                }
                return (d) invokeCommon.objValue;
            }
        }

        public d(boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = z2;
            this.c = z3;
            this.e = true;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.f;
            }
            return invokeV.intValue;
        }

        public final Runnable d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.d;
            }
            return (Runnable) invokeV.objValue;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b;
            }
            return invokeV.booleanValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.c;
            }
            return invokeV.booleanValue;
        }

        public final boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.e;
            }
            return invokeV.booleanValue;
        }

        public final void i(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.f = i;
            }
        }

        public final void j(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.e = z;
            }
        }

        public final void k(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, runnable) == null) {
                this.d = runnable;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$MemoryFlag;", "", "(Ljava/lang/String;I)V", "isAfterMaster", "", "()Z", "isBeforeMaster", "isMaster", "isTmp", "MASTER", "BEFORE_MASTER", "AFTER_MASTER", "TMP", "im-base-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class MemoryFlag {
        public static final /* synthetic */ MemoryFlag[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MemoryFlag AFTER_MASTER;
        public static final MemoryFlag BEFORE_MASTER;
        public static final MemoryFlag MASTER;
        public static final MemoryFlag TMP;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ MemoryFlag[] $values() {
            return new MemoryFlag[]{MASTER, BEFORE_MASTER, AFTER_MASTER, TMP};
        }

        public static MemoryFlag valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (MemoryFlag) Enum.valueOf(MemoryFlag.class, str) : (MemoryFlag) invokeL.objValue;
        }

        public static MemoryFlag[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (MemoryFlag[]) $VALUES.clone() : (MemoryFlag[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1429491799, "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$MemoryFlag;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1429491799, "Lcom/baidu/tieba/im/base/core/repo/MsgProcessor$MemoryFlag;");
                    return;
                }
            }
            MASTER = new MemoryFlag("MASTER", 0);
            BEFORE_MASTER = new MemoryFlag("BEFORE_MASTER", 1);
            AFTER_MASTER = new MemoryFlag("AFTER_MASTER", 2);
            TMP = new MemoryFlag("TMP", 3);
            $VALUES = $values();
        }

        public MemoryFlag(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }

        public final boolean isAfterMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this == AFTER_MASTER) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final boolean isBeforeMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this == BEFORE_MASTER) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final boolean isMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this == MASTER) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final boolean isTmp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this == TMP) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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

        public final TreeSet<TbBaseMsg> b(TbBaseMsg tbBaseMsg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tbBaseMsg)) == null) {
                TreeSet<TbBaseMsg> treeSet = new TreeSet<>(TbBaseMsg.COMPARATOR);
                treeSet.add(tbBaseMsg);
                return treeSet;
            }
            return (TreeSet) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements SizedSyncTreeSet.a<BaseItem<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgProcessor a;
        public final /* synthetic */ long b;

        public g(MsgProcessor msgProcessor, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgProcessor, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgProcessor;
            this.b = j;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.util.Collection<? extends com.baidu.tieba.im.base.core.uilist.BaseItem<?>>] */
        @Override // com.baidu.tieba.im.base.core.repo.SizedSyncTreeSet.a
        public void a(boolean z, Collection<BaseItem<?>> removed) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, removed) == null) {
                Intrinsics.checkNotNullParameter(removed, "removed");
                if (z) {
                    return;
                }
                SizedSyncTreeSet p = this.a.p(this.b);
                if (p.isEmpty()) {
                    p.addAll(removed);
                }
            }
        }
    }

    public MsgProcessor() {
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
        this.a = new SparseArray<>();
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        new ConcurrentHashMap();
    }

    public static /* synthetic */ void A(MsgProcessor msgProcessor, int i, TreeSet treeSet, c cVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            cVar = null;
        }
        msgProcessor.z(i, treeSet, cVar);
    }

    public static /* synthetic */ void d(MsgProcessor msgProcessor, TreeSet treeSet, d dVar, c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            cVar = null;
        }
        msgProcessor.c(treeSet, dVar, cVar);
    }

    public static /* synthetic */ void D(MsgProcessor msgProcessor, TbBaseMsg tbBaseMsg, d dVar, int i, Object obj) {
        if ((i & 2) != 0) {
            dVar = d.a.d(d.g, false, 0, 3, null);
        }
        msgProcessor.C(tbBaseMsg, dVar);
    }

    public static /* synthetic */ void J(MsgProcessor msgProcessor, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        msgProcessor.I(j, z);
    }

    public static final void F(MsgProcessor this$0, TbSysMsg tbSysMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, tbSysMsg) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(tbSysMsg, "$tbSysMsg");
            try {
                np8.a(this$0.f, tbSysMsg);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    @JvmOverloads
    public final void C(TbBaseMsg tbMsg, d source) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbMsg, source) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            Intrinsics.checkNotNullParameter(source, "source");
            d(this, g.b(tbMsg), source, null, 4, null);
        }
    }

    @Override // com.baidu.tieba.lv8
    public void a(int i, TreeSet<TbBaseMsg> msgSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, msgSet) == null) {
            Intrinsics.checkNotNullParameter(msgSet, "msgSet");
            d(this, msgSet, d.g.a(false, false, true), null, 4, null);
        }
    }

    public final void w(final long j, final d source) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048604, this, j, source) == null) {
            Intrinsics.checkNotNullParameter(source, "source");
            final ArrayList arrayList = new ArrayList(k(j));
            UiUtils.post(new Runnable() { // from class: com.baidu.tieba.lp8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MsgProcessor.x(MsgProcessor.this, j, arrayList, source);
                    }
                }
            });
        }
    }

    public static final void e(MsgProcessor this$0, TreeSet msgSet, d source, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, this$0, msgSet, source, cVar) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(msgSet, "$msgSet");
            Intrinsics.checkNotNullParameter(source, "$source");
            this$0.f(msgSet, source, cVar);
        }
    }

    public static final void g(MsgProcessor this$0, long j, List list, d source) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{this$0, Long.valueOf(j), list, source}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(list, "$list");
            Intrinsics.checkNotNullParameter(source, "$source");
            b bVar = this$0.e;
            if (bVar != null) {
                bVar.a(j, list, source);
            }
        }
    }

    public static final void x(MsgProcessor this$0, long j, List list, d source) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{this$0, Long.valueOf(j), list, source}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(list, "$list");
            Intrinsics.checkNotNullParameter(source, "$source");
            b bVar = this$0.e;
            if (bVar != null) {
                bVar.a(j, list, source);
            }
        }
    }

    public final void E(final TbSysMsg tbSysMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbSysMsg) == null) {
            UiUtils.post(new Runnable() { // from class: com.baidu.tieba.kp8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        MsgProcessor.F(MsgProcessor.this, tbSysMsg);
                    }
                }
            });
        }
    }

    public final void K(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public final void L(e<? extends TbSysMsg> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.f = eVar;
        }
    }

    public final void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            SizedSyncTreeSet<BaseItem<?>> p = p(j);
            if (!p.isEmpty()) {
                return;
            }
            SizedSyncTreeSet<BaseItem<?>> k = k(j);
            p.addAll(k);
            k.clear();
        }
    }

    public final void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            k(j).clear();
        }
    }

    /* JADX DEBUG: Type inference failed for r5v3. Raw type applied. Possible types: com.baidu.tieba.im.base.core.uilist.BaseItem<?>, com.baidu.tieba.im.base.core.uilist.BaseItem<? extends com.baidu.tieba.im.lib.socket.msg.TbBaseMsg> */
    public final BaseItem<? extends TbBaseMsg> m(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048594, this, j)) == null) {
            SizedSyncTreeSet<BaseItem<?>> k = k(j);
            if (k.isEmpty()) {
                return null;
            }
            return k.first();
        }
        return (BaseItem) invokeJ.objValue;
    }

    /* JADX DEBUG: Type inference failed for r5v3. Raw type applied. Possible types: com.baidu.tieba.im.base.core.uilist.BaseItem<?>, com.baidu.tieba.im.base.core.uilist.BaseItem<? extends com.baidu.tieba.im.lib.socket.msg.TbBaseMsg> */
    public final BaseItem<? extends TbBaseMsg> n(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j)) == null) {
            SizedSyncTreeSet<BaseItem<?>> p = p(j);
            if (p.isEmpty()) {
                return null;
            }
            return p.first();
        }
        return (BaseItem) invokeJ.objValue;
    }

    public final boolean u(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048602, this, j)) == null) {
            return !p(j).isEmpty();
        }
        return invokeJ.booleanValue;
    }

    public final void G(Pair<? extends Object, ? extends Class<? extends BaseItem<? extends TbBaseMsg>>> pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pair) == null) {
            Intrinsics.checkNotNullParameter(pair, "pair");
            Object first = pair.getFirst();
            Class<? extends BaseItem<? extends TbBaseMsg>> second = pair.getSecond();
            if (first instanceof Integer) {
                this.a.put(((Number) first).intValue(), pair.getSecond());
            } else if (first instanceof List) {
                for (Object obj : (List) first) {
                    SparseArray<Class<? extends BaseItem<? extends TbBaseMsg>>> sparseArray = this.a;
                    if (obj != null) {
                        sparseArray.put(((Integer) obj).intValue(), second);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
            }
        }
    }

    public final BaseItem<? extends TbBaseMsg> o(long j) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j)) == null) {
            Iterator<BaseItem<?>> descendingIterator = k(j).descendingIterator();
            Intrinsics.checkNotNullExpressionValue(descendingIterator, "getChatMsgSet(sessionId).descendingIterator()");
            while (descendingIterator.hasNext()) {
                BaseItem next = descendingIterator.next();
                TbBaseMsg tbMsg = next.getTbMsg();
                if (!tbMsg.isSysMsg()) {
                    return next;
                }
                TbSysMsg tbSysMsg = (TbSysMsg) tbMsg;
                int type = tbSysMsg.getType();
                TbSysMsg.MsgConf msgConf = tbSysMsg.getMsgConf();
                if (msgConf != null) {
                    z = msgConf.isVisible();
                } else {
                    z = false;
                }
                if (-7013 != type && -7014 != type && -7015 != type && z) {
                    return next;
                }
            }
            return null;
        }
        return (BaseItem) invokeJ.objValue;
    }

    @JvmOverloads
    public final void I(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            SizedSyncTreeSet<BaseItem<?>> p = p(j);
            if (!p.isEmpty()) {
                SizedSyncTreeSet<BaseItem<?>> k = k(j);
                if (z) {
                    k.clear();
                }
                k.addAll(p, true);
                p.clear();
            }
        }
    }

    public final BaseItem<? extends TbBaseMsg> l(SizedSyncTreeSet<BaseItem<? extends TbBaseMsg>> sizedSyncTreeSet, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, sizedSyncTreeSet, str)) == null) {
            Iterator<BaseItem<? extends TbBaseMsg>> descendingIterator = sizedSyncTreeSet.descendingIterator();
            Intrinsics.checkNotNullExpressionValue(descendingIterator, "set.descendingIterator()");
            while (descendingIterator.hasNext()) {
                BaseItem<? extends TbBaseMsg> next = descendingIterator.next();
                if (TextUtils.equals(next.getTbMsg().getMsgKey(), str)) {
                    BaseItem<? extends TbBaseMsg> m141shallowClone = next.m141shallowClone();
                    if (m141shallowClone != null) {
                        descendingIterator.remove();
                        sizedSyncTreeSet.add(m141shallowClone);
                    }
                    return m141shallowClone;
                }
            }
            return null;
        }
        return (BaseItem) invokeLL.objValue;
    }

    public final int s(TreeSet<ChatMsg> targetSet, String msgKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, targetSet, msgKey)) == null) {
            Intrinsics.checkNotNullParameter(targetSet, "targetSet");
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            Iterator<ChatMsg> it = targetSet.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "targetSet.iterator()");
            int i = 0;
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getMsgKey(), msgKey)) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.baidu.tieba.im.base.core.repo.MsgProcessor */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean M(long j, BaseItem<? extends TbBaseMsg> baseItem, d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), baseItem, dVar})) == null) {
            boolean z = false;
            if (dVar.e()) {
                return false;
            }
            for (Action action : baseItem.provideActionList()) {
                Action.a b2 = action.b();
                Action.Op c2 = action.c();
                Intrinsics.checkNotNullExpressionValue(c2, "action.op");
                String e2 = action.e();
                Intrinsics.checkNotNullExpressionValue(e2, "action.targetMsgKey");
                BaseItem<? extends TbBaseMsg> baseItem2 = null;
                int i = f.$EnumSwitchMapping$0[c2.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3 && TextUtils.equals(e2, baseItem.getTbMsg().getMsgKey())) {
                            baseItem2 = baseItem;
                        }
                    } else {
                        BaseItem<? extends TbBaseMsg> l = l(t(j), e2);
                        if (l == null) {
                            l = l(p(j), e2);
                        }
                        baseItem2 = l;
                        if (baseItem2 == null) {
                            baseItem2 = l(k(j), e2);
                            z = true;
                        }
                    }
                } else {
                    BaseItem<? extends TbBaseMsg> a2 = BaseItem.Companion.a(action.d(), e2);
                    boolean remove = t(j).remove(a2);
                    if (!remove) {
                        remove = p(j).remove(a2);
                    }
                    if (!remove) {
                        z = k(j).remove(a2);
                    }
                }
                Action.f(b2, c2, baseItem2, dVar);
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    @WorkerThread
    public final synchronized void f(TreeSet<TbBaseMsg> treeSet, final d dVar, c cVar) {
        SizedSyncTreeSet<BaseItem<?>> sizedSyncTreeSet;
        BaseItem<? extends TbBaseMsg> h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, treeSet, dVar, cVar) == null) {
            synchronized (this) {
                final long sessionId = treeSet.first().getSessionId();
                SizedSyncTreeSet<BaseItem<?>> k = k(sessionId);
                SizedSyncTreeSet<BaseItem<?>> t = t(sessionId);
                SizedSyncTreeSet<BaseItem<?>> p = p(sessionId);
                t.clear();
                Iterator<TbBaseMsg> it = treeSet.iterator();
                while (it.hasNext()) {
                    TbBaseMsg msg = it.next();
                    try {
                        Intrinsics.checkNotNullExpressionValue(msg, "msg");
                        BaseItem<? extends TbBaseMsg> h2 = h(sessionId, msg, dVar);
                        if (h2 != null) {
                            if (cVar != null) {
                                cVar.a(h2);
                            }
                            if (t.isEmpty()) {
                                sizedSyncTreeSet = k;
                            } else {
                                sizedSyncTreeSet = t;
                            }
                            TbSysMsg N = N(h2, sizedSyncTreeSet);
                            if (N != null && (h = h(sessionId, N, dVar)) != null) {
                                t.add(h);
                                h2.getTbMsg().setPreTimestampMsg(h.getTbMsg());
                            }
                            t.add(h2);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        pq8.g("parse_msg_exception", sessionId, e2);
                    }
                }
                if (!t.isEmpty()) {
                    if (!p.isEmpty() && dVar.g()) {
                        p.addAll(t);
                    } else {
                        k.addAll(t);
                        final ArrayList arrayList = new ArrayList(k);
                        UiUtils.post(new Runnable() { // from class: com.baidu.tieba.ip8
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    MsgProcessor.g(MsgProcessor.this, sessionId, arrayList, dVar);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v7, resolved type: java.lang.Object */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
        if (android.text.TextUtils.equals(r0, r9) != false) goto L6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.tieba.im.lib.socket.msg.TbBaseMsg] */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.baidu.tieba.im.lib.socket.msg.TbBaseMsg] */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.baidu.tieba.im.lib.socket.msg.TbBaseMsg] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TbSysMsg N(BaseItem<?> baseItem, SortedSet<BaseItem<?>> sortedSet) {
        InterceptResult invokeLL;
        TbBaseMsg tbBaseMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, baseItem, sortedSet)) == null) {
            if (sortedSet.isEmpty()) {
                tbBaseMsg = baseItem.getTbMsg();
            } else {
                ?? tbMsg = sortedSet.last().getTbMsg();
                ?? tbMsg2 = baseItem.getTbMsg();
                long msgId = tbMsg2.getMsgId() - tbMsg.getMsgId();
                String msgKey = tbMsg2.getMsgKey();
                String msgKey2 = sortedSet.first().getTbMsg().getMsgKey();
                tbBaseMsg = tbMsg2;
                if (msgId <= TimeUnit.MINUTES.toMicros(3L)) {
                    if (msgId < 0) {
                        tbBaseMsg = tbMsg2;
                    }
                    tbBaseMsg = null;
                }
            }
            if (tbBaseMsg == null) {
                return null;
            }
            return TbTimestampSysMsg.create(tbBaseMsg.getMsgId() - 1);
        }
        return (TbSysMsg) invokeLL.objValue;
    }

    public final MemoryFlag q(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            BaseItem<? extends TbBaseMsg> n = n(j);
            if (n != null && n.getTbMsg().getMsgId() <= j2) {
                return MemoryFlag.TMP;
            }
            BaseItem<? extends TbBaseMsg> o = o(j);
            if (o != null && o.getTbMsg().getMsgId() < j2) {
                return MemoryFlag.AFTER_MASTER;
            }
            BaseItem<? extends TbBaseMsg> m = m(j);
            if (m != null && m.getTbMsg().getMsgId() <= j2) {
                return MemoryFlag.MASTER;
            }
            return MemoryFlag.BEFORE_MASTER;
        }
        return (MemoryFlag) invokeCommon.objValue;
    }

    public final void c(final TreeSet<TbBaseMsg> treeSet, final d dVar, final c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048587, this, treeSet, dVar, cVar) != null) || treeSet.isEmpty()) {
            return;
        }
        UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.jp8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    MsgProcessor.e(MsgProcessor.this, treeSet, dVar, cVar);
                }
            }
        });
    }

    @JvmOverloads
    public final void z(int i, TreeSet<TbBaseMsg> msgSet, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048606, this, i, msgSet, cVar) == null) {
            Intrinsics.checkNotNullParameter(msgSet, "msgSet");
            c(msgSet, d.g.a(false, true, false), cVar);
        }
    }

    public final BaseItem<? extends TbBaseMsg> h(long j, TbBaseMsg tbBaseMsg, d dVar) {
        InterceptResult invokeCommon;
        BaseItem<? extends TbBaseMsg> baseItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), tbBaseMsg, dVar})) == null) {
            boolean z = tbBaseMsg instanceof TbSysMsg;
            if (z && ((TbSysMsg) tbBaseMsg).isIgnore()) {
                return null;
            }
            Class<? extends BaseItem<? extends TbBaseMsg>> cls = this.a.get(tbBaseMsg.getType());
            if (cls != null && (baseItem = cls.newInstance()) != null) {
                baseItem.injectTbMsg(tbBaseMsg);
                if (dVar.f()) {
                    baseItem.setSendStatus(dVar.c());
                }
            } else {
                baseItem = null;
            }
            if (z) {
                TbSysMsg tbSysMsg = (TbSysMsg) tbBaseMsg;
                if (tbSysMsg.isNoUISysMsg()) {
                    if (!dVar.e()) {
                        E(tbSysMsg);
                        if (baseItem != null && M(j, baseItem, dVar)) {
                            w(j, dVar);
                        }
                    }
                    return null;
                }
            }
            if (!dVar.e()) {
                if (baseItem != null) {
                    M(j, baseItem, dVar);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            return baseItem;
        }
        return (BaseItem) invokeCommon.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.tieba.im.lib.socket.msg.TbBaseMsg] */
    public final Pair<Integer, BaseItem<? extends TbBaseMsg>> r(MemoryFlag flag, long j, String msgKey) {
        InterceptResult invokeCommon;
        SizedSyncTreeSet<BaseItem<?>> k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{flag, Long.valueOf(j), msgKey})) == null) {
            Intrinsics.checkNotNullParameter(flag, "flag");
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            int i = f.$EnumSwitchMapping$1[flag.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    k = p(j);
                } else {
                    throw new IllegalStateException("不支持的内存分区参数");
                }
            } else {
                k = k(j);
            }
            Iterator<BaseItem<?>> it = k.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "set.iterator()");
            int i2 = 0;
            while (it.hasNext()) {
                BaseItem<?> next = it.next();
                if (TextUtils.equals(next.getTbMsg().getMsgKey(), msgKey)) {
                    return new Pair<>(Integer.valueOf(i2), next);
                }
                i2++;
            }
            return null;
        }
        return (Pair) invokeCommon.objValue;
    }

    public final SizedSyncTreeSet<BaseItem<?>> k(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
            SizedSyncTreeSet<BaseItem<? extends TbBaseMsg>> sizedSyncTreeSet = this.b.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<BaseItem<? extends TbBaseMsg>> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(600, new TreeSet(BaseItem.Companion.b()));
                sizedSyncTreeSet2.setCallback(new g(this, j));
                this.b.put(Long.valueOf(j), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    public final SizedSyncTreeSet<BaseItem<?>> p(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j)) == null) {
            SizedSyncTreeSet<BaseItem<? extends TbBaseMsg>> sizedSyncTreeSet = this.d.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<BaseItem<? extends TbBaseMsg>> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(200, new TreeSet(BaseItem.Companion.b()));
                this.d.put(Long.valueOf(j), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    public final SizedSyncTreeSet<BaseItem<?>> t(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048601, this, j)) == null) {
            SizedSyncTreeSet<BaseItem<? extends TbBaseMsg>> sizedSyncTreeSet = this.c.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<BaseItem<? extends TbBaseMsg>> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(new TreeSet(BaseItem.Companion.b()));
                this.c.put(Long.valueOf(j), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    public final boolean v(long j, TreeSet<TbBaseMsg> msgSet) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048603, this, j, msgSet)) == null) {
            Intrinsics.checkNotNullParameter(msgSet, "msgSet");
            TbBaseMsg last = msgSet.last();
            BaseItem<? extends TbBaseMsg> a2 = BaseItem.Companion.a(last.getMsgId(), last.getMsgKey());
            SizedSyncTreeSet<BaseItem<?>> p = p(j);
            Iterator<TbBaseMsg> descendingIterator = msgSet.descendingIterator();
            while (descendingIterator.hasNext()) {
                TbBaseMsg next = descendingIterator.next();
                TbBaseMsg tbMsg = a2.getTbMsg();
                tbMsg.setMsgId(next.getMsgId());
                tbMsg.setMsgKey(next.getMsgKey());
                if (p.contains(a2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
