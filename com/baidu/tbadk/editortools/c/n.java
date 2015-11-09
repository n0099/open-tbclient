package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.editortools.w;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.d {
    private a<?> aqS;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean aqR = false;

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
        this.aqS = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f al(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(i.c.pb_editor_tool_view_bg_alpha);
        jVar.setBarLinePostion(1);
        e eVar = new e(jVar);
        eVar.a(this.aqS);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof e) {
            com.baidu.tbadk.editortools.j Az = fVar.Az();
            o oVar = new o(this, (e) fVar, Az);
            Az.a(5, oVar);
            Az.a(4, oVar);
            Az.a(7, oVar);
            Az.a(16, oVar);
            Az.a(14, oVar);
            Az.a(15, oVar);
            Az.a(21, oVar);
            Az.a(22, oVar);
            Az.a(23, oVar);
            Az.a(8, oVar);
            Az.a(18, oVar);
            Az.a(20, oVar);
            Az.a(10, oVar);
            Az.a(11, oVar);
            Az.a(27, oVar);
            Az.a(29, oVar);
            Az.a(32, oVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        w wVar;
        w wVar2;
        w wVar3;
        com.baidu.tbadk.editortools.j Az = fVar.Az();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        if (XiaoyingUtil.showXiaoyingTool()) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, Az.getContext()), w.class);
            if (runTask2 != null && (wVar3 = (w) runTask2.getData()) != null) {
                wVar3.launcherPriority = 2;
                Az.b(wVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, Az.getContext()), w.class);
            if (runTask3 != null && (wVar2 = (w) runTask3.getData()) != null) {
                Az.b(wVar2);
            }
        }
        Az.b(new com.baidu.tbadk.editortools.imagetool.i(Az.getContext(), 3));
        Az.b(new com.baidu.tbadk.editortools.imagetool.b(Az.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.b.ayS() && com.baidu.tieba.tbadkCore.u.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Az.getContext()), w.class)) != null && (wVar = (w) runTask.getData()) != null) {
            wVar.launcherPriority = 4;
            Az.b(wVar);
        }
        Az.b(new com.baidu.tbadk.editortools.a.a(Az.getContext(), 5));
        arrayList.add(7);
        arrayList.add(8);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Az.getContext()), w.class);
        if (runTask4 != null && runTask4.getData() != null) {
            w wVar4 = (w) runTask4.getData();
            wVar4.launcherPriority = 7;
            Az.b(wVar4);
        }
        arrayList.add(13);
        arrayList.add(14);
        Az.b(new com.baidu.tbadk.editortools.inputtool.a(Az.getContext(), true));
        Az.b(new com.baidu.tbadk.editortools.sendtool.a(Az.getContext()));
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Az.getContext()), w.class);
        if (runTask5 != null && runTask5.getData() != null) {
            w wVar5 = (w) runTask5.getData();
            wVar5.launcherPriority = 9;
            Az.b(wVar5);
        }
        Az.q(arrayList);
        Az.AA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(i.h.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
