package com.baidu.tieba;

import android.annotation.SuppressLint;
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
import androidx.annotation.NonNull;
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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.GreyUtil;
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
import com.baidu.tieba.d05;
import com.baidu.tieba.im.data.GroupInfoData;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes4.dex */
public class ff9 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int J;
    public static final int K;
    public static h L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public SparseArray<String> B;
    public SparseArray<y85> C;
    public boolean D;
    public int E;
    public boolean F;
    public boolean G;
    public CustomMessageListener H;
    public int I;
    public final Context a;
    public final View b;
    public final View c;
    public final TextView d;
    public ShareScrollableLayout e;
    public ShareGridLayout f;
    public final EMTextView g;
    public final List<View> h;
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
    public List<MetaData> v;
    public final y18 w;
    public InsertGalleryAsyncTask x;
    public ShareItem y;
    public final SparseArray<ShareItem> z;

    public final boolean K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? (i2 & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? (i2 & 4) > 0 : invokeI.booleanValue;
    }

    public final boolean N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? (i2 & 1) > 0 : invokeI.booleanValue;
    }

    public final boolean O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? (i2 & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean P(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? (i2 & 16) > 0 : invokeI.booleanValue;
    }

    public final boolean R(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? (i2 & 32) > 0 : invokeI.booleanValue;
    }

    public void Z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
        }
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public static class h extends CustomMessageTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<ff9> a;

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                InterceptResult invokeL;
                ff9 ff9Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    WeakReference<ff9> weakReference = this.a.a;
                    if (weakReference != null && (ff9Var = weakReference.get()) != null && ff9Var.l != null && ff9Var.l.isShowing()) {
                        ff9Var.y();
                        return null;
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h() {
            super(2001277, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Integer) objArr[0]).intValue(), (CustomMessageTask.CustomRunnable) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRunnable = new a(this);
            setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        }

        public void a(ff9 ff9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ff9Var) == null) {
                WeakReference<ff9> weakReference = this.a;
                if (weakReference != null) {
                    weakReference.clear();
                    this.a = null;
                }
                if (ff9Var == null) {
                    return;
                }
                this.a = new WeakReference<>(ff9Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ff9 ff9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff9Var, Integer.valueOf(i)};
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
            this.a = ff9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.a.u();
            if (this.a.e != null) {
                this.a.e.removeAllViews();
            } else {
                this.a.f.removeAllViews();
            }
            if (this.a.e != null) {
                this.a.t();
            } else {
                this.a.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff9 a;

        public b(ff9 ff9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ff9Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.j != null) {
                    this.a.j.onDismiss(dialogInterface);
                }
                if (this.a.x != null) {
                    this.a.x.cancel();
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
                if (this.a.E(1).m && !this.a.G) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921696, 3));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff9 a;

        public c(ff9 ff9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ff9Var;
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
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ ff9 b;

        public d(ff9 ff9Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff9Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ff9Var;
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
    public class e extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff9 a;

        public e(ff9 ff9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ff9Var;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                ii.Q(this.a.a, "保存成功！");
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                ii.Q(this.a.a, "保存失败！");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ ff9 b;

        public f(ff9 ff9Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff9Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ff9Var;
            this.a = shareItem;
        }

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                yh.a(this.a.w);
                ii.P(this.b.a.getApplicationContext(), R.string.copy_success);
                d05Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(ff9 ff9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.d05.e
        public void onClick(d05 d05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                d05Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;
        public final /* synthetic */ ff9 b;

        public i(ff9 ff9Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff9Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ff9Var;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.y();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947762352, "Lcom/baidu/tieba/ff9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947762352, "Lcom/baidu/tieba/ff9;");
                return;
            }
        }
        J = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        K = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
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

    public void y() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && (alertDialog = this.l) != null) {
            this.A = false;
            if (this.a instanceof Activity) {
                DialogInterface.OnDismissListener onDismissListener = this.j;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(alertDialog);
                }
                lg.a(this.l, (Activity) this.a);
                MessageManager.getInstance().unRegisterListener(this.H);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            if (this.t) {
                this.d.setVisibility(8);
                if (Q()) {
                    this.o.setVisibility(0);
                    return;
                }
                return;
            }
            this.d.setVisibility(0);
            if (Q()) {
                this.o.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ff9(Context context) {
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

    public final void x0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048639, this, i2) == null) && i2 <= 8 && i2 > 0) {
            this.A = true;
            SparseArray<y85> sparseArray = this.C;
            if (sparseArray != null) {
                y85 y85Var = sparseArray.get(i2);
                if (!StringUtils.isNull(y85Var.b()) && y85Var.a() != null && y85Var.a().size() > 0) {
                    w0(y85Var.b(), y85Var.a());
                    return;
                }
            }
            SparseArray<String> sparseArray2 = this.B;
            if (sparseArray2 != null) {
                String str = sparseArray2.get(i2);
                if (!hi.isEmpty(str)) {
                    w0(str, new Object[0]);
                }
            }
        }
    }

    public final void y0(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
            int i2 = shareItem.J;
            if (i2 != 0) {
                param.param("obj_param1", i2);
                int i3 = shareItem.J;
                if (i3 == 2) {
                    param.param("fid", shareItem.N);
                } else if (i3 == 3) {
                    int i4 = shareItem.R;
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

    @SuppressLint({"ResourceType"})
    public ff9(Context context, boolean z, int i2) {
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
        this.v = new ArrayList();
        this.w = new y18();
        this.z = new SparseArray<>(8);
        this.A = false;
        this.D = true;
        this.E = 1;
        this.F = true;
        this.H = new a(this, 2001304);
        this.I = 0;
        this.I = i2;
        this.a = context;
        this.h = new ArrayList();
        View D = D();
        this.b = D;
        this.c = D.findViewById(R.id.obfuscated_res_0x7f092038);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092039);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.d.setText(sharePanelText);
        }
        ShareScrollableLayout shareScrollableLayout = (ShareScrollableLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09205a);
        this.e = shareScrollableLayout;
        if (shareScrollableLayout == null) {
            ShareGridLayout shareGridLayout = (ShareGridLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09203d);
            this.f = shareGridLayout;
            ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i5 = ShareGridLayout.f;
                marginLayoutParams.leftMargin = i5;
                marginLayoutParams.rightMargin = i5;
                this.f.setLayoutParams(marginLayoutParams);
            }
            this.f.setItemParams(J, K);
        } else {
            shareScrollableLayout.setItemParams(J, K);
        }
        EMTextView eMTextView = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f09047b);
        this.g = eMTextView;
        eMTextView.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090cd1);
        this.o = relativeLayout;
        if (relativeLayout != null) {
            this.p = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091b27);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091b26);
            this.q = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f0f56);
            MessageRedDotView messageRedDotView = (MessageRedDotView) this.b.findViewById(R.id.obfuscated_res_0x7f091b29);
            this.r = messageRedDotView;
            messageRedDotView.setExtendSize(ii.g(context, R.dimen.tbds5));
            this.r.setTextSize(R.dimen.T_X09);
            this.r.setTextBold(true);
            this.s = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091b28);
        }
    }

    public ShareItem E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            ShareItem shareItem = this.z.get(i2);
            if (shareItem == null) {
                return this.z.get(1);
            }
            return shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public ShareItem G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            ShareItem shareItem = this.z.get(i2);
            if (shareItem == null) {
                return this.z.get(1);
            }
            return shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void H(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onDismissListener) == null) && onDismissListener != null) {
            this.j = onDismissListener;
        }
    }

    public final boolean J(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, shareItem)) == null) {
            if (!TextUtils.isEmpty(shareItem.D0) && !TextUtils.isEmpty(shareItem.E0)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void Y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) && onClickListener != null) {
            this.i = onClickListener;
        }
    }

    public void a0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.u = str;
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.D = z;
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.t = z;
        }
    }

    public void d0(SparseArray<String> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, sparseArray) == null) {
            this.B = sparseArray;
        }
    }

    public void e0(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onCancelListener) == null) {
            this.k = onCancelListener;
        }
    }

    public void f0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, onClickListener) != null) || !Q()) {
            return;
        }
        this.o.setOnClickListener(new d(this, onClickListener));
    }

    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.E = i2;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.F = z;
        }
    }

    public void l0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, window) == null) {
            window.setLayout(-1, -2);
        }
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<View> list = this.h;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ShareItem shareItem = this.y;
            if (!shareItem.g || shareItem.p) {
                ShareItem shareItem2 = this.y;
                if (!shareItem2.i && !shareItem2.m && !shareItem2.w0 && !shareItem2.o) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0225, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final Location F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return ck6.b();
        }
        return (Location) invokeV.objValue;
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.o != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (L == null) {
                L = new h();
            }
            L.a(this);
            MessageManager.getInstance().registerTask(L);
        }
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.E == 2 && x()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void A0(ShareItem shareItem, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareItem, i2) != null) || shareItem == null) {
            return;
        }
        if (GroupInfoData.isValidGroup(shareItem.L0)) {
            shareItem.N0 = i2;
            x18.a(shareItem.L0, null, i2);
        } else if (shareItem.u == null) {
            if (shareItem.j) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2).param("obj_source", shareItem.I));
            }
        } else if (shareItem.b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.u).param("obj_type", i2).param("obj_source", shareItem.I).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.K));
        } else if (!shareItem.c && !shareItem.f) {
            if (shareItem.d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.u).param("obj_type", i2));
            } else if (shareItem.a) {
                z0(i2, shareItem.G);
            } else if (shareItem.e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.u).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.K));
            } else if (shareItem.g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                param.param("obj_source", shareItem.I);
                if (!hi.isEmpty(shareItem.x)) {
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
                statisticItem.param("post_id", shareItem.f0);
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

    public final String B(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem)) == null) {
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

    public void V(ShareDialogConfig.From from) {
        x85 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !hi.isEmpty(sharePanelConfData.b())) {
            this.d.setText(sharePanelConfData.b());
        }
    }

    public LinearLayout I(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.a();
            return shareDialogItemView;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public void g0(ShareItem shareItem, boolean z) {
        Location F;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, shareItem, z) == null) {
            this.y = shareItem;
            if (z && (F = F()) != null) {
                shareItem.F = F;
            }
            this.z.put(1, shareItem);
            if (!StringUtils.isNull(shareItem.r)) {
                this.d.setText(shareItem.r);
            }
        }
    }

    public void j(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048611, this, i2, i3) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            List<View> list = this.h;
            shareDialogItemView.a();
            list.add(shareDialogItemView);
        }
    }

    public void m(int i2, AbsSvgType absSvgType) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048617, this, i2, absSvgType) != null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
        shareDialogItemView.setItemIcon(absSvgType);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        List<View> list = this.h;
        shareDialogItemView.a();
        list.add(shareDialogItemView);
    }

    public final void w0(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048637, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.a, str, "click", 1, objArr);
        }
    }

    public final void z0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048643, this, i2, str) == null) {
            TiebaStatic.eventStat(this.a, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void S() {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (GroupInfoData.isValidGroup(this.y.L0)) {
                obj = this.y.L0;
            } else {
                obj = this.y.j0;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921694, obj);
            MessageManager.getInstance().registerStickyMode(2921694);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(this.a);
            shareFriendActivityConfig.setIsForShare(true);
            shareFriendActivityConfig.setFilterGroup(this.y.M0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.v = this.w.b();
            boolean C = C();
            List<MetaData> list = this.v;
            if (list != null && list.size() != 0 && !P(this.I) && TbadkCoreApplication.getCurrentAccount() != null && !C) {
                s0(0, 1, 2);
            } else if (C) {
                this.e.setItemParams(ii.l(this.a) / 5, K);
                t0(0, 1, C);
            } else {
                r0(0, 1);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048628, this) != null) || v0()) {
            return;
        }
        q0();
        if (!ja5.l()) {
            this.f.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.f.addView(this.h.get(i2), new ViewGroup.LayoutParams(J, K));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048630, this) != null) || v0()) {
            return;
        }
        q0();
        if (!ja5.l()) {
            this.f.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.f.addView(this.h.get(i2), new ViewGroup.LayoutParams(J, K));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048632, this) != null) || v0()) {
            return;
        }
        j0();
        if (!ja5.l()) {
            this.e.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.e.addView(this.h.get(i2), new ViewGroup.LayoutParams(J, K));
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_FRIEND_BTN);
            int i2 = this.y.I;
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

    @SuppressLint({"ResourceAsColor"})
    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            r25 d2 = r25.d(this.c);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColorSelector(this.g, R.color.CAM_X0107);
            if (Q()) {
                r25 d3 = r25.d(this.o);
                d3.o(R.string.J_X05);
                d3.f(R.color.CAM_X0201);
                this.p.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
                r25 d4 = r25.d(this.q);
                d4.C(R.string.F_X01);
                d4.w(R.color.CAM_X0105);
            }
        }
    }

    public final void U(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, metaData) != null) || metaData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_NEARLY_PERSON);
        int i2 = 0;
        int i3 = this.y.I;
        if (i3 != 4 && i3 != 3 && i3 != 20 && i3 != 30) {
            if (i3 != 5 && i3 != 10 && i3 != 33) {
                if (i3 != 6 && i3 != 2) {
                    if (i3 == 8) {
                        i2 = 4;
                    } else if (i3 == 25 || i3 == 29 || i3 == 11 || i3 == 12) {
                        i2 = 5;
                    }
                } else {
                    i2 = 3;
                }
            } else {
                i2 = 2;
            }
        } else {
            i2 = 1;
        }
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_source", i2);
        if (GroupInfoData.isValidGroup(metaData.groupData)) {
            statisticItem.addParam("room_id", metaData.groupData.getGroupId());
            statisticItem.addParam("fid", metaData.groupData.getForumId());
            statisticItem.addParam("fname", metaData.groupData.getForumName());
        } else {
            statisticItem.addParam(TiebaStatic.Params.FRIEND_UID, metaData.getUserId());
        }
        TiebaStatic.log(statisticItem);
    }

    public void W(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || !Q()) {
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

    public void h0(int i2, ShareItem shareItem, boolean z) {
        Location F;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), shareItem, Boolean.valueOf(z)}) == null) {
            if (z && (F = F()) != null) {
                shareItem.F = F;
            }
            this.z.put(i2, shareItem);
        }
    }

    public final void k(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048613, this, i2, i3, i4, i5) == null) {
            q(i2, i3, SkinManager.getColor(R.color.CAM_X0107), i4, i5);
        }
    }

    public final void l(int i2, int i3, int i4, boolean z, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, 0, i4);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.a();
            MaskView.c(shareDialogItemView, z);
            this.e.b(i5, shareDialogItemView);
        }
    }

    public final void q(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, i4, i5);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            ShareScrollableLayout shareScrollableLayout = this.e;
            shareDialogItemView.a();
            shareScrollableLayout.b(i6, shareDialogItemView);
        }
    }

    public final void m0(@NonNull MetaData metaData, @NonNull ForumData forumData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048618, this, metaData, forumData) != null) || wz7.a(this.a)) {
            return;
        }
        Context context = this.a;
        f18 f18Var = new f18(context, new h18(context));
        U(metaData);
        f18Var.j(forumData, metaData);
        b28.a("分享弹窗触发分享：分享成功");
        f18Var.k();
    }

    public final void n0(@NonNull MetaData metaData, @NonNull GroupInfoData groupInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048620, this, metaData, groupInfoData) != null) || wz7.a(this.a)) {
            return;
        }
        Context context = this.a;
        f18 f18Var = new f18(context, new i18(context));
        x18.a(groupInfoData, metaData, 1);
        f18Var.j(groupInfoData, metaData);
        b28.a("分享弹窗触发分享：分享成功");
        f18Var.k();
    }

    public void n(View view2, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048619, this, view2, i2, onClickListener) == null) && i2 <= this.h.size() && i2 >= 0) {
            this.h.add(i2, view2);
            if (onClickListener != null) {
                view2.setOnClickListener(new i(this, onClickListener));
            }
        }
    }

    public final void p(AbsSvgType absSvgType, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048624, this, absSvgType, i2, i3) != null) || absSvgType == null) {
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

    public final void o(@NonNull MetaData metaData, int i2, boolean z, int i3) {
        String avater;
        String name_show;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{metaData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            if (GroupInfoData.isValidGroup(metaData.groupData)) {
                avater = metaData.groupData.getPortrait();
                name_show = metaData.groupData.getName();
            } else {
                avater = metaData.getAvater();
                name_show = metaData.getName_show();
            }
            if (kr5.e(name_show) > 8) {
                name_show = kr5.m(name_show, 8) + StringHelper.STRING_MORE;
            }
            shareDialogItemView.setItemIcon(avater, i2, metaData);
            shareDialogItemView.setItemName(name_show);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.setTag(R.id.obfuscated_res_0x7f090a59, metaData);
            shareDialogItemView.a();
            MaskView.c(shareDialogItemView, z);
            this.e.b(i3, shareDialogItemView);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view2) == null) {
            this.G = true;
            int id = view2.getId();
            if (view2.getTag() != null) {
                i2 = ((Integer) view2.getTag()).intValue();
            } else {
                i2 = -1;
            }
            if (id != R.id.obfuscated_res_0x7f09047b && i2 != R.drawable.icon_pure_share_copy40 && o0()) {
                this.A = false;
                return;
            }
            if (i2 != R.drawable.icon_pure_share_download40) {
                y();
            }
            if (this.z.size() == 0) {
                return;
            }
            if (id != R.id.obfuscated_res_0x7f09047b && this.A) {
                return;
            }
            this.A = true;
            ShareItem G = G(1);
            ja5 ja5Var = new ja5(this.a, null);
            if (G != null && G.w0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_AI_APP_SHARE_CLICK).param("obj_id", G.x0).param("obj_type", G.y0).param("obj_source", G.z0));
                Bundle bundle = new Bundle();
                bundle.putInt("source", 16);
                G.l(bundle);
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem.param("obj_source", 25);
                TiebaStatic.log(statisticItem);
            }
            if (id == R.id.obfuscated_res_0x7f09047b) {
                w0("share_cancel", new Object[0]);
                if (G != null && G.g) {
                    A0(G, 16);
                }
                DialogInterface.OnCancelListener onCancelListener = this.k;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(this.l);
                }
                if (G.m) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921696, 3));
                    return;
                }
                return;
            }
            if (G != null && G.u0) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem2.param("obj_source", 31);
                TiebaStatic.log(statisticItem2);
            }
            StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
            statisticItem3.param("obj_param1", this.u);
            if (i2 == R.drawable.icon_mask_share_wechat40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    ii.P(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                w0("share_to_weixin", new Object[0]);
                x0(3);
                G = G(3);
                A0(G, 4);
                if (G != null) {
                    if (J(G) && G.b() != null && G.b().contains(3)) {
                        da5.f(G, this.a, 3, this.k);
                    } else if (G.s0 == 1) {
                        u0(G);
                    } else {
                        ja5Var.r(G);
                    }
                }
                statisticItem3.param("obj_type", 2);
            } else if (i2 == R.drawable.icon_mask_share_circle40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    ii.P(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                w0("share_to_pyq", new Object[0]);
                x0(2);
                G = G(2);
                A0(G, 3);
                if (G != null) {
                    if (J(G) && G.b() != null && G.b().contains(2)) {
                        da5.f(G, this.a, 2, this.k);
                    } else if (G.s0 == 1) {
                        u0(G);
                    } else {
                        if (G.b) {
                            G.w = "【" + G.v + "】 " + G.w;
                        }
                        ja5Var.s(G);
                    }
                }
                statisticItem3.param("obj_type", 3);
            } else if (i2 == R.drawable.icon_mask_share_qqzone40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    ii.P(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                if (el9.b(this.a, "com.tencent.mobileqq")) {
                    w0("share_to_qzone", new Object[0]);
                    x0(4);
                    G = G(4);
                    A0(G, 5);
                    if (G != null) {
                        if (J(G) && G.b() != null && G.b().contains(4)) {
                            da5.f(G, this.a, 4, this.k);
                        } else {
                            ja5Var.n(G);
                        }
                    }
                } else {
                    Context context = this.a;
                    BdToast.b(context, context.getText(R.string.share_qq_not_install)).o();
                }
                statisticItem3.param("obj_type", 5);
            } else if (i2 == R.drawable.icon_qq_weibo) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    ii.P(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                w0("share_to_qweibo", new Object[0]);
                x0(5);
                G = G(5);
                if (G != null) {
                    if (!G.a) {
                        G.w = B(G);
                    }
                    ja5Var.q(G);
                }
            } else if (i2 == R.drawable.icon_mask_share_weibo40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    ii.P(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                w0("share_to_sweibo", new Object[0]);
                x0(6);
                G = G(6);
                A0(G, 7);
                if (G != null) {
                    if (!G.a) {
                        G.w = B(G);
                    }
                    if (J(G) && G.b() != null && G.b().contains(4)) {
                        da5.f(G, this.a, 6, this.k);
                    } else {
                        ja5Var.p(G);
                    }
                }
                statisticItem3.param("obj_type", 6);
            } else if (i2 == R.drawable.icon_renren) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    ii.P(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                w0("share_to_renren", new Object[0]);
                x0(7);
                G = G(7);
                if (G != null) {
                    if (!G.a) {
                        G.w = B(G);
                    }
                    ja5Var.o(G);
                }
            } else if (i2 == R.drawable.icon_mask_share_qq40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    ii.P(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                    return;
                }
                if (el9.b(this.a, "com.tencent.mobileqq")) {
                    w0("share_to_qq_friend", new Object[0]);
                    x0(8);
                    G = G(8);
                    A0(G, 9);
                    if (G != null) {
                        if (J(G) && G.b() != null && G.b().contains(4)) {
                            da5.f(G, this.a, 8, this.k);
                        } else {
                            ja5Var.m(G);
                        }
                    }
                } else {
                    Context context2 = this.a;
                    BdToast.b(context2, context2.getText(R.string.share_qq_not_install)).o();
                }
                statisticItem3.param("obj_type", 4);
            } else if (i2 == R.drawable.icon_pure_share_download40) {
                if (this.n == null) {
                    this.n = new PermissionJudgePolicy();
                }
                this.n.clearRequestPermissionList();
                this.n.appendRequestPermission((Activity) this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.n.startRequestPermission((Activity) this.a)) {
                    this.A = false;
                    return;
                }
                y();
                A0(G, 17);
                if (FileHelper.isLocalFile(G.z)) {
                    if (FileHelper.copyImageFile(FileHelper.getImageRealPathFromUri(this.a, G.z), UUID.randomUUID().toString().replace("-", "").toLowerCase(), this.a) == 0) {
                        ii.Q(this.a, "保存成功！");
                    } else {
                        ii.Q(this.a, "保存失败！");
                    }
                } else {
                    Uri uri = G.z;
                    if (uri == null) {
                        return;
                    }
                    String uri2 = uri.toString();
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity == null) {
                        return;
                    }
                    InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(currentActivity, uri2, new e(this));
                    this.x = insertGalleryAsyncTask;
                    insertGalleryAsyncTask.execute(new String[0]);
                }
                statisticItem3.param("obj_type", 1);
            } else if (i2 != R.drawable.icon_pure_share_copy40 && i2 != 27) {
                if (i2 == 25) {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090a59);
                    if (this.a != null && (shareItem = this.y) != null && (tag instanceof MetaData)) {
                        ForumData forumData = shareItem.j0;
                        if (forumData != null) {
                            m0((MetaData) tag, forumData);
                        } else if (GroupInfoData.isValidGroup(shareItem.L0)) {
                            ShareItem shareItem2 = this.y;
                            shareItem2.N0 = 24;
                            n0((MetaData) tag, shareItem2.L0);
                        }
                    }
                } else if (i2 == 24) {
                    S();
                    T();
                    if (G != null) {
                        G.N0 = 24;
                        x18.a(G.L0, null, 24);
                    }
                } else if (i2 == 28) {
                    S();
                    if (G != null) {
                        G.N0 = 28;
                        x18.a(G.L0, null, 28);
                    }
                }
            } else {
                A0(G, 10);
                View.OnClickListener onClickListener = this.i;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                } else {
                    yh.a(G.x);
                    ii.Q(this.a.getApplicationContext(), this.a.getResources().getString(R.string.copy_pb_url_success));
                }
                y0(G);
                if (G != null && G.a) {
                    z0(8, G.G);
                }
                statisticItem3.param("obj_type", 8);
            }
            statisticItem3.param("obj_source", 6);
            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (G != null) {
                statisticItem3.param("fid", G.u);
                statisticItem3.param("fname", G.t);
            }
            TiebaStatic.log(statisticItem3);
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.G = false;
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ii.P(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (!ja5.l()) {
                ii.P(TbadkCoreApplication.getInst().getContext(), R.string.plugin_share_install_failure);
            } else {
                if (this.e != null) {
                    t();
                } else {
                    r();
                }
                AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f100108).create();
                this.l = create;
                create.setCanceledOnTouchOutside(true);
                this.l.setOnDismissListener(new b(this));
                this.l.setOnCancelListener(new c(this));
                Context context = this.a;
                if (context instanceof Activity) {
                    lg.i(this.l, (Activity) context);
                }
                r25 d2 = r25.d(this.c);
                d2.o(R.string.J_X14);
                d2.f(R.color.CAM_X0204);
                Window window = this.l.getWindow();
                if (window == null) {
                    return;
                }
                if (this.F) {
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = ii.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f100404);
                } else {
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003db);
                }
                window.setGravity(80);
                l0(window);
                window.setContentView(this.b);
                window.setDimAmount(this.m);
                u();
                z();
                X();
                g9.a(this.a).registerListener(this.H);
                GreyUtil.grey(window);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (!N(this.I)) {
                m(R.string.share_weixin, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
            }
            if (!O(this.I)) {
                m(R.string.share_weixin_timeline, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
            }
            if (!K(this.I)) {
                m(R.string.share_qq_friends, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
            }
            if (!M(this.I)) {
                m(R.string.share_qzone, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
            }
            if (!P(this.I)) {
                m(R.string.share_sina_weibo, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
            }
            if (R(this.I)) {
                j(R.string.share_save_pic, R.drawable.icon_pure_share_download40);
            }
            if (arrayList.size() > 0) {
                this.h.addAll(arrayList);
            }
            if (this.D) {
                j(R.string.share_copy, R.drawable.icon_pure_share_copy40);
            }
        }
    }

    public final void r0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048629, this, i2, i3) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (TbadkCoreApplication.getCurrentAccount() != null && !P(this.I)) {
                l(R.string.share_friend, R.drawable.icon_more_share2, 24, false, i2);
            }
            if (!N(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, i2);
            }
            if (!O(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, i2);
            }
            if (!K(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, i2);
            }
            if (!M(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, i2);
            }
            if (!P(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, i2);
            }
            if (R(this.I)) {
                k(R.string.share_save_pic, R.drawable.icon_pure_share_download40, 17, i3);
            }
            if (arrayList.size() > 0 && arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    this.e.b(i3, (View) arrayList.get(i4));
                }
            }
            if (this.D) {
                k(R.string.share_copy, R.drawable.icon_pure_share_copy40, 27, i3);
            }
        }
    }

    public final void s0(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048631, this, i2, i3, i4) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            int size = this.v.size();
            if (size < 10) {
                for (int i5 = 0; i5 < size; i5++) {
                    o(this.v.get(i5), 25, false, i2);
                }
            } else {
                for (int i6 = 0; i6 < 10; i6++) {
                    o(this.v.get(i6), 25, false, i2);
                }
            }
            this.e.a(i2);
            if (size >= 10) {
                k(R.string.more_friend, R.drawable.icon_share_morefriends, 28, i2);
            }
            l(R.string.share_friend, R.drawable.icon_more_share2, 24, false, i3);
            if (!N(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, i3);
            }
            if (!O(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, i3);
            }
            if (!K(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, i3);
            }
            if (!M(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, i3);
            }
            if (!P(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, i3);
            }
            if (R(this.I)) {
                k(R.string.share_save_pic, R.drawable.icon_pure_share_download40, 26, i4);
            }
            if (arrayList.size() > 0) {
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    this.e.b(i4, (View) arrayList.get(i7));
                }
            }
            if (this.D) {
                k(R.string.share_copy, R.drawable.icon_pure_share_copy40, 27, i4);
            }
        }
    }

    public final void t0(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (TbadkCoreApplication.getCurrentAccount() != null && !z) {
                l(R.string.share_friend, R.drawable.icon_more_share2, 24, false, i2);
            }
            if (!N(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, i2);
            }
            if (!O(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, i2);
            }
            if (!K(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, i2);
            }
            if (!M(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, i2);
            }
            if (!P(this.I)) {
                p(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, i2);
            }
            if (R(this.I)) {
                k(R.string.share_save_pic, R.drawable.icon_pure_share_download40, 17, i3);
            }
            if (arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    this.e.b(i3, (View) arrayList.get(i4));
                }
            }
            if (this.D) {
                j(R.string.share_copy, R.drawable.icon_pure_share_copy40);
            }
        }
    }

    public final void u0(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, shareItem) == null) && shareItem != null && !TextUtils.isEmpty(shareItem.w) && !TextUtils.isEmpty(shareItem.v)) {
            Context context = this.a;
            if (!(context instanceof Activity)) {
                return;
            }
            Activity activity = (Activity) context;
            d05 d05Var = new d05(activity);
            d05Var.setTitle(shareItem.v);
            d05Var.setMessage(shareItem.w);
            d05Var.setAutoNight(false);
            d05Var.setCancelable(true);
            d05Var.setTitleShowCenter(true);
            d05Var.setPositiveButton(R.string.share_copy, new f(this, shareItem));
            d05Var.setNegativeButton(R.string.share_cancel, new g(this)).create(g9.a(activity));
            d05Var.show();
        }
    }
}
