package com.baidu.tbadk.editortools.e;

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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.d {
    private boolean awX = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f ao(Context context) {
        com.baidu.tbadk.editortools.l lVar = new com.baidu.tbadk.editortools.l(context);
        lVar.setBackgroundColorId(0);
        lVar.setBarBackgroundColorId(r.d.common_color_10099);
        lVar.bD(true);
        return new p(lVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.l CO = fVar.CO();
            u uVar = new u(this, (p) fVar, CO);
            CO.a(4, uVar);
            CO.a(7, uVar);
            CO.a(16, uVar);
            CO.a(8, uVar);
            CO.a(10, uVar);
            CO.a(11, uVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        aa aaVar;
        com.baidu.tbadk.editortools.l CO = fVar.CO();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        CO.y(arrayList);
        if (com.baidu.tieba.tbadkCore.voice.c.bnn() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CO.getContext()), aa.class)) != null && (aaVar = (aa) runTask.getData()) != null) {
            aaVar.avw = 2;
            CO.b(aaVar);
        }
        CO.b(new com.baidu.tbadk.editortools.a.a(CO.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(CO.getContext(), true);
        if (aVar.auC instanceof EditText) {
            ((EditText) aVar.auC).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        CO.b(aVar);
        CO.b(new com.baidu.tbadk.editortools.sendtool.a(CO.getContext()));
        CO.CP();
        CO.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        CO.Bc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(r.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
