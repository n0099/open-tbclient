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
    final /* synthetic */ l aso;
    private final /* synthetic */ d asp;
    private final /* synthetic */ com.baidu.tbadk.editortools.j asq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, d dVar, com.baidu.tbadk.editortools.j jVar) {
        this.aso = lVar;
        this.asp = dVar;
        this.asq = jVar;
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
        if (this.asp != null && this.asp.Ax() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.asp.eZ((String) aVar.data);
                    this.aso.asm = false;
                    return;
                case 5:
                    if (!this.asq.AA()) {
                        TiebaStatic.eventStat(this.asq.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                    this.asp.Bv().showToast(i.h.over_limit_tip);
                    this.aso.asm = true;
                    return;
                case 8:
                    b = this.aso.b(this.asp.Bv().getPageContext(), 11001);
                    if (b) {
                        this.asp.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.asp.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.asq.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.asp.setVoiceModel(null);
                    this.asq.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.asp.getWriteImagesInfo().getChosedFiles() == null || this.asp.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.asp.Bv().getActivity(), this.asp.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.aso.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.aso.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.aso.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.aso.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.asp.BB();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.asp.getWriteImagesInfo() != null && this.asp.getWriteImagesInfo().getChosedFiles() != null && (size = this.asp.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.asp.Bv().getActivity(), 12012, this.asp.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.aso.asm;
                    if (z) {
                        this.asp.Bv().showToast(i.h.over_limit_tip);
                    }
                    b2 = this.aso.b(this.asp.Bv().getPageContext(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asp.Bv().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.asp.Bq();
                        return;
                    }
                    switch (this.asp.Bx()) {
                        case 0:
                            this.asp.Bo();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.asp.Bn();
                            return;
                    }
                case 20:
                    this.asp.Ax().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.axc().gu(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.asp.getBaobaoImagesInfo() == null || this.asp.getBaobaoImagesInfo().getChosedFiles() == null || this.asp.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.awa();
                        if (TbadkCoreApplication.getCurrentMemberType() == 0 && !com.baidu.tieba.tbadkCore.PbEditor.a.avZ()) {
                            this.asp.Bv().showToast(i.h.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.asp.Bv().getActivity());
                        intentConfig.getIntent().putExtra("title", this.asp.Bv().getResources().getString(i.h.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.asp.Bv().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.asp.BD();
                    return;
                case 23:
                    if (this.asp.getBaobaoImagesInfo() != null && this.asp.getBaobaoImagesInfo().size() > 0) {
                        this.asp.Bw().setIsBaobao(true);
                        return;
                    } else {
                        this.asp.Bw().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.asp.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.asp.Ax().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.asp.Bv() != null && this.asp.Bv().getResources() != null) {
                        Resources resources = this.asp.Bv().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.asp.Bv().getPageContext(), resources.getString(i.h.plugin_video_not_active), resources.getString(i.h.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.asp.Bv().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.asp.Bv().getPageContext(), resources.getString(i.h.plugin_video_install_tips), resources.getString(i.h.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.asp.Ax().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.asp.Ax().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.asp.Bs();
                    return;
            }
        }
    }
}
