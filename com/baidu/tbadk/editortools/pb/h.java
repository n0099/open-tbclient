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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ay;
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
    private bx akt;
    private TbPageContext<?> eGu;
    private NewWriteModel foP;
    private String foT;
    private c foW;
    private b foX;
    private String fpA;
    private DataModel<?> fpB;
    private boolean fpC;
    private NewWriteModel.d fpD;
    private f fpE;
    private x.a fpF;
    private View.OnClickListener fpG;
    private NewWriteModel.d fpd;
    private j fpz;
    public boolean isBJH;
    public int mFrom;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.fpA = "";
        this.fpC = false;
        this.foT = null;
        this.mFrom = 0;
        this.fpd = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (h.this.fpD != null) {
                    h.this.fpD.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    h.this.fpz = null;
                    h.this.fpA = null;
                    h.this.kn(true);
                    h.this.bzT();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cXs = h.this.foP.cXs();
                    h.this.foP.e((WriteData) null);
                    h.this.foP.xF(false);
                    h.this.mVoiceModel = null;
                    if (cXs != null && cXs != null && cXs.getType() == 2) {
                        h.this.fpB.bzo();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bP(i, str)) {
                    h.this.aG(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bum());
                    if (h.this.akt != null) {
                        writeData.setBaijiahaoData(h.this.akt.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.Ef(ahVar.bul())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.btS().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bul())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.btS().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.eGu.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.btS().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ak("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ak("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fpG = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.foT)) {
                    l.showToast(h.this.btS().getPageActivity(), h.this.foT);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.fpz == null) {
                this.fpz = new j();
            }
            this.fpz.mContent = writeData.getContent();
            this.fpz.fpL = writeData.getSubPbReplyPrefix();
            c(this.fpz);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eGu = tbPageContext;
    }

    public TbPageContext<?> btS() {
        return this.eGu;
    }

    public void setThreadData(bx bxVar) {
        this.akt = bxVar;
    }

    public void Do(String str) {
        if (this.fpz == null) {
            this.fpz = new j();
        }
        this.fpz.mContent = str;
    }

    public void a(j jVar) {
        this.fpz = jVar;
    }

    public void reset() {
        this.foP.e((WriteData) null);
        this.foP.xF(false);
        this.mVoiceModel = null;
    }

    public void a(x.a aVar) {
        this.fpF = aVar;
    }

    public void setReplyId(String str) {
        this.fpA = str;
    }

    public void b(DataModel<?> dataModel) {
        this.fpB = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bzp();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.foP = new NewWriteModel(tbPageContext);
            this.foP.b(this.fpd);
            x.b(this.fpB.bzp(), new x.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.fpz == null) {
                            h.this.fpz = new j();
                        }
                        h.this.fpz.mContent = writeData.getContent();
                        h.this.fpz.fpL = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.fpz);
                    }
                    if (h.this.fpF != null) {
                        h.this.fpF.a(writeData);
                    }
                }
            });
        }
    }

    public boolean bzJ() {
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
                    if (byN() != null) {
                        byN().hide();
                    }
                    bzT();
                    kn(true);
                    WriteData cXs = this.foP.cXs();
                    this.foP.e((WriteData) null);
                    this.foP.xF(false);
                    if (cXs != null && cXs != null && cXs.getType() == 2) {
                        this.fpB.bzo();
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
                    if (this.fpD != null) {
                        this.fpD.callback(false, postWriteCallBackData, null, this.foP.cXs(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void bzR() {
        if (this.foP.cXs() == null) {
            WriteData Dj = this.fpB.Dj(this.fpB.bzp());
            if (Dj != null && this.akt != null) {
                Dj.setBaijiahaoData(this.akt.getBaijiahaoData());
            }
            this.foP.e(Dj);
        }
        if (this.foP.cXs() != null) {
            this.foP.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fpz != null) {
                this.foP.cXs().setContent(this.fpz.mContent);
                this.foP.cXs().setSubPbReplyPrefix(this.fpz.fpL);
                if (this.akt != null) {
                    this.foP.cXs().setBaijiahaoData(this.akt.getBaijiahaoData());
                }
            }
            this.foP.cXs().setReplyId(this.fpA);
            if (this.mPostId != null) {
                this.foP.cXs().setRepostId(this.fpB.bzp());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.foP.cXs().setVoice(this.mVoiceModel.getId());
                    this.foP.cXs().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.foP.cXs().setVoice(null);
                    this.foP.cXs().setVoiceDuringTime(-1);
                }
            } else {
                this.foP.cXs().setVoice(null);
                this.foP.cXs().setVoiceDuringTime(-1);
            }
            if (!this.foP.dLo()) {
                btS().showToast(R.string.write_img_limit);
            } else if (this.foX == null || !this.foX.bzr()) {
                if (this.foW != null) {
                    this.foW.bzs();
                }
                c(this.foP.cXs());
                if (!this.foP.dLl()) {
                }
            }
        }
    }

    public void onDestory() {
        bzS();
        this.foP.cancelLoadData();
    }

    public void onStop() {
    }

    public void bzS() {
        WriteData writeData = new WriteData(2);
        if (this.fpz != null) {
            writeData.setContent(this.fpz.mContent);
            writeData.setSubPbReplyPrefix(this.fpz.fpL);
        }
        writeData.setReplyId(this.fpA);
        writeData.setThreadId(this.mPostId);
        x.g(this.mPostId, writeData);
    }

    public void bzT() {
        x.g(this.mPostId, null);
    }

    public void aG(int i, String str) {
        if (AntiHelper.bP(i, str)) {
            if (AntiHelper.a(this.eGu.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ak("obj_locate", ay.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            Ds(str);
        } else {
            btS().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.fpz != null) {
            pbEditorData.setContent(this.fpz.mContent);
            pbEditorData.setSubPbReplyPrefix(this.fpz.fpL);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.foT);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eGu.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.h rF;
        if (antiData != null) {
            this.foT = antiData.getVoice_message();
            if (!StringUtils.isNull(this.foT) && byN() != null && (rF = byN().rF(6)) != null && !TextUtils.isEmpty(this.foT)) {
                ((View) rF).setOnClickListener(this.fpG);
            }
        }
    }

    private void Ds(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(btS().getPageActivity());
        aVar.AJ(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(btS()).bog();
    }

    private void N(ArrayList<String> arrayList) {
        if (byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean bzU() {
        return this.fpC;
    }

    public void kp(boolean z) {
        this.fpC = z;
    }

    public void Dt(String str) {
        kp(true);
        byN().display();
        if (str != null && str.length() != 0) {
            String replace = btS().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.fpL = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(btS().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        kp(true);
        byN().display();
        c(jVar);
        TiebaStatic.eventStat(btS().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void bzV() {
        kp(false);
        byN().hide();
    }

    public void bzW() {
        kp(true);
        byN().display();
        byN().bD((View) byN().rF(5));
    }

    public void bzX() {
        kp(true);
        byN().display();
        byN().bD((View) byN().rF(2));
    }

    public void bzY() {
        kp(true);
        byN().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void Du(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.fpz != null) {
                if (TextUtils.isEmpty(this.fpz.fpL) && TextUtils.isEmpty(this.fpz.mContent)) {
                    Dt(str);
                    return;
                } else if (!TextUtils.isEmpty(this.fpz.fpL) && this.fpz.fpL.equals(replace)) {
                    b(this.fpz);
                    return;
                } else {
                    Dt(str);
                    return;
                }
            }
            Dt(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(boolean z) {
        if (byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.fpD = dVar;
    }

    public void a(c cVar) {
        this.foW = cVar;
    }

    public void a(b bVar) {
        this.foX = bVar;
    }

    public f bzZ() {
        if (this.fpE == null && byN() != null) {
            this.fpE = (f) byN().rI(27);
        }
        return this.fpE;
    }

    public boolean bAa() {
        return (this.fpz == null || au.isEmpty(this.fpz.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void Dv(String str) {
        if (!StringUtils.isNull(str) && byN() != null) {
            byN().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }

    public void c(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (!TextUtils.isEmpty(writeData.getContent())) {
                int i2 = 0;
                while (ax.eNa.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    ar arVar = new ar("c13990");
                    arVar.ak("obj_type", i2);
                    arVar.ak("obj_source", this.mFrom);
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(arVar);
                }
            }
            if (writeData.getWriteImagesInfo() != null && !y.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
                for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                    if (imageFileInfo.getImageType() == 1) {
                        i++;
                    }
                }
                if (i > 0 && this.mFrom > 0) {
                    ar arVar2 = new ar("c13991");
                    arVar2.ak("obj_type", i);
                    arVar2.ak("obj_source", this.mFrom);
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
