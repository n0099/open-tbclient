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
    private com.baidu.tieba.c.g hGH;
    private d hnT;

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.hnT = this.hGQ.bUM();
    }

    private void cao() {
        if (this.hnT == null) {
            this.hnT = this.hGQ.bUM();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        cao();
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
        FrsViewData bVu = this.hGQ.bVu();
        switch (i) {
            case 11001:
                this.hGQ.tL(0);
                return;
            case 11002:
                this.hnK.nJ(true);
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_HOST /* 11011 */:
                com.baidu.tieba.frs.f.i.a(this.hGQ, this.hGQ.getThreadId(), this.hGQ.ahg, this.hGQ.bUV());
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_REVERSE /* 11012 */:
                com.baidu.tieba.frs.f.i.b(this.hGQ, this.hGQ.getThreadId(), this.hGQ.ahg, this.hGQ.bUV());
                return;
            case RequestResponseCode.REQUEST_LOGIN_SIGN /* 11014 */:
                this.hnK.cbV();
                return;
            case RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE /* 11016 */:
                this.hnt.bWd();
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_SHAKE /* 11033 */:
            case RequestResponseCode.REQUEST_CODE_PHOTO_LIVE_LIST /* 23013 */:
            case RequestResponseCode.REQUEST_CODE_HEADLINE /* 23019 */:
            default:
                return;
            case RequestResponseCode.REQUEST_LOGIN_UNLIKE /* 11036 */:
                this.hnK.cbR();
                return;
            case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                if (intent != null) {
                    int intExtra = intent.getIntExtra(PostWriteCallBackData.GENERAL_TAB_ID, -1);
                    if (intExtra >= 0) {
                        uX(intExtra);
                        return;
                    }
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.hnT != null) {
                        this.hnT.e(postWriteCallBackData);
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
                    uX(intExtra2);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                this.hnt.bWo().notifyDataSetChanged();
                if (this.hnK != null) {
                    this.hnK.bYi();
                }
                int intExtra3 = intent.getIntExtra("type", -1);
                if (intExtra3 == 4) {
                    this.hGQ.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = bVu.getThreadDataById(stringExtra)) != null) {
                    if (intExtra3 == 2) {
                        threadDataById.kv(intent.getIntExtra("good_data", 0));
                        threadDataById.aRw();
                    }
                    a(bVu, intent, stringExtra);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_FO_WEBVIEW /* 18004 */:
                com.baidu.tieba.frs.f.i.b(this.hGQ.getPageContext(), bVu);
                return;
            case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                if (intent != null && bVu != null) {
                    com.baidu.tieba.frs.f.e.a(this.hGQ, bVu, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (intExtra4 == com.baidu.adp.lib.f.b.toInt(this.hGQ.getForumId(), 0)) {
                        this.hnK.O(intExtra5, intExtra6, intExtra7);
                        return;
                    }
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                if (intent.getIntExtra("extra_share_status", 2) == 1) {
                    this.hGQ.onShareSuccess(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_DO_PAY /* 25041 */:
                this.hIc.vD(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
        }
    }

    private void uX(int i) {
        if (this.hGQ != null && this.hGQ.bUR() != null) {
            if (i > 0) {
                FrsTabViewController.b vC = this.hGQ.bUR().vC(i);
                if (vC != null && (vC.fragment instanceof FrsCommonTabFragment)) {
                    this.hIc.vD(i);
                    return;
                }
                return;
            }
            int ccs = this.hGQ.bUR().ccs();
            if (this.hGQ.bUR().vC(ccs) != null) {
                this.hIc.vD(ccs);
            }
        }
    }

    private void a(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<o> dataList;
        if (frsViewData != null && intent != null && !TextUtils.isEmpty(str) && this.hnJ != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.hnJ.caI()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.hIe.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.b.a(dataList, str, cardHListViewData, intExtra)) {
                        frsViewData.setThreadList(dataList);
                        this.hnt.a(dataList, frsViewData);
                        ee(str, this.hGQ.getForumId());
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

    private ShareFromPBMsgData cap() {
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
        a(cap(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hGQ.getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.hGQ.getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.kI(1);
            aVar.aP(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.hGQ.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.hGQ.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.hGQ.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bbc() != null) {
                        Bundle bbc = shareItem.bbc();
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ag("obj_source", 1).ag("obj_type", bbc.getInt("obj_type")).ag("obj_param1", 3).dh("fid", bbc.getString("fid")).dh("tid", bbc.getString("tid")));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.hGQ.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.hGQ.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.gX(true);
            aVar.b(this.hGQ.getPageContext()).aST();
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.hGQ.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hGH == null) {
            this.hGH = new com.baidu.tieba.c.g(this.hGQ.getPageContext(), (NavigationBarCoverTip) this.hGQ.getView().findViewById(R.id.navigation_cover_tip));
        }
        if (this.hGQ.bVu() != null && this.hGQ.bVu().getForum() != null && this.hGQ.bVu().getForum().isLike() == 1) {
            this.hGH.mb(true);
        } else {
            this.hGH.mb(false);
        }
        this.hGH.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.hGH != null) {
            this.hGH.onDestroy();
        }
    }
}
