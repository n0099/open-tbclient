package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private static final HashMap<String, String> bYS = new HashMap<>();

    static {
        bYS.put("#(呵呵)", "image_emoticon");
        bYS.put("#(哈哈)", "image_emoticon2");
        bYS.put("#(吐舌)", "image_emoticon3");
        bYS.put("#(啊)", "image_emoticon4");
        bYS.put("#(啊?)", "image_emoticon4");
        bYS.put("#(酷)", "image_emoticon5");
        bYS.put("#(怒)", "image_emoticon6");
        bYS.put("#(开心)", "image_emoticon7");
        bYS.put("#(汗)", "image_emoticon8");
        bYS.put("#(泪)", "image_emoticon9");
        bYS.put("#(黑线)", "image_emoticon10");
        bYS.put("#(鄙视)", "image_emoticon11");
        bYS.put("#(不高兴)", "image_emoticon12");
        bYS.put("#(真棒)", "image_emoticon13");
        bYS.put("#(钱)", "image_emoticon14");
        bYS.put("#(疑问)", "image_emoticon15");
        bYS.put("#(阴险)", "image_emoticon16");
        bYS.put("#(吐)", "image_emoticon17");
        bYS.put("#(咦)", "image_emoticon18");
        bYS.put("#(咦?)", "image_emoticon18");
        bYS.put("#(委屈)", "image_emoticon19");
        bYS.put("#(花心)", "image_emoticon20");
        bYS.put("#(呼~)", "image_emoticon21");
        bYS.put("#(笑眼)", "image_emoticon22");
        bYS.put("#(冷)", "image_emoticon23");
        bYS.put("#(太开心)", "image_emoticon24");
        bYS.put("#(滑稽)", "image_emoticon25");
        bYS.put("#(勉强)", "image_emoticon26");
        bYS.put("#(狂汗)", "image_emoticon27");
        bYS.put("#(乖)", "image_emoticon28");
        bYS.put("#(睡觉)", "image_emoticon29");
        bYS.put("#(惊哭)", "image_emoticon30");
        bYS.put("#(升起)", "image_emoticon31");
        bYS.put("#(惊讶)", "image_emoticon32");
        bYS.put("#(喷)", "image_emoticon33");
        bYS.put("#(爱心)", "image_emoticon34");
        bYS.put("#(心碎)", "image_emoticon35");
        bYS.put("#(玫瑰)", "image_emoticon36");
        bYS.put("#(礼物)", "image_emoticon37");
        bYS.put("#(彩虹)", "image_emoticon38");
        bYS.put("#(星星月亮)", "image_emoticon39");
        bYS.put("#(太阳)", "image_emoticon40");
        bYS.put("#(钱币)", "image_emoticon41");
        bYS.put("#(灯泡)", "image_emoticon42");
        bYS.put("#(茶杯)", "image_emoticon43");
        bYS.put("#(蛋糕)", "image_emoticon44");
        bYS.put("#(音乐)", "image_emoticon45");
        bYS.put("#(haha)", "image_emoticon46");
        bYS.put("#(胜利)", "image_emoticon47");
        bYS.put("#(大拇指)", "image_emoticon48");
        bYS.put("#(弱)", "image_emoticon49");
        bYS.put("#(OK)", "image_emoticon50");
        bYS.put("#(哼)", "image_emoticon61");
        bYS.put("#(赖皮)", "ali_001");
        bYS.put("#(感动)", "ali_002");
        bYS.put("#(十分惊讶)", "ali_003");
        bYS.put("#(怒气)", "ali_004");
        bYS.put("#(哭泣)", "ali_005");
        bYS.put("#(吃惊)", "ali_006");
        bYS.put("#(嘲弄)", "ali_007");
        bYS.put("#(飘过)", "ali_008");
        bYS.put("#(转圈哭)", "ali_009");
        bYS.put("#(神经病)", "ali_010");
        bYS.put("#(揪耳朵)", "ali_011");
        bYS.put("#(惊汗)", "ali_012");
        bYS.put("#(隐身)", "ali_013");
        bYS.put("#(不要嘛)", "ali_014");
        bYS.put("#(遁)", "ali_015");
        bYS.put("#(不公平)", "ali_016");
        bYS.put("#(爬来了)", "ali_017");
        bYS.put("#(蛋花哭)", "ali_018");
        bYS.put("#(温暖)", "ali_019");
        bYS.put("#(点头)", "ali_020");
        bYS.put("#(撒钱)", "ali_021");
        bYS.put("#(献花)", "ali_022");
        bYS.put("#(寒)", "ali_023");
        bYS.put("#(傻笑)", "ali_024");
        bYS.put("#(扭扭)", "ali_025");
        bYS.put("#(疯)", "ali_026");
        bYS.put("#(抓狂)", "ali_027");
        bYS.put("#(抓)", "ali_028");
        bYS.put("#(蜷)", "ali_029");
        bYS.put("#(挠墙)", "ali_030");
        bYS.put("#(狂笑)", "ali_031");
        bYS.put("#(抱枕)", "ali_032");
        bYS.put("#(吼叫)", "ali_033");
        bYS.put("#(嚷)", "ali_034");
        bYS.put("#(唠叨)", "ali_035");
        bYS.put("#(捏脸)", "ali_036");
        bYS.put("#(爆笑)", "ali_037");
        bYS.put("#(郁闷)", "ali_038");
        bYS.put("#(潜水)", "ali_039");
        bYS.put("#(十分开心)", "ali_040");
        bYS.put("#(冷笑话)", "ali_041");
        bYS.put("#(顶！)", "ali_042");
        bYS.put("#(潜)", "ali_043");
        bYS.put("#(画圈圈)", "ali_044");
        bYS.put("#(玩电脑)", "ali_045");
        bYS.put("#(狂吐)", "ali_046");
        bYS.put("#(哭着跑)", "ali_047");
        bYS.put("#(阿狸侠)", "ali_048");
        bYS.put("#(冷死了)", "ali_049");
        bYS.put("#(惆怅~)", "ali_050");
        bYS.put("#(摸头)", "ali_051");
        bYS.put("#(蹭)", "ali_052");
        bYS.put("#(打滚)", "ali_053");
        bYS.put("#(叩拜)", "ali_054");
        bYS.put("#(摸)", "ali_055");
        bYS.put("#(数钱)", "ali_056");
        bYS.put("#(拖走)", "ali_057");
        bYS.put("#(热)", "ali_058");
        bYS.put("#(加1)", "ali_059");
        bYS.put("#(压力)", "ali_060");
        bYS.put("#(表逼我)", "ali_061");
        bYS.put("#(人呢)", "ali_062");
        bYS.put("#(摇晃)", "ali_063");
        bYS.put("#(打地鼠)", "ali_064");
        bYS.put("#(这个屌)", "ali_065");
        bYS.put("#(恐慌)", "ali_066");
        bYS.put("#(晕乎乎)", "ali_067");
        bYS.put("#(浮云)", "ali_068");
        bYS.put("#(给力)", "ali_069");
        bYS.put("#(杯具了)", "ali_070");
        bYS.put("#(焦糖舞)", "yz_001");
        bYS.put("#(翻滚)", "yz_002");
        bYS.put("#(拍屁股做鬼脸)", "yz_003");
        bYS.put("#(不)", "yz_004");
        bYS.put("#(河蟹掉啦)", "yz_005");
        bYS.put("#(哦耶)", "yz_006");
        bYS.put("#(我倒)", "yz_007");
        bYS.put("#(投降)", "yz_008");
        bYS.put("#(微笑)", "b01");
        bYS.put("#(帅哥)", "b02");
        bYS.put("#(美女)", "b03");
        bYS.put("#(老大)", "b04");
        bYS.put("#(哈哈哈)", "b05");
        bYS.put("#(奸笑)", "b06");
        bYS.put("#(傻乐)", "b07");
        bYS.put("#(飞吻)", "b08");
        bYS.put("#(害羞)", "b09");
        bYS.put("#(花痴)", "b10");
        bYS.put("#(憧憬)", "b11");
        bYS.put("#(你牛)", "b12");
        bYS.put("#(鼓掌)", "b13");
        bYS.put("#(可爱)", "b14");
        bYS.put("#(太委屈)", "b15");
        bYS.put("#(大哭)", "b16");
        bYS.put("#(泪奔)", "b17");
        bYS.put("#(寻死)", "b18");
        bYS.put("#(非常惊讶)", "b19");
        bYS.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return bYS.get(str);
    }

    public static List<TbFaceManager.RichUnit> iK(String str) {
        String str2 = "";
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '#' && i < length - 1 && str.charAt(i + 1) == '(') {
                String str3 = "#(";
                i += 2;
                while (i < length) {
                    char charAt2 = str.charAt(i);
                    str3 = String.valueOf(str3) + charAt2;
                    if (charAt2 == ')') {
                        break;
                    }
                    i++;
                }
                String name = getName(str3);
                if (TextUtils.isEmpty(name)) {
                    str2 = String.valueOf(str2) + str3;
                } else {
                    if (!TextUtils.isEmpty(str2)) {
                        arrayList.add(iL(str2));
                        str2 = "";
                    }
                    arrayList.add(aX(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(iL(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit iL(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aX(String str, String str2) {
        String substring = str.substring(2, str.length() - 1);
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str2;
        richUnit.type = 2;
        richUnit.c = substring;
        return richUnit;
    }

    public static ArrayList<com.baidu.tbadk.widget.richText.c> c(Context context, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        com.baidu.tbadk.widget.richText.c cVar = new com.baidu.tbadk.widget.richText.c(1);
        arrayList.add(cVar);
        try {
            String str2 = "";
            int length = str.length();
            int i2 = 0;
            while (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt == '#' && i2 < length - 1 && str.charAt(i2 + 1) == '(') {
                    String str3 = "#(";
                    i2 += 2;
                    while (i2 < length) {
                        char charAt2 = str.charAt(i2);
                        str3 = String.valueOf(str3) + charAt2;
                        if (charAt2 == ')' || (i2 + 1 < length && str.charAt(i2 + 1) == '#')) {
                            break;
                        }
                        i2++;
                    }
                    String name = getName(str3);
                    if (TextUtils.isEmpty(name)) {
                        str2 = String.valueOf(str2) + str3;
                    } else {
                        if (!TextUtils.isEmpty(str2)) {
                            if (i == 1) {
                                cVar.append(str2);
                            } else {
                                SpannableString L = L(context, str2);
                                if (L != null) {
                                    cVar.append(L);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(cVar.GG(), name, str3);
                        if (a != null) {
                            cVar.append(a);
                        }
                    }
                } else {
                    str2 = String.valueOf(str2) + charAt;
                }
                i2++;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (i == 1) {
                    cVar.append(str2);
                } else {
                    SpannableString L2 = L(context, str2);
                    if (L2 != null) {
                        cVar.append(L2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.e> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fi = TbFaceManager.CG().fi(str);
        if (fi != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m11getInst(), fi);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0043a fI = TbFaceManager.CG().fI(str);
            if (fI != null) {
                int width = (int) (0.5d * fI.getWidth());
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString L(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.bg.w(context, str);
    }
}
