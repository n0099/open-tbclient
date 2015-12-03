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
    private a<?> asV;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean asU = false;

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
        this.asV = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f am(Context context) {
        com.baidu.tbadk.editortools.k kVar = new com.baidu.tbadk.editortools.k(context);
        kVar.setBackgroundColorId(0);
        kVar.setBarBackgroundColorId(n.c.pb_editor_tool_view_bg_alpha);
        kVar.setBarLinePostion(1);
        e eVar = new e(kVar);
        eVar.a(this.asV);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof e) {
            com.baidu.tbadk.editortools.k Bu = fVar.Bu();
            o oVar = new o(this, (e) fVar, Bu);
            Bu.a(5, oVar);
            Bu.a(4, oVar);
            Bu.a(7, oVar);
            Bu.a(16, oVar);
            Bu.a(14, oVar);
            Bu.a(15, oVar);
            Bu.a(21, oVar);
            Bu.a(22, oVar);
            Bu.a(23, oVar);
            Bu.a(8, oVar);
            Bu.a(18, oVar);
            Bu.a(20, oVar);
            Bu.a(10, oVar);
            Bu.a(11, oVar);
            Bu.a(27, oVar);
            Bu.a(29, oVar);
            Bu.a(36, oVar);
            Bu.a(32, oVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        y yVar;
        y yVar2;
        y yVar3;
        com.baidu.tbadk.editortools.k Bu = fVar.Bu();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        if (XiaoyingUtil.showXiaoyingTool()) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, Bu.getContext()), y.class);
            if (runTask2 != null && (yVar3 = (y) runTask2.getData()) != null) {
                yVar3.launcherPriority = 2;
                Bu.b(yVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, Bu.getContext()), y.class);
            if (runTask3 != null && (yVar2 = (y) runTask3.getData()) != null) {
                Bu.b(yVar2);
            }
        }
        Bu.b(new com.baidu.tbadk.editortools.imagetool.i(Bu.getContext(), 3));
        Bu.b(new com.baidu.tbadk.editortools.imagetool.b(Bu.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.b.aEk() && v.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Bu.getContext()), y.class)) != null && (yVar = (y) runTask.getData()) != null) {
            yVar.launcherPriority = 4;
            Bu.b(yVar);
        }
        Bu.b(new com.baidu.tbadk.editortools.a.a(Bu.getContext(), 5));
        arrayList.add(7);
        arrayList.add(8);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Bu.getContext()), y.class);
        if (runTask4 != null && runTask4.getData() != null) {
            y yVar4 = (y) runTask4.getData();
            yVar4.launcherPriority = 7;
            Bu.b(yVar4);
        }
        arrayList.add(13);
        arrayList.add(14);
        Bu.b(new com.baidu.tbadk.editortools.inputtool.a(Bu.getContext(), true));
        Bu.b(new com.baidu.tbadk.editortools.sendtool.a(Bu.getContext()));
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Bu.getContext()), y.class);
        if (runTask5 != null && runTask5.getData() != null) {
            y yVar5 = (y) runTask5.getData();
            yVar5.launcherPriority = 8;
            Bu.b(yVar5);
        }
        Bu.p(arrayList);
        Bu.b(new com.baidu.tbadk.editortools.b.a(Bu.getContext(), 9));
        Bu.Bv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(n.i.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
