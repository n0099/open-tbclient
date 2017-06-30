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
    final /* synthetic */ l aCb;
    private final /* synthetic */ c aCc;
    private final /* synthetic */ com.baidu.tbadk.editortools.j aCd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, c cVar, com.baidu.tbadk.editortools.j jVar) {
        this.aCb = lVar;
        this.aCc = cVar;
        this.aCd = jVar;
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
        if (this.aCc != null && this.aCc.CG() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.aCc.fN((String) aVar.data);
                    this.aCb.aBZ = false;
                    return;
                case 5:
                    if (!this.aCd.CJ()) {
                        TiebaStatic.eventStat(this.aCd.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                case 38:
                case 39:
                case 41:
                case w.n.View_duplicateParentState /* 42 */:
                default:
                    return;
                case 7:
                    this.aCc.getContext().showToast(w.l.over_limit_tip);
                    this.aCb.aBZ = true;
                    return;
                case 8:
                    a2 = this.aCb.a(this.aCc.getContext().getPageContext(), 11001);
                    if (a2) {
                        this.aCc.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.aCc.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aCd.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.aCc.setVoiceModel(null);
                    this.aCd.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.aCc.getWriteImagesInfo().getChosedFiles() == null || this.aCc.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.aCc.getContext().getActivity(), this.aCc.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.aCb.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.aCb.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.aCb.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.aCb.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (a.Dc().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.aCc.eJ(1);
                            if (this.aCc.getWriteImagesInfo() != null) {
                                this.aCc.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.aCc.eJ(10);
                            if (this.aCc.getWriteImagesInfo() != null) {
                                this.aCc.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.aCc.Du();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.aCc.getWriteImagesInfo() != null && this.aCc.getWriteImagesInfo().getChosedFiles() != null && (size = this.aCc.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.aCc.getContext().getActivity(), 12012, this.aCc.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.aCb.aBZ;
                    if (z) {
                        this.aCc.getContext().showToast(w.l.over_limit_tip);
                    }
                    a3 = this.aCb.a(this.aCc.getContext().getPageContext(), 11025);
                    if (a3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aCc.getContext().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.aCc.Dl();
                        return;
                    }
                    switch (this.aCc.Dq()) {
                        case 0:
                            this.aCc.Dj();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.aCc.Di();
                            return;
                    }
                case 20:
                    this.aCc.CG().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.d.bna().lT(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 27:
                    VideoInfo videoInfo = this.aCc.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.aCc.CG().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.aCc.getContext() != null && this.aCc.getContext().getResources() != null) {
                        Resources resources = this.aCc.getContext().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.aCc.getContext().getPageContext(), resources.getString(w.l.plugin_video_not_active), resources.getString(w.l.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.aCc.getContext().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.aCc.getContext().getPageContext(), resources.getString(w.l.plugin_video_install_tips), resources.getString(w.l.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case 29:
                    this.aCc.CG().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.aCc.CG().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.aCc.Dn();
                    return;
                case 32:
                    this.aCc.CG().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    a = this.aCb.a(this.aCc.getContext().getPageContext(), 11040);
                    if (a) {
                        this.aCc.Dh();
                        return;
                    }
                    return;
                case 40:
                    if ((aVar.data instanceof String) || aVar.data == null) {
                        this.aCc.setGraffitiFileName((String) aVar.data);
                        return;
                    }
                    return;
                case w.n.View_minHeight /* 43 */:
                    if (!com.baidu.tbadk.plugins.a.a(this.aCc.getContext().getPageContext(), true, false)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(this.aCc.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                        return;
                    }
                    return;
            }
        }
    }
}
