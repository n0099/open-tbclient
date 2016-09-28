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
    private a<?> awf;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean awe = false;

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
        this.awf = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f ao(Context context) {
        com.baidu.tbadk.editortools.l lVar = new com.baidu.tbadk.editortools.l(context);
        lVar.setBackgroundColorId(0);
        lVar.setBarBackgroundColorId(r.d.common_color_10099);
        lVar.bz(true);
        e eVar = new e(lVar);
        eVar.a(this.awf);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof e) {
            com.baidu.tbadk.editortools.l CG = fVar.CG();
            o oVar = new o(this, (e) fVar, CG);
            CG.a(5, oVar);
            CG.a(4, oVar);
            CG.a(7, oVar);
            CG.a(16, oVar);
            CG.a(14, oVar);
            CG.a(15, oVar);
            CG.a(21, oVar);
            CG.a(22, oVar);
            CG.a(23, oVar);
            CG.a(8, oVar);
            CG.a(18, oVar);
            CG.a(20, oVar);
            CG.a(10, oVar);
            CG.a(11, oVar);
            CG.a(27, oVar);
            CG.a(29, oVar);
            CG.a(36, oVar);
            CG.a(32, oVar);
            CG.a(40, oVar);
            CG.a(43, oVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        aa aaVar;
        com.baidu.tbadk.editortools.l CG = fVar.CG();
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
        aVar.auA = r.f.icon_topic_n;
        CG.b(new com.baidu.tbadk.editortools.imagetool.i(CG.getContext(), 3));
        CG.b(new com.baidu.tbadk.editortools.imagetool.b(CG.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.bkX() && com.baidu.tieba.tbadkCore.u.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CG.getContext()), aa.class)) != null && (aaVar = (aa) runTask.getData()) != null) {
            aaVar.auC = 4;
            CG.b(aaVar);
        }
        CG.b(new com.baidu.tbadk.editortools.a.a(CG.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, CG.getContext()), aa.class);
        if (runTask2 != null && (runTask2.getData() instanceof aa)) {
            aa aaVar2 = (aa) runTask2.getData();
            aaVar2.auC = 6;
            CG.b(aaVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, CG.getContext()), aa.class);
        if (runTask3 != null && runTask3.getData() != null) {
            aa aaVar3 = (aa) runTask3.getData();
            aaVar3.auC = 8;
            CG.b(aaVar3);
        }
        arrayList.add(13);
        arrayList.add(14);
        CG.b(new com.baidu.tbadk.editortools.inputtool.a(CG.getContext(), true));
        CG.b(new com.baidu.tbadk.editortools.sendtool.a(CG.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, CG.getContext()), aa.class);
        if (runTask4 != null && runTask4.getData() != null) {
            aa aaVar4 = (aa) runTask4.getData();
            aaVar4.auC = 9;
            CG.b(aaVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        CG.y(arrayList);
        if (!"PbChosenActivity".equals(CG.getContext().getClass().getSimpleName())) {
            CG.b(new com.baidu.tbadk.editortools.b.a(CG.getContext(), 10));
        }
        CG.CH();
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
