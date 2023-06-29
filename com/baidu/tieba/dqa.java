package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QuestionTagChooseActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.cqa;
import com.baidu.tieba.write.data.QuestionTagListData;
import com.baidu.tieba.write.write.relevance.list.XLinearLayoutManager;
import com.baidu.tieba.write.write.tag.QuestionTagAdapter;
import com.baidu.tieba.write.write.tag.QuestionTagChooseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class dqa implements st5, ho {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final NavigationBar b;
    @NonNull
    public final QuestionTagChooseActivity c;
    public LinearLayout d;
    public ImageView e;
    public EditText f;
    public NestedScrollView g;
    public ConstraintLayout h;
    public TextView i;
    public TextView j;
    public FrameLayout k;
    public BdTypeRecyclerView l;
    public PbListView m;
    public dn5 n;
    public en5 o;
    public Intent p;
    public String q;
    public cqa r;

    @Override // com.baidu.tieba.st5
    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dqa a;

        public a(dqa dqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dqaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dqaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.p = null;
            this.a.c.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dqa a;

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

        public b(dqa dqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dqaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dqaVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable == null) {
                    obj = null;
                } else {
                    obj = editable.toString();
                }
                if (this.a.r != null) {
                    this.a.r.i(obj);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dqa a;

        public c(dqa dqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dqaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dqaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p = new Intent();
                this.a.p.putExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_CREATE_TAG, true);
                this.a.c.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements NestedScrollView.OnScrollChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dqa a;

        public d(dqa dqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dqaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dqaVar;
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{nestedScrollView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) != null && i2 >= nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getMeasuredHeight() - nestedScrollView.getMeasuredHeight() && i2 > i4) {
                this.a.D();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dqa a;

        public e(dqa dqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dqaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dqaVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    xi.z(this.a.c, this.a.a);
                    this.a.f.clearFocus();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements cqa.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dqa a;

        public f(dqa dqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dqaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dqaVar;
        }

        @Override // com.baidu.tieba.cqa.b
        public void a(boolean z, List<xn> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.a.t();
                this.a.u();
                if (ListUtils.isEmpty(list)) {
                    this.a.l.setVisibility(8);
                    this.a.H();
                    return;
                }
                this.a.l.setVisibility(0);
                this.a.l.setData(list);
                if (!z) {
                    this.a.G();
                } else {
                    this.a.F();
                }
            }
        }

        @Override // com.baidu.tieba.cqa.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    if (this.a.l.getAdapter() != null) {
                        this.a.l.getData().clear();
                        this.a.l.getAdapter().notifyDataSetChanged();
                    }
                    this.a.l.setVisibility(8);
                    this.a.J();
                } else {
                    this.a.l.setVisibility(0);
                    this.a.F();
                }
                this.a.u();
            }
        }

        @Override // com.baidu.tieba.cqa.b
        public void c(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
                if (z) {
                    this.a.l.setVisibility(0);
                    this.a.E();
                    return;
                }
                this.a.l.setVisibility(8);
                this.a.t();
                this.a.I(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dqa a;

        public g(dqa dqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dqaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dqaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.D();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dqa a;

        public h(dqa dqaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dqaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dqaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f == null) {
                    obj = null;
                } else {
                    obj = this.a.f.getText().toString();
                }
                this.a.r.i(obj);
            }
        }
    }

    public dqa(@NonNull LinearLayout linearLayout, @NonNull NavigationBar navigationBar, @NonNull QuestionTagChooseActivity questionTagChooseActivity, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {linearLayout, navigationBar, questionTagChooseActivity, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = linearLayout;
        this.b = navigationBar;
        this.c = questionTagChooseActivity;
        this.q = str;
        w();
        y();
    }

    public final void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(8);
            }
            K(str, false);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.setCenterTextTitle(this.c.getString(R.string.activity_select_tag_title));
            this.b.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
            this.b.setIsClose(true);
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m.H(this.c.getResources().getString(R.string.list_click_load_more));
            this.m.g();
            this.m.P(xi.g(this.l.getContext(), R.dimen.tbds44));
            this.m.G(new g(this));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.m.N();
            this.m.U();
            this.m.H(this.c.getString(R.string.list_loading));
            this.m.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.m.G(null);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.m.H(this.c.getResources().getString(R.string.list_no_more));
            this.m.g();
            this.m.P(xi.g(this.l.getContext(), R.dimen.tbds44));
            this.m.G(null);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.k == null) {
            return;
        }
        dn5 dn5Var = this.n;
        if (dn5Var != null && dn5Var.isViewAttached()) {
            return;
        }
        if (this.n == null) {
            this.n = new dn5(this.c);
        }
        this.n.attachView(this.k);
        this.n.t(xi.g(this.c, R.dimen.tbds300));
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g.setNestedScrollingEnabled(false);
            this.g.setOnScrollChangeListener(new d(this));
            this.l.setLayoutManager(new XLinearLayoutManager(this.a.getContext()));
            PbListView pbListView = new PbListView(this.a.getContext());
            this.m = pbListView;
            pbListView.a();
            this.m.s(R.color.CAM_X0205);
            this.m.B();
            this.m.J(SkinManager.getColor(R.color.CAM_X0107));
            this.m.L(R.dimen.tbfontsize33);
            this.m.F(R.color.CAM_X0110);
            this.l.setNextPage(this.m);
            this.l.addOnScrollListener(new e(this));
            F();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f.addTextChangedListener(new b(this));
        }
    }

    public final void D() {
        cqa cqaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (cqaVar = this.r) == null) {
            return;
        }
        if (cqaVar.h(false)) {
            F();
        } else {
            G();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(8);
            }
            K(this.c.getString(R.string.new_text_no_search_result), true);
        }
    }

    @Override // com.baidu.tieba.st5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.p;
        }
        return (Intent) invokeV.objValue;
    }

    public void onDestroy() {
        cqa cqaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (cqaVar = this.r) != null) {
            cqaVar.n();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final cqa.b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return new f(this);
        }
        return (cqa.b) invokeV.objValue;
    }

    public final void t() {
        dn5 dn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.k != null && (dn5Var = this.n) != null && dn5Var.isViewAttached()) {
            this.n.dettachView(this.k);
        }
    }

    public final void u() {
        en5 en5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.k != null && (en5Var = this.o) != null && en5Var.isViewAttached()) {
            this.o.dettachView(this.k);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ArrayList arrayList = new ArrayList();
            QuestionTagAdapter questionTagAdapter = new QuestionTagAdapter(this.c, QuestionTagListData.QuestionTag.TYPE_TAG);
            questionTagAdapter.setOnAdapterItemClickListener(this);
            arrayList.add(questionTagAdapter);
            this.l.addAdapters(arrayList);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.h.setOnClickListener(new c(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            cqa cqaVar = new cqa();
            this.r = cqaVar;
            cqaVar.j();
            this.r.m(this.q);
            this.r.l(s());
            this.r.i(null);
        }
    }

    @Override // com.baidu.tieba.st5
    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            NestedScrollView nestedScrollView = this.g;
            if (nestedScrollView == null || nestedScrollView.getScrollY() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void K(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048586, this, str, z) != null) || this.k == null) {
            return;
        }
        en5 en5Var = this.o;
        if (en5Var != null && en5Var.isViewAttached()) {
            return;
        }
        if (this.o == null) {
            this.o = new en5(this.c, new h(this));
        }
        if (z) {
            this.o.i(R.drawable.new_pic_emotion_10);
            this.o.e();
        } else {
            this.o.i(R.drawable.new_pic_emotion_08);
            this.o.p();
        }
        this.o.o(str);
        this.o.attachView(this.k, true);
        this.o.f(R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ho
    public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof QuestionTagListData.QuestionTag)) {
            Intent intent = new Intent();
            this.p = intent;
            intent.putExtra(QuestionTagChooseActivityConfig.KEY_RESPONSE_TAG, (QuestionTagListData.QuestionTag) xnVar);
            this.c.finish();
        }
    }

    @Override // com.baidu.tieba.st5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0302);
            s75 d2 = s75.d(this.d);
            d2.o(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            this.f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView != null && bdTypeRecyclerView.getAdapter() != null) {
                this.l.getAdapter().notifyDataSetChanged();
            }
            PbListView pbListView = this.m;
            if (pbListView != null) {
                pbListView.e(i);
            }
            en5 en5Var = this.o;
            if (en5Var != null) {
                en5Var.onChangeSkinType();
                this.o.f(R.color.CAM_X0201);
            }
            if (this.b.getBackImageView() != null) {
                this.b.getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_close40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LayoutInflater.from(this.c).inflate(R.layout.obfuscated_res_0x7f0d0538, (ViewGroup) this.a, true);
            this.d = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09209f);
            this.e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0920b1);
            this.f = (EditText) this.a.findViewById(R.id.obfuscated_res_0x7f0920cb);
            this.g = (NestedScrollView) this.a.findViewById(R.id.obfuscated_res_0x7f0918c8);
            this.h = (ConstraintLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09080c);
            this.i = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092358);
            this.j = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09080b);
            this.k = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0920bd);
            this.l = (BdTypeRecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f0920c5);
            A();
            C();
            x();
            B();
            v();
            q(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
