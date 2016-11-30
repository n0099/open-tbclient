package com.baidu.tieba.frs.e;

import android.content.Intent;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.utils.u;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class a extends s {
    private k bSB;
    private AcrossForumViewData cgb;

    public void b(AcrossForumViewData acrossForumViewData) {
        this.cgb = acrossForumViewData;
    }

    public a(FrsActivity frsActivity) {
        super(frsActivity);
        this.bSB = this.bZY.abP();
    }

    private void agn() {
        if (this.bSB == null) {
            this.bSB = this.bZY.abP();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        agn();
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
        bk rt;
        PostWriteCallBackData postWriteCallBackData;
        com.baidu.tieba.tbadkCore.p acr = this.bZY.acr();
        switch (i) {
            case 11001:
                this.bZY.hR(0);
                return;
            case 11002:
                this.bSi.ew(true);
                return;
            case 11011:
                u.a(this.bZY, this.bZY.getThreadId(), this.bZY.aNA, this.bZY.acc());
                return;
            case 11012:
                u.b(this.bZY, this.bZY.getThreadId(), this.bZY.aNA, this.bZY.acc());
                return;
            case 11014:
                this.bSi.ahC();
                return;
            case 11016:
                this.bRW.acV();
                return;
            case 11033:
            default:
                return;
            case 11036:
                this.bSi.acu();
                return;
            case 13003:
                if (intent != null) {
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception e) {
                        postWriteCallBackData = null;
                    }
                    if (this.bSB != null) {
                        this.bSB.a(postWriteCallBackData);
                        return;
                    }
                    return;
                }
                return;
            case 18003:
                this.bRW.ade().notifyDataSetChanged();
                if (this.bSi != null) {
                    this.bSi.aee();
                }
                int intExtra = intent.getIntExtra("type", -1);
                if (intExtra == 4) {
                    this.bZY.cj(6);
                    return;
                }
                String stringExtra = intent.getStringExtra("tid");
                if (stringExtra != null && (rt = acr.rt(stringExtra)) != null) {
                    if (intExtra == 2) {
                        rt.bW(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                        rt.sw();
                        return;
                    } else if (intExtra == 0) {
                        acr.x(rt);
                        this.bRW.acX();
                        if (com.baidu.tieba.tbadkCore.d.bkd() != null) {
                            com.baidu.tieba.tbadkCore.d.bkd().R(this.bZY.getForumName(), false);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 18004:
                u.b(this.bZY, acr);
                return;
            case 23003:
                if (intent != null && acr != null) {
                    if (com.baidu.tieba.frs.utils.j.from == 2) {
                        com.baidu.tieba.frs.acrossForum.u.b(this.bZY, intent, this.cgb);
                        return;
                    } else {
                        com.baidu.tieba.frs.utils.j.a(this.bZY, acr, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                }
                return;
            case 23007:
                if (com.baidu.tieba.frs.utils.j.from == 2) {
                    com.baidu.tieba.frs.acrossForum.u.a(this.bZY, intent, this.cgb);
                    return;
                } else {
                    com.baidu.tieba.frs.utils.j.a(this.bZY, acr, intent);
                    return;
                }
            case 23013:
                u.E(this.bZY);
                return;
            case 23019:
                u.b(this.bZY, this.bZY.bRM);
                return;
            case 24002:
                if (intent != null) {
                    int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                    int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                    int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                    int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                    if (intExtra2 == com.baidu.adp.lib.h.b.g(this.bZY.getForumId(), 0)) {
                        this.bSi.s(intExtra3, intExtra4, intExtra5);
                        return;
                    }
                    return;
                }
                return;
            case 24007:
                if (com.baidu.tieba.frs.utils.j.from == 2) {
                    com.baidu.tieba.frs.acrossForum.a.adR().jY("vip3");
                    return;
                }
                return;
        }
    }
}
