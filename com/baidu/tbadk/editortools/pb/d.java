package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.r;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.editortools.d {
    private DataModel<?> aEs;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean aEr = false;

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void a(DataModel<?> dataModel) {
        this.aEs = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aS(Context context) {
        i iVar = new i(context);
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.e.common_color_10099);
        iVar.bF(true);
        c cVar = new c(iVar);
        cVar.a(this.aEs);
        return cVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof c) {
            final i Da = fVar.Da();
            final c cVar = (c) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.d.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (cVar != null && cVar.Da() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                cVar.fX((String) aVar.data);
                                d.this.aEr = false;
                                return;
                            case 5:
                                if (!Da.Dd()) {
                                    TiebaStatic.eventStat(Da.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                            case d.n.View_duplicateParentState /* 42 */:
                            default:
                                return;
                            case 7:
                                cVar.getContext().showToast(d.l.over_limit_tip);
                                d.this.aEr = true;
                                return;
                            case 8:
                                if (d.this.a(cVar.getContext().getPageContext(), 11001)) {
                                    cVar.a((String) null, (WriteData) null);
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    cVar.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                }
                                Da.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                                return;
                            case 11:
                                cVar.setVoiceModel(null);
                                Da.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                                return;
                            case 14:
                                if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || cVar.getWriteImagesInfo().getChosedFiles() == null || cVar.getWriteImagesInfo().getChosedFiles().size() == 0) {
                                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) cVar.getContext().getActivity(), cVar.getWriteImagesInfo().toJsonString(), true, true);
                                    if (!StringUtils.isNull(d.this.from, true)) {
                                        albumActivityConfig.getIntent().putExtra("from", d.this.from);
                                    }
                                    if (!StringUtils.isNull(d.this.forumId, true)) {
                                        albumActivityConfig.getIntent().putExtra("forum_id", d.this.forumId);
                                    }
                                    albumActivityConfig.setRequestCode(12002);
                                    if (a.Dw().getStatus() == 1) {
                                        albumActivityConfig.setRequestFrom(2);
                                        cVar.eN(1);
                                        if (cVar.getWriteImagesInfo() != null) {
                                            cVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                        }
                                    } else {
                                        cVar.eN(10);
                                        if (cVar.getWriteImagesInfo() != null) {
                                            cVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                        }
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                    return;
                                }
                                cVar.DO();
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (cVar.getWriteImagesInfo() != null && cVar.getWriteImagesInfo().getChosedFiles() != null && (size = cVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(cVar.getContext().getActivity(), 12012, cVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (d.this.aEr) {
                                    cVar.getContext().showToast(d.l.over_limit_tip);
                                }
                                if (d.this.a(cVar.getContext().getPageContext(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(cVar.getContext().getActivity(), 12004, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    cVar.DF();
                                    return;
                                }
                                switch (cVar.DK()) {
                                    case 0:
                                        cVar.DD();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        cVar.DC();
                                        return;
                                }
                            case 20:
                                cVar.Da().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.btM().mC(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = cVar.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    cVar.Da().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                                    return;
                                } else if (cVar.getContext() != null && cVar.getContext().getResources() != null) {
                                    Resources resources = cVar.getContext().getResources();
                                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                                            XiaoyingUtil.showGoPluginDetailDialog(cVar.getContext().getPageContext(), resources.getString(d.l.plugin_video_not_active), resources.getString(d.l.setup));
                                            return;
                                        } else {
                                            XiaoyingUtil.startXiaoying(cVar.getContext().getActivity());
                                            return;
                                        }
                                    }
                                    XiaoyingUtil.showGoPluginDetailDialog(cVar.getContext().getPageContext(), resources.getString(d.l.plugin_video_install_tips), resources.getString(d.l.plugin_go_install));
                                    return;
                                } else {
                                    return;
                                }
                            case 29:
                                cVar.Da().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                cVar.Da().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                cVar.DH();
                                return;
                            case 32:
                                cVar.Da().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (d.this.a(cVar.getContext().getPageContext(), 11040)) {
                                    cVar.DB();
                                    return;
                                }
                                return;
                            case 40:
                                if ((aVar.data instanceof String) || aVar.data == null) {
                                    cVar.setGraffitiFileName((String) aVar.data);
                                    return;
                                }
                                return;
                            case d.n.View_minHeight /* 43 */:
                                if (!com.baidu.tbadk.plugins.a.a(cVar.getContext().getPageContext(), true, false)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(cVar.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Da.a(5, bVar);
            Da.a(4, bVar);
            Da.a(7, bVar);
            Da.a(16, bVar);
            Da.a(14, bVar);
            Da.a(15, bVar);
            Da.a(8, bVar);
            Da.a(18, bVar);
            Da.a(20, bVar);
            Da.a(10, bVar);
            Da.a(11, bVar);
            Da.a(27, bVar);
            Da.a(29, bVar);
            Da.a(36, bVar);
            Da.a(32, bVar);
            Da.a(40, bVar);
            Da.a(43, bVar);
            Da.a(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        r rVar;
        i Da = fVar.Da();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(Da.getContext(), 7);
        Da.b(aVar);
        aVar.aCO = d.g.icon_topic_n;
        Da.b(new com.baidu.tbadk.editortools.imagetool.d(Da.getContext(), 3));
        Da.b(new com.baidu.tbadk.editortools.imagetool.b(Da.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.bul() && m.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, Da.getContext()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.aCQ = 4;
            Da.b(rVar);
        }
        Da.b(new com.baidu.tbadk.editortools.a.a(Da.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, Da.getContext()), r.class);
        if (runTask2 != null && (runTask2.getData() instanceof r)) {
            r rVar2 = (r) runTask2.getData();
            rVar2.aCQ = 6;
            Da.b(rVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Da.getContext()), r.class);
        if (runTask3 != null && runTask3.getData() != null) {
            r rVar3 = (r) runTask3.getData();
            rVar3.aCQ = 8;
            Da.b(rVar3);
        }
        Da.b(new com.baidu.tbadk.editortools.inputtool.a(Da.getContext(), true));
        Da.b(new com.baidu.tbadk.editortools.sendtool.a(Da.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Da.getContext()), r.class);
        if (runTask4 != null && runTask4.getData() != null) {
            r rVar4 = (r) runTask4.getData();
            rVar4.aCQ = 9;
            Da.b(rVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        Da.A(arrayList);
        if (!"PbChosenActivity".equals(Da.getContext().getClass().getSimpleName())) {
            Da.b(new com.baidu.tbadk.editortools.b.a(Da.getContext(), 10));
        }
        Da.Db();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.l.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
