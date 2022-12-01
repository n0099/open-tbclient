package com.baidu.tieba;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SoLoadUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.ad.incentivevideo.net.GetIncentiveVideoTaskModel;
import com.baidu.tieba.kv4;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.vr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class as8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public final ItemCardHelper.c C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public CustomMessageListener F;
    public Runnable G;
    public Runnable H;
    public Runnable I;
    public MainTabActivity a;
    public FragmentTabHost b;
    public TextView c;
    public boolean d;
    public boolean e;
    public TbImageView f;
    public TbImageView g;
    public PopupWindow h;
    public boolean i;
    public Handler j;
    public f66 k;
    public jx8 l;
    public MaintabBottomIndicator m;
    public MaintabBottomIndicator n;
    public int o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public gs8 t;
    public boolean u;
    public boolean v;
    public boolean w;
    public v39 x;
    public boolean y;
    public FragmentTabHost.b z;

    /* loaded from: classes3.dex */
    public class a implements FragmentTabHost.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        /* renamed from: com.baidu.tieba.as8$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0210a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;

            public RunnableC0210a(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.a);
                }
            }
        }

        public a(as8 as8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        public final void a(int i) {
            String prePageKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.b.g(i).a == 2) {
                    prePageKey = TbPageExtraHelper.getCurrentVisiblePageKey(this.a.a.getPageContext().getContext());
                } else {
                    prePageKey = TbPageExtraHelper.getPrePageKey();
                }
                ah.a().postDelayed(new RunnableC0210a(this, new CustomResponsedMessage(2921520, prePageKey)), 100L);
            }
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                int i2 = this.a.b.g(i).a;
                if (i2 == 8) {
                    TbPageExtraHelper.setPrePageKey("a011");
                } else if (i2 == 2) {
                    TbPageExtraHelper.setPrePageKey("a002");
                } else if (i2 == 3) {
                    TbPageExtraHelper.setPrePageKey("a079");
                } else if (i2 == 1) {
                    TbPageExtraHelper.setPrePageKey("a025");
                } else if (i2 == 21) {
                    TbPageExtraHelper.setPrePageKey("a075");
                } else if (i2 == 22) {
                    TbPageExtraHelper.setPrePageKey("a088");
                }
            }
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        public boolean onPreTabSelectionChange(int i, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                FragmentTabHost.c g = this.a.b.g(i);
                if (g.a != 2 && FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.a.getPageContext(), null)) {
                    return false;
                }
                int i2 = g.a;
                if (i2 == 9) {
                    if (DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a, LoginDialogData.HOME_PAGE_WRITE_PAGE))) {
                        this.a.x.m();
                    }
                    return false;
                } else if (i2 == 8 && !TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.a.getActivity(), "maintab_person");
                    if (this.a.m != null) {
                        this.a.m.n();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                    return false;
                } else {
                    int i3 = g.a;
                    if (i3 == 15) {
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                        if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                            return false;
                        }
                    } else if (i3 == 3 && !TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.a.a.getActivity(), "maintab_msg");
                        return false;
                    } else if (g.a == 1) {
                        TiebaStatic.log(new StatisticItem("c13001"));
                    }
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00f0, code lost:
            if (com.baidu.tbadk.core.util.UtilHelper.isNumber(r1) != false) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x02a0, code lost:
            if (com.baidu.tbadk.core.util.UtilHelper.isNumber(r14) != false) goto L47;
         */
        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTabSelectionChanged(int i, boolean z) {
            String str;
            int i2;
            boolean z2;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                FragmentTabHost.c g = this.a.b.g(i);
                int i5 = g.a;
                int i6 = 3;
                int i7 = 2;
                if (i5 == 8) {
                    TbSingleton.getInstance().setMyTabClicked(true);
                    if (this.a.m != null && this.a.m.getAnimationView() != null && this.a.m.getAnimationView().getVisibility() == 0) {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                    }
                    if (this.a.m != null) {
                        this.a.m.n();
                    }
                    TiebaStatic.log("c13841");
                    SoLoadUtils.checkDownloadSo("libmml_framework.so", "com.baidu.tieba.soloader.libmmlframework", "mml_framework");
                    SoLoadUtils.checkDownloadSo("libc++_shared.so", "com.baidu.tieba.soloader.libcshared", SwanKV.LIB_CPP_SHARED);
                    SoLoadUtils.checkDownloadSo("libopencv_java3.so", "com.baidu.tieba.soloader.libopencv_java3", "opencv_java3");
                    SoLoadUtils.checkDownloadSo("libbd_pass_face_sdk.so", "com.baidu.tieba.soloader.libbdface", "bd_pass_face_sdk");
                } else if (i5 == 3) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
                    TbFragmentTabIndicator tbFragmentTabIndicator = g.b;
                    if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
                        if (maintabBottomIndicator.d("msg") != null && (maintabBottomIndicator.d("msg").a instanceof MessageRedDotView)) {
                            str = ((MessageRedDotView) maintabBottomIndicator.d("msg").a).getRedNum();
                            if (!TextUtils.isEmpty(str)) {
                            }
                        }
                    }
                    str = "0";
                    if (z) {
                        try {
                            i2 = Integer.parseInt(str);
                        } catch (Exception e) {
                            e.printStackTrace();
                            i2 = 0;
                        }
                        if (i2 > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount());
                        if (z2) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        TiebaStatic.log(param.param("obj_type", i3).param("obj_param1", str));
                        StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_TAB_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", str);
                        if (z2) {
                            i4 = 1;
                        } else {
                            i4 = 2;
                        }
                        TiebaStatic.log(param2.param("obj_type", i4).param("obj_source", 1));
                    }
                }
                if (g.a != 2) {
                    this.a.r = true;
                    if (this.a.p && this.a.n != null) {
                        this.a.n.x(this.a.p);
                    }
                    this.a.p = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
                    if (WindowGreySwitch.getIsOnNew()) {
                        u9.a(this.a.b.getFragmentTabWidget());
                        u9.a(this.a.f);
                    }
                } else {
                    if (this.a.p) {
                        MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                    }
                    this.a.p = true;
                    int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                    if (this.a.q == 2 && this.a.o != i && homeBarShowType == 1 && this.a.n != null) {
                        this.a.n.y();
                    } else if (this.a.q == 1 && this.a.n != null) {
                        this.a.n.x(this.a.p);
                    }
                    this.a.r = false;
                    if (WindowGreySwitch.getIsOnNew()) {
                        u9.b(this.a.b.getFragmentTabWidget());
                        u9.b(this.a.f);
                    }
                }
                if (this.a.z() != null) {
                    this.a.z().w = this.a.p;
                }
                b(this.a.o);
                a(this.a.o);
                this.a.o = i;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
                if (g.a == 22) {
                    TbFragmentTabIndicator tbFragmentTabIndicator2 = g.b;
                    if (tbFragmentTabIndicator2 instanceof MaintabBottomIndicator) {
                        MaintabBottomIndicator maintabBottomIndicator2 = (MaintabBottomIndicator) tbFragmentTabIndicator2;
                        if (maintabBottomIndicator2.d("video_msg") != null && (maintabBottomIndicator2.d("video_msg").a instanceof MessageRedDotView)) {
                            String redNum = ((MessageRedDotView) maintabBottomIndicator2.d("video_msg").a).getRedNum();
                            if (!TextUtils.isEmpty(redNum)) {
                            }
                        }
                    }
                    i7 = 1;
                    if (this.a.s) {
                        this.a.s = false;
                    } else {
                        i6 = i7;
                    }
                    if (z) {
                        long logWithBackTime = TiebaStatic.logWithBackTime(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", i6));
                        if (this.a.b.g(this.a.b.getCurrentTabIndex()) != null && this.a.b.g(this.a.b.getCurrentTabIndex()).a != 22) {
                            TbSingleton.getInstance().setCurrentClickTime(logWithBackTime);
                        }
                    }
                    mb5.b().c();
                    mb5.b().l(true);
                    if (this.a.b.g(this.a.b.getCurrentTabIndex()) != null && this.a.b.g(this.a.b.getCurrentTabIndex()).a == 22) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.FALSE));
                    } else {
                        if (this.a.b.getFragmentTabWidget() != null) {
                            this.a.b.getFragmentTabWidget().h(true, R.color.CAM_X0215);
                        }
                        this.a.b.q(true);
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            yi.M(this.a.a, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c81));
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921580, Boolean.TRUE));
                    }
                } else {
                    mb5.b().o();
                    mb5.b().l(false);
                    if (this.a.b.getFragmentTabWidget() != null) {
                        this.a.b.getFragmentTabWidget().h(false, R.color.CAM_X0207);
                    }
                    this.a.b.q(false);
                }
                if (g.a == 1 && TbSingleton.getInstance().needRefreshForumSquare) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921589));
                    TbSingleton.getInstance().needRefreshForumSquare = false;
                }
                if (g.a == 22) {
                    this.a.t.f(true);
                } else {
                    this.a.t.f(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921728));
                }
            }
        }

        public b(as8 as8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.a.b.getCurrentTabType() == 2) {
                    TiebaStatic.log("kantie_entry");
                } else if (this.a.b.getCurrentTabType() == 15) {
                    TiebaStatic.log("c12124");
                }
                if (this.a.b.getCurrentTabType() != this.a.b.g(i).a) {
                    this.a.b.setCurrentTab(i);
                }
                if (this.a.b.getCurrentTabType() == 1 && !qy4.k().h("has_guide_popup_window_been_shown", false)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
                }
                if (qy4.k().h("enter_forum_edit_mode", false)) {
                    if (this.a.b.getCurrentTabType() == 3) {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                    } else if (this.a.b.getCurrentTabType() == 2) {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                    }
                }
                if (this.a.b.getCurrentTabType() == 3) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
                }
                ah.a().postDelayed(new a(this), 300L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ as8 b;

        public c(as8 as8Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = as8Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.P(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        public d(as8 as8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null && this.a.h != null) {
                FragmentTabWidget fragmentTabWidget = this.a.b.getFragmentTabWidget();
                yi.l(this.a.a.getActivity());
                int g = yi.g(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f07025e);
                View contentView = this.a.h.getContentView();
                if (contentView == null) {
                    return;
                }
                contentView.measure(0, 0);
                int measuredWidth = contentView.getMeasuredWidth();
                FragmentTabHost.c h = this.a.b.h(3);
                if (h == null || (tbFragmentTabIndicator = h.b) == null) {
                    return;
                }
                int[] iArr = new int[2];
                tbFragmentTabIndicator.getLocationInWindow(iArr);
                int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
                if (measuredWidth2 <= 0) {
                    measuredWidth2 = yi.g(this.a.a.getActivity(), R.dimen.tbds570);
                }
                ch.l(this.a.h, fragmentTabWidget, measuredWidth2, -g);
                qy4.k().u("show_maintab_last_message_tips", true);
                this.a.i = true;
                this.a.j.postDelayed(this.a.I, 5000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        public e(as8 as8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(as8 as8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "1");
                TiebaStatic.log(statisticItem);
                kv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(as8 as8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                StatisticItem statisticItem = new StatisticItem("c12137");
                statisticItem.param("obj_locate", "2");
                TiebaStatic.log(statisticItem);
                kv4Var.dismiss();
                dy6.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements vr5.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        public h(as8 as8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        @Override // com.baidu.tieba.vr5.f
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mr5.i().v(6);
                mr5.i().t();
                new GetIncentiveVideoTaskModel(this.a.a, 6).H();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_FLOAT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", 1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements vr5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(as8 as8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.vr5.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_FLOAT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", 2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(as8 as8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            qa5 qa5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.b != null && (customResponsedMessage.getData() instanceof qa5) && (qa5Var = (qa5) customResponsedMessage.getData()) != null && this.a.b.h(qa5Var.e) != null && this.a.b.getCurrentTabType() != qa5Var.e) {
                TbFragmentTabIndicator tbFragmentTabIndicator = this.a.b.h(qa5Var.e).b;
                if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                    ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(qa5Var.g, qa5Var.c);
                    if (TextUtils.isEmpty(qa5Var.g)) {
                        return;
                    }
                    this.a.s = true;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(as8 as8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), this.a.a.getActivityRootView());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        public l(as8 as8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.y(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.a.getActivityRootView(), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.y(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.a.getActivityRootView(), j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(as8 as8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ta5 c;
            ta5 c2;
            ta5 c3;
            ta5 c4;
            ta5 c5;
            ta5 c6;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.b != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && wa5.d().b()) {
                TbadkCoreApplication.getInst().setBottomBarDynamicHeightValid(true);
                FragmentTabHost.c h = this.a.b.h(2);
                if (h != null && (h.b instanceof MaintabBottomIndicator) && (c6 = wa5.d().c("homePage")) != null) {
                    ((MaintabBottomIndicator) h.b).setDynamicIconData(c6);
                }
                FragmentTabHost.c h2 = this.a.b.h(1);
                if (h2 != null && (h2.b instanceof MaintabBottomIndicator) && (c5 = wa5.d().c("enterForum")) != null) {
                    ((MaintabBottomIndicator) h2.b).setDynamicIconData(c5);
                }
                FragmentTabHost.c h3 = this.a.b.h(22);
                if (h3 != null && (h3.b instanceof MaintabBottomIndicator) && (c4 = wa5.d().c("channel")) != null) {
                    ((MaintabBottomIndicator) h3.b).setDynamicIconData(c4);
                }
                FragmentTabHost.c h4 = this.a.b.h(3);
                if (h4 != null && (h4.b instanceof MaintabBottomIndicator) && (c3 = wa5.d().c("message")) != null) {
                    ((MaintabBottomIndicator) h4.b).setDynamicIconData(c3);
                }
                FragmentTabHost.c h5 = this.a.b.h(8);
                if (h5 != null && (h5.b instanceof MaintabBottomIndicator) && (c2 = wa5.d().c("person")) != null) {
                    ((MaintabBottomIndicator) h5.b).setDynamicIconData(c2);
                }
                if (this.a.f != null && this.a.f.getVisibility() == 0 && (c = wa5.d().c(AlbumActivityConfig.FROM_WRITE)) != null) {
                    this.a.f.setVisibility(8);
                    this.a.g.setUseNightOrDarkMask(false);
                    this.a.g.setVisibility(0);
                    this.a.g.K(c.t(), c.s(), false);
                }
                if (wa5.d().g() != null) {
                    this.a.b.n(wa5.d().g());
                    this.a.b.setShouldDrawTopLine(false);
                    this.a.b.p();
                }
                this.a.b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(as8 as8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || this.a.z() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof Integer) || this.a.b.g(this.a.b.getCurrentTabIndex()).a != 2) {
                return;
            }
            int intValue = ((Integer) data).intValue();
            if (intValue != 4) {
                if (intValue == 6) {
                    this.a.r = false;
                    if (this.a.q == 1) {
                        return;
                    }
                } else {
                    this.a.q = intValue;
                }
                if (this.a.q == 1) {
                    this.a.z().x(this.a.p);
                } else if (this.a.q == 2) {
                    this.a.z().y();
                } else if (intValue != 5) {
                    this.a.z().v();
                } else {
                    this.a.q = 1;
                    this.a.p = true;
                    if (!this.a.r) {
                        this.a.z().w();
                    }
                }
                this.a.z().v = true;
                this.a.z().x = this.a.q;
                this.a.z().w = this.a.p;
                return;
            }
            this.a.r = true;
            this.a.p = true;
            if (this.a.q == 2) {
                this.a.z().w();
            } else if (this.a.n != null && this.a.n.p()) {
                this.a.n.x(this.a.p);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(as8 as8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.p = true;
            if (this.a.z() != null) {
                this.a.z().w = this.a.p;
            }
            qy4.k().u("key_member_auto_ban_renewal_show", false);
            TbSingleton.getInstance().hasPerformInterestPanelShow = false;
            uq5.k().o();
            mr5.i().s();
            ey4.b().l();
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        public p(as8 as8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setVisibility(4);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as8 a;

        public q(as8 as8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.setVisibility(0);
            }
        }
    }

    public as8(MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.i = false;
        this.j = new Handler();
        this.o = 0;
        this.p = true;
        this.q = 1;
        this.r = false;
        this.s = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.y = false;
        this.z = new a(this);
        this.A = new j(this, 2921492);
        this.B = new k(this, 2001440);
        this.C = new l(this);
        this.D = new m(this, 2921551);
        this.E = new n(this, 2921382);
        this.F = new o(this, 2921410);
        this.H = new d(this);
        this.I = new e(this);
        this.a = mainTabActivity;
    }

    public void H(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (fragmentTabHost = this.b) != null) {
            if (z) {
                fragmentTabHost.i();
            } else {
                fragmentTabHost.u();
            }
        }
    }

    public void U(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, postWriteCallBackData) == null) {
            if (this.k == null) {
                this.k = new f66(this.a.getPageContext(), (NavigationBarCoverTip) this.a.findViewById(R.id.obfuscated_res_0x7f09169b));
            }
            this.k.l(postWriteCallBackData);
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.e = z;
            if (!z) {
                qy4.k().u("enter_forum_edit_mode", false);
            }
        }
    }

    public MaintabBottomIndicator A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.m;
        }
        return (MaintabBottomIndicator) invokeV.objValue;
    }

    public FragmentTabHost B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (FragmentTabHost) invokeV.objValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r = false;
            this.q = 1;
            if (z() != null) {
                z().x = this.q;
            }
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.B);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            qy4.k().u("has_show_message_tab_tips", this.d);
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (B() == null) {
                return true;
            }
            FragmentTabHost B = B();
            FragmentTabHost.c g2 = B.g(B.getCurrentTabIndex());
            if (g2 == null || g2.a != 22) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.j.removeCallbacks(this.H);
            this.j.removeCallbacks(this.I);
            ch.c(this.h);
        }
    }

    public MaintabBottomIndicator z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.n;
        }
        return (MaintabBottomIndicator) invokeV.objValue;
    }

    public void C(ArrayList<pa5> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.b.t();
            Iterator<pa5> it = arrayList.iterator();
            while (it.hasNext()) {
                pa5 next = it.next();
                if (next != null && next.d()) {
                    x(next, next.b(), next.c(this.a.getPageContext().getPageActivity()));
                }
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
                this.b.l(2);
            } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.b.l(1);
            } else {
                this.b.l(0);
            }
            this.b.setViewPagerScrollable(false);
        }
    }

    public void F(int i2) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i2) != null) || (fragmentTabHost = this.b) == null) {
            return;
        }
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            fragmentTabHost.setShouldDrawTopLine(true);
        }
        v39 v39Var = this.x;
        if (v39Var != null) {
            v39Var.i(i2);
        }
        this.b.s(i2);
        FragmentTabHost fragmentTabHost2 = this.b;
        FragmentTabHost.c g2 = fragmentTabHost2.g(fragmentTabHost2.getCurrentTabIndex());
        if (g2 != null && g2.a == 22) {
            if (this.b.getFragmentTabWidget() != null) {
                this.b.getFragmentTabWidget().h(true, R.color.CAM_X0215);
            }
            this.b.q(true);
        } else {
            if (this.b.getFragmentTabWidget() != null) {
                this.b.getFragmentTabWidget().h(false, R.color.CAM_X0207);
            }
            this.b.q(false);
        }
        if (wa5.d().g() != null) {
            this.b.setShouldDrawTopLine(false);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            N();
            if (B() != null) {
                B().t();
            }
            y();
            f66 f66Var = this.k;
            if (f66Var != null) {
                f66Var.h();
            }
            jx8 jx8Var = this.l;
            if (jx8Var != null) {
                jx8Var.e();
            }
            ItemCardHelper.w(null);
            vr5.K().J();
        }
    }

    public void I(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (this.u != z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921645, Boolean.valueOf(z)));
                this.w = z;
                this.u = z;
            }
            if (!this.v && !this.w) {
                z2 = false;
            } else {
                z2 = true;
            }
            H(z2);
        }
    }

    public void M(int i2) {
        MaintabBottomIndicator maintabBottomIndicator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            B().setCurrentTabByType(i2);
            if (i2 != 2) {
                this.r = true;
                if (this.p && (maintabBottomIndicator = this.n) != null) {
                    maintabBottomIndicator.x(false);
                }
                this.p = false;
                if (z() != null) {
                    z().w = this.p;
                }
            }
        }
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            kv4 kv4Var = new kv4(this.a.getActivity());
            kv4Var.setMessage(str);
            kv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0402, new f(this));
            kv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03b4, new g(this));
            kv4Var.create(this.a.getPageContext()).show();
        }
    }

    public void T(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, postWriteCallBackData) == null) && postWriteCallBackData != null && this.a.getActivityRootView() != null && postWriteCallBackData.mFrom == 1) {
            if (this.l == null) {
                MainTabActivity mainTabActivity = this.a;
                this.l = new jx8(mainTabActivity, mainTabActivity.getActivityRootView());
            }
            this.l.g(postWriteCallBackData);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ItemCardHelper.w(this.C);
            MessageManager.getInstance().registerListener(this.B);
            if (this.y != WindowGreySwitch.getIsOnNew()) {
                if (this.p && this.b != null) {
                    if (WindowGreySwitch.getIsOnNew()) {
                        u9.b(this.b.getFragmentTabWidget());
                        u9.b(this.f);
                    } else {
                        u9.a(this.b.getFragmentTabWidget());
                        u9.a(this.f);
                    }
                }
                this.y = WindowGreySwitch.getIsOnNew();
            }
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) this.a.findViewById(R.id.obfuscated_res_0x7f09206c);
            this.b = fragmentTabHost;
            fragmentTabHost.setVisibility(8);
            vr8.b(new p(this), 1);
            vr8.b(new q(this), 6);
            this.b.setup(this.a.getSupportFragmentManager());
            this.b.setAbsoluteWeight(true);
            this.b.setOnTabSelectionListener(this.z);
            this.b.s(TbadkCoreApplication.getInst().getSkinType());
            if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
                this.b.setShouldDrawIndicatorLine(false);
                this.b.setShouldDrawTopLine(true);
            }
            this.b.setOnPageChangeListener(new b(this));
            this.f = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090dd8);
            this.g = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090dd7);
            this.d = qy4.k().h("has_show_message_tab_tips", false);
            this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090078);
            this.b.setUIType(0);
            this.b.setTabContainerShadowShow(false);
            this.b.setBackGroundStyle(0);
            this.b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            gs8 gs8Var = new gs8(this.a, this.b.getTabWrapper());
            this.t = gs8Var;
            gs8Var.f(false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.a.getPageContext()));
            if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
                this.a.registerListener(this.E);
            }
            this.a.registerListener(this.F);
            this.a.registerListener(this.A);
            this.a.registerListener(this.D);
            this.x = new v39(this.a, "main_tab", 1, "8");
        }
    }

    public void P(String str) {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (StringUtils.isNull(str)) {
                this.c.setVisibility(8);
                return;
            }
            FragmentTabHost.c h2 = this.b.h(8);
            if (h2 != null) {
                if (this.i && ((popupWindow = this.h) == null || !popupWindow.isShowing())) {
                    Q(str, h2);
                    return;
                }
                if (this.G == null) {
                    this.G = new c(this, str);
                }
                TbadkCoreApplication.getInst().handler.removeCallbacks(this.G);
                TbadkCoreApplication.getInst().handler.postDelayed(this.G, 5000L);
                return;
            }
            this.c.setVisibility(8);
        }
    }

    public boolean w(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || xi.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (!qy4.k().h(qy4.o(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void Q(String str, FragmentTabHost.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, cVar) == null) {
            int[] iArr = new int[2];
            cVar.b.getLocationInWindow(iArr);
            int width = iArr[0] + (cVar.b.getWidth() / 2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.rightMargin = (yi.t(this.a).widthPixels - width) - yi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701f0);
            this.c.setLayoutParams(layoutParams);
            this.c.setVisibility(0);
            this.c.setText(str);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            vr5.K().N(this.a);
            vr5.K().X(yi.l(this.a));
            vr5.K().W(yi.j(this.a));
            vr5.K().Y(yi.u(this.a));
            vr5.K().Z(yi.g(this.a, R.dimen.tbds352));
            vr5.K().S(yi.g(this.a, R.dimen.tbds150));
            vr5.K().U(new h(this));
            vr5.K().V(new i(this));
            if (lr5.h().b() > 0) {
                long b2 = lr5.h().b() * 1000;
                vr5.K().a0(b2);
                vr5.K().T(b2);
                vr5.K().b0();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_FLOAT_SHOW).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    public final void x(pa5 pa5Var, qa5 qa5Var, TbFragmentTabIndicator tbFragmentTabIndicator) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048599, this, pa5Var, qa5Var, tbFragmentTabIndicator) == null) && qa5Var != null && (tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
            FragmentTabHost.c cVar = new FragmentTabHost.c();
            cVar.c = qa5Var.a;
            cVar.a = qa5Var.e;
            maintabBottomIndicator.setShowIconType(qa5Var.i);
            int i2 = qa5Var.i;
            boolean z = false;
            if (i2 == qa5.j) {
                maintabBottomIndicator.setWriteIconView();
                ta5 ta5Var = qa5Var.h;
                if (ta5Var != null && !TextUtils.isEmpty(ta5Var.t())) {
                    this.f.setVisibility(8);
                    this.g.setVisibility(0);
                    this.g.K(qa5Var.h.t(), qa5Var.h.s(), false);
                } else {
                    this.f.setVisibility(0);
                    this.f.setImageResource(qa5Var.d);
                }
                z = true;
            } else if (i2 == qa5.m) {
                maintabBottomIndicator.setText(qa5Var.b);
                maintabBottomIndicator.setAnimationResId(qa5Var.f);
                this.m = maintabBottomIndicator;
            } else {
                maintabBottomIndicator.setText(qa5Var.b);
                maintabBottomIndicator.setAnimationResId(qa5Var.f);
            }
            if (!xi.isEmpty(qa5Var.g)) {
                maintabBottomIndicator.setImageIconUrl(qa5Var.g, qa5Var.c);
            }
            ta5 ta5Var2 = qa5Var.h;
            if (ta5Var2 != null) {
                maintabBottomIndicator.setDynamicIconData(ta5Var2);
            }
            if (cVar.a == 2) {
                maintabBottomIndicator.z = true;
                this.n = maintabBottomIndicator;
            }
            tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            cVar.b = maintabBottomIndicator;
            cVar.d = pa5Var;
            this.b.d(cVar, -1, z);
        }
    }
}
