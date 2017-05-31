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
    private DataModel<?> aAX;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean aAW = false;

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
        this.aAX = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aR(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(w.e.common_color_10099);
        jVar.bB(true);
        c cVar = new c(jVar);
        cVar.a(this.aAX);
        return cVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof c) {
            com.baidu.tbadk.editortools.j Cm = fVar.Cm();
            m mVar = new m(this, (c) fVar, Cm);
            Cm.a(5, mVar);
            Cm.a(4, mVar);
            Cm.a(7, mVar);
            Cm.a(16, mVar);
            Cm.a(14, mVar);
            Cm.a(15, mVar);
            Cm.a(8, mVar);
            Cm.a(18, mVar);
            Cm.a(20, mVar);
            Cm.a(10, mVar);
            Cm.a(11, mVar);
            Cm.a(27, mVar);
            Cm.a(29, mVar);
            Cm.a(36, mVar);
            Cm.a(32, mVar);
            Cm.a(40, mVar);
            Cm.a(43, mVar);
            Cm.a(45, mVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        x xVar;
        com.baidu.tbadk.editortools.j Cm = fVar.Cm();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(Cm.getContext(), 7);
        Cm.b(aVar);
        aVar.azt = w.g.icon_topic_n;
        Cm.b(new com.baidu.tbadk.editortools.imagetool.i(Cm.getContext(), 3));
        Cm.b(new com.baidu.tbadk.editortools.imagetool.b(Cm.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.bjl() && com.baidu.tieba.tbadkCore.r.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Cm.getContext()), x.class)) != null && (xVar = (x) runTask.getData()) != null) {
            xVar.azv = 4;
            Cm.b(xVar);
        }
        Cm.b(new com.baidu.tbadk.editortools.a.a(Cm.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, Cm.getContext()), x.class);
        if (runTask2 != null && (runTask2.getData() instanceof x)) {
            x xVar2 = (x) runTask2.getData();
            xVar2.azv = 6;
            Cm.b(xVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Cm.getContext()), x.class);
        if (runTask3 != null && runTask3.getData() != null) {
            x xVar3 = (x) runTask3.getData();
            xVar3.azv = 8;
            Cm.b(xVar3);
        }
        Cm.b(new com.baidu.tbadk.editortools.inputtool.a(Cm.getContext(), true));
        Cm.b(new com.baidu.tbadk.editortools.sendtool.a(Cm.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Cm.getContext()), x.class);
        if (runTask4 != null && runTask4.getData() != null) {
            x xVar4 = (x) runTask4.getData();
            xVar4.azv = 9;
            Cm.b(xVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        Cm.v(arrayList);
        if (!"PbChosenActivity".equals(Cm.getContext().getClass().getSimpleName())) {
            Cm.b(new com.baidu.tbadk.editortools.b.a(Cm.getContext(), 10));
        }
        Cm.Cn();
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
