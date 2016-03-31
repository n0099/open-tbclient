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
    private static final HashMap<String, String> bYn = new HashMap<>();

    static {
        bYn.put("#(呵呵)", "image_emoticon");
        bYn.put("#(哈哈)", "image_emoticon2");
        bYn.put("#(吐舌)", "image_emoticon3");
        bYn.put("#(啊)", "image_emoticon4");
        bYn.put("#(啊?)", "image_emoticon4");
        bYn.put("#(酷)", "image_emoticon5");
        bYn.put("#(怒)", "image_emoticon6");
        bYn.put("#(开心)", "image_emoticon7");
        bYn.put("#(汗)", "image_emoticon8");
        bYn.put("#(泪)", "image_emoticon9");
        bYn.put("#(黑线)", "image_emoticon10");
        bYn.put("#(鄙视)", "image_emoticon11");
        bYn.put("#(不高兴)", "image_emoticon12");
        bYn.put("#(真棒)", "image_emoticon13");
        bYn.put("#(钱)", "image_emoticon14");
        bYn.put("#(疑问)", "image_emoticon15");
        bYn.put("#(阴险)", "image_emoticon16");
        bYn.put("#(吐)", "image_emoticon17");
        bYn.put("#(咦)", "image_emoticon18");
        bYn.put("#(咦?)", "image_emoticon18");
        bYn.put("#(委屈)", "image_emoticon19");
        bYn.put("#(花心)", "image_emoticon20");
        bYn.put("#(呼~)", "image_emoticon21");
        bYn.put("#(笑眼)", "image_emoticon22");
        bYn.put("#(冷)", "image_emoticon23");
        bYn.put("#(太开心)", "image_emoticon24");
        bYn.put("#(滑稽)", "image_emoticon25");
        bYn.put("#(勉强)", "image_emoticon26");
        bYn.put("#(狂汗)", "image_emoticon27");
        bYn.put("#(乖)", "image_emoticon28");
        bYn.put("#(睡觉)", "image_emoticon29");
        bYn.put("#(惊哭)", "image_emoticon30");
        bYn.put("#(升起)", "image_emoticon31");
        bYn.put("#(惊讶)", "image_emoticon32");
        bYn.put("#(喷)", "image_emoticon33");
        bYn.put("#(爱心)", "image_emoticon34");
        bYn.put("#(心碎)", "image_emoticon35");
        bYn.put("#(玫瑰)", "image_emoticon36");
        bYn.put("#(礼物)", "image_emoticon37");
        bYn.put("#(彩虹)", "image_emoticon38");
        bYn.put("#(星星月亮)", "image_emoticon39");
        bYn.put("#(太阳)", "image_emoticon40");
        bYn.put("#(钱币)", "image_emoticon41");
        bYn.put("#(灯泡)", "image_emoticon42");
        bYn.put("#(茶杯)", "image_emoticon43");
        bYn.put("#(蛋糕)", "image_emoticon44");
        bYn.put("#(音乐)", "image_emoticon45");
        bYn.put("#(haha)", "image_emoticon46");
        bYn.put("#(胜利)", "image_emoticon47");
        bYn.put("#(大拇指)", "image_emoticon48");
        bYn.put("#(弱)", "image_emoticon49");
        bYn.put("#(OK)", "image_emoticon50");
        bYn.put("#(哼)", "image_emoticon61");
        bYn.put("#(赖皮)", "ali_001");
        bYn.put("#(感动)", "ali_002");
        bYn.put("#(十分惊讶)", "ali_003");
        bYn.put("#(怒气)", "ali_004");
        bYn.put("#(哭泣)", "ali_005");
        bYn.put("#(吃惊)", "ali_006");
        bYn.put("#(嘲弄)", "ali_007");
        bYn.put("#(飘过)", "ali_008");
        bYn.put("#(转圈哭)", "ali_009");
        bYn.put("#(神经病)", "ali_010");
        bYn.put("#(揪耳朵)", "ali_011");
        bYn.put("#(惊汗)", "ali_012");
        bYn.put("#(隐身)", "ali_013");
        bYn.put("#(不要嘛)", "ali_014");
        bYn.put("#(遁)", "ali_015");
        bYn.put("#(不公平)", "ali_016");
        bYn.put("#(爬来了)", "ali_017");
        bYn.put("#(蛋花哭)", "ali_018");
        bYn.put("#(温暖)", "ali_019");
        bYn.put("#(点头)", "ali_020");
        bYn.put("#(撒钱)", "ali_021");
        bYn.put("#(献花)", "ali_022");
        bYn.put("#(寒)", "ali_023");
        bYn.put("#(傻笑)", "ali_024");
        bYn.put("#(扭扭)", "ali_025");
        bYn.put("#(疯)", "ali_026");
        bYn.put("#(抓狂)", "ali_027");
        bYn.put("#(抓)", "ali_028");
        bYn.put("#(蜷)", "ali_029");
        bYn.put("#(挠墙)", "ali_030");
        bYn.put("#(狂笑)", "ali_031");
        bYn.put("#(抱枕)", "ali_032");
        bYn.put("#(吼叫)", "ali_033");
        bYn.put("#(嚷)", "ali_034");
        bYn.put("#(唠叨)", "ali_035");
        bYn.put("#(捏脸)", "ali_036");
        bYn.put("#(爆笑)", "ali_037");
        bYn.put("#(郁闷)", "ali_038");
        bYn.put("#(潜水)", "ali_039");
        bYn.put("#(十分开心)", "ali_040");
        bYn.put("#(冷笑话)", "ali_041");
        bYn.put("#(顶！)", "ali_042");
        bYn.put("#(潜)", "ali_043");
        bYn.put("#(画圈圈)", "ali_044");
        bYn.put("#(玩电脑)", "ali_045");
        bYn.put("#(狂吐)", "ali_046");
        bYn.put("#(哭着跑)", "ali_047");
        bYn.put("#(阿狸侠)", "ali_048");
        bYn.put("#(冷死了)", "ali_049");
        bYn.put("#(惆怅~)", "ali_050");
        bYn.put("#(摸头)", "ali_051");
        bYn.put("#(蹭)", "ali_052");
        bYn.put("#(打滚)", "ali_053");
        bYn.put("#(叩拜)", "ali_054");
        bYn.put("#(摸)", "ali_055");
        bYn.put("#(数钱)", "ali_056");
        bYn.put("#(拖走)", "ali_057");
        bYn.put("#(热)", "ali_058");
        bYn.put("#(加1)", "ali_059");
        bYn.put("#(压力)", "ali_060");
        bYn.put("#(表逼我)", "ali_061");
        bYn.put("#(人呢)", "ali_062");
        bYn.put("#(摇晃)", "ali_063");
        bYn.put("#(打地鼠)", "ali_064");
        bYn.put("#(这个屌)", "ali_065");
        bYn.put("#(恐慌)", "ali_066");
        bYn.put("#(晕乎乎)", "ali_067");
        bYn.put("#(浮云)", "ali_068");
        bYn.put("#(给力)", "ali_069");
        bYn.put("#(杯具了)", "ali_070");
        bYn.put("#(焦糖舞)", "yz_001");
        bYn.put("#(翻滚)", "yz_002");
        bYn.put("#(拍屁股做鬼脸)", "yz_003");
        bYn.put("#(不)", "yz_004");
        bYn.put("#(河蟹掉啦)", "yz_005");
        bYn.put("#(哦耶)", "yz_006");
        bYn.put("#(我倒)", "yz_007");
        bYn.put("#(投降)", "yz_008");
        bYn.put("#(微笑)", "b01");
        bYn.put("#(帅哥)", "b02");
        bYn.put("#(美女)", "b03");
        bYn.put("#(老大)", "b04");
        bYn.put("#(哈哈哈)", "b05");
        bYn.put("#(奸笑)", "b06");
        bYn.put("#(傻乐)", "b07");
        bYn.put("#(飞吻)", "b08");
        bYn.put("#(害羞)", "b09");
        bYn.put("#(花痴)", "b10");
        bYn.put("#(憧憬)", "b11");
        bYn.put("#(你牛)", "b12");
        bYn.put("#(鼓掌)", "b13");
        bYn.put("#(可爱)", "b14");
        bYn.put("#(太委屈)", "b15");
        bYn.put("#(大哭)", "b16");
        bYn.put("#(泪奔)", "b17");
        bYn.put("#(寻死)", "b18");
        bYn.put("#(非常惊讶)", "b19");
        bYn.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return bYn.get(str);
    }

    public static List<TbFaceManager.RichUnit> iI(String str) {
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
                        arrayList.add(iJ(str2));
                        str2 = "";
                    }
                    arrayList.add(aT(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(iJ(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit iJ(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aT(String str, String str2) {
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
                                SpannableString K = K(context, str2);
                                if (K != null) {
                                    cVar.append(K);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(cVar.Iq(), name, str3);
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
                    SpannableString K2 = K(context, str2);
                    if (K2 != null) {
                        cVar.append(K2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.e> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fl = TbFaceManager.EN().fl(str);
        if (fl != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst(), fl);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0052a fL = TbFaceManager.EN().fL(str);
            if (fL != null) {
                int width = (int) (0.5d * fL.getWidth());
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString K(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.bg.v(context, str);
    }
}
