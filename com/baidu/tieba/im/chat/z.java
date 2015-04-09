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
    private static final HashMap<String, String> aWK = new HashMap<>();

    static {
        aWK.put("#(呵呵)", "image_emoticon");
        aWK.put("#(哈哈)", "image_emoticon2");
        aWK.put("#(吐舌)", "image_emoticon3");
        aWK.put("#(啊)", "image_emoticon4");
        aWK.put("#(啊?)", "image_emoticon4");
        aWK.put("#(酷)", "image_emoticon5");
        aWK.put("#(怒)", "image_emoticon6");
        aWK.put("#(开心)", "image_emoticon7");
        aWK.put("#(汗)", "image_emoticon8");
        aWK.put("#(泪)", "image_emoticon9");
        aWK.put("#(黑线)", "image_emoticon10");
        aWK.put("#(鄙视)", "image_emoticon11");
        aWK.put("#(不高兴)", "image_emoticon12");
        aWK.put("#(真棒)", "image_emoticon13");
        aWK.put("#(钱)", "image_emoticon14");
        aWK.put("#(疑问)", "image_emoticon15");
        aWK.put("#(阴险)", "image_emoticon16");
        aWK.put("#(吐)", "image_emoticon17");
        aWK.put("#(咦)", "image_emoticon18");
        aWK.put("#(咦?)", "image_emoticon18");
        aWK.put("#(委屈)", "image_emoticon19");
        aWK.put("#(花心)", "image_emoticon20");
        aWK.put("#(呼~)", "image_emoticon21");
        aWK.put("#(笑眼)", "image_emoticon22");
        aWK.put("#(冷)", "image_emoticon23");
        aWK.put("#(太开心)", "image_emoticon24");
        aWK.put("#(滑稽)", "image_emoticon25");
        aWK.put("#(勉强)", "image_emoticon26");
        aWK.put("#(狂汗)", "image_emoticon27");
        aWK.put("#(乖)", "image_emoticon28");
        aWK.put("#(睡觉)", "image_emoticon29");
        aWK.put("#(惊哭)", "image_emoticon30");
        aWK.put("#(升起)", "image_emoticon31");
        aWK.put("#(惊讶)", "image_emoticon32");
        aWK.put("#(喷)", "image_emoticon33");
        aWK.put("#(爱心)", "image_emoticon34");
        aWK.put("#(心碎)", "image_emoticon35");
        aWK.put("#(玫瑰)", "image_emoticon36");
        aWK.put("#(礼物)", "image_emoticon37");
        aWK.put("#(彩虹)", "image_emoticon38");
        aWK.put("#(星星月亮)", "image_emoticon39");
        aWK.put("#(太阳)", "image_emoticon40");
        aWK.put("#(钱币)", "image_emoticon41");
        aWK.put("#(灯泡)", "image_emoticon42");
        aWK.put("#(茶杯)", "image_emoticon43");
        aWK.put("#(蛋糕)", "image_emoticon44");
        aWK.put("#(音乐)", "image_emoticon45");
        aWK.put("#(haha)", "image_emoticon46");
        aWK.put("#(胜利)", "image_emoticon47");
        aWK.put("#(大拇指)", "image_emoticon48");
        aWK.put("#(弱)", "image_emoticon49");
        aWK.put("#(OK)", "image_emoticon50");
        aWK.put("#(赖皮)", "ali_001");
        aWK.put("#(感动)", "ali_002");
        aWK.put("#(十分惊讶)", "ali_003");
        aWK.put("#(怒气)", "ali_004");
        aWK.put("#(哭泣)", "ali_005");
        aWK.put("#(吃惊)", "ali_006");
        aWK.put("#(嘲弄)", "ali_007");
        aWK.put("#(飘过)", "ali_008");
        aWK.put("#(转圈哭)", "ali_009");
        aWK.put("#(神经病)", "ali_010");
        aWK.put("#(揪耳朵)", "ali_011");
        aWK.put("#(惊汗)", "ali_012");
        aWK.put("#(隐身)", "ali_013");
        aWK.put("#(不要嘛)", "ali_014");
        aWK.put("#(遁)", "ali_015");
        aWK.put("#(不公平)", "ali_016");
        aWK.put("#(爬来了)", "ali_017");
        aWK.put("#(蛋花哭)", "ali_018");
        aWK.put("#(温暖)", "ali_019");
        aWK.put("#(点头)", "ali_020");
        aWK.put("#(撒钱)", "ali_021");
        aWK.put("#(献花)", "ali_022");
        aWK.put("#(寒)", "ali_023");
        aWK.put("#(傻笑)", "ali_024");
        aWK.put("#(扭扭)", "ali_025");
        aWK.put("#(疯)", "ali_026");
        aWK.put("#(抓狂)", "ali_027");
        aWK.put("#(抓)", "ali_028");
        aWK.put("#(蜷)", "ali_029");
        aWK.put("#(挠墙)", "ali_030");
        aWK.put("#(狂笑)", "ali_031");
        aWK.put("#(抱枕)", "ali_032");
        aWK.put("#(吼叫)", "ali_033");
        aWK.put("#(嚷)", "ali_034");
        aWK.put("#(唠叨)", "ali_035");
        aWK.put("#(捏脸)", "ali_036");
        aWK.put("#(爆笑)", "ali_037");
        aWK.put("#(郁闷)", "ali_038");
        aWK.put("#(潜水)", "ali_039");
        aWK.put("#(十分开心)", "ali_040");
        aWK.put("#(冷笑话)", "ali_041");
        aWK.put("#(顶！)", "ali_042");
        aWK.put("#(潜)", "ali_043");
        aWK.put("#(画圈圈)", "ali_044");
        aWK.put("#(玩电脑)", "ali_045");
        aWK.put("#(狂吐)", "ali_046");
        aWK.put("#(哭着跑)", "ali_047");
        aWK.put("#(阿狸侠)", "ali_048");
        aWK.put("#(冷死了)", "ali_049");
        aWK.put("#(惆怅~)", "ali_050");
        aWK.put("#(摸头)", "ali_051");
        aWK.put("#(蹭)", "ali_052");
        aWK.put("#(打滚)", "ali_053");
        aWK.put("#(叩拜)", "ali_054");
        aWK.put("#(摸)", "ali_055");
        aWK.put("#(数钱)", "ali_056");
        aWK.put("#(拖走)", "ali_057");
        aWK.put("#(热)", "ali_058");
        aWK.put("#(加1)", "ali_059");
        aWK.put("#(压力)", "ali_060");
        aWK.put("#(表逼我)", "ali_061");
        aWK.put("#(人呢)", "ali_062");
        aWK.put("#(摇晃)", "ali_063");
        aWK.put("#(打地鼠)", "ali_064");
        aWK.put("#(这个屌)", "ali_065");
        aWK.put("#(恐慌)", "ali_066");
        aWK.put("#(晕乎乎)", "ali_067");
        aWK.put("#(浮云)", "ali_068");
        aWK.put("#(给力)", "ali_069");
        aWK.put("#(杯具了)", "ali_070");
        aWK.put("#(焦糖舞)", "yz_001");
        aWK.put("#(翻滚)", "yz_002");
        aWK.put("#(拍屁股做鬼脸)", "yz_003");
        aWK.put("#(不)", "yz_004");
        aWK.put("#(河蟹掉啦)", "yz_005");
        aWK.put("#(哦耶)", "yz_006");
        aWK.put("#(我倒)", "yz_007");
        aWK.put("#(投降)", "yz_008");
        aWK.put("#(微笑)", "b01");
        aWK.put("#(帅哥)", "b02");
        aWK.put("#(美女)", "b03");
        aWK.put("#(老大)", "b04");
        aWK.put("#(哈哈哈)", "b05");
        aWK.put("#(奸笑)", "b06");
        aWK.put("#(傻乐)", "b07");
        aWK.put("#(飞吻)", "b08");
        aWK.put("#(害羞)", "b09");
        aWK.put("#(花痴)", "b10");
        aWK.put("#(憧憬)", "b11");
        aWK.put("#(你牛)", "b12");
        aWK.put("#(鼓掌)", "b13");
        aWK.put("#(可爱)", "b14");
        aWK.put("#(太委屈)", "b15");
        aWK.put("#(大哭)", "b16");
        aWK.put("#(泪奔)", "b17");
        aWK.put("#(寻死)", "b18");
        aWK.put("#(非常惊讶)", "b19");
        aWK.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return aWK.get(str);
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
                        SpannableString a = a(cVar.DF(), name, str3);
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
        int ed = TbFaceManager.zx().ed(str);
        if (ed != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(TbadkCoreApplication.m411getInst(), ed);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            com.baidu.tbadk.imageManager.c eq = TbFaceManager.zx().eq(str);
            if (eq != null) {
                int width = (int) (0.5d * eq.getWidth());
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
