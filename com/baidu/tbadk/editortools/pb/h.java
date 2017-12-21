package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.f {
    private String aDE;
    private NewWriteModel aDH;
    private String aDL;
    private c aDO;
    private b aDP;
    private NewWriteModel.d aDV;
    private String aEp;
    private String aEq;
    private DataModel<?> aEr;
    private boolean aEs;
    private NewWriteModel.d aEt;
    private AntiData aEu;
    private e aEv;
    private View.OnClickListener aEw;
    private TbPageContext<?> aca;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.aDE = "";
        this.aEp = "";
        this.aEq = null;
        this.aEs = false;
        this.aDL = null;
        this.aDV = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
                if (h.this.aEt != null) {
                    h.this.aEt.callback(z, postWriteCallBackData, sVar, writeData, antiData);
                }
                if (z) {
                    h.this.aDE = null;
                    h.this.aEp = null;
                    h.this.bG(true);
                    h.this.DY();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = h.this.aDH.getWriteData();
                    h.this.aDH.setWriteData(null);
                    h.this.aDH.ni(false);
                    h.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        h.this.aEr.Dx();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.uB(i)) {
                    h.this.l(i, str);
                } else if (sVar != null && writeData != null && !StringUtils.isNull(sVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(sVar.getVcode_md5());
                    writeData.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData.setVcodeExtra(sVar.yk());
                    if (com.baidu.tbadk.p.a.hc(sVar.yj())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.xR().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, sVar.yj())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.xR().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.aca.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    h.this.xR().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahO));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahO));
            }
        };
        this.aEw = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.aDL)) {
                    l.showToast(h.this.xR().getPageActivity(), h.this.aDL);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aDE = writeData.getContent();
            gf(this.aDE);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.aca = tbPageContext;
    }

    public TbPageContext<?> xR() {
        return this.aca;
    }

    public String DV() {
        return this.aDE;
    }

    public void fX(String str) {
        this.aDE = str;
    }

    public void setReplyId(String str) {
        this.aEp = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aEr = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Dy();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aDH = new NewWriteModel(tbPageContext);
            this.aDH.b(this.aDV);
            t.b(this.aEr.Dy(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        h.this.aDE = writeData.getContent();
                        h.this.gf(h.this.aDE);
                    }
                }
            });
        }
    }

    public boolean DQ() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        q(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (De() != null) {
                        De().hide();
                    }
                    DY();
                    bG(true);
                    WriteData writeData = this.aDH.getWriteData();
                    this.aDH.setWriteData(null);
                    this.aDH.ni(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aEr.Dx();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.aEt != null) {
                        this.aEt.callback(false, postWriteCallBackData, null, this.aDH.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DW() {
        if (this.aDH.getWriteData() == null) {
            this.aDH.setWriteData(this.aEr.fS(this.aEr.Dy()));
        }
        if (this.aDH.getWriteData() != null) {
            this.aDH.getWriteData().setContent(this.aDE);
            this.aDH.getWriteData().setReplyId(this.aEp);
            if (this.mPostId != null) {
                this.aDH.getWriteData().setRepostId(this.aEr.Dy());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aDH.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aDH.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aDH.getWriteData().setVoice(null);
                    this.aDH.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDH.getWriteData().setVoice(null);
                this.aDH.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDH.byd()) {
                xR().showToast(d.j.write_img_limit);
            } else if (this.aDP == null || !this.aDP.DA()) {
                if (this.aDO != null) {
                    this.aDO.DB();
                }
                if (!this.aDH.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        DX();
        this.aDH.cancelLoadData();
    }

    public void onStop() {
    }

    public void DX() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aDE);
        writeData.setReplyId(this.aEp);
        writeData.setThreadId(this.mPostId);
        t.e(this.mPostId, writeData);
    }

    public void DY() {
        t.d(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.uB(i)) {
            if (AntiHelper.a(this.aca.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahO));
            }
        } else if (i == 230277 || i == 230278) {
            gc(str);
        } else {
            xR().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aDE);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aDL);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.aca.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.l eN;
        this.aEu = antiData;
        if (antiData != null) {
            this.aDL = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aDL) && De() != null && (eN = De().eN(6)) != null && !TextUtils.isEmpty(this.aDL)) {
                ((View) eN).setOnClickListener(this.aEw);
            }
        }
    }

    private void gc(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xR().getPageActivity());
        aVar.cS(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(xR()).th();
    }

    private void q(ArrayList<String> arrayList) {
        if (De() != null) {
            De().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean DZ() {
        return this.aEs;
    }

    public void bH(boolean z) {
        this.aEs = z;
    }

    public void gd(String str) {
        bH(true);
        De().lE();
        if (str != null && str.length() != 0) {
            gf(xR().getResources().getString(d.j.reply_sub_floor).replace("%s", str));
        } else {
            gf("");
        }
        TiebaStatic.eventStat(xR().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void ge(String str) {
        bH(true);
        De().lE();
        gf(str);
        TiebaStatic.eventStat(xR().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Ea() {
        bH(false);
        De().hide();
    }

    public void Eb() {
        bH(true);
        De().lE();
        De().M((View) De().eN(5));
    }

    public void Ec() {
        bH(true);
        De().lE();
        De().M((View) De().eN(2));
    }

    public void Ed() {
        bH(true);
        De().lE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gf(String str) {
        if (De() != null) {
            De().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void gg(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (am.isEmpty(this.aDE) || this.aDE.matches(str2)) {
            if (this.aEq != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aEq).lookingAt()) {
                    ge(this.aEq);
                    return;
                } else {
                    gd(str);
                    return;
                }
            }
            gd(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aDE);
        this.aEq = this.aDE;
        if (matcher.lookingAt()) {
            ge(this.aDE);
        } else {
            gd(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        if (De() != null) {
            De().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aEt = dVar;
    }

    public void a(c cVar) {
        this.aDO = cVar;
    }

    public void a(b bVar) {
        this.aDP = bVar;
    }

    public e Ee() {
        if (this.aEv == null && De() != null) {
            this.aEv = (e) De().eP(27);
        }
        return this.aEv;
    }
}
