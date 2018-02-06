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
    private TbPageContext<?> aRR;
    private String buO;
    private String buP;
    private DataModel<?> buQ;
    private boolean buR;
    private NewWriteModel.d buS;
    private AntiData buT;
    private e buU;
    private View.OnClickListener buV;
    private String bue;
    private NewWriteModel bui;
    private String bum;
    private c bup;
    private b buq;
    private NewWriteModel.d buw;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.bue = "";
        this.buO = "";
        this.buP = null;
        this.buR = false;
        this.bum = null;
        this.buw = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (h.this.buS != null) {
                    h.this.buS.callback(z, postWriteCallBackData, tVar, writeData, antiData);
                }
                if (z) {
                    h.this.bue = null;
                    h.this.buO = null;
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
                    WriteData writeData2 = h.this.bui.getWriteData();
                    h.this.bui.setWriteData(null);
                    h.this.bui.mO(false);
                    h.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        h.this.buQ.Lw();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.vQ(i)) {
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(h.this.aRR.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    h.this.FF().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").s("obj_locate", aq.a.aXJ));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").s("obj_locate", aq.a.aXJ));
            }
        };
        this.buV = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.bum)) {
                    l.showToast(h.this.FF().getPageActivity(), h.this.bum);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.bue = writeData.getContent();
            gF(this.bue);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.aRR = tbPageContext;
    }

    public TbPageContext<?> FF() {
        return this.aRR;
    }

    public void gx(String str) {
        this.bue = str;
    }

    public void setReplyId(String str) {
        this.buO = str;
    }

    public void b(DataModel<?> dataModel) {
        this.buQ = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Lx();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.bui = new NewWriteModel(tbPageContext);
            this.bui.b(this.buw);
            com.baidu.tieba.tbadkCore.t.b(this.buQ.Lx(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        h.this.bue = writeData.getContent();
                        h.this.gF(h.this.bue);
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
                    WriteData writeData = this.bui.getWriteData();
                    this.bui.setWriteData(null);
                    this.bui.mO(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.buQ.Lw();
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
                    if (this.buS != null) {
                        this.buS.callback(false, postWriteCallBackData, null, this.bui.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void LT() {
        if (this.bui.getWriteData() == null) {
            this.bui.setWriteData(this.buQ.gr(this.buQ.Lx()));
        }
        if (this.bui.getWriteData() != null) {
            this.bui.getWriteData().setContent(this.bue);
            this.bui.getWriteData().setReplyId(this.buO);
            if (this.mPostId != null) {
                this.bui.getWriteData().setRepostId(this.buQ.Lx());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.bui.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.bui.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.bui.getWriteData().setVoice(null);
                    this.bui.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.bui.getWriteData().setVoice(null);
                this.bui.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.bui.byd()) {
                FF().showToast(d.j.write_img_limit);
            } else if (this.buq == null || !this.buq.Lz()) {
                if (this.bup != null) {
                    this.bup.LA();
                }
                if (!this.bui.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        LU();
        this.bui.cancelLoadData();
    }

    public void onStop() {
    }

    public void LU() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.bue);
        writeData.setReplyId(this.buO);
        writeData.setThreadId(this.mPostId);
        com.baidu.tieba.tbadkCore.t.d(this.mPostId, writeData);
    }

    public void LV() {
        com.baidu.tieba.tbadkCore.t.c(this.mPostId, (WriteData) null);
    }

    public void k(int i, String str) {
        if (AntiHelper.vQ(i)) {
            if (AntiHelper.a(this.aRR.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").s("obj_locate", aq.a.aXJ));
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
        pbEditorData.setContent(this.bue);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.bum);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.aRR.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.l hG;
        this.buT = antiData;
        if (antiData != null) {
            this.bum = antiData.getVoice_message();
            if (!StringUtils.isNull(this.bum) && Lc() != null && (hG = Lc().hG(6)) != null && !TextUtils.isEmpty(this.bum)) {
                ((View) hG).setOnClickListener(this.buV);
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
        aVar.b(FF()).AU();
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
        return this.buR;
    }

    public void co(boolean z) {
        this.buR = z;
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
        if (am.isEmpty(this.bue) || this.bue.matches(str2)) {
            if (this.buP != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.buP).lookingAt()) {
                    gE(this.buP);
                    return;
                } else {
                    gD(str);
                    return;
                }
            }
            gD(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.bue);
        this.buP = this.bue;
        if (matcher.lookingAt()) {
            gE(this.bue);
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
        this.buS = dVar;
    }

    public void a(c cVar) {
        this.bup = cVar;
    }

    public void a(b bVar) {
        this.buq = bVar;
    }

    public e Mb() {
        if (this.buU == null && Lc() != null) {
            this.buU = (e) Lc().hI(27);
        }
        return this.buU;
    }
}
