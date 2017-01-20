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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.editortools.d {
    private boolean avy = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f ao(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(r.e.common_color_10099);
        jVar.bD(true);
        return new n(jVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.j Cw = fVar.Cw();
            s sVar = new s(this, (n) fVar, Cw);
            Cw.a(4, sVar);
            Cw.a(7, sVar);
            Cw.a(16, sVar);
            Cw.a(8, sVar);
            Cw.a(10, sVar);
            Cw.a(11, sVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        x xVar;
        com.baidu.tbadk.editortools.j Cw = fVar.Cw();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Cw.w(arrayList);
        if (com.baidu.tieba.tbadkCore.voice.c.biS() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Cw.getContext()), x.class)) != null && (xVar = (x) runTask.getData()) != null) {
            xVar.atY = 2;
            Cw.b(xVar);
        }
        Cw.b(new com.baidu.tbadk.editortools.a.a(Cw.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(Cw.getContext(), true);
        if (aVar.atm instanceof EditText) {
            ((EditText) aVar.atm).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Cw.b(aVar);
        Cw.b(new com.baidu.tbadk.editortools.sendtool.a(Cw.getContext()));
        Cw.Cx();
        Cw.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Cw.AK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(r.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
