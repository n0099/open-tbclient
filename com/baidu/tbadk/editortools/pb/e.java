package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
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
import com.baidu.tbadk.core.util.al;
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
    private String aCA;
    private VoiceData.VoiceModel aCB;
    private NewWriteModel aCE;
    private AntiData aCH;
    private b aCO;
    private NewWriteModel.d aCV;
    private String aDf;
    private String aDg;
    private DataModel<?> aDh;
    private boolean aDi;
    private NewWriteModel.d aDj;
    private TbPageContext<?> aaS;
    private String mPostId;

    public e(i iVar) {
        super(iVar);
        this.aCA = "";
        this.aDf = "";
        this.aDg = null;
        this.aDi = false;
        this.aCV = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                if (e.this.aDj != null) {
                    e.this.aDj.callback(z, postWriteCallBackData, qVar, writeData, antiData);
                }
                if (z) {
                    e.this.aCA = null;
                    e.this.aDf = null;
                    e.this.bN(true);
                    e.this.DO();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = e.this.aCE.getWriteData();
                    e.this.aCE.setWriteData(null);
                    e.this.aCE.mC(false);
                    e.this.aCB = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        e.this.aDh.Dm();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.to(i)) {
                    e.this.m(i, str);
                } else if (qVar != null && writeData != null && !StringUtils.isNull(qVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.yq());
                    if (com.baidu.tbadk.q.a.gT(qVar.yp())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.xY().getPageActivity(), 12006, writeData, false, qVar.yp())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.xY().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.aaS.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    e.this.xY().showToast(str);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.aaS = tbPageContext;
    }

    public TbPageContext<?> xY() {
        return this.aaS;
    }

    public String DL() {
        return this.aCA;
    }

    public void fR(String str) {
        this.aCA = str;
    }

    public void setReplyId(String str) {
        this.aDf = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aDh = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Dn();
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aCE = new NewWriteModel(tbPageContext);
            this.aCE.b(this.aCV);
            r.b(this.aDh.Dn(), new r.a() { // from class: com.baidu.tbadk.editortools.pb.e.2
                @Override // com.baidu.tieba.tbadkCore.r.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        e.this.aCA = writeData.getContent();
                        e.this.fZ(e.this.aCA);
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
                        q(stringArrayListExtra);
                        return;
                    }
                    return;
                case 12006:
                    if (CS() != null) {
                        CS().hide();
                    }
                    DO();
                    bN(true);
                    WriteData writeData = this.aCE.getWriteData();
                    this.aCE.setWriteData(null);
                    this.aCE.mC(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aDh.Dm();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DM() {
        if (this.aCE.getWriteData() == null) {
            this.aCE.setWriteData(this.aDh.fM(this.aDh.Dn()));
        }
        if (this.aCE.getWriteData() != null) {
            if (this.aCO != null) {
                this.aCO.Dp();
            }
            if (this.aCO != null) {
                this.aCO.Dp();
            }
            if (this.aCO != null) {
                this.aCO.Dp();
            }
            this.aCE.getWriteData().setContent(this.aCA);
            this.aCE.getWriteData().setReplyId(this.aDf);
            if (this.mPostId != null) {
                this.aCE.getWriteData().setRepostId(this.aDh.Dn());
            }
            if (this.aCB != null) {
                if (this.aCB.getId() != null) {
                    this.aCE.getWriteData().setVoice(this.aCB.getId());
                    this.aCE.getWriteData().setVoiceDuringTime(this.aCB.duration);
                } else {
                    this.aCE.getWriteData().setVoice(null);
                    this.aCE.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aCE.getWriteData().setVoice(null);
                this.aCE.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aCE.btx()) {
                xY().showToast(d.l.write_img_limit);
                return;
            }
            if (this.aCO != null) {
                this.aCO.Dp();
            }
            if (!this.aCE.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        DN();
        this.aCE.cancelLoadData();
    }

    public void onStop() {
    }

    public void DN() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aCA);
        writeData.setReplyId(this.aDf);
        writeData.setThreadId(this.mPostId);
        r.e(this.mPostId, writeData);
    }

    public void DO() {
        r.d(this.mPostId, (WriteData) null);
    }

    public void m(int i, String str) {
        if (AntiHelper.to(i)) {
            AntiHelper.ar(xY().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            fW(str);
        } else {
            xY().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aCH = antiData;
    }

    private void fW(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xY().getPageActivity());
        aVar.cN(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(xY()).th();
    }

    private void q(ArrayList<String> arrayList) {
        if (CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aCB = voiceModel;
    }

    public boolean DP() {
        return this.aDi;
    }

    public void bO(boolean z) {
        this.aDi = z;
    }

    public void fX(String str) {
        bO(true);
        CS().lJ();
        if (str != null && str.length() != 0) {
            fZ(xY().getResources().getString(d.l.reply_sub_floor).replace("%s", str));
        } else {
            fZ("");
        }
        TiebaStatic.eventStat(xY().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fY(String str) {
        bO(true);
        CS().lJ();
        fZ(str);
        TiebaStatic.eventStat(xY().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DQ() {
        bO(false);
        CS().hide();
    }

    public void DR() {
        bO(true);
        CS().lJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ(String str) {
        if (CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void ga(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.l.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (al.isEmpty(this.aCA) || this.aCA.matches(str2)) {
            if (this.aDg != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aDg).lookingAt()) {
                    fY(this.aDg);
                    return;
                } else {
                    fX(str);
                    return;
                }
            }
            fX(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aCA);
        this.aDg = this.aCA;
        if (matcher.lookingAt()) {
            fY(this.aCA);
        } else {
            fX(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        if (CS() != null) {
            CS().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aDj = dVar;
    }

    public void a(b bVar) {
        this.aCO = bVar;
    }
}
