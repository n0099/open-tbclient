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
import com.baidu.tbadk.coreExtra.data.x;
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
    private String baC;
    private NewWriteModel baF;
    private String baJ;
    private c baM;
    private b baN;
    private NewWriteModel.d baT;
    private String bbm;
    private String bbn;
    private DataModel<?> bbo;
    private boolean bbp;
    private NewWriteModel.d bbq;
    private AntiData bbr;
    private e bbs;
    private View.OnClickListener bbt;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.baC = "";
        this.bbm = "";
        this.bbn = null;
        this.bbp = false;
        this.baJ = null;
        this.baT = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (g.this.bbq != null) {
                    g.this.bbq.callback(z, postWriteCallBackData, xVar, writeData, antiData);
                }
                if (z) {
                    g.this.baC = null;
                    g.this.bbm = null;
                    g.this.cB(true);
                    g.this.Nj();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData writeData2 = g.this.baF.getWriteData();
                    g.this.baF.setWriteData(null);
                    g.this.baF.nD(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.bbo.MJ();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.al(i, str)) {
                    g.this.m(i, str);
                } else if (xVar != null && writeData != null && !StringUtils.isNull(xVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(xVar.getVcode_md5());
                    writeData.setVcodeUrl(xVar.getVcode_pic_url());
                    writeData.setVcodeExtra(xVar.Hl());
                    if (com.baidu.tbadk.r.a.jj(xVar.Hk())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(g.this.GQ().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, xVar.Hk())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(g.this.GQ().getPageActivity(), writeData, IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(g.this.mContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    g.this.GQ().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.g.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDp));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDp));
            }
        };
        this.bbt = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.baJ)) {
                    l.showToast(g.this.GQ().getPageActivity(), g.this.baJ);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.baC = writeData.getContent();
            im(this.baC);
        }
    }

    public void setContext(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public TbPageContext<?> GQ() {
        return this.mContext;
    }

    /* renamed from: if  reason: not valid java name */
    public void m18if(String str) {
        this.baC = str;
    }

    public void setReplyId(String str) {
        this.bbm = str;
    }

    public void b(DataModel<?> dataModel) {
        this.bbo = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.MK();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.baF = new NewWriteModel(tbPageContext);
            this.baF.b(this.baT);
            t.b(this.bbo.MK(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.baC = writeData.getContent();
                        g.this.im(g.this.baC);
                    }
                }
            });
        }
    }

    public boolean Nc() {
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
                    if (Mp() != null) {
                        Mp().hide();
                    }
                    Nj();
                    cB(true);
                    WriteData writeData = this.baF.getWriteData();
                    this.baF.setWriteData(null);
                    this.baF.nD(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.bbo.MJ();
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
                    if (this.bbq != null) {
                        this.bbq.callback(false, postWriteCallBackData, null, this.baF.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Nh() {
        if (this.baF.getWriteData() == null) {
            this.baF.setWriteData(this.bbo.hZ(this.bbo.MK()));
        }
        if (this.baF.getWriteData() != null) {
            this.baF.getWriteData().setContent(this.baC);
            this.baF.getWriteData().setReplyId(this.bbm);
            if (this.mPostId != null) {
                this.baF.getWriteData().setRepostId(this.bbo.MK());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.baF.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.baF.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.baF.getWriteData().setVoice(null);
                    this.baF.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.baF.getWriteData().setVoice(null);
                this.baF.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.baF.bGe()) {
                GQ().showToast(e.j.write_img_limit);
            } else if (this.baN == null || !this.baN.MM()) {
                if (this.baM != null) {
                    this.baM.MN();
                }
                if (!this.baF.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        Ni();
        this.baF.cancelLoadData();
    }

    public void onStop() {
    }

    public void Ni() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.baC);
        writeData.setReplyId(this.bbm);
        writeData.setThreadId(this.mPostId);
        t.d(this.mPostId, writeData);
    }

    public void Nj() {
        t.c(this.mPostId, (WriteData) null);
    }

    public void m(int i, String str) {
        if (AntiHelper.al(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDp));
            }
        } else if (i == 230277 || i == 230278) {
            ij(str);
        } else {
            GQ().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        pbEditorData.setContent(this.baC);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.baJ);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g fI;
        this.bbr = antiData;
        if (antiData != null) {
            this.baJ = antiData.getVoice_message();
            if (!StringUtils.isNull(this.baJ) && Mp() != null && (fI = Mp().fI(6)) != null && !TextUtils.isEmpty(this.baJ)) {
                ((View) fI).setOnClickListener(this.bbt);
            }
        }
    }

    private void ij(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(GQ().getPageActivity());
        aVar.eK(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.g.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(GQ()).BS();
    }

    private void u(ArrayList<String> arrayList) {
        if (Mp() != null) {
            Mp().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean Nk() {
        return this.bbp;
    }

    public void cC(boolean z) {
        this.bbp = z;
    }

    public void ik(String str) {
        cC(true);
        Mp().pR();
        if (str != null && str.length() != 0) {
            im(GQ().getResources().getString(e.j.reply_sub_floor).replace("%s", str));
        } else {
            im("");
        }
        TiebaStatic.eventStat(GQ().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void il(String str) {
        cC(true);
        Mp().pR();
        im(str);
        TiebaStatic.eventStat(GQ().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Nl() {
        cC(false);
        Mp().hide();
    }

    public void Nm() {
        cC(true);
        Mp().pR();
        Mp().aa((View) Mp().fI(5));
    }

    public void Nn() {
        cC(true);
        Mp().pR();
        Mp().aa((View) Mp().fI(2));
    }

    public void No() {
        cC(true);
        Mp().pR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im(String str) {
        if (Mp() != null) {
            Mp().b(new com.baidu.tbadk.editortools.a(6, 27, str));
        }
    }

    public void in(String str) {
        String string = TbadkCoreApplication.getInst().getResources().getString(e.j.reply_sub_floor);
        String str2 = "^" + string.replace("%s", ".+") + "$";
        if (ao.isEmpty(this.baC) || this.baC.matches(str2)) {
            if (this.bbn != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.bbn).lookingAt()) {
                    il(this.bbn);
                    return;
                } else {
                    ik(str);
                    return;
                }
            }
            ik(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.baC);
        this.bbn = this.baC;
        if (matcher.lookingAt()) {
            il(this.baC);
        } else {
            ik(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(boolean z) {
        if (Mp() != null) {
            Mp().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.bbq = dVar;
    }

    public void a(c cVar) {
        this.baM = cVar;
    }

    public void a(b bVar) {
        this.baN = bVar;
    }

    public e Np() {
        if (this.bbs == null && Mp() != null) {
            this.bbs = (e) Mp().fL(27);
        }
        return this.bbs;
    }
}
