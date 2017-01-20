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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.editortools.d {
    private DataModel<?> avz;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean avy = false;

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
        this.avz = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f ao(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(r.e.common_color_10099);
        jVar.bD(true);
        c cVar = new c(jVar);
        cVar.a(this.avz);
        return cVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof c) {
            com.baidu.tbadk.editortools.j Cw = fVar.Cw();
            m mVar = new m(this, (c) fVar, Cw);
            Cw.a(5, mVar);
            Cw.a(4, mVar);
            Cw.a(7, mVar);
            Cw.a(16, mVar);
            Cw.a(14, mVar);
            Cw.a(15, mVar);
            Cw.a(8, mVar);
            Cw.a(18, mVar);
            Cw.a(20, mVar);
            Cw.a(10, mVar);
            Cw.a(11, mVar);
            Cw.a(27, mVar);
            Cw.a(29, mVar);
            Cw.a(36, mVar);
            Cw.a(32, mVar);
            Cw.a(40, mVar);
            Cw.a(43, mVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        x xVar;
        com.baidu.tbadk.editortools.j Cw = fVar.Cw();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(Cw.getContext(), 7);
        Cw.b(aVar);
        aVar.atW = r.g.icon_topic_n;
        Cw.b(new com.baidu.tbadk.editortools.imagetool.i(Cw.getContext(), 3));
        Cw.b(new com.baidu.tbadk.editortools.imagetool.b(Cw.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.biS() && com.baidu.tieba.tbadkCore.s.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Cw.getContext()), x.class)) != null && (xVar = (x) runTask.getData()) != null) {
            xVar.atY = 4;
            Cw.b(xVar);
        }
        Cw.b(new com.baidu.tbadk.editortools.a.a(Cw.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, Cw.getContext()), x.class);
        if (runTask2 != null && (runTask2.getData() instanceof x)) {
            x xVar2 = (x) runTask2.getData();
            xVar2.atY = 6;
            Cw.b(xVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Cw.getContext()), x.class);
        if (runTask3 != null && runTask3.getData() != null) {
            x xVar3 = (x) runTask3.getData();
            xVar3.atY = 8;
            Cw.b(xVar3);
        }
        Cw.b(new com.baidu.tbadk.editortools.inputtool.a(Cw.getContext(), true));
        Cw.b(new com.baidu.tbadk.editortools.sendtool.a(Cw.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Cw.getContext()), x.class);
        if (runTask4 != null && runTask4.getData() != null) {
            x xVar4 = (x) runTask4.getData();
            xVar4.atY = 9;
            Cw.b(xVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        Cw.w(arrayList);
        if (!"PbChosenActivity".equals(Cw.getContext().getClass().getSimpleName())) {
            Cw.b(new com.baidu.tbadk.editortools.b.a(Cw.getContext(), 10));
        }
        Cw.Cx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(r.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
