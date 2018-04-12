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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
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
    private String aEA;
    private c aED;
    private b aEE;
    private NewWriteModel.d aEK;
    private String aEt;
    private NewWriteModel aEw;
    private String aFd;
    private String aFe;
    private DataModel<?> aFf;
    private boolean aFg;
    private NewWriteModel.d aFh;
    private AntiData aFi;
    private e aFj;
    private View.OnClickListener aFk;
    private TbPageContext<?> adf;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.aEt = "";
        this.aFd = "";
        this.aFe = null;
        this.aFg = false;
        this.aEA = null;
        this.aEK = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (g.this.aFh != null) {
                    g.this.aFh.callback(z, postWriteCallBackData, tVar, writeData, antiData);
                }
                if (z) {
                    g.this.aEt = null;
                    g.this.aFd = null;
                    g.this.bF(true);
                    g.this.Ey();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.aEw.getWriteData();
                    g.this.aEw.setWriteData(null);
                    g.this.aEw.mv(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.aFf.DZ();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.tu(i)) {
                    g.this.j(i, str);
                } else if (tVar != null && writeData != null && !StringUtils.isNull(tVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.yL());
                    if (com.baidu.tbadk.p.a.hq(tVar.yK())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.ys().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.yK())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.ys().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.adf.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.ys().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.ajd));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.ajd));
            }
        };
        this.aFk = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(g.this.aEA)) {
                    l.showToast(g.this.ys().getPageActivity(), g.this.aEA);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aEt = writeData.getContent();
            gw(this.aEt);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.adf = tbPageContext;
    }

    public TbPageContext<?> ys() {
        return this.adf;
    }

    public void gn(String str) {
        this.aEt = str;
    }

    public void setReplyId(String str) {
        this.aFd = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aFf = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Ea();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aEw = new NewWriteModel(tbPageContext);
            this.aEw.b(this.aEK);
            com.baidu.tieba.tbadkCore.t.b(this.aFf.Ea(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.aEt = writeData.getContent();
                        g.this.gw(g.this.aEt);
                    }
                }
            });
        }
    }

    public boolean Er() {
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
                    if (DF() != null) {
                        DF().hide();
                    }
                    Ey();
                    bF(true);
                    WriteData writeData = this.aEw.getWriteData();
                    this.aEw.setWriteData(null);
                    this.aEw.mv(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aFf.DZ();
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
                    if (this.aFh != null) {
                        this.aFh.callback(false, postWriteCallBackData, null, this.aEw.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Ew() {
        if (this.aEw.getWriteData() == null) {
            this.aEw.setWriteData(this.aFf.gi(this.aFf.Ea()));
        }
        if (this.aEw.getWriteData() != null) {
            this.aEw.getWriteData().setContent(this.aEt);
            this.aEw.getWriteData().setReplyId(this.aFd);
            if (this.mPostId != null) {
                this.aEw.getWriteData().setRepostId(this.aFf.Ea());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aEw.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aEw.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aEw.getWriteData().setVoice(null);
                    this.aEw.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aEw.getWriteData().setVoice(null);
                this.aEw.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aEw.bth()) {
                ys().showToast(d.k.write_img_limit);
            } else if (this.aEE == null || !this.aEE.Ec()) {
                if (this.aED != null) {
                    this.aED.Ed();
                }
                if (!this.aEw.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        Ex();
        this.aEw.cancelLoadData();
    }

    public void onStop() {
    }

    public void Ex() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aEt);
        writeData.setReplyId(this.aFd);
        writeData.setThreadId(this.mPostId);
        com.baidu.tieba.tbadkCore.t.d(this.mPostId, writeData);
    }

    public void Ey() {
        com.baidu.tieba.tbadkCore.t.c(this.mPostId, (WriteData) null);
    }

    public void j(int i, String str) {
        if (AntiHelper.tu(i)) {
            if (AntiHelper.a(this.adf.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.ajd));
            }
        } else if (i == 230277 || i == 230278) {
            gt(str);
        } else {
            ys().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aEt);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aEA);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.adf.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g eF;
        this.aFi = antiData;
        if (antiData != null) {
            this.aEA = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aEA) && DF() != null && (eF = DF().eF(6)) != null && !TextUtils.isEmpty(this.aEA)) {
                ((View) eF).setOnClickListener(this.aFk);
            }
        }
    }

    private void gt(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(ys().getPageActivity());
        aVar.dc(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(ys()).tD();
    }

    private void q(ArrayList<String> arrayList) {
        if (DF() != null) {
            DF().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean Ez() {
        return this.aFg;
    }

    public void bG(boolean z) {
        this.aFg = z;
    }

    public void gu(String str) {
        bG(true);
        DF().lN();
        if (str != null && str.length() != 0) {
            gw(ys().getResources().getString(d.k.reply_sub_floor).replace("%s", str));
        } else {
            gw("");
        }
        TiebaStatic.eventStat(ys().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gv(String str) {
        bG(true);
        DF().lN();
        gw(str);
        TiebaStatic.eventStat(ys().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void EA() {
        bG(false);
        DF().hide();
    }

    public void EB() {
        bG(true);
        DF().lN();
        DF().M((View) DF().eF(5));
    }

    public void EC() {
        bG(true);
        DF().lN();
        DF().M((View) DF().eF(2));
    }

    public void ED() {
        bG(true);
        DF().lN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(String str) {
        if (DF() != null) {
            DF().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void gx(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.k.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (an.isEmpty(this.aEt) || this.aEt.matches(str2)) {
            if (this.aFe != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aFe).lookingAt()) {
                    gv(this.aFe);
                    return;
                } else {
                    gu(str);
                    return;
                }
            }
            gu(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aEt);
        this.aFe = this.aEt;
        if (matcher.lookingAt()) {
            gv(this.aEt);
        } else {
            gu(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (DF() != null) {
            DF().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aFh = dVar;
    }

    public void a(c cVar) {
        this.aED = cVar;
    }

    public void a(b bVar) {
        this.aEE = bVar;
    }

    public e EE() {
        if (this.aFj == null && DF() != null) {
            this.aFj = (e) DF().eI(27);
        }
        return this.aFj;
    }
}
