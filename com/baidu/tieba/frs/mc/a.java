package com.baidu.tieba.frs.mc;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends r {
    private j bGh;

    public a(FrsActivity frsActivity) {
        super(frsActivity);
        this.bGh = this.bLZ.Xv();
    }

    private void abP() {
        if (this.bGh == null) {
            this.bGh = this.bLZ.Xv();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        abP();
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
        bh qr;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.n XW = this.bLZ.XW();
        switch (i) {
            case 11001:
                this.bLZ.hN(0);
                return;
            case 11002:
                this.bFR.el(true);
                return;
            case 11011:
                com.baidu.tieba.frs.utils.t.a(this.bLZ, this.bLZ.getThreadId(), this.bLZ.aLS, this.bLZ.XH());
                return;
            case 11012:
                com.baidu.tieba.frs.utils.t.b(this.bLZ, this.bLZ.getThreadId(), this.bLZ.aLS, this.bLZ.XH());
                return;
            case 11014:
                this.bFR.adg();
                return;
            case 11016:
                this.bFF.YA();
                return;
            case 11033:
            default:
                return;
            case 11036:
                this.bFR.XZ();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.bGh != null) {
                        this.bGh.a(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.bFF.YH().notifyDataSetChanged();
                if (this.bFR != null) {
                    this.bFR.ZB();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.bLZ.ck(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (qr = XW.qr(stringExtra)) != null) {
                    if (intExtra == 2) {
                        qr.bW(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        qr.sd();
                    } else if (intExtra == 0) {
                        XW.K(qr);
                        this.bFF.YB();
                        if (com.baidu.tieba.tbadkCore.c.bfG() != null) {
                            com.baidu.tieba.tbadkCore.c.bfG().U(this.bLZ.getForumName(), false);
                        }
                    }
                    a(XW, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.utils.t.b(this.bLZ, XW);
                return;
            case 23003:
                if (intent != null && XW != null) {
                    com.baidu.tieba.frs.utils.j.a(this.bLZ, XW, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                    return;
                }
                return;
            case 23007:
                com.baidu.tieba.frs.utils.j.a(this.bLZ, XW, intent);
                return;
            case 23013:
                com.baidu.tieba.frs.utils.t.E(this.bLZ);
                return;
            case 23019:
                com.baidu.tieba.frs.utils.t.b(this.bLZ, this.bLZ.bFv);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.g.b.g(this.bLZ.getForumId(), 0)) {
                        this.bFR.t(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.n nVar, Intent intent, String str) {
        ArrayList<v> dataList;
        if (nVar != null && intent != null && !TextUtils.isEmpty(str) && this.bFQ != null && this.bFS != null && this.bFQ.acf() && this.bFS.adk() != null && this.bFS.adk().Zn() != null && this.bFS.adk().Zn().eV()) {
            Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
            if ((serializableExtra instanceof CardHListViewData) && (dataList = this.bSI.getDataList()) != null) {
                CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                cardHListViewData.threadId = str;
                if (com.baidu.tieba.frs.smartsort.d.a(dataList, str, cardHListViewData)) {
                    nVar.ax(dataList);
                    this.bFF.a(dataList, nVar);
                    aM(str, this.bLZ.getForumId());
                }
            }
        }
    }

    public static void aM(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ar arVar = new ar("c11959");
            arVar.ab("tid", str);
            arVar.ab("fid", str2);
            arVar.s("obj_type", 1);
            TiebaStatic.log(arVar);
        }
    }
}
