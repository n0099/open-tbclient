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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
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
    private bv aii;
    private TbPageContext<?> dVN;
    private NewWriteModel eBQ;
    private String eBU;
    private c eBX;
    private b eBY;
    private String eCA;
    private DataModel<?> eCB;
    private boolean eCC;
    private NewWriteModel.d eCD;
    private f eCE;
    private w.a eCF;
    private View.OnClickListener eCG;
    private NewWriteModel.d eCe;
    private j eCz;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.eCA = "";
        this.eCC = false;
        this.eBU = null;
        this.eCe = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                if (h.this.eCD != null) {
                    h.this.eCD.callback(z, postWriteCallBackData, adVar, writeData, antiData);
                }
                if (z) {
                    h.this.eCz = null;
                    h.this.eCA = null;
                    h.this.iR(true);
                    h.this.bjK();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData dhF = h.this.eBQ.dhF();
                    h.this.eBQ.d((WriteData) null);
                    h.this.eBQ.vr(false);
                    h.this.mVoiceModel = null;
                    if (dhF != null && dhF != null && dhF.getType() == 2) {
                        h.this.eCB.bjf();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bB(i, str)) {
                    h.this.as(i, str);
                } else if (adVar != null && writeData != null && !StringUtils.isNull(adVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(adVar.getVcode_md5());
                    writeData.setVcodeUrl(adVar.getVcode_pic_url());
                    writeData.setVcodeExtra(adVar.bep());
                    if (h.this.aii != null) {
                        writeData.setBaijiahaoData(h.this.aii.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.bdZ().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.beo())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.bdZ().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.dVN.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.bdZ().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.eCG = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.eBU)) {
                    l.showToast(h.this.bdZ().getPageActivity(), h.this.eBU);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.eCz == null) {
                this.eCz = new j();
            }
            this.eCz.mContent = writeData.getContent();
            this.eCz.eCL = writeData.getSubPbReplyPrefix();
            c(this.eCz);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.dVN = tbPageContext;
    }

    public TbPageContext<?> bdZ() {
        return this.dVN;
    }

    public void setThreadData(bv bvVar) {
        this.aii = bvVar;
    }

    public void zJ(String str) {
        if (this.eCz == null) {
            this.eCz = new j();
        }
        this.eCz.mContent = str;
    }

    public void a(j jVar) {
        this.eCz = jVar;
    }

    public void a(w.a aVar) {
        this.eCF = aVar;
    }

    public void setReplyId(String str) {
        this.eCA = str;
    }

    public void b(DataModel<?> dataModel) {
        this.eCB = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bjg();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.eBQ = new NewWriteModel(tbPageContext);
            this.eBQ.b(this.eCe);
            w.b(this.eCB.bjg(), new w.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.eCz == null) {
                            h.this.eCz = new j();
                        }
                        h.this.eCz.mContent = writeData.getContent();
                        h.this.eCz.eCL = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.eCz);
                    }
                    if (h.this.eCF != null) {
                        h.this.eCF.a(writeData);
                    }
                }
            });
        }
    }

    public boolean bjA() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        H(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (biJ() != null) {
                        biJ().hide();
                    }
                    bjK();
                    iR(true);
                    WriteData dhF = this.eBQ.dhF();
                    this.eBQ.d((WriteData) null);
                    this.eBQ.vr(false);
                    if (dhF != null && dhF != null && dhF.getType() == 2) {
                        this.eCB.bjf();
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
                    if (this.eCD != null) {
                        this.eCD.callback(false, postWriteCallBackData, null, this.eBQ.dhF(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bjI() {
        if (this.eBQ.dhF() == null) {
            WriteData zE = this.eCB.zE(this.eCB.bjg());
            if (zE != null && this.aii != null) {
                zE.setBaijiahaoData(this.aii.getBaijiahaoData());
            }
            this.eBQ.d(zE);
        }
        if (this.eBQ.dhF() != null) {
            this.eBQ.setSpanGroupManager(this.mSpanGroupManager);
            if (this.eCz != null) {
                this.eBQ.dhF().setContent(this.eCz.mContent);
                this.eBQ.dhF().setSubPbReplyPrefix(this.eCz.eCL);
                if (this.aii != null) {
                    this.eBQ.dhF().setBaijiahaoData(this.aii.getBaijiahaoData());
                }
            }
            this.eBQ.dhF().setReplyId(this.eCA);
            if (this.mPostId != null) {
                this.eBQ.dhF().setRepostId(this.eCB.bjg());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.eBQ.dhF().setVoice(this.mVoiceModel.getId());
                    this.eBQ.dhF().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.eBQ.dhF().setVoice(null);
                    this.eBQ.dhF().setVoiceDuringTime(-1);
                }
            } else {
                this.eBQ.dhF().setVoice(null);
                this.eBQ.dhF().setVoiceDuringTime(-1);
            }
            if (!this.eBQ.dmz()) {
                bdZ().showToast(R.string.write_img_limit);
            } else if (this.eBY == null || !this.eBY.bji()) {
                if (this.eBX != null) {
                    this.eBX.bjj();
                }
                if (!this.eBQ.dmw()) {
                }
            }
        }
    }

    public void onDestory() {
        bjJ();
        this.eBQ.cancelLoadData();
    }

    public void onStop() {
    }

    public void bjJ() {
        WriteData writeData = new WriteData(2);
        if (this.eCz != null) {
            writeData.setContent(this.eCz.mContent);
            writeData.setSubPbReplyPrefix(this.eCz.eCL);
        }
        writeData.setReplyId(this.eCA);
        writeData.setThreadId(this.mPostId);
        w.g(this.mPostId, writeData);
    }

    public void bjK() {
        w.f(this.mPostId, (WriteData) null);
    }

    public void as(int i, String str) {
        if (AntiHelper.bB(i, str)) {
            if (AntiHelper.a(this.dVN.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            zN(str);
        } else {
            bdZ().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.eCz != null) {
            pbEditorData.setContent(this.eCz.mContent);
            pbEditorData.setSubPbReplyPrefix(this.eCz.eCL);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.eBU);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.dVN.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g nQ;
        if (antiData != null) {
            this.eBU = antiData.getVoice_message();
            if (!StringUtils.isNull(this.eBU) && biJ() != null && (nQ = biJ().nQ(6)) != null && !TextUtils.isEmpty(this.eBU)) {
                ((View) nQ).setOnClickListener(this.eCG);
            }
        }
    }

    private void zN(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bdZ().getPageActivity());
        aVar.xl(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bdZ()).aYL();
    }

    private void H(ArrayList<String> arrayList) {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bjL() {
        return this.eCC;
    }

    public void iT(boolean z) {
        this.eCC = z;
    }

    public void zO(String str) {
        iT(true);
        biJ().display();
        if (str != null && str.length() != 0) {
            String replace = bdZ().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.eCL = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(bdZ().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        iT(true);
        biJ().display();
        c(jVar);
        TiebaStatic.eventStat(bdZ().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bjM() {
        iT(false);
        biJ().hide();
    }

    public void bjN() {
        iT(true);
        biJ().display();
        biJ().bn((View) biJ().nQ(5));
    }

    public void bjO() {
        iT(true);
        biJ().display();
        biJ().bn((View) biJ().nQ(2));
    }

    public void bjP() {
        iT(true);
        biJ().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void zP(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.eCz != null) {
                if (TextUtils.isEmpty(this.eCz.eCL) && TextUtils.isEmpty(this.eCz.mContent)) {
                    zO(str);
                    return;
                } else if (!TextUtils.isEmpty(this.eCz.eCL) && this.eCz.eCL.equals(replace)) {
                    b(this.eCz);
                    return;
                } else {
                    zO(str);
                    return;
                }
            }
            zO(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR(boolean z) {
        if (biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.eCD = dVar;
    }

    public void a(c cVar) {
        this.eBX = cVar;
    }

    public void a(b bVar) {
        this.eBY = bVar;
    }

    public f bjQ() {
        if (this.eCE == null && biJ() != null) {
            this.eCE = (f) biJ().nT(27);
        }
        return this.eCE;
    }

    public boolean bjR() {
        return (this.eCz == null || as.isEmpty(this.eCz.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void zQ(String str) {
        if (!StringUtils.isNull(str) && biJ() != null) {
            biJ().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }
}
