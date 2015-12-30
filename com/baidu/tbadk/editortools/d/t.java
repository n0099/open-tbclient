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
    private boolean auy = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f al(Context context) {
        com.baidu.tbadk.editortools.k kVar = new com.baidu.tbadk.editortools.k(context);
        kVar.setBackgroundColorId(0);
        kVar.setBarBackgroundColorId(n.d.pb_editor_tool_view_bg_alpha);
        kVar.setBarLinePostion(1);
        return new p(kVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.k Bj = fVar.Bj();
            u uVar = new u(this, (p) fVar, Bj);
            Bj.a(4, uVar);
            Bj.a(7, uVar);
            Bj.a(16, uVar);
            Bj.a(8, uVar);
            Bj.a(10, uVar);
            Bj.a(11, uVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        y yVar;
        com.baidu.tbadk.editortools.k Bj = fVar.Bj();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Bj.q(arrayList);
        if (com.baidu.tieba.tbadkCore.voice.c.aGy() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Bj.getContext()), y.class)) != null && (yVar = (y) runTask.getData()) != null) {
            yVar.launcherPriority = 2;
            Bj.b(yVar);
        }
        Bj.b(new com.baidu.tbadk.editortools.a.a(Bj.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(Bj.getContext(), true);
        if (aVar.toolView instanceof EditText) {
            ((EditText) aVar.toolView).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Bj.b(aVar);
        Bj.b(new com.baidu.tbadk.editortools.sendtool.a(Bj.getContext()));
        Bj.Bk();
        Bj.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Bj.zK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m411getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(n.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
