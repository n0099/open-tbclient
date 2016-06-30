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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.d {
    private boolean asF = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f ag(Context context) {
        com.baidu.tbadk.editortools.l lVar = new com.baidu.tbadk.editortools.l(context);
        lVar.setBackgroundColorId(0);
        lVar.setBarBackgroundColorId(u.d.common_color_10099);
        lVar.bv(true);
        return new p(lVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            com.baidu.tbadk.editortools.l Bl = fVar.Bl();
            u uVar = new u(this, (p) fVar, Bl);
            Bl.a(4, uVar);
            Bl.a(7, uVar);
            Bl.a(16, uVar);
            Bl.a(8, uVar);
            Bl.a(10, uVar);
            Bl.a(11, uVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        aa aaVar;
        com.baidu.tbadk.editortools.l Bl = fVar.Bl();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        Bl.y(arrayList);
        if (com.baidu.tieba.tbadkCore.voice.c.bdt() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Bl.getContext()), aa.class)) != null && (aaVar = (aa) runTask.getData()) != null) {
            aaVar.ard = 2;
            Bl.b(aaVar);
        }
        Bl.b(new com.baidu.tbadk.editortools.a.a(Bl.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(Bl.getContext(), true);
        if (aVar.aqi instanceof EditText) {
            ((EditText) aVar.aqi).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        Bl.b(aVar);
        Bl.b(new com.baidu.tbadk.editortools.sendtool.a(Bl.getContext()));
        Bl.Bm();
        Bl.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        Bl.zD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(u.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
