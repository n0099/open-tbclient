package com.baidu.tieba.im.base.core.uilist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tieba.aw8;
import com.baidu.tieba.cv8;
import com.baidu.tieba.gu5;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.jl5;
import com.baidu.tieba.mv8;
import com.baidu.tieba.rk5;
import com.baidu.tieba.tracker.Monitor;
import com.baidu.tieba.uv8;
import com.baidu.tieba.x3b;
import com.baidu.tieba.y3b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.HashMap;
/* loaded from: classes6.dex */
public abstract class MsgSender<Adapter extends BaseNormalAdapter, Msg extends BaseItem<? extends TbBaseMsg>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Adapter a;
    public int b;

    /* loaded from: classes6.dex */
    public interface d {
        void a();

        void b();

        void c(int i);
    }

    public void i(@NonNull Msg msg, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, msg, dVar) == null) {
        }
    }

    public abstract boolean j(@NonNull Msg msg);

    public abstract void k(Msg msg, int i, int i2);

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseItem a;
        public final /* synthetic */ int b;
        public final /* synthetic */ MsgSender c;

        public a(MsgSender msgSender, BaseItem baseItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgSender, baseItem, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = msgSender;
            this.a = baseItem;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.h(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseItem a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ MsgSender d;

        public b(MsgSender msgSender, BaseItem baseItem, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgSender, baseItem, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = msgSender;
            this.a = baseItem;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gu5.c(this.d.a, "必须要绑定数据适配器");
                this.a.setSendStatus(this.b);
                this.d.a.notifyItemChanged(this.c, 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseItem a;
        public final /* synthetic */ int b;
        public final /* synthetic */ MsgSender c;

        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender.d
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            }
        }

        public c(MsgSender msgSender, BaseItem baseItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgSender, baseItem, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = msgSender;
            this.a = baseItem;
            this.b = i;
        }

        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.g(this.a, this.b);
            }
        }

        @Override // com.baidu.tieba.im.base.core.uilist.MsgSender.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.c.l(this.a, 2, this.b);
        }
    }

    public MsgSender() {
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

    public final void l(@NonNull Msg msg, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, msg, i, i2) == null) {
            UiUtils.post(new b(this, msg, i, i2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter */
    /* JADX WARN: Multi-variable type inference failed */
    public void f(@Nullable BaseNormalAdapter baseNormalAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, baseNormalAdapter) == null) {
            this.a = baseNormalAdapter;
        }
    }

    public final void g(@NonNull Msg msg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, msg, i) == null) {
            UiUtils.runOnBgThread(new a(this, msg, i));
        }
    }

    public final void n(@NonNull Msg msg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, msg, i) == null) {
            i(msg, new c(this, msg, i));
        }
    }

    @WorkerThread
    public final void h(@NonNull Msg msg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, msg, i) == null) {
            l(msg, 3, i);
            TbBaseMsg tbMsg = msg.getTbMsg();
            String valueOf = String.valueOf(tbMsg.getMsgId());
            uv8<?, ?> b2 = cv8.c.b(tbMsg.getClass());
            gu5.b(b2);
            ChatMsg chatMsg = (ChatMsg) aw8.a(b2, mv8.a, tbMsg);
            if (chatMsg == null) {
                l(msg, 4, i);
            } else {
                rk5.b().n(this.a.D(), tbMsg.getSessionId(), chatMsg, new jl5(this, tbMsg, msg, i, valueOf) { // from class: com.baidu.tieba.im.base.core.uilist.MsgSender.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TbBaseMsg a;
                    public final /* synthetic */ BaseItem b;
                    public final /* synthetic */ int c;
                    public final /* synthetic */ String d;
                    public final /* synthetic */ MsgSender e;

                    /* renamed from: com.baidu.tieba.im.base.core.uilist.MsgSender$2$a */
                    /* loaded from: classes6.dex */
                    public class a implements Runnable {
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ChatMsg a;
                        public final /* synthetic */ int b;
                        public final /* synthetic */ AnonymousClass2 c;

                        public a(AnonymousClass2 anonymousClass2, ChatMsg chatMsg, int i) {
                            Interceptable interceptable = $ic;
                            if (interceptable != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {anonymousClass2, chatMsg, Integer.valueOf(i)};
                                interceptable.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.c = anonymousClass2;
                            this.a = chatMsg;
                            this.b = i;
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.im.base.core.uilist.MsgSender */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            int i;
                            Interceptable interceptable = $ic;
                            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                                ChatMsg chatMsg = this.a;
                                if (chatMsg != null) {
                                    this.c.a.setOriginSdkMsg(chatMsg);
                                    this.c.a.syncServerMsgId(this.a.getMsgId());
                                }
                                if (this.b == 0) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                                AnonymousClass2 anonymousClass2 = this.c;
                                anonymousClass2.e.l(anonymousClass2.b, i, anonymousClass2.c);
                                AnonymousClass2 anonymousClass22 = this.c;
                                anonymousClass22.e.k(anonymousClass22.b, i, anonymousClass22.c);
                            }
                        }
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, tbMsg, msg, Integer.valueOf(i), valueOf};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.e = this;
                        this.a = tbMsg;
                        this.b = msg;
                        this.c = i;
                        this.d = valueOf;
                    }

                    @Override // com.baidu.tieba.jl5
                    public void onSendMessageResult(int i2, @Nullable ChatMsg chatMsg2) {
                        long j;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, chatMsg2) == null) {
                            a aVar = new a(this, chatMsg2, i2);
                            if (GlobalBuildConfig.isDebug()) {
                                j = this.e.b;
                            } else {
                                j = 0;
                            }
                            UiUtils.runOnUiThreadDelay(aVar, j);
                            if (i2 == 0 && chatMsg2 != null) {
                                Monitor.a.c(new y3b(this.d), x3b.a.a).l(new HashMap<String, String>(this, chatMsg2) { // from class: com.baidu.tieba.im.base.core.uilist.MsgSender.2.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass2 this$1;
                                    public final /* synthetic */ ChatMsg val$chatMsg;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, chatMsg2};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$chatMsg = chatMsg2;
                                        put("msg_type", String.valueOf(this.val$chatMsg.getMsgType()));
                                    }
                                });
                            } else {
                                Monitor.a.c(new y3b(this.d), x3b.a.a).b(new HashMap<String, String>(this, i2, chatMsg2) { // from class: com.baidu.tieba.im.base.core.uilist.MsgSender.2.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass2 this$1;
                                    public final /* synthetic */ ChatMsg val$chatMsg;
                                    public final /* synthetic */ int val$responseCode;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Integer.valueOf(i2), chatMsg2};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$responseCode = i2;
                                        this.val$chatMsg = chatMsg2;
                                        put(PushMessageHelper.ERROR_TYPE, String.valueOf(this.val$responseCode));
                                        put("error_info", String.valueOf(this.val$responseCode));
                                        ChatMsg chatMsg3 = this.val$chatMsg;
                                        if (chatMsg3 != null) {
                                            put("msg_type", String.valueOf(chatMsg3.getMsgType()));
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
            }
        }
    }

    public void m(@NonNull Msg msg, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, msg, i) == null) {
            gu5.c(this.a, "必须要绑定数据适配器");
            Monitor.a.c(new y3b(String.valueOf(msg.getTbMsg().getMsgId()), "chatroom", "chatroom_send_msg"), x3b.a.a).g();
            int sendStatus = msg.getSendStatus();
            if (sendStatus != 0 && sendStatus != 2) {
                z = false;
            } else {
                z = true;
            }
            if (j(msg) && z) {
                l(msg, 1, i);
                n(msg, i);
            } else if (sendStatus == 0 || sendStatus == 4) {
                g(msg, i);
            }
        }
    }
}
