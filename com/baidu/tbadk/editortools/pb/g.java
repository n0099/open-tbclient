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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
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
    private String aMQ;
    private NewWriteModel aMT;
    private String aMX;
    private String aNA;
    private String aNB;
    private DataModel<?> aNC;
    private boolean aND;
    private NewWriteModel.d aNE;
    private AntiData aNF;
    private e aNG;
    private View.OnClickListener aNH;
    private c aNa;
    private b aNb;
    private NewWriteModel.d aNh;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.aMQ = "";
        this.aNA = "";
        this.aNB = null;
        this.aND = false;
        this.aMX = null;
        this.aNh = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (g.this.aNE != null) {
                    g.this.aNE.callback(z, postWriteCallBackData, tVar, writeData, antiData);
                }
                if (z) {
                    g.this.aMQ = null;
                    g.this.aNA = null;
                    g.this.bJ(true);
                    g.this.Ia();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.aMT.getWriteData();
                    g.this.aMT.setWriteData(null);
                    g.this.aMT.mC(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.aNC.HA();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.tE(i)) {
                    g.this.j(i, str);
                } else if (tVar != null && writeData != null && !StringUtils.isNull(tVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.Ck());
                    if (com.baidu.tbadk.p.a.hM(tVar.Cj())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.BR().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Cj())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.BR().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.BR().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").r("obj_locate", as.a.arl));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").r("obj_locate", as.a.arl));
            }
        };
        this.aNH = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.aMX)) {
                    l.showToast(g.this.BR().getPageActivity(), g.this.aMX);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aMQ = writeData.getContent();
            gU(this.aMQ);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> BR() {
        return this.mContext;
    }

    public void gM(String str) {
        this.aMQ = str;
    }

    public void setReplyId(String str) {
        this.aNA = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aNC = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.HB();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aMT = new NewWriteModel(tbPageContext);
            this.aMT.b(this.aNh);
            com.baidu.tieba.tbadkCore.t.b(this.aNC.HB(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.aMQ = writeData.getContent();
                        g.this.gU(g.this.aMQ);
                    }
                }
            });
        }
    }

    public boolean HT() {
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
                    if (Hg() != null) {
                        Hg().hide();
                    }
                    Ia();
                    bJ(true);
                    WriteData writeData = this.aMT.getWriteData();
                    this.aMT.setWriteData(null);
                    this.aMT.mC(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aNC.HA();
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
                    if (this.aNE != null) {
                        this.aNE.callback(false, postWriteCallBackData, null, this.aMT.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void HY() {
        if (this.aMT.getWriteData() == null) {
            this.aMT.setWriteData(this.aNC.gH(this.aNC.HB()));
        }
        if (this.aMT.getWriteData() != null) {
            this.aMT.getWriteData().setContent(this.aMQ);
            this.aMT.getWriteData().setReplyId(this.aNA);
            if (this.mPostId != null) {
                this.aMT.getWriteData().setRepostId(this.aNC.HB());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aMT.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aMT.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aMT.getWriteData().setVoice(null);
                    this.aMT.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aMT.getWriteData().setVoice(null);
                this.aMT.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aMT.byk()) {
                BR().showToast(d.k.write_img_limit);
            } else if (this.aNb == null || !this.aNb.HD()) {
                if (this.aNa != null) {
                    this.aNa.HE();
                }
                if (!this.aMT.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        HZ();
        this.aMT.cancelLoadData();
    }

    public void onStop() {
    }

    public void HZ() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aMQ);
        writeData.setReplyId(this.aNA);
        writeData.setThreadId(this.mPostId);
        com.baidu.tieba.tbadkCore.t.d(this.mPostId, writeData);
    }

    public void Ia() {
        com.baidu.tieba.tbadkCore.t.c(this.mPostId, (WriteData) null);
    }

    public void j(int i, String str) {
        if (AntiHelper.tE(i)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").r("obj_locate", as.a.arl));
            }
        } else if (i == 230277 || i == 230278) {
            gR(str);
        } else {
            BR().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aMQ);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aMX);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g eJ;
        this.aNF = antiData;
        if (antiData != null) {
            this.aMX = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aMX) && Hg() != null && (eJ = Hg().eJ(6)) != null && !TextUtils.isEmpty(this.aMX)) {
                ((View) eJ).setOnClickListener(this.aNH);
            }
        }
    }

    private void gR(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(BR().getPageActivity());
        aVar.dB(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(BR()).xa();
    }

    private void q(ArrayList<String> arrayList) {
        if (Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean Ib() {
        return this.aND;
    }

    public void bK(boolean z) {
        this.aND = z;
    }

    public void gS(String str) {
        bK(true);
        Hg().oD();
        if (str != null && str.length() != 0) {
            gU(BR().getResources().getString(d.k.reply_sub_floor).replace("%s", str));
        } else {
            gU("");
        }
        TiebaStatic.eventStat(BR().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gT(String str) {
        bK(true);
        Hg().oD();
        gU(str);
        TiebaStatic.eventStat(BR().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Ic() {
        bK(false);
        Hg().hide();
    }

    public void Id() {
        bK(true);
        Hg().oD();
        Hg().M((View) Hg().eJ(5));
    }

    public void Ie() {
        bK(true);
        Hg().oD();
        Hg().M((View) Hg().eJ(2));
    }

    public void If() {
        bK(true);
        Hg().oD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gU(String str) {
        if (Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void gV(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.k.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ao.isEmpty(this.aMQ) || this.aMQ.matches(str2)) {
            if (this.aNB != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aNB).lookingAt()) {
                    gT(this.aNB);
                    return;
                } else {
                    gS(str);
                    return;
                }
            }
            gS(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aMQ);
        this.aNB = this.aMQ;
        if (matcher.lookingAt()) {
            gT(this.aMQ);
        } else {
            gS(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        if (Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aNE = dVar;
    }

    public void a(c cVar) {
        this.aNa = cVar;
    }

    public void a(b bVar) {
        this.aNb = bVar;
    }

    public e Ig() {
        if (this.aNG == null && Hg() != null) {
            this.aNG = (e) Hg().eM(27);
        }
        return this.aNG;
    }
}
