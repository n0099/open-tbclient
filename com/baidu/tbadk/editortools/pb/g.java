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
import com.baidu.tbadk.coreExtra.data.v;
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
    private String aVB;
    private NewWriteModel aVE;
    private String aVI;
    private c aVL;
    private b aVM;
    private NewWriteModel.d aVS;
    private String aWl;
    private String aWm;
    private DataModel<?> aWn;
    private boolean aWo;
    private NewWriteModel.d aWp;
    private AntiData aWq;
    private e aWr;
    private View.OnClickListener aWs;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.aVB = "";
        this.aWl = "";
        this.aWm = null;
        this.aWo = false;
        this.aVI = null;
        this.aVS = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
                if (g.this.aWp != null) {
                    g.this.aWp.callback(z, postWriteCallBackData, vVar, writeData, antiData);
                }
                if (z) {
                    g.this.aVB = null;
                    g.this.aWl = null;
                    g.this.cg(true);
                    g.this.LB();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.aVE.getWriteData();
                    g.this.aVE.setWriteData(null);
                    g.this.aVE.nm(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.aWn.Lb();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.am(i, str)) {
                    g.this.l(i, str);
                } else if (vVar != null && writeData != null && !StringUtils.isNull(vVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(vVar.getVcode_md5());
                    writeData.setVcodeUrl(vVar.getVcode_pic_url());
                    writeData.setVcodeExtra(vVar.FG());
                    if (com.baidu.tbadk.q.a.iy(vVar.FF())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.Fm().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, vVar.FF())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.Fm().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.Fm().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.ayz));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.ayz));
            }
        };
        this.aWs = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.aVI)) {
                    l.showToast(g.this.Fm().getPageActivity(), g.this.aVI);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aVB = writeData.getContent();
            hE(this.aVB);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> Fm() {
        return this.mContext;
    }

    public void hw(String str) {
        this.aVB = str;
    }

    public void setReplyId(String str) {
        this.aWl = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aWn = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Lc();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aVE = new NewWriteModel(tbPageContext);
            this.aVE.b(this.aVS);
            t.b(this.aWn.Lc(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.aVB = writeData.getContent();
                        g.this.hE(g.this.aVB);
                    }
                }
            });
        }
    }

    public boolean Lu() {
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
                    if (KH() != null) {
                        KH().hide();
                    }
                    LB();
                    cg(true);
                    WriteData writeData = this.aVE.getWriteData();
                    this.aVE.setWriteData(null);
                    this.aVE.nm(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aWn.Lb();
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
                    if (this.aWp != null) {
                        this.aWp.callback(false, postWriteCallBackData, null, this.aVE.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Lz() {
        if (this.aVE.getWriteData() == null) {
            this.aVE.setWriteData(this.aWn.hr(this.aWn.Lc()));
        }
        if (this.aVE.getWriteData() != null) {
            this.aVE.getWriteData().setContent(this.aVB);
            this.aVE.getWriteData().setReplyId(this.aWl);
            if (this.mPostId != null) {
                this.aVE.getWriteData().setRepostId(this.aWn.Lc());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aVE.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aVE.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aVE.getWriteData().setVoice(null);
                    this.aVE.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aVE.getWriteData().setVoice(null);
                this.aVE.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aVE.bDo()) {
                Fm().showToast(e.j.write_img_limit);
            } else if (this.aVM == null || !this.aVM.Le()) {
                if (this.aVL != null) {
                    this.aVL.Lf();
                }
                if (!this.aVE.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        LA();
        this.aVE.cancelLoadData();
    }

    public void onStop() {
    }

    public void LA() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aVB);
        writeData.setReplyId(this.aWl);
        writeData.setThreadId(this.mPostId);
        t.d(this.mPostId, writeData);
    }

    public void LB() {
        t.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.am(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").x("obj_locate", as.a.ayz));
            }
        } else if (i == 230277 || i == 230278) {
            hB(str);
        } else {
            Fm().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aVB);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aVI);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g ff;
        this.aWq = antiData;
        if (antiData != null) {
            this.aVI = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aVI) && KH() != null && (ff = KH().ff(6)) != null && !TextUtils.isEmpty(this.aVI)) {
                ((View) ff).setOnClickListener(this.aWs);
            }
        }
    }

    private void hB(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Fm().getPageActivity());
        aVar.ej(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Fm()).Au();
    }

    private void u(ArrayList<String> arrayList) {
        if (KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean LC() {
        return this.aWo;
    }

    public void ch(boolean z) {
        this.aWo = z;
    }

    public void hC(String str) {
        ch(true);
        KH().pQ();
        if (str != null && str.length() != 0) {
            hE(Fm().getResources().getString(e.j.reply_sub_floor).replace("%s", str));
        } else {
            hE("");
        }
        TiebaStatic.eventStat(Fm().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void hD(String str) {
        ch(true);
        KH().pQ();
        hE(str);
        TiebaStatic.eventStat(Fm().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void LD() {
        ch(false);
        KH().hide();
    }

    public void LE() {
        ch(true);
        KH().pQ();
        KH().aa((View) KH().ff(5));
    }

    public void LF() {
        ch(true);
        KH().pQ();
        KH().aa((View) KH().ff(2));
    }

    public void LG() {
        ch(true);
        KH().pQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hE(String str) {
        if (KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void hF(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(e.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ao.isEmpty(this.aVB) || this.aVB.matches(str2)) {
            if (this.aWm != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aWm).lookingAt()) {
                    hD(this.aWm);
                    return;
                } else {
                    hC(str);
                    return;
                }
            }
            hC(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aVB);
        this.aWm = this.aVB;
        if (matcher.lookingAt()) {
            hD(this.aVB);
        } else {
            hC(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(boolean z) {
        if (KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aWp = dVar;
    }

    public void a(c cVar) {
        this.aVL = cVar;
    }

    public void a(b bVar) {
        this.aVM = bVar;
    }

    public e LH() {
        if (this.aWr == null && KH() != null) {
            this.aWr = (e) KH().fi(27);
        }
        return this.aWr;
    }
}
