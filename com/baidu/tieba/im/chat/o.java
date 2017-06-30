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
    private static final HashMap<String, String> cWu = new HashMap<>();

    static {
        cWu.put("#(呵呵)", "image_emoticon");
        cWu.put("#(哈哈)", "image_emoticon2");
        cWu.put("#(吐舌)", "image_emoticon3");
        cWu.put("#(啊)", "image_emoticon4");
        cWu.put("#(啊?)", "image_emoticon4");
        cWu.put("#(酷)", "image_emoticon5");
        cWu.put("#(怒)", "image_emoticon6");
        cWu.put("#(开心)", "image_emoticon7");
        cWu.put("#(汗)", "image_emoticon8");
        cWu.put("#(泪)", "image_emoticon9");
        cWu.put("#(黑线)", "image_emoticon10");
        cWu.put("#(鄙视)", "image_emoticon11");
        cWu.put("#(不高兴)", "image_emoticon12");
        cWu.put("#(真棒)", "image_emoticon13");
        cWu.put("#(钱)", "image_emoticon14");
        cWu.put("#(疑问)", "image_emoticon15");
        cWu.put("#(阴险)", "image_emoticon16");
        cWu.put("#(吐)", "image_emoticon17");
        cWu.put("#(咦)", "image_emoticon18");
        cWu.put("#(咦?)", "image_emoticon18");
        cWu.put("#(委屈)", "image_emoticon19");
        cWu.put("#(花心)", "image_emoticon20");
        cWu.put("#(呼~)", "image_emoticon21");
        cWu.put("#(笑眼)", "image_emoticon22");
        cWu.put("#(冷)", "image_emoticon23");
        cWu.put("#(太开心)", "image_emoticon24");
        cWu.put("#(滑稽)", "image_emoticon25");
        cWu.put("#(勉强)", "image_emoticon26");
        cWu.put("#(狂汗)", "image_emoticon27");
        cWu.put("#(乖)", "image_emoticon28");
        cWu.put("#(睡觉)", "image_emoticon29");
        cWu.put("#(惊哭)", "image_emoticon30");
        cWu.put("#(升起)", "image_emoticon31");
        cWu.put("#(惊讶)", "image_emoticon32");
        cWu.put("#(喷)", "image_emoticon33");
        cWu.put("#(爱心)", "image_emoticon34");
        cWu.put("#(心碎)", "image_emoticon35");
        cWu.put("#(玫瑰)", "image_emoticon36");
        cWu.put("#(礼物)", "image_emoticon37");
        cWu.put("#(彩虹)", "image_emoticon38");
        cWu.put("#(星星月亮)", "image_emoticon39");
        cWu.put("#(太阳)", "image_emoticon40");
        cWu.put("#(钱币)", "image_emoticon41");
        cWu.put("#(灯泡)", "image_emoticon42");
        cWu.put("#(茶杯)", "image_emoticon43");
        cWu.put("#(蛋糕)", "image_emoticon44");
        cWu.put("#(音乐)", "image_emoticon45");
        cWu.put("#(haha)", "image_emoticon46");
        cWu.put("#(胜利)", "image_emoticon47");
        cWu.put("#(大拇指)", "image_emoticon48");
        cWu.put("#(弱)", "image_emoticon49");
        cWu.put("#(OK)", "image_emoticon50");
        cWu.put("#(哼)", "image_emoticon61");
        cWu.put("#(吃瓜)", "image_emoticon62");
        cWu.put("#(扔便便)", "image_emoticon63");
        cWu.put("#(惊恐)", "image_emoticon64");
        cWu.put("#(哎呦)", "image_emoticon65");
        cWu.put("#(小乖)", "image_emoticon66");
        cWu.put("#(捂嘴笑)", "image_emoticon67");
        cWu.put("#(你懂的)", "image_emoticon68");
        cWu.put("#(what)", "image_emoticon69");
        cWu.put("#(酸爽)", "image_emoticon70");
        cWu.put("#(呀咩爹)", "image_emoticon71");
        cWu.put("#(笑尿)", "image_emoticon72");
        cWu.put("#(挖鼻)", "image_emoticon73");
        cWu.put("#(犀利)", "image_emoticon74");
        cWu.put("#(小红脸)", "image_emoticon75");
        cWu.put("#(懒得理)", "image_emoticon76");
        cWu.put("#(沙发)", "image_emoticon77");
        cWu.put("#(手纸)", "image_emoticon78");
        cWu.put("#(香蕉)", "image_emoticon79");
        cWu.put("#(便便)", "image_emoticon80");
        cWu.put("#(药丸)", "image_emoticon81");
        cWu.put("#(红领巾)", "image_emoticon82");
        cWu.put("#(蜡烛)", "image_emoticon83");
        cWu.put("#(三道杠)", "image_emoticon84");
        cWu.put("#(赖皮)", "ali_001");
        cWu.put("#(感动)", "ali_002");
        cWu.put("#(十分惊讶)", "ali_003");
        cWu.put("#(怒气)", "ali_004");
        cWu.put("#(哭泣)", "ali_005");
        cWu.put("#(吃惊)", "ali_006");
        cWu.put("#(嘲弄)", "ali_007");
        cWu.put("#(飘过)", "ali_008");
        cWu.put("#(转圈哭)", "ali_009");
        cWu.put("#(神经病)", "ali_010");
        cWu.put("#(揪耳朵)", "ali_011");
        cWu.put("#(惊汗)", "ali_012");
        cWu.put("#(隐身)", "ali_013");
        cWu.put("#(不要嘛)", "ali_014");
        cWu.put("#(遁)", "ali_015");
        cWu.put("#(不公平)", "ali_016");
        cWu.put("#(爬来了)", "ali_017");
        cWu.put("#(蛋花哭)", "ali_018");
        cWu.put("#(温暖)", "ali_019");
        cWu.put("#(点头)", "ali_020");
        cWu.put("#(撒钱)", "ali_021");
        cWu.put("#(献花)", "ali_022");
        cWu.put("#(寒)", "ali_023");
        cWu.put("#(傻笑)", "ali_024");
        cWu.put("#(扭扭)", "ali_025");
        cWu.put("#(疯)", "ali_026");
        cWu.put("#(抓狂)", "ali_027");
        cWu.put("#(抓)", "ali_028");
        cWu.put("#(蜷)", "ali_029");
        cWu.put("#(挠墙)", "ali_030");
        cWu.put("#(狂笑)", "ali_031");
        cWu.put("#(抱枕)", "ali_032");
        cWu.put("#(吼叫)", "ali_033");
        cWu.put("#(嚷)", "ali_034");
        cWu.put("#(唠叨)", "ali_035");
        cWu.put("#(捏脸)", "ali_036");
        cWu.put("#(爆笑)", "ali_037");
        cWu.put("#(郁闷)", "ali_038");
        cWu.put("#(潜水)", "ali_039");
        cWu.put("#(十分开心)", "ali_040");
        cWu.put("#(冷笑话)", "ali_041");
        cWu.put("#(顶！)", "ali_042");
        cWu.put("#(潜)", "ali_043");
        cWu.put("#(画圈圈)", "ali_044");
        cWu.put("#(玩电脑)", "ali_045");
        cWu.put("#(狂吐)", "ali_046");
        cWu.put("#(哭着跑)", "ali_047");
        cWu.put("#(阿狸侠)", "ali_048");
        cWu.put("#(冷死了)", "ali_049");
        cWu.put("#(惆怅~)", "ali_050");
        cWu.put("#(摸头)", "ali_051");
        cWu.put("#(蹭)", "ali_052");
        cWu.put("#(打滚)", "ali_053");
        cWu.put("#(叩拜)", "ali_054");
        cWu.put("#(摸)", "ali_055");
        cWu.put("#(数钱)", "ali_056");
        cWu.put("#(拖走)", "ali_057");
        cWu.put("#(热)", "ali_058");
        cWu.put("#(加1)", "ali_059");
        cWu.put("#(压力)", "ali_060");
        cWu.put("#(表逼我)", "ali_061");
        cWu.put("#(人呢)", "ali_062");
        cWu.put("#(摇晃)", "ali_063");
        cWu.put("#(打地鼠)", "ali_064");
        cWu.put("#(这个屌)", "ali_065");
        cWu.put("#(恐慌)", "ali_066");
        cWu.put("#(晕乎乎)", "ali_067");
        cWu.put("#(浮云)", "ali_068");
        cWu.put("#(给力)", "ali_069");
        cWu.put("#(杯具了)", "ali_070");
        cWu.put("#(焦糖舞)", "yz_001");
        cWu.put("#(翻滚)", "yz_002");
        cWu.put("#(拍屁股做鬼脸)", "yz_003");
        cWu.put("#(不)", "yz_004");
        cWu.put("#(河蟹掉啦)", "yz_005");
        cWu.put("#(哦耶)", "yz_006");
        cWu.put("#(我倒)", "yz_007");
        cWu.put("#(投降)", "yz_008");
        cWu.put("#(微笑)", "b01");
        cWu.put("#(帅哥)", "b02");
        cWu.put("#(美女)", "b03");
        cWu.put("#(老大)", "b04");
        cWu.put("#(哈哈哈)", "b05");
        cWu.put("#(奸笑)", "b06");
        cWu.put("#(傻乐)", "b07");
        cWu.put("#(飞吻)", "b08");
        cWu.put("#(害羞)", "b09");
        cWu.put("#(花痴)", "b10");
        cWu.put("#(憧憬)", "b11");
        cWu.put("#(你牛)", "b12");
        cWu.put("#(鼓掌)", "b13");
        cWu.put("#(可爱)", "b14");
        cWu.put("#(太委屈)", "b15");
        cWu.put("#(大哭)", "b16");
        cWu.put("#(泪奔)", "b17");
        cWu.put("#(寻死)", "b18");
        cWu.put("#(非常惊讶)", "b19");
        cWu.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cWu.get(str);
    }

    public static List<TbFaceManager.RichUnit> le(String str) {
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
                        arrayList.add(lf(str2));
                        str2 = "";
                    }
                    arrayList.add(bd(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(lf(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit lf(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit bd(String str, String str2) {
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
                        SpannableString b = b(tbRichTextData.HZ(), name, str3);
                        if (b != null) {
                            tbRichTextData.append(b);
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

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.a> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fx = TbFaceManager.Ea().fx(str);
        if (fx != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a(TbadkCoreApplication.m9getInst(), fx);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            a.C0047a fZ = TbFaceManager.Ea().fZ(str);
            if (fZ != null) {
                int width = (int) (0.5d * fZ.getWidth());
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
        return com.baidu.tbadk.core.util.be.W(context, str);
    }
}
