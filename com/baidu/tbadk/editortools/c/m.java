package com.baidu.tbadk.editortools.c;

import android.content.res.Resources;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ l atR;
    private final /* synthetic */ d atS;
    private final /* synthetic */ com.baidu.tbadk.editortools.j atT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, d dVar, com.baidu.tbadk.editortools.j jVar) {
        this.atR = lVar;
        this.atS = dVar;
        this.atT = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        int size;
        boolean z;
        boolean b2;
        if (this.atS != null && this.atS.AL() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.atS.eU((String) aVar.data);
                    this.atR.atP = false;
                    return;
                case 5:
                    if (!this.atT.AO()) {
                        TiebaStatic.eventStat(this.atT.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                default:
                    return;
                case 7:
                    this.atS.BI().showToast(i.h.over_limit_tip);
                    this.atR.atP = true;
                    return;
                case 8:
                    b = this.atR.b(this.atS.BI().getPageContext(), 11001);
                    if (b) {
                        this.atS.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.atS.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.atT.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.atS.setVoiceModel(null);
                    this.atT.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.atS.getWriteImagesInfo().getChosedFiles() == null || this.atS.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.atS.BI().getActivity(), this.atS.getWriteImagesInfo().toJsonString(), String.valueOf(System.currentTimeMillis()));
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.atS.BO();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.atS.getWriteImagesInfo() != null && this.atS.getWriteImagesInfo().getChosedFiles() != null && (size = this.atS.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.atS.BI().getActivity(), 12012, this.atS.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.atR.atP;
                    if (z) {
                        this.atS.BI().showToast(i.h.over_limit_tip);
                    }
                    b2 = this.atR.b(this.atS.BI().getPageContext(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.atS.BI().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.atS.BD();
                        return;
                    }
                    switch (this.atS.BK()) {
                        case 0:
                            this.atS.BB();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.atS.BA();
                            return;
                    }
                case 20:
                    this.atS.AL().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.auQ().gk(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.atS.getBaobaoImagesInfo() == null || this.atS.getBaobaoImagesInfo().getChosedFiles() == null || this.atS.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.atK();
                        if (TbadkCoreApplication.getCurrentMemberType() == 0 && !com.baidu.tieba.tbadkCore.PbEditor.a.atJ()) {
                            this.atS.BI().showToast(i.h.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.atS.BI().getActivity());
                        intentConfig.getIntent().putExtra("title", this.atS.BI().getResources().getString(i.h.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.atS.BI().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.atS.BQ();
                    return;
                case 23:
                    if (this.atS.getBaobaoImagesInfo() != null && this.atS.getBaobaoImagesInfo().size() > 0) {
                        this.atS.BJ().setIsBaobao(true);
                        return;
                    } else {
                        this.atS.BJ().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.atS.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.atS.AL().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.atS.BI() != null && this.atS.BI().getResources() != null) {
                        Resources resources = this.atS.BI().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.atS.BI().getPageContext(), resources.getString(i.h.plugin_video_not_active), resources.getString(i.h.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.atS.BI().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.atS.BI().getPageContext(), resources.getString(i.h.plugin_video_install_tips), resources.getString(i.h.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.atS.AL().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.atS.AL().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.atS.BF();
                    return;
            }
        }
    }
}
