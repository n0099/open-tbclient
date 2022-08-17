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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hb5;
import com.repackage.k57;
import com.repackage.l57;
import com.repackage.m57;
import com.repackage.n57;
import com.repackage.oi;
import com.repackage.qi;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements hb5, HotTopicSelectModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExpandableListView.OnGroupClickListener A;
    public final ExpandableListView.OnChildClickListener B;
    public HotTopicSelectModel k;
    public final List<m57> l;
    public View m;
    public BdListView n;
    public ExpandableListView o;
    public n57 p;
    public k57 q;
    public ViewGroup r;
    public EditText s;
    public TextView t;
    public NoDataView u;
    public ImageView v;
    public TextView w;
    public Intent x;
    public final View.OnClickListener y;
    public final AdapterView.OnItemClickListener z;

    /* loaded from: classes3.dex */
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
                if (view2 == this.a.v) {
                    this.a.p1();
                } else if (view2 == this.a.t) {
                    this.a.q1("");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            m57 m57Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (m57Var = (m57) ListUtils.getItem(this.a.q.d(), i)) == null) {
                return;
            }
            String b = m57Var.b();
            this.a.q1(b);
            this.a.n1(b, 3);
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            m57 child;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                if (this.a.p == null || (child = this.a.p.getChild(i, i2)) == null) {
                    return false;
                }
                String b = child.b();
                this.a.q1(b);
                l57 group = this.a.p.getGroup(i);
                if (group != null) {
                    this.a.n1(b, group.getType() == 0 ? 1 : 2);
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) || z) {
                return;
            }
            qi.x(this.a.getPageContext().getPageActivity(), view2);
        }
    }

    /* loaded from: classes3.dex */
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
                    qi.L(this.a.getPageContext().getPageActivity(), textView);
                    if (TextUtils.isEmpty(this.a.s1())) {
                        return true;
                    }
                    HotTopicSelectActivity hotTopicSelectActivity = this.a;
                    hotTopicSelectActivity.q1(hotTopicSelectActivity.s1());
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicSelectActivity a;

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
                    this.a.o1();
                } else {
                    this.a.u.setVisibility(8);
                    this.a.m.setVisibility(8);
                    this.a.z1();
                    this.a.k.N(obj);
                }
                this.a.w1(!StringUtils.isNull(editable.toString()));
                this.a.x1();
            }
        }

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

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public hb5 E0(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, linearLayout, navigationBar)) == null) {
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0398, (ViewGroup) navigationBar.getContentLayout(), true);
            this.e.setVisibility(8);
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d039a, (ViewGroup) linearLayout, true);
            return this;
        }
        return (hb5) invokeLL.objValue;
    }

    @Override // com.repackage.hb5
    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.repackage.hb5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.x : (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void h0(l57 l57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, l57Var) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            hideLoadingView(this.r);
            this.l.clear();
            String s1 = s1();
            this.l.add(r1(s1));
            if (l57Var != null && l57Var.b() != null) {
                this.l.addAll(l57Var.b());
                this.q.e(s1, this.l);
                return;
            }
            this.q.e(s1, this.l);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void m0(l57 l57Var, l57 l57Var2, l57 l57Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, l57Var, l57Var2, l57Var3) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            hideLoadingView(this.r);
            this.p.c();
            v1(l57Var, true);
            v1(l57Var2, false);
            this.p.notifyDataSetChanged();
            int count = this.o.getCount();
            for (int i = 0; i < count; i++) {
                this.o.expandGroup(i);
            }
        }
    }

    @Override // com.repackage.hb5
    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
        }
    }

    public final void n1(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c11665");
            statisticItem.param("obj_name", str);
            statisticItem.param("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            this.q.b();
            n57 n57Var = this.p;
            if (n57Var != null && !ListUtils.isEmpty(n57Var.f())) {
                this.m.setVisibility(0);
                return;
            }
            z1();
            this.k.E();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            q1("");
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            this.mSkinType = i;
            NoDataView noDataView = this.u;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
            k57 k57Var = this.q;
            if (k57Var != null) {
                k57Var.notifyDataSetChanged();
            }
            n57 n57Var = this.p;
            if (n57Var != null) {
                n57Var.notifyDataSetChanged();
            }
            EditText editText = this.s;
            if (editText != null) {
                editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 2);
            SkinManager.setImageResource(this.v, R.drawable.del_search_btn);
            x1();
            if (this.mSkinType == 2) {
                StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            HotTopicSelectModel hotTopicSelectModel = new HotTopicSelectModel(getPageContext(), this);
            this.k = hotTopicSelectModel;
            hotTopicSelectModel.I(getIntent());
            this.k.L();
            u1();
            getWindow().setSoftInputMode(1);
            z1();
            this.k.M();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k.onDestroy();
            this.u.e();
            hideLoadingView(this.r);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStop();
            setSkinType(3);
            NoDataView noDataView = this.u;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.k.O("");
            this.s.setText("");
        }
    }

    public final void q1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            EditText editText = this.s;
            if (editText != null && editText.hasFocus()) {
                qi.x(getPageContext().getPageActivity(), this.s);
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

    public final m57 r1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            m57 m57Var = new m57();
            m57Var.d(str);
            return m57Var;
        }
        return (m57) invokeL.objValue;
    }

    @Override // com.repackage.hb5
    public boolean s() {
        InterceptResult invokeV;
        ListView listView;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.n.getVisibility() == 0) {
                listView = this.n;
            } else {
                listView = this.o;
            }
            return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void s0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            hideLoadingView(this.r);
            String s1 = s1();
            m57 r1 = r1(s1);
            this.l.clear();
            this.l.add(r1);
            this.q.e(s1, this.l);
        }
    }

    public final String s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            HotTopicSelectModel hotTopicSelectModel = this.k;
            String F = hotTopicSelectModel != null ? hotTopicSelectModel.F() : "";
            return F != null ? F : "";
        }
        return (String) invokeV.objValue;
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091db9);
            this.s = editText;
            editText.setCompoundDrawablePadding(qi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070302));
            this.s.setOnFocusChangeListener(new e(this));
            this.s.setOnEditorActionListener(new f(this));
            this.s.addTextChangedListener(new g(this));
            this.s.requestFocus();
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.r = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090ab7);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f090424);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f0922b0);
            this.v = (ImageView) findViewById(R.id.obfuscated_res_0x7f090633);
            this.m = findViewById(R.id.obfuscated_res_0x7f090d81);
            this.n = (BdListView) findViewById(R.id.obfuscated_res_0x7f090d77);
            this.u = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0702bf)), null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.r.addView(this.u, layoutParams);
            this.u.setVisibility(8);
            k57 k57Var = new k57(getPageContext());
            this.q = k57Var;
            this.n.setAdapter((ListAdapter) k57Var);
            this.o = (ExpandableListView) findViewById(R.id.obfuscated_res_0x7f090d79);
            n57 n57Var = new n57(getPageContext());
            this.p = n57Var;
            this.o.setAdapter(n57Var);
            this.n.setOnItemClickListener(this.z);
            this.o.setOnGroupClickListener(this.A);
            this.o.setOnChildClickListener(this.B);
            this.t.setOnClickListener(this.y);
            this.v.setOnClickListener(this.y);
            w1(false);
            t1();
        }
    }

    public final void v1(l57 l57Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048598, this, l57Var, z) == null) || l57Var == null || ListUtils.isEmpty(l57Var.b())) {
            return;
        }
        if (TextUtils.isEmpty(l57Var.a())) {
            l57Var.e(getString(z ? R.string.obfuscated_res_0x7f0f0808 : R.string.obfuscated_res_0x7f0f0809));
        }
        this.p.g(l57Var);
    }

    public void w1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.v.setVisibility(z ? 0 : 8);
        }
    }

    public final void x1() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (editText = this.s) == null || this.w == null) {
            return;
        }
        if (TextUtils.isEmpty(editText.getText())) {
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0109, 1);
        } else {
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0105, 1);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void y0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            hideLoadingView(this.r);
            this.m.setVisibility(8);
            if (!oi.z()) {
                this.u.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c3d));
                this.u.setVisibility(0);
            } else if (TextUtils.isEmpty(str)) {
            } else {
                this.u.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0fba));
                this.u.setVisibility(0);
                showToast(str);
            }
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.m.setVisibility(8);
            showLoadingView(this.r, true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07029e));
        }
    }
}
