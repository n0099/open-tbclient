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
    private static final HashMap<String, String> bKm = new HashMap<>();

    static {
        bKm.put("#(呵呵)", "image_emoticon");
        bKm.put("#(哈哈)", "image_emoticon2");
        bKm.put("#(吐舌)", "image_emoticon3");
        bKm.put("#(啊)", "image_emoticon4");
        bKm.put("#(啊?)", "image_emoticon4");
        bKm.put("#(酷)", "image_emoticon5");
        bKm.put("#(怒)", "image_emoticon6");
        bKm.put("#(开心)", "image_emoticon7");
        bKm.put("#(汗)", "image_emoticon8");
        bKm.put("#(泪)", "image_emoticon9");
        bKm.put("#(黑线)", "image_emoticon10");
        bKm.put("#(鄙视)", "image_emoticon11");
        bKm.put("#(不高兴)", "image_emoticon12");
        bKm.put("#(真棒)", "image_emoticon13");
        bKm.put("#(钱)", "image_emoticon14");
        bKm.put("#(疑问)", "image_emoticon15");
        bKm.put("#(阴险)", "image_emoticon16");
        bKm.put("#(吐)", "image_emoticon17");
        bKm.put("#(咦)", "image_emoticon18");
        bKm.put("#(咦?)", "image_emoticon18");
        bKm.put("#(委屈)", "image_emoticon19");
        bKm.put("#(花心)", "image_emoticon20");
        bKm.put("#(呼~)", "image_emoticon21");
        bKm.put("#(笑眼)", "image_emoticon22");
        bKm.put("#(冷)", "image_emoticon23");
        bKm.put("#(太开心)", "image_emoticon24");
        bKm.put("#(滑稽)", "image_emoticon25");
        bKm.put("#(勉强)", "image_emoticon26");
        bKm.put("#(狂汗)", "image_emoticon27");
        bKm.put("#(乖)", "image_emoticon28");
        bKm.put("#(睡觉)", "image_emoticon29");
        bKm.put("#(惊哭)", "image_emoticon30");
        bKm.put("#(升起)", "image_emoticon31");
        bKm.put("#(惊讶)", "image_emoticon32");
        bKm.put("#(喷)", "image_emoticon33");
        bKm.put("#(爱心)", "image_emoticon34");
        bKm.put("#(心碎)", "image_emoticon35");
        bKm.put("#(玫瑰)", "image_emoticon36");
        bKm.put("#(礼物)", "image_emoticon37");
        bKm.put("#(彩虹)", "image_emoticon38");
        bKm.put("#(星星月亮)", "image_emoticon39");
        bKm.put("#(太阳)", "image_emoticon40");
        bKm.put("#(钱币)", "image_emoticon41");
        bKm.put("#(灯泡)", "image_emoticon42");
        bKm.put("#(茶杯)", "image_emoticon43");
        bKm.put("#(蛋糕)", "image_emoticon44");
        bKm.put("#(音乐)", "image_emoticon45");
        bKm.put("#(haha)", "image_emoticon46");
        bKm.put("#(胜利)", "image_emoticon47");
        bKm.put("#(大拇指)", "image_emoticon48");
        bKm.put("#(弱)", "image_emoticon49");
        bKm.put("#(OK)", "image_emoticon50");
        bKm.put("#(哼)", "image_emoticon61");
        bKm.put("#(赖皮)", "ali_001");
        bKm.put("#(感动)", "ali_002");
        bKm.put("#(十分惊讶)", "ali_003");
        bKm.put("#(怒气)", "ali_004");
        bKm.put("#(哭泣)", "ali_005");
        bKm.put("#(吃惊)", "ali_006");
        bKm.put("#(嘲弄)", "ali_007");
        bKm.put("#(飘过)", "ali_008");
        bKm.put("#(转圈哭)", "ali_009");
        bKm.put("#(神经病)", "ali_010");
        bKm.put("#(揪耳朵)", "ali_011");
        bKm.put("#(惊汗)", "ali_012");
        bKm.put("#(隐身)", "ali_013");
        bKm.put("#(不要嘛)", "ali_014");
        bKm.put("#(遁)", "ali_015");
        bKm.put("#(不公平)", "ali_016");
        bKm.put("#(爬来了)", "ali_017");
        bKm.put("#(蛋花哭)", "ali_018");
        bKm.put("#(温暖)", "ali_019");
        bKm.put("#(点头)", "ali_020");
        bKm.put("#(撒钱)", "ali_021");
        bKm.put("#(献花)", "ali_022");
        bKm.put("#(寒)", "ali_023");
        bKm.put("#(傻笑)", "ali_024");
        bKm.put("#(扭扭)", "ali_025");
        bKm.put("#(疯)", "ali_026");
        bKm.put("#(抓狂)", "ali_027");
        bKm.put("#(抓)", "ali_028");
        bKm.put("#(蜷)", "ali_029");
        bKm.put("#(挠墙)", "ali_030");
        bKm.put("#(狂笑)", "ali_031");
        bKm.put("#(抱枕)", "ali_032");
        bKm.put("#(吼叫)", "ali_033");
        bKm.put("#(嚷)", "ali_034");
        bKm.put("#(唠叨)", "ali_035");
        bKm.put("#(捏脸)", "ali_036");
        bKm.put("#(爆笑)", "ali_037");
        bKm.put("#(郁闷)", "ali_038");
        bKm.put("#(潜水)", "ali_039");
        bKm.put("#(十分开心)", "ali_040");
        bKm.put("#(冷笑话)", "ali_041");
        bKm.put("#(顶！)", "ali_042");
        bKm.put("#(潜)", "ali_043");
        bKm.put("#(画圈圈)", "ali_044");
        bKm.put("#(玩电脑)", "ali_045");
        bKm.put("#(狂吐)", "ali_046");
        bKm.put("#(哭着跑)", "ali_047");
        bKm.put("#(阿狸侠)", "ali_048");
        bKm.put("#(冷死了)", "ali_049");
        bKm.put("#(惆怅~)", "ali_050");
        bKm.put("#(摸头)", "ali_051");
        bKm.put("#(蹭)", "ali_052");
        bKm.put("#(打滚)", "ali_053");
        bKm.put("#(叩拜)", "ali_054");
        bKm.put("#(摸)", "ali_055");
        bKm.put("#(数钱)", "ali_056");
        bKm.put("#(拖走)", "ali_057");
        bKm.put("#(热)", "ali_058");
        bKm.put("#(加1)", "ali_059");
        bKm.put("#(压力)", "ali_060");
        bKm.put("#(表逼我)", "ali_061");
        bKm.put("#(人呢)", "ali_062");
        bKm.put("#(摇晃)", "ali_063");
        bKm.put("#(打地鼠)", "ali_064");
        bKm.put("#(这个屌)", "ali_065");
        bKm.put("#(恐慌)", "ali_066");
        bKm.put("#(晕乎乎)", "ali_067");
        bKm.put("#(浮云)", "ali_068");
        bKm.put("#(给力)", "ali_069");
        bKm.put("#(杯具了)", "ali_070");
        bKm.put("#(焦糖舞)", "yz_001");
        bKm.put("#(翻滚)", "yz_002");
        bKm.put("#(拍屁股做鬼脸)", "yz_003");
        bKm.put("#(不)", "yz_004");
        bKm.put("#(河蟹掉啦)", "yz_005");
        bKm.put("#(哦耶)", "yz_006");
        bKm.put("#(我倒)", "yz_007");
        bKm.put("#(投降)", "yz_008");
        bKm.put("#(微笑)", "b01");
        bKm.put("#(帅哥)", "b02");
        bKm.put("#(美女)", "b03");
        bKm.put("#(老大)", "b04");
        bKm.put("#(哈哈哈)", "b05");
        bKm.put("#(奸笑)", "b06");
        bKm.put("#(傻乐)", "b07");
        bKm.put("#(飞吻)", "b08");
        bKm.put("#(害羞)", "b09");
        bKm.put("#(花痴)", "b10");
        bKm.put("#(憧憬)", "b11");
        bKm.put("#(你牛)", "b12");
        bKm.put("#(鼓掌)", "b13");
        bKm.put("#(可爱)", "b14");
        bKm.put("#(太委屈)", "b15");
        bKm.put("#(大哭)", "b16");
        bKm.put("#(泪奔)", "b17");
        bKm.put("#(寻死)", "b18");
        bKm.put("#(非常惊讶)", "b19");
        bKm.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return bKm.get(str);
    }

    public static List<TbFaceManager.RichUnit> hX(String str) {
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
                        arrayList.add(hY(str2));
                        str2 = "";
                    }
                    arrayList.add(aB(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(hY(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit hY(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aB(String str, String str2) {
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
                                SpannableString N = N(context, str2);
                                if (N != null) {
                                    cVar.append(N);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(cVar.FE(), name, str3);
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
        int fe = TbFaceManager.CL().fe(str);
        if (fe != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst(), fe);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0051a fF = TbFaceManager.CL().fF(str);
            if (fF != null) {
                int width = (int) (0.5d * fF.getWidth());
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
