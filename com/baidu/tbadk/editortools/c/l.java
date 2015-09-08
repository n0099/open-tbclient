package com.baidu.tbadk.editortools.c;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.editortools.v;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.editortools.d {
    private a<?> atQ;
    private String forumName = null;
    private boolean atP = false;

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void a(a<?> aVar) {
        this.atQ = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f am(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(i.c.pb_editor_tool_view_bg_alpha);
        jVar.setBarLinePostion(1);
        d dVar = new d(jVar);
        dVar.a(this.atQ);
        return dVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof d) {
            com.baidu.tbadk.editortools.j AL = fVar.AL();
            m mVar = new m(this, (d) fVar, AL);
            AL.a(5, mVar);
            AL.a(4, mVar);
            AL.a(7, mVar);
            AL.a(16, mVar);
            AL.a(14, mVar);
            AL.a(15, mVar);
            AL.a(21, mVar);
            AL.a(22, mVar);
            AL.a(23, mVar);
            AL.a(8, mVar);
            AL.a(18, mVar);
            AL.a(20, mVar);
            AL.a(10, mVar);
            AL.a(11, mVar);
            AL.a(27, mVar);
            AL.a(29, mVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        v vVar;
        v vVar2;
        v vVar3;
        com.baidu.tbadk.editortools.j AL = fVar.AL();
        AL.b(new com.baidu.tbadk.editortools.emotiontool.m(AL.getContext(), 1));
        if (XiaoyingUtil.showXiaoyingTool()) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, AL.getContext()), v.class);
            if (runTask2 != null && (vVar3 = (v) runTask2.getData()) != null) {
                vVar3.aqS = 2;
                AL.b(vVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, AL.getContext()), v.class);
            if (runTask3 != null && (vVar2 = (v) runTask3.getData()) != null) {
                AL.b(vVar2);
            }
        }
        AL.b(new com.baidu.tbadk.editortools.imagetool.i(AL.getContext(), 3));
        AL.b(new com.baidu.tbadk.editortools.imagetool.b(AL.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.avq() && u.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, AL.getContext()), v.class)) != null && (vVar = (v) runTask.getData()) != null) {
            vVar.aqS = 4;
            AL.b(vVar);
        }
        AL.b(new com.baidu.tbadk.editortools.a.a(AL.getContext(), 5));
        AL.b(new com.baidu.tbadk.editortools.locationtool.c(AL.getContext(), 6));
        AL.b(new com.baidu.tbadk.editortools.locationtool.b(AL.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, AL.getContext()), v.class);
        if (runTask4 != null && runTask4.getData() != null) {
            v vVar4 = (v) runTask4.getData();
            vVar4.aqS = 7;
            AL.b(vVar4);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE)) {
            AL.b(new com.baidu.tbadk.editortools.b.b(AL.getContext(), 8));
            AL.b(new com.baidu.tbadk.editortools.b.a(AL.getContext()));
        }
        AL.b(new com.baidu.tbadk.editortools.inputtool.a(AL.getContext(), true));
        AL.b(new com.baidu.tbadk.editortools.sendtool.a(AL.getContext()));
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, AL.getContext()), v.class);
        if (runTask5 != null && runTask5.getData() != null) {
            v vVar5 = (v) runTask5.getData();
            vVar5.aqS = 9;
            AL.b(vVar5);
        }
        AL.AM();
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
