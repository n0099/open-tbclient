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
    private static final HashMap<String, String> cOj = new HashMap<>();

    static {
        cOj.put("#(呵呵)", "image_emoticon");
        cOj.put("#(哈哈)", "image_emoticon2");
        cOj.put("#(吐舌)", "image_emoticon3");
        cOj.put("#(啊)", "image_emoticon4");
        cOj.put("#(啊?)", "image_emoticon4");
        cOj.put("#(酷)", "image_emoticon5");
        cOj.put("#(怒)", "image_emoticon6");
        cOj.put("#(开心)", "image_emoticon7");
        cOj.put("#(汗)", "image_emoticon8");
        cOj.put("#(泪)", "image_emoticon9");
        cOj.put("#(黑线)", "image_emoticon10");
        cOj.put("#(鄙视)", "image_emoticon11");
        cOj.put("#(不高兴)", "image_emoticon12");
        cOj.put("#(真棒)", "image_emoticon13");
        cOj.put("#(钱)", "image_emoticon14");
        cOj.put("#(疑问)", "image_emoticon15");
        cOj.put("#(阴险)", "image_emoticon16");
        cOj.put("#(吐)", "image_emoticon17");
        cOj.put("#(咦)", "image_emoticon18");
        cOj.put("#(咦?)", "image_emoticon18");
        cOj.put("#(委屈)", "image_emoticon19");
        cOj.put("#(花心)", "image_emoticon20");
        cOj.put("#(呼~)", "image_emoticon21");
        cOj.put("#(笑眼)", "image_emoticon22");
        cOj.put("#(冷)", "image_emoticon23");
        cOj.put("#(太开心)", "image_emoticon24");
        cOj.put("#(滑稽)", "image_emoticon25");
        cOj.put("#(勉强)", "image_emoticon26");
        cOj.put("#(狂汗)", "image_emoticon27");
        cOj.put("#(乖)", "image_emoticon28");
        cOj.put("#(睡觉)", "image_emoticon29");
        cOj.put("#(惊哭)", "image_emoticon30");
        cOj.put("#(升起)", "image_emoticon31");
        cOj.put("#(惊讶)", "image_emoticon32");
        cOj.put("#(喷)", "image_emoticon33");
        cOj.put("#(爱心)", "image_emoticon34");
        cOj.put("#(心碎)", "image_emoticon35");
        cOj.put("#(玫瑰)", "image_emoticon36");
        cOj.put("#(礼物)", "image_emoticon37");
        cOj.put("#(彩虹)", "image_emoticon38");
        cOj.put("#(星星月亮)", "image_emoticon39");
        cOj.put("#(太阳)", "image_emoticon40");
        cOj.put("#(钱币)", "image_emoticon41");
        cOj.put("#(灯泡)", "image_emoticon42");
        cOj.put("#(茶杯)", "image_emoticon43");
        cOj.put("#(蛋糕)", "image_emoticon44");
        cOj.put("#(音乐)", "image_emoticon45");
        cOj.put("#(haha)", "image_emoticon46");
        cOj.put("#(胜利)", "image_emoticon47");
        cOj.put("#(大拇指)", "image_emoticon48");
        cOj.put("#(弱)", "image_emoticon49");
        cOj.put("#(OK)", "image_emoticon50");
        cOj.put("#(哼)", "image_emoticon61");
        cOj.put("#(吃瓜)", "image_emoticon62");
        cOj.put("#(扔便便)", "image_emoticon63");
        cOj.put("#(惊恐)", "image_emoticon64");
        cOj.put("#(哎呦)", "image_emoticon65");
        cOj.put("#(小乖)", "image_emoticon66");
        cOj.put("#(捂嘴笑)", "image_emoticon67");
        cOj.put("#(你懂的)", "image_emoticon68");
        cOj.put("#(what)", "image_emoticon69");
        cOj.put("#(酸爽)", "image_emoticon70");
        cOj.put("#(呀咩爹)", "image_emoticon71");
        cOj.put("#(笑尿)", "image_emoticon72");
        cOj.put("#(挖鼻)", "image_emoticon73");
        cOj.put("#(犀利)", "image_emoticon74");
        cOj.put("#(小红脸)", "image_emoticon75");
        cOj.put("#(懒得理)", "image_emoticon76");
        cOj.put("#(沙发)", "image_emoticon77");
        cOj.put("#(手纸)", "image_emoticon78");
        cOj.put("#(香蕉)", "image_emoticon79");
        cOj.put("#(便便)", "image_emoticon80");
        cOj.put("#(药丸)", "image_emoticon81");
        cOj.put("#(红领巾)", "image_emoticon82");
        cOj.put("#(蜡烛)", "image_emoticon83");
        cOj.put("#(三道杠)", "image_emoticon84");
        cOj.put("#(赖皮)", "ali_001");
        cOj.put("#(感动)", "ali_002");
        cOj.put("#(十分惊讶)", "ali_003");
        cOj.put("#(怒气)", "ali_004");
        cOj.put("#(哭泣)", "ali_005");
        cOj.put("#(吃惊)", "ali_006");
        cOj.put("#(嘲弄)", "ali_007");
        cOj.put("#(飘过)", "ali_008");
        cOj.put("#(转圈哭)", "ali_009");
        cOj.put("#(神经病)", "ali_010");
        cOj.put("#(揪耳朵)", "ali_011");
        cOj.put("#(惊汗)", "ali_012");
        cOj.put("#(隐身)", "ali_013");
        cOj.put("#(不要嘛)", "ali_014");
        cOj.put("#(遁)", "ali_015");
        cOj.put("#(不公平)", "ali_016");
        cOj.put("#(爬来了)", "ali_017");
        cOj.put("#(蛋花哭)", "ali_018");
        cOj.put("#(温暖)", "ali_019");
        cOj.put("#(点头)", "ali_020");
        cOj.put("#(撒钱)", "ali_021");
        cOj.put("#(献花)", "ali_022");
        cOj.put("#(寒)", "ali_023");
        cOj.put("#(傻笑)", "ali_024");
        cOj.put("#(扭扭)", "ali_025");
        cOj.put("#(疯)", "ali_026");
        cOj.put("#(抓狂)", "ali_027");
        cOj.put("#(抓)", "ali_028");
        cOj.put("#(蜷)", "ali_029");
        cOj.put("#(挠墙)", "ali_030");
        cOj.put("#(狂笑)", "ali_031");
        cOj.put("#(抱枕)", "ali_032");
        cOj.put("#(吼叫)", "ali_033");
        cOj.put("#(嚷)", "ali_034");
        cOj.put("#(唠叨)", "ali_035");
        cOj.put("#(捏脸)", "ali_036");
        cOj.put("#(爆笑)", "ali_037");
        cOj.put("#(郁闷)", "ali_038");
        cOj.put("#(潜水)", "ali_039");
        cOj.put("#(十分开心)", "ali_040");
        cOj.put("#(冷笑话)", "ali_041");
        cOj.put("#(顶！)", "ali_042");
        cOj.put("#(潜)", "ali_043");
        cOj.put("#(画圈圈)", "ali_044");
        cOj.put("#(玩电脑)", "ali_045");
        cOj.put("#(狂吐)", "ali_046");
        cOj.put("#(哭着跑)", "ali_047");
        cOj.put("#(阿狸侠)", "ali_048");
        cOj.put("#(冷死了)", "ali_049");
        cOj.put("#(惆怅~)", "ali_050");
        cOj.put("#(摸头)", "ali_051");
        cOj.put("#(蹭)", "ali_052");
        cOj.put("#(打滚)", "ali_053");
        cOj.put("#(叩拜)", "ali_054");
        cOj.put("#(摸)", "ali_055");
        cOj.put("#(数钱)", "ali_056");
        cOj.put("#(拖走)", "ali_057");
        cOj.put("#(热)", "ali_058");
        cOj.put("#(加1)", "ali_059");
        cOj.put("#(压力)", "ali_060");
        cOj.put("#(表逼我)", "ali_061");
        cOj.put("#(人呢)", "ali_062");
        cOj.put("#(摇晃)", "ali_063");
        cOj.put("#(打地鼠)", "ali_064");
        cOj.put("#(这个屌)", "ali_065");
        cOj.put("#(恐慌)", "ali_066");
        cOj.put("#(晕乎乎)", "ali_067");
        cOj.put("#(浮云)", "ali_068");
        cOj.put("#(给力)", "ali_069");
        cOj.put("#(杯具了)", "ali_070");
        cOj.put("#(焦糖舞)", "yz_001");
        cOj.put("#(翻滚)", "yz_002");
        cOj.put("#(拍屁股做鬼脸)", "yz_003");
        cOj.put("#(不)", "yz_004");
        cOj.put("#(河蟹掉啦)", "yz_005");
        cOj.put("#(哦耶)", "yz_006");
        cOj.put("#(我倒)", "yz_007");
        cOj.put("#(投降)", "yz_008");
        cOj.put("#(微笑)", "b01");
        cOj.put("#(帅哥)", "b02");
        cOj.put("#(美女)", "b03");
        cOj.put("#(老大)", "b04");
        cOj.put("#(哈哈哈)", "b05");
        cOj.put("#(奸笑)", "b06");
        cOj.put("#(傻乐)", "b07");
        cOj.put("#(飞吻)", "b08");
        cOj.put("#(害羞)", "b09");
        cOj.put("#(花痴)", "b10");
        cOj.put("#(憧憬)", "b11");
        cOj.put("#(你牛)", "b12");
        cOj.put("#(鼓掌)", "b13");
        cOj.put("#(可爱)", "b14");
        cOj.put("#(太委屈)", "b15");
        cOj.put("#(大哭)", "b16");
        cOj.put("#(泪奔)", "b17");
        cOj.put("#(寻死)", "b18");
        cOj.put("#(非常惊讶)", "b19");
        cOj.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cOj.get(str);
    }

    public static List<TbFaceManager.RichUnit> jL(String str) {
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
                        arrayList.add(jM(str2));
                        str2 = "";
                    }
                    arrayList.add(aV(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(jM(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit jM(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aV(String str, String str2) {
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
                                SpannableString aj = aj(context, str2);
                                if (aj != null) {
                                    tbRichTextData.append(aj);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(tbRichTextData.HU(), name, str3);
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
                    SpannableString aj2 = aj(context, str2);
                    if (aj2 != null) {
                        tbRichTextData.append(aj2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.a> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fc = TbFaceManager.Ek().fc(str);
        if (fc != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a(TbadkCoreApplication.m9getInst(), fc);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            a.C0043a fE = TbFaceManager.Ek().fE(str);
            if (fE != null) {
                int width = (int) (0.5d * fE.getWidth());
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(aVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aj(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.bb.R(context, str);
    }
}
