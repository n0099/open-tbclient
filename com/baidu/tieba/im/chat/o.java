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
    private static final HashMap<String, String> bGF = new HashMap<>();

    static {
        bGF.put("#(呵呵)", "image_emoticon");
        bGF.put("#(哈哈)", "image_emoticon2");
        bGF.put("#(吐舌)", "image_emoticon3");
        bGF.put("#(啊)", "image_emoticon4");
        bGF.put("#(啊?)", "image_emoticon4");
        bGF.put("#(酷)", "image_emoticon5");
        bGF.put("#(怒)", "image_emoticon6");
        bGF.put("#(开心)", "image_emoticon7");
        bGF.put("#(汗)", "image_emoticon8");
        bGF.put("#(泪)", "image_emoticon9");
        bGF.put("#(黑线)", "image_emoticon10");
        bGF.put("#(鄙视)", "image_emoticon11");
        bGF.put("#(不高兴)", "image_emoticon12");
        bGF.put("#(真棒)", "image_emoticon13");
        bGF.put("#(钱)", "image_emoticon14");
        bGF.put("#(疑问)", "image_emoticon15");
        bGF.put("#(阴险)", "image_emoticon16");
        bGF.put("#(吐)", "image_emoticon17");
        bGF.put("#(咦)", "image_emoticon18");
        bGF.put("#(咦?)", "image_emoticon18");
        bGF.put("#(委屈)", "image_emoticon19");
        bGF.put("#(花心)", "image_emoticon20");
        bGF.put("#(呼~)", "image_emoticon21");
        bGF.put("#(笑眼)", "image_emoticon22");
        bGF.put("#(冷)", "image_emoticon23");
        bGF.put("#(太开心)", "image_emoticon24");
        bGF.put("#(滑稽)", "image_emoticon25");
        bGF.put("#(勉强)", "image_emoticon26");
        bGF.put("#(狂汗)", "image_emoticon27");
        bGF.put("#(乖)", "image_emoticon28");
        bGF.put("#(睡觉)", "image_emoticon29");
        bGF.put("#(惊哭)", "image_emoticon30");
        bGF.put("#(升起)", "image_emoticon31");
        bGF.put("#(惊讶)", "image_emoticon32");
        bGF.put("#(喷)", "image_emoticon33");
        bGF.put("#(爱心)", "image_emoticon34");
        bGF.put("#(心碎)", "image_emoticon35");
        bGF.put("#(玫瑰)", "image_emoticon36");
        bGF.put("#(礼物)", "image_emoticon37");
        bGF.put("#(彩虹)", "image_emoticon38");
        bGF.put("#(星星月亮)", "image_emoticon39");
        bGF.put("#(太阳)", "image_emoticon40");
        bGF.put("#(钱币)", "image_emoticon41");
        bGF.put("#(灯泡)", "image_emoticon42");
        bGF.put("#(茶杯)", "image_emoticon43");
        bGF.put("#(蛋糕)", "image_emoticon44");
        bGF.put("#(音乐)", "image_emoticon45");
        bGF.put("#(haha)", "image_emoticon46");
        bGF.put("#(胜利)", "image_emoticon47");
        bGF.put("#(大拇指)", "image_emoticon48");
        bGF.put("#(弱)", "image_emoticon49");
        bGF.put("#(OK)", "image_emoticon50");
        bGF.put("#(哼)", "image_emoticon61");
        bGF.put("#(赖皮)", "ali_001");
        bGF.put("#(感动)", "ali_002");
        bGF.put("#(十分惊讶)", "ali_003");
        bGF.put("#(怒气)", "ali_004");
        bGF.put("#(哭泣)", "ali_005");
        bGF.put("#(吃惊)", "ali_006");
        bGF.put("#(嘲弄)", "ali_007");
        bGF.put("#(飘过)", "ali_008");
        bGF.put("#(转圈哭)", "ali_009");
        bGF.put("#(神经病)", "ali_010");
        bGF.put("#(揪耳朵)", "ali_011");
        bGF.put("#(惊汗)", "ali_012");
        bGF.put("#(隐身)", "ali_013");
        bGF.put("#(不要嘛)", "ali_014");
        bGF.put("#(遁)", "ali_015");
        bGF.put("#(不公平)", "ali_016");
        bGF.put("#(爬来了)", "ali_017");
        bGF.put("#(蛋花哭)", "ali_018");
        bGF.put("#(温暖)", "ali_019");
        bGF.put("#(点头)", "ali_020");
        bGF.put("#(撒钱)", "ali_021");
        bGF.put("#(献花)", "ali_022");
        bGF.put("#(寒)", "ali_023");
        bGF.put("#(傻笑)", "ali_024");
        bGF.put("#(扭扭)", "ali_025");
        bGF.put("#(疯)", "ali_026");
        bGF.put("#(抓狂)", "ali_027");
        bGF.put("#(抓)", "ali_028");
        bGF.put("#(蜷)", "ali_029");
        bGF.put("#(挠墙)", "ali_030");
        bGF.put("#(狂笑)", "ali_031");
        bGF.put("#(抱枕)", "ali_032");
        bGF.put("#(吼叫)", "ali_033");
        bGF.put("#(嚷)", "ali_034");
        bGF.put("#(唠叨)", "ali_035");
        bGF.put("#(捏脸)", "ali_036");
        bGF.put("#(爆笑)", "ali_037");
        bGF.put("#(郁闷)", "ali_038");
        bGF.put("#(潜水)", "ali_039");
        bGF.put("#(十分开心)", "ali_040");
        bGF.put("#(冷笑话)", "ali_041");
        bGF.put("#(顶！)", "ali_042");
        bGF.put("#(潜)", "ali_043");
        bGF.put("#(画圈圈)", "ali_044");
        bGF.put("#(玩电脑)", "ali_045");
        bGF.put("#(狂吐)", "ali_046");
        bGF.put("#(哭着跑)", "ali_047");
        bGF.put("#(阿狸侠)", "ali_048");
        bGF.put("#(冷死了)", "ali_049");
        bGF.put("#(惆怅~)", "ali_050");
        bGF.put("#(摸头)", "ali_051");
        bGF.put("#(蹭)", "ali_052");
        bGF.put("#(打滚)", "ali_053");
        bGF.put("#(叩拜)", "ali_054");
        bGF.put("#(摸)", "ali_055");
        bGF.put("#(数钱)", "ali_056");
        bGF.put("#(拖走)", "ali_057");
        bGF.put("#(热)", "ali_058");
        bGF.put("#(加1)", "ali_059");
        bGF.put("#(压力)", "ali_060");
        bGF.put("#(表逼我)", "ali_061");
        bGF.put("#(人呢)", "ali_062");
        bGF.put("#(摇晃)", "ali_063");
        bGF.put("#(打地鼠)", "ali_064");
        bGF.put("#(这个屌)", "ali_065");
        bGF.put("#(恐慌)", "ali_066");
        bGF.put("#(晕乎乎)", "ali_067");
        bGF.put("#(浮云)", "ali_068");
        bGF.put("#(给力)", "ali_069");
        bGF.put("#(杯具了)", "ali_070");
        bGF.put("#(焦糖舞)", "yz_001");
        bGF.put("#(翻滚)", "yz_002");
        bGF.put("#(拍屁股做鬼脸)", "yz_003");
        bGF.put("#(不)", "yz_004");
        bGF.put("#(河蟹掉啦)", "yz_005");
        bGF.put("#(哦耶)", "yz_006");
        bGF.put("#(我倒)", "yz_007");
        bGF.put("#(投降)", "yz_008");
        bGF.put("#(微笑)", "b01");
        bGF.put("#(帅哥)", "b02");
        bGF.put("#(美女)", "b03");
        bGF.put("#(老大)", "b04");
        bGF.put("#(哈哈哈)", "b05");
        bGF.put("#(奸笑)", "b06");
        bGF.put("#(傻乐)", "b07");
        bGF.put("#(飞吻)", "b08");
        bGF.put("#(害羞)", "b09");
        bGF.put("#(花痴)", "b10");
        bGF.put("#(憧憬)", "b11");
        bGF.put("#(你牛)", "b12");
        bGF.put("#(鼓掌)", "b13");
        bGF.put("#(可爱)", "b14");
        bGF.put("#(太委屈)", "b15");
        bGF.put("#(大哭)", "b16");
        bGF.put("#(泪奔)", "b17");
        bGF.put("#(寻死)", "b18");
        bGF.put("#(非常惊讶)", "b19");
        bGF.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return bGF.get(str);
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
                        SpannableString a = a(cVar.FP(), name, str3);
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
        int fa = TbFaceManager.CW().fa(str);
        if (fa != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst(), fa);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0051a fB = TbFaceManager.CW().fB(str);
            if (fB != null) {
                int width = (int) (0.5d * fB.getWidth());
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
        return com.baidu.tbadk.core.util.bf.E(context, str);
    }
}
