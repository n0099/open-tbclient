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
    private String aRK;
    private String aRL;
    private DataModel<?> aRM;
    private boolean aRN;
    private NewWriteModel.d aRO;
    private AntiData aRP;
    private e aRQ;
    private View.OnClickListener aRR;
    private String aRa;
    private NewWriteModel aRd;
    private String aRh;
    private c aRk;
    private b aRl;
    private NewWriteModel.d aRr;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.aRa = "";
        this.aRK = "";
        this.aRL = null;
        this.aRN = false;
        this.aRh = null;
        this.aRr = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, v vVar, WriteData writeData, AntiData antiData) {
                if (g.this.aRO != null) {
                    g.this.aRO.callback(z, postWriteCallBackData, vVar, writeData, antiData);
                }
                if (z) {
                    g.this.aRa = null;
                    g.this.aRK = null;
                    g.this.bX(true);
                    g.this.JD();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.aRd.getWriteData();
                    g.this.aRd.setWriteData(null);
                    g.this.aRd.mV(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.aRM.Jd();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.am(i, str)) {
                    g.this.l(i, str);
                } else if (vVar != null && writeData != null && !StringUtils.isNull(vVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(vVar.getVcode_md5());
                    writeData.setVcodeUrl(vVar.getVcode_pic_url());
                    writeData.setVcodeExtra(vVar.DF());
                    if (com.baidu.tbadk.q.a.il(vVar.DE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.Dl().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, vVar.DE())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.Dl().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.Dl().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").w("obj_locate", as.a.atO));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").w("obj_locate", as.a.atO));
            }
        };
        this.aRR = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.aRh)) {
                    l.showToast(g.this.Dl().getPageActivity(), g.this.aRh);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aRa = writeData.getContent();
            hq(this.aRa);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> Dl() {
        return this.mContext;
    }

    public void hi(String str) {
        this.aRa = str;
    }

    public void setReplyId(String str) {
        this.aRK = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aRM = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Je();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aRd = new NewWriteModel(tbPageContext);
            this.aRd.b(this.aRr);
            t.b(this.aRM.Je(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.aRa = writeData.getContent();
                        g.this.hq(g.this.aRa);
                    }
                }
            });
        }
    }

    public boolean Jw() {
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
                    if (IJ() != null) {
                        IJ().hide();
                    }
                    JD();
                    bX(true);
                    WriteData writeData = this.aRd.getWriteData();
                    this.aRd.setWriteData(null);
                    this.aRd.mV(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aRM.Jd();
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
                    if (this.aRO != null) {
                        this.aRO.callback(false, postWriteCallBackData, null, this.aRd.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void JB() {
        if (this.aRd.getWriteData() == null) {
            this.aRd.setWriteData(this.aRM.hd(this.aRM.Je()));
        }
        if (this.aRd.getWriteData() != null) {
            this.aRd.getWriteData().setContent(this.aRa);
            this.aRd.getWriteData().setReplyId(this.aRK);
            if (this.mPostId != null) {
                this.aRd.getWriteData().setRepostId(this.aRM.Je());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aRd.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aRd.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aRd.getWriteData().setVoice(null);
                    this.aRd.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aRd.getWriteData().setVoice(null);
                this.aRd.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aRd.bAa()) {
                Dl().showToast(e.j.write_img_limit);
            } else if (this.aRl == null || !this.aRl.Jg()) {
                if (this.aRk != null) {
                    this.aRk.Jh();
                }
                if (!this.aRd.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        JC();
        this.aRd.cancelLoadData();
    }

    public void onStop() {
    }

    public void JC() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aRa);
        writeData.setReplyId(this.aRK);
        writeData.setThreadId(this.mPostId);
        t.d(this.mPostId, writeData);
    }

    public void JD() {
        t.c(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.am(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").w("obj_locate", as.a.atO));
            }
        } else if (i == 230277 || i == 230278) {
            hn(str);
        } else {
            Dl().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aRa);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aRh);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g eW;
        this.aRP = antiData;
        if (antiData != null) {
            this.aRh = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aRh) && IJ() != null && (eW = IJ().eW(6)) != null && !TextUtils.isEmpty(this.aRh)) {
                ((View) eW).setOnClickListener(this.aRR);
            }
        }
    }

    private void hn(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Dl().getPageActivity());
        aVar.dT(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(Dl()).yl();
    }

    private void u(ArrayList<String> arrayList) {
        if (IJ() != null) {
            IJ().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean JE() {
        return this.aRN;
    }

    public void bY(boolean z) {
        this.aRN = z;
    }

    public void ho(String str) {
        bY(true);
        IJ().pI();
        if (str != null && str.length() != 0) {
            hq(Dl().getResources().getString(e.j.reply_sub_floor).replace("%s", str));
        } else {
            hq("");
        }
        TiebaStatic.eventStat(Dl().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void hp(String str) {
        bY(true);
        IJ().pI();
        hq(str);
        TiebaStatic.eventStat(Dl().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void JF() {
        bY(false);
        IJ().hide();
    }

    public void JG() {
        bY(true);
        IJ().pI();
        IJ().aa((View) IJ().eW(5));
    }

    public void JH() {
        bY(true);
        IJ().pI();
        IJ().aa((View) IJ().eW(2));
    }

    public void JI() {
        bY(true);
        IJ().pI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hq(String str) {
        if (IJ() != null) {
            IJ().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void hr(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(e.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ao.isEmpty(this.aRa) || this.aRa.matches(str2)) {
            if (this.aRL != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aRL).lookingAt()) {
                    hp(this.aRL);
                    return;
                } else {
                    ho(str);
                    return;
                }
            }
            ho(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aRa);
        this.aRL = this.aRa;
        if (matcher.lookingAt()) {
            hp(this.aRa);
        } else {
            ho(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(boolean z) {
        if (IJ() != null) {
            IJ().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aRO = dVar;
    }

    public void a(c cVar) {
        this.aRk = cVar;
    }

    public void a(b bVar) {
        this.aRl = bVar;
    }

    public e JJ() {
        if (this.aRQ == null && IJ() != null) {
            this.aRQ = (e) IJ().eZ(27);
        }
        return this.aRQ;
    }
}
