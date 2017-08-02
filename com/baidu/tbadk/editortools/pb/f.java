package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.InputFilter;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.d {
    private boolean aDa = false;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aR(Context context) {
        i iVar = new i(context);
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.e.common_color_10099);
        iVar.bF(true);
        return new e(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar != null) {
            final i CS = fVar.CS();
            final e eVar = (e) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.f.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar.fR((String) aVar.data);
                                f.this.aDa = false;
                                return;
                            case 5:
                            case 6:
                            case 9:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            default:
                                return;
                            case 7:
                                eVar.xY().showToast(d.l.over_limit_tip);
                                f.this.aDa = true;
                                return;
                            case 8:
                                if (f.this.a(eVar.xY(), 11001)) {
                                    eVar.DM();
                                    TiebaStatic.log("c10090");
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    eVar.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                }
                                CS.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                                return;
                            case 11:
                                eVar.setVoiceModel(null);
                                CS.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                                return;
                            case 16:
                                if (f.this.aDa) {
                                    eVar.xY().showToast(d.l.over_limit_tip);
                                }
                                if (f.this.a(eVar.xY(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(eVar.xY().getPageActivity(), 12005, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            CS.a(4, bVar);
            CS.a(7, bVar);
            CS.a(16, bVar);
            CS.a(8, bVar);
            CS.a(10, bVar);
            CS.a(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        r rVar;
        i CS = fVar.CS();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        CS.A(arrayList);
        r eC = CS.eC(5);
        if (eC != null) {
            eC.bH(false);
        }
        if (com.baidu.tieba.tbadkCore.voice.c.btw() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CS.getContext()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.aBy = 2;
            CS.b(rVar);
        }
        CS.b(new com.baidu.tbadk.editortools.a.a(CS.getContext(), 4));
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(CS.getContext(), true);
        if (aVar.aAL instanceof EditText) {
            ((EditText) aVar.aAL).setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        }
        CS.b(aVar);
        CS.b(new com.baidu.tbadk.editortools.sendtool.a(CS.getContext()));
        CS.CT();
        CS.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        CS.Bm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
