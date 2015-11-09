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
/* loaded from: classes.dex */
public class o {
    private static final HashMap<String, String> brz = new HashMap<>();

    static {
        brz.put("#(呵呵)", "image_emoticon");
        brz.put("#(哈哈)", "image_emoticon2");
        brz.put("#(吐舌)", "image_emoticon3");
        brz.put("#(啊)", "image_emoticon4");
        brz.put("#(啊?)", "image_emoticon4");
        brz.put("#(酷)", "image_emoticon5");
        brz.put("#(怒)", "image_emoticon6");
        brz.put("#(开心)", "image_emoticon7");
        brz.put("#(汗)", "image_emoticon8");
        brz.put("#(泪)", "image_emoticon9");
        brz.put("#(黑线)", "image_emoticon10");
        brz.put("#(鄙视)", "image_emoticon11");
        brz.put("#(不高兴)", "image_emoticon12");
        brz.put("#(真棒)", "image_emoticon13");
        brz.put("#(钱)", "image_emoticon14");
        brz.put("#(疑问)", "image_emoticon15");
        brz.put("#(阴险)", "image_emoticon16");
        brz.put("#(吐)", "image_emoticon17");
        brz.put("#(咦)", "image_emoticon18");
        brz.put("#(咦?)", "image_emoticon18");
        brz.put("#(委屈)", "image_emoticon19");
        brz.put("#(花心)", "image_emoticon20");
        brz.put("#(呼~)", "image_emoticon21");
        brz.put("#(笑眼)", "image_emoticon22");
        brz.put("#(冷)", "image_emoticon23");
        brz.put("#(太开心)", "image_emoticon24");
        brz.put("#(滑稽)", "image_emoticon25");
        brz.put("#(勉强)", "image_emoticon26");
        brz.put("#(狂汗)", "image_emoticon27");
        brz.put("#(乖)", "image_emoticon28");
        brz.put("#(睡觉)", "image_emoticon29");
        brz.put("#(惊哭)", "image_emoticon30");
        brz.put("#(升起)", "image_emoticon31");
        brz.put("#(惊讶)", "image_emoticon32");
        brz.put("#(喷)", "image_emoticon33");
        brz.put("#(爱心)", "image_emoticon34");
        brz.put("#(心碎)", "image_emoticon35");
        brz.put("#(玫瑰)", "image_emoticon36");
        brz.put("#(礼物)", "image_emoticon37");
        brz.put("#(彩虹)", "image_emoticon38");
        brz.put("#(星星月亮)", "image_emoticon39");
        brz.put("#(太阳)", "image_emoticon40");
        brz.put("#(钱币)", "image_emoticon41");
        brz.put("#(灯泡)", "image_emoticon42");
        brz.put("#(茶杯)", "image_emoticon43");
        brz.put("#(蛋糕)", "image_emoticon44");
        brz.put("#(音乐)", "image_emoticon45");
        brz.put("#(haha)", "image_emoticon46");
        brz.put("#(胜利)", "image_emoticon47");
        brz.put("#(大拇指)", "image_emoticon48");
        brz.put("#(弱)", "image_emoticon49");
        brz.put("#(OK)", "image_emoticon50");
        brz.put("#(赖皮)", "ali_001");
        brz.put("#(感动)", "ali_002");
        brz.put("#(十分惊讶)", "ali_003");
        brz.put("#(怒气)", "ali_004");
        brz.put("#(哭泣)", "ali_005");
        brz.put("#(吃惊)", "ali_006");
        brz.put("#(嘲弄)", "ali_007");
        brz.put("#(飘过)", "ali_008");
        brz.put("#(转圈哭)", "ali_009");
        brz.put("#(神经病)", "ali_010");
        brz.put("#(揪耳朵)", "ali_011");
        brz.put("#(惊汗)", "ali_012");
        brz.put("#(隐身)", "ali_013");
        brz.put("#(不要嘛)", "ali_014");
        brz.put("#(遁)", "ali_015");
        brz.put("#(不公平)", "ali_016");
        brz.put("#(爬来了)", "ali_017");
        brz.put("#(蛋花哭)", "ali_018");
        brz.put("#(温暖)", "ali_019");
        brz.put("#(点头)", "ali_020");
        brz.put("#(撒钱)", "ali_021");
        brz.put("#(献花)", "ali_022");
        brz.put("#(寒)", "ali_023");
        brz.put("#(傻笑)", "ali_024");
        brz.put("#(扭扭)", "ali_025");
        brz.put("#(疯)", "ali_026");
        brz.put("#(抓狂)", "ali_027");
        brz.put("#(抓)", "ali_028");
        brz.put("#(蜷)", "ali_029");
        brz.put("#(挠墙)", "ali_030");
        brz.put("#(狂笑)", "ali_031");
        brz.put("#(抱枕)", "ali_032");
        brz.put("#(吼叫)", "ali_033");
        brz.put("#(嚷)", "ali_034");
        brz.put("#(唠叨)", "ali_035");
        brz.put("#(捏脸)", "ali_036");
        brz.put("#(爆笑)", "ali_037");
        brz.put("#(郁闷)", "ali_038");
        brz.put("#(潜水)", "ali_039");
        brz.put("#(十分开心)", "ali_040");
        brz.put("#(冷笑话)", "ali_041");
        brz.put("#(顶！)", "ali_042");
        brz.put("#(潜)", "ali_043");
        brz.put("#(画圈圈)", "ali_044");
        brz.put("#(玩电脑)", "ali_045");
        brz.put("#(狂吐)", "ali_046");
        brz.put("#(哭着跑)", "ali_047");
        brz.put("#(阿狸侠)", "ali_048");
        brz.put("#(冷死了)", "ali_049");
        brz.put("#(惆怅~)", "ali_050");
        brz.put("#(摸头)", "ali_051");
        brz.put("#(蹭)", "ali_052");
        brz.put("#(打滚)", "ali_053");
        brz.put("#(叩拜)", "ali_054");
        brz.put("#(摸)", "ali_055");
        brz.put("#(数钱)", "ali_056");
        brz.put("#(拖走)", "ali_057");
        brz.put("#(热)", "ali_058");
        brz.put("#(加1)", "ali_059");
        brz.put("#(压力)", "ali_060");
        brz.put("#(表逼我)", "ali_061");
        brz.put("#(人呢)", "ali_062");
        brz.put("#(摇晃)", "ali_063");
        brz.put("#(打地鼠)", "ali_064");
        brz.put("#(这个屌)", "ali_065");
        brz.put("#(恐慌)", "ali_066");
        brz.put("#(晕乎乎)", "ali_067");
        brz.put("#(浮云)", "ali_068");
        brz.put("#(给力)", "ali_069");
        brz.put("#(杯具了)", "ali_070");
        brz.put("#(焦糖舞)", "yz_001");
        brz.put("#(翻滚)", "yz_002");
        brz.put("#(拍屁股做鬼脸)", "yz_003");
        brz.put("#(不)", "yz_004");
        brz.put("#(河蟹掉啦)", "yz_005");
        brz.put("#(哦耶)", "yz_006");
        brz.put("#(我倒)", "yz_007");
        brz.put("#(投降)", "yz_008");
        brz.put("#(微笑)", "b01");
        brz.put("#(帅哥)", "b02");
        brz.put("#(美女)", "b03");
        brz.put("#(老大)", "b04");
        brz.put("#(哈哈哈)", "b05");
        brz.put("#(奸笑)", "b06");
        brz.put("#(傻乐)", "b07");
        brz.put("#(飞吻)", "b08");
        brz.put("#(害羞)", "b09");
        brz.put("#(花痴)", "b10");
        brz.put("#(憧憬)", "b11");
        brz.put("#(你牛)", "b12");
        brz.put("#(鼓掌)", "b13");
        brz.put("#(可爱)", "b14");
        brz.put("#(太委屈)", "b15");
        brz.put("#(大哭)", "b16");
        brz.put("#(泪奔)", "b17");
        brz.put("#(寻死)", "b18");
        brz.put("#(非常惊讶)", "b19");
        brz.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return brz.get(str);
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
                                SpannableString N = N(context, str2);
                                if (N != null) {
                                    cVar.append(N);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(cVar.EM(), name, str3);
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
                    SpannableString N2 = N(context, str2);
                    if (N2 != null) {
                        cVar.append(N2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.e> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int eM = TbFaceManager.BU().eM(str);
        if (eM != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst(), eM);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0049a fm = TbFaceManager.BU().fm(str);
            if (fm != null) {
                int width = (int) (0.5d * fm.getWidth());
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString N(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.az.E(context, str);
    }
}
