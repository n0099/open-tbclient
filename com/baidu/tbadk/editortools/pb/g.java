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
    private ForumData dZc;
    private DataModel<?> dZe;
    private String forumName = null;
    private String from = null;
    private boolean dZd = false;

    public void a(ForumData forumData) {
        this.dZc = forumData;
    }

    public ForumData aXG() {
        return this.dZc;
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
        this.dZe = dataModel;
    }

    public DataModel<?> aXH() {
        return this.dZe;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dx(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.hB(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.a(this.dZe);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof e) {
            final EditorTools aWN = dVar.aWN();
            final e eVar = (e) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.g.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (eVar != null && eVar.aWN() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar.wE((String) aVar.data);
                                g.this.dZd = false;
                                return;
                            case 5:
                                if (!aWN.aWP()) {
                                    TiebaStatic.eventStat(aWN.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                eVar.aXw().showToast(R.string.over_limit_tip);
                                g.this.dZd = true;
                                return;
                            case 8:
                                if (g.this.a(eVar.aXw().getPageContext(), 11001)) {
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
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) eVar.aXw().getActivity(), eVar.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(g.this.from, true)) {
                                    albumActivityConfig.getIntent().putExtra("from", g.this.from);
                                }
                                if (g.this.dZc != null && !StringUtils.isNull(g.this.dZc.getId(), true)) {
                                    albumActivityConfig.getIntent().putExtra("forum_id", g.this.dZc.getId());
                                }
                                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                if (a.aXj().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(2);
                                    if (eVar.getWriteImagesInfo() != null) {
                                        eVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (eVar.getWriteImagesInfo() != null) {
                                    eVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                l.hideSoftKeyPad(eVar.aXw().getActivity(), eVar.aXw().getActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (eVar.getWriteImagesInfo() != null && eVar.getWriteImagesInfo().getChosedFiles() != null && (size = eVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(eVar.aXw().getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, eVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (g.this.dZd) {
                                    eVar.aXw().showToast(R.string.over_limit_tip);
                                }
                                if (g.this.a(eVar.aXw().getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(eVar.aXw().getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    eVar.aXs();
                                    return;
                                }
                                switch (eVar.aXx()) {
                                    case 0:
                                        eVar.aXp();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        eVar.aXo();
                                        return;
                                }
                            case 20:
                                eVar.aWN().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.cWV().tX(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = eVar.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    eVar.aWN().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                                    return;
                                } else if (eVar.aXw() != null && eVar.aXw().getResources() != null) {
                                    Resources resources = eVar.aXw().getResources();
                                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                                            XiaoyingUtil.showGoPluginDetailDialog(eVar.aXw().getPageContext(), resources.getString(R.string.plugin_video_not_active), resources.getString(R.string.setup));
                                            return;
                                        } else {
                                            XiaoyingUtil.startXiaoying(eVar.aXw().getActivity());
                                            return;
                                        }
                                    }
                                    XiaoyingUtil.showGoPluginDetailDialog(eVar.aXw().getPageContext(), resources.getString(R.string.plugin_video_install_tips), resources.getString(R.string.plugin_go_install));
                                    return;
                                } else {
                                    return;
                                }
                            case 29:
                                eVar.aWN().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                eVar.aWN().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                eVar.aXu();
                                return;
                            case 32:
                                eVar.aWN().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (g.this.a(eVar.aXw().getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    eVar.aXn();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(eVar.aXw().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(eVar.aXw().getActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_PB);
                                    if (g.this.dZc != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(g.this.dZc.getId(), 0L), g.this.dZc.getFirst_class(), g.this.dZc.getSecond_class());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            aWN.setActionListener(5, bVar);
            aWN.setActionListener(4, bVar);
            aWN.setActionListener(7, bVar);
            aWN.setActionListener(16, bVar);
            aWN.setActionListener(14, bVar);
            aWN.setActionListener(15, bVar);
            aWN.setActionListener(8, bVar);
            aWN.setActionListener(18, bVar);
            aWN.setActionListener(20, bVar);
            aWN.setActionListener(10, bVar);
            aWN.setActionListener(11, bVar);
            aWN.setActionListener(27, bVar);
            aWN.setActionListener(29, bVar);
            aWN.setActionListener(36, bVar);
            aWN.setActionListener(32, bVar);
            aWN.setActionListener(43, bVar);
            aWN.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.l lVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar2;
        EditorTools aWN = dVar.aWN();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        aWN.b(new com.baidu.tbadk.editortools.imagetool.d(aWN.getContext(), 3));
        if (com.baidu.tieba.tbadkCore.voice.c.cXy() && s.d(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, aWN.getContext()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar2.dXC = 4;
            aWN.b(lVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(aWN.getContext(), 5);
        aVar.dXy = R.drawable.icon_pure_post_at24_svg;
        aVar.dXA = true;
        aWN.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, aWN.getContext()), com.baidu.tbadk.editortools.l.class);
        if (runTask2 != null && runTask2.getData() != null) {
            com.baidu.tbadk.editortools.l lVar3 = (com.baidu.tbadk.editortools.l) runTask2.getData();
            lVar3.dXy = R.drawable.icon_pure_more_bubble40_svg;
            lVar3.dXC = 9;
            aWN.b(lVar3);
        }
        aWN.b(new f(aWN.getContext()));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, aWN.getContext()), com.baidu.tbadk.editortools.l.class);
        if (runTask3 != null && runTask3.getData() != null) {
            com.baidu.tbadk.editortools.l lVar4 = (com.baidu.tbadk.editortools.l) runTask3.getData();
            lVar4.dXy = R.drawable.icon_pure_more_tail40_svg;
            lVar4.dXC = 10;
            aWN.b(lVar4);
        }
        if (!"PbChosenActivity".equals(aWN.getContext().getClass().getSimpleName())) {
            aWN.b(new com.baidu.tbadk.editortools.b.a(aWN.getContext(), 5));
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, aWN.getContext()), com.baidu.tbadk.editortools.l.class);
        if (runTask4 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar.dXC = 6;
            aWN.b(lVar);
        }
        aWN.aR(arrayList);
        com.baidu.tbadk.editortools.l mD = aWN.mD(5);
        if (mD != null) {
            mD.dXC = 1;
        }
        aWN.build();
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
