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
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.d {
    private boolean asU = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f am(Context context) {
        com.baidu.tbadk.editortools.k kVar = new com.baidu.tbadk.editortools.k(context);
        kVar.setBackgroundColorId(0);
        kVar.setBarBackgroundColorId(n.c.pb_editor_tool_view_bg_alpha);
        kVar.setBarLinePostion(1);
        return new p(kVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.k Bu = fVar.Bu();
            u uVar = new u(this, (p) fVar, Bu);
            Bu.a(4, uVar);
            Bu.a(7, uVar);
            Bu.a(16, uVar);
            Bu.a(8, uVar);
            Bu.a(10, uVar);
            Bu.a(11, uVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        y yVar;
        com.baidu.tbadk.editortools.k Bu = fVar.Bu();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Bu.p(arrayList);
        if (com.baidu.tieba.tbadkCore.voice.b.aEk() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Bu.getContext()), y.class)) != null && (yVar = (y) runTask.getData()) != null) {
            yVar.launcherPriority = 2;
            Bu.b(yVar);
        }
        Bu.b(new com.baidu.tbadk.editortools.a.a(Bu.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(Bu.getContext(), true);
        if (aVar.toolView instanceof EditText) {
            ((EditText) aVar.toolView).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Bu.b(aVar);
        Bu.b(new com.baidu.tbadk.editortools.sendtool.a(Bu.getContext()));
        Bu.Bv();
        Bu.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Bu.zY();
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
