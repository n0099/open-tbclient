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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ n avS;
    private final /* synthetic */ e avT;
    private final /* synthetic */ com.baidu.tbadk.editortools.l avU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, com.baidu.tbadk.editortools.l lVar) {
        this.avS = nVar;
        this.avT = eVar;
        this.avU = lVar;
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
        if (this.avT != null && this.avT.Dh() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.avT.fA((String) aVar.data);
                    this.avS.avQ = false;
                    return;
                case 5:
                    if (!this.avU.Dk()) {
                        TiebaStatic.eventStat(this.avU.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                case DealIntentService.CLASS_TYPE_MY_COLLECT_UPDATE /* 33 */:
                case 34:
                case TbConfig.FRS_NOABSTRACT_ITEM_NUMBER /* 35 */:
                case 37:
                case 38:
                case 39:
                default:
                    return;
                case 7:
                    this.avT.DY().showToast(t.j.over_limit_tip);
                    this.avS.avQ = true;
                    return;
                case 8:
                    b2 = this.avS.b(this.avT.DY().getPageContext(), 11001);
                    if (b2) {
                        this.avT.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.avT.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.avU.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.avT.setVoiceModel(null);
                    this.avU.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.avT.getWriteImagesInfo().getChosedFiles() == null || this.avT.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.avT.DY().getActivity(), this.avT.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.avS.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.avS.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.avS.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.avS.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (b.DI().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.avT.eK(1);
                            if (this.avT.getWriteImagesInfo() != null) {
                                this.avT.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.avT.eK(10);
                            if (this.avT.getWriteImagesInfo() != null) {
                                this.avT.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.avT.Ee();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.avT.getWriteImagesInfo() != null && this.avT.getWriteImagesInfo().getChosedFiles() != null && (size = this.avT.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.avT.DY().getActivity(), 12012, this.avT.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.avS.avQ;
                    if (z) {
                        this.avT.DY().showToast(t.j.over_limit_tip);
                    }
                    b3 = this.avS.b(this.avT.DY().getPageContext(), 11025);
                    if (b3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.avT.DY().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.avT.DS();
                        return;
                    }
                    switch (this.avT.Ea()) {
                        case 0:
                            this.avT.DQ();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.avT.DO();
                            return;
                    }
                case 20:
                    this.avT.Dh().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.aUd().iK(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.avT.getBaobaoImagesInfo() == null || this.avT.getBaobaoImagesInfo().getChosedFiles() == null || this.avT.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aSF();
                        if (TbadkCoreApplication.getCurrentMemberType() == 0 && !com.baidu.tieba.tbadkCore.PbEditor.a.aSE()) {
                            this.avT.DY().showToast(t.j.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.avT.DY().getActivity());
                        intentConfig.getIntent().putExtra("title", this.avT.DY().getResources().getString(t.j.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.avT.DY().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.avT.Eg();
                    return;
                case 23:
                    if (this.avT.getBaobaoImagesInfo() != null && this.avT.getBaobaoImagesInfo().size() > 0) {
                        this.avT.DZ().setIsBaobao(true);
                        return;
                    } else {
                        this.avT.DZ().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.avT.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.avT.Dh().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.avT.DY() != null && this.avT.DY().getResources() != null) {
                        Resources resources = this.avT.DY().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.avT.DY().getPageContext(), resources.getString(t.j.plugin_video_not_active), resources.getString(t.j.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.avT.DY().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.avT.DY().getPageContext(), resources.getString(t.j.plugin_video_install_tips), resources.getString(t.j.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.avT.Dh().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.avT.Dh().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.avT.DU();
                    return;
                case 32:
                    this.avT.Dh().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    b = this.avS.b(this.avT.DY().getPageContext(), 11040);
                    if (b) {
                        this.avT.DN();
                        return;
                    }
                    return;
                case 40:
                    if ((aVar.data instanceof String) || aVar.data == null) {
                        this.avT.setGraffitiFileName((String) aVar.data);
                        return;
                    }
                    return;
            }
        }
    }
}
