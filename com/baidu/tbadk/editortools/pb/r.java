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
    private boolean aBj = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aO(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(w.e.common_color_10099);
        jVar.bE(true);
        return new n(jVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.j Dn = fVar.Dn();
            s sVar = new s(this, (n) fVar, Dn);
            Dn.a(4, sVar);
            Dn.a(7, sVar);
            Dn.a(16, sVar);
            Dn.a(8, sVar);
            Dn.a(10, sVar);
            Dn.a(11, sVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        x xVar;
        com.baidu.tbadk.editortools.j Dn = fVar.Dn();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Dn.u(arrayList);
        if (com.baidu.tieba.tbadkCore.voice.c.bjt() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Dn.getContext()), x.class)) != null && (xVar = (x) runTask.getData()) != null) {
            xVar.azJ = 2;
            Dn.b(xVar);
        }
        Dn.b(new com.baidu.tbadk.editortools.a.a(Dn.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(Dn.getContext(), true);
        if (aVar.ayX instanceof EditText) {
            ((EditText) aVar.ayX).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Dn.b(aVar);
        Dn.b(new com.baidu.tbadk.editortools.sendtool.a(Dn.getContext()));
        Dn.Do();
        Dn.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Dn.BC();
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
