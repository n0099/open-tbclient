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
    private static final HashMap<String, String> bnL = new HashMap<>();

    static {
        bnL.put("#(呵呵)", "image_emoticon");
        bnL.put("#(哈哈)", "image_emoticon2");
        bnL.put("#(吐舌)", "image_emoticon3");
        bnL.put("#(啊)", "image_emoticon4");
        bnL.put("#(啊?)", "image_emoticon4");
        bnL.put("#(酷)", "image_emoticon5");
        bnL.put("#(怒)", "image_emoticon6");
        bnL.put("#(开心)", "image_emoticon7");
        bnL.put("#(汗)", "image_emoticon8");
        bnL.put("#(泪)", "image_emoticon9");
        bnL.put("#(黑线)", "image_emoticon10");
        bnL.put("#(鄙视)", "image_emoticon11");
        bnL.put("#(不高兴)", "image_emoticon12");
        bnL.put("#(真棒)", "image_emoticon13");
        bnL.put("#(钱)", "image_emoticon14");
        bnL.put("#(疑问)", "image_emoticon15");
        bnL.put("#(阴险)", "image_emoticon16");
        bnL.put("#(吐)", "image_emoticon17");
        bnL.put("#(咦)", "image_emoticon18");
        bnL.put("#(咦?)", "image_emoticon18");
        bnL.put("#(委屈)", "image_emoticon19");
        bnL.put("#(花心)", "image_emoticon20");
        bnL.put("#(呼~)", "image_emoticon21");
        bnL.put("#(笑眼)", "image_emoticon22");
        bnL.put("#(冷)", "image_emoticon23");
        bnL.put("#(太开心)", "image_emoticon24");
        bnL.put("#(滑稽)", "image_emoticon25");
        bnL.put("#(勉强)", "image_emoticon26");
        bnL.put("#(狂汗)", "image_emoticon27");
        bnL.put("#(乖)", "image_emoticon28");
        bnL.put("#(睡觉)", "image_emoticon29");
        bnL.put("#(惊哭)", "image_emoticon30");
        bnL.put("#(升起)", "image_emoticon31");
        bnL.put("#(惊讶)", "image_emoticon32");
        bnL.put("#(喷)", "image_emoticon33");
        bnL.put("#(爱心)", "image_emoticon34");
        bnL.put("#(心碎)", "image_emoticon35");
        bnL.put("#(玫瑰)", "image_emoticon36");
        bnL.put("#(礼物)", "image_emoticon37");
        bnL.put("#(彩虹)", "image_emoticon38");
        bnL.put("#(星星月亮)", "image_emoticon39");
        bnL.put("#(太阳)", "image_emoticon40");
        bnL.put("#(钱币)", "image_emoticon41");
        bnL.put("#(灯泡)", "image_emoticon42");
        bnL.put("#(茶杯)", "image_emoticon43");
        bnL.put("#(蛋糕)", "image_emoticon44");
        bnL.put("#(音乐)", "image_emoticon45");
        bnL.put("#(haha)", "image_emoticon46");
        bnL.put("#(胜利)", "image_emoticon47");
        bnL.put("#(大拇指)", "image_emoticon48");
        bnL.put("#(弱)", "image_emoticon49");
        bnL.put("#(OK)", "image_emoticon50");
        bnL.put("#(赖皮)", "ali_001");
        bnL.put("#(感动)", "ali_002");
        bnL.put("#(十分惊讶)", "ali_003");
        bnL.put("#(怒气)", "ali_004");
        bnL.put("#(哭泣)", "ali_005");
        bnL.put("#(吃惊)", "ali_006");
        bnL.put("#(嘲弄)", "ali_007");
        bnL.put("#(飘过)", "ali_008");
        bnL.put("#(转圈哭)", "ali_009");
        bnL.put("#(神经病)", "ali_010");
        bnL.put("#(揪耳朵)", "ali_011");
        bnL.put("#(惊汗)", "ali_012");
        bnL.put("#(隐身)", "ali_013");
        bnL.put("#(不要嘛)", "ali_014");
        bnL.put("#(遁)", "ali_015");
        bnL.put("#(不公平)", "ali_016");
        bnL.put("#(爬来了)", "ali_017");
        bnL.put("#(蛋花哭)", "ali_018");
        bnL.put("#(温暖)", "ali_019");
        bnL.put("#(点头)", "ali_020");
        bnL.put("#(撒钱)", "ali_021");
        bnL.put("#(献花)", "ali_022");
        bnL.put("#(寒)", "ali_023");
        bnL.put("#(傻笑)", "ali_024");
        bnL.put("#(扭扭)", "ali_025");
        bnL.put("#(疯)", "ali_026");
        bnL.put("#(抓狂)", "ali_027");
        bnL.put("#(抓)", "ali_028");
        bnL.put("#(蜷)", "ali_029");
        bnL.put("#(挠墙)", "ali_030");
        bnL.put("#(狂笑)", "ali_031");
        bnL.put("#(抱枕)", "ali_032");
        bnL.put("#(吼叫)", "ali_033");
        bnL.put("#(嚷)", "ali_034");
        bnL.put("#(唠叨)", "ali_035");
        bnL.put("#(捏脸)", "ali_036");
        bnL.put("#(爆笑)", "ali_037");
        bnL.put("#(郁闷)", "ali_038");
        bnL.put("#(潜水)", "ali_039");
        bnL.put("#(十分开心)", "ali_040");
        bnL.put("#(冷笑话)", "ali_041");
        bnL.put("#(顶！)", "ali_042");
        bnL.put("#(潜)", "ali_043");
        bnL.put("#(画圈圈)", "ali_044");
        bnL.put("#(玩电脑)", "ali_045");
        bnL.put("#(狂吐)", "ali_046");
        bnL.put("#(哭着跑)", "ali_047");
        bnL.put("#(阿狸侠)", "ali_048");
        bnL.put("#(冷死了)", "ali_049");
        bnL.put("#(惆怅~)", "ali_050");
        bnL.put("#(摸头)", "ali_051");
        bnL.put("#(蹭)", "ali_052");
        bnL.put("#(打滚)", "ali_053");
        bnL.put("#(叩拜)", "ali_054");
        bnL.put("#(摸)", "ali_055");
        bnL.put("#(数钱)", "ali_056");
        bnL.put("#(拖走)", "ali_057");
        bnL.put("#(热)", "ali_058");
        bnL.put("#(加1)", "ali_059");
        bnL.put("#(压力)", "ali_060");
        bnL.put("#(表逼我)", "ali_061");
        bnL.put("#(人呢)", "ali_062");
        bnL.put("#(摇晃)", "ali_063");
        bnL.put("#(打地鼠)", "ali_064");
        bnL.put("#(这个屌)", "ali_065");
        bnL.put("#(恐慌)", "ali_066");
        bnL.put("#(晕乎乎)", "ali_067");
        bnL.put("#(浮云)", "ali_068");
        bnL.put("#(给力)", "ali_069");
        bnL.put("#(杯具了)", "ali_070");
        bnL.put("#(焦糖舞)", "yz_001");
        bnL.put("#(翻滚)", "yz_002");
        bnL.put("#(拍屁股做鬼脸)", "yz_003");
        bnL.put("#(不)", "yz_004");
        bnL.put("#(河蟹掉啦)", "yz_005");
        bnL.put("#(哦耶)", "yz_006");
        bnL.put("#(我倒)", "yz_007");
        bnL.put("#(投降)", "yz_008");
        bnL.put("#(微笑)", "b01");
        bnL.put("#(帅哥)", "b02");
        bnL.put("#(美女)", "b03");
        bnL.put("#(老大)", "b04");
        bnL.put("#(哈哈哈)", "b05");
        bnL.put("#(奸笑)", "b06");
        bnL.put("#(傻乐)", "b07");
        bnL.put("#(飞吻)", "b08");
        bnL.put("#(害羞)", "b09");
        bnL.put("#(花痴)", "b10");
        bnL.put("#(憧憬)", "b11");
        bnL.put("#(你牛)", "b12");
        bnL.put("#(鼓掌)", "b13");
        bnL.put("#(可爱)", "b14");
        bnL.put("#(太委屈)", "b15");
        bnL.put("#(大哭)", "b16");
        bnL.put("#(泪奔)", "b17");
        bnL.put("#(寻死)", "b18");
        bnL.put("#(非常惊讶)", "b19");
        bnL.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return bnL.get(str);
    }

    public static List<TbFaceManager.RichUnit> hm(String str) {
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
                        arrayList.add(hn(str2));
                        str2 = "";
                    }
                    arrayList.add(aD(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(hn(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit hn(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aD(String str, String str2) {
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
                                SpannableString O = O(context, str2);
                                if (O != null) {
                                    cVar.append(O);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(cVar.Fk(), name, str3);
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
        int eH = TbFaceManager.Cr().eH(str);
        if (eH != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst(), eH);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0049a ff = TbFaceManager.Cr().ff(str);
            if (ff != null) {
                int width = (int) (0.5d * ff.getWidth());
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
