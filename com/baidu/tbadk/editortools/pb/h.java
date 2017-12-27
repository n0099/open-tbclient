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
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.f {
    private TbPageContext<?> aQq;
    private NewWriteModel brB;
    private String brF;
    private c brI;
    private b brJ;
    private NewWriteModel.d brP;
    private String bry;
    private String bsj;
    private String bsk;
    private DataModel<?> bsl;
    private boolean bsm;
    private NewWriteModel.d bsn;
    private AntiData bso;
    private e bsp;
    private View.OnClickListener bsq;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.bry = "";
        this.bsj = "";
        this.bsk = null;
        this.bsm = false;
        this.brF = null;
        this.brP = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
                if (h.this.bsn != null) {
                    h.this.bsn.callback(z, postWriteCallBackData, sVar, writeData, antiData);
                }
                if (z) {
                    h.this.bry = null;
                    h.this.bsj = null;
                    h.this.ck(true);
                    h.this.Lz();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = h.this.brB.getWriteData();
                    h.this.brB.setWriteData(null);
                    h.this.brB.nC(false);
                    h.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        h.this.bsl.KY();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.xo(i)) {
                    h.this.k(i, str);
                } else if (sVar != null && writeData != null && !StringUtils.isNull(sVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(sVar.getVcode_md5());
                    writeData.setVcodeUrl(sVar.getVcode_pic_url());
                    writeData.setVcodeExtra(sVar.FJ());
                    if (com.baidu.tbadk.p.a.hf(sVar.FI())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.Fq().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, sVar.FI())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.Fq().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.aQq.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    h.this.Fq().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aVY));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aVY));
            }
        };
        this.bsq = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.brF)) {
                    l.showToast(h.this.Fq().getPageActivity(), h.this.brF);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.bry = writeData.getContent();
            gm(this.bry);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.aQq = tbPageContext;
    }

    public TbPageContext<?> Fq() {
        return this.aQq;
    }

    public String Lw() {
        return this.bry;
    }

    public void ge(String str) {
        this.bry = str;
    }

    public void setReplyId(String str) {
        this.bsj = str;
    }

    public void b(DataModel<?> dataModel) {
        this.bsl = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.KZ();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.brB = new NewWriteModel(tbPageContext);
            this.brB.b(this.brP);
            u.b(this.bsl.KZ(), new u.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.u.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        h.this.bry = writeData.getContent();
                        h.this.gm(h.this.bry);
                    }
                }
            });
        }
    }

    public boolean Lr() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        r(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (KF() != null) {
                        KF().hide();
                    }
                    Lz();
                    ck(true);
                    WriteData writeData = this.brB.getWriteData();
                    this.brB.setWriteData(null);
                    this.brB.nC(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.bsl.KY();
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
                    if (this.bsn != null) {
                        this.bsn.callback(false, postWriteCallBackData, null, this.brB.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Lx() {
        if (this.brB.getWriteData() == null) {
            this.brB.setWriteData(this.bsl.fZ(this.bsl.KZ()));
        }
        if (this.brB.getWriteData() != null) {
            this.brB.getWriteData().setContent(this.bry);
            this.brB.getWriteData().setReplyId(this.bsj);
            if (this.mPostId != null) {
                this.brB.getWriteData().setRepostId(this.bsl.KZ());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.brB.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.brB.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.brB.getWriteData().setVoice(null);
                    this.brB.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.brB.getWriteData().setVoice(null);
                this.brB.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.brB.bDu()) {
                Fq().showToast(d.j.write_img_limit);
            } else if (this.brJ == null || !this.brJ.Lb()) {
                if (this.brI != null) {
                    this.brI.Lc();
                }
                if (!this.brB.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        Ly();
        this.brB.cancelLoadData();
    }

    public void onStop() {
    }

    public void Ly() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.bry);
        writeData.setReplyId(this.bsj);
        writeData.setThreadId(this.mPostId);
        u.d(this.mPostId, writeData);
    }

    public void Lz() {
        u.c(this.mPostId, (WriteData) null);
    }

    public void k(int i, String str) {
        if (AntiHelper.xo(i)) {
            if (AntiHelper.a(this.aQq.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aVY));
            }
        } else if (i == 230277 || i == 230278) {
            gj(str);
        } else {
            Fq().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.bry);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.brF);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.aQq.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.l hL;
        this.bso = antiData;
        if (antiData != null) {
            this.brF = antiData.getVoice_message();
            if (!StringUtils.isNull(this.brF) && KF() != null && (hL = KF().hL(6)) != null && !TextUtils.isEmpty(this.brF)) {
                ((View) hL).setOnClickListener(this.bsq);
            }
        }
    }

    private void gj(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Fq().getPageActivity());
        aVar.cZ(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Fq()).AI();
    }

    private void r(ArrayList<String> arrayList) {
        if (KF() != null) {
            KF().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean LA() {
        return this.bsm;
    }

    public void cl(boolean z) {
        this.bsm = z;
    }

    public void gk(String str) {
        cl(true);
        KF().th();
        if (str != null && str.length() != 0) {
            gm(Fq().getResources().getString(d.j.reply_sub_floor).replace("%s", str));
        } else {
            gm("");
        }
        TiebaStatic.eventStat(Fq().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gl(String str) {
        cl(true);
        KF().th();
        gm(str);
        TiebaStatic.eventStat(Fq().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void LB() {
        cl(false);
        KF().hide();
    }

    public void LC() {
        cl(true);
        KF().th();
        KF().bf((View) KF().hL(5));
    }

    public void LD() {
        cl(true);
        KF().th();
        KF().bf((View) KF().hL(2));
    }

    public void LE() {
        cl(true);
        KF().th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(String str) {
        if (KF() != null) {
            KF().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void gn(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (am.isEmpty(this.bry) || this.bry.matches(str2)) {
            if (this.bsk != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.bsk).lookingAt()) {
                    gl(this.bsk);
                    return;
                } else {
                    gk(str);
                    return;
                }
            }
            gk(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.bry);
        this.bsk = this.bry;
        if (matcher.lookingAt()) {
            gl(this.bry);
        } else {
            gk(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(boolean z) {
        if (KF() != null) {
            KF().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.bsn = dVar;
    }

    public void a(c cVar) {
        this.brI = cVar;
    }

    public void a(b bVar) {
        this.brJ = bVar;
    }

    public e LF() {
        if (this.bsp == null && KF() != null) {
            this.bsp = (e) KF().hN(27);
        }
        return this.bsp;
    }
}
