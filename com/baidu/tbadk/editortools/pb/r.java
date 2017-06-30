package com.baidu.tbadk.editortools.pb;

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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.d {
    private boolean aBZ = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aR(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(w.e.common_color_10099);
        jVar.bC(true);
        return new n(jVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.j CG = fVar.CG();
            s sVar = new s(this, (n) fVar, CG);
            CG.a(4, sVar);
            CG.a(7, sVar);
            CG.a(16, sVar);
            CG.a(8, sVar);
            CG.a(10, sVar);
            CG.a(11, sVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        x xVar;
        com.baidu.tbadk.editortools.j CG = fVar.CG();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        CG.x(arrayList);
        x eA = CG.eA(5);
        if (eA != null) {
            eA.bE(false);
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bnz() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CG.getContext()), x.class)) != null && (xVar = (x) runTask.getData()) != null) {
            xVar.aAy = 2;
            CG.b(xVar);
        }
        CG.b(new com.baidu.tbadk.editortools.a.a(CG.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(CG.getContext(), true);
        if (aVar.azL instanceof EditText) {
            ((EditText) aVar.azL).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        CG.b(aVar);
        CG.b(new com.baidu.tbadk.editortools.sendtool.a(CG.getContext()));
        CG.CH();
        CG.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        CG.Bb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(w.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
