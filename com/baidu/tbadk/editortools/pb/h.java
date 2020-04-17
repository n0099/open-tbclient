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
    private bj agz;
    private c dYA;
    private b dYB;
    private NewWriteModel.d dYH;
    private NewWriteModel dYt;
    private String dYx;
    private j dZb;
    private String dZc;
    private DataModel<?> dZd;
    private boolean dZe;
    private NewWriteModel.d dZf;
    private f dZg;
    private w.a dZh;
    private View.OnClickListener dZi;
    private TbPageContext<?> duG;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.dZc = "";
        this.dZe = false;
        this.dYx = null;
        this.dYH = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (h.this.dZf != null) {
                    h.this.dZf.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                }
                if (z) {
                    h.this.dZb = null;
                    h.this.dZc = null;
                    h.this.hI(true);
                    h.this.aXM();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cSN = h.this.dYt.cSN();
                    h.this.dYt.d((WriteData) null);
                    h.this.dYt.ua(false);
                    h.this.mVoiceModel = null;
                    if (cSN != null && cSN != null && cSN.getType() == 2) {
                        h.this.dZd.aXj();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bq(i, str)) {
                    h.this.ak(i, str);
                } else if (aaVar != null && writeData != null && !StringUtils.isNull(aaVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aSi());
                    if (h.this.agz != null) {
                        writeData.setBaijiahaoData(h.this.agz.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.xo(aaVar.aSh())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.aRS().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aSh())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.aRS().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.duG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.aRS().showToast(str);
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
        this.dZi = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.dYx)) {
                    l.showToast(h.this.aRS().getPageActivity(), h.this.dYx);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.dZb == null) {
                this.dZb = new j();
            }
            this.dZb.mContent = writeData.getContent();
            this.dZb.dZn = writeData.getSubPbReplyPrefix();
            c(this.dZb);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.duG = tbPageContext;
    }

    public TbPageContext<?> aRS() {
        return this.duG;
    }

    public void setThreadData(bj bjVar) {
        this.agz = bjVar;
    }

    public void wB(String str) {
        if (this.dZb == null) {
            this.dZb = new j();
        }
        this.dZb.mContent = str;
    }

    public void a(j jVar) {
        this.dZb = jVar;
    }

    public void a(w.a aVar) {
        this.dZh = aVar;
    }

    public void setReplyId(String str) {
        this.dZc = str;
    }

    public void b(DataModel<?> dataModel) {
        this.dZd = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.aXk();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.dYt = new NewWriteModel(tbPageContext);
            this.dYt.b(this.dYH);
            w.b(this.dZd.aXk(), new w.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.dZb == null) {
                            h.this.dZb = new j();
                        }
                        h.this.dZb.mContent = writeData.getContent();
                        h.this.dZb.dZn = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.dZb);
                    }
                    if (h.this.dZh != null) {
                        h.this.dZh.a(writeData);
                    }
                }
            });
        }
    }

    public boolean aXD() {
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
                    if (aWP() != null) {
                        aWP().hide();
                    }
                    aXM();
                    hI(true);
                    WriteData cSN = this.dYt.cSN();
                    this.dYt.d((WriteData) null);
                    this.dYt.ua(false);
                    if (cSN != null && cSN != null && cSN.getType() == 2) {
                        this.dZd.aXj();
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
                    if (this.dZf != null) {
                        this.dZf.callback(false, postWriteCallBackData, null, this.dYt.cSN(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void aXK() {
        if (this.dYt.cSN() == null) {
            WriteData ww = this.dZd.ww(this.dZd.aXk());
            if (ww != null && this.agz != null) {
                ww.setBaijiahaoData(this.agz.getBaijiahaoData());
            }
            this.dYt.d(ww);
        }
        if (this.dYt.cSN() != null) {
            if (this.dZb != null) {
                this.dYt.cSN().setContent(this.dZb.mContent);
                this.dYt.cSN().setSubPbReplyPrefix(this.dZb.dZn);
                if (this.agz != null) {
                    this.dYt.cSN().setBaijiahaoData(this.agz.getBaijiahaoData());
                }
            }
            this.dYt.cSN().setReplyId(this.dZc);
            if (this.mPostId != null) {
                this.dYt.cSN().setRepostId(this.dZd.aXk());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dYt.cSN().setVoice(this.mVoiceModel.getId());
                    this.dYt.cSN().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dYt.cSN().setVoice(null);
                    this.dYt.cSN().setVoiceDuringTime(-1);
                }
            } else {
                this.dYt.cSN().setVoice(null);
                this.dYt.cSN().setVoiceDuringTime(-1);
            }
            if (!this.dYt.cXE()) {
                aRS().showToast((int) R.string.write_img_limit);
            } else if (this.dYB == null || !this.dYB.aXm()) {
                if (this.dYA != null) {
                    this.dYA.aXn();
                }
                if (!this.dYt.cXB()) {
                }
            }
        }
    }

    public void onDestory() {
        aXL();
        this.dYt.cancelLoadData();
    }

    public void onStop() {
    }

    public void aXL() {
        WriteData writeData = new WriteData(2);
        if (this.dZb != null) {
            writeData.setContent(this.dZb.mContent);
            writeData.setSubPbReplyPrefix(this.dZb.dZn);
        }
        writeData.setReplyId(this.dZc);
        writeData.setThreadId(this.mPostId);
        w.e(this.mPostId, writeData);
    }

    public void aXM() {
        w.d(this.mPostId, (WriteData) null);
    }

    public void ak(int i, String str) {
        if (AntiHelper.bq(i, str)) {
            if (AntiHelper.a(this.duG.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            wF(str);
        } else {
            aRS().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.dZb != null) {
            pbEditorData.setContent(this.dZb.mContent);
            pbEditorData.setSubPbReplyPrefix(this.dZb.dZn);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.dYx);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.duG.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g mA;
        if (antiData != null) {
            this.dYx = antiData.getVoice_message();
            if (!StringUtils.isNull(this.dYx) && aWP() != null && (mA = aWP().mA(6)) != null && !TextUtils.isEmpty(this.dYx)) {
                ((View) mA).setOnClickListener(this.dZi);
            }
        }
    }

    private void wF(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aRS().getPageActivity());
        aVar.uf(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aRS()).aMU();
    }

    private void G(ArrayList<String> arrayList) {
        if (aWP() != null) {
            aWP().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean aXN() {
        return this.dZe;
    }

    public void hJ(boolean z) {
        this.dZe = z;
    }

    public void wG(String str) {
        hJ(true);
        aWP().display();
        if (str != null && str.length() != 0) {
            String replace = aRS().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.dZn = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(aRS().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        hJ(true);
        aWP().display();
        c(jVar);
        TiebaStatic.eventStat(aRS().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void aXO() {
        hJ(false);
        aWP().hide();
    }

    public void aXP() {
        hJ(true);
        aWP().display();
        aWP().bf((View) aWP().mA(5));
    }

    public void aXQ() {
        hJ(true);
        aWP().display();
        aWP().bf((View) aWP().mA(2));
    }

    public void aXR() {
        hJ(true);
        aWP().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (aWP() != null) {
            aWP().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void wH(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.dZb != null) {
                if (TextUtils.isEmpty(this.dZb.dZn) && TextUtils.isEmpty(this.dZb.mContent)) {
                    wG(str);
                    return;
                } else if (!TextUtils.isEmpty(this.dZb.dZn) && this.dZb.dZn.equals(replace)) {
                    b(this.dZb);
                    return;
                } else {
                    wG(str);
                    return;
                }
            }
            wG(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(boolean z) {
        if (aWP() != null) {
            aWP().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.dZf = dVar;
    }

    public void a(c cVar) {
        this.dYA = cVar;
    }

    public void a(b bVar) {
        this.dYB = bVar;
    }

    public f aXS() {
        if (this.dZg == null && aWP() != null) {
            this.dZg = (f) aWP().mD(27);
        }
        return this.dZg;
    }

    public boolean aXT() {
        return (this.dZb == null || aq.isEmpty(this.dZb.mContent)) ? false : true;
    }
}
