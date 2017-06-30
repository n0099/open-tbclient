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
    private DataModel<?> aCa;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean aBZ = false;

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
        this.aCa = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aR(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(w.e.common_color_10099);
        jVar.bC(true);
        c cVar = new c(jVar);
        cVar.a(this.aCa);
        return cVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof c) {
            com.baidu.tbadk.editortools.j CG = fVar.CG();
            m mVar = new m(this, (c) fVar, CG);
            CG.a(5, mVar);
            CG.a(4, mVar);
            CG.a(7, mVar);
            CG.a(16, mVar);
            CG.a(14, mVar);
            CG.a(15, mVar);
            CG.a(8, mVar);
            CG.a(18, mVar);
            CG.a(20, mVar);
            CG.a(10, mVar);
            CG.a(11, mVar);
            CG.a(27, mVar);
            CG.a(29, mVar);
            CG.a(36, mVar);
            CG.a(32, mVar);
            CG.a(40, mVar);
            CG.a(43, mVar);
            CG.a(45, mVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        x xVar;
        com.baidu.tbadk.editortools.j CG = fVar.CG();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(CG.getContext(), 7);
        CG.b(aVar);
        aVar.aAw = w.g.icon_topic_n;
        CG.b(new com.baidu.tbadk.editortools.imagetool.i(CG.getContext(), 3));
        CG.b(new com.baidu.tbadk.editortools.imagetool.b(CG.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.bnz() && com.baidu.tieba.tbadkCore.r.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CG.getContext()), x.class)) != null && (xVar = (x) runTask.getData()) != null) {
            xVar.aAy = 4;
            CG.b(xVar);
        }
        CG.b(new com.baidu.tbadk.editortools.a.a(CG.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, CG.getContext()), x.class);
        if (runTask2 != null && (runTask2.getData() instanceof x)) {
            x xVar2 = (x) runTask2.getData();
            xVar2.aAy = 6;
            CG.b(xVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, CG.getContext()), x.class);
        if (runTask3 != null && runTask3.getData() != null) {
            x xVar3 = (x) runTask3.getData();
            xVar3.aAy = 8;
            CG.b(xVar3);
        }
        CG.b(new com.baidu.tbadk.editortools.inputtool.a(CG.getContext(), true));
        CG.b(new com.baidu.tbadk.editortools.sendtool.a(CG.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, CG.getContext()), x.class);
        if (runTask4 != null && runTask4.getData() != null) {
            x xVar4 = (x) runTask4.getData();
            xVar4.aAy = 9;
            CG.b(xVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        CG.x(arrayList);
        if (!"PbChosenActivity".equals(CG.getContext().getClass().getSimpleName())) {
            CG.b(new com.baidu.tbadk.editortools.b.a(CG.getContext(), 10));
        }
        CG.CH();
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
