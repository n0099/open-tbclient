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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.editortools.d {
    private NewWriteModel ctK;
    private String ctO;
    private c ctR;
    private b ctS;
    private NewWriteModel.d ctY;
    private NewWriteModel.d cuA;
    private AntiData cuB;
    private e cuC;
    private View.OnClickListener cuD;
    private i cuw;
    private String cux;
    private DataModel<?> cuy;
    private boolean cuz;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.cux = "";
        this.cuz = false;
        this.ctO = null;
        this.ctY = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (g.this.cuA != null) {
                    g.this.cuA.callback(z, postWriteCallBackData, xVar, writeData, antiData);
                }
                if (z) {
                    g.this.cuw = null;
                    g.this.cux = null;
                    g.this.fp(true);
                    g.this.asV();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.ctK.getWriteData();
                    g.this.ctK.setWriteData(null);
                    g.this.ctK.rj(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.cuy.asv();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aG(i, str)) {
                    g.this.F(i, str);
                } else if (xVar != null && writeData != null && !StringUtils.isNull(xVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.amH());
                    if (com.baidu.tbadk.v.a.ru(xVar.amG())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.amm().getPageActivity(), 12006, writeData, false, xVar.amG())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.amm().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.amm().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUj));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUj));
            }
        };
        this.cuD = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.ctO)) {
                    l.showToast(g.this.amm().getPageActivity(), g.this.ctO);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.cuw == null) {
                this.cuw = new i();
            }
            this.cuw.mContent = writeData.getContent();
            this.cuw.cuI = writeData.getSubPbReplyPrefix();
            c(this.cuw);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> amm() {
        return this.mContext;
    }

    public void qr(String str) {
        if (this.cuw == null) {
            this.cuw = new i();
        }
        this.cuw.mContent = str;
    }

    public void a(i iVar) {
        this.cuw = iVar;
    }

    public void setReplyId(String str) {
        this.cux = str;
    }

    public void b(DataModel<?> dataModel) {
        this.cuy = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.asw();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.ctK = new NewWriteModel(tbPageContext);
            this.ctK.b(this.ctY);
            v.b(this.cuy.asw(), new v.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (g.this.cuw == null) {
                            g.this.cuw = new i();
                        }
                        g.this.cuw.mContent = writeData.getContent();
                        g.this.cuw.cuI = writeData.getSubPbReplyPrefix();
                        g.this.c(g.this.cuw);
                    }
                }
            });
        }
    }

    public boolean asO() {
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
                    if (asa() != null) {
                        asa().hide();
                    }
                    asV();
                    fp(true);
                    WriteData writeData = this.ctK.getWriteData();
                    this.ctK.setWriteData(null);
                    this.ctK.rj(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.cuy.asv();
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
                    if (this.cuA != null) {
                        this.cuA.callback(false, postWriteCallBackData, null, this.ctK.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void asT() {
        if (this.ctK.getWriteData() == null) {
            this.ctK.setWriteData(this.cuy.qm(this.cuy.asw()));
        }
        if (this.ctK.getWriteData() != null) {
            if (this.cuw != null) {
                this.ctK.getWriteData().setContent(this.cuw.mContent);
                this.ctK.getWriteData().setSubPbReplyPrefix(this.cuw.cuI);
            }
            this.ctK.getWriteData().setReplyId(this.cux);
            if (this.mPostId != null) {
                this.ctK.getWriteData().setRepostId(this.cuy.asw());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.ctK.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.ctK.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.ctK.getWriteData().setVoice(null);
                    this.ctK.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.ctK.getWriteData().setVoice(null);
                this.ctK.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.ctK.cqX()) {
                amm().showToast((int) R.string.write_img_limit);
            } else if (this.ctS == null || !this.ctS.asy()) {
                if (this.ctR != null) {
                    this.ctR.asz();
                }
                if (!this.ctK.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        asU();
        this.ctK.cancelLoadData();
    }

    public void onStop() {
    }

    public void asU() {
        WriteData writeData = new WriteData(2);
        if (this.cuw != null) {
            writeData.setContent(this.cuw.mContent);
            writeData.setSubPbReplyPrefix(this.cuw.cuI);
        }
        writeData.setReplyId(this.cux);
        writeData.setThreadId(this.mPostId);
        v.e(this.mPostId, writeData);
    }

    public void asV() {
        v.d(this.mPostId, (WriteData) null);
    }

    public void F(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUj));
            }
        } else if (i == 230277 || i == 230278) {
            qv(str);
        } else {
            amm().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.cuw != null) {
            pbEditorData.setContent(this.cuw.mContent);
            pbEditorData.setSubPbReplyPrefix(this.cuw.cuI);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.ctO);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g kn;
        this.cuB = antiData;
        if (antiData != null) {
            this.ctO = antiData.getVoice_message();
            if (!StringUtils.isNull(this.ctO) && asa() != null && (kn = asa().kn(6)) != null && !TextUtils.isEmpty(this.ctO)) {
                ((View) kn).setOnClickListener(this.cuD);
            }
        }
    }

    private void qv(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(amm().getPageActivity());
        aVar.mO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(amm()).agK();
    }

    private void z(ArrayList<String> arrayList) {
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean asW() {
        return this.cuz;
    }

    public void fq(boolean z) {
        this.cuz = z;
    }

    public void qw(String str) {
        fq(true);
        asa().qk();
        if (str != null && str.length() != 0) {
            String replace = amm().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            i iVar = new i();
            iVar.cuI = replace;
            c(iVar);
        } else {
            i iVar2 = new i();
            iVar2.mContent = "";
            c(iVar2);
        }
        TiebaStatic.eventStat(amm().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(i iVar) {
        fq(true);
        asa().qk();
        c(iVar);
        TiebaStatic.eventStat(amm().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void asX() {
        fq(false);
        asa().hide();
    }

    public void asY() {
        fq(true);
        asa().qk();
        asa().bd((View) asa().kn(5));
    }

    public void asZ() {
        fq(true);
        asa().qk();
        asa().bd((View) asa().kn(2));
    }

    public void ata() {
        fq(true);
        asa().qk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(6, 27, iVar));
        }
    }

    public void qx(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.cuw != null) {
                if (TextUtils.isEmpty(this.cuw.cuI) && TextUtils.isEmpty(this.cuw.mContent)) {
                    qw(str);
                    return;
                } else if (!TextUtils.isEmpty(this.cuw.cuI) && this.cuw.cuI.equals(replace)) {
                    b(this.cuw);
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
        if (asa() != null) {
            asa().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.cuA = dVar;
    }

    public void a(c cVar) {
        this.ctR = cVar;
    }

    public void a(b bVar) {
        this.ctS = bVar;
    }

    public e atb() {
        if (this.cuC == null && asa() != null) {
            this.cuC = (e) asa().kq(27);
        }
        return this.cuC;
    }
}
