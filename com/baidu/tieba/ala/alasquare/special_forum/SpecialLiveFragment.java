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
import c.a.r0.j3.x;
import c.a.r0.v.f.g.d.a;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class SpecialLiveFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LIVE_FEED_LOAD_MORE = 1;
    public static final int LIVE_FEED_REFRESH_NEW = 0;
    public static HashMap<Integer, Integer> Y = null;
    public static int mRefreshNewCountRecommendTab = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.v.f.g.d.a A;
    public c.a.r0.v.f.g.c.h B;
    public List<TabData> C;
    public List<SpecialLiveTabInfo> D;
    public LikeModel E;
    public CustomMessageListener F;
    public AlaLiveUserNotifyController G;
    public AlaLiveUserNotifyManager.AlaLiveNotifyListener H;
    public BdUniqueId I;
    public int J;
    public String K;
    public String L;
    public String M;
    public boolean N;
    public int O;
    public boolean P;
    public Handler Q;
    public Runnable R;
    public CustomMessageListener S;
    public CustomMessageListener T;
    public CustomMessageListener U;
    public final CustomMessageListener V;
    public final CustomMessageListener W;
    public final CustomMessageListener X;

    /* renamed from: e  reason: collision with root package name */
    public float f49618e;

    /* renamed from: f  reason: collision with root package name */
    public Context f49619f;

    /* renamed from: g  reason: collision with root package name */
    public View f49620g;

    /* renamed from: h  reason: collision with root package name */
    public AppBarLayout f49621h;

    /* renamed from: i  reason: collision with root package name */
    public CollapsingToolbarLayout f49622i;

    /* renamed from: j  reason: collision with root package name */
    public View f49623j;
    public View k;
    public ObservedChangeFrameLayout l;
    public RelativeLayout m;
    public View n;
    public TextView o;
    public TextView p;
    public TextView q;
    public RelativeLayout r;
    public View s;
    public View t;
    public TextView u;
    public ImageView v;
    public ScrollHorizontalTabView w;
    public CustomViewPager x;
    public q y;
    public c.a.r0.v.f.g.f.e z;

    /* loaded from: classes7.dex */
    public class a implements ScrollHorizontalTabView.ScrollTabPageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49624a;

        public a(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49624a = specialLiveFragment;
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageSelected(int i2, TabData tabData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, tabData) == null) {
                if (i2 != 0 || TbadkCoreApplication.isLogin()) {
                    if (this.f49624a.y != null) {
                        this.f49624a.y.b(i2, tabData);
                        return;
                    }
                    return;
                }
                ViewHelper.skipToLoginActivity(this.f49624a.getPageContext().getPageActivity());
                if (this.f49624a.x != null) {
                    this.f49624a.x.setCurrentItem(1);
                }
            }
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public boolean onPrePageSelect(int i2, TabData tabData) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, tabData)) == null) {
                return true;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49625a;

        public b(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49625a = specialLiveFragment;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                int abs = Math.abs(i2);
                if (abs == 0) {
                    this.f49625a.s.setVisibility(8);
                    this.f49625a.u.setVisibility(8);
                } else {
                    this.f49625a.s.setVisibility(0);
                    this.f49625a.u.setVisibility(0);
                }
                SpecialLiveFragment specialLiveFragment = this.f49625a;
                float f2 = abs;
                specialLiveFragment.i0(f2 > specialLiveFragment.f49618e / 2.0f);
                float abs2 = Math.abs(f2 / this.f49625a.f49618e);
                this.f49625a.s.setAlpha(abs2);
                this.f49625a.u.setAlpha(abs2);
                this.f49625a.g0(abs, abs2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.a.q0.f1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49626a;

        public c(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49626a = specialLiveFragment;
        }

        @Override // c.a.q0.f1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                SpecialLiveFragment specialLiveFragment = this.f49626a;
                specialLiveFragment.f49618e = (specialLiveFragment.l.getMeasuredHeight() + this.f49626a.m.getMeasuredHeight()) - this.f49626a.r.getMeasuredHeight();
                this.f49626a.f49622i.setMinimumHeight(this.f49626a.r.getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49627a;

        public d(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49627a = specialLiveFragment;
        }

        @Override // c.a.r0.v.f.g.d.a.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f49627a.R(i2, str);
            }
        }

        @Override // c.a.r0.v.f.g.d.a.b
        public void b(c.a.r0.v.f.g.c.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
                SpecialLiveFragment specialLiveFragment = this.f49627a;
                specialLiveFragment.hideLoadingView(specialLiveFragment.f49620g);
                this.f49627a.U(hVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements AlaLiveUserNotifyManager.AlaLiveNotifyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49628a;

        public e(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49628a = specialLiveFragment;
        }

        @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
        public void onCallBack() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f49628a.isPrimary()) {
                this.f49628a.G.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49629a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SpecialLiveFragment specialLiveFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49629a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            SignData signData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f49629a.p.setClickable(true);
                if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() != this.f49629a.I) {
                    return;
                }
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                SignData signData2 = null;
                if (AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
                    AntiHelper.t(this.f49629a.f49619f, signMessage.signData.blockPopInfoData, null);
                    return;
                }
                if (signMessage == null || (signData = signMessage.signData) == null) {
                    z = false;
                } else {
                    String str = signData.forumId;
                    if (str == null || !str.equals(this.f49629a.K)) {
                        return;
                    }
                    signData2 = signData;
                    z = true;
                }
                if (z) {
                    TbadkCoreApplication.getInst().addSignedForum(this.f49629a.L, signData2.sign_bonus_point, -1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData2));
                    if (AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        AntiHelper.u(this.f49629a.f49619f, signMessage.mSignErrorString);
                        return;
                    } else {
                        c.a.e.e.p.l.M(this.f49629a.f49619f, this.f49629a.f49619f.getString(R.string.special_sign_success_tip, Integer.valueOf(signData2.sign_bonus_point)));
                        return;
                    }
                }
                if (signMessage.mSignErrorCode == 160002) {
                    this.f49629a.O = 3;
                    this.f49629a.j0(false);
                }
                c.a.e.e.p.l.M(this.f49629a.f49619f, signMessage.mSignErrorString);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49630a;

        public g(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49630a = specialLiveFragment;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f49630a.p.setClickable(true);
                if (this.f49630a.E.getErrorCode() == 22) {
                    c.a.e.e.p.l.L(this.f49630a.f49619f, R.string.had_liked_forum);
                } else if (AntiHelper.m(this.f49630a.E.getErrorCode(), this.f49630a.E.getErrorString())) {
                    AntiHelper.u(this.f49630a.f49619f, this.f49630a.E.getErrorString());
                } else if (this.f49630a.E.getErrorCode() != 0) {
                    c.a.e.e.p.l.M(this.f49630a.f49619f, this.f49630a.E.getErrorString());
                } else {
                    x xVar = (x) obj;
                    if (xVar != null) {
                        TbadkCoreApplication.getInst().addLikeForum(this.f49630a.L);
                        xVar.v(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                        c.a.e.e.p.l.L(this.f49630a.f49619f, R.string.attention_success);
                        return;
                    }
                    c.a.e.e.p.l.L(this.f49630a.f49619f, R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49631e;

        public h(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49631e = specialLiveFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f49631e.z == null) {
                return;
            }
            this.f49631e.z.e();
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49632a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SpecialLiveFragment specialLiveFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49632a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f49632a.Q.removeCallbacks(this.f49632a.R);
                this.f49632a.Q.postDelayed(this.f49632a.R, 500L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49633a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SpecialLiveFragment specialLiveFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49633a = specialLiveFragment;
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
                this.f49633a.f0(false);
            }
            SpecialForumTabBaseFragment a2 = this.f49633a.y.a(this.f49633a.x.getCurrentItem());
            if (a2 != null) {
                a2.forceRefresh();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49634a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SpecialLiveFragment specialLiveFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49634a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f49634a.A == null || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.f49634a.f0(false);
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49635a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(SpecialLiveFragment specialLiveFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49635a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            x xVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x) && (xVar = (x) customResponsedMessage.getData()) != null && this.f49635a.K.equals(xVar.g())) {
                if (xVar.l() == 1) {
                    if (this.f49635a.e0()) {
                        this.f49635a.O = 3;
                    } else {
                        this.f49635a.O = 2;
                    }
                } else {
                    this.f49635a.O = 1;
                }
                this.f49635a.j0(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49636a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(SpecialLiveFragment specialLiveFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49636a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SignData signData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (signData = (SignData) customResponsedMessage.getData()) != null && this.f49636a.K.equals(signData.forumId) && signData.is_signed == 1) {
                this.f49636a.O = 3;
                this.f49636a.j0(false);
                c.a.e.e.p.l.M(this.f49636a.getPageContext().getPageActivity(), this.f49636a.f49619f.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49637a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(SpecialLiveFragment specialLiveFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49637a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (ListUtils.isEmpty(this.f49637a.C)) {
                    return;
                }
                ((TabData) this.f49637a.C.get(0)).extra = bool;
                this.f49637a.w.setData(this.f49637a.C);
                if (bool.booleanValue()) {
                    TiebaStatic.log("c12898");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49638e;

        public o(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49638e = specialLiveFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!c.a.e.e.p.j.z()) {
                    this.f49638e.showToast(R.string.neterror);
                    return;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.f49638e.f49619f);
                }
                if (this.f49638e.O == 1) {
                    this.f49638e.p.setClickable(false);
                    this.f49638e.E.L(this.f49638e.L, this.f49638e.K);
                    StatisticItem statisticItem = new StatisticItem("c12890");
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                } else if (this.f49638e.O == 2) {
                    this.f49638e.p.setClickable(false);
                    ForumData forumData = new ForumData();
                    forumData.setId(this.f49638e.K);
                    forumData.setName(this.f49638e.L);
                    CustomMessage customMessage = new CustomMessage(2001425, forumData);
                    customMessage.setTag(this.f49638e.I);
                    MessageManager.getInstance().sendMessage(customMessage);
                    StatisticItem statisticItem2 = new StatisticItem("c12892");
                    TiebaStaticHelper.addYYParam(statisticItem2);
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49639e;

        public p(SpecialLiveFragment specialLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49639e = specialLiveFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f49639e.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<SpecialLiveTabInfo> f49640a;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<SpecialForumTabBaseFragment> f49641b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f49642c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(SpecialLiveFragment specialLiveFragment, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialLiveFragment, fragmentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49642c = specialLiveFragment;
            this.f49640a = new ArrayList();
            SparseArray<SpecialForumTabBaseFragment> sparseArray = new SparseArray<>();
            this.f49641b = sparseArray;
            sparseArray.put(0, ConcernTabFragment.newInstance(0, specialLiveFragment.K, specialLiveFragment.L));
        }

        public SpecialForumTabBaseFragment a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f49641b.get(i2) : (SpecialForumTabBaseFragment) invokeI.objValue;
        }

        public void b(int i2, TabData tabData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, tabData) == null) || this.f49641b.get(i2) == null) {
                return;
            }
            this.f49641b.get(i2).setPrimary(true);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49640a.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                SpecialForumTabBaseFragment a2 = a(i2);
                if (a2 == null) {
                    if (i2 == 0) {
                        a2 = ConcernTabFragment.newInstance(0, this.f49642c.K, this.f49642c.L);
                    } else if (i2 == 1) {
                        a2 = RecommendTabFragment.newInstance(1, this.f49642c.K, this.f49642c.L);
                    } else {
                        a2 = OtherSubTabFragment.newInstance(i2, this.f49640a.get(i2), this.f49642c.K, this.f49642c.L);
                    }
                    this.f49641b.put(i2, a2);
                }
                return a2;
            }
            return (Fragment) invokeI.objValue;
        }

        public void onChangeSkinType(int i2) {
            SparseArray<SpecialForumTabBaseFragment> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (sparseArray = this.f49641b) == null || sparseArray.size() <= 0) {
                return;
            }
            int size = this.f49641b.size();
            for (int i3 = 0; i3 < size; i3++) {
                SpecialForumTabBaseFragment specialForumTabBaseFragment = this.f49641b.get(i3);
                if (specialForumTabBaseFragment != null) {
                    specialForumTabBaseFragment.onChangeSkinType(i2);
                }
            }
        }

        public void setData(List<SpecialLiveTabInfo> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f49640a.clear();
            this.f49640a.addAll(list);
            notifyDataSetChanged();
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
        Y = new HashMap<>();
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
        this.N = true;
        this.O = 1;
        this.P = false;
        this.Q = new Handler();
        this.R = new h(this);
        this.S = new i(this, 2921414);
        this.T = new j(this, 2001446);
        this.U = new k(this, 2005016);
        this.V = new l(this, 2001266);
        this.W = new m(this, 2001222);
        this.X = new n(this, AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON);
    }

    public static void addRefreshNewCountYYTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, null, i2) == null) {
            if (Y.containsKey(Integer.valueOf(i2))) {
                Y.put(Integer.valueOf(i2), Integer.valueOf(Y.get(Integer.valueOf(i2)).intValue() + 1));
            } else {
                Y.put(Integer.valueOf(i2), 2);
            }
        }
    }

    public static int getRefreshNewCountYYTab(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) {
            if (Y.containsKey(Integer.valueOf(i2))) {
                return Y.get(Integer.valueOf(i2)).intValue();
            }
            Y.put(Integer.valueOf(i2), 1);
            return 1;
        }
        return invokeI.intValue;
    }

    public static SpecialLiveFragment newInstance(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, str, str2)) == null) {
            SpecialLiveFragment specialLiveFragment = new SpecialLiveFragment();
            Bundle bundle = new Bundle();
            bundle.putString("forum_id", str);
            bundle.putString("forum_name", str2);
            specialLiveFragment.setArguments(bundle);
            return specialLiveFragment;
        }
        return (SpecialLiveFragment) invokeLL.objValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int dimensionPixelSize = this.f49619f.getResources().getDimensionPixelSize(R.dimen.ds88);
            if (UtilHelper.canUseStyleImmersiveSticky() && this.f49623j.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.f49623j.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.f49623j.setLayoutParams(layoutParams);
                this.f49623j.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
                layoutParams2.height = layoutParams.height;
                this.t.setLayoutParams(layoutParams2);
                dimensionPixelSize += layoutParams.height;
            } else {
                this.f49623j.setVisibility(8);
            }
            CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.r.getLayoutParams();
            ((FrameLayout.LayoutParams) layoutParams3).height = dimensionPixelSize;
            this.r.setLayoutParams(layoutParams3);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.C.clear();
            this.D.clear();
            this.C.add(W());
            this.C.add(Y());
            this.D.add(X());
            this.D.add(Z());
            if (ListUtils.isEmpty(this.B.f25826b)) {
                return;
            }
            for (int i2 = 0; i2 < this.B.f25826b.size() && i2 < 10; i2++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.B.f25826b.get(i2);
                if (specialLiveTabInfo != null && specialLiveTabInfo.tabId != 1108) {
                    this.D.add(specialLiveTabInfo);
                    TabData tabData = new TabData();
                    tabData.tabId = specialLiveTabInfo.tabId;
                    tabData.tabName = specialLiveTabInfo.tabName;
                    tabData.tabType = specialLiveTabInfo.tabType;
                    this.C.add(tabData);
                }
            }
        }
    }

    public final void R(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            hideLoadingView(this.f49620g);
            this.f49621h.setVisibility(8);
            if (TextUtils.isEmpty(str)) {
                showNetRefreshView(this.f49620g, this.f49619f.getResources().getString(R.string.square_load_data_failed_tip), true);
            } else {
                showNetRefreshView(this.f49620g, str, true);
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.B.f25827c) {
                if (e0()) {
                    this.O = 3;
                } else {
                    this.O = 2;
                }
            } else {
                this.O = 1;
            }
            j0(false);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean c2 = this.z.c(this.B.f25825a);
            if (c2) {
                this.z.k();
                this.z.g();
            }
            this.z.b(this.B.f25825a, c2);
            if (c2) {
                this.z.a(this.l);
            }
            this.z.j();
        }
    }

    public final void U(c.a.r0.v.f.g.c.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            this.f49621h.setVisibility(0);
            this.B = hVar;
            T();
            S();
            if (this.P) {
                return;
            }
            V();
            CustomViewPager customViewPager = this.x;
            if (customViewPager != null && customViewPager.getChildCount() > 1) {
                this.x.setCurrentItem(1);
            }
            if (ListUtils.isEmpty(this.B.f25826b)) {
                return;
            }
            this.P = true;
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Q();
            this.w.setData(this.C);
            this.y.setData(this.D);
        }
    }

    public final TabData W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TabData tabData = new TabData();
            tabData.tabId = -901;
            tabData.tabName = this.f49619f.getResources().getString(R.string.special_concern_tab_title);
            return tabData;
        }
        return (TabData) invokeV.objValue;
    }

    public final SpecialLiveTabInfo X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
            specialLiveTabInfo.tabId = -901;
            specialLiveTabInfo.tabName = this.f49619f.getResources().getString(R.string.special_concern_tab_title);
            return specialLiveTabInfo;
        }
        return (SpecialLiveTabInfo) invokeV.objValue;
    }

    public final TabData Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            TabData tabData = new TabData();
            tabData.tabId = -903;
            tabData.tabName = this.f49619f.getResources().getString(R.string.special_recommend_tab_title);
            return tabData;
        }
        return (TabData) invokeV.objValue;
    }

    public final SpecialLiveTabInfo Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
            specialLiveTabInfo.tabId = -903;
            specialLiveTabInfo.tabName = this.f49619f.getResources().getString(R.string.special_recommend_tab_title);
            return specialLiveTabInfo;
        }
        return (SpecialLiveTabInfo) invokeV.objValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.E = likeModel;
            likeModel.setLoadDataCallBack(new g(this));
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.G = new AlaLiveUserNotifyController(getPageContext());
            this.H = new e(this);
            AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.H);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.F = new f(this, 2001425);
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            q qVar = new q(this, getChildFragmentManager());
            this.y = qVar;
            this.x.setAdapter(qVar);
        }
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.B.f25829e.f25830a : invokeV.booleanValue;
    }

    public final void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.A.d()) {
            return;
        }
        if (z) {
            showLoadingView(this.f49620g);
        }
        this.A.e();
    }

    public final void g0(int i2, float f2) {
        c.a.r0.v.f.g.f.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (eVar = this.z) == null || f2 == 0.0f) {
            return;
        }
        if (this.J <= i2) {
            if (this.N && f2 >= 0.3f) {
                eVar.d(true);
                this.z.h();
                this.N = false;
            }
        } else if (!this.N && f2 <= 0.3f) {
            eVar.d(false);
            this.z.i();
            this.N = true;
        }
        this.J = i2;
    }

    public final void h0() {
        c.a.r0.v.f.g.c.h hVar;
        AlaUserInfoData alaUserInfoData;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (hVar = this.B) == null || (alaUserInfoData = hVar.f25828d) == null || this.O == 1) {
            return;
        }
        int i2 = alaUserInfoData.level_id;
        if (TextUtils.isEmpty(alaUserInfoData.level_name)) {
            str = "";
        } else {
            str = " " + this.B.f25828d.level_name;
        }
        if (i2 < 0) {
            return;
        }
        this.q.setText("LV" + i2 + str);
    }

    public final void i0(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (imageView = this.v) == null) {
            return;
        }
        if (z) {
            int i2 = R.drawable.selector_topbar_return_black;
            SkinManager.setNavbarIconSrc(imageView, i2, i2, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        int i3 = R.drawable.selector_topbar_return_white;
        SkinManager.setNavbarIconSrc(imageView, i3, i3, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void j0(boolean z) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            SkinManager.setBackgroundResource(this.p, R.drawable.frs_attention_btn_bg_selector);
            int g2 = c.a.e.e.p.l.g(this.f49619f, R.dimen.ds10);
            String string = this.f49619f.getResources().getString(R.string.attention);
            int i2 = R.drawable.frs_attention_btn_bg_selector;
            int i3 = R.color.CAM_X0101;
            int i4 = this.O;
            if (i4 == 1) {
                drawable = SkinManager.getDrawable(R.drawable.icon_add_follow_blue_s);
                this.p.setClickable(true);
                if (!z) {
                    StatisticItem statisticItem = new StatisticItem("c12889");
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                }
            } else if (i4 == 2) {
                string = this.f49619f.getResources().getString(R.string.sign);
                drawable = SkinManager.getDrawable(R.drawable.icon_public_sign_blue_s);
                this.p.setClickable(true);
                if (!z) {
                    StatisticItem statisticItem2 = new StatisticItem("c12891");
                    TiebaStaticHelper.addYYParam(statisticItem2);
                    TiebaStatic.log(statisticItem2);
                }
            } else {
                if (i4 == 3) {
                    string = this.f49619f.getResources().getString(R.string.signed);
                    this.p.setClickable(false);
                    i2 = R.drawable.special_sign_btn_signed_bg;
                    i3 = R.color.CAM_X0109;
                }
                drawable = null;
            }
            SkinManager.setBackgroundResource(this.p, i2);
            SkinManager.setViewTextColor(this.p, i3);
            this.p.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.p.setCompoundDrawablePadding(g2);
            this.p.setText(string);
            h0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.r0.v.f.g.f.e eVar = this.z;
            if (eVar != null) {
                eVar.f(i2);
            }
            ScrollHorizontalTabView scrollHorizontalTabView = this.w;
            if (scrollHorizontalTabView != null) {
                SkinManager.setBackgroundResource(scrollHorizontalTabView, R.color.CAM_X0201);
                this.w.onChangeSkinType(i2);
            }
            q qVar = this.y;
            if (qVar != null) {
                qVar.onChangeSkinType(i2);
            }
            i0(false);
            SkinManager.setBackgroundColor(this.f49623j, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.p, R.drawable.frs_attention_btn_bg_selector);
            SkinManager.setBackgroundResource(this.k, R.color.CAM_X0204);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments == null) {
                return;
            }
            this.f49619f = getPageContext().getPageActivity();
            this.K = arguments.getString("forum_id");
            String string = arguments.getString("forum_name");
            String string2 = this.f49619f.getResources().getString(R.string.forum);
            if (!TextUtils.isEmpty(string)) {
                this.L = string;
                StringBuilder sb = new StringBuilder();
                sb.append(UtilHelper.getFixedBarText(string, 5, true, true) + string2);
                this.M = sb.toString();
            } else {
                this.L = this.f49619f.getResources().getString(R.string.ala_ufan_bar_title);
                this.M = this.L + string2;
            }
            a0();
            b0();
            c0();
            MessageManager.getInstance().registerListener(this.F);
            MessageManager.getInstance().registerListener(this.V);
            MessageManager.getInstance().registerListener(this.W);
            MessageManager.getInstance().registerListener(this.X);
            MessageManager.getInstance().registerListener(this.T);
            MessageManager.getInstance().registerListener(this.U);
            MessageManager.getInstance().registerListener(this.S);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048600, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
            this.f49620g = inflate;
            this.f49621h = (AppBarLayout) inflate.findViewById(R.id.special_app_bar_layout);
            this.f49622i = (CollapsingToolbarLayout) this.f49620g.findViewById(R.id.special_collapse_layout);
            this.f49623j = this.f49620g.findViewById(R.id.statusbar_view);
            this.l = (ObservedChangeFrameLayout) this.f49620g.findViewById(R.id.live_container);
            this.I = BdUniqueId.gen();
            this.m = (RelativeLayout) this.f49620g.findViewById(R.id.function_container);
            this.n = this.f49620g.findViewById(R.id.function_bottom_space);
            TextView textView = (TextView) this.f49620g.findViewById(R.id.function_title);
            this.o = textView;
            textView.setText(this.M);
            TextView textView2 = (TextView) this.f49620g.findViewById(R.id.function_btn);
            this.p = textView2;
            textView2.setOnClickListener(new o(this));
            this.q = (TextView) this.f49620g.findViewById(R.id.function_level_desc);
            this.r = (RelativeLayout) this.f49620g.findViewById(R.id.navigation_layout);
            this.t = this.f49620g.findViewById(R.id.navigation_top_space);
            this.s = this.f49620g.findViewById(R.id.navigation_bg);
            TextView textView3 = (TextView) this.f49620g.findViewById(R.id.navigation_title);
            this.u = textView3;
            textView3.setText(this.M);
            ImageView imageView = (ImageView) this.f49620g.findViewById(R.id.navigation_back_img);
            this.v = imageView;
            imageView.setOnClickListener(new p(this));
            this.w = (ScrollHorizontalTabView) this.f49620g.findViewById(R.id.scroll_tab_view);
            this.x = (CustomViewPager) this.f49620g.findViewById(R.id.special_view_pager);
            d0();
            this.w.setViewPager(this.x);
            this.w.setScrollTabPageListener(new a(this));
            this.f49621h.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b(this));
            this.k = this.f49620g.findViewById(R.id.square_main_top_divider_line);
            this.l.setOnSizeChangeListener(new c(this));
            P();
            this.C = new ArrayList();
            this.D = new ArrayList();
            this.z = new c.a.r0.v.f.g.f.e(getPageContext());
            this.A = new c.a.r0.v.f.g.d.a(getPageContext(), new d(this));
            j0(true);
            f0(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f49620g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            c.a.r0.v.f.g.f.e eVar = this.z;
            if (eVar != null) {
                eVar.g();
            }
            if (this.V != null) {
                MessageManager.getInstance().unRegisterListener(this.V);
            }
            if (this.F != null) {
                MessageManager.getInstance().unRegisterListener(this.F);
            }
            if (this.W != null) {
                MessageManager.getInstance().unRegisterListener(this.W);
            }
            if (this.X != null) {
                MessageManager.getInstance().unRegisterListener(this.X);
            }
            if (this.T != null) {
                MessageManager.getInstance().unRegisterListener(this.T);
            }
            if (this.U != null) {
                MessageManager.getInstance().unRegisterListener(this.U);
            }
            c.a.r0.v.f.g.d.a aVar = this.A;
            if (aVar != null) {
                aVar.f();
            }
            AlaLiveUserNotifyController alaLiveUserNotifyController = this.G;
            if (alaLiveUserNotifyController != null) {
                alaLiveUserNotifyController.onDestroy();
            }
            AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.H);
            hideLoadingView(this.f49620g);
            MessageManager.getInstance().unRegisterListener(this.S);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onNetRefreshButtonClicked();
            hideNetRefreshView(this.f49620g);
            f0(true);
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPause();
            c.a.r0.v.f.g.f.e eVar = this.z;
            if (eVar != null) {
                eVar.d(true);
                this.z.k();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                if (isPrimary()) {
                    f0(false);
                    AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
                }
                if (this.z != null) {
                    if (isPrimary()) {
                        this.z.d(false);
                        this.z.j();
                        return;
                    }
                    this.z.d(true);
                    this.z.h();
                }
            }
        }
    }
}
