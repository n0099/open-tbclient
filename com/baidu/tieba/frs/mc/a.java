package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends h {
    private d dBW;
    private com.baidu.tieba.d.d dPC;

    public a(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dBW = this.dPK.atW();
    }

    private void ayh() {
        if (this.dBW == null) {
            this.dBW = this.dPK.atW();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ayh();
        if (i2 == -1) {
            c(i, intent);
        } else if (i2 == 0) {
            b(i, intent);
        }
    }

    private void b(int i, Intent intent) {
        switch (i) {
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_DEL /* 12003 */:
            default:
                return;
        }
    }

    private void c(int i, Intent intent) {
        bd sw;
        PostWriteCallBackData postWriteCallBackData;
        l auv = this.dPK.auv();
        switch (i) {
            case 11001:
                this.dPK.mS(0);
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED /* 11002 */:
                this.dBM.gj(true);
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REG /* 11011 */:
                com.baidu.tieba.frs.e.h.a(this.dPK, this.dPK.getThreadId(), this.dPK.bXU, this.dPK.auf());
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_FAST_REG /* 11012 */:
                com.baidu.tieba.frs.e.h.b(this.dPK, this.dPK.getThreadId(), this.dPK.bXU, this.dPK.auf());
                return;
            case 11014:
                this.dBM.azo();
                return;
            case 11016:
                this.dBD.auO();
                return;
            case 11033:
            case 24007:
            default:
                return;
            case 11036:
                this.dBM.azn();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.dBW != null) {
                        this.dBW.d(postWriteCallBackData);
                    }
                    b(postWriteCallBackData);
                    return;
                }
                return;
            case 18003:
                this.dBD.auU().notifyDataSetChanged();
                if (this.dBM != null) {
                    this.dBM.avV();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.dPK.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (sw = auv.sw(stringExtra)) != null) {
                    if (intExtra == 2) {
                        sw.eS(intent.getIntExtra("good_data", 0));
                        sw.zC();
                    }
                    a(auv, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.e.h.a(this.dPK.getPageContext(), auv);
                return;
            case 23003:
                if (intent != null && auv != null) {
                    com.baidu.tieba.frs.e.d.a(this.dPK, auv, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                M(intent);
                return;
            case 23013:
                com.baidu.tieba.frs.e.h.z(this.dPK);
                return;
            case 23019:
                com.baidu.tieba.frs.e.h.a(this.dPK, this.dPK.dBv);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.h(this.dPK.getForumId(), 0)) {
                        this.dBM.L(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(l lVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.i> dataList;
        if (lVar != null && intent != null && !TextUtils.isEmpty(str) && this.dBL != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.dBL.ayz()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.dQG.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        lVar.at(dataList);
                        this.dBD.a(dataList, lVar);
                        aU(str, this.dPK.getForumId());
                    }
                }
            }
        }
    }

    public static void aU(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ak akVar = new ak("c11959");
            akVar.aa("tid", str);
            akVar.aa(ImageViewerConfig.FORUM_ID, str2);
            akVar.s("obj_type", 1);
            TiebaStatic.log(akVar);
        }
    }

    private ShareFromPBMsgData ayi() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.bjm == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.bjm.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.bjp);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.bjk);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void M(Intent intent) {
        a(ayi(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPK.getActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(this.dPK.getActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.fd(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.dPK.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.a(a.this.dPK.getActivity(), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.dPK.getActivity(), j, str, str2, 0, lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Ir() != null) {
                        Bundle Ir = shareItem.Ir();
                        TiebaStatic.log(new ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_type", Ir.getInt("obj_type")).s("obj_param1", 3).aa(ImageViewerConfig.FORUM_ID, Ir.getString(ImageViewerConfig.FORUM_ID)).aa("tid", Ir.getString("tid")));
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.dPK.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.a(a.this.dPK.getActivity(), lVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aX(true);
            aVar.b(this.dPK.getPageContext()).AB();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.J(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dPC == null) {
            this.dPC = new com.baidu.tieba.d.d(this.dPK.getPageContext(), (NavigationBarCoverTip) this.dPK.getView().findViewById(d.g.navigation_cover_tip));
        }
        if (this.dPK.auv() != null && this.dPK.auv().aYJ() != null && this.dPK.auv().aYJ().isLike() == 1) {
            this.dPC.eU(true);
        } else {
            this.dPC.eU(false);
        }
        this.dPC.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.dPC != null) {
            this.dPC.onDestroy();
        }
    }
}
