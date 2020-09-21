package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes20.dex */
public class j {
    private static UserData mUserData;

    public static UserData coP() {
        return mUserData;
    }

    private static UserData a(FrsViewData frsViewData) {
        mUserData = frsViewData != null ? frsViewData.getUserData() : null;
        return mUserData;
    }

    public static void a(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, FrsViewData frsViewData) {
        if (threadCommentAndPraiseInfoLayout != null) {
            if (frsViewData != null && a(a(frsViewData))) {
                threadCommentAndPraiseInfoLayout.setManageVisible(true);
            } else {
                threadCommentAndPraiseInfoLayout.setManageVisible(false);
            }
        }
    }

    public static void a(com.baidu.card.b bVar, FrsViewData frsViewData) {
        if (bVar != null) {
            if (frsViewData != null && a(a(frsViewData))) {
                bVar.bo(4);
            } else {
                bVar.bp(4);
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

    public static boolean coQ() {
        UserData coP = coP();
        if (coP == null) {
            return false;
        }
        switch (coP.getIs_manager()) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean coR() {
        UserData coP = coP();
        return coP != null && coP.getIs_manager() == 3;
    }
}
