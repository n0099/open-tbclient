package com.baidu.tieba.barselect;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
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
import d.a.c.e.m.e;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.k0.v.b.d;
import d.a.k0.v.b.f;
/* loaded from: classes4.dex */
public class BarVoteModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public BarVoteActivity f14181e;

    /* renamed from: f  reason: collision with root package name */
    public f f14182f;

    /* renamed from: h  reason: collision with root package name */
    public long f14184h;
    public final BdUniqueId NORMAL_TYPE = BdUniqueId.gen();
    public final BdUniqueId SWITCH_TYPE = BdUniqueId.gen();
    public final BdUniqueId RELOAD_TYPE = BdUniqueId.gen();
    public int mPn = 0;

    /* renamed from: g  reason: collision with root package name */
    public c f14183g = null;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f14185i = new a(CmdConfigHttp.CMD_BAR_ELECTION, 309642);
    public HttpMessageListener j = new b(CmdConfigHttp.CMD_BAR_VOTE);

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {

        /* renamed from: com.baidu.tieba.barselect.BarVoteModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0168a implements Runnable {
            public RunnableC0168a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BarVoteModel.this.A();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BarVoteModel.this.A();
            }
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f voteData;
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (responsedMessage instanceof VoteElectionHttpResMessage) {
                voteData = ((VoteElectionHttpResMessage) responsedMessage).getVoteData();
            } else if (!(responsedMessage instanceof VoteElectionSocketResMessage)) {
                return;
            } else {
                voteData = ((VoteElectionSocketResMessage) responsedMessage).getVoteData();
            }
            if (responsedMessage.getOrginalMessage().getTag() == BarVoteModel.this.NORMAL_TYPE) {
                if (voteData != null && voteData.a() != null && (voteData.a().g() == 1 || voteData.a().g() == 2)) {
                    BarVoteModel barVoteModel = BarVoteModel.this;
                    if (barVoteModel.mPn == 0) {
                        barVoteModel.f14182f = voteData;
                        BarVoteModel.this.mPn++;
                    } else if (barVoteModel.f14182f != null && voteData.a() != null && ((voteData.a().g() == 1 || voteData.a().g() == 2) && BarVoteModel.this.f14182f.b() != null && voteData.b() != null)) {
                        BarVoteModel.this.f14182f.b().addAll(voteData.b());
                        BarVoteModel.this.f14182f.j(voteData.d());
                        BarVoteModel.this.mPn++;
                    }
                }
                if (BarVoteModel.this.f14183g != null) {
                    BarVoteModel.this.f14183g.a(responsedMessage.getError(), responsedMessage.getErrorString(), BarVoteModel.this.f14182f);
                }
            } else if (responsedMessage.getOrginalMessage().getTag() == BarVoteModel.this.RELOAD_TYPE) {
                if (voteData != null && voteData.a() != null && (voteData.a().g() == 1 || voteData.a().g() == 2)) {
                    BarVoteModel barVoteModel2 = BarVoteModel.this;
                    if (barVoteModel2.mPn == 0) {
                        barVoteModel2.f14182f = voteData;
                        BarVoteModel.this.mPn++;
                    }
                }
                if (BarVoteModel.this.f14183g != null) {
                    BarVoteModel.this.f14183g.a(responsedMessage.getError(), responsedMessage.getErrorString(), BarVoteModel.this.f14182f);
                }
            } else if (responsedMessage.getOrginalMessage().getTag() == BarVoteModel.this.SWITCH_TYPE) {
                if (voteData == null || voteData.a() == null) {
                    if (BarVoteModel.this.f14181e != null) {
                        e.a().postDelayed(new b(), 5000L);
                    }
                } else if (voteData.a().g() == d.a.k0.v.e.c.f62345c) {
                    BarVoteModel.this.f14182f = voteData;
                    BarVoteModel barVoteModel3 = BarVoteModel.this;
                    barVoteModel3.mPn = 1;
                    if (barVoteModel3.f14183g != null) {
                        BarVoteModel.this.f14183g.a(responsedMessage.getError(), responsedMessage.getErrorString(), BarVoteModel.this.f14182f);
                    }
                } else if (BarVoteModel.this.f14181e != null) {
                    e.a().postDelayed(new RunnableC0168a(), 5000L);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage instanceof CommitVoteResMsg) || BarVoteModel.this.f14182f == null || BarVoteModel.this.f14182f.a() == null || BarVoteModel.this.f14181e == null || httpResponsedMessage.getOrginalMessage().getTag() != BarVoteModel.this.f14181e.mPageId) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (error != 0) {
                if (error == 3250023) {
                    d.a.k0.d3.n0.f.b(error, "", null);
                    return;
                } else if (error == 3250021) {
                    d.a.k0.d3.n0.f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
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
                    AntiHelper.s(BarVoteModel.this.f14181e, blockPopInfoData);
                    return;
                }
            }
            boolean z = false;
            BarVoteModel.this.f14182f.a().k(false);
            Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
            if (!(orginalMessage instanceof CommitVoteReqMsg) || BarVoteModel.this.f14182f.b() == null) {
                return;
            }
            CommitVoteReqMsg commitVoteReqMsg = (CommitVoteReqMsg) orginalMessage;
            if (commitVoteReqMsg.candidate_uid != 0) {
                for (d dVar : BarVoteModel.this.f14182f.b()) {
                    if (dVar.l() == commitVoteReqMsg.candidate_uid) {
                        dVar.D(dVar.m() + 1);
                        z = true;
                    }
                }
                if (BarVoteModel.this.f14182f.f() != null && BarVoteModel.this.f14182f.f().l() == commitVoteReqMsg.candidate_uid) {
                    BarVoteModel.this.f14182f.f().D(BarVoteModel.this.f14182f.f().m() + 1);
                    z = true;
                }
                if (BarVoteModel.this.f14183g == null || !z) {
                    return;
                }
                l.L(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                BarVoteModel.this.f14183g.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), BarVoteModel.this.f14182f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2, String str, f fVar);
    }

    public BarVoteModel(BarVoteActivity barVoteActivity) {
        this.f14181e = barVoteActivity;
        this.f14184h = barVoteActivity.getIntent().getLongExtra("fid", 0L);
        registerListener(this.f14185i);
        registerListener(this.j);
        x();
    }

    public void A() {
        y(this.SWITCH_TYPE);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f14185i);
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    public void w() {
        y(this.NORMAL_TYPE);
    }

    public void x() {
        if (j.A()) {
            y(this.RELOAD_TYPE);
        } else {
            this.f14181e.showNetRefreshView();
        }
    }

    public void y(BdUniqueId bdUniqueId) {
        VoteElectionRequestMessage voteElectionRequestMessage = new VoteElectionRequestMessage();
        voteElectionRequestMessage.setFid(this.f14184h);
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

    public void z(c cVar) {
        this.f14183g = cVar;
    }
}
