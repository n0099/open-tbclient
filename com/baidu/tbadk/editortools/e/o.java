package com.baidu.tbadk.editortools.e;

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
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ n awg;
    private final /* synthetic */ e awh;
    private final /* synthetic */ com.baidu.tbadk.editortools.l awi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, com.baidu.tbadk.editortools.l lVar) {
        this.awg = nVar;
        this.awh = eVar;
        this.awi = lVar;
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
        if (this.awh != null && this.awh.CG() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.awh.fH((String) aVar.data);
                    this.awg.awe = false;
                    return;
                case 5:
                    if (!this.awi.CJ()) {
                        TiebaStatic.eventStat(this.awi.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                case r.l.PullToRefresh_adapterViewBackground /* 38 */:
                case r.l.PullToRefresh_headerBackground /* 39 */:
                case r.l.PullToRefresh_mode /* 41 */:
                case 42:
                default:
                    return;
                case 7:
                    this.awh.getContext().showToast(r.j.over_limit_tip);
                    this.awg.awe = true;
                    return;
                case 8:
                    b2 = this.awg.b(this.awh.getContext().getPageContext(), 11001);
                    if (b2) {
                        this.awh.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.awh.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.awi.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.awh.setVoiceModel(null);
                    this.awi.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.awh.getWriteImagesInfo().getChosedFiles() == null || this.awh.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.awh.getContext().getActivity(), this.awh.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.awg.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.awg.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.awg.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.awg.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (b.Dh().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.awh.eH(1);
                            if (this.awh.getWriteImagesInfo() != null) {
                                this.awh.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.awh.eH(10);
                            if (this.awh.getWriteImagesInfo() != null) {
                                this.awh.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.awh.DB();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.awh.getWriteImagesInfo() != null && this.awh.getWriteImagesInfo().getChosedFiles() != null && (size = this.awh.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.awh.getContext().getActivity(), 12012, this.awh.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.awg.awe;
                    if (z) {
                        this.awh.getContext().showToast(r.j.over_limit_tip);
                    }
                    b3 = this.awg.b(this.awh.getContext().getPageContext(), 11025);
                    if (b3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.awh.getContext().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.awh.Dq();
                        return;
                    }
                    switch (this.awh.Dx()) {
                        case 0:
                            this.awh.Do();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.awh.Dn();
                            return;
                    }
                case 20:
                    this.awh.CG().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.bkv().setNoLongerShowAddress(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.awh.getBaobaoImagesInfo() == null || this.awh.getBaobaoImagesInfo().getChosedFiles() == null || this.awh.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.bjc();
                        if (TbadkCoreApplication.getCurrentMemberType() == 0 && !com.baidu.tieba.tbadkCore.PbEditor.a.bjb()) {
                            this.awh.getContext().showToast(r.j.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.awh.getContext().getActivity());
                        intentConfig.getIntent().putExtra(VrPlayerActivityConfig.TITLE, this.awh.getContext().getResources().getString(r.j.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.awh.getContext().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.awh.DD();
                    return;
                case 23:
                    if (this.awh.getBaobaoImagesInfo() != null && this.awh.getBaobaoImagesInfo().size() > 0) {
                        this.awh.Dw().setIsBaobao(true);
                        return;
                    } else {
                        this.awh.Dw().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.awh.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.awh.CG().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.awh.getContext() != null && this.awh.getContext().getResources() != null) {
                        Resources resources = this.awh.getContext().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.awh.getContext().getPageContext(), resources.getString(r.j.plugin_video_not_active), resources.getString(r.j.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.awh.getContext().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.awh.getContext().getPageContext(), resources.getString(r.j.plugin_video_install_tips), resources.getString(r.j.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case 29:
                    this.awh.CG().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.awh.CG().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.awh.Ds();
                    return;
                case 32:
                    this.awh.CG().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    b = this.awg.b(this.awh.getContext().getPageContext(), 11040);
                    if (b) {
                        this.awh.Dm();
                        return;
                    }
                    return;
                case r.l.PullToRefresh_headerTextColor /* 40 */:
                    if ((aVar.data instanceof String) || aVar.data == null) {
                        this.awh.setGraffitiFileName((String) aVar.data);
                        return;
                    }
                    return;
                case 43:
                    if (!com.baidu.tbadk.plugins.a.f(this.awh.getContext().getPageContext())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(this.awh.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                        return;
                    }
                    return;
            }
        }
    }
}
