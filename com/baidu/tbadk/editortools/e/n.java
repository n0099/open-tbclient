package com.baidu.tbadk.editortools.e;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.d {
    private a<?> awY;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean awX = false;

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void a(a<?> aVar) {
        this.awY = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f ao(Context context) {
        com.baidu.tbadk.editortools.l lVar = new com.baidu.tbadk.editortools.l(context);
        lVar.setBackgroundColorId(0);
        lVar.setBarBackgroundColorId(r.d.common_color_10099);
        lVar.bD(true);
        e eVar = new e(lVar);
        eVar.a(this.awY);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof e) {
            com.baidu.tbadk.editortools.l CO = fVar.CO();
            o oVar = new o(this, (e) fVar, CO);
            CO.a(5, oVar);
            CO.a(4, oVar);
            CO.a(7, oVar);
            CO.a(16, oVar);
            CO.a(14, oVar);
            CO.a(15, oVar);
            CO.a(8, oVar);
            CO.a(18, oVar);
            CO.a(20, oVar);
            CO.a(10, oVar);
            CO.a(11, oVar);
            CO.a(27, oVar);
            CO.a(29, oVar);
            CO.a(36, oVar);
            CO.a(32, oVar);
            CO.a(40, oVar);
            CO.a(43, oVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        aa aaVar;
        com.baidu.tbadk.editortools.l CO = fVar.CO();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(CO.getContext(), 7);
        CO.b(aVar);
        aVar.avu = r.f.icon_topic_n;
        CO.b(new com.baidu.tbadk.editortools.imagetool.i(CO.getContext(), 3));
        CO.b(new com.baidu.tbadk.editortools.imagetool.b(CO.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.bnn() && com.baidu.tieba.tbadkCore.u.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CO.getContext()), aa.class)) != null && (aaVar = (aa) runTask.getData()) != null) {
            aaVar.avw = 4;
            CO.b(aaVar);
        }
        CO.b(new com.baidu.tbadk.editortools.a.a(CO.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, CO.getContext()), aa.class);
        if (runTask2 != null && (runTask2.getData() instanceof aa)) {
            aa aaVar2 = (aa) runTask2.getData();
            aaVar2.avw = 6;
            CO.b(aaVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, CO.getContext()), aa.class);
        if (runTask3 != null && runTask3.getData() != null) {
            aa aaVar3 = (aa) runTask3.getData();
            aaVar3.avw = 8;
            CO.b(aaVar3);
        }
        CO.b(new com.baidu.tbadk.editortools.inputtool.a(CO.getContext(), true));
        CO.b(new com.baidu.tbadk.editortools.sendtool.a(CO.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, CO.getContext()), aa.class);
        if (runTask4 != null && runTask4.getData() != null) {
            aa aaVar4 = (aa) runTask4.getData();
            aaVar4.avw = 9;
            CO.b(aaVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        CO.y(arrayList);
        if (!"PbChosenActivity".equals(CO.getContext().getClass().getSimpleName())) {
            CO.b(new com.baidu.tbadk.editortools.b.a(CO.getContext(), 10));
        }
        CO.CP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(r.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
