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
    final /* synthetic */ n avs;
    private final /* synthetic */ e avt;
    private final /* synthetic */ com.baidu.tbadk.editortools.k avu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, com.baidu.tbadk.editortools.k kVar) {
        this.avs = nVar;
        this.avt = eVar;
        this.avu = kVar;
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
        if (this.avt != null && this.avt.Cz() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.avt.fs((String) aVar.data);
                    this.avs.avq = false;
                    return;
                case 5:
                    if (!this.avu.CC()) {
                        TiebaStatic.eventStat(this.avu.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                default:
                    return;
                case 7:
                    this.avt.Do().showToast(t.j.over_limit_tip);
                    this.avs.avq = true;
                    return;
                case 8:
                    b2 = this.avs.b(this.avt.Do().getPageContext(), 11001);
                    if (b2) {
                        this.avt.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.avt.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.avu.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.avt.setVoiceModel(null);
                    this.avu.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.avt.getWriteImagesInfo().getChosedFiles() == null || this.avt.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.avt.Do().getActivity(), this.avt.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.avs.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.avs.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.avs.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.avs.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (b.Da().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.avt.eF(1);
                            if (this.avt.getWriteImagesInfo() != null) {
                                this.avt.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.avt.eF(10);
                            if (this.avt.getWriteImagesInfo() != null) {
                                this.avt.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.avt.Du();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.avt.getWriteImagesInfo() != null && this.avt.getWriteImagesInfo().getChosedFiles() != null && (size = this.avt.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.avt.Do().getActivity(), 12012, this.avt.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.avs.avq;
                    if (z) {
                        this.avt.Do().showToast(t.j.over_limit_tip);
                    }
                    b3 = this.avs.b(this.avt.Do().getPageContext(), 11025);
                    if (b3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.avt.Do().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.avt.Dj();
                        return;
                    }
                    switch (this.avt.Dq()) {
                        case 0:
                            this.avt.Dh();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.avt.Dg();
                            return;
                    }
                case 20:
                    this.avt.Cz().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.aNb().hV(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.avt.getBaobaoImagesInfo() == null || this.avt.getBaobaoImagesInfo().getChosedFiles() == null || this.avt.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aLL();
                        if (TbadkCoreApplication.getCurrentMemberType() == 0 && !com.baidu.tieba.tbadkCore.PbEditor.a.aLK()) {
                            this.avt.Do().showToast(t.j.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.avt.Do().getActivity());
                        intentConfig.getIntent().putExtra("title", this.avt.Do().getResources().getString(t.j.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.avt.Do().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.avt.Dw();
                    return;
                case 23:
                    if (this.avt.getBaobaoImagesInfo() != null && this.avt.getBaobaoImagesInfo().size() > 0) {
                        this.avt.Dp().setIsBaobao(true);
                        return;
                    } else {
                        this.avt.Dp().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.avt.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.avt.Cz().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.avt.Do() != null && this.avt.Do().getResources() != null) {
                        Resources resources = this.avt.Do().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.avt.Do().getPageContext(), resources.getString(t.j.plugin_video_not_active), resources.getString(t.j.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.avt.Do().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.avt.Do().getPageContext(), resources.getString(t.j.plugin_video_install_tips), resources.getString(t.j.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.avt.Cz().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.avt.Cz().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.avt.Dl();
                    return;
                case 32:
                    this.avt.Cz().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    b = this.avs.b(this.avt.Do().getPageContext(), 11040);
                    if (b) {
                        this.avt.Df();
                        return;
                    }
                    return;
            }
        }
    }
}
