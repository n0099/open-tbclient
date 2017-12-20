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
    private String aDB;
    private NewWriteModel aDE;
    private String aDI;
    private c aDL;
    private b aDM;
    private NewWriteModel.d aDS;
    private String aEm;
    private String aEn;
    private DataModel<?> aEo;
    private boolean aEp;
    private NewWriteModel.d aEq;
    private AntiData aEr;
    private e aEs;
    private View.OnClickListener aEt;
    private TbPageContext<?> abX;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.aDB = "";
        this.aEm = "";
        this.aEn = null;
        this.aEp = false;
        this.aDI = null;
        this.aDS = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
                if (h.this.aEq != null) {
                    h.this.aEq.callback(z, postWriteCallBackData, sVar, writeData, antiData);
                }
                if (z) {
                    h.this.aDB = null;
                    h.this.aEm = null;
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
                    WriteData writeData2 = h.this.aDE.getWriteData();
                    h.this.aDE.setWriteData(null);
                    h.this.aDE.ni(false);
                    h.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        h.this.aEo.Dx();
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.abX.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    h.this.xR().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahL));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahL));
            }
        };
        this.aEt = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.aDI)) {
                    l.showToast(h.this.xR().getPageActivity(), h.this.aDI);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aDB = writeData.getContent();
            gf(this.aDB);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.abX = tbPageContext;
    }

    public TbPageContext<?> xR() {
        return this.abX;
    }

    public String DV() {
        return this.aDB;
    }

    public void fX(String str) {
        this.aDB = str;
    }

    public void setReplyId(String str) {
        this.aEm = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aEo = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Dy();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aDE = new NewWriteModel(tbPageContext);
            this.aDE.b(this.aDS);
            t.b(this.aEo.Dy(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        h.this.aDB = writeData.getContent();
                        h.this.gf(h.this.aDB);
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
                    WriteData writeData = this.aDE.getWriteData();
                    this.aDE.setWriteData(null);
                    this.aDE.ni(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aEo.Dx();
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
                    if (this.aEq != null) {
                        this.aEq.callback(false, postWriteCallBackData, null, this.aDE.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DW() {
        if (this.aDE.getWriteData() == null) {
            this.aDE.setWriteData(this.aEo.fS(this.aEo.Dy()));
        }
        if (this.aDE.getWriteData() != null) {
            this.aDE.getWriteData().setContent(this.aDB);
            this.aDE.getWriteData().setReplyId(this.aEm);
            if (this.mPostId != null) {
                this.aDE.getWriteData().setRepostId(this.aEo.Dy());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aDE.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aDE.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aDE.getWriteData().setVoice(null);
                    this.aDE.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDE.getWriteData().setVoice(null);
                this.aDE.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDE.byc()) {
                xR().showToast(d.j.write_img_limit);
            } else if (this.aDM == null || !this.aDM.DA()) {
                if (this.aDL != null) {
                    this.aDL.DB();
                }
                if (!this.aDE.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        DX();
        this.aDE.cancelLoadData();
    }

    public void onStop() {
    }

    public void DX() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aDB);
        writeData.setReplyId(this.aEm);
        writeData.setThreadId(this.mPostId);
        t.e(this.mPostId, writeData);
    }

    public void DY() {
        t.d(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.uB(i)) {
            if (AntiHelper.a(this.abX.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahL));
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
        pbEditorData.setContent(this.aDB);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aDI);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.abX.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.l eN;
        this.aEr = antiData;
        if (antiData != null) {
            this.aDI = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aDI) && De() != null && (eN = De().eN(6)) != null && !TextUtils.isEmpty(this.aDI)) {
                ((View) eN).setOnClickListener(this.aEt);
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
        return this.aEp;
    }

    public void bH(boolean z) {
        this.aEp = z;
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
        if (am.isEmpty(this.aDB) || this.aDB.matches(str2)) {
            if (this.aEn != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aEn).lookingAt()) {
                    ge(this.aEn);
                    return;
                } else {
                    gd(str);
                    return;
                }
            }
            gd(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aDB);
        this.aEn = this.aDB;
        if (matcher.lookingAt()) {
            ge(this.aDB);
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
        this.aEq = dVar;
    }

    public void a(c cVar) {
        this.aDL = cVar;
    }

    public void a(b bVar) {
        this.aDM = bVar;
    }

    public e Ee() {
        if (this.aEs == null && De() != null) {
            this.aEs = (e) De().eP(27);
        }
        return this.aEs;
    }
}
