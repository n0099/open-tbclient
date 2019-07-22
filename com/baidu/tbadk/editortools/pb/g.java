package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
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
    private NewWriteModel ctD;
    private String ctH;
    private c ctK;
    private b ctL;
    private NewWriteModel.d ctR;
    private i cuo;
    private String cup;
    private DataModel<?> cuq;
    private boolean cus;
    private NewWriteModel.d cut;
    private AntiData cuu;
    private e cuv;
    private View.OnClickListener cuw;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.cup = "";
        this.cus = false;
        this.ctH = null;
        this.ctR = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (g.this.cut != null) {
                    g.this.cut.callback(z, postWriteCallBackData, xVar, writeData, antiData);
                }
                if (z) {
                    g.this.cuo = null;
                    g.this.cup = null;
                    g.this.fp(true);
                    g.this.asT();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.ctD.getWriteData();
                    g.this.ctD.setWriteData(null);
                    g.this.ctD.ri(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.cuq.ast();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aG(i, str)) {
                    g.this.F(i, str);
                } else if (xVar != null && writeData != null && !StringUtils.isNull(xVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.amF());
                    if (com.baidu.tbadk.v.a.ru(xVar.amE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.amk().getPageActivity(), 12006, writeData, false, xVar.amE())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.amk().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.amk().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUd));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUd));
            }
        };
        this.cuw = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.ctH)) {
                    l.showToast(g.this.amk().getPageActivity(), g.this.ctH);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.cuo == null) {
                this.cuo = new i();
            }
            this.cuo.mContent = writeData.getContent();
            this.cuo.cuB = writeData.getSubPbReplyPrefix();
            c(this.cuo);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> amk() {
        return this.mContext;
    }

    public void qr(String str) {
        if (this.cuo == null) {
            this.cuo = new i();
        }
        this.cuo.mContent = str;
    }

    public void a(i iVar) {
        this.cuo = iVar;
    }

    public void setReplyId(String str) {
        this.cup = str;
    }

    public void b(DataModel<?> dataModel) {
        this.cuq = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.asu();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.ctD = new NewWriteModel(tbPageContext);
            this.ctD.b(this.ctR);
            t.b(this.cuq.asu(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (g.this.cuo == null) {
                            g.this.cuo = new i();
                        }
                        g.this.cuo.mContent = writeData.getContent();
                        g.this.cuo.cuB = writeData.getSubPbReplyPrefix();
                        g.this.c(g.this.cuo);
                    }
                }
            });
        }
    }

    public boolean asM() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        z(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    if (arY() != null) {
                        arY().hide();
                    }
                    asT();
                    fp(true);
                    WriteData writeData = this.ctD.getWriteData();
                    this.ctD.setWriteData(null);
                    this.ctD.ri(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.cuq.ast();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12006:
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.cut != null) {
                        this.cut.callback(false, postWriteCallBackData, null, this.ctD.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void asR() {
        if (this.ctD.getWriteData() == null) {
            this.ctD.setWriteData(this.cuq.qm(this.cuq.asu()));
        }
        if (this.ctD.getWriteData() != null) {
            if (this.cuo != null) {
                this.ctD.getWriteData().setContent(this.cuo.mContent);
                this.ctD.getWriteData().setSubPbReplyPrefix(this.cuo.cuB);
            }
            this.ctD.getWriteData().setReplyId(this.cup);
            if (this.mPostId != null) {
                this.ctD.getWriteData().setRepostId(this.cuq.asu());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.ctD.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.ctD.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.ctD.getWriteData().setVoice(null);
                    this.ctD.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.ctD.getWriteData().setVoice(null);
                this.ctD.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.ctD.cqB()) {
                amk().showToast((int) R.string.write_img_limit);
            } else if (this.ctL == null || !this.ctL.asw()) {
                if (this.ctK != null) {
                    this.ctK.asx();
                }
                if (!this.ctD.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        asS();
        this.ctD.cancelLoadData();
    }

    public void onStop() {
    }

    public void asS() {
        WriteData writeData = new WriteData(2);
        if (this.cuo != null) {
            writeData.setContent(this.cuo.mContent);
            writeData.setSubPbReplyPrefix(this.cuo.cuB);
        }
        writeData.setReplyId(this.cup);
        writeData.setThreadId(this.mPostId);
        t.e(this.mPostId, writeData);
    }

    public void asT() {
        t.d(this.mPostId, (WriteData) null);
    }

    public void F(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUd));
            }
        } else if (i == 230277 || i == 230278) {
            qv(str);
        } else {
            amk().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.cuo != null) {
            pbEditorData.setContent(this.cuo.mContent);
            pbEditorData.setSubPbReplyPrefix(this.cuo.cuB);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.ctH);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g km;
        this.cuu = antiData;
        if (antiData != null) {
            this.ctH = antiData.getVoice_message();
            if (!StringUtils.isNull(this.ctH) && arY() != null && (km = arY().km(6)) != null && !TextUtils.isEmpty(this.ctH)) {
                ((View) km).setOnClickListener(this.cuw);
            }
        }
    }

    private void qv(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(amk().getPageActivity());
        aVar.mO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(amk()).agI();
    }

    private void z(ArrayList<String> arrayList) {
        if (arY() != null) {
            arY().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean asU() {
        return this.cus;
    }

    public void fq(boolean z) {
        this.cus = z;
    }

    public void qw(String str) {
        fq(true);
        arY().qk();
        if (str != null && str.length() != 0) {
            String replace = amk().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            i iVar = new i();
            iVar.cuB = replace;
            c(iVar);
        } else {
            i iVar2 = new i();
            iVar2.mContent = "";
            c(iVar2);
        }
        TiebaStatic.eventStat(amk().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(i iVar) {
        fq(true);
        arY().qk();
        c(iVar);
        TiebaStatic.eventStat(amk().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void asV() {
        fq(false);
        arY().hide();
    }

    public void asW() {
        fq(true);
        arY().qk();
        arY().bd((View) arY().km(5));
    }

    public void asX() {
        fq(true);
        arY().qk();
        arY().bd((View) arY().km(2));
    }

    public void asY() {
        fq(true);
        arY().qk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (arY() != null) {
            arY().b(new com.baidu.tbadk.editortools.a(6, 27, iVar));
        }
    }

    public void qx(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.cuo != null) {
                if (TextUtils.isEmpty(this.cuo.cuB) && TextUtils.isEmpty(this.cuo.mContent)) {
                    qw(str);
                    return;
                } else if (!TextUtils.isEmpty(this.cuo.cuB) && this.cuo.cuB.equals(replace)) {
                    b(this.cuo);
                    return;
                } else {
                    qw(str);
                    return;
                }
            }
            qw(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (arY() != null) {
            arY().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.cut = dVar;
    }

    public void a(c cVar) {
        this.ctK = cVar;
    }

    public void a(b bVar) {
        this.ctL = bVar;
    }

    public e asZ() {
        if (this.cuv == null && arY() != null) {
            this.cuv = (e) arY().kp(27);
        }
        return this.cuv;
    }
}
