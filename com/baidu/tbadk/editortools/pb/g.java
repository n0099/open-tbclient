package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class g extends com.baidu.tbadk.editortools.c {
    private ForumData dzq;
    private DataModel<?> dzs;
    private String forumName = null;
    private String from = null;
    private boolean dzr = false;

    public void a(ForumData forumData) {
        this.dzq = forumData;
    }

    public ForumData aPr() {
        return this.dzq;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String getFrom() {
        return this.from;
    }

    public void a(DataModel<?> dataModel) {
        this.dzs = dataModel;
    }

    public DataModel<?> aPs() {
        return this.dzs;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dV(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.gD(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.a(this.dzs);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof e) {
            final EditorTools aOy = dVar.aOy();
            final e eVar = (e) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.g.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (eVar != null && eVar.aOy() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar.vn((String) aVar.data);
                                g.this.dzr = false;
                                return;
                            case 5:
                                if (!aOy.aOA()) {
                                    TiebaStatic.eventStat(aOy.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                eVar.aPh().showToast(R.string.over_limit_tip);
                                g.this.dzr = true;
                                return;
                            case 8:
                                if (g.this.a(eVar.aPh().getPageContext(), 11001)) {
                                    eVar.a((String) null, (WriteData) null);
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    eVar.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                    eVar.a(true, (PostWriteCallBackData) null);
                                    return;
                                }
                                return;
                            case 11:
                                eVar.setVoiceModel(null);
                                return;
                            case 14:
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) eVar.aPh().getActivity(), eVar.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(g.this.from, true)) {
                                    albumActivityConfig.getIntent().putExtra("from", g.this.from);
                                }
                                if (g.this.dzq != null && !StringUtils.isNull(g.this.dzq.getId(), true)) {
                                    albumActivityConfig.getIntent().putExtra("forum_id", g.this.dzq.getId());
                                }
                                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                if (a.aOU().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(2);
                                    if (eVar.getWriteImagesInfo() != null) {
                                        eVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (eVar.getWriteImagesInfo() != null) {
                                    eVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                l.hideSoftKeyPad(eVar.aPh().getActivity(), eVar.aPh().getActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (eVar.getWriteImagesInfo() != null && eVar.getWriteImagesInfo().getChosedFiles() != null && (size = eVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(eVar.aPh().getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, eVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (g.this.dzr) {
                                    eVar.aPh().showToast(R.string.over_limit_tip);
                                }
                                if (g.this.a(eVar.aPh().getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(eVar.aPh().getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    eVar.aPd();
                                    return;
                                }
                                switch (eVar.aPi()) {
                                    case 0:
                                        eVar.aPa();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        eVar.aOZ();
                                        return;
                                }
                            case 20:
                                eVar.aOy().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.cMb().sV(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = eVar.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    eVar.aOy().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                                    return;
                                } else if (eVar.aPh() != null && eVar.aPh().getResources() != null) {
                                    Resources resources = eVar.aPh().getResources();
                                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                                            XiaoyingUtil.showGoPluginDetailDialog(eVar.aPh().getPageContext(), resources.getString(R.string.plugin_video_not_active), resources.getString(R.string.setup));
                                            return;
                                        } else {
                                            XiaoyingUtil.startXiaoying(eVar.aPh().getActivity());
                                            return;
                                        }
                                    }
                                    XiaoyingUtil.showGoPluginDetailDialog(eVar.aPh().getPageContext(), resources.getString(R.string.plugin_video_install_tips), resources.getString(R.string.plugin_go_install));
                                    return;
                                } else {
                                    return;
                                }
                            case 29:
                                eVar.aOy().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                eVar.aOy().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                eVar.aPf();
                                return;
                            case 32:
                                eVar.aOy().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (g.this.a(eVar.aPh().getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    eVar.aOY();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(eVar.aPh().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(eVar.aPh().getActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_PB);
                                    if (g.this.dzq != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(g.this.dzq.getId(), 0L), g.this.dzq.getFirst_class(), g.this.dzq.getSecond_class());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            aOy.setActionListener(5, bVar);
            aOy.setActionListener(4, bVar);
            aOy.setActionListener(7, bVar);
            aOy.setActionListener(16, bVar);
            aOy.setActionListener(14, bVar);
            aOy.setActionListener(15, bVar);
            aOy.setActionListener(8, bVar);
            aOy.setActionListener(18, bVar);
            aOy.setActionListener(20, bVar);
            aOy.setActionListener(10, bVar);
            aOy.setActionListener(11, bVar);
            aOy.setActionListener(27, bVar);
            aOy.setActionListener(29, bVar);
            aOy.setActionListener(36, bVar);
            aOy.setActionListener(32, bVar);
            aOy.setActionListener(43, bVar);
            aOy.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.l lVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar2;
        EditorTools aOy = dVar.aOy();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        aOy.b(new com.baidu.tbadk.editortools.imagetool.d(aOy.getContext(), 3));
        if (com.baidu.tieba.tbadkCore.voice.c.cMD() && s.d(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, aOy.getContext()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar2.dxQ = 4;
            aOy.b(lVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(aOy.getContext(), 5);
        aVar.dxM = R.drawable.icon_pure_post_at24_svg;
        aVar.dxO = true;
        aOy.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, aOy.getContext()), com.baidu.tbadk.editortools.l.class);
        if (runTask2 != null && runTask2.getData() != null) {
            com.baidu.tbadk.editortools.l lVar3 = (com.baidu.tbadk.editortools.l) runTask2.getData();
            lVar3.dxM = R.drawable.icon_pure_more_bubble40_svg;
            lVar3.dxQ = 9;
            aOy.b(lVar3);
        }
        aOy.b(new f(aOy.getContext()));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, aOy.getContext()), com.baidu.tbadk.editortools.l.class);
        if (runTask3 != null && runTask3.getData() != null) {
            com.baidu.tbadk.editortools.l lVar4 = (com.baidu.tbadk.editortools.l) runTask3.getData();
            lVar4.dxM = R.drawable.icon_pure_more_tail40_svg;
            lVar4.dxQ = 10;
            aOy.b(lVar4);
        }
        if (!"PbChosenActivity".equals(aOy.getContext().getClass().getSimpleName())) {
            aOy.b(new com.baidu.tbadk.editortools.b.a(aOy.getContext(), 5));
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, aOy.getContext()), com.baidu.tbadk.editortools.l.class);
        if (runTask4 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar.dxQ = 6;
            aOy.b(lVar);
        }
        aOy.aI(arrayList);
        com.baidu.tbadk.editortools.l mr = aOy.mr(5);
        if (mr != null) {
            mr.dxQ = 1;
        }
        aOy.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }
}
