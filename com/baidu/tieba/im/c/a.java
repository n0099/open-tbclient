package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class a {
    public static int a(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
            case 3:
            case 4:
            case 5:
            case 9:
            case 13:
            case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            default:
                return 1;
            case 6:
                return 2;
            case 7:
                return 3;
            case 8:
                return 5;
            case 10:
            case 11:
            case 12:
                return 6;
            case TbConfig.NOTIFY_LIVE_NOTIFY /* 21 */:
                return 7;
        }
    }
}
