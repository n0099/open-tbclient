package com.baidu.tieba.frs.utils;
/* loaded from: classes.dex */
public class s {
    public static int iI(int i) {
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

    public static int a(int i, com.baidu.tieba.tbadkCore.m mVar) {
        if (i == 4) {
            return 2;
        }
        switch (i) {
            case 2:
                if (mVar != null) {
                    mVar.setSortType(0);
                    mVar.setIsGood(0);
                    break;
                }
                break;
            case 3:
                if (mVar != null) {
                    mVar.setSortType(1);
                    mVar.setIsGood(0);
                    break;
                }
                break;
            case 5:
                if (mVar != null) {
                    mVar.setSortType(0);
                    mVar.setIsGood(1);
                    break;
                }
                break;
            case 6:
                if (mVar != null) {
                    mVar.setSortType(2);
                    mVar.setIsGood(0);
                    break;
                }
                break;
            case 7:
                if (mVar != null) {
                    mVar.setSortType(3);
                    mVar.setIsGood(0);
                    break;
                }
                break;
        }
        return 1;
    }
}
