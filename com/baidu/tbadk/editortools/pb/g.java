package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.editortools.d {
    private String aZR;
    private NewWriteModel aZU;
    private String aZY;
    private String baC;
    private String baD;
    private DataModel<?> baE;
    private boolean baF;
    private NewWriteModel.d baG;
    private AntiData baH;
    private e baI;
    private View.OnClickListener baJ;
    private c bab;
    private b bac;
    private NewWriteModel.d bai;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.aZR = "";
        this.baC = "";
        this.baD = null;
        this.baF = false;
        this.aZY = null;
        this.bai = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
                if (g.this.baG != null) {
                    g.this.baG.callback(z, postWriteCallBackData, wVar, writeData, antiData);
                }
                if (z) {
                    g.this.aZR = null;
                    g.this.baC = null;
                    g.this.cy(true);
                    g.this.MS();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.aZU.getWriteData();
                    g.this.aZU.setWriteData(null);
                    g.this.aZU.nC(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.baE.Ms();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.aj(i, str)) {
                    g.this.k(i, str);
                } else if (wVar != null && writeData != null && !StringUtils.isNull(wVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(wVar.getVcode_md5());
                    writeData.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData.setVcodeExtra(wVar.GX());
                    if (com.baidu.tbadk.r.a.iT(wVar.GW())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.GD().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.GW())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.GD().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.GD().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCN));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCN));
            }
        };
        this.baJ = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.aZY)) {
                    l.showToast(g.this.GD().getPageActivity(), g.this.aZY);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aZR = writeData.getContent();
            hX(this.aZR);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> GD() {
        return this.mContext;
    }

    public void hQ(String str) {
        this.aZR = str;
    }

    public void setReplyId(String str) {
        this.baC = str;
    }

    public void b(DataModel<?> dataModel) {
        this.baE = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Mt();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aZU = new NewWriteModel(tbPageContext);
            this.aZU.b(this.bai);
            t.b(this.baE.Mt(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.aZR = writeData.getContent();
                        g.this.hX(g.this.aZR);
                    }
                }
            });
        }
    }

    public boolean ML() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_MODIFY /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        u(stringArrayListExtra);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (LY() != null) {
                        LY().hide();
                    }
                    MS();
                    cy(true);
                    WriteData writeData = this.aZU.getWriteData();
                    this.aZU.setWriteData(null);
                    this.aZU.nC(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.baE.Ms();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.baG != null) {
                        this.baG.callback(false, postWriteCallBackData, null, this.aZU.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void MQ() {
        if (this.aZU.getWriteData() == null) {
            this.aZU.setWriteData(this.baE.hL(this.baE.Mt()));
        }
        if (this.aZU.getWriteData() != null) {
            this.aZU.getWriteData().setContent(this.aZR);
            this.aZU.getWriteData().setReplyId(this.baC);
            if (this.mPostId != null) {
                this.aZU.getWriteData().setRepostId(this.baE.Mt());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aZU.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aZU.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aZU.getWriteData().setVoice(null);
                    this.aZU.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aZU.getWriteData().setVoice(null);
                this.aZU.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aZU.bFv()) {
                GD().showToast(e.j.write_img_limit);
            } else if (this.bac == null || !this.bac.Mv()) {
                if (this.bab != null) {
                    this.bab.Mw();
                }
                if (!this.aZU.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        MR();
        this.aZU.cancelLoadData();
    }

    public void onStop() {
    }

    public void MR() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aZR);
        writeData.setReplyId(this.baC);
        writeData.setThreadId(this.mPostId);
        t.d(this.mPostId, writeData);
    }

    public void MS() {
        t.c(this.mPostId, (WriteData) null);
    }

    public void k(int i, String str) {
        if (AntiHelper.aj(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCN));
            }
        } else if (i == 230277 || i == 230278) {
            hU(str);
        } else {
            GD().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aZR);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aZY);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g fI;
        this.baH = antiData;
        if (antiData != null) {
            this.aZY = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aZY) && LY() != null && (fI = LY().fI(6)) != null && !TextUtils.isEmpty(this.aZY)) {
                ((View) fI).setOnClickListener(this.baJ);
            }
        }
    }

    private void hU(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(GD().getPageActivity());
        aVar.eB(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(GD()).BF();
    }

    private void u(ArrayList<String> arrayList) {
        if (LY() != null) {
            LY().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean MT() {
        return this.baF;
    }

    public void cz(boolean z) {
        this.baF = z;
    }

    public void hV(String str) {
        cz(true);
        LY().pN();
        if (str != null && str.length() != 0) {
            hX(GD().getResources().getString(e.j.reply_sub_floor).replace("%s", str));
        } else {
            hX("");
        }
        TiebaStatic.eventStat(GD().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void hW(String str) {
        cz(true);
        LY().pN();
        hX(str);
        TiebaStatic.eventStat(GD().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void MU() {
        cz(false);
        LY().hide();
    }

    public void MV() {
        cz(true);
        LY().pN();
        LY().aa((View) LY().fI(5));
    }

    public void MW() {
        cz(true);
        LY().pN();
        LY().aa((View) LY().fI(2));
    }

    public void MX() {
        cz(true);
        LY().pN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hX(String str) {
        if (LY() != null) {
            LY().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void hY(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(e.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ao.isEmpty(this.aZR) || this.aZR.matches(str2)) {
            if (this.baD != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.baD).lookingAt()) {
                    hW(this.baD);
                    return;
                } else {
                    hV(str);
                    return;
                }
            }
            hV(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aZR);
        this.baD = this.aZR;
        if (matcher.lookingAt()) {
            hW(this.aZR);
        } else {
            hV(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(boolean z) {
        if (LY() != null) {
            LY().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.baG = dVar;
    }

    public void a(c cVar) {
        this.bab = cVar;
    }

    public void a(b bVar) {
        this.bac = bVar;
    }

    public e MY() {
        if (this.baI == null && LY() != null) {
            this.baI = (e) LY().fL(27);
        }
        return this.baI;
    }
}
