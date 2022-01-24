package com.baidu.tieba.homepage.tabfeed;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.l1;
import c.a.s0.s.q.y0;
import c.a.t0.e1.o0;
import c.a.t0.g0.f0.j;
import c.a.t0.g0.v;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.model.TabFeedNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedView;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes12.dex */
public class HomePageTabFeedFragment extends BaseFragment implements c.a.t0.p1.j.e, o0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAB_CODE = "tab_code";
    public static final String TAB_NAME = "tab_name";
    public static final String TAB_TYPE = "tab_type";
    public static final int THREAD_NOT_FOUND = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f44404e;

    /* renamed from: f  reason: collision with root package name */
    public String f44405f;

    /* renamed from: g  reason: collision with root package name */
    public int f44406g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.p1.j.f f44407h;

    /* renamed from: i  reason: collision with root package name */
    public HomePageTabFeedView f44408i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f44409j;
    public HttpMessageListener k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public c.a.d.c.g.a q;
    public boolean r;
    public CustomMessageListener s;

    /* loaded from: classes12.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HomePageTabFeedFragment homePageTabFeedFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i2)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage.getmOrginalMessage() instanceof MercatorModel.MercatorRequestHttpMessage) && ((MercatorModel.MercatorRequestHttpMessage) httpResponsedMessage.getmOrginalMessage()).isFromHomePageTabFeedFragment()) {
                this.a.callRefresh(false);
                TbSingleton.getInstance().setMercatorRequestFromHomePageTabFeedFragment(false);
                this.a.r = false;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HomePageTabFeedFragment homePageTabFeedFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i2)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.r = true;
                HomePageTabFeedFragment homePageTabFeedFragment = this.a;
                homePageTabFeedFragment.hideLoadingView(homePageTabFeedFragment.f44409j);
                HomePageTabFeedFragment homePageTabFeedFragment2 = this.a;
                homePageTabFeedFragment2.showNoDataRefreshView(homePageTabFeedFragment2.f44409j, false);
                TbSingleton.getInstance().setMercatorRequestFromHomePageTabFeedFragment(false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HomePageTabFeedFragment homePageTabFeedFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i2)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && this.a.f44408i != null) {
                this.a.f44408i.notifyLocalInfoCompleted();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(HomePageTabFeedFragment homePageTabFeedFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i2)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof l1) || this.a.f44408i == null) {
                return;
            }
            this.a.f44408i.updatePublishProgress((l1) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes12.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(HomePageTabFeedFragment homePageTabFeedFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i2)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            View view;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.t0.p1.d.a)) {
                c.a.t0.p1.d.a aVar = (c.a.t0.p1.d.a) customResponsedMessage.getData();
                if (aVar.f20558b.equals(MainTabActivity.TAB_CODE_LOCAL)) {
                    int i2 = aVar.f20559c;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            aVar.a = null;
                            return;
                        }
                        return;
                    }
                    aVar.a = this.a.f44408i.getPostAnimateFloatView();
                    if (this.a.s() || (view = aVar.a) == null || view.getVisibility() != 0) {
                        return;
                    }
                    c.a.t0.p1.j.c.l();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f44410e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f44411f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f44412g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ long f44413h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ f f44414i;

            public a(f fVar, PostWriteCallBackData postWriteCallBackData, long j2, long j3, long j4) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, postWriteCallBackData, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44414i = fVar;
                this.f44410e = postWriteCallBackData;
                this.f44411f = j2;
                this.f44412g = j3;
                this.f44413h = j4;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int k = n.k(TbadkCoreApplication.getInst());
                    int i2 = n.i(TbadkCoreApplication.getInst());
                    float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setProZone(this.f44410e.getProZone());
                    requestGetMyPostNetMessage.setParams(this.f44411f, this.f44412g, this.f44413h, k, i2, f2, i3);
                    requestGetMyPostNetMessage.setCallFrom(1);
                    requestGetMyPostNetMessage.setTag(this.f44414i.a.getUniqueId());
                    this.f44414i.a.sendMessage(requestGetMyPostNetMessage);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(HomePageTabFeedFragment homePageTabFeedFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i2)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostWriteCallBackData postWriteCallBackData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || (postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData()) == null) {
                return;
            }
            long g2 = c.a.d.f.m.b.g(postWriteCallBackData.getPostId(), 0L);
            long g3 = c.a.d.f.m.b.g(postWriteCallBackData.getThreadId(), 0L);
            long g4 = c.a.d.f.m.b.g(c.a.t0.x3.s0.b.k().l(), 0L);
            if (g2 == 0 || g3 == 0 || g4 == 0) {
                return;
            }
            c.a.d.f.m.e.a().postDelayed(new a(this, postWriteCallBackData, g3, g2, g4), 1000L);
        }
    }

    /* loaded from: classes12.dex */
    public class g extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(HomePageTabFeedFragment homePageTabFeedFragment, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageTabFeedFragment;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
        @Override // c.a.d.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            String errorString;
            String errorString2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RequestGetMyPostNetMessage) {
                    z = ((RequestGetMyPostNetMessage) extra).showErrorToast();
                    if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
                        GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                            errorString2 = this.a.getResources().getString(R.string.neterror);
                        } else {
                            errorString2 = getMyPostHttpResponseMessage.getErrorString();
                        }
                        if (z || getMyPostHttpResponseMessage.getError() == 0) {
                            this.a.o(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                            return;
                        }
                        return;
                    } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                        GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                            errorString = this.a.getResources().getString(R.string.neterror);
                        } else {
                            errorString = getMyPostSocketResponseMessage.getErrorString();
                        }
                        if (z || getMyPostSocketResponseMessage.getError() == 0) {
                            this.a.o(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            z = true;
            if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(HomePageTabFeedFragment homePageTabFeedFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i2)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f44407h == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || this.a.f44407h.i() == null || ListUtils.getCount(this.a.f44407h.i()) == 0) {
                return;
            }
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.a.f44408i == null || this.a.f44408i.getRecycleView() == null || TextUtils.isEmpty(optString2)) {
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= this.a.f44408i.getRecycleView().getCount()) {
                        break;
                    }
                    c.a.d.n.e.n item = this.a.f44408i.getRecycleView().getItem(i2);
                    if (item instanceof j) {
                        j jVar = (j) item;
                        if (jVar.getThreadData() != null && jVar.getThreadData().p1() != null && optString2.equals(String.valueOf(jVar.getThreadData().p1().live_id))) {
                            optString = jVar.getThreadData().w1();
                            break;
                        }
                    }
                    i2++;
                }
                if (StringUtils.isNull(optString)) {
                    return;
                }
            }
            int i3 = 0;
            while (true) {
                if (i3 < this.a.f44407h.i().size()) {
                    e2 e2Var = this.a.f44407h.i().get(i3);
                    if (e2Var != null && optString.equals(e2Var.E)) {
                        this.a.f44407h.i().remove(i3);
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (this.a.f44408i.getRecycleView() != null) {
                List<Integer> d2 = c.a.t0.p1.j.a.d(optString, this.a.f44408i.getRecycleView());
                int intValue = d2.get(0).intValue();
                int intValue2 = d2.get(1).intValue();
                if (intValue == -1 || intValue2 == -1) {
                    return;
                }
                this.a.f44408i.getRecycleView().removeItemList(intValue, intValue2);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f44415e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HomePageTabFeedFragment f44416f;

        /* loaded from: classes12.dex */
        public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
            public void onPermissionsGranted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    TbSingleton.getInstance().setMercatorRequestFromHomePageTabFeedFragment(true);
                    MercatorModel.d().f();
                    c.a.s0.s.i0.b k = c.a.s0.s.i0.b.k();
                    k.u("key_home_common_tab_fragment_has_request_location_" + this.a.f44416f.f44405f, true);
                    this.a.f44416f.mLocationView.dettachView(this.a.f44416f.f44409j);
                    HomePageTabFeedFragment homePageTabFeedFragment = this.a.f44416f;
                    homePageTabFeedFragment.showLoadingView(homePageTabFeedFragment.f44409j);
                    if (this.a.f44416f.f44408i != null) {
                        this.a.f44416f.f44408i.setListContentVisible(true);
                    }
                }
            }
        }

        public i(HomePageTabFeedFragment homePageTabFeedFragment, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44416f = homePageTabFeedFragment;
            this.f44415e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.t0.p1.j.c.e();
                PermissionUtil.requestLocation(this.f44415e, 0, new a(this));
            }
        }
    }

    public HomePageTabFeedFragment() {
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
        this.r = true;
        this.s = new h(this, 2016488);
    }

    @Override // c.a.t0.p1.j.e
    public void callLoadMore() {
        c.a.t0.p1.j.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f44407h) == null) {
            return;
        }
        fVar.loadMore();
    }

    public void callRefresh(boolean z) {
        c.a.t0.p1.j.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || s() || q() || (fVar = this.f44407h) == null) {
            return;
        }
        if (this.f44408i != null && z) {
            if (fVar.a()) {
                this.f44408i.toListTop();
                this.f44408i.setIsRefresh(true);
            } else {
                hideNetRefreshView(this.f44409j);
                showLoadingView(this.f44409j);
            }
        }
        this.f44407h.refresh();
    }

    @Override // c.a.t0.e1.o0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f44406g == 201) {
                return "a075";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.tab_feed_fragment : invokeV.intValue;
    }

    public c.a.t0.p1.j.f getNetModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f44407h : (c.a.t0.p1.j.f) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public c.a.s0.q0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.s0.q0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.s = this.f44404e;
            }
            return pageStayDurationItem;
        }
        return (c.a.s0.q0.d) invokeV.objValue;
    }

    public String getTabCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f44405f : (String) invokeV.objValue;
    }

    public String getTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f44404e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            super.hideLoadingView(view);
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            super.hideNetRefreshView(view);
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(true);
            }
        }
    }

    public boolean isAtTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                return homePageTabFeedView.isListAtTop();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? ((n.i(getContext()) - n.f(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2) : invokeV.intValue;
    }

    public final void o(int i2, String str, GetMyPostResIdl getMyPostResIdl) {
        User_Info user_Info;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048589, this, i2, str, getMyPostResIdl) == null) {
            if (i2 != 0) {
                showToast(str);
                return;
            }
            DataRes dataRes = getMyPostResIdl.data;
            if (dataRes == null || dataRes.thread_info == null) {
                return;
            }
            y0 y0Var = new y0();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            r(builder2, getMyPostResIdl.data.user_info);
            User user = builder.author;
            if (user == null || TextUtils.isEmpty(user.name)) {
                builder.author = builder2.build(true);
            }
            User user2 = builder.author;
            if (user2 != null && (user_Info = getMyPostResIdl.data.user_info) != null && user2.name.equals(user_Info.name)) {
                builder.author = builder2.build(true);
            }
            builder.fname = c.a.t0.x3.s0.b.k().m();
            builder.fid = Long.valueOf(c.a.d.f.m.b.g(c.a.t0.x3.s0.b.k().m(), 0L));
            y0Var.d3(builder.build(true));
            this.f44408i.insertFakeThreadData(y0Var);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            super.onChangeSkinType(i2);
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                bundle = getArguments();
            }
            if (bundle != null) {
                this.f44404e = bundle.getString("tab_name");
                this.f44405f = bundle.getString("tab_code");
                this.f44406g = bundle.getInt("tab_type");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup viewGroup2 = this.f44409j;
            if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f44409j.getParent()).removeView(this.f44409j);
            }
            if (this.f44409j == null) {
                ViewGroup viewGroup3 = (ViewGroup) getLayoutInflater().inflate(getLayoutR(), (ViewGroup) null);
                this.f44409j = viewGroup3;
                this.f44408i = new HomePageTabFeedView(this, this, viewGroup3, this.f44405f);
                getLifecycle().addObserver(this.f44408i);
            }
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.resetListPullRefreshListener();
            }
            if (this.f44407h == null) {
                if (this.f44406g == 201) {
                    this.f44407h = new ChannelTabNetFeedModel(getPageContext(), this);
                } else {
                    this.f44407h = new TabFeedNetFeedModel(getPageContext(), this);
                }
                this.f44407h.o(this.f44405f, this.f44404e, this.f44406g);
            }
            this.f44407h.registerListener(getUniqueId());
            registerListener(this.s);
            p();
            return this.f44409j;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDestroy();
            v.b().e(false);
            c.a.t0.p1.j.f fVar = this.f44407h;
            if (fVar != null) {
                fVar.destory();
            }
            if (this.f44408i != null) {
                getLifecycle().removeObserver(this.f44408i);
            }
            MessageManager.getInstance().unRegisterListener(this.s);
            TbadkCoreApplication.getInst().getPersonalizeViewData().a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDetach();
            this.k = null;
            this.q = null;
            this.l = null;
            this.p = null;
            this.m = null;
            this.n = null;
            this.o = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onLazyLoad();
            if (l.z()) {
                if (s() || q()) {
                    return;
                }
                showLoadingView(this.f44409j);
                c.a.t0.p1.j.f fVar = this.f44407h;
                if (fVar != null) {
                    try {
                        fVar.refresh();
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                return;
            }
            showNetRefreshView(this.f44409j, null, true);
        }
    }

    @Override // c.a.s0.s.k0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            callRefresh(false);
        }
    }

    @Override // c.a.t0.p1.j.e
    public void onNetCallback(c.a.t0.p1.j.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) {
            hideLoadingView(this.f44409j);
            c.a.t0.p1.j.f fVar = this.f44407h;
            if (fVar != null && !fVar.a()) {
                showNoDataRefreshView(this.f44409j, false);
                return;
            }
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.onNetDataUpdate(dVar);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && l.z()) {
            hideNetRefreshView(this.f44409j);
            showLoadingView(this.f44409j);
            callRefresh(false);
        }
    }

    @Override // c.a.t0.e1.o0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    @Override // c.a.t0.e1.o0
    public void onPageStartIn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onPause();
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.pause();
            }
            v.b().e(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                HomePageTabFeedView homePageTabFeedView = this.f44408i;
                if (homePageTabFeedView != null) {
                    homePageTabFeedView.resume();
                }
                t();
                return;
            }
            HomePageTabFeedView homePageTabFeedView2 = this.f44408i;
            if (homePageTabFeedView2 != null) {
                homePageTabFeedView2.pause();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("tab_name", this.f44404e);
                bundle.putString("tab_code", this.f44405f);
                bundle.putInt("tab_type", this.f44406g);
            }
        }
    }

    @Override // c.a.t0.p1.j.e
    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, errorData) == null) {
            hideLoadingView(this.f44409j);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            c.a.t0.p1.j.f fVar = this.f44407h;
            if (fVar != null && !fVar.a()) {
                showNetRefreshView(this.f44409j, errorData != null ? getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setIsRefresh(false);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f44405f) && this.k == null) {
                a aVar = new a(this, CmdConfigHttp.CMD_GET_MERCATOR);
                this.k = aVar;
                registerListener(aVar);
            }
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f44405f) && this.l == null) {
                b bVar = new b(this, 2921649);
                this.l = bVar;
                registerListener(bVar);
            }
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f44405f) && this.m == null) {
                c cVar = new c(this, 2921651);
                this.m = cVar;
                registerListener(cVar);
            }
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f44405f) && this.n == null) {
                d dVar = new d(this, 2921526);
                this.n = dVar;
                registerListener(dVar);
            }
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f44405f) && this.o == null) {
                e eVar = new e(this, 2921652);
                this.o = eVar;
                registerListener(eVar);
            }
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f44405f) && this.p == null) {
                f fVar = new f(this, 2921655);
                this.p = fVar;
                fVar.setTag(getUniqueId());
                registerListener(this.p);
            }
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f44405f) && this.q == null) {
                c.a.d.c.g.a gVar = new g(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
                this.q = gVar;
                registerListener(gVar);
            }
        }
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f44405f) && this.r && PermissionUtil.checkLocationForTieba(getPageContext().getPageActivity())) {
                if (isNetRefreshViewAttached()) {
                    hideNetRefreshView(this.f44409j);
                }
                showLoadingView(this.f44409j);
                TbSingleton.getInstance().setMercatorRequestFromHomePageTabFeedFragment(true);
                MercatorModel.d().f();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void r(User.Builder builder, User_Info user_Info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, builder, user_Info) == null) || user_Info == null) {
            return;
        }
        Long l = user_Info.id;
        builder.id = l;
        builder.gender = user_Info.gender;
        builder.type = user_Info.type;
        builder.name = user_Info.name;
        builder.name_show = user_Info.name_show;
        if (l.longValue() == TbadkCoreApplication.getCurrentAccountId()) {
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
        } else {
            builder.portrait = user_Info.portrait;
        }
        builder.god_data = user_Info.god_data;
        builder.fans_num = user_Info.fans_num;
        builder.fans_nickname = user_Info.fans_nickname;
        builder.is_bawu = user_Info.is_bawu;
        builder.bawu_type = user_Info.bawu_type;
        builder.new_god_data = user_Info.new_god_data;
    }

    @Override // c.a.t0.e1.o0
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            callRefresh(true);
        }
    }

    public void removeListItems(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048610, this, i2, i3) == null) {
            c.a.t0.p1.j.f fVar = this.f44407h;
            if (fVar != null && !fVar.a()) {
                showNoDataRefreshView(this.f44409j, false);
                return;
            }
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.removeListItems(i2, i3);
            }
        }
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (MainTabActivity.TAB_CODE_LOCAL.equals(this.f44405f)) {
                Activity pageActivity = getPageContext().getPageActivity();
                c.a.s0.s.i0.b k = c.a.s0.s.i0.b.k();
                boolean h2 = k.h("key_home_common_tab_fragment_has_request_location_" + this.f44405f, false);
                if (PermissionUtil.checkLocationForTieba(pageActivity) && h2) {
                    return false;
                }
                HomePageTabFeedView homePageTabFeedView = this.f44408i;
                if (homePageTabFeedView != null) {
                    homePageTabFeedView.setListContentVisible(false);
                }
                if (isNetRefreshViewAttached()) {
                    hideNetRefreshView(this.f44409j);
                }
                c.a.t0.p1.j.c.k();
                showLocationView(this.f44409j, new i(this, pageActivity));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setVideoThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(false);
            }
            super.showLoadingView(view, false, n());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048614, this, view, str, z) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(false);
            }
            super.showNetRefreshView(view, getString(R.string.refresh_view_title_text), str, null, z, getNetRefreshListener());
            setNetRefreshViewTopMargin(n.f(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048615, this, view, z) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.setListContentVisible(false);
            }
            super.showNoDataRefreshView(view, z);
            setNetRefreshViewTopMargin(n.f(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f44404e);
            statisticItem.param("obj_type", this.f44405f);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? "714" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ViewGroup taskAttachParentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            HomePageTabFeedView homePageTabFeedView = this.f44408i;
            if (homePageTabFeedView != null) {
                return homePageTabFeedView.mTaskFloatingView;
            }
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            String e2 = c.a.s0.a.e0.c.f().e(taskActionId(), "tab_code");
            if (TextUtils.isEmpty(e2) || !e2.equalsIgnoreCase(this.f44405f)) {
                return;
            }
            super.taskStart();
        }
    }
}
