package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.k;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends h {
    private com.baidu.tieba.d.b cNH;
    private d cxV;

    public a(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cxV = this.cEN.aiP();
    }

    private void anv() {
        if (this.cxV == null) {
            this.cxV = this.cEN.aiP();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        anv();
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
        bh so;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.j ajn = this.cEN.ajn();
        switch (i) {
            case 11001:
                this.cEN.jp(0);
                return;
            case 11002:
                this.cxL.ff(true);
                return;
            case 11011:
                com.baidu.tieba.frs.f.i.a(this.cEN, this.cEN.getThreadId(), this.cEN.biQ, this.cEN.aiY());
                return;
            case 11012:
                com.baidu.tieba.frs.f.i.b(this.cEN, this.cEN.getThreadId(), this.cEN.biQ, this.cEN.aiY());
                return;
            case 11014:
                this.cxL.aoI();
                return;
            case 11016:
                this.cxB.ajF();
                return;
            case 11033:
            case 24007:
            default:
                return;
            case 11036:
                this.cxL.aoH();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.cxV != null) {
                        this.cxV.c(postWriteCallBackData);
                    }
                    a(postWriteCallBackData);
                    return;
                }
                return;
            case 18003:
                this.cxB.ajN().notifyDataSetChanged();
                if (this.cxL != null) {
                    this.cxL.akO();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.cEN.cm(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (so = ajn.so(stringExtra)) != null) {
                    if (intExtra == 2) {
                        so.bT(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        so.sc();
                    }
                    a(ajn, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.f.i.a(this.cEN.getPageContext(), ajn);
                return;
            case 23003:
                if (intent != null && ajn != null) {
                    com.baidu.tieba.frs.f.e.a(this.cEN, ajn, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                K(intent);
                return;
            case 23013:
                com.baidu.tieba.frs.f.i.B(this.cEN);
                return;
            case 23019:
                com.baidu.tieba.frs.f.i.a(this.cEN, this.cEN.cxt);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.cEN.getForumId(), 0)) {
                        this.cxL.B(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.j jVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.f> dataList;
        if (jVar != null && intent != null && !TextUtils.isEmpty(str) && this.cxK != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.cxK.anN()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.cOE.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        jVar.az(dataList);
                        this.cxB.a(dataList, jVar);
                        aS(str, this.cEN.getForumId());
                    }
                }
            }
        }
    }

    public static void aS(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ak akVar = new ak("c11959");
            akVar.ac("tid", str);
            akVar.ac(ImageViewerConfig.FORUM_ID, str2);
            akVar.r("obj_type", 1);
            TiebaStatic.log(akVar);
        }
    }

    private ShareFromPBMsgData anw() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.atR == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.atR.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.atU);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.atP);
        shareFromPBMsgData.setThreadId(shareItem.Xl);
        return shareFromPBMsgData;
    }

    private void K(Intent intent) {
        a(anw(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cEN.getActivity());
            final k kVar = new k(this.cEN.getActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cEN.getActivity().getSystemService("input_method");
                    l.a(a.this.cEN.getActivity(), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.cEN.getActivity(), j, str, str2, 0, kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Ax() != null) {
                        Bundle Ax = shareItem.Ax();
                        TiebaStatic.log(new ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", Ax.getInt("obj_type")).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, Ax.getString(ImageViewerConfig.FORUM_ID)).ac("tid", Ax.getString("tid")));
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cEN.getActivity().getSystemService("input_method");
                    l.a(a.this.cEN.getActivity(), kVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ap(true);
            aVar.b(this.cEN.getPageContext()).th();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                kVar.G(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.cNH == null) {
            this.cNH = new com.baidu.tieba.d.b(this.cEN.getPageContext(), (ViewStub) this.cEN.getView().findViewById(d.g.write_share_viewStub));
        }
        this.cNH.a(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.cNH != null) {
            this.cNH.onDestroy();
        }
    }
}
