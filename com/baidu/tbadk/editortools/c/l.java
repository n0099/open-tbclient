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
    private a<?> aso;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean asn = false;

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
        this.aso = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f al(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(i.c.pb_editor_tool_view_bg_alpha);
        jVar.setBarLinePostion(1);
        d dVar = new d(jVar);
        dVar.a(this.aso);
        return dVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof d) {
            com.baidu.tbadk.editortools.j Au = fVar.Au();
            m mVar = new m(this, (d) fVar, Au);
            Au.a(5, mVar);
            Au.a(4, mVar);
            Au.a(7, mVar);
            Au.a(16, mVar);
            Au.a(14, mVar);
            Au.a(15, mVar);
            Au.a(21, mVar);
            Au.a(22, mVar);
            Au.a(23, mVar);
            Au.a(8, mVar);
            Au.a(18, mVar);
            Au.a(20, mVar);
            Au.a(10, mVar);
            Au.a(11, mVar);
            Au.a(27, mVar);
            Au.a(29, mVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        v vVar;
        v vVar2;
        v vVar3;
        com.baidu.tbadk.editortools.j Au = fVar.Au();
        Au.b(new com.baidu.tbadk.editortools.emotiontool.m(Au.getContext(), 1));
        if (XiaoyingUtil.showXiaoyingTool()) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_TOOL, Au.getContext()), v.class);
            if (runTask2 != null && (vVar3 = (v) runTask2.getData()) != null) {
                vVar3.apu = 2;
                Au.b(vVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_XIAOYING_PANNEL_TOOL, Au.getContext()), v.class);
            if (runTask3 != null && (vVar2 = (v) runTask3.getData()) != null) {
                Au.b(vVar2);
            }
        }
        Au.b(new com.baidu.tbadk.editortools.imagetool.i(Au.getContext(), 3));
        Au.b(new com.baidu.tbadk.editortools.imagetool.b(Au.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.b.axJ() && u.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Au.getContext()), v.class)) != null && (vVar = (v) runTask.getData()) != null) {
            vVar.apu = 4;
            Au.b(vVar);
        }
        Au.b(new com.baidu.tbadk.editortools.a.a(Au.getContext(), 5));
        Au.b(new com.baidu.tbadk.editortools.locationtool.c(Au.getContext(), 6));
        Au.b(new com.baidu.tbadk.editortools.locationtool.b(Au.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Au.getContext()), v.class);
        if (runTask4 != null && runTask4.getData() != null) {
            v vVar4 = (v) runTask4.getData();
            vVar4.apu = 7;
            Au.b(vVar4);
        }
        if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE)) {
            Au.b(new com.baidu.tbadk.editortools.b.b(Au.getContext(), 8));
            Au.b(new com.baidu.tbadk.editortools.b.a(Au.getContext()));
        }
        Au.b(new com.baidu.tbadk.editortools.inputtool.a(Au.getContext(), true));
        Au.b(new com.baidu.tbadk.editortools.sendtool.a(Au.getContext()));
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Au.getContext()), v.class);
        if (runTask5 != null && runTask5.getData() != null) {
            v vVar5 = (v) runTask5.getData();
            vVar5.apu = 9;
            Au.b(vVar5);
        }
        Au.Av();
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
