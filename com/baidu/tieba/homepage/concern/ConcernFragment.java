package com.baidu.tieba.homepage.concern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.a05;
import com.baidu.tieba.ee7;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.hz4;
import com.baidu.tieba.jx4;
import com.baidu.tieba.li5;
import com.baidu.tieba.oma;
import com.baidu.tieba.pma;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes6.dex */
public class ConcernFragment extends BaseFragment implements ee7, pma {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcernPageView a;
    public ConcernPageView.s b;
    public ScrollFragmentTabHost c;
    public boolean d;
    public boolean e;
    public CustomMessageListener f;
    public final AntiHelper.k g;
    public CustomMessageListener h;
    public final CustomMessageListener i;
    public final CustomMessageListener j;
    public final HttpMessageListener k;

    @Override // com.baidu.tieba.pma
    @NonNull
    public String I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "home_follow_landing_page" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pma
    @NonNull
    public String V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "home" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ee7
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a038" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ee7
    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernFragment a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ long c;
            public final /* synthetic */ d d;

            public a(d dVar, long j, long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = dVar;
                this.a = j;
                this.b = j2;
                this.c = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setParams(this.a, this.b, this.c, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setCallFrom(1);
                    this.d.a.sendMessage(requestGetMyPostNetMessage);
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
                long j = JavaTypesHelper.toLong(postWriteCallBackData.getPostId(), 0L);
                long j2 = JavaTypesHelper.toLong(postWriteCallBackData.getThreadId(), 0L);
                long j3 = JavaTypesHelper.toLong(WriteMsgHolder.getLastForumId(), 0L);
                if (j != 0 && j2 != 0 && j3 != 0) {
                    SafeHandler.getInst().postDelayed(new a(this, j2, j, j3), 1000L);
                } else if (!StringUtils.isNull(postWriteCallBackData.getVideoid())) {
                    WriteData writeData = postWriteCallBackData.writeDataForVideo;
                    jx4 jx4Var = new jx4();
                    jx4Var.parseFromWriteData(writeData);
                    if (this.a.a != null && this.a.a.M()) {
                        this.a.a.J(jx4Var);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernFragment a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ long b;
            public final /* synthetic */ long c;
            public final /* synthetic */ e d;

            public a(e eVar, long j, long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = eVar;
                this.a = j;
                this.b = j2;
                this.c = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
                    int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
                    float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setParams(this.a, this.b, this.c, equipmentWidth, equipmentHeight, f, i);
                    requestGetMyPostNetMessage.setCallFrom(1);
                    this.d.a.sendMessage(requestGetMyPostNetMessage);
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
                long j = JavaTypesHelper.toLong(postWriteCallBackData.getPostId(), 0L);
                long j2 = JavaTypesHelper.toLong(postWriteCallBackData.getThreadId(), 0L);
                long j3 = JavaTypesHelper.toLong(WriteMsgHolder.getLastForumId(), 0L);
                if (j != 0 && j2 != 0 && j3 != 0) {
                    SafeHandler.getInst().postDelayed(new a(this, j2, j, j3), 1000L);
                } else if (!StringUtils.isNull(postWriteCallBackData.getVideoid())) {
                    WriteData writeData = postWriteCallBackData.writeDataForVideo;
                    jx4 jx4Var = new jx4();
                    jx4Var.parseFromWriteData(writeData);
                    if (this.a.a != null && this.a.a.M()) {
                        this.a.a.J(jx4Var);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.a.getUniqueId()) && updateAttentionMessage.getData().blockData != null && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().blockData, this.a.g) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void onNavigationButtonClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.a != null && this.a.a.M()) {
                this.a.a.Z();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ConcernFragment concernFragment, int i) {
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
        /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            boolean z;
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                    Object extra = httpResponsedMessage.getOrginalMessage().getExtra();
                    if (extra instanceof RequestGetMyPostNetMessage) {
                        z = ((RequestGetMyPostNetMessage) extra).showErrorToast();
                        if (!(httpResponsedMessage instanceof GetMyPostHttpResponseMessage)) {
                            GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) httpResponsedMessage;
                            if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                                errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e4f);
                            } else {
                                errorString = getMyPostHttpResponseMessage.getErrorString();
                            }
                            if (!z && getMyPostHttpResponseMessage.getError() != 0) {
                                return;
                            }
                            this.a.g2(getMyPostHttpResponseMessage.getError(), errorString, getMyPostHttpResponseMessage.getResponseData());
                            return;
                        }
                        return;
                    }
                }
                z = true;
                if (!(httpResponsedMessage instanceof GetMyPostHttpResponseMessage)) {
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
        this.k = new f(this, CmdConfigHttp.CMD_GET_MY_POST);
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
        this.k = new f(this, CmdConfigHttp.CMD_GET_MY_POST);
        SpeedStatsManager.getInstance().addStatsTimeStamp(5020);
        ConcernPageView concernPageView = new ConcernPageView(context);
        this.a = concernPageView;
        concernPageView.setConcernFragment(this);
        SpeedStatsManager.getInstance().addStatsTimeStamp(5021);
    }

    public void i2(ConcernPageView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sVar) == null) {
            this.b = sVar;
            this.a.setCallback(sVar);
        }
    }

    public void j2(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, scrollFragmentTabHost) == null) {
            this.c = scrollFragmentTabHost;
            ConcernPageView concernPageView = this.a;
            if (concernPageView != null && concernPageView.M()) {
                this.a.setScrollFragmentTabHost(scrollFragmentTabHost);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            super.onChangeSkinType(i);
            ConcernPageView concernPageView = this.a;
            if (concernPageView != null && concernPageView.M()) {
                this.a.T(i);
            }
        }
    }

    @Override // com.baidu.tieba.ee7
    public void N() {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.e && (concernPageView = this.a) != null && concernPageView.M()) {
            this.a.d0();
        }
    }

    public void f2() {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (concernPageView = this.a) != null && concernPageView.M()) {
            this.a.B();
        }
    }

    @Override // com.baidu.tieba.pma
    @NonNull
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return Integer.toString(getUniqueId().getId());
        }
        return (String) invokeV.objValue;
    }

    public void k2() {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (concernPageView = this.a) != null && concernPageView.M()) {
            this.a.c0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void notifyColourHeaderData() {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (concernPageView = this.a) != null) {
            concernPageView.R();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.a.W();
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.h);
            super.onDetach();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            this.a.setTabInForeBackgroundState(true);
            YunDialogManager.onHidden(a05.j);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5024);
            super.onResume();
            ConcernPageView concernPageView = this.a;
            if (concernPageView != null) {
                concernPageView.Y();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(5025);
        }
    }

    @Override // com.baidu.tieba.ee7
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            ConcernPageView concernPageView = this.a;
            if (concernPageView != null && concernPageView.M()) {
                this.a.T(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void g2(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        User_Info user_Info;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, str, getMyPostResIdl) == null) {
            if (i != 0) {
                showToast(str);
                return;
            }
            DataRes dataRes = getMyPostResIdl.data;
            if (dataRes != null && dataRes.thread_info != null) {
                jx4 jx4Var = new jx4();
                ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
                User.Builder builder2 = new User.Builder(builder.author);
                h2(builder2, getMyPostResIdl.data.user_info);
                User user = builder.author;
                if (user == null || TextUtils.isEmpty(user.name)) {
                    builder.author = builder2.build(true);
                }
                User user2 = builder.author;
                if (user2 != null && (user_Info = getMyPostResIdl.data.user_info) != null && user2.name.equals(user_Info.name)) {
                    builder.author = builder2.build(true);
                }
                builder.fname = WriteMsgHolder.getLastForumName();
                builder.fid = Long.valueOf(JavaTypesHelper.toLong(WriteMsgHolder.getLastForumName(), 0L));
                jx4Var.parserProtobuf(builder.build(true));
                if (jx4Var.getAuthor() != null && jx4Var.getAuthor().getUserGrowthData() != null && jx4Var.getAuthor().getUserGrowthData().a() == 0) {
                    jx4Var.getAuthor().setUserGrowthData(null);
                }
                this.a.K(jx4Var, true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public List<String> getCurrentPageSourceKeyList() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.i);
            MessageManager.getInstance().unRegisterListener(this.j);
            ConcernPageView concernPageView = this.a;
            if (concernPageView != null && concernPageView.M()) {
                this.a.V();
            }
            this.d = true;
            li5.e().b();
        }
    }

    public final void h2(User.Builder builder, User_Info user_Info) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, builder, user_Info) != null) || user_Info == null) {
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

    public void l2(tbclient.Userlike.DataRes dataRes, boolean z) {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048589, this, dataRes, z) == null) && (concernPageView = this.a) != null) {
            concernPageView.l0(dataRes, z);
        }
    }

    public void m2(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i) == null) {
            this.a.m0(str, i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.i.setTag(getBaseFragmentActivity().getUniqueId());
            this.i.setSelfListener(true);
            this.k.setSelfListener(true);
            ConcernPageView concernPageView = this.a;
            if (concernPageView != null && concernPageView.M()) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            oma.b(this, new Pair[0]);
            SpeedStatsManager.getInstance().addStatsTimeStamp(5022);
            if (this.a == null) {
                ConcernPageView concernPageView = new ConcernPageView(getContext());
                this.a = concernPageView;
                concernPageView.setConcernFragment(this);
            }
            if (this.a.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.a.getParent()).removeView(this.a);
                ConcernPageView.s sVar = this.b;
                if (sVar != null) {
                    this.a.setCallback(sVar);
                }
            }
            if (this.a.M()) {
                this.a.setPageUniqueId(getUniqueId());
                if (this.d) {
                    this.a.I();
                    this.d = false;
                }
            }
            this.a.U();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CONCERN_TAB_ON_CREATE_VIEW_END_STAMP_KEY);
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                if (!this.e) {
                    ConcernPageView concernPageView = this.a;
                    if (concernPageView != null) {
                        if (!concernPageView.M()) {
                            this.a.H(getContext());
                            this.a.removeAllViews();
                            this.a.k0();
                            this.a.I();
                            registerListener(this.f);
                            registerListener(this.h);
                            this.a.setScrollFragmentTabHost(this.c);
                            this.a.setPageUniqueId(getUniqueId());
                            registerListener(this.i);
                            registerListener(this.k);
                            registerListener(this.j);
                            this.a.setTabInForeBackgroundState(false);
                        }
                        this.a.C();
                    }
                    this.e = true;
                } else {
                    ConcernPageView concernPageView2 = this.a;
                    if (concernPageView2 != null) {
                        concernPageView2.X();
                    }
                }
                ConcernPageView concernPageView3 = this.a;
                if (concernPageView3 != null) {
                    concernPageView3.setViewForeground();
                }
                if (getContext() != null) {
                    YunDialogManager.onShow(getContext(), a05.j);
                    return;
                }
                return;
            }
            YunDialogManager.onHidden(a05.j);
            ConcernPageView concernPageView4 = this.a;
            if (concernPageView4 != null) {
                concernPageView4.a0();
            }
            f2();
        }
    }
}
