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
    private NewWriteModel aCB;
    private b aCJ;
    private NewWriteModel.d aCR;
    private String aCx;
    private VoiceData.VoiceModel aCy;
    private String aDb;
    private String aDc;
    private DataModel<?> aDd;
    private boolean aDe;
    private NewWriteModel.d aDf;
    private AntiData aDg;
    private TbPageContext<?> abz;
    private AntiHelper.a mInjectListener;
    private String mPostId;

    public e(i iVar) {
        super(iVar);
        this.aCx = "";
        this.aDb = "";
        this.aDc = null;
        this.aDe = false;
        this.aCR = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                if (e.this.aDf != null) {
                    e.this.aDf.callback(z, postWriteCallBackData, qVar, writeData, antiData);
                }
                if (z) {
                    e.this.aCx = null;
                    e.this.aDb = null;
                    e.this.bL(true);
                    e.this.Dv();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = e.this.aCB.getWriteData();
                    e.this.aCB.setWriteData(null);
                    e.this.aCB.mG(false);
                    e.this.aCy = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        e.this.aDd.CT();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.tG(i)) {
                    e.this.l(i, str);
                } else if (qVar != null && writeData != null && !StringUtils.isNull(qVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.ya());
                    if (com.baidu.tbadk.p.a.gT(qVar.xZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.xH().getPageActivity(), 12006, writeData, false, qVar.xZ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.xH().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.abz.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    e.this.xH().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.e.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahl));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahl));
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.abz = tbPageContext;
    }

    public TbPageContext<?> xH() {
        return this.abz;
    }

    public String Ds() {
        return this.aCx;
    }

    public void fO(String str) {
        this.aCx = str;
    }

    public void setReplyId(String str) {
        this.aDb = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aDd = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.CU();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aCB = new NewWriteModel(tbPageContext);
            this.aCB.b(this.aCR);
            r.b(this.aDd.CU(), new r.a() { // from class: com.baidu.tbadk.editortools.pb.e.3
                @Override // com.baidu.tieba.tbadkCore.r.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        e.this.aCx = writeData.getContent();
                        e.this.fW(e.this.aCx);
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
                    if (Cz() != null) {
                        Cz().hide();
                    }
                    Dv();
                    bL(true);
                    WriteData writeData = this.aCB.getWriteData();
                    this.aCB.setWriteData(null);
                    this.aCB.mG(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aDd.CT();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Dt() {
        if (this.aCB.getWriteData() == null) {
            this.aCB.setWriteData(this.aDd.fJ(this.aDd.CU()));
        }
        if (this.aCB.getWriteData() != null) {
            if (this.aCJ != null) {
                this.aCJ.CW();
            }
            if (this.aCJ != null) {
                this.aCJ.CW();
            }
            if (this.aCJ != null) {
                this.aCJ.CW();
            }
            this.aCB.getWriteData().setContent(this.aCx);
            this.aCB.getWriteData().setReplyId(this.aDb);
            if (this.mPostId != null) {
                this.aCB.getWriteData().setRepostId(this.aDd.CU());
            }
            if (this.aCy != null) {
                if (this.aCy.getId() != null) {
                    this.aCB.getWriteData().setVoice(this.aCy.getId());
                    this.aCB.getWriteData().setVoiceDuringTime(this.aCy.duration);
                } else {
                    this.aCB.getWriteData().setVoice(null);
                    this.aCB.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aCB.getWriteData().setVoice(null);
                this.aCB.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aCB.bsD()) {
                xH().showToast(d.l.write_img_limit);
                return;
            }
            if (this.aCJ != null) {
                this.aCJ.CW();
            }
            if (!this.aCB.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        Du();
        this.aCB.cancelLoadData();
    }

    public void onStop() {
    }

    public void Du() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aCx);
        writeData.setReplyId(this.aDb);
        writeData.setThreadId(this.mPostId);
        r.e(this.mPostId, writeData);
    }

    public void Dv() {
        r.d(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.tG(i)) {
            if (AntiHelper.a(this.abz.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahl));
            }
        } else if (i == 230277 || i == 230278) {
            fT(str);
        } else {
            xH().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aDg = antiData;
    }

    private void fT(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xH().getPageActivity());
        aVar.cM(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(xH()).ti();
    }

    private void p(ArrayList<String> arrayList) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aCy = voiceModel;
    }

    public boolean Dw() {
        return this.aDe;
    }

    public void bM(boolean z) {
        this.aDe = z;
    }

    public void fU(String str) {
        bM(true);
        Cz().lM();
        if (str != null && str.length() != 0) {
            fW(xH().getResources().getString(d.l.reply_sub_floor).replace("%s", str));
        } else {
            fW("");
        }
        TiebaStatic.eventStat(xH().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void fV(String str) {
        bM(true);
        Cz().lM();
        fW(str);
        TiebaStatic.eventStat(xH().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Dx() {
        bM(false);
        Cz().hide();
    }

    public void Dy() {
        bM(true);
        Cz().lM();
        Cz().L((View) Cz().eN(5));
    }

    public void Dz() {
        bM(true);
        Cz().lM();
        Cz().L((View) Cz().eN(2));
    }

    public void DA() {
        bM(true);
        Cz().lM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(String str) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void fX(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.l.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (am.isEmpty(this.aCx) || this.aCx.matches(str2)) {
            if (this.aDc != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aDc).lookingAt()) {
                    fV(this.aDc);
                    return;
                } else {
                    fU(str);
                    return;
                }
            }
            fU(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aCx);
        this.aDc = this.aCx;
        if (matcher.lookingAt()) {
            fV(this.aCx);
        } else {
            fU(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        if (Cz() != null) {
            Cz().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aDf = dVar;
    }

    public void a(b bVar) {
        this.aCJ = bVar;
    }
}
