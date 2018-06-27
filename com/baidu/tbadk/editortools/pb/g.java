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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.EditorTools;
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
public class g extends com.baidu.tbadk.editortools.d {
    private String aNM;
    private NewWriteModel aNP;
    private String aNT;
    private c aNW;
    private b aNX;
    private NewWriteModel.d aOA;
    private AntiData aOB;
    private e aOC;
    private View.OnClickListener aOD;
    private NewWriteModel.d aOd;
    private String aOw;
    private String aOx;
    private DataModel<?> aOy;
    private boolean aOz;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.aNM = "";
        this.aOw = "";
        this.aOx = null;
        this.aOz = false;
        this.aNT = null;
        this.aOd = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (g.this.aOA != null) {
                    g.this.aOA.callback(z, postWriteCallBackData, tVar, writeData, antiData);
                }
                if (z) {
                    g.this.aNM = null;
                    g.this.aOw = null;
                    g.this.bM(true);
                    g.this.Is();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.aNP.getWriteData();
                    g.this.aNP.setWriteData(null);
                    g.this.aNP.mN(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.aOy.HS();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.tQ(i)) {
                    g.this.j(i, str);
                } else if (tVar != null && writeData != null && !StringUtils.isNull(tVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.CC());
                    if (com.baidu.tbadk.p.a.hQ(tVar.CB())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.Ci().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.CB())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.Ci().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.Ci().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arO));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arO));
            }
        };
        this.aOD = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.aNT)) {
                    l.showToast(g.this.Ci().getPageActivity(), g.this.aNT);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aNM = writeData.getContent();
            gY(this.aNM);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> Ci() {
        return this.mContext;
    }

    public void gQ(String str) {
        this.aNM = str;
    }

    public void setReplyId(String str) {
        this.aOw = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aOy = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.HT();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aNP = new NewWriteModel(tbPageContext);
            this.aNP.b(this.aOd);
            com.baidu.tieba.tbadkCore.t.b(this.aOy.HT(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.aNM = writeData.getContent();
                        g.this.gY(g.this.aNM);
                    }
                }
            });
        }
    }

    public boolean Il() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        u(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (Hy() != null) {
                        Hy().hide();
                    }
                    Is();
                    bM(true);
                    WriteData writeData = this.aNP.getWriteData();
                    this.aNP.setWriteData(null);
                    this.aNP.mN(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aOy.HS();
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
                    if (this.aOA != null) {
                        this.aOA.callback(false, postWriteCallBackData, null, this.aNP.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Iq() {
        if (this.aNP.getWriteData() == null) {
            this.aNP.setWriteData(this.aOy.gL(this.aOy.HT()));
        }
        if (this.aNP.getWriteData() != null) {
            this.aNP.getWriteData().setContent(this.aNM);
            this.aNP.getWriteData().setReplyId(this.aOw);
            if (this.mPostId != null) {
                this.aNP.getWriteData().setRepostId(this.aOy.HT());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aNP.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aNP.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aNP.getWriteData().setVoice(null);
                    this.aNP.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aNP.getWriteData().setVoice(null);
                this.aNP.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aNP.byO()) {
                Ci().showToast(d.k.write_img_limit);
            } else if (this.aNX == null || !this.aNX.HV()) {
                if (this.aNW != null) {
                    this.aNW.HW();
                }
                if (!this.aNP.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        Ir();
        this.aNP.cancelLoadData();
    }

    public void onStop() {
    }

    public void Ir() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aNM);
        writeData.setReplyId(this.aOw);
        writeData.setThreadId(this.mPostId);
        com.baidu.tieba.tbadkCore.t.d(this.mPostId, writeData);
    }

    public void Is() {
        com.baidu.tieba.tbadkCore.t.c(this.mPostId, (WriteData) null);
    }

    public void j(int i, String str) {
        if (AntiHelper.tQ(i)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arO));
            }
        } else if (i == 230277 || i == 230278) {
            gV(str);
        } else {
            Ci().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aNM);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aNT);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g eK;
        this.aOB = antiData;
        if (antiData != null) {
            this.aNT = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aNT) && Hy() != null && (eK = Hy().eK(6)) != null && !TextUtils.isEmpty(this.aNT)) {
                ((View) eK).setOnClickListener(this.aOD);
            }
        }
    }

    private void gV(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Ci().getPageActivity());
        aVar.dE(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Ci()).xn();
    }

    private void u(ArrayList<String> arrayList) {
        if (Hy() != null) {
            Hy().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean It() {
        return this.aOz;
    }

    public void bN(boolean z) {
        this.aOz = z;
    }

    public void gW(String str) {
        bN(true);
        Hy().oD();
        if (str != null && str.length() != 0) {
            gY(Ci().getResources().getString(d.k.reply_sub_floor).replace("%s", str));
        } else {
            gY("");
        }
        TiebaStatic.eventStat(Ci().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gX(String str) {
        bN(true);
        Hy().oD();
        gY(str);
        TiebaStatic.eventStat(Ci().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Iu() {
        bN(false);
        Hy().hide();
    }

    public void Iv() {
        bN(true);
        Hy().oD();
        Hy().N((View) Hy().eK(5));
    }

    public void Iw() {
        bN(true);
        Hy().oD();
        Hy().N((View) Hy().eK(2));
    }

    public void Ix() {
        bN(true);
        Hy().oD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gY(String str) {
        if (Hy() != null) {
            Hy().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void gZ(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.k.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ap.isEmpty(this.aNM) || this.aNM.matches(str2)) {
            if (this.aOx != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aOx).lookingAt()) {
                    gX(this.aOx);
                    return;
                } else {
                    gW(str);
                    return;
                }
            }
            gW(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aNM);
        this.aOx = this.aNM;
        if (matcher.lookingAt()) {
            gX(this.aNM);
        } else {
            gW(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(boolean z) {
        if (Hy() != null) {
            Hy().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aOA = dVar;
    }

    public void a(c cVar) {
        this.aNW = cVar;
    }

    public void a(b bVar) {
        this.aNX = bVar;
    }

    public e Iy() {
        if (this.aOC == null && Hy() != null) {
            this.aOC = (e) Hy().eN(27);
        }
        return this.aOC;
    }
}
