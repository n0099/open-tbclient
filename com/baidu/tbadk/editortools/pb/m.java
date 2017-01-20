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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class m implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ l avA;
    private final /* synthetic */ c avB;
    private final /* synthetic */ com.baidu.tbadk.editortools.j avC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, c cVar, com.baidu.tbadk.editortools.j jVar) {
        this.avA = lVar;
        this.avB = cVar;
        this.avC = jVar;
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
        if (this.avB != null && this.avB.Cw() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.avB.fD((String) aVar.data);
                    this.avA.avy = false;
                    return;
                case 5:
                    if (!this.avC.Cz()) {
                        TiebaStatic.eventStat(this.avC.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                case r.n.PullToRefresh_adapterViewBackground /* 38 */:
                case r.n.PullToRefresh_headerBackground /* 39 */:
                case r.n.PullToRefresh_mode /* 41 */:
                case 42:
                default:
                    return;
                case 7:
                    this.avB.getContext().showToast(r.l.over_limit_tip);
                    this.avA.avy = true;
                    return;
                case 8:
                    b2 = this.avA.b(this.avB.getContext().getPageContext(), 11001);
                    if (b2) {
                        this.avB.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.avB.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.avC.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.avB.setVoiceModel(null);
                    this.avC.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.avB.getWriteImagesInfo().getChosedFiles() == null || this.avB.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.avB.getContext().getActivity(), this.avB.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.avA.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.avA.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.avA.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.avA.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (a.CT().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.avB.eM(1);
                            if (this.avB.getWriteImagesInfo() != null) {
                                this.avB.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.avB.eM(10);
                            if (this.avB.getWriteImagesInfo() != null) {
                                this.avB.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.avB.Dl();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.avB.getWriteImagesInfo() != null && this.avB.getWriteImagesInfo().getChosedFiles() != null && (size = this.avB.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.avB.getContext().getActivity(), 12012, this.avB.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.avA.avy;
                    if (z) {
                        this.avB.getContext().showToast(r.l.over_limit_tip);
                    }
                    b3 = this.avA.b(this.avB.getContext().getPageContext(), 11025);
                    if (b3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.avB.getContext().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.avB.Dc();
                        return;
                    }
                    switch (this.avB.Dh()) {
                        case 0:
                            this.avB.Da();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.avB.CZ();
                            return;
                    }
                case 20:
                    this.avB.Cw().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.bit().lj(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 27:
                    VideoInfo videoInfo = this.avB.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.avB.Cw().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.avB.getContext() != null && this.avB.getContext().getResources() != null) {
                        Resources resources = this.avB.getContext().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.avB.getContext().getPageContext(), resources.getString(r.l.plugin_video_not_active), resources.getString(r.l.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.avB.getContext().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.avB.getContext().getPageContext(), resources.getString(r.l.plugin_video_install_tips), resources.getString(r.l.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case 29:
                    this.avB.Cw().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.avB.Cw().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.avB.De();
                    return;
                case 32:
                    this.avB.Cw().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    b = this.avA.b(this.avB.getContext().getPageContext(), 11040);
                    if (b) {
                        this.avB.CY();
                        return;
                    }
                    return;
                case r.n.PullToRefresh_headerTextColor /* 40 */:
                    if ((aVar.data instanceof String) || aVar.data == null) {
                        this.avB.setGraffitiFileName((String) aVar.data);
                        return;
                    }
                    return;
                case 43:
                    if (!com.baidu.tbadk.plugins.a.a(this.avB.getContext().getPageContext(), true, false)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(this.avB.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                        return;
                    }
                    return;
            }
        }
    }
}
