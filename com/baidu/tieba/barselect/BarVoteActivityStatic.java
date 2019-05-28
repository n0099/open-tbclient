package com.baidu.tieba.barselect;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.core.atomData.IdentityReviewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.barselect.data.VoteElectionHttpResMessage;
import com.baidu.tieba.barselect.data.VoteElectionSocketResMessage;
import com.baidu.tieba.barselect.idCard.CameraActivity;
import com.baidu.tieba.barselect.idCard.IdentityReviewActivity;
/* loaded from: classes3.dex */
public class BarVoteActivityStatic {
    static {
        aHr();
        aWt();
        aWu();
        aWx();
        aWv();
        aWw();
        aWy();
        aWz();
    }

    private static void aHr() {
        com.baidu.tieba.tbadkCore.a.a.a(309642, VoteElectionSocketResMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BAR_ELECTION, com.baidu.tieba.tbadkCore.a.a.bn("c/f/bawu/electionInfo", 309642));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(VoteElectionHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aWt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BAR_VOTE, TbConfig.SERVER_ADDRESS + "c/c/bawu/commitVote");
        tbHttpMessageTask.setResponsedClass(CommitVoteResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedLogin(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aWu() {
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

    private static void aWv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921412, new CustomMessageTask.CustomRunnable<CameraActivityConfig>() { // from class: com.baidu.tieba.barselect.BarVoteActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<CameraActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().getIntent() != null) {
                    customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra(IntentConfig.REQUEST_CODE, 0), CameraActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aWw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921413, new CustomMessageTask.CustomRunnable<IdentityReviewActivityConfig>() { // from class: com.baidu.tieba.barselect.BarVoteActivityStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IdentityReviewActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    if (customMessage.getData().getIntent() != null && customMessage.getData().getIntent().getBooleanExtra(IdentityReviewActivityConfig.KEY_IS_START_FOR_RESULT, false)) {
                        customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra(IntentConfig.REQUEST_CODE, 0), IdentityReviewActivity.class);
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

    private static void aWx() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921411, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.barselect.BarVoteActivityStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof com.baidu.tieba.pb.d)) {
                    com.baidu.tieba.pb.d dVar = (com.baidu.tieba.pb.d) customMessage.getData();
                    CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(dVar.bPw(), dVar.getForumId(), dVar.getThreadId(), dVar.getSource());
                    commitVoteReqMsg.setTag(dVar.bPv());
                    MessageManager.getInstance().sendMessage(commitVoteReqMsg);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aWy() {
        ba.aiz().a(new ba.a() { // from class: com.baidu.tieba.barselect.BarVoteActivityStatic.5
            @Override // com.baidu.tbadk.core.util.ba.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.startsWith("tieba://election?")) {
                    long c = com.baidu.adp.lib.g.b.c(ae.ce(str, "fid="), 0L);
                    if (c != 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(c, 4)));
                        return 0;
                    }
                }
                return 3;
            }
        });
    }

    private static void aWz() {
        ba.aiz().a(new ba.a() { // from class: com.baidu.tieba.barselect.BarVoteActivityStatic.6
            @Override // com.baidu.tbadk.core.util.ba.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.startsWith("tieba://idcard?")) {
                    long c = com.baidu.adp.lib.g.b.c(ae.ce(str, "fid="), 0L);
                    if (c != 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921413, new IdentityReviewActivityConfig(tbPageContext.getPageActivity(), c, 25042)));
                        return 0;
                    }
                }
                return 3;
            }
        });
    }
}
