package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.editortools.c {
    private boolean fGH;
    public String fGT;
    private boolean isBJH;

    public i() {
        this(false);
    }

    public i(boolean z) {
        this.fGH = false;
        this.isBJH = false;
        this.isBJH = z;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e fk(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(this.isBJH ? 5 : 2);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.kP(false);
        h hVar = new h(editorTools);
        hVar.isBJH = this.isBJH;
        return hVar;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar != null) {
            final EditorTools bEI = eVar.bEI();
            final h hVar = (h) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.i.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    m sv;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                if (aVar.data instanceof j) {
                                    hVar.a((j) aVar.data);
                                    hVar.setSpanGroupManager(((j) aVar.data).mSpanGroupManager);
                                } else if (aVar.data instanceof String) {
                                    hVar.DT((String) aVar.data);
                                } else if (aVar.data instanceof SpanGroupManager) {
                                    hVar.DT(aVar.data.toString());
                                    hVar.setSpanGroupManager((SpanGroupManager) aVar.data);
                                }
                                i.this.fGH = false;
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
                                hVar.bzM().showToast(R.string.over_limit_tip);
                                i.this.fGH = true;
                                return;
                            case 8:
                                if (i.this.a(hVar.bzM(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                                    hVar.bFM();
                                    TiebaStatic.log(TbadkCoreStatisticKey.SUBPB_CLICK_SEND);
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    hVar.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                    hVar.a((PostWriteCallBackData) null);
                                    return;
                                }
                                return;
                            case 11:
                                hVar.setVoiceModel(null);
                                if (bEI != null && (sv = bEI.sv(6)) != null && sv.fDH != null) {
                                    sv.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (i.this.fGH) {
                                    hVar.bzM().showToast(R.string.over_limit_tip);
                                }
                                if (i.this.a(hVar.bzM(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(hVar.bzM().getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            bEI.setActionListener(4, bVar);
            bEI.setActionListener(7, bVar);
            bEI.setActionListener(16, bVar);
            bEI.setActionListener(8, bVar);
            bEI.setActionListener(10, bVar);
            bEI.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        EditorTools bEI = eVar.bEI();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        bEI.bL(arrayList);
        m sv = bEI.sv(5);
        if (sv != null) {
            sv.kR(false);
            sv.fEA = 1;
        }
        if (!this.isBJH) {
            if (com.baidu.tieba.tbadkCore.voice.c.dQz() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bEI.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.fEA = 2;
                bEI.b(mVar);
            }
            bEI.b(new com.baidu.tbadk.editortools.a.a(bEI.getContext(), 4));
        }
        f fVar = new f(bEI.getContext(), this.isBJH, false);
        if (!at.isEmpty(this.fGT)) {
            fVar.setHint(this.fGT);
        }
        bEI.b(fVar);
        bEI.build();
        bEI.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        bEI.bDe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    public void setHintText(String str) {
        this.fGT = str;
    }
}
