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
    private String aNL;
    private NewWriteModel aNO;
    private String aNS;
    private c aNV;
    private b aNW;
    private AntiData aOA;
    private e aOB;
    private View.OnClickListener aOC;
    private NewWriteModel.d aOc;
    private String aOv;
    private String aOw;
    private DataModel<?> aOx;
    private boolean aOy;
    private NewWriteModel.d aOz;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.aNL = "";
        this.aOv = "";
        this.aOw = null;
        this.aOy = false;
        this.aNS = null;
        this.aOc = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (g.this.aOz != null) {
                    g.this.aOz.callback(z, postWriteCallBackData, tVar, writeData, antiData);
                }
                if (z) {
                    g.this.aNL = null;
                    g.this.aOv = null;
                    g.this.bK(true);
                    g.this.In();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.aNO.getWriteData();
                    g.this.aNO.setWriteData(null);
                    g.this.aNO.my(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.aOx.HN();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.al(i, str)) {
                    g.this.l(i, str);
                } else if (tVar != null && writeData != null && !StringUtils.isNull(tVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.Cu());
                    if (com.baidu.tbadk.q.a.hN(tVar.Ct())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.Ca().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.Ct())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.Ca().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.Ca().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arp));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arp));
            }
        };
        this.aOC = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.aNS)) {
                    l.showToast(g.this.Ca().getPageActivity(), g.this.aNS);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aNL = writeData.getContent();
            gU(this.aNL);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> Ca() {
        return this.mContext;
    }

    public void gM(String str) {
        this.aNL = str;
    }

    public void setReplyId(String str) {
        this.aOv = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aOx = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.HO();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aNO = new NewWriteModel(tbPageContext);
            this.aNO.b(this.aOc);
            com.baidu.tieba.tbadkCore.t.b(this.aOx.HO(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.aNL = writeData.getContent();
                        g.this.gU(g.this.aNL);
                    }
                }
            });
        }
    }

    public boolean Ig() {
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
                    if (Ht() != null) {
                        Ht().hide();
                    }
                    In();
                    bK(true);
                    WriteData writeData = this.aNO.getWriteData();
                    this.aNO.setWriteData(null);
                    this.aNO.my(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aOx.HN();
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
                    if (this.aOz != null) {
                        this.aOz.callback(false, postWriteCallBackData, null, this.aNO.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Il() {
        if (this.aNO.getWriteData() == null) {
            this.aNO.setWriteData(this.aOx.gH(this.aOx.HO()));
        }
        if (this.aNO.getWriteData() != null) {
            this.aNO.getWriteData().setContent(this.aNL);
            this.aNO.getWriteData().setReplyId(this.aOv);
            if (this.mPostId != null) {
                this.aNO.getWriteData().setRepostId(this.aOx.HO());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aNO.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aNO.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aNO.getWriteData().setVoice(null);
                    this.aNO.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aNO.getWriteData().setVoice(null);
                this.aNO.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aNO.bxr()) {
                Ca().showToast(d.j.write_img_limit);
            } else if (this.aNW == null || !this.aNW.HQ()) {
                if (this.aNV != null) {
                    this.aNV.HR();
                }
                if (!this.aNO.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        Im();
        this.aNO.cancelLoadData();
    }

    public void onStop() {
    }

    public void Im() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aNL);
        writeData.setReplyId(this.aOv);
        writeData.setThreadId(this.mPostId);
        com.baidu.tieba.tbadkCore.t.d(this.mPostId, writeData);
    }

    public void In() {
        com.baidu.tieba.tbadkCore.t.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.al(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arp));
            }
        } else if (i == 230277 || i == 230278) {
            gR(str);
        } else {
            Ca().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aNL);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aNS);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g eL;
        this.aOA = antiData;
        if (antiData != null) {
            this.aNS = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aNS) && Ht() != null && (eL = Ht().eL(6)) != null && !TextUtils.isEmpty(this.aNS)) {
                ((View) eL).setOnClickListener(this.aOC);
            }
        }
    }

    private void gR(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Ca().getPageActivity());
        aVar.dB(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Ca()).xf();
    }

    private void u(ArrayList<String> arrayList) {
        if (Ht() != null) {
            Ht().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean Io() {
        return this.aOy;
    }

    public void bL(boolean z) {
        this.aOy = z;
    }

    public void gS(String str) {
        bL(true);
        Ht().oF();
        if (str != null && str.length() != 0) {
            gU(Ca().getResources().getString(d.j.reply_sub_floor).replace("%s", str));
        } else {
            gU("");
        }
        TiebaStatic.eventStat(Ca().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gT(String str) {
        bL(true);
        Ht().oF();
        gU(str);
        TiebaStatic.eventStat(Ca().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Ip() {
        bL(false);
        Ht().hide();
    }

    public void Iq() {
        bL(true);
        Ht().oF();
        Ht().N((View) Ht().eL(5));
    }

    public void Ir() {
        bL(true);
        Ht().oF();
        Ht().N((View) Ht().eL(2));
    }

    public void Is() {
        bL(true);
        Ht().oF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gU(String str) {
        if (Ht() != null) {
            Ht().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void gV(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ap.isEmpty(this.aNL) || this.aNL.matches(str2)) {
            if (this.aOw != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aOw).lookingAt()) {
                    gT(this.aOw);
                    return;
                } else {
                    gS(str);
                    return;
                }
            }
            gS(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aNL);
        this.aOw = this.aNL;
        if (matcher.lookingAt()) {
            gT(this.aNL);
        } else {
            gS(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (Ht() != null) {
            Ht().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aOz = dVar;
    }

    public void a(c cVar) {
        this.aNV = cVar;
    }

    public void a(b bVar) {
        this.aNW = bVar;
    }

    public e It() {
        if (this.aOB == null && Ht() != null) {
            this.aOB = (e) Ht().eO(27);
        }
        return this.aOB;
    }
}
