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
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.d {
    private boolean aqR = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f al(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(i.c.pb_editor_tool_view_bg_alpha);
        jVar.setBarLinePostion(1);
        return new p(jVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.j Az = fVar.Az();
            u uVar = new u(this, (p) fVar, Az);
            Az.a(4, uVar);
            Az.a(7, uVar);
            Az.a(16, uVar);
            Az.a(8, uVar);
            Az.a(10, uVar);
            Az.a(11, uVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        w wVar;
        com.baidu.tbadk.editortools.j Az = fVar.Az();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Az.q(arrayList);
        if (com.baidu.tieba.tbadkCore.voice.b.ayS() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Az.getContext()), w.class)) != null && (wVar = (w) runTask.getData()) != null) {
            wVar.launcherPriority = 2;
            Az.b(wVar);
        }
        Az.b(new com.baidu.tbadk.editortools.a.a(Az.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(Az.getContext(), true);
        if (aVar.toolView instanceof EditText) {
            ((EditText) aVar.toolView).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Az.b(aVar);
        Az.b(new com.baidu.tbadk.editortools.sendtool.a(Az.getContext()));
        Az.AA();
        Az.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
