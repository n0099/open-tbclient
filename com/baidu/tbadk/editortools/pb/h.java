package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.d {
    private bj Nl;
    private TbPageContext<?> cQU;
    private NewWriteModel dtU;
    private String dtY;
    private j duD;
    private String duE;
    private DataModel<?> duF;
    private boolean duG;
    private NewWriteModel.d duH;
    private f duI;
    private v.a duJ;
    private View.OnClickListener duK;
    private c dub;
    private b duc;
    private NewWriteModel.d dui;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.duE = "";
        this.duG = false;
        this.dtY = null;
        this.dui = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (h.this.duH != null) {
                    h.this.duH.callback(z, postWriteCallBackData, yVar, writeData, antiData);
                }
                if (z) {
                    h.this.duD = null;
                    h.this.duE = null;
                    h.this.gx(true);
                    h.this.aMz();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cFi = h.this.dtU.cFi();
                    h.this.dtU.d((WriteData) null);
                    h.this.dtU.sC(false);
                    h.this.mVoiceModel = null;
                    if (cFi != null && cFi != null && cFi.getType() == 2) {
                        h.this.duF.aLW();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aW(i, str)) {
                    h.this.P(i, str);
                } else if (yVar != null && writeData != null && !StringUtils.isNull(yVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.aGR());
                    if (h.this.Nl != null) {
                        writeData.setBaijiahaoData(h.this.Nl.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.vB(yVar.aGQ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.aGD().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.aGQ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.aGD().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.cQU.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.aGD().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.duK = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.dtY)) {
                    l.showToast(h.this.aGD().getPageActivity(), h.this.dtY);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.duD == null) {
                this.duD = new j();
            }
            this.duD.mContent = writeData.getContent();
            this.duD.duP = writeData.getSubPbReplyPrefix();
            c(this.duD);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cQU = tbPageContext;
    }

    public TbPageContext<?> aGD() {
        return this.cQU;
    }

    public void setThreadData(bj bjVar) {
        this.Nl = bjVar;
    }

    public void uQ(String str) {
        if (this.duD == null) {
            this.duD = new j();
        }
        this.duD.mContent = str;
    }

    public void a(j jVar) {
        this.duD = jVar;
    }

    public void a(v.a aVar) {
        this.duJ = aVar;
    }

    public void setReplyId(String str) {
        this.duE = str;
    }

    public void b(DataModel<?> dataModel) {
        this.duF = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.aLX();
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.dtU = new NewWriteModel(tbPageContext);
            this.dtU.b(this.dui);
            v.b(this.duF.aLX(), new v.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.duD == null) {
                            h.this.duD = new j();
                        }
                        h.this.duD.mContent = writeData.getContent();
                        h.this.duD.duP = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.duD);
                    }
                    if (h.this.duJ != null) {
                        h.this.duJ.a(writeData);
                    }
                }
            });
        }
    }

    public boolean aMq() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        E(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (aLC() != null) {
                        aLC().hide();
                    }
                    aMz();
                    gx(true);
                    WriteData cFi = this.dtU.cFi();
                    this.dtU.d((WriteData) null);
                    this.dtU.sC(false);
                    if (cFi != null && cFi != null && cFi.getType() == 2) {
                        this.duF.aLW();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.duH != null) {
                        this.duH.callback(false, postWriteCallBackData, null, this.dtU.cFi(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void aMx() {
        if (this.dtU.cFi() == null) {
            WriteData uM = this.duF.uM(this.duF.aLX());
            if (uM != null && this.Nl != null) {
                uM.setBaijiahaoData(this.Nl.getBaijiahaoData());
            }
            this.dtU.d(uM);
        }
        if (this.dtU.cFi() != null) {
            if (this.duD != null) {
                this.dtU.cFi().setContent(this.duD.mContent);
                this.dtU.cFi().setSubPbReplyPrefix(this.duD.duP);
                if (this.Nl != null) {
                    this.dtU.cFi().setBaijiahaoData(this.Nl.getBaijiahaoData());
                }
            }
            this.dtU.cFi().setReplyId(this.duE);
            if (this.mPostId != null) {
                this.dtU.cFi().setRepostId(this.duF.aLX());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dtU.cFi().setVoice(this.mVoiceModel.getId());
                    this.dtU.cFi().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dtU.cFi().setVoice(null);
                    this.dtU.cFi().setVoiceDuringTime(-1);
                }
            } else {
                this.dtU.cFi().setVoice(null);
                this.dtU.cFi().setVoiceDuringTime(-1);
            }
            if (!this.dtU.cJJ()) {
                aGD().showToast((int) R.string.write_img_limit);
            } else if (this.duc == null || !this.duc.aLZ()) {
                if (this.dub != null) {
                    this.dub.aMa();
                }
                if (!this.dtU.cJG()) {
                }
            }
        }
    }

    public void onDestory() {
        aMy();
        this.dtU.cancelLoadData();
    }

    public void onStop() {
    }

    public void aMy() {
        WriteData writeData = new WriteData(2);
        if (this.duD != null) {
            writeData.setContent(this.duD.mContent);
            writeData.setSubPbReplyPrefix(this.duD.duP);
        }
        writeData.setReplyId(this.duE);
        writeData.setThreadId(this.mPostId);
        v.e(this.mPostId, writeData);
    }

    public void aMz() {
        v.d(this.mPostId, (WriteData) null);
    }

    public void P(int i, String str) {
        if (AntiHelper.aW(i, str)) {
            if (AntiHelper.a(this.cQU.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            uU(str);
        } else {
            aGD().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.duD != null) {
            pbEditorData.setContent(this.duD.mContent);
            pbEditorData.setSubPbReplyPrefix(this.duD.duP);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.dtY);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cQU.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g lU;
        if (antiData != null) {
            this.dtY = antiData.getVoice_message();
            if (!StringUtils.isNull(this.dtY) && aLC() != null && (lU = aLC().lU(6)) != null && !TextUtils.isEmpty(this.dtY)) {
                ((View) lU).setOnClickListener(this.duK);
            }
        }
    }

    private void uU(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aGD().getPageActivity());
        aVar.sz(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aGD()).aBW();
    }

    private void E(ArrayList<String> arrayList) {
        if (aLC() != null) {
            aLC().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean aMA() {
        return this.duG;
    }

    public void gy(boolean z) {
        this.duG = z;
    }

    public void uV(String str) {
        gy(true);
        aLC().lw();
        if (str != null && str.length() != 0) {
            String replace = aGD().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.duP = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(aGD().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        gy(true);
        aLC().lw();
        c(jVar);
        TiebaStatic.eventStat(aGD().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void aMB() {
        gy(false);
        aLC().hide();
    }

    public void aMC() {
        gy(true);
        aLC().lw();
        aLC().ba((View) aLC().lU(5));
    }

    public void aMD() {
        gy(true);
        aLC().lw();
        aLC().ba((View) aLC().lU(2));
    }

    public void aME() {
        gy(true);
        aLC().lw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (aLC() != null) {
            aLC().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void uW(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.duD != null) {
                if (TextUtils.isEmpty(this.duD.duP) && TextUtils.isEmpty(this.duD.mContent)) {
                    uV(str);
                    return;
                } else if (!TextUtils.isEmpty(this.duD.duP) && this.duD.duP.equals(replace)) {
                    b(this.duD);
                    return;
                } else {
                    uV(str);
                    return;
                }
            }
            uV(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(boolean z) {
        if (aLC() != null) {
            aLC().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.duH = dVar;
    }

    public void a(c cVar) {
        this.dub = cVar;
    }

    public void a(b bVar) {
        this.duc = bVar;
    }

    public f aMF() {
        if (this.duI == null && aLC() != null) {
            this.duI = (f) aLC().lX(27);
        }
        return this.duI;
    }

    public boolean aMG() {
        return (this.duD == null || aq.isEmpty(this.duD.mContent)) ? false : true;
    }
}
