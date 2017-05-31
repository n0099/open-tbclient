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
    private boolean aAW = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aR(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(w.e.common_color_10099);
        jVar.bB(true);
        return new n(jVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.j Cm = fVar.Cm();
            s sVar = new s(this, (n) fVar, Cm);
            Cm.a(4, sVar);
            Cm.a(7, sVar);
            Cm.a(16, sVar);
            Cm.a(8, sVar);
            Cm.a(10, sVar);
            Cm.a(11, sVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        x xVar;
        com.baidu.tbadk.editortools.j Cm = fVar.Cm();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Cm.v(arrayList);
        if (com.baidu.tieba.tbadkCore.voice.c.bjl() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Cm.getContext()), x.class)) != null && (xVar = (x) runTask.getData()) != null) {
            xVar.azv = 2;
            Cm.b(xVar);
        }
        Cm.b(new com.baidu.tbadk.editortools.a.a(Cm.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(Cm.getContext(), true);
        if (aVar.ayJ instanceof EditText) {
            ((EditText) aVar.ayJ).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Cm.b(aVar);
        Cm.b(new com.baidu.tbadk.editortools.sendtool.a(Cm.getContext()));
        Cm.Cn();
        Cm.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Cm.AG();
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
