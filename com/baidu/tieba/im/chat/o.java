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
    private static final HashMap<String, String> cEc = new HashMap<>();

    static {
        cEc.put("#(呵呵)", "image_emoticon");
        cEc.put("#(哈哈)", "image_emoticon2");
        cEc.put("#(吐舌)", "image_emoticon3");
        cEc.put("#(啊)", "image_emoticon4");
        cEc.put("#(啊?)", "image_emoticon4");
        cEc.put("#(酷)", "image_emoticon5");
        cEc.put("#(怒)", "image_emoticon6");
        cEc.put("#(开心)", "image_emoticon7");
        cEc.put("#(汗)", "image_emoticon8");
        cEc.put("#(泪)", "image_emoticon9");
        cEc.put("#(黑线)", "image_emoticon10");
        cEc.put("#(鄙视)", "image_emoticon11");
        cEc.put("#(不高兴)", "image_emoticon12");
        cEc.put("#(真棒)", "image_emoticon13");
        cEc.put("#(钱)", "image_emoticon14");
        cEc.put("#(疑问)", "image_emoticon15");
        cEc.put("#(阴险)", "image_emoticon16");
        cEc.put("#(吐)", "image_emoticon17");
        cEc.put("#(咦)", "image_emoticon18");
        cEc.put("#(咦?)", "image_emoticon18");
        cEc.put("#(委屈)", "image_emoticon19");
        cEc.put("#(花心)", "image_emoticon20");
        cEc.put("#(呼~)", "image_emoticon21");
        cEc.put("#(笑眼)", "image_emoticon22");
        cEc.put("#(冷)", "image_emoticon23");
        cEc.put("#(太开心)", "image_emoticon24");
        cEc.put("#(滑稽)", "image_emoticon25");
        cEc.put("#(勉强)", "image_emoticon26");
        cEc.put("#(狂汗)", "image_emoticon27");
        cEc.put("#(乖)", "image_emoticon28");
        cEc.put("#(睡觉)", "image_emoticon29");
        cEc.put("#(惊哭)", "image_emoticon30");
        cEc.put("#(升起)", "image_emoticon31");
        cEc.put("#(惊讶)", "image_emoticon32");
        cEc.put("#(喷)", "image_emoticon33");
        cEc.put("#(爱心)", "image_emoticon34");
        cEc.put("#(心碎)", "image_emoticon35");
        cEc.put("#(玫瑰)", "image_emoticon36");
        cEc.put("#(礼物)", "image_emoticon37");
        cEc.put("#(彩虹)", "image_emoticon38");
        cEc.put("#(星星月亮)", "image_emoticon39");
        cEc.put("#(太阳)", "image_emoticon40");
        cEc.put("#(钱币)", "image_emoticon41");
        cEc.put("#(灯泡)", "image_emoticon42");
        cEc.put("#(茶杯)", "image_emoticon43");
        cEc.put("#(蛋糕)", "image_emoticon44");
        cEc.put("#(音乐)", "image_emoticon45");
        cEc.put("#(haha)", "image_emoticon46");
        cEc.put("#(胜利)", "image_emoticon47");
        cEc.put("#(大拇指)", "image_emoticon48");
        cEc.put("#(弱)", "image_emoticon49");
        cEc.put("#(OK)", "image_emoticon50");
        cEc.put("#(哼)", "image_emoticon61");
        cEc.put("#(吃瓜)", "image_emoticon62");
        cEc.put("#(扔便便)", "image_emoticon63");
        cEc.put("#(惊恐)", "image_emoticon64");
        cEc.put("#(哎呦)", "image_emoticon65");
        cEc.put("#(小乖)", "image_emoticon66");
        cEc.put("#(捂嘴笑)", "image_emoticon67");
        cEc.put("#(你懂的)", "image_emoticon68");
        cEc.put("#(what)", "image_emoticon69");
        cEc.put("#(酸爽)", "image_emoticon70");
        cEc.put("#(呀咩爹)", "image_emoticon71");
        cEc.put("#(笑尿)", "image_emoticon72");
        cEc.put("#(挖鼻)", "image_emoticon73");
        cEc.put("#(犀利)", "image_emoticon74");
        cEc.put("#(小红脸)", "image_emoticon75");
        cEc.put("#(懒得理)", "image_emoticon76");
        cEc.put("#(沙发)", "image_emoticon77");
        cEc.put("#(手纸)", "image_emoticon78");
        cEc.put("#(香蕉)", "image_emoticon79");
        cEc.put("#(便便)", "image_emoticon80");
        cEc.put("#(药丸)", "image_emoticon81");
        cEc.put("#(红领巾)", "image_emoticon82");
        cEc.put("#(蜡烛)", "image_emoticon83");
        cEc.put("#(三道杠)", "image_emoticon84");
        cEc.put("#(赖皮)", "ali_001");
        cEc.put("#(感动)", "ali_002");
        cEc.put("#(十分惊讶)", "ali_003");
        cEc.put("#(怒气)", "ali_004");
        cEc.put("#(哭泣)", "ali_005");
        cEc.put("#(吃惊)", "ali_006");
        cEc.put("#(嘲弄)", "ali_007");
        cEc.put("#(飘过)", "ali_008");
        cEc.put("#(转圈哭)", "ali_009");
        cEc.put("#(神经病)", "ali_010");
        cEc.put("#(揪耳朵)", "ali_011");
        cEc.put("#(惊汗)", "ali_012");
        cEc.put("#(隐身)", "ali_013");
        cEc.put("#(不要嘛)", "ali_014");
        cEc.put("#(遁)", "ali_015");
        cEc.put("#(不公平)", "ali_016");
        cEc.put("#(爬来了)", "ali_017");
        cEc.put("#(蛋花哭)", "ali_018");
        cEc.put("#(温暖)", "ali_019");
        cEc.put("#(点头)", "ali_020");
        cEc.put("#(撒钱)", "ali_021");
        cEc.put("#(献花)", "ali_022");
        cEc.put("#(寒)", "ali_023");
        cEc.put("#(傻笑)", "ali_024");
        cEc.put("#(扭扭)", "ali_025");
        cEc.put("#(疯)", "ali_026");
        cEc.put("#(抓狂)", "ali_027");
        cEc.put("#(抓)", "ali_028");
        cEc.put("#(蜷)", "ali_029");
        cEc.put("#(挠墙)", "ali_030");
        cEc.put("#(狂笑)", "ali_031");
        cEc.put("#(抱枕)", "ali_032");
        cEc.put("#(吼叫)", "ali_033");
        cEc.put("#(嚷)", "ali_034");
        cEc.put("#(唠叨)", "ali_035");
        cEc.put("#(捏脸)", "ali_036");
        cEc.put("#(爆笑)", "ali_037");
        cEc.put("#(郁闷)", "ali_038");
        cEc.put("#(潜水)", "ali_039");
        cEc.put("#(十分开心)", "ali_040");
        cEc.put("#(冷笑话)", "ali_041");
        cEc.put("#(顶！)", "ali_042");
        cEc.put("#(潜)", "ali_043");
        cEc.put("#(画圈圈)", "ali_044");
        cEc.put("#(玩电脑)", "ali_045");
        cEc.put("#(狂吐)", "ali_046");
        cEc.put("#(哭着跑)", "ali_047");
        cEc.put("#(阿狸侠)", "ali_048");
        cEc.put("#(冷死了)", "ali_049");
        cEc.put("#(惆怅~)", "ali_050");
        cEc.put("#(摸头)", "ali_051");
        cEc.put("#(蹭)", "ali_052");
        cEc.put("#(打滚)", "ali_053");
        cEc.put("#(叩拜)", "ali_054");
        cEc.put("#(摸)", "ali_055");
        cEc.put("#(数钱)", "ali_056");
        cEc.put("#(拖走)", "ali_057");
        cEc.put("#(热)", "ali_058");
        cEc.put("#(加1)", "ali_059");
        cEc.put("#(压力)", "ali_060");
        cEc.put("#(表逼我)", "ali_061");
        cEc.put("#(人呢)", "ali_062");
        cEc.put("#(摇晃)", "ali_063");
        cEc.put("#(打地鼠)", "ali_064");
        cEc.put("#(这个屌)", "ali_065");
        cEc.put("#(恐慌)", "ali_066");
        cEc.put("#(晕乎乎)", "ali_067");
        cEc.put("#(浮云)", "ali_068");
        cEc.put("#(给力)", "ali_069");
        cEc.put("#(杯具了)", "ali_070");
        cEc.put("#(焦糖舞)", "yz_001");
        cEc.put("#(翻滚)", "yz_002");
        cEc.put("#(拍屁股做鬼脸)", "yz_003");
        cEc.put("#(不)", "yz_004");
        cEc.put("#(河蟹掉啦)", "yz_005");
        cEc.put("#(哦耶)", "yz_006");
        cEc.put("#(我倒)", "yz_007");
        cEc.put("#(投降)", "yz_008");
        cEc.put("#(微笑)", "b01");
        cEc.put("#(帅哥)", "b02");
        cEc.put("#(美女)", "b03");
        cEc.put("#(老大)", "b04");
        cEc.put("#(哈哈哈)", "b05");
        cEc.put("#(奸笑)", "b06");
        cEc.put("#(傻乐)", "b07");
        cEc.put("#(飞吻)", "b08");
        cEc.put("#(害羞)", "b09");
        cEc.put("#(花痴)", "b10");
        cEc.put("#(憧憬)", "b11");
        cEc.put("#(你牛)", "b12");
        cEc.put("#(鼓掌)", "b13");
        cEc.put("#(可爱)", "b14");
        cEc.put("#(太委屈)", "b15");
        cEc.put("#(大哭)", "b16");
        cEc.put("#(泪奔)", "b17");
        cEc.put("#(寻死)", "b18");
        cEc.put("#(非常惊讶)", "b19");
        cEc.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cEc.get(str);
    }

    public static List<TbFaceManager.RichUnit> kd(String str) {
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
                        arrayList.add(ke(str2));
                        str2 = "";
                    }
                    arrayList.add(aX(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(ke(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit ke(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aX(String str, String str2) {
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
                                SpannableString M = M(context, str2);
                                if (M != null) {
                                    cVar.append(M);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(cVar.GJ(), name, str3);
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
                    SpannableString M2 = M(context, str2);
                    if (M2 != null) {
                        cVar.append(M2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.e> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fo = TbFaceManager.CP().fo(str);
        if (fo != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m9getInst(), fo);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0043a fO = TbFaceManager.CP().fO(str);
            if (fO != null) {
                int width = (int) (0.5d * fO.getWidth());
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString M(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.bi.x(context, str);
    }
}
