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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.editortools.d {
    private i ckP;
    private String ckQ;
    private DataModel<?> ckR;
    private boolean ckS;
    private NewWriteModel.d ckT;
    private AntiData ckU;
    private e ckV;
    private View.OnClickListener ckW;
    private NewWriteModel cke;
    private String cki;
    private c ckl;
    private b ckm;
    private NewWriteModel.d cks;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.ckQ = "";
        this.ckS = false;
        this.cki = null;
        this.cks = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (g.this.ckT != null) {
                    g.this.ckT.callback(z, postWriteCallBackData, xVar, writeData, antiData);
                }
                if (z) {
                    g.this.ckP = null;
                    g.this.ckQ = null;
                    g.this.eP(true);
                    g.this.amO();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.cke.getWriteData();
                    g.this.cke.setWriteData(null);
                    g.this.cke.qd(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.ckR.amo();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aB(i, str)) {
                    g.this.C(i, str);
                } else if (xVar != null && writeData != null && !StringUtils.isNull(xVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.agE());
                    if (com.baidu.tbadk.u.a.pU(xVar.agD())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.agj().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.agD())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.agj().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.agj().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLl));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLl));
            }
        };
        this.ckW = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.cki)) {
                    l.showToast(g.this.agj().getPageActivity(), g.this.cki);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.ckP == null) {
                this.ckP = new i();
            }
            this.ckP.mContent = writeData.getContent();
            this.ckP.clb = writeData.getSubPbReplyPrefix();
            c(this.ckP);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> agj() {
        return this.mContext;
    }

    public void oS(String str) {
        if (this.ckP == null) {
            this.ckP = new i();
        }
        this.ckP.mContent = str;
    }

    public void a(i iVar) {
        this.ckP = iVar;
    }

    public void setReplyId(String str) {
        this.ckQ = str;
    }

    public void b(DataModel<?> dataModel) {
        this.ckR = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.amp();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.cke = new NewWriteModel(tbPageContext);
            this.cke.b(this.cks);
            t.b(this.ckR.amp(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (g.this.ckP == null) {
                            g.this.ckP = new i();
                        }
                        g.this.ckP.mContent = writeData.getContent();
                        g.this.ckP.clb = writeData.getSubPbReplyPrefix();
                        g.this.c(g.this.ckP);
                    }
                }
            });
        }
    }

    public boolean amH() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        w(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (alT() != null) {
                        alT().hide();
                    }
                    amO();
                    eP(true);
                    WriteData writeData = this.cke.getWriteData();
                    this.cke.setWriteData(null);
                    this.cke.qd(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.ckR.amo();
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
                    if (this.ckT != null) {
                        this.ckT.callback(false, postWriteCallBackData, null, this.cke.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void amM() {
        if (this.cke.getWriteData() == null) {
            this.cke.setWriteData(this.ckR.oN(this.ckR.amp()));
        }
        if (this.cke.getWriteData() != null) {
            if (this.ckP != null) {
                this.cke.getWriteData().setContent(this.ckP.mContent);
                this.cke.getWriteData().setSubPbReplyPrefix(this.ckP.clb);
            }
            this.cke.getWriteData().setReplyId(this.ckQ);
            if (this.mPostId != null) {
                this.cke.getWriteData().setRepostId(this.ckR.amp());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.cke.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.cke.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.cke.getWriteData().setVoice(null);
                    this.cke.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.cke.getWriteData().setVoice(null);
                this.cke.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.cke.cfC()) {
                agj().showToast(d.j.write_img_limit);
            } else if (this.ckm == null || !this.ckm.amr()) {
                if (this.ckl != null) {
                    this.ckl.ams();
                }
                if (!this.cke.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        amN();
        this.cke.cancelLoadData();
    }

    public void onStop() {
    }

    public void amN() {
        WriteData writeData = new WriteData(2);
        if (this.ckP != null) {
            writeData.setContent(this.ckP.mContent);
            writeData.setSubPbReplyPrefix(this.ckP.clb);
        }
        writeData.setReplyId(this.ckQ);
        writeData.setThreadId(this.mPostId);
        t.e(this.mPostId, writeData);
    }

    public void amO() {
        t.d(this.mPostId, (WriteData) null);
    }

    public void C(int i, String str) {
        if (AntiHelper.aB(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLl));
            }
        } else if (i == 230277 || i == 230278) {
            oW(str);
        } else {
            agj().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.ckP != null) {
            pbEditorData.setContent(this.ckP.mContent);
            pbEditorData.setSubPbReplyPrefix(this.ckP.clb);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.cki);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g jt;
        this.ckU = antiData;
        if (antiData != null) {
            this.cki = antiData.getVoice_message();
            if (!StringUtils.isNull(this.cki) && alT() != null && (jt = alT().jt(6)) != null && !TextUtils.isEmpty(this.cki)) {
                ((View) jt).setOnClickListener(this.ckW);
            }
        }
    }

    private void oW(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(agj().getPageActivity());
        aVar.ly(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(agj()).aaZ();
    }

    private void w(ArrayList<String> arrayList) {
        if (alT() != null) {
            alT().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean amP() {
        return this.ckS;
    }

    public void eQ(boolean z) {
        this.ckS = z;
    }

    public void oX(String str) {
        eQ(true);
        alT().qT();
        if (str != null && str.length() != 0) {
            String replace = agj().getResources().getString(d.j.reply_sub_floor).replace("%s", str);
            i iVar = new i();
            iVar.clb = replace;
            c(iVar);
        } else {
            i iVar2 = new i();
            iVar2.mContent = "";
            c(iVar2);
        }
        TiebaStatic.eventStat(agj().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(i iVar) {
        eQ(true);
        alT().qT();
        c(iVar);
        TiebaStatic.eventStat(agj().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void amQ() {
        eQ(false);
        alT().hide();
    }

    public void amR() {
        eQ(true);
        alT().qT();
        alT().aV((View) alT().jt(5));
    }

    public void amS() {
        eQ(true);
        alT().qT();
        alT().aV((View) alT().jt(2));
    }

    public void amT() {
        eQ(true);
        alT().qT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (alT() != null) {
            alT().b(new com.baidu.tbadk.editortools.a(6, 27, iVar));
        }
    }

    public void oY(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(d.j.reply_sub_floor).replace("%s", str);
            if (this.ckP != null) {
                if (TextUtils.isEmpty(this.ckP.clb) && TextUtils.isEmpty(this.ckP.mContent)) {
                    oX(str);
                    return;
                } else if (!TextUtils.isEmpty(this.ckP.clb) && this.ckP.clb.equals(replace)) {
                    b(this.ckP);
                    return;
                } else {
                    oX(str);
                    return;
                }
            }
            oX(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(boolean z) {
        if (alT() != null) {
            alT().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.ckT = dVar;
    }

    public void a(c cVar) {
        this.ckl = cVar;
    }

    public void a(b bVar) {
        this.ckm = bVar;
    }

    public e amU() {
        if (this.ckV == null && alT() != null) {
            this.ckV = (e) alT().jw(27);
        }
        return this.ckV;
    }
}
