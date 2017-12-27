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
import com.baidu.tbadk.core.data.be;
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
    private com.baidu.tieba.d.d dKF;
    private d dxa;

    public a(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dxa = this.dKN.asO();
    }

    private void awZ() {
        if (this.dxa == null) {
            this.dxa = this.dKN.asO();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        awZ();
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
        be sV;
        PostWriteCallBackData postWriteCallBackData;
        l atn = this.dKN.atn();
        switch (i) {
            case 11001:
                this.dKN.mP(0);
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED /* 11002 */:
                this.dwQ.gd(true);
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REG /* 11011 */:
                com.baidu.tieba.frs.e.h.a(this.dKN, this.dKN.getThreadId(), this.dKN.bXF, this.dKN.asX());
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_FAST_REG /* 11012 */:
                com.baidu.tieba.frs.e.h.b(this.dKN, this.dKN.getThreadId(), this.dKN.bXF, this.dKN.asX());
                return;
            case 11014:
                this.dwQ.ayg();
                return;
            case 11016:
                this.dwH.atG();
                return;
            case 11033:
            case 24007:
            default:
                return;
            case 11036:
                this.dwQ.ayf();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.dxa != null) {
                        this.dxa.d(postWriteCallBackData);
                    }
                    b(postWriteCallBackData);
                    return;
                }
                return;
            case 18003:
                this.dwH.atM().notifyDataSetChanged();
                if (this.dwQ != null) {
                    this.dwQ.auN();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.dKN.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (sV = atn.sV(stringExtra)) != null) {
                    if (intExtra == 2) {
                        sV.eT(intent.getIntExtra("good_data", 0));
                        sV.zF();
                    }
                    a(atn, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.e.h.a(this.dKN.getPageContext(), atn);
                return;
            case 23003:
                if (intent != null && atn != null) {
                    com.baidu.tieba.frs.e.d.a(this.dKN, atn, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                M(intent);
                return;
            case 23013:
                com.baidu.tieba.frs.e.h.z(this.dKN);
                return;
            case 23019:
                com.baidu.tieba.frs.e.h.a(this.dKN, this.dKN.dwz);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.h(this.dKN.getForumId(), 0)) {
                        this.dwQ.L(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(l lVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.i> dataList;
        if (lVar != null && intent != null && !TextUtils.isEmpty(str) && this.dwP != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.dwP.axr()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.dLJ.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        lVar.az(dataList);
                        this.dwH.a(dataList, lVar);
                        aV(str, this.dKN.getForumId());
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

    private ShareFromPBMsgData axa() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.biN == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.biN.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.biQ);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.biL);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void M(Intent intent) {
        a(axa(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dKN.getActivity());
            final com.baidu.tieba.view.l lVar = new com.baidu.tieba.view.l(this.dKN.getActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.ff(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.dKN.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.a(a.this.dKN.getActivity(), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.dKN.getActivity(), j, str, str2, 0, lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Iw() != null) {
                        Bundle Iw = shareItem.Iw();
                        TiebaStatic.log(new ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_type", Iw.getInt("obj_type")).s("obj_param1", 3).ab(ImageViewerConfig.FORUM_ID, Iw.getString(ImageViewerConfig.FORUM_ID)).ab("tid", Iw.getString("tid")));
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.dKN.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.a(a.this.dKN.getActivity(), lVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aW(true);
            aVar.b(this.dKN.getPageContext()).AI();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.J(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dKF == null) {
            this.dKF = new com.baidu.tieba.d.d(this.dKN.getPageContext(), (NavigationBarCoverTip) this.dKN.getView().findViewById(d.g.navigation_cover_tip));
        }
        if (this.dKN.atn() != null && this.dKN.atn().aYy() != null && this.dKN.atn().aYy().isLike() == 1) {
            this.dKF.eO(true);
        } else {
            this.dKF.eO(false);
        }
        this.dKF.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.dKF != null) {
            this.dKF.onDestroy();
        }
    }
}
