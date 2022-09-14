package com.baidu.tieba;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LocalChannelTopicListActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.homepage.topic.local.LocalChannelTopicDecoration;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class e47 implements ud5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinearLayout b;
    public NavigationBar c;
    public View d;
    public EMTextView e;
    public EMTextView f;
    public RelativeLayout g;
    public BdTypeRecyclerView h;
    public s85 i;
    public t85 j;
    public View.OnClickListener k;
    public LocalChannelTopicDecoration l;
    public boolean m;

    /* loaded from: classes3.dex */
    public class a implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e47 a;

        public a(e47 e47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e47Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.a == null || this.a.a.getPageActivity() == null || !(cdo instanceof g47)) {
                return;
            }
            this.a.t();
            String str = ((g47) cdo).a;
            if (!this.a.m) {
                if (this.a.a.getPageActivity() instanceof SuspendedActivity) {
                    ((SuspendedActivity) this.a.a.getPageActivity()).b1(true);
                }
                this.a.a.getPageActivity().finish();
                if (this.a.a == null || this.a.a.getPageActivity() == null) {
                    return;
                }
                WriteActivityConfig.newInstance(this.a.a.getPageActivity()).setType(9).setFrom("main_tab").setCallFrom("2").setIsPostLocalChannelDynamic(true).setLocalChannelTopic(str).send();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(LocalChannelTopicListActivityConfig.KEY_RESPONSE_TOPIC, str);
            this.a.a.getPageActivity().setResult(-1, intent);
            this.a.a.getPageActivity().finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h47 a;
        public final /* synthetic */ e47 b;

        public b(e47 e47Var, h47 h47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e47Var, h47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e47Var;
            this.a = h47Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.a == null) {
                return;
            }
            this.b.r();
            this.b.j(this.a);
        }
    }

    public e47(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = linearLayout;
        this.c = navigationBar;
        this.k = onClickListener;
        i();
        h();
    }

    @Override // com.baidu.tieba.ud5
    public void E(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            this.h.setPressed(false);
        }
    }

    @Override // com.baidu.tieba.vd5
    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        s85 s85Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.g == null || (s85Var = this.i) == null || !s85Var.isViewAttached()) {
            return;
        }
        this.i.dettachView(this.g);
    }

    public final void g() {
        t85 t85Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.g == null || (t85Var = this.j) == null || !t85Var.isViewAttached()) {
            return;
        }
        this.j.dettachView(this.g);
    }

    @Override // com.baidu.tieba.vd5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void h() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (tbPageContext = this.a) == null || this.b == null) {
            return;
        }
        LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04ae, (ViewGroup) this.b, true);
        this.g = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091426);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.b.findViewById(R.id.obfuscated_res_0x7f091bb8);
        this.h = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
        this.h.setFadingEdgeLength(0);
        this.h.setOverScrollMode(2);
        LocalChannelTopicDecoration localChannelTopicDecoration = new LocalChannelTopicDecoration();
        this.l = localChannelTopicDecoration;
        this.h.addItemDecoration(localChannelTopicDecoration);
        ArrayList arrayList = new ArrayList();
        d47 d47Var = new d47(this.a, g47.e);
        d47Var.setOnAdapterItemClickListener(new a(this));
        arrayList.add(d47Var);
        this.h.a(arrayList);
        this.h.setVisibility(8);
        g();
        o();
    }

    public final void i() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a == null || (navigationBar = this.c) == null) {
            return;
        }
        navigationBar.setFixedHeight(false);
        if (this.c.getContentLayout() != null && this.c.getContentLayout().getLayoutParams() != null) {
            this.c.getContentLayout().getLayoutParams().height = ej.f(this.a.getPageActivity(), R.dimen.tbds161);
            this.c.getContentLayout().requestLayout();
        }
        this.d = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04af, this.c.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER), true);
        this.e = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f091425);
        this.f = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f091424);
    }

    public final void j(h47 h47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, h47Var) == null) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.getPageActivity());
            pbActivityConfig.setThreadId(h47Var.a.b);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    public void k(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) || intent == null) {
            return;
        }
        this.m = intent.getBooleanExtra(LocalChannelTopicListActivityConfig.KEY_IS_RESPONSE_FOR_TOPIC, false);
        u();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            p(this.a.getString(R.string.obfuscated_res_0x7f0f09ff), true);
            f();
            this.h.setVisibility(8);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(8);
            }
            f();
            p(str, false);
        }
    }

    @Override // com.baidu.tieba.vd5
    public void n(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || this.a == null) {
            return;
        }
        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0108);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right_n, SkinManager.getColor(R.color.CAM_X0108), null);
        if (this.f != null && pureDrawable != null) {
            int f = ej.f(this.a.getPageActivity(), R.dimen.tbds31);
            pureDrawable.setBounds(0, 0, f, f);
            this.f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
        }
        s85 s85Var = this.i;
        if (s85Var != null) {
            s85Var.m(i);
        }
        t85 t85Var = this.j;
        if (t85Var != null) {
            t85Var.onChangeSkinType();
        }
        LocalChannelTopicDecoration localChannelTopicDecoration = this.l;
        if (localChannelTopicDecoration != null) {
            localChannelTopicDecoration.a();
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.h.getAdapter().notifyDataSetChanged();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.a == null || this.g == null) {
            return;
        }
        s85 s85Var = this.i;
        if (s85Var == null || !s85Var.isViewAttached()) {
            if (this.i == null) {
                this.i = new s85(this.a.getPageActivity());
            }
            this.i.attachView(this.g);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public final void p(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) || this.a == null || this.g == null) {
            return;
        }
        t85 t85Var = this.j;
        if (t85Var == null || !t85Var.isViewAttached()) {
            if (this.j == null) {
                this.j = new t85(this.a.getPageActivity(), this.k);
            }
            if (z) {
                this.j.i(R.drawable.new_pic_emotion_07);
                this.j.e();
            } else {
                this.j.i(R.drawable.new_pic_emotion_08);
                this.j.p();
            }
            this.j.o(str);
            this.j.attachView(this.g);
        }
    }

    public void q(h47 h47Var) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, h47Var) == null) {
            if (h47Var == null) {
                l();
            } else if (this.d == null || (eMTextView = this.f) == null || this.h == null) {
            } else {
                f47 f47Var = h47Var.a;
                if (f47Var != null) {
                    eMTextView.setText(f47Var.a);
                    this.f.setVisibility(0);
                    this.d.setOnClickListener(new b(this, h47Var));
                }
                if (ListUtils.isEmpty(h47Var.b)) {
                    l();
                    return;
                }
                f();
                g();
                this.h.setVisibility(0);
                this.h.setData(h47Var.b);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            TiebaStatic.log(new StatisticItem("c14524"));
        }
    }

    @Override // com.baidu.tieba.vd5
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getVisibility() != 0) {
                return true;
            }
            return this.h.getFirstVisiblePosition() == 0 && this.h.getChildAt(0) != null && this.h.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c14523"));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            TiebaStatic.log(new StatisticItem("c14522").param("obj_source", this.m ? 2 : 1));
        }
    }
}
