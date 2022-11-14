package com.baidu.tieba.homepage.concern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ah;
import com.baidu.tieba.ew4;
import com.baidu.tieba.gr8;
import com.baidu.tieba.gw4;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.jv4;
import com.baidu.tieba.lk6;
import com.baidu.tieba.qb;
import com.baidu.tieba.qt4;
import com.baidu.tieba.ra5;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.xg;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ConcernFragment extends BaseFragment implements lk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcernPageView a;
    public ConcernPageView.o b;
    public ScrollFragmentTabHost c;
    public boolean d;
    public boolean e;
    public CustomMessageListener f;
    public final AntiHelper.k g;
    public CustomMessageListener h;
    public final CustomMessageListener i;
    public final CustomMessageListener j;
    public final qb k;

    @Override // com.baidu.tieba.lk6
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.ce5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a038" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lk6
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernFragment a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ long b;
            public final /* synthetic */ long c;
            public final /* synthetic */ long d;
            public final /* synthetic */ d e;

            public a(d dVar, PostWriteCallBackData postWriteCallBackData, long j, long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, postWriteCallBackData, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = dVar;
                this.a = postWriteCallBackData;
                this.b = j;
                this.c = j2;
                this.d = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int l = yi.l(TbadkCoreApplication.getInst());
                    int j = yi.j(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setProZone(this.a.getProZone());
                    requestGetMyPostNetMessage.setParams(this.b, this.c, this.d, l, j, f, i);
                    requestGetMyPostNetMessage.setCallFrom(1);
                    this.e.a.sendMessage(requestGetMyPostNetMessage);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ConcernFragment concernFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernFragment, Integer.valueOf(i)};
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
            this.a = concernFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostWriteCallBackData postWriteCallBackData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData()) != null) {
                long g = xg.g(postWriteCallBackData.getPostId(), 0L);
                long g2 = xg.g(postWriteCallBackData.getThreadId(), 0L);
                long g3 = xg.g(gr8.k().l(), 0L);
                if (g != 0 && g2 != 0 && g3 != 0) {
                    ah.a().postDelayed(new a(this, postWriteCallBackData, g2, g, g3), 1000L);
                } else if (!StringUtils.isNull(postWriteCallBackData.getVideoid())) {
                    WriteData writeData = postWriteCallBackData.writeDataForVideo;
                    qt4 qt4Var = new qt4();
                    qt4Var.parseFromWriteData(writeData);
                    if (this.a.a != null && this.a.a.E()) {
                        this.a.a.B(qt4Var);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernFragment a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ long b;
            public final /* synthetic */ long c;
            public final /* synthetic */ long d;
            public final /* synthetic */ e e;

            public a(e eVar, PostWriteCallBackData postWriteCallBackData, long j, long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, postWriteCallBackData, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = eVar;
                this.a = postWriteCallBackData;
                this.b = j;
                this.c = j2;
                this.d = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int l = yi.l(TbadkCoreApplication.getInst());
                    int j = yi.j(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setProZone(this.a.getProZone());
                    requestGetMyPostNetMessage.setParams(this.b, this.c, this.d, l, j, f, i);
                    requestGetMyPostNetMessage.setCallFrom(1);
                    this.e.a.sendMessage(requestGetMyPostNetMessage);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ConcernFragment concernFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernFragment, Integer.valueOf(i)};
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
            this.a = concernFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostWriteCallBackData postWriteCallBackData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData()) != null) {
                long g = xg.g(postWriteCallBackData.getPostId(), 0L);
                long g2 = xg.g(postWriteCallBackData.getThreadId(), 0L);
                long g3 = xg.g(gr8.k().l(), 0L);
                if (g != 0 && g2 != 0 && g3 != 0) {
                    ah.a().postDelayed(new a(this, postWriteCallBackData, g2, g, g3), 1000L);
                } else if (!StringUtils.isNull(postWriteCallBackData.getVideoid())) {
                    WriteData writeData = postWriteCallBackData.writeDataForVideo;
                    qt4 qt4Var = new qt4();
                    qt4Var.parseFromWriteData(writeData);
                    if (this.a.a != null && this.a.a.E()) {
                        this.a.a.B(qt4Var);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ConcernFragment concernFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernFragment, Integer.valueOf(i)};
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
            this.a = concernFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().c != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.a.getUniqueId()) && updateAttentionMessage.getData().i != null && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().i, this.a.g) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernFragment a;

        public b(ConcernFragment concernFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ConcernFragment concernFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernFragment, Integer.valueOf(i)};
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
            this.a = concernFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.a != null && this.a.a.E()) {
                this.a.a.O();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ConcernFragment concernFragment, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernFragment, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = concernFragment;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
        @Override // com.baidu.tieba.qb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            String errorString;
            String errorString2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                    Object extra = responsedMessage.getOrginalMessage().getExtra();
                    if (extra instanceof RequestGetMyPostNetMessage) {
                        z = ((RequestGetMyPostNetMessage) extra).showErrorToast();
                        if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
                            GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                            if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                                errorString2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c81);
                            } else {
                                errorString2 = getMyPostHttpResponseMessage.getErrorString();
                            }
                            if (!z && getMyPostHttpResponseMessage.getError() != 0) {
                                return;
                            }
                            this.a.u1(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                            return;
                        } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                            GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                            if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                                errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c81);
                            } else {
                                errorString = getMyPostSocketResponseMessage.getErrorString();
                            }
                            if (!z && getMyPostSocketResponseMessage.getError() != 0) {
                                return;
                            }
                            this.a.u1(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
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
    }

    public ConcernFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.f = new a(this, 2001115);
        this.g = new b(this);
        this.h = new c(this, 2921414);
        this.i = new d(this, 2001383);
        this.j = new e(this, 2921650);
        this.k = new f(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = false;
        this.f = new a(this, 2001115);
        this.g = new b(this);
        this.h = new c(this, 2921414);
        this.i = new d(this, 2001383);
        this.j = new e(this, 2921650);
        this.k = new f(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        SpeedStatsManager.getInstance().addStatsTimeStamp(5020);
        this.a = new ConcernPageView(context);
        SpeedStatsManager.getInstance().addStatsTimeStamp(5021);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            ConcernPageView concernPageView = this.a;
            if (concernPageView != null && concernPageView.E()) {
                this.a.K(i);
            }
        }
    }

    public void x1(ConcernPageView.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, oVar) == null) {
            this.b = oVar;
            this.a.setCallback(oVar);
        }
    }

    public void y1(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, scrollFragmentTabHost) == null) {
            this.c = scrollFragmentTabHost;
            ConcernPageView concernPageView = this.a;
            if (concernPageView != null && concernPageView.E()) {
                this.a.setScrollFragmentTabHost(scrollFragmentTabHost);
            }
        }
    }

    public void A1(DataRes dataRes, boolean z) {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048576, this, dataRes, z) == null) && (concernPageView = this.a) != null) {
            concernPageView.a0(dataRes, z);
        }
    }

    public void B1(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
            this.a.b0(str, i);
        }
    }

    @Override // com.baidu.tieba.lk6
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            ConcernPageView concernPageView = this.a;
            if (concernPageView != null && concernPageView.E()) {
                this.a.K(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void notifyColourHeaderData() {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (concernPageView = this.a) != null) {
            concernPageView.I();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.h);
            super.onDetach();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            this.a.setTabInForeBackgroundState(true);
            gw4.n(ew4.j);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5024);
            super.onResume();
            ConcernPageView concernPageView = this.a;
            if (concernPageView != null) {
                concernPageView.N();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(5025);
        }
    }

    @Override // com.baidu.tieba.lk6
    public void t() {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.e && (concernPageView = this.a) != null && concernPageView.E()) {
            this.a.S();
        }
    }

    public void t1() {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (concernPageView = this.a) != null && concernPageView.E()) {
            this.a.u();
        }
    }

    public void z1() {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (concernPageView = this.a) != null && concernPageView.E()) {
            this.a.R();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.ce5
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (super.getCurrentPageSourceKeyList() != null) {
                arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
            } else {
                arrayList = new ArrayList();
            }
            if (!"a001".equals(ListUtils.getItem(arrayList, arrayList.size() - 1))) {
                arrayList.add("a001");
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.i);
            MessageManager.getInstance().unRegisterListener(this.j);
            ConcernPageView concernPageView = this.a;
            if (concernPageView != null && concernPageView.E()) {
                this.a.L();
            }
            this.d = true;
            ra5.e().b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.i.setTag(getBaseFragmentActivity().getUniqueId());
            this.i.setSelfListener(true);
            this.k.getHttpMessageListener().setSelfListener(true);
            this.k.getSocketMessageListener().setSelfListener(true);
            ConcernPageView concernPageView = this.a;
            if (concernPageView != null && concernPageView.E()) {
                registerListener(this.i);
                registerListener(this.k);
                registerListener(this.j);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5022);
            if (this.a.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.a.getParent()).removeView(this.a);
                ConcernPageView.o oVar = this.b;
                if (oVar != null) {
                    this.a.setCallback(oVar);
                }
            }
            if (this.a.E()) {
                this.a.setPageUniqueId(getUniqueId());
                if (this.d) {
                    this.a.A();
                    this.d = false;
                }
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CONCERN_TAB_ON_CREATE_VIEW_END_STAMP_KEY);
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    public final void u1(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        User_Info user_Info;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048593, this, i, str, getMyPostResIdl) == null) {
            if (i != 0) {
                showToast(str);
                return;
            }
            tbclient.GetMyPost.DataRes dataRes = getMyPostResIdl.data;
            if (dataRes != null && dataRes.thread_info != null) {
                qt4 qt4Var = new qt4();
                ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
                User.Builder builder2 = new User.Builder(builder.author);
                v1(builder2, getMyPostResIdl.data.user_info);
                User user = builder.author;
                if (user == null || TextUtils.isEmpty(user.name)) {
                    builder.author = builder2.build(true);
                }
                User user2 = builder.author;
                if (user2 != null && (user_Info = getMyPostResIdl.data.user_info) != null && user2.name.equals(user_Info.name)) {
                    builder.author = builder2.build(true);
                }
                builder.fname = gr8.k().m();
                builder.fid = Long.valueOf(xg.g(gr8.k().m(), 0L));
                qt4Var.parserProtobuf(builder.build(true));
                this.a.C(qt4Var, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                if (!this.e) {
                    ConcernPageView concernPageView = this.a;
                    if (concernPageView != null) {
                        if (!concernPageView.E()) {
                            this.a.z(getContext());
                            if (!UbsABTestHelper.isLaunchUpA()) {
                                this.a.removeAllViews();
                                this.a.Z();
                            }
                            this.a.A();
                            registerListener(this.f);
                            registerListener(this.h);
                            this.a.setScrollFragmentTabHost(this.c);
                            this.a.setPageUniqueId(getUniqueId());
                            registerListener(this.i);
                            registerListener(this.k);
                            registerListener(this.j);
                            this.a.setTabInForeBackgroundState(false);
                        }
                        this.a.v();
                    }
                    this.e = true;
                } else {
                    ConcernPageView concernPageView2 = this.a;
                    if (concernPageView2 != null) {
                        concernPageView2.M();
                    }
                }
                ConcernPageView concernPageView3 = this.a;
                if (concernPageView3 != null) {
                    concernPageView3.setViewForeground();
                }
                if (getContext() != null) {
                    gw4.o(getContext(), ew4.j);
                    return;
                }
                return;
            }
            gw4.n(ew4.j);
            ConcernPageView concernPageView4 = this.a;
            if (concernPageView4 != null) {
                concernPageView4.P();
            }
            t1();
        }
    }

    public final void v1(User.Builder builder, User_Info user_Info) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, builder, user_Info) != null) || user_Info == null) {
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
}
