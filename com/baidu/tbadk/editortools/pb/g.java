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
import com.baidu.tbadk.editortools.r;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.o;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.editortools.d {
    private DataModel<?> aEd;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean aEc = false;

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
        this.aEd = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aZ(Context context) {
        com.baidu.tbadk.editortools.i iVar = new com.baidu.tbadk.editortools.i(context);
        iVar.setIsFromPb(true);
        iVar.setBarMaxLauCount(5);
        iVar.setBarLauncherType(3);
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.C0082d.cp_bg_line_d);
        iVar.by(false);
        iVar.setMoreButtonAtEnd(true);
        d dVar = new d(iVar);
        dVar.a(this.aEd);
        return dVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof d) {
            final com.baidu.tbadk.editortools.i Dd = fVar.Dd();
            final d dVar = (d) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.g.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (dVar != null && dVar.Dd() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                dVar.fY((String) aVar.data);
                                g.this.aEc = false;
                                return;
                            case 5:
                                if (!Dd.Dg()) {
                                    TiebaStatic.eventStat(Dd.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                            case d.l.View_longClickable /* 37 */:
                            case d.l.View_saveEnabled /* 38 */:
                            case d.l.View_filterTouchesWhenObscured /* 39 */:
                            case d.l.View_drawingCacheQuality /* 40 */:
                            case d.l.View_keepScreenOn /* 41 */:
                            case d.l.View_duplicateParentState /* 42 */:
                            default:
                                return;
                            case 7:
                                dVar.getContext().showToast(d.j.over_limit_tip);
                                g.this.aEc = true;
                                return;
                            case 8:
                                if (g.this.a(dVar.getContext().getPageContext(), 11001)) {
                                    dVar.a((String) null, (WriteData) null);
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    dVar.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                    dVar.a(true, (PostWriteCallBackData) null);
                                    return;
                                }
                                return;
                            case 11:
                                dVar.setVoiceModel(null);
                                return;
                            case 14:
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) dVar.getContext().getActivity(), dVar.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(g.this.from, true)) {
                                    albumActivityConfig.getIntent().putExtra("from", g.this.from);
                                }
                                if (!StringUtils.isNull(g.this.forumId, true)) {
                                    albumActivityConfig.getIntent().putExtra("forum_id", g.this.forumId);
                                }
                                albumActivityConfig.setRequestCode(12002);
                                if (a.Dy().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(2);
                                    if (dVar.getWriteImagesInfo() != null) {
                                        dVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (dVar.getWriteImagesInfo() != null) {
                                    dVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (dVar.getWriteImagesInfo() != null && dVar.getWriteImagesInfo().getChosedFiles() != null && (size = dVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(dVar.getContext().getActivity(), 12012, dVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (g.this.aEc) {
                                    dVar.getContext().showToast(d.j.over_limit_tip);
                                }
                                if (g.this.a(dVar.getContext().getPageContext(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(dVar.getContext().getActivity(), 12004, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    dVar.DG();
                                    return;
                                }
                                switch (dVar.DK()) {
                                    case 0:
                                        dVar.DE();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        dVar.DD();
                                        return;
                                }
                            case 20:
                                dVar.Dd().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.bwW().nd(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = dVar.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    dVar.Dd().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                                    return;
                                } else if (dVar.getContext() != null && dVar.getContext().getResources() != null) {
                                    Resources resources = dVar.getContext().getResources();
                                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                                            XiaoyingUtil.showGoPluginDetailDialog(dVar.getContext().getPageContext(), resources.getString(d.j.plugin_video_not_active), resources.getString(d.j.setup));
                                            return;
                                        } else {
                                            XiaoyingUtil.startXiaoying(dVar.getContext().getActivity());
                                            return;
                                        }
                                    }
                                    XiaoyingUtil.showGoPluginDetailDialog(dVar.getContext().getPageContext(), resources.getString(d.j.plugin_video_install_tips), resources.getString(d.j.plugin_go_install));
                                    return;
                                } else {
                                    return;
                                }
                            case 29:
                                dVar.Dd().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                dVar.Dd().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                dVar.DI();
                                return;
                            case 32:
                                dVar.Dd().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case d.l.View_clickable /* 36 */:
                                if (g.this.a(dVar.getContext().getPageContext(), 11040)) {
                                    dVar.DC();
                                    return;
                                }
                                return;
                            case d.l.View_minHeight /* 43 */:
                                if (!com.baidu.tbadk.plugins.a.a(dVar.getContext().getPageContext(), true, false)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(dVar.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Dd.a(5, bVar);
            Dd.a(4, bVar);
            Dd.a(7, bVar);
            Dd.a(16, bVar);
            Dd.a(14, bVar);
            Dd.a(15, bVar);
            Dd.a(8, bVar);
            Dd.a(18, bVar);
            Dd.a(20, bVar);
            Dd.a(10, bVar);
            Dd.a(11, bVar);
            Dd.a(27, bVar);
            Dd.a(29, bVar);
            Dd.a(36, bVar);
            Dd.a(32, bVar);
            Dd.a(43, bVar);
            Dd.a(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        r rVar;
        CustomResponsedMessage runTask;
        r rVar2;
        com.baidu.tbadk.editortools.i Dd = fVar.Dd();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(Dd.getContext(), 3);
        dVar.aCB = d.f.new_pbeditor_image_button;
        Dd.b(dVar);
        if (com.baidu.tieba.tbadkCore.voice.c.bxv() && o.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, Dd.getContext()), r.class)) != null && (rVar2 = (r) runTask.getData()) != null) {
            rVar2.aCB = d.f.new_pbeditor_voice_button;
            rVar2.aCD = 4;
            Dd.b(rVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Dd.getContext(), 5);
        aVar.aCB = d.f.new_pbeditor_at_button;
        Dd.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Dd.getContext()), r.class);
        if (runTask2 != null && runTask2.getData() != null) {
            r rVar3 = (r) runTask2.getData();
            rVar3.aCB = d.f.icon_post_more_bubble_n;
            rVar3.aCD = 9;
            Dd.b(rVar3);
        }
        Dd.b(new e(Dd.getContext()));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Dd.getContext()), r.class);
        if (runTask3 != null && runTask3.getData() != null) {
            r rVar4 = (r) runTask3.getData();
            rVar4.aCB = d.f.icon_post_more_tail_n;
            rVar4.aCD = 10;
            Dd.b(rVar4);
        }
        if (!"PbChosenActivity".equals(Dd.getContext().getClass().getSimpleName())) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(Dd.getContext(), 5);
            aVar2.aCB = d.f.new_pbeditor_gift_button;
            Dd.b(aVar2);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, Dd.getContext()), r.class);
        if (runTask4 != null && (rVar = (r) runTask4.getData()) != null) {
            rVar.aCD = 6;
            rVar.aCB = d.f.icon_post_more_location;
            Dd.b(rVar);
        }
        Dd.B(arrayList);
        r eP = Dd.eP(5);
        if (eP != null) {
            eP.aCD = 1;
            eP.aCB = d.f.new_pbeditor_face_button;
        }
        Dd.De();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
