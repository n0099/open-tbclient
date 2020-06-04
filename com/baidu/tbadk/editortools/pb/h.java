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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ab;
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
    private bk ahg;
    private TbPageContext<?> dIF;
    private NewWriteModel emH;
    private String emL;
    private c emO;
    private b emP;
    private NewWriteModel.d emV;
    private j enq;
    private String enr;
    private DataModel<?> ens;
    private boolean ent;
    private NewWriteModel.d enu;
    private f enw;
    private w.a enx;
    private View.OnClickListener eny;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.enr = "";
        this.ent = false;
        this.emL = null;
        this.emV = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
                if (h.this.enu != null) {
                    h.this.enu.callback(z, postWriteCallBackData, abVar, writeData, antiData);
                }
                if (z) {
                    h.this.enq = null;
                    h.this.enr = null;
                    h.this.ie(true);
                    h.this.bdU();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData daf = h.this.emH.daf();
                    h.this.emH.d((WriteData) null);
                    h.this.emH.uy(false);
                    h.this.mVoiceModel = null;
                    if (daf != null && daf != null && daf.getType() == 2) {
                        h.this.ens.bdr();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bv(i, str)) {
                    h.this.ap(i, str);
                } else if (abVar != null && writeData != null && !StringUtils.isNull(abVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(abVar.getVcode_md5());
                    writeData.setVcodeUrl(abVar.getVcode_pic_url());
                    writeData.setVcodeExtra(abVar.aYn());
                    if (h.this.ahg != null) {
                        writeData.setBaijiahaoData(h.this.ahg.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.s.a.yX(abVar.aYm())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.aXX().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, abVar.aYm())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.aXX().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.dIF.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.aXX().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.eny = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.emL)) {
                    l.showToast(h.this.aXX().getPageActivity(), h.this.emL);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.enq == null) {
                this.enq = new j();
            }
            this.enq.mContent = writeData.getContent();
            this.enq.enD = writeData.getSubPbReplyPrefix();
            c(this.enq);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.dIF = tbPageContext;
    }

    public TbPageContext<?> aXX() {
        return this.dIF;
    }

    public void setThreadData(bk bkVar) {
        this.ahg = bkVar;
    }

    public void yk(String str) {
        if (this.enq == null) {
            this.enq = new j();
        }
        this.enq.mContent = str;
    }

    public void a(j jVar) {
        this.enq = jVar;
    }

    public void a(w.a aVar) {
        this.enx = aVar;
    }

    public void setReplyId(String str) {
        this.enr = str;
    }

    public void b(DataModel<?> dataModel) {
        this.ens = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bds();
        }
    }

    public void h(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.emH = new NewWriteModel(tbPageContext);
            this.emH.b(this.emV);
            w.b(this.ens.bds(), new w.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.enq == null) {
                            h.this.enq = new j();
                        }
                        h.this.enq.mContent = writeData.getContent();
                        h.this.enq.enD = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.enq);
                    }
                    if (h.this.enx != null) {
                        h.this.enx.a(writeData);
                    }
                }
            });
        }
    }

    public boolean bdL() {
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
                    if (bcX() != null) {
                        bcX().hide();
                    }
                    bdU();
                    ie(true);
                    WriteData daf = this.emH.daf();
                    this.emH.d((WriteData) null);
                    this.emH.uy(false);
                    if (daf != null && daf != null && daf.getType() == 2) {
                        this.ens.bdr();
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
                    if (this.enu != null) {
                        this.enu.callback(false, postWriteCallBackData, null, this.emH.daf(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bdS() {
        if (this.emH.daf() == null) {
            WriteData yf = this.ens.yf(this.ens.bds());
            if (yf != null && this.ahg != null) {
                yf.setBaijiahaoData(this.ahg.getBaijiahaoData());
            }
            this.emH.d(yf);
        }
        if (this.emH.daf() != null) {
            if (this.enq != null) {
                this.emH.daf().setContent(this.enq.mContent);
                this.emH.daf().setSubPbReplyPrefix(this.enq.enD);
                if (this.ahg != null) {
                    this.emH.daf().setBaijiahaoData(this.ahg.getBaijiahaoData());
                }
            }
            this.emH.daf().setReplyId(this.enr);
            if (this.mPostId != null) {
                this.emH.daf().setRepostId(this.ens.bds());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.emH.daf().setVoice(this.mVoiceModel.getId());
                    this.emH.daf().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.emH.daf().setVoice(null);
                    this.emH.daf().setVoiceDuringTime(-1);
                }
            } else {
                this.emH.daf().setVoice(null);
                this.emH.daf().setVoiceDuringTime(-1);
            }
            if (!this.emH.dff()) {
                aXX().showToast((int) R.string.write_img_limit);
            } else if (this.emP == null || !this.emP.bdu()) {
                if (this.emO != null) {
                    this.emO.bdv();
                }
                if (!this.emH.dfc()) {
                }
            }
        }
    }

    public void onDestory() {
        bdT();
        this.emH.cancelLoadData();
    }

    public void onStop() {
    }

    public void bdT() {
        WriteData writeData = new WriteData(2);
        if (this.enq != null) {
            writeData.setContent(this.enq.mContent);
            writeData.setSubPbReplyPrefix(this.enq.enD);
        }
        writeData.setReplyId(this.enr);
        writeData.setThreadId(this.mPostId);
        w.f(this.mPostId, writeData);
    }

    public void bdU() {
        w.e(this.mPostId, (WriteData) null);
    }

    public void ap(int i, String str) {
        if (AntiHelper.bv(i, str)) {
            if (AntiHelper.a(this.dIF.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", at.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            yo(str);
        } else {
            aXX().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.enq != null) {
            pbEditorData.setContent(this.enq.mContent);
            pbEditorData.setSubPbReplyPrefix(this.enq.enD);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.emL);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.dIF.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g ne;
        if (antiData != null) {
            this.emL = antiData.getVoice_message();
            if (!StringUtils.isNull(this.emL) && bcX() != null && (ne = bcX().ne(6)) != null && !TextUtils.isEmpty(this.emL)) {
                ((View) ne).setOnClickListener(this.eny);
            }
        }
    }

    private void yo(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aXX().getPageActivity());
        aVar.vO(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(aXX()).aST();
    }

    private void G(ArrayList<String> arrayList) {
        if (bcX() != null) {
            bcX().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bdV() {
        return this.ent;
    }

    /* renamed from: if  reason: not valid java name */
    public void m31if(boolean z) {
        this.ent = z;
    }

    public void yp(String str) {
        m31if(true);
        bcX().display();
        if (str != null && str.length() != 0) {
            String replace = aXX().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.enD = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(aXX().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        m31if(true);
        bcX().display();
        c(jVar);
        TiebaStatic.eventStat(aXX().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bdW() {
        m31if(false);
        bcX().hide();
    }

    public void bdX() {
        m31if(true);
        bcX().display();
        bcX().bg((View) bcX().ne(5));
    }

    public void bdY() {
        m31if(true);
        bcX().display();
        bcX().bg((View) bcX().ne(2));
    }

    public void bdZ() {
        m31if(true);
        bcX().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (bcX() != null) {
            bcX().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void yq(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.enq != null) {
                if (TextUtils.isEmpty(this.enq.enD) && TextUtils.isEmpty(this.enq.mContent)) {
                    yp(str);
                    return;
                } else if (!TextUtils.isEmpty(this.enq.enD) && this.enq.enD.equals(replace)) {
                    b(this.enq);
                    return;
                } else {
                    yp(str);
                    return;
                }
            }
            yp(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie(boolean z) {
        if (bcX() != null) {
            bcX().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.enu = dVar;
    }

    public void a(c cVar) {
        this.emO = cVar;
    }

    public void a(b bVar) {
        this.emP = bVar;
    }

    public f bea() {
        if (this.enw == null && bcX() != null) {
            this.enw = (f) bcX().nh(27);
        }
        return this.enw;
    }

    public boolean beb() {
        return (this.enq == null || aq.isEmpty(this.enq.mContent)) ? false : true;
    }
}
