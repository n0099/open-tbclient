package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class bk8 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final View b;
    public final TextView c;
    public final TextView d;
    public ShareGridLayout e;
    public final List<View> f;
    public View.OnClickListener g;
    public DialogInterface.OnDismissListener h;
    public AlertDialog i;
    public final SparseArray<ShareItem> j;
    public boolean k;
    public SparseArray<String> l;
    public SparseArray<z25> m;

    @SuppressLint({"ResourceAsColor"})
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public final boolean n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? (i & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) ? (i & 1) > 0 : invokeI.booleanValue;
    }

    public final boolean p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) ? (i & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) ? (i & 16) > 0 : invokeI.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class a implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk8 a;

        public a(bk8 bk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bk8Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.a.i != null && this.a.i.isShowing()) {
                    this.a.f();
                    return null;
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk8 a;

        public b(bk8 bk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bk8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.h != null) {
                    this.a.h.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;
        public final /* synthetic */ bk8 b;

        public c(bk8 bk8Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk8Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bk8Var;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.f();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947647962, "Lcom/baidu/tieba/bk8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947647962, "Lcom/baidu/tieba/bk8;");
                return;
            }
        }
        n = (int) ((yi.l(TbadkCoreApplication.getInst()) - (yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) * 0.2d);
        o = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds234);
        p = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        q = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
        r = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        s = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    }

    public bk8(Context context, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = new SparseArray<>(8);
        this.k = false;
        this.a = context;
        this.f = new ArrayList();
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d010c, (ViewGroup) null);
        this.b = inflate;
        this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ed6);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.d.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091eda);
        this.e = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i4 = ShareGridLayout.f;
            marginLayoutParams.leftMargin = i4;
            marginLayoutParams.rightMargin = i4;
            this.e.setLayoutParams(marginLayoutParams);
        }
        this.e.setItemParams(n, o);
        TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090435);
        this.c = textView;
        textView.setOnClickListener(this);
        if (!o(i)) {
            m(new SvgMaskType(R.drawable.obfuscated_res_0x7f08083f), R.string.obfuscated_res_0x7f0f11c3, 4);
        }
        if (!p(i)) {
            m(new SvgMaskType(R.drawable.obfuscated_res_0x7f08083b), R.string.obfuscated_res_0x7f0f11ca, 3);
        }
        if (!n(i)) {
            m(new SvgMaskType(R.drawable.obfuscated_res_0x7f08083c), R.string.obfuscated_res_0x7f0f11a1, 9);
        }
        if (!q(i)) {
            m(new SvgMaskType(R.drawable.obfuscated_res_0x7f080840), R.string.obfuscated_res_0x7f0f11b0, 7);
        }
        if (!i45.m()) {
            this.e.setVisibility(8);
        }
    }

    public final ShareItem j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            ShareItem shareItem = this.j.get(i);
            if (shareItem == null) {
                return this.j.get(1);
            }
            return shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void k(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, onDismissListener) == null) && onDismissListener != null) {
            this.h = onDismissListener;
        }
    }

    public void s(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) && onClickListener != null) {
            this.g = onClickListener;
        }
    }

    public final void A(ShareItem shareItem, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, shareItem, i) == null) && shareItem != null && shareItem.u != null) {
            if (shareItem.b) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.u).param("obj_type", i));
            } else if (!shareItem.c && !shareItem.f) {
                if (shareItem.d) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.u).param("obj_type", i));
                } else if (shareItem.a) {
                    z(i, shareItem.G);
                } else if (shareItem.e) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.u));
                } else if (shareItem.g) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                    if (!xi.isEmpty(shareItem.x) && shareItem.x.contains("worldcup")) {
                        param.param("obj_param1", 9);
                    }
                    TiebaStatic.log(param);
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.u).param("obj_type", i).param("obj_source", shareItem.I).param("obj_param1", shareItem.J).param("fid", shareItem.N));
            }
        }
    }

    public void c(View view2, int i, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, onClickListener) == null) && i <= this.f.size() && i >= 0) {
            this.f.add(i, view2);
            if (onClickListener != null) {
                view2.setOnClickListener(new c(this, onClickListener));
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int i = 0; i < this.f.size(); i++) {
                this.e.addView(this.f.get(i), new ViewGroup.LayoutParams(n, o));
            }
        }
    }

    public void f() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (alertDialog = this.i) != null) {
            this.k = false;
            Context context = this.a;
            if (context instanceof Activity) {
                ch.a(alertDialog, (Activity) context);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<View> list = this.f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public final Location i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return d66.b();
        }
        return (Location) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new a(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public final String h(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, shareItem)) == null) {
            String str = "【" + shareItem.v + "】 " + shareItem.w;
            shareItem.w = str;
            return str;
        }
        return (String) invokeL.objValue;
    }

    public LinearLayout l(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i, i2)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i2));
            ImageView imageView = new ImageView(this.a);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
            int i3 = p;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            layoutParams.topMargin = q;
            layoutParams.bottomMargin = r;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.a);
            textView.setTextSize(0, s);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageResource(i2);
            textView.setTextColor(this.a.getResources().getColorStateList(R.color.obfuscated_res_0x7f060a4d));
            return linearLayout;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public final void m(AbsSvgType absSvgType, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048587, this, absSvgType, i, i2) != null) || absSvgType == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.a);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
        }
        int i3 = p;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.topMargin = q;
        layoutParams.bottomMargin = r;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.a);
        textView.setTextSize(0, s);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageDrawable(absSvgType.getDrawable());
        textView.setTextColor(this.a.getResources().getColorStateList(R.color.obfuscated_res_0x7f060a4d));
        linearLayout.setOnClickListener(this);
        this.f.add(linearLayout);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            int id = view2.getId();
            if (view2.getTag() != null) {
                i = ((Integer) view2.getTag()).intValue();
            } else {
                i = -1;
            }
            if (this.j.size() == 0) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f090435 && this.k) {
                return;
            }
            this.k = true;
            i45 i45Var = new i45(this.a, null);
            ShareItem j = j(1);
            if (id == R.id.obfuscated_res_0x7f090435) {
                v("share_cancel", new Object[0]);
                f();
                return;
            }
            if (j.Y > 0) {
                x(i, j);
            }
            if (i == 4) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    yi.O(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1196);
                    return;
                }
                v("share_to_weixin", new Object[0]);
                w(3);
                ShareItem j2 = j(3);
                A(j2, 4);
                if (j2 != null) {
                    i45Var.s(j2);
                }
            } else if (i == 3) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    yi.O(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1196);
                    return;
                }
                v("share_to_pyq", new Object[0]);
                w(2);
                ShareItem j3 = j(2);
                A(j3, 3);
                if (j3 != null) {
                    if (j3.b) {
                        j3.w = "【" + j3.v + "】 " + j3.w;
                    }
                    i45Var.t(j3);
                }
            } else if (i == 5) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    yi.O(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1196);
                    return;
                } else if (qo8.b(this.a, "com.tencent.mobileqq")) {
                    v("share_to_qzone", new Object[0]);
                    w(4);
                    ShareItem j4 = j(4);
                    A(j4, 5);
                    if (j4 != null) {
                        i45Var.o(j4);
                    }
                } else {
                    Context context = this.a;
                    BdToast.b(context, context.getText(R.string.obfuscated_res_0x7f0f11a2)).i();
                }
            } else if (i == 6) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    yi.O(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1196);
                    return;
                }
                v("share_to_qweibo", new Object[0]);
                w(5);
                ShareItem j5 = j(5);
                A(j5, 6);
                if (j5 != null) {
                    if (!j5.a) {
                        j5.w = h(j5);
                    }
                    i45Var.r(j5);
                }
            } else if (i == 7) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    yi.O(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1196);
                    return;
                }
                v("share_to_sweibo", new Object[0]);
                w(6);
                ShareItem j6 = j(6);
                A(j6, 7);
                if (j6 != null) {
                    if (!j6.a) {
                        j6.w = h(j6);
                    }
                    i45Var.q(j6);
                }
            } else if (i == 8) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    yi.O(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1196);
                    return;
                }
                v("share_to_renren", new Object[0]);
                w(7);
                ShareItem j7 = j(7);
                A(j7, 8);
                if (j7 != null) {
                    if (!j7.a) {
                        j7.w = h(j7);
                    }
                    i45Var.p(j7);
                }
            } else if (i == 9) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    yi.O(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1196);
                    return;
                } else if (qo8.b(this.a, "com.tencent.mobileqq")) {
                    v("share_to_qq_friend", new Object[0]);
                    w(8);
                    ShareItem j8 = j(8);
                    A(j8, 9);
                    if (j8 != null) {
                        i45Var.n(j8);
                    }
                } else {
                    Context context2 = this.a;
                    BdToast.b(context2, context2.getText(R.string.obfuscated_res_0x7f0f11a2)).i();
                }
            } else if (i == 10) {
                A(j, 10);
                View.OnClickListener onClickListener = this.g;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                } else {
                    oi.a(j.x);
                    yi.P(this.a.getApplicationContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f045f));
                }
                y(j);
                if (j != null && j.a) {
                    z(8, j.G);
                }
            }
            f();
        }
    }

    public void t(ShareItem shareItem, boolean z) {
        Location i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, shareItem, z) == null) {
            if (z && (i = i()) != null) {
                shareItem.F = i;
            }
            this.j.put(1, shareItem);
        }
    }

    public final void v(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.a, str, "click", 1, objArr);
        }
    }

    public final void z(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048601, this, i, str) == null) {
            TiebaStatic.eventStat(this.a, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                yi.O(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1196);
                Context context = this.a;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            } else if (!i45.m()) {
                yi.O(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0f01);
            } else {
                d();
                AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f100107).create();
                this.i = create;
                GreyUtil.grey(create);
                this.i.setCanceledOnTouchOutside(true);
                this.i.setOnDismissListener(new b(this));
                Context context2 = this.a;
                if (context2 instanceof Activity) {
                    ch.i(this.i, (Activity) context2);
                }
                this.b.setBackgroundResource(R.drawable.transmit_share_dialog_background);
                Window window = this.i.getWindow();
                window.addFlags(512);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = yi.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f1003fa);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.b);
                e();
                r();
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public final void w(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && i <= 8 && i > 0) {
            this.k = true;
            SparseArray<z25> sparseArray = this.m;
            if (sparseArray != null) {
                z25 z25Var = sparseArray.get(i);
                if (!StringUtils.isNull(z25Var.b()) && z25Var.a() != null && z25Var.a().size() > 0) {
                    v(z25Var.b(), z25Var.a());
                    return;
                }
            }
            SparseArray<String> sparseArray2 = this.l;
            if (sparseArray2 != null) {
                String str = sparseArray2.get(i);
                if (!xi.isEmpty(str)) {
                    v(str, new Object[0]);
                }
            }
        }
    }

    public final void y(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 9);
            int i = shareItem.J;
            if (i != 0) {
                param.param("obj_param1", i);
                int i2 = shareItem.J;
                if (i2 == 2) {
                    param.param("fid", shareItem.N);
                } else if (i2 == 3) {
                    int i3 = shareItem.Q;
                    if (i3 != 0) {
                        param.param("obj_type", i3);
                    }
                    param.param("tid", shareItem.O).param("fid", shareItem.N);
                }
            }
            param.param("obj_locate", 7);
            TiebaStatic.log(param);
        }
    }

    public final void x(int i, ShareItem shareItem) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048599, this, i, shareItem) == null) && i >= 0 && shareItem != null) {
            if (i == 4) {
                str = ThirdPartyUtil.TYPE_WEIXIN;
            } else if (i == 3) {
                str = "pyq";
            } else if (i == 9) {
                str = LoginConstants.QQ_LOGIN;
            } else if (i == 7) {
                str = "weibo";
            } else {
                str = "";
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE);
            statisticItem.addParam("obj_type", shareItem.Z);
            statisticItem.addParam(TiebaStatic.Params.TIEBA_PARAMS, str);
            statisticItem.addParam("room_id", shareItem.Y);
            statisticItem.eventStat();
        }
    }
}
