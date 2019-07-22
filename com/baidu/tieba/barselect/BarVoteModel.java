package com.baidu.tieba.barselect;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.data.VoteElectionHttpResMessage;
import com.baidu.tieba.barselect.data.VoteElectionRequestMessage;
import com.baidu.tieba.barselect.data.VoteElectionSocketResMessage;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
/* loaded from: classes3.dex */
public class BarVoteModel extends BdBaseModel {
    private BarVoteActivity euL;
    private f euM;
    private long fid;
    public final BdUniqueId NORMAL_TYPE = BdUniqueId.gen();
    public final BdUniqueId SWITCH_TYPE = BdUniqueId.gen();
    public final BdUniqueId RELOAD_TYPE = BdUniqueId.gen();
    public int mPn = 0;
    private a euN = null;
    private com.baidu.adp.framework.listener.a bzb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_BAR_ELECTION, 309642) { // from class: com.baidu.tieba.barselect.BarVoteModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f voteData;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                if (responsedMessage instanceof VoteElectionHttpResMessage) {
                    voteData = ((VoteElectionHttpResMessage) responsedMessage).getVoteData();
                } else if (responsedMessage instanceof VoteElectionSocketResMessage) {
                    voteData = ((VoteElectionSocketResMessage) responsedMessage).getVoteData();
                } else {
                    return;
                }
                if (responsedMessage.getOrginalMessage().getTag() == BarVoteModel.this.NORMAL_TYPE) {
                    if (voteData != null && voteData.aYP() != null && (voteData.aYP().getStatus() == 1 || voteData.aYP().getStatus() == 2)) {
                        if (BarVoteModel.this.mPn == 0) {
                            BarVoteModel.this.euM = voteData;
                            BarVoteModel.this.mPn++;
                        } else if (BarVoteModel.this.euM != null && voteData.aYP() != null && ((voteData.aYP().getStatus() == 1 || voteData.aYP().getStatus() == 2) && BarVoteModel.this.euM.aYN() != null && voteData.aYN() != null)) {
                            BarVoteModel.this.euM.aYN().addAll(voteData.aYN());
                            BarVoteModel.this.euM.setHasMore(voteData.getHasMore());
                            BarVoteModel.this.mPn++;
                        }
                    }
                    if (BarVoteModel.this.euN != null) {
                        BarVoteModel.this.euN.a(responsedMessage.getError(), responsedMessage.getErrorString(), BarVoteModel.this.euM);
                    }
                } else if (responsedMessage.getOrginalMessage().getTag() == BarVoteModel.this.RELOAD_TYPE) {
                    if (voteData != null && voteData.aYP() != null && ((voteData.aYP().getStatus() == 1 || voteData.aYP().getStatus() == 2) && BarVoteModel.this.mPn == 0)) {
                        BarVoteModel.this.euM = voteData;
                        BarVoteModel.this.mPn++;
                    }
                    if (BarVoteModel.this.euN != null) {
                        BarVoteModel.this.euN.a(responsedMessage.getError(), responsedMessage.getErrorString(), BarVoteModel.this.euM);
                    }
                } else if (responsedMessage.getOrginalMessage().getTag() == BarVoteModel.this.SWITCH_TYPE) {
                    if (voteData == null || voteData.aYP() == null) {
                        if (BarVoteModel.this.euL != null) {
                            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.barselect.BarVoteModel.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    BarVoteModel.this.aYw();
                                }
                            }, 5000L);
                        }
                    } else if (voteData.aYP().getStatus() == com.baidu.tieba.barselect.a.d.eyX) {
                        BarVoteModel.this.euM = voteData;
                        BarVoteModel.this.mPn = 1;
                        if (BarVoteModel.this.euN != null) {
                            BarVoteModel.this.euN.a(responsedMessage.getError(), responsedMessage.getErrorString(), BarVoteModel.this.euM);
                        }
                    } else if (BarVoteModel.this.euL != null) {
                        com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.barselect.BarVoteModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BarVoteModel.this.aYw();
                            }
                        }, 5000L);
                    }
                }
            }
        }
    };
    private HttpMessageListener euO = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.barselect.BarVoteModel.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            boolean z;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage instanceof CommitVoteResMsg) && BarVoteModel.this.euM != null && BarVoteModel.this.euM.aYP() != null && BarVoteModel.this.euL != null && httpResponsedMessage.getOrginalMessage().getTag() == BarVoteModel.this.euL.mPageId) {
                int error = httpResponsedMessage.getError();
                if (error == 0) {
                    BarVoteModel.this.euM.aYP().iu(false);
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if ((orginalMessage instanceof CommitVoteReqMsg) && BarVoteModel.this.euM.aYN() != null && ((CommitVoteReqMsg) orginalMessage).candidate_uid != 0) {
                        boolean z2 = false;
                        for (com.baidu.tieba.barselect.data.d dVar : BarVoteModel.this.euM.aYN()) {
                            if (dVar.getUid() == ((CommitVoteReqMsg) orginalMessage).candidate_uid) {
                                dVar.ps(dVar.aYC() + 1);
                                z = true;
                            } else {
                                z = z2;
                            }
                            z2 = z;
                        }
                        if (BarVoteModel.this.euM.aYO() != null && BarVoteModel.this.euM.aYO().getUid() == ((CommitVoteReqMsg) orginalMessage).candidate_uid) {
                            BarVoteModel.this.euM.aYO().ps(BarVoteModel.this.euM.aYO().aYC() + 1);
                            z2 = true;
                        }
                        if (BarVoteModel.this.euN != null && z2) {
                            l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                            BarVoteModel.this.euN.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), BarVoteModel.this.euM);
                        }
                    }
                } else if (error == 3250023) {
                    com.baidu.tieba.tbadkCore.util.f.a(error, "", (f.a) null);
                } else if (error == 3250021) {
                    com.baidu.tieba.tbadkCore.util.f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), (f.a) null);
                } else if (error == 3250002 || error == 3250004) {
                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                    blockPopInfoData.block_info = aq.isEmpty(httpResponsedMessage.getErrorString()) ? TbadkCoreApplication.getInst().getString(R.string.block_user_tip) : httpResponsedMessage.getErrorString();
                    blockPopInfoData.ahead_info = TbadkCoreApplication.getInst().getString(R.string.block_user_feed);
                    blockPopInfoData.ok_info = TbadkCoreApplication.getInst().getString(R.string.know);
                    blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                    AntiHelper.a(BarVoteModel.this.euL, blockPopInfoData);
                } else {
                    l.showToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, com.baidu.tieba.barselect.data.f fVar);
    }

    public BarVoteModel(BarVoteActivity barVoteActivity) {
        this.euL = barVoteActivity;
        this.fid = this.euL.getIntent().getLongExtra("fid", 0L);
        registerListener(this.bzb);
        registerListener(this.euO);
        refresh();
    }

    public void m(BdUniqueId bdUniqueId) {
        VoteElectionRequestMessage voteElectionRequestMessage = new VoteElectionRequestMessage();
        voteElectionRequestMessage.setFid(this.fid);
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

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.euN = aVar;
    }

    public void aIQ() {
        m(this.NORMAL_TYPE);
    }

    public void aYw() {
        m(this.SWITCH_TYPE);
    }

    public void refresh() {
        if (j.jQ()) {
            m(this.RELOAD_TYPE);
        } else {
            this.euL.aJg();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bzb);
        MessageManager.getInstance().unRegisterListener(this.euO);
    }
}
