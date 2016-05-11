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
    private a<?> arQ;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean arP = false;

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
        this.arQ = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f ah(Context context) {
        com.baidu.tbadk.editortools.l lVar = new com.baidu.tbadk.editortools.l(context);
        lVar.setBackgroundColorId(0);
        lVar.setBarBackgroundColorId(t.d.pb_editor_tool_view_bg_alpha);
        lVar.setBarLinePostion(1);
        e eVar = new e(lVar);
        eVar.a(this.arQ);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof e) {
            com.baidu.tbadk.editortools.l Bb = fVar.Bb();
            o oVar = new o(this, (e) fVar, Bb);
            Bb.a(5, oVar);
            Bb.a(4, oVar);
            Bb.a(7, oVar);
            Bb.a(16, oVar);
            Bb.a(14, oVar);
            Bb.a(15, oVar);
            Bb.a(21, oVar);
            Bb.a(22, oVar);
            Bb.a(23, oVar);
            Bb.a(8, oVar);
            Bb.a(18, oVar);
            Bb.a(20, oVar);
            Bb.a(10, oVar);
            Bb.a(11, oVar);
            Bb.a(27, oVar);
            Bb.a(29, oVar);
            Bb.a(36, oVar);
            Bb.a(32, oVar);
            Bb.a(40, oVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        aa aaVar;
        com.baidu.tbadk.editortools.l Bb = fVar.Bb();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        Bb.b(new com.baidu.tbadk.editortools.imagetool.i(Bb.getContext(), 3));
        Bb.b(new com.baidu.tbadk.editortools.imagetool.b(Bb.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.aUZ() && com.baidu.tieba.tbadkCore.u.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Bb.getContext()), aa.class)) != null && (aaVar = (aa) runTask.getData()) != null) {
            aaVar.aqn = 4;
            Bb.b(aaVar);
        }
        Bb.b(new com.baidu.tbadk.editortools.a.a(Bb.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, Bb.getContext()), aa.class);
        if (runTask2 != null && (runTask2.getData() instanceof aa)) {
            aa aaVar2 = (aa) runTask2.getData();
            aaVar2.aqn = 6;
            Bb.b(aaVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Bb.getContext()), aa.class);
        if (runTask3 != null && runTask3.getData() != null) {
            aa aaVar3 = (aa) runTask3.getData();
            aaVar3.aqn = 7;
            Bb.b(aaVar3);
        }
        arrayList.add(13);
        arrayList.add(14);
        Bb.b(new com.baidu.tbadk.editortools.inputtool.a(Bb.getContext(), true));
        Bb.b(new com.baidu.tbadk.editortools.sendtool.a(Bb.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Bb.getContext()), aa.class);
        if (runTask4 != null && runTask4.getData() != null) {
            aa aaVar4 = (aa) runTask4.getData();
            aaVar4.aqn = 8;
            Bb.b(aaVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        Bb.x(arrayList);
        Bb.b(new com.baidu.tbadk.editortools.b.a(Bb.getContext(), 9));
        Bb.Bc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m11getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(t.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
