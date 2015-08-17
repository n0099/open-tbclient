package com.baidu.tbadk.editortools.c;

import android.content.res.Resources;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
    final /* synthetic */ l ash;
    private final /* synthetic */ d asi;
    private final /* synthetic */ com.baidu.tbadk.editortools.j asj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, d dVar, com.baidu.tbadk.editortools.j jVar) {
        this.ash = lVar;
        this.asi = dVar;
        this.asj = jVar;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        boolean b;
        int size;
        boolean z;
        boolean b2;
        if (this.asi != null && this.asi.Ay() != null && aVar != null) {
            switch (aVar.code) {
                case 4:
                    this.asi.eM((String) aVar.data);
                    this.ash.asf = false;
                    return;
                case 5:
                    if (!this.asj.AB()) {
                        TiebaStatic.eventStat(this.asj.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                    this.asi.Bv().showToast(i.C0057i.over_limit_tip);
                    this.ash.asf = true;
                    return;
                case 8:
                    b = this.ash.b(this.asi.Bv().getPageContext(), 11001);
                    if (b) {
                        this.asi.a((String) null, (WriteData) null);
                        return;
                    }
                    return;
                case 10:
                    if (aVar.data instanceof VoiceData.VoiceModel) {
                        this.asi.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                    }
                    this.asj.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                    return;
                case 11:
                    this.asi.setVoiceModel(null);
                    this.asj.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                    return;
                case 14:
                    if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || this.asi.getWriteImagesInfo().getChosedFiles() == null || this.asi.getWriteImagesInfo().getChosedFiles().size() == 0) {
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.asi.Bv().getActivity(), this.asi.getWriteImagesInfo().toJsonString(), String.valueOf(System.currentTimeMillis()));
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    }
                    this.asi.BB();
                    return;
                case 15:
                    int intValue = ((Integer) aVar.data).intValue();
                    if (this.asi.getWriteImagesInfo() != null && this.asi.getWriteImagesInfo().getChosedFiles() != null && (size = this.asi.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(this.asi.Bv().getActivity(), 12012, this.asi.getWriteImagesInfo(), intValue)));
                        return;
                    }
                    return;
                case 16:
                    z = this.ash.asf;
                    if (z) {
                        this.asi.Bv().showToast(i.C0057i.over_limit_tip);
                    }
                    b2 = this.ash.b(this.asi.Bv().getPageContext(), 11025);
                    if (b2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.asi.Bv().getActivity(), 12004, true)));
                        return;
                    }
                    return;
                case 18:
                    if (aVar.data != null) {
                        this.asi.Bq();
                        return;
                    }
                    switch (this.asi.Bx()) {
                        case 0:
                            this.asi.Bo();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.asi.Bn();
                            return;
                    }
                case 20:
                    this.asi.Ay().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                    com.baidu.tieba.tbadkCore.location.c.aqC().fz(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                    return;
                case 21:
                    if (this.asi.getBaobaoImagesInfo() == null || this.asi.getBaobaoImagesInfo().getChosedFiles() == null || this.asi.getBaobaoImagesInfo().getChosedFiles().size() == 0) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.apx();
                        if (!com.baidu.tieba.tbadkCore.PbEditor.a.apw()) {
                            this.asi.Bv().showToast(i.C0057i.baobao_over_limit);
                            return;
                        }
                        IntentConfig intentConfig = new IntentConfig(this.asi.Bv().getActivity());
                        intentConfig.getIntent().putExtra("title", this.asi.Bv().getResources().getString(i.C0057i.send_reply));
                        intentConfig.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.asi.Bv().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_BAOBAO_STARTMATCHIMAGE, intentConfig));
                        return;
                    }
                    this.asi.BD();
                    return;
                case 23:
                    if (this.asi.getBaobaoImagesInfo() != null && this.asi.getBaobaoImagesInfo().size() > 0) {
                        this.asi.Bw().setIsBaobao(true);
                        return;
                    } else {
                        this.asi.Bw().setIsBaobao(false);
                        return;
                    }
                case 27:
                    VideoInfo videoInfo = this.asi.getVideoInfo();
                    if (videoInfo != null && videoInfo.isAvaliable()) {
                        this.asi.Ay().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                        return;
                    } else if (this.asi.Bv() != null && this.asi.Bv().getResources() != null) {
                        Resources resources = this.asi.Bv().getResources();
                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                            if (XiaoyingUtil.isXiaoyingForbidden()) {
                                XiaoyingUtil.showGoPluginDetailDialog(this.asi.Bv().getPageContext(), resources.getString(i.C0057i.plugin_video_not_active), resources.getString(i.C0057i.setup));
                                return;
                            } else {
                                XiaoyingUtil.startXiaoying(this.asi.Bv().getActivity());
                                return;
                            }
                        }
                        XiaoyingUtil.showGoPluginDetailDialog(this.asi.Bv().getPageContext(), resources.getString(i.C0057i.plugin_video_install_tips), resources.getString(i.C0057i.plugin_go_install));
                        return;
                    } else {
                        return;
                    }
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.asi.Ay().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                    this.asi.Ay().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                    this.asi.Bs();
                    return;
            }
        }
    }
}
