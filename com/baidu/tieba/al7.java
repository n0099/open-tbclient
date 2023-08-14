package com.baidu.tieba;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.bl7;
import com.baidu.tieba.frs.forumRule.ForumRulesEditActivity;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.w45;
import com.baidu.tieba.write.WriteVideoUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes5.dex */
public class al7 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public lr6 C;
    public EditorScrollView D;
    public List<bl7> E;
    public ForumRuleBaseData F;
    public BdTopToast G;
    public boolean H;
    public int I;
    public u45 J;
    public w45 K;
    public boolean L;
    public Runnable M;
    public w45.e N;
    public w45.e O;
    public final TbPageContext<?> a;
    public final String b;
    public final String c;
    public final String d;
    public sk7 e;
    public ForumRulesEditActivity f;
    public View g;
    public View h;
    public View i;
    public RelativeLayout j;
    public RelativeLayout k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public EMTextView o;
    public EMTextView p;
    public EMTextView q;
    public EMTextView r;
    public EMTextView s;
    public EMTextView t;
    public EditText u;
    public EditText v;
    public LinearLayout w;
    public LinearLayout x;
    public NavigationBar y;
    public TextView z;

    /* loaded from: classes5.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al7 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        /* loaded from: classes5.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (motionEvent.getAction() == 1) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    } else if (motionEvent.getAction() == 3) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        public f(al7 al7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = al7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.a.t(length);
                al7.R(this.a.s, length, 500);
                this.a.M();
                if (this.a.v.getLineCount() > 6) {
                    this.a.v.setOnTouchListener(new a(this));
                } else {
                    this.a.v.setOnTouchListener(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bl7 a;
        public final /* synthetic */ al7 b;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    g gVar = this.a;
                    gVar.b.O(gVar.a);
                }
            }
        }

        public g(al7 al7Var, bl7 bl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var, bl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = al7Var;
            this.a = bl7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.k().getText().toString().length() != 0 || this.a.l().getText().toString().length() != 0) {
                    this.b.V(new a(this));
                } else {
                    this.b.O(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements w45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al7 a;

        public a(al7 al7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = al7Var;
        }

        @Override // com.baidu.tieba.w45.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D();
                if (this.a.f != null) {
                    this.a.f.finish();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;

        public b(al7 al7Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onClick(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al7 a;

        public c(al7 al7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = al7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.s(true, null, false);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al7 a;

        public d(al7 al7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = al7Var;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.E();
            BdUtilHelper.hideSoftKeyPad(this.a.a.getPageActivity(), this.a.u);
            BdUtilHelper.hideSoftKeyPad(this.a.a.getPageActivity(), this.a.v);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al7 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public e(al7 al7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = al7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.a.X(length);
                al7.R(this.a.q, length, 50);
                this.a.M();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements bl7.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al7 a;

        public h(al7 al7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = al7Var;
        }

        @Override // com.baidu.tieba.bl7.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.M();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al7 a;

        public i(al7 al7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = al7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D.fullScroll(130);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements w45.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al7 a;

        public j(al7 al7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = al7Var;
        }

        @Override // com.baidu.tieba.w45.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements w45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al7 a;

        public k(al7 al7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = al7Var;
        }

        @Override // com.baidu.tieba.w45.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.z();
        }
    }

    public al7(TbPageContext<?> tbPageContext, sk7 sk7Var, View view2, String str, String str2, String str3, String str4, int i2, ForumRulesEditActivity forumRulesEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, sk7Var, view2, str, str2, str3, str4, Integer.valueOf(i2), forumRulesEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E = new ArrayList();
        this.F = new ForumRuleBaseData();
        this.H = true;
        this.L = false;
        this.M = new c(this);
        this.N = new k(this);
        this.O = new a(this);
        this.a = tbPageContext;
        this.b = str;
        this.c = str2;
        this.d = str4;
        this.I = i2;
        this.f = forumRulesEditActivity;
        this.e = sk7Var;
        F(view2, str3);
    }

    public static void R(TextView textView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, textView, i2, i3) == null) {
            textView.setText(i2 + "/" + i3);
            if (i2 > i3) {
                EMManager.from(textView).setTextColor(R.color.CAM_X0301);
            } else {
                EMManager.from(textView).setTextColor(R.color.CAM_X0111);
            }
        }
    }

    public final void O(bl7 bl7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, bl7Var) == null) && bl7Var != null) {
            this.x.removeView(bl7Var.m());
            this.E.remove(bl7Var);
            S();
            K();
            N();
            M();
        }
    }

    public final void P(bl7 bl7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bl7Var) == null) && bl7Var != null) {
            bl7Var.o(new g(this, bl7Var));
            bl7Var.p(new h(this));
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.A == null || (editText = this.u) == null || editText.getText().toString().trim().length() <= 0) {
                return false;
            }
            EditText editText2 = this.v;
            if (editText2 != null && editText2.getText().toString().trim().length() <= 0) {
                return false;
            }
            List<bl7> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    bl7 bl7Var = this.E.get(i2);
                    EditText l = bl7Var.l();
                    SpanGroupEditText k2 = bl7Var.k();
                    if (l == null || l.getText().toString().trim().length() <= 0 || k2 == null || k2.getText().toString().trim().length() <= 0) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.F == null) {
                this.F = new ForumRuleBaseData();
            }
            ArrayList arrayList = new ArrayList();
            List<bl7> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                    bl7 bl7Var = this.E.get(i2);
                    EditText l = bl7Var.l();
                    SpanGroupEditText k2 = bl7Var.k();
                    if (l != null) {
                        forumRuleItemData.setTitle(l.getText().toString());
                    }
                    if (k2 != null) {
                        forumRuleItemData.setContent(k2.getSpanGroupManager().G());
                    }
                    forumRuleItemData.setStatus(i2 + "");
                    arrayList.add(forumRuleItemData);
                }
            }
            this.F.setTitle(this.u.getText().toString());
            this.F.setPreface(this.v.getText().toString());
            this.F.setList(arrayList);
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            ForumRuleBaseData forumRuleBaseData = this.F;
            if (forumRuleBaseData != null) {
                if (forumRuleBaseData.getTitle() != null) {
                    i2 = this.F.getTitle().length();
                } else {
                    i2 = 0;
                }
                if (this.F.getList() != null && this.F.getList().size() > 0) {
                    i4 = 0;
                    i5 = 0;
                    for (int i6 = 0; i6 < this.F.getList().size(); i6++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.F.getList().get(i6);
                        if (forumRuleItemData != null) {
                            if (forumRuleItemData.getTitle() != null) {
                                i4 += forumRuleItemData.getTitle().length();
                            }
                            if (forumRuleItemData.getContent() != null) {
                                i5 += forumRuleItemData.getContent().length();
                            }
                        }
                    }
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                if (this.F.getPreface() != null) {
                    i3 = this.F.getPreface().length();
                } else {
                    i3 = 0;
                }
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            if (i2 + i4 + i5 + i3 <= 5000) {
                return false;
            }
            D();
            W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07c1), 5000));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String format = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07b7), this.c, bi.getDateStringMouth(new Date()));
            this.u.setText(format);
            this.u.setSelection(format.length());
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            layoutParams.width = -1;
            this.u.setLayoutParams(layoutParams);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.y.setOnClickListener(this);
            R(this.q, 0, 50);
            R(this.s, 0, 500);
            this.D.setListener(new d(this));
            this.u.addTextChangedListener(new e(this));
            this.v.addTextChangedListener(new f(this));
        }
    }

    public final void U() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.C == null && (relativeLayout = this.j) != null) {
            lr6 lr6Var = new lr6(this.a, relativeLayout);
            this.C = lr6Var;
            lr6Var.L(R.drawable.bg_tip_blue_up_left);
            this.C.o(16);
            this.C.x(true);
            this.C.N(true);
            this.C.n(3000);
            this.C.Q(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.C.T(this.a.getString(R.string.obfuscated_res_0x7f0f07bc), "key_forum_rule_first_edit");
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.E.size() > 0 && this.x != null) {
            bl7 bl7Var = this.E.get(0);
            this.x.removeView(bl7Var.m());
            this.E.remove(bl7Var);
            K();
            N();
        }
    }

    public final void N() {
        List<bl7> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (list = this.E) != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.E.size(); i2++) {
                bl7 bl7Var = this.E.get(i2);
                bl7Var.t(i2);
                bl7Var.s(i2);
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.E.get(0) != null) {
            if (this.E.size() == 1) {
                this.E.get(0).q(false);
            } else {
                this.E.get(0).q(true);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            C();
            q(R.string.obfuscated_res_0x7f0f07b2, R.string.obfuscated_res_0x7f0f07b1);
            q(R.string.obfuscated_res_0x7f0f07be, R.string.obfuscated_res_0x7f0f07bd);
            q(R.string.obfuscated_res_0x7f0f07b6, R.string.obfuscated_res_0x7f0f07b5);
            q(R.string.obfuscated_res_0x7f0f07ab, R.string.obfuscated_res_0x7f0f07aa);
            s(false, null, false);
        }
    }

    public void D() {
        u45 u45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (u45Var = this.J) != null && u45Var.isShowing()) {
            this.J.dismiss();
        }
    }

    public final void E() {
        lr6 lr6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (lr6Var = this.C) != null) {
            lr6Var.h();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.G = null;
            this.F = null;
            this.e = null;
            this.f = null;
            D();
            this.J = null;
            this.K = null;
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.A == null) {
            return;
        }
        if (A()) {
            this.A.setEnabled(true);
        } else {
            this.A.setEnabled(false);
        }
    }

    public void T() {
        ForumRulesEditActivity forumRulesEditActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.J != null && (forumRulesEditActivity = this.f) != null && !forumRulesEditActivity.isFinishing()) {
            this.J.l();
        }
    }

    public final void F(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, str) == null) {
            this.g = view2;
            this.y = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0918b6);
            this.w = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f9c);
            this.D = (EditorScrollView) view2.findViewById(R.id.obfuscated_res_0x7f0920e2);
            this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090bba);
            this.j = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c26);
            this.m = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090bb9);
            this.o = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090bbb);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f090c25);
            this.u = (EditText) view2.findViewById(R.id.obfuscated_res_0x7f090a4b);
            this.p = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092795);
            this.q = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09257f);
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f090c23);
            this.r = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091d1c);
            this.v = (EditText) view2.findViewById(R.id.obfuscated_res_0x7f091d1a);
            this.s = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091d1b);
            this.x = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0915fa);
            this.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090819);
            this.t = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090818);
            this.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09081a);
            TextView addTextButton = this.y.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.a.getString(R.string.obfuscated_res_0x7f0f058b), null);
            this.B = addTextButton;
            addTextButton.setId(R.id.negative_feedback_view);
            this.B.setOnClickListener(this);
            this.y.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f07ba));
            EMTextView eMTextView = new EMTextView(this.a.getPageActivity());
            this.z = eMTextView;
            eMTextView.setText(this.a.getString(R.string.video_preview));
            this.z.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.gravity = 17;
            this.z.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
            this.z.setLayoutParams(layoutParams);
            this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.z, this);
            EMTextView eMTextView2 = new EMTextView(this.a.getPageActivity());
            this.A = eMTextView2;
            eMTextView2.setText(this.a.getString(R.string.push_commit));
            this.A.setEnabled(false);
            this.A.setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            this.A.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
            this.A.setLayoutParams(layoutParams2);
            this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.A, this);
            G();
            U();
            s(false, null, false);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.J == null) {
                w45 w45Var = new w45(this.a.getPageActivity());
                this.K = w45Var;
                w45Var.t(this.a.getString(R.string.obfuscated_res_0x7f0f07c0));
                this.J = new u45(this.a, this.K);
                ArrayList arrayList = new ArrayList();
                s45 s45Var = new s45(this.a.getString(R.string.obfuscated_res_0x7f0f12cc), this.K);
                s45Var.q(R.color.CAM_X0302);
                s45Var.m(this.N);
                arrayList.add(s45Var);
                s45 s45Var2 = new s45(this.a.getString(R.string.not_save), this.K);
                s45Var2.m(this.O);
                arrayList.add(s45Var2);
                this.K.o(new j(this));
                this.K.l(arrayList);
            }
            T();
        }
    }

    public final void K() {
        List<bl7> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (list = this.E) != null) {
            if (list.size() >= 20) {
                this.t.setText(this.a.getString(R.string.obfuscated_res_0x7f0f07c6));
                this.k.setEnabled(false);
                this.t.setEnabled(false);
                this.H = false;
                this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b33, y9a.a(SkinManager.getColor(R.color.CAM_X0105), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_PRESS));
                EMManager.from(this.k).setBorderColor(R.color.CAM_X0902).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X07).setAlpha(R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
                return;
            }
            this.t.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07c2), Integer.valueOf(20 - this.E.size())));
            this.k.setEnabled(true);
            this.t.setEnabled(true);
            this.H = true;
            this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b33, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            EMManager.from(this.k).setBorderColor(R.color.CAM_X0902).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X07).setAlpha(R.string.A_X01).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            J();
            if (y()) {
                return;
            }
            ForumRuleBaseData forumRuleBaseData = this.F;
            if (forumRuleBaseData != null) {
                if (forumRuleBaseData.getTitle().length() > 50) {
                    D();
                    W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07bf), this.a.getString(R.string.obfuscated_res_0x7f0f07b0), 50));
                    return;
                }
                if (this.F.getList() != null) {
                    for (int i2 = 0; i2 < this.F.getList().size(); i2++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.F.getList().get(i2);
                        if (forumRuleItemData != null) {
                            if (forumRuleItemData.getTitle().length() > 50) {
                                D();
                                W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07bf), this.a.getString(R.string.obfuscated_res_0x7f0f07af), 50));
                                return;
                            } else if (forumRuleItemData.getContent().length() > 1000) {
                                D();
                                W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07bf), this.a.getString(R.string.obfuscated_res_0x7f0f07ae), 1000));
                                return;
                            }
                        }
                    }
                }
                if (this.F.getPreface().length() > 600) {
                    D();
                    W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07bf), this.a.getString(R.string.obfuscated_res_0x7f0f07b4), 600));
                    return;
                }
            }
            this.e.U0(this.F, true);
        }
    }

    public void Q(ForumRuleBaseData forumRuleBaseData, boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048591, this, forumRuleBaseData, z) == null) && this.g != null && forumRuleBaseData != null) {
            this.u.setText(forumRuleBaseData.getTitle());
            EditText editText = this.u;
            if (forumRuleBaseData.getTitle() != null) {
                i2 = forumRuleBaseData.getTitle().length();
            } else {
                i2 = 0;
            }
            editText.setSelection(i2);
            this.v.setText(forumRuleBaseData.getPreface());
            EditText editText2 = this.v;
            if (forumRuleBaseData.getPreface() != null) {
                i3 = forumRuleBaseData.getPreface().length();
            } else {
                i3 = 0;
            }
            editText2.setSelection(i3);
            if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
                bl7 bl7Var = this.E.get(0);
                this.x.removeView(bl7Var.m());
                this.E.remove(bl7Var);
                for (int i4 = 0; i4 < forumRuleBaseData.getPbDataList().size(); i4++) {
                    s(false, forumRuleBaseData.getPbDataList().get(i4), !z);
                }
                return;
            }
            C();
        }
    }

    public final void V(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            new TBAlertBuilder(this.a.getPageActivity()).setTitle(R.string.obfuscated_res_0x7f0f07c5).setDesc(R.string.obfuscated_res_0x7f0f07c4).setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.next_time, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig((int) R.string.del_post, TBAlertConfig.OperateBtnStyle.MAIN, new b(this, onClickListener))).setAutoClose().setCancelable(false).show();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            if (i2 == 0 && !this.L) {
                if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                    zk7.c(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20), this.v);
                    this.L = true;
                } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                    zk7.c(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20), this.v);
                    this.L = true;
                }
            } else if (this.L) {
                this.L = false;
                zk7.c(0, 0, this.v);
            }
        }
    }

    public final void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            BdTopToast bdTopToast = this.G;
            if (bdTopToast == null || !bdTopToast.isShown()) {
                BdTopToast content = new BdTopToast(this.a.getPageActivity(), 2000).setIcon(false).setContent(str);
                this.G = content;
                content.show((ViewGroup) this.g.findViewById(R.id.obfuscated_res_0x7f091610));
            }
        }
    }

    public final void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 > 0) {
                this.p.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
                layoutParams.width = -1;
                this.u.setLayoutParams(layoutParams);
                return;
            }
            this.p.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.u.getLayoutParams();
            layoutParams2.width = -2;
            this.u.setLayoutParams(layoutParams2);
        }
    }

    public final void r(bl7 bl7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, bl7Var) == null) && bl7Var != null) {
            this.x.addView(bl7Var.m());
            this.E.add(bl7Var);
            S();
            if (this.E.indexOf(bl7Var) != -1) {
                bl7Var.t(this.E.indexOf(bl7Var));
                bl7Var.s(this.E.indexOf(bl7Var));
            }
            M();
            K();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            if (view2 == this.B) {
                I();
            } else if (view2 == this.A) {
                x();
            } else if (view2 == this.z) {
                J();
                this.a.sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this.a.getPageActivity(), this.b, this.c, this.F, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.d, this.I)));
            } else if (view2 == this.j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(this.c, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
            } else if (view2 == this.p) {
                B();
            } else if (view2 != this.w && view2 != this.y) {
                if (view2 == this.k) {
                    SafeHandler.getInst().removeCallbacks(this.M);
                    SafeHandler.getInst().postDelayed(this.M, 300L);
                }
            } else {
                BdUtilHelper.hideSoftKeyPad(this.a.getPageActivity(), this.u);
                BdUtilHelper.hideSoftKeyPad(this.a.getPageActivity(), this.v);
            }
        }
    }

    public final void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) && this.x != null) {
            bl7 bl7Var = new bl7(this.a.getPageActivity());
            P(bl7Var);
            r(bl7Var);
            String string = TbadkApplication.getInst().getResources().getString(i2);
            String string2 = TbadkApplication.getInst().getResources().getString(i3);
            bl7Var.l().setText(string);
            bl7Var.l().setSelection(string.length());
            bl7Var.k().insert(string2);
            bl7Var.k().setSelection(bl7Var.k().getText().toString().length());
        }
    }

    public final void s(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), forumRuleItemPbData, Boolean.valueOf(z2)}) == null) && this.x != null) {
            bl7 bl7Var = new bl7(this.a.getPageActivity());
            P(bl7Var);
            r(bl7Var);
            if (forumRuleItemPbData != null) {
                bl7Var.l().setText(forumRuleItemPbData.title);
                EditText l = bl7Var.l();
                String str = forumRuleItemPbData.title;
                if (str != null) {
                    i2 = str.length();
                } else {
                    i2 = 0;
                }
                l.setSelection(i2);
                if (forumRuleItemPbData.mContent != null) {
                    for (int i3 = 0; i3 < forumRuleItemPbData.mContent.size(); i3++) {
                        ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i3);
                        if (forumRuleItemPbContentData != null) {
                            if ("a".equals(forumRuleItemPbContentData.tag)) {
                                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                                SpanGroupEditText k2 = bl7Var.k();
                                tbLinkSpanGroup.a(k2.getText(), k2.getSelectionEnd(), k2.getSelectionEnd(), (int) k2.getTextSize());
                                tbLinkSpanGroup.E(forumRuleItemPbContentData.href);
                                tbLinkSpanGroup.C(forumRuleItemPbContentData.value);
                                tbLinkSpanGroup.t();
                                k2.getSpanGroupManager().K(tbLinkSpanGroup);
                            } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                bl7Var.k().insert(forumRuleItemPbContentData.value);
                            } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                                bl7Var.k().insert("\r\n");
                            }
                        }
                    }
                }
                bl7Var.k().setSelection(bl7Var.k().getText().toString().length());
                if (z2 && "1".equals(forumRuleItemPbData.status)) {
                    bl7Var.l().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    bl7Var.k().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                    bl7Var.r(true);
                }
            }
            if (z) {
                SafeHandler.getInst().post(new i(this));
            }
        }
    }

    public void u(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048604, this, i2) == null) && this.g != null) {
            EMManager.from(this.w).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.o).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.h).setBackGroundColor(R.color.CAM_X0210);
            EMManager.from(this.i).setBackGroundColor(R.color.CAM_X0210);
            EMManager.from(this.q).setTextColor(R.color.CAM_X0111);
            EMManager.from(this.s).setTextColor(R.color.CAM_X0111);
            EMManager.from(this.p).setTextColor(R.color.CAM_X0304).setTextStyle(R.string.F_X02);
            EMManager.from(this.r).setTextColor(R.color.CAM_X0107).setTextStyle(R.string.F_X02);
            EMManager.from(this.B).setTextSelectorColor(R.color.CAM_X0105);
            EMManager.from(this.z).setTextSelectorColor(R.color.CAM_X0302).setTextSize(R.dimen.T_X05);
            EMManager.from(this.A).setTextSize(R.dimen.T_X05);
            this.A.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            this.t.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
            this.u.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.u.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.v.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.l.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b42, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (this.H) {
                this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b33, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b33, y9a.a(SkinManager.getColor(R.color.CAM_X0304), SkinManager.RESOURCE_ALPHA_PRESS), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            NavigationBar navigationBar = this.y;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i2);
            }
            w45 w45Var = this.K;
            if (w45Var != null) {
                w45Var.j();
            }
            if (i2 == 0) {
                WriteVideoUtil.setCursorColor(this.u, R.drawable.edittext_cursor);
                WriteVideoUtil.setCursorColor(this.v, R.drawable.edittext_cursor);
            } else {
                WriteVideoUtil.setCursorColor(this.u, R.drawable.edittext_cursor_2);
                WriteVideoUtil.setCursorColor(this.v, R.drawable.edittext_cursor_2);
            }
            EMManager corner = EMManager.from(this.k).setBorderColor(R.color.CAM_X0902).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X07);
            if (this.H) {
                i3 = R.string.A_X01;
            } else {
                i3 = R.string.A_X09;
            }
            corner.setAlpha(i3).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            EditText editText = this.u;
            if (editText != null && editText.getText().toString().length() > 50) {
                W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07a7), this.a.getString(R.string.obfuscated_res_0x7f0f07b0)));
                return;
            }
            List<bl7> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    bl7 bl7Var = this.E.get(i2);
                    EditText l = bl7Var.l();
                    SpanGroupEditText k2 = bl7Var.k();
                    if (l != null && l.getText().toString().trim().length() > 30) {
                        W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07a7), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07ad), zk7.d(i2 + 1), this.a.getString(R.string.obfuscated_res_0x7f0f07c8))));
                        return;
                    } else if (k2 != null && k2.getText().toString().length() > 1000) {
                        W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07a7), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07ad), zk7.d(i2 + 1), this.a.getString(R.string.obfuscated_res_0x7f0f07a8))));
                        return;
                    }
                }
            }
            EditText editText2 = this.v;
            if (editText2 != null && editText2.getText().toString().length() > 500) {
                W(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07a7), this.a.getString(R.string.obfuscated_res_0x7f0f07b4)));
                return;
            }
            J();
            this.e.U0(this.F, false);
        }
    }
}
