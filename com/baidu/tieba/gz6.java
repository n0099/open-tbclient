package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.feed.widget.FeedBackReasonView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class gz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Runnable A;
    public View.OnClickListener B;
    public PopupWindow.OnDismissListener C;
    public CustomMessageListener D;
    public String a;
    public String b;
    public Context c;
    public PopupWindow d;
    public ViewGroup e;
    public SparseArray<String> f;
    public List<FeedBackReasonView.b> g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public PopupWindow p;
    public View q;
    public TextView r;
    public TBSpecificationBtn s;
    public o55 t;
    public FeedBackReasonView u;
    public boolean v;
    public int w;
    public boolean x;
    public f y;
    public CompoundButton.OnCheckedChangeListener z;

    /* loaded from: classes4.dex */
    public interface f {
        void a(List<FeedBackReasonView.b> list, boolean z);
    }

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz6 a;

        public a(gz6 gz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz6Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (compoundButton.getTag() instanceof FeedBackReasonView.b) {
                    FeedBackReasonView.b bVar = (FeedBackReasonView.b) compoundButton.getTag();
                    if (z) {
                        if (!this.a.g.contains(bVar)) {
                            this.a.g.add(bVar);
                        }
                    } else {
                        this.a.g.remove(bVar);
                    }
                }
                if (this.a.q != null && !ListUtils.isEmpty(this.a.g)) {
                    this.a.q.removeCallbacks(this.a.A);
                    this.a.q.postDelayed(this.a.A, 500L);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz6 a;

        public b(gz6 gz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.m(false);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz6 a;

        public c(gz6 gz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.m(true);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz6 a;

        public d(gz6 gz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz6Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.q != null) {
                    this.a.q.removeCallbacks(this.a.A);
                }
                if (this.a.p != null) {
                    this.a.p.dismiss();
                    this.a.p = null;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gz6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(gz6 gz6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz6Var, Integer.valueOf(i)};
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
            this.a = gz6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.i();
            }
        }
    }

    public gz6(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.f = null;
        this.g = new ArrayList();
        this.w = 3;
        this.x = false;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new c(this);
        this.C = new d(this);
        this.D = new e(this, 2016524);
        this.c = view2.getContext();
        this.q = view2;
        l();
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            f fVar = this.y;
            if (fVar != null) {
                fVar.a(this.g, z);
            }
            i();
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.u.setFirstRowSingleColumn(z);
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && !hi.isEmpty(str)) {
            this.a = str;
        }
    }

    public void q(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.y = fVar;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && !hi.isEmpty(str)) {
            this.b = str;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.x = z;
        }
    }

    public final boolean g(Context context, View view2, int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            if (context == null || view2 == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view2.getLocationOnScreen(iArr2);
            int height = view2.getHeight();
            int j = ii.j(context);
            int l = ii.l(context);
            if (((j - iArr2[1]) - height) - i3 < i) {
                z = true;
            } else {
                z = false;
            }
            iArr[0] = l - i2;
            if (z) {
                iArr[1] = (iArr2[1] - i) - i4;
                iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            } else {
                iArr[1] = iArr2[1] + height + i4;
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final void h() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (skinType = TbadkCoreApplication.getInst().getSkinType()) != this.w) {
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1);
            this.w = skinType;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PopupWindow popupWindow = this.d;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.d = null;
            }
            PopupWindow popupWindow2 = this.p;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.p = null;
            }
        }
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ViewGroup viewGroup = this.e;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.e.getMeasuredHeight();
            this.j = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.v || this.g.size() == 0) {
            return;
        }
        this.g.clear();
        u();
    }

    public final View j() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.c;
            if (context == null) {
                return null;
            }
            if (this.e == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.e = viewGroup;
                this.r = (TextView) viewGroup.findViewById(R.id.head_text);
                if (!hi.isEmpty(this.a)) {
                    this.r.setText(this.a);
                }
                this.s = (TBSpecificationBtn) this.e.findViewById(R.id.uninterested_btn);
                o55 o55Var = new o55();
                this.t = o55Var;
                o55Var.t(R.color.CAM_X0304);
                this.s.setConfig(this.t);
                this.s.setOnClickListener(this.B);
                this.s.setText(this.c.getResources().getString(R.string.not_interested));
                this.s.setTextSize(R.dimen.T_X08);
                ViewGroup viewGroup2 = this.e;
                int i2 = this.n;
                if (this.x) {
                    i = 0;
                } else {
                    i = this.o;
                }
                viewGroup2.setPadding(i2, 0, i2, i);
            }
            h();
            u();
            FeedBackReasonView feedBackReasonView = this.u;
            if (feedBackReasonView != null && feedBackReasonView.getParent() == null) {
                this.e.addView(this.u);
            }
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int size = this.g.size();
            if (size > 0) {
                String string = this.c.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
                SpannableString spannableString = new SpannableString(string);
                UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)));
                TextView textView = this.r;
                if (textView != null) {
                    textView.setText(spannableString);
                }
                TBSpecificationBtn tBSpecificationBtn = this.s;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setText(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f045d));
                    return;
                }
                return;
            }
            if (this.r != null) {
                if (!hi.isEmpty(this.a)) {
                    this.r.setText(this.a);
                } else {
                    this.r.setText(this.c.getResources().getString(R.string.tell_us_reason));
                }
            }
            if (this.s != null) {
                if (!hi.isEmpty(this.b)) {
                    this.s.setText(this.b);
                } else {
                    this.s.setText(this.c.getResources().getString(R.string.not_interested));
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l = ii.g(this.c, R.dimen.M_W_X004);
            this.m = ii.g(this.c, R.dimen.tbds14);
            this.n = ii.g(this.c, R.dimen.M_W_X005);
            this.o = ii.g(this.c, R.dimen.M_H_X007);
            this.i = ii.l(this.c) - (this.l * 2);
            this.k = ii.g(this.c, R.dimen.tbds160);
            FeedBackReasonView feedBackReasonView = new FeedBackReasonView(this.c);
            this.u = feedBackReasonView;
            feedBackReasonView.setCanUnCheckedInSingleBox(false);
            this.u.setOnCheckedChangedListener(this.z);
            MessageManager.getInstance().registerListener(this.D);
        }
    }

    public void s(View view2) {
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, view2) != null) || this.c == null) {
            return;
        }
        if (!this.x && ((sparseArray = this.f) == null || sparseArray.size() == 0)) {
            return;
        }
        View j = j();
        this.i = ii.l(this.c) - (this.l * 2);
        int k = k();
        this.h = k;
        int[] iArr = new int[2];
        boolean g = g(this.c, this.q, k, this.i, this.k, this.m, iArr);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0207));
        gradientDrawable.setCornerRadius(ii.g(this.c, R.dimen.tbds31));
        j.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(j, this.i, k());
        this.d = popupWindow;
        GreyUtil.grey(popupWindow);
        this.d.setFocusable(true);
        this.d.setTouchable(true);
        this.d.setOnDismissListener(this.C);
        n();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.c).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.p = popupWindow2;
        GreyUtil.grey(popupWindow2);
        if (Build.VERSION.SDK_INT >= 22) {
            this.p.setAttachedInDecor(false);
        }
        this.p.showAtLocation(this.q, 0, 0, 0);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.d.setBackgroundDrawable(new ColorDrawable(0));
        if (g) {
            this.d.setAnimationStyle(R.style.obfuscated_res_0x7f1003f9);
        } else {
            this.d.setAnimationStyle(R.style.obfuscated_res_0x7f1003fa);
        }
        this.d.showAtLocation(this.q, 0, iArr[0] - this.l, iArr[1]);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        this.v = true;
    }
}
