package com.baidu.tbadk.editortools.d;

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
import com.baidu.tbadk.editortools.aa;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.d {
    private boolean avQ = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f ai(Context context) {
        com.baidu.tbadk.editortools.l lVar = new com.baidu.tbadk.editortools.l(context);
        lVar.setBackgroundColorId(0);
        lVar.setBarBackgroundColorId(t.d.pb_editor_tool_view_bg_alpha);
        lVar.setBarLinePostion(1);
        return new p(lVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.l Dh = fVar.Dh();
            u uVar = new u(this, (p) fVar, Dh);
            Dh.a(4, uVar);
            Dh.a(7, uVar);
            Dh.a(16, uVar);
            Dh.a(8, uVar);
            Dh.a(10, uVar);
            Dh.a(11, uVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        aa aaVar;
        com.baidu.tbadk.editortools.l Dh = fVar.Dh();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Dh.v(arrayList);
        if (com.baidu.tieba.tbadkCore.voice.c.aUE() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Dh.getContext()), aa.class)) != null && (aaVar = (aa) runTask.getData()) != null) {
            aaVar.launcherPriority = 2;
            Dh.b(aaVar);
        }
        Dh.b(new com.baidu.tbadk.editortools.a.a(Dh.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(Dh.getContext(), true);
        if (aVar.toolView instanceof EditText) {
            ((EditText) aVar.toolView).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Dh.b(aVar);
        Dh.b(new com.baidu.tbadk.editortools.sendtool.a(Dh.getContext()));
        Dh.Di();
        Dh.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Dh.BD();
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
