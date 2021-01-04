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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
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
    private bz alW;
    private TbPageContext<?> eXu;
    private j fGK;
    private String fGL;
    private DataModel<?> fGM;
    private boolean fGN;
    private NewWriteModel.d fGO;
    private f fGP;
    private y.a fGQ;
    private View.OnClickListener fGR;
    private NewWriteModel fGa;
    private String fGe;
    private c fGh;
    private b fGi;
    private NewWriteModel.d fGo;
    public boolean isBJH;
    public int mFrom;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.fGL = "";
        this.fGN = false;
        this.fGe = null;
        this.mFrom = 0;
        this.fGo = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (h.this.fGO != null) {
                    h.this.fGO.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    h.this.fGK = null;
                    h.this.fGL = null;
                    h.this.la(true);
                    h.this.bFO();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z && h.this.alW != null) {
                    aq aqVar = new aq("c13563");
                    aqVar.dX("tid", h.this.alW.getId());
                    aqVar.w("fid", h.this.alW.getFid());
                    aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                    aqVar.an("obj_type", 2);
                    com.baidu.tbadk.pageExtra.c ft = com.baidu.tbadk.pageExtra.d.ft(h.this.eXu.getPageActivity());
                    if (ft != null) {
                        aqVar.dX("obj_cur_page", ft.getCurrentPageKey());
                    }
                    if (com.baidu.tbadk.pageExtra.d.bHm() != null) {
                        aqVar.dX("obj_pre_page", com.baidu.tbadk.pageExtra.d.bHm());
                    }
                    TiebaStatic.log(aqVar);
                }
                if (z) {
                    WriteData dco = h.this.fGa.dco();
                    h.this.fGa.f((WriteData) null);
                    h.this.fGa.yp(false);
                    h.this.mVoiceModel = null;
                    if (dco != null && dco != null && dco.getType() == 2) {
                        h.this.fGM.bFj();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bP(i, str)) {
                    h.this.aI(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bAg());
                    if (h.this.alW != null) {
                        writeData.setBaijiahaoData(h.this.alW.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.EQ(ahVar.bAf())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.bzM().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bAf())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.bzM().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.eXu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.bzM().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fGR = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.fGe)) {
                    l.showToast(h.this.bzM().getPageActivity(), h.this.fGe);
                }
            }
        };
    }

    public void c(WriteData writeData) {
        if (writeData != null) {
            if (this.fGK == null) {
                this.fGK = new j();
            }
            this.fGK.mContent = writeData.getContent();
            this.fGK.fGW = writeData.getSubPbReplyPrefix();
            c(this.fGK);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eXu = tbPageContext;
    }

    public TbPageContext<?> bzM() {
        return this.eXu;
    }

    public void setThreadData(bz bzVar) {
        this.alW = bzVar;
    }

    public void DT(String str) {
        if (this.fGK == null) {
            this.fGK = new j();
        }
        this.fGK.mContent = str;
    }

    public void a(j jVar) {
        this.fGK = jVar;
    }

    public void reset() {
        this.fGa.f((WriteData) null);
        this.fGa.yp(false);
        this.mVoiceModel = null;
    }

    public void a(y.a aVar) {
        this.fGQ = aVar;
    }

    public void setReplyId(String str) {
        this.fGL = str;
    }

    public void b(DataModel<?> dataModel) {
        this.fGM = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bFk();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.fGa = new NewWriteModel(tbPageContext);
            this.fGa.b(this.fGo);
            y.e(this.fGM.bFk(), new y.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.fGK == null) {
                            h.this.fGK = new j();
                        }
                        h.this.fGK.mContent = writeData.getContent();
                        h.this.fGK.fGW = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.fGK);
                    }
                    if (h.this.fGQ != null) {
                        h.this.fGQ.b(writeData);
                    }
                }
            });
        }
    }

    public boolean bFE() {
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
                    if (bEI() != null) {
                        bEI().hide();
                    }
                    bFO();
                    la(true);
                    WriteData dco = this.fGa.dco();
                    this.fGa.f((WriteData) null);
                    this.fGa.yp(false);
                    if (dco != null && dco != null && dco.getType() == 2) {
                        this.fGM.bFj();
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
                    if (this.fGO != null) {
                        this.fGO.callback(false, postWriteCallBackData, null, this.fGa.dco(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bFM() {
        if (this.fGa.dco() == null) {
            WriteData DO = this.fGM.DO(this.fGM.bFk());
            if (DO != null && this.alW != null) {
                DO.setBaijiahaoData(this.alW.getBaijiahaoData());
            }
            this.fGa.f(DO);
        }
        if (this.fGa.dco() != null) {
            this.fGa.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fGK != null) {
                this.fGa.dco().setContent(this.fGK.mContent);
                this.fGa.dco().setSubPbReplyPrefix(this.fGK.fGW);
                if (this.alW != null) {
                    this.fGa.dco().setBaijiahaoData(this.alW.getBaijiahaoData());
                }
            }
            this.fGa.dco().setReplyId(this.fGL);
            if (this.mPostId != null) {
                this.fGa.dco().setRepostId(this.fGM.bFk());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fGa.dco().setVoice(this.mVoiceModel.getId());
                    this.fGa.dco().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fGa.dco().setVoice(null);
                    this.fGa.dco().setVoiceDuringTime(-1);
                }
            } else {
                this.fGa.dco().setVoice(null);
                this.fGa.dco().setVoiceDuringTime(-1);
            }
            if (!this.fGa.dQD()) {
                bzM().showToast(R.string.write_img_limit);
            } else if (this.fGi == null || !this.fGi.bFm()) {
                if (this.fGh != null) {
                    this.fGh.bFn();
                }
                d(this.fGa.dco());
                if (!this.fGa.dQB()) {
                }
            }
        }
    }

    public void onDestory() {
        bFN();
        this.fGa.cancelLoadData();
    }

    public void onStop() {
    }

    public void bFN() {
        WriteData writeData = new WriteData(2);
        if (this.fGK != null) {
            writeData.setContent(this.fGK.mContent);
            writeData.setSubPbReplyPrefix(this.fGK.fGW);
        }
        writeData.setReplyId(this.fGL);
        writeData.setThreadId(this.mPostId);
        y.f(this.mPostId, writeData);
    }

    public void bFO() {
        y.f(this.mPostId, (WriteData) null);
    }

    public void aI(int i, String str) {
        if (AntiHelper.bP(i, str)) {
            if (AntiHelper.a(this.eXu.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            DX(str);
        } else {
            bzM().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.fGK != null) {
            pbEditorData.setContent(this.fGK.mContent);
            pbEditorData.setSubPbReplyPrefix(this.fGK.fGW);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.fGe);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eXu.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.h ss;
        if (antiData != null) {
            this.fGe = antiData.getVoice_message();
            if (!StringUtils.isNull(this.fGe) && bEI() != null && (ss = bEI().ss(6)) != null && !TextUtils.isEmpty(this.fGe)) {
                ((View) ss).setOnClickListener(this.fGR);
            }
        }
    }

    private void DX(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bzM().getPageActivity());
        aVar.Bp(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bzM()).btX();
    }

    private void N(ArrayList<String> arrayList) {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bFP() {
        return this.fGN;
    }

    public void lc(boolean z) {
        this.fGN = z;
    }

    public void DY(String str) {
        lc(true);
        bEI().rV();
        if (str != null && str.length() != 0) {
            String replace = bzM().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.fGW = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(bzM().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        lc(true);
        bEI().rV();
        c(jVar);
        TiebaStatic.eventStat(bzM().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bFQ() {
        lc(false);
        bEI().hide();
    }

    public void bFR() {
        lc(true);
        bEI().rV();
        bEI().bP((View) bEI().ss(5));
    }

    public void bFS() {
        lc(true);
        bEI().rV();
        bEI().bP((View) bEI().ss(2));
    }

    public void bFT() {
        lc(true);
        bEI().rV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void DZ(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.fGK != null) {
                if (TextUtils.isEmpty(this.fGK.fGW) && TextUtils.isEmpty(this.fGK.mContent)) {
                    DY(str);
                    return;
                } else if (!TextUtils.isEmpty(this.fGK.fGW) && this.fGK.fGW.equals(replace)) {
                    b(this.fGK);
                    return;
                } else {
                    DY(str);
                    return;
                }
            }
            DY(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(boolean z) {
        if (bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.fGO = dVar;
    }

    public void a(c cVar) {
        this.fGh = cVar;
    }

    public void a(b bVar) {
        this.fGi = bVar;
    }

    public f bFU() {
        if (this.fGP == null && bEI() != null) {
            this.fGP = (f) bEI().sv(27);
        }
        return this.fGP;
    }

    public boolean bFV() {
        return (this.fGK == null || at.isEmpty(this.fGK.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void Ea(String str) {
        if (!StringUtils.isNull(str) && bEI() != null) {
            bEI().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }

    public void d(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (!TextUtils.isEmpty(writeData.getContent())) {
                int i2 = 0;
                while (aw.fdJ.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    aq aqVar = new aq("c13990");
                    aqVar.an("obj_type", i2);
                    aqVar.an("obj_source", this.mFrom);
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dX("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar);
                }
            }
            if (writeData.getWriteImagesInfo() != null && !x.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
                for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                    if (imageFileInfo.getImageType() == 1) {
                        i++;
                    }
                }
                if (i > 0 && this.mFrom > 0) {
                    aq aqVar2 = new aq("c13991");
                    aqVar2.an("obj_type", i);
                    aqVar2.an("obj_source", this.mFrom);
                    aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dX("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
