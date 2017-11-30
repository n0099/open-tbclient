package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.f {
    private String aDD;
    private c aDG;
    private b aDH;
    private NewWriteModel.d aDN;
    private String aDw;
    private NewWriteModel aDz;
    private String aEh;
    private String aEi;
    private DataModel<?> aEj;
    private boolean aEk;
    private NewWriteModel.d aEl;
    private AntiData aEm;
    private e aEn;
    private View.OnClickListener aEo;
    private TbPageContext<?> acd;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public h(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.aDw = "";
        this.aEh = "";
        this.aEi = null;
        this.aEk = false;
        this.aDD = null;
        this.aDN = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
                if (h.this.aEl != null) {
                    h.this.aEl.callback(z, postWriteCallBackData, rVar, writeData, antiData);
                }
                if (z) {
                    h.this.aDw = null;
                    h.this.aEh = null;
                    h.this.bF(true);
                    h.this.DX();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = h.this.aDz.getWriteData();
                    h.this.aDz.setWriteData(null);
                    h.this.aDz.ng(false);
                    h.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        h.this.aEj.Dw();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.uq(i)) {
                    h.this.l(i, str);
                } else if (rVar != null && writeData != null && !StringUtils.isNull(rVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(rVar.getVcode_md5());
                    writeData.setVcodeUrl(rVar.getVcode_pic_url());
                    writeData.setVcodeExtra(rVar.yj());
                    if (com.baidu.tbadk.p.a.he(rVar.yi())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.xQ().getPageActivity(), 12006, writeData, false, rVar.yi())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.xQ().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.acd.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    h.this.xQ().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahR));
            }
        };
        this.aEo = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.aDD)) {
                    l.showToast(h.this.xQ().getPageActivity(), h.this.aDD);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aDw = writeData.getContent();
            gg(this.aDw);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.acd = tbPageContext;
    }

    public TbPageContext<?> xQ() {
        return this.acd;
    }

    public String DU() {
        return this.aDw;
    }

    public void fY(String str) {
        this.aDw = str;
    }

    public void setReplyId(String str) {
        this.aEh = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aEj = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Dx();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aDz = new NewWriteModel(tbPageContext);
            this.aDz.b(this.aDN);
            t.b(this.aEj.Dx(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        h.this.aDw = writeData.getContent();
                        h.this.gg(h.this.aDw);
                    }
                }
            });
        }
    }

    public boolean DP() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        q(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    if (Dd() != null) {
                        Dd().hide();
                    }
                    DX();
                    bF(true);
                    WriteData writeData = this.aDz.getWriteData();
                    this.aDz.setWriteData(null);
                    this.aDz.ng(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aEj.Dw();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12006:
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.aEl != null) {
                        this.aEl.callback(false, postWriteCallBackData, null, this.aDz.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DV() {
        if (this.aDz.getWriteData() == null) {
            this.aDz.setWriteData(this.aEj.fT(this.aEj.Dx()));
        }
        if (this.aDz.getWriteData() != null) {
            this.aDz.getWriteData().setContent(this.aDw);
            this.aDz.getWriteData().setReplyId(this.aEh);
            if (this.mPostId != null) {
                this.aDz.getWriteData().setRepostId(this.aEj.Dx());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aDz.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aDz.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aDz.getWriteData().setVoice(null);
                    this.aDz.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDz.getWriteData().setVoice(null);
                this.aDz.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDz.bxw()) {
                xQ().showToast(d.j.write_img_limit);
            } else if (this.aDH == null || !this.aDH.Dz()) {
                if (this.aDG != null) {
                    this.aDG.DA();
                }
                if (!this.aDz.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        DW();
        this.aDz.cancelLoadData();
    }

    public void onStop() {
    }

    public void DW() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aDw);
        writeData.setReplyId(this.aEh);
        writeData.setThreadId(this.mPostId);
        t.e(this.mPostId, writeData);
    }

    public void DX() {
        t.d(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.uq(i)) {
            if (AntiHelper.a(this.acd.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahR));
            }
        } else if (i == 230277 || i == 230278) {
            gd(str);
        } else {
            xQ().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aDw);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aDD);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.acd.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.l eN;
        this.aEm = antiData;
        if (antiData != null) {
            this.aDD = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aDD) && Dd() != null && (eN = Dd().eN(6)) != null && !TextUtils.isEmpty(this.aDD)) {
                ((View) eN).setOnClickListener(this.aEo);
            }
        }
    }

    private void gd(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xQ().getPageActivity());
        aVar.cS(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(xQ()).tk();
    }

    private void q(ArrayList<String> arrayList) {
        if (Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean DY() {
        return this.aEk;
    }

    public void bG(boolean z) {
        this.aEk = z;
    }

    public void ge(String str) {
        bG(true);
        Dd().lE();
        if (str != null && str.length() != 0) {
            gg(xQ().getResources().getString(d.j.reply_sub_floor).replace("%s", str));
        } else {
            gg("");
        }
        TiebaStatic.eventStat(xQ().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gf(String str) {
        bG(true);
        Dd().lE();
        gg(str);
        TiebaStatic.eventStat(xQ().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DZ() {
        bG(false);
        Dd().hide();
    }

    public void Ea() {
        bG(true);
        Dd().lE();
        Dd().L((View) Dd().eN(5));
    }

    public void Eb() {
        bG(true);
        Dd().lE();
        Dd().L((View) Dd().eN(2));
    }

    public void Ec() {
        bG(true);
        Dd().lE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(String str) {
        if (Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void gh(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (am.isEmpty(this.aDw) || this.aDw.matches(str2)) {
            if (this.aEi != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aEi).lookingAt()) {
                    gf(this.aEi);
                    return;
                } else {
                    ge(str);
                    return;
                }
            }
            ge(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aDw);
        this.aEi = this.aDw;
        if (matcher.lookingAt()) {
            gf(this.aDw);
        } else {
            ge(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aEl = dVar;
    }

    public void a(c cVar) {
        this.aDG = cVar;
    }

    public void a(b bVar) {
        this.aDH = bVar;
    }

    public e Ed() {
        if (this.aEn == null && Dd() != null) {
            this.aEn = (e) Dd().eP(27);
        }
        return this.aEn;
    }
}
