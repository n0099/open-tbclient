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
    private DataModel<?> bso;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean bsn = false;

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
        this.bso = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f bi(Context context) {
        com.baidu.tbadk.editortools.i iVar = new com.baidu.tbadk.editortools.i(context);
        iVar.setIsFromPb(true);
        iVar.setBarMaxLauCount(5);
        iVar.setBarLauncherType(3);
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.C0107d.cp_bg_line_d);
        iVar.cb(false);
        iVar.setMoreButtonAtEnd(true);
        d dVar = new d(iVar);
        dVar.a(this.bso);
        return dVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof d) {
            final com.baidu.tbadk.editortools.i Ku = fVar.Ku();
            final d dVar = (d) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.g.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (dVar != null && dVar.Ku() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                dVar.gf((String) aVar.data);
                                g.this.bsn = false;
                                return;
                            case 5:
                                if (!Ku.Kx()) {
                                    TiebaStatic.eventStat(Ku.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                g.this.bsn = true;
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
                                if (a.KP().getStatus() == 1) {
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
                                if (g.this.bsn) {
                                    dVar.getContext().showToast(d.j.over_limit_tip);
                                }
                                if (g.this.a(dVar.getContext().getPageContext(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(dVar.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    dVar.KX();
                                    return;
                                }
                                switch (dVar.Lb()) {
                                    case 0:
                                        dVar.KV();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        dVar.KU();
                                        return;
                                }
                            case 20:
                                dVar.Ku().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.bwp().mB(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = dVar.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    dVar.Ku().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
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
                                dVar.Ku().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                dVar.Ku().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                dVar.KZ();
                                return;
                            case 32:
                                dVar.Ku().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (g.this.a(dVar.getContext().getPageContext(), 11040)) {
                                    dVar.KT();
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
            Ku.a(5, bVar);
            Ku.a(4, bVar);
            Ku.a(7, bVar);
            Ku.a(16, bVar);
            Ku.a(14, bVar);
            Ku.a(15, bVar);
            Ku.a(8, bVar);
            Ku.a(18, bVar);
            Ku.a(20, bVar);
            Ku.a(10, bVar);
            Ku.a(11, bVar);
            Ku.a(27, bVar);
            Ku.a(29, bVar);
            Ku.a(36, bVar);
            Ku.a(32, bVar);
            Ku.a(43, bVar);
            Ku.a(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        r rVar;
        CustomResponsedMessage runTask;
        r rVar2;
        com.baidu.tbadk.editortools.i Ku = fVar.Ku();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(Ku.getContext(), 3);
        dVar.bqN = d.f.new_pbeditor_image_button;
        Ku.b(dVar);
        if (com.baidu.tieba.tbadkCore.voice.c.bwQ() && p.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, Ku.getContext()), r.class)) != null && (rVar2 = (r) runTask.getData()) != null) {
            rVar2.bqN = d.f.new_pbeditor_voice_button;
            rVar2.bqP = 4;
            Ku.b(rVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Ku.getContext(), 5);
        aVar.bqN = d.f.new_pbeditor_at_button;
        Ku.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Ku.getContext()), r.class);
        if (runTask2 != null && runTask2.getData() != null) {
            r rVar3 = (r) runTask2.getData();
            rVar3.bqN = d.f.icon_post_more_bubble_n;
            rVar3.bqP = 9;
            Ku.b(rVar3);
        }
        Ku.b(new e(Ku.getContext()));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Ku.getContext()), r.class);
        if (runTask3 != null && runTask3.getData() != null) {
            r rVar4 = (r) runTask3.getData();
            rVar4.bqN = d.f.icon_post_more_tail_n;
            rVar4.bqP = 10;
            Ku.b(rVar4);
        }
        if (!"PbChosenActivity".equals(Ku.getContext().getClass().getSimpleName())) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(Ku.getContext(), 5);
            aVar2.bqN = d.f.new_pbeditor_gift_button;
            Ku.b(aVar2);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, Ku.getContext()), r.class);
        if (runTask4 != null && (rVar = (r) runTask4.getData()) != null) {
            rVar.bqP = 6;
            rVar.bqN = d.f.icon_post_more_location;
            Ku.b(rVar);
        }
        Ku.I(arrayList);
        r hJ = Ku.hJ(5);
        if (hJ != null) {
            hJ.bqP = 1;
            hJ.bqN = d.f.new_pbeditor_face_button;
        }
        Ku.Kv();
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
