package com.baidu.tieba.homepage.tabfeed;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.b26;
import com.baidu.tieba.dh;
import com.baidu.tieba.ej;
import com.baidu.tieba.ep8;
import com.baidu.tieba.gh;
import com.baidu.tieba.gy6;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.channel.model.ChannelTabNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.model.TabFeedNetFeedModel;
import com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedView;
import com.baidu.tieba.ii6;
import com.baidu.tieba.m37;
import com.baidu.tieba.o37;
import com.baidu.tieba.o95;
import com.baidu.tieba.on4;
import com.baidu.tieba.ox4;
import com.baidu.tieba.p47;
import com.baidu.tieba.pb;
import com.baidu.tieba.q37;
import com.baidu.tieba.r37;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.w26;
import com.baidu.tieba.ws4;
import com.baidu.tieba.xc5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.List;
import org.json.JSONObject;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class HomePageTabFeedFragment extends BaseFragment implements q37, ii6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public r37 d;
    public HomePageTabFeedView e;
    public ViewGroup f;
    public HttpMessageListener g;
    public CustomMessageListener h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;
    public pb m;
    public boolean n;
    public boolean o;
    public CustomMessageListener p;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HomePageTabFeedFragment homePageTabFeedFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage.getmOrginalMessage() instanceof MercatorModel.MercatorRequestHttpMessage) && ((MercatorModel.MercatorRequestHttpMessage) httpResponsedMessage.getmOrginalMessage()).isFromHomePageTabFeedFragment()) {
                this.a.z1(false);
                TbSingleton.getInstance().setMercatorRequestFromHomePageTabFeedFragment(false);
                this.a.n = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HomePageTabFeedFragment homePageTabFeedFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.n = true;
                HomePageTabFeedFragment homePageTabFeedFragment = this.a;
                homePageTabFeedFragment.hideLoadingView(homePageTabFeedFragment.f);
                HomePageTabFeedFragment homePageTabFeedFragment2 = this.a;
                homePageTabFeedFragment2.showNoDataRefreshView(homePageTabFeedFragment2.f, false);
                TbSingleton.getInstance().setMercatorRequestFromHomePageTabFeedFragment(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HomePageTabFeedFragment homePageTabFeedFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue() && this.a.e != null) {
                this.a.e.y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(HomePageTabFeedFragment homePageTabFeedFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PublishProgressData) || this.a.e == null) {
                return;
            }
            this.a.e.I((PublishProgressData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(HomePageTabFeedFragment homePageTabFeedFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gy6)) {
                gy6 gy6Var = (gy6) customResponsedMessage.getData();
                if (ImagesContract.LOCAL.equals(gy6Var.b)) {
                    int i = gy6Var.c;
                    if (i != 0) {
                        if (i == 1) {
                            gy6Var.a = null;
                            return;
                        }
                        return;
                    }
                    gy6Var.a = this.a.e.r();
                    if (this.a.K1() || (view2 = gy6Var.a) == null || view2.getVisibility() != 0) {
                        return;
                    }
                    o37.n();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ long b;
            public final /* synthetic */ long c;
            public final /* synthetic */ long d;
            public final /* synthetic */ f e;

            public a(f fVar, PostWriteCallBackData postWriteCallBackData, long j, long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, postWriteCallBackData, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = fVar;
                this.a = postWriteCallBackData;
                this.b = j;
                this.c = j2;
                this.d = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int k = ej.k(TbadkCoreApplication.getInst());
                    int i = ej.i(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setProZone(this.a.getProZone());
                    requestGetMyPostNetMessage.setParams(this.b, this.c, this.d, k, i, f, i2);
                    requestGetMyPostNetMessage.setCallFrom(1);
                    requestGetMyPostNetMessage.setTag(this.e.a.getUniqueId());
                    this.e.a.sendMessage(requestGetMyPostNetMessage);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(HomePageTabFeedFragment homePageTabFeedFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i)};
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
            long g = dh.g(postWriteCallBackData.getPostId(), 0L);
            long g2 = dh.g(postWriteCallBackData.getThreadId(), 0L);
            long g3 = dh.g(ep8.k().l(), 0L);
            if (g == 0 || g2 == 0 || g3 == 0) {
                return;
            }
            gh.a().postDelayed(new a(this, postWriteCallBackData, g2, g, g3), 1000L);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(HomePageTabFeedFragment homePageTabFeedFragment, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = homePageTabFeedFragment;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
        @Override // com.baidu.tieba.pb
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
                            errorString2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                        } else {
                            errorString2 = getMyPostHttpResponseMessage.getErrorString();
                        }
                        if (z || getMyPostHttpResponseMessage.getError() == 0) {
                            this.a.F1(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                            return;
                        }
                        return;
                    } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                        GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                            errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                        } else {
                            errorString = getMyPostSocketResponseMessage.getErrorString();
                        }
                        if (z || getMyPostSocketResponseMessage.getError() == 0) {
                            this.a.F1(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
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

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageTabFeedFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(HomePageTabFeedFragment homePageTabFeedFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageTabFeedFragment, Integer.valueOf(i)};
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
            this.a = homePageTabFeedFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.d == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || this.a.d.l() == null || ListUtils.getCount(this.a.d.l()) == 0) {
                return;
            }
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.a.e == null || this.a.e.s() == null || TextUtils.isEmpty(optString2)) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= this.a.e.s().getCount()) {
                        break;
                    }
                    Cdo B = this.a.e.s().B(i);
                    if (B instanceof w26) {
                        w26 w26Var = (w26) B;
                        if (w26Var.getThreadData() != null && w26Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(w26Var.getThreadData().getThreadAlaInfo().live_id))) {
                            optString = w26Var.getThreadData().getTid();
                            break;
                        }
                    }
                    i++;
                }
                if (StringUtils.isNull(optString)) {
                    return;
                }
            }
            int i2 = 0;
            while (true) {
                if (i2 < this.a.d.l().size()) {
                    ThreadData threadData = this.a.d.l().get(i2);
                    if (threadData != null && optString.equals(threadData.tid)) {
                        this.a.d.l().remove(i2);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            if (this.a.e.s() != null) {
                List<Integer> g = m37.g(optString, this.a.e.s());
                int intValue = g.get(0).intValue();
                int intValue2 = g.get(1).intValue();
                if (intValue == -1 || intValue2 == -1) {
                    return;
                }
                this.a.e.s().E(intValue, intValue2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ HomePageTabFeedFragment b;

        /* loaded from: classes4.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                    ox4 k = ox4.k();
                    k.u("key_home_common_tab_fragment_has_request_location_" + this.a.b.b, true);
                    this.a.b.mLocationView.dettachView(this.a.b.f);
                    HomePageTabFeedFragment homePageTabFeedFragment = this.a.b;
                    homePageTabFeedFragment.showLoadingView(homePageTabFeedFragment.f);
                    if (this.a.b.e != null) {
                        this.a.b.e.F(true);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homePageTabFeedFragment;
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                o37.f();
                PermissionUtil.requestLocation(this.a, 0, new a(this));
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
        this.n = true;
        this.p = new h(this, 2016488);
    }

    public int A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0842 : invokeV.intValue;
    }

    public final int B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = ((ej.i(getContext()) - ej.f(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            return this.o ? i2 - UtilHelper.getDimenPixelSize(R.dimen.tbds200) : i2;
        }
        return invokeV.intValue;
    }

    public r37 C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (r37) invokeV.objValue;
    }

    public String D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public String E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public final void F1(int i2, String str, GetMyPostResIdl getMyPostResIdl) {
        User_Info user_Info;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, str, getMyPostResIdl) == null) {
            if (i2 != 0) {
                showToast(str);
                return;
            }
            DataRes dataRes = getMyPostResIdl.data;
            if (dataRes == null || dataRes.thread_info == null) {
                return;
            }
            ws4 ws4Var = new ws4();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            I1(builder2, getMyPostResIdl.data.user_info);
            User user = builder.author;
            if (user == null || TextUtils.isEmpty(user.name)) {
                builder.author = builder2.build(true);
            }
            User user2 = builder.author;
            if (user2 != null && (user_Info = getMyPostResIdl.data.user_info) != null && user2.name.equals(user_Info.name)) {
                builder.author = builder2.build(true);
            }
            builder.fname = ep8.k().m();
            builder.fid = Long.valueOf(dh.g(ep8.k().m(), 0L));
            ws4Var.parserProtobuf(builder.build(true));
            this.e.u(ws4Var);
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (ImagesContract.LOCAL.equals(this.b) && this.g == null) {
                a aVar = new a(this, CmdConfigHttp.CMD_GET_MERCATOR);
                this.g = aVar;
                registerListener(aVar);
            }
            if (ImagesContract.LOCAL.equals(this.b) && this.h == null) {
                b bVar = new b(this, 2921649);
                this.h = bVar;
                registerListener(bVar);
            }
            if (ImagesContract.LOCAL.equals(this.b) && this.i == null) {
                c cVar = new c(this, 2921651);
                this.i = cVar;
                registerListener(cVar);
            }
            if (ImagesContract.LOCAL.equals(this.b) && this.j == null) {
                d dVar = new d(this, 2921526);
                this.j = dVar;
                registerListener(dVar);
            }
            if (ImagesContract.LOCAL.equals(this.b) && this.k == null) {
                e eVar = new e(this, 2921652);
                this.k = eVar;
                registerListener(eVar);
            }
            if (ImagesContract.LOCAL.equals(this.b) && this.l == null) {
                f fVar = new f(this, 2921655);
                this.l = fVar;
                fVar.setTag(getUniqueId());
                registerListener(this.l);
            }
            if (ImagesContract.LOCAL.equals(this.b) && this.m == null) {
                pb gVar = new g(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
                this.m = gVar;
                registerListener(gVar);
            }
        }
    }

    public final boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (ImagesContract.LOCAL.equals(this.b) && this.n && PermissionUtil.checkLocationForTieba(getPageContext().getPageActivity())) {
                if (isNetRefreshViewAttached()) {
                    hideNetRefreshView(this.f);
                }
                showLoadingView(this.f);
                TbSingleton.getInstance().setMercatorRequestFromHomePageTabFeedFragment(true);
                MercatorModel.d().f();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void I1(User.Builder builder, User_Info user_Info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, builder, user_Info) == null) || user_Info == null) {
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

    public void J1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.o = z;
        }
    }

    public final boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (ImagesContract.LOCAL.equals(this.b)) {
                Activity pageActivity = getPageContext().getPageActivity();
                ox4 k = ox4.k();
                boolean h2 = k.h("key_home_common_tab_fragment_has_request_location_" + this.b, false);
                if (PermissionUtil.checkLocationForTieba(pageActivity) && h2) {
                    return false;
                }
                HomePageTabFeedView homePageTabFeedView = this.e;
                if (homePageTabFeedView != null) {
                    homePageTabFeedView.F(false);
                }
                if (isNetRefreshViewAttached()) {
                    hideNetRefreshView(this.f);
                }
                o37.m();
                showLocationView(this.f, new i(this, pageActivity));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && isPrimary()) {
            StatisticItem statisticItem = new StatisticItem("c13749");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.a);
            statisticItem.param("obj_type", this.b);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.ii6
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ii6
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            HomePageTabFeedView homePageTabFeedView = this.e;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.z(TbadkCoreApplication.getInst().getSkinType());
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.yx4.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            z1(false);
        }
    }

    @Override // com.baidu.tieba.q37
    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, errorData) == null) {
            hideLoadingView(this.f);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            r37 r37Var = this.d;
            if (r37Var != null && !r37Var.a()) {
                showNetRefreshView(this.f, errorData != null ? getString(R.string.obfuscated_res_0x7f0f0c58, errorData.error_msg, Integer.valueOf(errorData.error_code)) : null, true);
            }
            HomePageTabFeedView homePageTabFeedView = this.e;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.E(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.uc5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.c == 201) {
                return "a075";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public xc5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            xc5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.s = this.a;
            }
            return pageStayDurationItem;
        }
        return (xc5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            super.hideLoadingView(view2);
            HomePageTabFeedView homePageTabFeedView = this.e;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.F(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view2) == null) {
            super.hideNetRefreshView(view2);
            HomePageTabFeedView homePageTabFeedView = this.e;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.F(true);
            }
        }
    }

    @Override // com.baidu.tieba.q37
    public void i() {
        r37 r37Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (r37Var = this.d) == null) {
            return;
        }
        r37Var.b();
    }

    @Override // com.baidu.tieba.q37
    public void l0(p47 p47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, p47Var) == null) {
            hideLoadingView(this.f);
            r37 r37Var = this.d;
            if (r37Var != null && !r37Var.a()) {
                showNoDataRefreshView(this.f, false);
                return;
            }
            HomePageTabFeedView homePageTabFeedView = this.e;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.A(p47Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void notifyColourHeaderData() {
        HomePageTabFeedView homePageTabFeedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (homePageTabFeedView = this.e) == null) {
            return;
        }
        homePageTabFeedView.x();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            super.onChangeSkinType(i2);
            HomePageTabFeedView homePageTabFeedView = this.e;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.z(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onCreate(bundle);
            if (getArguments() != null) {
                bundle = getArguments();
            }
            if (bundle != null) {
                this.a = bundle.getString("tab_name");
                this.b = bundle.getString("tab_code");
                this.c = bundle.getInt("tab_type");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, layoutInflater, viewGroup, bundle)) == null) {
            ViewGroup viewGroup2 = this.f;
            if (viewGroup2 != null && (viewGroup2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f.getParent()).removeView(this.f);
            }
            if (this.f == null) {
                ViewGroup viewGroup3 = (ViewGroup) getLayoutInflater().inflate(A1(), (ViewGroup) null);
                this.f = viewGroup3;
                this.e = new HomePageTabFeedView(this, this, viewGroup3, this.b);
                getLifecycle().addObserver(this.e);
            }
            HomePageTabFeedView homePageTabFeedView = this.e;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.C();
            }
            if (this.d == null) {
                if (this.c == 201) {
                    this.d = new ChannelTabNetFeedModel(getPageContext(), this);
                } else {
                    this.d = new TabFeedNetFeedModel(getPageContext(), this);
                }
                this.d.r(this.b, this.a, this.c);
            }
            this.d.c(getUniqueId());
            registerListener(this.p);
            G1();
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDestroy();
            b26.b().e(false);
            r37 r37Var = this.d;
            if (r37Var != null) {
                r37Var.destory();
            }
            if (this.e != null) {
                getLifecycle().removeObserver(this.e);
            }
            MessageManager.getInstance().unRegisterListener(this.p);
            o95.e().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onDetach();
            this.g = null;
            this.m = null;
            this.h = null;
            this.l = null;
            this.i = null;
            this.j = null;
            this.k = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onLazyLoad();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                if (K1() || H1()) {
                    return;
                }
                showLoadingView(this.f);
                r37 r37Var = this.d;
                if (r37Var != null) {
                    try {
                        r37Var.refresh();
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                return;
            }
            showNetRefreshView(this.f, null, true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && BdNetTypeUtil.isNetWorkAvailable()) {
            hideNetRefreshView(this.f);
            showLoadingView(this.f);
            z1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onPause();
            HomePageTabFeedView homePageTabFeedView = this.e;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.B();
            }
            b26.b().e(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                HomePageTabFeedView homePageTabFeedView = this.e;
                if (homePageTabFeedView != null) {
                    homePageTabFeedView.D();
                }
                L1();
                return;
            }
            HomePageTabFeedView homePageTabFeedView2 = this.e;
            if (homePageTabFeedView2 != null) {
                homePageTabFeedView2.B();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putString("tab_name", this.a);
                bundle.putString("tab_code", this.b);
                bundle.putInt("tab_type", this.c);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view2) == null) {
            HomePageTabFeedView homePageTabFeedView = this.e;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.F(false);
            }
            super.showLoadingView(view2, false, B1());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048611, this, view2, str, z) == null) {
            HomePageTabFeedView homePageTabFeedView = this.e;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.F(false);
            }
            super.showNetRefreshView(view2, getString(R.string.obfuscated_res_0x7f0f0fda), str, null, z, getNetRefreshListener());
            setNetRefreshViewTopMargin(ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702ab));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNoDataRefreshView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048612, this, view2, z) == null) {
            HomePageTabFeedView homePageTabFeedView = this.e;
            if (homePageTabFeedView != null) {
                homePageTabFeedView.F(false);
            }
            super.showNoDataRefreshView(view2, z);
            setNetRefreshViewTopMargin(ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702ab));
        }
    }

    @Override // com.baidu.tieba.ii6
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            z1(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? "714" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ViewGroup taskAttachParentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            HomePageTabFeedView homePageTabFeedView = this.e;
            if (homePageTabFeedView != null) {
                return homePageTabFeedView.q;
            }
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            String e2 = on4.f().e(taskActionId(), "tab_code");
            if (TextUtils.isEmpty(e2) || !e2.equalsIgnoreCase(this.b)) {
                return;
            }
            super.taskStart();
        }
    }

    @Override // com.baidu.tieba.ii6
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
        }
    }

    public void z1(boolean z) {
        r37 r37Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048618, this, z) == null) || K1() || H1() || (r37Var = this.d) == null) {
            return;
        }
        if (this.e != null && z) {
            if (r37Var.a()) {
                this.e.H();
                this.e.E(true);
            } else {
                hideNetRefreshView(this.f);
                showLoadingView(this.f);
            }
        }
        this.d.refresh();
    }
}
