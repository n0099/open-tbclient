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
    private String aDR;
    private VoiceData.VoiceModel aDS;
    private NewWriteModel aDV;
    private AntiData aDY;
    private NewWriteModel.d aEA;
    private b aEf;
    private NewWriteModel.d aEm;
    private String aEw;
    private String aEx;
    private DataModel<?> aEy;
    private boolean aEz;
    private TbPageContext<?> acr;
    private String mPostId;

    public e(i iVar) {
        super(iVar);
        this.aDR = "";
        this.aEw = "";
        this.aEx = null;
        this.aEz = false;
        this.aEm = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.e.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                if (e.this.aEA != null) {
                    e.this.aEA.callback(z, postWriteCallBackData, qVar, writeData, antiData);
                }
                if (z) {
                    e.this.aDR = null;
                    e.this.aEw = null;
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
                    WriteData writeData2 = e.this.aDV.getWriteData();
                    e.this.aDV.setWriteData(null);
                    e.this.aDV.mF(false);
                    e.this.aDS = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        e.this.aEy.Du();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.tx(i)) {
                    e.this.m(i, str);
                } else if (qVar != null && writeData != null && !StringUtils.isNull(qVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(qVar.getVcode_md5());
                    writeData.setVcodeUrl(qVar.getVcode_pic_url());
                    writeData.setVcodeExtra(qVar.yy());
                    if (com.baidu.tbadk.q.a.gY(qVar.yx())) {
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
        return this.aDR;
    }

    public void fX(String str) {
        this.aDR = str;
    }

    public void setReplyId(String str) {
        this.aEw = str;
    }

    public void b(DataModel<?> dataModel) {
        this.aEy = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Dv();
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aDV = new NewWriteModel(tbPageContext);
            this.aDV.b(this.aEm);
            r.b(this.aEy.Dv(), new r.a() { // from class: com.baidu.tbadk.editortools.pb.e.2
                @Override // com.baidu.tieba.tbadkCore.r.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        e.this.aDR = writeData.getContent();
                        e.this.gf(e.this.aDR);
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
                    WriteData writeData = this.aDV.getWriteData();
                    this.aDV.setWriteData(null);
                    this.aDV.mF(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.aEy.Du();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void DU() {
        if (this.aDV.getWriteData() == null) {
            this.aDV.setWriteData(this.aEy.fS(this.aEy.Dv()));
        }
        if (this.aDV.getWriteData() != null) {
            if (this.aEf != null) {
                this.aEf.Dx();
            }
            if (this.aEf != null) {
                this.aEf.Dx();
            }
            if (this.aEf != null) {
                this.aEf.Dx();
            }
            this.aDV.getWriteData().setContent(this.aDR);
            this.aDV.getWriteData().setReplyId(this.aEw);
            if (this.mPostId != null) {
                this.aDV.getWriteData().setRepostId(this.aEy.Dv());
            }
            if (this.aDS != null) {
                if (this.aDS.getId() != null) {
                    this.aDV.getWriteData().setVoice(this.aDS.getId());
                    this.aDV.getWriteData().setVoiceDuringTime(this.aDS.duration);
                } else {
                    this.aDV.getWriteData().setVoice(null);
                    this.aDV.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aDV.getWriteData().setVoice(null);
                this.aDV.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aDV.bum()) {
                yg().showToast(d.l.write_img_limit);
                return;
            }
            if (this.aEf != null) {
                this.aEf.Dx();
            }
            if (!this.aDV.startPostWrite()) {
            }
        }
    }

    public void onDestory() {
        DV();
        this.aDV.cancelLoadData();
    }

    public void onStop() {
    }

    public void DV() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aDR);
        writeData.setReplyId(this.aEw);
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
            gc(str);
        } else {
            yg().showToast(str);
        }
    }

    public void a(AntiData antiData) {
        this.aDY = antiData;
    }

    private void gc(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(yg().getPageActivity());
        aVar.cT(str);
        aVar.b(d.l.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.e.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(yg()).tr();
    }

    private void q(ArrayList<String> arrayList) {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(17, 3, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.aDS = voiceModel;
    }

    public boolean DX() {
        return this.aEz;
    }

    public void bO(boolean z) {
        this.aEz = z;
    }

    public void gd(String str) {
        bO(true);
        Da().lT();
        if (str != null && str.length() != 0) {
            gf(yg().getResources().getString(d.l.reply_sub_floor).replace("%s", str));
        } else {
            gf("");
        }
        TiebaStatic.eventStat(yg().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void ge(String str) {
        bO(true);
        Da().lT();
        gf(str);
        TiebaStatic.eventStat(yg().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void DY() {
        bO(false);
        Da().hide();
    }

    public void DZ() {
        bO(true);
        Da().lT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gf(String str) {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(6, 3, str));
        }
    }

    public void gg(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(d.l.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (al.isEmpty(this.aDR) || this.aDR.matches(str2)) {
            if (this.aEx != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.aEx).lookingAt()) {
                    ge(this.aEx);
                    return;
                } else {
                    gd(str);
                    return;
                }
            }
            gd(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aDR);
        this.aEx = this.aDR;
        if (matcher.lookingAt()) {
            ge(this.aDR);
        } else {
            gd(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        if (Da() != null) {
            Da().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.aEA = dVar;
    }

    public void a(b bVar) {
        this.aEf = bVar;
    }
}
