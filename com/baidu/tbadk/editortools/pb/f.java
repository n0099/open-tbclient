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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class f extends com.baidu.tbadk.editortools.c {
    private ForumData aNu;
    private DataModel<?> aNw;
    private String forumName = null;
    private String from = null;
    private boolean aNv = false;

    public void a(ForumData forumData) {
        this.aNu = forumData;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void a(DataModel<?> dataModel) {
        this.aNw = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d aZ(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(d.C0141d.cp_bg_line_d);
        editorTools.bC(false);
        editorTools.setMoreButtonAtEnd(true);
        d dVar = new d(editorTools);
        dVar.a(this.aNw);
        return dVar;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof d) {
            final EditorTools Hg = dVar.Hg();
            final d dVar2 = (d) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.f.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (dVar2 != null && dVar2.Hg() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                dVar2.gM((String) aVar.data);
                                f.this.aNv = false;
                                return;
                            case 5:
                                if (!Hg.Hj()) {
                                    TiebaStatic.eventStat(Hg.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                dVar2.getContext().showToast(d.k.over_limit_tip);
                                f.this.aNv = true;
                                return;
                            case 8:
                                if (f.this.a(dVar2.getContext().getPageContext(), 11001)) {
                                    dVar2.a((String) null, (WriteData) null);
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    dVar2.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                    dVar2.a(true, (PostWriteCallBackData) null);
                                    return;
                                }
                                return;
                            case 11:
                                dVar2.setVoiceModel(null);
                                return;
                            case 14:
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) dVar2.getContext().getActivity(), dVar2.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(f.this.from, true)) {
                                    albumActivityConfig.getIntent().putExtra("from", f.this.from);
                                }
                                if (f.this.aNu != null && !StringUtils.isNull(f.this.aNu.getId(), true)) {
                                    albumActivityConfig.getIntent().putExtra("forum_id", f.this.aNu.getId());
                                }
                                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                                if (a.HC().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(2);
                                    if (dVar2.getWriteImagesInfo() != null) {
                                        dVar2.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (dVar2.getWriteImagesInfo() != null) {
                                    dVar2.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                l.b(dVar2.getContext().getActivity(), dVar2.getContext().getActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (dVar2.getWriteImagesInfo() != null && dVar2.getWriteImagesInfo().getChosedFiles() != null && (size = dVar2.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(dVar2.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, dVar2.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (f.this.aNv) {
                                    dVar2.getContext().showToast(d.k.over_limit_tip);
                                }
                                if (f.this.a(dVar2.getContext().getPageContext(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(dVar2.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    dVar2.HL();
                                    return;
                                }
                                switch (dVar2.HP()) {
                                    case 0:
                                        dVar2.HI();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        dVar2.HH();
                                        return;
                                }
                            case 20:
                                dVar2.Hg().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.bxH().mz(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = dVar2.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    dVar2.Hg().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                                    return;
                                } else if (dVar2.getContext() != null && dVar2.getContext().getResources() != null) {
                                    Resources resources = dVar2.getContext().getResources();
                                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                                            XiaoyingUtil.showGoPluginDetailDialog(dVar2.getContext().getPageContext(), resources.getString(d.k.plugin_video_not_active), resources.getString(d.k.setup));
                                            return;
                                        } else {
                                            XiaoyingUtil.startXiaoying(dVar2.getContext().getActivity());
                                            return;
                                        }
                                    }
                                    XiaoyingUtil.showGoPluginDetailDialog(dVar2.getContext().getPageContext(), resources.getString(d.k.plugin_video_install_tips), resources.getString(d.k.plugin_go_install));
                                    return;
                                } else {
                                    return;
                                }
                            case 29:
                                dVar2.Hg().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                dVar2.Hg().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                dVar2.HN();
                                return;
                            case 32:
                                dVar2.Hg().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (f.this.a(dVar2.getContext().getPageContext(), 11040)) {
                                    dVar2.HG();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(dVar2.getContext().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(dVar2.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                                    if (f.this.aNu != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(f.this.aNu.getId(), 0L), f.this.aNu.getFirst_class(), f.this.aNu.getSecond_class());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            Hg.setActionListener(5, bVar);
            Hg.setActionListener(4, bVar);
            Hg.setActionListener(7, bVar);
            Hg.setActionListener(16, bVar);
            Hg.setActionListener(14, bVar);
            Hg.setActionListener(15, bVar);
            Hg.setActionListener(8, bVar);
            Hg.setActionListener(18, bVar);
            Hg.setActionListener(20, bVar);
            Hg.setActionListener(10, bVar);
            Hg.setActionListener(11, bVar);
            Hg.setActionListener(27, bVar);
            Hg.setActionListener(29, bVar);
            Hg.setActionListener(36, bVar);
            Hg.setActionListener(32, bVar);
            Hg.setActionListener(43, bVar);
            Hg.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        k kVar;
        CustomResponsedMessage runTask;
        k kVar2;
        EditorTools Hg = dVar.Hg();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.imagetool.d dVar2 = new com.baidu.tbadk.editortools.imagetool.d(Hg.getContext(), 3);
        dVar2.aLW = d.f.new_pbeditor_image_button;
        Hg.b(dVar2);
        if (com.baidu.tieba.tbadkCore.voice.c.byj() && p.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, Hg.getContext()), k.class)) != null && (kVar2 = (k) runTask.getData()) != null) {
            kVar2.aLW = d.f.new_pbeditor_voice_button;
            kVar2.aLY = 4;
            Hg.b(kVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Hg.getContext(), 5);
        aVar.aLW = d.f.new_pbeditor_at_button;
        Hg.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, Hg.getContext()), k.class);
        if (runTask2 != null && runTask2.getData() != null) {
            k kVar3 = (k) runTask2.getData();
            kVar3.aLW = d.f.icon_post_more_bubble_n;
            kVar3.aLY = 9;
            Hg.b(kVar3);
        }
        Hg.b(new e(Hg.getContext()));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, Hg.getContext()), k.class);
        if (runTask3 != null && runTask3.getData() != null) {
            k kVar4 = (k) runTask3.getData();
            kVar4.aLW = d.f.icon_post_more_tail_n;
            kVar4.aLY = 10;
            Hg.b(kVar4);
        }
        if (!"PbChosenActivity".equals(Hg.getContext().getClass().getSimpleName())) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(Hg.getContext(), 5);
            aVar2.aLW = d.f.new_pbeditor_gift_button;
            Hg.b(aVar2);
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, Hg.getContext()), k.class);
        if (runTask4 != null && (kVar = (k) runTask4.getData()) != null) {
            kVar.aLY = 6;
            kVar.aLW = d.f.icon_post_more_location;
            Hg.b(kVar);
        }
        Hg.F(arrayList);
        k eM = Hg.eM(5);
        if (eM != null) {
            eM.aLY = 1;
            eM.aLW = d.f.new_pbeditor_face_button;
        }
        Hg.Hh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.k.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
