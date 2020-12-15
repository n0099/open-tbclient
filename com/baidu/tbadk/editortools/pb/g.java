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
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class g extends com.baidu.tbadk.editortools.c {
    private ForumData fxa;
    private DataModel<?> fxc;
    private String forumName = null;
    private String from = null;
    private boolean fxb = false;

    public void a(ForumData forumData) {
        this.fxa = forumData;
    }

    public ForumData bDp() {
        return this.fxa;
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
        this.fxc = dataModel;
    }

    public DataModel<?> bDq() {
        return this.fxc;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e eO(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.kt(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.a(this.fxc);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar instanceof e) {
            final EditorTools bCn = eVar.bCn();
            final e eVar2 = (e) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.g.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (eVar2 != null && eVar2.bCn() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar2.DW(aVar.data.toString());
                                if (aVar.data instanceof SpanGroupManager) {
                                    eVar2.setSpanGroupManager((SpanGroupManager) aVar.data);
                                }
                                g.this.fxb = false;
                                return;
                            case 5:
                                if (!bCn.bCr()) {
                                    TiebaStatic.eventStat(bCn.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                eVar2.bxs().showToast(R.string.over_limit_tip);
                                g.this.fxb = true;
                                return;
                            case 8:
                                if (g.this.a(eVar2.bxs(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                                    eVar2.a((String) null, (WriteData) null);
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar.data instanceof VoiceData.VoiceModel) {
                                    eVar2.setVoiceModel((VoiceData.VoiceModel) aVar.data);
                                    eVar2.a(true, (PostWriteCallBackData) null);
                                    return;
                                }
                                return;
                            case 11:
                                eVar2.setVoiceModel(null);
                                return;
                            case 14:
                                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(eVar2.bxs().getPageActivity(), eVar2.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(g.this.from, true)) {
                                    albumFloatActivityConfig.getIntent().putExtra("from", g.this.from);
                                }
                                if (g.this.fxa != null && !StringUtils.isNull(g.this.fxa.getId(), true)) {
                                    albumFloatActivityConfig.getIntent().putExtra("forum_id", g.this.fxa.getId());
                                }
                                albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                if (a.bCQ().getStatus() == 1) {
                                    albumFloatActivityConfig.setRequestFrom(2);
                                    if (eVar2.getWriteImagesInfo() != null) {
                                        eVar2.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (eVar2.getWriteImagesInfo() != null) {
                                    eVar2.getWriteImagesInfo().setMaxImagesAllowed(9);
                                }
                                l.hideSoftKeyPad(eVar2.bxs().getPageActivity(), eVar2.bxs().getPageActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (eVar2.getWriteImagesInfo() != null && eVar2.getWriteImagesInfo().getChosedFiles() != null && (size = eVar2.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(eVar2.bxs().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, eVar2.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (g.this.fxb) {
                                    eVar2.bxs().showToast(R.string.over_limit_tip);
                                }
                                if (g.this.a(eVar2.bxs(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(eVar2.bxs().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    eVar2.bDa();
                                    return;
                                }
                                switch (eVar2.bDe()) {
                                    case 0:
                                        eVar2.bCX();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        eVar2.bCV();
                                        return;
                                }
                            case 20:
                                eVar2.bCn().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.b.dPU().yh(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = eVar2.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    eVar2.bCn().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                                    return;
                                } else if (eVar2.bxs() != null && eVar2.bxs().getResources() != null) {
                                    Resources resources = eVar2.bxs().getResources();
                                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                                            XiaoyingUtil.showGoPluginDetailDialog(eVar2.bxs(), resources.getString(R.string.plugin_video_not_active), resources.getString(R.string.setup));
                                            return;
                                        } else {
                                            XiaoyingUtil.startXiaoying(eVar2.bxs().getPageActivity());
                                            return;
                                        }
                                    }
                                    XiaoyingUtil.showGoPluginDetailDialog(eVar2.bxs(), resources.getString(R.string.plugin_video_install_tips), resources.getString(R.string.plugin_go_install));
                                    return;
                                } else {
                                    return;
                                }
                            case 29:
                                eVar2.bCn().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                eVar2.bCn().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                eVar2.bDc();
                                return;
                            case 32:
                                eVar2.bCn().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (g.this.a(eVar2.bxs(), (int) RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    eVar2.bCU();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(eVar2.bxs(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(eVar2.bxs().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_PB);
                                    if (g.this.fxa != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(g.this.fxa.getId(), 0L), g.this.fxa.getFirst_class(), g.this.fxa.getSecond_class());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            bCn.setActionListener(5, bVar);
            bCn.setActionListener(4, bVar);
            bCn.setActionListener(7, bVar);
            bCn.setActionListener(16, bVar);
            bCn.setActionListener(14, bVar);
            bCn.setActionListener(15, bVar);
            bCn.setActionListener(8, bVar);
            bCn.setActionListener(18, bVar);
            bCn.setActionListener(20, bVar);
            bCn.setActionListener(10, bVar);
            bCn.setActionListener(11, bVar);
            bCn.setActionListener(27, bVar);
            bCn.setActionListener(29, bVar);
            bCn.setActionListener(36, bVar);
            bCn.setActionListener(32, bVar);
            bCn.setActionListener(43, bVar);
            bCn.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        EditorTools bCn = eVar.bCn();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        bCn.b(new com.baidu.tbadk.editortools.imagetool.d(bCn.getContext(), 1));
        if (com.baidu.tieba.tbadkCore.voice.c.dQD() && u.d(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bCn.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
            mVar.fuU = 2;
            bCn.b(mVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(bCn.getContext(), 4);
        aVar.fuR = false;
        bCn.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, bCn.getContext()), m.class);
        if (runTask2 != null && runTask2.getData() != null) {
            m mVar2 = (m) runTask2.getData();
            mVar2.fuU = 6;
            bCn.b(mVar2);
        }
        bCn.b(new f(bCn.getContext(), false, true));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, bCn.getContext()), m.class);
        if (runTask3 != null && runTask3.getData() != null) {
            m mVar3 = (m) runTask3.getData();
            mVar3.fuU = 7;
            bCn.b(mVar3);
        }
        if (!"PbChosenActivity".equals(bCn.getContext().getClass().getSimpleName())) {
            bCn.b(new com.baidu.tbadk.editortools.b.a(bCn.getContext(), 5));
        }
        bCn.bE(arrayList);
        m sj = bCn.sj(5);
        if (sj != null) {
            sj.fuU = 3;
        }
        bCn.build();
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
