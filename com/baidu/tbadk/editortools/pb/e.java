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
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.editortools.d {
    private DataModel<?> aDu;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean aDt = false;

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
        this.aDu = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aX(Context context) {
        i iVar = new i(context);
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.C0080d.cp_bg_line_d);
        iVar.bx(false);
        d dVar = new d(iVar);
        dVar.a(this.aDu);
        return dVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof d) {
            final i CI = fVar.CI();
            final d dVar = (d) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.e.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (dVar != null && dVar.CI() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                dVar.fU((String) aVar.data);
                                e.this.aDt = false;
                                return;
                            case 5:
                                if (!CI.CL()) {
                                    TiebaStatic.eventStat(CI.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                e.this.aDt = true;
                                return;
                            case 8:
                                if (e.this.a(dVar.getContext().getPageContext(), 11001)) {
                                    dVar.a((String) null, (WriteData) null);
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    dVar.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                }
                                CI.b(new com.baidu.tbadk.editortools.a(2, 6, " "));
                                return;
                            case 11:
                                dVar.setVoiceModel(null);
                                CI.b(new com.baidu.tbadk.editortools.a(2, 6, null));
                                return;
                            case 14:
                                if ((aVar.data != null && aVar.data != null && (aVar.data instanceof Boolean) && ((Boolean) aVar.data).booleanValue()) || dVar.getWriteImagesInfo().getChosedFiles() == null || dVar.getWriteImagesInfo().getChosedFiles().size() == 0) {
                                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) dVar.getContext().getActivity(), dVar.getWriteImagesInfo().toJsonString(), true, true);
                                    if (!StringUtils.isNull(e.this.from, true)) {
                                        albumActivityConfig.getIntent().putExtra("from", e.this.from);
                                    }
                                    if (!StringUtils.isNull(e.this.forumId, true)) {
                                        albumActivityConfig.getIntent().putExtra("forum_id", e.this.forumId);
                                    }
                                    albumActivityConfig.setRequestCode(12002);
                                    if (a.Dd().getStatus() == 1) {
                                        albumActivityConfig.setRequestFrom(2);
                                        dVar.eY(1);
                                        if (dVar.getWriteImagesInfo() != null) {
                                            dVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                        }
                                    } else {
                                        dVar.eY(10);
                                        if (dVar.getWriteImagesInfo() != null) {
                                            dVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                        }
                                    }
                                    if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_img_to_emotion_collection_tips"), true)) {
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_IMG_TO_EMOTION_CONNECTION_DIALOG));
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_img_to_emotion_collection_tips"), false);
                                        return;
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                    return;
                                }
                                dVar.Dv();
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (dVar.getWriteImagesInfo() != null && dVar.getWriteImagesInfo().getChosedFiles() != null && (size = dVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(dVar.getContext().getActivity(), 12012, dVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (e.this.aDt) {
                                    dVar.getContext().showToast(d.j.over_limit_tip);
                                }
                                if (e.this.a(dVar.getContext().getPageContext(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(dVar.getContext().getActivity(), 12004, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    dVar.Dn();
                                    return;
                                }
                                switch (dVar.Dr()) {
                                    case 0:
                                        dVar.Dl();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        dVar.Dk();
                                        return;
                                }
                            case 20:
                                dVar.CI().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.bva().my(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = dVar.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    dVar.CI().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
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
                                dVar.CI().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                dVar.CI().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                dVar.Dp();
                                return;
                            case 32:
                                dVar.CI().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case d.l.View_clickable /* 36 */:
                                if (e.this.a(dVar.getContext().getPageContext(), 11040)) {
                                    dVar.Dj();
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
            CI.a(5, bVar);
            CI.a(4, bVar);
            CI.a(7, bVar);
            CI.a(16, bVar);
            CI.a(14, bVar);
            CI.a(15, bVar);
            CI.a(8, bVar);
            CI.a(18, bVar);
            CI.a(20, bVar);
            CI.a(10, bVar);
            CI.a(11, bVar);
            CI.a(27, bVar);
            CI.a(29, bVar);
            CI.a(36, bVar);
            CI.a(32, bVar);
            CI.a(43, bVar);
            CI.a(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        r rVar;
        i CI = fVar.CI();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(CI.getContext(), 7);
        CI.b(aVar);
        aVar.aBQ = d.f.icon_topic_n;
        CI.b(new com.baidu.tbadk.editortools.imagetool.d(CI.getContext(), 3));
        CI.b(new com.baidu.tbadk.editortools.imagetool.b(CI.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.bvy() && n.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CI.getContext()), r.class)) != null && (rVar = (r) runTask.getData()) != null) {
            rVar.aBS = 4;
            CI.b(rVar);
        }
        CI.b(new com.baidu.tbadk.editortools.a.a(CI.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, CI.getContext()), r.class);
        if (runTask2 != null && (runTask2.getData() instanceof r)) {
            r rVar2 = (r) runTask2.getData();
            rVar2.aBS = 6;
            CI.b(rVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, CI.getContext()), r.class);
        if (runTask3 != null && runTask3.getData() != null) {
            r rVar3 = (r) runTask3.getData();
            rVar3.aBS = 8;
            CI.b(rVar3);
        }
        CI.b(new com.baidu.tbadk.editortools.inputtool.a(CI.getContext(), true));
        CI.b(new com.baidu.tbadk.editortools.sendtool.a(CI.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, CI.getContext()), r.class);
        if (runTask4 != null && runTask4.getData() != null) {
            r rVar4 = (r) runTask4.getData();
            rVar4.aBS = 9;
            CI.b(rVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        CI.A(arrayList);
        if (!"PbChosenActivity".equals(CI.getContext().getClass().getSimpleName())) {
            CI.b(new com.baidu.tbadk.editortools.b.a(CI.getContext(), 10));
        }
        CI.CJ();
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
