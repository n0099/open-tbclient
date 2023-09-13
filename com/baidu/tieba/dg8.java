package com.baidu.tieba;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailActivity;
import com.baidu.tieba.im.forum.detail.ItemEmotionView;
import com.baidu.tieba.im.forum.detail.ItemFootNavView;
import com.baidu.tieba.im.forum.detail.ItemHeaderView;
import com.baidu.tieba.im.forum.detail.ItemHotThreadView;
import com.baidu.tieba.im.forum.detail.ItemInfoView;
import com.baidu.tieba.im.forum.detail.ItemMsgManage;
import com.baidu.tieba.view.CustomScrollView;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.ManagerApplyInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes5.dex */
public class dg8 extends BdBaseView<ForumDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumDetailActivity a;
    public View b;
    public LinearLayout c;
    public NavigationBar d;
    public NoNetworkView e;
    public NoDataView f;
    public CustomScrollView g;
    public ItemHeaderView h;
    public ItemInfoView i;
    public ItemMsgManage j;
    public ItemEmotionView k;
    public ItemHotThreadView l;
    public ItemFootNavView m;
    public y45 n;
    public View.OnClickListener o;

    /* loaded from: classes5.dex */
    public class a implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dg8 a;

        public a(dg8 dg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dg8Var;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                this.a.n.dismiss();
                this.a.a.s1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dg8 a;

        public b(dg8 dg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dg8Var;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                this.a.n.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dg8 a;

        public c(dg8 dg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dg8Var;
        }

        public /* synthetic */ c(dg8 dg8Var, a aVar) {
            this(dg8Var);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            this.a.m.o(false);
                        }
                    } else {
                        this.a.m.o(true);
                    }
                } else {
                    this.a.m.o(false);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947703700, "Lcom/baidu/tieba/dg8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947703700, "Lcom/baidu/tieba/dg8;");
                return;
            }
        }
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    }

    public void C() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (noDataView = this.f) != null) {
            noDataView.setVisibility(8);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.m.n(this.a);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.showLoadingView(this.b);
        }
    }

    public NoNetworkView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.e;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.a.hideLoadingView(this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg8(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumDetailActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = forumDetailActivity;
        D();
    }

    public void F(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, forumEmotionData) == null) {
            this.k.setEmotionData(forumEmotionData);
        }
    }

    public void I(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.j.setSwitch(z);
        }
    }

    public void K(List<SimpleThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.l.setData(list);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092129);
            TextView textView = new TextView(this.a.getActivity());
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
            this.c.addView(textView, 0);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.d = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0793));
            this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d.showBottomLine();
            this.e = (NoNetworkView) this.a.findViewById(R.id.no_network_view);
            CustomScrollView customScrollView = (CustomScrollView) this.a.findViewById(R.id.obfuscated_res_0x7f092128);
            this.g = customScrollView;
            customScrollView.setOnTouchListener(new c(this, null));
            this.h = (ItemHeaderView) this.a.findViewById(R.id.obfuscated_res_0x7f0911be);
            this.i = (ItemInfoView) this.a.findViewById(R.id.obfuscated_res_0x7f0911c5);
            this.j = (ItemMsgManage) this.a.findViewById(R.id.obfuscated_res_0x7f0911cc);
            this.k = (ItemEmotionView) this.a.findViewById(R.id.obfuscated_res_0x7f0911b7);
            this.l = (ItemHotThreadView) this.a.findViewById(R.id.obfuscated_res_0x7f0911c1);
            ItemFootNavView itemFootNavView = (ItemFootNavView) this.a.findViewById(R.id.obfuscated_res_0x7f0911b8);
            this.m = itemFootNavView;
            itemFootNavView.setClickable(true);
            this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091fea);
            this.j.setMsgOnClickListener(this.a);
            this.k.setEmotionOnClickListener(this.a);
            this.j.setSwitchChangeListener(this.a);
        }
    }

    public void G(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{recommendForumInfo, Boolean.valueOf(z), Boolean.valueOf(z2), managerApplyInfo, priManagerApplyInfo, managerElectionTab}) == null) {
            this.h.setData(recommendForumInfo);
            this.i.setData(recommendForumInfo);
            this.j.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
            this.m.setData(recommendForumInfo, this.a);
        }
    }

    public void H(RecommendForumInfo recommendForumInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, recommendForumInfo, z) == null) {
            this.j.setShowState(recommendForumInfo, z);
        }
    }

    public void O(RecommendForumInfo recommendForumInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, recommendForumInfo, z) == null) {
            this.m.r(z);
            this.j.setShowState(recommendForumInfo, z);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.n == null) {
                y45 y45Var = new y45(this.a.getPageContext().getPageActivity());
                this.n = y45Var;
                y45Var.setMessageId(R.string.obfuscated_res_0x7f0f0eec);
                this.n.setPositiveButton(R.string.alert_yes_button, new a(this));
                this.n.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new b(this));
            }
            this.n.create(getPageContext()).show();
        }
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (this.f == null) {
                NoDataView a2 = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, p), NoDataViewFactory.e.d(null, this.a.getResources().getString(i)), null);
                this.f = a2;
                a2.setOnClickListener(this.o);
            }
            this.f.setTextOption(NoDataViewFactory.e.d(null, this.a.getResources().getString(i)));
            this.f.f(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.b);
            this.d.onChangeSkinType(getPageContext(), i);
            this.e.onChangeSkinType(getPageContext(), i);
            this.h.b(this.a, i);
            this.i.b(this.a, i);
            this.j.b(this.a, i);
            this.l.d(this.a, i);
            this.m.m(this.a, i);
        }
    }
}
