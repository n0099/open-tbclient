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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.e06;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f06 {
    public static /* synthetic */ Interceptable $ic;
    public static String F;
    public transient /* synthetic */ FieldHolder $fh;
    public CompoundButton.OnCheckedChangeListener A;
    public Runnable B;
    public View.OnClickListener C;
    public PopupWindow.OnDismissListener D;
    public CustomMessageListener E;
    public Context a;
    public TbPageContext b;
    public PopupWindow c;
    public ViewGroup d;
    public h05 e;
    public SparseArray<String> f;
    public List<e06.b> g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public NEGFeedBackView.b p;
    public PopupWindow q;
    public View r;
    public TextView s;
    public TBSpecificationBtn t;
    public n75 u;
    public e06 v;
    public boolean w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f06 a;

        public a(f06 f06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f06Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.a.p != null) {
                    this.a.p.b(this.a.e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof e06.b) {
                    e06.b bVar = (e06.b) compoundButton.getTag();
                    if (z) {
                        if (!this.a.g.contains(bVar)) {
                            this.a.g.add(bVar);
                        }
                    } else {
                        this.a.g.remove(bVar);
                    }
                }
                if (this.a.r != null && !ListUtils.isEmpty(this.a.g)) {
                    this.a.r.removeCallbacks(this.a.B);
                    this.a.r.postDelayed(this.a.B, 500L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f06 a;

        public b(f06 f06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f06Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f06 a;

        public c(f06 f06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f06Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.r();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f06 a;

        public d(f06 f06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f06Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.r != null) {
                    this.a.r.removeCallbacks(this.a.B);
                }
                if (this.a.q != null) {
                    this.a.q.dismiss();
                    this.a.q = null;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f06 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(f06 f06Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f06Var, Integer.valueOf(i)};
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
            this.a = f06Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.k();
            }
        }
    }

    public f06(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = new ArrayList();
        this.p = null;
        this.x = 3;
        this.y = true;
        this.z = false;
        this.A = new a(this);
        this.B = new b(this);
        this.C = new c(this);
        this.D = new d(this);
        this.E = new e(this, 2016524);
        this.a = tbPageContext.getPageActivity();
        this.b = tbPageContext;
        this.r = view2;
        p();
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.z = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.y = z;
        }
    }

    public void v(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, strArr) == null) {
            this.v.k(strArr);
        }
    }

    public void w(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.v.m(z);
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && !qi.isEmpty(str)) {
            F = str;
        }
    }

    public void z(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        CustomMessageListener customMessageListener = this.E;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.E);
    }

    public void A(View view2) {
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a == null) {
            return;
        }
        if (!this.z && ((sparseArray = this.f) == null || sparseArray.size() == 0)) {
            return;
        }
        View l = l();
        this.i = ri.l(this.a) - (this.l * 2);
        int o = o();
        this.h = o;
        int[] iArr = new int[2];
        boolean i = i(this.a, this.r, o, this.i, this.k, this.m, iArr);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0207));
        gradientDrawable.setCornerRadius(ri.g(this.a, R.dimen.tbds31));
        l.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(l, this.i, o());
        this.c = popupWindow;
        GreyUtil.grey(popupWindow);
        this.c.setFocusable(true);
        this.c.setTouchable(true);
        this.c.setOnDismissListener(this.D);
        s();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.q = popupWindow2;
        GreyUtil.grey(popupWindow2);
        if (Build.VERSION.SDK_INT >= 22) {
            this.q.setAttachedInDecor(false);
        }
        this.q.showAtLocation(this.r, 0, 0, 0);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.c.setBackgroundDrawable(new ColorDrawable(0));
        if (i) {
            this.c.setAnimationStyle(R.style.obfuscated_res_0x7f10040c);
        } else {
            this.c.setAnimationStyle(R.style.obfuscated_res_0x7f10040d);
        }
        this.c.showAtLocation(this.r, 0, iArr[0] - this.l, iArr[1]);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        NEGFeedBackView.b bVar = this.p;
        if (bVar != null) {
            bVar.c(this.e);
        }
        this.w = true;
    }

    public final JSONObject n(ArrayList<Integer> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.e != null && arrayList != null) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                if (!ListUtils.isEmpty(this.g)) {
                    for (e06.b bVar : this.g) {
                        if (bVar != null) {
                            arrayList.add(Integer.valueOf(bVar.b));
                            if (sb.length() != 0) {
                                sb.append(",");
                            }
                            sb.append(String.valueOf(bVar.b));
                            if (sb2.length() != 0) {
                                sb2.append(",");
                            }
                            sb2.append(bVar.d);
                        }
                    }
                }
                try {
                    jSONObject.put("tid", this.e.f());
                    if (sb.length() != 0) {
                        jSONObject.put("dislike_ids", sb.toString());
                    }
                    jSONObject.put("fid", this.e.c());
                    jSONObject.put("click_time", System.currentTimeMillis());
                    if (!StringUtils.isNull(this.e.getType())) {
                        jSONObject.put("type", this.e.getType());
                    }
                    if (this.e.h() != 0) {
                        jSONObject.put("topic_id", this.e.h());
                    }
                    jSONObject.put("extra", sb2.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.g.size();
            if (size > 0) {
                String string = this.a.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
                SpannableString spannableString = new SpannableString(string);
                UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)));
                TextView textView = this.s;
                if (textView != null) {
                    textView.setText(spannableString);
                }
                TBSpecificationBtn tBSpecificationBtn = this.t;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f04b2));
                    return;
                }
                return;
            }
            if (this.s != null) {
                if (!qi.isEmpty(F)) {
                    this.s.setText(F);
                } else {
                    this.s.setText(this.a.getResources().getString(R.string.tell_us_reason));
                }
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.t;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.setText(this.a.getResources().getString(R.string.not_interested));
            }
        }
    }

    public final View l() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Context context = this.a;
            if (context == null) {
                return null;
            }
            if (this.d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.d = viewGroup;
                this.s = (TextView) viewGroup.findViewById(R.id.head_text);
                if (!qi.isEmpty(F)) {
                    this.s.setText(F);
                }
                this.t = (TBSpecificationBtn) this.d.findViewById(R.id.uninterested_btn);
                n75 n75Var = new n75();
                this.u = n75Var;
                n75Var.t(R.color.CAM_X0304);
                this.t.setConfig(this.u);
                this.t.setOnClickListener(this.C);
                this.t.setText(this.a.getResources().getString(R.string.not_interested));
                this.t.setTextSize(R.dimen.T_X08);
                ViewGroup viewGroup2 = this.d;
                int i2 = this.n;
                if (this.z) {
                    i = 0;
                } else {
                    i = this.o;
                }
                viewGroup2.setPadding(i2, 0, i2, i);
            }
            j();
            View h = this.v.h();
            if (h != null && h.getParent() == null) {
                this.d.addView(h);
            }
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.e != null && this.c != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            JSONObject n = n(arrayList);
            if (this.y && this.b != null) {
                if (!StringUtils.isNull(this.e.getType())) {
                    CustomMessage customMessage = new CustomMessage(2921324, this.b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, n);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage(2016488, this.b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, n);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
            }
            k();
            new u65().a = BoxAccountManager.GET_SHARE_LOGIN_INFO_DEFAULT_TIMEOUT;
            String string = this.a.getResources().getString(R.string.reduce_related_thread_recommend);
            if (n != null && "7".equals(n.optString("dislike_ids"))) {
                string = this.a.getResources().getString(R.string.forbidden_forum_success);
            }
            ri.Q(this.a, string);
            NEGFeedBackView.b bVar = this.p;
            if (bVar != null) {
                bVar.a(arrayList, m(), this.e);
            }
        }
    }

    public final boolean i(Context context, View view2, int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            if (context == null || view2 == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view2.getLocationOnScreen(iArr2);
            int height = view2.getHeight();
            int j = ri.j(context);
            int l = ri.l(context);
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

    public final void j() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (skinType = TbadkCoreApplication.getInst().getSkinType()) != this.x) {
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
            this.x = skinType;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PopupWindow popupWindow = this.c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.c = null;
            }
            PopupWindow popupWindow2 = this.q;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.q = null;
            }
        }
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ViewGroup viewGroup = this.d;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.d.getMeasuredHeight();
            this.j = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.E);
            k();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || !this.w || this.g.size() == 0) {
            return;
        }
        this.g.clear();
        C();
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!ListUtils.isEmpty(this.g)) {
                StringBuilder sb = new StringBuilder();
                for (e06.b bVar : this.g) {
                    if (bVar != null) {
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(bVar.c);
                    }
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.l = ri.g(this.a, R.dimen.M_W_X004);
            this.m = ri.g(this.a, R.dimen.tbds14);
            this.n = ri.g(this.a, R.dimen.M_W_X005);
            this.o = ri.g(this.a, R.dimen.M_H_X007);
            this.i = ri.l(this.a) - (this.l * 2);
            this.k = ri.g(this.a, R.dimen.tbds160);
            e06 e06Var = new e06(this.a);
            this.v = e06Var;
            e06Var.n(true);
            this.v.i(false);
            this.v.o(this.A);
            TbPageContext tbPageContext = this.b;
            if (tbPageContext != null) {
                tbPageContext.registerListener(this.E);
            }
        }
    }

    public void u(h05 h05Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, h05Var) != null) || h05Var == null) {
            return;
        }
        this.e = h05Var;
        SparseArray<String> b2 = h05Var.b();
        this.f = b2;
        if (b2 != null && b2.size() > 9) {
            for (int size = this.f.size() - 1; size >= 9; size--) {
                this.f.removeAt(size);
            }
        }
        this.v.j(h05Var);
    }
}
