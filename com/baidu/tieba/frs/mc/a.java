package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes22.dex */
public class a extends j {
    private d iTz;
    private com.baidu.tieba.d.h jrd;

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.iTz = this.jrm.cBY();
    }

    private void cIU() {
        if (this.iTz == null) {
            this.iTz = this.jrm.cBY();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        cIU();
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
            case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                return;
        }
    }

    private void c(int i, Intent intent) {
        ShareItem shareItem;
        by threadDataById;
        PostWriteCallBackData postWriteCallBackData;
        FrsViewData cCK = this.jrm.cCK();
        switch (i) {
            case RequestResponseCode.REQUEST_LOGIN_WRITE /* 11001 */:
                this.jrm.zI(0);
                return;
            case RequestResponseCode.REQUEST_LOGIN_LIKE /* 11002 */:
                this.iTq.qW(true);
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_HOST /* 11011 */:
                com.baidu.tieba.frs.f.l.a(this.jrm, this.jrm.getThreadId(), this.jrm.alu, this.jrm.cCh());
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_REVERSE /* 11012 */:
                com.baidu.tieba.frs.f.l.b(this.jrm, this.jrm.getThreadId(), this.jrm.alu, this.jrm.cCh());
                return;
            case RequestResponseCode.REQUEST_LOGIN_SIGN /* 11014 */:
                this.iTq.cKH();
                return;
            case RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE /* 11016 */:
                this.iSX.cDu();
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_SHAKE /* 11033 */:
            case RequestResponseCode.REQUEST_CODE_PHOTO_LIVE_LIST /* 23013 */:
            case RequestResponseCode.REQUEST_CODE_HEADLINE /* 23019 */:
            default:
                return;
            case RequestResponseCode.REQUEST_LOGIN_UNLIKE /* 11036 */:
                this.iTq.cKD();
                return;
            case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
            case RequestResponseCode.REQUEST_SDK_WEB_VIEW /* 25048 */:
                if (intent != null) {
                    int intExtra = intent.getIntExtra(PostWriteCallBackData.GENERAL_TAB_ID, -1);
                    if (intExtra >= 0) {
                        Bk(intExtra);
                        return;
                    }
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.iTz != null) {
                        this.iTz.f(postWriteCallBackData);
                    }
                    if (e(postWriteCallBackData)) {
                        com.baidu.tbadk.coreExtra.c.b.a(this.jrm.getTbPageContext(), postWriteCallBackData);
                        return;
                    } else if (!d(postWriteCallBackData)) {
                        b(postWriteCallBackData);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case RequestResponseCode.REQUEST_RECORDER_VIDEO /* 13010 */:
                int intExtra2 = intent.getIntExtra(PostWriteCallBackData.GENERAL_TAB_ID, -1);
                if (intExtra2 >= 0) {
                    Bk(intExtra2);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                this.iSX.cDF().notifyDataSetChanged();
                if (this.iTq != null) {
                    this.iTq.cFM();
                }
                int intExtra3 = intent.getIntExtra("type", -1);
                if (intExtra3 == 4) {
                    this.jrm.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = cCK.getThreadDataById(stringExtra)) != null) {
                    if (intExtra3 == 2) {
                        threadDataById.oG(intent.getIntExtra("good_data", 0));
                        threadDataById.bpP();
                    }
                    a(cCK, intent, stringExtra);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_FO_WEBVIEW /* 18004 */:
                com.baidu.tieba.frs.f.l.c(this.jrm.getPageContext(), cCK);
                return;
            case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                if (intent != null && cCK != null) {
                    com.baidu.tieba.frs.f.h.a(this.jrm, cCK, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (intExtra4 == com.baidu.adp.lib.f.b.toInt(this.jrm.getForumId(), 0)) {
                        this.iTq.R(intExtra5, intExtra6, intExtra7);
                        return;
                    }
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                int intExtra8 = intent.getIntExtra("extra_share_status", 2);
                if (intExtra8 == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null) {
                    ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    arVar.al("obj_locate", 4);
                    arVar.dY("tid", shareItem.tid);
                    arVar.dY("pid", intent.getStringExtra("pid"));
                    TiebaStatic.log(arVar);
                }
                if (intExtra8 == 1) {
                    this.jrm.onShareSuccess(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_DO_PAY /* 25041 */:
                this.jsw.ui(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
            case RequestResponseCode.REQUEST_SDK_RENAME /* 25050 */:
                this.jrm.refresh();
                return;
            case RequestResponseCode.REQUEST_MOBILE_MODIFY_NICKNAME_DIALOG /* 25052 */:
                String stringExtra2 = intent.getStringExtra("group_name");
                boolean booleanExtra = intent.getBooleanExtra("from", true);
                this.jrm.KI(stringExtra2);
                if (!booleanExtra && this.iTq != null) {
                    this.iTq.cFS();
                    return;
                }
                return;
        }
    }

    public void Bk(int i) {
        if (this.jrm != null && this.jrm.cCd() != null) {
            if (i > 0) {
                FrsTabViewController.b BQ = this.jrm.cCd().BQ(i);
                if (BQ != null && (BQ.fragment instanceof FrsCommonTabFragment)) {
                    this.jsw.ui(i);
                    return;
                }
                return;
            }
            int cLj = this.jrm.cCd().cLj();
            if (this.jrm.cCd().BQ(cLj) != null) {
                this.jsw.ui(cLj);
            }
        }
    }

    private void a(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<q> dataList;
        if (frsViewData != null && intent != null && !TextUtils.isEmpty(str) && this.iTp != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.iTp.cJo()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.jsy.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.b.a(dataList, str, cardHListViewData, intExtra)) {
                        frsViewData.setThreadList(dataList);
                        this.iSX.a(dataList, frsViewData);
                        fa(str, this.jrm.getForumId());
                    }
                }
            }
        }
    }

    public static void fa(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ar arVar = new ar("c11959");
            arVar.dY("tid", str);
            arVar.dY("fid", str2);
            arVar.al("obj_type", 1);
            TiebaStatic.log(arVar);
        }
    }

    private ShareFromPBMsgData cIV() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.fnC);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void S(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(cIV(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jrm.getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.jrm.getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.oT(1);
            aVar.bi(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.jrm.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.jrm.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.jrm.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bAj() != null) {
                        Bundle bAj = shareItem.bAj();
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).al("obj_source", 1).al("obj_type", bAj.getInt("obj_type")).al("obj_param1", 3).dY("fid", bAj.getString("fid")).dY("tid", bAj.getString("tid")));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.jrm.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.jrm.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.jm(true);
            aVar.b(this.jrm.getPageContext()).brv();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aQ(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.jrm.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.jrd == null) {
            this.jrd = new com.baidu.tieba.d.h(this.jrm.getPageContext(), (NavigationBarCoverTip) this.jrm.getView().findViewById(R.id.navigation_cover_tip));
        }
        if (this.jrm.cCK() != null && this.jrm.cCK().getForum() != null && this.jrm.cCK().getForum().isLike() == 1) {
            this.jrd.pi(true);
        } else {
            this.jrd.pi(false);
        }
        this.jrd.b(postWriteCallBackData);
    }

    private boolean e(PostWriteCallBackData postWriteCallBackData) {
        return (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) ? false : true;
    }

    public void onDestroy() {
        if (this.jrd != null) {
            this.jrd.onDestroy();
        }
    }
}
