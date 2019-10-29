package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
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
    private NewWriteModel cGQ;
    private String cGV;
    private c cGY;
    private b cGZ;
    private i cHC;
    private String cHD;
    private DataModel<?> cHE;
    private boolean cHF;
    private NewWriteModel.d cHG;
    private AntiData cHH;
    private e cHI;
    private View.OnClickListener cHJ;
    private NewWriteModel.d cHf;
    private TbPageContext<?> cfl;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.cHD = "";
        this.cHF = false;
        this.cGV = null;
        this.cHf = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (g.this.cHG != null) {
                    g.this.cHG.callback(z, postWriteCallBackData, yVar, writeData, antiData);
                }
                if (z) {
                    g.this.cHC = null;
                    g.this.cHD = null;
                    g.this.fm(true);
                    g.this.auT();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData clc = g.this.cGQ.clc();
                    g.this.cGQ.d((WriteData) null);
                    g.this.cGQ.qV(false);
                    g.this.mVoiceModel = null;
                    if (clc != null && clc != null && clc.getType() == 2) {
                        g.this.cHE.aut();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aH(i, str)) {
                    g.this.I(i, str);
                } else if (yVar != null && writeData != null && !StringUtils.isNull(yVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.apu());
                    if (com.baidu.tbadk.v.a.qv(yVar.apt())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(g.this.apd().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apt())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(g.this.apd().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(g.this.cfl.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.apd().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.cHJ = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.cGV)) {
                    l.showToast(g.this.apd().getPageActivity(), g.this.cGV);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.cHC == null) {
                this.cHC = new i();
            }
            this.cHC.mContent = writeData.getContent();
            this.cHC.cHO = writeData.getSubPbReplyPrefix();
            c(this.cHC);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cfl = tbPageContext;
    }

    public TbPageContext<?> apd() {
        return this.cfl;
    }

    public void pL(String str) {
        if (this.cHC == null) {
            this.cHC = new i();
        }
        this.cHC.mContent = str;
    }

    public void a(i iVar) {
        this.cHC = iVar;
    }

    public void setReplyId(String str) {
        this.cHD = str;
    }

    public void b(DataModel<?> dataModel) {
        this.cHE = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.auu();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.cGQ = new NewWriteModel(tbPageContext);
            this.cGQ.b(this.cHf);
            v.b(this.cHE.auu(), new v.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (g.this.cHC == null) {
                            g.this.cHC = new i();
                        }
                        g.this.cHC.mContent = writeData.getContent();
                        g.this.cHC.cHO = writeData.getSubPbReplyPrefix();
                        g.this.c(g.this.cHC);
                    }
                }
            });
        }
    }

    public boolean auM() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        B(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (atZ() != null) {
                        atZ().hide();
                    }
                    auT();
                    fm(true);
                    WriteData clc = this.cGQ.clc();
                    this.cGQ.d((WriteData) null);
                    this.cGQ.qV(false);
                    if (clc != null && clc != null && clc.getType() == 2) {
                        this.cHE.aut();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.cHG != null) {
                        this.cHG.callback(false, postWriteCallBackData, null, this.cGQ.clc(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void auR() {
        if (this.cGQ.clc() == null) {
            this.cGQ.d(this.cHE.pG(this.cHE.auu()));
        }
        if (this.cGQ.clc() != null) {
            if (this.cHC != null) {
                this.cGQ.clc().setContent(this.cHC.mContent);
                this.cGQ.clc().setSubPbReplyPrefix(this.cHC.cHO);
            }
            this.cGQ.clc().setReplyId(this.cHD);
            if (this.mPostId != null) {
                this.cGQ.clc().setRepostId(this.cHE.auu());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.cGQ.clc().setVoice(this.mVoiceModel.getId());
                    this.cGQ.clc().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.cGQ.clc().setVoice(null);
                    this.cGQ.clc().setVoiceDuringTime(-1);
                }
            } else {
                this.cGQ.clc().setVoice(null);
                this.cGQ.clc().setVoiceDuringTime(-1);
            }
            if (!this.cGQ.cpH()) {
                apd().showToast((int) R.string.write_img_limit);
            } else if (this.cGZ == null || !this.cGZ.auw()) {
                if (this.cGY != null) {
                    this.cGY.aux();
                }
                if (!this.cGQ.cpE()) {
                }
            }
        }
    }

    public void onDestory() {
        auS();
        this.cGQ.cancelLoadData();
    }

    public void onStop() {
    }

    public void auS() {
        WriteData writeData = new WriteData(2);
        if (this.cHC != null) {
            writeData.setContent(this.cHC.mContent);
            writeData.setSubPbReplyPrefix(this.cHC.cHO);
        }
        writeData.setReplyId(this.cHD);
        writeData.setThreadId(this.mPostId);
        v.e(this.mPostId, writeData);
    }

    public void auT() {
        v.d(this.mPostId, (WriteData) null);
    }

    public void I(int i, String str) {
        if (AntiHelper.aH(i, str)) {
            if (AntiHelper.a(this.cfl.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            pP(str);
        } else {
            apd().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.cHC != null) {
            pbEditorData.setContent(this.cHC.mContent);
            pbEditorData.setSubPbReplyPrefix(this.cHC.cHO);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.cGV);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cfl.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g jI;
        this.cHH = antiData;
        if (antiData != null) {
            this.cGV = antiData.getVoice_message();
            if (!StringUtils.isNull(this.cGV) && atZ() != null && (jI = atZ().jI(6)) != null && !TextUtils.isEmpty(this.cGV)) {
                ((View) jI).setOnClickListener(this.cHJ);
            }
        }
    }

    private void pP(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(apd().getPageActivity());
        aVar.nn(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(apd()).akO();
    }

    private void B(ArrayList<String> arrayList) {
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean auU() {
        return this.cHF;
    }

    public void fn(boolean z) {
        this.cHF = z;
    }

    public void pQ(String str) {
        fn(true);
        atZ().le();
        if (str != null && str.length() != 0) {
            String replace = apd().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            i iVar = new i();
            iVar.cHO = replace;
            c(iVar);
        } else {
            i iVar2 = new i();
            iVar2.mContent = "";
            c(iVar2);
        }
        TiebaStatic.eventStat(apd().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(i iVar) {
        fn(true);
        atZ().le();
        c(iVar);
        TiebaStatic.eventStat(apd().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void auV() {
        fn(false);
        atZ().hide();
    }

    public void auW() {
        fn(true);
        atZ().le();
        atZ().bd((View) atZ().jI(5));
    }

    public void auX() {
        fn(true);
        atZ().le();
        atZ().bd((View) atZ().jI(2));
    }

    public void auY() {
        fn(true);
        atZ().le();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(6, 27, iVar));
        }
    }

    public void pR(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.cHC != null) {
                if (TextUtils.isEmpty(this.cHC.cHO) && TextUtils.isEmpty(this.cHC.mContent)) {
                    pQ(str);
                    return;
                } else if (!TextUtils.isEmpty(this.cHC.cHO) && this.cHC.cHO.equals(replace)) {
                    b(this.cHC);
                    return;
                } else {
                    pQ(str);
                    return;
                }
            }
            pQ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(boolean z) {
        if (atZ() != null) {
            atZ().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.cHG = dVar;
    }

    public void a(c cVar) {
        this.cGY = cVar;
    }

    public void a(b bVar) {
        this.cGZ = bVar;
    }

    public e auZ() {
        if (this.cHI == null && atZ() != null) {
            this.cHI = (e) atZ().jL(27);
        }
        return this.cHI;
    }
}
