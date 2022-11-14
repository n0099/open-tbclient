package com.baidu.tieba.hottopicselect;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import com.baidu.tieba.o97;
import com.baidu.tieba.p97;
import com.baidu.tieba.q97;
import com.baidu.tieba.r97;
import com.baidu.tieba.rf5;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements rf5, HotTopicSelectModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExpandableListView.OnGroupClickListener A;
    public final ExpandableListView.OnChildClickListener B;
    public HotTopicSelectModel k;
    public final List<q97> l;
    public View m;
    public BdListView n;
    public ExpandableListView o;
    public r97 p;
    public o97 q;
    public ViewGroup r;
    public EditText s;
    public TextView t;
    public NoDataView u;
    public ImageView v;
    public TextView w;
    public Intent x;
    public final View.OnClickListener y;
    public final AdapterView.OnItemClickListener z;

    @Override // com.baidu.tieba.rf5
    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.tieba.rf5
    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicSelectActivity a;

        public a(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicSelectActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 != this.a.v) {
                    if (view2 != this.a.t) {
                        return;
                    }
                    this.a.x1("");
                    return;
                }
                this.a.v1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicSelectActivity a;

        public b(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicSelectActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            q97 q97Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && (q97Var = (q97) ListUtils.getItem(this.a.q.d(), i)) != null) {
                String b = q97Var.b();
                this.a.x1(b);
                this.a.t1(b, 3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ExpandableListView.OnGroupClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicSelectActivity a;

        public c(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicSelectActivity;
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                if (this.a.o != null) {
                    this.a.o.expandGroup(i);
                    return true;
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ExpandableListView.OnChildClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicSelectActivity a;

        public d(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicSelectActivity;
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view2, int i, int i2, long j) {
            InterceptResult invokeCommon;
            q97 child;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                if (this.a.p != null && (child = this.a.p.getChild(i, i2)) != null) {
                    String b = child.b();
                    this.a.x1(b);
                    p97 group = this.a.p.getGroup(i);
                    if (group != null) {
                        if (group.getType() == 0) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        this.a.t1(b, i3);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicSelectActivity a;

        public e(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicSelectActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && !z) {
                yi.z(this.a.getPageContext().getPageActivity(), view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicSelectActivity a;

        public f(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicSelectActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 6) {
                    yi.N(this.a.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(this.a.z1())) {
                        HotTopicSelectActivity hotTopicSelectActivity = this.a;
                        hotTopicSelectActivity.x1(hotTopicSelectActivity.z1());
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicSelectActivity a;

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

        public g(HotTopicSelectActivity hotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicSelectActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = editable.toString();
                if (obj == null || obj.trim().length() <= 0) {
                    this.a.u1();
                } else {
                    this.a.u.setVisibility(8);
                    this.a.m.setVisibility(8);
                    this.a.F1();
                    this.a.k.N(obj);
                }
                this.a.D1(!StringUtils.isNull(editable.toString()));
                this.a.E1();
            }
        }
    }

    public HotTopicSelectActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.y = new a(this);
        this.z = new b(this);
        this.A = new c(this);
        this.B = new d(this);
    }

    public final void E1() {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (editText = this.s) != null && this.w != null) {
            if (TextUtils.isEmpty(editText.getText())) {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0105, 1);
            }
        }
    }

    @Override // com.baidu.tieba.rf5
    public boolean s() {
        InterceptResult invokeV;
        ListView listView;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.n.getVisibility() == 0) {
                listView = this.n;
            } else {
                listView = this.o;
            }
            if (listView == null || listView.getFirstVisiblePosition() != 0 || (childAt = listView.getChildAt(0)) == null || childAt.getTop() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            this.q.b();
            r97 r97Var = this.p;
            if (r97Var != null && !ListUtils.isEmpty(r97Var.f())) {
                this.m.setVisibility(0);
                return;
            }
            F1();
            this.k.E();
        }
    }

    public void D1(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            ImageView imageView = this.v;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public final q97 y1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            q97 q97Var = new q97();
            q97Var.d(str);
            return q97Var;
        }
        return (q97) invokeL.objValue;
    }

    public final void t1(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, str, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c11665");
            statisticItem.param("obj_name", str);
            statisticItem.param("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void A0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            hideLoadingView(this.r);
            String z1 = z1();
            q97 y1 = y1(z1);
            this.l.clear();
            this.l.add(y1);
            this.q.e(z1, this.l);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            HotTopicSelectModel hotTopicSelectModel = new HotTopicSelectModel(getPageContext(), this);
            this.k = hotTopicSelectModel;
            hotTopicSelectModel.I(getIntent());
            this.k.L();
            B1();
            getWindow().setSoftInputMode(1);
            F1();
            this.k.M();
        }
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091e5d);
            this.s = editText;
            editText.setCompoundDrawablePadding(yi.g(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070302));
            this.s.setOnFocusChangeListener(new e(this));
            this.s.setOnEditorActionListener(new f(this));
            this.s.addTextChangedListener(new g(this));
            this.s.requestFocus();
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.r = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090af0);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f090447);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f09235c);
            this.v = (ImageView) findViewById(R.id.obfuscated_res_0x7f09065d);
            this.m = findViewById(R.id.obfuscated_res_0x7f090dda);
            this.n = (BdListView) findViewById(R.id.obfuscated_res_0x7f090dd1);
            this.u = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0702bf)), null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.r.addView(this.u, layoutParams);
            this.u.setVisibility(8);
            o97 o97Var = new o97(getPageContext());
            this.q = o97Var;
            this.n.setAdapter((ListAdapter) o97Var);
            this.o = (ExpandableListView) findViewById(R.id.obfuscated_res_0x7f090dd2);
            r97 r97Var = new r97(getPageContext());
            this.p = r97Var;
            this.o.setAdapter(r97Var);
            this.n.setOnItemClickListener(this.z);
            this.o.setOnGroupClickListener(this.A);
            this.o.setOnChildClickListener(this.B);
            this.t.setOnClickListener(this.y);
            this.v.setOnClickListener(this.y);
            D1(false);
            A1();
        }
    }

    public final void C1(p97 p97Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048579, this, p97Var, z) == null) && p97Var != null && !ListUtils.isEmpty(p97Var.b())) {
            if (TextUtils.isEmpty(p97Var.a())) {
                if (z) {
                    i = R.string.obfuscated_res_0x7f0f0830;
                } else {
                    i = R.string.obfuscated_res_0x7f0f0831;
                }
                p97Var.e(getString(i));
            }
            this.p.g(p97Var);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public rf5 N0(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, linearLayout, navigationBar)) == null) {
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d03a3, (ViewGroup) navigationBar.getContentLayout(), true);
            this.e.setVisibility(8);
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d03a5, (ViewGroup) linearLayout, true);
            return this;
        }
        return (rf5) invokeLL.objValue;
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.m.setVisibility(8);
            showLoadingView(this.r, true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07029e));
        }
    }

    @Override // com.baidu.tieba.rf5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.x;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            x1("");
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.k.onDestroy();
            this.u.e();
            hideLoadingView(this.r);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStop();
            setSkinType(3);
            NoDataView noDataView = this.u;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.k.O("");
            this.s.setText("");
        }
    }

    public final String z1() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            HotTopicSelectModel hotTopicSelectModel = this.k;
            if (hotTopicSelectModel == null) {
                str = "";
            } else {
                str = hotTopicSelectModel.F();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void H0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            hideLoadingView(this.r);
            this.m.setVisibility(8);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.u.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c81));
                this.u.setVisibility(0);
            } else if (!TextUtils.isEmpty(str)) {
                this.u.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f100d));
                this.u.setVisibility(0);
                showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void m0(p97 p97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, p97Var) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            hideLoadingView(this.r);
            this.l.clear();
            String z1 = z1();
            this.l.add(y1(z1));
            if (p97Var != null && p97Var.b() != null) {
                this.l.addAll(p97Var.b());
                this.q.e(z1, this.l);
                return;
            }
            this.q.e(z1, this.l);
        }
    }

    public final void x1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            EditText editText = this.s;
            if (editText != null && editText.hasFocus()) {
                yi.z(getPageContext().getPageActivity(), this.s);
            }
            if (TextUtils.isEmpty(str)) {
                setResult(0, new Intent());
            } else {
                this.x = new Intent();
                this.x.putExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING, str + HotSelectActivityConfig.HOT_TOPIC_SING);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            super.onChangeSkinType(i);
            this.mSkinType = i;
            NoDataView noDataView = this.u;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
            o97 o97Var = this.q;
            if (o97Var != null) {
                o97Var.notifyDataSetChanged();
            }
            r97 r97Var = this.p;
            if (r97Var != null) {
                r97Var.notifyDataSetChanged();
            }
            EditText editText = this.s;
            if (editText != null) {
                editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 2);
            SkinManager.setImageResource(this.v, R.drawable.del_search_btn);
            E1();
            if (this.mSkinType == 2) {
                StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
            }
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void u0(p97 p97Var, p97 p97Var2, p97 p97Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, p97Var, p97Var2, p97Var3) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            hideLoadingView(this.r);
            this.p.c();
            C1(p97Var, true);
            C1(p97Var2, false);
            this.p.notifyDataSetChanged();
            int count = this.o.getCount();
            for (int i = 0; i < count; i++) {
                this.o.expandGroup(i);
            }
        }
    }
}
