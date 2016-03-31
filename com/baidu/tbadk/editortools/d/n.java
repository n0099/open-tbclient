package com.baidu.tbadk.editortools.d;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.d {
    private a<?> avR;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean avQ = false;

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
        this.avR = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f ai(Context context) {
        com.baidu.tbadk.editortools.l lVar = new com.baidu.tbadk.editortools.l(context);
        lVar.setBackgroundColorId(0);
        lVar.setBarBackgroundColorId(t.d.pb_editor_tool_view_bg_alpha);
        lVar.setBarLinePostion(1);
        e eVar = new e(lVar);
        eVar.a(this.avR);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof e) {
            com.baidu.tbadk.editortools.l Dh = fVar.Dh();
            o oVar = new o(this, (e) fVar, Dh);
            Dh.a(5, oVar);
            Dh.a(4, oVar);
            Dh.a(7, oVar);
            Dh.a(16, oVar);
            Dh.a(14, oVar);
            Dh.a(15, oVar);
            Dh.a(21, oVar);
            Dh.a(22, oVar);
            Dh.a(23, oVar);
            Dh.a(8, oVar);
            Dh.a(18, oVar);
            Dh.a(20, oVar);
            Dh.a(10, oVar);
            Dh.a(11, oVar);
            Dh.a(27, oVar);
            Dh.a(29, oVar);
            Dh.a(36, oVar);
            Dh.a(32, oVar);
            Dh.a(40, oVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        aa aaVar;
        com.baidu.tbadk.editortools.l Dh = fVar.Dh();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        Dh.b(new com.baidu.tbadk.editortools.imagetool.i(Dh.getContext(), 3));
        Dh.b(new com.baidu.tbadk.editortools.imagetool.b(Dh.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.aUE() && com.baidu.tieba.tbadkCore.u.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Dh.getContext()), aa.class)) != null && (aaVar = (aa) runTask.getData()) != null) {
            aaVar.launcherPriority = 4;
            Dh.b(aaVar);
        }
        Dh.b(new com.baidu.tbadk.editortools.a.a(Dh.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, Dh.getContext()), aa.class);
        if (runTask2 != null && (runTask2.getData() instanceof aa)) {
            aa aaVar2 = (aa) runTask2.getData();
            aaVar2.launcherPriority = 6;
            Dh.b(aaVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Dh.getContext()), aa.class);
        if (runTask3 != null && runTask3.getData() != null) {
            aa aaVar3 = (aa) runTask3.getData();
            aaVar3.launcherPriority = 7;
            Dh.b(aaVar3);
        }
        arrayList.add(13);
        arrayList.add(14);
        Dh.b(new com.baidu.tbadk.editortools.inputtool.a(Dh.getContext(), true));
        Dh.b(new com.baidu.tbadk.editortools.sendtool.a(Dh.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Dh.getContext()), aa.class);
        if (runTask4 != null && runTask4.getData() != null) {
            aa aaVar4 = (aa) runTask4.getData();
            aaVar4.launcherPriority = 8;
            Dh.b(aaVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        Dh.v(arrayList);
        Dh.b(new com.baidu.tbadk.editortools.b.a(Dh.getContext(), 9));
        Dh.Di();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(t.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
