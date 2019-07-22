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
import com.baidu.tbadk.core.data.bg;
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
    private com.baidu.tieba.c.f fLS;
    private d fur;

    public a(FrsFragment frsFragment) {
        super(frsFragment);
        this.fur = this.fMb.blK();
    }

    private void bqZ() {
        if (this.fur == null) {
            this.fur = this.fMb.blK();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bqZ();
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
        bg threadDataById;
        PostWriteCallBackData postWriteCallBackData;
        FrsViewData bmo = this.fMb.bmo();
        switch (i) {
            case SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE /* 11001 */:
                this.fMb.rr(0);
                return;
            case SapiGIDEvent.SYSTEM_NETWORK_CHANGE_MOB_TO_WIFI /* 11002 */:
                this.fuh.kQ(true);
                return;
            case 11011:
                com.baidu.tieba.frs.f.i.a(this.fMb, this.fMb.getThreadId(), this.fMb.ccj, this.fMb.blT());
                return;
            case 11012:
                com.baidu.tieba.frs.f.i.b(this.fMb, this.fMb.getThreadId(), this.fMb.ccj, this.fMb.blT());
                return;
            case 11014:
                this.fuh.bsG();
                return;
            case 11016:
                this.ftP.bmU();
                return;
            case 11033:
            case 23013:
            case 23019:
            default:
                return;
            case 11036:
                this.fuh.bsF();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.fur != null) {
                        this.fur.e(postWriteCallBackData);
                    }
                    if (!d(postWriteCallBackData)) {
                        b(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.ftP.bne().notifyDataSetChanged();
                if (this.fuh != null) {
                    this.fuh.boN();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.fMb.refresh(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (threadDataById = bmo.getThreadDataById(stringExtra)) != null) {
                    if (intExtra == 2) {
                        threadDataById.hl(intent.getIntExtra("good_data", 0));
                        threadDataById.afn();
                    }
                    a(bmo, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.f.i.b(this.fMb.getPageContext(), bmo);
                return;
            case 23003:
                if (intent != null && bmo != null) {
                    com.baidu.tieba.frs.f.e.a(this.fMb, bmo, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                ag(intent);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.f(this.fMb.getForumId(), 0)) {
                        this.fuh.K(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
            case 24007:
                if (intent.getIntExtra("extra_share_status", 2) == 1) {
                    this.fMb.wU(intent.getStringExtra("tid"));
                    return;
                }
                return;
            case 25041:
                this.fNk.sY(intent.getIntExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1));
                return;
        }
    }

    private void a(FrsViewData frsViewData, Intent intent, String str) {
        ArrayList<m> dataList;
        if (frsViewData != null && intent != null && !TextUtils.isEmpty(str) && this.fug != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.fug.brq()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.fNm.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.b.a(dataList, str, cardHListViewData, intExtra)) {
                        frsViewData.setThreadList(dataList);
                        this.ftP.a(dataList, frsViewData);
                        cZ(str, this.fMb.getForumId());
                    }
                }
            }
        }
    }

    public static void cZ(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            an anVar = new an("c11959");
            anVar.bT("tid", str);
            anVar.bT("fid", str2);
            anVar.P("obj_type", 1);
            TiebaStatic.log(anVar);
        }
    }

    private ShareFromPBMsgData bra() {
        com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.imageUri == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.imageUri.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.ckI);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.ckC);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void ag(Intent intent) {
        long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
        String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
        String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
        a(bra(), longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2);
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fMb.getActivity());
            final Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(this.fMb.getActivity());
            thread2GroupShareView.setData(shareFromPBMsgData);
            aVar.hx(1);
            aVar.aH(thread2GroupShareView);
            aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.fMb.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.b(a.this.fMb.getActivity(), thread2GroupShareView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(a.this.fMb.getActivity(), j, str, str2, str3, 0, thread2GroupShareView.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.apW() != null) {
                        Bundle apW = shareItem.apW();
                        TiebaStatic.log(new an("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).P("obj_type", apW.getInt("obj_type")).P("obj_param1", 3).bT("fid", apW.getString("fid")).bT("tid", apW.getString("tid")));
                    }
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.fMb.getActivity().getSystemService("input_method");
                    com.baidu.adp.lib.util.l.b(a.this.fMb.getActivity(), thread2GroupShareView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.dR(true);
            aVar.b(this.fMb.getPageContext()).agI();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                thread2GroupShareView.am(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private boolean d(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || aq.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.fMb.getActivity()).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.fLS == null) {
            this.fLS = new com.baidu.tieba.c.f(this.fMb.getPageContext(), (NavigationBarCoverTip) this.fMb.getView().findViewById(R.id.navigation_cover_tip));
        }
        if (this.fMb.bmo() != null && this.fMb.bmo().getForum() != null && this.fMb.bmo().getForum().isLike() == 1) {
            this.fLS.iS(true);
        } else {
            this.fLS.iS(false);
        }
        this.fLS.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.fLS != null) {
            this.fLS.onDestroy();
        }
    }
}
