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
    private TbPageContext<?> aQp;
    private String brH;
    private NewWriteModel brK;
    private String brO;
    private c brR;
    private b brS;
    private NewWriteModel.d brY;
    private String bss;
    private String bst;
    private DataModel<?> bsu;
    private boolean bsv;
    private NewWriteModel.d bsw;
    private AntiData bsx;
    private e bsy;
    private View.OnClickListener bsz;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.brH = "";
        this.bss = "";
        this.bst = null;
        this.bsv = false;
        this.brO = null;
        this.brY = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (h.this.bsw != null) {
                    h.this.bsw.callback(z, postWriteCallBackData, tVar, writeData, antiData);
                }
                if (z) {
                    h.this.brH = null;
                    h.this.bss = null;
                    h.this.ci(true);
                    h.this.Ln();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = h.this.brK.getWriteData();
                    h.this.brK.setWriteData(null);
                    h.this.brK.mE(false);
                    h.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        h.this.bsu.KN();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.vQ(i)) {
                    h.this.k(i, str);
                } else if (tVar != null && writeData != null && !StringUtils.isNull(tVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FA());
                    if (com.baidu.tbadk.p.a.hg(tVar.Fz())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.Fh().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Fz())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.Fh().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.aQp.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    h.this.Fh().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", ap.a.aVX));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", ap.a.aVX));
            }
        };
        this.bsz = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.brO)) {
                    l.showToast(h.this.Fh().getPageActivity(), h.this.brO);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.brH = writeData.getContent();
            gn(this.brH);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.aQp = tbPageContext;
    }

    public TbPageContext<?> Fh() {
        return this.aQp;
    }

    public void gf(String str) {
        this.brH = str;
    }

    public void setReplyId(String str) {
        this.bss = str;
    }

    public void b(DataModel<?> dataModel) {
        this.bsu = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.KO();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.brK = new NewWriteModel(tbPageContext);
            this.brK.b(this.brY);
            u.b(this.bsu.KO(), new u.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.u.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        h.this.brH = writeData.getContent();
                        h.this.gn(h.this.brH);
                    }
                }
            });
        }
    }

    public boolean Lg() {
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
                    if (Ku() != null) {
                        Ku().hide();
                    }
                    Ln();
                    ci(true);
                    WriteData writeData = this.brK.getWriteData();
                    this.brK.setWriteData(null);
                    this.brK.mE(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.bsu.KN();
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
                    if (this.bsw != null) {
                        this.bsw.callback(false, postWriteCallBackData, null, this.brK.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Ll() {
        if (this.brK.getWriteData() == null) {
            this.brK.setWriteData(this.bsu.ga(this.bsu.KO()));
        }
        if (this.brK.getWriteData() != null) {
            this.brK.getWriteData().setContent(this.brH);
            this.brK.getWriteData().setReplyId(this.bss);
            if (this.mPostId != null) {
                this.brK.getWriteData().setRepostId(this.bsu.KO());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.brK.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.brK.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.brK.getWriteData().setVoice(null);
                    this.brK.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.brK.getWriteData().setVoice(null);
                this.brK.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.brK.bwR()) {
                Fh().showToast(d.j.write_img_limit);
            } else if (this.brS == null || !this.brS.KQ()) {
                if (this.brR != null) {
                    this.brR.KR();
                }
                if (!this.brK.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        Lm();
        this.brK.cancelLoadData();
    }

    public void onStop() {
    }

    public void Lm() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.brH);
        writeData.setReplyId(this.bss);
        writeData.setThreadId(this.mPostId);
        u.d(this.mPostId, writeData);
    }

    public void Ln() {
        u.c(this.mPostId, (WriteData) null);
    }

    public void k(int i, String str) {
        if (AntiHelper.vQ(i)) {
            if (AntiHelper.a(this.aQp.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").s("obj_locate", ap.a.aVX));
            }
        } else if (i == 230277 || i == 230278) {
            gk(str);
        } else {
            Fh().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.brH);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.brO);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.aQp.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.l hH;
        this.bsx = antiData;
        if (antiData != null) {
            this.brO = antiData.getVoice_message();
            if (!StringUtils.isNull(this.brO) && Ku() != null && (hH = Ku().hH(6)) != null && !TextUtils.isEmpty(this.brO)) {
                ((View) hH).setOnClickListener(this.bsz);
            }
        }
    }

    private void gk(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Fh().getPageActivity());
        aVar.cZ(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Fh()).AA();
    }

    private void r(ArrayList<String> arrayList) {
        if (Ku() != null) {
            Ku().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean Lo() {
        return this.bsv;
    }

    public void cj(boolean z) {
        this.bsv = z;
    }

    public void gl(String str) {
        cj(true);
        Ku().th();
        if (str != null && str.length() != 0) {
            gn(Fh().getResources().getString(d.j.reply_sub_floor).replace("%s", str));
        } else {
            gn("");
        }
        TiebaStatic.eventStat(Fh().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gm(String str) {
        cj(true);
        Ku().th();
        gn(str);
        TiebaStatic.eventStat(Fh().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Lp() {
        cj(false);
        Ku().hide();
    }

    public void Lq() {
        cj(true);
        Ku().th();
        Ku().bh((View) Ku().hH(5));
    }

    public void Lr() {
        cj(true);
        Ku().th();
        Ku().bh((View) Ku().hH(2));
    }

    public void Ls() {
        cj(true);
        Ku().th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gn(String str) {
        if (Ku() != null) {
            Ku().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void go(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (am.isEmpty(this.brH) || this.brH.matches(str2)) {
            if (this.bst != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.bst).lookingAt()) {
                    gm(this.bst);
                    return;
                } else {
                    gl(str);
                    return;
                }
            }
            gl(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.brH);
        this.bst = this.brH;
        if (matcher.lookingAt()) {
            gm(this.brH);
        } else {
            gl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(boolean z) {
        if (Ku() != null) {
            Ku().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.bsw = dVar;
    }

    public void a(c cVar) {
        this.brR = cVar;
    }

    public void a(b bVar) {
        this.brS = bVar;
    }

    public e Lt() {
        if (this.bsy == null && Ku() != null) {
            this.bsy = (e) Ku().hJ(27);
        }
        return this.bsy;
    }
}
