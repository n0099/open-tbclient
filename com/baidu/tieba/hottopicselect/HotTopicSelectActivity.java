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
import com.baidu.tieba.a68;
import com.baidu.tieba.b68;
import com.baidu.tieba.c68;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import com.baidu.tieba.it5;
import com.baidu.tieba.vi;
import com.baidu.tieba.z58;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class HotTopicSelectActivity extends SuspendedActivity implements it5, HotTopicSelectModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExpandableListView.OnGroupClickListener A;
    public final ExpandableListView.OnChildClickListener B;
    public HotTopicSelectModel k;
    public final List<b68> l;
    public View m;
    public BdListView n;
    public ExpandableListView o;
    public c68 p;
    public z58 q;
    public ViewGroup r;
    public EditText s;
    public TextView t;
    public NoDataView u;
    public ImageView v;
    public TextView w;
    public Intent x;
    public final View.OnClickListener y;
    public final AdapterView.OnItemClickListener z;

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.it5
    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.it5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
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
                    this.a.Z1("");
                    return;
                }
                this.a.Y1();
            }
        }
    }

    /* loaded from: classes6.dex */
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
            b68 b68Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && (b68Var = (b68) ListUtils.getItem(this.a.q.d(), i)) != null) {
                String b = b68Var.b();
                this.a.Z1(b);
                this.a.W1(b, 3);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
            b68 child;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                if (this.a.p != null && (child = this.a.p.getChild(i, i2)) != null) {
                    String b = child.b();
                    this.a.Z1(b);
                    a68 group = this.a.p.getGroup(i);
                    if (group != null) {
                        if (group.getType() == 0) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        this.a.W1(b, i3);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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
                vi.z(this.a.getPageContext().getPageActivity(), view2);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    vi.O(this.a.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(this.a.b2())) {
                        HotTopicSelectActivity hotTopicSelectActivity = this.a;
                        hotTopicSelectActivity.Z1(hotTopicSelectActivity.b2());
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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
                    this.a.X1();
                } else {
                    this.a.u.setVisibility(8);
                    this.a.m.setVisibility(8);
                    this.a.h2();
                    this.a.k.i0(obj);
                }
                this.a.f2(!StringUtils.isNull(editable.toString()));
                this.a.g2();
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

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            this.q.b();
            c68 c68Var = this.p;
            if (c68Var != null && !ListUtils.isEmpty(c68Var.f())) {
                this.m.setVisibility(0);
                return;
            }
            h2();
            this.k.Z();
        }
    }

    public final void g2() {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (editText = this.s) != null && this.w != null) {
            if (TextUtils.isEmpty(editText.getText())) {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0105, 1);
            }
        }
    }

    @Override // com.baidu.tieba.it5
    public boolean z() {
        InterceptResult invokeV;
        ListView listView;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
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

    public final b68 a2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            b68 b68Var = new b68();
            b68Var.d(str);
            return b68Var;
        }
        return (b68) invokeL.objValue;
    }

    public void f2(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            ImageView imageView = this.v;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public final void W1(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, str, i) == null) {
            StatisticItem statisticItem = new StatisticItem("c11665");
            statisticItem.param("obj_name", str);
            statisticItem.param("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void J0(a68 a68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a68Var) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            hideLoadingView(this.r);
            this.l.clear();
            String b2 = b2();
            this.l.add(a2(b2));
            if (a68Var != null && a68Var.b() != null) {
                this.l.addAll(a68Var.b());
                this.q.e(b2, this.l);
                return;
            }
            this.q.e(b2, this.l);
        }
    }

    public final void Z1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            EditText editText = this.s;
            if (editText != null && editText.hasFocus()) {
                vi.z(getPageContext().getPageActivity(), this.s);
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

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void n1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            hideLoadingView(this.r);
            this.m.setVisibility(8);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.u.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0def));
                this.u.setVisibility(0);
            } else if (!TextUtils.isEmpty(str)) {
                this.u.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
                this.u.setVisibility(0);
                showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void R0(a68 a68Var, a68 a68Var2, a68 a68Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, a68Var, a68Var2, a68Var3) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            hideLoadingView(this.r);
            this.p.c();
            e2(a68Var, true);
            e2(a68Var2, false);
            this.p.notifyDataSetChanged();
            int count = this.o.getCount();
            for (int i = 0; i < count; i++) {
                this.o.expandGroup(i);
            }
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k.j0("");
            this.s.setText("");
        }
    }

    public final String b2() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            HotTopicSelectModel hotTopicSelectModel = this.k;
            if (hotTopicSelectModel == null) {
                str = "";
            } else {
                str = hotTopicSelectModel.a0();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.it5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.x;
        }
        return (Intent) invokeV.objValue;
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.m.setVisibility(8);
            showLoadingView(this.r, true, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b6));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Z1("");
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.k.onDestroy();
            this.u.e();
            hideLoadingView(this.r);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onStop();
            setSkinType(3);
            NoDataView noDataView = this.u;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f092059);
            this.s = editText;
            editText.setCompoundDrawablePadding(vi.g(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070416));
            this.s.setOnFocusChangeListener(new e(this));
            this.s.setOnEditorActionListener(new f(this));
            this.s.addTextChangedListener(new g(this));
            this.s.requestFocus();
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.r = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090c15);
            this.t = (TextView) findViewById(R.id.btn_confirm);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f0925ac);
            this.v = (ImageView) findViewById(R.id.obfuscated_res_0x7f09070b);
            this.m = findViewById(R.id.obfuscated_res_0x7f090f51);
            this.n = (BdListView) findViewById(R.id.obfuscated_res_0x7f090f4a);
            this.u = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0703d3)), null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.r.addView(this.u, layoutParams);
            this.u.setVisibility(8);
            z58 z58Var = new z58(getPageContext());
            this.q = z58Var;
            this.n.setAdapter((ListAdapter) z58Var);
            this.o = (ExpandableListView) findViewById(R.id.obfuscated_res_0x7f090f4b);
            c68 c68Var = new c68(getPageContext());
            this.p = c68Var;
            this.o.setAdapter(c68Var);
            this.n.setOnItemClickListener(this.z);
            this.o.setOnGroupClickListener(this.A);
            this.o.setOnChildClickListener(this.B);
            this.t.setOnClickListener(this.y);
            this.v.setOnClickListener(this.y);
            f2(false);
            c2();
        }
    }

    public final void e2(a68 a68Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048588, this, a68Var, z) == null) && a68Var != null && !ListUtils.isEmpty(a68Var.b())) {
            if (TextUtils.isEmpty(a68Var.a())) {
                if (z) {
                    i = R.string.obfuscated_res_0x7f0f0961;
                } else {
                    i = R.string.obfuscated_res_0x7f0f0962;
                }
                a68Var.e(getString(i));
            }
            this.p.g(a68Var);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public it5 u1(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, linearLayout, navigationBar)) == null) {
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d03f5, (ViewGroup) navigationBar.getContentLayout(), true);
            this.e.setVisibility(8);
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d03f7, (ViewGroup) linearLayout, true);
            return this;
        }
        return (it5) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void g1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            hideLoadingView(this.r);
            String b2 = b2();
            b68 a2 = a2(b2);
            this.l.clear();
            this.l.add(a2);
            this.q.e(b2, this.l);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onCreate(bundle);
            HotTopicSelectModel hotTopicSelectModel = new HotTopicSelectModel(getPageContext(), this);
            this.k = hotTopicSelectModel;
            hotTopicSelectModel.d0(getIntent());
            this.k.g0();
            d2();
            getWindow().setSoftInputMode(1);
            h2();
            this.k.h0();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            super.onChangeSkinType(i);
            this.mSkinType = i;
            NoDataView noDataView = this.u;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
            z58 z58Var = this.q;
            if (z58Var != null) {
                z58Var.notifyDataSetChanged();
            }
            c68 c68Var = this.p;
            if (c68Var != null) {
                c68Var.notifyDataSetChanged();
            }
            EditText editText = this.s;
            if (editText != null) {
                editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 2);
            SkinManager.setImageResource(this.v, R.drawable.del_search_btn);
            g2();
            if (this.mSkinType == 2) {
                StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
            }
        }
    }
}
