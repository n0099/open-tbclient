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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.d {
    private bj agC;
    private String dYC;
    private c dYF;
    private b dYG;
    private NewWriteModel.d dYM;
    private NewWriteModel dYy;
    private j dZg;
    private String dZh;
    private DataModel<?> dZi;
    private boolean dZj;
    private NewWriteModel.d dZk;
    private f dZl;
    private w.a dZm;
    private View.OnClickListener dZn;
    private TbPageContext<?> duK;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.dZh = "";
        this.dZj = false;
        this.dYC = null;
        this.dYM = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (h.this.dZk != null) {
                    h.this.dZk.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                }
                if (z) {
                    h.this.dZg = null;
                    h.this.dZh = null;
                    h.this.hI(true);
                    h.this.aXK();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cSK = h.this.dYy.cSK();
                    h.this.dYy.d((WriteData) null);
                    h.this.dYy.ua(false);
                    h.this.mVoiceModel = null;
                    if (cSK != null && cSK != null && cSK.getType() == 2) {
                        h.this.dZi.aXh();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bq(i, str)) {
                    h.this.ak(i, str);
                } else if (aaVar != null && writeData != null && !StringUtils.isNull(aaVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aSf());
                    if (h.this.agC != null) {
                        writeData.setBaijiahaoData(h.this.agC.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.xr(aaVar.aSe())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.aRP().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aSe())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.aRP().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.duK.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.aRP().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.dZn = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.dYC)) {
                    l.showToast(h.this.aRP().getPageActivity(), h.this.dYC);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.dZg == null) {
                this.dZg = new j();
            }
            this.dZg.mContent = writeData.getContent();
            this.dZg.dZs = writeData.getSubPbReplyPrefix();
            c(this.dZg);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.duK = tbPageContext;
    }

    public TbPageContext<?> aRP() {
        return this.duK;
    }

    public void setThreadData(bj bjVar) {
        this.agC = bjVar;
    }

    public void wE(String str) {
        if (this.dZg == null) {
            this.dZg = new j();
        }
        this.dZg.mContent = str;
    }

    public void a(j jVar) {
        this.dZg = jVar;
    }

    public void a(w.a aVar) {
        this.dZm = aVar;
    }

    public void setReplyId(String str) {
        this.dZh = str;
    }

    public void b(DataModel<?> dataModel) {
        this.dZi = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.aXi();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.dYy = new NewWriteModel(tbPageContext);
            this.dYy.b(this.dYM);
            w.b(this.dZi.aXi(), new w.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.dZg == null) {
                            h.this.dZg = new j();
                        }
                        h.this.dZg.mContent = writeData.getContent();
                        h.this.dZg.dZs = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.dZg);
                    }
                    if (h.this.dZm != null) {
                        h.this.dZm.a(writeData);
                    }
                }
            });
        }
    }

    public boolean aXB() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        G(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (aWN() != null) {
                        aWN().hide();
                    }
                    aXK();
                    hI(true);
                    WriteData cSK = this.dYy.cSK();
                    this.dYy.d((WriteData) null);
                    this.dYy.ua(false);
                    if (cSK != null && cSK != null && cSK.getType() == 2) {
                        this.dZi.aXh();
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
                    if (this.dZk != null) {
                        this.dZk.callback(false, postWriteCallBackData, null, this.dYy.cSK(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void aXI() {
        if (this.dYy.cSK() == null) {
            WriteData wz = this.dZi.wz(this.dZi.aXi());
            if (wz != null && this.agC != null) {
                wz.setBaijiahaoData(this.agC.getBaijiahaoData());
            }
            this.dYy.d(wz);
        }
        if (this.dYy.cSK() != null) {
            if (this.dZg != null) {
                this.dYy.cSK().setContent(this.dZg.mContent);
                this.dYy.cSK().setSubPbReplyPrefix(this.dZg.dZs);
                if (this.agC != null) {
                    this.dYy.cSK().setBaijiahaoData(this.agC.getBaijiahaoData());
                }
            }
            this.dYy.cSK().setReplyId(this.dZh);
            if (this.mPostId != null) {
                this.dYy.cSK().setRepostId(this.dZi.aXi());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dYy.cSK().setVoice(this.mVoiceModel.getId());
                    this.dYy.cSK().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dYy.cSK().setVoice(null);
                    this.dYy.cSK().setVoiceDuringTime(-1);
                }
            } else {
                this.dYy.cSK().setVoice(null);
                this.dYy.cSK().setVoiceDuringTime(-1);
            }
            if (!this.dYy.cXB()) {
                aRP().showToast((int) R.string.write_img_limit);
            } else if (this.dYG == null || !this.dYG.aXk()) {
                if (this.dYF != null) {
                    this.dYF.aXl();
                }
                if (!this.dYy.cXy()) {
                }
            }
        }
    }

    public void onDestory() {
        aXJ();
        this.dYy.cancelLoadData();
    }

    public void onStop() {
    }

    public void aXJ() {
        WriteData writeData = new WriteData(2);
        if (this.dZg != null) {
            writeData.setContent(this.dZg.mContent);
            writeData.setSubPbReplyPrefix(this.dZg.dZs);
        }
        writeData.setReplyId(this.dZh);
        writeData.setThreadId(this.mPostId);
        w.e(this.mPostId, writeData);
    }

    public void aXK() {
        w.d(this.mPostId, (WriteData) null);
    }

    public void ak(int i, String str) {
        if (AntiHelper.bq(i, str)) {
            if (AntiHelper.a(this.duK.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            wI(str);
        } else {
            aRP().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.dZg != null) {
            pbEditorData.setContent(this.dZg.mContent);
            pbEditorData.setSubPbReplyPrefix(this.dZg.dZs);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.dYC);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.duK.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g mA;
        if (antiData != null) {
            this.dYC = antiData.getVoice_message();
            if (!StringUtils.isNull(this.dYC) && aWN() != null && (mA = aWN().mA(6)) != null && !TextUtils.isEmpty(this.dYC)) {
                ((View) mA).setOnClickListener(this.dZn);
            }
        }
    }

    private void wI(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aRP().getPageActivity());
        aVar.ui(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aRP()).aMS();
    }

    private void G(ArrayList<String> arrayList) {
        if (aWN() != null) {
            aWN().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean aXL() {
        return this.dZj;
    }

    public void hJ(boolean z) {
        this.dZj = z;
    }

    public void wJ(String str) {
        hJ(true);
        aWN().display();
        if (str != null && str.length() != 0) {
            String replace = aRP().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.dZs = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(aRP().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        hJ(true);
        aWN().display();
        c(jVar);
        TiebaStatic.eventStat(aRP().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void aXM() {
        hJ(false);
        aWN().hide();
    }

    public void aXN() {
        hJ(true);
        aWN().display();
        aWN().bf((View) aWN().mA(5));
    }

    public void aXO() {
        hJ(true);
        aWN().display();
        aWN().bf((View) aWN().mA(2));
    }

    public void aXP() {
        hJ(true);
        aWN().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (aWN() != null) {
            aWN().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void wK(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.dZg != null) {
                if (TextUtils.isEmpty(this.dZg.dZs) && TextUtils.isEmpty(this.dZg.mContent)) {
                    wJ(str);
                    return;
                } else if (!TextUtils.isEmpty(this.dZg.dZs) && this.dZg.dZs.equals(replace)) {
                    b(this.dZg);
                    return;
                } else {
                    wJ(str);
                    return;
                }
            }
            wJ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(boolean z) {
        if (aWN() != null) {
            aWN().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.dZk = dVar;
    }

    public void a(c cVar) {
        this.dYF = cVar;
    }

    public void a(b bVar) {
        this.dYG = bVar;
    }

    public f aXQ() {
        if (this.dZl == null && aWN() != null) {
            this.dZl = (f) aWN().mD(27);
        }
        return this.dZl;
    }

    public boolean aXR() {
        return (this.dZg == null || aq.isEmpty(this.dZg.mContent)) ? false : true;
    }
}
