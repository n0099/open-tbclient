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
    private boolean asf = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f am(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(i.c.pb_editor_tool_view_bg_alpha);
        jVar.setBarLinePostion(1);
        return new n(jVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.j Ay = fVar.Ay();
            s sVar = new s(this, (n) fVar, Ay);
            Ay.a(4, sVar);
            Ay.a(7, sVar);
            Ay.a(16, sVar);
            Ay.a(8, sVar);
            Ay.a(10, sVar);
            Ay.a(11, sVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        v vVar;
        com.baidu.tbadk.editortools.j Ay = fVar.Ay();
        Ay.b(new com.baidu.tbadk.editortools.emotiontool.m(Ay.getContext(), 1, false));
        if (com.baidu.tieba.tbadkCore.voice.c.arc() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Ay.getContext()), v.class)) != null && (vVar = (v) runTask.getData()) != null) {
            vVar.aph = 2;
            Ay.b(vVar);
        }
        Ay.b(new com.baidu.tbadk.editortools.a.a(Ay.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(Ay.getContext(), true);
        if (aVar.aox instanceof EditText) {
            ((EditText) aVar.aox).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Ay.b(aVar);
        Ay.b(new com.baidu.tbadk.editortools.sendtool.a(Ay.getContext()));
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
