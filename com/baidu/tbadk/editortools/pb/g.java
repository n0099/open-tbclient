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
    private String aEB;
    private c aEE;
    private b aEF;
    private NewWriteModel.d aEL;
    private String aEu;
    private NewWriteModel aEx;
    private String aFe;
    private String aFf;
    private DataModel<?> aFg;
    private boolean aFh;
    private NewWriteModel.d aFi;
    private AntiData aFj;
    private e aFk;
    private View.OnClickListener aFl;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.aEu = "";
        this.aFe = "";
        this.aFf = null;
        this.aFh = false;
        this.aEB = null;
        this.aEL = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (g.this.aFi != null) {
                    g.this.aFi.callback(z, postWriteCallBackData, tVar, writeData, antiData);
                }
                if (z) {
                    g.this.aEu = null;
                    g.this.aFe = null;
                    g.this.bF(true);
                    g.this.Ew();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.aEx.getWriteData();
                    g.this.aEx.setWriteData(null);
                    g.this.aEx.mw(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.aFg.DX();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.ts(i)) {
                    g.this.j(i, str);
                } else if (tVar != null && writeData != null && !StringUtils.isNull(tVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.yK());
                    if (com.baidu.tbadk.p.a.hr(tVar.yJ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.yr().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.yJ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.yr().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.yr().showToast(str);
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
        this.aFl = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!TextUtils.isEmpty(g.this.aEB)) {
                    l.showToast(g.this.yr().getPageActivity(), g.this.aEB);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aEu = writeData.getContent();
            gw(this.aEu);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> yr() {
        return this.mContext;
    }

    public void gn(String str) {
        this.aEu = str;
    }

    public void setReplyId(String str) {
        this.aFe = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aFg = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.DY();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aEx = new NewWriteModel(tbPageContext);
            this.aEx.b(this.aEL);
            com.baidu.tieba.tbadkCore.t.b(this.aFg.DY(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.aEu = writeData.getContent();
                        g.this.gw(g.this.aEu);
                    }
                }
            });
        }
    }

    public boolean Ep() {
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
                    if (DD() != null) {
                        DD().hide();
                    }
                    Ew();
                    bF(true);
                    WriteData writeData = this.aEx.getWriteData();
                    this.aEx.setWriteData(null);
                    this.aEx.mw(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aFg.DX();
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
                    if (this.aFi != null) {
                        this.aFi.callback(false, postWriteCallBackData, null, this.aEx.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Eu() {
        if (this.aEx.getWriteData() == null) {
            this.aEx.setWriteData(this.aFg.gi(this.aFg.DY()));
        }
        if (this.aEx.getWriteData() != null) {
            this.aEx.getWriteData().setContent(this.aEu);
            this.aEx.getWriteData().setReplyId(this.aFe);
            if (this.mPostId != null) {
                this.aEx.getWriteData().setRepostId(this.aFg.DY());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aEx.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aEx.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aEx.getWriteData().setVoice(null);
                    this.aEx.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aEx.getWriteData().setVoice(null);
                this.aEx.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aEx.btf()) {
                yr().showToast(d.k.write_img_limit);
            } else if (this.aEF == null || !this.aEF.Ea()) {
                if (this.aEE != null) {
                    this.aEE.Eb();
                }
                if (!this.aEx.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        Ev();
        this.aEx.cancelLoadData();
    }

    public void onStop() {
    }

    public void Ev() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aEu);
        writeData.setReplyId(this.aFe);
        writeData.setThreadId(this.mPostId);
        com.baidu.tieba.tbadkCore.t.d(this.mPostId, writeData);
    }

    public void Ew() {
        com.baidu.tieba.tbadkCore.t.c(this.mPostId, (WriteData) null);
    }

    public void j(int i, String str) {
        if (AntiHelper.ts(i)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.ajd));
            }
        } else if (i == 230277 || i == 230278) {
            gt(str);
        } else {
            yr().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aEu);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aEB);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g eF;
        this.aFj = antiData;
        if (antiData != null) {
            this.aEB = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aEB) && DD() != null && (eF = DD().eF(6)) != null && !TextUtils.isEmpty(this.aEB)) {
                ((View) eF).setOnClickListener(this.aFl);
            }
        }
    }

    private void gt(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(yr().getPageActivity());
        aVar.dc(str);
        aVar.b(d.k.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(yr()).tC();
    }

    private void q(ArrayList<String> arrayList) {
        if (DD() != null) {
            DD().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean Ex() {
        return this.aFh;
    }

    public void bG(boolean z) {
        this.aFh = z;
    }

    public void gu(String str) {
        bG(true);
        DD().lM();
        if (str != null && str.length() != 0) {
            gw(yr().getResources().getString(d.k.reply_sub_floor).replace("%s", str));
        } else {
            gw("");
        }
        TiebaStatic.eventStat(yr().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gv(String str) {
        bG(true);
        DD().lM();
        gw(str);
        TiebaStatic.eventStat(yr().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Ey() {
        bG(false);
        DD().hide();
    }

    public void Ez() {
        bG(true);
        DD().lM();
        DD().M((View) DD().eF(5));
    }

    public void EA() {
        bG(true);
        DD().lM();
        DD().M((View) DD().eF(2));
    }

    public void EB() {
        bG(true);
        DD().lM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(String str) {
        if (DD() != null) {
            DD().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void gx(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.k.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (an.isEmpty(this.aEu) || this.aEu.matches(str2)) {
            if (this.aFf != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aFf).lookingAt()) {
                    gv(this.aFf);
                    return;
                } else {
                    gu(str);
                    return;
                }
            }
            gu(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aEu);
        this.aFf = this.aEu;
        if (matcher.lookingAt()) {
            gv(this.aEu);
        } else {
            gu(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (DD() != null) {
            DD().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aFi = dVar;
    }

    public void a(c cVar) {
        this.aEE = cVar;
    }

    public void a(b bVar) {
        this.aEF = bVar;
    }

    public e EC() {
        if (this.aFk == null && DD() != null) {
            this.aFk = (e) DD().eI(27);
        }
        return this.aFk;
    }
}
