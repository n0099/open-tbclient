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
    private com.baidu.tieba.d.b cOb;
    private d cyo;

    public a(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cyo = this.cFg.ajd();
    }

    private void anK() {
        if (this.cyo == null) {
            this.cyo = this.cFg.ajd();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        anK();
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
        bh su;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.j ajB = this.cFg.ajB();
        switch (i) {
            case 11001:
                this.cFg.jo(0);
                return;
            case 11002:
                this.cye.fl(true);
                return;
            case 11011:
                com.baidu.tieba.frs.f.i.a(this.cFg, this.cFg.getThreadId(), this.cFg.biZ, this.cFg.ajm());
                return;
            case 11012:
                com.baidu.tieba.frs.f.i.b(this.cFg, this.cFg.getThreadId(), this.cFg.biZ, this.cFg.ajm());
                return;
            case 11014:
                this.cye.aoX();
                return;
            case 11016:
                this.cxU.ajT();
                return;
            case 11033:
            case 24007:
            default:
                return;
            case 11036:
                this.cye.aoW();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.cyo != null) {
                        this.cyo.c(postWriteCallBackData);
                    }
                    a(postWriteCallBackData);
                    return;
                }
                return;
            case 18003:
                this.cxU.akb().notifyDataSetChanged();
                if (this.cye != null) {
                    this.cye.alc();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.cFg.cm(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (su = ajB.su(stringExtra)) != null) {
                    if (intExtra == 2) {
                        su.bT(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        su.sc();
                    }
                    a(ajB, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.f.i.a(this.cFg.getPageContext(), ajB);
                return;
            case 23003:
                if (intent != null && ajB != null) {
                    com.baidu.tieba.frs.f.e.a(this.cFg, ajB, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                K(intent);
                return;
            case 23013:
                com.baidu.tieba.frs.f.i.B(this.cFg);
                return;
            case 23019:
                com.baidu.tieba.frs.f.i.a(this.cFg, this.cFg.cxM);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.cFg.getForumId(), 0)) {
                        this.cye.B(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.j jVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.f> dataList;
        if (jVar != null && intent != null && !TextUtils.isEmpty(str) && this.cyd != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.cyd.aoc()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.cOY.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        jVar.az(dataList);
                        this.cxU.a(dataList, jVar);
                        aT(str, this.cFg.getForumId());
                    }
                }
            }
        }
    }

    public static void aT(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ak akVar = new ak("c11959");
            akVar.ac("tid", str);
            akVar.ac(ImageViewerConfig.FORUM_ID, str2);
            akVar.r("obj_type", 1);
            TiebaStatic.log(akVar);
        }
    }

    private ShareFromPBMsgData anL() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.atZ == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.atZ.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.auc);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.atX);
        shareFromPBMsgData.setThreadId(shareItem.Xl);
        return shareFromPBMsgData;
    }

    private void K(Intent intent) {
        a(anL(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cFg.getActivity());
            final k kVar = new k(this.cFg.getActivity());
            kVar.setData(shareFromPBMsgData);
            aVar.ce(1);
            aVar.v(kVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cFg.getActivity().getSystemService("input_method");
                    l.a(a.this.cFg.getActivity(), kVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.cFg.getActivity(), j, str, str2, 0, kVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.AJ() != null) {
                        Bundle AJ = shareItem.AJ();
                        TiebaStatic.log(new ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", AJ.getInt("obj_type")).r("obj_param1", 3).ac(ImageViewerConfig.FORUM_ID, AJ.getString(ImageViewerConfig.FORUM_ID)).ac("tid", AJ.getString("tid")));
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cFg.getActivity().getSystemService("input_method");
                    l.a(a.this.cFg.getActivity(), kVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ap(true);
            aVar.b(this.cFg.getPageContext()).th();
            if (!com.baidu.adp.lib.util.k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                kVar.G(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.cOb == null) {
            this.cOb = new com.baidu.tieba.d.b(this.cFg.getPageContext(), (ViewStub) this.cFg.getView().findViewById(d.g.write_share_viewStub));
        }
        this.cOb.a(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.cOb != null) {
            this.cOb.onDestroy();
        }
    }
}
