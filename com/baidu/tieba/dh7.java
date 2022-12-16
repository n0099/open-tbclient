package com.baidu.tieba;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
/* loaded from: classes4.dex */
public class dh7 extends p9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int B;
    public transient /* synthetic */ FieldHolder $fh;
    public TBAlertBuilder A;
    public TbPageContext<BaseFragmentActivity> a;
    public View b;
    public LinearLayout c;
    public LinearLayout d;
    public TextView e;
    public TbRichTextView f;
    public FlowLayout g;
    public EMTextView h;
    public EMTextView i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public View m;
    public BaseMsg n;
    public ChatRoomDetail o;
    public int p;
    public int q;
    public FastRequest r;
    public FastRequest s;
    public long t;
    public long u;
    public long v;
    public long w;
    public String x;
    public long y;
    public String z;

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomMessageListener a;

        public a(dh7 dh7Var, CustomMessageListener customMessageListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var, customMessageListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = customMessageListener;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().unRegisterListener(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh7 a;

        public b(dh7 dh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.n != null && this.a.n.getMsgType() == 1 && ((TextMsg) this.a.n).getText() != null) {
                oi.a(((TextMsg) this.a.n).getText());
                vg7.a(this.a.a);
                BdTopToast bdTopToast = new BdTopToast(this.a.a.getContext());
                bdTopToast.h(true);
                bdTopToast.g(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0837));
                bdTopToast.i((ViewGroup) this.a.a.getPageActivity().findViewById(16908290));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh7 a;

        public c(dh7 dh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vg7.a(this.a.a);
                this.a.y();
                TiebaStatic.log(new StatisticItem("c15091").param("uid", this.a.w).param("fid", this.a.y).param("room_id", this.a.t));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh7 a;

        public d(dh7 dh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vg7.a(this.a.a);
                this.a.G();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh7 a;

        public e(dh7 dh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.x();
                vg7.a(this.a.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh7 a;

        public f(dh7 dh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vg7.a(this.a.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh7 b;

        public g(dh7 dh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                BdLog.d("error: " + i + " " + str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.b.a.getContext());
                bdTopToast.h(true);
                bdTopToast.g(this.b.a.getResources().getString(R.string.obfuscated_res_0x7f0f083b));
                bdTopToast.i((ViewGroup) this.b.a.getPageActivity().findViewById(16908290));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
            }
        }

        public h(dh7 dh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                BdLog.d("error: " + i + " " + str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(dh7 dh7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.v();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh7 a;

        public j(dh7 dh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.w();
                TiebaStatic.log(new StatisticItem("c15092").param("uid", this.a.v).param("fid", this.a.y).param("room_id", this.a.t));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947704630, "Lcom/baidu/tieba/dh7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947704630, "Lcom/baidu/tieba/dh7;");
                return;
            }
        }
        B = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h.getLayoutParams().width = 201;
            this.i.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            B(true);
            D(false);
            C(false);
            E(false);
        }
    }

    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void v() {
        TBAlertBuilder tBAlertBuilder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (tBAlertBuilder = this.A) != null) {
            tBAlertBuilder.g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh7(TbPageContext<BaseFragmentActivity> tbPageContext, BaseMsg baseMsg, ChatRoomDetail chatRoomDetail) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, baseMsg, chatRoomDetail};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.n = baseMsg;
        this.o = chatRoomDetail;
        r();
        q();
    }

    public void B(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            EMTextView eMTextView = this.h;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void C(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            EMTextView eMTextView = this.j;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void D(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            EMTextView eMTextView = this.k;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void E(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            EMTextView eMTextView = this.i;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (i2 == 0 || i2 == 1 || i2 == 2) {
                B(true);
                D(true);
                C(false);
                E(false);
            }
        }
    }

    public final void F(TextView textView, int i2) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048581, this, textView, i2) != null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i3 = B;
        pureDrawable.setBounds(0, 0, i3, i3);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void G() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            r9<T> r9Var = this.mContext;
            if (r9Var != 0) {
                str = String.format(r9Var.getString(R.string.obfuscated_res_0x7f0f0839), this.z);
            } else {
                str = null;
            }
            i iVar = new i(this, 2001304);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.getPageActivity());
            this.A = tBAlertBuilder;
            tBAlertBuilder.v(R.string.obfuscated_res_0x7f0f0838);
            if (!xi.isEmpty(str)) {
                this.A.q(str);
            }
            this.A.o(true);
            this.A.t(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0501, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0838, TBAlertConfig.OperateBtnStyle.MAIN, new j(this)));
            this.A.i();
            this.A.j(false);
            this.A.y();
            MessageManager.getInstance().registerListener(iVar);
            this.A.s(new a(this, iVar));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.r == null) {
                this.r = new FastRequest(this.a, CmdConfigHttp.CMD_GET_GROUP_CHAT_LIMIT_MESSAGE, "c/c/chatroom/controlSpeak");
            }
            FastRequest fastRequest = this.r;
            fastRequest.H("uid", String.valueOf(this.w));
            fastRequest.H("chatroom_id", String.valueOf(this.t));
            fastRequest.H("op_type", 1);
            fastRequest.H("block_uid", String.valueOf(this.v));
            fastRequest.H("forum_id", String.valueOf(this.y));
            fastRequest.J(new g(this));
            fastRequest.I();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.s == null) {
                this.s = new FastRequest(this.a, CmdConfigHttp.CMD_GET_GROUP_CHAT_ROLLBACK_MESSAGE, "c/c/chatroom/withdrawMsg");
            }
            FastRequest fastRequest = this.s;
            fastRequest.H("uid_to", String.valueOf(this.v));
            fastRequest.H("chatroom_id", String.valueOf(this.t));
            fastRequest.H("msg_id", String.valueOf(this.u));
            fastRequest.H("msg_key", String.valueOf(this.x));
            fastRequest.H("forum_id", String.valueOf(this.y));
            fastRequest.J(new h(this));
            fastRequest.I();
        }
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2) {
                    B(true);
                    D(true);
                    C(false);
                    E(true);
                    return;
                }
                return;
            }
            B(true);
            D(true);
            C(true);
            E(true);
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2) {
                    B(true);
                    D(true);
                    C(false);
                    E(false);
                    return;
                }
                return;
            }
            B(true);
            D(true);
            C(true);
            E(true);
        }
    }

    public final TbRichText K(BaseMsg baseMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, baseMsg)) == null) {
            int msgType = baseMsg.getMsgType();
            if (msgType != 1) {
                if (msgType != 2) {
                    if (msgType != 3) {
                        if (msgType != 32) {
                            if (msgType != 7009) {
                                return new TbRichText(xa7.c("", 0));
                            }
                            return new TbRichText(xa7.c(TbadkCoreApplication.getInst().getString(R.string.last_msg_forum_share), 0));
                        }
                        return new TbRichText(xa7.c(TbadkCoreApplication.getInst().getString(R.string.last_msg_thread_share), 0));
                    }
                    return new TbRichText(xa7.c(TbadkCoreApplication.getInst().getString(R.string.last_msg_voice), 0));
                }
                return new TbRichText(xa7.c(TbadkCoreApplication.getInst().getString(R.string.last_msg_pic), 0));
            }
            return new TbRichText(xa7.c(((TextMsg) baseMsg).getText(), 0));
        }
        return (TbRichText) invokeL.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.n.getCommonMsgField() != null) {
                if (this.n.getCommonMsgField().getUserName() != null) {
                    TextView textView = this.e;
                    textView.setText(this.n.getCommonMsgField().getUserName() + ZeusCrashHandler.NAME_SEPERATOR);
                    this.z = this.n.getCommonMsgField().getUserName();
                }
                if (this.n.getCommonMsgField().getMsgKey() != null) {
                    this.x = this.n.getCommonMsgField().getMsgKey();
                }
                this.q = this.n.getCommonMsgField().getRole();
                this.t = this.n.getCommonMsgField().getRoomId();
                this.u = this.n.getCommonMsgField().getMsgId();
                this.v = this.n.getCommonMsgField().getUserId();
                this.w = TbadkCoreApplication.getCurrentAccountId();
                if (this.o.getBasicInfo() != null) {
                    this.y = this.o.getBasicInfo().getForumId();
                }
            }
            if (this.o.getUserInfo() != null) {
                this.p = this.o.getUserInfo().getIdentityRole();
            }
            this.f.setMaxLines(1);
            this.f.setAddTruncateListener(true);
            this.f.setTextEllipsize(TextUtils.TruncateAt.END);
            this.f.setText(K(this.n));
            if (this.v != this.w) {
                int i2 = this.p;
                if (i2 == 0) {
                    u(this.q);
                } else if (i2 == 2) {
                    t(this.q);
                } else if (i2 == 1) {
                    H(this.q);
                }
            } else {
                J();
            }
            BaseMsg baseMsg = this.n;
            if (baseMsg != null && baseMsg.getMsgType() != 1) {
                B(false);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07d5, (ViewGroup) null);
            this.b = inflate;
            this.c = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090d69);
            this.d = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090d63);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d67);
            this.f = (TbRichTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d66);
            this.g = (FlowLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090d4e);
            EMTextView eMTextView = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d5e);
            this.h = eMTextView;
            eMTextView.setOnClickListener(new b(this));
            EMTextView eMTextView2 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d61);
            this.i = eMTextView2;
            eMTextView2.setOnClickListener(new c(this));
            EMTextView eMTextView3 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d5f);
            this.j = eMTextView3;
            eMTextView3.setOnClickListener(new d(this));
            EMTextView eMTextView4 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d60);
            this.k = eMTextView4;
            eMTextView4.setOnClickListener(new e(this));
            EMTextView eMTextView5 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d47);
            this.l = eMTextView5;
            eMTextView5.setOnClickListener(new f(this));
            this.m = this.b.findViewById(R.id.obfuscated_res_0x7f0903ce);
            if (!s()) {
                A();
            }
        }
    }

    public void z() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            rw4 d2 = rw4.d(this.c);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0213);
            rw4 d3 = rw4.d(this.d);
            d3.n(R.string.J_X14);
            d3.f(R.color.CAM_X0209);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.l, R.color.CAM_X0213);
            rw4 d4 = rw4.d(this.e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X08);
            d4.A(R.string.F_X01);
            this.f.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            this.f.setTextSize(UtilHelper.getDimenPixelSize(R.dimen.T_X08));
            SkinManager.setViewTextColorSelector(this.l, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.a.getPageActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (s()) {
                i2 = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 4)) / 3;
            } else {
                i2 = (width - 804) / 3;
            }
            this.g.setHorizontalSpacing(i2);
            F(this.h, R.drawable.obfuscated_res_0x7f08045a);
            F(this.i, R.drawable.obfuscated_res_0x7f08045d);
            F(this.j, R.drawable.obfuscated_res_0x7f08045b);
            F(this.k, R.drawable.obfuscated_res_0x7f08045c);
        }
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.a.getPageActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.densityDpi;
            if (i2 % 160 != 0 && (i2 * 1.0f) / 160.0f != 1.5d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> tbPageContext = this.a;
            urlManager.dealOneLink(tbPageContext, new String[]{"https://tieba.baidu.com/tpl/wise-bawu-core/report?type=5" + ("&chatroom_msg_id=" + this.u) + ("&chatroom_id=" + this.t)});
        }
    }
}
