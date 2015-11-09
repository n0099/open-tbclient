package com.baidu.tbadk.editortools.c;

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
class o implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ n aqT;
    private final /* synthetic */ e aqU;
    private final /* synthetic */ com.baidu.tbadk.editortools.j aqV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, com.baidu.tbadk.editortools.j jVar) {
        this.aqT = nVar;
        this.aqU = eVar;
        this.aqV = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        int size;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        boolean b2;
        if (this.aqU != null && this.aqU.Az() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.aqU.fb((String) aVar.data);
                    this.aqT.aqR = false;
                    return;
                case 5:
                    if (!this.aqV.AC()) {
                        TiebaStatic.eventStat(this.aqV.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                default:
                    return;
                case 7:
                    this.aqU.Bj().showToast(i.h.over_limit_tip);
                    this.aqT.aqR = true;
                    return;
                case 8:
                    b = this.aqT.b(this.aqU.Bj().getPageContext(), 11001);
                    if (b) {
                        this.aqU.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.aqU.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aqV.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.aqU.setVoiceModel(null);
                    this.aqV.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.aqU.getWriteImagesInfo().getChosedFiles() == null || this.aqU.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.aqU.Bj().getActivity(), this.aqU.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.aqT.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.aqT.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.aqT.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.aqT.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (b.AW().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.aqU.ed(1);
                            if (this.aqU.getWriteImagesInfo() != null) {
                                this.aqU.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.aqU.ed(10);
                            if (this.aqU.getWriteImagesInfo() != null) {
                                this.aqU.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.aqU.Bp();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.aqU.getWriteImagesInfo() != null && this.aqU.getWriteImagesInfo().getChosedFiles() != null && (size = this.aqU.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.aqU.Bj().getActivity(), 12012, this.aqU.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.aqT.aqR;
                    if (z) {
                        this.aqU.Bj().showToast(i.h.over_limit_tip);
                    }
                    b2 = this.aqT.b(this.aqU.Bj().getPageContext(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aqU.Bj().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.aqU.Be();
                        return;
                    }
                    switch (this.aqU.Bl()) {
                        case 0:
                            this.aqU.Bc();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.aqU.Bb();
                            return;
                    }
                case 20:
                    this.aqU.Az().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.ayr().gA(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.aqU.getBaobaoImagesInfo() == null || this.aqU.getBaobaoImagesInfo().getChosedFiles() == null || this.aqU.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.awM();
                        if (TbadkCoreApplication.getCurrentMemberType() == 0 && !com.baidu.tieba.tbadkCore.PbEditor.a.awL()) {
                            this.aqU.Bj().showToast(i.h.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.aqU.Bj().getActivity());
                        intentConfig.getIntent().putExtra("title", this.aqU.Bj().getResources().getString(i.h.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.aqU.Bj().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.aqU.Br();
                    return;
                case 23:
                    if (this.aqU.getBaobaoImagesInfo() != null && this.aqU.getBaobaoImagesInfo().size() > 0) {
                        this.aqU.Bk().setIsBaobao(true);
                        return;
                    } else {
                        this.aqU.Bk().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.aqU.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.aqU.Az().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.aqU.Bj() != null && this.aqU.Bj().getResources() != null) {
                        Resources resources = this.aqU.Bj().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.aqU.Bj().getPageContext(), resources.getString(i.h.plugin_video_not_active), resources.getString(i.h.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.aqU.Bj().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.aqU.Bj().getPageContext(), resources.getString(i.h.plugin_video_install_tips), resources.getString(i.h.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.aqU.Az().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.aqU.Az().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.aqU.Bg();
                    return;
                case 32:
                    this.aqU.Az().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
            }
        }
    }
}
