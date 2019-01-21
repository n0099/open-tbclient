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
    private String baD;
    private NewWriteModel baG;
    private String baK;
    private c baN;
    private b baO;
    private NewWriteModel.d baU;
    private String bbn;
    private String bbo;
    private DataModel<?> bbp;
    private boolean bbq;
    private NewWriteModel.d bbr;
    private AntiData bbs;
    private e bbt;
    private View.OnClickListener bbu;
    private TbPageContext<?> mContext;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private VoiceData.VoiceModel mVoiceModel;

    public g(EditorTools editorTools) {
        super(editorTools);
        this.baD = "";
        this.bbn = "";
        this.bbo = null;
        this.bbq = false;
        this.baK = null;
        this.baU = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.g.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (g.this.bbr != null) {
                    g.this.bbr.callback(z, postWriteCallBackData, xVar, writeData, antiData);
                }
                if (z) {
                    g.this.baD = null;
                    g.this.bbn = null;
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
                    WriteData writeData2 = g.this.baG.getWriteData();
                    g.this.baG.setWriteData(null);
                    g.this.baG.nD(false);
                    g.this.mVoiceModel = null;
                    if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                        g.this.bbp.MJ();
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
                TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDq));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDq));
            }
        };
        this.bbu = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.baK)) {
                    l.showToast(g.this.GQ().getPageActivity(), g.this.baK);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            this.baD = writeData.getContent();
            im(this.baD);
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
        this.baD = str;
    }

    public void setReplyId(String str) {
        this.bbn = str;
    }

    public void b(DataModel<?> dataModel) {
        this.bbp = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.MK();
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.baG = new NewWriteModel(tbPageContext);
            this.baG.b(this.baU);
            t.b(this.bbp.MK(), new t.a() { // from class: com.baidu.tbadk.editortools.pb.g.3
                @Override // com.baidu.tieba.tbadkCore.t.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        g.this.baD = writeData.getContent();
                        g.this.im(g.this.baD);
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
                    WriteData writeData = this.baG.getWriteData();
                    this.baG.setWriteData(null);
                    this.baG.nD(false);
                    if (writeData != null && writeData != null && writeData.getType() == 2) {
                        this.bbp.MJ();
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
                    if (this.bbr != null) {
                        this.bbr.callback(false, postWriteCallBackData, null, this.baG.getWriteData(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void Nh() {
        if (this.baG.getWriteData() == null) {
            this.baG.setWriteData(this.bbp.hZ(this.bbp.MK()));
        }
        if (this.baG.getWriteData() != null) {
            this.baG.getWriteData().setContent(this.baD);
            this.baG.getWriteData().setReplyId(this.bbn);
            if (this.mPostId != null) {
                this.baG.getWriteData().setRepostId(this.bbp.MK());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.baG.getWriteData().setVoice(this.mVoiceModel.getId());
                    this.baG.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.baG.getWriteData().setVoice(null);
                    this.baG.getWriteData().setVoiceDuringTime(-1);
                }
            } else {
                this.baG.getWriteData().setVoice(null);
                this.baG.getWriteData().setVoiceDuringTime(-1);
            }
            if (!this.baG.bGe()) {
                GQ().showToast(e.j.write_img_limit);
            } else if (this.baO == null || !this.baO.MM()) {
                if (this.baN != null) {
                    this.baN.MN();
                }
                if (!this.baG.startPostWrite()) {
                }
            }
        }
    }

    public void onDestory() {
        Ni();
        this.baG.cancelLoadData();
    }

    public void onStop() {
    }

    public void Ni() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.baD);
        writeData.setReplyId(this.bbn);
        writeData.setThreadId(this.mPostId);
        t.d(this.mPostId, writeData);
    }

    public void Nj() {
        t.c(this.mPostId, (WriteData) null);
    }

    public void m(int i, String str) {
        if (AntiHelper.al(i, str)) {
            if (AntiHelper.a(this.mContext.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDq));
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
        pbEditorData.setContent(this.baD);
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.baK);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.mContext.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.g fI;
        this.bbs = antiData;
        if (antiData != null) {
            this.baK = antiData.getVoice_message();
            if (!StringUtils.isNull(this.baK) && Mp() != null && (fI = Mp().fI(6)) != null && !TextUtils.isEmpty(this.baK)) {
                ((View) fI).setOnClickListener(this.bbu);
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
        return this.bbq;
    }

    public void cC(boolean z) {
        this.bbq = z;
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
        if (ao.isEmpty(this.baD) || this.baD.matches(str2)) {
            if (this.bbo != null) {
                if (Pattern.compile(string.replace("%s", str)).matcher(this.bbo).lookingAt()) {
                    il(this.bbo);
                    return;
                } else {
                    ik(str);
                    return;
                }
            }
            ik(str);
            return;
        }
        Matcher matcher = Pattern.compile(string.replace("%s", str)).matcher(this.baD);
        this.bbo = this.baD;
        if (matcher.lookingAt()) {
            il(this.baD);
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
        this.bbr = dVar;
    }

    public void a(c cVar) {
        this.baN = cVar;
    }

    public void a(b bVar) {
        this.baO = bVar;
    }

    public e Np() {
        if (this.bbt == null && Mp() != null) {
            this.bbt = (e) Mp().fL(27);
        }
        return this.bbt;
    }
}
