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
/* loaded from: classes8.dex */
public class BarVoteModel extends BdBaseModel {
    private long fid;
    private BarVoteActivity ghC;
    private f ghD;
    public final BdUniqueId NORMAL_TYPE = BdUniqueId.gen();
    public final BdUniqueId SWITCH_TYPE = BdUniqueId.gen();
    public final BdUniqueId RELOAD_TYPE = BdUniqueId.gen();
    public int mPn = 0;
    private a ghE = null;
    private com.baidu.adp.framework.listener.a dhj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_BAR_ELECTION, 309642) { // from class: com.baidu.tieba.barselect.BarVoteModel.1
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
                    if (voteData != null && voteData.bDY() != null && (voteData.bDY().getStatus() == 1 || voteData.bDY().getStatus() == 2)) {
                        if (BarVoteModel.this.mPn == 0) {
                            BarVoteModel.this.ghD = voteData;
                            BarVoteModel.this.mPn++;
                        } else if (BarVoteModel.this.ghD != null && voteData.bDY() != null && ((voteData.bDY().getStatus() == 1 || voteData.bDY().getStatus() == 2) && BarVoteModel.this.ghD.bDW() != null && voteData.bDW() != null)) {
                            BarVoteModel.this.ghD.bDW().addAll(voteData.bDW());
                            BarVoteModel.this.ghD.setHasMore(voteData.getHasMore());
                            BarVoteModel.this.mPn++;
                        }
                    }
                    if (BarVoteModel.this.ghE != null) {
                        BarVoteModel.this.ghE.a(responsedMessage.getError(), responsedMessage.getErrorString(), BarVoteModel.this.ghD);
                    }
                } else if (responsedMessage.getOrginalMessage().getTag() == BarVoteModel.this.RELOAD_TYPE) {
                    if (voteData != null && voteData.bDY() != null && ((voteData.bDY().getStatus() == 1 || voteData.bDY().getStatus() == 2) && BarVoteModel.this.mPn == 0)) {
                        BarVoteModel.this.ghD = voteData;
                        BarVoteModel.this.mPn++;
                    }
                    if (BarVoteModel.this.ghE != null) {
                        BarVoteModel.this.ghE.a(responsedMessage.getError(), responsedMessage.getErrorString(), BarVoteModel.this.ghD);
                    }
                } else if (responsedMessage.getOrginalMessage().getTag() == BarVoteModel.this.SWITCH_TYPE) {
                    if (voteData == null || voteData.bDY() == null) {
                        if (BarVoteModel.this.ghC != null) {
                            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.barselect.BarVoteModel.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    BarVoteModel.this.bDH();
                                }
                            }, 5000L);
                        }
                    } else if (voteData.bDY().getStatus() == com.baidu.tieba.barselect.a.d.glL) {
                        BarVoteModel.this.ghD = voteData;
                        BarVoteModel.this.mPn = 1;
                        if (BarVoteModel.this.ghE != null) {
                            BarVoteModel.this.ghE.a(responsedMessage.getError(), responsedMessage.getErrorString(), BarVoteModel.this.ghD);
                        }
                    } else if (BarVoteModel.this.ghC != null) {
                        com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.barselect.BarVoteModel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BarVoteModel.this.bDH();
                            }
                        }, 5000L);
                    }
                }
            }
        }
    };
    private HttpMessageListener ghF = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.barselect.BarVoteModel.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            boolean z;
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage instanceof CommitVoteResMsg) && BarVoteModel.this.ghD != null && BarVoteModel.this.ghD.bDY() != null && BarVoteModel.this.ghC != null && httpResponsedMessage.getOrginalMessage().getTag() == BarVoteModel.this.ghC.mPageId) {
                int error = httpResponsedMessage.getError();
                if (error == 0) {
                    BarVoteModel.this.ghD.bDY().lm(false);
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if ((orginalMessage instanceof CommitVoteReqMsg) && BarVoteModel.this.ghD.bDW() != null && ((CommitVoteReqMsg) orginalMessage).candidate_uid != 0) {
                        boolean z2 = false;
                        for (com.baidu.tieba.barselect.data.d dVar : BarVoteModel.this.ghD.bDW()) {
                            if (dVar.getUid() == ((CommitVoteReqMsg) orginalMessage).candidate_uid) {
                                dVar.ry(dVar.bDN() + 1);
                                z = true;
                            } else {
                                z = z2;
                            }
                            z2 = z;
                        }
                        if (BarVoteModel.this.ghD.bDX() != null && BarVoteModel.this.ghD.bDX().getUid() == ((CommitVoteReqMsg) orginalMessage).candidate_uid) {
                            BarVoteModel.this.ghD.bDX().ry(BarVoteModel.this.ghD.bDX().bDN() + 1);
                            z2 = true;
                        }
                        if (BarVoteModel.this.ghE != null && z2) {
                            l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                            BarVoteModel.this.ghE.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), BarVoteModel.this.ghD);
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
                    AntiHelper.a(BarVoteModel.this.ghC, blockPopInfoData);
                } else {
                    l.showToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, String str, com.baidu.tieba.barselect.data.f fVar);
    }

    public BarVoteModel(BarVoteActivity barVoteActivity) {
        this.ghC = barVoteActivity;
        this.fid = this.ghC.getIntent().getLongExtra("fid", 0L);
        registerListener(this.dhj);
        registerListener(this.ghF);
        refresh();
    }

    public void n(BdUniqueId bdUniqueId) {
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
        this.ghE = aVar;
    }

    public void blb() {
        n(this.NORMAL_TYPE);
    }

    public void bDH() {
        n(this.SWITCH_TYPE);
    }

    public void refresh() {
        if (j.isNetworkAvailableForImmediately()) {
            n(this.RELOAD_TYPE);
        } else {
            this.ghC.bls();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dhj);
        MessageManager.getInstance().unRegisterListener(this.ghF);
    }
}
