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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.editortools.c {
    private boolean ewd;
    public String ewp;
    private boolean isBJH;

    public i() {
        this(false);
    }

    public i(boolean z) {
        this.ewd = false;
        this.isBJH = false;
        this.isBJH = z;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dP(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(this.isBJH ? 5 : 2);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.ig(false);
        h hVar = new h(editorTools);
        hVar.isBJH = this.isBJH;
        return hVar;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            final EditorTools bfa = dVar.bfa();
            final h hVar = (h) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.i.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    l nB;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                if (aVar.data instanceof j) {
                                    hVar.a((j) aVar.data);
                                } else if (aVar.data instanceof String) {
                                    hVar.yD((String) aVar.data);
                                } else if (aVar.data instanceof SpanGroupManager) {
                                    hVar.yD(aVar.data.toString());
                                    hVar.setSpanGroupManager((SpanGroupManager) aVar.data);
                                }
                                i.this.ewd = false;
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
                                hVar.bac().showToast((int) R.string.over_limit_tip);
                                i.this.ewd = true;
                                return;
                            case 8:
                                if (i.this.a(hVar.bac(), 11001)) {
                                    hVar.bfX();
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
                                if (bfa != null && (nB = bfa.nB(6)) != null && nB.etH != null) {
                                    nB.etH.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (i.this.ewd) {
                                    hVar.bac().showToast((int) R.string.over_limit_tip);
                                }
                                if (i.this.a(hVar.bac(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(hVar.bac().getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            bfa.setActionListener(4, bVar);
            bfa.setActionListener(7, bVar);
            bfa.setActionListener(16, bVar);
            bfa.setActionListener(8, bVar);
            bfa.setActionListener(10, bVar);
            bfa.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        l lVar;
        EditorTools bfa = dVar.bfa();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        bfa.aW(arrayList);
        l nB = bfa.nB(5);
        if (nB != null) {
            nB.ii(false);
            nB.euy = 1;
        }
        if (!this.isBJH) {
            if (com.baidu.tieba.tbadkCore.voice.c.djm() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bfa.getContext()), l.class)) != null && (lVar = (l) runTask.getData()) != null) {
                lVar.euy = 2;
                bfa.b(lVar);
            }
            bfa.b(new com.baidu.tbadk.editortools.a.a(bfa.getContext(), 4));
        }
        f fVar = new f(bfa.getContext(), this.isBJH);
        if (!ar.isEmpty(this.ewp)) {
            fVar.setHint(this.ewp);
        }
        bfa.b(fVar);
        bfa.build();
        bfa.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        bfa.bdC();
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
        this.ewp = str;
    }
}
