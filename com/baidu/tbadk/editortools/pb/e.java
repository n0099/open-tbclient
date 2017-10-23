package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
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
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.i;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.editortools.f {
    private NewWriteModel.d aCE;
    private String aCO;
    private String aCP;
    private DataModel<?> aCQ;
    private boolean aCR;
    private NewWriteModel.d aCS;
    private AntiData aCT;
    private String aCk;
    private VoiceData.VoiceModel aCl;
    private NewWriteModel aCo;
    private b aCw;
    private TbPageContext<?> abm;
    private AntiHelper.a mInjectListener;
    private String mPostId;

    public e(i iVar) {
        super(iVar);
        this.aCk = "";
        this.aCO = "";
        this.aCP = null;
        this.aCR = false;
        this.aCE = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                if (e.this.aCS != null) {
                    e.this.aCS.callback(z, postWriteCallBackData, qVar, writeData, antiData);
                }
                if (z) {
                    e.this.aCk = null;
                    e.this.aCO = null;
                    e.this.bK(true);
                    e.this.Dp();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = e.this.aCo.getWriteData();
                    e.this.aCo.setWriteData(null);
                    e.this.aCo.mF(false);
                    e.this.aCl = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        e.this.aCQ.CN();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.tF(i)) {
                    e.this.l(i, str);
                } else if (qVar != null && writeData != null && !StringUtils.isNull(qVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.xT());
                    if (com.baidu.tbadk.p.a.gS(qVar.xS())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.xA().getPageActivity(), 12006, writeData, false, qVar.xS())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.xA().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.abm.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    e.this.xA().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.agZ));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.agZ));
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.abm = tbPageContext;
    }

    public TbPageContext<?> xA() {
        return this.abm;
    }

    public String Dm() {
        return this.aCk;
    }

    public void fN(String str) {
        this.aCk = str;
    }

    public void setReplyId(String str) {
        this.aCO = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aCQ = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.CO();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aCo = new NewWriteModel(tbPageContext);
            this.aCo.b(this.aCE);
            r.b(this.aCQ.CO(), new r.a() { // from class: com.baidu.tbadk.editortools.pb.e.3
                @Override // com.baidu.tieba.tbadkCore.r.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        e.this.aCk = writeData.getContent();
                        e.this.fV(e.this.aCk);
                    }
                }
            });
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        p(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    if (Ct() != null) {
                        Ct().hide();
                    }
                    Dp();
                    bK(true);
                    WriteData writeData = this.aCo.getWriteData();
                    this.aCo.setWriteData(null);
                    this.aCo.mF(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aCQ.CN();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Dn() {
        if (this.aCo.getWriteData() == null) {
            this.aCo.setWriteData(this.aCQ.fI(this.aCQ.CO()));
        }
        if (this.aCo.getWriteData() != null) {
            if (this.aCw != null) {
                this.aCw.CQ();
            }
            if (this.aCw != null) {
                this.aCw.CQ();
            }
            if (this.aCw != null) {
                this.aCw.CQ();
            }
            this.aCo.getWriteData().setContent(this.aCk);
            this.aCo.getWriteData().setReplyId(this.aCO);
            if (this.mPostId != null) {
                this.aCo.getWriteData().setRepostId(this.aCQ.CO());
            }
            if (this.aCl != null) {
                if (this.aCl.getId() != null) {
                    this.aCo.getWriteData().setVoice(this.aCl.getId());
                    this.aCo.getWriteData().setVoiceDuringTime(this.aCl.duration);
                } else {
                    this.aCo.getWriteData().setVoice(null);
                    this.aCo.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aCo.getWriteData().setVoice(null);
                this.aCo.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aCo.bsv()) {
                xA().showToast(d.l.write_img_limit);
                return;
            }
            if (this.aCw != null) {
                this.aCw.CQ();
            }
            if (!this.aCo.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        Do();
        this.aCo.cancelLoadData();
    }

    public void onStop() {
    }

    public void Do() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aCk);
        writeData.setReplyId(this.aCO);
        writeData.setThreadId(this.mPostId);
        r.e(this.mPostId, writeData);
    }

    public void Dp() {
        r.d(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.tF(i)) {
            if (AntiHelper.a(this.abm.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.agZ));
            }
        } else if (i == 230277 || i == 230278) {
            fS(str);
        } else {
            xA().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aCT = antiData;
    }

    private void fS(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xA().getPageActivity());
        aVar.cL(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(xA()).tb();
    }

    private void p(ArrayList<String> arrayList) {
        if (Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aCl = voiceModel;
    }

    public boolean Dq() {
        return this.aCR;
    }

    public void bL(boolean z) {
        this.aCR = z;
    }

    public void fT(String str) {
        bL(true);
        Ct().lM();
        if (str != null && str.length() != 0) {
            fV(xA().getResources().getString(d.l.reply_sub_floor).replace("%s", str));
        } else {
            fV("");
        }
        TiebaStatic.eventStat(xA().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fU(String str) {
        bL(true);
        Ct().lM();
        fV(str);
        TiebaStatic.eventStat(xA().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Dr() {
        bL(false);
        Ct().hide();
    }

    public void Ds() {
        bL(true);
        Ct().lM();
        Ct().L((View) Ct().eM(5));
    }

    public void Dt() {
        bL(true);
        Ct().lM();
        Ct().L((View) Ct().eM(2));
    }

    public void Du() {
        bL(true);
        Ct().lM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV(String str) {
        if (Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fW(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.l.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (am.isEmpty(this.aCk) || this.aCk.matches(str2)) {
            if (this.aCP != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aCP).lookingAt()) {
                    fU(this.aCP);
                    return;
                } else {
                    fT(str);
                    return;
                }
            }
            fT(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aCk);
        this.aCP = this.aCk;
        if (matcher.lookingAt()) {
            fU(this.aCk);
        } else {
            fT(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (Ct() != null) {
            Ct().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aCS = dVar;
    }

    public void a(b bVar) {
        this.aCw = bVar;
    }
}
