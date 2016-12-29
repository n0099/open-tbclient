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
    private static final HashMap<String, String> cEL = new HashMap<>();

    static {
        cEL.put("#(呵呵)", "image_emoticon");
        cEL.put("#(哈哈)", "image_emoticon2");
        cEL.put("#(吐舌)", "image_emoticon3");
        cEL.put("#(啊)", "image_emoticon4");
        cEL.put("#(啊?)", "image_emoticon4");
        cEL.put("#(酷)", "image_emoticon5");
        cEL.put("#(怒)", "image_emoticon6");
        cEL.put("#(开心)", "image_emoticon7");
        cEL.put("#(汗)", "image_emoticon8");
        cEL.put("#(泪)", "image_emoticon9");
        cEL.put("#(黑线)", "image_emoticon10");
        cEL.put("#(鄙视)", "image_emoticon11");
        cEL.put("#(不高兴)", "image_emoticon12");
        cEL.put("#(真棒)", "image_emoticon13");
        cEL.put("#(钱)", "image_emoticon14");
        cEL.put("#(疑问)", "image_emoticon15");
        cEL.put("#(阴险)", "image_emoticon16");
        cEL.put("#(吐)", "image_emoticon17");
        cEL.put("#(咦)", "image_emoticon18");
        cEL.put("#(咦?)", "image_emoticon18");
        cEL.put("#(委屈)", "image_emoticon19");
        cEL.put("#(花心)", "image_emoticon20");
        cEL.put("#(呼~)", "image_emoticon21");
        cEL.put("#(笑眼)", "image_emoticon22");
        cEL.put("#(冷)", "image_emoticon23");
        cEL.put("#(太开心)", "image_emoticon24");
        cEL.put("#(滑稽)", "image_emoticon25");
        cEL.put("#(勉强)", "image_emoticon26");
        cEL.put("#(狂汗)", "image_emoticon27");
        cEL.put("#(乖)", "image_emoticon28");
        cEL.put("#(睡觉)", "image_emoticon29");
        cEL.put("#(惊哭)", "image_emoticon30");
        cEL.put("#(升起)", "image_emoticon31");
        cEL.put("#(惊讶)", "image_emoticon32");
        cEL.put("#(喷)", "image_emoticon33");
        cEL.put("#(爱心)", "image_emoticon34");
        cEL.put("#(心碎)", "image_emoticon35");
        cEL.put("#(玫瑰)", "image_emoticon36");
        cEL.put("#(礼物)", "image_emoticon37");
        cEL.put("#(彩虹)", "image_emoticon38");
        cEL.put("#(星星月亮)", "image_emoticon39");
        cEL.put("#(太阳)", "image_emoticon40");
        cEL.put("#(钱币)", "image_emoticon41");
        cEL.put("#(灯泡)", "image_emoticon42");
        cEL.put("#(茶杯)", "image_emoticon43");
        cEL.put("#(蛋糕)", "image_emoticon44");
        cEL.put("#(音乐)", "image_emoticon45");
        cEL.put("#(haha)", "image_emoticon46");
        cEL.put("#(胜利)", "image_emoticon47");
        cEL.put("#(大拇指)", "image_emoticon48");
        cEL.put("#(弱)", "image_emoticon49");
        cEL.put("#(OK)", "image_emoticon50");
        cEL.put("#(哼)", "image_emoticon61");
        cEL.put("#(吃瓜)", "image_emoticon62");
        cEL.put("#(扔便便)", "image_emoticon63");
        cEL.put("#(惊恐)", "image_emoticon64");
        cEL.put("#(哎呦)", "image_emoticon65");
        cEL.put("#(小乖)", "image_emoticon66");
        cEL.put("#(捂嘴笑)", "image_emoticon67");
        cEL.put("#(你懂的)", "image_emoticon68");
        cEL.put("#(what)", "image_emoticon69");
        cEL.put("#(酸爽)", "image_emoticon70");
        cEL.put("#(呀咩爹)", "image_emoticon71");
        cEL.put("#(笑尿)", "image_emoticon72");
        cEL.put("#(挖鼻)", "image_emoticon73");
        cEL.put("#(犀利)", "image_emoticon74");
        cEL.put("#(小红脸)", "image_emoticon75");
        cEL.put("#(懒得理)", "image_emoticon76");
        cEL.put("#(沙发)", "image_emoticon77");
        cEL.put("#(手纸)", "image_emoticon78");
        cEL.put("#(香蕉)", "image_emoticon79");
        cEL.put("#(便便)", "image_emoticon80");
        cEL.put("#(药丸)", "image_emoticon81");
        cEL.put("#(红领巾)", "image_emoticon82");
        cEL.put("#(蜡烛)", "image_emoticon83");
        cEL.put("#(三道杠)", "image_emoticon84");
        cEL.put("#(赖皮)", "ali_001");
        cEL.put("#(感动)", "ali_002");
        cEL.put("#(十分惊讶)", "ali_003");
        cEL.put("#(怒气)", "ali_004");
        cEL.put("#(哭泣)", "ali_005");
        cEL.put("#(吃惊)", "ali_006");
        cEL.put("#(嘲弄)", "ali_007");
        cEL.put("#(飘过)", "ali_008");
        cEL.put("#(转圈哭)", "ali_009");
        cEL.put("#(神经病)", "ali_010");
        cEL.put("#(揪耳朵)", "ali_011");
        cEL.put("#(惊汗)", "ali_012");
        cEL.put("#(隐身)", "ali_013");
        cEL.put("#(不要嘛)", "ali_014");
        cEL.put("#(遁)", "ali_015");
        cEL.put("#(不公平)", "ali_016");
        cEL.put("#(爬来了)", "ali_017");
        cEL.put("#(蛋花哭)", "ali_018");
        cEL.put("#(温暖)", "ali_019");
        cEL.put("#(点头)", "ali_020");
        cEL.put("#(撒钱)", "ali_021");
        cEL.put("#(献花)", "ali_022");
        cEL.put("#(寒)", "ali_023");
        cEL.put("#(傻笑)", "ali_024");
        cEL.put("#(扭扭)", "ali_025");
        cEL.put("#(疯)", "ali_026");
        cEL.put("#(抓狂)", "ali_027");
        cEL.put("#(抓)", "ali_028");
        cEL.put("#(蜷)", "ali_029");
        cEL.put("#(挠墙)", "ali_030");
        cEL.put("#(狂笑)", "ali_031");
        cEL.put("#(抱枕)", "ali_032");
        cEL.put("#(吼叫)", "ali_033");
        cEL.put("#(嚷)", "ali_034");
        cEL.put("#(唠叨)", "ali_035");
        cEL.put("#(捏脸)", "ali_036");
        cEL.put("#(爆笑)", "ali_037");
        cEL.put("#(郁闷)", "ali_038");
        cEL.put("#(潜水)", "ali_039");
        cEL.put("#(十分开心)", "ali_040");
        cEL.put("#(冷笑话)", "ali_041");
        cEL.put("#(顶！)", "ali_042");
        cEL.put("#(潜)", "ali_043");
        cEL.put("#(画圈圈)", "ali_044");
        cEL.put("#(玩电脑)", "ali_045");
        cEL.put("#(狂吐)", "ali_046");
        cEL.put("#(哭着跑)", "ali_047");
        cEL.put("#(阿狸侠)", "ali_048");
        cEL.put("#(冷死了)", "ali_049");
        cEL.put("#(惆怅~)", "ali_050");
        cEL.put("#(摸头)", "ali_051");
        cEL.put("#(蹭)", "ali_052");
        cEL.put("#(打滚)", "ali_053");
        cEL.put("#(叩拜)", "ali_054");
        cEL.put("#(摸)", "ali_055");
        cEL.put("#(数钱)", "ali_056");
        cEL.put("#(拖走)", "ali_057");
        cEL.put("#(热)", "ali_058");
        cEL.put("#(加1)", "ali_059");
        cEL.put("#(压力)", "ali_060");
        cEL.put("#(表逼我)", "ali_061");
        cEL.put("#(人呢)", "ali_062");
        cEL.put("#(摇晃)", "ali_063");
        cEL.put("#(打地鼠)", "ali_064");
        cEL.put("#(这个屌)", "ali_065");
        cEL.put("#(恐慌)", "ali_066");
        cEL.put("#(晕乎乎)", "ali_067");
        cEL.put("#(浮云)", "ali_068");
        cEL.put("#(给力)", "ali_069");
        cEL.put("#(杯具了)", "ali_070");
        cEL.put("#(焦糖舞)", "yz_001");
        cEL.put("#(翻滚)", "yz_002");
        cEL.put("#(拍屁股做鬼脸)", "yz_003");
        cEL.put("#(不)", "yz_004");
        cEL.put("#(河蟹掉啦)", "yz_005");
        cEL.put("#(哦耶)", "yz_006");
        cEL.put("#(我倒)", "yz_007");
        cEL.put("#(投降)", "yz_008");
        cEL.put("#(微笑)", "b01");
        cEL.put("#(帅哥)", "b02");
        cEL.put("#(美女)", "b03");
        cEL.put("#(老大)", "b04");
        cEL.put("#(哈哈哈)", "b05");
        cEL.put("#(奸笑)", "b06");
        cEL.put("#(傻乐)", "b07");
        cEL.put("#(飞吻)", "b08");
        cEL.put("#(害羞)", "b09");
        cEL.put("#(花痴)", "b10");
        cEL.put("#(憧憬)", "b11");
        cEL.put("#(你牛)", "b12");
        cEL.put("#(鼓掌)", "b13");
        cEL.put("#(可爱)", "b14");
        cEL.put("#(太委屈)", "b15");
        cEL.put("#(大哭)", "b16");
        cEL.put("#(泪奔)", "b17");
        cEL.put("#(寻死)", "b18");
        cEL.put("#(非常惊讶)", "b19");
        cEL.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cEL.get(str);
    }

    public static List<TbFaceManager.RichUnit> jW(String str) {
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
                        arrayList.add(jX(str2));
                        str2 = "";
                    }
                    arrayList.add(aY(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(jX(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit jX(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aY(String str, String str2) {
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
                        SpannableString a = a(cVar.HC(), name, str3);
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
        int fq = TbFaceManager.DW().fq(str);
        if (fq != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m9getInst(), fq);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0044a fS = TbFaceManager.DW().fS(str);
            if (fS != null) {
                int width = (int) (0.5d * fS.getWidth());
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
        return com.baidu.tbadk.core.util.bc.x(context, str);
    }
}
