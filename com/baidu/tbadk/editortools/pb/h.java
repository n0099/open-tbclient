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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.f {
    private TbPageContext<?> aRG;
    private String btR;
    private NewWriteModel btU;
    private String btY;
    private String buB;
    private String buC;
    private DataModel<?> buD;
    private boolean buE;
    private NewWriteModel.d buF;
    private AntiData buG;
    private e buH;
    private View.OnClickListener buI;
    private c bub;
    private b buc;
    private NewWriteModel.d buj;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.btR = "";
        this.buB = "";
        this.buC = null;
        this.buE = false;
        this.btY = null;
        this.buj = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (h.this.buF != null) {
                    h.this.buF.callback(z, postWriteCallBackData, tVar, writeData, antiData);
                }
                if (z) {
                    h.this.btR = null;
                    h.this.buB = null;
                    h.this.cn(true);
                    h.this.LU();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = h.this.btU.getWriteData();
                    h.this.btU.setWriteData(null);
                    h.this.btU.mO(false);
                    h.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        h.this.buD.Lv();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.vR(i)) {
                    h.this.k(i, str);
                } else if (tVar != null && writeData != null && !StringUtils.isNull(tVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.FX());
                    if (com.baidu.tbadk.p.a.hx(tVar.FW())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(h.this.FE().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.FW())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(h.this.FE().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(h.this.aRG.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    h.this.FE().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXx));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXx));
            }
        };
        this.buI = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.btY)) {
                    l.showToast(h.this.FE().getPageActivity(), h.this.btY);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.btR = writeData.getContent();
            gF(this.btR);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.aRG = tbPageContext;
    }

    public TbPageContext<?> FE() {
        return this.aRG;
    }

    public void gx(String str) {
        this.btR = str;
    }

    public void setReplyId(String str) {
        this.buB = str;
    }

    public void b(DataModel<?> dataModel) {
        this.buD = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Lw();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.btU = new NewWriteModel(tbPageContext);
            this.btU.b(this.buj);
            com.baidu.tieba.tbadkCore.t.b(this.buD.Lw(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        h.this.btR = writeData.getContent();
                        h.this.gF(h.this.btR);
                    }
                }
            });
        }
    }

    public boolean LN() {
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
                    if (Lb() != null) {
                        Lb().hide();
                    }
                    LU();
                    cn(true);
                    WriteData writeData = this.btU.getWriteData();
                    this.btU.setWriteData(null);
                    this.btU.mO(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.buD.Lv();
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
                    if (this.buF != null) {
                        this.buF.callback(false, postWriteCallBackData, null, this.btU.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void LS() {
        if (this.btU.getWriteData() == null) {
            this.btU.setWriteData(this.buD.gr(this.buD.Lw()));
        }
        if (this.btU.getWriteData() != null) {
            this.btU.getWriteData().setContent(this.btR);
            this.btU.getWriteData().setReplyId(this.buB);
            if (this.mPostId != null) {
                this.btU.getWriteData().setRepostId(this.buD.Lw());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.btU.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.btU.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.btU.getWriteData().setVoice(null);
                    this.btU.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.btU.getWriteData().setVoice(null);
                this.btU.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.btU.byc()) {
                FE().showToast(d.j.write_img_limit);
            } else if (this.buc == null || !this.buc.Ly()) {
                if (this.bub != null) {
                    this.bub.Lz();
                }
                if (!this.btU.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        LT();
        this.btU.cancelLoadData();
    }

    public void onStop() {
    }

    public void LT() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.btR);
        writeData.setReplyId(this.buB);
        writeData.setThreadId(this.mPostId);
        com.baidu.tieba.tbadkCore.t.d(this.mPostId, writeData);
    }

    public void LU() {
        com.baidu.tieba.tbadkCore.t.c(this.mPostId, (WriteData) null);
    }

    public void k(int i, String str) {
        if (AntiHelper.vR(i)) {
            if (AntiHelper.a(this.aRG.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXx));
            }
        } else if (i == 230277 || i == 230278) {
            gC(str);
        } else {
            FE().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.btR);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.btY);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.aRG.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.l hG;
        this.buG = antiData;
        if (antiData != null) {
            this.btY = antiData.getVoice_message();
            if (!StringUtils.isNull(this.btY) && Lb() != null && (hG = Lb().hG(6)) != null && !TextUtils.isEmpty(this.btY)) {
                ((View) hG).setOnClickListener(this.buI);
            }
        }
    }

    private void gC(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(FE().getPageActivity());
        aVar.dk(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(FE()).AU();
    }

    private void r(ArrayList<String> arrayList) {
        if (Lb() != null) {
            Lb().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean LV() {
        return this.buE;
    }

    public void co(boolean z) {
        this.buE = z;
    }

    public void gD(String str) {
        co(true);
        Lb().th();
        if (str != null && str.length() != 0) {
            gF(FE().getResources().getString(d.j.reply_sub_floor).replace("%s", str));
        } else {
            gF("");
        }
        TiebaStatic.eventStat(FE().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gE(String str) {
        co(true);
        Lb().th();
        gF(str);
        TiebaStatic.eventStat(FE().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void LW() {
        co(false);
        Lb().hide();
    }

    public void LX() {
        co(true);
        Lb().th();
        Lb().bh((View) Lb().hG(5));
    }

    public void LY() {
        co(true);
        Lb().th();
        Lb().bh((View) Lb().hG(2));
    }

    public void LZ() {
        co(true);
        Lb().th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(String str) {
        if (Lb() != null) {
            Lb().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void gG(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (am.isEmpty(this.btR) || this.btR.matches(str2)) {
            if (this.buC != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.buC).lookingAt()) {
                    gE(this.buC);
                    return;
                } else {
                    gD(str);
                    return;
                }
            }
            gD(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.btR);
        this.buC = this.btR;
        if (matcher.lookingAt()) {
            gE(this.btR);
        } else {
            gD(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (Lb() != null) {
            Lb().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.buF = dVar;
    }

    public void a(c cVar) {
        this.bub = cVar;
    }

    public void a(b bVar) {
        this.buc = bVar;
    }

    public e Ma() {
        if (this.buH == null && Lb() != null) {
            this.buH = (e) Lb().hI(27);
        }
        return this.buH;
    }
}
