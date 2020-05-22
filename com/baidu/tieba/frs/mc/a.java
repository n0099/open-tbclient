package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends j {
    private com.baidu.tieba.c.g hFU;
    private d hnI;

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.hnI = this.hGd.bUK();
    }

    private void cag() {
        if (this.hnI == null) {
            this.hnI = this.hGd.bUK();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        cag();
        if (i2 == -1) {
            c(i, intent);
        } else if (i2 == 0) {
            b(i, intent);
        }
    }

    private void b(int i, Intent intent) {
        switch (i) {
            case RequestResponseCode.REQUEST_IMAGE_VIEW /* 12003 */:
            default:
                return;
        }
    }

    private void c(int i, Intent intent) {
        bk threadDataById;
        PostWriteCallBackData postWriteCallBackData;
        FrsViewData bVs = this.hGd.bVs();
        switch (i) {
            case 11001:
                this.hGd.tJ(0);
                return;
            case 11002:
                this.hnz.nJ(true);
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_HOST /* 11011 */:
                com.baidu.tieba.frs.f.i.a(this.hGd, this.hGd.getThreadId(), this.hGd.ahg, this.hGd.bUT());
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_REVERSE /* 11012 */:
                com.baidu.tieba.frs.f.i.b(this.hGd, this.hGd.getThreadId(), this.hGd.ahg, this.hGd.bUT());
                return;
            case RequestResponseCode.REQUEST_LOGIN_SIGN /* 11014 */:
                this.hnz.cbN();
                return;
            case RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE /* 11016 */:
                this.hni.bWb();
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_SHAKE /* 11033 */:
            case RequestResponseCode.REQUEST_CODE_PHOTO_LIVE_LIST /* 23013 */:
            case RequestResponseCode.REQUEST_CODE_HEADLINE /* 23019 */:
            default:
                return;
            case RequestResponseCode.REQUEST_LOGIN_UNLIKE /* 11036 */:
                this.hnz.cbJ();
                return;
            case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                if (intent != null) {
                    int intExtra = intent.getIntExtra(PostWriteCallBackData.GENERAL_TAB_ID, -1);
                    if (intExtra >= 0) {
                        uV(intExtra);
                        return;
                    }
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.hnI != null) {
                        this.hnI.e(postWriteCallBackData);
                    }
                    if (!d(postWriteCallBackData)) {
                        b(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_RECORDER_VIDEO /* 13010 */:
                int intExtra2 = intent.getIntExtra(PostWriteCallBackData.GENERAL_TAB_ID, -1);
                if (intExtra2 >= 0) {
                    uV(intExtra2);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                this.hni.bWm().notifyDataSetChanged();
                if (this.hnz != null) {
                    this.hnz.bYf();
                }
                int intExtra3 = intent.getIntExtra("type", -1);
                if (intExtra3 == 4) {
                    this.hGd.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = bVs.getThreadDataById(stringExtra)) != null) {
                    if (intExtra3 == 2) {
                        threadDataById.kt(intent.getIntExtra("good_data", 0));
                        threadDataById.aRw();
                    }
                    a(bVs, intent, stringExtra);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_FO_WEBVIEW /* 18004 */:
                com.baidu.tieba.frs.f.i.b(this.hGd.getPageContext(), bVs);
                return;
            case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                if (intent != null && bVs != null) {
                    com.baidu.tieba.frs.f.e.a(this.hGd, bVs, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                S(intent);
                return;
            case RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN /* 24002 */:
                if (intent != null) {
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra6 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra7 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra4 == com.baidu.adp.lib.f.b.toInt(this.hGd.getForumId(), 0)) {
                        this.hnz.O(intExtra5, intExtra6, intExtra7);
                        return;
                    }
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                if (intent.getIntExtra("extra_share_status", 2) == 1) {
                    this.hGd.onShareSuccess(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_DO_PAY /* 25041 */:
                this.hHp.vB(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
        }
    }

    private void uV(int i) {
        if (this.hGd != null && this.hGd.bUP() != null) {
            if (i > 0) {
                FrsTabViewController.b vA = this.hGd.bUP().vA(i);
                if (vA != null && (vA.fragment instanceof FrsCommonTabFragment)) {
                    this.hHp.vB(i);
                    return;
                }
                return;
            }
            int cck = this.hGd.bUP().cck();
            if (this.hGd.bUP().vA(cck) != null) {
                this.hHp.vB(cck);
            }
        }
    }

    private void a(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<o> dataList;
        if (frsViewData != null && intent != null && !TextUtils.isEmpty(str) && this.hny != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.hny.caA()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.hHr.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.b.a(dataList, str, cardHListViewData, intExtra)) {
                        frsViewData.setThreadList(dataList);
                        this.hni.a(dataList, frsViewData);
                        ee(str, this.hGd.getForumId());
                    }
                }
            }
        }
    }

    public static void ee(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            an anVar = new an("c11959");
            anVar.dh("tid", str);
            anVar.dh("fid", str2);
            anVar.ag("obj_type", 1);
            TiebaStatic.log(anVar);
        }
    }

    private ShareFromPBMsgData cah() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.eeT);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void S(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(cah(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hGd.getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.hGd.getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.kG(1);
            aVar.aP(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.hGd.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.hGd.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.hGd.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bbb() != null) {
                        Bundle bbb = shareItem.bbb();
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ag("obj_source", 1).ag("obj_type", bbb.getInt("obj_type")).ag("obj_param1", 3).dh("fid", bbb.getString("fid")).dh("tid", bbb.getString("tid")));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.hGd.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.hGd.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.gX(true);
            aVar.b(this.hGd.getPageContext()).aST();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aF(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.hGd.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hFU == null) {
            this.hFU = new com.baidu.tieba.c.g(this.hGd.getPageContext(), (NavigationBarCoverTip) this.hGd.getView().findViewById(R.id.navigation_cover_tip));
        }
        if (this.hGd.bVs() != null && this.hGd.bVs().getForum() != null && this.hGd.bVs().getForum().isLike() == 1) {
            this.hFU.mb(true);
        } else {
            this.hFU.mb(false);
        }
        this.hFU.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.hFU != null) {
            this.hFU.onDestroy();
        }
    }
}
