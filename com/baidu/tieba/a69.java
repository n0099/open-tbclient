package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.immessagecenter.mention.AtMessageFragment;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.mention.ReplyMeModel;
import com.baidu.tieba.p55;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.u69;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a69 extends BdBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataModel<MessageCenterActivity> A;
    public NewWriteModel.d B;
    public ReplyMeModel C;
    public Runnable D;
    public final ReplyMeModel.b E;
    public AtMessageFragment a;
    public PbListView b;
    public NoDataView c;
    public m69 d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public NavigationBarShadowView g;
    public ViewGroup h;
    public q55 i;
    public u69 j;
    public boolean k;
    public ReplyPrivacyCheckController l;
    public AttentionHostData m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public final p55.g q;
    public RecyclerView.OnScrollListener r;
    public u69.a s;
    public final RecyclerView.OnScrollListener t;
    public hh5 u;
    public n69 v;
    public String w;
    public String x;
    public long y;
    public long z;

    public void k0(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, newsNotifyMessage) != null) || newsNotifyMessage == null) {
        }
    }

    public void m0(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, errorData) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class k extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinearSmoothScroller a;
        public final /* synthetic */ a69 b;

        /* loaded from: classes5.dex */
        public class a extends LinearSmoothScroller {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int getVerticalSnapPreference() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return -1;
                }
                return invokeV.intValue;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(k kVar, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Context) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(a69 a69Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a69Var;
            this.a = new a(this, this.b.mContext.getContext());
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, recyclerView, state, i) == null) {
                this.a.setTargetPosition(i);
                startSmoothScroll(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends DataModel<MessageCenterActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String S() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String T() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String U() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean X() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean Y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean Z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean cancelLoadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getFromForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean loadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(a69 a69Var, BdPageContext bdPageContext) {
            super(bdPageContext);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var, bdPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((BdPageContext) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String Q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.v != null) {
                    return this.a.v.o();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String R() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.v != null) {
                    return this.a.v.x();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.a.w;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData V(String str) {
            InterceptResult invokeL;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                WriteData writeData = new WriteData();
                writeData.setForumId(this.a.w);
                writeData.setForumName(this.a.x);
                writeData.setThreadId(this.a.v.x());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (this.a.v.B()) {
                    if (this.a.y > 0) {
                        str3 = String.valueOf(this.a.y);
                    } else {
                        str3 = this.a.v.l().n;
                    }
                    writeData.setFloor(str3);
                } else {
                    writeData.setFloor(this.a.v.o());
                }
                if (this.a.z > 0) {
                    writeData.setRepostId(String.valueOf(this.a.z));
                    if (this.a.v.B()) {
                        str2 = String.valueOf(this.a.z);
                    } else {
                        str2 = null;
                    }
                    writeData.setReSubPostId(str2);
                }
                if (this.a.v != null) {
                    writeData.setBaijiahaoData(this.a.v.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }
            return (WriteData) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public b(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) != null) || this.a.a.getBaseFragmentActivity() == null) {
                return;
            }
            this.a.a.getBaseFragmentActivity().hideProgressBar();
            this.a.u.a().v();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                this.a.l.setLikeUserData(this.a.m);
                this.a.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                return;
            }
            if (postWriteCallBackData != null && o95Var == null && !AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                this.a.a.showToast(postWriteCallBackData.getErrorString());
            }
            if (z && postWriteCallBackData != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
                statisticItem.param("tid", postWriteCallBackData.getPostId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 8);
                xo5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a.mContext.getPageActivity());
                if (currentVisiblePageExtra != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements bh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public c(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // com.baidu.tieba.bh5
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.getBaseFragmentActivity() != null) {
                this.a.a.getBaseFragmentActivity().showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public d(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.u != null) {
                this.a.u.B();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public e(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.u != null && this.a.u.v() != null) {
                BdUtilHelper.showSoftKeyPad(this.a.getPageContext().getPageActivity(), this.a.u.v().k());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ReplyMeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public f(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // com.baidu.tieba.immessagecenter.mention.ReplyMeModel.b
        public void a(long j, long j2, long j3, String str, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4)}) != null) {
                return;
            }
            this.a.w = String.valueOf(j);
            this.a.x = str;
            this.a.y = j2;
            this.a.z = j3;
            this.a.r0();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public g(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null && this.a.a != null) {
                this.a.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.b.G(null);
                this.a.b.U();
                this.a.a.a3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements p55.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public h(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // com.baidu.tieba.p55.g
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if (this.a.a != null) {
                        this.a.a.c3();
                    }
                } else if (this.a.e != null) {
                    this.a.e.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public i(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i != 0) {
                    if (i == 1 || i == 2) {
                        this.a.g.c();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.a.g.c();
                } else {
                    this.a.g.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends mm6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 b;

        public j(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a69Var;
        }

        @Override // com.baidu.tieba.mm6
        public void a(View view2, BaseCardInfo baseCardInfo) {
            long j;
            int i;
            BaijiahaoData baijiahaoData;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, baseCardInfo) == null) && view2 != null && (baseCardInfo instanceof n69)) {
                n69 n69Var = (n69) baseCardInfo;
                if (n69Var.z() && view2.getId() != R.id.obfuscated_res_0x7f091d58 && view2.getId() != R.id.user_name) {
                    n69Var.E(false);
                    this.b.h0();
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f091823) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f09065b) {
                        Object tag = view2.getTag(R.id.item_data);
                        if (tag instanceof Boolean) {
                            String p = n69Var.p();
                            if (((Boolean) tag).booleanValue()) {
                                this.b.a.V2(n69Var, p);
                                return;
                            } else if (n69Var.getThreadType() == 40) {
                                this.b.a.Z2(n69Var, true, p);
                                return;
                            } else {
                                this.b.a.X2(n69Var, p);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.b.v = n69Var;
                if (n69Var.B()) {
                    j = JavaTypesHelper.toLong(n69Var.p(), 0L);
                } else {
                    j = JavaTypesHelper.toLong(n69Var.o(), 0L);
                }
                long j2 = j;
                int i2 = 2;
                if (this.b.u != null && this.b.mContext != null) {
                    if (n69Var.k() != null && n69Var.q() != null) {
                        String userName = UtilHelper.getUserName(n69Var.s());
                        if (n69Var.k().size() <= 2) {
                            if (n69Var.k().size() > 1 && n69Var.k().get(1) != null) {
                                str2 = ty5.I(n69Var.k().get(1).content).toString();
                            } else {
                                str2 = this.b.mContext.getString(R.string.obfuscated_res_0x7f0f1688);
                                i2 = 1;
                            }
                        } else if (n69Var.k().get(2) != null) {
                            str2 = ty5.I(n69Var.k().get(2).content).toString();
                        } else {
                            str2 = null;
                        }
                        this.b.u.q(this.b.mContext.getString(R.string.obfuscated_res_0x7f0f1282) + userName + this.b.mContext.getString(R.string.obfuscated_res_0x7f0f1686) + str2);
                    }
                    this.b.u.X(this.b.v.o());
                    hh5 hh5Var = this.b.u;
                    if (n69Var.B()) {
                        str = this.b.v.o();
                    } else {
                        str = null;
                    }
                    hh5Var.f0(str);
                    i = i2;
                } else {
                    i = 2;
                }
                if (this.b.m == null) {
                    this.b.m = new AttentionHostData();
                }
                if (this.b.v != null) {
                    this.b.m.parserWithMetaData(this.b.v.u());
                }
                if (this.b.v != null) {
                    baijiahaoData = this.b.v.getBaijiahaoData();
                } else {
                    baijiahaoData = null;
                }
                this.b.C.R(j2, i, n69Var.d(), n69Var.x(), baijiahaoData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public m(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.b.G(null);
                this.a.b.R();
                this.a.a.a3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements u69.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public n(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // com.baidu.tieba.u69.a
        public void onClose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.j != null) {
                this.a.f.removeHeaderView(this.a.j.a());
                this.a.o = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a69 a;

        public o(a69 a69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a69Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i != 0 && this.a.u != null) {
                    this.a.u.B();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a69(AtMessageFragment atMessageFragment) {
        super(atMessageFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atMessageFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = R.color.CAM_X0204;
        this.o = false;
        this.p = new g(this);
        this.q = new h(this);
        this.r = new i(this);
        this.s = new n(this);
        this.t = new o(this);
        this.C = null;
        this.D = new e(this);
        this.E = new f(this);
        this.a = atMessageFragment;
        this.l = new ReplyPrivacyCheckController(atMessageFragment.getPageContext());
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            hh5 hh5Var = this.u;
            if (hh5Var != null && hh5Var.a() != null) {
                this.u.a().F(i2);
            }
            PbListView pbListView = this.b;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                this.b.e(i2);
            }
            q55 q55Var = this.i;
            if (q55Var != null) {
                q55Var.D(i2);
            }
            NoDataView noDataView = this.c;
            if (noDataView != null) {
                noDataView.f(this.mContext, i2);
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            h0();
            SkinManager.setBackgroundColor(this.f, this.n);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            u69 u69Var = this.j;
            if (u69Var != null) {
                u69Var.b(i2, false);
            }
        }
    }

    public void b0(int i2) {
        m69 m69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (m69Var = this.d) != null) {
            m69Var.a(i2);
        }
    }

    public void o0(aj ajVar) {
        m69 m69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, ajVar) == null) && (m69Var = this.d) != null) {
            m69Var.f(ajVar);
        }
    }

    public void p0(zi ziVar) {
        m69 m69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, ziVar) == null) && (m69Var = this.d) != null) {
            m69Var.d(ziVar);
        }
    }

    public void q0(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && this.e != null) {
            if (z && (bdTypeRecyclerView = this.f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
                this.f.setSelection(0);
            }
            this.e.setRefreshing(z);
        }
    }

    public final void a0() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a.getContext()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        if (areNotificationsEnabled) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        statisticItem.param("obj_type", i2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            u69 u69Var = this.j;
            if (u69Var != null) {
                this.f.removeHeaderView(u69Var.a());
                this.o = false;
            }
        } else if (!this.o && u69.d()) {
            if (this.j == null) {
                u69 u69Var2 = new u69(this.a.getPageContext(), false);
                this.j = u69Var2;
                u69Var2.c(this.s);
            }
            this.f.addHeaderView(this.j.a(), 0);
            this.o = true;
        }
    }

    public BdSwipeRefreshLayout c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (BdSwipeRefreshLayout) invokeV.objValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.A = new a(this, a5.a(this.a.getPageContext().getContext()));
            this.B = new b(this);
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            a0();
        }
    }

    public void h0() {
        m69 m69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (m69Var = this.d) != null) {
            m69Var.c();
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            a0();
        }
    }

    public final void d0(int i2, Intent intent) {
        ve5 ve5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, intent) == null) {
            this.u.a().y();
            this.u.B();
            this.u.a().I();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (!(serializableExtra instanceof PbEditorData)) {
                return;
            }
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            this.u.E(writeData);
            this.u.h0(pbEditorData.getVoiceModel());
            ue5 u = this.u.a().u(6);
            if (u != null && (ve5Var = u.m) != null) {
                ve5Var.U(new he5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.u.J();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.D);
            hh5 hh5Var = this.u;
            if (hh5Var != null) {
                hh5Var.G();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.l;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController2 = this.l;
            if (replyPrivacyCheckController2 != null) {
                replyPrivacyCheckController2.setAttentionCallback(null);
            }
            ReplyMeModel replyMeModel = this.C;
            if (replyMeModel != null) {
                replyMeModel.S(null);
                this.C.onDestroy();
            }
        }
    }

    public final void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            hh5 hh5Var = this.u;
            if (hh5Var != null && hh5Var.a() != null && this.u.a().getParent() != null) {
                ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
            }
            hh5 hh5Var2 = (hh5) new ih5(z).a(this.a.getPageContext().getPageActivity());
            this.u = hh5Var2;
            hh5Var2.R(this.a.getPageContext());
            this.u.e0(this.A);
            this.u.S(3);
            this.u.C(this.a.getPageContext());
            this.u.a().M(true);
            this.u.a().F(TbadkCoreApplication.getInst().getSkinType());
            if (this.u.a() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                this.h.addView(this.u.a(), layoutParams);
                this.u.a().v();
            }
            this.u.Y(new c(this));
            this.u.U(this.B);
            if (this.u.a() != null) {
                this.u.a().setOnCancelClickListener(new d(this));
            }
        }
    }

    public boolean i0(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, intent)) == null) {
            hh5 hh5Var = this.u;
            if (hh5Var != null) {
                if (i2 == 12005) {
                    hh5Var.n0();
                    SafeHandler.getInst().postDelayed(this.D, 300L);
                }
                this.u.F(i2, i3, intent);
            }
            if (i2 == 25035) {
                d0(i3, intent);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public View j0(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            if (viewGroup == null) {
                return null;
            }
            this.h = viewGroup;
            this.g = (NavigationBarShadowView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0919ca);
            if (this.i == null) {
                q55 q55Var = new q55(this.a.getPageContext());
                this.i = q55Var;
                q55Var.a(this.q);
            }
            this.i.W(this.a.getUniqueId());
            if (this.b == null) {
                PbListView pbListView = new PbListView(this.a.getContext());
                this.b = pbListView;
                pbListView.c();
            }
            this.b.s(R.color.CAM_X0205);
            this.b.v();
            this.b.w(BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds182));
            this.b.B();
            this.b.L(R.dimen.tbfontsize33);
            this.b.J(SkinManager.getColor(R.color.CAM_X0109));
            this.b.F(R.color.CAM_X0110);
            this.b.G(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.h.findViewById(R.id.obfuscated_res_0x7f09030c);
            this.e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.i);
            this.f = (BdTypeRecyclerView) this.h.findViewById(R.id.obfuscated_res_0x7f09030f);
            m69 m69Var = new m69(this.a.getPageContext(), this.f);
            this.d = m69Var;
            m69Var.g(new j(this));
            ((DefaultItemAnimator) this.f.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f.setLayoutManager(new k(this, this.mContext.getContext()));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.setRecyclerListener(new l(this));
            this.f.setOnSrollToBottomListener(new m(this));
            this.f.setOnScrollListener(this.t);
            this.f.addOnScrollListener(this.r);
            g0();
            ReplyMeModel replyMeModel = new ReplyMeModel(this.a.getPageContext());
            this.C = replyMeModel;
            replyMeModel.S(this.E);
            f0();
            e0(false);
            return this.h;
        }
        return (View) invokeL.objValue;
    }

    public void n0(boolean z, ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048590, this, z, arrayList) != null) || this.f == null) {
            return;
        }
        this.e.setVisibility(0);
        q0(false);
        if (z) {
            this.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.g();
            this.b.G(this.p);
        } else {
            this.b.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.g();
            this.b.H(this.mContext.getResources().getString(R.string.list_no_more));
            this.b.G(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.c == null) {
                this.c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0cc0)), null);
                this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            if (this.c.getParent() == null && !this.k) {
                this.k = true;
                this.f.addHeaderView(this.c);
                this.c.setVisibility(0);
                this.c.f(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f.setNextPage(null);
            if (arrayList != null) {
                this.d.e(arrayList);
            }
            this.n = R.color.CAM_X0205;
            this.e.setEnabled(false);
        } else {
            this.f.removeHeaderView(this.c);
            this.k = false;
            m69 m69Var = this.d;
            if (m69Var != null) {
                m69Var.e(arrayList);
                this.d.c();
            }
            this.f.setNextPage(this.b);
            this.n = R.color.CAM_X0204;
        }
        a0();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void r0() {
        n69 n69Var;
        n69 n69Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            n69 n69Var3 = this.v;
            if (n69Var3 != null && n69Var3.getBaijiahaoData() != null && this.v.isBjh()) {
                hh5 hh5Var = this.u;
                if (hh5Var == null || !hh5Var.s) {
                    e0(true);
                }
                if (this.u != null && (n69Var2 = this.v) != null) {
                    if (n69Var2.B() && this.v.s() != null) {
                        this.u.o0(this.v.s().getName_show(), this.v.s().getPortrait());
                        return;
                    } else {
                        this.u.o0(null, null);
                        return;
                    }
                }
                return;
            }
            hh5 hh5Var2 = this.u;
            if (hh5Var2 == null || hh5Var2.s) {
                e0(false);
            }
            if (this.u != null && (n69Var = this.v) != null) {
                if (n69Var.B() && this.v.s() != null) {
                    this.u.o0(this.v.s().getName_show(), this.v.s().getPortrait());
                } else {
                    this.u.o0(null, null);
                }
            }
        }
    }
}
