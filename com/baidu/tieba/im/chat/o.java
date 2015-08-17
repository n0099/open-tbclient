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
    private static final HashMap<String, String> bnn = new HashMap<>();

    static {
        bnn.put("#(呵呵)", "image_emoticon");
        bnn.put("#(哈哈)", "image_emoticon2");
        bnn.put("#(吐舌)", "image_emoticon3");
        bnn.put("#(啊)", "image_emoticon4");
        bnn.put("#(啊?)", "image_emoticon4");
        bnn.put("#(酷)", "image_emoticon5");
        bnn.put("#(怒)", "image_emoticon6");
        bnn.put("#(开心)", "image_emoticon7");
        bnn.put("#(汗)", "image_emoticon8");
        bnn.put("#(泪)", "image_emoticon9");
        bnn.put("#(黑线)", "image_emoticon10");
        bnn.put("#(鄙视)", "image_emoticon11");
        bnn.put("#(不高兴)", "image_emoticon12");
        bnn.put("#(真棒)", "image_emoticon13");
        bnn.put("#(钱)", "image_emoticon14");
        bnn.put("#(疑问)", "image_emoticon15");
        bnn.put("#(阴险)", "image_emoticon16");
        bnn.put("#(吐)", "image_emoticon17");
        bnn.put("#(咦)", "image_emoticon18");
        bnn.put("#(咦?)", "image_emoticon18");
        bnn.put("#(委屈)", "image_emoticon19");
        bnn.put("#(花心)", "image_emoticon20");
        bnn.put("#(呼~)", "image_emoticon21");
        bnn.put("#(笑眼)", "image_emoticon22");
        bnn.put("#(冷)", "image_emoticon23");
        bnn.put("#(太开心)", "image_emoticon24");
        bnn.put("#(滑稽)", "image_emoticon25");
        bnn.put("#(勉强)", "image_emoticon26");
        bnn.put("#(狂汗)", "image_emoticon27");
        bnn.put("#(乖)", "image_emoticon28");
        bnn.put("#(睡觉)", "image_emoticon29");
        bnn.put("#(惊哭)", "image_emoticon30");
        bnn.put("#(升起)", "image_emoticon31");
        bnn.put("#(惊讶)", "image_emoticon32");
        bnn.put("#(喷)", "image_emoticon33");
        bnn.put("#(爱心)", "image_emoticon34");
        bnn.put("#(心碎)", "image_emoticon35");
        bnn.put("#(玫瑰)", "image_emoticon36");
        bnn.put("#(礼物)", "image_emoticon37");
        bnn.put("#(彩虹)", "image_emoticon38");
        bnn.put("#(星星月亮)", "image_emoticon39");
        bnn.put("#(太阳)", "image_emoticon40");
        bnn.put("#(钱币)", "image_emoticon41");
        bnn.put("#(灯泡)", "image_emoticon42");
        bnn.put("#(茶杯)", "image_emoticon43");
        bnn.put("#(蛋糕)", "image_emoticon44");
        bnn.put("#(音乐)", "image_emoticon45");
        bnn.put("#(haha)", "image_emoticon46");
        bnn.put("#(胜利)", "image_emoticon47");
        bnn.put("#(大拇指)", "image_emoticon48");
        bnn.put("#(弱)", "image_emoticon49");
        bnn.put("#(OK)", "image_emoticon50");
        bnn.put("#(赖皮)", "ali_001");
        bnn.put("#(感动)", "ali_002");
        bnn.put("#(十分惊讶)", "ali_003");
        bnn.put("#(怒气)", "ali_004");
        bnn.put("#(哭泣)", "ali_005");
        bnn.put("#(吃惊)", "ali_006");
        bnn.put("#(嘲弄)", "ali_007");
        bnn.put("#(飘过)", "ali_008");
        bnn.put("#(转圈哭)", "ali_009");
        bnn.put("#(神经病)", "ali_010");
        bnn.put("#(揪耳朵)", "ali_011");
        bnn.put("#(惊汗)", "ali_012");
        bnn.put("#(隐身)", "ali_013");
        bnn.put("#(不要嘛)", "ali_014");
        bnn.put("#(遁)", "ali_015");
        bnn.put("#(不公平)", "ali_016");
        bnn.put("#(爬来了)", "ali_017");
        bnn.put("#(蛋花哭)", "ali_018");
        bnn.put("#(温暖)", "ali_019");
        bnn.put("#(点头)", "ali_020");
        bnn.put("#(撒钱)", "ali_021");
        bnn.put("#(献花)", "ali_022");
        bnn.put("#(寒)", "ali_023");
        bnn.put("#(傻笑)", "ali_024");
        bnn.put("#(扭扭)", "ali_025");
        bnn.put("#(疯)", "ali_026");
        bnn.put("#(抓狂)", "ali_027");
        bnn.put("#(抓)", "ali_028");
        bnn.put("#(蜷)", "ali_029");
        bnn.put("#(挠墙)", "ali_030");
        bnn.put("#(狂笑)", "ali_031");
        bnn.put("#(抱枕)", "ali_032");
        bnn.put("#(吼叫)", "ali_033");
        bnn.put("#(嚷)", "ali_034");
        bnn.put("#(唠叨)", "ali_035");
        bnn.put("#(捏脸)", "ali_036");
        bnn.put("#(爆笑)", "ali_037");
        bnn.put("#(郁闷)", "ali_038");
        bnn.put("#(潜水)", "ali_039");
        bnn.put("#(十分开心)", "ali_040");
        bnn.put("#(冷笑话)", "ali_041");
        bnn.put("#(顶！)", "ali_042");
        bnn.put("#(潜)", "ali_043");
        bnn.put("#(画圈圈)", "ali_044");
        bnn.put("#(玩电脑)", "ali_045");
        bnn.put("#(狂吐)", "ali_046");
        bnn.put("#(哭着跑)", "ali_047");
        bnn.put("#(阿狸侠)", "ali_048");
        bnn.put("#(冷死了)", "ali_049");
        bnn.put("#(惆怅~)", "ali_050");
        bnn.put("#(摸头)", "ali_051");
        bnn.put("#(蹭)", "ali_052");
        bnn.put("#(打滚)", "ali_053");
        bnn.put("#(叩拜)", "ali_054");
        bnn.put("#(摸)", "ali_055");
        bnn.put("#(数钱)", "ali_056");
        bnn.put("#(拖走)", "ali_057");
        bnn.put("#(热)", "ali_058");
        bnn.put("#(加1)", "ali_059");
        bnn.put("#(压力)", "ali_060");
        bnn.put("#(表逼我)", "ali_061");
        bnn.put("#(人呢)", "ali_062");
        bnn.put("#(摇晃)", "ali_063");
        bnn.put("#(打地鼠)", "ali_064");
        bnn.put("#(这个屌)", "ali_065");
        bnn.put("#(恐慌)", "ali_066");
        bnn.put("#(晕乎乎)", "ali_067");
        bnn.put("#(浮云)", "ali_068");
        bnn.put("#(给力)", "ali_069");
        bnn.put("#(杯具了)", "ali_070");
        bnn.put("#(焦糖舞)", "yz_001");
        bnn.put("#(翻滚)", "yz_002");
        bnn.put("#(拍屁股做鬼脸)", "yz_003");
        bnn.put("#(不)", "yz_004");
        bnn.put("#(河蟹掉啦)", "yz_005");
        bnn.put("#(哦耶)", "yz_006");
        bnn.put("#(我倒)", "yz_007");
        bnn.put("#(投降)", "yz_008");
        bnn.put("#(微笑)", "b01");
        bnn.put("#(帅哥)", "b02");
        bnn.put("#(美女)", "b03");
        bnn.put("#(老大)", "b04");
        bnn.put("#(哈哈哈)", "b05");
        bnn.put("#(奸笑)", "b06");
        bnn.put("#(傻乐)", "b07");
        bnn.put("#(飞吻)", "b08");
        bnn.put("#(害羞)", "b09");
        bnn.put("#(花痴)", "b10");
        bnn.put("#(憧憬)", "b11");
        bnn.put("#(你牛)", "b12");
        bnn.put("#(鼓掌)", "b13");
        bnn.put("#(可爱)", "b14");
        bnn.put("#(太委屈)", "b15");
        bnn.put("#(大哭)", "b16");
        bnn.put("#(泪奔)", "b17");
        bnn.put("#(寻死)", "b18");
        bnn.put("#(非常惊讶)", "b19");
        bnn.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return bnn.get(str);
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
                                SpannableString O = O(context, str2);
                                if (O != null) {
                                    cVar.append(O);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(cVar.Fa(), name, str3);
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
                    SpannableString O2 = O(context, str2);
                    if (O2 != null) {
                        cVar.append(O2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.e> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int ez = TbFaceManager.Cd().ez(str);
        if (ez != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst(), ez);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0049a eX = TbFaceManager.Cd().eX(str);
            if (eX != null) {
                int width = (int) (0.5d * eX.getWidth());
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString O(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.ax.E(context, str);
    }
}
