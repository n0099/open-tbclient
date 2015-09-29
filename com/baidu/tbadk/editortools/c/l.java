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
    private a<?> asn;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean asm = false;

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
        this.asn = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f al(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(i.c.pb_editor_tool_view_bg_alpha);
        jVar.setBarLinePostion(1);
        d dVar = new d(jVar);
        dVar.a(this.asn);
        return dVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof d) {
            com.baidu.tbadk.editortools.j Ax = fVar.Ax();
            m mVar = new m(this, (d) fVar, Ax);
            Ax.a(5, mVar);
            Ax.a(4, mVar);
            Ax.a(7, mVar);
            Ax.a(16, mVar);
            Ax.a(14, mVar);
            Ax.a(15, mVar);
            Ax.a(21, mVar);
            Ax.a(22, mVar);
            Ax.a(23, mVar);
            Ax.a(8, mVar);
            Ax.a(18, mVar);
            Ax.a(20, mVar);
            Ax.a(10, mVar);
            Ax.a(11, mVar);
            Ax.a(27, mVar);
            Ax.a(29, mVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        v vVar;
        v vVar2;
        v vVar3;
        com.baidu.tbadk.editortools.j Ax = fVar.Ax();
        Ax.b(new com.baidu.tbadk.editortools.emotiontool.m(Ax.getContext(), 1));
        if (XiaoyingUtil.showXiaoyingTool()) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, Ax.getContext()), v.class);
            if (runTask2 != null && (vVar3 = (v) runTask2.getData()) != null) {
                vVar3.apt = 2;
                Ax.b(vVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, Ax.getContext()), v.class);
            if (runTask3 != null && (vVar2 = (v) runTask3.getData()) != null) {
                Ax.b(vVar2);
            }
        }
        Ax.b(new com.baidu.tbadk.editortools.imagetool.i(Ax.getContext(), 3));
        Ax.b(new com.baidu.tbadk.editortools.imagetool.b(Ax.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.b.axD() && u.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Ax.getContext()), v.class)) != null && (vVar = (v) runTask.getData()) != null) {
            vVar.apt = 4;
            Ax.b(vVar);
        }
        Ax.b(new com.baidu.tbadk.editortools.a.a(Ax.getContext(), 5));
        Ax.b(new com.baidu.tbadk.editortools.locationtool.c(Ax.getContext(), 6));
        Ax.b(new com.baidu.tbadk.editortools.locationtool.b(Ax.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Ax.getContext()), v.class);
        if (runTask4 != null && runTask4.getData() != null) {
            v vVar4 = (v) runTask4.getData();
            vVar4.apt = 7;
            Ax.b(vVar4);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE)) {
            Ax.b(new com.baidu.tbadk.editortools.b.b(Ax.getContext(), 8));
            Ax.b(new com.baidu.tbadk.editortools.b.a(Ax.getContext()));
        }
        Ax.b(new com.baidu.tbadk.editortools.inputtool.a(Ax.getContext(), true));
        Ax.b(new com.baidu.tbadk.editortools.sendtool.a(Ax.getContext()));
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Ax.getContext()), v.class);
        if (runTask5 != null && runTask5.getData() != null) {
            v vVar5 = (v) runTask5.getData();
            vVar5.apt = 9;
            Ax.b(vVar5);
        }
        Ax.Ay();
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
