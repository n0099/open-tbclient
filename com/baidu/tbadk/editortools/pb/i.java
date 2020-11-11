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
    public String fqA;
    private boolean fqo;
    private boolean isBJH;

    public i() {
        this(false);
    }

    public i(boolean z) {
        this.fqo = false;
        this.isBJH = false;
        this.isBJH = z;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e ej(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarLauncherType(this.isBJH ? 5 : 2);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.kc(false);
        h hVar = new h(editorTools);
        hVar.isBJH = this.isBJH;
        return hVar;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar != null) {
            final EditorTools bzx = eVar.bzx();
            final h hVar = (h) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.i.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    m rk;
                    if (aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                if (aVar.data instanceof j) {
                                    hVar.a((j) aVar.data);
                                    hVar.setSpanGroupManager(((j) aVar.data).mSpanGroupManager);
                                } else if (aVar.data instanceof String) {
                                    hVar.DP((String) aVar.data);
                                } else if (aVar.data instanceof SpanGroupManager) {
                                    hVar.DP(aVar.data.toString());
                                    hVar.setSpanGroupManager((SpanGroupManager) aVar.data);
                                }
                                i.this.fqo = false;
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
                                hVar.buC().showToast(R.string.over_limit_tip);
                                i.this.fqo = true;
                                return;
                            case 8:
                                if (i.this.a(hVar.buC(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                                    hVar.bAB();
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
                                if (bzx != null && (rk = bzx.rk(6)) != null && rk.fnp != null) {
                                    rk.fnp.a(new com.baidu.tbadk.editortools.a(52, 0, null));
                                    return;
                                }
                                return;
                            case 16:
                                if (i.this.fqo) {
                                    hVar.buC().showToast(R.string.over_limit_tip);
                                }
                                if (i.this.a(hVar.buC(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(hVar.buC().getPageActivity(), RequestResponseCode.REQUEST_SUB_PB_AT_SELECT, true)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            bzx.setActionListener(4, bVar);
            bzx.setActionListener(7, bVar);
            bzx.setActionListener(16, bVar);
            bzx.setActionListener(8, bVar);
            bzx.setActionListener(10, bVar);
            bzx.setActionListener(11, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        EditorTools bzx = eVar.bzx();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        bzx.bA(arrayList);
        m rk = bzx.rk(5);
        if (rk != null) {
            rk.ke(false);
            rk.foi = 1;
        }
        if (!this.isBJH) {
            if (com.baidu.tieba.tbadkCore.voice.c.dLl() && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bzx.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
                mVar.foi = 2;
                bzx.b(mVar);
            }
            bzx.b(new com.baidu.tbadk.editortools.a.a(bzx.getContext(), 4));
        }
        f fVar = new f(bzx.getContext(), this.isBJH, false);
        if (!at.isEmpty(this.fqA)) {
            fVar.setHint(this.fqA);
        }
        bzx.b(fVar);
        bzx.build();
        bzx.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        bzx.bxU();
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
        this.fqA = str;
    }
}
