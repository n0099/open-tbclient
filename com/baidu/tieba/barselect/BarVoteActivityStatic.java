package com.baidu.tieba.barselect;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.core.atomData.IdentityReviewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ai;
import com.baidu.tieba.barselect.data.VoteElectionHttpResMessage;
import com.baidu.tieba.barselect.data.VoteElectionSocketResMessage;
import com.baidu.tieba.barselect.idCard.CameraActivity;
import com.baidu.tieba.barselect.idCard.IdentityReviewActivity;
/* loaded from: classes15.dex */
public class BarVoteActivityStatic {
    static {
        bFB();
        cau();
        cav();
        cay();
        caw();
        cax();
        caz();
        caA();
    }

    private static void bFB() {
        com.baidu.tieba.tbadkCore.a.a.a(309642, VoteElectionSocketResMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BAR_ELECTION, com.baidu.tieba.tbadkCore.a.a.bH("c/f/bawu/electionInfo", 309642));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(VoteElectionHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cau() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BAR_VOTE, TbConfig.SERVER_ADDRESS + "c/c/bawu/commitVote");
        tbHttpMessageTask.setResponsedClass(CommitVoteResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cav() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921408, new CustomMessageTask.CustomRunnable<BarVoteActivityConfig>() { // from class: com.baidu.tieba.barselect.BarVoteActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<BarVoteActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(BarVoteActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void caw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921412, new CustomMessageTask.CustomRunnable<CameraActivityConfig>() { // from class: com.baidu.tieba.barselect.BarVoteActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<CameraActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().getIntent() != null) {
                    customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra("request_code", 0), CameraActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cax() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921413, new CustomMessageTask.CustomRunnable<IdentityReviewActivityConfig>() { // from class: com.baidu.tieba.barselect.BarVoteActivityStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IdentityReviewActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    if (customMessage.getData().getIntent() != null && customMessage.getData().getIntent().getBooleanExtra(IdentityReviewActivityConfig.KEY_IS_START_FOR_RESULT, false)) {
                        customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra("request_code", 0), IdentityReviewActivity.class);
                    } else {
                        customMessage.getData().startActivity(IdentityReviewActivity.class);
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cay() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921411, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.barselect.BarVoteActivityStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof com.baidu.tieba.pb.d)) {
                    com.baidu.tieba.pb.d dVar = (com.baidu.tieba.pb.d) customMessage.getData();
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(dVar.cUY(), dVar.getForumId(), dVar.getThreadId(), dVar.cUX());
                    commitVoteReqMsg.setTag(dVar.cUW());
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void caz() {
        be.bju().a(new be.a() { // from class: com.baidu.tieba.barselect.BarVoteActivityStatic.5
            @Override // com.baidu.tbadk.core.util.be.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.startsWith("tieba://election?")) {
                    long j = com.baidu.adp.lib.f.b.toLong(ai.getMatchStringFromURL(str, "fid="), 0L);
                    if (j != 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(j, 4)));
                        return 0;
                    }
                }
                return 3;
            }
        });
    }

    private static void caA() {
        be.bju().a(new be.a() { // from class: com.baidu.tieba.barselect.BarVoteActivityStatic.6
            @Override // com.baidu.tbadk.core.util.be.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.startsWith("tieba://idcard?")) {
                    long j = com.baidu.adp.lib.f.b.toLong(ai.getMatchStringFromURL(str, "fid="), 0L);
                    if (j != 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921413, new IdentityReviewActivityConfig(tbPageContext.getPageActivity(), j, RequestResponseCode.REQUEST_DO_YUANPACKAGE_PAY)));
                        return 0;
                    }
                }
                return 3;
            }
        });
    }
}
