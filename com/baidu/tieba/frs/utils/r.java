package com.baidu.tieba.frs.utils;

import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes.dex */
public class r {
    public static int iF(int i) {
        int i2 = 0;
        if (i == 4) {
            return 2;
        }
        switch (i) {
            case 2:
            case 5:
                break;
            case 3:
                i2 = 1;
                break;
            case 4:
            default:
                i2 = -1;
                break;
            case 6:
                i2 = 2;
                break;
            case 7:
                i2 = 3;
                break;
        }
        return i2;
    }

    public static int a(int i, FrsRequestData frsRequestData) {
        if (i == 4) {
            return 2;
        }
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
