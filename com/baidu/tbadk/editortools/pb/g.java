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
    private i ckR;
    private String ckS;
    private DataModel<?> ckT;
    private boolean ckU;
    private NewWriteModel.d ckV;
    private AntiData ckW;
    private e ckX;
    private View.OnClickListener ckY;
    private NewWriteModel ckg;
    private String ckk;
    private c ckn;
    private b cko;
    private NewWriteModel.d cku;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.ckS = "";
        this.ckU = false;
        this.ckk = null;
        this.cku = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (g.this.ckV != null) {
                    g.this.ckV.callback(z, postWriteCallBackData, xVar, writeData, antiData);
                }
                if (z) {
                    g.this.ckR = null;
                    g.this.ckS = null;
                    g.this.eP(true);
                    g.this.amK();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.ckg.getWriteData();
                    g.this.ckg.setWriteData(null);
                    g.this.ckg.qd(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.ckT.amk();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aD(i, str)) {
                    g.this.C(i, str);
                } else if (xVar != null && writeData != null && !StringUtils.isNull(xVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.agB());
                    if (com.baidu.tbadk.u.a.pU(xVar.agA())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.agg().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.agA())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.agg().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.agg().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLo));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLo));
            }
        };
        this.ckY = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.ckk)) {
                    l.showToast(g.this.agg().getPageActivity(), g.this.ckk);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.ckR == null) {
                this.ckR = new i();
            }
            this.ckR.mContent = writeData.getContent();
            this.ckR.cld = writeData.getSubPbReplyPrefix();
            c(this.ckR);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> agg() {
        return this.mContext;
    }

    public void oT(String str) {
        if (this.ckR == null) {
            this.ckR = new i();
        }
        this.ckR.mContent = str;
    }

    public void a(i iVar) {
        this.ckR = iVar;
    }

    public void setReplyId(String str) {
        this.ckS = str;
    }

    public void b(DataModel<?> dataModel) {
        this.ckT = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.aml();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.ckg = new NewWriteModel(tbPageContext);
            this.ckg.b(this.cku);
            t.b(this.ckT.aml(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (g.this.ckR == null) {
                            g.this.ckR = new i();
                        }
                        g.this.ckR.mContent = writeData.getContent();
                        g.this.ckR.cld = writeData.getSubPbReplyPrefix();
                        g.this.c(g.this.ckR);
                    }
                }
            });
        }
    }

    public boolean amD() {
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
                    if (alP() != null) {
                        alP().hide();
                    }
                    amK();
                    eP(true);
                    WriteData writeData = this.ckg.getWriteData();
                    this.ckg.setWriteData(null);
                    this.ckg.qd(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.ckT.amk();
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
                    if (this.ckV != null) {
                        this.ckV.callback(false, postWriteCallBackData, null, this.ckg.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void amI() {
        if (this.ckg.getWriteData() == null) {
            this.ckg.setWriteData(this.ckT.oO(this.ckT.aml()));
        }
        if (this.ckg.getWriteData() != null) {
            if (this.ckR != null) {
                this.ckg.getWriteData().setContent(this.ckR.mContent);
                this.ckg.getWriteData().setSubPbReplyPrefix(this.ckR.cld);
            }
            this.ckg.getWriteData().setReplyId(this.ckS);
            if (this.mPostId != null) {
                this.ckg.getWriteData().setRepostId(this.ckT.aml());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.ckg.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.ckg.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.ckg.getWriteData().setVoice(null);
                    this.ckg.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.ckg.getWriteData().setVoice(null);
                this.ckg.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.ckg.cfB()) {
                agg().showToast(d.j.write_img_limit);
            } else if (this.cko == null || !this.cko.amn()) {
                if (this.ckn != null) {
                    this.ckn.amo();
                }
                if (!this.ckg.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        amJ();
        this.ckg.cancelLoadData();
    }

    public void onStop() {
    }

    public void amJ() {
        WriteData writeData = new WriteData(2);
        if (this.ckR != null) {
            writeData.setContent(this.ckR.mContent);
            writeData.setSubPbReplyPrefix(this.ckR.cld);
        }
        writeData.setReplyId(this.ckS);
        writeData.setThreadId(this.mPostId);
        t.e(this.mPostId, writeData);
    }

    public void amK() {
        t.d(this.mPostId, (WriteData) null);
    }

    public void C(int i, String str) {
        if (AntiHelper.aD(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLo));
            }
        } else if (i == 230277 || i == 230278) {
            oX(str);
        } else {
            agg().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.ckR != null) {
            pbEditorData.setContent(this.ckR.mContent);
            pbEditorData.setSubPbReplyPrefix(this.ckR.cld);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.ckk);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g js;
        this.ckW = antiData;
        if (antiData != null) {
            this.ckk = antiData.getVoice_message();
            if (!StringUtils.isNull(this.ckk) && alP() != null && (js = alP().js(6)) != null && !TextUtils.isEmpty(this.ckk)) {
                ((View) js).setOnClickListener(this.ckY);
            }
        }
    }

    private void oX(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(agg().getPageActivity());
        aVar.lz(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(agg()).aaW();
    }

    private void w(ArrayList<String> arrayList) {
        if (alP() != null) {
            alP().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean amL() {
        return this.ckU;
    }

    public void eQ(boolean z) {
        this.ckU = z;
    }

    public void oY(String str) {
        eQ(true);
        alP().qT();
        if (str != null && str.length() != 0) {
            String replace = agg().getResources().getString(d.j.reply_sub_floor).replace("%s", str);
            i iVar = new i();
            iVar.cld = replace;
            c(iVar);
        } else {
            i iVar2 = new i();
            iVar2.mContent = "";
            c(iVar2);
        }
        TiebaStatic.eventStat(agg().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(i iVar) {
        eQ(true);
        alP().qT();
        c(iVar);
        TiebaStatic.eventStat(agg().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void amM() {
        eQ(false);
        alP().hide();
    }

    public void amN() {
        eQ(true);
        alP().qT();
        alP().aV((View) alP().js(5));
    }

    public void amO() {
        eQ(true);
        alP().qT();
        alP().aV((View) alP().js(2));
    }

    public void amP() {
        eQ(true);
        alP().qT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (alP() != null) {
            alP().b(new com.baidu.tbadk.editortools.a(6, 27, iVar));
        }
    }

    public void oZ(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(d.j.reply_sub_floor).replace("%s", str);
            if (this.ckR != null) {
                if (TextUtils.isEmpty(this.ckR.cld) && TextUtils.isEmpty(this.ckR.mContent)) {
                    oY(str);
                    return;
                } else if (!TextUtils.isEmpty(this.ckR.cld) && this.ckR.cld.equals(replace)) {
                    b(this.ckR);
                    return;
                } else {
                    oY(str);
                    return;
                }
            }
            oY(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(boolean z) {
        if (alP() != null) {
            alP().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.ckV = dVar;
    }

    public void a(c cVar) {
        this.ckn = cVar;
    }

    public void a(b bVar) {
        this.cko = bVar;
    }

    public e amQ() {
        if (this.ckX == null && alP() != null) {
            this.ckX = (e) alP().jv(27);
        }
        return this.ckX;
    }
}
