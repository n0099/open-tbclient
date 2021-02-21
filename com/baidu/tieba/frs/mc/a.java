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
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.Thread2GroupShareView;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends j {
    private final CustomMessageListener jEM;
    private d jgX;

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.jEM = new CustomMessageListener(2001383) { // from class: com.baidu.tieba.frs.mc.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                    if (a.this.jgX != null) {
                        a.this.jgX.f(postWriteCallBackData);
                    }
                    if (!a.this.e(postWriteCallBackData)) {
                        a.this.d(postWriteCallBackData);
                    } else {
                        com.baidu.tbadk.coreExtra.c.b.a(a.this.jEV.getTbPageContext(), postWriteCallBackData);
                    }
                }
            }
        };
        this.jgX = this.jEV.cCu();
        this.jEM.setTag(this.jEV.getPageContext().getUniqueId());
        this.jEM.setSelfListener(true);
        this.jEV.registerListener(this.jEM);
    }

    private void cJx() {
        if (this.jgX == null) {
            this.jgX = this.jEV.cCu();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        cJx();
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
        com.baidu.tieba.frs.vc.d cDH;
        ShareItem shareItem;
        cb threadDataById;
        FrsViewData cDg = this.jEV.cDg();
        switch (i) {
            case RequestResponseCode.REQUEST_LOGIN_WRITE /* 11001 */:
                this.jEV.yz(0);
                return;
            case RequestResponseCode.REQUEST_LOGIN_LIKE /* 11002 */:
                this.jgO.rA(true);
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_HOST /* 11011 */:
                com.baidu.tieba.frs.d.l.a(this.jEV, this.jEV.getThreadId(), this.jEV.akU, this.jEV.cCD());
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_REVERSE /* 11012 */:
                com.baidu.tieba.frs.d.l.b(this.jEV, this.jEV.getThreadId(), this.jEV.akU, this.jEV.cCD());
                return;
            case RequestResponseCode.REQUEST_LOGIN_SIGN /* 11014 */:
                this.jgO.cLy();
                return;
            case RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE /* 11016 */:
                this.jgv.cDQ();
                return;
            case RequestResponseCode.REQUEST_LOGIN_FRS_SHAKE /* 11033 */:
            case RequestResponseCode.REQUEST_WRITE_NEW /* 13003 */:
            case RequestResponseCode.REQUEST_CODE_PHOTO_LIVE_LIST /* 23013 */:
            case RequestResponseCode.REQUEST_CODE_HEADLINE /* 23019 */:
            case RequestResponseCode.REQUEST_SDK_WEB_VIEW /* 25048 */:
            default:
                return;
            case RequestResponseCode.REQUEST_LOGIN_UNLIKE /* 11036 */:
                this.jgO.cLh();
                return;
            case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
                this.jgv.cEb().notifyDataSetChanged();
                if (this.jgO != null) {
                    this.jgO.cGl();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.jEV.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = cDg.getThreadDataById(stringExtra)) != null) {
                    if (intExtra == 2) {
                        threadDataById.nn(intent.getIntExtra("good_data", 0));
                        threadDataById.boP();
                    }
                    a(cDg, intent, stringExtra);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_FRS_FO_WEBVIEW /* 18004 */:
                com.baidu.tieba.frs.d.l.c(this.jEV.getPageContext(), cDg);
                return;
            case RequestResponseCode.REQUEST_SELECT_IM_CHAT_GROUP_CODE /* 23003 */:
                if (intent != null && cDg != null) {
                    com.baidu.tieba.frs.d.h.a(this.jEV, cDg, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
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
                    if (intExtra2 == com.baidu.adp.lib.f.b.toInt(this.jEV.getForumId(), 0)) {
                        this.jgO.T(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                int intExtra6 = intent.getIntExtra("extra_share_status", 2);
                if (intExtra6 == 1 && (shareItem = TbadkCoreApplication.getInst().getShareItem()) != null) {
                    ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    arVar.ap("obj_locate", 4);
                    arVar.dR("tid", shareItem.tid);
                    arVar.dR("pid", intent.getStringExtra("pid"));
                    TiebaStatic.log(arVar);
                }
                if (intExtra6 == 1) {
                    this.jEV.Kh(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_DO_PAY /* 25041 */:
                this.jGd.sT(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
            case RequestResponseCode.REQUEST_SDK_RENAME /* 25050 */:
                this.jEV.refresh();
                return;
            case RequestResponseCode.REQUEST_MOBILE_MODIFY_NICKNAME_DIALOG /* 25052 */:
                String stringExtra2 = intent.getStringExtra("group_name");
                boolean booleanExtra = intent.getBooleanExtra("from", true);
                this.jEV.Kg(stringExtra2);
                if (!booleanExtra && this.jgO != null) {
                    this.jgO.cGt();
                    return;
                }
                return;
            case 25054:
                q cCB = this.jEV.cCB();
                if (cCB != null && (cDH = cCB.cDH()) != null) {
                    cDH.cLe();
                    return;
                }
                return;
        }
    }

    public void zZ(int i) {
        if (this.jEV != null && this.jEV.cCz() != null) {
            if (i > 0) {
                FrsTabViewController.b AG = this.jEV.cCz().AG(i);
                if (AG != null && (AG.fragment instanceof FrsCommonTabFragment)) {
                    this.jGd.sT(i);
                    return;
                }
                return;
            }
            int cLQ = this.jEV.cCz().cLQ();
            if (this.jEV.cCz().AG(cLQ) != null) {
                this.jGd.sT(cLQ);
            }
        }
    }

    private void a(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.n> dataList;
        if (frsViewData != null && intent != null && !TextUtils.isEmpty(str) && this.jgN != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.jgN.cJR()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.jGf.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.b.a(dataList, str, cardHListViewData, intExtra)) {
                        frsViewData.setThreadList(dataList);
                        this.jgv.a(dataList, frsViewData);
                        fa(str, this.jEV.getForumId());
                    }
                }
            }
        }
    }

    public static void fa(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ar arVar = new ar("c11959");
            arVar.dR("tid", str);
            arVar.dR("fid", str2);
            arVar.ap("obj_type", 1);
            TiebaStatic.log(arVar);
        }
    }

    private ShareFromPBMsgData cJy() {
        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.fuV);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.fName);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void T(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(cJy(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jEV.getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.jEV.getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.nA(1);
            aVar.bn(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.jEV.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.jEV.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.jEV.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.bzc() != null) {
                        Bundle bzc = shareItem.bzc();
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ap("obj_source", 1).ap("obj_type", bzc.getInt("obj_type")).ap("obj_param1", 3).dR("fid", bzc.getString("fid")).dR("tid", bzc.getString("tid")));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.adp.lib.util.l.hideSoftKeyPad(a.this.jEV.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.jG(true);
            aVar.b(this.jEV.getPageContext()).bqx();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.aP(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || au.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoEasterEggActivityConfig(this.jEV.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(PostWriteCallBackData postWriteCallBackData) {
        return (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) ? false : true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jEM);
    }
}
