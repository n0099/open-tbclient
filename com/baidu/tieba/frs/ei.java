package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ei implements View.OnClickListener {
    final /* synthetic */ eh blT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(eh ehVar) {
        this.blT = ehVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ax axVar;
        BaseActivity baseActivity;
        com.baidu.tbadk.core.data.ax axVar2;
        com.baidu.tbadk.core.data.ax axVar3;
        BaseActivity baseActivity2;
        com.baidu.tbadk.core.data.ax axVar4;
        com.baidu.tbadk.core.data.ax axVar5;
        com.baidu.tbadk.core.data.ax axVar6;
        com.baidu.tbadk.core.data.ax axVar7;
        com.baidu.tbadk.core.data.ax axVar8;
        com.baidu.tbadk.core.data.ax axVar9;
        BaseActivity baseActivity3;
        BaseActivity baseActivity4;
        com.baidu.tbadk.core.data.ax axVar10;
        com.baidu.tbadk.core.data.ax axVar11;
        com.baidu.tbadk.core.data.ax axVar12;
        com.baidu.tbadk.core.data.ax axVar13;
        com.baidu.tbadk.core.data.ax axVar14;
        axVar = this.blT.aab;
        if (axVar.re() == 2) {
            axVar4 = this.blT.aab;
            if (axVar4.qF() != null) {
                axVar5 = this.blT.aab;
                String qE = axVar5.qF().qE();
                if (StringUtils.isNull(qE)) {
                    axVar14 = this.blT.aab;
                    qE = axVar14.qF().getTaskId();
                }
                axVar6 = this.blT.aab;
                String valueOf = String.valueOf(axVar6.getFid());
                axVar7 = this.blT.aab;
                String qP = axVar7.qP();
                axVar8 = this.blT.aab;
                String threadId = axVar8.qF().getThreadId();
                StringBuilder sb = new StringBuilder("tieba.baidu.com/p/");
                axVar9 = this.blT.aab;
                a.a("frs", null, "CLICK", valueOf, qP, threadId, null, sb.append(axVar9.qF().getThreadId()).toString(), qE);
                if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
                    baseActivity3 = this.blT.bek;
                    baseActivity4 = this.blT.bek;
                    InterviewLiveActivityConfig interviewLiveActivityConfig = new InterviewLiveActivityConfig(baseActivity4.getPageContext().getPageActivity());
                    axVar10 = this.blT.aab;
                    String threadId2 = axVar10.qF().getThreadId();
                    axVar11 = this.blT.aab;
                    String taskId = axVar11.qF().getTaskId();
                    axVar12 = this.blT.aab;
                    String forumId = axVar12.qF().getForumId();
                    axVar13 = this.blT.aab;
                    baseActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, interviewLiveActivityConfig.createNormalCfg(threadId2, taskId, forumId, axVar13.qF().getForumName())));
                    return;
                }
            }
        }
        baseActivity = this.blT.bek;
        PbActivityConfig pbActivityConfig = new PbActivityConfig(baseActivity.getPageContext().getPageActivity());
        axVar2 = this.blT.aab;
        axVar3 = this.blT.aab;
        PbActivityConfig createFromThreadCfg = pbActivityConfig.createFromThreadCfg(axVar2, axVar3.qP(), null, 18003, true, false, false);
        baseActivity2 = this.blT.bek;
        baseActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
    }
}
