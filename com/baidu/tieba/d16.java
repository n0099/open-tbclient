package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.v06;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BlueCircleProgressDialog A;
    public int B;
    public c16 C;
    public UserData D;
    public boolean E;
    public boolean F;
    public int G;
    public ClickableSpan H;
    public boolean I;
    public CustomMessageListener J;
    public CompoundButton.OnCheckedChangeListener K;
    public PopupWindow.OnDismissListener L;
    public CustomMessageListener M;
    public Context a;
    public TbPageContext b;
    public BdUniqueId c;
    public NegativeFeedBackData d;
    public SparseArray<String> e;
    public List<v06.b> f;
    public int g;
    public int h;
    public int i;
    public NEGFeedBackView.NEGFeedbackEventCallback j;
    public PopupWindow k;
    public View l;
    public v06 m;
    public boolean n;
    public int o;
    public PopupWindow p;
    public ViewGroup q;
    public EMTextView r;
    public EMTextView s;
    public EMTextView t;
    public EMTextView u;
    public EMTextView v;
    public LinearLayout w;
    public String x;
    public h y;
    public i z;

    /* loaded from: classes5.dex */
    public interface h {
        void onClick();
    }

    /* loaded from: classes5.dex */
    public interface i {
        void a(JSONArray jSONArray);
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d16 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d16 d16Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d16Var, Integer.valueOf(i)};
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
            this.a = d16Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921745) {
                return;
            }
            this.a.E();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d16 a;

        public b(d16 d16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d16Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.a.j != null) {
                    this.a.j.onCheckedChanged(this.a.d, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof v06.b) {
                    v06.b bVar = (v06.b) compoundButton.getTag();
                    if (z) {
                        if (!this.a.f.contains(bVar)) {
                            this.a.f.add(bVar);
                            if (this.a.E && this.a.s != null) {
                                this.a.s.setClickable(true);
                                EMManager.from(this.a.s).setTextColor(R.color.CAM_X0302);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.a.f.remove(bVar);
                    if (this.a.E && this.a.s != null) {
                        this.a.s.setClickable(false);
                        this.a.s.setTextColor(bqa.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d16 a;

        public c(d16 d16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d16Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.k != null) {
                    this.a.k.dismiss();
                    this.a.k = null;
                }
                MessageManager.getInstance().unRegisterListener(this.a.M);
                MessageManager.getInstance().unRegisterListener(this.a.J);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d16 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d16 d16Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d16Var, Integer.valueOf(i)};
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
            this.a = d16Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.a.w();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d16 a;

        public e(d16 d16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.k != null) {
                    this.a.k.dismiss();
                    this.a.k = null;
                }
                if (this.a.p != null) {
                    this.a.p.dismiss();
                    this.a.p = null;
                }
                if (this.a.I) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CANCEL_CLICK).param("obj_source", this.a.x));
                }
                if (this.a.y != null) {
                    this.a.y.onClick();
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.a.x).param("obj_type", "9"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d16 a;

        public f(d16 d16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d16Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            JSONObject z = this.a.z();
            if (this.a.x != "3" && this.a.x != "4" && this.a.x != "1") {
                if (z == null) {
                    return;
                }
                this.a.L();
                CustomMessage customMessage = new CustomMessage(2016489, this.a.b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, z);
                customResponsedMessage.setOrginalMessage(customMessage);
                if (this.a.c != null) {
                    customMessage.setTag(this.a.c);
                }
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            this.a.y();
        }
    }

    /* loaded from: classes5.dex */
    public class g extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d16 a;

        public g(d16 d16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d16Var;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.a.a, this.a.C.b(), this.a.C.c(), this.a.C.a(), this.a.C.g(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                if (this.a.k != null) {
                    this.a.k.dismiss();
                    this.a.k = null;
                }
                if (this.a.p != null) {
                    this.a.p.dismiss();
                    this.a.p = null;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d16(TbPageContext tbPageContext, View view2, c16 c16Var, UserData userData) {
        this(tbPageContext, view2, c16Var, userData, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, c16Var, userData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (View) objArr2[1], (c16) objArr2[2], (UserData) objArr2[3], (BdUniqueId) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d16(TbPageContext tbPageContext, View view2, c16 c16Var, UserData userData, @Nullable BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, c16Var, userData, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.d = null;
        this.e = null;
        this.f = new ArrayList();
        this.j = null;
        this.p = null;
        this.A = null;
        this.B = 3;
        this.E = true;
        this.F = false;
        this.J = new a(this, 2921745);
        this.K = new b(this);
        this.L = new c(this);
        this.M = new d(this, 2001304);
        this.a = tbPageContext.getPageActivity();
        this.b = tbPageContext;
        this.c = bdUniqueId;
        this.l = view2;
        this.C = c16Var;
        this.D = userData;
        D();
        C();
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.I = z;
        }
    }

    public void I(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr) == null) {
            this.m.k(strArr);
        }
    }

    public void J(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
            this.z = iVar;
        }
    }

    public final View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Context context = this.a;
            if (context == null) {
                return null;
            }
            if (this.q == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ueg_new_delete_thread_view, (ViewGroup) null);
                this.q = viewGroup;
                EMTextView eMTextView = (EMTextView) viewGroup.findViewById(R.id.ueg_new_delete_thread_title_view);
                this.t = eMTextView;
                if (this.I) {
                    eMTextView.setText(R.string.shield_reason);
                } else {
                    eMTextView.setText(R.string.delete_reason);
                }
                EMManager.from(this.t).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
                EMTextView eMTextView2 = (EMTextView) this.q.findViewById(R.id.ueg_new_delete_thread_describe_view);
                this.u = eMTextView2;
                EMManager.from(eMTextView2).setTextSize(R.dimen.T_X08);
                EMTextView eMTextView3 = (EMTextView) this.q.findViewById(R.id.ueg_new_delete_thread_cancel_view);
                this.r = eMTextView3;
                eMTextView3.setOnClickListener(new e(this));
                EMTextView eMTextView4 = (EMTextView) this.q.findViewById(R.id.ueg_new_delete_thread_certain_view);
                this.s = eMTextView4;
                if (this.I) {
                    eMTextView4.setText(R.string.obfuscated_res_0x7f0f1418);
                } else {
                    eMTextView4.setText(R.string.obfuscated_res_0x7f0f04ca);
                }
                this.s.setOnClickListener(new f(this));
            }
            this.w = (LinearLayout) this.q.findViewById(R.id.ueg_new_delete_thread_reason_view_container);
            View g2 = this.m.g();
            if (g2 != null && g2.getParent() == null) {
                int dimens = BdUtilHelper.getDimens(this.a, R.dimen.M_W_X009);
                g2.setPadding(dimens, 0, dimens, 0);
                this.w.addView(g2);
            }
            EMTextView eMTextView5 = (EMTextView) this.q.findViewById(R.id.ueg_new_delete_thread_tip_view);
            this.v = eMTextView5;
            eMTextView5.setHighlightColor(SelectorHelper.getResources().getColor(17170445));
            if (this.F) {
                this.v.setVisibility(0);
                if (1 == this.G) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) this.a.getString(R.string.set_forum_rule_tip_manager));
                    g gVar = new g(this);
                    this.H = gVar;
                    spannableStringBuilder.setSpan(gVar, 13, 17, 18);
                    this.v.setText(spannableStringBuilder);
                    this.v.setMovementMethod(LinkMovementMethod.getInstance());
                } else {
                    this.v.setText(this.a.getString(R.string.set_forum_rule_tip_assist));
                }
            } else {
                this.v.setVisibility(8);
            }
            this.v.setClickable(false);
            this.v.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
            w();
            return this.q;
        }
        return (View) invokeV.objValue;
    }

    public final int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ViewGroup viewGroup = this.q;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.q.getMeasuredHeight();
            this.i = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !this.n || this.f.size() == 0) {
            return;
        }
        this.f.clear();
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.A == null) {
                this.A = new BlueCircleProgressDialog(this.b);
            }
            this.A.setTipString(R.string.obfuscated_res_0x7f0f0c22);
            this.A.setDialogVisiable(true);
        }
    }

    public void x() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (blueCircleProgressDialog = this.A) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            PopupWindow popupWindow = this.p;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.p = null;
            }
            PopupWindow popupWindow2 = this.k;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.k = null;
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o = BdUtilHelper.getDimens(this.a, R.dimen.M_W_X009);
            this.h = BdUtilHelper.getEquipmentWidth(this.a) - (this.o * 2);
            v06 v06Var = new v06(this.b.getPageActivity());
            this.m = v06Var;
            v06Var.o(this.K);
            this.m.n(true);
            if (this.F) {
                this.m.l(5);
            }
        }
    }

    public final void D() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c16 c16Var = this.C;
            if (c16Var != null) {
                if (c16Var.e() == 1) {
                    this.E = false;
                } else {
                    this.E = true;
                }
                if (this.C.d() == 1) {
                    this.F = false;
                } else {
                    this.F = true;
                }
            }
            if (this.F && (userData = this.D) != null) {
                this.G = userData.getIs_manager();
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.p != null && this.b != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.b.getPageActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            PopupWindow popupWindow = this.p;
            popupWindow.update(displayMetrics.widthPixels - (this.o * 2), popupWindow.getHeight());
        }
    }

    public void H(NegativeFeedBackData negativeFeedBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, negativeFeedBackData) != null) || negativeFeedBackData == null) {
            return;
        }
        this.d = negativeFeedBackData;
        SparseArray<String> feedBackReasonMap = negativeFeedBackData.getFeedBackReasonMap();
        this.e = feedBackReasonMap;
        if (feedBackReasonMap != null && feedBackReasonMap.size() > 8) {
            for (int size = this.e.size() - 1; size >= 8; size--) {
                this.e.removeAt(size);
            }
        }
        this.m.j(negativeFeedBackData);
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, str) != null) || this.a == null) {
            return;
        }
        this.x = str;
        View A = A();
        if (A != null && A.getParent() != null) {
            ((ViewGroup) A.getParent()).removeView(A);
        }
        if (A == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
        gradientDrawable.setCornerRadius(BdUtilHelper.getDimens(this.a, R.dimen.tbds31));
        A.setBackgroundDrawable(gradientDrawable);
        w();
        this.g = B();
        PopupWindow popupWindow = new PopupWindow(A, this.h, this.g);
        this.p = popupWindow;
        GreyUtil.grey(popupWindow);
        this.p.setFocusable(true);
        this.p.setTouchable(true);
        this.p.setOnDismissListener(this.L);
        F();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.k = popupWindow2;
        GreyUtil.grey(popupWindow2);
        if (Build.VERSION.SDK_INT >= 22) {
            this.k.setAttachedInDecor(false);
        }
        this.k.showAtLocation(this.l, 0, 0, 0);
        this.p.showAtLocation(this.l, 17, 0, 0);
        NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback = this.j;
        if (nEGFeedbackEventCallback != null) {
            nEGFeedbackEventCallback.onNEGFeedbackWindowShow(this.d);
        }
        this.n = true;
        MessageManager.getInstance().registerListener(this.J);
        MessageManager.getInstance().registerListener(this.M);
    }

    public final void w() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (skinType = TbadkCoreApplication.getInst().getSkinType()) != this.B) {
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColorSelector(this.r, R.color.CAM_X0105);
            if (this.E) {
                this.s.setTextColor(bqa.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                this.s.setClickable(false);
            } else {
                EMManager.from(this.s).setTextColor(R.color.CAM_X0302);
            }
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0105, 1);
            this.v.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
            gradientDrawable.setCornerRadius(BdUtilHelper.getDimens(this.a, R.dimen.tbds31));
            this.q.setBackgroundDrawable(gradientDrawable);
            this.B = skinType;
        }
    }

    public final JSONObject z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.d == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            if (!ListUtils.isEmpty(this.f)) {
                int i3 = 0;
                while (i2 < this.f.size()) {
                    v06.b bVar = this.f.get(i2);
                    if (bVar != null) {
                        jSONArray.put(String.valueOf(bVar.b));
                        i3 = bVar.a + 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.x).param("obj_type", i2));
            if (this.I) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_REASON_CLICK).param("obj_source", this.x).param("obj_type", i2));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CONFIRM_CLICK).param("obj_source", this.x).param("obj_type", i2));
            }
            i iVar = this.z;
            if (iVar != null) {
                iVar.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.d.getTidArray());
                jSONObject.put("type", this.d.getDeleteType());
                jSONObject.put("forum_id", this.d.getFid());
                jSONObject.put("is_frs_masks", this.d.getMaskTidArray());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
