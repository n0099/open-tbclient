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
import com.baidu.tieba.tbadkCore.t;
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.editortools.d {
    private a<?> asg;
    private String forumName = null;
    private boolean asf = false;

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void a(a<?> aVar) {
        this.asg = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f am(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(i.c.pb_editor_tool_view_bg_alpha);
        jVar.setBarLinePostion(1);
        d dVar = new d(jVar);
        dVar.a(this.asg);
        return dVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof d) {
            com.baidu.tbadk.editortools.j Ay = fVar.Ay();
            m mVar = new m(this, (d) fVar, Ay);
            Ay.a(5, mVar);
            Ay.a(4, mVar);
            Ay.a(7, mVar);
            Ay.a(16, mVar);
            Ay.a(14, mVar);
            Ay.a(15, mVar);
            Ay.a(21, mVar);
            Ay.a(22, mVar);
            Ay.a(23, mVar);
            Ay.a(8, mVar);
            Ay.a(18, mVar);
            Ay.a(20, mVar);
            Ay.a(10, mVar);
            Ay.a(11, mVar);
            Ay.a(27, mVar);
            Ay.a(29, mVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        v vVar;
        v vVar2;
        v vVar3;
        com.baidu.tbadk.editortools.j Ay = fVar.Ay();
        Ay.b(new com.baidu.tbadk.editortools.emotiontool.m(Ay.getContext(), 1));
        if (XiaoyingUtil.showXiaoyingTool()) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, Ay.getContext()), v.class);
            if (runTask2 != null && (vVar3 = (v) runTask2.getData()) != null) {
                vVar3.aph = 2;
                Ay.b(vVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, Ay.getContext()), v.class);
            if (runTask3 != null && (vVar2 = (v) runTask3.getData()) != null) {
                Ay.b(vVar2);
            }
        }
        Ay.b(new com.baidu.tbadk.editortools.imagetool.i(Ay.getContext(), 3));
        Ay.b(new com.baidu.tbadk.editortools.imagetool.b(Ay.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.arc() && t.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Ay.getContext()), v.class)) != null && (vVar = (v) runTask.getData()) != null) {
            vVar.aph = 4;
            Ay.b(vVar);
        }
        Ay.b(new com.baidu.tbadk.editortools.a.a(Ay.getContext(), 5));
        Ay.b(new com.baidu.tbadk.editortools.locationtool.c(Ay.getContext(), 6));
        Ay.b(new com.baidu.tbadk.editortools.locationtool.b(Ay.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Ay.getContext()), v.class);
        if (runTask4 != null && runTask4.getData() != null) {
            v vVar4 = (v) runTask4.getData();
            vVar4.aph = 7;
            Ay.b(vVar4);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE)) {
            Ay.b(new com.baidu.tbadk.editortools.b.b(Ay.getContext(), 8));
            Ay.b(new com.baidu.tbadk.editortools.b.a(Ay.getContext()));
        }
        Ay.b(new com.baidu.tbadk.editortools.inputtool.a(Ay.getContext(), true));
        Ay.b(new com.baidu.tbadk.editortools.sendtool.a(Ay.getContext()));
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Ay.getContext()), v.class);
        if (runTask5 != null && runTask5.getData() != null) {
            v vVar5 = (v) runTask5.getData();
            vVar5.aph = 9;
            Ay.b(vVar5);
        }
        Ay.Az();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(i.C0057i.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
