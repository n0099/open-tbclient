package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private static final HashMap<String, String> cJa = new HashMap<>();

    static {
        cJa.put("#(呵呵)", "image_emoticon");
        cJa.put("#(哈哈)", "image_emoticon2");
        cJa.put("#(吐舌)", "image_emoticon3");
        cJa.put("#(啊)", "image_emoticon4");
        cJa.put("#(啊?)", "image_emoticon4");
        cJa.put("#(酷)", "image_emoticon5");
        cJa.put("#(怒)", "image_emoticon6");
        cJa.put("#(开心)", "image_emoticon7");
        cJa.put("#(汗)", "image_emoticon8");
        cJa.put("#(泪)", "image_emoticon9");
        cJa.put("#(黑线)", "image_emoticon10");
        cJa.put("#(鄙视)", "image_emoticon11");
        cJa.put("#(不高兴)", "image_emoticon12");
        cJa.put("#(真棒)", "image_emoticon13");
        cJa.put("#(钱)", "image_emoticon14");
        cJa.put("#(疑问)", "image_emoticon15");
        cJa.put("#(阴险)", "image_emoticon16");
        cJa.put("#(吐)", "image_emoticon17");
        cJa.put("#(咦)", "image_emoticon18");
        cJa.put("#(咦?)", "image_emoticon18");
        cJa.put("#(委屈)", "image_emoticon19");
        cJa.put("#(花心)", "image_emoticon20");
        cJa.put("#(呼~)", "image_emoticon21");
        cJa.put("#(笑眼)", "image_emoticon22");
        cJa.put("#(冷)", "image_emoticon23");
        cJa.put("#(太开心)", "image_emoticon24");
        cJa.put("#(滑稽)", "image_emoticon25");
        cJa.put("#(勉强)", "image_emoticon26");
        cJa.put("#(狂汗)", "image_emoticon27");
        cJa.put("#(乖)", "image_emoticon28");
        cJa.put("#(睡觉)", "image_emoticon29");
        cJa.put("#(惊哭)", "image_emoticon30");
        cJa.put("#(升起)", "image_emoticon31");
        cJa.put("#(惊讶)", "image_emoticon32");
        cJa.put("#(喷)", "image_emoticon33");
        cJa.put("#(爱心)", "image_emoticon34");
        cJa.put("#(心碎)", "image_emoticon35");
        cJa.put("#(玫瑰)", "image_emoticon36");
        cJa.put("#(礼物)", "image_emoticon37");
        cJa.put("#(彩虹)", "image_emoticon38");
        cJa.put("#(星星月亮)", "image_emoticon39");
        cJa.put("#(太阳)", "image_emoticon40");
        cJa.put("#(钱币)", "image_emoticon41");
        cJa.put("#(灯泡)", "image_emoticon42");
        cJa.put("#(茶杯)", "image_emoticon43");
        cJa.put("#(蛋糕)", "image_emoticon44");
        cJa.put("#(音乐)", "image_emoticon45");
        cJa.put("#(haha)", "image_emoticon46");
        cJa.put("#(胜利)", "image_emoticon47");
        cJa.put("#(大拇指)", "image_emoticon48");
        cJa.put("#(弱)", "image_emoticon49");
        cJa.put("#(OK)", "image_emoticon50");
        cJa.put("#(哼)", "image_emoticon61");
        cJa.put("#(吃瓜)", "image_emoticon62");
        cJa.put("#(扔便便)", "image_emoticon63");
        cJa.put("#(惊恐)", "image_emoticon64");
        cJa.put("#(哎呦)", "image_emoticon65");
        cJa.put("#(小乖)", "image_emoticon66");
        cJa.put("#(捂嘴笑)", "image_emoticon67");
        cJa.put("#(你懂的)", "image_emoticon68");
        cJa.put("#(what)", "image_emoticon69");
        cJa.put("#(酸爽)", "image_emoticon70");
        cJa.put("#(呀咩爹)", "image_emoticon71");
        cJa.put("#(笑尿)", "image_emoticon72");
        cJa.put("#(挖鼻)", "image_emoticon73");
        cJa.put("#(犀利)", "image_emoticon74");
        cJa.put("#(小红脸)", "image_emoticon75");
        cJa.put("#(懒得理)", "image_emoticon76");
        cJa.put("#(沙发)", "image_emoticon77");
        cJa.put("#(手纸)", "image_emoticon78");
        cJa.put("#(香蕉)", "image_emoticon79");
        cJa.put("#(便便)", "image_emoticon80");
        cJa.put("#(药丸)", "image_emoticon81");
        cJa.put("#(红领巾)", "image_emoticon82");
        cJa.put("#(蜡烛)", "image_emoticon83");
        cJa.put("#(三道杠)", "image_emoticon84");
        cJa.put("#(赖皮)", "ali_001");
        cJa.put("#(感动)", "ali_002");
        cJa.put("#(十分惊讶)", "ali_003");
        cJa.put("#(怒气)", "ali_004");
        cJa.put("#(哭泣)", "ali_005");
        cJa.put("#(吃惊)", "ali_006");
        cJa.put("#(嘲弄)", "ali_007");
        cJa.put("#(飘过)", "ali_008");
        cJa.put("#(转圈哭)", "ali_009");
        cJa.put("#(神经病)", "ali_010");
        cJa.put("#(揪耳朵)", "ali_011");
        cJa.put("#(惊汗)", "ali_012");
        cJa.put("#(隐身)", "ali_013");
        cJa.put("#(不要嘛)", "ali_014");
        cJa.put("#(遁)", "ali_015");
        cJa.put("#(不公平)", "ali_016");
        cJa.put("#(爬来了)", "ali_017");
        cJa.put("#(蛋花哭)", "ali_018");
        cJa.put("#(温暖)", "ali_019");
        cJa.put("#(点头)", "ali_020");
        cJa.put("#(撒钱)", "ali_021");
        cJa.put("#(献花)", "ali_022");
        cJa.put("#(寒)", "ali_023");
        cJa.put("#(傻笑)", "ali_024");
        cJa.put("#(扭扭)", "ali_025");
        cJa.put("#(疯)", "ali_026");
        cJa.put("#(抓狂)", "ali_027");
        cJa.put("#(抓)", "ali_028");
        cJa.put("#(蜷)", "ali_029");
        cJa.put("#(挠墙)", "ali_030");
        cJa.put("#(狂笑)", "ali_031");
        cJa.put("#(抱枕)", "ali_032");
        cJa.put("#(吼叫)", "ali_033");
        cJa.put("#(嚷)", "ali_034");
        cJa.put("#(唠叨)", "ali_035");
        cJa.put("#(捏脸)", "ali_036");
        cJa.put("#(爆笑)", "ali_037");
        cJa.put("#(郁闷)", "ali_038");
        cJa.put("#(潜水)", "ali_039");
        cJa.put("#(十分开心)", "ali_040");
        cJa.put("#(冷笑话)", "ali_041");
        cJa.put("#(顶！)", "ali_042");
        cJa.put("#(潜)", "ali_043");
        cJa.put("#(画圈圈)", "ali_044");
        cJa.put("#(玩电脑)", "ali_045");
        cJa.put("#(狂吐)", "ali_046");
        cJa.put("#(哭着跑)", "ali_047");
        cJa.put("#(阿狸侠)", "ali_048");
        cJa.put("#(冷死了)", "ali_049");
        cJa.put("#(惆怅~)", "ali_050");
        cJa.put("#(摸头)", "ali_051");
        cJa.put("#(蹭)", "ali_052");
        cJa.put("#(打滚)", "ali_053");
        cJa.put("#(叩拜)", "ali_054");
        cJa.put("#(摸)", "ali_055");
        cJa.put("#(数钱)", "ali_056");
        cJa.put("#(拖走)", "ali_057");
        cJa.put("#(热)", "ali_058");
        cJa.put("#(加1)", "ali_059");
        cJa.put("#(压力)", "ali_060");
        cJa.put("#(表逼我)", "ali_061");
        cJa.put("#(人呢)", "ali_062");
        cJa.put("#(摇晃)", "ali_063");
        cJa.put("#(打地鼠)", "ali_064");
        cJa.put("#(这个屌)", "ali_065");
        cJa.put("#(恐慌)", "ali_066");
        cJa.put("#(晕乎乎)", "ali_067");
        cJa.put("#(浮云)", "ali_068");
        cJa.put("#(给力)", "ali_069");
        cJa.put("#(杯具了)", "ali_070");
        cJa.put("#(焦糖舞)", "yz_001");
        cJa.put("#(翻滚)", "yz_002");
        cJa.put("#(拍屁股做鬼脸)", "yz_003");
        cJa.put("#(不)", "yz_004");
        cJa.put("#(河蟹掉啦)", "yz_005");
        cJa.put("#(哦耶)", "yz_006");
        cJa.put("#(我倒)", "yz_007");
        cJa.put("#(投降)", "yz_008");
        cJa.put("#(微笑)", "b01");
        cJa.put("#(帅哥)", "b02");
        cJa.put("#(美女)", "b03");
        cJa.put("#(老大)", "b04");
        cJa.put("#(哈哈哈)", "b05");
        cJa.put("#(奸笑)", "b06");
        cJa.put("#(傻乐)", "b07");
        cJa.put("#(飞吻)", "b08");
        cJa.put("#(害羞)", "b09");
        cJa.put("#(花痴)", "b10");
        cJa.put("#(憧憬)", "b11");
        cJa.put("#(你牛)", "b12");
        cJa.put("#(鼓掌)", "b13");
        cJa.put("#(可爱)", "b14");
        cJa.put("#(太委屈)", "b15");
        cJa.put("#(大哭)", "b16");
        cJa.put("#(泪奔)", "b17");
        cJa.put("#(寻死)", "b18");
        cJa.put("#(非常惊讶)", "b19");
        cJa.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cJa.get(str);
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

    public static ArrayList<TbRichTextData> f(Context context, String str, int i) {
        ArrayList<TbRichTextData> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        arrayList.add(tbRichTextData);
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
                                tbRichTextData.append(str2);
                            } else {
                                SpannableString am = am(context, str2);
                                if (am != null) {
                                    tbRichTextData.append(am);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(tbRichTextData.HH(), name, str3);
                        if (a != null) {
                            tbRichTextData.append(a);
                        }
                    }
                } else {
                    str2 = String.valueOf(str2) + charAt;
                }
                i2++;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (i == 1) {
                    tbRichTextData.append(str2);
                } else {
                    SpannableString am2 = am(context, str2);
                    if (am2 != null) {
                        tbRichTextData.append(am2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.a> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int ff = TbFaceManager.DM().ff(str);
        if (ff != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a(TbadkCoreApplication.m9getInst(), ff);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            a.C0045a fH = TbFaceManager.DM().fH(str);
            if (fH != null) {
                int width = (int) (0.5d * fH.getWidth());
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(aVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString am(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.bb.V(context, str);
    }
}
