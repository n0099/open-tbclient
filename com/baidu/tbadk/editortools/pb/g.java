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
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g extends com.baidu.tbadk.editortools.c {
    private ForumData duJ;
    private DataModel<?> duL;
    private String forumName = null;
    private String from = null;
    private boolean duK = false;

    public void a(ForumData forumData) {
        this.duJ = forumData;
    }

    public ForumData aMO() {
        return this.duJ;
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
        this.duL = dataModel;
    }

    public DataModel<?> aMP() {
        return this.duL;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dS(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.gv(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.a(this.duL);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof e) {
            final EditorTools aLV = dVar.aLV();
            final e eVar = (e) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.g.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (eVar != null && eVar.aLV() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar.uV((String) aVar.data);
                                g.this.duK = false;
                                return;
                            case 5:
                                if (!aLV.aLX()) {
                                    TiebaStatic.eventStat(aLV.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                eVar.aME().showToast(R.string.over_limit_tip);
                                g.this.duK = true;
                                return;
                            case 8:
                                if (g.this.a(eVar.aME().getPageContext(), 11001)) {
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
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) eVar.aME().getActivity(), eVar.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(g.this.from, true)) {
                                    albumActivityConfig.getIntent().putExtra("from", g.this.from);
                                }
                                if (g.this.duJ != null && !StringUtils.isNull(g.this.duJ.getId(), true)) {
                                    albumActivityConfig.getIntent().putExtra("forum_id", g.this.duJ.getId());
                                }
                                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                if (a.aMr().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(2);
                                    if (eVar.getWriteImagesInfo() != null) {
                                        eVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (eVar.getWriteImagesInfo() != null) {
                                    eVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                l.hideSoftKeyPad(eVar.aME().getActivity(), eVar.aME().getActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (eVar.getWriteImagesInfo() != null && eVar.getWriteImagesInfo().getChosedFiles() != null && (size = eVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(eVar.aME().getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, eVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (g.this.duK) {
                                    eVar.aME().showToast(R.string.over_limit_tip);
                                }
                                if (g.this.a(eVar.aME().getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(eVar.aME().getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    eVar.aMA();
                                    return;
                                }
                                switch (eVar.aMF()) {
                                    case 0:
                                        eVar.aMx();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        eVar.aMw();
                                        return;
                                }
                            case 20:
                                eVar.aLV().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.cKg().sL(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = eVar.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    eVar.aLV().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                                    return;
                                } else if (eVar.aME() != null && eVar.aME().getResources() != null) {
                                    Resources resources = eVar.aME().getResources();
                                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                                            XiaoyingUtil.showGoPluginDetailDialog(eVar.aME().getPageContext(), resources.getString(R.string.plugin_video_not_active), resources.getString(R.string.setup));
                                            return;
                                        } else {
                                            XiaoyingUtil.startXiaoying(eVar.aME().getActivity());
                                            return;
                                        }
                                    }
                                    XiaoyingUtil.showGoPluginDetailDialog(eVar.aME().getPageContext(), resources.getString(R.string.plugin_video_install_tips), resources.getString(R.string.plugin_go_install));
                                    return;
                                } else {
                                    return;
                                }
                            case 29:
                                eVar.aLV().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                eVar.aLV().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                eVar.aMC();
                                return;
                            case 32:
                                eVar.aLV().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (g.this.a(eVar.aME().getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    eVar.aMv();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(eVar.aME().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(eVar.aME().getActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_PB);
                                    if (g.this.duJ != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(g.this.duJ.getId(), 0L), g.this.duJ.getFirst_class(), g.this.duJ.getSecond_class());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            aLV.setActionListener(5, bVar);
            aLV.setActionListener(4, bVar);
            aLV.setActionListener(7, bVar);
            aLV.setActionListener(16, bVar);
            aLV.setActionListener(14, bVar);
            aLV.setActionListener(15, bVar);
            aLV.setActionListener(8, bVar);
            aLV.setActionListener(18, bVar);
            aLV.setActionListener(20, bVar);
            aLV.setActionListener(10, bVar);
            aLV.setActionListener(11, bVar);
            aLV.setActionListener(27, bVar);
            aLV.setActionListener(29, bVar);
            aLV.setActionListener(36, bVar);
            aLV.setActionListener(32, bVar);
            aLV.setActionListener(43, bVar);
            aLV.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.l lVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar2;
        EditorTools aLV = dVar.aLV();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        aLV.b(new com.baidu.tbadk.editortools.imagetool.d(aLV.getContext(), 3));
        if (com.baidu.tieba.tbadkCore.voice.c.cKL() && r.d(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, aLV.getContext()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar2.dtj = 4;
            aLV.b(lVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(aLV.getContext(), 5);
        aVar.dtf = R.drawable.icon_pure_post_at24_svg;
        aVar.dth = true;
        aLV.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, aLV.getContext()), com.baidu.tbadk.editortools.l.class);
        if (runTask2 != null && runTask2.getData() != null) {
            com.baidu.tbadk.editortools.l lVar3 = (com.baidu.tbadk.editortools.l) runTask2.getData();
            lVar3.dtf = R.drawable.icon_pure_more_bubble40_svg;
            lVar3.dtj = 9;
            aLV.b(lVar3);
        }
        aLV.b(new f(aLV.getContext()));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, aLV.getContext()), com.baidu.tbadk.editortools.l.class);
        if (runTask3 != null && runTask3.getData() != null) {
            com.baidu.tbadk.editortools.l lVar4 = (com.baidu.tbadk.editortools.l) runTask3.getData();
            lVar4.dtf = R.drawable.icon_pure_more_tail40_svg;
            lVar4.dtj = 10;
            aLV.b(lVar4);
        }
        if (!"PbChosenActivity".equals(aLV.getContext().getClass().getSimpleName())) {
            aLV.b(new com.baidu.tbadk.editortools.b.a(aLV.getContext(), 5));
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, aLV.getContext()), com.baidu.tbadk.editortools.l.class);
        if (runTask4 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar.dtj = 6;
            aLV.b(lVar);
        }
        aLV.aI(arrayList);
        com.baidu.tbadk.editortools.l lX = aLV.lX(5);
        if (lX != null) {
            lX.dtj = 1;
        }
        aLV.build();
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
