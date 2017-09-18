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
    private DataModel<?> aDH;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean aDG = false;

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
        this.aDH = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aY(Context context) {
        i iVar = new i(context);
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.e.cp_bg_line_d);
        iVar.bE(false);
        c cVar = new c(iVar);
        cVar.a(this.aDH);
        return cVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof c) {
            final i CV = fVar.CV();
            final c cVar = (c) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.d.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (cVar != null && cVar.CV() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                cVar.fV((String) aVar.data);
                                d.this.aDG = false;
                                return;
                            case 5:
                                if (!CV.CY()) {
                                    TiebaStatic.eventStat(CV.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                            case d.n.View_longClickable /* 37 */:
                            case d.n.View_saveEnabled /* 38 */:
                            case d.n.View_filterTouchesWhenObscured /* 39 */:
                            case d.n.View_keepScreenOn /* 41 */:
                            case d.n.View_duplicateParentState /* 42 */:
                            default:
                                return;
                            case 7:
                                cVar.getContext().showToast(d.l.over_limit_tip);
                                d.this.aDG = true;
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
                                CV.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                                return;
                            case 11:
                                cVar.setVoiceModel(null);
                                CV.b(new com.baidu.tbadk.editortools.a(2, 6, null));
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
                                    if (a.Dr().getStatus() == 1) {
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
                                cVar.DJ();
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (cVar.getWriteImagesInfo() != null && cVar.getWriteImagesInfo().getChosedFiles() != null && (size = cVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(cVar.getContext().getActivity(), 12012, cVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (d.this.aDG) {
                                    cVar.getContext().showToast(d.l.over_limit_tip);
                                }
                                if (d.this.a(cVar.getContext().getPageContext(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(cVar.getContext().getActivity(), 12004, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    cVar.DA();
                                    return;
                                }
                                switch (cVar.DF()) {
                                    case 0:
                                        cVar.Dy();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        cVar.Dx();
                                        return;
                                }
                            case 20:
                                cVar.CV().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.btf().mJ(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = cVar.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    cVar.CV().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
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
                                cVar.CV().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                cVar.CV().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                cVar.DC();
                                return;
                            case 32:
                                cVar.CV().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case d.n.View_clickable /* 36 */:
                                if (d.this.a(cVar.getContext().getPageContext(), 11040)) {
                                    cVar.Dw();
                                    return;
                                }
                                return;
                            case d.n.View_drawingCacheQuality /* 40 */:
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
            CV.a(5, bVar);
            CV.a(4, bVar);
            CV.a(7, bVar);
            CV.a(16, bVar);
            CV.a(14, bVar);
            CV.a(15, bVar);
            CV.a(8, bVar);
            CV.a(18, bVar);
            CV.a(20, bVar);
            CV.a(10, bVar);
            CV.a(11, bVar);
            CV.a(27, bVar);
            CV.a(29, bVar);
            CV.a(36, bVar);
            CV.a(32, bVar);
            CV.a(40, bVar);
            CV.a(43, bVar);
            CV.a(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        r rVar;
        i CV = fVar.CV();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(CV.getContext(), 7);
        CV.b(aVar);
        aVar.aBZ = d.g.icon_topic_n;
        CV.b(new com.baidu.tbadk.editortools.imagetool.d(CV.getContext(), 3));
        CV.b(new com.baidu.tbadk.editortools.imagetool.b(CV.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.btE() && m.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CV.getContext()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.aCb = 4;
            CV.b(rVar);
        }
        CV.b(new com.baidu.tbadk.editortools.a.a(CV.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, CV.getContext()), r.class);
        if (runTask2 != null && (runTask2.getData() instanceof r)) {
            r rVar2 = (r) runTask2.getData();
            rVar2.aCb = 6;
            CV.b(rVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, CV.getContext()), r.class);
        if (runTask3 != null && runTask3.getData() != null) {
            r rVar3 = (r) runTask3.getData();
            rVar3.aCb = 8;
            CV.b(rVar3);
        }
        CV.b(new com.baidu.tbadk.editortools.inputtool.a(CV.getContext(), true));
        CV.b(new com.baidu.tbadk.editortools.sendtool.a(CV.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, CV.getContext()), r.class);
        if (runTask4 != null && runTask4.getData() != null) {
            r rVar4 = (r) runTask4.getData();
            rVar4.aCb = 9;
            CV.b(rVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        CV.A(arrayList);
        if (!"PbChosenActivity".equals(CV.getContext().getClass().getSimpleName())) {
            CV.b(new com.baidu.tbadk.editortools.b.a(CV.getContext(), 10));
        }
        CV.CW();
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
