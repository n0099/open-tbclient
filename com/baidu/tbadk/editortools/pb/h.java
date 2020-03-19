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
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.d {
    private bj NR;
    private TbPageContext<?> cVv;
    private NewWriteModel dyM;
    private String dyQ;
    private c dyT;
    private b dyU;
    private w.a dzA;
    private View.OnClickListener dzB;
    private NewWriteModel.d dza;
    private j dzu;
    private String dzv;
    private DataModel<?> dzw;
    private boolean dzx;
    private NewWriteModel.d dzy;
    private f dzz;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.dzv = "";
        this.dzx = false;
        this.dyQ = null;
        this.dza = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (h.this.dzy != null) {
                    h.this.dzy.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                }
                if (z) {
                    h.this.dzu = null;
                    h.this.dzv = null;
                    h.this.gK(true);
                    h.this.aPv();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cIp = h.this.dyM.cIp();
                    h.this.dyM.d((WriteData) null);
                    h.this.dyM.sY(false);
                    h.this.mVoiceModel = null;
                    if (cIp != null && cIp != null && cIp.getType() == 2) {
                        h.this.dzw.aOS();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bb(i, str)) {
                    h.this.T(i, str);
                } else if (aaVar != null && writeData != null && !StringUtils.isNull(aaVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJL());
                    if (h.this.NR != null) {
                        writeData.setBaijiahaoData(h.this.NR.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.wc(aaVar.aJK())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.aJv().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJK())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.aJv().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.cVv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.aJv().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).X("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).X("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.dzB = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.dyQ)) {
                    l.showToast(h.this.aJv().getPageActivity(), h.this.dyQ);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.dzu == null) {
                this.dzu = new j();
            }
            this.dzu.mContent = writeData.getContent();
            this.dzu.dzG = writeData.getSubPbReplyPrefix();
            c(this.dzu);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cVv = tbPageContext;
    }

    public TbPageContext<?> aJv() {
        return this.cVv;
    }

    public void setThreadData(bj bjVar) {
        this.NR = bjVar;
    }

    public void vn(String str) {
        if (this.dzu == null) {
            this.dzu = new j();
        }
        this.dzu.mContent = str;
    }

    public void a(j jVar) {
        this.dzu = jVar;
    }

    public void a(w.a aVar) {
        this.dzA = aVar;
    }

    public void setReplyId(String str) {
        this.dzv = str;
    }

    public void b(DataModel<?> dataModel) {
        this.dzw = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.aOT();
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.dyM = new NewWriteModel(tbPageContext);
            this.dyM.b(this.dza);
            w.b(this.dzw.aOT(), new w.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.dzu == null) {
                            h.this.dzu = new j();
                        }
                        h.this.dzu.mContent = writeData.getContent();
                        h.this.dzu.dzG = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.dzu);
                    }
                    if (h.this.dzA != null) {
                        h.this.dzA.a(writeData);
                    }
                }
            });
        }
    }

    public boolean aPm() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        G(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (aOy() != null) {
                        aOy().hide();
                    }
                    aPv();
                    gK(true);
                    WriteData cIp = this.dyM.cIp();
                    this.dyM.d((WriteData) null);
                    this.dyM.sY(false);
                    if (cIp != null && cIp != null && cIp.getType() == 2) {
                        this.dzw.aOS();
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
                    if (this.dzy != null) {
                        this.dzy.callback(false, postWriteCallBackData, null, this.dyM.cIp(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void aPt() {
        if (this.dyM.cIp() == null) {
            WriteData vj = this.dzw.vj(this.dzw.aOT());
            if (vj != null && this.NR != null) {
                vj.setBaijiahaoData(this.NR.getBaijiahaoData());
            }
            this.dyM.d(vj);
        }
        if (this.dyM.cIp() != null) {
            if (this.dzu != null) {
                this.dyM.cIp().setContent(this.dzu.mContent);
                this.dyM.cIp().setSubPbReplyPrefix(this.dzu.dzG);
                if (this.NR != null) {
                    this.dyM.cIp().setBaijiahaoData(this.NR.getBaijiahaoData());
                }
            }
            this.dyM.cIp().setReplyId(this.dzv);
            if (this.mPostId != null) {
                this.dyM.cIp().setRepostId(this.dzw.aOT());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dyM.cIp().setVoice(this.mVoiceModel.getId());
                    this.dyM.cIp().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dyM.cIp().setVoice(null);
                    this.dyM.cIp().setVoiceDuringTime(-1);
                }
            } else {
                this.dyM.cIp().setVoice(null);
                this.dyM.cIp().setVoiceDuringTime(-1);
            }
            if (!this.dyM.cMH()) {
                aJv().showToast((int) R.string.write_img_limit);
            } else if (this.dyU == null || !this.dyU.aOV()) {
                if (this.dyT != null) {
                    this.dyT.aOW();
                }
                if (!this.dyM.cME()) {
                }
            }
        }
    }

    public void onDestory() {
        aPu();
        this.dyM.cancelLoadData();
    }

    public void onStop() {
    }

    public void aPu() {
        WriteData writeData = new WriteData(2);
        if (this.dzu != null) {
            writeData.setContent(this.dzu.mContent);
            writeData.setSubPbReplyPrefix(this.dzu.dzG);
        }
        writeData.setReplyId(this.dzv);
        writeData.setThreadId(this.mPostId);
        w.e(this.mPostId, writeData);
    }

    public void aPv() {
        w.d(this.mPostId, (WriteData) null);
    }

    public void T(int i, String str) {
        if (AntiHelper.bb(i, str)) {
            if (AntiHelper.a(this.cVv.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            vr(str);
        } else {
            aJv().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.dzu != null) {
            pbEditorData.setContent(this.dzu.mContent);
            pbEditorData.setSubPbReplyPrefix(this.dzu.dzG);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.dyQ);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cVv.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g mo;
        if (antiData != null) {
            this.dyQ = antiData.getVoice_message();
            if (!StringUtils.isNull(this.dyQ) && aOy() != null && (mo = aOy().mo(6)) != null && !TextUtils.isEmpty(this.dyQ)) {
                ((View) mo).setOnClickListener(this.dzB);
            }
        }
    }

    private void vr(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aJv().getPageActivity());
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aJv()).aEG();
    }

    private void G(ArrayList<String> arrayList) {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean aPw() {
        return this.dzx;
    }

    public void gL(boolean z) {
        this.dzx = z;
    }

    public void vs(String str) {
        gL(true);
        aOy().display();
        if (str != null && str.length() != 0) {
            String replace = aJv().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.dzG = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(aJv().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        gL(true);
        aOy().display();
        c(jVar);
        TiebaStatic.eventStat(aJv().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void aPx() {
        gL(false);
        aOy().hide();
    }

    public void aPy() {
        gL(true);
        aOy().display();
        aOy().be((View) aOy().mo(5));
    }

    public void aPz() {
        gL(true);
        aOy().display();
        aOy().be((View) aOy().mo(2));
    }

    public void aPA() {
        gL(true);
        aOy().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void vt(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.dzu != null) {
                if (TextUtils.isEmpty(this.dzu.dzG) && TextUtils.isEmpty(this.dzu.mContent)) {
                    vs(str);
                    return;
                } else if (!TextUtils.isEmpty(this.dzu.dzG) && this.dzu.dzG.equals(replace)) {
                    b(this.dzu);
                    return;
                } else {
                    vs(str);
                    return;
                }
            }
            vs(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gK(boolean z) {
        if (aOy() != null) {
            aOy().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.dzy = dVar;
    }

    public void a(c cVar) {
        this.dyT = cVar;
    }

    public void a(b bVar) {
        this.dyU = bVar;
    }

    public f aPB() {
        if (this.dzz == null && aOy() != null) {
            this.dzz = (f) aOy().mr(27);
        }
        return this.dzz;
    }

    public boolean aPC() {
        return (this.dzu == null || aq.isEmpty(this.dzu.mContent)) ? false : true;
    }
}
