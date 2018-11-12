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
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.editortools.d {
    private c aWB;
    private b aWC;
    private NewWriteModel.d aWI;
    private String aWr;
    private NewWriteModel aWu;
    private String aWy;
    private String aXb;
    private String aXc;
    private DataModel<?> aXd;
    private boolean aXe;
    private NewWriteModel.d aXf;
    private AntiData aXg;
    private e aXh;
    private View.OnClickListener aXi;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.aWr = "";
        this.aXb = "";
        this.aXc = null;
        this.aXe = false;
        this.aWy = null;
        this.aWI = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
                if (g.this.aXf != null) {
                    g.this.aXf.callback(z, postWriteCallBackData, wVar, writeData, antiData);
                }
                if (z) {
                    g.this.aWr = null;
                    g.this.aXb = null;
                    g.this.cx(true);
                    g.this.LN();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.aWu.getWriteData();
                    g.this.aWu.setWriteData(null);
                    g.this.aWu.nx(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.aXd.Ln();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.ai(i, str)) {
                    g.this.k(i, str);
                } else if (wVar != null && writeData != null && !StringUtils.isNull(wVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(wVar.getVcode_md5());
                    writeData.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData.setVcodeExtra(wVar.FS());
                    if (com.baidu.tbadk.q.a.iA(wVar.FR())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.Fy().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.FR())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.Fy().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.Fy().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.azm));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.azm));
            }
        };
        this.aXi = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.aWy)) {
                    l.showToast(g.this.Fy().getPageActivity(), g.this.aWy);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aWr = writeData.getContent();
            hF(this.aWr);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> Fy() {
        return this.mContext;
    }

    public void hx(String str) {
        this.aWr = str;
    }

    public void setReplyId(String str) {
        this.aXb = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aXd = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Lo();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aWu = new NewWriteModel(tbPageContext);
            this.aWu.b(this.aWI);
            t.b(this.aXd.Lo(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.aWr = writeData.getContent();
                        g.this.hF(g.this.aWr);
                    }
                }
            });
        }
    }

    public boolean LG() {
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
                    if (KT() != null) {
                        KT().hide();
                    }
                    LN();
                    cx(true);
                    WriteData writeData = this.aWu.getWriteData();
                    this.aWu.setWriteData(null);
                    this.aWu.nx(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aXd.Ln();
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
                    if (this.aXf != null) {
                        this.aXf.callback(false, postWriteCallBackData, null, this.aWu.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void LL() {
        if (this.aWu.getWriteData() == null) {
            this.aWu.setWriteData(this.aXd.hs(this.aXd.Lo()));
        }
        if (this.aWu.getWriteData() != null) {
            this.aWu.getWriteData().setContent(this.aWr);
            this.aWu.getWriteData().setReplyId(this.aXb);
            if (this.mPostId != null) {
                this.aWu.getWriteData().setRepostId(this.aXd.Lo());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aWu.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aWu.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aWu.getWriteData().setVoice(null);
                    this.aWu.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aWu.getWriteData().setVoice(null);
                this.aWu.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aWu.bCJ()) {
                Fy().showToast(e.j.write_img_limit);
            } else if (this.aWC == null || !this.aWC.Lq()) {
                if (this.aWB != null) {
                    this.aWB.Lr();
                }
                if (!this.aWu.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        LM();
        this.aWu.cancelLoadData();
    }

    public void onStop() {
    }

    public void LM() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aWr);
        writeData.setReplyId(this.aXb);
        writeData.setThreadId(this.mPostId);
        t.d(this.mPostId, writeData);
    }

    public void LN() {
        t.c(this.mPostId, (WriteData) null);
    }

    public void k(int i, String str) {
        if (AntiHelper.ai(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").x("obj_locate", as.a.azm));
            }
        } else if (i == 230277 || i == 230278) {
            hC(str);
        } else {
            Fy().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aWr);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aWy);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g ft;
        this.aXg = antiData;
        if (antiData != null) {
            this.aWy = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aWy) && KT() != null && (ft = KT().ft(6)) != null && !TextUtils.isEmpty(this.aWy)) {
                ((View) ft).setOnClickListener(this.aXi);
            }
        }
    }

    private void hC(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Fy().getPageActivity());
        aVar.ej(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Fy()).AB();
    }

    private void u(ArrayList<String> arrayList) {
        if (KT() != null) {
            KT().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean LO() {
        return this.aXe;
    }

    public void cy(boolean z) {
        this.aXe = z;
    }

    public void hD(String str) {
        cy(true);
        KT().pO();
        if (str != null && str.length() != 0) {
            hF(Fy().getResources().getString(e.j.reply_sub_floor).replace("%s", str));
        } else {
            hF("");
        }
        TiebaStatic.eventStat(Fy().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void hE(String str) {
        cy(true);
        KT().pO();
        hF(str);
        TiebaStatic.eventStat(Fy().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void LP() {
        cy(false);
        KT().hide();
    }

    public void LQ() {
        cy(true);
        KT().pO();
        KT().aa((View) KT().ft(5));
    }

    public void LR() {
        cy(true);
        KT().pO();
        KT().aa((View) KT().ft(2));
    }

    public void LS() {
        cy(true);
        KT().pO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hF(String str) {
        if (KT() != null) {
            KT().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void hG(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(e.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ao.isEmpty(this.aWr) || this.aWr.matches(str2)) {
            if (this.aXc != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aXc).lookingAt()) {
                    hE(this.aXc);
                    return;
                } else {
                    hD(str);
                    return;
                }
            }
            hD(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aWr);
        this.aXc = this.aWr;
        if (matcher.lookingAt()) {
            hE(this.aWr);
        } else {
            hD(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(boolean z) {
        if (KT() != null) {
            KT().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aXf = dVar;
    }

    public void a(c cVar) {
        this.aWB = cVar;
    }

    public void a(b bVar) {
        this.aWC = bVar;
    }

    public e LT() {
        if (this.aXh == null && KT() != null) {
            this.aXh = (e) KT().fw(27);
        }
        return this.aXh;
    }
}
