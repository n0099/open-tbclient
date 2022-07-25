package com.baidu.tieba.ala.alasquare.special_forum;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.data.TabData;
import com.baidu.ala.notify.AlaLiveUserNotifyController;
import com.baidu.ala.notify.AlaLiveUserNotifyManager;
import com.baidu.ala.view.ScrollHorizontalTabView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeFrameLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveTabInfo;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.repackage.c9;
import com.repackage.dg5;
import com.repackage.ni;
import com.repackage.oh8;
import com.repackage.pi;
import com.repackage.pr5;
import com.repackage.rr5;
import com.repackage.yr5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class SpecialLiveFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static int U = 1;
    public static HashMap<Integer, Integer> V;
    public transient /* synthetic */ FieldHolder $fh;
    public LikeModel A;
    public CustomMessageListener B;
    public AlaLiveUserNotifyController C;
    public AlaLiveUserNotifyManager.AlaLiveNotifyListener D;
    public BdUniqueId E;
    public int F;
    public String G;
    public String H;
    public String I;
    public boolean J;
    public int K;
    public boolean L;
    public Handler M;
    public Runnable N;
    public CustomMessageListener O;
    public CustomMessageListener P;
    public CustomMessageListener Q;
    public final CustomMessageListener R;
    public final CustomMessageListener S;
    public final CustomMessageListener T;
    public float a;
    public Context b;
    public View c;
    public AppBarLayout d;
    public CollapsingToolbarLayout e;
    public View f;
    public View g;
    public ObservedChangeFrameLayout h;
    public RelativeLayout i;
    public View j;
    public TextView k;
    public TextView l;
    public TextView m;
    public RelativeLayout n;
    public View o;
    public View p;
    public TextView q;
    public ImageView r;
    public ScrollHorizontalTabView s;
    public CustomViewPager t;
    public q u;
    public yr5 v;
    public rr5 w;
    public pr5 x;
    public List<TabData> y;
    public List<SpecialLiveTabInfo> z;

    /* loaded from: classes3.dex */
    public class a implements ScrollHorizontalTabView.ScrollTabPageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        public a(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialLiveFragment;
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageSelected(int i, TabData tabData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, tabData) == null) {
                if (i != 0 || TbadkCoreApplication.isLogin()) {
                    if (this.a.u != null) {
                        this.a.u.e(i, tabData);
                        return;
                    }
                    return;
                }
                ViewHelper.skipToLoginActivity(this.a.getPageContext().getPageActivity());
                if (this.a.t != null) {
                    this.a.t.setCurrentItem(1);
                }
            }
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public boolean onPrePageSelect(int i, TabData tabData) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, tabData)) == null) {
                return true;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        public b(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialLiveFragment;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) {
                int abs = Math.abs(i);
                if (abs == 0) {
                    this.a.o.setVisibility(8);
                    this.a.q.setVisibility(8);
                } else {
                    this.a.o.setVisibility(0);
                    this.a.q.setVisibility(0);
                }
                SpecialLiveFragment specialLiveFragment = this.a;
                float f = abs;
                specialLiveFragment.x2(f > specialLiveFragment.a / 2.0f);
                float abs2 = Math.abs(f / this.a.a);
                this.a.o.setAlpha(abs2);
                this.a.q.setAlpha(abs2);
                this.a.v2(abs, abs2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements dg5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        public c(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialLiveFragment;
        }

        @Override // com.repackage.dg5
        public void a(View view2, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                SpecialLiveFragment specialLiveFragment = this.a;
                specialLiveFragment.a = (specialLiveFragment.h.getMeasuredHeight() + this.a.i.getMeasuredHeight()) - this.a.n.getMeasuredHeight();
                this.a.e.setMinimumHeight(this.a.n.getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements rr5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        public d(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialLiveFragment;
        }

        @Override // com.repackage.rr5.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.e2(i, str);
            }
        }

        @Override // com.repackage.rr5.b
        public void b(pr5 pr5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pr5Var) == null) {
                SpecialLiveFragment specialLiveFragment = this.a;
                specialLiveFragment.hideLoadingView(specialLiveFragment.c);
                this.a.h2(pr5Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AlaLiveUserNotifyManager.AlaLiveNotifyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        public e(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialLiveFragment;
        }

        @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
        public void onCallBack() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.isPrimary()) {
                this.a.C.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SpecialLiveFragment specialLiveFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i)};
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
            this.a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            SignData signData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.l.setClickable(true);
                if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() != this.a.E) {
                    return;
                }
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                SignData signData2 = null;
                if (AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
                    AntiHelper.t(this.a.b, signMessage.signData.blockPopInfoData, null);
                    return;
                }
                if (signMessage == null || (signData = signMessage.signData) == null) {
                    z = false;
                } else {
                    String str = signData.forumId;
                    if (str == null || !str.equals(this.a.G)) {
                        return;
                    }
                    signData2 = signData;
                    z = true;
                }
                if (z) {
                    TbadkCoreApplication.getInst().addSignedForum(this.a.H, signData2.sign_bonus_point, -1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData2));
                    if (AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        AntiHelper.u(this.a.b, signMessage.mSignErrorString);
                        return;
                    } else {
                        pi.O(this.a.b, this.a.b.getString(R.string.obfuscated_res_0x7f0f117f, Integer.valueOf(signData2.sign_bonus_point)));
                        return;
                    }
                }
                if (signMessage.mSignErrorCode == 160002) {
                    this.a.K = 3;
                    this.a.y2(false);
                }
                pi.O(this.a.b, signMessage.mSignErrorString);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        public g(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialLiveFragment;
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.l.setClickable(true);
                if (this.a.A.getErrorCode() == 22) {
                    pi.N(this.a.b, R.string.obfuscated_res_0x7f0f0815);
                } else if (AntiHelper.m(this.a.A.getErrorCode(), this.a.A.getErrorString())) {
                    AntiHelper.u(this.a.b, this.a.A.getErrorString());
                } else if (this.a.A.getErrorCode() != 0) {
                    pi.O(this.a.b, this.a.A.getErrorString());
                } else {
                    oh8 oh8Var = (oh8) obj;
                    if (oh8Var != null) {
                        TbadkCoreApplication.getInst().addLikeForum(this.a.H);
                        oh8Var.y(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, oh8Var));
                        pi.N(this.a.b, R.string.obfuscated_res_0x7f0f02b6);
                        return;
                    }
                    pi.N(this.a.b, R.string.obfuscated_res_0x7f0f0c17);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        public h(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialLiveFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.v == null) {
                return;
            }
            this.a.v.e();
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SpecialLiveFragment specialLiveFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i)};
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
            this.a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.M.removeCallbacks(this.a.N);
                this.a.M.postDelayed(this.a.N, 500L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SpecialLiveFragment specialLiveFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i)};
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
            this.a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length != 2) {
                return;
            }
            if ("FrsLiveLive".equals(split[0])) {
                this.a.t2(false);
            }
            SpecialForumTabBaseFragment b = this.a.u.b(this.a.t.getCurrentItem());
            if (b != null) {
                b.w();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SpecialLiveFragment specialLiveFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i)};
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
            this.a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.w == null || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.a.t2(false);
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(SpecialLiveFragment specialLiveFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i)};
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
            this.a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            oh8 oh8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof oh8) && (oh8Var = (oh8) customResponsedMessage.getData()) != null && this.a.G.equals(oh8Var.g())) {
                if (oh8Var.n() == 1) {
                    if (this.a.s2()) {
                        this.a.K = 3;
                    } else {
                        this.a.K = 2;
                    }
                } else {
                    this.a.K = 1;
                }
                this.a.y2(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(SpecialLiveFragment specialLiveFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i)};
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
            this.a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SignData signData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (signData = (SignData) customResponsedMessage.getData()) != null && this.a.G.equals(signData.forumId) && signData.is_signed == 1) {
                this.a.K = 3;
                this.a.y2(false);
                pi.O(this.a.getPageContext().getPageActivity(), this.a.b.getString(R.string.obfuscated_res_0x7f0f117f, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(SpecialLiveFragment specialLiveFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i)};
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
            this.a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (ListUtils.isEmpty(this.a.y)) {
                    return;
                }
                ((TabData) this.a.y.get(0)).extra = bool;
                this.a.s.setData(this.a.y);
                if (bool.booleanValue()) {
                    TiebaStatic.log("c12898");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        public o(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialLiveFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!ni.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                    return;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.a.b);
                }
                if (this.a.K == 1) {
                    this.a.l.setClickable(false);
                    this.a.A.R(this.a.H, this.a.G);
                    StatisticItem statisticItem = new StatisticItem("c12890");
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                } else if (this.a.K == 2) {
                    this.a.l.setClickable(false);
                    ForumData forumData = new ForumData();
                    forumData.setId(this.a.G);
                    forumData.setName(this.a.H);
                    CustomMessage customMessage = new CustomMessage(2001425, forumData);
                    customMessage.setTag(this.a.E);
                    MessageManager.getInstance().sendMessage(customMessage);
                    StatisticItem statisticItem2 = new StatisticItem("c12892");
                    TiebaStaticHelper.addYYParam(statisticItem2);
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpecialLiveFragment a;

        public p(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = specialLiveFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<SpecialLiveTabInfo> a;
        public SparseArray<SpecialForumTabBaseFragment> b;
        public final /* synthetic */ SpecialLiveFragment c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(SpecialLiveFragment specialLiveFragment, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, fragmentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = specialLiveFragment;
            this.a = new ArrayList();
            SparseArray<SpecialForumTabBaseFragment> sparseArray = new SparseArray<>();
            this.b = sparseArray;
            sparseArray.put(0, ConcernTabFragment.O1(0, specialLiveFragment.G, specialLiveFragment.H));
        }

        public SpecialForumTabBaseFragment b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.b.get(i) : (SpecialForumTabBaseFragment) invokeI.objValue;
        }

        public void c(int i) {
            SparseArray<SpecialForumTabBaseFragment> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (sparseArray = this.b) == null || sparseArray.size() <= 0) {
                return;
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                SpecialForumTabBaseFragment specialForumTabBaseFragment = this.b.get(i2);
                if (specialForumTabBaseFragment != null) {
                    specialForumTabBaseFragment.onChangeSkinType(i);
                }
            }
        }

        public void d(List<SpecialLiveTabInfo> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.a.clear();
            this.a.addAll(list);
            notifyDataSetChanged();
        }

        public void e(int i, TabData tabData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, tabData) == null) || this.b.get(i) == null) {
                return;
            }
            this.b.get(i).setPrimary(true);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                SpecialForumTabBaseFragment b = b(i);
                if (b == null) {
                    if (i == 0) {
                        b = ConcernTabFragment.O1(0, this.c.G, this.c.H);
                    } else if (i == 1) {
                        b = RecommendTabFragment.N1(1, this.c.G, this.c.H);
                    } else {
                        b = OtherSubTabFragment.P1(i, this.a.get(i), this.c.G, this.c.H);
                    }
                    this.b.put(i, b);
                }
                return b;
            }
            return (Fragment) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-764849475, "Lcom/baidu/tieba/ala/alasquare/special_forum/SpecialLiveFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-764849475, "Lcom/baidu/tieba/ala/alasquare/special_forum/SpecialLiveFragment;");
                return;
            }
        }
        V = new HashMap<>();
    }

    public SpecialLiveFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.J = true;
        this.K = 1;
        this.L = false;
        this.M = new Handler();
        this.N = new h(this);
        this.O = new i(this, 2921414);
        this.P = new j(this, 2001446);
        this.Q = new k(this, 2005016);
        this.R = new l(this, 2001266);
        this.S = new m(this, 2001222);
        this.T = new n(this, AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON);
    }

    public static void b2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65565, null, i2) == null) {
            if (V.containsKey(Integer.valueOf(i2))) {
                V.put(Integer.valueOf(i2), Integer.valueOf(V.get(Integer.valueOf(i2)).intValue() + 1));
            } else {
                V.put(Integer.valueOf(i2), 2);
            }
        }
    }

    public static int n2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, null, i2)) == null) {
            if (V.containsKey(Integer.valueOf(i2))) {
                return V.get(Integer.valueOf(i2)).intValue();
            }
            V.put(Integer.valueOf(i2), 1);
            return 1;
        }
        return invokeI.intValue;
    }

    public static SpecialLiveFragment u2(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, str, str2)) == null) {
            SpecialLiveFragment specialLiveFragment = new SpecialLiveFragment();
            Bundle bundle = new Bundle();
            bundle.putString("forum_id", str);
            bundle.putString("forum_name", str2);
            specialLiveFragment.setArguments(bundle);
            return specialLiveFragment;
        }
        return (SpecialLiveFragment) invokeLL.objValue;
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070306);
            if (UtilHelper.canUseStyleImmersiveSticky() && this.f.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.f.setLayoutParams(layoutParams);
                this.f.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
                layoutParams2.height = layoutParams.height;
                this.p.setLayoutParams(layoutParams2);
                dimensionPixelSize += layoutParams.height;
            } else {
                this.f.setVisibility(8);
            }
            CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.n.getLayoutParams();
            ((FrameLayout.LayoutParams) layoutParams3).height = dimensionPixelSize;
            this.n.setLayoutParams(layoutParams3);
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.y.clear();
            this.z.clear();
            this.y.add(j2());
            this.y.add(l2());
            this.z.add(k2());
            this.z.add(m2());
            if (ListUtils.isEmpty(this.x.b)) {
                return;
            }
            for (int i2 = 0; i2 < this.x.b.size() && i2 < 10; i2++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.x.b.get(i2);
                if (specialLiveTabInfo != null && specialLiveTabInfo.tabId != 1108) {
                    this.z.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.y.add(tabData);
                }
            }
        }
    }

    public final void e2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            hideLoadingView(this.c);
            this.d.setVisibility(8);
            if (TextUtils.isEmpty(str)) {
                showNetRefreshView(this.c, this.b.getResources().getString(R.string.obfuscated_res_0x7f0f1196), true);
            } else {
                showNetRefreshView(this.c, str, true);
            }
        }
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.x.c) {
                if (s2()) {
                    this.K = 3;
                } else {
                    this.K = 2;
                }
            } else {
                this.K = 1;
            }
            y2(false);
        }
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean c2 = this.v.c(this.x.a);
            if (c2) {
                this.v.k();
                this.v.g();
            }
            this.v.b(this.x.a, c2);
            if (c2) {
                this.v.a(this.h);
            }
            this.v.j();
        }
    }

    public final void h2(pr5 pr5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pr5Var) == null) {
            this.d.setVisibility(0);
            this.x = pr5Var;
            g2();
            f2();
            if (this.L) {
                return;
            }
            i2();
            CustomViewPager customViewPager = this.t;
            if (customViewPager != null && customViewPager.getChildCount() > 1) {
                this.t.setCurrentItem(1);
            }
            if (ListUtils.isEmpty(this.x.b)) {
                return;
            }
            this.L = true;
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d2();
            this.s.setData(this.y);
            this.u.d(this.z);
        }
    }

    public final TabData j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TabData tabData = new TabData();
            tabData.tabId = -901;
            tabData.tabName = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f1179);
            return tabData;
        }
        return (TabData) invokeV.objValue;
    }

    public final SpecialLiveTabInfo k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
            specialLiveTabInfo.tabId = -901;
            specialLiveTabInfo.tabName = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f1179);
            return specialLiveTabInfo;
        }
        return (SpecialLiveTabInfo) invokeV.objValue;
    }

    public final TabData l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            TabData tabData = new TabData();
            tabData.tabId = -903;
            tabData.tabName = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f117e);
            return tabData;
        }
        return (TabData) invokeV.objValue;
    }

    public final SpecialLiveTabInfo m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
            specialLiveTabInfo.tabId = -903;
            specialLiveTabInfo.tabName = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f117e);
            return specialLiveTabInfo;
        }
        return (SpecialLiveTabInfo) invokeV.objValue;
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.A = likeModel;
            likeModel.setLoadDataCallBack(new g(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            super.onChangeSkinType(i2);
            yr5 yr5Var = this.v;
            if (yr5Var != null) {
                yr5Var.f(i2);
            }
            ScrollHorizontalTabView scrollHorizontalTabView = this.s;
            if (scrollHorizontalTabView != null) {
                SkinManager.setBackgroundResource(scrollHorizontalTabView, R.color.CAM_X0201);
                this.s.onChangeSkinType(i2);
            }
            q qVar = this.u;
            if (qVar != null) {
                qVar.c(i2);
            }
            x2(false);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.l, R.drawable.frs_attention_btn_bg_selector);
            SkinManager.setBackgroundResource(this.g, R.color.CAM_X0204);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments == null) {
                return;
            }
            this.b = getPageContext().getPageActivity();
            this.G = arguments.getString("forum_id");
            String string = arguments.getString("forum_name");
            String string2 = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f064c);
            if (!TextUtils.isEmpty(string)) {
                this.H = string;
                StringBuilder sb = new StringBuilder();
                sb.append(UtilHelper.getFixedBarText(string, 5, true, true) + string2);
                this.I = sb.toString();
            } else {
                this.H = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f024a);
                this.I = this.H + string2;
            }
            o2();
            p2();
            q2();
            MessageManager.getInstance().registerListener(this.B);
            MessageManager.getInstance().registerListener(this.R);
            MessageManager.getInstance().registerListener(this.S);
            MessageManager.getInstance().registerListener(this.T);
            MessageManager.getInstance().registerListener(this.P);
            MessageManager.getInstance().registerListener(this.Q);
            MessageManager.getInstance().registerListener(this.O);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d079a, (ViewGroup) null);
            this.c = inflate;
            this.d = (AppBarLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091de1);
            this.e = (CollapsingToolbarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091de2);
            this.f = this.c.findViewById(R.id.obfuscated_res_0x7f091e3f);
            this.h = (ObservedChangeFrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0912cc);
            this.E = BdUniqueId.gen();
            this.i = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090bf7);
            this.j = this.c.findViewById(R.id.obfuscated_res_0x7f090bf4);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090bfe);
            this.k = textView;
            textView.setText(this.I);
            TextView textView2 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090bf5);
            this.l = textView2;
            textView2.setOnClickListener(new o(this));
            this.m = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090bfb);
            this.n = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091576);
            this.p = this.c.findViewById(R.id.obfuscated_res_0x7f09157a);
            this.o = this.c.findViewById(R.id.obfuscated_res_0x7f091572);
            TextView textView3 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091579);
            this.q = textView3;
            textView3.setText(this.I);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091567);
            this.r = imageView;
            imageView.setOnClickListener(new p(this));
            this.s = (ScrollHorizontalTabView) this.c.findViewById(R.id.obfuscated_res_0x7f091c96);
            this.t = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091de4);
            r2();
            this.s.setViewPager(this.t);
            this.s.setScrollTabPageListener(new a(this));
            this.d.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b(this));
            this.g = this.c.findViewById(R.id.obfuscated_res_0x7f091e12);
            this.h.setOnSizeChangeListener(new c(this));
            c2();
            this.y = new ArrayList();
            this.z = new ArrayList();
            this.v = new yr5(getPageContext());
            this.w = new rr5(getPageContext(), new d(this));
            y2(true);
            t2(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            yr5 yr5Var = this.v;
            if (yr5Var != null) {
                yr5Var.g();
            }
            if (this.R != null) {
                MessageManager.getInstance().unRegisterListener(this.R);
            }
            if (this.B != null) {
                MessageManager.getInstance().unRegisterListener(this.B);
            }
            if (this.S != null) {
                MessageManager.getInstance().unRegisterListener(this.S);
            }
            if (this.T != null) {
                MessageManager.getInstance().unRegisterListener(this.T);
            }
            if (this.P != null) {
                MessageManager.getInstance().unRegisterListener(this.P);
            }
            if (this.Q != null) {
                MessageManager.getInstance().unRegisterListener(this.Q);
            }
            rr5 rr5Var = this.w;
            if (rr5Var != null) {
                rr5Var.f();
            }
            AlaLiveUserNotifyController alaLiveUserNotifyController = this.C;
            if (alaLiveUserNotifyController != null) {
                alaLiveUserNotifyController.onDestroy();
            }
            AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.D);
            hideLoadingView(this.c);
            MessageManager.getInstance().unRegisterListener(this.O);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onNetRefreshButtonClicked();
            hideNetRefreshView(this.c);
            t2(true);
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            yr5 yr5Var = this.v;
            if (yr5Var != null) {
                yr5Var.d(true);
                this.v.k();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                if (isPrimary()) {
                    t2(false);
                    AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                }
                if (this.v != null) {
                    if (isPrimary()) {
                        this.v.d(false);
                        this.v.j();
                        return;
                    }
                    this.v.d(true);
                    this.v.h();
                }
            }
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.C = new AlaLiveUserNotifyController(getPageContext());
            this.D = new e(this);
            AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.D);
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.B = new f(this, 2001425);
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            q qVar = new q(this, getChildFragmentManager());
            this.u = qVar;
            this.t.setAdapter(qVar);
        }
    }

    public final boolean s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.x.e.a : invokeV.booleanValue;
    }

    public final void t2(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || this.w.d()) {
            return;
        }
        if (z) {
            showLoadingView(this.c);
        }
        this.w.e();
    }

    public final void v2(int i2, float f2) {
        yr5 yr5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (yr5Var = this.v) == null || f2 == 0.0f) {
            return;
        }
        if (this.F <= i2) {
            if (this.J && f2 >= 0.3f) {
                yr5Var.d(true);
                this.v.h();
                this.J = false;
            }
        } else if (!this.J && f2 <= 0.3f) {
            yr5Var.d(false);
            this.v.i();
            this.J = true;
        }
        this.F = i2;
    }

    public final void w2() {
        pr5 pr5Var;
        AlaUserInfoData alaUserInfoData;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (pr5Var = this.x) == null || (alaUserInfoData = pr5Var.d) == null || this.K == 1) {
            return;
        }
        int i2 = alaUserInfoData.level_id;
        if (TextUtils.isEmpty(alaUserInfoData.level_name)) {
            str = "";
        } else {
            str = " " + this.x.d.level_name;
        }
        if (i2 < 0) {
            return;
        }
        this.m.setText("LV" + i2 + str);
    }

    public final void x2(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z) == null) || (imageView = this.r) == null) {
            return;
        }
        if (z) {
            SkinManager.setNavbarIconSrc(imageView, R.drawable.selector_topbar_return_black, R.drawable.selector_topbar_return_black, TbadkCoreApplication.getInst().getSkinType());
        } else {
            SkinManager.setNavbarIconSrc(imageView, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void y2(boolean z) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            TextView textView = this.l;
            int i2 = R.drawable.frs_attention_btn_bg_selector;
            SkinManager.setBackgroundResource(textView, R.drawable.frs_attention_btn_bg_selector);
            int f2 = pi.f(this.b, R.dimen.obfuscated_res_0x7f070230);
            String string = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f02a7);
            int i3 = this.K;
            int i4 = R.color.CAM_X0101;
            if (i3 == 1) {
                drawable = SkinManager.getDrawable(R.drawable.icon_add_follow_blue_s);
                this.l.setClickable(true);
                if (!z) {
                    StatisticItem statisticItem = new StatisticItem("c12889");
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                }
            } else if (i3 == 2) {
                string = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f1140);
                drawable = SkinManager.getDrawable(R.drawable.icon_public_sign_blue_s);
                this.l.setClickable(true);
                if (!z) {
                    StatisticItem statisticItem2 = new StatisticItem("c12891");
                    TiebaStaticHelper.addYYParam(statisticItem2);
                    TiebaStatic.log(statisticItem2);
                }
            } else {
                if (i3 == 3) {
                    string = this.b.getResources().getString(R.string.obfuscated_res_0x7f0f115f);
                    this.l.setClickable(false);
                    i2 = R.drawable.special_sign_btn_signed_bg;
                    i4 = R.color.CAM_X0109;
                }
                drawable = null;
            }
            SkinManager.setBackgroundResource(this.l, i2);
            SkinManager.setViewTextColor(this.l, i4);
            this.l.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.l.setCompoundDrawablePadding(f2);
            this.l.setText(string);
            w2();
        }
    }
}
