package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
/* loaded from: classes4.dex */
public class a extends j {
    private com.baidu.tieba.c.f fOv;
    private d fwD;

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.fwD = this.fOE.bmC();
    }

    private void brX() {
        if (this.fwD == null) {
            this.fwD = this.fOE.bmC();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        brX();
        if (i2 == -1) {
            c(i, intent);
        } else if (i2 == 0) {
            b(i, intent);
        }
    }

    private void b(int i, Intent intent) {
        switch (i) {
            case 12003:
            default:
                return;
        }
    }

    private void c(int i, Intent intent) {
        bh threadDataById;
        PostWriteCallBackData postWriteCallBackData;
        FrsViewData bnj = this.fOE.bnj();
        switch (i) {
            case SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE /* 11001 */:
                this.fOE.rw(0);
                return;
            case SapiGIDEvent.SYSTEM_NETWORK_CHANGE_MOB_TO_WIFI /* 11002 */:
                this.fwt.kT(true);
                return;
            case 11011:
                com.baidu.tieba.frs.f.i.a(this.fOE, this.fOE.getThreadId(), this.fOE.cdk, this.fOE.bmL());
                return;
            case 11012:
                com.baidu.tieba.frs.f.i.b(this.fOE, this.fOE.getThreadId(), this.fOE.cdk, this.fOE.bmL());
                return;
            case 11014:
                this.fwt.btG();
                return;
            case 11016:
                this.fwb.bnP();
                return;
            case 11033:
            case 23013:
            case 23019:
            default:
                return;
            case 11036:
                this.fwt.btF();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.fwD != null) {
                        this.fwD.e(postWriteCallBackData);
                    }
                    if (!d(postWriteCallBackData)) {
                        b(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.fwb.bnZ().notifyDataSetChanged();
                if (this.fwt != null) {
                    this.fwt.bpL();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.fOE.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = bnj.getThreadDataById(stringExtra)) != null) {
                    if (intExtra == 2) {
                        threadDataById.hm(intent.getIntExtra("good_data", 0));
                        threadDataById.afs();
                    }
                    a(bnj, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.f.i.b(this.fOE.getPageContext(), bnj);
                return;
            case 23003:
                if (intent != null && bnj != null) {
                    com.baidu.tieba.frs.f.e.a(this.fOE, bnj, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                ai(intent);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.f(this.fOE.getForumId(), 0)) {
                        this.fwt.L(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
            case 24007:
                if (intent.getIntExtra("extra_share_status", 2) == 1) {
                    this.fOE.xu(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case 25041:
                this.fPO.te(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
        }
    }

    private void a(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<m> dataList;
        if (frsViewData != null && intent != null && !TextUtils.isEmpty(str) && this.fws != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.fws.bsp()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.fPQ.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.b.a(dataList, str, cardHListViewData, intExtra)) {
                        frsViewData.setThreadList(dataList);
                        this.fwb.a(dataList, frsViewData);
                        da(str, this.fOE.getForumId());
                    }
                }
            }
        }
    }

    public static void da(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            an anVar = new an("c11959");
            anVar.bT("tid", str);
            anVar.bT("fid", str2);
            anVar.P("obj_type", 1);
            TiebaStatic.log(anVar);
        }
    }

    private ShareFromPBMsgData brY() {
        com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.clK);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.clE);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void ai(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(brY(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fOE.getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.fOE.getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hy(1);
            aVar.aH(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.fOE.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.b(a.this.fOE.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(a.this.fOE.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.aqk() != null) {
                        Bundle aqk = shareItem.aqk();
                        TiebaStatic.log(new an("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).P("obj_type", aqk.getInt("obj_type")).P("obj_param1", 3).bT("fid", aqk.getString("fid")).bT("tid", aqk.getString("tid")));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.fOE.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.b(a.this.fOE.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.dR(true);
            aVar.b(this.fOE.getPageContext()).agO();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.am(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.fOE.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fOv == null) {
            this.fOv = new com.baidu.tieba.c.f(this.fOE.getPageContext(), (NavigationBarCoverTip) this.fOE.getView().findViewById(R.id.navigation_cover_tip));
        }
        if (this.fOE.bnj() != null && this.fOE.bnj().getForum() != null && this.fOE.bnj().getForum().isLike() == 1) {
            this.fOv.iV(true);
        } else {
            this.fOv.iV(false);
        }
        this.fOv.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.fOv != null) {
            this.fOv.onDestroy();
        }
    }
}
