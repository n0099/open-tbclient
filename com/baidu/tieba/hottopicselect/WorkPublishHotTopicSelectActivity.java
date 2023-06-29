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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tieba.s75;
import com.baidu.tieba.st5;
import com.baidu.tieba.u68;
import com.baidu.tieba.v68;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.w68;
import com.baidu.tieba.x68;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class WorkPublishHotTopicSelectActivity extends SuspendedActivity implements st5, HotTopicSelectModel.c {
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
    public final List<w68> l;
    public View m;
    public BdListView n;
    public ExpandableListView o;
    public x68 p;
    public u68 q;
    public List<String> r;
    public ViewGroup s;
    public EditText t;
    public NoDataView u;
    public ImageView v;
    public TextView w;
    public Intent x;
    public TextView y;
    public RelativeLayout z;

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.st5
    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.st5
    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishHotTopicSelectActivity a;

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
                    this.a.e2();
                } else {
                    this.a.u.setVisibility(8);
                    this.a.m.setVisibility(8);
                    this.a.n2();
                    this.a.k.i0(obj);
                }
                this.a.l2(!StringUtils.isNull(editable.toString()));
                this.a.m2();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_post_topic12, R.color.CAM_X0302, null);
                Drawable pureDrawable2 = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f080787, R.color.CAM_X0302, null);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
                pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                pureDrawable2.setBounds(0, 0, dimenPixelSize2, dimenPixelSize2);
                textView.setCompoundDrawablePadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
                textView.setCompoundDrawables(pureDrawable, null, pureDrawable2, null);
                String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(str, 16, "...");
                s75 d = s75.d(textView);
                d.o(R.string.J_X01);
                d.m(R.dimen.L_X01);
                d.l(R.color.CAM_X0302);
                d.f(R.color.CAM_X0905);
                return cutChineseAndEnglishWithEmoji;
            }
            return (CharSequence) invokeLIL.objValue;
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                    this.a.f2();
                } else if (view2 == this.a.y) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921602, this.a.r));
                    this.a.t1();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            w68 w68Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && (w68Var = (w68) ListUtils.getItem(this.a.q.d(), i)) != null) {
                String b = w68Var.b();
                this.a.d2(b);
                this.a.c2(b, 3);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
            w68 child;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{expandableListView, view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                if (this.a.p != null && (child = this.a.p.getChild(i, i2)) != null) {
                    String b = child.b();
                    this.a.d2(b);
                    v68 group = this.a.p.getGroup(i);
                    if (group != null) {
                        if (group.getType() == 0) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        this.a.c2(b, i3);
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
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && !z) {
                xi.z(this.a.getPageContext().getPageActivity(), view2);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.r.size() >= this.a.C) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getPageContext().getPageActivity());
                bdTopToast.h(false);
                bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f16a3));
                bdTopToast.i((ViewGroup) this.a.getPageContext().getPageActivity().findViewById(R.id.suspend_root_view));
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    xi.O(this.a.getPageContext().getPageActivity(), textView);
                    if (!TextUtils.isEmpty(this.a.h2())) {
                        WorkPublishHotTopicSelectActivity workPublishHotTopicSelectActivity = this.a;
                        workPublishHotTopicSelectActivity.d2(workPublishHotTopicSelectActivity.h2());
                        return true;
                    }
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

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f0920c3);
            this.t = editText;
            editText.setCompoundDrawablePadding(xi.g(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070416));
            this.t.setOnFocusChangeListener(new h(this));
            this.t.setOnClickListener(new i(this));
            this.t.setOnEditorActionListener(new j(this));
            this.t.addTextChangedListener(new a(this));
            this.t.requestFocus();
        }
    }

    public final w68 g2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            w68 w68Var = new w68();
            w68Var.d(str);
            return w68Var;
        }
        return (w68) invokeL.objValue;
    }

    public void l2(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            ImageView imageView = this.v;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void c2(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c11665");
            statisticItem.param("obj_name", str);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void J0(v68 v68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v68Var) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            hideLoadingView(this.s);
            this.l.clear();
            String h2 = h2();
            this.l.add(g2(h2));
            if (v68Var != null && v68Var.b() != null) {
                this.l.addAll(v68Var.b());
                this.q.e(h2, this.l);
                return;
            }
            this.q.e(h2, this.l);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void n1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            hideLoadingView(this.s);
            this.m.setVisibility(8);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.u.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0e0f));
                this.u.setVisibility(0);
            } else if (!TextUtils.isEmpty(str)) {
                this.u.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
                this.u.setVisibility(0);
                showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void R0(v68 v68Var, v68 v68Var2, v68 v68Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, v68Var, v68Var2, v68Var3) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            hideLoadingView(this.s);
            this.p.c();
            k2(v68Var, true);
            k2(v68Var2, false);
            this.p.notifyDataSetChanged();
            int count = this.o.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                this.o.expandGroup(i2);
            }
        }
    }

    public final void d2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            EditText editText = this.t;
            if (editText != null && editText.hasFocus()) {
                xi.z(getPageContext().getPageActivity(), this.t);
            }
            f2();
            if (this.r.contains(str)) {
                BdTopToast bdTopToast = new BdTopToast(this);
                bdTopToast.h(false);
                bdTopToast.g(getString(R.string.obfuscated_res_0x7f0f03d9));
                bdTopToast.i((ViewGroup) findViewById(R.id.suspend_root_view));
            } else if (this.r.size() >= this.C) {
                BdTopToast bdTopToast2 = new BdTopToast(this);
                bdTopToast2.h(false);
                bdTopToast2.g(getString(R.string.obfuscated_res_0x7f0f16a3));
                bdTopToast2.i((ViewGroup) findViewById(R.id.suspend_root_view));
            } else {
                this.r.add(str);
                this.B.setText(String.format("(%d/%d)", Integer.valueOf(this.r.size()), Integer.valueOf(this.C)));
                this.A.setLabels(this.r, this.D);
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSkinType = i2;
            s75.d(this.y).A(R.color.CAM_X0302);
            s75.d(this.B).x(R.color.CAM_X0107);
            s75.d(findViewById(R.id.obfuscated_res_0x7f0928d4)).x(R.color.CAM_X0105);
            s75.d(findViewById(R.id.obfuscated_res_0x7f0928fa)).x(R.color.CAM_X0105);
            s75 d2 = s75.d(this.z);
            d2.o(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            this.A.setLabelTextColor(SkinManager.getColor(R.color.CAM_X0302));
            this.A.setLabels(this.r, this.D);
            NoDataView noDataView = this.u;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            u68 u68Var = this.q;
            if (u68Var != null) {
                u68Var.notifyDataSetChanged();
            }
            x68 x68Var = this.p;
            if (x68Var != null) {
                x68Var.notifyDataSetChanged();
            }
            EditText editText = this.t;
            if (editText != null) {
                editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 2);
            SkinManager.setImageResource(this.v, R.drawable.del_search_btn);
            m2();
            if (this.mSkinType == 2) {
                StatusBarUtil.from(getPageContext().getPageActivity()).setTransparentStatusbar(true).setLightStatusBar(true).process();
            }
        }
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.o.setVisibility(0);
            this.n.setVisibility(8);
            this.q.b();
            x68 x68Var = this.p;
            if (x68Var != null && !ListUtils.isEmpty(x68Var.f())) {
                this.m.setVisibility(0);
                return;
            }
            n2();
            this.k.Z();
        }
    }

    public final void m2() {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (editText = this.t) != null && this.w != null) {
            if (TextUtils.isEmpty(editText.getText())) {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0109, 1);
            } else {
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0105, 1);
            }
        }
    }

    @Override // com.baidu.tieba.st5
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

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k.j0("");
            this.t.setText("");
        }
    }

    @Override // com.baidu.tieba.st5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.x;
        }
        return (Intent) invokeV.objValue;
    }

    public final String h2() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.m.setVisibility(8);
            showLoadingView(this.s, false, getResources().getDimensionPixelSize(R.dimen.tbds320));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.k.onDestroy();
            this.u.e();
            hideLoadingView(this.s);
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

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void g1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            hideLoadingView(this.s);
            String h2 = h2();
            w68 g2 = g2(h2);
            this.l.clear();
            this.l.add(g2);
            this.q.e(h2, this.l);
        }
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.s = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090c1d);
            this.z = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0928f9);
            this.A = (AutoChangeLineView) findViewById(R.id.obfuscated_res_0x7f092606);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0928d5);
            this.B = textView;
            textView.setText(String.format("(%d/%d)", Integer.valueOf(this.r.size()), Integer.valueOf(this.C)));
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f09261a);
            this.v = (ImageView) findViewById(R.id.obfuscated_res_0x7f09070e);
            this.m = findViewById(R.id.obfuscated_res_0x7f090f5b);
            this.n = (BdListView) findViewById(R.id.obfuscated_res_0x7f090f54);
            this.u = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0703d3)), null, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.s.addView(this.u, layoutParams);
            this.u.setVisibility(8);
            u68 u68Var = new u68(getPageContext());
            this.q = u68Var;
            this.n.setAdapter((ListAdapter) u68Var);
            this.o = (ExpandableListView) findViewById(R.id.obfuscated_res_0x7f090f55);
            x68 x68Var = new x68(getPageContext());
            this.p = x68Var;
            this.o.setAdapter(x68Var);
            this.n.setOnItemClickListener(this.F);
            this.o.setOnGroupClickListener(this.G);
            this.o.setOnChildClickListener(this.H);
            this.v.setOnClickListener(this.E);
            this.y.setOnClickListener(this.E);
            this.A.setOnLabelClickListener(new c(this));
            l2(false);
            i2();
        }
    }

    public final void k2(v68 v68Var, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, v68Var, z) == null) && v68Var != null && !ListUtils.isEmpty(v68Var.b())) {
            if (TextUtils.isEmpty(v68Var.a())) {
                if (z) {
                    i2 = R.string.obfuscated_res_0x7f0f0968;
                } else {
                    i2 = R.string.obfuscated_res_0x7f0f0969;
                }
                v68Var.e(getString(i2));
            }
            this.p.g(v68Var);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public st5 u1(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, linearLayout, navigationBar)) == null) {
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f188f));
            this.y = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.obfuscated_res_0x7f0f05a4));
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d03f9, (ViewGroup) linearLayout, true);
            return this;
        }
        return (st5) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onCreate(bundle);
            this.C = TbSingleton.getInstance().getWorksAddTopicMaxNum();
            HotTopicSelectModel hotTopicSelectModel = new HotTopicSelectModel(getPageContext(), this);
            this.k = hotTopicSelectModel;
            hotTopicSelectModel.d0(getIntent());
            this.k.g0();
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
            j2();
            this.A.setLabels(this.r, this.D);
            getWindow().setSoftInputMode(1);
            n2();
            this.k.h0();
        }
    }
}
