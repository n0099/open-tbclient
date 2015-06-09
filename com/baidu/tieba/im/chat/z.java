package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class z {
    private static final HashMap<String, String> aZr = new HashMap<>();

    static {
        aZr.put("#(呵呵)", "image_emoticon");
        aZr.put("#(哈哈)", "image_emoticon2");
        aZr.put("#(吐舌)", "image_emoticon3");
        aZr.put("#(啊)", "image_emoticon4");
        aZr.put("#(啊?)", "image_emoticon4");
        aZr.put("#(酷)", "image_emoticon5");
        aZr.put("#(怒)", "image_emoticon6");
        aZr.put("#(开心)", "image_emoticon7");
        aZr.put("#(汗)", "image_emoticon8");
        aZr.put("#(泪)", "image_emoticon9");
        aZr.put("#(黑线)", "image_emoticon10");
        aZr.put("#(鄙视)", "image_emoticon11");
        aZr.put("#(不高兴)", "image_emoticon12");
        aZr.put("#(真棒)", "image_emoticon13");
        aZr.put("#(钱)", "image_emoticon14");
        aZr.put("#(疑问)", "image_emoticon15");
        aZr.put("#(阴险)", "image_emoticon16");
        aZr.put("#(吐)", "image_emoticon17");
        aZr.put("#(咦)", "image_emoticon18");
        aZr.put("#(咦?)", "image_emoticon18");
        aZr.put("#(委屈)", "image_emoticon19");
        aZr.put("#(花心)", "image_emoticon20");
        aZr.put("#(呼~)", "image_emoticon21");
        aZr.put("#(笑眼)", "image_emoticon22");
        aZr.put("#(冷)", "image_emoticon23");
        aZr.put("#(太开心)", "image_emoticon24");
        aZr.put("#(滑稽)", "image_emoticon25");
        aZr.put("#(勉强)", "image_emoticon26");
        aZr.put("#(狂汗)", "image_emoticon27");
        aZr.put("#(乖)", "image_emoticon28");
        aZr.put("#(睡觉)", "image_emoticon29");
        aZr.put("#(惊哭)", "image_emoticon30");
        aZr.put("#(升起)", "image_emoticon31");
        aZr.put("#(惊讶)", "image_emoticon32");
        aZr.put("#(喷)", "image_emoticon33");
        aZr.put("#(爱心)", "image_emoticon34");
        aZr.put("#(心碎)", "image_emoticon35");
        aZr.put("#(玫瑰)", "image_emoticon36");
        aZr.put("#(礼物)", "image_emoticon37");
        aZr.put("#(彩虹)", "image_emoticon38");
        aZr.put("#(星星月亮)", "image_emoticon39");
        aZr.put("#(太阳)", "image_emoticon40");
        aZr.put("#(钱币)", "image_emoticon41");
        aZr.put("#(灯泡)", "image_emoticon42");
        aZr.put("#(茶杯)", "image_emoticon43");
        aZr.put("#(蛋糕)", "image_emoticon44");
        aZr.put("#(音乐)", "image_emoticon45");
        aZr.put("#(haha)", "image_emoticon46");
        aZr.put("#(胜利)", "image_emoticon47");
        aZr.put("#(大拇指)", "image_emoticon48");
        aZr.put("#(弱)", "image_emoticon49");
        aZr.put("#(OK)", "image_emoticon50");
        aZr.put("#(赖皮)", "ali_001");
        aZr.put("#(感动)", "ali_002");
        aZr.put("#(十分惊讶)", "ali_003");
        aZr.put("#(怒气)", "ali_004");
        aZr.put("#(哭泣)", "ali_005");
        aZr.put("#(吃惊)", "ali_006");
        aZr.put("#(嘲弄)", "ali_007");
        aZr.put("#(飘过)", "ali_008");
        aZr.put("#(转圈哭)", "ali_009");
        aZr.put("#(神经病)", "ali_010");
        aZr.put("#(揪耳朵)", "ali_011");
        aZr.put("#(惊汗)", "ali_012");
        aZr.put("#(隐身)", "ali_013");
        aZr.put("#(不要嘛)", "ali_014");
        aZr.put("#(遁)", "ali_015");
        aZr.put("#(不公平)", "ali_016");
        aZr.put("#(爬来了)", "ali_017");
        aZr.put("#(蛋花哭)", "ali_018");
        aZr.put("#(温暖)", "ali_019");
        aZr.put("#(点头)", "ali_020");
        aZr.put("#(撒钱)", "ali_021");
        aZr.put("#(献花)", "ali_022");
        aZr.put("#(寒)", "ali_023");
        aZr.put("#(傻笑)", "ali_024");
        aZr.put("#(扭扭)", "ali_025");
        aZr.put("#(疯)", "ali_026");
        aZr.put("#(抓狂)", "ali_027");
        aZr.put("#(抓)", "ali_028");
        aZr.put("#(蜷)", "ali_029");
        aZr.put("#(挠墙)", "ali_030");
        aZr.put("#(狂笑)", "ali_031");
        aZr.put("#(抱枕)", "ali_032");
        aZr.put("#(吼叫)", "ali_033");
        aZr.put("#(嚷)", "ali_034");
        aZr.put("#(唠叨)", "ali_035");
        aZr.put("#(捏脸)", "ali_036");
        aZr.put("#(爆笑)", "ali_037");
        aZr.put("#(郁闷)", "ali_038");
        aZr.put("#(潜水)", "ali_039");
        aZr.put("#(十分开心)", "ali_040");
        aZr.put("#(冷笑话)", "ali_041");
        aZr.put("#(顶！)", "ali_042");
        aZr.put("#(潜)", "ali_043");
        aZr.put("#(画圈圈)", "ali_044");
        aZr.put("#(玩电脑)", "ali_045");
        aZr.put("#(狂吐)", "ali_046");
        aZr.put("#(哭着跑)", "ali_047");
        aZr.put("#(阿狸侠)", "ali_048");
        aZr.put("#(冷死了)", "ali_049");
        aZr.put("#(惆怅~)", "ali_050");
        aZr.put("#(摸头)", "ali_051");
        aZr.put("#(蹭)", "ali_052");
        aZr.put("#(打滚)", "ali_053");
        aZr.put("#(叩拜)", "ali_054");
        aZr.put("#(摸)", "ali_055");
        aZr.put("#(数钱)", "ali_056");
        aZr.put("#(拖走)", "ali_057");
        aZr.put("#(热)", "ali_058");
        aZr.put("#(加1)", "ali_059");
        aZr.put("#(压力)", "ali_060");
        aZr.put("#(表逼我)", "ali_061");
        aZr.put("#(人呢)", "ali_062");
        aZr.put("#(摇晃)", "ali_063");
        aZr.put("#(打地鼠)", "ali_064");
        aZr.put("#(这个屌)", "ali_065");
        aZr.put("#(恐慌)", "ali_066");
        aZr.put("#(晕乎乎)", "ali_067");
        aZr.put("#(浮云)", "ali_068");
        aZr.put("#(给力)", "ali_069");
        aZr.put("#(杯具了)", "ali_070");
        aZr.put("#(焦糖舞)", "yz_001");
        aZr.put("#(翻滚)", "yz_002");
        aZr.put("#(拍屁股做鬼脸)", "yz_003");
        aZr.put("#(不)", "yz_004");
        aZr.put("#(河蟹掉啦)", "yz_005");
        aZr.put("#(哦耶)", "yz_006");
        aZr.put("#(我倒)", "yz_007");
        aZr.put("#(投降)", "yz_008");
        aZr.put("#(微笑)", "b01");
        aZr.put("#(帅哥)", "b02");
        aZr.put("#(美女)", "b03");
        aZr.put("#(老大)", "b04");
        aZr.put("#(哈哈哈)", "b05");
        aZr.put("#(奸笑)", "b06");
        aZr.put("#(傻乐)", "b07");
        aZr.put("#(飞吻)", "b08");
        aZr.put("#(害羞)", "b09");
        aZr.put("#(花痴)", "b10");
        aZr.put("#(憧憬)", "b11");
        aZr.put("#(你牛)", "b12");
        aZr.put("#(鼓掌)", "b13");
        aZr.put("#(可爱)", "b14");
        aZr.put("#(太委屈)", "b15");
        aZr.put("#(大哭)", "b16");
        aZr.put("#(泪奔)", "b17");
        aZr.put("#(寻死)", "b18");
        aZr.put("#(非常惊讶)", "b19");
        aZr.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return aZr.get(str);
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
                                SpannableString M = M(context, str2);
                                if (M != null) {
                                    cVar.append(M);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(cVar.Eq(), name, str3);
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
                    SpannableString M2 = M(context, str2);
                    if (M2 != null) {
                        cVar.append(M2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.f> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int eu = TbFaceManager.Al().eu(str);
        if (eu != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(TbadkCoreApplication.m411getInst(), eu);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            com.baidu.tbadk.imageManager.c eH = TbFaceManager.Al().eH(str);
            if (eH != null) {
                int width = (int) (0.5d * eH.getWidth());
                fVar.setBounds(new Rect(0, 0, width, width));
            } else {
                fVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(fVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString M(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.bi.C(context, str);
    }
}
