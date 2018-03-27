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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.l;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends h {
    private d dEH;
    private com.baidu.tieba.d.e dSG;

    public a(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dEH = this.dSO.auM();
    }

    private void azk() {
        if (this.dEH == null) {
            this.dEH = this.dSO.auM();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        azk();
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
        bd sE;
        PostWriteCallBackData postWriteCallBackData;
        m avl = this.dSO.avl();
        switch (i) {
            case 11001:
                this.dSO.mP(0);
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_INITED /* 11002 */:
                this.dEx.gv(true);
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REG /* 11011 */:
                com.baidu.tieba.frs.f.h.a(this.dSO, this.dSO.getThreadId(), this.dSO.bZU, this.dSO.auV());
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_FAST_REG /* 11012 */:
                com.baidu.tieba.frs.f.h.b(this.dSO, this.dSO.getThreadId(), this.dSO.bZU, this.dSO.auV());
                return;
            case 11014:
                this.dEx.aAt();
                return;
            case 11016:
                this.dEo.avQ();
                return;
            case 11033:
            default:
                return;
            case 11036:
                this.dEx.aAs();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.dEH != null) {
                        this.dEH.d(postWriteCallBackData);
                    }
                    b(postWriteCallBackData);
                    return;
                }
                return;
            case 18003:
                this.dEo.avX().notifyDataSetChanged();
                if (this.dEx != null) {
                    this.dEx.awV();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.dSO.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (sE = avl.sE(stringExtra)) != null) {
                    if (intExtra == 2) {
                        sE.eS(intent.getIntExtra("good_data", 0));
                        sE.zW();
                    }
                    a(avl, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.f.h.a(this.dSO.getPageContext(), avl);
                return;
            case 23003:
                if (intent != null && avl != null) {
                    com.baidu.tieba.frs.f.d.a(this.dSO, avl, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                L(intent);
                return;
            case 23013:
                com.baidu.tieba.frs.f.h.z(this.dSO);
                return;
            case 23019:
                com.baidu.tieba.frs.f.h.a(this.dSO, this.dSO.dEg);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.h(this.dSO.getForumId(), 0)) {
                        this.dEx.M(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
            case 24007:
                if (intent.getIntExtra("extra_share_status", 2) == 1) {
                    this.dSO.lH(intent.getStringExtra("tid"));
                    return;
                }
                return;
        }
    }

    private void a(m mVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.i> dataList;
        if (mVar != null && intent != null && !TextUtils.isEmpty(str) && this.dEw != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.dEw.azC()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.dTK.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        mVar.au(dataList);
                        this.dEo.a(dataList, mVar);
                        aV(str, this.dSO.getForumId());
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

    private ShareFromPBMsgData azl() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.blr == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.blr.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.blu);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.blp);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void L(Intent intent) {
        a(azl(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dSO.getActivity());
            final l lVar = new l(this.dSO.getActivity());
            lVar.setData(shareFromPBMsgData);
            aVar.fd(1);
            aVar.aO(lVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.dSO.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.a(a.this.dSO.getActivity(), lVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(a.this.dSO.getActivity(), j, str, str2, 0, lVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.IX() != null) {
                        Bundle IX = shareItem.IX();
                        TiebaStatic.log(new ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).s("obj_type", IX.getInt("obj_type")).s("obj_param1", 3).ab(ImageViewerConfig.FORUM_ID, IX.getString(ImageViewerConfig.FORUM_ID)).ab("tid", IX.getString("tid")));
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.dSO.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.a(a.this.dSO.getActivity(), lVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ba(true);
            aVar.b(this.dSO.getPageContext()).AV();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                lVar.G(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.dSG == null) {
            this.dSG = new com.baidu.tieba.d.e(this.dSO.getPageContext(), (NavigationBarCoverTip) this.dSO.getView().findViewById(d.g.navigation_cover_tip));
        }
        if (this.dSO.avl() != null && this.dSO.avl().bas() != null && this.dSO.avl().bas().isLike() == 1) {
            this.dSG.fb(true);
        } else {
            this.dSG.fb(false);
        }
        this.dSG.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.dSG != null) {
            this.dSG.onDestroy();
        }
    }
}
