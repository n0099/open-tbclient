package com.baidu.tieba.frs.d;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.acrossForum.u;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends s {
    private AcrossForumViewData bLK;
    private k byK;

    public void b(AcrossForumViewData acrossForumViewData) {
        this.bLK = acrossForumViewData;
    }

    public a(FrsActivity frsActivity) {
        super(frsActivity);
        this.byK = this.bFI.We();
    }

    private void aaJ() {
        if (this.byK == null) {
            this.byK = this.bFI.We();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        aaJ();
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
        bg pX;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.o WF = this.bFI.WF();
        switch (i) {
            case 11001:
                this.bFI.hb(0);
                return;
            case 11002:
                this.bys.eg(true);
                return;
            case 11011:
                com.baidu.tieba.frs.utils.t.a(this.bFI, this.bFI.getThreadId(), this.bFI.aMR, this.bFI.Wq());
                return;
            case 11012:
                com.baidu.tieba.frs.utils.t.b(this.bFI, this.bFI.getThreadId(), this.bFI.aMR, this.bFI.Wq());
                return;
            case 11014:
                this.bys.abZ();
                return;
            case 11016:
                this.byg.Xl();
                return;
            case 11033:
            default:
                return;
            case 11036:
                this.bys.WI();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.byK != null) {
                        this.byK.a(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.byg.Xu().notifyDataSetChanged();
                if (this.bys != null) {
                    this.bys.Yx();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.bFI.cl(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (pX = WF.pX(stringExtra)) != null) {
                    if (intExtra == 2) {
                        pX.bX(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        pX.sl();
                    } else if (intExtra == 0) {
                        WF.C(pX);
                        this.byg.Xn();
                        if (com.baidu.tieba.tbadkCore.c.bdT() != null) {
                            com.baidu.tieba.tbadkCore.c.bdT().U(this.bFI.getForumName(), false);
                        }
                    }
                    a(WF, intent, stringExtra);
                    return;
                }
                return;
            case 18004:
                com.baidu.tieba.frs.utils.t.b(this.bFI, WF);
                return;
            case 23003:
                if (intent != null && WF != null) {
                    if (com.baidu.tieba.frs.utils.j.from == 2) {
                        u.b(this.bFI, intent, this.bLK);
                        return;
                    } else {
                        com.baidu.tieba.frs.utils.j.a(this.bFI, WF, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                }
                return;
            case 23007:
                if (com.baidu.tieba.frs.utils.j.from == 2) {
                    u.a(this.bFI, intent, this.bLK);
                    return;
                } else {
                    com.baidu.tieba.frs.utils.j.a(this.bFI, WF, intent);
                    return;
                }
            case 23013:
                com.baidu.tieba.frs.utils.t.D(this.bFI);
                return;
            case 23019:
                com.baidu.tieba.frs.utils.t.b(this.bFI, this.bFI.bxX);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.h.b.g(this.bFI.getForumId(), 0)) {
                        this.bys.s(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
            case 24007:
                if (com.baidu.tieba.frs.utils.j.from == 2) {
                    com.baidu.tieba.frs.acrossForum.a.Yl().iD("vip3");
                    return;
                }
                return;
        }
    }

    private void a(com.baidu.tieba.tbadkCore.o oVar, Intent intent, String str) {
        ArrayList<v> dataList;
        if (oVar != null && intent != null && !TextUtils.isEmpty(str) && this.byr != null && this.byt != null && this.byr.aaZ() && this.byt.acc() != null && this.byt.acc().Yf() != null && this.byt.acc().Yf().eX()) {
            Serializable serializableExtra = intent.getSerializableExtra(PbActivityConfig.KEY_INTENT_GUESS_LIKE_DATA);
            if ((serializableExtra instanceof CardHListViewData) && (dataList = this.bMu.getDataList()) != null) {
                CardHListViewData cardHListViewData = (CardHListViewData) serializableExtra;
                cardHListViewData.threadId = str;
                if (com.baidu.tieba.frs.f.e.a(dataList, str, cardHListViewData)) {
                    oVar.at(dataList);
                    this.byg.a(dataList, oVar);
                    aH(str, this.bFI.getForumId());
                }
            }
        }
    }

    public static void aH(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            at atVar = new at("c11959");
            atVar.ab("tid", str);
            atVar.ab("fid", str2);
            atVar.s("obj_type", 1);
            TiebaStatic.log(atVar);
        }
    }
}
