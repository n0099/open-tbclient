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
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.d {
    private a<?> asG;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean asF = false;

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
        this.asG = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f ag(Context context) {
        com.baidu.tbadk.editortools.l lVar = new com.baidu.tbadk.editortools.l(context);
        lVar.setBackgroundColorId(0);
        lVar.setBarBackgroundColorId(u.d.common_color_10099);
        lVar.bv(true);
        e eVar = new e(lVar);
        eVar.a(this.asG);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof e) {
            com.baidu.tbadk.editortools.l Bl = fVar.Bl();
            o oVar = new o(this, (e) fVar, Bl);
            Bl.a(5, oVar);
            Bl.a(4, oVar);
            Bl.a(7, oVar);
            Bl.a(16, oVar);
            Bl.a(14, oVar);
            Bl.a(15, oVar);
            Bl.a(21, oVar);
            Bl.a(22, oVar);
            Bl.a(23, oVar);
            Bl.a(8, oVar);
            Bl.a(18, oVar);
            Bl.a(20, oVar);
            Bl.a(10, oVar);
            Bl.a(11, oVar);
            Bl.a(27, oVar);
            Bl.a(29, oVar);
            Bl.a(36, oVar);
            Bl.a(32, oVar);
            Bl.a(40, oVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        aa aaVar;
        com.baidu.tbadk.editortools.l Bl = fVar.Bl();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        Bl.b(new com.baidu.tbadk.editortools.imagetool.i(Bl.getContext(), 3));
        Bl.b(new com.baidu.tbadk.editortools.imagetool.b(Bl.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.bdt() && v.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Bl.getContext()), aa.class)) != null && (aaVar = (aa) runTask.getData()) != null) {
            aaVar.ard = 4;
            Bl.b(aaVar);
        }
        Bl.b(new com.baidu.tbadk.editortools.a.a(Bl.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, Bl.getContext()), aa.class);
        if (runTask2 != null && (runTask2.getData() instanceof aa)) {
            aa aaVar2 = (aa) runTask2.getData();
            aaVar2.ard = 6;
            Bl.b(aaVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Bl.getContext()), aa.class);
        if (runTask3 != null && runTask3.getData() != null) {
            aa aaVar3 = (aa) runTask3.getData();
            aaVar3.ard = 7;
            Bl.b(aaVar3);
        }
        arrayList.add(13);
        arrayList.add(14);
        Bl.b(new com.baidu.tbadk.editortools.inputtool.a(Bl.getContext(), true));
        Bl.b(new com.baidu.tbadk.editortools.sendtool.a(Bl.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Bl.getContext()), aa.class);
        if (runTask4 != null && runTask4.getData() != null) {
            aa aaVar4 = (aa) runTask4.getData();
            aaVar4.ard = 8;
            Bl.b(aaVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        Bl.y(arrayList);
        Bl.b(new com.baidu.tbadk.editortools.b.a(Bl.getContext(), 9));
        Bl.Bm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(u.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
