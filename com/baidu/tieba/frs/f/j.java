package com.baidu.tieba.frs.f;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes.dex */
public class j {
    private static String cKf() {
        return "pref_name_frs_sortType_" + TbadkCoreApplication.getCurrentAccount();
    }

    private static SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.getInst().getSharedPreferences(cKf(), 0);
    }

    public static void aS(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                SharedPreferences.Editor edit = getSharedPreferences().edit();
                edit.putInt(str, i);
                edit.apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int LG(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return getSharedPreferences().getInt(str, -1);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void clearAll() {
        try {
            SharedPreferences.Editor edit = getSharedPreferences().edit();
            edit.clear();
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int BD(int i) {
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
            case 8:
                return 4;
        }
    }

    public static int BE(int i) {
        switch (i) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 6;
            case 3:
                return 7;
            case 4:
                return 8;
            default:
                return -1;
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
            case 8:
                if (frsRequestData != null) {
                    frsRequestData.setSortType(4);
                    frsRequestData.setIsGood(0);
                    break;
                }
                break;
        }
        return 1;
    }

    public static int BF(int i) {
        switch (i) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
            case 4:
                return 4;
            case 3:
                return 1;
            default:
                return -1;
        }
    }
}
