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
    private d iTx;
    private com.baidu.tieba.d.h jrb;

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.iTx = this.jrk.cBX();
    }

    private void cIT() {
        if (this.iTx == null) {
            this.iTx = this.jrk.cBX();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        cIT();
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
        FrsViewData cCJ = this.jrk.cCJ();
        switch (i) {
            case RequestResponseCode.REQUEST_LOGIN_WRITE /* 11001 */:
                this.jrk.zI(0);
                return;
            case RequestResponseCode.REQUEST_LOGIN_LIKE /* 11002 */:
                this.iTo.qW(true);
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_HOST /* 11011 */:
                com.baidu.tieba.frs.f.l.a(this.jrk, this.jrk.getThreadId(), this.jrk.alu, this.jrk.cCg());
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_REVERSE /* 11012 */:
                com.baidu.tieba.frs.f.l.b(this.jrk, this.jrk.getThreadId(), this.jrk.alu, this.jrk.cCg());
                return;
            case RequestResponseCode.REQUEST_LOGIN_SIGN /* 11014 */:
                this.iTo.cKG();
                return;
            case RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE /* 11016 */:
                this.iSV.cDt();
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_SHAKE /* 11033 */:
            case RequestResponseCode.REQUEST_CODE_PHOTO_LIVE_LIST /* 23013 */:
            case RequestResponseCode.REQUEST_CODE_HEADLINE /* 23019 */:
            default:
                return;
            case RequestResponseCode.REQUEST_LOGIN_UNLIKE /* 11036 */:
                this.iTo.cKC();
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
                    if (this.iTx != null) {
                        this.iTx.f(postWriteCallBackData);
                    }
                    if (e(postWriteCallBackData)) {
                        com.baidu.tbadk.coreExtra.c.b.a(this.jrk.getTbPageContext(), postWriteCallBackData);
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
                this.iSV.cDE().notifyDataSetChanged();
                if (this.iTo != null) {
                    this.iTo.cFL();
                }
                int intExtra3 = intent.getIntExtra("type", -1);
                if (intExtra3 == 4) {
                    this.jrk.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = cCJ.getThreadDataById(stringExtra)) != null) {
                    if (intExtra3 == 2) {
                        threadDataById.oG(intent.getIntExtra("good_data", 0));
                        threadDataById.bpP();
                    }
                    a(cCJ, intent, stringExtra);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_FO_WEBVIEW /* 18004 */:
                com.baidu.tieba.frs.f.l.c(this.jrk.getPageContext(), cCJ);
                return;
            case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                if (intent != null && cCJ != null) {
                    com.baidu.tieba.frs.f.h.a(this.jrk, cCJ, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (intExtra4 == com.baidu.adp.lib.f.b.toInt(this.jrk.getForumId(), 0)) {
                        this.iTo.R(intExtra5, intExtra6, intExtra7);
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
                    this.jrk.onShareSuccess(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_DO_PAY /* 25041 */:
                this.jsu.ui(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
            case RequestResponseCode.REQUEST_SDK_RENAME /* 25050 */:
                this.jrk.refresh();
                return;
            case RequestResponseCode.REQUEST_MOBILE_MODIFY_NICKNAME_DIALOG /* 25052 */:
                String stringExtra2 = intent.getStringExtra("group_name");
                boolean booleanExtra = intent.getBooleanExtra("from", true);
                this.jrk.KI(stringExtra2);
                if (!booleanExtra && this.iTo != null) {
                    this.iTo.cFR();
                    return;
                }
                return;
        }
    }

    public void Bk(int i) {
        if (this.jrk != null && this.jrk.cCc() != null) {
            if (i > 0) {
                FrsTabViewController.b BQ = this.jrk.cCc().BQ(i);
                if (BQ != null && (BQ.fragment instanceof FrsCommonTabFragment)) {
                    this.jsu.ui(i);
                    return;
                }
                return;
            }
            int cLi = this.jrk.cCc().cLi();
            if (this.jrk.cCc().BQ(cLi) != null) {
                this.jsu.ui(cLi);
            }
        }
    }

    private void a(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<q> dataList;
        if (frsViewData != null && intent != null && !TextUtils.isEmpty(str) && this.iTn != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.iTn.cJn()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.jsw.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.b.a(dataList, str, cardHListViewData, intExtra)) {
                        frsViewData.setThreadList(dataList);
                        this.iSV.a(dataList, frsViewData);
                        fa(str, this.jrk.getForumId());
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

    private ShareFromPBMsgData cIU() {
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
        a(cIU(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jrk.getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.jrk.getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.oT(1);
            aVar.bi(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.jrk.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.jrk.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.jrk.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
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
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.jrk.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.jrk.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.jm(true);
            aVar.b(this.jrk.getPageContext()).brv();
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.jrk.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.jrb == null) {
            this.jrb = new com.baidu.tieba.d.h(this.jrk.getPageContext(), (NavigationBarCoverTip) this.jrk.getView().findViewById(R.id.navigation_cover_tip));
        }
        if (this.jrk.cCJ() != null && this.jrk.cCJ().getForum() != null && this.jrk.cCJ().getForum().isLike() == 1) {
            this.jrb.pi(true);
        } else {
            this.jrb.pi(false);
        }
        this.jrb.b(postWriteCallBackData);
    }

    private boolean e(PostWriteCallBackData postWriteCallBackData) {
        return (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) ? false : true;
    }

    public void onDestroy() {
        if (this.jrb != null) {
            this.jrb.onDestroy();
        }
    }
}
