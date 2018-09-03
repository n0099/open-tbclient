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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.editortools.d {
    private String aNI;
    private NewWriteModel aNL;
    private String aNP;
    private c aNS;
    private b aNT;
    private NewWriteModel.d aNZ;
    private String aOs;
    private String aOt;
    private DataModel<?> aOu;
    private boolean aOv;
    private NewWriteModel.d aOw;
    private AntiData aOx;
    private e aOy;
    private View.OnClickListener aOz;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.aNI = "";
        this.aOs = "";
        this.aOt = null;
        this.aOv = false;
        this.aNP = null;
        this.aNZ = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, u uVar, WriteData writeData, AntiData antiData) {
                if (g.this.aOw != null) {
                    g.this.aOw.callback(z, postWriteCallBackData, uVar, writeData, antiData);
                }
                if (z) {
                    g.this.aNI = null;
                    g.this.aOs = null;
                    g.this.bL(true);
                    g.this.In();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.aNL.getWriteData();
                    g.this.aNL.setWriteData(null);
                    g.this.aNL.my(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.aOu.HN();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.al(i, str)) {
                    g.this.l(i, str);
                } else if (uVar != null && writeData != null && !StringUtils.isNull(uVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(uVar.getVcode_md5());
                    writeData.setVcodeUrl(uVar.getVcode_pic_url());
                    writeData.setVcodeExtra(uVar.Cs());
                    if (com.baidu.tbadk.q.a.hN(uVar.Cr())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.BX().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, uVar.Cr())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.BX().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.BX().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arq));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arq));
            }
        };
        this.aOz = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.aNP)) {
                    l.showToast(g.this.BX().getPageActivity(), g.this.aNP);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aNI = writeData.getContent();
            gU(this.aNI);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> BX() {
        return this.mContext;
    }

    public void gM(String str) {
        this.aNI = str;
    }

    public void setReplyId(String str) {
        this.aOs = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aOu = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.HO();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aNL = new NewWriteModel(tbPageContext);
            this.aNL.b(this.aNZ);
            t.b(this.aOu.HO(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.aNI = writeData.getContent();
                        g.this.gU(g.this.aNI);
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
                    bL(true);
                    WriteData writeData = this.aNL.getWriteData();
                    this.aNL.setWriteData(null);
                    this.aNL.my(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aOu.HN();
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
                    if (this.aOw != null) {
                        this.aOw.callback(false, postWriteCallBackData, null, this.aNL.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Il() {
        if (this.aNL.getWriteData() == null) {
            this.aNL.setWriteData(this.aOu.gH(this.aOu.HO()));
        }
        if (this.aNL.getWriteData() != null) {
            this.aNL.getWriteData().setContent(this.aNI);
            this.aNL.getWriteData().setReplyId(this.aOs);
            if (this.mPostId != null) {
                this.aNL.getWriteData().setRepostId(this.aOu.HO());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aNL.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aNL.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aNL.getWriteData().setVoice(null);
                    this.aNL.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aNL.getWriteData().setVoice(null);
                this.aNL.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aNL.bxs()) {
                BX().showToast(f.j.write_img_limit);
            } else if (this.aNT == null || !this.aNT.HQ()) {
                if (this.aNS != null) {
                    this.aNS.HR();
                }
                if (!this.aNL.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        Im();
        this.aNL.cancelLoadData();
    }

    public void onStop() {
    }

    public void Im() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aNI);
        writeData.setReplyId(this.aOs);
        writeData.setThreadId(this.mPostId);
        t.d(this.mPostId, writeData);
    }

    public void In() {
        t.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.al(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arq));
            }
        } else if (i == 230277 || i == 230278) {
            gR(str);
        } else {
            BX().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aNI);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aNP);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g eK;
        this.aOx = antiData;
        if (antiData != null) {
            this.aNP = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aNP) && Ht() != null && (eK = Ht().eK(6)) != null && !TextUtils.isEmpty(this.aNP)) {
                ((View) eK).setOnClickListener(this.aOz);
            }
        }
    }

    private void gR(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(BX().getPageActivity());
        aVar.dB(str);
        aVar.b(f.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(BX()).xe();
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
        return this.aOv;
    }

    public void bM(boolean z) {
        this.aOv = z;
    }

    public void gS(String str) {
        bM(true);
        Ht().oC();
        if (str != null && str.length() != 0) {
            gU(BX().getResources().getString(f.j.reply_sub_floor).replace("%s", str));
        } else {
            gU("");
        }
        TiebaStatic.eventStat(BX().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gT(String str) {
        bM(true);
        Ht().oC();
        gU(str);
        TiebaStatic.eventStat(BX().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Ip() {
        bM(false);
        Ht().hide();
    }

    public void Iq() {
        bM(true);
        Ht().oC();
        Ht().N((View) Ht().eK(5));
    }

    public void Ir() {
        bM(true);
        Ht().oC();
        Ht().N((View) Ht().eK(2));
    }

    public void Is() {
        bM(true);
        Ht().oC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gU(String str) {
        if (Ht() != null) {
            Ht().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void gV(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(f.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ap.isEmpty(this.aNI) || this.aNI.matches(str2)) {
            if (this.aOt != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aOt).lookingAt()) {
                    gT(this.aOt);
                    return;
                } else {
                    gS(str);
                    return;
                }
            }
            gS(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aNI);
        this.aOt = this.aNI;
        if (matcher.lookingAt()) {
            gT(this.aNI);
        } else {
            gS(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        if (Ht() != null) {
            Ht().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aOw = dVar;
    }

    public void a(c cVar) {
        this.aNS = cVar;
    }

    public void a(b bVar) {
        this.aNT = bVar;
    }

    public e It() {
        if (this.aOy == null && Ht() != null) {
            this.aOy = (e) Ht().eN(27);
        }
        return this.aOy;
    }
}
