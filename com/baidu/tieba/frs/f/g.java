package com.baidu.tieba.frs.f;

import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes.dex */
public class g {
    public static int jt(int i) {
        switch (i) {
            case 2:
            case 5:
                return 0;
            case 3:
                return 1;
            case 4:
            default:
                return -1;
            case 6:
                return 2;
            case 7:
                return 3;
        }
    }

    public static int a(int i, FrsRequestData frsRequestData) {
        switch (i) {
            case 2:
                if (frsRequestData != null) {
                    frsRequestData.setSortType(0);
                    frsRequestData.setIsGood(0);
                    break;
                }
                break;
            case 3:
                if (frsRequestData != null) {
                    frsRequestData.setSortType(1);
                    frsRequestData.setIsGood(0);
                    break;
                }
                break;
            case 5:
                if (frsRequestData != null) {
                    frsRequestData.setSortType(0);
                    frsRequestData.setIsGood(1);
                    break;
                }
                break;
            case 6:
                if (frsRequestData != null) {
                    frsRequestData.setSortType(2);
                    frsRequestData.setIsGood(0);
                    break;
                }
                break;
            case 7:
                if (frsRequestData != null) {
                    frsRequestData.setSortType(3);
                    frsRequestData.setIsGood(0);
                    break;
                }
                break;
        }
        return 1;
    }
}
