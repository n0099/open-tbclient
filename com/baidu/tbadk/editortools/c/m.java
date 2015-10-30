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
class m implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ l asp;
    private final /* synthetic */ d asq;
    private final /* synthetic */ com.baidu.tbadk.editortools.j asr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, d dVar, com.baidu.tbadk.editortools.j jVar) {
        this.asp = lVar;
        this.asq = dVar;
        this.asr = jVar;
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
        if (this.asq != null && this.asq.Au() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.asq.eZ((String) aVar.data);
                    this.asp.asn = false;
                    return;
                case 5:
                    if (!this.asr.Ax()) {
                        TiebaStatic.eventStat(this.asr.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                    this.asq.Bs().showToast(i.h.over_limit_tip);
                    this.asp.asn = true;
                    return;
                case 8:
                    b = this.asp.b(this.asq.Bs().getPageContext(), 11001);
                    if (b) {
                        this.asq.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.asq.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.asr.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.asq.setVoiceModel(null);
                    this.asr.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.asq.getWriteImagesInfo().getChosedFiles() == null || this.asq.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.asq.Bs().getActivity(), this.asq.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.asp.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.asp.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.asp.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.asp.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.asq.By();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.asq.getWriteImagesInfo() != null && this.asq.getWriteImagesInfo().getChosedFiles() != null && (size = this.asq.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.asq.Bs().getActivity(), 12012, this.asq.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.asp.asn;
                    if (z) {
                        this.asq.Bs().showToast(i.h.over_limit_tip);
                    }
                    b2 = this.asp.b(this.asq.Bs().getPageContext(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asq.Bs().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.asq.Bn();
                        return;
                    }
                    switch (this.asq.Bu()) {
                        case 0:
                            this.asq.Bl();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.asq.Bk();
                            return;
                    }
                case 20:
                    this.asq.Au().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.axi().gu(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.asq.getBaobaoImagesInfo() == null || this.asq.getBaobaoImagesInfo().getChosedFiles() == null || this.asq.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.awe();
                        if (TbadkCoreApplication.getCurrentMemberType() == 0 && !com.baidu.tieba.tbadkCore.PbEditor.a.awd()) {
                            this.asq.Bs().showToast(i.h.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.asq.Bs().getActivity());
                        intentConfig.getIntent().putExtra("title", this.asq.Bs().getResources().getString(i.h.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.asq.Bs().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.asq.BA();
                    return;
                case 23:
                    if (this.asq.getBaobaoImagesInfo() != null && this.asq.getBaobaoImagesInfo().size() > 0) {
                        this.asq.Bt().setIsBaobao(true);
                        return;
                    } else {
                        this.asq.Bt().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.asq.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.asq.Au().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.asq.Bs() != null && this.asq.Bs().getResources() != null) {
                        Resources resources = this.asq.Bs().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.asq.Bs().getPageContext(), resources.getString(i.h.plugin_video_not_active), resources.getString(i.h.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.asq.Bs().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.asq.Bs().getPageContext(), resources.getString(i.h.plugin_video_install_tips), resources.getString(i.h.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.asq.Au().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.asq.Au().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.asq.Bp();
                    return;
            }
        }
    }
}
