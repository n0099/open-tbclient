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
    private static final HashMap<String, String> cTR = new HashMap<>();

    static {
        cTR.put("#(呵呵)", "image_emoticon");
        cTR.put("#(哈哈)", "image_emoticon2");
        cTR.put("#(吐舌)", "image_emoticon3");
        cTR.put("#(啊)", "image_emoticon4");
        cTR.put("#(啊?)", "image_emoticon4");
        cTR.put("#(酷)", "image_emoticon5");
        cTR.put("#(怒)", "image_emoticon6");
        cTR.put("#(开心)", "image_emoticon7");
        cTR.put("#(汗)", "image_emoticon8");
        cTR.put("#(泪)", "image_emoticon9");
        cTR.put("#(黑线)", "image_emoticon10");
        cTR.put("#(鄙视)", "image_emoticon11");
        cTR.put("#(不高兴)", "image_emoticon12");
        cTR.put("#(真棒)", "image_emoticon13");
        cTR.put("#(钱)", "image_emoticon14");
        cTR.put("#(疑问)", "image_emoticon15");
        cTR.put("#(阴险)", "image_emoticon16");
        cTR.put("#(吐)", "image_emoticon17");
        cTR.put("#(咦)", "image_emoticon18");
        cTR.put("#(咦?)", "image_emoticon18");
        cTR.put("#(委屈)", "image_emoticon19");
        cTR.put("#(花心)", "image_emoticon20");
        cTR.put("#(呼~)", "image_emoticon21");
        cTR.put("#(笑眼)", "image_emoticon22");
        cTR.put("#(冷)", "image_emoticon23");
        cTR.put("#(太开心)", "image_emoticon24");
        cTR.put("#(滑稽)", "image_emoticon25");
        cTR.put("#(勉强)", "image_emoticon26");
        cTR.put("#(狂汗)", "image_emoticon27");
        cTR.put("#(乖)", "image_emoticon28");
        cTR.put("#(睡觉)", "image_emoticon29");
        cTR.put("#(惊哭)", "image_emoticon30");
        cTR.put("#(升起)", "image_emoticon31");
        cTR.put("#(惊讶)", "image_emoticon32");
        cTR.put("#(喷)", "image_emoticon33");
        cTR.put("#(爱心)", "image_emoticon34");
        cTR.put("#(心碎)", "image_emoticon35");
        cTR.put("#(玫瑰)", "image_emoticon36");
        cTR.put("#(礼物)", "image_emoticon37");
        cTR.put("#(彩虹)", "image_emoticon38");
        cTR.put("#(星星月亮)", "image_emoticon39");
        cTR.put("#(太阳)", "image_emoticon40");
        cTR.put("#(钱币)", "image_emoticon41");
        cTR.put("#(灯泡)", "image_emoticon42");
        cTR.put("#(茶杯)", "image_emoticon43");
        cTR.put("#(蛋糕)", "image_emoticon44");
        cTR.put("#(音乐)", "image_emoticon45");
        cTR.put("#(haha)", "image_emoticon46");
        cTR.put("#(胜利)", "image_emoticon47");
        cTR.put("#(大拇指)", "image_emoticon48");
        cTR.put("#(弱)", "image_emoticon49");
        cTR.put("#(OK)", "image_emoticon50");
        cTR.put("#(哼)", "image_emoticon61");
        cTR.put("#(吃瓜)", "image_emoticon62");
        cTR.put("#(扔便便)", "image_emoticon63");
        cTR.put("#(惊恐)", "image_emoticon64");
        cTR.put("#(哎呦)", "image_emoticon65");
        cTR.put("#(小乖)", "image_emoticon66");
        cTR.put("#(捂嘴笑)", "image_emoticon67");
        cTR.put("#(你懂的)", "image_emoticon68");
        cTR.put("#(what)", "image_emoticon69");
        cTR.put("#(酸爽)", "image_emoticon70");
        cTR.put("#(呀咩爹)", "image_emoticon71");
        cTR.put("#(笑尿)", "image_emoticon72");
        cTR.put("#(挖鼻)", "image_emoticon73");
        cTR.put("#(犀利)", "image_emoticon74");
        cTR.put("#(小红脸)", "image_emoticon75");
        cTR.put("#(懒得理)", "image_emoticon76");
        cTR.put("#(沙发)", "image_emoticon77");
        cTR.put("#(手纸)", "image_emoticon78");
        cTR.put("#(香蕉)", "image_emoticon79");
        cTR.put("#(便便)", "image_emoticon80");
        cTR.put("#(药丸)", "image_emoticon81");
        cTR.put("#(红领巾)", "image_emoticon82");
        cTR.put("#(蜡烛)", "image_emoticon83");
        cTR.put("#(三道杠)", "image_emoticon84");
        cTR.put("#(赖皮)", "ali_001");
        cTR.put("#(感动)", "ali_002");
        cTR.put("#(十分惊讶)", "ali_003");
        cTR.put("#(怒气)", "ali_004");
        cTR.put("#(哭泣)", "ali_005");
        cTR.put("#(吃惊)", "ali_006");
        cTR.put("#(嘲弄)", "ali_007");
        cTR.put("#(飘过)", "ali_008");
        cTR.put("#(转圈哭)", "ali_009");
        cTR.put("#(神经病)", "ali_010");
        cTR.put("#(揪耳朵)", "ali_011");
        cTR.put("#(惊汗)", "ali_012");
        cTR.put("#(隐身)", "ali_013");
        cTR.put("#(不要嘛)", "ali_014");
        cTR.put("#(遁)", "ali_015");
        cTR.put("#(不公平)", "ali_016");
        cTR.put("#(爬来了)", "ali_017");
        cTR.put("#(蛋花哭)", "ali_018");
        cTR.put("#(温暖)", "ali_019");
        cTR.put("#(点头)", "ali_020");
        cTR.put("#(撒钱)", "ali_021");
        cTR.put("#(献花)", "ali_022");
        cTR.put("#(寒)", "ali_023");
        cTR.put("#(傻笑)", "ali_024");
        cTR.put("#(扭扭)", "ali_025");
        cTR.put("#(疯)", "ali_026");
        cTR.put("#(抓狂)", "ali_027");
        cTR.put("#(抓)", "ali_028");
        cTR.put("#(蜷)", "ali_029");
        cTR.put("#(挠墙)", "ali_030");
        cTR.put("#(狂笑)", "ali_031");
        cTR.put("#(抱枕)", "ali_032");
        cTR.put("#(吼叫)", "ali_033");
        cTR.put("#(嚷)", "ali_034");
        cTR.put("#(唠叨)", "ali_035");
        cTR.put("#(捏脸)", "ali_036");
        cTR.put("#(爆笑)", "ali_037");
        cTR.put("#(郁闷)", "ali_038");
        cTR.put("#(潜水)", "ali_039");
        cTR.put("#(十分开心)", "ali_040");
        cTR.put("#(冷笑话)", "ali_041");
        cTR.put("#(顶！)", "ali_042");
        cTR.put("#(潜)", "ali_043");
        cTR.put("#(画圈圈)", "ali_044");
        cTR.put("#(玩电脑)", "ali_045");
        cTR.put("#(狂吐)", "ali_046");
        cTR.put("#(哭着跑)", "ali_047");
        cTR.put("#(阿狸侠)", "ali_048");
        cTR.put("#(冷死了)", "ali_049");
        cTR.put("#(惆怅~)", "ali_050");
        cTR.put("#(摸头)", "ali_051");
        cTR.put("#(蹭)", "ali_052");
        cTR.put("#(打滚)", "ali_053");
        cTR.put("#(叩拜)", "ali_054");
        cTR.put("#(摸)", "ali_055");
        cTR.put("#(数钱)", "ali_056");
        cTR.put("#(拖走)", "ali_057");
        cTR.put("#(热)", "ali_058");
        cTR.put("#(加1)", "ali_059");
        cTR.put("#(压力)", "ali_060");
        cTR.put("#(表逼我)", "ali_061");
        cTR.put("#(人呢)", "ali_062");
        cTR.put("#(摇晃)", "ali_063");
        cTR.put("#(打地鼠)", "ali_064");
        cTR.put("#(这个屌)", "ali_065");
        cTR.put("#(恐慌)", "ali_066");
        cTR.put("#(晕乎乎)", "ali_067");
        cTR.put("#(浮云)", "ali_068");
        cTR.put("#(给力)", "ali_069");
        cTR.put("#(杯具了)", "ali_070");
        cTR.put("#(焦糖舞)", "yz_001");
        cTR.put("#(翻滚)", "yz_002");
        cTR.put("#(拍屁股做鬼脸)", "yz_003");
        cTR.put("#(不)", "yz_004");
        cTR.put("#(河蟹掉啦)", "yz_005");
        cTR.put("#(哦耶)", "yz_006");
        cTR.put("#(我倒)", "yz_007");
        cTR.put("#(投降)", "yz_008");
        cTR.put("#(微笑)", "b01");
        cTR.put("#(帅哥)", "b02");
        cTR.put("#(美女)", "b03");
        cTR.put("#(老大)", "b04");
        cTR.put("#(哈哈哈)", "b05");
        cTR.put("#(奸笑)", "b06");
        cTR.put("#(傻乐)", "b07");
        cTR.put("#(飞吻)", "b08");
        cTR.put("#(害羞)", "b09");
        cTR.put("#(花痴)", "b10");
        cTR.put("#(憧憬)", "b11");
        cTR.put("#(你牛)", "b12");
        cTR.put("#(鼓掌)", "b13");
        cTR.put("#(可爱)", "b14");
        cTR.put("#(太委屈)", "b15");
        cTR.put("#(大哭)", "b16");
        cTR.put("#(泪奔)", "b17");
        cTR.put("#(寻死)", "b18");
        cTR.put("#(非常惊讶)", "b19");
        cTR.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cTR.get(str);
    }

    public static List<TbFaceManager.RichUnit> lg(String str) {
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
                        arrayList.add(lh(str2));
                        str2 = "";
                    }
                    arrayList.add(bb(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(lh(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit lh(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit bb(String str, String str2) {
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
                        SpannableString a = a(cVar.Id(), name, str3);
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
        int fr = TbFaceManager.Ej().fr(str);
        if (fr != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m9getInst(), fr);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0044a fT = TbFaceManager.Ej().fT(str);
            if (fT != null) {
                int width = (int) (0.5d * fT.getWidth());
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
        return com.baidu.tbadk.core.util.bh.x(context, str);
    }
}
