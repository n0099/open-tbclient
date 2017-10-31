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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
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
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.f {
    private String aCT;
    private VoiceData.VoiceModel aCU;
    private NewWriteModel aCX;
    private DataModel<?> aDA;
    private boolean aDB;
    private NewWriteModel.d aDC;
    private AntiData aDD;
    private c aDf;
    private b aDg;
    private com.baidu.tbadk.editortools.inputtool.a aDi;
    private NewWriteModel.d aDo;
    private String aDy;
    private String aDz;
    private TbPageContext<?> abI;
    private AntiHelper.a mInjectListener;
    private String mPostId;

    public f(i iVar) {
        super(iVar);
        this.aCT = "";
        this.aDy = "";
        this.aDz = null;
        this.aDB = false;
        this.aDo = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.f.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                if (f.this.aDC != null) {
                    f.this.aDC.callback(z, postWriteCallBackData, qVar, writeData, antiData);
                }
                if (z) {
                    f.this.aCT = null;
                    f.this.aDy = null;
                    f.this.bF(true);
                    f.this.DE();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = f.this.aCX.getWriteData();
                    f.this.aCX.setWriteData(null);
                    f.this.aCX.mB(false);
                    f.this.aCU = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        f.this.aDA.Db();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.tW(i)) {
                    f.this.l(i, str);
                } else if (qVar != null && writeData != null && !StringUtils.isNull(qVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.ya());
                    if (com.baidu.tbadk.q.a.ha(qVar.xZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(f.this.xH().getPageActivity(), 12006, writeData, false, qVar.xZ())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(f.this.xH().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(f.this.abI.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    f.this.xH().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.f.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12536").r("obj_locate", ap.a.ahu));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ak("c12535").r("obj_locate", ap.a.ahu));
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.abI = tbPageContext;
    }

    public TbPageContext<?> xH() {
        return this.abI;
    }

    public String DB() {
        return this.aCT;
    }

    public void fU(String str) {
        this.aCT = str;
    }

    public void setReplyId(String str) {
        this.aDy = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aDA = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Dc();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aCX = new NewWriteModel(tbPageContext);
            this.aCX.b(this.aDo);
            s.b(this.aDA.Dc(), new s.a() { // from class: com.baidu.tbadk.editortools.pb.f.3
                @Override // com.baidu.tieba.tbadkCore.s.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        f.this.aCT = writeData.getContent();
                        f.this.gc(f.this.aCT);
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
                    if (CI() != null) {
                        CI().hide();
                    }
                    DE();
                    bF(true);
                    WriteData writeData = this.aCX.getWriteData();
                    this.aCX.setWriteData(null);
                    this.aCX.mB(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aDA.Db();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12006:
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA) instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    if (this.aDC != null) {
                        this.aDC.callback(false, postWriteCallBackData, null, this.aCX.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DC() {
        if (this.aCX.getWriteData() == null) {
            this.aCX.setWriteData(this.aDA.fP(this.aDA.Dc()));
        }
        if (this.aCX.getWriteData() != null) {
            this.aCX.getWriteData().setContent(this.aCT);
            this.aCX.getWriteData().setReplyId(this.aDy);
            if (this.mPostId != null) {
                this.aCX.getWriteData().setRepostId(this.aDA.Dc());
            }
            if (this.aCU != null) {
                if (this.aCU.getId() != null) {
                    this.aCX.getWriteData().setVoice(this.aCU.getId());
                    this.aCX.getWriteData().setVoiceDuringTime(this.aCU.duration);
                } else {
                    this.aCX.getWriteData().setVoice(null);
                    this.aCX.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aCX.getWriteData().setVoice(null);
                this.aCX.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aCX.bvz()) {
                xH().showToast(d.j.write_img_limit);
            } else if (this.aDg == null || !this.aDg.De()) {
                if (this.aDf != null) {
                    this.aDf.Df();
                }
                if (!this.aCX.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        DD();
        this.aCX.cancelLoadData();
    }

    public void onStop() {
    }

    public void DD() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aCT);
        writeData.setReplyId(this.aDy);
        writeData.setThreadId(this.mPostId);
        s.e(this.mPostId, writeData);
    }

    public void DE() {
        s.d(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.tW(i)) {
            if (AntiHelper.a(this.abI.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahu));
            }
        } else if (i == 230277 || i == 230278) {
            fZ(str);
        } else {
            xH().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aDD = antiData;
    }

    private void fZ(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xH().getPageActivity());
        aVar.cS(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.f.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(xH()).th();
    }

    private void q(ArrayList<String> arrayList) {
        if (CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aCU = voiceModel;
    }

    public boolean DF() {
        return this.aDB;
    }

    public void bG(boolean z) {
        this.aDB = z;
    }

    public void ga(String str) {
        bG(true);
        CI().lG();
        if (str != null && str.length() != 0) {
            gc(xH().getResources().getString(d.j.reply_sub_floor).replace("%s", str));
        } else {
            gc("");
        }
        TiebaStatic.eventStat(xH().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gb(String str) {
        bG(true);
        CI().lG();
        gc(str);
        TiebaStatic.eventStat(xH().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DG() {
        bG(false);
        CI().hide();
    }

    public void DH() {
        bG(true);
        CI().lG();
        CI().L((View) CI().eN(5));
    }

    public void DI() {
        bG(true);
        CI().lG();
        CI().L((View) CI().eN(2));
    }

    public void DJ() {
        bG(true);
        CI().lG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(String str) {
        if (CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void gd(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (am.isEmpty(this.aCT) || this.aCT.matches(str2)) {
            if (this.aDz != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aDz).lookingAt()) {
                    gb(this.aDz);
                    return;
                } else {
                    ga(str);
                    return;
                }
            }
            ga(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aCT);
        this.aDz = this.aCT;
        if (matcher.lookingAt()) {
            gb(this.aCT);
        } else {
            ga(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (CI() != null) {
            CI().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aDC = dVar;
    }

    public void a(c cVar) {
        this.aDf = cVar;
    }

    public void a(b bVar) {
        this.aDg = bVar;
    }

    public com.baidu.tbadk.editortools.inputtool.a Di() {
        if (this.aDi == null && CI() != null) {
            this.aDi = (com.baidu.tbadk.editortools.inputtool.a) CI().eP(3);
        }
        return this.aDi;
    }
}
