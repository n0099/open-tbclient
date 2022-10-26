package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.pu4;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.tieba.transmitShare.ShareScrollableLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
/* loaded from: classes4.dex */
public class ii8 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int L;
    public static final int M;
    public static int N;
    public static int O;
    public static int P;
    public static int Q;
    public transient /* synthetic */ FieldHolder $fh;
    public ShareItem A;
    public final SparseArray B;
    public boolean C;
    public SparseArray D;
    public SparseArray E;
    public boolean F;
    public int G;
    public boolean H;
    public boolean I;
    public CustomMessageListener J;
    public int K;
    public final Context a;
    public final View b;
    public final View c;
    public final TextView d;
    public ShareScrollableLayout e;
    public ShareGridLayout f;
    public final EMTextView g;
    public final List h;
    public View.OnClickListener i;
    public DialogInterface.OnDismissListener j;
    public DialogInterface.OnCancelListener k;
    public AlertDialog l;
    public float m;
    public PermissionJudgePolicy n;
    public RelativeLayout o;
    public ImageView p;
    public TextView q;
    public MessageRedDotView r;
    public ImageView s;
    public boolean t;
    public String u;
    public ArrayList v;
    public ArrayList w;
    public ArrayList x;
    public ArrayList y;
    public ArrayList z;

    public final boolean I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? (i2 & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? (i2 & 4) > 0 : invokeI.booleanValue;
    }

    public final boolean L(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? (i2 & 1) > 0 : invokeI.booleanValue;
    }

    public final boolean M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? (i2 & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? (i2 & 16) > 0 : invokeI.booleanValue;
    }

    public final boolean P(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? (i2 & 32) > 0 : invokeI.booleanValue;
    }

    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ii8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ii8 ii8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii8Var, Integer.valueOf(i)};
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
            this.a = ii8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.a.t();
            if (this.a.e != null) {
                this.a.e.removeAllViews();
            } else {
                this.a.f.removeAllViews();
            }
            if (this.a.e != null) {
                this.a.s();
            } else {
                this.a.r();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CustomMessageTask.CustomRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ii8 a;

        public b(ii8 ii8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ii8Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage run(CustomMessage customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.a.l != null && this.a.l.isShowing()) {
                    this.a.v();
                    return null;
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ii8 a;

        public c(ii8 ii8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ii8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.j != null) {
                    this.a.j.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
                if (this.a.D(1).m && !this.a.I) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921696, 3));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ii8 a;

        public d(ii8 ii8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ii8Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && this.a.k != null) {
                this.a.k.onCancel(dialogInterface);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ ii8 b;

        public e(ii8 ii8Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii8Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ii8Var;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.l != null) {
                    this.b.l.dismiss();
                }
                this.a.onClick(view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ii8 a;

        public f(ii8 ii8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ii8Var;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                fj.N(this.a.a, "保存成功！");
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                fj.N(this.a.a, "保存失败！");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ ii8 b;

        public g(ii8 ii8Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii8Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ii8Var;
            this.a = shareItem;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                vi.a(this.a.w);
                fj.M(this.b.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f045d);
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(ii8 ii8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;
        public final /* synthetic */ ii8 b;

        public i(ii8 ii8Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii8Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ii8Var;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.v();
                View.OnClickListener onClickListener = this.a;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947854577, "Lcom/baidu/tieba/ii8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947854577, "Lcom/baidu/tieba/ii8;");
                return;
            }
        }
        L = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        M = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds239);
        N = 10;
        O = 8;
        P = 1;
        Q = 2;
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            E();
            boolean A = A();
            ArrayList arrayList = this.y;
            if (arrayList != null && arrayList.size() != 0 && !N(this.K) && TbadkCoreApplication.getCurrentAccount() != null && !A) {
                p0(0, 1, 2);
            } else if (A) {
                this.e.setItemParams(fj.k(this.a) / 5, M);
                q0(0, 1, A);
            } else {
                o0(0, 1);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048626, this) != null) || s0()) {
            return;
        }
        n0();
        if (!k35.m()) {
            this.f.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.f.addView((View) this.h.get(i2), new ViewGroup.LayoutParams(L, M));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048628, this) != null) || s0()) {
            return;
        }
        n0();
        if (!k35.m()) {
            this.f.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.f.addView((View) this.h.get(i2), new ViewGroup.LayoutParams(L, M));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048630, this) != null) || s0()) {
            return;
        }
        i0();
        if (!k35.m()) {
            this.e.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.e.addView((View) this.h.get(i2), new ViewGroup.LayoutParams(L, M));
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            ArrayList arrayList = this.v;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator it = this.v.iterator();
                while (it.hasNext()) {
                    ((MetaData) it.next()).setItemType(P);
                }
            }
            ArrayList arrayList2 = this.w;
            if (arrayList2 != null && arrayList2.size() != 0) {
                Iterator it2 = this.w.iterator();
                while (it2.hasNext()) {
                    ((MetaData) it2.next()).setItemType(Q);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ii8(Context context) {
        this(context, false, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void u0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048635, this, i2) == null) && i2 <= 8 && i2 > 0) {
            this.C = true;
            SparseArray sparseArray = this.E;
            if (sparseArray != null) {
                b25 b25Var = (b25) sparseArray.get(i2);
                if (!StringUtils.isNull(b25Var.b()) && b25Var.a() != null && b25Var.a().size() > 0) {
                    t0(b25Var.b(), b25Var.a());
                    return;
                }
            }
            SparseArray sparseArray2 = this.D;
            if (sparseArray2 != null) {
                String str = (String) sparseArray2.get(i2);
                if (!ej.isEmpty(str)) {
                    t0(str, new Object[0]);
                }
            }
        }
    }

    public final void v0(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
            int i2 = shareItem.J;
            if (i2 != 0) {
                param.param("obj_param1", i2);
                int i3 = shareItem.J;
                if (i3 == 2) {
                    param.param("fid", shareItem.N);
                } else if (i3 == 3) {
                    int i4 = shareItem.Q;
                    if (i4 != 0) {
                        param.param("obj_type", i4);
                    }
                    param.param("tid", shareItem.O).param("fid", shareItem.N);
                }
            }
            param.param("obj_locate", 9);
            TiebaStatic.log(param);
        }
    }

    public ii8(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = 0.33f;
        this.x = new ArrayList();
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.B = new SparseArray(8);
        this.C = false;
        this.F = true;
        this.G = 1;
        this.H = true;
        this.J = new a(this, 2001304);
        this.K = 0;
        this.K = i2;
        this.a = context;
        this.h = new ArrayList();
        View B = B();
        this.b = B;
        this.c = B.findViewById(R.id.obfuscated_res_0x7f091e7e);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091e7f);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.d.setText(sharePanelText);
        }
        ShareScrollableLayout shareScrollableLayout = (ShareScrollableLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091e9f);
        this.e = shareScrollableLayout;
        if (shareScrollableLayout == null) {
            ShareGridLayout shareGridLayout = (ShareGridLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091e83);
            this.f = shareGridLayout;
            ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i5 = ShareGridLayout.f;
                marginLayoutParams.leftMargin = i5;
                marginLayoutParams.rightMargin = i5;
                this.f.setLayoutParams(marginLayoutParams);
            }
            this.f.setItemParams(L, M);
        } else {
            shareScrollableLayout.setItemParams(L, M);
        }
        EMTextView eMTextView = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090428);
        this.g = eMTextView;
        eMTextView.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090bd3);
        this.o = relativeLayout;
        if (relativeLayout != null) {
            this.p = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09199c);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09199b);
            this.q = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f0ea5);
            MessageRedDotView messageRedDotView = (MessageRedDotView) this.b.findViewById(R.id.obfuscated_res_0x7f09199e);
            this.r = messageRedDotView;
            messageRedDotView.setExtendSize(fj.f(context, R.dimen.tbds5));
            this.r.setTextSize(R.dimen.T_X09);
            this.r.setTextBold(true);
            this.s = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09199d);
        }
    }

    public ShareItem D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            ShareItem shareItem = (ShareItem) this.B.get(i2);
            if (shareItem == null) {
                return (ShareItem) this.B.get(1);
            }
            return shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void F(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, onDismissListener) == null) && onDismissListener != null) {
            this.j = onDismissListener;
        }
    }

    public final boolean H(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, shareItem)) == null) {
            if (!TextUtils.isEmpty(shareItem.B0) && !TextUtils.isEmpty(shareItem.C0)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void W(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) && onClickListener != null) {
            this.i = onClickListener;
        }
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.u = str;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.F = z;
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.t = z;
        }
    }

    public void c0(SparseArray sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, sparseArray) == null) {
            this.D = sparseArray;
        }
    }

    public void d0(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onCancelListener) == null) {
            this.k = onCancelListener;
        }
    }

    public void e0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, onClickListener) != null) || !O()) {
            return;
        }
        this.o.setOnClickListener(new e(this, onClickListener));
    }

    public void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.G = i2;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.H = z;
        }
    }

    public void k0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, window) == null) {
            window.setLayout(-1, -2);
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ShareItem shareItem = this.A;
            if (!shareItem.g || shareItem.p) {
                ShareItem shareItem2 = this.A;
                if (!shareItem2.i && !shareItem2.m && !shareItem2.t0 && !shareItem2.o) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d020f, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final Location C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return f46.b();
        }
        return (Location) invokeV.objValue;
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.o != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new b(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.G == 2 && u()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            List list = this.h;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.v = vc7.a();
            this.w = xc7.a();
            x();
            ArrayList arrayList = this.v;
            if (arrayList != null && this.w != null && arrayList.size() != 0 && this.w.size() != 0) {
                this.x.addAll(this.v);
                this.x.addAll(this.w);
            } else {
                ArrayList arrayList2 = this.v;
                if (arrayList2 != null && arrayList2.size() != 0) {
                    this.x.addAll(this.v);
                } else {
                    ArrayList arrayList3 = this.w;
                    if (arrayList3 != null && arrayList3.size() != 0) {
                        this.x.addAll(this.w);
                    }
                }
            }
            Z();
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_FRIEND_BTN);
            int i2 = this.A.I;
            int i3 = 2;
            if (i2 != 4 && i2 != 3 && i2 != 20 && i2 != 30) {
                if (i2 != 5 && i2 != 10 && i2 != 33) {
                    i3 = (i2 == 6 || i2 == 2) ? 3 : i2 == 8 ? 4 : (i2 == 25 || i2 == 29 || i2 == 11 || i2 == 12) ? 5 : 0;
                }
            } else {
                i3 = 1;
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i3);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            for (int i2 = 0; i2 < this.x.size(); i2++) {
                if (((MetaData) this.x.get(i2)).getUserId() == null) {
                    this.y.add(this.x.get(i2));
                } else if (!this.z.contains(((MetaData) this.x.get(i2)).getUserId())) {
                    this.z.add(((MetaData) this.x.get(i2)).getUserId());
                    this.y.add(this.x.get(i2));
                }
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            nv4 d2 = nv4.d(this.c);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColorSelector(this.g, R.color.CAM_X0107);
            if (O()) {
                nv4 d3 = nv4.d(this.o);
                d3.n(R.string.J_X05);
                d3.f(R.color.CAM_X0201);
                this.p.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a1c, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
                nv4 d4 = nv4.d(this.q);
                d4.A(R.string.F_X01);
                d4.v(R.color.CAM_X0105);
            }
        }
    }

    public LinearLayout G(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.a();
            return shareDialogItemView;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public void f0(ShareItem shareItem, boolean z) {
        Location C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, shareItem, z) == null) {
            this.A = shareItem;
            if (z && (C = C()) != null) {
                shareItem.F = C;
            }
            this.B.put(1, shareItem);
            if (!StringUtils.isNull(shareItem.r)) {
                this.d.setText(shareItem.r);
            }
        }
    }

    public void i(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048609, this, i2, i3) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            List list = this.h;
            shareDialogItemView.a();
            list.add(shareDialogItemView);
        }
    }

    public void l(int i2, AbsSvgType absSvgType) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048615, this, i2, absSvgType) != null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
        shareDialogItemView.setItemIcon(absSvgType);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        List list = this.h;
        shareDialogItemView.a();
        list.add(shareDialogItemView);
    }

    public final void t0(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.a, str, "click", 1, objArr);
        }
    }

    public final void w0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048639, this, i2, str) == null) {
            TiebaStatic.eventStat(this.a, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921694, this.A.g0);
            MessageManager.getInstance().registerStickyMode(2921694);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(this.a);
            shareFriendActivityConfig.setIsForShare(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            if (!(this.a instanceof Activity)) {
                return false;
            }
            if (this.n == null) {
                this.n = new PermissionJudgePolicy();
            }
            this.n.clearRequestPermissionList();
            this.n.appendRequestPermission((Activity) this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
            return this.n.startRequestPermission((Activity) this.a);
        }
        return invokeV.booleanValue;
    }

    public void v() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && (alertDialog = this.l) != null) {
            this.C = false;
            if (this.a instanceof Activity) {
                DialogInterface.OnDismissListener onDismissListener = this.j;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(alertDialog);
                }
                jh.a(this.l, (Activity) this.a);
                MessageManager.getInstance().unRegisterListener(this.J);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (this.t) {
                this.d.setVisibility(8);
                if (O()) {
                    this.o.setVisibility(0);
                    return;
                }
                return;
            }
            this.d.setVisibility(0);
            if (O()) {
                this.o.setVisibility(8);
            }
        }
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_NEARLY_PERSON);
            int i2 = this.A.I;
            int i3 = 2;
            if (i2 != 4 && i2 != 3 && i2 != 20 && i2 != 30) {
                if (i2 != 5 && i2 != 10 && i2 != 33) {
                    i3 = (i2 == 6 || i2 == 2) ? 3 : i2 == 8 ? 4 : (i2 == 25 || i2 == 29 || i2 == 11 || i2 == 12) ? 5 : 0;
                }
            } else {
                i3 = 1;
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i3);
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, str);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void r0(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, shareItem) == null) && shareItem != null && !TextUtils.isEmpty(shareItem.w) && !TextUtils.isEmpty(shareItem.v)) {
            Context context = this.a;
            if (!(context instanceof Activity)) {
                return;
            }
            Activity activity = (Activity) context;
            pu4 pu4Var = new pu4(activity);
            pu4Var.setTitle(shareItem.v);
            pu4Var.setMessage(shareItem.w);
            pu4Var.setAutoNight(false);
            pu4Var.setCancelable(true);
            pu4Var.setTitleShowCenter(true);
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1164, new g(this, shareItem));
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f115f, new h(this)).create(w9.a(activity));
            pu4Var.show();
        }
    }

    public void T(ShareDialogConfig.From from) {
        a25 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !ej.isEmpty(sharePanelConfData.b())) {
            this.d.setText(sharePanelConfData.b());
        }
    }

    public final String z(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, shareItem)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(shareItem.v)) {
                sb.append("【");
                sb.append(shareItem.v);
                sb.append("】 ");
            }
            if (!TextUtils.isEmpty(shareItem.v)) {
                sb.append(shareItem.w);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void U(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || !O()) {
            return;
        }
        if (z) {
            if (i2 <= 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                this.r.f(i2);
            }
            this.r.setVisibility(0);
            return;
        }
        this.r.setVisibility(8);
    }

    public void g0(int i2, ShareItem shareItem, boolean z) {
        Location C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), shareItem, Boolean.valueOf(z)}) == null) {
            if (z && (C = C()) != null) {
                shareItem.F = C;
            }
            this.B.put(i2, shareItem);
        }
    }

    public final void j(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048611, this, i2, i3, i4, i5) == null) {
            p(i2, i3, SkinManager.getColor(R.color.CAM_X0107), i4, i5);
        }
    }

    public final void k(int i2, int i3, int i4, boolean z, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, 0, i4);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.a();
            MaskView.c(shareDialogItemView, z);
            this.e.b(i5, shareDialogItemView);
        }
    }

    public final void p(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, i4, i5);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            ShareScrollableLayout shareScrollableLayout = this.e;
            shareDialogItemView.a();
            shareScrollableLayout.b(i6, shareDialogItemView);
        }
    }

    public void m(View view2, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048617, this, view2, i2, onClickListener) == null) && i2 <= this.h.size() && i2 >= 0) {
            this.h.add(i2, view2);
            if (onClickListener != null) {
                view2.setOnClickListener(new i(this, onClickListener));
            }
        }
    }

    public final void o(AbsSvgType absSvgType, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048621, this, absSvgType, i2, i3) != null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
        shareDialogItemView.setItemIcon(absSvgType);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        ShareScrollableLayout shareScrollableLayout = this.e;
        shareDialogItemView.a();
        shareScrollableLayout.b(i3, shareDialogItemView);
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.I = false;
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                fj.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1172);
            } else if (!k35.m()) {
                fj.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0ee4);
            } else {
                if (this.e != null) {
                    s();
                } else {
                    q();
                }
                AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f100107).create();
                this.l = create;
                create.setCanceledOnTouchOutside(true);
                this.l.setOnDismissListener(new c(this));
                this.l.setOnCancelListener(new d(this));
                Context context = this.a;
                if (context instanceof Activity) {
                    jh.i(this.l, (Activity) context);
                }
                nv4 d2 = nv4.d(this.c);
                d2.n(R.string.J_X14);
                d2.f(R.color.CAM_X0204);
                Window window = this.l.getWindow();
                if (window == null) {
                    return;
                }
                if (this.H) {
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = fj.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f8);
                } else {
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003d0);
                }
                window.setGravity(80);
                k0(window);
                window.setContentView(this.b);
                window.setDimAmount(this.m);
                t();
                w();
                V();
                w9.a(this.a).registerListener(this.J);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public final void n(MetaData metaData, int i2, boolean z, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{metaData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(metaData.getAvater(), i2, metaData);
            String name_show = metaData.getName_show();
            if (oi5.d(metaData.getName_show()) > O) {
                name_show = oi5.l(name_show, O) + StringHelper.STRING_MORE;
            }
            shareDialogItemView.setItemName(name_show);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.setTag(R.id.obfuscated_res_0x7f090974, metaData);
            shareDialogItemView.a();
            MaskView.c(shareDialogItemView, z);
            this.e.b(i3, shareDialogItemView);
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (!L(this.K)) {
                l(R.string.obfuscated_res_0x7f0f119f, new SvgMaskType(R.drawable.obfuscated_res_0x7f080833));
            }
            if (!M(this.K)) {
                l(R.string.obfuscated_res_0x7f0f11a6, new SvgMaskType(R.drawable.obfuscated_res_0x7f08082f));
            }
            if (!I(this.K)) {
                l(R.string.obfuscated_res_0x7f0f117d, new SvgMaskType(R.drawable.obfuscated_res_0x7f080830));
            }
            if (!K(this.K)) {
                l(R.string.obfuscated_res_0x7f0f1181, new SvgMaskType(R.drawable.obfuscated_res_0x7f080831));
            }
            if (!N(this.K)) {
                l(R.string.obfuscated_res_0x7f0f118c, new SvgMaskType(R.drawable.obfuscated_res_0x7f080834));
            }
            if (P(this.K)) {
                i(R.string.obfuscated_res_0x7f0f1185, R.drawable.obfuscated_res_0x7f0809e9);
            }
            if (arrayList.size() > 0) {
                this.h.addAll(arrayList);
            }
            if (this.F) {
                i(R.string.obfuscated_res_0x7f0f1164, R.drawable.obfuscated_res_0x7f0809e6);
            }
        }
    }

    public final void o0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048622, this, i2, i3) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (TbadkCoreApplication.getCurrentAccount() != null && !N(this.K)) {
                k(R.string.obfuscated_res_0x7f0f1169, R.drawable.obfuscated_res_0x7f08088c, 24, false, i2);
            }
            if (!L(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080833), R.string.obfuscated_res_0x7f0f119f, i2);
            }
            if (!M(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f08082f), R.string.obfuscated_res_0x7f0f11a6, i2);
            }
            if (!I(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080830), R.string.obfuscated_res_0x7f0f117d, i2);
            }
            if (!K(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080831), R.string.obfuscated_res_0x7f0f1181, i2);
            }
            if (!N(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080834), R.string.obfuscated_res_0x7f0f118c, i2);
            }
            if (P(this.K)) {
                j(R.string.obfuscated_res_0x7f0f1185, R.drawable.obfuscated_res_0x7f0809e9, 17, i3);
            }
            if (arrayList.size() > 0 && arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    this.e.b(i3, (View) arrayList.get(i4));
                }
            }
            if (this.F) {
                j(R.string.obfuscated_res_0x7f0f1164, R.drawable.obfuscated_res_0x7f0809e6, 27, i3);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view2) == null) {
            this.I = true;
            int id = view2.getId();
            if (view2.getTag() != null) {
                i2 = ((Integer) view2.getTag()).intValue();
            } else {
                i2 = -1;
            }
            if (id != R.id.obfuscated_res_0x7f090428 && i2 != R.drawable.obfuscated_res_0x7f0809e6 && l0()) {
                this.C = false;
                return;
            }
            if (i2 != R.drawable.obfuscated_res_0x7f0809e9) {
                v();
            }
            if (this.B.size() == 0) {
                return;
            }
            if (id != R.id.obfuscated_res_0x7f090428 && this.C) {
                return;
            }
            this.C = true;
            ShareItem D = D(1);
            k35 k35Var = new k35(this.a, null);
            if (D != null && D.t0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_AI_APP_SHARE_CLICK).param("obj_id", D.u0).param("obj_type", D.v0).param("obj_source", D.w0));
                Bundle bundle = new Bundle();
                bundle.putInt("source", 16);
                D.k(bundle);
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem.param("obj_source", 25);
                TiebaStatic.log(statisticItem);
            }
            if (id == R.id.obfuscated_res_0x7f090428) {
                t0("share_cancel", new Object[0]);
                if (D != null && D.g) {
                    x0(D, 16);
                }
                DialogInterface.OnCancelListener onCancelListener = this.k;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(this.l);
                }
                if (D.m) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921696, 3));
                    return;
                }
                return;
            }
            if (D != null && D.r0) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem2.param("obj_source", 31);
                TiebaStatic.log(statisticItem2);
            }
            StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
            statisticItem3.param("obj_param1", this.u);
            if (i2 == R.drawable.obfuscated_res_0x7f080833) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    fj.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1172);
                    return;
                }
                t0("share_to_weixin", new Object[0]);
                u0(3);
                D = D(3);
                x0(D, 4);
                if (D != null) {
                    if (H(D) && D.a() != null && D.a().contains(3)) {
                        e35.f(D, this.a, 3, this.k);
                    } else if (D.p0 == 1) {
                        r0(D);
                    } else {
                        k35Var.s(D);
                    }
                }
                statisticItem3.param("obj_type", 2);
            } else if (i2 == R.drawable.obfuscated_res_0x7f08082f) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    fj.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1172);
                    return;
                }
                t0("share_to_pyq", new Object[0]);
                u0(2);
                D = D(2);
                x0(D, 3);
                if (D != null) {
                    if (H(D) && D.a() != null && D.a().contains(2)) {
                        e35.f(D, this.a, 2, this.k);
                    } else if (D.p0 == 1) {
                        r0(D);
                    } else {
                        if (D.b) {
                            D.w = "【" + D.v + "】 " + D.w;
                        }
                        k35Var.t(D);
                    }
                }
                statisticItem3.param("obj_type", 3);
            } else if (i2 == R.drawable.obfuscated_res_0x7f080831) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    fj.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1172);
                    return;
                }
                if (vm8.b(this.a, "com.tencent.mobileqq")) {
                    t0("share_to_qzone", new Object[0]);
                    u0(4);
                    D = D(4);
                    x0(D, 5);
                    if (D != null) {
                        if (H(D) && D.a() != null && D.a().contains(4)) {
                            e35.f(D, this.a, 4, this.k);
                        } else {
                            k35Var.o(D);
                        }
                    }
                } else {
                    Context context = this.a;
                    BdToast.b(context, context.getText(R.string.obfuscated_res_0x7f0f117e)).i();
                }
                statisticItem3.param("obj_type", 5);
            } else if (i2 == R.drawable.icon_qq_weibo) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    fj.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1172);
                    return;
                }
                t0("share_to_qweibo", new Object[0]);
                u0(5);
                D = D(5);
                if (D != null) {
                    if (!D.a) {
                        D.w = z(D);
                    }
                    k35Var.r(D);
                }
            } else if (i2 == R.drawable.obfuscated_res_0x7f080834) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    fj.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1172);
                    return;
                }
                t0("share_to_sweibo", new Object[0]);
                u0(6);
                D = D(6);
                x0(D, 7);
                if (D != null) {
                    if (!D.a) {
                        D.w = z(D);
                    }
                    if (H(D) && D.a() != null && D.a().contains(4)) {
                        e35.f(D, this.a, 6, this.k);
                    } else {
                        k35Var.q(D);
                    }
                }
                statisticItem3.param("obj_type", 6);
            } else if (i2 == R.drawable.icon_renren) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    fj.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1172);
                    return;
                }
                t0("share_to_renren", new Object[0]);
                u0(7);
                D = D(7);
                if (D != null) {
                    if (!D.a) {
                        D.w = z(D);
                    }
                    k35Var.p(D);
                }
            } else if (i2 == R.drawable.obfuscated_res_0x7f080830) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    fj.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1172);
                    return;
                }
                if (vm8.b(this.a, "com.tencent.mobileqq")) {
                    t0("share_to_qq_friend", new Object[0]);
                    u0(8);
                    D = D(8);
                    x0(D, 9);
                    if (D != null) {
                        if (H(D) && D.a() != null && D.a().contains(4)) {
                            e35.f(D, this.a, 8, this.k);
                        } else {
                            k35Var.n(D);
                        }
                    }
                } else {
                    Context context2 = this.a;
                    BdToast.b(context2, context2.getText(R.string.obfuscated_res_0x7f0f117e)).i();
                }
                statisticItem3.param("obj_type", 4);
            } else if (i2 == R.drawable.obfuscated_res_0x7f0809e9) {
                if (this.n == null) {
                    this.n = new PermissionJudgePolicy();
                }
                this.n.clearRequestPermissionList();
                this.n.appendRequestPermission((Activity) this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.n.startRequestPermission((Activity) this.a)) {
                    this.C = false;
                    return;
                }
                v();
                x0(D, 17);
                if (FileHelper.isLocalFile(D.z)) {
                    if (FileHelper.copyImageFile(FileHelper.getImageRealPathFromUri(this.a, D.z), UUID.randomUUID().toString().replace("-", "").toLowerCase(), this.a) == 0) {
                        fj.N(this.a, "保存成功！");
                    } else {
                        fj.N(this.a, "保存失败！");
                    }
                } else {
                    Uri uri = D.z;
                    if (uri == null) {
                        return;
                    }
                    String uri2 = uri.toString();
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity == null) {
                        return;
                    }
                    new InsertGalleryAsyncTask(currentActivity, uri2, new f(this)).execute(new String[0]);
                }
                statisticItem3.param("obj_type", 1);
            } else if (i2 == R.drawable.obfuscated_res_0x7f0809e6) {
                x0(D, 10);
                View.OnClickListener onClickListener = this.i;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                } else {
                    vi.a(D.x);
                    fj.N(this.a.getApplicationContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f045c));
                }
                v0(D);
                if (D != null && D.a) {
                    w0(8, D.G);
                }
                statisticItem3.param("obj_type", 8);
            } else if (i2 == 25) {
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f090974);
                Context context3 = this.a;
                if (context3 != null && (shareItem = this.A) != null && shareItem.g0 != null && (tag instanceof MetaData)) {
                    if (ra7.a(context3)) {
                        return;
                    }
                    MetaData metaData = (MetaData) tag;
                    S(metaData.getUserId());
                    cc7 cc7Var = new cc7(this.a);
                    cc7Var.n(this.A.g0, metaData);
                    cc7Var.p();
                }
            } else if (i2 == 24) {
                Q();
                R();
            } else if (i2 == 28) {
                Q();
            }
            statisticItem3.param("obj_source", 6);
            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (D != null) {
                statisticItem3.param("fid", D.u);
                statisticItem3.param("fname", D.t);
            }
            TiebaStatic.log(statisticItem3);
        }
    }

    public final void p0(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048625, this, i2, i3, i4) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            int size = this.y.size();
            if (size < N) {
                for (int i5 = 0; i5 < size; i5++) {
                    n((MetaData) this.y.get(i5), 25, false, i2);
                }
            } else {
                for (int i6 = 0; i6 < N; i6++) {
                    n((MetaData) this.y.get(i6), 25, false, i2);
                }
            }
            this.e.a(i2);
            if (size >= N) {
                j(R.string.obfuscated_res_0x7f0f0b10, R.drawable.obfuscated_res_0x7f080a90, 28, i2);
            }
            k(R.string.obfuscated_res_0x7f0f1169, R.drawable.obfuscated_res_0x7f08088c, 24, false, i3);
            if (!L(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080833), R.string.obfuscated_res_0x7f0f119f, i3);
            }
            if (!M(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f08082f), R.string.obfuscated_res_0x7f0f11a6, i3);
            }
            if (!I(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080830), R.string.obfuscated_res_0x7f0f117d, i3);
            }
            if (!K(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080831), R.string.obfuscated_res_0x7f0f1181, i3);
            }
            if (!N(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080834), R.string.obfuscated_res_0x7f0f118c, i3);
            }
            if (P(this.K)) {
                j(R.string.obfuscated_res_0x7f0f1185, R.drawable.obfuscated_res_0x7f0809e9, 26, i4);
            }
            if (arrayList.size() > 0) {
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    this.e.b(i4, (View) arrayList.get(i7));
                }
            }
            if (this.F) {
                j(R.string.obfuscated_res_0x7f0f1164, R.drawable.obfuscated_res_0x7f0809e6, 27, i4);
            }
        }
    }

    public final void q0(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (TbadkCoreApplication.getCurrentAccount() != null && !z) {
                k(R.string.obfuscated_res_0x7f0f1169, R.drawable.obfuscated_res_0x7f08088c, 24, false, i2);
            }
            if (!L(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080833), R.string.obfuscated_res_0x7f0f119f, i2);
            }
            if (!M(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f08082f), R.string.obfuscated_res_0x7f0f11a6, i2);
            }
            if (!I(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080830), R.string.obfuscated_res_0x7f0f117d, i2);
            }
            if (!K(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080831), R.string.obfuscated_res_0x7f0f1181, i2);
            }
            if (!N(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080834), R.string.obfuscated_res_0x7f0f118c, i2);
            }
            if (P(this.K)) {
                j(R.string.obfuscated_res_0x7f0f1185, R.drawable.obfuscated_res_0x7f0809e9, 17, i3);
            }
            if (arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    this.e.b(i3, (View) arrayList.get(i4));
                }
            }
            if (this.F) {
                i(R.string.obfuscated_res_0x7f0f1164, R.drawable.obfuscated_res_0x7f0809e6);
            }
        }
    }

    public final void x0(ShareItem shareItem, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048641, this, shareItem, i2) != null) || shareItem == null) {
            return;
        }
        if (shareItem.u == null) {
            if (shareItem.j) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2).param("obj_source", shareItem.I));
            }
        } else if (shareItem.b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.u).param("obj_type", i2).param("obj_source", shareItem.I).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.K));
        } else if (!shareItem.c && !shareItem.f) {
            if (shareItem.d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.u).param("obj_type", i2));
            } else if (shareItem.a) {
                w0(i2, shareItem.G);
            } else if (shareItem.e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.u).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.K));
            } else if (shareItem.g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                param.param("obj_source", shareItem.I);
                if (!ej.isEmpty(shareItem.x)) {
                    if (shareItem.x.contains("worldcup")) {
                        param.param("obj_param1", 9);
                    }
                    param.param(TiebaStatic.Params.OBJ_URL, shareItem.x);
                }
                TiebaStatic.log(param);
            } else if (shareItem.i) {
                if (i2 == 3) {
                    str = "1";
                } else if (i2 == 4) {
                    str = "2";
                } else if (i2 == 9) {
                    str = "4";
                } else if (i2 == 5) {
                    str = "3";
                } else if (i2 == 7) {
                    str = "5";
                } else {
                    str = "6";
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_TOPIC_DETAIL).param("obj_locate", str).param("topic_id", shareItem.u));
            } else if (shareItem.k) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem.param("tid", shareItem.u);
                statisticItem.param("post_id", shareItem.c0);
                statisticItem.param("obj_source", 18);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.K);
                TiebaStatic.log(statisticItem);
            } else if (shareItem.l) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_GAME_DETIAL);
                statisticItem2.param("obj_type", i2);
                statisticItem2.param("obj_name", shareItem.v);
                TiebaStatic.log(statisticItem2);
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem3.param("obj_source", 19);
                TiebaStatic.log(statisticItem3);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.u).param("obj_type", i2).param("obj_source", shareItem.I).param("obj_param1", shareItem.J).param("fid", shareItem.N).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.K));
        }
    }
}
