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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ay;
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
import com.baidu.tieba.tbadkCore.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.e {
    private cb akU;
    private TbPageContext<?> eUY;
    private NewWriteModel fDH;
    private String fDL;
    private c fDO;
    private b fDP;
    private NewWriteModel.d fDW;
    private j fEq;
    private String fEr;
    private DataModel<?> fEs;
    private boolean fEt;
    private NewWriteModel.d fEu;
    private f fEv;
    private y.a fEw;
    private View.OnClickListener fEx;
    public boolean isBJH;
    public int mFrom;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.fEr = "";
        this.fEt = false;
        this.fDL = null;
        this.mFrom = 0;
        this.fDW = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (h.this.fEu != null) {
                    h.this.fEu.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    h.this.fEq = null;
                    h.this.fEr = null;
                    h.this.kZ(true);
                    h.this.bCo();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z && h.this.akU != null) {
                    ar arVar = new ar("c13563");
                    arVar.dR("tid", h.this.akU.getId());
                    arVar.v("fid", h.this.akU.getFid());
                    arVar.v("uid", TbadkApplication.getCurrentAccountId());
                    arVar.ap("obj_type", 2);
                    com.baidu.tbadk.pageExtra.c fq = com.baidu.tbadk.pageExtra.d.fq(h.this.eUY.getPageActivity());
                    if (fq != null) {
                        arVar.dR("obj_cur_page", fq.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bDM() != null) {
                        arVar.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDM());
                    }
                    TiebaStatic.log(arVar);
                }
                if (z) {
                    WriteData daC = h.this.fDH.daC();
                    h.this.fDH.f((WriteData) null);
                    h.this.fDH.yE(false);
                    h.this.mVoiceModel = null;
                    if (daC != null && daC != null && daC.getType() == 2) {
                        h.this.fEs.bBI();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bX(i, str)) {
                    h.this.aN(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bwF());
                    if (h.this.akU != null) {
                        writeData.setBaijiahaoData(h.this.akU.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.DY(ahVar.bwE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.bwm().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwE())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.bwm().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.eUY.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.bwm().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fEx = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.fDL)) {
                    l.showToast(h.this.bwm().getPageActivity(), h.this.fDL);
                }
            }
        };
    }

    public void c(WriteData writeData) {
        if (writeData != null) {
            if (this.fEq == null) {
                this.fEq = new j();
            }
            this.fEq.mContent = writeData.getContent();
            this.fEq.fEC = writeData.getSubPbReplyPrefix();
            c(this.fEq);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eUY = tbPageContext;
    }

    public TbPageContext<?> bwm() {
        return this.eUY;
    }

    public void setThreadData(cb cbVar) {
        this.akU = cbVar;
    }

    public void CW(String str) {
        if (this.fEq == null) {
            this.fEq = new j();
        }
        this.fEq.mContent = str;
    }

    public void a(j jVar) {
        this.fEq = jVar;
    }

    public void reset() {
        this.fDH.f((WriteData) null);
        this.fDH.yE(false);
        this.mVoiceModel = null;
    }

    public void a(y.a aVar) {
        this.fEw = aVar;
    }

    public void setReplyId(String str) {
        this.fEr = str;
    }

    public void b(DataModel<?> dataModel) {
        this.fEs = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bBJ();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.fDH = new NewWriteModel(tbPageContext);
            this.fDH.b(this.fDW);
            y.e(this.fEs.bBJ(), new y.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.fEq == null) {
                            h.this.fEq = new j();
                        }
                        h.this.fEq.mContent = writeData.getContent();
                        h.this.fEq.fEC = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.fEq);
                    }
                    if (h.this.fEw != null) {
                        h.this.fEw.b(writeData);
                    }
                }
            });
        }
    }

    public boolean bCd() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        I(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (bBh() != null) {
                        bBh().hide();
                    }
                    bCo();
                    kZ(true);
                    WriteData daC = this.fDH.daC();
                    this.fDH.f((WriteData) null);
                    this.fDH.yE(false);
                    if (daC != null && daC != null && daC.getType() == 2) {
                        this.fEs.bBI();
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
                    if (this.fEu != null) {
                        this.fEu.callback(false, postWriteCallBackData, null, this.fDH.daC(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bCm() {
        if (this.fDH.daC() == null) {
            WriteData CR = this.fEs.CR(this.fEs.bBJ());
            if (CR != null && this.akU != null) {
                CR.setBaijiahaoData(this.akU.getBaijiahaoData());
            }
            this.fDH.f(CR);
        }
        if (this.fDH.daC() != null) {
            this.fDH.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fEq != null) {
                this.fDH.daC().setContent(this.fEq.mContent);
                this.fDH.daC().setSubPbReplyPrefix(this.fEq.fEC);
                if (this.akU != null) {
                    this.fDH.daC().setBaijiahaoData(this.akU.getBaijiahaoData());
                }
            }
            this.fDH.daC().setReplyId(this.fEr);
            if (this.mPostId != null) {
                this.fDH.daC().setRepostId(this.fEs.bBJ());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fDH.daC().setVoice(this.mVoiceModel.getId());
                    this.fDH.daC().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fDH.daC().setVoice(null);
                    this.fDH.daC().setVoiceDuringTime(-1);
                }
            } else {
                this.fDH.daC().setVoice(null);
                this.fDH.daC().setVoiceDuringTime(-1);
            }
            if (!this.fDH.dPf()) {
                bwm().showToast(R.string.write_img_limit);
            } else if (this.fDP == null || !this.fDP.bBL()) {
                if (this.fDO != null) {
                    this.fDO.bBM();
                }
                d(this.fDH.daC());
                if (!this.fDH.dPd()) {
                }
            }
        }
    }

    public void onDestory() {
        bCn();
        this.fDH.cancelLoadData();
    }

    public void onStop() {
    }

    public void bCn() {
        WriteData writeData = new WriteData(2);
        if (this.fEq != null) {
            writeData.setContent(this.fEq.mContent);
            writeData.setSubPbReplyPrefix(this.fEq.fEC);
        }
        writeData.setReplyId(this.fEr);
        writeData.setThreadId(this.mPostId);
        y.f(this.mPostId, writeData);
    }

    public void bCo() {
        y.f(this.mPostId, (WriteData) null);
    }

    public void aN(int i, String str) {
        if (AntiHelper.bX(i, str)) {
            if (AntiHelper.a(this.eUY.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            Da(str);
        } else {
            bwm().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.fEq != null) {
            pbEditorData.setContent(this.fEq.mContent);
            pbEditorData.setSubPbReplyPrefix(this.fEq.fEC);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.fDL);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eUY.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.h qR;
        if (antiData != null) {
            this.fDL = antiData.getVoice_message();
            if (!StringUtils.isNull(this.fDL) && bBh() != null && (qR = bBh().qR(6)) != null && !TextUtils.isEmpty(this.fDL)) {
                ((View) qR).setOnClickListener(this.fEx);
            }
        }
    }

    private void Da(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bwm().getPageActivity());
        aVar.Au(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bwm()).bqx();
    }

    private void I(ArrayList<String> arrayList) {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bCp() {
        return this.fEt;
    }

    public void lb(boolean z) {
        this.fEt = z;
    }

    public void Db(String str) {
        lb(true);
        bBh().display();
        if (str != null && str.length() != 0) {
            String replace = bwm().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.fEC = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(bwm().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        lb(true);
        bBh().display();
        c(jVar);
        TiebaStatic.eventStat(bwm().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bCq() {
        lb(false);
        bBh().hide();
    }

    public void bCr() {
        lb(true);
        bBh().display();
        bBh().bL((View) bBh().qR(5));
    }

    public void bCs() {
        lb(true);
        bBh().display();
        bBh().bL((View) bBh().qR(2));
    }

    public void bCt() {
        lb(true);
        bBh().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void Dc(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.fEq != null) {
                if (TextUtils.isEmpty(this.fEq.fEC) && TextUtils.isEmpty(this.fEq.mContent)) {
                    Db(str);
                    return;
                } else if (!TextUtils.isEmpty(this.fEq.fEC) && this.fEq.fEC.equals(replace)) {
                    b(this.fEq);
                    return;
                } else {
                    Db(str);
                    return;
                }
            }
            Db(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.fEu = dVar;
    }

    public void a(c cVar) {
        this.fDO = cVar;
    }

    public void a(b bVar) {
        this.fDP = bVar;
    }

    public f bCu() {
        if (this.fEv == null && bBh() != null) {
            this.fEv = (f) bBh().qU(27);
        }
        return this.fEv;
    }

    public boolean bCv() {
        return (this.fEq == null || au.isEmpty(this.fEq.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void Dd(String str) {
        if (!StringUtils.isNull(str) && bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }

    public void d(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (!TextUtils.isEmpty(writeData.getContent())) {
                int i2 = 0;
                while (ax.fbp.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    ar arVar = new ar("c13990");
                    arVar.ap("obj_type", i2);
                    arVar.ap("obj_source", this.mFrom);
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(arVar);
                }
            }
            if (writeData.getWriteImagesInfo() != null && !com.baidu.tbadk.core.util.y.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
                for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                    if (imageFileInfo.getImageType() == 1) {
                        i++;
                    }
                }
                if (i > 0 && this.mFrom > 0) {
                    ar arVar2 = new ar("c13991");
                    arVar2.ap("obj_type", i);
                    arVar2.ap("obj_source", this.mFrom);
                    arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar2.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(arVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
