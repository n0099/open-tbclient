package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.Reaction;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class hm8 extends BdBaseView<BaseFragmentActivity> implements fm8, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int F;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public Runnable B;
    public TBAlertBuilder C;
    @Nullable
    public TBAlertBuilder D;
    public boolean E;
    public final WeakReference<Activity> a;
    @Nullable
    public AlertDialog b;
    public View c;
    public LinearLayout d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public FlowLayout h;
    @NonNull
    public final km8 i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public EMTextView o;
    public EMTextView p;
    public EMTextView q;
    public EMTextView r;
    public LinearLayout s;
    public HeadImageView t;
    public TextView u;
    public View v;
    public List<View> w;
    public EMTextView x;
    public View y;
    @Nullable
    public dm8 z;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm8 a;

        public a(hm8 hm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
                this.a.G();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm8 a;

        public b(hm8 hm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.T();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm8 a;

        public c(hm8 hm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hb.a(this.a.b, this.a.mContext.getPageActivity());
                this.a.G();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm8 a;

        public d(hm8 hm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.z != null) {
                this.a.z.b(25, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm8 a;

        public e(hm8 hm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.D.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ChatRoomDetail.BasicInfo b;
        public final /* synthetic */ TbBaseMsg c;
        public final /* synthetic */ hm8 d;

        public f(hm8 hm8Var, Activity activity, ChatRoomDetail.BasicInfo basicInfo, TbBaseMsg tbBaseMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm8Var, activity, basicInfo, tbBaseMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hm8Var;
            this.a = activity;
            this.b = basicInfo;
            this.c = tbBaseMsg;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a, String.valueOf(this.b.getForumId()), this.b.getForumName(), "", TbadkCoreApplication.getCurrentAccount(), this.c.getUserName(), this.c.getUserName(), "", this.c.getPortrait(), "chatroom", this.c.getSessionId(), this.c.getMsgId())));
                this.d.D.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? i == 4 : invokeLIL.booleanValue;
        }

        public g(hm8 hm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm8Var};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947828630, "Lcom/baidu/tieba/hm8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947828630, "Lcom/baidu/tieba/hm8;");
                return;
            }
        }
        F = UtilHelper.getDimenPixelSize(R.dimen.tbds78);
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlertDialog create = new AlertDialog.Builder(this.mContext.getPageActivity(), R.style.obfuscated_res_0x7f10010d).create();
            this.b = create;
            create.setCanceledOnTouchOutside(true);
            this.b.setOnDismissListener(new a(this));
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048582, this) != null) {
            return;
        }
        while (true) {
            List<View> list = this.w;
            if (list != null && list.size() > 0) {
                this.h.removeView(this.w.get(0));
                this.w.remove(0);
            } else {
                return;
            }
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.s != null) {
            EMManager.from(this.u).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X09);
        }
    }

    @Override // com.baidu.tieba.fm8
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            S(0L);
        }
    }

    @Override // com.baidu.tieba.fm8
    public void o() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (linearLayout = this.s) != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            A(0L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hm8(@NonNull BdPageContext<BaseFragmentActivity> bdPageContext) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.w = new ArrayList();
        this.E = false;
        this.a = new WeakReference<>(bdPageContext.getPageActivity());
        B();
        C();
        km8 km8Var = new km8(this);
        this.i = km8Var;
        km8Var.b(this.c);
    }

    public void A(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            if (this.A == null) {
                this.A = new c(this);
            }
            SafeHandler.getInst().postDelayed(this.A, j);
        }
    }

    public void H(@NonNull Reaction reaction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, reaction) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ext_reaction", reaction);
            this.z.b(26, hashMap);
        }
    }

    public final void J(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            EMTextView eMTextView = this.q;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void K(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            EMTextView eMTextView = this.r;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void L(@Nullable Map<String, Object> map) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, map) == null) {
            if (map != null && map.containsKey("is_show_copy")) {
                z = ((Boolean) map.get("is_show_copy")).booleanValue();
            } else {
                z = true;
            }
            EMTextView eMTextView = this.j;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void M(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            EMTextView eMTextView = this.m;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void N(@Nullable Map<String, Object> map) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, map) == null) {
            int i = 0;
            if (map != null && map.containsKey("is_show_reply")) {
                z = ((Boolean) map.get("is_show_reply")).booleanValue();
            } else {
                z = false;
            }
            EMTextView eMTextView = this.k;
            if (!z) {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void O(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            EMTextView eMTextView = this.n;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void P(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            EMTextView eMTextView = this.l;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void S(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            if (this.B == null) {
                this.B = new b(this);
            }
            SafeHandler.getInst().postDelayed(this.B, j);
        }
    }

    public final void V(@Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, map) == null) {
            L(map);
            N(map);
            O(false);
            M(false);
            P(true);
        }
    }

    public void W(@Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, str) == null) && !StringUtils.isNull(str)) {
            this.t.startLoad(str, 12, false);
        }
    }

    @Override // com.baidu.tieba.cm8
    public void c(@NonNull List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            this.i.c(list);
        }
    }

    @Override // com.baidu.tieba.fm8
    public void m(@NonNull dm8 dm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, dm8Var) == null) {
            this.z = dm8Var;
        }
    }

    @SuppressLint({"InflateParams"})
    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d089a, (ViewGroup) null);
            this.c = inflate;
            this.d = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090ec7);
            this.e = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090ec1);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ec5);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ec4);
            this.g = textView;
            textView.setMaxLines(1);
            this.g.setEllipsize(TextUtils.TruncateAt.END);
            this.h = (FlowLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090ea8);
            EMTextView eMTextView = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090eba);
            this.j = eMTextView;
            eMTextView.setOnClickListener(this);
            EMTextView eMTextView2 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ebf);
            this.l = eMTextView2;
            eMTextView2.setOnClickListener(this);
            EMTextView eMTextView3 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ebc);
            this.m = eMTextView3;
            eMTextView3.setOnClickListener(this);
            EMTextView eMTextView4 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ebe);
            this.n = eMTextView4;
            eMTextView4.setOnClickListener(this);
            EMTextView eMTextView5 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ea5);
            this.x = eMTextView5;
            eMTextView5.setOnClickListener(this);
            EMTextView eMTextView6 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ebd);
            this.k = eMTextView6;
            eMTextView6.setOnClickListener(this);
            EMTextView eMTextView7 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090eb9);
            this.p = eMTextView7;
            eMTextView7.setOnClickListener(this);
            EMTextView eMTextView8 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ebb);
            this.o = eMTextView8;
            eMTextView8.setOnClickListener(this);
            EMTextView eMTextView9 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090eb7);
            this.q = eMTextView9;
            eMTextView9.setOnClickListener(this);
            this.y = this.c.findViewById(R.id.obfuscated_res_0x7f090418);
            EMTextView eMTextView10 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090eb8);
            this.r = eMTextView10;
            eMTextView10.setOnClickListener(this);
            if (!D()) {
                I();
            }
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.mContext.getPageActivity().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            if (i % 160 != 0 && (i * 1.0f) / 160.0f != 1.5d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fm8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.b != null) {
                this.b = null;
            }
            if (this.B != null) {
                SafeHandler.getInst().removeCallbacks(this.B);
                this.B = null;
            }
            if (this.A != null) {
                SafeHandler.getInst().removeCallbacks(this.A);
                this.A = null;
            }
        }
    }

    public final void E(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, map) == null) {
            if (i != 0) {
                if (i != 1 && i != 2 && i != 3 && i != 4) {
                    if (i == 64) {
                        L(map);
                        N(map);
                        O(true);
                        M(false);
                        P(true);
                        return;
                    }
                    return;
                }
                L(map);
                N(map);
                O(true);
                M(false);
                P(false);
                return;
            }
            L(map);
            N(map);
            O(true);
            M(true);
            P(true);
        }
    }

    public final void F(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, map) == null) {
            if (i == 0 || i == 1 || i == 2 || i == 4 || i == 64) {
                L(map);
                N(map);
                O(true);
                M(false);
                P(false);
            }
        }
    }

    public final void Q(TextView textView, int i) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048592, this, textView, i) != null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i2 = F;
        pureDrawable.setBounds(0, 0, i2, i2);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    @Override // com.baidu.tieba.fm8
    @SuppressLint({"SetTextI18n"})
    public void k(@NonNull String str, @NonNull CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, charSequence) == null) {
            TextView textView = this.f;
            textView.setText(str + ZeusCrashHandler.NAME_SEPERATOR);
            this.g.setText(charSequence);
        }
    }

    @Override // com.baidu.tieba.fm8
    public void p(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, str, str2) == null) {
            this.u.setText(str);
            W(str2);
            this.s.setVisibility(0);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.q.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            this.n.getLayoutParams().width = 201;
            this.o.getLayoutParams().width = 201;
            this.r.getLayoutParams().width = 201;
            this.p.getLayoutParams().width = 201;
            LinearLayout linearLayout = this.s;
            if (linearLayout != null) {
                linearLayout.getLayoutParams().width = 201;
            }
        }
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            AlertDialog alertDialog = this.b;
            if (alertDialog == null) {
                return false;
            }
            boolean i = hb.i(alertDialog, this.mContext.getPageActivity());
            Window window = this.b.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100420);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.c);
            window.setDimAmount(0.33f);
            return i;
        }
        return invokeV.booleanValue;
    }

    public final void U(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i, map) == null) {
            if (i != 0) {
                if (i == 1 || i == 2 || i == 4 || i == 64) {
                    L(map);
                    O(true);
                    N(map);
                    M(false);
                    P(true);
                    return;
                }
                return;
            }
            L(map);
            O(true);
            N(map);
            M(true);
            P(true);
        }
    }

    public final void y(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048614, this, i, map) == null) {
            if (i != 0) {
                if (i == 1 || i == 2 || i == 64) {
                    L(map);
                    N(map);
                    O(true);
                    M(false);
                    P(false);
                    return;
                }
                return;
            }
            L(map);
            N(map);
            O(true);
            M(true);
            P(false);
        }
    }

    @Override // com.baidu.tieba.fm8
    public void a(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            new BdTopToast(this.mContext.getContext()).setIcon(true).setContent(str).show((ViewGroup) this.mContext.getPageActivity().findViewById(16908290));
        }
    }

    @Override // com.baidu.tieba.fm8
    public void i(boolean z, int i, int i2, @Nullable Map<String, Object> map, boolean z2, int i3, long j, long j2) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), map, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            boolean z3 = true;
            if (z) {
                V(map);
            } else if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            y(i, map);
                        }
                    } else {
                        U(i, map);
                    }
                } else {
                    E(i, map);
                }
            } else {
                F(i, map);
            }
            int i5 = 8;
            if (map != null && map.containsKey("is_show_bubble")) {
                boolean booleanValue = ((Boolean) map.get("is_show_bubble")).booleanValue();
                EMTextView eMTextView = this.p;
                if (booleanValue) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
                eMTextView.setVisibility(i4);
            } else {
                this.p.setVisibility(8);
            }
            if (map != null && map.containsKey("is_show_emoji_reply")) {
                this.i.d(((Boolean) map.get("is_show_emoji_reply")).booleanValue());
            } else {
                this.i.d(true);
            }
            if (z2) {
                J(true);
                vb8.a(1, 1, j, j2);
            } else {
                J(false);
            }
            if (map != null && map.containsKey("is_show_excellent_btn")) {
                boolean booleanValue2 = ((Boolean) map.get("is_show_excellent_btn")).booleanValue();
                EMTextView eMTextView2 = this.o;
                if (booleanValue2) {
                    i5 = 0;
                }
                eMTextView2.setVisibility(i5);
            } else {
                this.o.setVisibility(8);
            }
            int i6 = R.string.obfuscated_res_0x7f0f041b;
            int i7 = R.drawable.obfuscated_res_0x7f0804e2;
            if (map != null && map.containsKey("is_excellent_msg")) {
                boolean booleanValue3 = ((Boolean) map.get("is_excellent_msg")).booleanValue();
                this.E = booleanValue3;
                EMTextView eMTextView3 = this.o;
                if (booleanValue3) {
                    i7 = R.drawable.obfuscated_res_0x7f0804e1;
                }
                Q(eMTextView3, i7);
                EMTextView eMTextView4 = this.o;
                if (this.E) {
                    i6 = R.string.obfuscated_res_0x7f0f041a;
                }
                eMTextView4.setText(i6);
            } else {
                Q(this.o, R.drawable.obfuscated_res_0x7f0804e2);
                this.o.setText(R.string.obfuscated_res_0x7f0f041b);
            }
            if ((i3 != 1 && i3 != 2) || i != 0 || z) {
                z3 = false;
            }
            K(z3);
        }
    }

    @Override // com.baidu.tieba.fm8
    public void j(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            if (this.C == null) {
                this.C = new TBAlertBuilder(this.a.get());
            }
            this.C.setTitle(R.string.obfuscated_res_0x7f0f0952);
            this.C.setDescStr(str);
            this.C.setDescLightStyle(true);
            this.C.setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0596, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0952, TBAlertConfig.OperateBtnStyle.MAIN, new d(this)));
            this.C.setAutoClose();
            this.C.setCancelable(false);
            this.C.show();
        }
    }

    @Override // com.baidu.tieba.fm8
    public void n(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, obj) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d019a, (ViewGroup) null);
            this.v = inflate;
            this.s = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091f91);
            this.t = (HeadImageView) this.v.findViewById(R.id.obfuscated_res_0x7f091f96);
            this.u = (TextView) this.v.findViewById(R.id.obfuscated_res_0x7f091fa8);
            R();
            this.t.setIsRound(true);
            this.t.setDrawBorder(false);
            this.t.setPlaceHolder(1);
            this.s.setOnClickListener(this);
            this.s.setTag(obj);
            this.h.addView(this.v);
            this.w.add(this.v);
            LinearLayout linearLayout = this.s;
            if (linearLayout != null) {
                linearLayout.getLayoutParams().width = 201;
            }
        }
    }

    @Override // com.baidu.tieba.fm8
    public void onChangeSkinType() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            EMManager.from(this.d).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0213);
            EMManager.from(this.e).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0209);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.y, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.x, R.color.CAM_X0213);
            EMManager.from(this.f).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(this.g).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X08);
            R();
            SkinManager.setViewTextColorSelector(this.x, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.mContext.getPageActivity().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (D()) {
                i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i = (width - 1005) / 4;
            }
            this.h.setHorizontalSpacing(i);
            Q(this.q, R.drawable.obfuscated_res_0x7f0800e3);
            Q(this.j, R.drawable.obfuscated_res_0x7f0804dc);
            Q(this.l, R.drawable.obfuscated_res_0x7f0804e0);
            Q(this.m, R.drawable.obfuscated_res_0x7f0804dd);
            Q(this.n, R.drawable.obfuscated_res_0x7f0804df);
            Q(this.k, R.drawable.obfuscated_res_0x7f0804de);
            Q(this.p, R.drawable.obfuscated_res_0x7f080bb4);
            EMTextView eMTextView = this.o;
            if (this.E) {
                i2 = R.drawable.obfuscated_res_0x7f0804e1;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f0804e2;
            }
            Q(eMTextView, i2);
            Q(this.r, R.drawable.obfuscated_res_0x7f080b9a);
            TBAlertBuilder tBAlertBuilder = this.C;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.onChangeSkinType();
            }
            TBAlertBuilder tBAlertBuilder2 = this.D;
            if (tBAlertBuilder2 != null) {
                tBAlertBuilder2.onChangeSkinType();
            }
            this.i.onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        dm8 dm8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090eba) {
                dm8 dm8Var2 = this.z;
                if (dm8Var2 != null) {
                    dm8Var2.b(19, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090ebf) {
                dm8 dm8Var3 = this.z;
                if (dm8Var3 != null) {
                    dm8Var3.b(18, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090ebc) {
                dm8 dm8Var4 = this.z;
                if (dm8Var4 != null) {
                    dm8Var4.b(17, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090ebe) {
                dm8 dm8Var5 = this.z;
                if (dm8Var5 != null) {
                    dm8Var5.b(20, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090ebd) {
                dm8 dm8Var6 = this.z;
                if (dm8Var6 != null) {
                    dm8Var6.b(21, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090ea5) {
                dm8 dm8Var7 = this.z;
                if (dm8Var7 != null) {
                    dm8Var7.b(22, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090eb9) {
                dm8 dm8Var8 = this.z;
                if (dm8Var8 != null) {
                    dm8Var8.b(23, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f091f91) {
                if (this.z != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("robot_tag", view2.getTag());
                    this.z.b(24, hashMap);
                }
            } else if (id == R.id.obfuscated_res_0x7f090ebb) {
                dm8 dm8Var9 = this.z;
                if (dm8Var9 != null) {
                    dm8Var9.b(33, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090eb7) {
                dm8 dm8Var10 = this.z;
                if (dm8Var10 != null) {
                    dm8Var10.b(32, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f0917b2) {
                dm8 dm8Var11 = this.z;
                if (dm8Var11 != null) {
                    dm8Var11.b(34, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090eb8 && (dm8Var = this.z) != null) {
                dm8Var.b(35, null);
            }
            z();
        }
    }

    @Override // com.baidu.tieba.fm8
    public void q(int i, int i2, @Nullable String str) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048612, this, i, i2, str) == null) {
            if (i != 1) {
                if (i == 3 && i2 == 1) {
                    boolean z = !this.E;
                    this.E = z;
                    EMTextView eMTextView = this.o;
                    if (z) {
                        i3 = R.drawable.obfuscated_res_0x7f0804e1;
                    } else {
                        i3 = R.drawable.obfuscated_res_0x7f0804e2;
                    }
                    Q(eMTextView, i3);
                    a(str);
                }
            } else if (i2 == 1) {
                a(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0956));
            }
        }
    }

    @Override // com.baidu.tieba.fm8
    public void r(@Nullable BaseItem baseItem, @Nullable ChatRoomDetail chatRoomDetail) {
        WeakReference<Activity> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048613, this, baseItem, chatRoomDetail) == null) && (weakReference = this.a) != null && weakReference.get() != null && baseItem != null && baseItem.getTbMsg() != null && chatRoomDetail != null && chatRoomDetail.getUserInfo() != null && chatRoomDetail.getBasicInfo() != null) {
            Activity activity = this.a.get();
            TbBaseMsg tbMsg = baseItem.getTbMsg();
            ChatRoomDetail.BasicInfo basicInfo = chatRoomDetail.getBasicInfo();
            ChatRoomDetail.UserInfo userInfo = chatRoomDetail.getUserInfo();
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a60);
            String banAllForumContent = userInfo.getBanAllForumContent();
            if (StringUtils.isNull(banAllForumContent)) {
                banAllForumContent = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a5e);
            }
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(activity);
            this.D = tBAlertBuilder;
            tBAlertBuilder.setTitleStr(string);
            this.D.setDescStr(String.format(banAllForumContent, tbMsg.getUserName(), basicInfo.getForumName()));
            this.D.setOperateBtn(new TBAlertConfig.OperateBtnConfig(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a64), TBAlertConfig.OperateBtnStyle.SECONDARY, new e(this)), new TBAlertConfig.OperateBtnConfig(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a60), TBAlertConfig.OperateBtnStyle.MAIN, new f(this, activity, basicInfo, tbMsg)));
            this.D.setOnKeyListener(new g(this));
            this.D.setAutoClose();
            this.D.setCancelable(false);
            this.D.show();
        }
    }
}
