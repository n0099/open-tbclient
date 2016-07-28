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
    private static final HashMap<String, String> cGR = new HashMap<>();

    static {
        cGR.put("#(呵呵)", "image_emoticon");
        cGR.put("#(哈哈)", "image_emoticon2");
        cGR.put("#(吐舌)", "image_emoticon3");
        cGR.put("#(啊)", "image_emoticon4");
        cGR.put("#(啊?)", "image_emoticon4");
        cGR.put("#(酷)", "image_emoticon5");
        cGR.put("#(怒)", "image_emoticon6");
        cGR.put("#(开心)", "image_emoticon7");
        cGR.put("#(汗)", "image_emoticon8");
        cGR.put("#(泪)", "image_emoticon9");
        cGR.put("#(黑线)", "image_emoticon10");
        cGR.put("#(鄙视)", "image_emoticon11");
        cGR.put("#(不高兴)", "image_emoticon12");
        cGR.put("#(真棒)", "image_emoticon13");
        cGR.put("#(钱)", "image_emoticon14");
        cGR.put("#(疑问)", "image_emoticon15");
        cGR.put("#(阴险)", "image_emoticon16");
        cGR.put("#(吐)", "image_emoticon17");
        cGR.put("#(咦)", "image_emoticon18");
        cGR.put("#(咦?)", "image_emoticon18");
        cGR.put("#(委屈)", "image_emoticon19");
        cGR.put("#(花心)", "image_emoticon20");
        cGR.put("#(呼~)", "image_emoticon21");
        cGR.put("#(笑眼)", "image_emoticon22");
        cGR.put("#(冷)", "image_emoticon23");
        cGR.put("#(太开心)", "image_emoticon24");
        cGR.put("#(滑稽)", "image_emoticon25");
        cGR.put("#(勉强)", "image_emoticon26");
        cGR.put("#(狂汗)", "image_emoticon27");
        cGR.put("#(乖)", "image_emoticon28");
        cGR.put("#(睡觉)", "image_emoticon29");
        cGR.put("#(惊哭)", "image_emoticon30");
        cGR.put("#(升起)", "image_emoticon31");
        cGR.put("#(惊讶)", "image_emoticon32");
        cGR.put("#(喷)", "image_emoticon33");
        cGR.put("#(爱心)", "image_emoticon34");
        cGR.put("#(心碎)", "image_emoticon35");
        cGR.put("#(玫瑰)", "image_emoticon36");
        cGR.put("#(礼物)", "image_emoticon37");
        cGR.put("#(彩虹)", "image_emoticon38");
        cGR.put("#(星星月亮)", "image_emoticon39");
        cGR.put("#(太阳)", "image_emoticon40");
        cGR.put("#(钱币)", "image_emoticon41");
        cGR.put("#(灯泡)", "image_emoticon42");
        cGR.put("#(茶杯)", "image_emoticon43");
        cGR.put("#(蛋糕)", "image_emoticon44");
        cGR.put("#(音乐)", "image_emoticon45");
        cGR.put("#(haha)", "image_emoticon46");
        cGR.put("#(胜利)", "image_emoticon47");
        cGR.put("#(大拇指)", "image_emoticon48");
        cGR.put("#(弱)", "image_emoticon49");
        cGR.put("#(OK)", "image_emoticon50");
        cGR.put("#(哼)", "image_emoticon61");
        cGR.put("#(吃瓜)", "image_emoticon62");
        cGR.put("#(扔便便)", "image_emoticon63");
        cGR.put("#(惊恐)", "image_emoticon64");
        cGR.put("#(哎呦)", "image_emoticon65");
        cGR.put("#(小乖)", "image_emoticon66");
        cGR.put("#(捂嘴笑)", "image_emoticon67");
        cGR.put("#(你懂的)", "image_emoticon68");
        cGR.put("#(what)", "image_emoticon69");
        cGR.put("#(酸爽)", "image_emoticon70");
        cGR.put("#(呀咩爹)", "image_emoticon71");
        cGR.put("#(笑尿)", "image_emoticon72");
        cGR.put("#(挖鼻)", "image_emoticon73");
        cGR.put("#(犀利)", "image_emoticon74");
        cGR.put("#(小红脸)", "image_emoticon75");
        cGR.put("#(懒得理)", "image_emoticon76");
        cGR.put("#(沙发)", "image_emoticon77");
        cGR.put("#(手纸)", "image_emoticon78");
        cGR.put("#(香蕉)", "image_emoticon79");
        cGR.put("#(便便)", "image_emoticon80");
        cGR.put("#(药丸)", "image_emoticon81");
        cGR.put("#(红领巾)", "image_emoticon82");
        cGR.put("#(蜡烛)", "image_emoticon83");
        cGR.put("#(三道杠)", "image_emoticon84");
        cGR.put("#(赖皮)", "ali_001");
        cGR.put("#(感动)", "ali_002");
        cGR.put("#(十分惊讶)", "ali_003");
        cGR.put("#(怒气)", "ali_004");
        cGR.put("#(哭泣)", "ali_005");
        cGR.put("#(吃惊)", "ali_006");
        cGR.put("#(嘲弄)", "ali_007");
        cGR.put("#(飘过)", "ali_008");
        cGR.put("#(转圈哭)", "ali_009");
        cGR.put("#(神经病)", "ali_010");
        cGR.put("#(揪耳朵)", "ali_011");
        cGR.put("#(惊汗)", "ali_012");
        cGR.put("#(隐身)", "ali_013");
        cGR.put("#(不要嘛)", "ali_014");
        cGR.put("#(遁)", "ali_015");
        cGR.put("#(不公平)", "ali_016");
        cGR.put("#(爬来了)", "ali_017");
        cGR.put("#(蛋花哭)", "ali_018");
        cGR.put("#(温暖)", "ali_019");
        cGR.put("#(点头)", "ali_020");
        cGR.put("#(撒钱)", "ali_021");
        cGR.put("#(献花)", "ali_022");
        cGR.put("#(寒)", "ali_023");
        cGR.put("#(傻笑)", "ali_024");
        cGR.put("#(扭扭)", "ali_025");
        cGR.put("#(疯)", "ali_026");
        cGR.put("#(抓狂)", "ali_027");
        cGR.put("#(抓)", "ali_028");
        cGR.put("#(蜷)", "ali_029");
        cGR.put("#(挠墙)", "ali_030");
        cGR.put("#(狂笑)", "ali_031");
        cGR.put("#(抱枕)", "ali_032");
        cGR.put("#(吼叫)", "ali_033");
        cGR.put("#(嚷)", "ali_034");
        cGR.put("#(唠叨)", "ali_035");
        cGR.put("#(捏脸)", "ali_036");
        cGR.put("#(爆笑)", "ali_037");
        cGR.put("#(郁闷)", "ali_038");
        cGR.put("#(潜水)", "ali_039");
        cGR.put("#(十分开心)", "ali_040");
        cGR.put("#(冷笑话)", "ali_041");
        cGR.put("#(顶！)", "ali_042");
        cGR.put("#(潜)", "ali_043");
        cGR.put("#(画圈圈)", "ali_044");
        cGR.put("#(玩电脑)", "ali_045");
        cGR.put("#(狂吐)", "ali_046");
        cGR.put("#(哭着跑)", "ali_047");
        cGR.put("#(阿狸侠)", "ali_048");
        cGR.put("#(冷死了)", "ali_049");
        cGR.put("#(惆怅~)", "ali_050");
        cGR.put("#(摸头)", "ali_051");
        cGR.put("#(蹭)", "ali_052");
        cGR.put("#(打滚)", "ali_053");
        cGR.put("#(叩拜)", "ali_054");
        cGR.put("#(摸)", "ali_055");
        cGR.put("#(数钱)", "ali_056");
        cGR.put("#(拖走)", "ali_057");
        cGR.put("#(热)", "ali_058");
        cGR.put("#(加1)", "ali_059");
        cGR.put("#(压力)", "ali_060");
        cGR.put("#(表逼我)", "ali_061");
        cGR.put("#(人呢)", "ali_062");
        cGR.put("#(摇晃)", "ali_063");
        cGR.put("#(打地鼠)", "ali_064");
        cGR.put("#(这个屌)", "ali_065");
        cGR.put("#(恐慌)", "ali_066");
        cGR.put("#(晕乎乎)", "ali_067");
        cGR.put("#(浮云)", "ali_068");
        cGR.put("#(给力)", "ali_069");
        cGR.put("#(杯具了)", "ali_070");
        cGR.put("#(焦糖舞)", "yz_001");
        cGR.put("#(翻滚)", "yz_002");
        cGR.put("#(拍屁股做鬼脸)", "yz_003");
        cGR.put("#(不)", "yz_004");
        cGR.put("#(河蟹掉啦)", "yz_005");
        cGR.put("#(哦耶)", "yz_006");
        cGR.put("#(我倒)", "yz_007");
        cGR.put("#(投降)", "yz_008");
        cGR.put("#(微笑)", "b01");
        cGR.put("#(帅哥)", "b02");
        cGR.put("#(美女)", "b03");
        cGR.put("#(老大)", "b04");
        cGR.put("#(哈哈哈)", "b05");
        cGR.put("#(奸笑)", "b06");
        cGR.put("#(傻乐)", "b07");
        cGR.put("#(飞吻)", "b08");
        cGR.put("#(害羞)", "b09");
        cGR.put("#(花痴)", "b10");
        cGR.put("#(憧憬)", "b11");
        cGR.put("#(你牛)", "b12");
        cGR.put("#(鼓掌)", "b13");
        cGR.put("#(可爱)", "b14");
        cGR.put("#(太委屈)", "b15");
        cGR.put("#(大哭)", "b16");
        cGR.put("#(泪奔)", "b17");
        cGR.put("#(寻死)", "b18");
        cGR.put("#(非常惊讶)", "b19");
        cGR.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cGR.get(str);
    }

    public static List<TbFaceManager.RichUnit> kk(String str) {
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
                        arrayList.add(kl(str2));
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
            arrayList.add(kl(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit kl(String str) {
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
                        SpannableString a = a(cVar.GH(), name, str3);
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
        int fm = TbFaceManager.CO().fm(str);
        if (fm != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m10getInst(), fm);
            if (arrayList != null) {
                arrayList.add(eVar);
            }
            a.C0044a fM = TbFaceManager.CO().fM(str);
            if (fM != null) {
                int width = (int) (0.5d * fM.getWidth());
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
