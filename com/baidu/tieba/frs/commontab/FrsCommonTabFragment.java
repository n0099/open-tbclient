package com.baidu.tieba.frs.commontab;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.l.v0.a;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.x0.c1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import b.a.r0.x0.p0;
import b.a.r0.x0.r0;
import b.a.r0.x0.x2.k;
import b.a.r0.z2.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.j, p0, r0, u {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CAN_AUTO_PLAY_VIDEO = "can_auto_play_video";
    public static final String FORUM_ID = "forum_id";
    public static final String FROM = "from";
    public static final String IS_BRAND_FORUM = "is_brand_forum";
    public static final String IS_GENERAL_TAB = "is_general_tab";
    public static final String NEED_LOG = "need_log";
    public static final String SORT_TYPE = "sort_type";
    public static final String TAB_CODE = "tab_code";
    public static final String TAB_ID = "tab_id";
    public static final String TAB_NAME = "tab_name";
    public static final String TAB_TYPE = "tab_type";
    public static final String THEME_COLOR = "theme_color";
    public static final String VIEW_DATA = "view_data";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canAutoPlay;

    /* renamed from: e  reason: collision with root package name */
    public int f48433e;

    /* renamed from: f  reason: collision with root package name */
    public VoiceManager f48434f;
    public String forumId;
    public String forumName;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48435g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.g0.c f48436h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCardViewHolder f48437i;
    public boolean isBrandForum;
    public int isGeneralTab;
    public int j;
    public int k;
    public long l;
    public int m;
    public String mFrom;
    public b.a.r0.x0.v1.b mMainView;
    public b.a.r0.x0.v1.c mModelController;
    public View mRootView;
    public int n;
    public boolean needLog;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public final CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public int tabId;
    public String tabName;
    public int tabType;
    public CustomMessageListener u;
    public CustomMessageListener v;
    public FrsViewData viewData;
    public final RecyclerView.OnScrollListener w;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f48438e;

        public a(FrsCommonTabFragment frsCommonTabFragment, b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48438e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.a.q0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f48438e) == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f48439a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FrsCommonTabFragment frsCommonTabFragment, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48439a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || this.f48439a.f48436h == null || !this.f48439a.f48436h.isViewAttached()) {
                return;
            }
            this.f48439a.adjustRefreshView(num.intValue());
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f48440a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FrsCommonTabFragment frsCommonTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2)};
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
            this.f48440a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int parseInt = Integer.parseInt(data.toString());
                FrsCommonTabFragment frsCommonTabFragment = this.f48440a;
                if (parseInt == frsCommonTabFragment.tabId) {
                    b.a.r0.x0.v1.b bVar = frsCommonTabFragment.mMainView;
                    if (bVar != null) {
                        bVar.z(0);
                    }
                    if (this.f48440a.f48436h != null && this.f48440a.f48436h.isViewAttached()) {
                        this.f48440a.onNetRefreshButtonClicked();
                        return;
                    }
                    b.a.r0.x0.v1.b bVar2 = this.f48440a.mMainView;
                    if (bVar2 != null) {
                        bVar2.x(true);
                    }
                    this.f48440a.onPullRefresh();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, Boolean.TRUE));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f48441a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FrsCommonTabFragment frsCommonTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2)};
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
            this.f48441a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.r0.x0.v1.b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || (bVar = this.f48441a.mMainView) == null) {
                    return;
                }
                bVar.m(str);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f48442a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FrsCommonTabFragment frsCommonTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2)};
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
            this.f48442a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.r0.x0.v1.b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bVar = this.f48442a.mMainView) != null) {
                    b.a.r0.q2.i i2 = bVar.i();
                    if (i2 != null && i2.j() != null && (i2.j().getTag() instanceof ThreadCardViewHolder)) {
                        this.f48442a.f48437i = (ThreadCardViewHolder) i2.j().getTag();
                    }
                    if (this.f48442a.f48437i == null || this.f48442a.f48437i.getCardView() == null) {
                        return;
                    }
                    this.f48442a.f48437i.getCardView().n(new a.C0090a(3));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f48443a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FrsCommonTabFragment frsCommonTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2)};
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
            this.f48443a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f48443a.mModelController == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f48443a.mModelController.m(str);
        }
    }

    /* loaded from: classes9.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f48444a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FrsCommonTabFragment frsCommonTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2)};
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
            this.f48444a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            FrsCommonTabFragment frsCommonTabFragment = this.f48444a;
            if (frsCommonTabFragment.tabType == 100 && frsCommonTabFragment.mModelController.d()) {
                this.f48444a.loadmore();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f48445a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FrsCommonTabFragment frsCommonTabFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2)};
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
            this.f48445a = frsCommonTabFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            this.f48445a.l = ((Long) customResponsedMessage.getData()).longValue();
            ArrayList<n> arrayList = this.f48445a.mModelController.f().f26445g;
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                n nVar = arrayList.get(i2);
                if ((nVar instanceof c2) && TextUtils.equals(((c2) nVar).w.s1(), String.valueOf(this.f48445a.l))) {
                    this.f48445a.m = i2;
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrsCommonTabFragment f48446a;

        public i(FrsCommonTabFragment frsCommonTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48446a = frsCommonTabFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0) {
                    b.a.r0.k3.c.g().h(this.f48446a.getUniqueId(), true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.f48446a.k += i3;
                if (this.f48446a.k < this.f48446a.j * 2 || i3 >= 0) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f48447e;

        public j(FrsCommonTabFragment frsCommonTabFragment, b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsCommonTabFragment, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48447e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.a.q0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f48447e) == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    public FrsCommonTabFragment() {
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
        this.f48433e = 3;
        this.f48435g = true;
        this.j = 0;
        this.k = 0;
        this.l = 0L;
        this.m = 0;
        this.n = 0;
        this.p = new b(this, 2921397, true);
        this.q = new c(this, 2001624);
        this.r = new d(this, 2921031);
        this.s = new e(this, 2921381);
        this.t = new f(this, 2016331);
        this.u = new g(this, 2921629);
        this.v = new h(this, 2921630);
        this.w = new i(this);
    }

    public void addThreadData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) || d2Var == null) {
            return;
        }
        this.mModelController.a(d2Var);
    }

    public void adjustRefreshView(int i2) {
        b.a.q0.g0.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (cVar = this.f48436h) != null && cVar.isViewAttached()) {
            this.f48436h.a(i2);
        }
    }

    @Override // b.a.r0.x0.p0
    public void changeToSpecialFrs(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
        }
    }

    public b.a.e.l.e.a createFrsExtraAdapter(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bdUniqueId)) == null) {
            return null;
        }
        return (b.a.e.l.e.a) invokeL.objValue;
    }

    @Override // b.a.r0.x0.p0
    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            scrollToTop();
            b.a.r0.x0.v1.b bVar = this.mMainView;
            if (bVar != null) {
                bVar.x(true);
            }
        }
    }

    public String getCurrentPageKeyForTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.tabId == 89 ? "a006" : "a006" : (String) invokeV.objValue;
    }

    @Override // b.a.r0.z2.u
    public String getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.forumId : (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mFrom : (String) invokeV.objValue;
    }

    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? f1.frs_common_tab_fragment : invokeV.intValue;
    }

    public b.a.r0.x0.v1.b getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mMainView : (b.a.r0.x0.v1.b) invokeV.objValue;
    }

    public b.a.r0.x0.v1.c getModelController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mModelController : (b.a.r0.x0.v1.c) invokeV.objValue;
    }

    @Override // b.a.r0.z2.u
    public int getPageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mModelController.e() : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n : invokeV.intValue;
    }

    @Override // b.a.r0.z2.u
    public TbPageContext<?> getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getPageContext() : (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public b.a.q0.m0.c getTbPageExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            return new b.a.q0.m0.c(getUniqueId(), getCurrentPageKeyForTabId(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
        }
        return (b.a.q0.m0.c) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TbPageTag tbPageTag = super.getTbPageTag();
            tbPageTag.sortType = k.g(getSortType());
            tbPageTag.locatePage = "a006";
            tbPageTag.tabId = this.tabId;
            tbPageTag.tabType = this.tabType;
            tbPageTag.isGeneralTab = this.isGeneralTab;
            return tbPageTag;
        }
        return (TbPageTag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f48434f == null) {
                this.f48434f = VoiceManager.instance();
            }
            return this.f48434f;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            b.a.r0.x0.v1.b bVar = this.mMainView;
            if (bVar != null) {
                bVar.v(true);
            }
            b.a.q0.g0.c cVar = this.f48436h;
            if (cVar != null) {
                cVar.dettachView(view);
            }
        }
    }

    public final void j() {
        b.a.r0.x0.v1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || ListUtils.isEmpty(b.a.r0.x0.a.h().i()) || (bVar = this.mMainView) == null || bVar.j() == null || this.mMainView.j().getData() == null) {
            return;
        }
        ArrayList<n> arrayList = this.mModelController.f().f26445g;
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        Iterator<n> it = arrayList.iterator();
        List<n> data = this.mMainView.j().getData();
        int count = ListUtils.getCount(b.a.r0.x0.a.h().i());
        int i2 = 0;
        while (it.hasNext()) {
            n next = it.next();
            d2 d2Var = null;
            if (next instanceof c2) {
                d2Var = ((c2) next).w;
            } else if (next instanceof d2) {
                d2Var = (d2) next;
            }
            if (d2Var != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= count) {
                        break;
                    } else if (StringHelper.equals(b.a.r0.x0.a.h().i().get(i3).f0(), d2Var.f0())) {
                        it.remove();
                        data.remove(next);
                        this.mMainView.j().getAdapter().notifyItemRemoved(i2);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            i2++;
        }
    }

    public final void k(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.forumId);
            if (i2 == 89) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 502) {
                statisticItem.param("obj_type", 8);
            } else if (i2 == 504) {
                statisticItem.param("obj_type", 11);
            } else if (this.tabType == 3) {
                statisticItem.param("obj_type", 13);
            } else if (this.isGeneralTab == 1) {
                statisticItem.param("obj_type", 12);
            }
            statisticItem.param("obj_locate", i3);
            statisticItem.eventStat();
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            String string = getPageContext().getResources().getString(h1.is_district_forum);
            FrsViewData frsViewData = this.viewData;
            return (frsViewData == null || frsViewData.getForum() == null || StringUtils.isNull(this.viewData.getForum().getFirst_class()) || !this.viewData.getForum().getFirst_class().equals(string)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void loadmore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (l.D()) {
                VoiceManager voiceManager = this.f48434f;
                if (voiceManager != null) {
                    voiceManager.stopPlay();
                }
                b.a.r0.x0.v1.c cVar = this.mModelController;
                if (cVar != null) {
                    cVar.l(this.n);
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getActivity());
            aVar.setContentViewSize(1);
            ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
            professionDialogLayout.setButtonClickListener(new j(this, aVar));
            professionDialogLayout.setCloseViewClickListener(new a(this, aVar));
            aVar.setContentView(professionDialogLayout);
            aVar.setCancelable(false);
            aVar.setCanceledOnTouchOutside(false);
            aVar.create(getPageContext()).show();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.tabId == 502) {
            StatisticItem statisticItem = new StatisticItem("c13376");
            statisticItem.param("fid", this.forumId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        b.a.r0.x0.v1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048601, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 18003) {
                String stringExtra = intent.getStringExtra("tid");
                int intExtra = intent.getIntExtra("type", -1);
                if (StringUtils.isNull(stringExtra) || intExtra != 0 || (bVar = this.mMainView) == null) {
                    return;
                }
                bVar.m(stringExtra);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            if (this.f48433e == 3 && this.mMainView == null) {
                return;
            }
            this.f48433e = i2;
            super.onChangeSkinType(i2);
            this.mMainView.l(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.tabId = bundle.getInt("tab_id");
                this.tabType = bundle.getInt("tab_type");
                this.mFrom = bundle.getString("from");
                this.forumId = bundle.getString("forum_id");
                this.forumName = bundle.getString("name");
                this.canAutoPlay = bundle.getBoolean(CAN_AUTO_PLAY_VIDEO);
                this.needLog = bundle.getBoolean(NEED_LOG);
                this.isBrandForum = bundle.getBoolean(IS_BRAND_FORUM);
                this.tabName = bundle.getString("tab_name");
                this.isGeneralTab = bundle.getInt(IS_GENERAL_TAB);
                this.viewData = (FrsViewData) bundle.getSerializable(VIEW_DATA);
                this.o = bundle.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
                if (this.isGeneralTab != 1) {
                    this.n = bundle.getInt("sort_type", 0);
                }
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.tabId = arguments.getInt("tab_id");
                    this.tabType = arguments.getInt("tab_type");
                    this.mFrom = arguments.getString("from");
                    this.forumId = arguments.getString("forum_id");
                    this.forumName = arguments.getString("name");
                    this.canAutoPlay = arguments.getBoolean(CAN_AUTO_PLAY_VIDEO);
                    this.needLog = arguments.getBoolean(NEED_LOG);
                    this.isBrandForum = arguments.getBoolean(IS_BRAND_FORUM);
                    this.tabName = arguments.getString("tab_name");
                    this.isGeneralTab = arguments.getInt(IS_GENERAL_TAB);
                    this.viewData = (FrsViewData) arguments.getSerializable(VIEW_DATA);
                    this.o = arguments.getBoolean(FrsActivityConfig.FLAG_SHOW_AD);
                }
            }
            VoiceManager voiceManager = getVoiceManager();
            this.f48434f = voiceManager;
            voiceManager.onCreate(getPageContext());
            b.a.r0.k3.c.g().i(getUniqueId());
            b.a.r0.x0.v1.c cVar = new b.a.r0.x0.v1.c(this, b.a.e.e.m.b.e(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
            this.mModelController = cVar;
            cVar.s(this.tabType);
            this.mModelController.q(b.a.r0.z0.a.a(this.o));
            registerListener(this.q);
            registerListener(this.r);
            registerListener(this.s);
            registerListener(this.t);
            registerListener(this.p);
            registerListener(this.u);
            registerListener(this.v);
            this.j = UtilHelper.getScreenHeight(getActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
            this.mRootView = inflate;
            b.a.r0.x0.v1.b bVar = new b.a.r0.x0.v1.b(this, inflate, this.viewData);
            this.mMainView = bVar;
            bVar.y(this.w);
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            b.a.r0.k3.c.g().k(getUniqueId());
            b.a.r0.b0.u.b().e(false);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.t);
            super.onDestroy();
            b.a.r0.x0.v1.b bVar = this.mMainView;
            if (bVar != null) {
                bVar.n();
            }
            VoiceManager voiceManager = this.f48434f;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onLazyLoad();
            if (b.a.e.e.p.j.z()) {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(c1.ds250));
                pullRefresh();
                return;
            }
            showNetRefreshView(this.mRootView, null, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            k(this.tabId, 2);
        }
    }

    @Override // b.a.r0.x0.r0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && b.a.e.e.p.j.z()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(c1.ds250));
            pullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onPause();
            b.a.r0.x0.v1.b bVar = this.mMainView;
            if (bVar != null) {
                bVar.p();
            }
            VoiceManager voiceManager = this.f48434f;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                b.a.r0.x0.v1.b bVar = this.mMainView;
                if (bVar != null) {
                    bVar.s();
                }
                if (this.f48435g) {
                    this.f48435g = false;
                    if (this.tabId == 502) {
                        if (b.a.q0.s.e0.b.j().g("first_into_tab_profession", true) && !l()) {
                            b.a.q0.s.e0.b.j().t("first_into_tab_profession", false);
                            m();
                        }
                        new b.a.r0.x0.q2.a.c(getPageContext()).f(this.forumId);
                        onLazyLoad();
                    }
                    int i2 = this.tabId;
                    if (i2 != 503 && i2 != 504) {
                        if (!this.isLazyLoaded) {
                            onLazyLoad();
                        }
                    } else {
                        onLazyLoad();
                    }
                }
                n();
            } else {
                b.a.r0.x0.v1.b bVar2 = this.mMainView;
                if (bVar2 != null) {
                    bVar2.p();
                }
            }
            b.a.r0.x0.v1.b bVar3 = this.mMainView;
            if (bVar3 != null && this.l != 0) {
                bVar3.t(this.m + 1);
            }
            this.l = 0L;
        }
    }

    @Override // b.a.r0.x0.r0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || getContext() == null) {
            return;
        }
        if (b.a.e.e.p.j.z()) {
            hideNetRefreshView(this.mRootView);
            if (this.mModelController.h()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(c1.ds250));
            }
            pullRefresh();
            return;
        }
        b.a.r0.x0.v1.b bVar = this.mMainView;
        if (bVar != null) {
            bVar.x(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onResume();
            VoiceManager voiceManager = this.f48434f;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.tabId);
            bundle.putString("forum_id", this.forumId);
            bundle.putString("name", this.forumName);
            bundle.putBoolean(CAN_AUTO_PLAY_VIDEO, this.canAutoPlay);
            bundle.putBoolean(NEED_LOG, this.needLog);
            bundle.putBoolean(IS_BRAND_FORUM, this.isBrandForum);
            bundle.putString("tab_name", this.tabName);
            bundle.putInt(IS_GENERAL_TAB, this.isGeneralTab);
            bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, this.o);
            if (this.isGeneralTab != 1) {
                bundle.putInt("sort_type", this.n);
            }
            VoiceManager voiceManager = this.f48434f;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, errorData) == null) {
            hideLoadingView(this.mRootView);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(h1.im_error_default);
                }
            }
            if (!this.mModelController.h()) {
                showNetRefreshView(this.mRootView, errorData != null ? getPageContext().getResources().getString(h1.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            b.a.r0.x0.v1.b bVar = this.mMainView;
            if (bVar != null) {
                bVar.x(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.f48434f;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onStop();
            b.a.r0.k3.c.g().h(getUniqueId(), false);
            VoiceManager voiceManager = this.f48434f;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    public void onViewDataChange(b.a.r0.x0.v1.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, dVar) == null) || dVar == null) {
            return;
        }
        hideLoadingView(this.mRootView);
        this.n = dVar.m;
        b.a.r0.x0.v1.b bVar = this.mMainView;
        if (bVar != null) {
            bVar.x(false);
            this.mMainView.r();
            this.mMainView.o(dVar);
        }
        if (this.mModelController.j() && this.tabId == 89) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, Boolean.FALSE));
        }
        b.a.r0.k3.c.g().h(getUniqueId(), false);
    }

    public void processBatchDelete() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            j();
            int i3 = 0;
            int i4 = -1;
            for (n nVar : this.mModelController.f().f26445g) {
                if ((nVar instanceof c2) && (i2 = ((c2) nVar).position) != i4) {
                    i3++;
                    i4 = i2;
                    continue;
                }
                if (i3 >= 6) {
                    break;
                }
            }
            if (i3 < 6) {
                loadmore();
            }
        }
    }

    public final void pullRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && l.D()) {
            VoiceManager voiceManager = this.f48434f;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            b.a.r0.x0.v1.c cVar = this.mModelController;
            if (cVar != null) {
                cVar.o(this.n);
            }
        }
    }

    public void refreshRecyclerView() {
        b.a.r0.x0.v1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (bVar = this.mMainView) == null) {
            return;
        }
        bVar.q();
    }

    @Override // b.a.r0.x0.p0
    public void scrollToTop() {
        b.a.r0.x0.v1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (bVar = this.mMainView) == null) {
            return;
        }
        bVar.u();
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.n = i2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048624, this, view, str, z) == null) {
            b.a.r0.x0.v1.b bVar = this.mMainView;
            if (bVar != null) {
                bVar.v(false);
            }
            if (getPageContext() == null || getPageContext().getContext() == null) {
                return;
            }
            if (this.f48436h == null) {
                this.f48436h = new b.a.q0.g0.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.f48436h.e(null);
            this.f48436h.d(str);
            this.f48436h.c(null);
            this.f48436h.attachView(view, z);
            this.f48436h.f();
            this.f48436h.a(0);
        }
    }

    @Override // b.a.r0.z2.u
    public void updateLastIds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
        }
    }
}
