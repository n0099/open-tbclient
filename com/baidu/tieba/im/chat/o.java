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
    private static final HashMap<String, String> cSx = new HashMap<>();

    static {
        cSx.put("#(呵呵)", "image_emoticon");
        cSx.put("#(哈哈)", "image_emoticon2");
        cSx.put("#(吐舌)", "image_emoticon3");
        cSx.put("#(啊)", "image_emoticon4");
        cSx.put("#(啊?)", "image_emoticon4");
        cSx.put("#(酷)", "image_emoticon5");
        cSx.put("#(怒)", "image_emoticon6");
        cSx.put("#(开心)", "image_emoticon7");
        cSx.put("#(汗)", "image_emoticon8");
        cSx.put("#(泪)", "image_emoticon9");
        cSx.put("#(黑线)", "image_emoticon10");
        cSx.put("#(鄙视)", "image_emoticon11");
        cSx.put("#(不高兴)", "image_emoticon12");
        cSx.put("#(真棒)", "image_emoticon13");
        cSx.put("#(钱)", "image_emoticon14");
        cSx.put("#(疑问)", "image_emoticon15");
        cSx.put("#(阴险)", "image_emoticon16");
        cSx.put("#(吐)", "image_emoticon17");
        cSx.put("#(咦)", "image_emoticon18");
        cSx.put("#(咦?)", "image_emoticon18");
        cSx.put("#(委屈)", "image_emoticon19");
        cSx.put("#(花心)", "image_emoticon20");
        cSx.put("#(呼~)", "image_emoticon21");
        cSx.put("#(笑眼)", "image_emoticon22");
        cSx.put("#(冷)", "image_emoticon23");
        cSx.put("#(太开心)", "image_emoticon24");
        cSx.put("#(滑稽)", "image_emoticon25");
        cSx.put("#(勉强)", "image_emoticon26");
        cSx.put("#(狂汗)", "image_emoticon27");
        cSx.put("#(乖)", "image_emoticon28");
        cSx.put("#(睡觉)", "image_emoticon29");
        cSx.put("#(惊哭)", "image_emoticon30");
        cSx.put("#(升起)", "image_emoticon31");
        cSx.put("#(惊讶)", "image_emoticon32");
        cSx.put("#(喷)", "image_emoticon33");
        cSx.put("#(爱心)", "image_emoticon34");
        cSx.put("#(心碎)", "image_emoticon35");
        cSx.put("#(玫瑰)", "image_emoticon36");
        cSx.put("#(礼物)", "image_emoticon37");
        cSx.put("#(彩虹)", "image_emoticon38");
        cSx.put("#(星星月亮)", "image_emoticon39");
        cSx.put("#(太阳)", "image_emoticon40");
        cSx.put("#(钱币)", "image_emoticon41");
        cSx.put("#(灯泡)", "image_emoticon42");
        cSx.put("#(茶杯)", "image_emoticon43");
        cSx.put("#(蛋糕)", "image_emoticon44");
        cSx.put("#(音乐)", "image_emoticon45");
        cSx.put("#(haha)", "image_emoticon46");
        cSx.put("#(胜利)", "image_emoticon47");
        cSx.put("#(大拇指)", "image_emoticon48");
        cSx.put("#(弱)", "image_emoticon49");
        cSx.put("#(OK)", "image_emoticon50");
        cSx.put("#(哼)", "image_emoticon61");
        cSx.put("#(吃瓜)", "image_emoticon62");
        cSx.put("#(扔便便)", "image_emoticon63");
        cSx.put("#(惊恐)", "image_emoticon64");
        cSx.put("#(哎呦)", "image_emoticon65");
        cSx.put("#(小乖)", "image_emoticon66");
        cSx.put("#(捂嘴笑)", "image_emoticon67");
        cSx.put("#(你懂的)", "image_emoticon68");
        cSx.put("#(what)", "image_emoticon69");
        cSx.put("#(酸爽)", "image_emoticon70");
        cSx.put("#(呀咩爹)", "image_emoticon71");
        cSx.put("#(笑尿)", "image_emoticon72");
        cSx.put("#(挖鼻)", "image_emoticon73");
        cSx.put("#(犀利)", "image_emoticon74");
        cSx.put("#(小红脸)", "image_emoticon75");
        cSx.put("#(懒得理)", "image_emoticon76");
        cSx.put("#(沙发)", "image_emoticon77");
        cSx.put("#(手纸)", "image_emoticon78");
        cSx.put("#(香蕉)", "image_emoticon79");
        cSx.put("#(便便)", "image_emoticon80");
        cSx.put("#(药丸)", "image_emoticon81");
        cSx.put("#(红领巾)", "image_emoticon82");
        cSx.put("#(蜡烛)", "image_emoticon83");
        cSx.put("#(三道杠)", "image_emoticon84");
        cSx.put("#(赖皮)", "ali_001");
        cSx.put("#(感动)", "ali_002");
        cSx.put("#(十分惊讶)", "ali_003");
        cSx.put("#(怒气)", "ali_004");
        cSx.put("#(哭泣)", "ali_005");
        cSx.put("#(吃惊)", "ali_006");
        cSx.put("#(嘲弄)", "ali_007");
        cSx.put("#(飘过)", "ali_008");
        cSx.put("#(转圈哭)", "ali_009");
        cSx.put("#(神经病)", "ali_010");
        cSx.put("#(揪耳朵)", "ali_011");
        cSx.put("#(惊汗)", "ali_012");
        cSx.put("#(隐身)", "ali_013");
        cSx.put("#(不要嘛)", "ali_014");
        cSx.put("#(遁)", "ali_015");
        cSx.put("#(不公平)", "ali_016");
        cSx.put("#(爬来了)", "ali_017");
        cSx.put("#(蛋花哭)", "ali_018");
        cSx.put("#(温暖)", "ali_019");
        cSx.put("#(点头)", "ali_020");
        cSx.put("#(撒钱)", "ali_021");
        cSx.put("#(献花)", "ali_022");
        cSx.put("#(寒)", "ali_023");
        cSx.put("#(傻笑)", "ali_024");
        cSx.put("#(扭扭)", "ali_025");
        cSx.put("#(疯)", "ali_026");
        cSx.put("#(抓狂)", "ali_027");
        cSx.put("#(抓)", "ali_028");
        cSx.put("#(蜷)", "ali_029");
        cSx.put("#(挠墙)", "ali_030");
        cSx.put("#(狂笑)", "ali_031");
        cSx.put("#(抱枕)", "ali_032");
        cSx.put("#(吼叫)", "ali_033");
        cSx.put("#(嚷)", "ali_034");
        cSx.put("#(唠叨)", "ali_035");
        cSx.put("#(捏脸)", "ali_036");
        cSx.put("#(爆笑)", "ali_037");
        cSx.put("#(郁闷)", "ali_038");
        cSx.put("#(潜水)", "ali_039");
        cSx.put("#(十分开心)", "ali_040");
        cSx.put("#(冷笑话)", "ali_041");
        cSx.put("#(顶！)", "ali_042");
        cSx.put("#(潜)", "ali_043");
        cSx.put("#(画圈圈)", "ali_044");
        cSx.put("#(玩电脑)", "ali_045");
        cSx.put("#(狂吐)", "ali_046");
        cSx.put("#(哭着跑)", "ali_047");
        cSx.put("#(阿狸侠)", "ali_048");
        cSx.put("#(冷死了)", "ali_049");
        cSx.put("#(惆怅~)", "ali_050");
        cSx.put("#(摸头)", "ali_051");
        cSx.put("#(蹭)", "ali_052");
        cSx.put("#(打滚)", "ali_053");
        cSx.put("#(叩拜)", "ali_054");
        cSx.put("#(摸)", "ali_055");
        cSx.put("#(数钱)", "ali_056");
        cSx.put("#(拖走)", "ali_057");
        cSx.put("#(热)", "ali_058");
        cSx.put("#(加1)", "ali_059");
        cSx.put("#(压力)", "ali_060");
        cSx.put("#(表逼我)", "ali_061");
        cSx.put("#(人呢)", "ali_062");
        cSx.put("#(摇晃)", "ali_063");
        cSx.put("#(打地鼠)", "ali_064");
        cSx.put("#(这个屌)", "ali_065");
        cSx.put("#(恐慌)", "ali_066");
        cSx.put("#(晕乎乎)", "ali_067");
        cSx.put("#(浮云)", "ali_068");
        cSx.put("#(给力)", "ali_069");
        cSx.put("#(杯具了)", "ali_070");
        cSx.put("#(焦糖舞)", "yz_001");
        cSx.put("#(翻滚)", "yz_002");
        cSx.put("#(拍屁股做鬼脸)", "yz_003");
        cSx.put("#(不)", "yz_004");
        cSx.put("#(河蟹掉啦)", "yz_005");
        cSx.put("#(哦耶)", "yz_006");
        cSx.put("#(我倒)", "yz_007");
        cSx.put("#(投降)", "yz_008");
        cSx.put("#(微笑)", "b01");
        cSx.put("#(帅哥)", "b02");
        cSx.put("#(美女)", "b03");
        cSx.put("#(老大)", "b04");
        cSx.put("#(哈哈哈)", "b05");
        cSx.put("#(奸笑)", "b06");
        cSx.put("#(傻乐)", "b07");
        cSx.put("#(飞吻)", "b08");
        cSx.put("#(害羞)", "b09");
        cSx.put("#(花痴)", "b10");
        cSx.put("#(憧憬)", "b11");
        cSx.put("#(你牛)", "b12");
        cSx.put("#(鼓掌)", "b13");
        cSx.put("#(可爱)", "b14");
        cSx.put("#(太委屈)", "b15");
        cSx.put("#(大哭)", "b16");
        cSx.put("#(泪奔)", "b17");
        cSx.put("#(寻死)", "b18");
        cSx.put("#(非常惊讶)", "b19");
        cSx.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cSx.get(str);
    }

    public static List<TbFaceManager.RichUnit> kT(String str) {
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
                        arrayList.add(kU(str2));
                        str2 = "";
                    }
                    arrayList.add(aZ(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(kU(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit kU(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aZ(String str, String str2) {
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
                        SpannableString a = a(cVar.Ie(), name, str3);
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
        int fp = TbFaceManager.Ej().fp(str);
        if (fp != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m9getInst(), fp);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0044a fP = TbFaceManager.Ej().fP(str);
            if (fP != null) {
                int width = (int) (0.5d * fP.getWidth());
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
        return com.baidu.tbadk.core.util.bi.x(context, str);
    }
}
