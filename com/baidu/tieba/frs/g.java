package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes3.dex */
public class g {
    private static UserData mUserData;

    public static UserData bjz() {
        return mUserData;
    }

    private static UserData a(FrsViewData frsViewData) {
        mUserData = frsViewData != null ? frsViewData.getUserData() : null;
        return mUserData;
    }

    public static void a(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, FrsViewData frsViewData) {
        if (threadCommentAndPraiseInfoLayout != null) {
            if (frsViewData != null && frsViewData.frsCurrentTabId != 303 && a(a(frsViewData))) {
                threadCommentAndPraiseInfoLayout.setManageVisible(true);
            } else {
                threadCommentAndPraiseInfoLayout.setManageVisible(false);
            }
        }
    }

    public static void a(com.baidu.card.b bVar, FrsViewData frsViewData) {
        if (bVar != null) {
            if (frsViewData != null && frsViewData.frsCurrentTabId != 303 && a(a(frsViewData))) {
                bVar.aB(4);
            } else {
                bVar.aC(4);
            }
        }
    }

    public static boolean a(UserData userData) {
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

    public static boolean bjA() {
        UserData bjz = bjz();
        if (bjz == null) {
            return false;
        }
        switch (bjz.getIs_manager()) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean bjB() {
        UserData bjz = bjz();
        return bjz != null && bjz.getIs_manager() == 3;
    }
}
