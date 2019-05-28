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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.editortools.d {
    private NewWriteModel.d csD;
    private NewWriteModel csp;
    private String cst;
    private c csw;
    private b csx;
    private i cta;
    private String ctb;
    private DataModel<?> ctc;
    private boolean ctd;
    private NewWriteModel.d cte;
    private AntiData ctf;
    private e ctg;
    private View.OnClickListener cth;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.ctb = "";
        this.ctd = false;
        this.cst = null;
        this.csD = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (g.this.cte != null) {
                    g.this.cte.callback(z, postWriteCallBackData, xVar, writeData, antiData);
                }
                if (z) {
                    g.this.cta = null;
                    g.this.ctb = null;
                    g.this.fl(true);
                    g.this.arN();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.csp.getWriteData();
                    g.this.csp.setWriteData(null);
                    g.this.csp.qS(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.ctc.arn();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aG(i, str)) {
                    g.this.F(i, str);
                } else if (xVar != null && writeData != null && !StringUtils.isNull(xVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.alA());
                    if (com.baidu.tbadk.v.a.rd(xVar.alz())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.alf().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.alz())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.alf().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.alf().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTb));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTb));
            }
        };
        this.cth = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.cst)) {
                    l.showToast(g.this.alf().getPageActivity(), g.this.cst);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.cta == null) {
                this.cta = new i();
            }
            this.cta.mContent = writeData.getContent();
            this.cta.ctm = writeData.getSubPbReplyPrefix();
            c(this.cta);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> alf() {
        return this.mContext;
    }

    public void qb(String str) {
        if (this.cta == null) {
            this.cta = new i();
        }
        this.cta.mContent = str;
    }

    public void a(i iVar) {
        this.cta = iVar;
    }

    public void setReplyId(String str) {
        this.ctb = str;
    }

    public void b(DataModel<?> dataModel) {
        this.ctc = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.aro();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.csp = new NewWriteModel(tbPageContext);
            this.csp.b(this.csD);
            t.b(this.ctc.aro(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (g.this.cta == null) {
                            g.this.cta = new i();
                        }
                        g.this.cta.mContent = writeData.getContent();
                        g.this.cta.ctm = writeData.getSubPbReplyPrefix();
                        g.this.c(g.this.cta);
                    }
                }
            });
        }
    }

    public boolean arG() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        z(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (aqS() != null) {
                        aqS().hide();
                    }
                    arN();
                    fl(true);
                    WriteData writeData = this.csp.getWriteData();
                    this.csp.setWriteData(null);
                    this.csp.qS(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.ctc.arn();
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
                    if (this.cte != null) {
                        this.cte.callback(false, postWriteCallBackData, null, this.csp.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void arL() {
        if (this.csp.getWriteData() == null) {
            this.csp.setWriteData(this.ctc.pW(this.ctc.aro()));
        }
        if (this.csp.getWriteData() != null) {
            if (this.cta != null) {
                this.csp.getWriteData().setContent(this.cta.mContent);
                this.csp.getWriteData().setSubPbReplyPrefix(this.cta.ctm);
            }
            this.csp.getWriteData().setReplyId(this.ctb);
            if (this.mPostId != null) {
                this.csp.getWriteData().setRepostId(this.ctc.aro());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.csp.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.csp.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.csp.getWriteData().setVoice(null);
                    this.csp.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.csp.getWriteData().setVoice(null);
                this.csp.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.csp.cnH()) {
                alf().showToast((int) R.string.write_img_limit);
            } else if (this.csx == null || !this.csx.arq()) {
                if (this.csw != null) {
                    this.csw.arr();
                }
                if (!this.csp.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        arM();
        this.csp.cancelLoadData();
    }

    public void onStop() {
    }

    public void arM() {
        WriteData writeData = new WriteData(2);
        if (this.cta != null) {
            writeData.setContent(this.cta.mContent);
            writeData.setSubPbReplyPrefix(this.cta.ctm);
        }
        writeData.setReplyId(this.ctb);
        writeData.setThreadId(this.mPostId);
        t.e(this.mPostId, writeData);
    }

    public void arN() {
        t.d(this.mPostId, (WriteData) null);
    }

    public void F(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTb));
            }
        } else if (i == 230277 || i == 230278) {
            qf(str);
        } else {
            alf().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.cta != null) {
            pbEditorData.setContent(this.cta.mContent);
            pbEditorData.setSubPbReplyPrefix(this.cta.ctm);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.cst);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g kg;
        this.ctf = antiData;
        if (antiData != null) {
            this.cst = antiData.getVoice_message();
            if (!StringUtils.isNull(this.cst) && aqS() != null && (kg = aqS().kg(6)) != null && !TextUtils.isEmpty(this.cst)) {
                ((View) kg).setOnClickListener(this.cth);
            }
        }
    }

    private void qf(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(alf().getPageActivity());
        aVar.mE(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(alf()).afG();
    }

    private void z(ArrayList<String> arrayList) {
        if (aqS() != null) {
            aqS().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean arO() {
        return this.ctd;
    }

    public void fm(boolean z) {
        this.ctd = z;
    }

    public void qg(String str) {
        fm(true);
        aqS().pO();
        if (str != null && str.length() != 0) {
            String replace = alf().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            i iVar = new i();
            iVar.ctm = replace;
            c(iVar);
        } else {
            i iVar2 = new i();
            iVar2.mContent = "";
            c(iVar2);
        }
        TiebaStatic.eventStat(alf().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(i iVar) {
        fm(true);
        aqS().pO();
        c(iVar);
        TiebaStatic.eventStat(alf().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void arP() {
        fm(false);
        aqS().hide();
    }

    public void arQ() {
        fm(true);
        aqS().pO();
        aqS().bb((View) aqS().kg(5));
    }

    public void arR() {
        fm(true);
        aqS().pO();
        aqS().bb((View) aqS().kg(2));
    }

    public void arS() {
        fm(true);
        aqS().pO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (aqS() != null) {
            aqS().b(new com.baidu.tbadk.editortools.a(6, 27, iVar));
        }
    }

    public void qh(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.cta != null) {
                if (TextUtils.isEmpty(this.cta.ctm) && TextUtils.isEmpty(this.cta.mContent)) {
                    qg(str);
                    return;
                } else if (!TextUtils.isEmpty(this.cta.ctm) && this.cta.ctm.equals(replace)) {
                    b(this.cta);
                    return;
                } else {
                    qg(str);
                    return;
                }
            }
            qg(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(boolean z) {
        if (aqS() != null) {
            aqS().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.cte = dVar;
    }

    public void a(c cVar) {
        this.csw = cVar;
    }

    public void a(b bVar) {
        this.csx = bVar;
    }

    public e arT() {
        if (this.ctg == null && aqS() != null) {
            this.ctg = (e) aqS().kj(27);
        }
        return this.ctg;
    }
}
