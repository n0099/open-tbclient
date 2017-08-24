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
    private String aDS;
    private VoiceData.VoiceModel aDT;
    private NewWriteModel aDW;
    private AntiData aDZ;
    private boolean aEA;
    private NewWriteModel.d aEB;
    private b aEg;
    private NewWriteModel.d aEn;
    private String aEx;
    private String aEy;
    private DataModel<?> aEz;
    private TbPageContext<?> acr;
    private String mPostId;

    public e(i iVar) {
        super(iVar);
        this.aDS = "";
        this.aEx = "";
        this.aEy = null;
        this.aEA = false;
        this.aEn = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                if (e.this.aEB != null) {
                    e.this.aEB.callback(z, postWriteCallBackData, qVar, writeData, antiData);
                }
                if (z) {
                    e.this.aDS = null;
                    e.this.aEx = null;
                    e.this.bN(true);
                    e.this.DW();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = e.this.aDW.getWriteData();
                    e.this.aDW.setWriteData(null);
                    e.this.aDW.mF(false);
                    e.this.aDT = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        e.this.aEz.Du();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.tx(i)) {
                    e.this.m(i, str);
                } else if (qVar != null && writeData != null && !StringUtils.isNull(qVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.yy());
                    if (com.baidu.tbadk.q.a.hb(qVar.yx())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(e.this.yg().getPageActivity(), 12006, writeData, false, qVar.yx())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(e.this.yg().getPageActivity(), writeData, 12006)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(e.this.acr.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                } else {
                    e.this.yg().showToast(str);
                }
            }
        };
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.acr = tbPageContext;
    }

    public TbPageContext<?> yg() {
        return this.acr;
    }

    public String DT() {
        return this.aDS;
    }

    public void gb(String str) {
        this.aDS = str;
    }

    public void setReplyId(String str) {
        this.aEx = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aEz = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Dv();
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aDW = new NewWriteModel(tbPageContext);
            this.aDW.b(this.aEn);
            r.b(this.aEz.Dv(), new r.a() { // from class: com.baidu.tbadk.editortools.pb.e.2
                @Override // com.baidu.tieba.tbadkCore.r.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        e.this.aDS = writeData.getContent();
                        e.this.gj(e.this.aDS);
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
                    if (Da() != null) {
                        Da().hide();
                    }
                    DW();
                    bN(true);
                    WriteData writeData = this.aDW.getWriteData();
                    this.aDW.setWriteData(null);
                    this.aDW.mF(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aEz.Du();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DU() {
        if (this.aDW.getWriteData() == null) {
            this.aDW.setWriteData(this.aEz.fW(this.aEz.Dv()));
        }
        if (this.aDW.getWriteData() != null) {
            if (this.aEg != null) {
                this.aEg.Dx();
            }
            if (this.aEg != null) {
                this.aEg.Dx();
            }
            if (this.aEg != null) {
                this.aEg.Dx();
            }
            this.aDW.getWriteData().setContent(this.aDS);
            this.aDW.getWriteData().setReplyId(this.aEx);
            if (this.mPostId != null) {
                this.aDW.getWriteData().setRepostId(this.aEz.Dv());
            }
            if (this.aDT != null) {
                if (this.aDT.getId() != null) {
                    this.aDW.getWriteData().setVoice(this.aDT.getId());
                    this.aDW.getWriteData().setVoiceDuringTime(this.aDT.duration);
                } else {
                    this.aDW.getWriteData().setVoice(null);
                    this.aDW.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDW.getWriteData().setVoice(null);
                this.aDW.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDW.buf()) {
                yg().showToast(d.l.write_img_limit);
                return;
            }
            if (this.aEg != null) {
                this.aEg.Dx();
            }
            if (!this.aDW.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        DV();
        this.aDW.cancelLoadData();
    }

    public void onStop() {
    }

    public void DV() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aDS);
        writeData.setReplyId(this.aEx);
        writeData.setThreadId(this.mPostId);
        r.e(this.mPostId, writeData);
    }

    public void DW() {
        r.d(this.mPostId, (WriteData) null);
    }

    public void m(int i, String str) {
        if (AntiHelper.tx(i)) {
            AntiHelper.ar(yg().getPageActivity(), str);
        } else if (i == 230277 || i == 230278) {
            gg(str);
        } else {
            yg().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aDZ = antiData;
    }

    private void gg(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(yg().getPageActivity());
        aVar.cW(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(yg()).ts();
    }

    private void q(ArrayList<String> arrayList) {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aDT = voiceModel;
    }

    public boolean DX() {
        return this.aEA;
    }

    public void bO(boolean z) {
        this.aEA = z;
    }

    public void gh(String str) {
        bO(true);
        Da().lS();
        if (str != null && str.length() != 0) {
            gj(yg().getResources().getString(d.l.reply_sub_floor).replace("%s", str));
        } else {
            gj("");
        }
        TiebaStatic.eventStat(yg().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void gi(String str) {
        bO(true);
        Da().lS();
        gj(str);
        TiebaStatic.eventStat(yg().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DY() {
        bO(false);
        Da().hide();
    }

    public void DZ() {
        bO(true);
        Da().lS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(String str) {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void gk(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.l.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (al.isEmpty(this.aDS) || this.aDS.matches(str2)) {
            if (this.aEy != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aEy).lookingAt()) {
                    gi(this.aEy);
                    return;
                } else {
                    gh(str);
                    return;
                }
            }
            gh(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aDS);
        this.aEy = this.aDS;
        if (matcher.lookingAt()) {
            gi(this.aDS);
        } else {
            gh(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aEB = dVar;
    }

    public void a(b bVar) {
        this.aEg = bVar;
    }
}
