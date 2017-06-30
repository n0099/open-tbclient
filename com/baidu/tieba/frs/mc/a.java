package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends z {
    private l ccE;

    public a(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.ccE = this.cbE.adN();
    }

    private void agG() {
        if (this.ccE == null) {
            this.ccE = this.cbE.adN();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        agG();
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
        bm rd;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.n aek = this.cbE.aek();
        switch (i) {
            case 11001:
                this.cbE.it(0);
                return;
            case 11002:
                this.cct.eQ(true);
                return;
            case 11011:
                com.baidu.tieba.frs.e.p.a(this.cbE, this.cbE.getThreadId(), this.cbE.bdI, this.cbE.adW());
                return;
            case 11012:
                com.baidu.tieba.frs.e.p.b(this.cbE, this.cbE.getThreadId(), this.cbE.bdI, this.cbE.adW());
                return;
            case 11014:
                this.cct.ahT();
                return;
            case 11016:
                this.ccj.aeA();
                return;
            case 11033:
            default:
                return;
            case 11036:
                this.cct.ahS();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra(WriteActivityConfig.POST_WRITE_CALLBACK_DATA);
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.ccE != null) {
                        this.ccE.a(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.ccj.aeI().notifyDataSetChanged();
                if (this.cct != null) {
                    this.cct.afd();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.cbE.ci(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (rd = aek.rd(stringExtra)) != null) {
                    if (intExtra == 2) {
                        rd.bT(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        rd.rZ();
                    }
                    a(aek, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.e.p.a(this.cbE.getPageContext(), aek);
                return;
            case 23003:
                if (intent != null && aek != null) {
                    com.baidu.tieba.frs.e.h.a(this.cbE, aek, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                com.baidu.tieba.frs.e.h.a(this.cbE, aek, intent);
                return;
            case 23013:
                com.baidu.tieba.frs.e.p.y(this.cbE);
                return;
            case 23019:
                com.baidu.tieba.frs.e.p.a(this.cbE, this.cbE.cca);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.cbE.getForumId(), 0)) {
                        this.cct.u(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.n nVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.v> dataList;
        if (nVar != null && intent != null && !TextUtils.isEmpty(str) && this.ccs != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.ccs.agY()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.cnf.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.d.a(dataList, str, cardHListViewData, intExtra)) {
                        nVar.az(dataList);
                        this.ccj.a(dataList, nVar);
                        aS(str, this.cbE.getForumId());
                    }
                }
            }
        }
    }

    public static void aS(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            au auVar = new au("c11959");
            auVar.Z("tid", str);
            auVar.Z("fid", str2);
            auVar.r("obj_type", 1);
            TiebaStatic.log(auVar);
        }
    }
}
