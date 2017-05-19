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
    private DataModel<?> aBl;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean aBk = false;

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
        this.aBl = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aR(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(w.e.common_color_10099);
        jVar.bE(true);
        c cVar = new c(jVar);
        cVar.a(this.aBl);
        return cVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof c) {
            com.baidu.tbadk.editortools.j Cs = fVar.Cs();
            m mVar = new m(this, (c) fVar, Cs);
            Cs.a(5, mVar);
            Cs.a(4, mVar);
            Cs.a(7, mVar);
            Cs.a(16, mVar);
            Cs.a(14, mVar);
            Cs.a(15, mVar);
            Cs.a(8, mVar);
            Cs.a(18, mVar);
            Cs.a(20, mVar);
            Cs.a(10, mVar);
            Cs.a(11, mVar);
            Cs.a(27, mVar);
            Cs.a(29, mVar);
            Cs.a(36, mVar);
            Cs.a(32, mVar);
            Cs.a(40, mVar);
            Cs.a(43, mVar);
            Cs.a(45, mVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        x xVar;
        com.baidu.tbadk.editortools.j Cs = fVar.Cs();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(Cs.getContext(), 7);
        Cs.b(aVar);
        aVar.azH = w.g.icon_topic_n;
        Cs.b(new com.baidu.tbadk.editortools.imagetool.i(Cs.getContext(), 3));
        Cs.b(new com.baidu.tbadk.editortools.imagetool.b(Cs.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.bhR() && com.baidu.tieba.tbadkCore.r.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Cs.getContext()), x.class)) != null && (xVar = (x) runTask.getData()) != null) {
            xVar.azJ = 4;
            Cs.b(xVar);
        }
        Cs.b(new com.baidu.tbadk.editortools.a.a(Cs.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, Cs.getContext()), x.class);
        if (runTask2 != null && (runTask2.getData() instanceof x)) {
            x xVar2 = (x) runTask2.getData();
            xVar2.azJ = 6;
            Cs.b(xVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Cs.getContext()), x.class);
        if (runTask3 != null && runTask3.getData() != null) {
            x xVar3 = (x) runTask3.getData();
            xVar3.azJ = 8;
            Cs.b(xVar3);
        }
        Cs.b(new com.baidu.tbadk.editortools.inputtool.a(Cs.getContext(), true));
        Cs.b(new com.baidu.tbadk.editortools.sendtool.a(Cs.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Cs.getContext()), x.class);
        if (runTask4 != null && runTask4.getData() != null) {
            x xVar4 = (x) runTask4.getData();
            xVar4.azJ = 9;
            Cs.b(xVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        Cs.v(arrayList);
        if (!"PbChosenActivity".equals(Cs.getContext().getClass().getSimpleName())) {
            Cs.b(new com.baidu.tbadk.editortools.b.a(Cs.getContext(), 10));
        }
        Cs.Ct();
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
