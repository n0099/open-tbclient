package com.baidu.tbadk.editortools.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ n asH;
    private final /* synthetic */ e asI;
    private final /* synthetic */ com.baidu.tbadk.editortools.l asJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, com.baidu.tbadk.editortools.l lVar) {
        this.asH = nVar;
        this.asI = eVar;
        this.asJ = lVar;
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
        if (this.asI != null && this.asI.Bl() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.asI.fD((String) aVar.data);
                    this.asH.asF = false;
                    return;
                case 5:
                    if (!this.asJ.Bo()) {
                        TiebaStatic.eventStat(this.asJ.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                case TbConfig.NOTIFY_FANS_NEW_ID /* 26 */:
                case 28:
                case 30:
                case 31:
                case DealIntentService.CLASS_TYPE_MY_COLLECT_UPDATE /* 33 */:
                case 34:
                case TbConfig.FRS_NOABSTRACT_ITEM_NUMBER /* 35 */:
                case 37:
                case 38:
                case 39:
                default:
                    return;
                case 7:
                    this.asI.getContext().showToast(u.j.over_limit_tip);
                    this.asH.asF = true;
                    return;
                case 8:
                    b2 = this.asH.b(this.asI.getContext().getPageContext(), 11001);
                    if (b2) {
                        this.asI.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.asI.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.asJ.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.asI.setVoiceModel(null);
                    this.asJ.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.asI.getWriteImagesInfo().getChosedFiles() == null || this.asI.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.asI.getContext().getActivity(), this.asI.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.asH.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.asH.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.asH.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.asH.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (b.BM().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.asI.eu(1);
                            if (this.asI.getWriteImagesInfo() != null) {
                                this.asI.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.asI.eu(10);
                            if (this.asI.getWriteImagesInfo() != null) {
                                this.asI.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.asI.Cg();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.asI.getWriteImagesInfo() != null && this.asI.getWriteImagesInfo().getChosedFiles() != null && (size = this.asI.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.asI.getContext().getActivity(), 12012, this.asI.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.asH.asF;
                    if (z) {
                        this.asI.getContext().showToast(u.j.over_limit_tip);
                    }
                    b3 = this.asH.b(this.asI.getContext().getPageContext(), 11025);
                    if (b3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asI.getContext().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.asI.BV();
                        return;
                    }
                    switch (this.asI.Cc()) {
                        case 0:
                            this.asI.BT();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.asI.BS();
                            return;
                    }
                case 20:
                    this.asI.Bl().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.bcT().setNoLongerShowAddress(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.asI.getBaobaoImagesInfo() == null || this.asI.getBaobaoImagesInfo().getChosedFiles() == null || this.asI.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.bbx();
                        if (TbadkCoreApplication.getCurrentMemberType() == 0 && !com.baidu.tieba.tbadkCore.PbEditor.a.bbw()) {
                            this.asI.getContext().showToast(u.j.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.asI.getContext().getActivity());
                        intentConfig.getIntent().putExtra("title", this.asI.getContext().getResources().getString(u.j.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.asI.getContext().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.asI.Ci();
                    return;
                case 23:
                    if (this.asI.getBaobaoImagesInfo() != null && this.asI.getBaobaoImagesInfo().size() > 0) {
                        this.asI.Cb().setIsBaobao(true);
                        return;
                    } else {
                        this.asI.Cb().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.asI.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.asI.Bl().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.asI.getContext() != null && this.asI.getContext().getResources() != null) {
                        Resources resources = this.asI.getContext().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.asI.getContext().getPageContext(), resources.getString(u.j.plugin_video_not_active), resources.getString(u.j.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.asI.getContext().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.asI.getContext().getPageContext(), resources.getString(u.j.plugin_video_install_tips), resources.getString(u.j.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case 29:
                    this.asI.Bl().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.asI.Bl().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.asI.BX();
                    return;
                case 32:
                    this.asI.Bl().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    b = this.asH.b(this.asI.getContext().getPageContext(), 11040);
                    if (b) {
                        this.asI.BR();
                        return;
                    }
                    return;
                case 40:
                    if ((aVar.data instanceof String) || aVar.data == null) {
                        this.asI.setGraffitiFileName((String) aVar.data);
                        return;
                    }
                    return;
            }
        }
    }
}
