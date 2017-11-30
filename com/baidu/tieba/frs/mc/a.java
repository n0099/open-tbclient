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
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends h {
    private d cHt;
    private com.baidu.tieba.d.d cXq;

    public a(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cHt = this.cOm.akX();
    }

    private void apE() {
        if (this.cHt == null) {
            this.cHt = this.cOm.akX();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        apE();
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
        bd sQ;
        PostWriteCallBackData postWriteCallBackData;
        k alv = this.cOm.alv();
        switch (i) {
            case 11001:
                this.cOm.jM(0);
                return;
            case 11002:
                this.cHj.fC(true);
                return;
            case 11011:
                com.baidu.tieba.frs.f.h.a(this.cOm, this.cOm.getThreadId(), this.cOm.bkp, this.cOm.alg());
                return;
            case 11012:
                com.baidu.tieba.frs.f.h.b(this.cOm, this.cOm.getThreadId(), this.cOm.bkp, this.cOm.alg());
                return;
            case 11014:
                this.cHj.aqQ();
                return;
            case 11016:
                this.cHa.alN();
                return;
            case 11033:
            case 24007:
            default:
                return;
            case 11036:
                this.cHj.aqP();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.cHt != null) {
                        this.cHt.d(postWriteCallBackData);
                    }
                    b(postWriteCallBackData);
                    return;
                }
                return;
            case 18003:
                this.cHa.alV().notifyDataSetChanged();
                if (this.cHj != null) {
                    this.cHj.amY();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.cOm.cn(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (sQ = alv.sQ(stringExtra)) != null) {
                    if (intExtra == 2) {
                        sQ.bT(intent.getIntExtra("good_data", 0));
                        sQ.sf();
                    }
                    a(alv, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.f.h.a(this.cOm.getPageContext(), alv);
                return;
            case 23003:
                if (intent != null && alv != null) {
                    com.baidu.tieba.frs.f.d.a(this.cOm, alv, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                K(intent);
                return;
            case 23013:
                com.baidu.tieba.frs.f.h.B(this.cOm);
                return;
            case 23019:
                com.baidu.tieba.frs.f.h.a(this.cOm, this.cOm.cGS);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.cOm.getForumId(), 0)) {
                        this.cHj.C(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(k kVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.f> dataList;
        if (kVar != null && intent != null && !TextUtils.isEmpty(str) && this.cHi != null) {
            int intExtra = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
            if (this.cHi.apW()) {
                Serializable serializableExtra = intent.getSerializableExtra("guess_like_data");
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.cYn.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        kVar.az(dataList);
                        this.cHa.a(dataList, kVar);
                        aW(str, this.cOm.getForumId());
                    }
                }
            }
        }
    }

    public static void aW(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ak akVar = new ak("c11959");
            akVar.ac("tid", str);
            akVar.ac(ImageViewerConfig.FORUM_ID, str2);
            akVar.r("obj_type", 1);
            TiebaStatic.log(akVar);
        }
    }

    private ShareFromPBMsgData apF() {
        com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.auz == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.auz.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.auC);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.aux);
        shareFromPBMsgData.setThreadId(shareItem.tid);
        return shareFromPBMsgData;
    }

    private void K(Intent intent) {
        a(apF(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cOm.getActivity());
            final com.baidu.tieba.view.k kVar = new com.baidu.tieba.view.k(this.cOm.getActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.cf(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cOm.getActivity().getSystemService("input_method");
                    l.a(a.this.cOm.getActivity(), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.cOm.getActivity(), j, str, str2, 0, kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.AT() != null) {
                        Bundle AT = shareItem.AT();
                        TiebaStatic.log(new ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", AT.getInt("obj_type")).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, AT.getString(ImageViewerConfig.FORUM_ID)).ac("tid", AT.getString("tid")));
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cOm.getActivity().getSystemService("input_method");
                    l.a(a.this.cOm.getActivity(), kVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ap(true);
            aVar.b(this.cOm.getPageContext()).tk();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                kVar.H(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private void b(PostWriteCallBackData postWriteCallBackData) {
        if (this.cXq == null) {
            this.cXq = new com.baidu.tieba.d.d(this.cOm.getPageContext(), (ViewStub) this.cOm.getView().findViewById(d.g.write_share_viewStub));
        }
        if (this.cOm.alv() != null && this.cOm.alv().aRf() != null && this.cOm.alv().aRf().isLike() == 1) {
            this.cXq.eg(true);
        } else {
            this.cXq.eg(false);
        }
        this.cXq.b(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.cXq != null) {
            this.cXq.onDestroy();
        }
    }
}
