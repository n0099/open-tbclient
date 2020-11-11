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
    private bw akq;
    private TbPageContext<?> eIc;
    private NewWriteModel fpI;
    private String fpM;
    private c fpP;
    private b fpQ;
    private NewWriteModel.d fpW;
    private j fqr;
    private String fqs;
    private DataModel<?> fqt;
    private boolean fqu;
    private NewWriteModel.d fqv;
    private f fqw;
    private x.a fqx;
    private View.OnClickListener fqy;
    public boolean isBJH;
    public int mFrom;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.fqs = "";
        this.fqu = false;
        this.fpM = null;
        this.mFrom = 0;
        this.fpW = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (h.this.fqv != null) {
                    h.this.fqv.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    h.this.fqr = null;
                    h.this.fqs = null;
                    h.this.km(true);
                    h.this.bAD();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cXW = h.this.fpI.cXW();
                    h.this.fpI.e((WriteData) null);
                    h.this.fpI.xy(false);
                    h.this.mVoiceModel = null;
                    if (cXW != null && cXW != null && cXW.getType() == 2) {
                        h.this.fqt.bzY();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bR(i, str)) {
                    h.this.aI(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.buW());
                    if (h.this.akq != null) {
                        writeData.setBaijiahaoData(h.this.akq.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.EE(ahVar.buV())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.buC().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.buV())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.buC().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.eIc.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.buC().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).al("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).al("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fqy = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.fpM)) {
                    l.showToast(h.this.buC().getPageActivity(), h.this.fpM);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.fqr == null) {
                this.fqr = new j();
            }
            this.fqr.mContent = writeData.getContent();
            this.fqr.fqD = writeData.getSubPbReplyPrefix();
            c(this.fqr);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eIc = tbPageContext;
    }

    public TbPageContext<?> buC() {
        return this.eIc;
    }

    public void setThreadData(bw bwVar) {
        this.akq = bwVar;
    }

    public void DP(String str) {
        if (this.fqr == null) {
            this.fqr = new j();
        }
        this.fqr.mContent = str;
    }

    public void a(j jVar) {
        this.fqr = jVar;
    }

    public void reset() {
        this.fpI.e((WriteData) null);
        this.fpI.xy(false);
        this.mVoiceModel = null;
    }

    public void a(x.a aVar) {
        this.fqx = aVar;
    }

    public void setReplyId(String str) {
        this.fqs = str;
    }

    public void b(DataModel<?> dataModel) {
        this.fqt = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bzZ();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.fpI = new NewWriteModel(tbPageContext);
            this.fpI.b(this.fpW);
            x.b(this.fqt.bzZ(), new x.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.fqr == null) {
                            h.this.fqr = new j();
                        }
                        h.this.fqr.mContent = writeData.getContent();
                        h.this.fqr.fqD = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.fqr);
                    }
                    if (h.this.fqx != null) {
                        h.this.fqx.a(writeData);
                    }
                }
            });
        }
    }

    public boolean bAt() {
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
                    if (bzx() != null) {
                        bzx().hide();
                    }
                    bAD();
                    km(true);
                    WriteData cXW = this.fpI.cXW();
                    this.fpI.e((WriteData) null);
                    this.fpI.xy(false);
                    if (cXW != null && cXW != null && cXW.getType() == 2) {
                        this.fqt.bzY();
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
                    if (this.fqv != null) {
                        this.fqv.callback(false, postWriteCallBackData, null, this.fpI.cXW(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bAB() {
        if (this.fpI.cXW() == null) {
            WriteData DK = this.fqt.DK(this.fqt.bzZ());
            if (DK != null && this.akq != null) {
                DK.setBaijiahaoData(this.akq.getBaijiahaoData());
            }
            this.fpI.e(DK);
        }
        if (this.fpI.cXW() != null) {
            this.fpI.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fqr != null) {
                this.fpI.cXW().setContent(this.fqr.mContent);
                this.fpI.cXW().setSubPbReplyPrefix(this.fqr.fqD);
                if (this.akq != null) {
                    this.fpI.cXW().setBaijiahaoData(this.akq.getBaijiahaoData());
                }
            }
            this.fpI.cXW().setReplyId(this.fqs);
            if (this.mPostId != null) {
                this.fpI.cXW().setRepostId(this.fqt.bzZ());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fpI.cXW().setVoice(this.mVoiceModel.getId());
                    this.fpI.cXW().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fpI.cXW().setVoice(null);
                    this.fpI.cXW().setVoiceDuringTime(-1);
                }
            } else {
                this.fpI.cXW().setVoice(null);
                this.fpI.cXW().setVoiceDuringTime(-1);
            }
            if (!this.fpI.dLp()) {
                buC().showToast(R.string.write_img_limit);
            } else if (this.fpQ == null || !this.fpQ.bAb()) {
                if (this.fpP != null) {
                    this.fpP.bAc();
                }
                c(this.fpI.cXW());
                if (!this.fpI.dLm()) {
                }
            }
        }
    }

    public void onDestory() {
        bAC();
        this.fpI.cancelLoadData();
    }

    public void onStop() {
    }

    public void bAC() {
        WriteData writeData = new WriteData(2);
        if (this.fqr != null) {
            writeData.setContent(this.fqr.mContent);
            writeData.setSubPbReplyPrefix(this.fqr.fqD);
        }
        writeData.setReplyId(this.fqs);
        writeData.setThreadId(this.mPostId);
        x.g(this.mPostId, writeData);
    }

    public void bAD() {
        x.f(this.mPostId, (WriteData) null);
    }

    public void aI(int i, String str) {
        if (AntiHelper.bR(i, str)) {
            if (AntiHelper.a(this.eIc.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).al("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            DT(str);
        } else {
            buC().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.fqr != null) {
            pbEditorData.setContent(this.fqr.mContent);
            pbEditorData.setSubPbReplyPrefix(this.fqr.fqD);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.fpM);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eIc.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.h rh;
        if (antiData != null) {
            this.fpM = antiData.getVoice_message();
            if (!StringUtils.isNull(this.fpM) && bzx() != null && (rh = bzx().rh(6)) != null && !TextUtils.isEmpty(this.fpM)) {
                ((View) rh).setOnClickListener(this.fqy);
            }
        }
    }

    private void DT(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(buC().getPageActivity());
        aVar.Bo(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(buC()).bpc();
    }

    private void N(ArrayList<String> arrayList) {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bAE() {
        return this.fqu;
    }

    public void ko(boolean z) {
        this.fqu = z;
    }

    public void DU(String str) {
        ko(true);
        bzx().display();
        if (str != null && str.length() != 0) {
            String replace = buC().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.fqD = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(buC().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        ko(true);
        bzx().display();
        c(jVar);
        TiebaStatic.eventStat(buC().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bAF() {
        ko(false);
        bzx().hide();
    }

    public void bAG() {
        ko(true);
        bzx().display();
        bzx().bA((View) bzx().rh(5));
    }

    public void bAH() {
        ko(true);
        bzx().display();
        bzx().bA((View) bzx().rh(2));
    }

    public void bAI() {
        ko(true);
        bzx().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void DV(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.fqr != null) {
                if (TextUtils.isEmpty(this.fqr.fqD) && TextUtils.isEmpty(this.fqr.mContent)) {
                    DU(str);
                    return;
                } else if (!TextUtils.isEmpty(this.fqr.fqD) && this.fqr.fqD.equals(replace)) {
                    b(this.fqr);
                    return;
                } else {
                    DU(str);
                    return;
                }
            }
            DU(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km(boolean z) {
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.fqv = dVar;
    }

    public void a(c cVar) {
        this.fpP = cVar;
    }

    public void a(b bVar) {
        this.fpQ = bVar;
    }

    public f bAJ() {
        if (this.fqw == null && bzx() != null) {
            this.fqw = (f) bzx().rk(27);
        }
        return this.fqw;
    }

    public boolean bAK() {
        return (this.fqr == null || at.isEmpty(this.fqr.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void DW(String str) {
        if (!StringUtils.isNull(str) && bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }

    public void c(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (!TextUtils.isEmpty(writeData.getContent())) {
                int i2 = 0;
                while (aw.eNW.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    aq aqVar = new aq("c13990");
                    aqVar.al("obj_type", i2);
                    aqVar.al("obj_source", this.mFrom);
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dR("tid", writeData.getThreadId());
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
                    aqVar2.al("obj_type", i);
                    aqVar2.al("obj_source", this.mFrom);
                    aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
