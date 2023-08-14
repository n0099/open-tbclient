package com.baidu.tieba.barselect;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.bi;
import com.baidu.tieba.hg6;
import com.baidu.tieba.jg6;
import com.baidu.tieba.sg6;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.yca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BarVoteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId NORMAL_TYPE;
    public final BdUniqueId RELOAD_TYPE;
    public final BdUniqueId SWITCH_TYPE;
    public BarVoteActivity a;
    public jg6 b;
    public c c;
    public long d;
    public NetMessageListener e;
    public HttpMessageListener f;
    public int mPn;

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i, String str, jg6 jg6Var);
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BarVoteModel a;

        /* renamed from: com.baidu.tieba.barselect.BarVoteModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0252a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0252a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.T();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.T();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BarVoteModel barVoteModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {barVoteModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = barVoteModel;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            jg6 voteData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (responsedMessage instanceof VoteElectionHttpResMessage) {
                    voteData = ((VoteElectionHttpResMessage) responsedMessage).getVoteData();
                } else if (responsedMessage instanceof VoteElectionSocketResMessage) {
                    voteData = ((VoteElectionSocketResMessage) responsedMessage).getVoteData();
                } else {
                    return;
                }
                if (responsedMessage.getOrginalMessage().getTag() == this.a.NORMAL_TYPE) {
                    if (voteData != null && voteData.a() != null && (voteData.a().h() == 1 || voteData.a().h() == 2)) {
                        BarVoteModel barVoteModel = this.a;
                        if (barVoteModel.mPn != 0) {
                            if (barVoteModel.b != null && voteData.a() != null && ((voteData.a().h() == 1 || voteData.a().h() == 2) && this.a.b.b() != null && voteData.b() != null)) {
                                this.a.b.b().addAll(voteData.b());
                                this.a.b.j(voteData.d());
                                this.a.mPn++;
                            }
                        } else {
                            barVoteModel.b = voteData;
                            this.a.mPn++;
                        }
                    }
                    if (this.a.c != null) {
                        this.a.c.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.b);
                    }
                } else if (responsedMessage.getOrginalMessage().getTag() == this.a.RELOAD_TYPE) {
                    if (voteData != null && voteData.a() != null && (voteData.a().h() == 1 || voteData.a().h() == 2)) {
                        BarVoteModel barVoteModel2 = this.a;
                        if (barVoteModel2.mPn == 0) {
                            barVoteModel2.b = voteData;
                            this.a.mPn++;
                        }
                    }
                    if (this.a.c != null) {
                        this.a.c.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.b);
                    }
                } else if (responsedMessage.getOrginalMessage().getTag() == this.a.SWITCH_TYPE) {
                    if (voteData != null && voteData.a() != null) {
                        if (voteData.a().h() != sg6.c) {
                            if (this.a.a != null) {
                                SafeHandler.getInst().postDelayed(new RunnableC0252a(this), 5000L);
                                return;
                            }
                            return;
                        }
                        this.a.b = voteData;
                        BarVoteModel barVoteModel3 = this.a;
                        barVoteModel3.mPn = 1;
                        if (barVoteModel3.c != null) {
                            this.a.c.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.b);
                        }
                    } else if (this.a.a != null) {
                        SafeHandler.getInst().postDelayed(new b(this), 5000L);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BarVoteModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BarVoteModel barVoteModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {barVoteModel, Integer.valueOf(i)};
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
            this.a = barVoteModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage instanceof CommitVoteResMsg) && this.a.b != null && this.a.b.a() != null && this.a.a != null && httpResponsedMessage.getOrginalMessage().getTag() == this.a.a.a) {
                int error = httpResponsedMessage.getError();
                if (error == 0) {
                    boolean z = false;
                    this.a.b.a().m(false);
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if ((orginalMessage instanceof CommitVoteReqMsg) && this.a.b.b() != null) {
                        CommitVoteReqMsg commitVoteReqMsg = (CommitVoteReqMsg) orginalMessage;
                        if (commitVoteReqMsg.candidate_uid != 0) {
                            for (hg6 hg6Var : this.a.b.b()) {
                                if (hg6Var.l() == commitVoteReqMsg.candidate_uid) {
                                    hg6Var.D(hg6Var.m() + 1);
                                    z = true;
                                }
                            }
                            if (this.a.b.f() != null && this.a.b.f().l() == commitVoteReqMsg.candidate_uid) {
                                this.a.b.f().D(this.a.b.f().m() + 1);
                                z = true;
                            }
                            if (this.a.c != null && z) {
                                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                                this.a.c.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.b);
                            }
                        }
                    }
                } else if (error == 3250023) {
                    yca.b(error, "", null);
                } else if (error == 3250021) {
                    yca.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
                } else if (error != 3250002 && error != 3250004) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                } else {
                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                    if (bi.isEmpty(httpResponsedMessage.getErrorString())) {
                        errorString = TbadkCoreApplication.getInst().getString(R.string.block_user_tip);
                    } else {
                        errorString = httpResponsedMessage.getErrorString();
                    }
                    blockPopInfoData.block_info = errorString;
                    blockPopInfoData.ahead_info = TbadkCoreApplication.getInst().getString(R.string.block_user_feed);
                    blockPopInfoData.ok_info = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b3e);
                    blockPopInfoData.ahead_url = AntiHelper.a;
                    AntiHelper.s(this.a.a, blockPopInfoData);
                }
            }
        }
    }

    public BarVoteModel(BarVoteActivity barVoteActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {barVoteActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.NORMAL_TYPE = BdUniqueId.gen();
        this.SWITCH_TYPE = BdUniqueId.gen();
        this.RELOAD_TYPE = BdUniqueId.gen();
        this.mPn = 0;
        this.c = null;
        this.e = new a(this, CmdConfigHttp.CMD_BAR_ELECTION, 309642);
        this.f = new b(this, CmdConfigHttp.CMD_BAR_VOTE);
        this.a = barVoteActivity;
        this.d = barVoteActivity.getIntent().getLongExtra("fid", 0L);
        registerListener(this.e);
        registerListener(this.f);
        refresh();
    }

    public void S(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.c = cVar;
        }
    }

    public void R(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) {
            VoteElectionRequestMessage voteElectionRequestMessage = new VoteElectionRequestMessage();
            voteElectionRequestMessage.setFid(this.d);
            if (bdUniqueId == this.NORMAL_TYPE) {
                voteElectionRequestMessage.setPn(this.mPn + 1);
            } else if (bdUniqueId == this.SWITCH_TYPE) {
                voteElectionRequestMessage.setPn(1);
            } else if (bdUniqueId == this.RELOAD_TYPE) {
                this.mPn = 0;
                voteElectionRequestMessage.setPn(1);
            } else {
                return;
            }
            voteElectionRequestMessage.setRn(50);
            voteElectionRequestMessage.setTag(bdUniqueId);
            sendMessage(voteElectionRequestMessage);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            R(this.SWITCH_TYPE);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            R(this.NORMAL_TYPE);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            MessageManager.getInstance().unRegisterListener(this.f);
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                R(this.RELOAD_TYPE);
            } else {
                this.a.y1();
            }
        }
    }
}
