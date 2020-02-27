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
    private TbPageContext<?> cVg;
    private j dyT;
    private String dyU;
    private DataModel<?> dyV;
    private boolean dyW;
    private NewWriteModel.d dyX;
    private f dyY;
    private v.a dyZ;
    private NewWriteModel dyl;
    private String dyp;
    private c dys;
    private b dyt;
    private NewWriteModel.d dyz;
    private View.OnClickListener dza;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.dyU = "";
        this.dyW = false;
        this.dyp = null;
        this.dyz = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (h.this.dyX != null) {
                    h.this.dyX.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                }
                if (z) {
                    h.this.dyT = null;
                    h.this.dyU = null;
                    h.this.gJ(true);
                    h.this.aPo();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cHS = h.this.dyl.cHS();
                    h.this.dyl.d((WriteData) null);
                    h.this.dyl.sS(false);
                    h.this.mVoiceModel = null;
                    if (cHS != null && cHS != null && cHS.getType() == 2) {
                        h.this.dyV.aOL();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bb(i, str)) {
                    h.this.T(i, str);
                } else if (aaVar != null && writeData != null && !StringUtils.isNull(aaVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJE());
                    if (h.this.NQ != null) {
                        writeData.setBaijiahaoData(h.this.NQ.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.wa(aaVar.aJD())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.aJo().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJD())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.aJo().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.cVg.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.aJo().showToast(str);
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
        this.dza = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.dyp)) {
                    l.showToast(h.this.aJo().getPageActivity(), h.this.dyp);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.dyT == null) {
                this.dyT = new j();
            }
            this.dyT.mContent = writeData.getContent();
            this.dyT.dzf = writeData.getSubPbReplyPrefix();
            c(this.dyT);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cVg = tbPageContext;
    }

    public TbPageContext<?> aJo() {
        return this.cVg;
    }

    public void setThreadData(bj bjVar) {
        this.NQ = bjVar;
    }

    public void vm(String str) {
        if (this.dyT == null) {
            this.dyT = new j();
        }
        this.dyT.mContent = str;
    }

    public void a(j jVar) {
        this.dyT = jVar;
    }

    public void a(v.a aVar) {
        this.dyZ = aVar;
    }

    public void setReplyId(String str) {
        this.dyU = str;
    }

    public void b(DataModel<?> dataModel) {
        this.dyV = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.aOM();
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.dyl = new NewWriteModel(tbPageContext);
            this.dyl.b(this.dyz);
            v.b(this.dyV.aOM(), new v.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.dyT == null) {
                            h.this.dyT = new j();
                        }
                        h.this.dyT.mContent = writeData.getContent();
                        h.this.dyT.dzf = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.dyT);
                    }
                    if (h.this.dyZ != null) {
                        h.this.dyZ.a(writeData);
                    }
                }
            });
        }
    }

    public boolean aPf() {
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
                    if (aOr() != null) {
                        aOr().hide();
                    }
                    aPo();
                    gJ(true);
                    WriteData cHS = this.dyl.cHS();
                    this.dyl.d((WriteData) null);
                    this.dyl.sS(false);
                    if (cHS != null && cHS != null && cHS.getType() == 2) {
                        this.dyV.aOL();
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
                    if (this.dyX != null) {
                        this.dyX.callback(false, postWriteCallBackData, null, this.dyl.cHS(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void aPm() {
        if (this.dyl.cHS() == null) {
            WriteData vi = this.dyV.vi(this.dyV.aOM());
            if (vi != null && this.NQ != null) {
                vi.setBaijiahaoData(this.NQ.getBaijiahaoData());
            }
            this.dyl.d(vi);
        }
        if (this.dyl.cHS() != null) {
            if (this.dyT != null) {
                this.dyl.cHS().setContent(this.dyT.mContent);
                this.dyl.cHS().setSubPbReplyPrefix(this.dyT.dzf);
                if (this.NQ != null) {
                    this.dyl.cHS().setBaijiahaoData(this.NQ.getBaijiahaoData());
                }
            }
            this.dyl.cHS().setReplyId(this.dyU);
            if (this.mPostId != null) {
                this.dyl.cHS().setRepostId(this.dyV.aOM());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dyl.cHS().setVoice(this.mVoiceModel.getId());
                    this.dyl.cHS().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dyl.cHS().setVoice(null);
                    this.dyl.cHS().setVoiceDuringTime(-1);
                }
            } else {
                this.dyl.cHS().setVoice(null);
                this.dyl.cHS().setVoiceDuringTime(-1);
            }
            if (!this.dyl.cMk()) {
                aJo().showToast((int) R.string.write_img_limit);
            } else if (this.dyt == null || !this.dyt.aOO()) {
                if (this.dys != null) {
                    this.dys.aOP();
                }
                if (!this.dyl.cMh()) {
                }
            }
        }
    }

    public void onDestory() {
        aPn();
        this.dyl.cancelLoadData();
    }

    public void onStop() {
    }

    public void aPn() {
        WriteData writeData = new WriteData(2);
        if (this.dyT != null) {
            writeData.setContent(this.dyT.mContent);
            writeData.setSubPbReplyPrefix(this.dyT.dzf);
        }
        writeData.setReplyId(this.dyU);
        writeData.setThreadId(this.mPostId);
        v.e(this.mPostId, writeData);
    }

    public void aPo() {
        v.d(this.mPostId, (WriteData) null);
    }

    public void T(int i, String str) {
        if (AntiHelper.bb(i, str)) {
            if (AntiHelper.a(this.cVg.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            vq(str);
        } else {
            aJo().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.dyT != null) {
            pbEditorData.setContent(this.dyT.mContent);
            pbEditorData.setSubPbReplyPrefix(this.dyT.dzf);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.dyp);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cVg.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g mm;
        if (antiData != null) {
            this.dyp = antiData.getVoice_message();
            if (!StringUtils.isNull(this.dyp) && aOr() != null && (mm = aOr().mm(6)) != null && !TextUtils.isEmpty(this.dyp)) {
                ((View) mm).setOnClickListener(this.dza);
            }
        }
    }

    private void vq(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aJo().getPageActivity());
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aJo()).aEA();
    }

    private void G(ArrayList<String> arrayList) {
        if (aOr() != null) {
            aOr().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean aPp() {
        return this.dyW;
    }

    public void gK(boolean z) {
        this.dyW = z;
    }

    public void vr(String str) {
        gK(true);
        aOr().display();
        if (str != null && str.length() != 0) {
            String replace = aJo().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.dzf = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(aJo().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        gK(true);
        aOr().display();
        c(jVar);
        TiebaStatic.eventStat(aJo().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void aPq() {
        gK(false);
        aOr().hide();
    }

    public void aPr() {
        gK(true);
        aOr().display();
        aOr().be((View) aOr().mm(5));
    }

    public void aPs() {
        gK(true);
        aOr().display();
        aOr().be((View) aOr().mm(2));
    }

    public void aPt() {
        gK(true);
        aOr().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (aOr() != null) {
            aOr().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void vs(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.dyT != null) {
                if (TextUtils.isEmpty(this.dyT.dzf) && TextUtils.isEmpty(this.dyT.mContent)) {
                    vr(str);
                    return;
                } else if (!TextUtils.isEmpty(this.dyT.dzf) && this.dyT.dzf.equals(replace)) {
                    b(this.dyT);
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
        if (aOr() != null) {
            aOr().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.dyX = dVar;
    }

    public void a(c cVar) {
        this.dys = cVar;
    }

    public void a(b bVar) {
        this.dyt = bVar;
    }

    public f aPu() {
        if (this.dyY == null && aOr() != null) {
            this.dyY = (f) aOr().mp(27);
        }
        return this.dyY;
    }

    public boolean aPv() {
        return (this.dyT == null || aq.isEmpty(this.dyT.mContent)) ? false : true;
    }
}
