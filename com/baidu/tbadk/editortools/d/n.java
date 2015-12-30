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
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.d {
    private a<?> auz;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean auy = false;

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
        this.auz = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f al(Context context) {
        com.baidu.tbadk.editortools.k kVar = new com.baidu.tbadk.editortools.k(context);
        kVar.setBackgroundColorId(0);
        kVar.setBarBackgroundColorId(n.d.pb_editor_tool_view_bg_alpha);
        kVar.setBarLinePostion(1);
        e eVar = new e(kVar);
        eVar.a(this.auz);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof e) {
            com.baidu.tbadk.editortools.k Bj = fVar.Bj();
            o oVar = new o(this, (e) fVar, Bj);
            Bj.a(5, oVar);
            Bj.a(4, oVar);
            Bj.a(7, oVar);
            Bj.a(16, oVar);
            Bj.a(14, oVar);
            Bj.a(15, oVar);
            Bj.a(21, oVar);
            Bj.a(22, oVar);
            Bj.a(23, oVar);
            Bj.a(8, oVar);
            Bj.a(18, oVar);
            Bj.a(20, oVar);
            Bj.a(10, oVar);
            Bj.a(11, oVar);
            Bj.a(27, oVar);
            Bj.a(29, oVar);
            Bj.a(36, oVar);
            Bj.a(32, oVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        y yVar;
        y yVar2;
        y yVar3;
        com.baidu.tbadk.editortools.k Bj = fVar.Bj();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        if (XiaoyingUtil.showXiaoyingTool()) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, Bj.getContext()), y.class);
            if (runTask2 != null && (yVar3 = (y) runTask2.getData()) != null) {
                yVar3.launcherPriority = 2;
                Bj.b(yVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, Bj.getContext()), y.class);
            if (runTask3 != null && (yVar2 = (y) runTask3.getData()) != null) {
                Bj.b(yVar2);
            }
        }
        Bj.b(new com.baidu.tbadk.editortools.imagetool.i(Bj.getContext(), 3));
        Bj.b(new com.baidu.tbadk.editortools.imagetool.b(Bj.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.aGy() && v.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Bj.getContext()), y.class)) != null && (yVar = (y) runTask.getData()) != null) {
            yVar.launcherPriority = 4;
            Bj.b(yVar);
        }
        Bj.b(new com.baidu.tbadk.editortools.a.a(Bj.getContext(), 5));
        arrayList.add(7);
        arrayList.add(8);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Bj.getContext()), y.class);
        if (runTask4 != null && runTask4.getData() != null) {
            y yVar4 = (y) runTask4.getData();
            yVar4.launcherPriority = 7;
            Bj.b(yVar4);
        }
        arrayList.add(13);
        arrayList.add(14);
        Bj.b(new com.baidu.tbadk.editortools.inputtool.a(Bj.getContext(), true));
        Bj.b(new com.baidu.tbadk.editortools.sendtool.a(Bj.getContext()));
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Bj.getContext()), y.class);
        if (runTask5 != null && runTask5.getData() != null) {
            y yVar5 = (y) runTask5.getData();
            yVar5.launcherPriority = 8;
            Bj.b(yVar5);
        }
        Bj.q(arrayList);
        Bj.b(new com.baidu.tbadk.editortools.b.a(Bj.getContext(), 9));
        Bj.Bk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(n.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
