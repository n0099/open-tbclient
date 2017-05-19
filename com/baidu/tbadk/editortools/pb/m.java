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
    final /* synthetic */ l aBm;
    private final /* synthetic */ c aBn;
    private final /* synthetic */ com.baidu.tbadk.editortools.j aBo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, c cVar, com.baidu.tbadk.editortools.j jVar) {
        this.aBm = lVar;
        this.aBn = cVar;
        this.aBo = jVar;
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
        if (this.aBn != null && this.aBn.Cs() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.aBn.fv((String) aVar.data);
                    this.aBm.aBk = false;
                    return;
                case 5:
                    if (!this.aBo.Cv()) {
                        TiebaStatic.eventStat(this.aBo.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                    this.aBn.getContext().showToast(w.l.over_limit_tip);
                    this.aBm.aBk = true;
                    return;
                case 8:
                    a2 = this.aBm.a(this.aBn.getContext().getPageContext(), 11001);
                    if (a2) {
                        this.aBn.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.aBn.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aBo.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.aBn.setVoiceModel(null);
                    this.aBo.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.aBn.getWriteImagesInfo().getChosedFiles() == null || this.aBn.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.aBn.getContext().getActivity(), this.aBn.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.aBm.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.aBm.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.aBm.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.aBm.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (a.CO().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.aBn.eG(1);
                            if (this.aBn.getWriteImagesInfo() != null) {
                                this.aBn.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.aBn.eG(10);
                            if (this.aBn.getWriteImagesInfo() != null) {
                                this.aBn.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.aBn.Dg();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.aBn.getWriteImagesInfo() != null && this.aBn.getWriteImagesInfo().getChosedFiles() != null && (size = this.aBn.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.aBn.getContext().getActivity(), 12012, this.aBn.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.aBm.aBk;
                    if (z) {
                        this.aBn.getContext().showToast(w.l.over_limit_tip);
                    }
                    a3 = this.aBm.a(this.aBn.getContext().getPageContext(), 11025);
                    if (a3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aBn.getContext().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.aBn.CX();
                        return;
                    }
                    switch (this.aBn.Dc()) {
                        case 0:
                            this.aBn.CV();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.aBn.CU();
                            return;
                    }
                case 20:
                    this.aBn.Cs().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.d.bhs().kZ(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 27:
                    VideoInfo videoInfo = this.aBn.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.aBn.Cs().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.aBn.getContext() != null && this.aBn.getContext().getResources() != null) {
                        Resources resources = this.aBn.getContext().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.aBn.getContext().getPageContext(), resources.getString(w.l.plugin_video_not_active), resources.getString(w.l.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.aBn.getContext().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.aBn.getContext().getPageContext(), resources.getString(w.l.plugin_video_install_tips), resources.getString(w.l.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case 29:
                    this.aBn.Cs().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.aBn.Cs().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.aBn.CZ();
                    return;
                case 32:
                    this.aBn.Cs().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    a = this.aBm.a(this.aBn.getContext().getPageContext(), 11040);
                    if (a) {
                        this.aBn.CT();
                        return;
                    }
                    return;
                case w.n.PullToRefresh_headerTextColor /* 40 */:
                    if ((aVar.data instanceof String) || aVar.data == null) {
                        this.aBn.setGraffitiFileName((String) aVar.data);
                        return;
                    }
                    return;
                case 43:
                    if (!com.baidu.tbadk.plugins.a.a(this.aBn.getContext().getPageContext(), true, false)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(this.aBn.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                        return;
                    }
                    return;
            }
        }
    }
}
