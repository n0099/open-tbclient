package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.editortools.d {
    private DataModel<?> bsx;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean bsw = false;

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
        this.bsx = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f bf(Context context) {
        com.baidu.tbadk.editortools.i iVar = new com.baidu.tbadk.editortools.i(context);
        iVar.setIsFromPb(true);
        iVar.setBarMaxLauCount(5);
        iVar.setBarLauncherType(3);
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.C0108d.cp_bg_line_d);
        iVar.cc(false);
        iVar.setMoreButtonAtEnd(true);
        d dVar = new d(iVar);
        dVar.a(this.bsx);
        return dVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof d) {
            final com.baidu.tbadk.editortools.i Kw = fVar.Kw();
            final d dVar = (d) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.g.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (dVar != null && dVar.Kw() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                dVar.gn((String) aVar.data);
                                g.this.bsw = false;
                                return;
                            case 5:
                                if (!Kw.Kz()) {
                                    TiebaStatic.eventStat(Kw.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                            case 40:
                            case 41:
                            case 42:
                            default:
                                return;
                            case 7:
                                dVar.getContext().showToast(d.j.over_limit_tip);
                                g.this.bsw = true;
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
                                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                                if (a.KR().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(2);
                                    if (dVar.getWriteImagesInfo() != null) {
                                        dVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (dVar.getWriteImagesInfo() != null) {
                                    dVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                l.a(dVar.getContext().getActivity(), dVar.getContext().getActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (dVar.getWriteImagesInfo() != null && dVar.getWriteImagesInfo().getChosedFiles() != null && (size = dVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(dVar.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, dVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (g.this.bsw) {
                                    dVar.getContext().showToast(d.j.over_limit_tip);
                                }
                                if (g.this.a(dVar.getContext().getPageContext(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(dVar.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    dVar.KZ();
                                    return;
                                }
                                switch (dVar.Ld()) {
                                    case 0:
                                        dVar.KX();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        dVar.KW();
                                        return;
                                }
                            case 20:
                                dVar.Kw().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.bwr().mE(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = dVar.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    dVar.Kw().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
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
                                dVar.Kw().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                dVar.Kw().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                dVar.Lb();
                                return;
                            case 32:
                                dVar.Kw().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (g.this.a(dVar.getContext().getPageContext(), 11040)) {
                                    dVar.KV();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.a.a(dVar.getContext().getPageContext(), true, false)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(dVar.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Kw.a(5, bVar);
            Kw.a(4, bVar);
            Kw.a(7, bVar);
            Kw.a(16, bVar);
            Kw.a(14, bVar);
            Kw.a(15, bVar);
            Kw.a(8, bVar);
            Kw.a(18, bVar);
            Kw.a(20, bVar);
            Kw.a(10, bVar);
            Kw.a(11, bVar);
            Kw.a(27, bVar);
            Kw.a(29, bVar);
            Kw.a(36, bVar);
            Kw.a(32, bVar);
            Kw.a(43, bVar);
            Kw.a(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        r rVar;
        CustomResponsedMessage runTask;
        r rVar2;
        com.baidu.tbadk.editortools.i Kw = fVar.Kw();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(Kw.getContext(), 3);
        dVar.bqW = d.f.new_pbeditor_image_button;
        Kw.b(dVar);
        if (com.baidu.tieba.tbadkCore.voice.c.bwS() && p.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, Kw.getContext()), r.class)) != null && (rVar2 = (r) runTask.getData()) != null) {
            rVar2.bqW = d.f.new_pbeditor_voice_button;
            rVar2.bqY = 4;
            Kw.b(rVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Kw.getContext(), 5);
        aVar.bqW = d.f.new_pbeditor_at_button;
        Kw.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Kw.getContext()), r.class);
        if (runTask2 != null && runTask2.getData() != null) {
            r rVar3 = (r) runTask2.getData();
            rVar3.bqW = d.f.icon_post_more_bubble_n;
            rVar3.bqY = 9;
            Kw.b(rVar3);
        }
        Kw.b(new e(Kw.getContext()));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Kw.getContext()), r.class);
        if (runTask3 != null && runTask3.getData() != null) {
            r rVar4 = (r) runTask3.getData();
            rVar4.bqW = d.f.icon_post_more_tail_n;
            rVar4.bqY = 10;
            Kw.b(rVar4);
        }
        if (!"PbChosenActivity".equals(Kw.getContext().getClass().getSimpleName())) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(Kw.getContext(), 5);
            aVar2.bqW = d.f.new_pbeditor_gift_button;
            Kw.b(aVar2);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, Kw.getContext()), r.class);
        if (runTask4 != null && (rVar = (r) runTask4.getData()) != null) {
            rVar.bqY = 6;
            rVar.bqW = d.f.icon_post_more_location;
            Kw.b(rVar);
        }
        Kw.I(arrayList);
        r hJ = Kw.hJ(5);
        if (hJ != null) {
            hJ.bqY = 1;
            hJ.bqW = d.f.new_pbeditor_face_button;
        }
        Kw.Kx();
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
