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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
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
/* loaded from: classes16.dex */
public class a extends j {
    private d hGc;
    private com.baidu.tieba.c.h hZT;

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.hGc = this.iac.cbp();
    }

    private void chc() {
        if (this.hGc == null) {
            this.hGc = this.iac.cbp();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        chc();
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
        bv threadDataById;
        PostWriteCallBackData postWriteCallBackData;
        FrsViewData cbZ = this.iac.cbZ();
        switch (i) {
            case 11001:
                this.iac.uF(0);
                return;
            case 11002:
                this.hFT.oA(true);
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_HOST /* 11011 */:
                com.baidu.tieba.frs.f.i.a(this.iac, this.iac.getThreadId(), this.iac.aii, this.iac.cby());
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_REVERSE /* 11012 */:
                com.baidu.tieba.frs.f.i.b(this.iac, this.iac.getThreadId(), this.iac.aii, this.iac.cby());
                return;
            case RequestResponseCode.REQUEST_LOGIN_SIGN /* 11014 */:
                this.hFT.ciN();
                return;
            case RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE /* 11016 */:
                this.hFz.ccJ();
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_SHAKE /* 11033 */:
            case RequestResponseCode.REQUEST_CODE_PHOTO_LIVE_LIST /* 23013 */:
            case RequestResponseCode.REQUEST_CODE_HEADLINE /* 23019 */:
            default:
                return;
            case RequestResponseCode.REQUEST_LOGIN_UNLIKE /* 11036 */:
                this.hFT.ciJ();
                return;
            case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
            case RequestResponseCode.REQUEST_SDK_WEB_VIEW /* 25048 */:
                if (intent != null) {
                    int intExtra = intent.getIntExtra(PostWriteCallBackData.GENERAL_TAB_ID, -1);
                    if (intExtra >= 0) {
                        vU(intExtra);
                        return;
                    }
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.hGc != null) {
                        this.hGc.e(postWriteCallBackData);
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
                    vU(intExtra2);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                this.hFz.ccU().notifyDataSetChanged();
                if (this.hFT != null) {
                    this.hFT.ceV();
                }
                int intExtra3 = intent.getIntExtra("type", -1);
                if (intExtra3 == 4) {
                    this.iac.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = cbZ.getThreadDataById(stringExtra)) != null) {
                    if (intExtra3 == 2) {
                        threadDataById.ld(intent.getIntExtra("good_data", 0));
                        threadDataById.aXj();
                    }
                    a(cbZ, intent, stringExtra);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_FO_WEBVIEW /* 18004 */:
                com.baidu.tieba.frs.f.i.c(this.iac.getPageContext(), cbZ);
                return;
            case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                if (intent != null && cbZ != null) {
                    com.baidu.tieba.frs.f.e.a(this.iac, cbZ, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                T(intent);
                return;
            case RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN /* 24002 */:
                if (intent != null) {
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra6 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra7 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra4 == com.baidu.adp.lib.f.b.toInt(this.iac.getForumId(), 0)) {
                        this.hFT.N(intExtra5, intExtra6, intExtra7);
                        return;
                    }
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                if (intent.getIntExtra("extra_share_status", 2) == 1) {
                    this.iac.onShareSuccess(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_DO_PAY /* 25041 */:
                this.ibn.wA(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
            case RequestResponseCode.REQUEST_SDK_RENAME /* 25050 */:
                this.iac.refresh();
                return;
        }
    }

    public void vU(int i) {
        if (this.iac != null && this.iac.cbu() != null) {
            if (i > 0) {
                FrsTabViewController.b wz = this.iac.cbu().wz(i);
                if (wz != null && (wz.fragment instanceof FrsCommonTabFragment)) {
                    this.ibn.wA(i);
                    return;
                }
                return;
            }
            int cjk = this.iac.cbu().cjk();
            if (this.iac.cbu().wz(cjk) != null) {
                this.ibn.wA(cjk);
            }
        }
    }

    private void a(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<q> dataList;
        if (frsViewData != null && intent != null && !TextUtils.isEmpty(str) && this.hFS != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.hFS.chw()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.ibp.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.b.a(dataList, str, cardHListViewData, intExtra)) {
                        frsViewData.setThreadList(dataList);
                        this.hFz.a(dataList, frsViewData);
                        em(str, this.iac.getForumId());
                    }
                }
            }
        }
    }

    public static void em(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ap apVar = new ap("c11959");
            apVar.dn("tid", str);
            apVar.dn("fid", str2);
            apVar.ah("obj_type", 1);
            TiebaStatic.log(apVar);
        }
    }

    private ShareFromPBMsgData chd() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.etQ);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void T(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(chd(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iac.getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.iac.getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.lq(1);
            aVar.aV(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.iac.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.iac.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.iac.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bgL() != null) {
                        Bundle bgL = shareItem.bgL();
                        TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ah("obj_source", 1).ah("obj_type", bgL.getInt("obj_type")).ah("obj_param1", 3).dn("fid", bgL.getString("fid")).dn("tid", bgL.getString("tid")));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.iac.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.iac.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.hK(true);
            aVar.b(this.iac.getPageContext()).aYL();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aF(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || as.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.iac.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.hZT == null) {
            this.hZT = new com.baidu.tieba.c.h(this.iac.getPageContext(), (NavigationBarCoverTip) this.iac.getView().findViewById(R.id.navigation_cover_tip));
        }
        if (this.iac.cbZ() != null && this.iac.cbZ().getForum() != null && this.iac.cbZ().getForum().isLike() == 1) {
            this.hZT.mR(true);
        } else {
            this.hZT.mR(false);
        }
        this.hZT.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.hZT != null) {
            this.hZT.onDestroy();
        }
    }
}
