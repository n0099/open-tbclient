package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a extends j {
    private com.baidu.tieba.c.g gEv;
    private d gmJ;

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.gmJ = this.gEE.bCd();
    }

    private void bHx() {
        if (this.gmJ == null) {
            this.gmJ = this.gEE.bCd();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bHx();
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
        bj threadDataById;
        PostWriteCallBackData postWriteCallBackData;
        FrsViewData bCK = this.gEE.bCK();
        switch (i) {
            case 11001:
                this.gEE.sz(0);
                return;
            case 11002:
                this.gmA.mc(true);
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_HOST /* 11011 */:
                com.baidu.tieba.frs.f.i.a(this.gEE, this.gEE.getThreadId(), this.gEE.Np, this.gEE.bCm());
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_REVERSE /* 11012 */:
                com.baidu.tieba.frs.f.i.b(this.gEE, this.gEE.getThreadId(), this.gEE.Np, this.gEE.bCm());
                return;
            case RequestResponseCode.REQUEST_LOGIN_SIGN /* 11014 */:
                this.gmA.bIZ();
                return;
            case RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE /* 11016 */:
                this.gmj.bDq();
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_SHAKE /* 11033 */:
            case RequestResponseCode.REQUEST_CODE_PHOTO_LIVE_LIST /* 23013 */:
            case RequestResponseCode.REQUEST_CODE_HEADLINE /* 23019 */:
            default:
                return;
            case RequestResponseCode.REQUEST_LOGIN_UNLIKE /* 11036 */:
                this.gmA.bIV();
                return;
            case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.gmJ != null) {
                        this.gmJ.e(postWriteCallBackData);
                    }
                    if (!d(postWriteCallBackData)) {
                        b(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                this.gmj.bDA().notifyDataSetChanged();
                if (this.gmA != null) {
                    this.gmA.bFn();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.gEE.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = bCK.getThreadDataById(stringExtra)) != null) {
                    if (intExtra == 2) {
                        threadDataById.jv(intent.getIntExtra("good_data", 0));
                        threadDataById.aAT();
                    }
                    a(bCK, intent, stringExtra);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_FO_WEBVIEW /* 18004 */:
                com.baidu.tieba.frs.f.i.b(this.gEE.getPageContext(), bCK);
                return;
            case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                if (intent != null && bCK != null) {
                    com.baidu.tieba.frs.f.e.a(this.gEE, bCK, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                aj(intent);
                return;
            case RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN /* 24002 */:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.f.b.toInt(this.gEE.getForumId(), 0)) {
                        this.gmA.K(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                if (intent.getIntExtra("extra_share_status", 2) == 1) {
                    this.gEE.onShareSuccess(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_DO_PAY /* 25041 */:
                this.gFT.uk(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
        }
    }

    private void a(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<m> dataList;
        if (frsViewData != null && intent != null && !TextUtils.isEmpty(str) && this.gmz != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.gmz.bHP()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.gFV.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.b.a(dataList, str, cardHListViewData, intExtra)) {
                        frsViewData.setThreadList(dataList);
                        this.gmj.a(dataList, frsViewData);
                        dh(str, this.gEE.getForumId());
                    }
                }
            }
        }
    }

    public static void dh(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            an anVar = new an("c11959");
            anVar.cp("tid", str);
            anVar.cp("fid", str2);
            anVar.Z("obj_type", 1);
            TiebaStatic.log(anVar);
        }
    }

    private ShareFromPBMsgData bHy() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.dlS);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void aj(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bHy(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gEE.getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.gEE.getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.jI(1);
            aVar.aO(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.gEE.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.gEE.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.gEE.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.aJV() != null) {
                        Bundle aJV = shareItem.aJV();
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).Z("obj_source", 1).Z("obj_type", aJV.getInt("obj_type")).Z("obj_param1", 3).cp("fid", aJV.getString("fid")).cp("tid", aJV.getString("tid")));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.gEE.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.gEE.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.fA(true);
            aVar.b(this.gEE.getPageContext()).aCp();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.am(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.gEE.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.gEv == null) {
            this.gEv = new com.baidu.tieba.c.g(this.gEE.getPageContext(), (NavigationBarCoverTip) this.gEE.getView().findViewById(R.id.navigation_cover_tip));
        }
        if (this.gEE.bCK() != null && this.gEE.bCK().getForum() != null && this.gEE.bCK().getForum().isLike() == 1) {
            this.gEv.kv(true);
        } else {
            this.gEv.kv(false);
        }
        this.gEv.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.gEv != null) {
            this.gEv.onDestroy();
        }
    }
}
