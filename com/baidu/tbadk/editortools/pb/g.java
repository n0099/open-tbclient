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
    private ForumData enm;
    private DataModel<?> eno;
    private String forumName = null;
    private String from = null;
    private boolean enn = false;

    public void a(ForumData forumData) {
        this.enm = forumData;
    }

    public ForumData bdQ() {
        return this.enm;
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
        this.eno = dataModel;
    }

    public DataModel<?> bdR() {
        return this.eno;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dO(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.hX(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.a(this.eno);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof e) {
            final EditorTools bcX = dVar.bcX();
            final e eVar = (e) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.g.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (eVar != null && eVar.bcX() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar.yk((String) aVar.data);
                                g.this.enn = false;
                                return;
                            case 5:
                                if (!bcX.bcZ()) {
                                    TiebaStatic.eventStat(bcX.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                eVar.bdG().showToast(R.string.over_limit_tip);
                                g.this.enn = true;
                                return;
                            case 8:
                                if (g.this.a(eVar.bdG().getPageContext(), 11001)) {
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
                                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) eVar.bdG().getActivity(), eVar.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(g.this.from, true)) {
                                    albumActivityConfig.getIntent().putExtra("from", g.this.from);
                                }
                                if (g.this.enm != null && !StringUtils.isNull(g.this.enm.getId(), true)) {
                                    albumActivityConfig.getIntent().putExtra("forum_id", g.this.enm.getId());
                                }
                                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                if (a.bdt().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(2);
                                    if (eVar.getWriteImagesInfo() != null) {
                                        eVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (eVar.getWriteImagesInfo() != null) {
                                    eVar.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                l.hideSoftKeyPad(eVar.bdG().getActivity(), eVar.bdG().getActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (eVar.getWriteImagesInfo() != null && eVar.getWriteImagesInfo().getChosedFiles() != null && (size = eVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(eVar.bdG().getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, eVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (g.this.enn) {
                                    eVar.bdG().showToast(R.string.over_limit_tip);
                                }
                                if (g.this.a(eVar.bdG().getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(eVar.bdG().getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    eVar.bdC();
                                    return;
                                }
                                switch (eVar.bdH()) {
                                    case 0:
                                        eVar.bdz();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        eVar.bdy();
                                        return;
                                }
                            case 20:
                                eVar.bcX().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.der().uv(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = eVar.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    eVar.bcX().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                                    return;
                                } else if (eVar.bdG() != null && eVar.bdG().getResources() != null) {
                                    Resources resources = eVar.bdG().getResources();
                                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                                            XiaoyingUtil.showGoPluginDetailDialog(eVar.bdG().getPageContext(), resources.getString(R.string.plugin_video_not_active), resources.getString(R.string.setup));
                                            return;
                                        } else {
                                            XiaoyingUtil.startXiaoying(eVar.bdG().getActivity());
                                            return;
                                        }
                                    }
                                    XiaoyingUtil.showGoPluginDetailDialog(eVar.bdG().getPageContext(), resources.getString(R.string.plugin_video_install_tips), resources.getString(R.string.plugin_go_install));
                                    return;
                                } else {
                                    return;
                                }
                            case 29:
                                eVar.bcX().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                eVar.bcX().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                eVar.bdE();
                                return;
                            case 32:
                                eVar.bcX().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (g.this.a(eVar.bdG().getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    eVar.bdx();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(eVar.bdG().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(eVar.bdG().getActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_PB);
                                    if (g.this.enm != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(g.this.enm.getId(), 0L), g.this.enm.getFirst_class(), g.this.enm.getSecond_class());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            bcX.setActionListener(5, bVar);
            bcX.setActionListener(4, bVar);
            bcX.setActionListener(7, bVar);
            bcX.setActionListener(16, bVar);
            bcX.setActionListener(14, bVar);
            bcX.setActionListener(15, bVar);
            bcX.setActionListener(8, bVar);
            bcX.setActionListener(18, bVar);
            bcX.setActionListener(20, bVar);
            bcX.setActionListener(10, bVar);
            bcX.setActionListener(11, bVar);
            bcX.setActionListener(27, bVar);
            bcX.setActionListener(29, bVar);
            bcX.setActionListener(36, bVar);
            bcX.setActionListener(32, bVar);
            bcX.setActionListener(43, bVar);
            bcX.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.l lVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar2;
        EditorTools bcX = dVar.bcX();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        bcX.b(new com.baidu.tbadk.editortools.imagetool.d(bcX.getContext(), 3));
        if (com.baidu.tieba.tbadkCore.voice.c.dfb() && s.d(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bcX.getContext()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar2.elL = 4;
            bcX.b(lVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(bcX.getContext(), 5);
        aVar.elH = R.drawable.icon_pure_post_at24_svg;
        aVar.elJ = true;
        bcX.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, bcX.getContext()), com.baidu.tbadk.editortools.l.class);
        if (runTask2 != null && runTask2.getData() != null) {
            com.baidu.tbadk.editortools.l lVar3 = (com.baidu.tbadk.editortools.l) runTask2.getData();
            lVar3.elH = R.drawable.icon_pure_more_bubble40_svg;
            lVar3.elL = 9;
            bcX.b(lVar3);
        }
        bcX.b(new f(bcX.getContext()));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, bcX.getContext()), com.baidu.tbadk.editortools.l.class);
        if (runTask3 != null && runTask3.getData() != null) {
            com.baidu.tbadk.editortools.l lVar4 = (com.baidu.tbadk.editortools.l) runTask3.getData();
            lVar4.elH = R.drawable.icon_pure_more_tail40_svg;
            lVar4.elL = 10;
            bcX.b(lVar4);
        }
        if (!"PbChosenActivity".equals(bcX.getContext().getClass().getSimpleName())) {
            bcX.b(new com.baidu.tbadk.editortools.b.a(bcX.getContext(), 5));
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, bcX.getContext()), com.baidu.tbadk.editortools.l.class);
        if (runTask4 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
            lVar.elL = 6;
            bcX.b(lVar);
        }
        bcX.aM(arrayList);
        com.baidu.tbadk.editortools.l nh = bcX.nh(5);
        if (nh != null) {
            nh.elL = 1;
        }
        bcX.build();
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
