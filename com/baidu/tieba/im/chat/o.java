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
    private static final HashMap<String, String> bNV = new HashMap<>();

    static {
        bNV.put("#(呵呵)", "image_emoticon");
        bNV.put("#(哈哈)", "image_emoticon2");
        bNV.put("#(吐舌)", "image_emoticon3");
        bNV.put("#(啊)", "image_emoticon4");
        bNV.put("#(啊?)", "image_emoticon4");
        bNV.put("#(酷)", "image_emoticon5");
        bNV.put("#(怒)", "image_emoticon6");
        bNV.put("#(开心)", "image_emoticon7");
        bNV.put("#(汗)", "image_emoticon8");
        bNV.put("#(泪)", "image_emoticon9");
        bNV.put("#(黑线)", "image_emoticon10");
        bNV.put("#(鄙视)", "image_emoticon11");
        bNV.put("#(不高兴)", "image_emoticon12");
        bNV.put("#(真棒)", "image_emoticon13");
        bNV.put("#(钱)", "image_emoticon14");
        bNV.put("#(疑问)", "image_emoticon15");
        bNV.put("#(阴险)", "image_emoticon16");
        bNV.put("#(吐)", "image_emoticon17");
        bNV.put("#(咦)", "image_emoticon18");
        bNV.put("#(咦?)", "image_emoticon18");
        bNV.put("#(委屈)", "image_emoticon19");
        bNV.put("#(花心)", "image_emoticon20");
        bNV.put("#(呼~)", "image_emoticon21");
        bNV.put("#(笑眼)", "image_emoticon22");
        bNV.put("#(冷)", "image_emoticon23");
        bNV.put("#(太开心)", "image_emoticon24");
        bNV.put("#(滑稽)", "image_emoticon25");
        bNV.put("#(勉强)", "image_emoticon26");
        bNV.put("#(狂汗)", "image_emoticon27");
        bNV.put("#(乖)", "image_emoticon28");
        bNV.put("#(睡觉)", "image_emoticon29");
        bNV.put("#(惊哭)", "image_emoticon30");
        bNV.put("#(升起)", "image_emoticon31");
        bNV.put("#(惊讶)", "image_emoticon32");
        bNV.put("#(喷)", "image_emoticon33");
        bNV.put("#(爱心)", "image_emoticon34");
        bNV.put("#(心碎)", "image_emoticon35");
        bNV.put("#(玫瑰)", "image_emoticon36");
        bNV.put("#(礼物)", "image_emoticon37");
        bNV.put("#(彩虹)", "image_emoticon38");
        bNV.put("#(星星月亮)", "image_emoticon39");
        bNV.put("#(太阳)", "image_emoticon40");
        bNV.put("#(钱币)", "image_emoticon41");
        bNV.put("#(灯泡)", "image_emoticon42");
        bNV.put("#(茶杯)", "image_emoticon43");
        bNV.put("#(蛋糕)", "image_emoticon44");
        bNV.put("#(音乐)", "image_emoticon45");
        bNV.put("#(haha)", "image_emoticon46");
        bNV.put("#(胜利)", "image_emoticon47");
        bNV.put("#(大拇指)", "image_emoticon48");
        bNV.put("#(弱)", "image_emoticon49");
        bNV.put("#(OK)", "image_emoticon50");
        bNV.put("#(哼)", "image_emoticon61");
        bNV.put("#(赖皮)", "ali_001");
        bNV.put("#(感动)", "ali_002");
        bNV.put("#(十分惊讶)", "ali_003");
        bNV.put("#(怒气)", "ali_004");
        bNV.put("#(哭泣)", "ali_005");
        bNV.put("#(吃惊)", "ali_006");
        bNV.put("#(嘲弄)", "ali_007");
        bNV.put("#(飘过)", "ali_008");
        bNV.put("#(转圈哭)", "ali_009");
        bNV.put("#(神经病)", "ali_010");
        bNV.put("#(揪耳朵)", "ali_011");
        bNV.put("#(惊汗)", "ali_012");
        bNV.put("#(隐身)", "ali_013");
        bNV.put("#(不要嘛)", "ali_014");
        bNV.put("#(遁)", "ali_015");
        bNV.put("#(不公平)", "ali_016");
        bNV.put("#(爬来了)", "ali_017");
        bNV.put("#(蛋花哭)", "ali_018");
        bNV.put("#(温暖)", "ali_019");
        bNV.put("#(点头)", "ali_020");
        bNV.put("#(撒钱)", "ali_021");
        bNV.put("#(献花)", "ali_022");
        bNV.put("#(寒)", "ali_023");
        bNV.put("#(傻笑)", "ali_024");
        bNV.put("#(扭扭)", "ali_025");
        bNV.put("#(疯)", "ali_026");
        bNV.put("#(抓狂)", "ali_027");
        bNV.put("#(抓)", "ali_028");
        bNV.put("#(蜷)", "ali_029");
        bNV.put("#(挠墙)", "ali_030");
        bNV.put("#(狂笑)", "ali_031");
        bNV.put("#(抱枕)", "ali_032");
        bNV.put("#(吼叫)", "ali_033");
        bNV.put("#(嚷)", "ali_034");
        bNV.put("#(唠叨)", "ali_035");
        bNV.put("#(捏脸)", "ali_036");
        bNV.put("#(爆笑)", "ali_037");
        bNV.put("#(郁闷)", "ali_038");
        bNV.put("#(潜水)", "ali_039");
        bNV.put("#(十分开心)", "ali_040");
        bNV.put("#(冷笑话)", "ali_041");
        bNV.put("#(顶！)", "ali_042");
        bNV.put("#(潜)", "ali_043");
        bNV.put("#(画圈圈)", "ali_044");
        bNV.put("#(玩电脑)", "ali_045");
        bNV.put("#(狂吐)", "ali_046");
        bNV.put("#(哭着跑)", "ali_047");
        bNV.put("#(阿狸侠)", "ali_048");
        bNV.put("#(冷死了)", "ali_049");
        bNV.put("#(惆怅~)", "ali_050");
        bNV.put("#(摸头)", "ali_051");
        bNV.put("#(蹭)", "ali_052");
        bNV.put("#(打滚)", "ali_053");
        bNV.put("#(叩拜)", "ali_054");
        bNV.put("#(摸)", "ali_055");
        bNV.put("#(数钱)", "ali_056");
        bNV.put("#(拖走)", "ali_057");
        bNV.put("#(热)", "ali_058");
        bNV.put("#(加1)", "ali_059");
        bNV.put("#(压力)", "ali_060");
        bNV.put("#(表逼我)", "ali_061");
        bNV.put("#(人呢)", "ali_062");
        bNV.put("#(摇晃)", "ali_063");
        bNV.put("#(打地鼠)", "ali_064");
        bNV.put("#(这个屌)", "ali_065");
        bNV.put("#(恐慌)", "ali_066");
        bNV.put("#(晕乎乎)", "ali_067");
        bNV.put("#(浮云)", "ali_068");
        bNV.put("#(给力)", "ali_069");
        bNV.put("#(杯具了)", "ali_070");
        bNV.put("#(焦糖舞)", "yz_001");
        bNV.put("#(翻滚)", "yz_002");
        bNV.put("#(拍屁股做鬼脸)", "yz_003");
        bNV.put("#(不)", "yz_004");
        bNV.put("#(河蟹掉啦)", "yz_005");
        bNV.put("#(哦耶)", "yz_006");
        bNV.put("#(我倒)", "yz_007");
        bNV.put("#(投降)", "yz_008");
        bNV.put("#(微笑)", "b01");
        bNV.put("#(帅哥)", "b02");
        bNV.put("#(美女)", "b03");
        bNV.put("#(老大)", "b04");
        bNV.put("#(哈哈哈)", "b05");
        bNV.put("#(奸笑)", "b06");
        bNV.put("#(傻乐)", "b07");
        bNV.put("#(飞吻)", "b08");
        bNV.put("#(害羞)", "b09");
        bNV.put("#(花痴)", "b10");
        bNV.put("#(憧憬)", "b11");
        bNV.put("#(你牛)", "b12");
        bNV.put("#(鼓掌)", "b13");
        bNV.put("#(可爱)", "b14");
        bNV.put("#(太委屈)", "b15");
        bNV.put("#(大哭)", "b16");
        bNV.put("#(泪奔)", "b17");
        bNV.put("#(寻死)", "b18");
        bNV.put("#(非常惊讶)", "b19");
        bNV.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return bNV.get(str);
    }

    public static List<TbFaceManager.RichUnit> hZ(String str) {
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
                        arrayList.add(ia(str2));
                        str2 = "";
                    }
                    arrayList.add(aG(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(ia(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit ia(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aG(String str, String str2) {
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
                                SpannableString T = T(context, str2);
                                if (T != null) {
                                    cVar.append(T);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(cVar.GW(), name, str3);
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
                    SpannableString T2 = T(context, str2);
                    if (T2 != null) {
                        cVar.append(T2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.e> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fd = TbFaceManager.Ec().fd(str);
        if (fd != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst(), fd);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0052a fD = TbFaceManager.Ec().fD(str);
            if (fD != null) {
                int width = (int) (0.5d * fD.getWidth());
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString T(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.be.E(context, str);
    }
}
