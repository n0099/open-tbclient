package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends u {
    private k bNp;

    public a(FrsActivity frsActivity) {
        super(frsActivity);
        this.bNp = this.bTf.Yu();
    }

    private void acM() {
        if (this.bNp == null) {
            this.bNp = this.bTf.Yu();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        acM();
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
        bj pA;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.n YV = this.bTf.YV();
        switch (i) {
            case 11001:
                this.bTf.hJ(0);
                return;
            case 11002:
                this.bMZ.el(true);
                return;
            case 11011:
                com.baidu.tieba.frs.utils.t.a(this.bTf, this.bTf.getThreadId(), this.bTf.aRF, this.bTf.YG());
                return;
            case 11012:
                com.baidu.tieba.frs.utils.t.b(this.bTf, this.bTf.getThreadId(), this.bTf.aRF, this.bTf.YG());
                return;
            case 11014:
                this.bMZ.aeg();
                return;
            case 11016:
                this.bMN.Zz();
                return;
            case 11033:
            default:
                return;
            case 11036:
                this.bMZ.YY();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.bNp != null) {
                        this.bNp.a(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.bMN.ZG().notifyDataSetChanged();
                if (this.bMZ != null) {
                    this.bMZ.aay();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.bTf.cg(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (pA = YV.pA(stringExtra)) != null) {
                    if (intExtra == 2) {
                        pA.bR(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        pA.sy();
                    } else if (intExtra == 0) {
                        YV.L(pA);
                        this.bMN.ZA();
                        if (com.baidu.tieba.tbadkCore.c.bft() != null) {
                            com.baidu.tieba.tbadkCore.c.bft().V(this.bTf.getForumName(), false);
                        }
                    }
                    a(YV, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.utils.t.b(this.bTf, YV);
                return;
            case 23003:
                if (intent != null && YV != null) {
                    com.baidu.tieba.frs.utils.j.a(this.bTf, YV, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                com.baidu.tieba.frs.utils.j.a(this.bTf, YV, intent);
                return;
            case 23013:
                com.baidu.tieba.frs.utils.t.E(this.bTf);
                return;
            case 23019:
                com.baidu.tieba.frs.utils.t.b(this.bTf, this.bTf.bMD);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.bTf.getForumId(), 0)) {
                        this.bMZ.t(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.n nVar, Intent intent, String str) {
        ArrayList<com.baidu.adp.widget.ListView.v> dataList;
        if (nVar != null && intent != null && !TextUtils.isEmpty(str) && this.bMY != null && this.bNa != null) {
            int intExtra = intent.getIntExtra(PbActivityConfig.KEY_SMART_FRS_POSITION, -1);
            if (this.bMY.adc() && this.bNa.aek() != null && this.bNa.aek().aam() != null && this.bNa.aek().aam().fP()) {
                Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
                if ((serializableExtra instanceof CardHListViewData) && (dataList = this.bZU.getDataList()) != null) {
                    CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                    cardHListViewData.threadId = str;
                    if (com.baidu.tieba.frs.smartsort.d.a(dataList, str, cardHListViewData, intExtra)) {
                        nVar.ax(dataList);
                        this.bMN.a(dataList, nVar);
                        aK(str, this.bTf.getForumId());
                    }
                }
            }
        }
    }

    public static void aK(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            as asVar = new as("c11959");
            asVar.Z("tid", str);
            asVar.Z("fid", str2);
            asVar.s("obj_type", 1);
            TiebaStatic.log(asVar);
        }
    }
}
