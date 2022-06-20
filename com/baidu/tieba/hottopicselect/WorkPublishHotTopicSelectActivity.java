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
import com.repackage.b37;
import com.repackage.c37;
import com.repackage.d37;
import com.repackage.e37;
import com.repackage.f95;
import com.repackage.fr4;
import com.repackage.ni;
import com.repackage.pi;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class WorkPublishHotTopicSelectActivity extends SuspendedActivity implements f95, HotTopicSelectModel.c {
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
    public final List<d37> l;
    public View m;
    public BdListView n;
    public ExpandableListView o;
    public e37 p;
    public b37 q;
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
                    this.a.l1();
                } else {
                    this.a.u.setVisibility(8);
                    this.a.m.setVisibility(8);
                    this.a.u1();
                    this.a.k.N(obj);
                }
                this.a.s1(!StringUtils.isNull(editable.toString()));
                this.a.t1();
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
                fr4 d = fr4.d(textView);
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
                    this.a.m1();
                } else if (view2 == this.a.y) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921602, this.a.r));
                    this.a.o0();
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
            d37 d37Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (d37Var = (d37) ListUtils.getItem(this.a.q.d(), i)) == null) {
                return;
            }
            String b = d37Var.b();
            this.a.k1(b);
            this.a.j1(b, 3);
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
            d37 child;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                if (this.a.p == null || (child = this.a.p.getChild(i, i2)) == null) {
                    return false;
                }
                String b = child.b();
                this.a.k1(b);
                c37 group = this.a.p.getGroup(i);
                if (group != null) {
                    this.a.j1(b, group.getType() == 0 ? 1 : 2);
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
            bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f1454));
            bdTopToast.j((ViewGroup) this.a.getPageContext().getPageActivity().findViewById(R.id.obfuscated_res_0x7f091dc6));
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
                    if (TextUtils.isEmpty(this.a.o1())) {
                        return true;
                    }
                    WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity = this.a;
                    workPublishHotTopicSelectActivity.k1(workPublishHotTopicSelectActivity.o1());
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
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.f95
    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void N(c37 c37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c37Var) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            hideLoadingView(this.s);
            this.l.clear();
            String o1 = o1();
            this.l.add(n1(o1));
            if (c37Var != null && c37Var.b() != null) {
                this.l.addAll(c37Var.b());
                this.q.e(o1, this.l);
                return;
            }
            this.q.e(o1, this.l);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void c0(c37 c37Var, c37 c37Var2, c37 c37Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, c37Var, c37Var2, c37Var3) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            hideLoadingView(this.s);
            this.p.c();
            r1(c37Var, true);
            r1(c37Var2, false);
            this.p.notifyDataSetChanged();
            int count = this.o.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                this.o.expandGroup(i2);
            }
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void g0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            hideLoadingView(this.s);
            String o1 = o1();
            d37 n1 = n1(o1);
            this.l.clear();
            this.l.add(n1);
            this.q.e(o1, this.l);
        }
    }

    @Override // com.repackage.f95
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.x : (Intent) invokeV.objValue;
    }

    public final void j1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c11665");
            statisticItem.param("obj_name", str);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            hideLoadingView(this.s);
            this.m.setVisibility(8);
            if (!ni.z()) {
                this.u.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c37));
                this.u.setVisibility(0);
            } else if (TextUtils.isEmpty(str)) {
            } else {
                this.u.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0fa0));
                this.u.setVisibility(0);
                showToast(str);
            }
        }
    }

    public final void k1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            EditText editText = this.t;
            if (editText != null && editText.hasFocus()) {
                pi.x(getPageContext().getPageActivity(), this.t);
            }
            m1();
            if (this.r.contains(str)) {
                BdTopToast bdTopToast = new BdTopToast(this);
                bdTopToast.i(false);
                bdTopToast.h(getString(R.string.obfuscated_res_0x7f0f0373));
                bdTopToast.j((ViewGroup) findViewById(R.id.obfuscated_res_0x7f091dc6));
            } else if (this.r.size() >= this.C) {
                BdTopToast bdTopToast2 = new BdTopToast(this);
                bdTopToast2.i(false);
                bdTopToast2.h(getString(R.string.obfuscated_res_0x7f0f1454));
                bdTopToast2.j((ViewGroup) findViewById(R.id.obfuscated_res_0x7f091dc6));
            } else {
                this.r.add(str);
                this.B.setText(String.format("(%d/%d)", Integer.valueOf(this.r.size()), Integer.valueOf(this.C)));
                this.A.setLabels(this.r, this.D);
            }
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            this.q.b();
            e37 e37Var = this.p;
            if (e37Var != null && !ListUtils.isEmpty(e37Var.f())) {
                this.m.setVisibility(0);
                return;
            }
            u1();
            this.k.E();
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.k.O("");
            this.t.setText("");
        }
    }

    @Override // com.repackage.f95
    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    public final d37 n1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            d37 d37Var = new d37();
            d37Var.d(str);
            return d37Var;
        }
        return (d37) invokeL.objValue;
    }

    public final String o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            HotTopicSelectModel hotTopicSelectModel = this.k;
            String F = hotTopicSelectModel != null ? hotTopicSelectModel.F() : "";
            return F != null ? F : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSkinType = i2;
            fr4.d(this.y).x(R.color.CAM_X0302);
            fr4.d(this.B).v(R.color.CAM_X0107);
            fr4.d(findViewById(R.id.obfuscated_res_0x7f09236a)).v(R.color.CAM_X0105);
            fr4.d(findViewById(R.id.obfuscated_res_0x7f09238d)).v(R.color.CAM_X0105);
            fr4 d2 = fr4.d(this.z);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            this.A.setLabelTextColor(SkinManager.getColor(R.color.CAM_X0302));
            this.A.setLabels(this.r, this.D);
            NoDataView noDataView = this.u;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            b37 b37Var = this.q;
            if (b37Var != null) {
                b37Var.notifyDataSetChanged();
            }
            e37 e37Var = this.p;
            if (e37Var != null) {
                e37Var.notifyDataSetChanged();
            }
            EditText editText = this.t;
            if (editText != null) {
                editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 2);
            SkinManager.setImageResource(this.v, R.drawable.del_search_btn);
            t1();
            if (this.mSkinType == 2) {
                StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            this.C = TbSingleton.getInstance().getWorksAddTopicMaxNum();
            HotTopicSelectModel hotTopicSelectModel = new HotTopicSelectModel(getPageContext(), this);
            this.k = hotTopicSelectModel;
            hotTopicSelectModel.I(getIntent());
            this.k.L();
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
            q1();
            this.A.setLabels(this.r, this.D);
            getWindow().setSoftInputMode(1);
            u1();
            this.k.M();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.k.onDestroy();
            this.u.e();
            hideLoadingView(this.s);
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

    public final void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091c28);
            this.t = editText;
            editText.setCompoundDrawablePadding(pi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070305));
            this.t.setOnFocusChangeListener(new h(this));
            this.t.setOnClickListener(new i(this));
            this.t.setOnEditorActionListener(new j(this));
            this.t.addTextChangedListener(new a(this));
            this.t.requestFocus();
        }
    }

    public final void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.s = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090a7b);
            this.z = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09238c);
            this.A = (AutoChangeLineView) findViewById(R.id.obfuscated_res_0x7f0920f6);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09236b);
            this.B = textView;
            textView.setText(String.format("(%d/%d)", Integer.valueOf(this.r.size()), Integer.valueOf(this.C)));
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f09210a);
            this.v = (ImageView) findViewById(R.id.obfuscated_res_0x7f090615);
            this.m = findViewById(R.id.obfuscated_res_0x7f090d34);
            this.n = (BdListView) findViewById(R.id.obfuscated_res_0x7f090d2c);
            this.u = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0702c2)), null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.s.addView(this.u, layoutParams);
            this.u.setVisibility(8);
            b37 b37Var = new b37(getPageContext());
            this.q = b37Var;
            this.n.setAdapter((ListAdapter) b37Var);
            this.o = (ExpandableListView) findViewById(R.id.obfuscated_res_0x7f090d2e);
            e37 e37Var = new e37(getPageContext());
            this.p = e37Var;
            this.o.setAdapter(e37Var);
            this.n.setOnItemClickListener(this.F);
            this.o.setOnGroupClickListener(this.G);
            this.o.setOnChildClickListener(this.H);
            this.v.setOnClickListener(this.E);
            this.y.setOnClickListener(this.E);
            this.A.setOnLabelClickListener(new c(this));
            s1(false);
            p1();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public f95 r0(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, linearLayout, navigationBar)) == null) {
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f15c5));
            this.y = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.obfuscated_res_0x7f0f04e6));
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0396, (ViewGroup) linearLayout, true);
            return this;
        }
        return (f95) invokeLL.objValue;
    }

    public final void r1(c37 c37Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048598, this, c37Var, z) == null) || c37Var == null || ListUtils.isEmpty(c37Var.b())) {
            return;
        }
        if (TextUtils.isEmpty(c37Var.a())) {
            c37Var.e(getString(z ? R.string.obfuscated_res_0x7f0f07ef : R.string.obfuscated_res_0x7f0f07f0));
        }
        this.p.g(c37Var);
    }

    @Override // com.repackage.f95
    public boolean s() {
        InterceptResult invokeV;
        ListView listView;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.n.getVisibility() == 0) {
                listView = this.n;
            } else {
                listView = this.o;
            }
            return listView != null && listView.getFirstVisiblePosition() == 0 && (childAt = listView.getChildAt(0)) != null && childAt.getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public void s1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.v.setVisibility(z ? 0 : 8);
        }
    }

    public final void t1() {
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

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.m.setVisibility(8);
            showLoadingView(this.s, false, getResources().getDimensionPixelSize(R.dimen.tbds320));
        }
    }
}
