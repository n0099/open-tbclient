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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.e {
    private bw ajX;
    private j ePT;
    private String ePU;
    private DataModel<?> ePV;
    private boolean ePW;
    private NewWriteModel.d ePX;
    private f ePY;
    private x.a ePZ;
    private NewWriteModel ePk;
    private String ePo;
    private c ePr;
    private b ePs;
    private NewWriteModel.d ePy;
    private View.OnClickListener eQa;
    private TbPageContext<?> ehG;
    public boolean isBJH;
    public int mFrom;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.ePU = "";
        this.ePW = false;
        this.ePo = null;
        this.mFrom = 0;
        this.ePy = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (h.this.ePX != null) {
                    h.this.ePX.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    h.this.ePT = null;
                    h.this.ePU = null;
                    h.this.js(true);
                    h.this.btB();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cOG = h.this.ePk.cOG();
                    h.this.ePk.e((WriteData) null);
                    h.this.ePk.wr(false);
                    h.this.mVoiceModel = null;
                    if (cOG != null && cOG != null && cOG.getType() == 2) {
                        h.this.ePV.bsW();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bC(i, str)) {
                    h.this.ar(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bnT());
                    if (h.this.ajX != null) {
                        writeData.setBaijiahaoData(h.this.ajX.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.Dl(ahVar.bnS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.bnz().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bnS())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.bnz().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.ehG.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.bnz().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.eQa = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.ePo)) {
                    l.showToast(h.this.bnz().getPageActivity(), h.this.ePo);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.ePT == null) {
                this.ePT = new j();
            }
            this.ePT.mContent = writeData.getContent();
            this.ePT.eQf = writeData.getSubPbReplyPrefix();
            c(this.ePT);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.ehG = tbPageContext;
    }

    public TbPageContext<?> bnz() {
        return this.ehG;
    }

    public void setThreadData(bw bwVar) {
        this.ajX = bwVar;
    }

    public void Cw(String str) {
        if (this.ePT == null) {
            this.ePT = new j();
        }
        this.ePT.mContent = str;
    }

    public void a(j jVar) {
        this.ePT = jVar;
    }

    public void reset() {
        this.ePk.e((WriteData) null);
        this.ePk.wr(false);
        this.mVoiceModel = null;
    }

    public void a(x.a aVar) {
        this.ePZ = aVar;
    }

    public void setReplyId(String str) {
        this.ePU = str;
    }

    public void b(DataModel<?> dataModel) {
        this.ePV = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bsX();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.ePk = new NewWriteModel(tbPageContext);
            this.ePk.b(this.ePy);
            x.b(this.ePV.bsX(), new x.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.ePT == null) {
                            h.this.ePT = new j();
                        }
                        h.this.ePT.mContent = writeData.getContent();
                        h.this.ePT.eQf = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.ePT);
                    }
                    if (h.this.ePZ != null) {
                        h.this.ePZ.a(writeData);
                    }
                }
            });
        }
    }

    public boolean btr() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        N(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (bsv() != null) {
                        bsv().hide();
                    }
                    btB();
                    js(true);
                    WriteData cOG = this.ePk.cOG();
                    this.ePk.e((WriteData) null);
                    this.ePk.wr(false);
                    if (cOG != null && cOG != null && cOG.getType() == 2) {
                        this.ePV.bsW();
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
                    if (this.ePX != null) {
                        this.ePX.callback(false, postWriteCallBackData, null, this.ePk.cOG(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void btz() {
        if (this.ePk.cOG() == null) {
            WriteData Cr = this.ePV.Cr(this.ePV.bsX());
            if (Cr != null && this.ajX != null) {
                Cr.setBaijiahaoData(this.ajX.getBaijiahaoData());
            }
            this.ePk.e(Cr);
        }
        if (this.ePk.cOG() != null) {
            this.ePk.setSpanGroupManager(this.mSpanGroupManager);
            if (this.ePT != null) {
                this.ePk.cOG().setContent(this.ePT.mContent);
                this.ePk.cOG().setSubPbReplyPrefix(this.ePT.eQf);
                if (this.ajX != null) {
                    this.ePk.cOG().setBaijiahaoData(this.ajX.getBaijiahaoData());
                }
            }
            this.ePk.cOG().setReplyId(this.ePU);
            if (this.mPostId != null) {
                this.ePk.cOG().setRepostId(this.ePV.bsX());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.ePk.cOG().setVoice(this.mVoiceModel.getId());
                    this.ePk.cOG().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.ePk.cOG().setVoice(null);
                    this.ePk.cOG().setVoiceDuringTime(-1);
                }
            } else {
                this.ePk.cOG().setVoice(null);
                this.ePk.cOG().setVoiceDuringTime(-1);
            }
            if (!this.ePk.dBT()) {
                bnz().showToast(R.string.write_img_limit);
            } else if (this.ePs == null || !this.ePs.bsZ()) {
                if (this.ePr != null) {
                    this.ePr.bta();
                }
                c(this.ePk.cOG());
                if (!this.ePk.dBQ()) {
                }
            }
        }
    }

    public void onDestory() {
        btA();
        this.ePk.cancelLoadData();
    }

    public void onStop() {
    }

    public void btA() {
        WriteData writeData = new WriteData(2);
        if (this.ePT != null) {
            writeData.setContent(this.ePT.mContent);
            writeData.setSubPbReplyPrefix(this.ePT.eQf);
        }
        writeData.setReplyId(this.ePU);
        writeData.setThreadId(this.mPostId);
        x.g(this.mPostId, writeData);
    }

    public void btB() {
        x.f(this.mPostId, (WriteData) null);
    }

    public void ar(int i, String str) {
        if (AntiHelper.bC(i, str)) {
            if (AntiHelper.a(this.ehG.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            CA(str);
        } else {
            bnz().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.ePT != null) {
            pbEditorData.setContent(this.ePT.mContent);
            pbEditorData.setSubPbReplyPrefix(this.ePT.eQf);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.ePo);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.ehG.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.h qo;
        if (antiData != null) {
            this.ePo = antiData.getVoice_message();
            if (!StringUtils.isNull(this.ePo) && bsv() != null && (qo = bsv().qo(6)) != null && !TextUtils.isEmpty(this.ePo)) {
                ((View) qo).setOnClickListener(this.eQa);
            }
        }
    }

    private void CA(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bnz().getPageActivity());
        aVar.zV(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bnz()).bia();
    }

    private void N(ArrayList<String> arrayList) {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean btC() {
        return this.ePW;
    }

    public void ju(boolean z) {
        this.ePW = z;
    }

    public void CB(String str) {
        ju(true);
        bsv().display();
        if (str != null && str.length() != 0) {
            String replace = bnz().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.eQf = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(bnz().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        ju(true);
        bsv().display();
        c(jVar);
        TiebaStatic.eventStat(bnz().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void btD() {
        ju(false);
        bsv().hide();
    }

    public void btE() {
        ju(true);
        bsv().display();
        bsv().br((View) bsv().qo(5));
    }

    public void btF() {
        ju(true);
        bsv().display();
        bsv().br((View) bsv().qo(2));
    }

    public void btG() {
        ju(true);
        bsv().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void CC(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.ePT != null) {
                if (TextUtils.isEmpty(this.ePT.eQf) && TextUtils.isEmpty(this.ePT.mContent)) {
                    CB(str);
                    return;
                } else if (!TextUtils.isEmpty(this.ePT.eQf) && this.ePT.eQf.equals(replace)) {
                    b(this.ePT);
                    return;
                } else {
                    CB(str);
                    return;
                }
            }
            CB(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js(boolean z) {
        if (bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.ePX = dVar;
    }

    public void a(c cVar) {
        this.ePr = cVar;
    }

    public void a(b bVar) {
        this.ePs = bVar;
    }

    public f btH() {
        if (this.ePY == null && bsv() != null) {
            this.ePY = (f) bsv().qr(27);
        }
        return this.ePY;
    }

    public boolean btI() {
        return (this.ePT == null || at.isEmpty(this.ePT.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void CD(String str) {
        if (!StringUtils.isNull(str) && bsv() != null) {
            bsv().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }

    public void c(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (!TextUtils.isEmpty(writeData.getContent())) {
                int i2 = 0;
                while (aw.enD.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    aq aqVar = new aq("c13990");
                    aqVar.ai("obj_type", i2);
                    aqVar.ai("obj_source", this.mFrom);
                    aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dF("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar);
                }
            }
            if (writeData.getWriteImagesInfo() != null && !y.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
                for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                    if (imageFileInfo.getImageType() == 1) {
                        i++;
                    }
                }
                if (i > 0 && this.mFrom > 0) {
                    aq aqVar2 = new aq("c13991");
                    aqVar2.ai("obj_type", i);
                    aqVar2.ai("obj_source", this.mFrom);
                    aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dF("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
