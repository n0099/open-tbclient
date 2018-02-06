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
    private DataModel<?> buK;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean buJ = false;

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
        this.buK = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f be(Context context) {
        com.baidu.tbadk.editortools.i iVar = new com.baidu.tbadk.editortools.i(context);
        iVar.setIsFromPb(true);
        iVar.setBarMaxLauCount(5);
        iVar.setBarLauncherType(3);
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.C0140d.cp_bg_line_d);
        iVar.cg(false);
        iVar.setMoreButtonAtEnd(true);
        d dVar = new d(iVar);
        dVar.a(this.buK);
        return dVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof d) {
            final com.baidu.tbadk.editortools.i Lc = fVar.Lc();
            final d dVar = (d) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.g.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (dVar != null && dVar.Lc() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                dVar.gx((String) aVar.data);
                                g.this.buJ = false;
                                return;
                            case 5:
                                if (!Lc.Lf()) {
                                    TiebaStatic.eventStat(Lc.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                g.this.buJ = true;
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
                                if (a.Ly().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(2);
                                    if (dVar.getWriteImagesInfo() != null) {
                                        dVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (dVar.getWriteImagesInfo() != null) {
                                    dVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                l.a(dVar.getContext().getActivity(), dVar.getContext().getActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (dVar.getWriteImagesInfo() != null && dVar.getWriteImagesInfo().getChosedFiles() != null && (size = dVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(dVar.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, dVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (g.this.buJ) {
                                    dVar.getContext().showToast(d.j.over_limit_tip);
                                }
                                if (g.this.a(dVar.getContext().getPageContext(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(dVar.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    dVar.LG();
                                    return;
                                }
                                switch (dVar.LK()) {
                                    case 0:
                                        dVar.LE();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        dVar.LD();
                                        return;
                                }
                            case 20:
                                dVar.Lc().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.bxA().mL(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = dVar.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    dVar.Lc().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
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
                                dVar.Lc().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                dVar.Lc().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                dVar.LI();
                                return;
                            case 32:
                                dVar.Lc().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (g.this.a(dVar.getContext().getPageContext(), 11040)) {
                                    dVar.LC();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.a.a(dVar.getContext().getPageContext(), true, false)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotSelectActivityConfig(dVar.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Lc.a(5, bVar);
            Lc.a(4, bVar);
            Lc.a(7, bVar);
            Lc.a(16, bVar);
            Lc.a(14, bVar);
            Lc.a(15, bVar);
            Lc.a(8, bVar);
            Lc.a(18, bVar);
            Lc.a(20, bVar);
            Lc.a(10, bVar);
            Lc.a(11, bVar);
            Lc.a(27, bVar);
            Lc.a(29, bVar);
            Lc.a(36, bVar);
            Lc.a(32, bVar);
            Lc.a(43, bVar);
            Lc.a(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        r rVar;
        CustomResponsedMessage runTask;
        r rVar2;
        com.baidu.tbadk.editortools.i Lc = fVar.Lc();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(Lc.getContext(), 3);
        dVar.btj = d.f.new_pbeditor_image_button;
        Lc.b(dVar);
        if (com.baidu.tieba.tbadkCore.voice.c.byc() && p.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, Lc.getContext()), r.class)) != null && (rVar2 = (r) runTask.getData()) != null) {
            rVar2.btj = d.f.new_pbeditor_voice_button;
            rVar2.btl = 4;
            Lc.b(rVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Lc.getContext(), 5);
        aVar.btj = d.f.new_pbeditor_at_button;
        Lc.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, Lc.getContext()), r.class);
        if (runTask2 != null && runTask2.getData() != null) {
            r rVar3 = (r) runTask2.getData();
            rVar3.btj = d.f.icon_post_more_bubble_n;
            rVar3.btl = 9;
            Lc.b(rVar3);
        }
        Lc.b(new e(Lc.getContext()));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, Lc.getContext()), r.class);
        if (runTask3 != null && runTask3.getData() != null) {
            r rVar4 = (r) runTask3.getData();
            rVar4.btj = d.f.icon_post_more_tail_n;
            rVar4.btl = 10;
            Lc.b(rVar4);
        }
        if (!"PbChosenActivity".equals(Lc.getContext().getClass().getSimpleName())) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(Lc.getContext(), 5);
            aVar2.btj = d.f.new_pbeditor_gift_button;
            Lc.b(aVar2);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, Lc.getContext()), r.class);
        if (runTask4 != null && (rVar = (r) runTask4.getData()) != null) {
            rVar.btl = 6;
            rVar.btj = d.f.icon_post_more_location;
            Lc.b(rVar);
        }
        Lc.K(arrayList);
        r hI = Lc.hI(5);
        if (hI != null) {
            hI.btl = 1;
            hI.btj = d.f.new_pbeditor_face_button;
        }
        Lc.Ld();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
