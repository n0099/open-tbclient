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
    final /* synthetic */ n auA;
    private final /* synthetic */ e auB;
    private final /* synthetic */ com.baidu.tbadk.editortools.k auC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, com.baidu.tbadk.editortools.k kVar) {
        this.auA = nVar;
        this.auB = eVar;
        this.auC = kVar;
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
        if (this.auB != null && this.auB.Bj() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.auB.fu((String) aVar.data);
                    this.auA.auy = false;
                    return;
                case 5:
                    if (!this.auC.Bm()) {
                        TiebaStatic.eventStat(this.auC.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                    this.auB.BY().showToast(n.j.over_limit_tip);
                    this.auA.auy = true;
                    return;
                case 8:
                    b2 = this.auA.b(this.auB.BY().getPageContext(), 11001);
                    if (b2) {
                        this.auB.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.auB.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.auC.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.auB.setVoiceModel(null);
                    this.auC.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.auB.getWriteImagesInfo().getChosedFiles() == null || this.auB.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.auB.BY().getActivity(), this.auB.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.auA.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.auA.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.auA.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.auA.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (b.BK().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.auB.el(1);
                            if (this.auB.getWriteImagesInfo() != null) {
                                this.auB.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.auB.el(10);
                            if (this.auB.getWriteImagesInfo() != null) {
                                this.auB.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.auB.Ce();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.auB.getWriteImagesInfo() != null && this.auB.getWriteImagesInfo().getChosedFiles() != null && (size = this.auB.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.auB.BY().getActivity(), 12012, this.auB.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.auA.auy;
                    if (z) {
                        this.auB.BY().showToast(n.j.over_limit_tip);
                    }
                    b3 = this.auA.b(this.auB.BY().getPageContext(), 11025);
                    if (b3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.auB.BY().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.auB.BT();
                        return;
                    }
                    switch (this.auB.Ca()) {
                        case 0:
                            this.auB.BR();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.auB.BQ();
                            return;
                    }
                case 20:
                    this.auB.Bj().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.aFW().hu(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.auB.getBaobaoImagesInfo() == null || this.auB.getBaobaoImagesInfo().getChosedFiles() == null || this.auB.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aEF();
                        if (TbadkCoreApplication.getCurrentMemberType() == 0 && !com.baidu.tieba.tbadkCore.PbEditor.a.aEE()) {
                            this.auB.BY().showToast(n.j.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.auB.BY().getActivity());
                        intentConfig.getIntent().putExtra("title", this.auB.BY().getResources().getString(n.j.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.auB.BY().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.auB.Cg();
                    return;
                case 23:
                    if (this.auB.getBaobaoImagesInfo() != null && this.auB.getBaobaoImagesInfo().size() > 0) {
                        this.auB.BZ().setIsBaobao(true);
                        return;
                    } else {
                        this.auB.BZ().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.auB.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.auB.Bj().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.auB.BY() != null && this.auB.BY().getResources() != null) {
                        Resources resources = this.auB.BY().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.auB.BY().getPageContext(), resources.getString(n.j.plugin_video_not_active), resources.getString(n.j.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.auB.BY().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.auB.BY().getPageContext(), resources.getString(n.j.plugin_video_install_tips), resources.getString(n.j.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.auB.Bj().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.auB.Bj().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.auB.BV();
                    return;
                case 32:
                    this.auB.Bj().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    b = this.auA.b(this.auB.BY().getPageContext(), 11040);
                    if (b) {
                        this.auB.BP();
                        return;
                    }
                    return;
            }
        }
    }
}
