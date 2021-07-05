package com.baidu.tieba.barselect;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.VoteElectionHttpResMessage;
import com.baidu.tieba.barselect.data.VoteElectionRequestMessage;
import com.baidu.tieba.barselect.data.VoteElectionSocketResMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.e;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.s0.x.b.d;
import d.a.s0.x.b.f;
/* loaded from: classes5.dex */
public class BarVoteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId NORMAL_TYPE;
    public final BdUniqueId RELOAD_TYPE;
    public final BdUniqueId SWITCH_TYPE;

    /* renamed from: e  reason: collision with root package name */
    public BarVoteActivity f14310e;

    /* renamed from: f  reason: collision with root package name */
    public f f14311f;

    /* renamed from: g  reason: collision with root package name */
    public c f14312g;

    /* renamed from: h  reason: collision with root package name */
    public long f14313h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f14314i;
    public HttpMessageListener j;
    public int mPn;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BarVoteModel f14315a;

        /* renamed from: com.baidu.tieba.barselect.BarVoteModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0192a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f14316e;

            public RunnableC0192a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14316e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f14316e.f14315a.C();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f14317e;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14317e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f14317e.f14315a.C();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BarVoteModel barVoteModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {barVoteModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f14315a = barVoteModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f voteData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (responsedMessage instanceof VoteElectionHttpResMessage) {
                voteData = ((VoteElectionHttpResMessage) responsedMessage).getVoteData();
            } else if (!(responsedMessage instanceof VoteElectionSocketResMessage)) {
                return;
            } else {
                voteData = ((VoteElectionSocketResMessage) responsedMessage).getVoteData();
            }
            if (responsedMessage.getOrginalMessage().getTag() == this.f14315a.NORMAL_TYPE) {
                if (voteData != null && voteData.a() != null && (voteData.a().g() == 1 || voteData.a().g() == 2)) {
                    BarVoteModel barVoteModel = this.f14315a;
                    if (barVoteModel.mPn == 0) {
                        barVoteModel.f14311f = voteData;
                        this.f14315a.mPn++;
                    } else if (barVoteModel.f14311f != null && voteData.a() != null && ((voteData.a().g() == 1 || voteData.a().g() == 2) && this.f14315a.f14311f.b() != null && voteData.b() != null)) {
                        this.f14315a.f14311f.b().addAll(voteData.b());
                        this.f14315a.f14311f.j(voteData.d());
                        this.f14315a.mPn++;
                    }
                }
                if (this.f14315a.f14312g != null) {
                    this.f14315a.f14312g.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f14315a.f14311f);
                }
            } else if (responsedMessage.getOrginalMessage().getTag() == this.f14315a.RELOAD_TYPE) {
                if (voteData != null && voteData.a() != null && (voteData.a().g() == 1 || voteData.a().g() == 2)) {
                    BarVoteModel barVoteModel2 = this.f14315a;
                    if (barVoteModel2.mPn == 0) {
                        barVoteModel2.f14311f = voteData;
                        this.f14315a.mPn++;
                    }
                }
                if (this.f14315a.f14312g != null) {
                    this.f14315a.f14312g.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f14315a.f14311f);
                }
            } else if (responsedMessage.getOrginalMessage().getTag() == this.f14315a.SWITCH_TYPE) {
                if (voteData == null || voteData.a() == null) {
                    if (this.f14315a.f14310e != null) {
                        e.a().postDelayed(new b(this), 5000L);
                    }
                } else if (voteData.a().g() == d.a.s0.x.e.c.f69388c) {
                    this.f14315a.f14311f = voteData;
                    BarVoteModel barVoteModel3 = this.f14315a;
                    barVoteModel3.mPn = 1;
                    if (barVoteModel3.f14312g != null) {
                        this.f14315a.f14312g.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f14315a.f14311f);
                    }
                } else if (this.f14315a.f14310e != null) {
                    e.a().postDelayed(new RunnableC0192a(this), 5000L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BarVoteModel f14318a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BarVoteModel barVoteModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {barVoteModel, Integer.valueOf(i2)};
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
            this.f14318a = barVoteModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage instanceof CommitVoteResMsg) || this.f14318a.f14311f == null || this.f14318a.f14311f.a() == null || this.f14318a.f14310e == null || httpResponsedMessage.getOrginalMessage().getTag() != this.f14318a.f14310e.mPageId) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (error != 0) {
                if (error == 3250023) {
                    d.a.s0.h3.n0.f.b(error, "", null);
                    return;
                } else if (error == 3250021) {
                    d.a.s0.h3.n0.f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
                    return;
                } else if (error != 3250002 && error != 3250004) {
                    l.M(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                    return;
                } else {
                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                    blockPopInfoData.block_info = k.isEmpty(httpResponsedMessage.getErrorString()) ? TbadkCoreApplication.getInst().getString(R.string.block_user_tip) : httpResponsedMessage.getErrorString();
                    blockPopInfoData.ahead_info = TbadkCoreApplication.getInst().getString(R.string.block_user_feed);
                    blockPopInfoData.ok_info = TbadkCoreApplication.getInst().getString(R.string.know);
                    blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                    AntiHelper.s(this.f14318a.f14310e, blockPopInfoData);
                    return;
                }
            }
            boolean z = false;
            this.f14318a.f14311f.a().k(false);
            Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
            if (!(orginalMessage instanceof CommitVoteReqMsg) || this.f14318a.f14311f.b() == null) {
                return;
            }
            CommitVoteReqMsg commitVoteReqMsg = (CommitVoteReqMsg) orginalMessage;
            if (commitVoteReqMsg.candidate_uid != 0) {
                for (d dVar : this.f14318a.f14311f.b()) {
                    if (dVar.l() == commitVoteReqMsg.candidate_uid) {
                        dVar.D(dVar.m() + 1);
                        z = true;
                    }
                }
                if (this.f14318a.f14311f.f() != null && this.f14318a.f14311f.f().l() == commitVoteReqMsg.candidate_uid) {
                    this.f14318a.f14311f.f().D(this.f14318a.f14311f.f().m() + 1);
                    z = true;
                }
                if (this.f14318a.f14312g == null || !z) {
                    return;
                }
                l.L(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                this.f14318a.f14312g.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f14318a.f14311f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i2, String str, f fVar);
    }

    public BarVoteModel(BarVoteActivity barVoteActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {barVoteActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.NORMAL_TYPE = BdUniqueId.gen();
        this.SWITCH_TYPE = BdUniqueId.gen();
        this.RELOAD_TYPE = BdUniqueId.gen();
        this.mPn = 0;
        this.f14312g = null;
        this.f14314i = new a(this, CmdConfigHttp.CMD_BAR_ELECTION, 309642);
        this.j = new b(this, CmdConfigHttp.CMD_BAR_VOTE);
        this.f14310e = barVoteActivity;
        this.f14313h = barVoteActivity.getIntent().getLongExtra("fid", 0L);
        registerListener(this.f14314i);
        registerListener(this.j);
        refresh();
    }

    public void A(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) {
            VoteElectionRequestMessage voteElectionRequestMessage = new VoteElectionRequestMessage();
            voteElectionRequestMessage.setFid(this.f14313h);
            if (bdUniqueId == this.NORMAL_TYPE) {
                voteElectionRequestMessage.setPn(this.mPn + 1);
            } else if (bdUniqueId == this.SWITCH_TYPE) {
                voteElectionRequestMessage.setPn(1);
            } else if (bdUniqueId != this.RELOAD_TYPE) {
                return;
            } else {
                this.mPn = 0;
                voteElectionRequestMessage.setPn(1);
            }
            voteElectionRequestMessage.setRn(50);
            voteElectionRequestMessage.setTag(bdUniqueId);
            sendMessage(voteElectionRequestMessage);
        }
    }

    public void B(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f14312g = cVar;
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            A(this.SWITCH_TYPE);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            A(this.NORMAL_TYPE);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f14314i);
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (j.A()) {
                A(this.RELOAD_TYPE);
            } else {
                this.f14310e.showNetRefreshView();
            }
        }
    }
}
