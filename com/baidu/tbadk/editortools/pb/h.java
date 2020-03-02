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
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.d {
    private bj NQ;
    private TbPageContext<?> cVh;
    private NewWriteModel.d dyA;
    private j dyU;
    private String dyV;
    private DataModel<?> dyW;
    private boolean dyX;
    private NewWriteModel.d dyY;
    private f dyZ;
    private NewWriteModel dym;
    private String dyq;
    private c dyt;
    private b dyu;
    private v.a dza;
    private View.OnClickListener dzb;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.dyV = "";
        this.dyX = false;
        this.dyq = null;
        this.dyA = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (h.this.dyY != null) {
                    h.this.dyY.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                }
                if (z) {
                    h.this.dyU = null;
                    h.this.dyV = null;
                    h.this.gJ(true);
                    h.this.aPq();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cHU = h.this.dym.cHU();
                    h.this.dym.d((WriteData) null);
                    h.this.dym.sS(false);
                    h.this.mVoiceModel = null;
                    if (cHU != null && cHU != null && cHU.getType() == 2) {
                        h.this.dyW.aON();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bb(i, str)) {
                    h.this.T(i, str);
                } else if (aaVar != null && writeData != null && !StringUtils.isNull(aaVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJG());
                    if (h.this.NQ != null) {
                        writeData.setBaijiahaoData(h.this.NQ.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.wa(aaVar.aJF())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.aJq().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJF())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.aJq().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.cVh.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.aJq().showToast(str);
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
        this.dzb = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.dyq)) {
                    l.showToast(h.this.aJq().getPageActivity(), h.this.dyq);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.dyU == null) {
                this.dyU = new j();
            }
            this.dyU.mContent = writeData.getContent();
            this.dyU.dzg = writeData.getSubPbReplyPrefix();
            c(this.dyU);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cVh = tbPageContext;
    }

    public TbPageContext<?> aJq() {
        return this.cVh;
    }

    public void setThreadData(bj bjVar) {
        this.NQ = bjVar;
    }

    public void vm(String str) {
        if (this.dyU == null) {
            this.dyU = new j();
        }
        this.dyU.mContent = str;
    }

    public void a(j jVar) {
        this.dyU = jVar;
    }

    public void a(v.a aVar) {
        this.dza = aVar;
    }

    public void setReplyId(String str) {
        this.dyV = str;
    }

    public void b(DataModel<?> dataModel) {
        this.dyW = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.aOO();
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.dym = new NewWriteModel(tbPageContext);
            this.dym.b(this.dyA);
            v.b(this.dyW.aOO(), new v.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.dyU == null) {
                            h.this.dyU = new j();
                        }
                        h.this.dyU.mContent = writeData.getContent();
                        h.this.dyU.dzg = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.dyU);
                    }
                    if (h.this.dza != null) {
                        h.this.dza.a(writeData);
                    }
                }
            });
        }
    }

    public boolean aPh() {
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
                    if (aOt() != null) {
                        aOt().hide();
                    }
                    aPq();
                    gJ(true);
                    WriteData cHU = this.dym.cHU();
                    this.dym.d((WriteData) null);
                    this.dym.sS(false);
                    if (cHU != null && cHU != null && cHU.getType() == 2) {
                        this.dyW.aON();
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
                    if (this.dyY != null) {
                        this.dyY.callback(false, postWriteCallBackData, null, this.dym.cHU(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void aPo() {
        if (this.dym.cHU() == null) {
            WriteData vi = this.dyW.vi(this.dyW.aOO());
            if (vi != null && this.NQ != null) {
                vi.setBaijiahaoData(this.NQ.getBaijiahaoData());
            }
            this.dym.d(vi);
        }
        if (this.dym.cHU() != null) {
            if (this.dyU != null) {
                this.dym.cHU().setContent(this.dyU.mContent);
                this.dym.cHU().setSubPbReplyPrefix(this.dyU.dzg);
                if (this.NQ != null) {
                    this.dym.cHU().setBaijiahaoData(this.NQ.getBaijiahaoData());
                }
            }
            this.dym.cHU().setReplyId(this.dyV);
            if (this.mPostId != null) {
                this.dym.cHU().setRepostId(this.dyW.aOO());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dym.cHU().setVoice(this.mVoiceModel.getId());
                    this.dym.cHU().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dym.cHU().setVoice(null);
                    this.dym.cHU().setVoiceDuringTime(-1);
                }
            } else {
                this.dym.cHU().setVoice(null);
                this.dym.cHU().setVoiceDuringTime(-1);
            }
            if (!this.dym.cMm()) {
                aJq().showToast((int) R.string.write_img_limit);
            } else if (this.dyu == null || !this.dyu.aOQ()) {
                if (this.dyt != null) {
                    this.dyt.aOR();
                }
                if (!this.dym.cMj()) {
                }
            }
        }
    }

    public void onDestory() {
        aPp();
        this.dym.cancelLoadData();
    }

    public void onStop() {
    }

    public void aPp() {
        WriteData writeData = new WriteData(2);
        if (this.dyU != null) {
            writeData.setContent(this.dyU.mContent);
            writeData.setSubPbReplyPrefix(this.dyU.dzg);
        }
        writeData.setReplyId(this.dyV);
        writeData.setThreadId(this.mPostId);
        v.e(this.mPostId, writeData);
    }

    public void aPq() {
        v.d(this.mPostId, (WriteData) null);
    }

    public void T(int i, String str) {
        if (AntiHelper.bb(i, str)) {
            if (AntiHelper.a(this.cVh.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            vq(str);
        } else {
            aJq().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.dyU != null) {
            pbEditorData.setContent(this.dyU.mContent);
            pbEditorData.setSubPbReplyPrefix(this.dyU.dzg);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.dyq);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cVh.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g mm;
        if (antiData != null) {
            this.dyq = antiData.getVoice_message();
            if (!StringUtils.isNull(this.dyq) && aOt() != null && (mm = aOt().mm(6)) != null && !TextUtils.isEmpty(this.dyq)) {
                ((View) mm).setOnClickListener(this.dzb);
            }
        }
    }

    private void vq(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aJq().getPageActivity());
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aJq()).aEC();
    }

    private void G(ArrayList<String> arrayList) {
        if (aOt() != null) {
            aOt().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean aPr() {
        return this.dyX;
    }

    public void gK(boolean z) {
        this.dyX = z;
    }

    public void vr(String str) {
        gK(true);
        aOt().display();
        if (str != null && str.length() != 0) {
            String replace = aJq().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.dzg = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(aJq().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        gK(true);
        aOt().display();
        c(jVar);
        TiebaStatic.eventStat(aJq().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void aPs() {
        gK(false);
        aOt().hide();
    }

    public void aPt() {
        gK(true);
        aOt().display();
        aOt().be((View) aOt().mm(5));
    }

    public void aPu() {
        gK(true);
        aOt().display();
        aOt().be((View) aOt().mm(2));
    }

    public void aPv() {
        gK(true);
        aOt().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (aOt() != null) {
            aOt().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void vs(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.dyU != null) {
                if (TextUtils.isEmpty(this.dyU.dzg) && TextUtils.isEmpty(this.dyU.mContent)) {
                    vr(str);
                    return;
                } else if (!TextUtils.isEmpty(this.dyU.dzg) && this.dyU.dzg.equals(replace)) {
                    b(this.dyU);
                    return;
                } else {
                    vr(str);
                    return;
                }
            }
            vr(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(boolean z) {
        if (aOt() != null) {
            aOt().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.dyY = dVar;
    }

    public void a(c cVar) {
        this.dyt = cVar;
    }

    public void a(b bVar) {
        this.dyu = bVar;
    }

    public f aPw() {
        if (this.dyZ == null && aOt() != null) {
            this.dyZ = (f) aOt().mp(27);
        }
        return this.dyZ;
    }

    public boolean aPx() {
        return (this.dyU == null || aq.isEmpty(this.dyU.mContent)) ? false : true;
    }
}
