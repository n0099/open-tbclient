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
import com.baidu.tbadk.coreExtra.data.r;
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
    private String aDG;
    private String aDH;
    private DataModel<?> aDI;
    private boolean aDJ;
    private NewWriteModel.d aDK;
    private AntiData aDL;
    private String aDb;
    private VoiceData.VoiceModel aDc;
    private NewWriteModel aDf;
    private c aDn;
    private b aDo;
    private com.baidu.tbadk.editortools.inputtool.a aDq;
    private NewWriteModel.d aDw;
    private TbPageContext<?> abI;
    private AntiHelper.a mInjectListener;
    private String mPostId;

    public f(i iVar) {
        super(iVar);
        this.aDb = "";
        this.aDG = "";
        this.aDH = null;
        this.aDJ = false;
        this.aDw = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.f.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
                if (f.this.aDK != null) {
                    f.this.aDK.callback(z, postWriteCallBackData, rVar, writeData, antiData);
                }
                if (z) {
                    f.this.aDb = null;
                    f.this.aDG = null;
                    f.this.bG(true);
                    f.this.DQ();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = f.this.aDf.getWriteData();
                    f.this.aDf.setWriteData(null);
                    f.this.aDf.mJ(false);
                    f.this.aDc = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        f.this.aDI.Dn();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.ua(i)) {
                    f.this.l(i, str);
                } else if (rVar != null && writeData != null && !StringUtils.isNull(rVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(rVar.getVcode_md5());
                    writeData.setVcodeUrl(rVar.getVcode_pic_url());
                    writeData.setVcodeExtra(rVar.yi());
                    if (com.baidu.tbadk.q.a.hb(rVar.yh())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(f.this.xP().getPageActivity(), 12006, writeData, false, rVar.yh())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(f.this.xP().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(f.this.abI.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    f.this.xP().showToast(str);
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

    public TbPageContext<?> xP() {
        return this.abI;
    }

    public String DN() {
        return this.aDb;
    }

    public void fV(String str) {
        this.aDb = str;
    }

    public void setReplyId(String str) {
        this.aDG = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aDI = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Do();
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aDf = new NewWriteModel(tbPageContext);
            this.aDf.b(this.aDw);
            s.b(this.aDI.Do(), new s.a() { // from class: com.baidu.tbadk.editortools.pb.f.3
                @Override // com.baidu.tieba.tbadkCore.s.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        f.this.aDb = writeData.getContent();
                        f.this.gd(f.this.aDb);
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
                    if (CU() != null) {
                        CU().hide();
                    }
                    DQ();
                    bG(true);
                    WriteData writeData = this.aDf.getWriteData();
                    this.aDf.setWriteData(null);
                    this.aDf.mJ(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aDI.Dn();
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
                    if (this.aDK != null) {
                        this.aDK.callback(false, postWriteCallBackData, null, this.aDf.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DO() {
        if (this.aDf.getWriteData() == null) {
            this.aDf.setWriteData(this.aDI.fQ(this.aDI.Do()));
        }
        if (this.aDf.getWriteData() != null) {
            this.aDf.getWriteData().setContent(this.aDb);
            this.aDf.getWriteData().setReplyId(this.aDG);
            if (this.mPostId != null) {
                this.aDf.getWriteData().setRepostId(this.aDI.Do());
            }
            if (this.aDc != null) {
                if (this.aDc.getId() != null) {
                    this.aDf.getWriteData().setVoice(this.aDc.getId());
                    this.aDf.getWriteData().setVoiceDuringTime(this.aDc.duration);
                } else {
                    this.aDf.getWriteData().setVoice(null);
                    this.aDf.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDf.getWriteData().setVoice(null);
                this.aDf.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDf.bvL()) {
                xP().showToast(d.j.write_img_limit);
            } else if (this.aDo == null || !this.aDo.Dq()) {
                if (this.aDn != null) {
                    this.aDn.Dr();
                }
                if (!this.aDf.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        DP();
        this.aDf.cancelLoadData();
    }

    public void onStop() {
    }

    public void DP() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aDb);
        writeData.setReplyId(this.aDG);
        writeData.setThreadId(this.mPostId);
        s.e(this.mPostId, writeData);
    }

    public void DQ() {
        s.d(this.mPostId, (WriteData) null);
    }

    public void l(int i, String str) {
        if (AntiHelper.ua(i)) {
            if (AntiHelper.a(this.abI.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new ak("c12534").r("obj_locate", ap.a.ahu));
            }
        } else if (i == 230277 || i == 230278) {
            ga(str);
        } else {
            xP().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aDL = antiData;
    }

    private void ga(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(xP().getPageActivity());
        aVar.cS(str);
        aVar.b(d.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.f.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(xP()).th();
    }

    private void q(ArrayList<String> arrayList) {
        if (CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aDc = voiceModel;
    }

    public boolean DR() {
        return this.aDJ;
    }

    public void bH(boolean z) {
        this.aDJ = z;
    }

    public void gb(String str) {
        bH(true);
        CU().lG();
        if (str != null && str.length() != 0) {
            gd(xP().getResources().getString(d.j.reply_sub_floor).replace("%s", str));
        } else {
            gd("");
        }
        TiebaStatic.eventStat(xP().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gc(String str) {
        bH(true);
        CU().lG();
        gd(str);
        TiebaStatic.eventStat(xP().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DS() {
        bH(false);
        CU().hide();
    }

    public void DT() {
        bH(true);
        CU().lG();
        CU().L((View) CU().eM(5));
    }

    public void DU() {
        bH(true);
        CU().lG();
        CU().L((View) CU().eM(2));
    }

    public void DV() {
        bH(true);
        CU().lG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd(String str) {
        if (CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void ge(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (am.isEmpty(this.aDb) || this.aDb.matches(str2)) {
            if (this.aDH != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aDH).lookingAt()) {
                    gc(this.aDH);
                    return;
                } else {
                    gb(str);
                    return;
                }
            }
            gb(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aDb);
        this.aDH = this.aDb;
        if (matcher.lookingAt()) {
            gc(this.aDb);
        } else {
            gb(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        if (CU() != null) {
            CU().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aDK = dVar;
    }

    public void a(c cVar) {
        this.aDn = cVar;
    }

    public void a(b bVar) {
        this.aDo = bVar;
    }

    public com.baidu.tbadk.editortools.inputtool.a Du() {
        if (this.aDq == null && CU() != null) {
            this.aDq = (com.baidu.tbadk.editortools.inputtool.a) CU().eO(3);
        }
        return this.aDq;
    }
}
