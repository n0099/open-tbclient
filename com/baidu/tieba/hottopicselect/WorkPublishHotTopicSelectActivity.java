package com.baidu.tieba.hottopicselect;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.WorkPublishHotTopicSelectActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AutoChangeLineView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ia5;
import com.repackage.ni;
import com.repackage.pi;
import com.repackage.r37;
import com.repackage.s37;
import com.repackage.t37;
import com.repackage.u37;
import com.repackage.ur4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class WorkPublishHotTopicSelectActivity extends SuspendedActivity implements ia5, HotTopicSelectModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AutoChangeLineView A;
    public TextView B;
    public int C;
    public AutoChangeLineView.b<String> D;
    public final View.OnClickListener E;
    public final AdapterView.OnItemClickListener F;
    public final ExpandableListView.OnGroupClickListener G;
    public final ExpandableListView.OnChildClickListener H;
    public HotTopicSelectModel k;
    public final List<t37> l;
    public View m;
    public BdListView n;
    public ExpandableListView o;
    public u37 p;
    public r37 q;
    public List<String> r;
    public ViewGroup s;
    public EditText t;
    public NoDataView u;
    public ImageView v;
    public TextView w;
    public Intent x;
    public TextView y;
    public RelativeLayout z;

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public a(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = editable.toString();
                if (this.a.r.size() >= this.a.C) {
                    editable.clear();
                    return;
                }
                if (obj == null || obj.trim().length() <= 0) {
                    this.a.k1();
                } else {
                    this.a.u.setVisibility(8);
                    this.a.m.setVisibility(8);
                    this.a.t1();
                    this.a.k.O(obj);
                }
                this.a.r1(!StringUtils.isNull(editable.toString()));
                this.a.s1();
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

    /* loaded from: classes3.dex */
    public class b implements AutoChangeLineView.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public b(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
        /* renamed from: b */
        public CharSequence a(TextView textView, int i, String str) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, i, str)) == null) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f0805fc, R.color.CAM_X0302, null);
                Drawable pureDrawable2 = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f0805f2, R.color.CAM_X0302, null);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                pureDrawable2.setBounds(0, 0, dimenPixelSize2, dimenPixelSize2);
                textView.setCompoundDrawablePadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                textView.setCompoundDrawables(pureDrawable, null, pureDrawable2, null);
                String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(str, 16, StringHelper.STRING_MORE);
                ur4 d = ur4.d(textView);
                d.n(R.string.J_X01);
                d.l(R.dimen.L_X01);
                d.k(R.color.CAM_X0302);
                d.f(R.color.CAM_X0905);
                return cutChineseAndEnglishWithEmoji;
            }
            return (CharSequence) invokeLIL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AutoChangeLineView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public c(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // com.baidu.tbadk.core.view.AutoChangeLineView.c
        public void a(TextView textView, Object obj, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, textView, obj, i) == null) && (obj instanceof String)) {
                this.a.r.remove(obj);
                this.a.B.setText(String.format("(%d/%d)", Integer.valueOf(this.a.r.size()), Integer.valueOf(this.a.C)));
                this.a.A.setLabels(this.a.r, this.a.D);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public d(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.v) {
                    this.a.l1();
                } else if (view2 == this.a.y) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921602, this.a.r));
                    this.a.n0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public e(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            t37 t37Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (t37Var = (t37) ListUtils.getItem(this.a.q.d(), i)) == null) {
                return;
            }
            String b = t37Var.b();
            this.a.j1(b);
            this.a.i1(b, 3);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ExpandableListView.OnGroupClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public f(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
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
    public class g implements ExpandableListView.OnChildClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public g(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view2, int i, int i2, long j) {
            InterceptResult invokeCommon;
            t37 child;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                if (this.a.p == null || (child = this.a.p.getChild(i, i2)) == null) {
                    return false;
                }
                String b = child.b();
                this.a.j1(b);
                s37 group = this.a.p.getGroup(i);
                if (group != null) {
                    this.a.i1(b, group.getType() == 0 ? 1 : 2);
                    return false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public h(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) || z) {
                return;
            }
            pi.x(this.a.getPageContext().getPageActivity(), view2);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public i(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.r.size() < this.a.C) {
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this.a.getPageContext().getPageActivity());
            bdTopToast.i(false);
            bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f144e));
            bdTopToast.j((ViewGroup) this.a.getPageContext().getPageActivity().findViewById(R.id.obfuscated_res_0x7f091e6a));
        }
    }

    /* loaded from: classes3.dex */
    public class j implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

        public j(WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishHotTopicSelectActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishHotTopicSelectActivity;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 6) {
                    pi.M(this.a.getPageContext().getPageActivity(), textView);
                    if (TextUtils.isEmpty(this.a.n1())) {
                        return true;
                    }
                    WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity = this.a;
                    workPublishHotTopicSelectActivity.j1(workPublishHotTopicSelectActivity.n1());
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    public WorkPublishHotTopicSelectActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.r = new ArrayList();
        this.C = 3;
        this.D = new b(this);
        this.E = new d(this);
        this.F = new e(this);
        this.G = new f(this);
        this.H = new g(this);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void F(s37 s37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s37Var) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            hideLoadingView(this.s);
            this.l.clear();
            String n1 = n1();
            this.l.add(m1(n1));
            if (s37Var != null && s37Var.b() != null) {
                this.l.addAll(s37Var.b());
                this.q.e(n1, this.l);
                return;
            }
            this.q.e(n1, this.l);
        }
    }

    @Override // com.repackage.ia5
    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void a0(s37 s37Var, s37 s37Var2, s37 s37Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, s37Var, s37Var2, s37Var3) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            hideLoadingView(this.s);
            this.p.c();
            q1(s37Var, true);
            q1(s37Var2, false);
            this.p.notifyDataSetChanged();
            int count = this.o.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                this.o.expandGroup(i2);
            }
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void f0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            hideLoadingView(this.s);
            String n1 = n1();
            t37 m1 = m1(n1);
            this.l.clear();
            this.l.add(m1);
            this.q.e(n1, this.l);
        }
    }

    @Override // com.repackage.ia5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.x : (Intent) invokeV.objValue;
    }

    public final void i1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c11665");
            statisticItem.param("obj_name", str);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            hideLoadingView(this.s);
            this.m.setVisibility(8);
            if (!ni.z()) {
                this.u.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c2b));
                this.u.setVisibility(0);
            } else if (TextUtils.isEmpty(str)) {
            } else {
                this.u.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0f9b));
                this.u.setVisibility(0);
                showToast(str);
            }
        }
    }

    public final void j1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            EditText editText = this.t;
            if (editText != null && editText.hasFocus()) {
                pi.x(getPageContext().getPageActivity(), this.t);
            }
            l1();
            if (this.r.contains(str)) {
                BdTopToast bdTopToast = new BdTopToast(this);
                bdTopToast.i(false);
                bdTopToast.h(getString(R.string.obfuscated_res_0x7f0f0377));
                bdTopToast.j((ViewGroup) findViewById(R.id.obfuscated_res_0x7f091e6a));
            } else if (this.r.size() >= this.C) {
                BdTopToast bdTopToast2 = new BdTopToast(this);
                bdTopToast2.i(false);
                bdTopToast2.h(getString(R.string.obfuscated_res_0x7f0f144e));
                bdTopToast2.j((ViewGroup) findViewById(R.id.obfuscated_res_0x7f091e6a));
            } else {
                this.r.add(str);
                this.B.setText(String.format("(%d/%d)", Integer.valueOf(this.r.size()), Integer.valueOf(this.C)));
                this.A.setLabels(this.r, this.D);
            }
        }
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            this.q.b();
            u37 u37Var = this.p;
            if (u37Var != null && !ListUtils.isEmpty(u37Var.f())) {
                this.m.setVisibility(0);
                return;
            }
            t1();
            this.k.F();
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.k.P("");
            this.t.setText("");
        }
    }

    public final t37 m1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            t37 t37Var = new t37();
            t37Var.d(str);
            return t37Var;
        }
        return (t37) invokeL.objValue;
    }

    @Override // com.repackage.ia5
    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }

    public final String n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            HotTopicSelectModel hotTopicSelectModel = this.k;
            String G = hotTopicSelectModel != null ? hotTopicSelectModel.G() : "";
            return G != null ? G : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public ia5 o0(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, linearLayout, navigationBar)) == null) {
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f15c7));
            this.y = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.obfuscated_res_0x7f0f04ef));
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0399, (ViewGroup) linearLayout, true);
            return this;
        }
        return (ia5) invokeLL.objValue;
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091cc8);
            this.t = editText;
            editText.setCompoundDrawablePadding(pi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070304));
            this.t.setOnFocusChangeListener(new h(this));
            this.t.setOnClickListener(new i(this));
            this.t.setOnEditorActionListener(new j(this));
            this.t.addTextChangedListener(new a(this));
            this.t.requestFocus();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSkinType = i2;
            ur4.d(this.y).x(R.color.CAM_X0302);
            ur4.d(this.B).v(R.color.CAM_X0107);
            ur4.d(findViewById(R.id.obfuscated_res_0x7f092412)).v(R.color.CAM_X0105);
            ur4.d(findViewById(R.id.obfuscated_res_0x7f092435)).v(R.color.CAM_X0105);
            ur4 d2 = ur4.d(this.z);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            this.A.setLabelTextColor(SkinManager.getColor(R.color.CAM_X0302));
            this.A.setLabels(this.r, this.D);
            NoDataView noDataView = this.u;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            r37 r37Var = this.q;
            if (r37Var != null) {
                r37Var.notifyDataSetChanged();
            }
            u37 u37Var = this.p;
            if (u37Var != null) {
                u37Var.notifyDataSetChanged();
            }
            EditText editText = this.t;
            if (editText != null) {
                editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 2);
            SkinManager.setImageResource(this.v, R.drawable.del_search_btn);
            s1();
            if (this.mSkinType == 2) {
                StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            this.C = TbSingleton.getInstance().getWorksAddTopicMaxNum();
            HotTopicSelectModel hotTopicSelectModel = new HotTopicSelectModel(getPageContext(), this);
            this.k = hotTopicSelectModel;
            hotTopicSelectModel.J(getIntent());
            this.k.M();
            if (getIntent() != null) {
                ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(WorkPublishHotTopicSelectActivityConfig.WORK_PUBLISH_TOPIC_LIST);
                this.r = stringArrayListExtra;
                if (stringArrayListExtra == null) {
                    this.r = new ArrayList();
                }
                int size = this.r.size();
                int i2 = this.C;
                if (size > i2) {
                    this.r = this.r.subList(0, i2);
                }
            }
            p1();
            this.A.setLabels(this.r, this.D);
            getWindow().setSoftInputMode(1);
            t1();
            this.k.N();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.k.onDestroy();
            this.u.e();
            hideLoadingView(this.s);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.s = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090a83);
            this.z = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f092434);
            this.A = (AutoChangeLineView) findViewById(R.id.obfuscated_res_0x7f092199);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092413);
            this.B = textView;
            textView.setText(String.format("(%d/%d)", Integer.valueOf(this.r.size()), Integer.valueOf(this.C)));
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f0921ad);
            this.v = (ImageView) findViewById(R.id.obfuscated_res_0x7f090617);
            this.m = findViewById(R.id.obfuscated_res_0x7f090d42);
            this.n = (BdListView) findViewById(R.id.obfuscated_res_0x7f090d38);
            this.u = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0702c1)), null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.s.addView(this.u, layoutParams);
            this.u.setVisibility(8);
            r37 r37Var = new r37(getPageContext());
            this.q = r37Var;
            this.n.setAdapter((ListAdapter) r37Var);
            this.o = (ExpandableListView) findViewById(R.id.obfuscated_res_0x7f090d3a);
            u37 u37Var = new u37(getPageContext());
            this.p = u37Var;
            this.o.setAdapter(u37Var);
            this.n.setOnItemClickListener(this.F);
            this.o.setOnGroupClickListener(this.G);
            this.o.setOnChildClickListener(this.H);
            this.v.setOnClickListener(this.E);
            this.y.setOnClickListener(this.E);
            this.A.setOnLabelClickListener(new c(this));
            r1(false);
            o1();
        }
    }

    public final void q1(s37 s37Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048598, this, s37Var, z) == null) || s37Var == null || ListUtils.isEmpty(s37Var.b())) {
            return;
        }
        if (TextUtils.isEmpty(s37Var.a())) {
            s37Var.e(getString(z ? R.string.obfuscated_res_0x7f0f07fa : R.string.obfuscated_res_0x7f0f07fb));
        }
        this.p.g(s37Var);
    }

    public void r1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.v.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.repackage.ia5
    public boolean s() {
        InterceptResult invokeV;
        ListView listView;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.n.getVisibility() == 0) {
                listView = this.n;
            } else {
                listView = this.o;
            }
            return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void s1() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (editText = this.t) == null || this.w == null) {
            return;
        }
        if (TextUtils.isEmpty(editText.getText())) {
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0109, 1);
        } else {
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0105, 1);
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.m.setVisibility(8);
            showLoadingView(this.s, false, getResources().getDimensionPixelSize(R.dimen.tbds320));
        }
    }
}
