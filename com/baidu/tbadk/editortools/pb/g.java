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
    private NewWriteModel cFZ;
    private i cGL;
    private String cGM;
    private DataModel<?> cGN;
    private boolean cGO;
    private NewWriteModel.d cGP;
    private AntiData cGQ;
    private e cGR;
    private View.OnClickListener cGS;
    private String cGe;
    private c cGh;
    private b cGi;
    private NewWriteModel.d cGo;
    private TbPageContext<?> ceu;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.cGM = "";
        this.cGO = false;
        this.cGe = null;
        this.cGo = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (g.this.cGP != null) {
                    g.this.cGP.callback(z, postWriteCallBackData, yVar, writeData, antiData);
                }
                if (z) {
                    g.this.cGL = null;
                    g.this.cGM = null;
                    g.this.fm(true);
                    g.this.auR();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cla = g.this.cFZ.cla();
                    g.this.cFZ.d((WriteData) null);
                    g.this.cFZ.qV(false);
                    g.this.mVoiceModel = null;
                    if (cla != null && cla != null && cla.getType() == 2) {
                        g.this.cGN.aur();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aG(i, str)) {
                    g.this.H(i, str);
                } else if (yVar != null && writeData != null && !StringUtils.isNull(yVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(yVar.getVcode_md5());
                    writeData.setVcodeUrl(yVar.getVcode_pic_url());
                    writeData.setVcodeExtra(yVar.aps());
                    if (com.baidu.tbadk.v.a.qv(yVar.apr())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(g.this.apb().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, yVar.apr())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(g.this.apb().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(g.this.ceu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.apb().showToast(str);
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
        this.cGS = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.cGe)) {
                    l.showToast(g.this.apb().getPageActivity(), g.this.cGe);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.cGL == null) {
                this.cGL = new i();
            }
            this.cGL.mContent = writeData.getContent();
            this.cGL.cGX = writeData.getSubPbReplyPrefix();
            c(this.cGL);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.ceu = tbPageContext;
    }

    public TbPageContext<?> apb() {
        return this.ceu;
    }

    public void pL(String str) {
        if (this.cGL == null) {
            this.cGL = new i();
        }
        this.cGL.mContent = str;
    }

    public void a(i iVar) {
        this.cGL = iVar;
    }

    public void setReplyId(String str) {
        this.cGM = str;
    }

    public void b(DataModel<?> dataModel) {
        this.cGN = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.aus();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.cFZ = new NewWriteModel(tbPageContext);
            this.cFZ.b(this.cGo);
            v.b(this.cGN.aus(), new v.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (g.this.cGL == null) {
                            g.this.cGL = new i();
                        }
                        g.this.cGL.mContent = writeData.getContent();
                        g.this.cGL.cGX = writeData.getSubPbReplyPrefix();
                        g.this.c(g.this.cGL);
                    }
                }
            });
        }
    }

    public boolean auK() {
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
                    if (atX() != null) {
                        atX().hide();
                    }
                    auR();
                    fm(true);
                    WriteData cla = this.cFZ.cla();
                    this.cFZ.d((WriteData) null);
                    this.cFZ.qV(false);
                    if (cla != null && cla != null && cla.getType() == 2) {
                        this.cGN.aur();
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
                    if (this.cGP != null) {
                        this.cGP.callback(false, postWriteCallBackData, null, this.cFZ.cla(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void auP() {
        if (this.cFZ.cla() == null) {
            this.cFZ.d(this.cGN.pG(this.cGN.aus()));
        }
        if (this.cFZ.cla() != null) {
            if (this.cGL != null) {
                this.cFZ.cla().setContent(this.cGL.mContent);
                this.cFZ.cla().setSubPbReplyPrefix(this.cGL.cGX);
            }
            this.cFZ.cla().setReplyId(this.cGM);
            if (this.mPostId != null) {
                this.cFZ.cla().setRepostId(this.cGN.aus());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.cFZ.cla().setVoice(this.mVoiceModel.getId());
                    this.cFZ.cla().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.cFZ.cla().setVoice(null);
                    this.cFZ.cla().setVoiceDuringTime(-1);
                }
            } else {
                this.cFZ.cla().setVoice(null);
                this.cFZ.cla().setVoiceDuringTime(-1);
            }
            if (!this.cFZ.cpF()) {
                apb().showToast((int) R.string.write_img_limit);
            } else if (this.cGi == null || !this.cGi.auu()) {
                if (this.cGh != null) {
                    this.cGh.auv();
                }
                if (!this.cFZ.cpC()) {
                }
            }
        }
    }

    public void onDestory() {
        auQ();
        this.cFZ.cancelLoadData();
    }

    public void onStop() {
    }

    public void auQ() {
        WriteData writeData = new WriteData(2);
        if (this.cGL != null) {
            writeData.setContent(this.cGL.mContent);
            writeData.setSubPbReplyPrefix(this.cGL.cGX);
        }
        writeData.setReplyId(this.cGM);
        writeData.setThreadId(this.mPostId);
        v.e(this.mPostId, writeData);
    }

    public void auR() {
        v.d(this.mPostId, (WriteData) null);
    }

    public void H(int i, String str) {
        if (AntiHelper.aG(i, str)) {
            if (AntiHelper.a(this.ceu.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            pP(str);
        } else {
            apb().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.cGL != null) {
            pbEditorData.setContent(this.cGL.mContent);
            pbEditorData.setSubPbReplyPrefix(this.cGL.cGX);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.cGe);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.ceu.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g jH;
        this.cGQ = antiData;
        if (antiData != null) {
            this.cGe = antiData.getVoice_message();
            if (!StringUtils.isNull(this.cGe) && atX() != null && (jH = atX().jH(6)) != null && !TextUtils.isEmpty(this.cGe)) {
                ((View) jH).setOnClickListener(this.cGS);
            }
        }
    }

    private void pP(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(apb().getPageActivity());
        aVar.nn(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(apb()).akM();
    }

    private void B(ArrayList<String> arrayList) {
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean auS() {
        return this.cGO;
    }

    public void fn(boolean z) {
        this.cGO = z;
    }

    public void pQ(String str) {
        fn(true);
        atX().le();
        if (str != null && str.length() != 0) {
            String replace = apb().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            i iVar = new i();
            iVar.cGX = replace;
            c(iVar);
        } else {
            i iVar2 = new i();
            iVar2.mContent = "";
            c(iVar2);
        }
        TiebaStatic.eventStat(apb().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(i iVar) {
        fn(true);
        atX().le();
        c(iVar);
        TiebaStatic.eventStat(apb().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void auT() {
        fn(false);
        atX().hide();
    }

    public void auU() {
        fn(true);
        atX().le();
        atX().bd((View) atX().jH(5));
    }

    public void auV() {
        fn(true);
        atX().le();
        atX().bd((View) atX().jH(2));
    }

    public void auW() {
        fn(true);
        atX().le();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(6, 27, iVar));
        }
    }

    public void pR(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.cGL != null) {
                if (TextUtils.isEmpty(this.cGL.cGX) && TextUtils.isEmpty(this.cGL.mContent)) {
                    pQ(str);
                    return;
                } else if (!TextUtils.isEmpty(this.cGL.cGX) && this.cGL.cGX.equals(replace)) {
                    b(this.cGL);
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
        if (atX() != null) {
            atX().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.cGP = dVar;
    }

    public void a(c cVar) {
        this.cGh = cVar;
    }

    public void a(b bVar) {
        this.cGi = bVar;
    }

    public e auX() {
        if (this.cGR == null && atX() != null) {
            this.cGR = (e) atX().jK(27);
        }
        return this.cGR;
    }
}
