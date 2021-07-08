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
import com.baidu.mobads.container.util.AdIconUtil;
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
import d.a.p0.h3.w;
import d.a.p0.v.d.f.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class SpecialLiveFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Y = 1;
    public static HashMap<Integer, Integer> Z;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.p0.v.d.f.d.a A;
    public d.a.p0.v.d.f.c.h B;
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
    public float f14068e;

    /* renamed from: f  reason: collision with root package name */
    public Context f14069f;

    /* renamed from: g  reason: collision with root package name */
    public View f14070g;

    /* renamed from: h  reason: collision with root package name */
    public AppBarLayout f14071h;

    /* renamed from: i  reason: collision with root package name */
    public CollapsingToolbarLayout f14072i;
    public View j;
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
    public d.a.p0.v.d.f.f.e z;

    /* loaded from: classes4.dex */
    public class a implements ScrollHorizontalTabView.ScrollTabPageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14073a;

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
            this.f14073a = specialLiveFragment;
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
                    if (this.f14073a.y != null) {
                        this.f14073a.y.e(i2, tabData);
                        return;
                    }
                    return;
                }
                ViewHelper.skipToLoginActivity(this.f14073a.getPageContext().getPageActivity());
                if (this.f14073a.x != null) {
                    this.f14073a.x.setCurrentItem(1);
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

    /* loaded from: classes4.dex */
    public class b implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14074a;

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
            this.f14074a = specialLiveFragment;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                int abs = Math.abs(i2);
                if (abs == 0) {
                    this.f14074a.s.setVisibility(8);
                    this.f14074a.u.setVisibility(8);
                } else {
                    this.f14074a.s.setVisibility(0);
                    this.f14074a.u.setVisibility(0);
                }
                SpecialLiveFragment specialLiveFragment = this.f14074a;
                float f2 = abs;
                specialLiveFragment.L1(f2 > specialLiveFragment.f14068e / 2.0f);
                float abs2 = Math.abs(f2 / this.f14074a.f14068e);
                this.f14074a.s.setAlpha(abs2);
                this.f14074a.u.setAlpha(abs2);
                this.f14074a.J1(abs, abs2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.o0.b1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14075a;

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
            this.f14075a = specialLiveFragment;
        }

        @Override // d.a.o0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                SpecialLiveFragment specialLiveFragment = this.f14075a;
                specialLiveFragment.f14068e = (specialLiveFragment.l.getMeasuredHeight() + this.f14075a.m.getMeasuredHeight()) - this.f14075a.r.getMeasuredHeight();
                this.f14075a.f14072i.setMinimumHeight(this.f14075a.r.getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14076a;

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
            this.f14076a = specialLiveFragment;
        }

        @Override // d.a.p0.v.d.f.d.a.b
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                this.f14076a.s1(i2, str);
            }
        }

        @Override // d.a.p0.v.d.f.d.a.b
        public void b(d.a.p0.v.d.f.c.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
                SpecialLiveFragment specialLiveFragment = this.f14076a;
                specialLiveFragment.hideLoadingView(specialLiveFragment.f14070g);
                this.f14076a.v1(hVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements AlaLiveUserNotifyManager.AlaLiveNotifyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14077a;

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
            this.f14077a = specialLiveFragment;
        }

        @Override // com.baidu.ala.notify.AlaLiveUserNotifyManager.AlaLiveNotifyListener
        public void onCallBack() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f14077a.isPrimary()) {
                this.f14077a.G.showNextNotifyDialog(0, AlaLiveUserNotifyManager.getInstance().getNotifyDataList());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14078a;

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
            this.f14078a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            SignData signData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f14078a.p.setClickable(true);
                if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage().getTag() != this.f14078a.I) {
                    return;
                }
                SignMessage signMessage = (SignMessage) customResponsedMessage;
                SignData signData2 = null;
                if (AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString) && signMessage.signData != null) {
                    AntiHelper.t(this.f14078a.f14069f, signMessage.signData.blockPopInfoData, null);
                    return;
                }
                if (signMessage == null || (signData = signMessage.signData) == null) {
                    z = false;
                } else {
                    String str = signData.forumId;
                    if (str == null || !str.equals(this.f14078a.K)) {
                        return;
                    }
                    signData2 = signData;
                    z = true;
                }
                if (z) {
                    TbadkCoreApplication.getInst().addSignedForum(this.f14078a.L, signData2.sign_bonus_point, -1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData2));
                    if (AntiHelper.m(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        AntiHelper.u(this.f14078a.f14069f, signMessage.mSignErrorString);
                        return;
                    } else {
                        d.a.c.e.p.l.M(this.f14078a.f14069f, this.f14078a.f14069f.getString(R.string.special_sign_success_tip, Integer.valueOf(signData2.sign_bonus_point)));
                        return;
                    }
                }
                if (signMessage.mSignErrorCode == 160002) {
                    this.f14078a.O = 3;
                    this.f14078a.M1(false);
                }
                d.a.c.e.p.l.M(this.f14078a.f14069f, signMessage.mSignErrorString);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14079a;

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
            this.f14079a = specialLiveFragment;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f14079a.p.setClickable(true);
                if (this.f14079a.E.getErrorCode() == 22) {
                    d.a.c.e.p.l.L(this.f14079a.f14069f, R.string.had_liked_forum);
                } else if (AntiHelper.m(this.f14079a.E.getErrorCode(), this.f14079a.E.getErrorString())) {
                    AntiHelper.u(this.f14079a.f14069f, this.f14079a.E.getErrorString());
                } else if (this.f14079a.E.getErrorCode() != 0) {
                    d.a.c.e.p.l.M(this.f14079a.f14069f, this.f14079a.E.getErrorString());
                } else {
                    w wVar = (w) obj;
                    if (wVar != null) {
                        TbadkCoreApplication.getInst().addLikeForum(this.f14079a.L);
                        wVar.v(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                        d.a.c.e.p.l.L(this.f14079a.f14069f, R.string.attention_success);
                        return;
                    }
                    d.a.c.e.p.l.L(this.f14079a.f14069f, R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14080e;

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
            this.f14080e = specialLiveFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14080e.z == null) {
                return;
            }
            this.f14080e.z.e();
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14081a;

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
            this.f14081a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f14081a.Q.removeCallbacks(this.f14081a.R);
                this.f14081a.Q.postDelayed(this.f14081a.R, 500L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14082a;

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
            this.f14082a = specialLiveFragment;
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
                this.f14082a.H1(false);
            }
            SpecialForumTabBaseFragment b2 = this.f14082a.y.b(this.f14082a.x.getCurrentItem());
            if (b2 != null) {
                b2.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14083a;

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
            this.f14083a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f14083a.A == null || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            this.f14083a.H1(false);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14084a;

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
            this.f14084a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            w wVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && (wVar = (w) customResponsedMessage.getData()) != null && this.f14084a.K.equals(wVar.g())) {
                if (wVar.l() == 1) {
                    if (this.f14084a.G1()) {
                        this.f14084a.O = 3;
                    } else {
                        this.f14084a.O = 2;
                    }
                } else {
                    this.f14084a.O = 1;
                }
                this.f14084a.M1(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14085a;

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
            this.f14085a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SignData signData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (signData = (SignData) customResponsedMessage.getData()) != null && this.f14085a.K.equals(signData.forumId) && signData.is_signed == 1) {
                this.f14085a.O = 3;
                this.f14085a.M1(false);
                d.a.c.e.p.l.M(this.f14085a.getPageContext().getPageActivity(), this.f14085a.f14069f.getString(R.string.special_sign_success_tip, Integer.valueOf(signData.sign_bonus_point)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14086a;

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
            this.f14086a = specialLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (ListUtils.isEmpty(this.f14086a.C)) {
                    return;
                }
                ((TabData) this.f14086a.C.get(0)).extra = bool;
                this.f14086a.w.setData(this.f14086a.C);
                if (bool.booleanValue()) {
                    TiebaStatic.log("c12898");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14087e;

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
            this.f14087e = specialLiveFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!d.a.c.e.p.j.z()) {
                    this.f14087e.showToast(R.string.neterror);
                    return;
                }
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(this.f14087e.f14069f);
                }
                if (this.f14087e.O == 1) {
                    this.f14087e.p.setClickable(false);
                    this.f14087e.E.L(this.f14087e.L, this.f14087e.K);
                    StatisticItem statisticItem = new StatisticItem("c12890");
                    TiebaStaticHelper.addYYParam(statisticItem);
                    TiebaStatic.log(statisticItem);
                } else if (this.f14087e.O == 2) {
                    this.f14087e.p.setClickable(false);
                    ForumData forumData = new ForumData();
                    forumData.setId(this.f14087e.K);
                    forumData.setName(this.f14087e.L);
                    CustomMessage customMessage = new CustomMessage(2001425, forumData);
                    customMessage.setTag(this.f14087e.I);
                    MessageManager.getInstance().sendMessage(customMessage);
                    StatisticItem statisticItem2 = new StatisticItem("c12892");
                    TiebaStaticHelper.addYYParam(statisticItem2);
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14088e;

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
            this.f14088e = specialLiveFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f14088e.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<SpecialLiveTabInfo> f14089a;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<SpecialForumTabBaseFragment> f14090b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpecialLiveFragment f14091c;

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
            this.f14091c = specialLiveFragment;
            this.f14089a = new ArrayList();
            SparseArray<SpecialForumTabBaseFragment> sparseArray = new SparseArray<>();
            this.f14090b = sparseArray;
            sparseArray.put(0, ConcernTabFragment.a1(0));
        }

        public SpecialForumTabBaseFragment b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f14090b.get(i2) : (SpecialForumTabBaseFragment) invokeI.objValue;
        }

        public void c(int i2) {
            SparseArray<SpecialForumTabBaseFragment> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (sparseArray = this.f14090b) == null || sparseArray.size() <= 0) {
                return;
            }
            int size = this.f14090b.size();
            for (int i3 = 0; i3 < size; i3++) {
                SpecialForumTabBaseFragment specialForumTabBaseFragment = this.f14090b.get(i3);
                if (specialForumTabBaseFragment != null) {
                    specialForumTabBaseFragment.onChangeSkinType(i2);
                }
            }
        }

        public void d(List<SpecialLiveTabInfo> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.f14089a.clear();
            this.f14089a.addAll(list);
            notifyDataSetChanged();
        }

        public void e(int i2, TabData tabData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, tabData) == null) || this.f14090b.get(i2) == null) {
                return;
            }
            this.f14090b.get(i2).setPrimary(true);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14089a.size() : invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                SpecialForumTabBaseFragment b2 = b(i2);
                if (b2 == null) {
                    if (i2 == 0) {
                        b2 = ConcernTabFragment.a1(0);
                    } else if (i2 == 1) {
                        b2 = RecommendTabFragment.Z0(1);
                    } else {
                        b2 = OtherSubTabFragment.b1(i2, this.f14089a.get(i2));
                    }
                    this.f14090b.put(i2, b2);
                }
                return b2;
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
        Z = new HashMap<>();
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

    public static int B1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (Z.containsKey(Integer.valueOf(i2))) {
                return Z.get(Integer.valueOf(i2)).intValue();
            }
            Z.put(Integer.valueOf(i2), 1);
            return 1;
        }
        return invokeI.intValue;
    }

    public static SpecialLiveFragment I1(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            SpecialLiveFragment specialLiveFragment = new SpecialLiveFragment();
            Bundle bundle = new Bundle();
            bundle.putString("forum_id", str);
            bundle.putString("forum_name", str2);
            specialLiveFragment.setArguments(bundle);
            return specialLiveFragment;
        }
        return (SpecialLiveFragment) invokeLL.objValue;
    }

    public static void p1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65574, null, i2) == null) {
            if (Z.containsKey(Integer.valueOf(i2))) {
                Z.put(Integer.valueOf(i2), Integer.valueOf(Z.get(Integer.valueOf(i2)).intValue() + 1));
            } else {
                Z.put(Integer.valueOf(i2), 2);
            }
        }
    }

    public final SpecialLiveTabInfo A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
            specialLiveTabInfo.tabId = -903;
            specialLiveTabInfo.tabName = this.f14069f.getResources().getString(R.string.special_recommend_tab_title);
            return specialLiveTabInfo;
        }
        return (SpecialLiveTabInfo) invokeV.objValue;
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.E = likeModel;
            likeModel.setLoadDataCallBack(new g(this));
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.G = new AlaLiveUserNotifyController(getPageContext());
            this.H = new e(this);
            AlaLiveUserNotifyManager.getInstance().addNotifyListener(this.H);
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.F = new f(this, 2001425);
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q qVar = new q(this, getChildFragmentManager());
            this.y = qVar;
            this.x.setAdapter(qVar);
        }
    }

    public final boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.B.f64535e.f64536a : invokeV.booleanValue;
    }

    public final void H1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || this.A.d()) {
            return;
        }
        if (z) {
            showLoadingView(this.f14070g);
        }
        this.A.e();
    }

    public final void J1(int i2, float f2) {
        d.a.p0.v.d.f.f.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || (eVar = this.z) == null || f2 == 0.0f) {
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

    public final void K1() {
        d.a.p0.v.d.f.c.h hVar;
        AlaUserInfoData alaUserInfoData;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.B) == null || (alaUserInfoData = hVar.f64534d) == null || this.O == 1) {
            return;
        }
        int i2 = alaUserInfoData.level_id;
        if (TextUtils.isEmpty(alaUserInfoData.level_name)) {
            str = "";
        } else {
            str = " " + this.B.f64534d.level_name;
        }
        if (i2 < 0) {
            return;
        }
        this.q.setText("LV" + i2 + str);
    }

    public final void L1(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (imageView = this.v) == null) {
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

    public final void M1(boolean z) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            SkinManager.setBackgroundResource(this.p, R.drawable.frs_attention_btn_bg_selector);
            int g2 = d.a.c.e.p.l.g(this.f14069f, R.dimen.ds10);
            String string = this.f14069f.getResources().getString(R.string.attention);
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
                string = this.f14069f.getResources().getString(R.string.sign);
                drawable = SkinManager.getDrawable(R.drawable.icon_public_sign_blue_s);
                this.p.setClickable(true);
                if (!z) {
                    StatisticItem statisticItem2 = new StatisticItem("c12891");
                    TiebaStaticHelper.addYYParam(statisticItem2);
                    TiebaStatic.log(statisticItem2);
                }
            } else {
                if (i4 == 3) {
                    string = this.f14069f.getResources().getString(R.string.signed);
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
            K1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.p0.v.d.f.f.e eVar = this.z;
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
                qVar.c(i2);
            }
            L1(false);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
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
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments == null) {
                return;
            }
            this.f14069f = getPageContext().getPageActivity();
            this.K = arguments.getString("forum_id");
            String string = arguments.getString("forum_name");
            String string2 = this.f14069f.getResources().getString(R.string.forum);
            if (!TextUtils.isEmpty(string)) {
                this.L = string;
                StringBuilder sb = new StringBuilder();
                sb.append(UtilHelper.getFixedBarText(string, 5, true, true) + string2);
                this.M = sb.toString();
            } else {
                this.L = this.f14069f.getResources().getString(R.string.ala_ufan_bar_title);
                this.M = this.L + string2;
            }
            C1();
            D1();
            E1();
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.special_live_layout, (ViewGroup) null);
            this.f14070g = inflate;
            this.f14071h = (AppBarLayout) inflate.findViewById(R.id.special_app_bar_layout);
            this.f14072i = (CollapsingToolbarLayout) this.f14070g.findViewById(R.id.special_collapse_layout);
            this.j = this.f14070g.findViewById(R.id.statusbar_view);
            this.l = (ObservedChangeFrameLayout) this.f14070g.findViewById(R.id.live_container);
            this.I = BdUniqueId.gen();
            this.m = (RelativeLayout) this.f14070g.findViewById(R.id.function_container);
            this.n = this.f14070g.findViewById(R.id.function_bottom_space);
            TextView textView = (TextView) this.f14070g.findViewById(R.id.function_title);
            this.o = textView;
            textView.setText(this.M);
            TextView textView2 = (TextView) this.f14070g.findViewById(R.id.function_btn);
            this.p = textView2;
            textView2.setOnClickListener(new o(this));
            this.q = (TextView) this.f14070g.findViewById(R.id.function_level_desc);
            this.r = (RelativeLayout) this.f14070g.findViewById(R.id.navigation_layout);
            this.t = this.f14070g.findViewById(R.id.navigation_top_space);
            this.s = this.f14070g.findViewById(R.id.navigation_bg);
            TextView textView3 = (TextView) this.f14070g.findViewById(R.id.navigation_title);
            this.u = textView3;
            textView3.setText(this.M);
            ImageView imageView = (ImageView) this.f14070g.findViewById(R.id.navigation_back_img);
            this.v = imageView;
            imageView.setOnClickListener(new p(this));
            this.w = (ScrollHorizontalTabView) this.f14070g.findViewById(R.id.scroll_tab_view);
            this.x = (CustomViewPager) this.f14070g.findViewById(R.id.special_view_pager);
            F1();
            this.w.setViewPager(this.x);
            this.w.setScrollTabPageListener(new a(this));
            this.f14071h.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b(this));
            this.k = this.f14070g.findViewById(R.id.square_main_top_divider_line);
            this.l.setOnSizeChangeListener(new c(this));
            q1();
            this.C = new ArrayList();
            this.D = new ArrayList();
            this.z = new d.a.p0.v.d.f.f.e(getPageContext());
            this.A = new d.a.p0.v.d.f.d.a(getPageContext(), new d(this));
            M1(true);
            H1(true);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f14070g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            d.a.p0.v.d.f.f.e eVar = this.z;
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
            d.a.p0.v.d.f.d.a aVar = this.A;
            if (aVar != null) {
                aVar.f();
            }
            AlaLiveUserNotifyController alaLiveUserNotifyController = this.G;
            if (alaLiveUserNotifyController != null) {
                alaLiveUserNotifyController.onDestroy();
            }
            AlaLiveUserNotifyManager.getInstance().removeNotifyListener(this.H);
            hideLoadingView(this.f14070g);
            MessageManager.getInstance().unRegisterListener(this.S);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onNetRefreshButtonClicked();
            hideNetRefreshView(this.f14070g);
            H1(true);
            AlaLiveUserNotifyManager.getInstance().sendGetUserNotifyRequest();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            d.a.p0.v.d.f.f.e eVar = this.z;
            if (eVar != null) {
                eVar.d(true);
                this.z.k();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
            if (isAdded()) {
                if (isPrimary()) {
                    H1(false);
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

    public final void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int dimensionPixelSize = this.f14069f.getResources().getDimensionPixelSize(R.dimen.ds88);
            if (UtilHelper.canUseStyleImmersiveSticky() && this.j.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.j.setLayoutParams(layoutParams);
                this.j.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
                layoutParams2.height = layoutParams.height;
                this.t.setLayoutParams(layoutParams2);
                dimensionPixelSize += layoutParams.height;
            } else {
                this.j.setVisibility(8);
            }
            CollapsingToolbarLayout.LayoutParams layoutParams3 = (CollapsingToolbarLayout.LayoutParams) this.r.getLayoutParams();
            ((FrameLayout.LayoutParams) layoutParams3).height = dimensionPixelSize;
            this.r.setLayoutParams(layoutParams3);
        }
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.C.clear();
            this.D.clear();
            this.C.add(x1());
            this.C.add(z1());
            this.D.add(y1());
            this.D.add(A1());
            if (ListUtils.isEmpty(this.B.f64532b)) {
                return;
            }
            for (int i2 = 0; i2 < this.B.f64532b.size() && i2 < 10; i2++) {
                SpecialLiveTabInfo specialLiveTabInfo = this.B.f64532b.get(i2);
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

    public final void s1(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i2, str) == null) {
            hideLoadingView(this.f14070g);
            this.f14071h.setVisibility(8);
            if (TextUtils.isEmpty(str)) {
                showNetRefreshView(this.f14070g, this.f14069f.getResources().getString(R.string.square_load_data_failed_tip), true);
            } else {
                showNetRefreshView(this.f14070g, str, true);
            }
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.B.f64533c) {
                if (G1()) {
                    this.O = 3;
                } else {
                    this.O = 2;
                }
            } else {
                this.O = 1;
            }
            M1(false);
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            boolean c2 = this.z.c(this.B.f64531a);
            if (c2) {
                this.z.k();
                this.z.g();
            }
            this.z.b(this.B.f64531a, c2);
            if (c2) {
                this.z.a(this.l);
            }
            this.z.j();
        }
    }

    public final void v1(d.a.p0.v.d.f.c.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, hVar) == null) {
            this.f14071h.setVisibility(0);
            this.B = hVar;
            u1();
            t1();
            if (this.P) {
                return;
            }
            w1();
            CustomViewPager customViewPager = this.x;
            if (customViewPager != null && customViewPager.getChildCount() > 1) {
                this.x.setCurrentItem(1);
            }
            if (ListUtils.isEmpty(this.B.f64532b)) {
                return;
            }
            this.P = true;
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            r1();
            this.w.setData(this.C);
            this.y.d(this.D);
        }
    }

    public final TabData x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            TabData tabData = new TabData();
            tabData.tabId = -901;
            tabData.tabName = this.f14069f.getResources().getString(R.string.special_concern_tab_title);
            return tabData;
        }
        return (TabData) invokeV.objValue;
    }

    public final SpecialLiveTabInfo y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SpecialLiveTabInfo specialLiveTabInfo = new SpecialLiveTabInfo();
            specialLiveTabInfo.tabId = -901;
            specialLiveTabInfo.tabName = this.f14069f.getResources().getString(R.string.special_concern_tab_title);
            return specialLiveTabInfo;
        }
        return (SpecialLiveTabInfo) invokeV.objValue;
    }

    public final TabData z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            TabData tabData = new TabData();
            tabData.tabId = -903;
            tabData.tabName = this.f14069f.getResources().getString(R.string.special_recommend_tab_title);
            return tabData;
        }
        return (TabData) invokeV.objValue;
    }
}
