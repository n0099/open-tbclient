package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes3.dex */
public class g {
    private static UserData mUserData;

    public static UserData bcg() {
        return mUserData;
    }

    private static UserData a(FrsViewData frsViewData) {
        mUserData = frsViewData != null ? frsViewData.getUserData() : null;
        return mUserData;
    }

    public static void a(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, FrsViewData frsViewData) {
        if (threadCommentAndPraiseInfoLayout != null) {
            if (frsViewData != null && frsViewData.frsCurrentTabId != 303 && b(a(frsViewData))) {
                threadCommentAndPraiseInfoLayout.setManageVisible(true);
            } else {
                threadCommentAndPraiseInfoLayout.setManageVisible(false);
            }
        }
    }

    public static void a(com.baidu.card.b bVar, FrsViewData frsViewData) {
        if (bVar != null) {
            if (frsViewData != null && frsViewData.frsCurrentTabId != 303 && b(a(frsViewData))) {
                bVar.bu(4);
            } else {
                bVar.bv(4);
            }
        }
    }

    public static boolean b(UserData userData) {
        if (userData == null) {
            return false;
        }
        switch (userData.getIs_manager()) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    public static boolean bch() {
        UserData bcg = bcg();
        if (bcg == null) {
            return false;
        }
        switch (bcg.getIs_manager()) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean bci() {
        UserData bcg = bcg();
        return bcg != null && bcg.getIs_manager() == 3;
    }
}
