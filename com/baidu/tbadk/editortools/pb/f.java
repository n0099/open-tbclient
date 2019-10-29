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
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f extends com.baidu.tbadk.editortools.c {
    private ForumData cHw;
    private DataModel<?> cHy;
    private String forumName = null;
    private String from = null;
    private boolean cHx = false;

    public void a(ForumData forumData) {
        this.cHw = forumData;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void a(DataModel<?> dataModel) {
        this.cHy = dataModel;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d cx(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.ff(false);
        editorTools.setMoreButtonAtEnd(true);
        d dVar = new d(editorTools);
        dVar.a(this.cHy);
        return dVar;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof d) {
            final EditorTools atZ = dVar.atZ();
            final d dVar2 = (d) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tbadk.editortools.pb.f.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    int size;
                    if (dVar2 != null && dVar2.atZ() != null && aVar != null) {
                        switch (aVar.code) {
                            case 4:
                                dVar2.pL((String) aVar.data);
                                f.this.cHx = false;
                                return;
                            case 5:
                                if (!atZ.aub()) {
                                    TiebaStatic.eventStat(atZ.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
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
                                dVar2.getContext().showToast((int) R.string.over_limit_tip);
                                f.this.cHx = true;
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
                                if (f.this.cHw != null && !StringUtils.isNull(f.this.cHw.getId(), true)) {
                                    albumActivityConfig.getIntent().putExtra("forum_id", f.this.cHw.getId());
                                }
                                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                if (a.auv().getStatus() == 1) {
                                    albumActivityConfig.setRequestFrom(2);
                                    if (dVar2.getWriteImagesInfo() != null) {
                                        dVar2.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (dVar2.getWriteImagesInfo() != null) {
                                    dVar2.getWriteImagesInfo().setMaxImagesAllowed(10);
                                }
                                l.hideSoftKeyPad(dVar2.getContext().getActivity(), dVar2.getContext().getActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar.data).intValue();
                                if (dVar2.getWriteImagesInfo() != null && dVar2.getWriteImagesInfo().getChosedFiles() != null && (size = dVar2.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(dVar2.getContext().getActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, dVar2.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (f.this.cHx) {
                                    dVar2.getContext().showToast((int) R.string.over_limit_tip);
                                }
                                if (f.this.a(dVar2.getContext().getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(dVar2.getContext().getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    dVar2.auE();
                                    return;
                                }
                                switch (dVar2.auI()) {
                                    case 0:
                                        dVar2.auB();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        dVar2.auA();
                                        return;
                                }
                            case 20:
                                dVar2.atZ().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.c.coW().qS(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 27:
                                VideoInfo videoInfo = dVar2.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    dVar2.atZ().b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                                    return;
                                } else if (dVar2.getContext() != null && dVar2.getContext().getResources() != null) {
                                    Resources resources = dVar2.getContext().getResources();
                                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                                            XiaoyingUtil.showGoPluginDetailDialog(dVar2.getContext().getPageContext(), resources.getString(R.string.plugin_video_not_active), resources.getString(R.string.setup));
                                            return;
                                        } else {
                                            XiaoyingUtil.startXiaoying(dVar2.getContext().getActivity());
                                            return;
                                        }
                                    }
                                    XiaoyingUtil.showGoPluginDetailDialog(dVar2.getContext().getPageContext(), resources.getString(R.string.plugin_video_install_tips), resources.getString(R.string.plugin_go_install));
                                    return;
                                } else {
                                    return;
                                }
                            case 29:
                                dVar2.atZ().b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                dVar2.atZ().b(new com.baidu.tbadk.editortools.a(1, 2, null));
                                dVar2.auG();
                                return;
                            case 32:
                                dVar2.atZ().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (f.this.a(dVar2.getContext().getPageContext(), (int) RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    dVar2.auz();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(dVar2.getContext().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(dVar2.getContext().getActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_PB);
                                    if (f.this.cHw != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.toLong(f.this.cHw.getId(), 0L), f.this.cHw.getFirst_class(), f.this.cHw.getSecond_class());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            atZ.setActionListener(5, bVar);
            atZ.setActionListener(4, bVar);
            atZ.setActionListener(7, bVar);
            atZ.setActionListener(16, bVar);
            atZ.setActionListener(14, bVar);
            atZ.setActionListener(15, bVar);
            atZ.setActionListener(8, bVar);
            atZ.setActionListener(18, bVar);
            atZ.setActionListener(20, bVar);
            atZ.setActionListener(10, bVar);
            atZ.setActionListener(11, bVar);
            atZ.setActionListener(27, bVar);
            atZ.setActionListener(29, bVar);
            atZ.setActionListener(36, bVar);
            atZ.setActionListener(32, bVar);
            atZ.setActionListener(43, bVar);
            atZ.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        k kVar;
        CustomResponsedMessage runTask;
        k kVar2;
        EditorTools atZ = dVar.atZ();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(9);
        atZ.b(new com.baidu.tbadk.editortools.imagetool.d(atZ.getContext(), 3));
        if (com.baidu.tieba.tbadkCore.voice.c.cpD() && r.b(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, atZ.getContext()), k.class)) != null && (kVar2 = (k) runTask.getData()) != null) {
            kVar2.cFV = 4;
            atZ.b(kVar2);
        }
        atZ.b(new com.baidu.tbadk.editortools.a.a(atZ.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, atZ.getContext()), k.class);
        if (runTask2 != null && runTask2.getData() != null) {
            k kVar3 = (k) runTask2.getData();
            kVar3.cFR = R.drawable.icon_post_more_bubble_n;
            kVar3.cFV = 9;
            atZ.b(kVar3);
        }
        atZ.b(new e(atZ.getContext()));
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, atZ.getContext()), k.class);
        if (runTask3 != null && runTask3.getData() != null) {
            k kVar4 = (k) runTask3.getData();
            kVar4.cFR = R.drawable.icon_post_more_tail_n;
            kVar4.cFV = 10;
            atZ.b(kVar4);
        }
        if (!"PbChosenActivity".equals(atZ.getContext().getClass().getSimpleName())) {
            atZ.b(new com.baidu.tbadk.editortools.b.a(atZ.getContext(), 5));
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, atZ.getContext()), k.class);
        if (runTask4 != null && (kVar = (k) runTask4.getData()) != null) {
            kVar.cFV = 6;
            kVar.cFR = R.drawable.icon_post_more_location;
            atZ.b(kVar);
        }
        atZ.aC(arrayList);
        k jL = atZ.jL(5);
        if (jL != null) {
            jL.cFV = 1;
        }
        atZ.build();
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
