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
    private d dBB;
    private com.baidu.tieba.d.d dPh;

    public a(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dBB = this.dPp.atR();
    }

    private void ayc() {
        if (this.dBB == null) {
            this.dBB = this.dPp.atR();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ayc();
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
        bd so;
        PostWriteCallBackData postWriteCallBackData;
        l auq = this.dPp.auq();
        switch (i) {
            case 11001:
                this.dPp.mS(0);
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED /* 11002 */:
                this.dBr.gh(true);
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REG /* 11011 */:
                com.baidu.tieba.frs.e.h.a(this.dPp, this.dPp.getThreadId(), this.dPp.bXM, this.dPp.aua());
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_FAST_REG /* 11012 */:
                com.baidu.tieba.frs.e.h.b(this.dPp, this.dPp.getThreadId(), this.dPp.bXM, this.dPp.aua());
                return;
            case 11014:
                this.dBr.azj();
                return;
            case 11016:
                this.dBi.auJ();
                return;
            case 11033:
            case 24007:
            default:
                return;
            case 11036:
                this.dBr.azi();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.dBB != null) {
                        this.dBB.d(postWriteCallBackData);
                    }
                    b(postWriteCallBackData);
                    return;
                }
                return;
            case 18003:
                this.dBi.auP().notifyDataSetChanged();
                if (this.dBr != null) {
                    this.dBr.avQ();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.dPp.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (so = auq.so(stringExtra)) != null) {
                    if (intExtra == 2) {
                        so.eS(intent.getIntExtra("good_data", 0));
                        so.zB();
                    }
                    a(auq, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.e.h.a(this.dPp.getPageContext(), auq);
                return;
            case 23003:
                if (intent != null && auq != null) {
                    com.baidu.tieba.frs.e.d.a(this.dPp, auq, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                M(intent);
                return;
            case 23013:
                com.baidu.tieba.frs.e.h.z(this.dPp);
                return;
            case 23019:
                com.baidu.tieba.frs.e.h.a(this.dPp, this.dPp.dBa);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.h(this.dPp.getForumId(), 0)) {
                        this.dBr.L(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(l lVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.i> dataList;
        if (lVar != null && intent != null && !TextUtils.isEmpty(str) && this.dBq != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.dBq.ayu()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.dQl.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        lVar.at(dataList);
                        this.dBi.a(dataList, lVar);
                        aV(str, this.dPp.getForumId());
                    }
                }
            }
        }
    }

    public static void aV(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ak akVar = new ak("c11959");
            akVar.ab("tid", str);
            akVar.ab(ImageViewerConfig.FORUM_ID, str2);
            akVar.s("obj_type", 1);
            TiebaStatic.log(akVar);
        }
    }

    private ShareFromPBMsgData ayd() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.bje == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.bje.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.bjh);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.bjc);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void M(Intent intent) {
        a(ayd(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPp.getActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(this.dPp.getActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.fd(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.dPp.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.a(a.this.dPp.getActivity(), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.dPp.getActivity(), j, str, str2, 0, lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Ip() != null) {
                        Bundle Ip = shareItem.Ip();
                        TiebaStatic.log(new ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_type", Ip.getInt("obj_type")).s("obj_param1", 3).ab(ImageViewerConfig.FORUM_ID, Ip.getString(ImageViewerConfig.FORUM_ID)).ab("tid", Ip.getString("tid")));
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.dPp.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.a(a.this.dPp.getActivity(), lVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aW(true);
            aVar.b(this.dPp.getPageContext()).AA();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.J(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dPh == null) {
            this.dPh = new com.baidu.tieba.d.d(this.dPp.getPageContext(), (NavigationBarCoverTip) this.dPp.getView().findViewById(d.g.navigation_cover_tip));
        }
        if (this.dPp.auq() != null && this.dPp.auq().aYE() != null && this.dPp.auq().aYE().isLike() == 1) {
            this.dPh.eS(true);
        } else {
            this.dPh.eS(false);
        }
        this.dPh.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.dPh != null) {
            this.dPh.onDestroy();
        }
    }
}
