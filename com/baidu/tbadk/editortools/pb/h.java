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
    private TbPageContext<?> aQs;
    private String brQ;
    private NewWriteModel brT;
    private String brX;
    private String bsB;
    private String bsC;
    private DataModel<?> bsD;
    private boolean bsE;
    private NewWriteModel.d bsF;
    private AntiData bsG;
    private e bsH;
    private View.OnClickListener bsI;
    private c bsa;
    private b bsb;
    private NewWriteModel.d bsh;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.brQ = "";
        this.bsB = "";
        this.bsC = null;
        this.bsE = false;
        this.brX = null;
        this.bsh = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (h.this.bsF != null) {
                    h.this.bsF.callback(z, postWriteCallBackData, tVar, writeData, antiData);
                }
                if (z) {
                    h.this.brQ = null;
                    h.this.bsB = null;
                    h.this.cj(true);
                    h.this.Lp();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = h.this.brT.getWriteData();
                    h.this.brT.setWriteData(null);
                    h.this.brT.mH(false);
                    h.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        h.this.bsD.KP();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.vQ(i)) {
                    h.this.k(i, str);
                } else if (tVar != null && writeData != null && !StringUtils.isNull(tVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FC());
                    if (com.baidu.tbadk.p.a.ho(tVar.FB())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.Fj().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FB())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.Fj().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.aQs.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    h.this.Fj().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aWa));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aWa));
            }
        };
        this.bsI = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.brX)) {
                    l.showToast(h.this.Fj().getPageActivity(), h.this.brX);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.brQ = writeData.getContent();
            gw(this.brQ);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.aQs = tbPageContext;
    }

    public TbPageContext<?> Fj() {
        return this.aQs;
    }

    public void gn(String str) {
        this.brQ = str;
    }

    public void setReplyId(String str) {
        this.bsB = str;
    }

    public void b(DataModel<?> dataModel) {
        this.bsD = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.KQ();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.brT = new NewWriteModel(tbPageContext);
            this.brT.b(this.bsh);
            u.b(this.bsD.KQ(), new u.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.u.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        h.this.brQ = writeData.getContent();
                        h.this.gw(h.this.brQ);
                    }
                }
            });
        }
    }

    public boolean Li() {
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
                    if (Kw() != null) {
                        Kw().hide();
                    }
                    Lp();
                    cj(true);
                    WriteData writeData = this.brT.getWriteData();
                    this.brT.setWriteData(null);
                    this.brT.mH(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.bsD.KP();
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
                    if (this.bsF != null) {
                        this.bsF.callback(false, postWriteCallBackData, null, this.brT.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Ln() {
        if (this.brT.getWriteData() == null) {
            this.brT.setWriteData(this.bsD.gi(this.bsD.KQ()));
        }
        if (this.brT.getWriteData() != null) {
            this.brT.getWriteData().setContent(this.brQ);
            this.brT.getWriteData().setReplyId(this.bsB);
            if (this.mPostId != null) {
                this.brT.getWriteData().setRepostId(this.bsD.KQ());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.brT.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.brT.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.brT.getWriteData().setVoice(null);
                    this.brT.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.brT.getWriteData().setVoice(null);
                this.brT.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.brT.bwT()) {
                Fj().showToast(d.j.write_img_limit);
            } else if (this.bsb == null || !this.bsb.KS()) {
                if (this.bsa != null) {
                    this.bsa.KT();
                }
                if (!this.brT.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        Lo();
        this.brT.cancelLoadData();
    }

    public void onStop() {
    }

    public void Lo() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.brQ);
        writeData.setReplyId(this.bsB);
        writeData.setThreadId(this.mPostId);
        u.d(this.mPostId, writeData);
    }

    public void Lp() {
        u.c(this.mPostId, (WriteData) null);
    }

    public void k(int i, String str) {
        if (AntiHelper.vQ(i)) {
            if (AntiHelper.a(this.aQs.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aWa));
            }
        } else if (i == 230277 || i == 230278) {
            gt(str);
        } else {
            Fj().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.brQ);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.brX);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.aQs.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.l hH;
        this.bsG = antiData;
        if (antiData != null) {
            this.brX = antiData.getVoice_message();
            if (!StringUtils.isNull(this.brX) && Kw() != null && (hH = Kw().hH(6)) != null && !TextUtils.isEmpty(this.brX)) {
                ((View) hH).setOnClickListener(this.bsI);
            }
        }
    }

    private void gt(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Fj().getPageActivity());
        aVar.cZ(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Fj()).AB();
    }

    private void r(ArrayList<String> arrayList) {
        if (Kw() != null) {
            Kw().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean Lq() {
        return this.bsE;
    }

    public void ck(boolean z) {
        this.bsE = z;
    }

    public void gu(String str) {
        ck(true);
        Kw().ti();
        if (str != null && str.length() != 0) {
            gw(Fj().getResources().getString(d.j.reply_sub_floor).replace("%s", str));
        } else {
            gw("");
        }
        TiebaStatic.eventStat(Fj().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gv(String str) {
        ck(true);
        Kw().ti();
        gw(str);
        TiebaStatic.eventStat(Fj().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Lr() {
        ck(false);
        Kw().hide();
    }

    public void Ls() {
        ck(true);
        Kw().ti();
        Kw().bh((View) Kw().hH(5));
    }

    public void Lt() {
        ck(true);
        Kw().ti();
        Kw().bh((View) Kw().hH(2));
    }

    public void Lu() {
        ck(true);
        Kw().ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(String str) {
        if (Kw() != null) {
            Kw().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void gx(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (am.isEmpty(this.brQ) || this.brQ.matches(str2)) {
            if (this.bsC != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.bsC).lookingAt()) {
                    gv(this.bsC);
                    return;
                } else {
                    gu(str);
                    return;
                }
            }
            gu(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.brQ);
        this.bsC = this.brQ;
        if (matcher.lookingAt()) {
            gv(this.brQ);
        } else {
            gu(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(boolean z) {
        if (Kw() != null) {
            Kw().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.bsF = dVar;
    }

    public void a(c cVar) {
        this.bsa = cVar;
    }

    public void a(b bVar) {
        this.bsb = bVar;
    }

    public e Lv() {
        if (this.bsH == null && Kw() != null) {
            this.bsH = (e) Kw().hJ(27);
        }
        return this.bsH;
    }
}
