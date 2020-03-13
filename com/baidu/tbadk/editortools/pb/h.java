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
    private TbPageContext<?> cVi;
    private String dyD;
    private c dyG;
    private b dyH;
    private NewWriteModel.d dyN;
    private NewWriteModel dyz;
    private j dzh;
    private String dzi;
    private DataModel<?> dzj;
    private boolean dzk;
    private NewWriteModel.d dzl;
    private f dzm;
    private v.a dzn;
    private View.OnClickListener dzo;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.dzi = "";
        this.dzk = false;
        this.dyD = null;
        this.dyN = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (h.this.dzl != null) {
                    h.this.dzl.callback(z, postWriteCallBackData, aaVar, writeData, antiData);
                }
                if (z) {
                    h.this.dzh = null;
                    h.this.dzi = null;
                    h.this.gJ(true);
                    h.this.aPr();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cHV = h.this.dyz.cHV();
                    h.this.dyz.d((WriteData) null);
                    h.this.dyz.sS(false);
                    h.this.mVoiceModel = null;
                    if (cHV != null && cHV != null && cHV.getType() == 2) {
                        h.this.dzj.aOO();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bb(i, str)) {
                    h.this.T(i, str);
                } else if (aaVar != null && writeData != null && !StringUtils.isNull(aaVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(aaVar.getVcode_md5());
                    writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                    writeData.setVcodeExtra(aaVar.aJH());
                    if (h.this.NQ != null) {
                        writeData.setBaijiahaoData(h.this.NQ.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.wb(aaVar.aJG())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.aJr().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJG())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.aJr().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.cVi.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.aJr().showToast(str);
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
        this.dzo = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.dyD)) {
                    l.showToast(h.this.aJr().getPageActivity(), h.this.dyD);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.dzh == null) {
                this.dzh = new j();
            }
            this.dzh.mContent = writeData.getContent();
            this.dzh.dzt = writeData.getSubPbReplyPrefix();
            c(this.dzh);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.cVi = tbPageContext;
    }

    public TbPageContext<?> aJr() {
        return this.cVi;
    }

    public void setThreadData(bj bjVar) {
        this.NQ = bjVar;
    }

    public void vn(String str) {
        if (this.dzh == null) {
            this.dzh = new j();
        }
        this.dzh.mContent = str;
    }

    public void a(j jVar) {
        this.dzh = jVar;
    }

    public void a(v.a aVar) {
        this.dzn = aVar;
    }

    public void setReplyId(String str) {
        this.dzi = str;
    }

    public void b(DataModel<?> dataModel) {
        this.dzj = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.aOP();
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.dyz = new NewWriteModel(tbPageContext);
            this.dyz.b(this.dyN);
            v.b(this.dzj.aOP(), new v.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.dzh == null) {
                            h.this.dzh = new j();
                        }
                        h.this.dzh.mContent = writeData.getContent();
                        h.this.dzh.dzt = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.dzh);
                    }
                    if (h.this.dzn != null) {
                        h.this.dzn.a(writeData);
                    }
                }
            });
        }
    }

    public boolean aPi() {
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
                    if (aOu() != null) {
                        aOu().hide();
                    }
                    aPr();
                    gJ(true);
                    WriteData cHV = this.dyz.cHV();
                    this.dyz.d((WriteData) null);
                    this.dyz.sS(false);
                    if (cHV != null && cHV != null && cHV.getType() == 2) {
                        this.dzj.aOO();
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
                    if (this.dzl != null) {
                        this.dzl.callback(false, postWriteCallBackData, null, this.dyz.cHV(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void aPp() {
        if (this.dyz.cHV() == null) {
            WriteData vj = this.dzj.vj(this.dzj.aOP());
            if (vj != null && this.NQ != null) {
                vj.setBaijiahaoData(this.NQ.getBaijiahaoData());
            }
            this.dyz.d(vj);
        }
        if (this.dyz.cHV() != null) {
            if (this.dzh != null) {
                this.dyz.cHV().setContent(this.dzh.mContent);
                this.dyz.cHV().setSubPbReplyPrefix(this.dzh.dzt);
                if (this.NQ != null) {
                    this.dyz.cHV().setBaijiahaoData(this.NQ.getBaijiahaoData());
                }
            }
            this.dyz.cHV().setReplyId(this.dzi);
            if (this.mPostId != null) {
                this.dyz.cHV().setRepostId(this.dzj.aOP());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.dyz.cHV().setVoice(this.mVoiceModel.getId());
                    this.dyz.cHV().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.dyz.cHV().setVoice(null);
                    this.dyz.cHV().setVoiceDuringTime(-1);
                }
            } else {
                this.dyz.cHV().setVoice(null);
                this.dyz.cHV().setVoiceDuringTime(-1);
            }
            if (!this.dyz.cMn()) {
                aJr().showToast((int) R.string.write_img_limit);
            } else if (this.dyH == null || !this.dyH.aOR()) {
                if (this.dyG != null) {
                    this.dyG.aOS();
                }
                if (!this.dyz.cMk()) {
                }
            }
        }
    }

    public void onDestory() {
        aPq();
        this.dyz.cancelLoadData();
    }

    public void onStop() {
    }

    public void aPq() {
        WriteData writeData = new WriteData(2);
        if (this.dzh != null) {
            writeData.setContent(this.dzh.mContent);
            writeData.setSubPbReplyPrefix(this.dzh.dzt);
        }
        writeData.setReplyId(this.dzi);
        writeData.setThreadId(this.mPostId);
        v.e(this.mPostId, writeData);
    }

    public void aPr() {
        v.d(this.mPostId, (WriteData) null);
    }

    public void T(int i, String str) {
        if (AntiHelper.bb(i, str)) {
            if (AntiHelper.a(this.cVi.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).X("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            vr(str);
        } else {
            aJr().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.dzh != null) {
            pbEditorData.setContent(this.dzh.mContent);
            pbEditorData.setSubPbReplyPrefix(this.dzh.dzt);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.dyD);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.cVi.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g mm;
        if (antiData != null) {
            this.dyD = antiData.getVoice_message();
            if (!StringUtils.isNull(this.dyD) && aOu() != null && (mm = aOu().mm(6)) != null && !TextUtils.isEmpty(this.dyD)) {
                ((View) mm).setOnClickListener(this.dzo);
            }
        }
    }

    private void vr(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aJr().getPageActivity());
        aVar.sS(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aJr()).aEC();
    }

    private void G(ArrayList<String> arrayList) {
        if (aOu() != null) {
            aOu().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean aPs() {
        return this.dzk;
    }

    public void gK(boolean z) {
        this.dzk = z;
    }

    public void vs(String str) {
        gK(true);
        aOu().display();
        if (str != null && str.length() != 0) {
            String replace = aJr().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.dzt = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(aJr().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        gK(true);
        aOu().display();
        c(jVar);
        TiebaStatic.eventStat(aJr().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void aPt() {
        gK(false);
        aOu().hide();
    }

    public void aPu() {
        gK(true);
        aOu().display();
        aOu().be((View) aOu().mm(5));
    }

    public void aPv() {
        gK(true);
        aOu().display();
        aOu().be((View) aOu().mm(2));
    }

    public void aPw() {
        gK(true);
        aOu().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (aOu() != null) {
            aOu().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void vt(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.dzh != null) {
                if (TextUtils.isEmpty(this.dzh.dzt) && TextUtils.isEmpty(this.dzh.mContent)) {
                    vs(str);
                    return;
                } else if (!TextUtils.isEmpty(this.dzh.dzt) && this.dzh.dzt.equals(replace)) {
                    b(this.dzh);
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
    public void gJ(boolean z) {
        if (aOu() != null) {
            aOu().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.dzl = dVar;
    }

    public void a(c cVar) {
        this.dyG = cVar;
    }

    public void a(b bVar) {
        this.dyH = bVar;
    }

    public f aPx() {
        if (this.dzm == null && aOu() != null) {
            this.dzm = (f) aOu().mp(27);
        }
        return this.dzm;
    }

    public boolean aPy() {
        return (this.dzh == null || aq.isEmpty(this.dzh.mContent)) ? false : true;
    }
}
