package com.baidu.tbadk.editortools.d;

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
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ n atw;
    private final /* synthetic */ e atx;
    private final /* synthetic */ com.baidu.tbadk.editortools.l aty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, e eVar, com.baidu.tbadk.editortools.l lVar) {
        this.atw = nVar;
        this.atx = eVar;
        this.aty = lVar;
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
        if (this.atx != null && this.atx.Bl() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.atx.fB((String) aVar.data);
                    this.atw.atu = false;
                    return;
                case 5:
                    if (!this.aty.Bo()) {
                        TiebaStatic.eventStat(this.aty.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                case 33:
                case u.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling /* 34 */:
                case 35:
                case u.l.PullToRefresh_tb_ptrDrawableBottom /* 37 */:
                case u.l.PullToRefresh_adapterViewBackground /* 38 */:
                case u.l.PullToRefresh_headerBackground /* 39 */:
                default:
                    return;
                case 7:
                    this.atx.getContext().showToast(u.j.over_limit_tip);
                    this.atw.atu = true;
                    return;
                case 8:
                    b2 = this.atw.b(this.atx.getContext().getPageContext(), 11001);
                    if (b2) {
                        this.atx.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.atx.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.aty.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.atx.setVoiceModel(null);
                    this.aty.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.atx.getWriteImagesInfo().getChosedFiles() == null || this.atx.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.atx.getContext().getActivity(), this.atx.getWriteImagesInfo().toJsonString(), true, true);
                        str = this.atw.from;
                        if (!StringUtils.isNull(str, true)) {
                            Intent intent = albumActivityConfig.getIntent();
                            str4 = this.atw.from;
                            intent.putExtra("from", str4);
                        }
                        str2 = this.atw.forumId;
                        if (!StringUtils.isNull(str2, true)) {
                            Intent intent2 = albumActivityConfig.getIntent();
                            str3 = this.atw.forumId;
                            intent2.putExtra("forum_id", str3);
                        }
                        albumActivityConfig.setRequestCode(12002);
                        if (b.BM().getStatus() == 1) {
                            albumActivityConfig.setRequestFrom(2);
                            this.atx.eu(1);
                            if (this.atx.getWriteImagesInfo() != null) {
                                this.atx.getWriteImagesInfo().setMaxImagesAllowed(1);
                            }
                        } else {
                            this.atx.eu(10);
                            if (this.atx.getWriteImagesInfo() != null) {
                                this.atx.getWriteImagesInfo().setMaxImagesAllowed(10);
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.atx.Cg();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.atx.getWriteImagesInfo() != null && this.atx.getWriteImagesInfo().getChosedFiles() != null && (size = this.atx.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.atx.getContext().getActivity(), 12012, this.atx.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.atw.atu;
                    if (z) {
                        this.atx.getContext().showToast(u.j.over_limit_tip);
                    }
                    b3 = this.atw.b(this.atx.getContext().getPageContext(), 11025);
                    if (b3) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.atx.getContext().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.atx.BV();
                        return;
                    }
                    switch (this.atx.Cc()) {
                        case 0:
                            this.atx.BT();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.atx.BS();
                            return;
                    }
                case 20:
                    this.atx.Bl().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.bgi().setNoLongerShowAddress(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.atx.getBaobaoImagesInfo() == null || this.atx.getBaobaoImagesInfo().getChosedFiles() == null || this.atx.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.beM();
                        if (TbadkCoreApplication.getCurrentMemberType() == 0 && !com.baidu.tieba.tbadkCore.PbEditor.a.beL()) {
                            this.atx.getContext().showToast(u.j.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.atx.getContext().getActivity());
                        intentConfig.getIntent().putExtra("title", this.atx.getContext().getResources().getString(u.j.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.atx.getContext().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.atx.Ci();
                    return;
                case 23:
                    if (this.atx.getBaobaoImagesInfo() != null && this.atx.getBaobaoImagesInfo().size() > 0) {
                        this.atx.Cb().setIsBaobao(true);
                        return;
                    } else {
                        this.atx.Cb().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.atx.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.atx.Bl().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.atx.getContext() != null && this.atx.getContext().getResources() != null) {
                        Resources resources = this.atx.getContext().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.atx.getContext().getPageContext(), resources.getString(u.j.plugin_video_not_active), resources.getString(u.j.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.atx.getContext().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.atx.getContext().getPageContext(), resources.getString(u.j.plugin_video_install_tips), resources.getString(u.j.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case 29:
                    this.atx.Bl().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.atx.Bl().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.atx.BX();
                    return;
                case 32:
                    this.atx.Bl().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                    return;
                case u.l.PullToRefresh_tb_ptrDrawableTop /* 36 */:
                    b = this.atw.b(this.atx.getContext().getPageContext(), 11040);
                    if (b) {
                        this.atx.BR();
                        return;
                    }
                    return;
                case u.l.PullToRefresh_headerTextColor /* 40 */:
                    if ((aVar.data instanceof String) || aVar.data == null) {
                        this.atx.setGraffitiFileName((String) aVar.data);
                        return;
                    }
                    return;
            }
        }
    }
}
