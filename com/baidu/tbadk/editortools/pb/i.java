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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.editortools.c {
    public String eCI;
    private boolean eCw;
    private boolean isBJH;

    public i() {
        this(false);
    }

    public i(boolean z) {
        this.eCw = false;
        this.isBJH = false;
        this.isBJH = z;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dU(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(this.isBJH ? 5 : 2);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.iK(false);
        h hVar = new h(editorTools);
        hVar.isBJH = this.isBJH;
        return hVar;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            final EditorTools biJ = dVar.biJ();
            final h hVar = (h) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.i.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    l nT;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                if (aVar.data instanceof j) {
                                    hVar.a((j) aVar.data);
                                } else if (aVar.data instanceof String) {
                                    hVar.zJ((String) aVar.data);
                                } else if (aVar.data instanceof SpanGroupManager) {
                                    hVar.zJ(aVar.data.toString());
                                    hVar.setSpanGroupManager((SpanGroupManager) aVar.data);
                                }
                                i.this.eCw = false;
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
                                hVar.bdZ().showToast(R.string.over_limit_tip);
                                i.this.eCw = true;
                                return;
                            case 8:
                                if (i.this.a(hVar.bdZ(), 11001)) {
                                    hVar.bjI();
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
                                if (biJ != null && (nT = biJ.nT(6)) != null && nT.ezZ != null) {
                                    nT.ezZ.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (i.this.eCw) {
                                    hVar.bdZ().showToast(R.string.over_limit_tip);
                                }
                                if (i.this.a(hVar.bdZ(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(hVar.bdZ().getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            biJ.setActionListener(4, bVar);
            biJ.setActionListener(7, bVar);
            biJ.setActionListener(16, bVar);
            biJ.setActionListener(8, bVar);
            biJ.setActionListener(10, bVar);
            biJ.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        l lVar;
        EditorTools biJ = dVar.biJ();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        biJ.bc(arrayList);
        l nT = biJ.nT(5);
        if (nT != null) {
            nT.iM(false);
            nT.eAR = 1;
        }
        if (!this.isBJH) {
            if (com.baidu.tieba.tbadkCore.voice.c.dmv() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, biJ.getContext()), l.class)) != null && (lVar = (l) runTask.getData()) != null) {
                lVar.eAR = 2;
                biJ.b(lVar);
            }
            biJ.b(new com.baidu.tbadk.editortools.a.a(biJ.getContext(), 4));
        }
        f fVar = new f(biJ.getContext(), this.isBJH, false);
        if (!as.isEmpty(this.eCI)) {
            fVar.setHint(this.eCI);
        }
        biJ.b(fVar);
        biJ.build();
        biJ.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        biJ.bhl();
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
        this.eCI = str;
    }
}
