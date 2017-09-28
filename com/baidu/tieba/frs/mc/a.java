package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
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
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends h {
    private com.baidu.tieba.d.b cEG;
    private d cqN;

    public a(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cqN = this.cxi.agN();
    }

    private void akP() {
        if (this.cqN == null) {
            this.cqN = this.cxi.agN();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        akP();
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
        bh rH;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.i ahk = this.cxi.ahk();
        switch (i) {
            case 11001:
                this.cxi.ja(0);
                return;
            case 11002:
                this.cqD.fh(true);
                return;
            case 11011:
                com.baidu.tieba.frs.g.i.a(this.cxi, this.cxi.getThreadId(), this.cxi.bit, this.cxi.agW());
                return;
            case 11012:
                com.baidu.tieba.frs.g.i.b(this.cxi, this.cxi.getThreadId(), this.cxi.bit, this.cxi.agW());
                return;
            case 11014:
                this.cqD.amc();
                return;
            case 11016:
                this.cqt.ahC();
                return;
            case 11033:
            case 24007:
            default:
                return;
            case 11036:
                this.cqD.amb();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.cqN != null) {
                        this.cqN.b(postWriteCallBackData);
                    }
                    a(postWriteCallBackData);
                    return;
                }
                return;
            case 18003:
                this.cqt.ahK().notifyDataSetChanged();
                if (this.cqD != null) {
                    this.cqD.aiH();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.cxi.cm(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (rH = ahk.rH(stringExtra)) != null) {
                    if (intExtra == 2) {
                        rH.bV(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        rH.sd();
                    }
                    a(ahk, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.g.i.a(this.cxi.getPageContext(), ahk);
                return;
            case 23003:
                if (intent != null && ahk != null) {
                    com.baidu.tieba.frs.g.e.a(this.cxi, ahk, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                L(intent);
                return;
            case 23013:
                com.baidu.tieba.frs.g.i.B(this.cxi);
                return;
            case 23019:
                com.baidu.tieba.frs.g.i.a(this.cxi, this.cxi.cql);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.cxi.getForumId(), 0)) {
                        this.cqD.y(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.i iVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.f> dataList;
        if (iVar != null && intent != null && !TextUtils.isEmpty(str) && this.cqC != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.cqC.alh()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.cFD.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.c.a(dataList, str, cardHListViewData, intExtra)) {
                        iVar.az(dataList);
                        this.cqt.a(dataList, iVar);
                        aY(str, this.cxi.getForumId());
                    }
                }
            }
        }
    }

    public static void aY(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ak akVar = new ak("c11959");
            akVar.ad("tid", str);
            akVar.ad("fid", str2);
            akVar.r("obj_type", 1);
            TiebaStatic.log(akVar);
        }
    }

    private ShareFromPBMsgData akQ() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem == null) {
            return null;
        }
        String uri = shareItem.atH == null ? "http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg" : shareItem.atH.toString();
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        shareFromPBMsgData.setTitle(shareItem.title);
        shareFromPBMsgData.setContent(shareItem.atK);
        shareFromPBMsgData.setImageUrl(uri);
        shareFromPBMsgData.setForumName(shareItem.atF);
        shareFromPBMsgData.setThreadId(shareItem.Xf);
        return shareFromPBMsgData;
    }

    private void L(Intent intent) {
        a(akQ(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private void a(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        if (shareFromPBMsgData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cxi.getActivity());
            final com.baidu.tieba.view.j jVar = new com.baidu.tieba.view.j(this.cxi.getActivity());
            jVar.setData(shareFromPBMsgData);
            aVar.cf(1);
            aVar.v(jVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.frs.mc.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cxi.getActivity().getSystemService("input_method");
                    l.a(a.this.cxi.getActivity(), jVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(a.this.cxi.getActivity(), j, str, str2, 0, jVar.getLeaveMsg(), shareFromPBMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                    com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.Au() != null) {
                        Bundle Au = shareItem.Au();
                        TiebaStatic.log(new ak("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1).r("obj_type", Au.getInt("obj_type")).r("obj_param1", 3).ad("fid", Au.getString("fid")).ad("tid", Au.getString("tid")));
                    }
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.frs.mc.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    InputMethodManager inputMethodManager = (InputMethodManager) a.this.cxi.getActivity().getSystemService("input_method");
                    l.a(a.this.cxi.getActivity(), jVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(this.cxi.getPageContext()).ti();
            if (!k.isEmpty(shareFromPBMsgData.getImageUrl())) {
                jVar.I(shareFromPBMsgData.getImageUrl(), false);
            }
        }
    }

    private void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.cEG == null) {
            this.cEG = new com.baidu.tieba.d.b(this.cxi.getPageContext(), (ViewStub) this.cxi.getView().findViewById(d.h.write_share_viewStub));
        }
        this.cEG.a(postWriteCallBackData);
    }

    public void onDestroy() {
        if (this.cEG != null) {
            this.cEG.onDestroy();
        }
    }
}
