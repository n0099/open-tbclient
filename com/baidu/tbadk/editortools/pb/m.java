package com.baidu.tbadk.editortools.pb;

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
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ l aAV;
    private final /* synthetic */ c aAW;
    private final /* synthetic */ com.baidu.tbadk.editortools.j aAX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, c cVar, com.baidu.tbadk.editortools.j jVar) {
        this.aAV = lVar;
        this.aAW = cVar;
        this.aAX = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean a;
        boolean a2;
        int size;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        boolean a3;
        if (this.aAW != null && this.aAW.CP() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.aAW.fs((String) aVar.data);
                    this.aAV.aAT = false;
                    return;
                case 5:
                    if (!this.aAX.CS()) {
                        TiebaStatic.eventStat(this.aAX.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                case w.n.PullToRefresh_adapterViewBackground /* 38 */:
                case w.n.PullToRefresh_headerBackground /* 39 */:
                case w.n.PullToRefresh_mode /* 41 */:
                case 42:
                default:
                    return;
                case 7:
                    this.aAW.getContext().showToast(w.l.over_limit_tip);
                    this.aAV.aAT = true;
                    return;
                case 8:
                    a2 = this.aAV.a(this.aAW.getContext().getPageContext(), 11001);
                    if (a2) {
                        this.aAW.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.aAW.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aAX.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.aAW.setVoiceModel(null);
                    this.aAX.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.aAW.getWriteImagesInfo().getChosedFiles() == null || this.aAW.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.aAW.getContext().getActivity(), this.aAW.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.aAV.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.aAV.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.aAV.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.aAV.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (a.Dm().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.aAW.eH(1);
                            if (this.aAW.getWriteImagesInfo() != null) {
                                this.aAW.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.aAW.eH(10);
                            if (this.aAW.getWriteImagesInfo() != null) {
                                this.aAW.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.aAW.DE();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.aAW.getWriteImagesInfo() != null && this.aAW.getWriteImagesInfo().getChosedFiles() != null && (size = this.aAW.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.aAW.getContext().getActivity(), 12012, this.aAW.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.aAV.aAT;
                    if (z) {
                        this.aAW.getContext().showToast(w.l.over_limit_tip);
                    }
                    a3 = this.aAV.a(this.aAW.getContext().getPageContext(), 11025);
                    if (a3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aAW.getContext().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.aAW.Dv();
                        return;
                    }
                    switch (this.aAW.DA()) {
                        case 0:
                            this.aAW.Dt();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.aAW.Ds();
                            return;
                    }
                case 20:
                    this.aAW.CP().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.bij().li(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 27:
                    VideoInfo videoInfo = this.aAW.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.aAW.CP().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.aAW.getContext() != null && this.aAW.getContext().getResources() != null) {
                        Resources resources = this.aAW.getContext().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.aAW.getContext().getPageContext(), resources.getString(w.l.plugin_video_not_active), resources.getString(w.l.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.aAW.getContext().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.aAW.getContext().getPageContext(), resources.getString(w.l.plugin_video_install_tips), resources.getString(w.l.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case 29:
                    this.aAW.CP().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.aAW.CP().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.aAW.Dx();
                    return;
                case 32:
                    this.aAW.CP().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    a = this.aAV.a(this.aAW.getContext().getPageContext(), 11040);
                    if (a) {
                        this.aAW.Dr();
                        return;
                    }
                    return;
                case w.n.PullToRefresh_headerTextColor /* 40 */:
                    if ((aVar.data instanceof String) || aVar.data == null) {
                        this.aAW.setGraffitiFileName((String) aVar.data);
                        return;
                    }
                    return;
                case 43:
                    if (!com.baidu.tbadk.plugins.a.a(this.aAW.getContext().getPageContext(), true, false)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(this.aAW.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                        return;
                    }
                    return;
            }
        }
    }
}
