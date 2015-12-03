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
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ n asW;
    private final /* synthetic */ e asX;
    private final /* synthetic */ com.baidu.tbadk.editortools.k asY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, com.baidu.tbadk.editortools.k kVar) {
        this.asW = nVar;
        this.asX = eVar;
        this.asY = kVar;
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
        if (this.asX != null && this.asX.Bu() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.asX.fq((String) aVar.data);
                    this.asW.asU = false;
                    return;
                case 5:
                    if (!this.asY.Bx()) {
                        TiebaStatic.eventStat(this.asY.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                case TbConfig.FRS_NOABSTRACT_ITEM_NUMBER /* 35 */:
                default:
                    return;
                case 7:
                    this.asX.Cj().showToast(n.i.over_limit_tip);
                    this.asW.asU = true;
                    return;
                case 8:
                    b2 = this.asW.b(this.asX.Cj().getPageContext(), 11001);
                    if (b2) {
                        this.asX.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.asX.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.asY.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.asX.setVoiceModel(null);
                    this.asY.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.asX.getWriteImagesInfo().getChosedFiles() == null || this.asX.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.asX.Cj().getActivity(), this.asX.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.asW.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.asW.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.asW.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.asW.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (b.BV().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.asX.er(1);
                            if (this.asX.getWriteImagesInfo() != null) {
                                this.asX.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.asX.er(10);
                            if (this.asX.getWriteImagesInfo() != null) {
                                this.asX.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.asX.Cp();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.asX.getWriteImagesInfo() != null && this.asX.getWriteImagesInfo().getChosedFiles() != null && (size = this.asX.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.asX.Cj().getActivity(), 12012, this.asX.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.asW.asU;
                    if (z) {
                        this.asX.Cj().showToast(n.i.over_limit_tip);
                    }
                    b3 = this.asW.b(this.asX.Cj().getPageContext(), 11025);
                    if (b3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asX.Cj().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.asX.Ce();
                        return;
                    }
                    switch (this.asX.Cl()) {
                        case 0:
                            this.asX.Cc();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.asX.Cb();
                            return;
                    }
                case 20:
                    this.asX.Bu().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.aDJ().hl(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.asX.getBaobaoImagesInfo() == null || this.asX.getBaobaoImagesInfo().getChosedFiles() == null || this.asX.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aCy();
                        if (TbadkCoreApplication.getCurrentMemberType() == 0 && !com.baidu.tieba.tbadkCore.PbEditor.a.aCx()) {
                            this.asX.Cj().showToast(n.i.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.asX.Cj().getActivity());
                        intentConfig.getIntent().putExtra("title", this.asX.Cj().getResources().getString(n.i.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.asX.Cj().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.asX.Cr();
                    return;
                case 23:
                    if (this.asX.getBaobaoImagesInfo() != null && this.asX.getBaobaoImagesInfo().size() > 0) {
                        this.asX.Ck().setIsBaobao(true);
                        return;
                    } else {
                        this.asX.Ck().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.asX.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.asX.Bu().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.asX.Cj() != null && this.asX.Cj().getResources() != null) {
                        Resources resources = this.asX.Cj().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.asX.Cj().getPageContext(), resources.getString(n.i.plugin_video_not_active), resources.getString(n.i.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.asX.Cj().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.asX.Cj().getPageContext(), resources.getString(n.i.plugin_video_install_tips), resources.getString(n.i.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.asX.Bu().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.asX.Bu().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.asX.Cg();
                    return;
                case 32:
                    this.asX.Bu().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    b = this.asW.b(this.asX.Cj().getPageContext(), 11040);
                    if (b) {
                        this.asX.Ca();
                        return;
                    }
                    return;
            }
        }
    }
}
