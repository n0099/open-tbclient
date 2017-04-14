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
    private DataModel<?> aBk;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean aBj = false;

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
        this.aBk = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aO(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(w.e.common_color_10099);
        jVar.bE(true);
        c cVar = new c(jVar);
        cVar.a(this.aBk);
        return cVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof c) {
            com.baidu.tbadk.editortools.j Dn = fVar.Dn();
            m mVar = new m(this, (c) fVar, Dn);
            Dn.a(5, mVar);
            Dn.a(4, mVar);
            Dn.a(7, mVar);
            Dn.a(16, mVar);
            Dn.a(14, mVar);
            Dn.a(15, mVar);
            Dn.a(8, mVar);
            Dn.a(18, mVar);
            Dn.a(20, mVar);
            Dn.a(10, mVar);
            Dn.a(11, mVar);
            Dn.a(27, mVar);
            Dn.a(29, mVar);
            Dn.a(36, mVar);
            Dn.a(32, mVar);
            Dn.a(40, mVar);
            Dn.a(43, mVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        x xVar;
        com.baidu.tbadk.editortools.j Dn = fVar.Dn();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(Dn.getContext(), 7);
        Dn.b(aVar);
        aVar.azH = w.g.icon_topic_n;
        Dn.b(new com.baidu.tbadk.editortools.imagetool.i(Dn.getContext(), 3));
        Dn.b(new com.baidu.tbadk.editortools.imagetool.b(Dn.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.bjt() && com.baidu.tieba.tbadkCore.s.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Dn.getContext()), x.class)) != null && (xVar = (x) runTask.getData()) != null) {
            xVar.azJ = 4;
            Dn.b(xVar);
        }
        Dn.b(new com.baidu.tbadk.editortools.a.a(Dn.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, Dn.getContext()), x.class);
        if (runTask2 != null && (runTask2.getData() instanceof x)) {
            x xVar2 = (x) runTask2.getData();
            xVar2.azJ = 6;
            Dn.b(xVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Dn.getContext()), x.class);
        if (runTask3 != null && runTask3.getData() != null) {
            x xVar3 = (x) runTask3.getData();
            xVar3.azJ = 8;
            Dn.b(xVar3);
        }
        Dn.b(new com.baidu.tbadk.editortools.inputtool.a(Dn.getContext(), true));
        Dn.b(new com.baidu.tbadk.editortools.sendtool.a(Dn.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Dn.getContext()), x.class);
        if (runTask4 != null && runTask4.getData() != null) {
            x xVar4 = (x) runTask4.getData();
            xVar4.azJ = 9;
            Dn.b(xVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        Dn.u(arrayList);
        if (!"PbChosenActivity".equals(Dn.getContext().getClass().getSimpleName())) {
            Dn.b(new com.baidu.tbadk.editortools.b.a(Dn.getContext(), 10));
        }
        Dn.Do();
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
