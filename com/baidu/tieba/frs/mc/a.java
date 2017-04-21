package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends w {
    private l bPv;

    public a(FrsActivity frsActivity) {
        super(frsActivity);
        this.bPv = this.bVk.ZS();
    }

    private void adG() {
        if (this.bPv == null) {
            this.bPv = this.bVk.ZS();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        adG();
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
        bi pS;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.n aas = this.bVk.aas();
        switch (i) {
            case 11001:
                this.bVk.hS(0);
                return;
            case 11002:
                this.bPg.ev(true);
                return;
            case 11011:
                com.baidu.tieba.frs.f.t.a(this.bVk, this.bVk.getThreadId(), this.bVk.aRX, this.bVk.aad());
                return;
            case 11012:
                com.baidu.tieba.frs.f.t.b(this.bVk, this.bVk.getThreadId(), this.bVk.aRX, this.bVk.aad());
                return;
            case 11014:
                this.bPg.afc();
                return;
            case 11016:
                this.bOU.aaY();
                return;
            case 11033:
            default:
                return;
            case 11036:
                this.bPg.aav();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.bPv != null) {
                        this.bPv.a(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.bOU.abf().notifyDataSetChanged();
                if (this.bPg != null) {
                    this.bPg.abX();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.bVk.cj(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (pS = aas.pS(stringExtra)) != null) {
                    if (intExtra == 2) {
                        pS.bU(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        pS.sW();
                    } else if (intExtra == 0) {
                        aas.I(pS);
                        this.bOU.aaZ();
                        if (com.baidu.tieba.tbadkCore.c.bhj() != null) {
                            com.baidu.tieba.tbadkCore.c.bhj().V(this.bVk.getForumName(), false);
                        }
                    }
                    a(aas, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.f.t.b(this.bVk, aas);
                return;
            case 23003:
                if (intent != null && aas != null) {
                    com.baidu.tieba.frs.f.j.a(this.bVk, aas, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                com.baidu.tieba.frs.f.j.a(this.bVk, aas, intent);
                return;
            case 23013:
                com.baidu.tieba.frs.f.t.E(this.bVk);
                return;
            case 23019:
                com.baidu.tieba.frs.f.t.b(this.bVk, this.bVk.bOK);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.bVk.getForumId(), 0)) {
                        this.bPg.t(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.n nVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.v> dataList;
        if (nVar != null && intent != null && !TextUtils.isEmpty(str) && this.bPf != null && this.bPh != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.bPf.adX() && this.bPh.afg() != null && this.bPh.afg().abL() != null && this.bPh.afg().abL().fV()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.caM.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.d.a(dataList, str, cardHListViewData, intExtra)) {
                        nVar.ax(dataList);
                        this.bOU.a(dataList, nVar);
                        aN(str, this.bVk.getForumId());
                    }
                }
            }
        }
    }

    public static void aN(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            as asVar = new as("c11959");
            asVar.aa("tid", str);
            asVar.aa("fid", str2);
            asVar.s("obj_type", 1);
            TiebaStatic.log(asVar);
        }
    }
}
