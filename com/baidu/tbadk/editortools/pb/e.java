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
import com.baidu.tbadk.core.util.am;
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
    private NewWriteModel.d aDB;
    private String aDL;
    private String aDM;
    private DataModel<?> aDN;
    private boolean aDO;
    private NewWriteModel.d aDP;
    private String aDg;
    private VoiceData.VoiceModel aDh;
    private NewWriteModel aDk;
    private AntiData aDn;
    private b aDu;
    private TbPageContext<?> aby;
    private String mPostId;

    public e(i iVar) {
        super(iVar);
        this.aDg = "";
        this.aDL = "";
        this.aDM = null;
        this.aDO = false;
        this.aDB = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                if (e.this.aDP != null) {
                    e.this.aDP.callback(z, postWriteCallBackData, qVar, writeData, antiData);
                }
                if (z) {
                    e.this.aDg = null;
                    e.this.aDL = null;
                    e.this.bM(true);
                    e.this.DR();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = e.this.aDk.getWriteData();
                    e.this.aDk.setWriteData(null);
                    e.this.aDk.mM(false);
                    e.this.aDh = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        e.this.aDN.Dp();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.tB(i)) {
                    e.this.l(i, str);
                } else if (qVar != null && writeData != null && !StringUtils.isNull(qVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.yB());
                    if (com.baidu.tbadk.q.a.gX(qVar.yA())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.yi().getPageActivity(), 12006, writeData, false, qVar.yA())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.yi().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.aby.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    e.this.yi().showToast(str);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.aby = tbPageContext;
    }

    public TbPageContext<?> yi() {
        return this.aby;
    }

    public String DO() {
        return this.aDg;
    }

    public void fV(String str) {
        this.aDg = str;
    }

    public void setReplyId(String str) {
        this.aDL = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aDN = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Dq();
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aDk = new NewWriteModel(tbPageContext);
            this.aDk.b(this.aDB);
            r.b(this.aDN.Dq(), new r.a() { // from class: com.baidu.tbadk.editortools.pb.e.2
                @Override // com.baidu.tieba.tbadkCore.r.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        e.this.aDg = writeData.getContent();
                        e.this.gd(e.this.aDg);
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
                    if (CV() != null) {
                        CV().hide();
                    }
                    DR();
                    bM(true);
                    WriteData writeData = this.aDk.getWriteData();
                    this.aDk.setWriteData(null);
                    this.aDk.mM(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aDN.Dp();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DP() {
        if (this.aDk.getWriteData() == null) {
            this.aDk.setWriteData(this.aDN.fQ(this.aDN.Dq()));
        }
        if (this.aDk.getWriteData() != null) {
            if (this.aDu != null) {
                this.aDu.Ds();
            }
            if (this.aDu != null) {
                this.aDu.Ds();
            }
            if (this.aDu != null) {
                this.aDu.Ds();
            }
            this.aDk.getWriteData().setContent(this.aDg);
            this.aDk.getWriteData().setReplyId(this.aDL);
            if (this.mPostId != null) {
                this.aDk.getWriteData().setRepostId(this.aDN.Dq());
            }
            if (this.aDh != null) {
                if (this.aDh.getId() != null) {
                    this.aDk.getWriteData().setVoice(this.aDh.getId());
                    this.aDk.getWriteData().setVoiceDuringTime(this.aDh.duration);
                } else {
                    this.aDk.getWriteData().setVoice(null);
                    this.aDk.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDk.getWriteData().setVoice(null);
                this.aDk.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDk.btF()) {
                yi().showToast(d.l.write_img_limit);
                return;
            }
            if (this.aDu != null) {
                this.aDu.Ds();
            }
            if (!this.aDk.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        DQ();
        this.aDk.cancelLoadData();
    }

    public void onStop() {
    }

    public void DQ() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aDg);
        writeData.setReplyId(this.aDL);
        writeData.setThreadId(this.mPostId);
        r.e(this.mPostId, writeData);
    }

    public void DR() {
        r.d(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.tB(i)) {
            AntiHelper.g(yi().getPageActivity(), str, i);
        } else if (i == 230277 || i == 230278) {
            ga(str);
        } else {
            yi().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aDn = antiData;
    }

    private void ga(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(yi().getPageActivity());
        aVar.cM(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(yi()).to();
    }

    private void q(ArrayList<String> arrayList) {
        if (CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aDh = voiceModel;
    }

    public boolean DS() {
        return this.aDO;
    }

    public void bN(boolean z) {
        this.aDO = z;
    }

    public void gb(String str) {
        bN(true);
        CV().lK();
        if (str != null && str.length() != 0) {
            gd(yi().getResources().getString(d.l.reply_sub_floor).replace("%s", str));
        } else {
            gd("");
        }
        TiebaStatic.eventStat(yi().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gc(String str) {
        bN(true);
        CV().lK();
        gd(str);
        TiebaStatic.eventStat(yi().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DT() {
        bN(false);
        CV().hide();
    }

    public void DU() {
        bN(true);
        CV().lK();
        CV().K((View) CV().eC(5));
    }

    public void DV() {
        bN(true);
        CV().lK();
        CV().K((View) CV().eC(2));
    }

    public void DW() {
        bN(true);
        CV().lK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd(String str) {
        if (CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void ge(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.l.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (am.isEmpty(this.aDg) || this.aDg.matches(str2)) {
            if (this.aDM != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aDM).lookingAt()) {
                    gc(this.aDM);
                    return;
                } else {
                    gb(str);
                    return;
                }
            }
            gb(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aDg);
        this.aDM = this.aDg;
        if (matcher.lookingAt()) {
            gc(this.aDg);
        } else {
            gb(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(boolean z) {
        if (CV() != null) {
            CV().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aDP = dVar;
    }

    public void a(b bVar) {
        this.aDu = bVar;
    }
}
