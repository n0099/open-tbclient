package com.baidu.tbadk.editortools.c;

import android.content.Context;
import android.text.InputFilter;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.d {
    private boolean asm = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f al(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(i.c.pb_editor_tool_view_bg_alpha);
        jVar.setBarLinePostion(1);
        return new n(jVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.j Ax = fVar.Ax();
            s sVar = new s(this, (n) fVar, Ax);
            Ax.a(4, sVar);
            Ax.a(7, sVar);
            Ax.a(16, sVar);
            Ax.a(8, sVar);
            Ax.a(10, sVar);
            Ax.a(11, sVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        v vVar;
        com.baidu.tbadk.editortools.j Ax = fVar.Ax();
        Ax.b(new com.baidu.tbadk.editortools.emotiontool.m(Ax.getContext(), 1, false));
        if (com.baidu.tieba.tbadkCore.voice.b.axD() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Ax.getContext()), v.class)) != null && (vVar = (v) runTask.getData()) != null) {
            vVar.apt = 2;
            Ax.b(vVar);
        }
        Ax.b(new com.baidu.tbadk.editortools.a.a(Ax.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(Ax.getContext(), true);
        if (aVar.aoI instanceof EditText) {
            ((EditText) aVar.aoI).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Ax.b(aVar);
        Ax.b(new com.baidu.tbadk.editortools.sendtool.a(Ax.getContext()));
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
