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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
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
    private TbPageContext<?> aRI;
    private String btU;
    private NewWriteModel btX;
    private String buE;
    private String buF;
    private DataModel<?> buG;
    private boolean buH;
    private NewWriteModel.d buI;
    private AntiData buJ;
    private e buK;
    private View.OnClickListener buL;
    private String bub;
    private c bue;
    private b bug;
    private NewWriteModel.d bum;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.btU = "";
        this.buE = "";
        this.buF = null;
        this.buH = false;
        this.bub = null;
        this.bum = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (h.this.buI != null) {
                    h.this.buI.callback(z, postWriteCallBackData, tVar, writeData, antiData);
                }
                if (z) {
                    h.this.btU = null;
                    h.this.buE = null;
                    h.this.cn(true);
                    h.this.LV();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = h.this.btX.getWriteData();
                    h.this.btX.setWriteData(null);
                    h.this.btX.mT(false);
                    h.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        h.this.buG.Lw();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.vR(i)) {
                    h.this.k(i, str);
                } else if (tVar != null && writeData != null && !StringUtils.isNull(tVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FY());
                    if (com.baidu.tbadk.p.a.hx(tVar.FX())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(h.this.FF().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FX())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(h.this.FF().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(h.this.aRI.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    h.this.FF().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXz));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXz));
            }
        };
        this.buL = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.bub)) {
                    l.showToast(h.this.FF().getPageActivity(), h.this.bub);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.btU = writeData.getContent();
            gF(this.btU);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.aRI = tbPageContext;
    }

    public TbPageContext<?> FF() {
        return this.aRI;
    }

    public void gx(String str) {
        this.btU = str;
    }

    public void setReplyId(String str) {
        this.buE = str;
    }

    public void b(DataModel<?> dataModel) {
        this.buG = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Lx();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.btX = new NewWriteModel(tbPageContext);
            this.btX.b(this.bum);
            u.b(this.buG.Lx(), new u.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.u.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        h.this.btU = writeData.getContent();
                        h.this.gF(h.this.btU);
                    }
                }
            });
        }
    }

    public boolean LO() {
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
                    if (Lc() != null) {
                        Lc().hide();
                    }
                    LV();
                    cn(true);
                    WriteData writeData = this.btX.getWriteData();
                    this.btX.setWriteData(null);
                    this.btX.mT(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.buG.Lw();
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
                    if (this.buI != null) {
                        this.buI.callback(false, postWriteCallBackData, null, this.btX.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void LT() {
        if (this.btX.getWriteData() == null) {
            this.btX.setWriteData(this.buG.gr(this.buG.Lx()));
        }
        if (this.btX.getWriteData() != null) {
            this.btX.getWriteData().setContent(this.btU);
            this.btX.getWriteData().setReplyId(this.buE);
            if (this.mPostId != null) {
                this.btX.getWriteData().setRepostId(this.buG.Lx());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.btX.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.btX.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.btX.getWriteData().setVoice(null);
                    this.btX.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.btX.getWriteData().setVoice(null);
                this.btX.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.btX.byh()) {
                FF().showToast(d.j.write_img_limit);
            } else if (this.bug == null || !this.bug.Lz()) {
                if (this.bue != null) {
                    this.bue.LA();
                }
                if (!this.btX.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        LU();
        this.btX.cancelLoadData();
    }

    public void onStop() {
    }

    public void LU() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.btU);
        writeData.setReplyId(this.buE);
        writeData.setThreadId(this.mPostId);
        u.d(this.mPostId, writeData);
    }

    public void LV() {
        u.c(this.mPostId, (WriteData) null);
    }

    public void k(int i, String str) {
        if (AntiHelper.vR(i)) {
            if (AntiHelper.a(this.aRI.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXz));
            }
        } else if (i == 230277 || i == 230278) {
            gC(str);
        } else {
            FF().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.btU);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.bub);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.aRI.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.l hG;
        this.buJ = antiData;
        if (antiData != null) {
            this.bub = antiData.getVoice_message();
            if (!StringUtils.isNull(this.bub) && Lc() != null && (hG = Lc().hG(6)) != null && !TextUtils.isEmpty(this.bub)) {
                ((View) hG).setOnClickListener(this.buL);
            }
        }
    }

    private void gC(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(FF().getPageActivity());
        aVar.dk(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(FF()).AV();
    }

    private void r(ArrayList<String> arrayList) {
        if (Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean LW() {
        return this.buH;
    }

    public void co(boolean z) {
        this.buH = z;
    }

    public void gD(String str) {
        co(true);
        Lc().th();
        if (str != null && str.length() != 0) {
            gF(FF().getResources().getString(d.j.reply_sub_floor).replace("%s", str));
        } else {
            gF("");
        }
        TiebaStatic.eventStat(FF().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gE(String str) {
        co(true);
        Lc().th();
        gF(str);
        TiebaStatic.eventStat(FF().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void LX() {
        co(false);
        Lc().hide();
    }

    public void LY() {
        co(true);
        Lc().th();
        Lc().bh((View) Lc().hG(5));
    }

    public void LZ() {
        co(true);
        Lc().th();
        Lc().bh((View) Lc().hG(2));
    }

    public void Ma() {
        co(true);
        Lc().th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(String str) {
        if (Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void gG(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (am.isEmpty(this.btU) || this.btU.matches(str2)) {
            if (this.buF != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.buF).lookingAt()) {
                    gE(this.buF);
                    return;
                } else {
                    gD(str);
                    return;
                }
            }
            gD(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.btU);
        this.buF = this.btU;
        if (matcher.lookingAt()) {
            gE(this.btU);
        } else {
            gD(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.buI = dVar;
    }

    public void a(c cVar) {
        this.bue = cVar;
    }

    public void a(b bVar) {
        this.bug = bVar;
    }

    public e Mb() {
        if (this.buK == null && Lc() != null) {
            this.buK = (e) Lc().hI(27);
        }
        return this.buK;
    }
}
