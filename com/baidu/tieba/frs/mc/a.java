package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends j {
    private d jbd;
    private final CustomMessageListener jyT;

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.jyT = new CustomMessageListener(2001383) { // from class: com.baidu.tieba.frs.mc.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                    if (a.this.jbd != null) {
                        a.this.jbd.f(postWriteCallBackData);
                    }
                    if (!a.this.e(postWriteCallBackData)) {
                        a.this.d(postWriteCallBackData);
                    } else {
                        com.baidu.tbadk.coreExtra.c.b.a(a.this.jzc.getTbPageContext(), postWriteCallBackData);
                    }
                }
            }
        };
        this.jbd = this.jzc.cBb();
        this.jyT.setTag(this.jzc.getPageContext().getUniqueId());
        this.jyT.setSelfListener(true);
        this.jzc.registerListener(this.jyT);
    }

    private void cId() {
        if (this.jbd == null) {
            this.jbd = this.jzc.cBb();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        cId();
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
        bz threadDataById;
        FrsViewData cBN = this.jzc.cBN();
        switch (i) {
            case RequestResponseCode.REQUEST_LOGIN_WRITE /* 11001 */:
                this.jzc.yp(0);
                return;
            case RequestResponseCode.REQUEST_LOGIN_LIKE /* 11002 */:
                this.jaU.rq(true);
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_HOST /* 11011 */:
                com.baidu.tieba.frs.d.l.a(this.jzc, this.jzc.getThreadId(), this.jzc.ale, this.jzc.cBk());
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_REVERSE /* 11012 */:
                com.baidu.tieba.frs.d.l.b(this.jzc, this.jzc.getThreadId(), this.jzc.ale, this.jzc.cBk());
                return;
            case RequestResponseCode.REQUEST_LOGIN_SIGN /* 11014 */:
                this.jaU.cKd();
                return;
            case RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE /* 11016 */:
                this.jaB.cCx();
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_SHAKE /* 11033 */:
            case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
            case RequestResponseCode.REQUEST_CODE_PHOTO_LIVE_LIST /* 23013 */:
            case RequestResponseCode.REQUEST_CODE_HEADLINE /* 23019 */:
            case RequestResponseCode.REQUEST_SDK_WEB_VIEW /* 25048 */:
            default:
                return;
            case RequestResponseCode.REQUEST_LOGIN_UNLIKE /* 11036 */:
                this.jaU.cJM();
                return;
            case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                this.jaB.cCI().notifyDataSetChanged();
                if (this.jaU != null) {
                    this.jaU.cER();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.jzc.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = cBN.getThreadDataById(stringExtra)) != null) {
                    if (intExtra == 2) {
                        threadDataById.nk(intent.getIntExtra("good_data", 0));
                        threadDataById.box();
                    }
                    a(cBN, intent, stringExtra);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_FO_WEBVIEW /* 18004 */:
                com.baidu.tieba.frs.d.l.c(this.jzc.getPageContext(), cBN);
                return;
            case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                if (intent != null && cBN != null) {
                    com.baidu.tieba.frs.d.h.a(this.jzc, cBN, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_SHARE_FRIEND_FORUM /* 23007 */:
                T(intent);
                return;
            case RequestResponseCode.REQUEST_FRS_TO_SUPPLEMENT_RESIGN /* 24002 */:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.f.b.toInt(this.jzc.getForumId(), 0)) {
                        this.jaU.T(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                int intExtra6 = intent.getIntExtra("extra_share_status", 2);
                if (intExtra6 == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null) {
                    aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    aqVar.an("obj_locate", 4);
                    aqVar.dW("tid", shareItem.tid);
                    aqVar.dW("pid", intent.getStringExtra("pid"));
                    TiebaStatic.log(aqVar);
                }
                if (intExtra6 == 1) {
                    this.jzc.Jv(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_DO_PAY /* 25041 */:
                this.jAl.sO(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
            case RequestResponseCode.REQUEST_SDK_RENAME /* 25050 */:
                this.jzc.refresh();
                return;
            case RequestResponseCode.REQUEST_MOBILE_MODIFY_NICKNAME_DIALOG /* 25052 */:
                String stringExtra2 = intent.getStringExtra("group_name");
                boolean booleanExtra = intent.getBooleanExtra("from", true);
                this.jzc.Ju(stringExtra2);
                if (!booleanExtra && this.jaU != null) {
                    this.jaU.cEZ();
                    return;
                }
                return;
        }
    }

    public void zQ(int i) {
        if (this.jzc != null && this.jzc.cBg() != null) {
            if (i > 0) {
                FrsTabViewController.b Aw = this.jzc.cBg().Aw(i);
                if (Aw != null && (Aw.fragment instanceof FrsCommonTabFragment)) {
                    this.jAl.sO(i);
                    return;
                }
                return;
            }
            int cKv = this.jzc.cBg().cKv();
            if (this.jzc.cBg().Aw(cKv) != null) {
                this.jAl.sO(cKv);
            }
        }
    }

    private void a(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.n> dataList;
        if (frsViewData != null && intent != null && !TextUtils.isEmpty(str) && this.jaT != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.jaT.cIx()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.jAn.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.b.a(dataList, str, cardHListViewData, intExtra)) {
                        frsViewData.setThreadList(dataList);
                        this.jaB.a(dataList, frsViewData);
                        fa(str, this.jzc.getForumId());
                    }
                }
            }
        }
    }

    public static void fa(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            aq aqVar = new aq("c11959");
            aqVar.dW("tid", str);
            aqVar.dW("fid", str2);
            aqVar.an("obj_type", 1);
            TiebaStatic.log(aqVar);
        }
    }

    private ShareFromPBMsgData cIe() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.fsD);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void T(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(cIe(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jzc.getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.jzc.getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.nx(1);
            aVar.br(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.jzc.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.jzc.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.jzc.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.byK() != null) {
                        Bundle byK = shareItem.byK();
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).an("obj_source", 1).an("obj_type", byK.getInt("obj_type")).an("obj_param1", 3).dW("fid", byK.getString("fid")).dW("tid", byK.getString("tid")));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.jzc.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.jE(true);
            aVar.b(this.jzc.getPageContext()).bqe();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aQ(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || at.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.jzc.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(PostWriteCallBackData postWriteCallBackData) {
        return (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) ? false : true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jyT);
    }
}
