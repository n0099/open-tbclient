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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.e {
    private bw akp;
    private TbPageContext<?> etO;
    private NewWriteModel.d fbF;
    private NewWriteModel fbr;
    private String fbv;
    private c fby;
    private b fbz;
    private j fca;
    private String fcb;
    private DataModel<?> fcc;
    private boolean fcd;
    private NewWriteModel.d fce;
    private f fcf;
    private x.a fcg;
    private View.OnClickListener fch;
    public boolean isBJH;
    public int mFrom;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.fcb = "";
        this.fcd = false;
        this.fbv = null;
        this.mFrom = 0;
        this.fbF = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (h.this.fce != null) {
                    h.this.fce.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    h.this.fca = null;
                    h.this.fcb = null;
                    h.this.jQ(true);
                    h.this.bwl();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cSo = h.this.fbr.cSo();
                    h.this.fbr.e((WriteData) null);
                    h.this.fbr.wY(false);
                    h.this.mVoiceModel = null;
                    if (cSo != null && cSo != null && cSo.getType() == 2) {
                        h.this.fcc.bvG();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bM(i, str)) {
                    h.this.aC(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bqD());
                    if (h.this.akp != null) {
                        writeData.setBaijiahaoData(h.this.akp.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.DX(ahVar.bqC())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.bqj().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bqC())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.bqj().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.etO.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.bqj().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fch = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.fbv)) {
                    l.showToast(h.this.bqj().getPageActivity(), h.this.fbv);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.fca == null) {
                this.fca = new j();
            }
            this.fca.mContent = writeData.getContent();
            this.fca.fcm = writeData.getSubPbReplyPrefix();
            c(this.fca);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.etO = tbPageContext;
    }

    public TbPageContext<?> bqj() {
        return this.etO;
    }

    public void setThreadData(bw bwVar) {
        this.akp = bwVar;
    }

    public void Di(String str) {
        if (this.fca == null) {
            this.fca = new j();
        }
        this.fca.mContent = str;
    }

    public void a(j jVar) {
        this.fca = jVar;
    }

    public void reset() {
        this.fbr.e((WriteData) null);
        this.fbr.wY(false);
        this.mVoiceModel = null;
    }

    public void a(x.a aVar) {
        this.fcg = aVar;
    }

    public void setReplyId(String str) {
        this.fcb = str;
    }

    public void b(DataModel<?> dataModel) {
        this.fcc = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bvH();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.fbr = new NewWriteModel(tbPageContext);
            this.fbr.b(this.fbF);
            x.b(this.fcc.bvH(), new x.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.fca == null) {
                            h.this.fca = new j();
                        }
                        h.this.fca.mContent = writeData.getContent();
                        h.this.fca.fcm = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.fca);
                    }
                    if (h.this.fcg != null) {
                        h.this.fcg.a(writeData);
                    }
                }
            });
        }
    }

    public boolean bwb() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        N(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (bvf() != null) {
                        bvf().hide();
                    }
                    bwl();
                    jQ(true);
                    WriteData cSo = this.fbr.cSo();
                    this.fbr.e((WriteData) null);
                    this.fbr.wY(false);
                    if (cSo != null && cSo != null && cSo.getType() == 2) {
                        this.fcc.bvG();
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
                    if (this.fce != null) {
                        this.fce.callback(false, postWriteCallBackData, null, this.fbr.cSo(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bwj() {
        if (this.fbr.cSo() == null) {
            WriteData Dd = this.fcc.Dd(this.fcc.bvH());
            if (Dd != null && this.akp != null) {
                Dd.setBaijiahaoData(this.akp.getBaijiahaoData());
            }
            this.fbr.e(Dd);
        }
        if (this.fbr.cSo() != null) {
            this.fbr.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fca != null) {
                this.fbr.cSo().setContent(this.fca.mContent);
                this.fbr.cSo().setSubPbReplyPrefix(this.fca.fcm);
                if (this.akp != null) {
                    this.fbr.cSo().setBaijiahaoData(this.akp.getBaijiahaoData());
                }
            }
            this.fbr.cSo().setReplyId(this.fcb);
            if (this.mPostId != null) {
                this.fbr.cSo().setRepostId(this.fcc.bvH());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fbr.cSo().setVoice(this.mVoiceModel.getId());
                    this.fbr.cSo().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fbr.cSo().setVoice(null);
                    this.fbr.cSo().setVoiceDuringTime(-1);
                }
            } else {
                this.fbr.cSo().setVoice(null);
                this.fbr.cSo().setVoiceDuringTime(-1);
            }
            if (!this.fbr.dFF()) {
                bqj().showToast(R.string.write_img_limit);
            } else if (this.fbz == null || !this.fbz.bvJ()) {
                if (this.fby != null) {
                    this.fby.bvK();
                }
                c(this.fbr.cSo());
                if (!this.fbr.dFC()) {
                }
            }
        }
    }

    public void onDestory() {
        bwk();
        this.fbr.cancelLoadData();
    }

    public void onStop() {
    }

    public void bwk() {
        WriteData writeData = new WriteData(2);
        if (this.fca != null) {
            writeData.setContent(this.fca.mContent);
            writeData.setSubPbReplyPrefix(this.fca.fcm);
        }
        writeData.setReplyId(this.fcb);
        writeData.setThreadId(this.mPostId);
        x.g(this.mPostId, writeData);
    }

    public void bwl() {
        x.f(this.mPostId, (WriteData) null);
    }

    public void aC(int i, String str) {
        if (AntiHelper.bM(i, str)) {
            if (AntiHelper.a(this.etO.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            Dm(str);
        } else {
            bqj().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.fca != null) {
            pbEditorData.setContent(this.fca.mContent);
            pbEditorData.setSubPbReplyPrefix(this.fca.fcm);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.fbv);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.etO.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.h qM;
        if (antiData != null) {
            this.fbv = antiData.getVoice_message();
            if (!StringUtils.isNull(this.fbv) && bvf() != null && (qM = bvf().qM(6)) != null && !TextUtils.isEmpty(this.fbv)) {
                ((View) qM).setOnClickListener(this.fch);
            }
        }
    }

    private void Dm(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bqj().getPageActivity());
        aVar.AH(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bqj()).bkJ();
    }

    private void N(ArrayList<String> arrayList) {
        if (bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bwm() {
        return this.fcd;
    }

    public void jS(boolean z) {
        this.fcd = z;
    }

    public void Dn(String str) {
        jS(true);
        bvf().display();
        if (str != null && str.length() != 0) {
            String replace = bqj().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.fcm = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(bqj().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        jS(true);
        bvf().display();
        c(jVar);
        TiebaStatic.eventStat(bqj().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bwn() {
        jS(false);
        bvf().hide();
    }

    public void bwo() {
        jS(true);
        bvf().display();
        bvf().bv((View) bvf().qM(5));
    }

    public void bwp() {
        jS(true);
        bvf().display();
        bvf().bv((View) bvf().qM(2));
    }

    public void bwq() {
        jS(true);
        bvf().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void Do(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.fca != null) {
                if (TextUtils.isEmpty(this.fca.fcm) && TextUtils.isEmpty(this.fca.mContent)) {
                    Dn(str);
                    return;
                } else if (!TextUtils.isEmpty(this.fca.fcm) && this.fca.fcm.equals(replace)) {
                    b(this.fca);
                    return;
                } else {
                    Dn(str);
                    return;
                }
            }
            Dn(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jQ(boolean z) {
        if (bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.fce = dVar;
    }

    public void a(c cVar) {
        this.fby = cVar;
    }

    public void a(b bVar) {
        this.fbz = bVar;
    }

    public f bwr() {
        if (this.fcf == null && bvf() != null) {
            this.fcf = (f) bvf().qP(27);
        }
        return this.fcf;
    }

    public boolean bws() {
        return (this.fca == null || at.isEmpty(this.fca.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void Dp(String str) {
        if (!StringUtils.isNull(str) && bvf() != null) {
            bvf().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }

    public void c(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (!TextUtils.isEmpty(writeData.getContent())) {
                int i2 = 0;
                while (aw.ezL.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    aq aqVar = new aq("c13990");
                    aqVar.aj("obj_type", i2);
                    aqVar.aj("obj_source", this.mFrom);
                    aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dK("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar);
                }
            }
            if (writeData.getWriteImagesInfo() != null && !y.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
                for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                    if (imageFileInfo.getImageType() == 1) {
                        i++;
                    }
                }
                if (i > 0 && this.mFrom > 0) {
                    aq aqVar2 = new aq("c13991");
                    aqVar2.aj("obj_type", i);
                    aqVar2.aj("obj_source", this.mFrom);
                    aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dK("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
