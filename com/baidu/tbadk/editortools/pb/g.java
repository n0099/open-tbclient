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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
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
    private NewWriteModel cuH;
    private String cuL;
    private c cuO;
    private b cuP;
    private NewWriteModel.d cuV;
    private i cvs;
    private String cvt;
    private DataModel<?> cvu;
    private boolean cvv;
    private NewWriteModel.d cvw;
    private AntiData cvx;
    private e cvy;
    private View.OnClickListener cvz;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.cvt = "";
        this.cvv = false;
        this.cuL = null;
        this.cuV = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (g.this.cvw != null) {
                    g.this.cvw.callback(z, postWriteCallBackData, yVar, writeData, antiData);
                }
                if (z) {
                    g.this.cvs = null;
                    g.this.cvt = null;
                    g.this.fs(true);
                    g.this.ath();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.cuH.getWriteData();
                    g.this.cuH.setWriteData(null);
                    g.this.cuH.rm(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.cvu.asH();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aG(i, str)) {
                    g.this.F(i, str);
                } else if (yVar != null && writeData != null && !StringUtils.isNull(yVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.amT());
                    if (com.baidu.tbadk.v.a.rF(yVar.amS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.amy().getPageActivity(), 12006, writeData, false, yVar.amS())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.amy().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.amy().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").P("obj_locate", at.a.bUM));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").P("obj_locate", at.a.bUM));
            }
        };
        this.cvz = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.cuL)) {
                    l.showToast(g.this.amy().getPageActivity(), g.this.cuL);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.cvs == null) {
                this.cvs = new i();
            }
            this.cvs.mContent = writeData.getContent();
            this.cvs.cvE = writeData.getSubPbReplyPrefix();
            c(this.cvs);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> amy() {
        return this.mContext;
    }

    public void qC(String str) {
        if (this.cvs == null) {
            this.cvs = new i();
        }
        this.cvs.mContent = str;
    }

    public void a(i iVar) {
        this.cvs = iVar;
    }

    public void setReplyId(String str) {
        this.cvt = str;
    }

    public void b(DataModel<?> dataModel) {
        this.cvu = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.asI();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.cuH = new NewWriteModel(tbPageContext);
            this.cuH.b(this.cuV);
            v.b(this.cvu.asI(), new v.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (g.this.cvs == null) {
                            g.this.cvs = new i();
                        }
                        g.this.cvs.mContent = writeData.getContent();
                        g.this.cvs.cvE = writeData.getSubPbReplyPrefix();
                        g.this.c(g.this.cvs);
                    }
                }
            });
        }
    }

    public boolean ata() {
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
                    if (asm() != null) {
                        asm().hide();
                    }
                    ath();
                    fs(true);
                    WriteData writeData = this.cuH.getWriteData();
                    this.cuH.setWriteData(null);
                    this.cuH.rm(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.cvu.asH();
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
                    if (this.cvw != null) {
                        this.cvw.callback(false, postWriteCallBackData, null, this.cuH.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void atf() {
        if (this.cuH.getWriteData() == null) {
            this.cuH.setWriteData(this.cvu.qx(this.cvu.asI()));
        }
        if (this.cuH.getWriteData() != null) {
            if (this.cvs != null) {
                this.cuH.getWriteData().setContent(this.cvs.mContent);
                this.cuH.getWriteData().setSubPbReplyPrefix(this.cvs.cvE);
            }
            this.cuH.getWriteData().setReplyId(this.cvt);
            if (this.mPostId != null) {
                this.cuH.getWriteData().setRepostId(this.cvu.asI());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.cuH.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.cuH.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.cuH.getWriteData().setVoice(null);
                    this.cuH.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.cuH.getWriteData().setVoice(null);
                this.cuH.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.cuH.crL()) {
                amy().showToast((int) R.string.write_img_limit);
            } else if (this.cuP == null || !this.cuP.asK()) {
                if (this.cuO != null) {
                    this.cuO.asL();
                }
                if (!this.cuH.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        atg();
        this.cuH.cancelLoadData();
    }

    public void onStop() {
    }

    public void atg() {
        WriteData writeData = new WriteData(2);
        if (this.cvs != null) {
            writeData.setContent(this.cvs.mContent);
            writeData.setSubPbReplyPrefix(this.cvs.cvE);
        }
        writeData.setReplyId(this.cvt);
        writeData.setThreadId(this.mPostId);
        v.e(this.mPostId, writeData);
    }

    public void ath() {
        v.d(this.mPostId, (WriteData) null);
    }

    public void F(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an("c12534").P("obj_locate", at.a.bUM));
            }
        } else if (i == 230277 || i == 230278) {
            qG(str);
        } else {
            amy().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.cvs != null) {
            pbEditorData.setContent(this.cvs.mContent);
            pbEditorData.setSubPbReplyPrefix(this.cvs.cvE);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.cuL);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g kq;
        this.cvx = antiData;
        if (antiData != null) {
            this.cuL = antiData.getVoice_message();
            if (!StringUtils.isNull(this.cuL) && asm() != null && (kq = asm().kq(6)) != null && !TextUtils.isEmpty(this.cuL)) {
                ((View) kq).setOnClickListener(this.cvz);
            }
        }
    }

    private void qG(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(amy().getPageActivity());
        aVar.mQ(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(amy()).agO();
    }

    private void z(ArrayList<String> arrayList) {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean ati() {
        return this.cvv;
    }

    public void ft(boolean z) {
        this.cvv = z;
    }

    public void qH(String str) {
        ft(true);
        asm().ql();
        if (str != null && str.length() != 0) {
            String replace = amy().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            i iVar = new i();
            iVar.cvE = replace;
            c(iVar);
        } else {
            i iVar2 = new i();
            iVar2.mContent = "";
            c(iVar2);
        }
        TiebaStatic.eventStat(amy().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(i iVar) {
        ft(true);
        asm().ql();
        c(iVar);
        TiebaStatic.eventStat(amy().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void atj() {
        ft(false);
        asm().hide();
    }

    public void atk() {
        ft(true);
        asm().ql();
        asm().bd((View) asm().kq(5));
    }

    public void atl() {
        ft(true);
        asm().ql();
        asm().bd((View) asm().kq(2));
    }

    public void atm() {
        ft(true);
        asm().ql();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(6, 27, iVar));
        }
    }

    public void qI(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.cvs != null) {
                if (TextUtils.isEmpty(this.cvs.cvE) && TextUtils.isEmpty(this.cvs.mContent)) {
                    qH(str);
                    return;
                } else if (!TextUtils.isEmpty(this.cvs.cvE) && this.cvs.cvE.equals(replace)) {
                    b(this.cvs);
                    return;
                } else {
                    qH(str);
                    return;
                }
            }
            qH(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(boolean z) {
        if (asm() != null) {
            asm().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.cvw = dVar;
    }

    public void a(c cVar) {
        this.cuO = cVar;
    }

    public void a(b bVar) {
        this.cuP = bVar;
    }

    public e atn() {
        if (this.cvy == null && asm() != null) {
            this.cvy = (e) asm().kt(27);
        }
        return this.cvy;
    }
}
