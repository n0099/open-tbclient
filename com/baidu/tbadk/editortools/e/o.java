package com.baidu.tbadk.editortools.e;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ n awZ;
    private final /* synthetic */ e axa;
    private final /* synthetic */ com.baidu.tbadk.editortools.l axb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, com.baidu.tbadk.editortools.l lVar) {
        this.awZ = nVar;
        this.axa = eVar;
        this.axb = lVar;
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
        if (this.axa != null && this.axa.CO() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.axa.fK((String) aVar.data);
                    this.awZ.awX = false;
                    return;
                case 5:
                    if (!this.axb.CR()) {
                        TiebaStatic.eventStat(this.axb.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
                        return;
                    }
                    return;
                case 6:
                case 9:
                case 12:
                case 13:
                case 17:
                case 19:
                case 21:
                case 22:
                case 23:
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
                    this.axa.getContext().showToast(r.j.over_limit_tip);
                    this.awZ.awX = true;
                    return;
                case 8:
                    b2 = this.awZ.b(this.axa.getContext().getPageContext(), 11001);
                    if (b2) {
                        this.axa.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.axa.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.axb.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.axa.setVoiceModel(null);
                    this.axb.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.axa.getWriteImagesInfo().getChosedFiles() == null || this.axa.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.axa.getContext().getActivity(), this.axa.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.awZ.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.awZ.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.awZ.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.awZ.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (b.Dp().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.axa.eK(1);
                            if (this.axa.getWriteImagesInfo() != null) {
                                this.axa.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.axa.eK(10);
                            if (this.axa.getWriteImagesInfo() != null) {
                                this.axa.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.axa.DI();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.axa.getWriteImagesInfo() != null && this.axa.getWriteImagesInfo().getChosedFiles() != null && (size = this.axa.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.axa.getContext().getActivity(), 12012, this.axa.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.awZ.awX;
                    if (z) {
                        this.axa.getContext().showToast(r.j.over_limit_tip);
                    }
                    b3 = this.awZ.b(this.axa.getContext().getPageContext(), 11025);
                    if (b3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.axa.getContext().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.axa.Dy();
                        return;
                    }
                    switch (this.axa.DE()) {
                        case 0:
                            this.axa.Dw();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.axa.Dv();
                            return;
                    }
                case 20:
                    this.axa.CO().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.bmL().setNoLongerShowAddress(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 27:
                    VideoInfo videoInfo = this.axa.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.axa.CO().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.axa.getContext() != null && this.axa.getContext().getResources() != null) {
                        Resources resources = this.axa.getContext().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.axa.getContext().getPageContext(), resources.getString(r.j.plugin_video_not_active), resources.getString(r.j.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.axa.getContext().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.axa.getContext().getPageContext(), resources.getString(r.j.plugin_video_install_tips), resources.getString(r.j.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case 29:
                    this.axa.CO().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.axa.CO().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.axa.DA();
                    return;
                case 32:
                    this.axa.CO().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    b = this.awZ.b(this.axa.getContext().getPageContext(), 11040);
                    if (b) {
                        this.axa.Du();
                        return;
                    }
                    return;
                case r.l.PullToRefresh_headerTextColor /* 40 */:
                    if ((aVar.data instanceof String) || aVar.data == null) {
                        this.axa.setGraffitiFileName((String) aVar.data);
                        return;
                    }
                    return;
                case 43:
                    if (!com.baidu.tbadk.plugins.a.a(this.axa.getContext().getPageContext(), true, false)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(this.axa.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                        return;
                    }
                    return;
            }
        }
    }
}
