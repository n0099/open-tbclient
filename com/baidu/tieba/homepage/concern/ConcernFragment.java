package com.baidu.tieba.homepage.concern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.q.y0;
import c.a.r0.k3.r0.g;
import c.a.r0.x0.n0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
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
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public class ConcernFragment extends BaseFragment implements n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ConcernPageView f52058e;

    /* renamed from: f  reason: collision with root package name */
    public ConcernPageView.l f52059f;

    /* renamed from: g  reason: collision with root package name */
    public ScrollFragmentTabHost f52060g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52061h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52062i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f52063j;
    public final AntiHelper.k k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final c.a.e.c.g.a n;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernFragment f52064a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ConcernFragment concernFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernFragment, Integer.valueOf(i2)};
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
            this.f52064a = concernFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f48113c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(this.f52064a.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (AntiHelper.t(this.f52064a.getActivity(), updateAttentionMessage.getData().l, this.f52064a.k) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().f48111a && updateAttentionMessage.getData().f48114d) {
                    l.L(this.f52064a.getActivity(), R.string.attention_success);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernFragment f52065a;

        public b(ConcernFragment concernFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52065a = concernFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernFragment f52066a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ConcernFragment concernFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernFragment, Integer.valueOf(i2)};
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
            this.f52066a = concernFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f52066a.f52058e != null && this.f52066a.f52058e.isInit()) {
                this.f52066a.f52058e.onScreenSizeChange();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernFragment f52067a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f52068e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f52069f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f52070g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ long f52071h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ d f52072i;

            public a(d dVar, PostWriteCallBackData postWriteCallBackData, long j2, long j3, long j4) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, postWriteCallBackData, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52072i = dVar;
                this.f52068e = postWriteCallBackData;
                this.f52069f = j2;
                this.f52070g = j3;
                this.f52071h = j4;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int k = l.k(TbadkCoreApplication.getInst());
                    int i2 = l.i(TbadkCoreApplication.getInst());
                    float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                    int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                    RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                    requestGetMyPostNetMessage.setProZone(this.f52068e.getProZone());
                    requestGetMyPostNetMessage.setParams(this.f52069f, this.f52070g, this.f52071h, k, i2, f2, i3);
                    requestGetMyPostNetMessage.setCallFrom(1);
                    this.f52072i.f52067a.sendMessage(requestGetMyPostNetMessage);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ConcernFragment concernFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernFragment, Integer.valueOf(i2)};
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
            this.f52067a = concernFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostWriteCallBackData postWriteCallBackData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || (postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData()) == null) {
                return;
            }
            long g2 = c.a.e.e.m.b.g(postWriteCallBackData.getPostId(), 0L);
            long g3 = c.a.e.e.m.b.g(postWriteCallBackData.getThreadId(), 0L);
            long g4 = c.a.e.e.m.b.g(g.j().k(), 0L);
            if (g2 != 0 && g3 != 0 && g4 != 0) {
                c.a.e.e.m.e.a().postDelayed(new a(this, postWriteCallBackData, g3, g2, g4), 1000L);
            } else if (StringUtils.isNull(postWriteCallBackData.getVideoid())) {
            } else {
                WriteData writeData = postWriteCallBackData.writeDataForVideo;
                y0 y0Var = new y0();
                y0Var.O2(writeData);
                if (this.f52067a.f52058e == null || !this.f52067a.f52058e.isInit()) {
                    return;
                }
                this.f52067a.f52058e.insertOneThread(y0Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernFragment f52073a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ConcernFragment concernFragment, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernFragment, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f52073a = concernFragment;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
        @Override // c.a.e.c.g.a
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
                            errorString2 = this.f52073a.getResources().getString(R.string.neterror);
                        } else {
                            errorString2 = getMyPostHttpResponseMessage.getErrorString();
                        }
                        if (z || getMyPostHttpResponseMessage.getError() == 0) {
                            this.f52073a.d(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                            return;
                        }
                        return;
                    } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                        GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                            errorString = this.f52073a.getResources().getString(R.string.neterror);
                        } else {
                            errorString = getMyPostSocketResponseMessage.getErrorString();
                        }
                        if (z || getMyPostSocketResponseMessage.getError() == 0) {
                            this.f52073a.d(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
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

    public ConcernFragment() {
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
        this.f52061h = false;
        this.f52063j = new a(this, 2001115);
        this.k = new b(this);
        this.l = new c(this, 2921414);
        this.m = new d(this, 2001383);
        this.n = new e(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    }

    @Override // c.a.r0.x0.n0
    public void changeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            ConcernPageView concernPageView = this.f52058e;
            if (concernPageView == null || !concernPageView.isInit()) {
                return;
            }
            this.f52058e.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void completePullRefresh() {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (concernPageView = this.f52058e) != null && concernPageView.isInit()) {
            this.f52058e.completePullRefresh();
        }
    }

    public final void d(int i2, String str, GetMyPostResIdl getMyPostResIdl) {
        User_Info user_Info;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, str, getMyPostResIdl) == null) {
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
            e(builder2, getMyPostResIdl.data.user_info);
            User user = builder.author;
            if (user == null || TextUtils.isEmpty(user.name)) {
                builder.author = builder2.build(true);
            }
            User user2 = builder.author;
            if (user2 != null && (user_Info = getMyPostResIdl.data.user_info) != null && user2.name.equals(user_Info.name)) {
                builder.author = builder2.build(true);
            }
            builder.fname = g.j().l();
            builder.fid = Long.valueOf(c.a.e.e.m.b.g(g.j().l(), 0L));
            y0Var.Y2(builder.build(true));
            this.f52058e.insertOneThread(y0Var);
        }
    }

    public final void e(User.Builder builder, User_Info user_Info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, builder, user_Info) == null) || user_Info == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a038" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.q0.o0.a
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
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.m.setTag(getBaseFragmentActivity().getUniqueId());
            this.m.setSelfListener(true);
            this.n.getHttpMessageListener().setSelfListener(true);
            this.n.getSocketMessageListener().setSelfListener(true);
            ConcernPageView concernPageView = this.f52058e;
            if (concernPageView == null || !concernPageView.isInit()) {
                return;
            }
            registerListener(this.m);
            registerListener(this.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            ConcernPageView concernPageView = this.f52058e;
            if (concernPageView == null || !concernPageView.isInit()) {
                return;
            }
            this.f52058e.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5022);
            if (this.f52058e.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f52058e.getParent()).removeView(this.f52058e);
                ConcernPageView.l lVar = this.f52059f;
                if (lVar != null) {
                    this.f52058e.setCallback(lVar);
                }
            }
            if (this.f52058e.isInit()) {
                this.f52058e.setPageUniqueId(getUniqueId());
                if (this.f52061h) {
                    this.f52058e.initListeners();
                    this.f52061h = false;
                }
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.CONCERN_TAB_ON_CREATE_VIEW_END_STAMP_KEY);
            return this.f52058e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.m);
            ConcernPageView concernPageView = this.f52058e;
            if (concernPageView != null && concernPageView.isInit()) {
                this.f52058e.onDestroy();
            }
            this.f52061h = true;
            TbadkCoreApplication.getInst().getPersonalizeViewData().a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f52063j);
            MessageManager.getInstance().unRegisterListener(this.l);
            super.onDetach();
        }
    }

    @Override // c.a.r0.x0.n0
    public void onPageOutEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // c.a.r0.x0.n0
    public void onPageStartIn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            this.f52058e.setTabInForeBackgroundState(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                if (!this.f52062i) {
                    ConcernPageView concernPageView = this.f52058e;
                    if (concernPageView != null) {
                        if (!concernPageView.isInit()) {
                            this.f52058e.init(getContext());
                            if (!c.a.q0.b.d.C()) {
                                this.f52058e.removeAllViews();
                                this.f52058e.showRealView();
                            }
                            this.f52058e.initListeners();
                            registerListener(this.f52063j);
                            registerListener(this.l);
                            this.f52058e.setScrollFragmentTabHost(this.f52060g);
                            this.f52058e.setPageUniqueId(getUniqueId());
                            registerListener(this.m);
                            registerListener(this.n);
                            this.f52058e.setTabInForeBackgroundState(false);
                        }
                        this.f52058e.firstLoad();
                    }
                    this.f52062i = true;
                }
                this.f52058e.setViewForeground();
                return;
            }
            this.f52058e.onViewBackGround();
            completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(5024);
            super.onResume();
            ConcernPageView concernPageView = this.f52058e;
            if (concernPageView != null) {
                concernPageView.onResume();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(5025);
        }
    }

    @Override // c.a.r0.x0.n0
    public void refreshPage() {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f52062i && (concernPageView = this.f52058e) != null && concernPageView.isInit()) {
            this.f52058e.reload();
        }
    }

    public void setCallback(ConcernPageView.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, lVar) == null) {
            this.f52059f = lVar;
            this.f52058e.setCallback(lVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, scrollFragmentTabHost) == null) {
            this.f52060g = scrollFragmentTabHost;
            ConcernPageView concernPageView = this.f52058e;
            if (concernPageView == null || !concernPageView.isInit()) {
                return;
            }
            this.f52058e.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void setVideoThreadId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
        }
    }

    public void startRedDotLoad() {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (concernPageView = this.f52058e) != null && concernPageView.isInit()) {
            this.f52058e.redDotLoad();
        }
    }

    public void updateData(tbclient.Userlike.DataRes dataRes, boolean z) {
        ConcernPageView concernPageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048597, this, dataRes, z) == null) || (concernPageView = this.f52058e) == null) {
            return;
        }
        concernPageView.updateData(dataRes, z);
    }

    public void updateError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, str, i2) == null) {
            this.f52058e.updateError(str, i2);
        }
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52061h = false;
        this.f52063j = new a(this, 2001115);
        this.k = new b(this);
        this.l = new c(this, 2921414);
        this.m = new d(this, 2001383);
        this.n = new e(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        SpeedStatsManager.getInstance().addStatsTimeStamp(5020);
        this.f52058e = new ConcernPageView(context);
        SpeedStatsManager.getInstance().addStatsTimeStamp(5021);
    }
}
