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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
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
    private bu aiq;
    private TbPageContext<?> dPv;
    private String evB;
    private c evE;
    private b evF;
    private NewWriteModel.d evL;
    private NewWriteModel evx;
    private j ewg;
    private String ewh;
    private DataModel<?> ewi;
    private boolean ewj;
    private NewWriteModel.d ewk;
    private f ewl;
    private w.a ewm;
    private View.OnClickListener ewn;
    public boolean isBJH;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.ewh = "";
        this.ewj = false;
        this.evB = null;
        this.evL = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                if (h.this.ewk != null) {
                    h.this.ewk.callback(z, postWriteCallBackData, adVar, writeData, antiData);
                }
                if (z) {
                    h.this.ewg = null;
                    h.this.ewh = null;
                    h.this.in(true);
                    h.this.bfZ();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData dew = h.this.evx.dew();
                    h.this.evx.d((WriteData) null);
                    h.this.evx.uN(false);
                    h.this.mVoiceModel = null;
                    if (dew != null && dew != null && dew.getType() == 2) {
                        h.this.ewi.bfv();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bA(i, str)) {
                    h.this.ar(i, str);
                } else if (adVar != null && writeData != null && !StringUtils.isNull(adVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(adVar.getVcode_md5());
                    writeData.setVcodeUrl(adVar.getVcode_pic_url());
                    writeData.setVcodeExtra(adVar.bas());
                    if (h.this.aiq != null) {
                        writeData.setBaijiahaoData(h.this.aiq.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.zq(adVar.bar())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.bac().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.bar())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.bac().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.dPv.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.bac().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", av.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", av.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.ewn = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.evB)) {
                    l.showToast(h.this.bac().getPageActivity(), h.this.evB);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.ewg == null) {
                this.ewg = new j();
            }
            this.ewg.mContent = writeData.getContent();
            this.ewg.ews = writeData.getSubPbReplyPrefix();
            c(this.ewg);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.dPv = tbPageContext;
    }

    public TbPageContext<?> bac() {
        return this.dPv;
    }

    public void setThreadData(bu buVar) {
        this.aiq = buVar;
    }

    public void yD(String str) {
        if (this.ewg == null) {
            this.ewg = new j();
        }
        this.ewg.mContent = str;
    }

    public void a(j jVar) {
        this.ewg = jVar;
    }

    public void a(w.a aVar) {
        this.ewm = aVar;
    }

    public void setReplyId(String str) {
        this.ewh = str;
    }

    public void b(DataModel<?> dataModel) {
        this.ewi = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bfw();
        }
    }

    public void k(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.evx = new NewWriteModel(tbPageContext);
            this.evx.b(this.evL);
            w.b(this.ewi.bfw(), new w.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.ewg == null) {
                            h.this.ewg = new j();
                        }
                        h.this.ewg.mContent = writeData.getContent();
                        h.this.ewg.ews = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.ewg);
                    }
                    if (h.this.ewm != null) {
                        h.this.ewm.a(writeData);
                    }
                }
            });
        }
    }

    public boolean bfQ() {
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
                    if (bfa() != null) {
                        bfa().hide();
                    }
                    bfZ();
                    in(true);
                    WriteData dew = this.evx.dew();
                    this.evx.d((WriteData) null);
                    this.evx.uN(false);
                    if (dew != null && dew != null && dew.getType() == 2) {
                        this.ewi.bfv();
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
                    if (this.ewk != null) {
                        this.ewk.callback(false, postWriteCallBackData, null, this.evx.dew(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bfX() {
        if (this.evx.dew() == null) {
            WriteData yy = this.ewi.yy(this.ewi.bfw());
            if (yy != null && this.aiq != null) {
                yy.setBaijiahaoData(this.aiq.getBaijiahaoData());
            }
            this.evx.d(yy);
        }
        if (this.evx.dew() != null) {
            this.evx.setSpanGroupManager(this.mSpanGroupManager);
            if (this.ewg != null) {
                this.evx.dew().setContent(this.ewg.mContent);
                this.evx.dew().setSubPbReplyPrefix(this.ewg.ews);
                if (this.aiq != null) {
                    this.evx.dew().setBaijiahaoData(this.aiq.getBaijiahaoData());
                }
            }
            this.evx.dew().setReplyId(this.ewh);
            if (this.mPostId != null) {
                this.evx.dew().setRepostId(this.ewi.bfw());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.evx.dew().setVoice(this.mVoiceModel.getId());
                    this.evx.dew().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.evx.dew().setVoice(null);
                    this.evx.dew().setVoiceDuringTime(-1);
                }
            } else {
                this.evx.dew().setVoice(null);
                this.evx.dew().setVoiceDuringTime(-1);
            }
            if (!this.evx.djr()) {
                bac().showToast((int) R.string.write_img_limit);
            } else if (this.evF == null || !this.evF.bfy()) {
                if (this.evE != null) {
                    this.evE.bfz();
                }
                if (!this.evx.djo()) {
                }
            }
        }
    }

    public void onDestory() {
        bfY();
        this.evx.cancelLoadData();
    }

    public void onStop() {
    }

    public void bfY() {
        WriteData writeData = new WriteData(2);
        if (this.ewg != null) {
            writeData.setContent(this.ewg.mContent);
            writeData.setSubPbReplyPrefix(this.ewg.ews);
        }
        writeData.setReplyId(this.ewh);
        writeData.setThreadId(this.mPostId);
        w.g(this.mPostId, writeData);
    }

    public void bfZ() {
        w.f(this.mPostId, (WriteData) null);
    }

    public void ar(int i, String str) {
        if (AntiHelper.bA(i, str)) {
            if (AntiHelper.a(this.dPv.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", av.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            yH(str);
        } else {
            bac().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.ewg != null) {
            pbEditorData.setContent(this.ewg.mContent);
            pbEditorData.setSubPbReplyPrefix(this.ewg.ews);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.evB);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.dPv.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g ny;
        if (antiData != null) {
            this.evB = antiData.getVoice_message();
            if (!StringUtils.isNull(this.evB) && bfa() != null && (ny = bfa().ny(6)) != null && !TextUtils.isEmpty(this.evB)) {
                ((View) ny).setOnClickListener(this.ewn);
            }
        }
    }

    private void yH(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bac().getPageActivity());
        aVar.we(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bac()).aUN();
    }

    private void G(ArrayList<String> arrayList) {
        if (bfa() != null) {
            bfa().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bga() {
        return this.ewj;
    }

    public void io(boolean z) {
        this.ewj = z;
    }

    public void yI(String str) {
        io(true);
        bfa().display();
        if (str != null && str.length() != 0) {
            String replace = bac().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.ews = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(bac().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        io(true);
        bfa().display();
        c(jVar);
        TiebaStatic.eventStat(bac().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bgb() {
        io(false);
        bfa().hide();
    }

    public void bgc() {
        io(true);
        bfa().display();
        bfa().bh((View) bfa().ny(5));
    }

    public void bgd() {
        io(true);
        bfa().display();
        bfa().bh((View) bfa().ny(2));
    }

    public void bge() {
        io(true);
        bfa().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (bfa() != null) {
            bfa().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void yJ(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.ewg != null) {
                if (TextUtils.isEmpty(this.ewg.ews) && TextUtils.isEmpty(this.ewg.mContent)) {
                    yI(str);
                    return;
                } else if (!TextUtils.isEmpty(this.ewg.ews) && this.ewg.ews.equals(replace)) {
                    b(this.ewg);
                    return;
                } else {
                    yI(str);
                    return;
                }
            }
            yI(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(boolean z) {
        if (bfa() != null) {
            bfa().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.ewk = dVar;
    }

    public void a(c cVar) {
        this.evE = cVar;
    }

    public void a(b bVar) {
        this.evF = bVar;
    }

    public f bgf() {
        if (this.ewl == null && bfa() != null) {
            this.ewl = (f) bfa().nB(27);
        }
        return this.ewl;
    }

    public boolean bgg() {
        return (this.ewg == null || ar.isEmpty(this.ewg.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }
}
