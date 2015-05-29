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
    private static final HashMap<String, String> aZq = new HashMap<>();

    static {
        aZq.put("#(呵呵)", "image_emoticon");
        aZq.put("#(哈哈)", "image_emoticon2");
        aZq.put("#(吐舌)", "image_emoticon3");
        aZq.put("#(啊)", "image_emoticon4");
        aZq.put("#(啊?)", "image_emoticon4");
        aZq.put("#(酷)", "image_emoticon5");
        aZq.put("#(怒)", "image_emoticon6");
        aZq.put("#(开心)", "image_emoticon7");
        aZq.put("#(汗)", "image_emoticon8");
        aZq.put("#(泪)", "image_emoticon9");
        aZq.put("#(黑线)", "image_emoticon10");
        aZq.put("#(鄙视)", "image_emoticon11");
        aZq.put("#(不高兴)", "image_emoticon12");
        aZq.put("#(真棒)", "image_emoticon13");
        aZq.put("#(钱)", "image_emoticon14");
        aZq.put("#(疑问)", "image_emoticon15");
        aZq.put("#(阴险)", "image_emoticon16");
        aZq.put("#(吐)", "image_emoticon17");
        aZq.put("#(咦)", "image_emoticon18");
        aZq.put("#(咦?)", "image_emoticon18");
        aZq.put("#(委屈)", "image_emoticon19");
        aZq.put("#(花心)", "image_emoticon20");
        aZq.put("#(呼~)", "image_emoticon21");
        aZq.put("#(笑眼)", "image_emoticon22");
        aZq.put("#(冷)", "image_emoticon23");
        aZq.put("#(太开心)", "image_emoticon24");
        aZq.put("#(滑稽)", "image_emoticon25");
        aZq.put("#(勉强)", "image_emoticon26");
        aZq.put("#(狂汗)", "image_emoticon27");
        aZq.put("#(乖)", "image_emoticon28");
        aZq.put("#(睡觉)", "image_emoticon29");
        aZq.put("#(惊哭)", "image_emoticon30");
        aZq.put("#(升起)", "image_emoticon31");
        aZq.put("#(惊讶)", "image_emoticon32");
        aZq.put("#(喷)", "image_emoticon33");
        aZq.put("#(爱心)", "image_emoticon34");
        aZq.put("#(心碎)", "image_emoticon35");
        aZq.put("#(玫瑰)", "image_emoticon36");
        aZq.put("#(礼物)", "image_emoticon37");
        aZq.put("#(彩虹)", "image_emoticon38");
        aZq.put("#(星星月亮)", "image_emoticon39");
        aZq.put("#(太阳)", "image_emoticon40");
        aZq.put("#(钱币)", "image_emoticon41");
        aZq.put("#(灯泡)", "image_emoticon42");
        aZq.put("#(茶杯)", "image_emoticon43");
        aZq.put("#(蛋糕)", "image_emoticon44");
        aZq.put("#(音乐)", "image_emoticon45");
        aZq.put("#(haha)", "image_emoticon46");
        aZq.put("#(胜利)", "image_emoticon47");
        aZq.put("#(大拇指)", "image_emoticon48");
        aZq.put("#(弱)", "image_emoticon49");
        aZq.put("#(OK)", "image_emoticon50");
        aZq.put("#(赖皮)", "ali_001");
        aZq.put("#(感动)", "ali_002");
        aZq.put("#(十分惊讶)", "ali_003");
        aZq.put("#(怒气)", "ali_004");
        aZq.put("#(哭泣)", "ali_005");
        aZq.put("#(吃惊)", "ali_006");
        aZq.put("#(嘲弄)", "ali_007");
        aZq.put("#(飘过)", "ali_008");
        aZq.put("#(转圈哭)", "ali_009");
        aZq.put("#(神经病)", "ali_010");
        aZq.put("#(揪耳朵)", "ali_011");
        aZq.put("#(惊汗)", "ali_012");
        aZq.put("#(隐身)", "ali_013");
        aZq.put("#(不要嘛)", "ali_014");
        aZq.put("#(遁)", "ali_015");
        aZq.put("#(不公平)", "ali_016");
        aZq.put("#(爬来了)", "ali_017");
        aZq.put("#(蛋花哭)", "ali_018");
        aZq.put("#(温暖)", "ali_019");
        aZq.put("#(点头)", "ali_020");
        aZq.put("#(撒钱)", "ali_021");
        aZq.put("#(献花)", "ali_022");
        aZq.put("#(寒)", "ali_023");
        aZq.put("#(傻笑)", "ali_024");
        aZq.put("#(扭扭)", "ali_025");
        aZq.put("#(疯)", "ali_026");
        aZq.put("#(抓狂)", "ali_027");
        aZq.put("#(抓)", "ali_028");
        aZq.put("#(蜷)", "ali_029");
        aZq.put("#(挠墙)", "ali_030");
        aZq.put("#(狂笑)", "ali_031");
        aZq.put("#(抱枕)", "ali_032");
        aZq.put("#(吼叫)", "ali_033");
        aZq.put("#(嚷)", "ali_034");
        aZq.put("#(唠叨)", "ali_035");
        aZq.put("#(捏脸)", "ali_036");
        aZq.put("#(爆笑)", "ali_037");
        aZq.put("#(郁闷)", "ali_038");
        aZq.put("#(潜水)", "ali_039");
        aZq.put("#(十分开心)", "ali_040");
        aZq.put("#(冷笑话)", "ali_041");
        aZq.put("#(顶！)", "ali_042");
        aZq.put("#(潜)", "ali_043");
        aZq.put("#(画圈圈)", "ali_044");
        aZq.put("#(玩电脑)", "ali_045");
        aZq.put("#(狂吐)", "ali_046");
        aZq.put("#(哭着跑)", "ali_047");
        aZq.put("#(阿狸侠)", "ali_048");
        aZq.put("#(冷死了)", "ali_049");
        aZq.put("#(惆怅~)", "ali_050");
        aZq.put("#(摸头)", "ali_051");
        aZq.put("#(蹭)", "ali_052");
        aZq.put("#(打滚)", "ali_053");
        aZq.put("#(叩拜)", "ali_054");
        aZq.put("#(摸)", "ali_055");
        aZq.put("#(数钱)", "ali_056");
        aZq.put("#(拖走)", "ali_057");
        aZq.put("#(热)", "ali_058");
        aZq.put("#(加1)", "ali_059");
        aZq.put("#(压力)", "ali_060");
        aZq.put("#(表逼我)", "ali_061");
        aZq.put("#(人呢)", "ali_062");
        aZq.put("#(摇晃)", "ali_063");
        aZq.put("#(打地鼠)", "ali_064");
        aZq.put("#(这个屌)", "ali_065");
        aZq.put("#(恐慌)", "ali_066");
        aZq.put("#(晕乎乎)", "ali_067");
        aZq.put("#(浮云)", "ali_068");
        aZq.put("#(给力)", "ali_069");
        aZq.put("#(杯具了)", "ali_070");
        aZq.put("#(焦糖舞)", "yz_001");
        aZq.put("#(翻滚)", "yz_002");
        aZq.put("#(拍屁股做鬼脸)", "yz_003");
        aZq.put("#(不)", "yz_004");
        aZq.put("#(河蟹掉啦)", "yz_005");
        aZq.put("#(哦耶)", "yz_006");
        aZq.put("#(我倒)", "yz_007");
        aZq.put("#(投降)", "yz_008");
        aZq.put("#(微笑)", "b01");
        aZq.put("#(帅哥)", "b02");
        aZq.put("#(美女)", "b03");
        aZq.put("#(老大)", "b04");
        aZq.put("#(哈哈哈)", "b05");
        aZq.put("#(奸笑)", "b06");
        aZq.put("#(傻乐)", "b07");
        aZq.put("#(飞吻)", "b08");
        aZq.put("#(害羞)", "b09");
        aZq.put("#(花痴)", "b10");
        aZq.put("#(憧憬)", "b11");
        aZq.put("#(你牛)", "b12");
        aZq.put("#(鼓掌)", "b13");
        aZq.put("#(可爱)", "b14");
        aZq.put("#(太委屈)", "b15");
        aZq.put("#(大哭)", "b16");
        aZq.put("#(泪奔)", "b17");
        aZq.put("#(寻死)", "b18");
        aZq.put("#(非常惊讶)", "b19");
        aZq.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return aZq.get(str);
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
                        SpannableString a = a(cVar.Ep(), name, str3);
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
        int eu = TbFaceManager.Ak().eu(str);
        if (eu != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(TbadkCoreApplication.m411getInst(), eu);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            com.baidu.tbadk.imageManager.c eH = TbFaceManager.Ak().eH(str);
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
