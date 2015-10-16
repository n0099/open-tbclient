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
    private static final HashMap<String, String> bqV = new HashMap<>();

    static {
        bqV.put("#(呵呵)", "image_emoticon");
        bqV.put("#(哈哈)", "image_emoticon2");
        bqV.put("#(吐舌)", "image_emoticon3");
        bqV.put("#(啊)", "image_emoticon4");
        bqV.put("#(啊?)", "image_emoticon4");
        bqV.put("#(酷)", "image_emoticon5");
        bqV.put("#(怒)", "image_emoticon6");
        bqV.put("#(开心)", "image_emoticon7");
        bqV.put("#(汗)", "image_emoticon8");
        bqV.put("#(泪)", "image_emoticon9");
        bqV.put("#(黑线)", "image_emoticon10");
        bqV.put("#(鄙视)", "image_emoticon11");
        bqV.put("#(不高兴)", "image_emoticon12");
        bqV.put("#(真棒)", "image_emoticon13");
        bqV.put("#(钱)", "image_emoticon14");
        bqV.put("#(疑问)", "image_emoticon15");
        bqV.put("#(阴险)", "image_emoticon16");
        bqV.put("#(吐)", "image_emoticon17");
        bqV.put("#(咦)", "image_emoticon18");
        bqV.put("#(咦?)", "image_emoticon18");
        bqV.put("#(委屈)", "image_emoticon19");
        bqV.put("#(花心)", "image_emoticon20");
        bqV.put("#(呼~)", "image_emoticon21");
        bqV.put("#(笑眼)", "image_emoticon22");
        bqV.put("#(冷)", "image_emoticon23");
        bqV.put("#(太开心)", "image_emoticon24");
        bqV.put("#(滑稽)", "image_emoticon25");
        bqV.put("#(勉强)", "image_emoticon26");
        bqV.put("#(狂汗)", "image_emoticon27");
        bqV.put("#(乖)", "image_emoticon28");
        bqV.put("#(睡觉)", "image_emoticon29");
        bqV.put("#(惊哭)", "image_emoticon30");
        bqV.put("#(升起)", "image_emoticon31");
        bqV.put("#(惊讶)", "image_emoticon32");
        bqV.put("#(喷)", "image_emoticon33");
        bqV.put("#(爱心)", "image_emoticon34");
        bqV.put("#(心碎)", "image_emoticon35");
        bqV.put("#(玫瑰)", "image_emoticon36");
        bqV.put("#(礼物)", "image_emoticon37");
        bqV.put("#(彩虹)", "image_emoticon38");
        bqV.put("#(星星月亮)", "image_emoticon39");
        bqV.put("#(太阳)", "image_emoticon40");
        bqV.put("#(钱币)", "image_emoticon41");
        bqV.put("#(灯泡)", "image_emoticon42");
        bqV.put("#(茶杯)", "image_emoticon43");
        bqV.put("#(蛋糕)", "image_emoticon44");
        bqV.put("#(音乐)", "image_emoticon45");
        bqV.put("#(haha)", "image_emoticon46");
        bqV.put("#(胜利)", "image_emoticon47");
        bqV.put("#(大拇指)", "image_emoticon48");
        bqV.put("#(弱)", "image_emoticon49");
        bqV.put("#(OK)", "image_emoticon50");
        bqV.put("#(赖皮)", "ali_001");
        bqV.put("#(感动)", "ali_002");
        bqV.put("#(十分惊讶)", "ali_003");
        bqV.put("#(怒气)", "ali_004");
        bqV.put("#(哭泣)", "ali_005");
        bqV.put("#(吃惊)", "ali_006");
        bqV.put("#(嘲弄)", "ali_007");
        bqV.put("#(飘过)", "ali_008");
        bqV.put("#(转圈哭)", "ali_009");
        bqV.put("#(神经病)", "ali_010");
        bqV.put("#(揪耳朵)", "ali_011");
        bqV.put("#(惊汗)", "ali_012");
        bqV.put("#(隐身)", "ali_013");
        bqV.put("#(不要嘛)", "ali_014");
        bqV.put("#(遁)", "ali_015");
        bqV.put("#(不公平)", "ali_016");
        bqV.put("#(爬来了)", "ali_017");
        bqV.put("#(蛋花哭)", "ali_018");
        bqV.put("#(温暖)", "ali_019");
        bqV.put("#(点头)", "ali_020");
        bqV.put("#(撒钱)", "ali_021");
        bqV.put("#(献花)", "ali_022");
        bqV.put("#(寒)", "ali_023");
        bqV.put("#(傻笑)", "ali_024");
        bqV.put("#(扭扭)", "ali_025");
        bqV.put("#(疯)", "ali_026");
        bqV.put("#(抓狂)", "ali_027");
        bqV.put("#(抓)", "ali_028");
        bqV.put("#(蜷)", "ali_029");
        bqV.put("#(挠墙)", "ali_030");
        bqV.put("#(狂笑)", "ali_031");
        bqV.put("#(抱枕)", "ali_032");
        bqV.put("#(吼叫)", "ali_033");
        bqV.put("#(嚷)", "ali_034");
        bqV.put("#(唠叨)", "ali_035");
        bqV.put("#(捏脸)", "ali_036");
        bqV.put("#(爆笑)", "ali_037");
        bqV.put("#(郁闷)", "ali_038");
        bqV.put("#(潜水)", "ali_039");
        bqV.put("#(十分开心)", "ali_040");
        bqV.put("#(冷笑话)", "ali_041");
        bqV.put("#(顶！)", "ali_042");
        bqV.put("#(潜)", "ali_043");
        bqV.put("#(画圈圈)", "ali_044");
        bqV.put("#(玩电脑)", "ali_045");
        bqV.put("#(狂吐)", "ali_046");
        bqV.put("#(哭着跑)", "ali_047");
        bqV.put("#(阿狸侠)", "ali_048");
        bqV.put("#(冷死了)", "ali_049");
        bqV.put("#(惆怅~)", "ali_050");
        bqV.put("#(摸头)", "ali_051");
        bqV.put("#(蹭)", "ali_052");
        bqV.put("#(打滚)", "ali_053");
        bqV.put("#(叩拜)", "ali_054");
        bqV.put("#(摸)", "ali_055");
        bqV.put("#(数钱)", "ali_056");
        bqV.put("#(拖走)", "ali_057");
        bqV.put("#(热)", "ali_058");
        bqV.put("#(加1)", "ali_059");
        bqV.put("#(压力)", "ali_060");
        bqV.put("#(表逼我)", "ali_061");
        bqV.put("#(人呢)", "ali_062");
        bqV.put("#(摇晃)", "ali_063");
        bqV.put("#(打地鼠)", "ali_064");
        bqV.put("#(这个屌)", "ali_065");
        bqV.put("#(恐慌)", "ali_066");
        bqV.put("#(晕乎乎)", "ali_067");
        bqV.put("#(浮云)", "ali_068");
        bqV.put("#(给力)", "ali_069");
        bqV.put("#(杯具了)", "ali_070");
        bqV.put("#(焦糖舞)", "yz_001");
        bqV.put("#(翻滚)", "yz_002");
        bqV.put("#(拍屁股做鬼脸)", "yz_003");
        bqV.put("#(不)", "yz_004");
        bqV.put("#(河蟹掉啦)", "yz_005");
        bqV.put("#(哦耶)", "yz_006");
        bqV.put("#(我倒)", "yz_007");
        bqV.put("#(投降)", "yz_008");
        bqV.put("#(微笑)", "b01");
        bqV.put("#(帅哥)", "b02");
        bqV.put("#(美女)", "b03");
        bqV.put("#(老大)", "b04");
        bqV.put("#(哈哈哈)", "b05");
        bqV.put("#(奸笑)", "b06");
        bqV.put("#(傻乐)", "b07");
        bqV.put("#(飞吻)", "b08");
        bqV.put("#(害羞)", "b09");
        bqV.put("#(花痴)", "b10");
        bqV.put("#(憧憬)", "b11");
        bqV.put("#(你牛)", "b12");
        bqV.put("#(鼓掌)", "b13");
        bqV.put("#(可爱)", "b14");
        bqV.put("#(太委屈)", "b15");
        bqV.put("#(大哭)", "b16");
        bqV.put("#(泪奔)", "b17");
        bqV.put("#(寻死)", "b18");
        bqV.put("#(非常惊讶)", "b19");
        bqV.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return bqV.get(str);
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
                        SpannableString a = a(cVar.EX(), name, str3);
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
        int eM = TbFaceManager.Ce().eM(str);
        if (eM != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst(), eM);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0049a fk = TbFaceManager.Ce().fk(str);
            if (fk != null) {
                int width = (int) (0.5d * fk.getWidth());
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
