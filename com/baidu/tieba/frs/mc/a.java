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
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a extends h {
    private d dLm;
    private com.baidu.tieba.c.f ecx;

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.dLm = this.ecG.aBq();
    }

    private void aGT() {
        if (this.dLm == null) {
            this.dLm = this.ecG.aBq();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        aGT();
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
        bb vy;
        PostWriteCallBackData postWriteCallBackData;
        l aBO = this.ecG.aBO();
        switch (i) {
            case 11001:
                this.ecG.mk(0);
                return;
            case 11002:
                this.dLc.hs(true);
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_REG /* 11011 */:
                com.baidu.tieba.frs.f.i.a(this.ecG, this.ecG.getThreadId(), this.ecG.bNy, this.ecG.aBz());
                return;
            case IEventCenterService.EventId.EventMode.SAPIWEBVIEW_FAST_REG /* 11012 */:
                com.baidu.tieba.frs.f.i.b(this.ecG, this.ecG.getThreadId(), this.ecG.bNy, this.ecG.aBz());
                return;
            case 11014:
                this.dLc.aIf();
                return;
            case 11016:
                this.dKR.aCw();
                return;
            case 11033:
            case 23013:
            case 23019:
            default:
                return;
            case 11036:
                this.dLc.aIe();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.dLm != null) {
                        this.dLm.e(postWriteCallBackData);
                    }
                    if (!d(postWriteCallBackData)) {
                        b(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.dKR.aCE().notifyDataSetChanged();
                if (this.dLc != null) {
                    this.dLc.aEb();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.ecG.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (vy = aBO.vy(stringExtra)) != null) {
                    if (intExtra == 2) {
                        vy.cS(intent.getIntExtra("good_data", 0));
                        vy.Aq();
                    }
                    a(aBO, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.f.i.b(this.ecG.getPageContext(), aBO);
                return;
            case 23003:
                if (intent != null && aBO != null) {
                    com.baidu.tieba.frs.f.e.a(this.ecG, aBO, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                N(intent);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.l(this.ecG.getForumId(), 0)) {
                        this.dLc.F(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
            case 24007:
                if (intent.getIntExtra("extra_share_status", 2) == 1) {
                    this.ecG.oc(intent.getStringExtra("tid"));
                    return;
                }
                return;
        }
    }

    private void a(l lVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.h> dataList;
        if (lVar != null && intent != null && !TextUtils.isEmpty(str) && this.dLb != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.dLb.aHl()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.edF.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        lVar.ay(dataList);
                        this.dKR.a(dataList, lVar);
                        bE(str, this.ecG.getForumId());
                    }
                }
            }
        }
    }

    public static void bE(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            am amVar = new am("c11959");
            amVar.aA("tid", str);
            amVar.aA(ImageViewerConfig.FORUM_ID, str2);
            amVar.x("obj_type", 1);
            TiebaStatic.log(amVar);
        }
    }

    private ShareFromPBMsgData aGU() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.aSl);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.aSh);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void N(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(aGU(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ecG.getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.ecG.getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.dd(1);
            aVar.G(thread2GroupShareView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.ecG.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.b(a.this.ecG.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(a.this.ecG.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Kh() != null) {
                        Bundle Kh = shareItem.Kh();
                        TiebaStatic.log(new am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).x("obj_type", Kh.getInt("obj_type")).x("obj_param1", 3).aA(ImageViewerConfig.FORUM_ID, Kh.getString(ImageViewerConfig.FORUM_ID)).aA("tid", Kh.getString("tid")));
                    }
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.ecG.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.b(a.this.ecG.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.bg(true);
            aVar.b(this.ecG.getPageContext()).BF();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.N(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || ao.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.ecG.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.ecx == null) {
            this.ecx = new com.baidu.tieba.c.f(this.ecG.getPageContext(), (NavigationBarCoverTip) this.ecG.getView().findViewById(e.g.navigation_cover_tip));
        }
        if (this.ecG.aBO() != null && this.ecG.aBO().bgT() != null && this.ecG.aBO().bgT().isLike() == 1) {
            this.ecx.fJ(true);
        } else {
            this.ecx.fJ(false);
        }
        this.ecx.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.ecx != null) {
            this.ecx.onDestroy();
        }
    }
}
