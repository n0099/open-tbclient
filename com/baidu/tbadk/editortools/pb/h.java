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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.z;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.d {
    private bj Np;
    private TbPageContext<?> cRe;
    private j duN;
    private String duO;
    private DataModel<?> duP;
    private boolean duQ;
    private NewWriteModel.d duR;
    private f duS;
    private v.a duT;
    private View.OnClickListener duU;
    private NewWriteModel duf;
    private String duj;
    private c dum;
    private b dun;
    private NewWriteModel.d dut;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.duO = "";
        this.duQ = false;
        this.duj = null;
        this.dut = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, z zVar, WriteData writeData, AntiData antiData) {
                if (h.this.duR != null) {
                    h.this.duR.callback(z, postWriteCallBackData, zVar, writeData, antiData);
                }
                if (z) {
                    h.this.duN = null;
                    h.this.duO = null;
                    h.this.gC(true);
                    h.this.aMS();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cGm = h.this.duf.cGm();
                    h.this.duf.d((WriteData) null);
                    h.this.duf.sO(false);
                    h.this.mVoiceModel = null;
                    if (cGm != null && cGm != null && cGm.getType() == 2) {
                        h.this.duP.aMp();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bc(i, str)) {
                    h.this.R(i, str);
                } else if (zVar != null && writeData != null && !StringUtils.isNull(zVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(zVar.getVcode_md5());
                    writeData.setVcodeUrl(zVar.getVcode_pic_url());
                    writeData.setVcodeExtra(zVar.aHl());
                    if (h.this.Np != null) {
                        writeData.setBaijiahaoData(h.this.Np.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.vG(zVar.aHk())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.aGW().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, zVar.aHk())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.aGW().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.cRe.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.aGW().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).Z("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).Z("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.duU = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.duj)) {
                    l.showToast(h.this.aGW().getPageActivity(), h.this.duj);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.duN == null) {
                this.duN = new j();
            }
            this.duN.mContent = writeData.getContent();
            this.duN.duZ = writeData.getSubPbReplyPrefix();
            c(this.duN);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cRe = tbPageContext;
    }

    public TbPageContext<?> aGW() {
        return this.cRe;
    }

    public void setThreadData(bj bjVar) {
        this.Np = bjVar;
    }

    public void uV(String str) {
        if (this.duN == null) {
            this.duN = new j();
        }
        this.duN.mContent = str;
    }

    public void a(j jVar) {
        this.duN = jVar;
    }

    public void a(v.a aVar) {
        this.duT = aVar;
    }

    public void setReplyId(String str) {
        this.duO = str;
    }

    public void b(DataModel<?> dataModel) {
        this.duP = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.aMq();
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.duf = new NewWriteModel(tbPageContext);
            this.duf.b(this.dut);
            v.b(this.duP.aMq(), new v.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.duN == null) {
                            h.this.duN = new j();
                        }
                        h.this.duN.mContent = writeData.getContent();
                        h.this.duN.duZ = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.duN);
                    }
                    if (h.this.duT != null) {
                        h.this.duT.a(writeData);
                    }
                }
            });
        }
    }

    public boolean aMJ() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        E(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (aLV() != null) {
                        aLV().hide();
                    }
                    aMS();
                    gC(true);
                    WriteData cGm = this.duf.cGm();
                    this.duf.d((WriteData) null);
                    this.duf.sO(false);
                    if (cGm != null && cGm != null && cGm.getType() == 2) {
                        this.duP.aMp();
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
                    if (this.duR != null) {
                        this.duR.callback(false, postWriteCallBackData, null, this.duf.cGm(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void aMQ() {
        if (this.duf.cGm() == null) {
            WriteData uR = this.duP.uR(this.duP.aMq());
            if (uR != null && this.Np != null) {
                uR.setBaijiahaoData(this.Np.getBaijiahaoData());
            }
            this.duf.d(uR);
        }
        if (this.duf.cGm() != null) {
            if (this.duN != null) {
                this.duf.cGm().setContent(this.duN.mContent);
                this.duf.cGm().setSubPbReplyPrefix(this.duN.duZ);
                if (this.Np != null) {
                    this.duf.cGm().setBaijiahaoData(this.Np.getBaijiahaoData());
                }
            }
            this.duf.cGm().setReplyId(this.duO);
            if (this.mPostId != null) {
                this.duf.cGm().setRepostId(this.duP.aMq());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.duf.cGm().setVoice(this.mVoiceModel.getId());
                    this.duf.cGm().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.duf.cGm().setVoice(null);
                    this.duf.cGm().setVoiceDuringTime(-1);
                }
            } else {
                this.duf.cGm().setVoice(null);
                this.duf.cGm().setVoiceDuringTime(-1);
            }
            if (!this.duf.cKN()) {
                aGW().showToast((int) R.string.write_img_limit);
            } else if (this.dun == null || !this.dun.aMs()) {
                if (this.dum != null) {
                    this.dum.aMt();
                }
                if (!this.duf.cKK()) {
                }
            }
        }
    }

    public void onDestory() {
        aMR();
        this.duf.cancelLoadData();
    }

    public void onStop() {
    }

    public void aMR() {
        WriteData writeData = new WriteData(2);
        if (this.duN != null) {
            writeData.setContent(this.duN.mContent);
            writeData.setSubPbReplyPrefix(this.duN.duZ);
        }
        writeData.setReplyId(this.duO);
        writeData.setThreadId(this.mPostId);
        v.e(this.mPostId, writeData);
    }

    public void aMS() {
        v.d(this.mPostId, (WriteData) null);
    }

    public void R(int i, String str) {
        if (AntiHelper.bc(i, str)) {
            if (AntiHelper.a(this.cRe.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).Z("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            uZ(str);
        } else {
            aGW().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.duN != null) {
            pbEditorData.setContent(this.duN.mContent);
            pbEditorData.setSubPbReplyPrefix(this.duN.duZ);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.duj);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cRe.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g lU;
        if (antiData != null) {
            this.duj = antiData.getVoice_message();
            if (!StringUtils.isNull(this.duj) && aLV() != null && (lU = aLV().lU(6)) != null && !TextUtils.isEmpty(this.duj)) {
                ((View) lU).setOnClickListener(this.duU);
            }
        }
    }

    private void uZ(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aGW().getPageActivity());
        aVar.sC(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aGW()).aCp();
    }

    private void E(ArrayList<String> arrayList) {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean aMT() {
        return this.duQ;
    }

    public void gD(boolean z) {
        this.duQ = z;
    }

    public void va(String str) {
        gD(true);
        aLV().display();
        if (str != null && str.length() != 0) {
            String replace = aGW().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.duZ = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(aGW().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        gD(true);
        aLV().display();
        c(jVar);
        TiebaStatic.eventStat(aGW().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void aMU() {
        gD(false);
        aLV().hide();
    }

    public void aMV() {
        gD(true);
        aLV().display();
        aLV().be((View) aLV().lU(5));
    }

    public void aMW() {
        gD(true);
        aLV().display();
        aLV().be((View) aLV().lU(2));
    }

    public void aMX() {
        gD(true);
        aLV().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void vb(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.duN != null) {
                if (TextUtils.isEmpty(this.duN.duZ) && TextUtils.isEmpty(this.duN.mContent)) {
                    va(str);
                    return;
                } else if (!TextUtils.isEmpty(this.duN.duZ) && this.duN.duZ.equals(replace)) {
                    b(this.duN);
                    return;
                } else {
                    va(str);
                    return;
                }
            }
            va(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(boolean z) {
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.duR = dVar;
    }

    public void a(c cVar) {
        this.dum = cVar;
    }

    public void a(b bVar) {
        this.dun = bVar;
    }

    public f aMY() {
        if (this.duS == null && aLV() != null) {
            this.duS = (f) aLV().lX(27);
        }
        return this.duS;
    }

    public boolean aMZ() {
        return (this.duN == null || aq.isEmpty(this.duN.mContent)) ? false : true;
    }
}
