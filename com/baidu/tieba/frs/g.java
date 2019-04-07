package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes3.dex */
public class g {
    private static UserData mUserData;

    public static UserData bce() {
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
                bVar.bt(4);
            } else {
                bVar.bu(4);
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

    public static boolean bcf() {
        UserData bce = bce();
        if (bce == null) {
            return false;
        }
        switch (bce.getIs_manager()) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean bcg() {
        UserData bce = bce();
        return bce != null && bce.getIs_manager() == 3;
    }
}
