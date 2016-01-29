package com.baidu.tbadk.editortools.d;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.d {
    private a<?> avr;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean avq = false;

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
        this.avr = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f al(Context context) {
        com.baidu.tbadk.editortools.k kVar = new com.baidu.tbadk.editortools.k(context);
        kVar.setBackgroundColorId(0);
        kVar.setBarBackgroundColorId(t.d.pb_editor_tool_view_bg_alpha);
        kVar.setBarLinePostion(1);
        e eVar = new e(kVar);
        eVar.a(this.avr);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof e) {
            com.baidu.tbadk.editortools.k Cz = fVar.Cz();
            o oVar = new o(this, (e) fVar, Cz);
            Cz.a(5, oVar);
            Cz.a(4, oVar);
            Cz.a(7, oVar);
            Cz.a(16, oVar);
            Cz.a(14, oVar);
            Cz.a(15, oVar);
            Cz.a(21, oVar);
            Cz.a(22, oVar);
            Cz.a(23, oVar);
            Cz.a(8, oVar);
            Cz.a(18, oVar);
            Cz.a(20, oVar);
            Cz.a(10, oVar);
            Cz.a(11, oVar);
            Cz.a(27, oVar);
            Cz.a(29, oVar);
            Cz.a(36, oVar);
            Cz.a(32, oVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        y yVar;
        com.baidu.tbadk.editortools.k Cz = fVar.Cz();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        Cz.b(new com.baidu.tbadk.editortools.imagetool.i(Cz.getContext(), 3));
        Cz.b(new com.baidu.tbadk.editortools.imagetool.b(Cz.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.aNC() && com.baidu.tieba.tbadkCore.u.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Cz.getContext()), y.class)) != null && (yVar = (y) runTask.getData()) != null) {
            yVar.launcherPriority = 4;
            Cz.b(yVar);
        }
        Cz.b(new com.baidu.tbadk.editortools.a.a(Cz.getContext(), 5));
        arrayList.add(7);
        arrayList.add(8);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Cz.getContext()), y.class);
        if (runTask2 != null && runTask2.getData() != null) {
            y yVar2 = (y) runTask2.getData();
            yVar2.launcherPriority = 7;
            Cz.b(yVar2);
        }
        arrayList.add(13);
        arrayList.add(14);
        Cz.b(new com.baidu.tbadk.editortools.inputtool.a(Cz.getContext(), true));
        Cz.b(new com.baidu.tbadk.editortools.sendtool.a(Cz.getContext()));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Cz.getContext()), y.class);
        if (runTask3 != null && runTask3.getData() != null) {
            y yVar3 = (y) runTask3.getData();
            yVar3.launcherPriority = 8;
            Cz.b(yVar3);
        }
        Cz.u(arrayList);
        Cz.b(new com.baidu.tbadk.editortools.b.a(Cz.getContext(), 9));
        Cz.CA();
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
