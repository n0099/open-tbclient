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
    private static final HashMap<String, String> bqK = new HashMap<>();

    static {
        bqK.put("#(呵呵)", "image_emoticon");
        bqK.put("#(哈哈)", "image_emoticon2");
        bqK.put("#(吐舌)", "image_emoticon3");
        bqK.put("#(啊)", "image_emoticon4");
        bqK.put("#(啊?)", "image_emoticon4");
        bqK.put("#(酷)", "image_emoticon5");
        bqK.put("#(怒)", "image_emoticon6");
        bqK.put("#(开心)", "image_emoticon7");
        bqK.put("#(汗)", "image_emoticon8");
        bqK.put("#(泪)", "image_emoticon9");
        bqK.put("#(黑线)", "image_emoticon10");
        bqK.put("#(鄙视)", "image_emoticon11");
        bqK.put("#(不高兴)", "image_emoticon12");
        bqK.put("#(真棒)", "image_emoticon13");
        bqK.put("#(钱)", "image_emoticon14");
        bqK.put("#(疑问)", "image_emoticon15");
        bqK.put("#(阴险)", "image_emoticon16");
        bqK.put("#(吐)", "image_emoticon17");
        bqK.put("#(咦)", "image_emoticon18");
        bqK.put("#(咦?)", "image_emoticon18");
        bqK.put("#(委屈)", "image_emoticon19");
        bqK.put("#(花心)", "image_emoticon20");
        bqK.put("#(呼~)", "image_emoticon21");
        bqK.put("#(笑眼)", "image_emoticon22");
        bqK.put("#(冷)", "image_emoticon23");
        bqK.put("#(太开心)", "image_emoticon24");
        bqK.put("#(滑稽)", "image_emoticon25");
        bqK.put("#(勉强)", "image_emoticon26");
        bqK.put("#(狂汗)", "image_emoticon27");
        bqK.put("#(乖)", "image_emoticon28");
        bqK.put("#(睡觉)", "image_emoticon29");
        bqK.put("#(惊哭)", "image_emoticon30");
        bqK.put("#(升起)", "image_emoticon31");
        bqK.put("#(惊讶)", "image_emoticon32");
        bqK.put("#(喷)", "image_emoticon33");
        bqK.put("#(爱心)", "image_emoticon34");
        bqK.put("#(心碎)", "image_emoticon35");
        bqK.put("#(玫瑰)", "image_emoticon36");
        bqK.put("#(礼物)", "image_emoticon37");
        bqK.put("#(彩虹)", "image_emoticon38");
        bqK.put("#(星星月亮)", "image_emoticon39");
        bqK.put("#(太阳)", "image_emoticon40");
        bqK.put("#(钱币)", "image_emoticon41");
        bqK.put("#(灯泡)", "image_emoticon42");
        bqK.put("#(茶杯)", "image_emoticon43");
        bqK.put("#(蛋糕)", "image_emoticon44");
        bqK.put("#(音乐)", "image_emoticon45");
        bqK.put("#(haha)", "image_emoticon46");
        bqK.put("#(胜利)", "image_emoticon47");
        bqK.put("#(大拇指)", "image_emoticon48");
        bqK.put("#(弱)", "image_emoticon49");
        bqK.put("#(OK)", "image_emoticon50");
        bqK.put("#(赖皮)", "ali_001");
        bqK.put("#(感动)", "ali_002");
        bqK.put("#(十分惊讶)", "ali_003");
        bqK.put("#(怒气)", "ali_004");
        bqK.put("#(哭泣)", "ali_005");
        bqK.put("#(吃惊)", "ali_006");
        bqK.put("#(嘲弄)", "ali_007");
        bqK.put("#(飘过)", "ali_008");
        bqK.put("#(转圈哭)", "ali_009");
        bqK.put("#(神经病)", "ali_010");
        bqK.put("#(揪耳朵)", "ali_011");
        bqK.put("#(惊汗)", "ali_012");
        bqK.put("#(隐身)", "ali_013");
        bqK.put("#(不要嘛)", "ali_014");
        bqK.put("#(遁)", "ali_015");
        bqK.put("#(不公平)", "ali_016");
        bqK.put("#(爬来了)", "ali_017");
        bqK.put("#(蛋花哭)", "ali_018");
        bqK.put("#(温暖)", "ali_019");
        bqK.put("#(点头)", "ali_020");
        bqK.put("#(撒钱)", "ali_021");
        bqK.put("#(献花)", "ali_022");
        bqK.put("#(寒)", "ali_023");
        bqK.put("#(傻笑)", "ali_024");
        bqK.put("#(扭扭)", "ali_025");
        bqK.put("#(疯)", "ali_026");
        bqK.put("#(抓狂)", "ali_027");
        bqK.put("#(抓)", "ali_028");
        bqK.put("#(蜷)", "ali_029");
        bqK.put("#(挠墙)", "ali_030");
        bqK.put("#(狂笑)", "ali_031");
        bqK.put("#(抱枕)", "ali_032");
        bqK.put("#(吼叫)", "ali_033");
        bqK.put("#(嚷)", "ali_034");
        bqK.put("#(唠叨)", "ali_035");
        bqK.put("#(捏脸)", "ali_036");
        bqK.put("#(爆笑)", "ali_037");
        bqK.put("#(郁闷)", "ali_038");
        bqK.put("#(潜水)", "ali_039");
        bqK.put("#(十分开心)", "ali_040");
        bqK.put("#(冷笑话)", "ali_041");
        bqK.put("#(顶！)", "ali_042");
        bqK.put("#(潜)", "ali_043");
        bqK.put("#(画圈圈)", "ali_044");
        bqK.put("#(玩电脑)", "ali_045");
        bqK.put("#(狂吐)", "ali_046");
        bqK.put("#(哭着跑)", "ali_047");
        bqK.put("#(阿狸侠)", "ali_048");
        bqK.put("#(冷死了)", "ali_049");
        bqK.put("#(惆怅~)", "ali_050");
        bqK.put("#(摸头)", "ali_051");
        bqK.put("#(蹭)", "ali_052");
        bqK.put("#(打滚)", "ali_053");
        bqK.put("#(叩拜)", "ali_054");
        bqK.put("#(摸)", "ali_055");
        bqK.put("#(数钱)", "ali_056");
        bqK.put("#(拖走)", "ali_057");
        bqK.put("#(热)", "ali_058");
        bqK.put("#(加1)", "ali_059");
        bqK.put("#(压力)", "ali_060");
        bqK.put("#(表逼我)", "ali_061");
        bqK.put("#(人呢)", "ali_062");
        bqK.put("#(摇晃)", "ali_063");
        bqK.put("#(打地鼠)", "ali_064");
        bqK.put("#(这个屌)", "ali_065");
        bqK.put("#(恐慌)", "ali_066");
        bqK.put("#(晕乎乎)", "ali_067");
        bqK.put("#(浮云)", "ali_068");
        bqK.put("#(给力)", "ali_069");
        bqK.put("#(杯具了)", "ali_070");
        bqK.put("#(焦糖舞)", "yz_001");
        bqK.put("#(翻滚)", "yz_002");
        bqK.put("#(拍屁股做鬼脸)", "yz_003");
        bqK.put("#(不)", "yz_004");
        bqK.put("#(河蟹掉啦)", "yz_005");
        bqK.put("#(哦耶)", "yz_006");
        bqK.put("#(我倒)", "yz_007");
        bqK.put("#(投降)", "yz_008");
        bqK.put("#(微笑)", "b01");
        bqK.put("#(帅哥)", "b02");
        bqK.put("#(美女)", "b03");
        bqK.put("#(老大)", "b04");
        bqK.put("#(哈哈哈)", "b05");
        bqK.put("#(奸笑)", "b06");
        bqK.put("#(傻乐)", "b07");
        bqK.put("#(飞吻)", "b08");
        bqK.put("#(害羞)", "b09");
        bqK.put("#(花痴)", "b10");
        bqK.put("#(憧憬)", "b11");
        bqK.put("#(你牛)", "b12");
        bqK.put("#(鼓掌)", "b13");
        bqK.put("#(可爱)", "b14");
        bqK.put("#(太委屈)", "b15");
        bqK.put("#(大哭)", "b16");
        bqK.put("#(泪奔)", "b17");
        bqK.put("#(寻死)", "b18");
        bqK.put("#(非常惊讶)", "b19");
        bqK.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return bqK.get(str);
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
        return com.baidu.tbadk.core.util.ay.E(context, str);
    }
}
