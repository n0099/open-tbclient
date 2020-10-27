package com.baidu.tbadk.editortools.pb;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends com.baidu.tbadk.editortools.e {
    private bw akq;
    private TbPageContext<?> eCn;
    private NewWriteModel fjQ;
    private String fjU;
    private c fjX;
    private b fjY;
    private String fkA;
    private DataModel<?> fkB;
    private boolean fkC;
    private NewWriteModel.d fkD;
    private f fkE;
    private x.a fkF;
    private View.OnClickListener fkG;
    private NewWriteModel.d fke;
    private j fkz;
    public boolean isBJH;
    public int mFrom;
    private AntiHelper.a mInjectListener;
    private String mPostId;
    private SpanGroupManager mSpanGroupManager;
    private VoiceData.VoiceModel mVoiceModel;

    public h(EditorTools editorTools) {
        super(editorTools);
        this.fkA = "";
        this.fkC = false;
        this.fjU = null;
        this.mFrom = 0;
        this.fke = new NewWriteModel.d() { // from class: com.baidu.tbadk.editortools.pb.h.1
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (h.this.fkD != null) {
                    h.this.fkD.callback(z, postWriteCallBackData, ahVar, writeData, antiData);
                }
                if (z) {
                    h.this.fkz = null;
                    h.this.fkA = null;
                    h.this.kd(true);
                    h.this.bye();
                }
                int i = -1;
                String str = "";
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z) {
                    WriteData cVv = h.this.fjQ.cVv();
                    h.this.fjQ.e((WriteData) null);
                    h.this.fjQ.xp(false);
                    h.this.mVoiceModel = null;
                    if (cVv != null && cVv != null && cVv.getType() == 2) {
                        h.this.fkB.bxz();
                    }
                } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.bN(i, str)) {
                    h.this.aE(i, str);
                } else if (ahVar != null && writeData != null && !StringUtils.isNull(ahVar.getVcode_pic_url())) {
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bsw());
                    if (h.this.akq != null) {
                        writeData.setBaijiahaoData(h.this.akq.getBaijiahaoData());
                    }
                    if (com.baidu.tbadk.t.a.Eq(ahVar.bsv())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(h.this.bsc().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bsv())));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(h.this.bsc().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                    }
                } else if (postWriteCallBackData != null && i == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(h.this.eCn.getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                } else if (i != 238010) {
                    h.this.bsc().showToast(str);
                }
            }
        };
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tbadk.editortools.pb.h.2
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aj("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        };
        this.fkG = new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TextUtils.isEmpty(h.this.fjU)) {
                    l.showToast(h.this.bsc().getPageActivity(), h.this.fjU);
                }
            }
        };
    }

    public void b(WriteData writeData) {
        if (writeData != null) {
            if (this.fkz == null) {
                this.fkz = new j();
            }
            this.fkz.mContent = writeData.getContent();
            this.fkz.fkL = writeData.getSubPbReplyPrefix();
            c(this.fkz);
        }
    }

    public void a(TbPageContext<?> tbPageContext) {
        this.eCn = tbPageContext;
    }

    public TbPageContext<?> bsc() {
        return this.eCn;
    }

    public void setThreadData(bw bwVar) {
        this.akq = bwVar;
    }

    public void DB(String str) {
        if (this.fkz == null) {
            this.fkz = new j();
        }
        this.fkz.mContent = str;
    }

    public void a(j jVar) {
        this.fkz = jVar;
    }

    public void reset() {
        this.fjQ.e((WriteData) null);
        this.fjQ.xp(false);
        this.mVoiceModel = null;
    }

    public void a(x.a aVar) {
        this.fkF = aVar;
    }

    public void setReplyId(String str) {
        this.fkA = str;
    }

    public void b(DataModel<?> dataModel) {
        this.fkB = dataModel;
        if (dataModel != null) {
            this.mPostId = dataModel.bxA();
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null) {
            this.fjQ = new NewWriteModel(tbPageContext);
            this.fjQ.b(this.fke);
            x.b(this.fkB.bxA(), new x.a() { // from class: com.baidu.tbadk.editortools.pb.h.3
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                        if (h.this.fkz == null) {
                            h.this.fkz = new j();
                        }
                        h.this.fkz.mContent = writeData.getContent();
                        h.this.fkz.fkL = writeData.getSubPbReplyPrefix();
                        h.this.c(h.this.fkz);
                    }
                    if (h.this.fkF != null) {
                        h.this.fkF.a(writeData);
                    }
                }
            });
        }
    }

    public boolean bxU() {
        return (this.mVoiceModel == null || TextUtils.isEmpty(this.mVoiceModel.voiceId) || this.mVoiceModel.duration <= 0) ? false : true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_SUB_PB_AT_SELECT /* 12005 */:
                    if (intent != null && (stringArrayListExtra = intent.getStringArrayListExtra("name_show")) != null) {
                        N(stringArrayListExtra);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (bwY() != null) {
                        bwY().hide();
                    }
                    bye();
                    kd(true);
                    WriteData cVv = this.fjQ.cVv();
                    this.fjQ.e((WriteData) null);
                    this.fjQ.xp(false);
                    if (cVv != null && cVv != null && cVv.getType() == 2) {
                        this.fkB.bxz();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    PostWriteCallBackData postWriteCallBackData = (intent == null || !(intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    if (this.fkD != null) {
                        this.fkD.callback(false, postWriteCallBackData, null, this.fjQ.cVv(), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void byc() {
        if (this.fjQ.cVv() == null) {
            WriteData Dw = this.fkB.Dw(this.fkB.bxA());
            if (Dw != null && this.akq != null) {
                Dw.setBaijiahaoData(this.akq.getBaijiahaoData());
            }
            this.fjQ.e(Dw);
        }
        if (this.fjQ.cVv() != null) {
            this.fjQ.setSpanGroupManager(this.mSpanGroupManager);
            if (this.fkz != null) {
                this.fjQ.cVv().setContent(this.fkz.mContent);
                this.fjQ.cVv().setSubPbReplyPrefix(this.fkz.fkL);
                if (this.akq != null) {
                    this.fjQ.cVv().setBaijiahaoData(this.akq.getBaijiahaoData());
                }
            }
            this.fjQ.cVv().setReplyId(this.fkA);
            if (this.mPostId != null) {
                this.fjQ.cVv().setRepostId(this.fkB.bxA());
            }
            if (this.mVoiceModel != null) {
                if (this.mVoiceModel.getId() != null) {
                    this.fjQ.cVv().setVoice(this.mVoiceModel.getId());
                    this.fjQ.cVv().setVoiceDuringTime(this.mVoiceModel.duration);
                } else {
                    this.fjQ.cVv().setVoice(null);
                    this.fjQ.cVv().setVoiceDuringTime(-1);
                }
            } else {
                this.fjQ.cVv().setVoice(null);
                this.fjQ.cVv().setVoiceDuringTime(-1);
            }
            if (!this.fjQ.dIN()) {
                bsc().showToast(R.string.write_img_limit);
            } else if (this.fjY == null || !this.fjY.bxC()) {
                if (this.fjX != null) {
                    this.fjX.bxD();
                }
                c(this.fjQ.cVv());
                if (!this.fjQ.dIK()) {
                }
            }
        }
    }

    public void onDestory() {
        byd();
        this.fjQ.cancelLoadData();
    }

    public void onStop() {
    }

    public void byd() {
        WriteData writeData = new WriteData(2);
        if (this.fkz != null) {
            writeData.setContent(this.fkz.mContent);
            writeData.setSubPbReplyPrefix(this.fkz.fkL);
        }
        writeData.setReplyId(this.fkA);
        writeData.setThreadId(this.mPostId);
        x.g(this.mPostId, writeData);
    }

    public void bye() {
        x.f(this.mPostId, (WriteData) null);
    }

    public void aE(int i, String str) {
        if (AntiHelper.bN(i, str)) {
            if (AntiHelper.a(this.eCn.getPageActivity(), str, i, this.mInjectListener) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aj("obj_locate", ax.a.LOCATE_REPLY_SUB_PB));
            }
        } else if (i == 230277 || i == 230278) {
            DF(str);
        } else {
            bsc().showToast(str);
        }
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        PbEditorData pbEditorData = new PbEditorData();
        pbEditorData.setEditorType(1);
        if (this.fkz != null) {
            pbEditorData.setContent(this.fkz.mContent);
            pbEditorData.setSubPbReplyPrefix(this.fkz.fkL);
        }
        pbEditorData.setVoiceModel(this.mVoiceModel);
        pbEditorData.setThreadData(new PbEditorData.ThreadData());
        pbEditorData.setDisableVoiceMessage(this.fjU);
        pbEditorData.setOpenVoiceRecordButton(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbFullScreenEditorActivityConfig(this.eCn.getPageActivity(), RequestResponseCode.REQUEST_PB_FULL_SCREEN_EDITOR, pbEditorData, postWriteCallBackData)));
    }

    public void a(AntiData antiData) {
        com.baidu.tbadk.editortools.h qX;
        if (antiData != null) {
            this.fjU = antiData.getVoice_message();
            if (!StringUtils.isNull(this.fjU) && bwY() != null && (qX = bwY().qX(6)) != null && !TextUtils.isEmpty(this.fjU)) {
                ((View) qX).setOnClickListener(this.fkG);
            }
        }
    }

    private void DF(String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(bsc().getPageActivity());
        aVar.Ba(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.editortools.pb.h.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(bsc()).bmC();
    }

    private void N(ArrayList<String> arrayList) {
        if (bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(17, 27, arrayList));
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public boolean byf() {
        return this.fkC;
    }

    public void kf(boolean z) {
        this.fkC = z;
    }

    public void DG(String str) {
        kf(true);
        bwY().display();
        if (str != null && str.length() != 0) {
            String replace = bsc().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            j jVar = new j();
            jVar.fkL = replace;
            c(jVar);
        } else {
            j jVar2 = new j();
            jVar2.mContent = "";
            c(jVar2);
        }
        TiebaStatic.eventStat(bsc().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    private void b(j jVar) {
        kf(true);
        bwY().display();
        c(jVar);
        TiebaStatic.eventStat(bsc().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void byg() {
        kf(false);
        bwY().hide();
    }

    public void byh() {
        kf(true);
        bwY().display();
        bwY().bw((View) bwY().qX(5));
    }

    public void byi() {
        kf(true);
        bwY().display();
        bwY().bw((View) bwY().qX(2));
    }

    public void byj() {
        kf(true);
        bwY().display();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(6, 27, jVar));
        }
    }

    public void DH(String str) {
        if (str != null) {
            String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
            if (this.fkz != null) {
                if (TextUtils.isEmpty(this.fkz.fkL) && TextUtils.isEmpty(this.fkz.mContent)) {
                    DG(str);
                    return;
                } else if (!TextUtils.isEmpty(this.fkz.fkL) && this.fkz.fkL.equals(replace)) {
                    b(this.fkz);
                    return;
                } else {
                    DG(str);
                    return;
                }
            }
            DG(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        if (bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    public void b(NewWriteModel.d dVar) {
        this.fkD = dVar;
    }

    public void a(c cVar) {
        this.fjX = cVar;
    }

    public void a(b bVar) {
        this.fjY = bVar;
    }

    public f byk() {
        if (this.fkE == null && bwY() != null) {
            this.fkE = (f) bwY().ra(27);
        }
        return this.fkE;
    }

    public boolean byl() {
        return (this.fkz == null || at.isEmpty(this.fkz.mContent)) ? false : true;
    }

    public void setSpanGroupManager(SpanGroupManager spanGroupManager) {
        this.mSpanGroupManager = spanGroupManager;
    }

    public void DI(String str) {
        if (!StringUtils.isNull(str) && bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(45, 27, str));
        }
    }

    public void c(WriteData writeData) {
        int i = 0;
        if (writeData != null) {
            if (!TextUtils.isEmpty(writeData.getContent())) {
                int i2 = 0;
                while (aw.eIh.matcher(writeData.getContent()).find()) {
                    i2++;
                }
                if (i2 > 0 && this.mFrom > 0) {
                    aq aqVar = new aq("c13990");
                    aqVar.aj("obj_type", i2);
                    aqVar.aj("obj_source", this.mFrom);
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar);
                }
            }
            if (writeData.getWriteImagesInfo() != null && !y.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
                for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                    if (imageFileInfo.getImageType() == 1) {
                        i++;
                    }
                }
                if (i > 0 && this.mFrom > 0) {
                    aq aqVar2 = new aq("c13991");
                    aqVar2.aj("obj_type", i);
                    aqVar2.aj("obj_source", this.mFrom);
                    aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dR("tid", writeData.getThreadId());
                    TiebaStatic.log(aqVar2);
                }
            }
        }
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}
