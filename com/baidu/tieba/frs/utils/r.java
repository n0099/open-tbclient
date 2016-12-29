package com.baidu.tieba.frs.utils;
/* loaded from: classes.dex */
public class r {
    public static int hS(int i) {
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

    public static int a(int i, com.baidu.tieba.tbadkCore.l lVar) {
        if (i == 4) {
            return 2;
        }
        switch (i) {
            case 2:
                if (lVar != null) {
                    lVar.setSortType(0);
                    lVar.setIsGood(0);
                    break;
                }
                break;
            case 3:
                if (lVar != null) {
                    lVar.setSortType(1);
                    lVar.setIsGood(0);
                    break;
                }
                break;
            case 5:
                if (lVar != null) {
                    lVar.setSortType(0);
                    lVar.setIsGood(1);
                    break;
                }
                break;
            case 6:
                if (lVar != null) {
                    lVar.setSortType(2);
                    lVar.setIsGood(0);
                    break;
                }
                break;
            case 7:
                if (lVar != null) {
                    lVar.setSortType(3);
                    lVar.setIsGood(0);
                    break;
                }
                break;
        }
        return 1;
    }
}
