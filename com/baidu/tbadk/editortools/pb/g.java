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
    private String aZO;
    private NewWriteModel aZR;
    private String aZV;
    private c aZY;
    private b aZZ;
    private String baA;
    private DataModel<?> baB;
    private boolean baC;
    private NewWriteModel.d baD;
    private AntiData baE;
    private e baF;
    private View.OnClickListener baG;
    private NewWriteModel.d baf;
    private String baz;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.aZO = "";
        this.baz = "";
        this.baA = null;
        this.baC = false;
        this.aZV = null;
        this.baf = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
                if (g.this.baD != null) {
                    g.this.baD.callback(z, postWriteCallBackData, wVar, writeData, antiData);
                }
                if (z) {
                    g.this.aZO = null;
                    g.this.baz = null;
                    g.this.cy(true);
                    g.this.MR();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.aZR.getWriteData();
                    g.this.aZR.setWriteData(null);
                    g.this.aZR.nz(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.baB.Mr();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.ai(i, str)) {
                    g.this.k(i, str);
                } else if (wVar != null && writeData != null && !StringUtils.isNull(wVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(wVar.getVcode_md5());
                    writeData.setVcodeUrl(wVar.getVcode_pic_url());
                    writeData.setVcodeExtra(wVar.GW());
                    if (com.baidu.tbadk.r.a.iS(wVar.GV())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.GC().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, wVar.GV())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.GC().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.GC().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCM));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCM));
            }
        };
        this.baG = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.aZV)) {
                    l.showToast(g.this.GC().getPageActivity(), g.this.aZV);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.aZO = writeData.getContent();
            hW(this.aZO);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> GC() {
        return this.mContext;
    }

    public void hP(String str) {
        this.aZO = str;
    }

    public void setReplyId(String str) {
        this.baz = str;
    }

    public void b(DataModel<?> dataModel) {
        this.baB = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.Ms();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.aZR = new NewWriteModel(tbPageContext);
            this.aZR.b(this.baf);
            t.b(this.baB.Ms(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.aZO = writeData.getContent();
                        g.this.hW(g.this.aZO);
                    }
                }
            });
        }
    }

    public boolean MK() {
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
                    if (LX() != null) {
                        LX().hide();
                    }
                    MR();
                    cy(true);
                    WriteData writeData = this.aZR.getWriteData();
                    this.aZR.setWriteData(null);
                    this.aZR.nz(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.baB.Mr();
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
                    if (this.baD != null) {
                        this.baD.callback(false, postWriteCallBackData, null, this.aZR.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void MP() {
        if (this.aZR.getWriteData() == null) {
            this.aZR.setWriteData(this.baB.hK(this.baB.Ms()));
        }
        if (this.aZR.getWriteData() != null) {
            this.aZR.getWriteData().setContent(this.aZO);
            this.aZR.getWriteData().setReplyId(this.baz);
            if (this.mPostId != null) {
                this.aZR.getWriteData().setRepostId(this.baB.Ms());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.aZR.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.aZR.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.aZR.getWriteData().setVoice(null);
                    this.aZR.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.aZR.getWriteData().setVoice(null);
                this.aZR.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.aZR.bEE()) {
                GC().showToast(e.j.write_img_limit);
            } else if (this.aZZ == null || !this.aZZ.Mu()) {
                if (this.aZY != null) {
                    this.aZY.Mv();
                }
                if (!this.aZR.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        MQ();
        this.aZR.cancelLoadData();
    }

    public void onStop() {
    }

    public void MQ() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.aZO);
        writeData.setReplyId(this.baz);
        writeData.setThreadId(this.mPostId);
        t.d(this.mPostId, writeData);
    }

    public void MR() {
        t.c(this.mPostId, (WriteData) null);
    }

    public void k(int i, String str) {
        if (AntiHelper.ai(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCM));
            }
        } else if (i == 230277 || i == 230278) {
            hT(str);
        } else {
            GC().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.aZO);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.aZV);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g fH;
        this.baE = antiData;
        if (antiData != null) {
            this.aZV = antiData.getVoice_message();
            if (!StringUtils.isNull(this.aZV) && LX() != null && (fH = LX().fH(6)) != null && !TextUtils.isEmpty(this.aZV)) {
                ((View) fH).setOnClickListener(this.baG);
            }
        }
    }

    private void hT(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(GC().getPageActivity());
        aVar.eB(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(GC()).BF();
    }

    private void u(ArrayList<String> arrayList) {
        if (LX() != null) {
            LX().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean MS() {
        return this.baC;
    }

    public void cz(boolean z) {
        this.baC = z;
    }

    public void hU(String str) {
        cz(true);
        LX().pN();
        if (str != null && str.length() != 0) {
            hW(GC().getResources().getString(e.j.reply_sub_floor).replace("%s", str));
        } else {
            hW("");
        }
        TiebaStatic.eventStat(GC().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void hV(String str) {
        cz(true);
        LX().pN();
        hW(str);
        TiebaStatic.eventStat(GC().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void MT() {
        cz(false);
        LX().hide();
    }

    public void MU() {
        cz(true);
        LX().pN();
        LX().aa((View) LX().fH(5));
    }

    public void MV() {
        cz(true);
        LX().pN();
        LX().aa((View) LX().fH(2));
    }

    public void MW() {
        cz(true);
        LX().pN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hW(String str) {
        if (LX() != null) {
            LX().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void hX(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(e.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ao.isEmpty(this.aZO) || this.aZO.matches(str2)) {
            if (this.baA != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.baA).lookingAt()) {
                    hV(this.baA);
                    return;
                } else {
                    hU(str);
                    return;
                }
            }
            hU(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.aZO);
        this.baA = this.aZO;
        if (matcher.lookingAt()) {
            hV(this.aZO);
        } else {
            hU(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(boolean z) {
        if (LX() != null) {
            LX().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.baD = dVar;
    }

    public void a(c cVar) {
        this.aZY = cVar;
    }

    public void a(b bVar) {
        this.aZZ = bVar;
    }

    public e MX() {
        if (this.baF == null && LX() != null) {
            this.baF = (e) LX().fK(27);
        }
        return this.baF;
    }
}
