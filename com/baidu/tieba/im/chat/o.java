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
    private static final HashMap<String, String> cZz = new HashMap<>();

    static {
        cZz.put("#(呵呵)", "image_emoticon");
        cZz.put("#(哈哈)", "image_emoticon2");
        cZz.put("#(吐舌)", "image_emoticon3");
        cZz.put("#(啊)", "image_emoticon4");
        cZz.put("#(啊?)", "image_emoticon4");
        cZz.put("#(酷)", "image_emoticon5");
        cZz.put("#(怒)", "image_emoticon6");
        cZz.put("#(开心)", "image_emoticon7");
        cZz.put("#(汗)", "image_emoticon8");
        cZz.put("#(泪)", "image_emoticon9");
        cZz.put("#(黑线)", "image_emoticon10");
        cZz.put("#(鄙视)", "image_emoticon11");
        cZz.put("#(不高兴)", "image_emoticon12");
        cZz.put("#(真棒)", "image_emoticon13");
        cZz.put("#(钱)", "image_emoticon14");
        cZz.put("#(疑问)", "image_emoticon15");
        cZz.put("#(阴险)", "image_emoticon16");
        cZz.put("#(吐)", "image_emoticon17");
        cZz.put("#(咦)", "image_emoticon18");
        cZz.put("#(咦?)", "image_emoticon18");
        cZz.put("#(委屈)", "image_emoticon19");
        cZz.put("#(花心)", "image_emoticon20");
        cZz.put("#(呼~)", "image_emoticon21");
        cZz.put("#(笑眼)", "image_emoticon22");
        cZz.put("#(冷)", "image_emoticon23");
        cZz.put("#(太开心)", "image_emoticon24");
        cZz.put("#(滑稽)", "image_emoticon25");
        cZz.put("#(勉强)", "image_emoticon26");
        cZz.put("#(狂汗)", "image_emoticon27");
        cZz.put("#(乖)", "image_emoticon28");
        cZz.put("#(睡觉)", "image_emoticon29");
        cZz.put("#(惊哭)", "image_emoticon30");
        cZz.put("#(升起)", "image_emoticon31");
        cZz.put("#(惊讶)", "image_emoticon32");
        cZz.put("#(喷)", "image_emoticon33");
        cZz.put("#(爱心)", "image_emoticon34");
        cZz.put("#(心碎)", "image_emoticon35");
        cZz.put("#(玫瑰)", "image_emoticon36");
        cZz.put("#(礼物)", "image_emoticon37");
        cZz.put("#(彩虹)", "image_emoticon38");
        cZz.put("#(星星月亮)", "image_emoticon39");
        cZz.put("#(太阳)", "image_emoticon40");
        cZz.put("#(钱币)", "image_emoticon41");
        cZz.put("#(灯泡)", "image_emoticon42");
        cZz.put("#(茶杯)", "image_emoticon43");
        cZz.put("#(蛋糕)", "image_emoticon44");
        cZz.put("#(音乐)", "image_emoticon45");
        cZz.put("#(haha)", "image_emoticon46");
        cZz.put("#(胜利)", "image_emoticon47");
        cZz.put("#(大拇指)", "image_emoticon48");
        cZz.put("#(弱)", "image_emoticon49");
        cZz.put("#(OK)", "image_emoticon50");
        cZz.put("#(哼)", "image_emoticon61");
        cZz.put("#(吃瓜)", "image_emoticon62");
        cZz.put("#(扔便便)", "image_emoticon63");
        cZz.put("#(惊恐)", "image_emoticon64");
        cZz.put("#(哎呦)", "image_emoticon65");
        cZz.put("#(小乖)", "image_emoticon66");
        cZz.put("#(捂嘴笑)", "image_emoticon67");
        cZz.put("#(你懂的)", "image_emoticon68");
        cZz.put("#(what)", "image_emoticon69");
        cZz.put("#(酸爽)", "image_emoticon70");
        cZz.put("#(呀咩爹)", "image_emoticon71");
        cZz.put("#(笑尿)", "image_emoticon72");
        cZz.put("#(挖鼻)", "image_emoticon73");
        cZz.put("#(犀利)", "image_emoticon74");
        cZz.put("#(小红脸)", "image_emoticon75");
        cZz.put("#(懒得理)", "image_emoticon76");
        cZz.put("#(沙发)", "image_emoticon77");
        cZz.put("#(手纸)", "image_emoticon78");
        cZz.put("#(香蕉)", "image_emoticon79");
        cZz.put("#(便便)", "image_emoticon80");
        cZz.put("#(药丸)", "image_emoticon81");
        cZz.put("#(红领巾)", "image_emoticon82");
        cZz.put("#(蜡烛)", "image_emoticon83");
        cZz.put("#(三道杠)", "image_emoticon84");
        cZz.put("#(赖皮)", "ali_001");
        cZz.put("#(感动)", "ali_002");
        cZz.put("#(十分惊讶)", "ali_003");
        cZz.put("#(怒气)", "ali_004");
        cZz.put("#(哭泣)", "ali_005");
        cZz.put("#(吃惊)", "ali_006");
        cZz.put("#(嘲弄)", "ali_007");
        cZz.put("#(飘过)", "ali_008");
        cZz.put("#(转圈哭)", "ali_009");
        cZz.put("#(神经病)", "ali_010");
        cZz.put("#(揪耳朵)", "ali_011");
        cZz.put("#(惊汗)", "ali_012");
        cZz.put("#(隐身)", "ali_013");
        cZz.put("#(不要嘛)", "ali_014");
        cZz.put("#(遁)", "ali_015");
        cZz.put("#(不公平)", "ali_016");
        cZz.put("#(爬来了)", "ali_017");
        cZz.put("#(蛋花哭)", "ali_018");
        cZz.put("#(温暖)", "ali_019");
        cZz.put("#(点头)", "ali_020");
        cZz.put("#(撒钱)", "ali_021");
        cZz.put("#(献花)", "ali_022");
        cZz.put("#(寒)", "ali_023");
        cZz.put("#(傻笑)", "ali_024");
        cZz.put("#(扭扭)", "ali_025");
        cZz.put("#(疯)", "ali_026");
        cZz.put("#(抓狂)", "ali_027");
        cZz.put("#(抓)", "ali_028");
        cZz.put("#(蜷)", "ali_029");
        cZz.put("#(挠墙)", "ali_030");
        cZz.put("#(狂笑)", "ali_031");
        cZz.put("#(抱枕)", "ali_032");
        cZz.put("#(吼叫)", "ali_033");
        cZz.put("#(嚷)", "ali_034");
        cZz.put("#(唠叨)", "ali_035");
        cZz.put("#(捏脸)", "ali_036");
        cZz.put("#(爆笑)", "ali_037");
        cZz.put("#(郁闷)", "ali_038");
        cZz.put("#(潜水)", "ali_039");
        cZz.put("#(十分开心)", "ali_040");
        cZz.put("#(冷笑话)", "ali_041");
        cZz.put("#(顶！)", "ali_042");
        cZz.put("#(潜)", "ali_043");
        cZz.put("#(画圈圈)", "ali_044");
        cZz.put("#(玩电脑)", "ali_045");
        cZz.put("#(狂吐)", "ali_046");
        cZz.put("#(哭着跑)", "ali_047");
        cZz.put("#(阿狸侠)", "ali_048");
        cZz.put("#(冷死了)", "ali_049");
        cZz.put("#(惆怅~)", "ali_050");
        cZz.put("#(摸头)", "ali_051");
        cZz.put("#(蹭)", "ali_052");
        cZz.put("#(打滚)", "ali_053");
        cZz.put("#(叩拜)", "ali_054");
        cZz.put("#(摸)", "ali_055");
        cZz.put("#(数钱)", "ali_056");
        cZz.put("#(拖走)", "ali_057");
        cZz.put("#(热)", "ali_058");
        cZz.put("#(加1)", "ali_059");
        cZz.put("#(压力)", "ali_060");
        cZz.put("#(表逼我)", "ali_061");
        cZz.put("#(人呢)", "ali_062");
        cZz.put("#(摇晃)", "ali_063");
        cZz.put("#(打地鼠)", "ali_064");
        cZz.put("#(这个屌)", "ali_065");
        cZz.put("#(恐慌)", "ali_066");
        cZz.put("#(晕乎乎)", "ali_067");
        cZz.put("#(浮云)", "ali_068");
        cZz.put("#(给力)", "ali_069");
        cZz.put("#(杯具了)", "ali_070");
        cZz.put("#(焦糖舞)", "yz_001");
        cZz.put("#(翻滚)", "yz_002");
        cZz.put("#(拍屁股做鬼脸)", "yz_003");
        cZz.put("#(不)", "yz_004");
        cZz.put("#(河蟹掉啦)", "yz_005");
        cZz.put("#(哦耶)", "yz_006");
        cZz.put("#(我倒)", "yz_007");
        cZz.put("#(投降)", "yz_008");
        cZz.put("#(微笑)", "b01");
        cZz.put("#(帅哥)", "b02");
        cZz.put("#(美女)", "b03");
        cZz.put("#(老大)", "b04");
        cZz.put("#(哈哈哈)", "b05");
        cZz.put("#(奸笑)", "b06");
        cZz.put("#(傻乐)", "b07");
        cZz.put("#(飞吻)", "b08");
        cZz.put("#(害羞)", "b09");
        cZz.put("#(花痴)", "b10");
        cZz.put("#(憧憬)", "b11");
        cZz.put("#(你牛)", "b12");
        cZz.put("#(鼓掌)", "b13");
        cZz.put("#(可爱)", "b14");
        cZz.put("#(太委屈)", "b15");
        cZz.put("#(大哭)", "b16");
        cZz.put("#(泪奔)", "b17");
        cZz.put("#(寻死)", "b18");
        cZz.put("#(非常惊讶)", "b19");
        cZz.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cZz.get(str);
    }

    public static List<TbFaceManager.RichUnit> lt(String str) {
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
                        arrayList.add(lu(str2));
                        str2 = "";
                    }
                    arrayList.add(bc(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(lu(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit lu(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit bc(String str, String str2) {
        String substring = str.substring(2, str.length() - 1);
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str2;
        richUnit.type = 2;
        richUnit.c = substring;
        return richUnit;
    }

    public static ArrayList<com.baidu.tbadk.widget.richText.c> b(Context context, String str, int i) {
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
                        SpannableString a = a(cVar.Ig(), name, str3);
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
        int fu = TbFaceManager.Eo().fu(str);
        if (fu != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m9getInst(), fu);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0044a fW = TbFaceManager.Eo().fW(str);
            if (fW != null) {
                int width = (int) (0.5d * fW.getWidth());
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
        return com.baidu.tbadk.core.util.bf.x(context, str);
    }
}
