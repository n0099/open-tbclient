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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.data.CommitVoteReqMsg;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.barselect.data.VoteElectionHttpResMessage;
import com.baidu.tieba.barselect.data.VoteElectionSocketResMessage;
import com.baidu.tieba.barselect.idCard.CameraActivity;
import com.baidu.tieba.barselect.idCard.IdentityReviewActivity;
import d.b.h0.z0.n0;
/* loaded from: classes4.dex */
public class BarVoteActivityStatic {

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<BarVoteActivityConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<BarVoteActivityConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(BarVoteActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<CameraActivityConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<CameraActivityConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null && customMessage.getData().getIntent() != null) {
                customMessage.getData().startActivityForResult(customMessage.getData().getIntent().getIntExtra("request_code", 0), CameraActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements CustomMessageTask.CustomRunnable<IdentityReviewActivityConfig> {
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
    }

    /* loaded from: classes4.dex */
    public static class d implements CustomMessageTask.CustomRunnable {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage customMessage) {
            if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof d.b.i0.d2.d)) {
                d.b.i0.d2.d dVar = (d.b.i0.d2.d) customMessage.getData();
                CommitVoteReqMsg commitVoteReqMsg = new CommitVoteReqMsg(dVar.a(), dVar.b(), dVar.d(), dVar.c());
                commitVoteReqMsg.setTag(dVar.e());
                MessageManager.getInstance().sendMessage(commitVoteReqMsg);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_BAR_VOTE)) {
                    long f2 = d.b.c.e.m.b.f(n0.c(str, "fid="), 0L);
                    if (f2 != 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(f2, 4)));
                        return 0;
                    }
                }
            }
            return 3;
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (str.startsWith(UrlSchemaHelper.SCHEME_TYPE_ID_CARD)) {
                    long f2 = d.b.c.e.m.b.f(n0.c(str, "fid="), 0L);
                    if (f2 != 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921413, new IdentityReviewActivityConfig(tbPageContext.getPageActivity(), f2, 25042)));
                        return 0;
                    }
                }
            }
            return 3;
        }
    }

    static {
        h();
        e();
        c();
        f();
        d();
        g();
        a();
        b();
    }

    public static void a() {
        UrlManager.getInstance().addListener(new e());
    }

    public static void b() {
        UrlManager.getInstance().addListener(new f());
    }

    public static void c() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921408, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void d() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921412, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void e() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BAR_VOTE, TbConfig.SERVER_ADDRESS + "c/c/bawu/commitVote");
        tbHttpMessageTask.setResponsedClass(CommitVoteResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void f() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921411, new d());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void g() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921413, new c());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void h() {
        d.b.i0.d3.d0.a.h(309642, VoteElectionSocketResMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BAR_ELECTION, d.b.i0.d3.d0.a.a("c/f/bawu/electionInfo", 309642));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(VoteElectionHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
