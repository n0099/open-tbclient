package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.editortools.d {
    private DataModel<?> aAU;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean aAT = false;

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void a(DataModel<?> dataModel) {
        this.aAU = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aM(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(w.e.common_color_10099);
        jVar.bC(true);
        c cVar = new c(jVar);
        cVar.a(this.aAU);
        return cVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof c) {
            com.baidu.tbadk.editortools.j CP = fVar.CP();
            m mVar = new m(this, (c) fVar, CP);
            CP.a(5, mVar);
            CP.a(4, mVar);
            CP.a(7, mVar);
            CP.a(16, mVar);
            CP.a(14, mVar);
            CP.a(15, mVar);
            CP.a(8, mVar);
            CP.a(18, mVar);
            CP.a(20, mVar);
            CP.a(10, mVar);
            CP.a(11, mVar);
            CP.a(27, mVar);
            CP.a(29, mVar);
            CP.a(36, mVar);
            CP.a(32, mVar);
            CP.a(40, mVar);
            CP.a(43, mVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        x xVar;
        com.baidu.tbadk.editortools.j CP = fVar.CP();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(CP.getContext(), 7);
        CP.b(aVar);
        aVar.azr = w.g.icon_topic_n;
        CP.b(new com.baidu.tbadk.editortools.imagetool.i(CP.getContext(), 3));
        CP.b(new com.baidu.tbadk.editortools.imagetool.b(CP.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.biI() && com.baidu.tieba.tbadkCore.s.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CP.getContext()), x.class)) != null && (xVar = (x) runTask.getData()) != null) {
            xVar.azt = 4;
            CP.b(xVar);
        }
        CP.b(new com.baidu.tbadk.editortools.a.a(CP.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, CP.getContext()), x.class);
        if (runTask2 != null && (runTask2.getData() instanceof x)) {
            x xVar2 = (x) runTask2.getData();
            xVar2.azt = 6;
            CP.b(xVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, CP.getContext()), x.class);
        if (runTask3 != null && runTask3.getData() != null) {
            x xVar3 = (x) runTask3.getData();
            xVar3.azt = 8;
            CP.b(xVar3);
        }
        CP.b(new com.baidu.tbadk.editortools.inputtool.a(CP.getContext(), true));
        CP.b(new com.baidu.tbadk.editortools.sendtool.a(CP.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, CP.getContext()), x.class);
        if (runTask4 != null && runTask4.getData() != null) {
            x xVar4 = (x) runTask4.getData();
            xVar4.azt = 9;
            CP.b(xVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        CP.u(arrayList);
        if (!"PbChosenActivity".equals(CP.getContext().getClass().getSimpleName())) {
            CP.b(new com.baidu.tbadk.editortools.b.a(CP.getContext(), 10));
        }
        CP.CQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(w.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
