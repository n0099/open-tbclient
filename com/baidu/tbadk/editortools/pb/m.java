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
    final /* synthetic */ l aBn;
    private final /* synthetic */ c aBo;
    private final /* synthetic */ com.baidu.tbadk.editortools.j aBp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, c cVar, com.baidu.tbadk.editortools.j jVar) {
        this.aBn = lVar;
        this.aBo = cVar;
        this.aBp = jVar;
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
        if (this.aBo != null && this.aBo.Dn() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.aBo.fy((String) aVar.data);
                    this.aBn.aBl = false;
                    return;
                case 5:
                    if (!this.aBp.Dq()) {
                        TiebaStatic.eventStat(this.aBp.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                    this.aBo.getContext().showToast(w.l.over_limit_tip);
                    this.aBn.aBl = true;
                    return;
                case 8:
                    a2 = this.aBn.a(this.aBo.getContext().getPageContext(), 11001);
                    if (a2) {
                        this.aBo.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.aBo.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aBp.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.aBo.setVoiceModel(null);
                    this.aBp.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.aBo.getWriteImagesInfo().getChosedFiles() == null || this.aBo.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.aBo.getContext().getActivity(), this.aBo.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.aBn.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.aBn.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.aBn.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.aBn.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (a.DK().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.aBo.eK(1);
                            if (this.aBo.getWriteImagesInfo() != null) {
                                this.aBo.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.aBo.eK(10);
                            if (this.aBo.getWriteImagesInfo() != null) {
                                this.aBo.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.aBo.Ec();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.aBo.getWriteImagesInfo() != null && this.aBo.getWriteImagesInfo().getChosedFiles() != null && (size = this.aBo.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.aBo.getContext().getActivity(), 12012, this.aBo.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.aBn.aBl;
                    if (z) {
                        this.aBo.getContext().showToast(w.l.over_limit_tip);
                    }
                    a3 = this.aBn.a(this.aBo.getContext().getPageContext(), 11025);
                    if (a3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.aBo.getContext().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.aBo.DT();
                        return;
                    }
                    switch (this.aBo.DY()) {
                        case 0:
                            this.aBo.DR();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.aBo.DQ();
                            return;
                    }
                case 20:
                    this.aBo.Dn().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.d.bjV().lv(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 27:
                    VideoInfo videoInfo = this.aBo.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.aBo.Dn().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.aBo.getContext() != null && this.aBo.getContext().getResources() != null) {
                        Resources resources = this.aBo.getContext().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.aBo.getContext().getPageContext(), resources.getString(w.l.plugin_video_not_active), resources.getString(w.l.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.aBo.getContext().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.aBo.getContext().getPageContext(), resources.getString(w.l.plugin_video_install_tips), resources.getString(w.l.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case 29:
                    this.aBo.Dn().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.aBo.Dn().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.aBo.DV();
                    return;
                case 32:
                    this.aBo.Dn().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case 36:
                    a = this.aBn.a(this.aBo.getContext().getPageContext(), 11040);
                    if (a) {
                        this.aBo.DP();
                        return;
                    }
                    return;
                case w.n.PullToRefresh_headerTextColor /* 40 */:
                    if ((aVar.data instanceof String) || aVar.data == null) {
                        this.aBo.setGraffitiFileName((String) aVar.data);
                        return;
                    }
                    return;
                case 43:
                    if (!com.baidu.tbadk.plugins.a.a(this.aBo.getContext().getPageContext(), true, false)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(this.aBo.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                        return;
                    }
                    return;
            }
        }
    }
}
