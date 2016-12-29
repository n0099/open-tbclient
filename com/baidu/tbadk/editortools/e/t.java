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
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.d {
    private boolean awu = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f am(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(r.d.common_color_10099);
        jVar.bD(true);
        return new p(jVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.j CB = fVar.CB();
            u uVar = new u(this, (p) fVar, CB);
            CB.a(4, uVar);
            CB.a(7, uVar);
            CB.a(16, uVar);
            CB.a(8, uVar);
            CB.a(10, uVar);
            CB.a(11, uVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        x xVar;
        com.baidu.tbadk.editortools.j CB = fVar.CB();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        CB.y(arrayList);
        if (com.baidu.tieba.tbadkCore.voice.c.bhh() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CB.getContext()), x.class)) != null && (xVar = (x) runTask.getData()) != null) {
            xVar.auT = 2;
            CB.b(xVar);
        }
        CB.b(new com.baidu.tbadk.editortools.a.a(CB.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(CB.getContext(), true);
        if (aVar.auh instanceof EditText) {
            ((EditText) aVar.auh).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        CB.b(aVar);
        CB.b(new com.baidu.tbadk.editortools.sendtool.a(CB.getContext()));
        CB.CC();
        CB.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        CB.AP();
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
