package com.baidu.tieba.homepage.lowFlows.d;

import android.graphics.drawable.Drawable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    public static Drawable[] LZ(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        Drawable[] drawableArr = new Drawable[2];
        char c = 65535;
        switch (str.hashCode()) {
            case -1581702362:
                if (str.equals("share_num")) {
                    c = 1;
                    break;
                }
                break;
            case -6986408:
                if (str.equals("care_num")) {
                    c = 3;
                    break;
                }
                break;
            case 975378291:
                if (str.equals("agree_num")) {
                    c = 0;
                    break;
                }
                break;
            case 2103869862:
                if (str.equals("comment_num")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                drawableArr[0] = WebPManager.a(R.drawable.pic_banner_tiebatreasure_like, WebPManager.ResourceStateType.NORMAL);
                drawableArr[1] = WebPManager.a(R.drawable.pic_giadienta_tiebatreasure_like, WebPManager.ResourceStateType.NORMAL);
                return drawableArr;
            case 1:
                drawableArr[0] = WebPManager.a(R.drawable.pic_banner_tiebatreasure_spread, WebPManager.ResourceStateType.NORMAL);
                drawableArr[1] = WebPManager.a(R.drawable.pic_giadienta_tiebatreasure_spread, WebPManager.ResourceStateType.NORMAL);
                return drawableArr;
            case 2:
                drawableArr[0] = WebPManager.a(R.drawable.pic_banner_tiebatreasure_discuss, WebPManager.ResourceStateType.NORMAL);
                drawableArr[1] = WebPManager.a(R.drawable.pic_giadienta_tiebatreasure_discuss, WebPManager.ResourceStateType.NORMAL);
                return drawableArr;
            case 3:
                drawableArr[0] = WebPManager.a(R.drawable.pic_banner_tiebatreasure_care, WebPManager.ResourceStateType.NORMAL);
                drawableArr[1] = WebPManager.a(R.drawable.pic_giadienta_tiebatreasure_care, WebPManager.ResourceStateType.NORMAL);
                return drawableArr;
            default:
                drawableArr[0] = WebPManager.a(R.drawable.pic_banner_tiebatreasure_custom, WebPManager.ResourceStateType.NORMAL);
                drawableArr[1] = WebPManager.a(R.drawable.pic_giadienta_tiebatreasure_custom, WebPManager.ResourceStateType.NORMAL);
                return drawableArr;
        }
    }

    public static String Ma(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1581702362:
                if (str.equals("share_num")) {
                    c = 1;
                    break;
                }
                break;
            case -6986408:
                if (str.equals("care_num")) {
                    c = 3;
                    break;
                }
                break;
            case 975378291:
                if (str.equals("agree_num")) {
                    c = 0;
                    break;
                }
                break;
            case 2103869862:
                if (str.equals("comment_num")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return TbadkCoreApplication.getInst().getResources().getString(R.string.lf_banner_treasure_like);
            case 1:
                return TbadkCoreApplication.getInst().getResources().getString(R.string.lf_banner_treasure_spread);
            case 2:
                return TbadkCoreApplication.getInst().getResources().getString(R.string.lf_banner_treasure_discuss);
            case 3:
                return TbadkCoreApplication.getInst().getResources().getString(R.string.lf_banner_treasure_care);
            default:
                return TbadkCoreApplication.getInst().getResources().getString(R.string.lf_banner_treasure_custom);
        }
    }
}
