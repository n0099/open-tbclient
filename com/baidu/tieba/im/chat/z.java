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
    private static final HashMap<String, String> aWu = new HashMap<>();

    static {
        aWu.put("#(呵呵)", "image_emoticon");
        aWu.put("#(哈哈)", "image_emoticon2");
        aWu.put("#(吐舌)", "image_emoticon3");
        aWu.put("#(啊)", "image_emoticon4");
        aWu.put("#(啊?)", "image_emoticon4");
        aWu.put("#(酷)", "image_emoticon5");
        aWu.put("#(怒)", "image_emoticon6");
        aWu.put("#(开心)", "image_emoticon7");
        aWu.put("#(汗)", "image_emoticon8");
        aWu.put("#(泪)", "image_emoticon9");
        aWu.put("#(黑线)", "image_emoticon10");
        aWu.put("#(鄙视)", "image_emoticon11");
        aWu.put("#(不高兴)", "image_emoticon12");
        aWu.put("#(真棒)", "image_emoticon13");
        aWu.put("#(钱)", "image_emoticon14");
        aWu.put("#(疑问)", "image_emoticon15");
        aWu.put("#(阴险)", "image_emoticon16");
        aWu.put("#(吐)", "image_emoticon17");
        aWu.put("#(咦)", "image_emoticon18");
        aWu.put("#(咦?)", "image_emoticon18");
        aWu.put("#(委屈)", "image_emoticon19");
        aWu.put("#(花心)", "image_emoticon20");
        aWu.put("#(呼~)", "image_emoticon21");
        aWu.put("#(笑眼)", "image_emoticon22");
        aWu.put("#(冷)", "image_emoticon23");
        aWu.put("#(太开心)", "image_emoticon24");
        aWu.put("#(滑稽)", "image_emoticon25");
        aWu.put("#(勉强)", "image_emoticon26");
        aWu.put("#(狂汗)", "image_emoticon27");
        aWu.put("#(乖)", "image_emoticon28");
        aWu.put("#(睡觉)", "image_emoticon29");
        aWu.put("#(惊哭)", "image_emoticon30");
        aWu.put("#(升起)", "image_emoticon31");
        aWu.put("#(惊讶)", "image_emoticon32");
        aWu.put("#(喷)", "image_emoticon33");
        aWu.put("#(爱心)", "image_emoticon34");
        aWu.put("#(心碎)", "image_emoticon35");
        aWu.put("#(玫瑰)", "image_emoticon36");
        aWu.put("#(礼物)", "image_emoticon37");
        aWu.put("#(彩虹)", "image_emoticon38");
        aWu.put("#(星星月亮)", "image_emoticon39");
        aWu.put("#(太阳)", "image_emoticon40");
        aWu.put("#(钱币)", "image_emoticon41");
        aWu.put("#(灯泡)", "image_emoticon42");
        aWu.put("#(茶杯)", "image_emoticon43");
        aWu.put("#(蛋糕)", "image_emoticon44");
        aWu.put("#(音乐)", "image_emoticon45");
        aWu.put("#(haha)", "image_emoticon46");
        aWu.put("#(胜利)", "image_emoticon47");
        aWu.put("#(大拇指)", "image_emoticon48");
        aWu.put("#(弱)", "image_emoticon49");
        aWu.put("#(OK)", "image_emoticon50");
        aWu.put("#(赖皮)", "ali_001");
        aWu.put("#(感动)", "ali_002");
        aWu.put("#(十分惊讶)", "ali_003");
        aWu.put("#(怒气)", "ali_004");
        aWu.put("#(哭泣)", "ali_005");
        aWu.put("#(吃惊)", "ali_006");
        aWu.put("#(嘲弄)", "ali_007");
        aWu.put("#(飘过)", "ali_008");
        aWu.put("#(转圈哭)", "ali_009");
        aWu.put("#(神经病)", "ali_010");
        aWu.put("#(揪耳朵)", "ali_011");
        aWu.put("#(惊汗)", "ali_012");
        aWu.put("#(隐身)", "ali_013");
        aWu.put("#(不要嘛)", "ali_014");
        aWu.put("#(遁)", "ali_015");
        aWu.put("#(不公平)", "ali_016");
        aWu.put("#(爬来了)", "ali_017");
        aWu.put("#(蛋花哭)", "ali_018");
        aWu.put("#(温暖)", "ali_019");
        aWu.put("#(点头)", "ali_020");
        aWu.put("#(撒钱)", "ali_021");
        aWu.put("#(献花)", "ali_022");
        aWu.put("#(寒)", "ali_023");
        aWu.put("#(傻笑)", "ali_024");
        aWu.put("#(扭扭)", "ali_025");
        aWu.put("#(疯)", "ali_026");
        aWu.put("#(抓狂)", "ali_027");
        aWu.put("#(抓)", "ali_028");
        aWu.put("#(蜷)", "ali_029");
        aWu.put("#(挠墙)", "ali_030");
        aWu.put("#(狂笑)", "ali_031");
        aWu.put("#(抱枕)", "ali_032");
        aWu.put("#(吼叫)", "ali_033");
        aWu.put("#(嚷)", "ali_034");
        aWu.put("#(唠叨)", "ali_035");
        aWu.put("#(捏脸)", "ali_036");
        aWu.put("#(爆笑)", "ali_037");
        aWu.put("#(郁闷)", "ali_038");
        aWu.put("#(潜水)", "ali_039");
        aWu.put("#(十分开心)", "ali_040");
        aWu.put("#(冷笑话)", "ali_041");
        aWu.put("#(顶！)", "ali_042");
        aWu.put("#(潜)", "ali_043");
        aWu.put("#(画圈圈)", "ali_044");
        aWu.put("#(玩电脑)", "ali_045");
        aWu.put("#(狂吐)", "ali_046");
        aWu.put("#(哭着跑)", "ali_047");
        aWu.put("#(阿狸侠)", "ali_048");
        aWu.put("#(冷死了)", "ali_049");
        aWu.put("#(惆怅~)", "ali_050");
        aWu.put("#(摸头)", "ali_051");
        aWu.put("#(蹭)", "ali_052");
        aWu.put("#(打滚)", "ali_053");
        aWu.put("#(叩拜)", "ali_054");
        aWu.put("#(摸)", "ali_055");
        aWu.put("#(数钱)", "ali_056");
        aWu.put("#(拖走)", "ali_057");
        aWu.put("#(热)", "ali_058");
        aWu.put("#(加1)", "ali_059");
        aWu.put("#(压力)", "ali_060");
        aWu.put("#(表逼我)", "ali_061");
        aWu.put("#(人呢)", "ali_062");
        aWu.put("#(摇晃)", "ali_063");
        aWu.put("#(打地鼠)", "ali_064");
        aWu.put("#(这个屌)", "ali_065");
        aWu.put("#(恐慌)", "ali_066");
        aWu.put("#(晕乎乎)", "ali_067");
        aWu.put("#(浮云)", "ali_068");
        aWu.put("#(给力)", "ali_069");
        aWu.put("#(杯具了)", "ali_070");
        aWu.put("#(焦糖舞)", "yz_001");
        aWu.put("#(翻滚)", "yz_002");
        aWu.put("#(拍屁股做鬼脸)", "yz_003");
        aWu.put("#(不)", "yz_004");
        aWu.put("#(河蟹掉啦)", "yz_005");
        aWu.put("#(哦耶)", "yz_006");
        aWu.put("#(我倒)", "yz_007");
        aWu.put("#(投降)", "yz_008");
        aWu.put("#(微笑)", "b01");
        aWu.put("#(帅哥)", "b02");
        aWu.put("#(美女)", "b03");
        aWu.put("#(老大)", "b04");
        aWu.put("#(哈哈哈)", "b05");
        aWu.put("#(奸笑)", "b06");
        aWu.put("#(傻乐)", "b07");
        aWu.put("#(飞吻)", "b08");
        aWu.put("#(害羞)", "b09");
        aWu.put("#(花痴)", "b10");
        aWu.put("#(憧憬)", "b11");
        aWu.put("#(你牛)", "b12");
        aWu.put("#(鼓掌)", "b13");
        aWu.put("#(可爱)", "b14");
        aWu.put("#(太委屈)", "b15");
        aWu.put("#(大哭)", "b16");
        aWu.put("#(泪奔)", "b17");
        aWu.put("#(寻死)", "b18");
        aWu.put("#(非常惊讶)", "b19");
        aWu.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return aWu.get(str);
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
                        SpannableString a = a(cVar.Dz(), name, str3);
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

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.f> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int ea = TbFaceManager.zr().ea(str);
        if (ea != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(TbadkCoreApplication.m411getInst(), ea);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            com.baidu.tbadk.imageManager.c en = TbFaceManager.zr().en(str);
            if (en != null) {
                int width = (int) (0.5d * en.getWidth());
                fVar.setBounds(new Rect(0, 0, width, width));
            } else {
                fVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(fVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString K(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.bk.C(context, str);
    }
}
