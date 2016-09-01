package com.baidu.tbadk.editortools.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ n awD;
    private final /* synthetic */ e awE;
    private final /* synthetic */ com.baidu.tbadk.editortools.l awF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, com.baidu.tbadk.editortools.l lVar) {
        this.awD = nVar;
        this.awE = eVar;
        this.awF = lVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        boolean b2;
        int size;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        boolean b3;
        if (this.awE != null && this.awE.CG() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.awE.fE((String) aVar.data);
                    this.awD.awB = false;
                    return;
                case 5:
                    if (!this.awF.CJ()) {
                        TiebaStatic.eventStat(this.awF.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
                        return;
                    }
                    return;
                case 6:
                case 9:
                case 12:
                case 13:
                case 17:
                case 19:
                case 22:
                case 24:
                case 25:
                case 26:
                case 28:
                case 30:
                case 31:
                case 33:
                case 34:
                case 35:
                case 37:
                case t.l.PullToRefresh_adapterViewBackground /* 38 */:
                case t.l.PullToRefresh_headerBackground /* 39 */:
                default:
                    return;
                case 7:
                    this.awE.getContext().showToast(t.j.over_limit_tip);
                    this.awD.awB = true;
                    return;
                case 8:
                    b2 = this.awD.b(this.awE.getContext().getPageContext(), 11001);
                    if (b2) {
                        this.awE.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.awE.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.awF.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.awE.setVoiceModel(null);
                    this.awF.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.awE.getWriteImagesInfo().getChosedFiles() == null || this.awE.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.awE.getContext().getActivity(), this.awE.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.awD.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.awD.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.awD.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.awD.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (b.Dh().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.awE.eI(1);
                            if (this.awE.getWriteImagesInfo() != null) {
                                this.awE.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.awE.eI(10);
                            if (this.awE.getWriteImagesInfo() != null) {
                                this.awE.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.awE.DB();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.awE.getWriteImagesInfo() != null && this.awE.getWriteImagesInfo().getChosedFiles() != null && (size = this.awE.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.awE.getContext().getActivity(), 12012, this.awE.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.awD.awB;
                    if (z) {
                        this.awE.getContext().showToast(t.j.over_limit_tip);
                    }
                    b3 = this.awD.b(this.awE.getContext().getPageContext(), 11025);
                    if (b3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.awE.getContext().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.awE.Dq();
                        return;
                    }
                    switch (this.awE.Dx()) {
                        case 0:
                            this.awE.Do();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.awE.Dn();
                            return;
                    }
                case 20:
                    this.awE.CG().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.bjJ().setNoLongerShowAddress(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.awE.getBaobaoImagesInfo() == null || this.awE.getBaobaoImagesInfo().getChosedFiles() == null || this.awE.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.bir();
                        if (TbadkCoreApplication.getCurrentMemberType() == 0 && !com.baidu.tieba.tbadkCore.PbEditor.a.biq()) {
                            this.awE.getContext().showToast(t.j.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.awE.getContext().getActivity());
                        intentConfig.getIntent().putExtra(VrPlayerActivityConfig.TITLE, this.awE.getContext().getResources().getString(t.j.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.awE.getContext().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.awE.DD();
                    return;
                case 23:
                    if (this.awE.getBaobaoImagesInfo() != null && this.awE.getBaobaoImagesInfo().size() > 0) {
                        this.awE.Dw().setIsBaobao(true);
                        return;
                    } else {
                        this.awE.Dw().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.awE.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.awE.CG().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.awE.getContext() != null && this.awE.getContext().getResources() != null) {
                        Resources resources = this.awE.getContext().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.awE.getContext().getPageContext(), resources.getString(t.j.plugin_video_not_active), resources.getString(t.j.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.awE.getContext().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.awE.getContext().getPageContext(), resources.getString(t.j.plugin_video_install_tips), resources.getString(t.j.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case 29:
                    this.awE.CG().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.awE.CG().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.awE.Ds();
                    return;
                case 32:
                    this.awE.CG().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    b = this.awD.b(this.awE.getContext().getPageContext(), 11040);
                    if (b) {
                        this.awE.Dm();
                        return;
                    }
                    return;
                case t.l.PullToRefresh_headerTextColor /* 40 */:
                    if ((aVar.data instanceof String) || aVar.data == null) {
                        this.awE.setGraffitiFileName((String) aVar.data);
                        return;
                    }
                    return;
            }
        }
    }
}
