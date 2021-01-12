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
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.editortools.c {
    private ForumData fBZ;
    private DataModel<?> fCb;
    private String forumName = null;
    private String from = null;
    private boolean fCa = false;

    public void a(ForumData forumData) {
        this.fBZ = forumData;
    }

    public ForumData bBS() {
        return this.fBZ;
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
        this.fCb = dataModel;
    }

    public DataModel<?> bBT() {
        return this.fCb;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e fi(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.kL(false);
        editorTools.setMoreButtonAtEnd(true);
        e eVar = new e(editorTools);
        eVar.a(this.fCb);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar instanceof e) {
            final EditorTools bAP = eVar.bAP();
            final e eVar2 = (e) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.g.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (eVar2 != null && eVar2.bAP() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                eVar2.CH(aVar.data.toString());
                                if (aVar.data instanceof SpanGroupManager) {
                                    eVar2.setSpanGroupManager((SpanGroupManager) aVar.data);
                                }
                                g.this.fCa = false;
                                return;
                            case 5:
                                if (!bAP.bAT()) {
                                    TiebaStatic.eventStat(bAP.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                eVar2.bvT().showToast(R.string.over_limit_tip);
                                g.this.fCa = true;
                                return;
                            case 8:
                                if (g.this.a(eVar2.bvT(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
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
                                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(eVar2.bvT().getPageActivity(), eVar2.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(g.this.from, true)) {
                                    albumFloatActivityConfig.getIntent().putExtra("from", g.this.from);
                                }
                                if (g.this.fBZ != null && !StringUtils.isNull(g.this.fBZ.getId(), true)) {
                                    albumFloatActivityConfig.getIntent().putExtra("forum_id", g.this.fBZ.getId());
                                }
                                albumFloatActivityConfig.setRequestCode(12002);
                                if (a.bBs().getStatus() == 1) {
                                    albumFloatActivityConfig.setRequestFrom(2);
                                    if (eVar2.getWriteImagesInfo() != null) {
                                        eVar2.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (eVar2.getWriteImagesInfo() != null) {
                                    eVar2.getWriteImagesInfo().setMaxImagesAllowed(9);
                                }
                                l.hideSoftKeyPad(eVar2.bvT().getPageActivity(), eVar2.bvT().getPageActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (eVar2.getWriteImagesInfo() != null && eVar2.getWriteImagesInfo().getChosedFiles() != null && (size = eVar2.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(eVar2.bvT().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, eVar2.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (g.this.fCa) {
                                    eVar2.bvT().showToast(R.string.over_limit_tip);
                                }
                                if (g.this.a(eVar2.bvT(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(eVar2.bvT().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    eVar2.bBC();
                                    return;
                                }
                                switch (eVar2.bBG()) {
                                    case 0:
                                        eVar2.bBz();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        eVar2.bBx();
                                        return;
                                }
                            case 20:
                                eVar2.bAP().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.b.dLZ().yi(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = eVar2.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    eVar2.bAP().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                                    return;
                                } else if (eVar2.bvT() != null && eVar2.bvT().getResources() != null) {
                                    Resources resources = eVar2.bvT().getResources();
                                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                                            XiaoyingUtil.showGoPluginDetailDialog(eVar2.bvT(), resources.getString(R.string.plugin_video_not_active), resources.getString(R.string.setup));
                                            return;
                                        } else {
                                            XiaoyingUtil.startXiaoying(eVar2.bvT().getPageActivity());
                                            return;
                                        }
                                    }
                                    XiaoyingUtil.showGoPluginDetailDialog(eVar2.bvT(), resources.getString(R.string.plugin_video_install_tips), resources.getString(R.string.plugin_go_install));
                                    return;
                                } else {
                                    return;
                                }
                            case 29:
                                eVar2.bAP().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                eVar2.bAP().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                eVar2.bBE();
                                return;
                            case 32:
                                eVar2.bAP().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (g.this.a(eVar2.bvT(), (int) RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    eVar2.bBw();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(eVar2.bvT(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(eVar2.bvT().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_PB);
                                    if (g.this.fBZ != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(g.this.fBZ.getId(), 0L), g.this.fBZ.getFirst_class(), g.this.fBZ.getSecond_class());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            bAP.setActionListener(5, bVar);
            bAP.setActionListener(4, bVar);
            bAP.setActionListener(7, bVar);
            bAP.setActionListener(16, bVar);
            bAP.setActionListener(14, bVar);
            bAP.setActionListener(15, bVar);
            bAP.setActionListener(8, bVar);
            bAP.setActionListener(18, bVar);
            bAP.setActionListener(20, bVar);
            bAP.setActionListener(10, bVar);
            bAP.setActionListener(11, bVar);
            bAP.setActionListener(27, bVar);
            bAP.setActionListener(29, bVar);
            bAP.setActionListener(36, bVar);
            bAP.setActionListener(32, bVar);
            bAP.setActionListener(43, bVar);
            bAP.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        EditorTools bAP = eVar.bAP();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        bAP.b(new com.baidu.tbadk.editortools.imagetool.d(bAP.getContext(), 1));
        if (com.baidu.tieba.tbadkCore.voice.c.dMI() && u.d(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bAP.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
            mVar.fzS = 2;
            bAP.b(mVar);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(bAP.getContext(), 4);
        aVar.fzP = false;
        bAP.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, bAP.getContext()), m.class);
        if (runTask2 != null && runTask2.getData() != null) {
            m mVar2 = (m) runTask2.getData();
            mVar2.fzS = 6;
            bAP.b(mVar2);
        }
        bAP.b(new f(bAP.getContext(), false, true));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, bAP.getContext()), m.class);
        if (runTask3 != null && runTask3.getData() != null) {
            m mVar3 = (m) runTask3.getData();
            mVar3.fzS = 7;
            bAP.b(mVar3);
        }
        if (!"PbChosenActivity".equals(bAP.getContext().getClass().getSimpleName())) {
            bAP.b(new com.baidu.tbadk.editortools.b.a(bAP.getContext(), 5));
        }
        bAP.bL(arrayList);
        m qP = bAP.qP(5);
        if (qP != null) {
            qP.fzS = 3;
        }
        bAP.build();
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
