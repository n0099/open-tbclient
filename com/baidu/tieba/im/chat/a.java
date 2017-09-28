package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> dmf = new HashMap<>();

    static {
        dmf.put("#(呵呵)", "image_emoticon");
        dmf.put("#(哈哈)", "image_emoticon2");
        dmf.put("#(吐舌)", "image_emoticon3");
        dmf.put("#(啊)", "image_emoticon4");
        dmf.put("#(啊?)", "image_emoticon4");
        dmf.put("#(酷)", "image_emoticon5");
        dmf.put("#(怒)", "image_emoticon6");
        dmf.put("#(开心)", "image_emoticon7");
        dmf.put("#(汗)", "image_emoticon8");
        dmf.put("#(泪)", "image_emoticon9");
        dmf.put("#(黑线)", "image_emoticon10");
        dmf.put("#(鄙视)", "image_emoticon11");
        dmf.put("#(不高兴)", "image_emoticon12");
        dmf.put("#(真棒)", "image_emoticon13");
        dmf.put("#(钱)", "image_emoticon14");
        dmf.put("#(疑问)", "image_emoticon15");
        dmf.put("#(阴险)", "image_emoticon16");
        dmf.put("#(吐)", "image_emoticon17");
        dmf.put("#(咦)", "image_emoticon18");
        dmf.put("#(咦?)", "image_emoticon18");
        dmf.put("#(委屈)", "image_emoticon19");
        dmf.put("#(花心)", "image_emoticon20");
        dmf.put("#(呼~)", "image_emoticon21");
        dmf.put("#(笑眼)", "image_emoticon22");
        dmf.put("#(冷)", "image_emoticon23");
        dmf.put("#(太开心)", "image_emoticon24");
        dmf.put("#(滑稽)", "image_emoticon25");
        dmf.put("#(勉强)", "image_emoticon26");
        dmf.put("#(狂汗)", "image_emoticon27");
        dmf.put("#(乖)", "image_emoticon28");
        dmf.put("#(睡觉)", "image_emoticon29");
        dmf.put("#(惊哭)", "image_emoticon30");
        dmf.put("#(升起)", "image_emoticon31");
        dmf.put("#(惊讶)", "image_emoticon32");
        dmf.put("#(喷)", "image_emoticon33");
        dmf.put("#(爱心)", "image_emoticon34");
        dmf.put("#(心碎)", "image_emoticon35");
        dmf.put("#(玫瑰)", "image_emoticon36");
        dmf.put("#(礼物)", "image_emoticon37");
        dmf.put("#(彩虹)", "image_emoticon38");
        dmf.put("#(星星月亮)", "image_emoticon39");
        dmf.put("#(太阳)", "image_emoticon40");
        dmf.put("#(钱币)", "image_emoticon41");
        dmf.put("#(灯泡)", "image_emoticon42");
        dmf.put("#(茶杯)", "image_emoticon43");
        dmf.put("#(蛋糕)", "image_emoticon44");
        dmf.put("#(音乐)", "image_emoticon45");
        dmf.put("#(haha)", "image_emoticon46");
        dmf.put("#(胜利)", "image_emoticon47");
        dmf.put("#(大拇指)", "image_emoticon48");
        dmf.put("#(弱)", "image_emoticon49");
        dmf.put("#(OK)", "image_emoticon50");
        dmf.put("#(哼)", "image_emoticon61");
        dmf.put("#(吃瓜)", "image_emoticon62");
        dmf.put("#(扔便便)", "image_emoticon63");
        dmf.put("#(惊恐)", "image_emoticon64");
        dmf.put("#(哎呦)", "image_emoticon65");
        dmf.put("#(小乖)", "image_emoticon66");
        dmf.put("#(捂嘴笑)", "image_emoticon67");
        dmf.put("#(你懂的)", "image_emoticon68");
        dmf.put("#(what)", "image_emoticon69");
        dmf.put("#(酸爽)", "image_emoticon70");
        dmf.put("#(呀咩爹)", "image_emoticon71");
        dmf.put("#(笑尿)", "image_emoticon72");
        dmf.put("#(挖鼻)", "image_emoticon73");
        dmf.put("#(犀利)", "image_emoticon74");
        dmf.put("#(小红脸)", "image_emoticon75");
        dmf.put("#(懒得理)", "image_emoticon76");
        dmf.put("#(沙发)", "image_emoticon77");
        dmf.put("#(手纸)", "image_emoticon78");
        dmf.put("#(香蕉)", "image_emoticon79");
        dmf.put("#(便便)", "image_emoticon80");
        dmf.put("#(药丸)", "image_emoticon81");
        dmf.put("#(红领巾)", "image_emoticon82");
        dmf.put("#(蜡烛)", "image_emoticon83");
        dmf.put("#(三道杠)", "image_emoticon84");
        dmf.put("#(赖皮)", "ali_001");
        dmf.put("#(感动)", "ali_002");
        dmf.put("#(十分惊讶)", "ali_003");
        dmf.put("#(怒气)", "ali_004");
        dmf.put("#(哭泣)", "ali_005");
        dmf.put("#(吃惊)", "ali_006");
        dmf.put("#(嘲弄)", "ali_007");
        dmf.put("#(飘过)", "ali_008");
        dmf.put("#(转圈哭)", "ali_009");
        dmf.put("#(神经病)", "ali_010");
        dmf.put("#(揪耳朵)", "ali_011");
        dmf.put("#(惊汗)", "ali_012");
        dmf.put("#(隐身)", "ali_013");
        dmf.put("#(不要嘛)", "ali_014");
        dmf.put("#(遁)", "ali_015");
        dmf.put("#(不公平)", "ali_016");
        dmf.put("#(爬来了)", "ali_017");
        dmf.put("#(蛋花哭)", "ali_018");
        dmf.put("#(温暖)", "ali_019");
        dmf.put("#(点头)", "ali_020");
        dmf.put("#(撒钱)", "ali_021");
        dmf.put("#(献花)", "ali_022");
        dmf.put("#(寒)", "ali_023");
        dmf.put("#(傻笑)", "ali_024");
        dmf.put("#(扭扭)", "ali_025");
        dmf.put("#(疯)", "ali_026");
        dmf.put("#(抓狂)", "ali_027");
        dmf.put("#(抓)", "ali_028");
        dmf.put("#(蜷)", "ali_029");
        dmf.put("#(挠墙)", "ali_030");
        dmf.put("#(狂笑)", "ali_031");
        dmf.put("#(抱枕)", "ali_032");
        dmf.put("#(吼叫)", "ali_033");
        dmf.put("#(嚷)", "ali_034");
        dmf.put("#(唠叨)", "ali_035");
        dmf.put("#(捏脸)", "ali_036");
        dmf.put("#(爆笑)", "ali_037");
        dmf.put("#(郁闷)", "ali_038");
        dmf.put("#(潜水)", "ali_039");
        dmf.put("#(十分开心)", "ali_040");
        dmf.put("#(冷笑话)", "ali_041");
        dmf.put("#(顶！)", "ali_042");
        dmf.put("#(潜)", "ali_043");
        dmf.put("#(画圈圈)", "ali_044");
        dmf.put("#(玩电脑)", "ali_045");
        dmf.put("#(狂吐)", "ali_046");
        dmf.put("#(哭着跑)", "ali_047");
        dmf.put("#(阿狸侠)", "ali_048");
        dmf.put("#(冷死了)", "ali_049");
        dmf.put("#(惆怅~)", "ali_050");
        dmf.put("#(摸头)", "ali_051");
        dmf.put("#(蹭)", "ali_052");
        dmf.put("#(打滚)", "ali_053");
        dmf.put("#(叩拜)", "ali_054");
        dmf.put("#(摸)", "ali_055");
        dmf.put("#(数钱)", "ali_056");
        dmf.put("#(拖走)", "ali_057");
        dmf.put("#(热)", "ali_058");
        dmf.put("#(加1)", "ali_059");
        dmf.put("#(压力)", "ali_060");
        dmf.put("#(表逼我)", "ali_061");
        dmf.put("#(人呢)", "ali_062");
        dmf.put("#(摇晃)", "ali_063");
        dmf.put("#(打地鼠)", "ali_064");
        dmf.put("#(这个屌)", "ali_065");
        dmf.put("#(恐慌)", "ali_066");
        dmf.put("#(晕乎乎)", "ali_067");
        dmf.put("#(浮云)", "ali_068");
        dmf.put("#(给力)", "ali_069");
        dmf.put("#(杯具了)", "ali_070");
        dmf.put("#(焦糖舞)", "yz_001");
        dmf.put("#(翻滚)", "yz_002");
        dmf.put("#(拍屁股做鬼脸)", "yz_003");
        dmf.put("#(不)", "yz_004");
        dmf.put("#(河蟹掉啦)", "yz_005");
        dmf.put("#(哦耶)", "yz_006");
        dmf.put("#(我倒)", "yz_007");
        dmf.put("#(投降)", "yz_008");
        dmf.put("#(微笑)", "b01");
        dmf.put("#(帅哥)", "b02");
        dmf.put("#(美女)", "b03");
        dmf.put("#(老大)", "b04");
        dmf.put("#(哈哈哈)", "b05");
        dmf.put("#(奸笑)", "b06");
        dmf.put("#(傻乐)", "b07");
        dmf.put("#(飞吻)", "b08");
        dmf.put("#(害羞)", "b09");
        dmf.put("#(花痴)", "b10");
        dmf.put("#(憧憬)", "b11");
        dmf.put("#(你牛)", "b12");
        dmf.put("#(鼓掌)", "b13");
        dmf.put("#(可爱)", "b14");
        dmf.put("#(太委屈)", "b15");
        dmf.put("#(大哭)", "b16");
        dmf.put("#(泪奔)", "b17");
        dmf.put("#(寻死)", "b18");
        dmf.put("#(非常惊讶)", "b19");
        dmf.put("#(表示疑问)", "b20");
        dmf.put("#(暗中观察)", "image_emoticon85");
        dmf.put("#(吃瓜)", "image_emoticon86");
        dmf.put("#(喝酒)", "image_emoticon87");
        dmf.put("#(嘿嘿嘿)", "image_emoticon88");
        dmf.put("#(噗)", "image_emoticon89");
        dmf.put("#(困成狗)", "image_emoticon90");
        dmf.put("#(微微一笑)", "image_emoticon91");
        dmf.put("#(托腮)", "image_emoticon92");
        dmf.put("#(摊手)", "image_emoticon93");
        dmf.put("#(柯基暗中观察)", "image_emoticon94");
        dmf.put("#(欢呼)", "image_emoticon95");
        dmf.put("#(炸药)", "image_emoticon96");
        dmf.put("#(突然兴奋)", "image_emoticon97");
        dmf.put("#(紧张)", "image_emoticon98");
        dmf.put("#(黑头瞪眼)", "image_emoticon99");
        dmf.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return dmf.get(str);
    }

    public static List<TbFaceManager.RichUnit> lC(String str) {
        String str2;
        String str3;
        String str4;
        String str5 = "";
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (true) {
            str2 = str5;
            if (i >= str.length()) {
                break;
            }
            char charAt = str.charAt(i);
            if (charAt == '#' && i < length - 1 && str.charAt(i + 1) == '(') {
                int i2 = i + 2;
                String str6 = "#(";
                while (true) {
                    if (i2 >= length) {
                        str3 = str6;
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    str6 = str6 + charAt2;
                    if (charAt2 == ')') {
                        str3 = str6;
                        break;
                    }
                    i2++;
                }
                String name = getName(str3);
                if (TextUtils.isEmpty(name)) {
                    str4 = str2 + str3;
                } else {
                    if (TextUtils.isEmpty(str2)) {
                        str4 = str2;
                    } else {
                        arrayList.add(lD(str2));
                        str4 = "";
                    }
                    arrayList.add(bc(str3, name));
                }
                int i3 = i2;
                str5 = str4;
                i = i3;
            } else {
                str5 = str2 + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(lD(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit lD(String str) {
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

    public static ArrayList<TbRichTextData> f(Context context, String str, int i) {
        String str2;
        String str3;
        String str4;
        ArrayList<TbRichTextData> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        arrayList.add(tbRichTextData);
        try {
            String str5 = "";
            int length = str.length();
            int i2 = 0;
            while (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt == '#' && i2 < length - 1 && str.charAt(i2 + 1) == '(') {
                    int i3 = i2 + 2;
                    String str6 = "#(";
                    while (true) {
                        if (i3 >= length) {
                            str3 = str6;
                            break;
                        }
                        char charAt2 = str.charAt(i3);
                        str6 = str6 + charAt2;
                        if (charAt2 != ')') {
                            if (i3 + 1 < length && str.charAt(i3 + 1) == '#') {
                                str3 = str6;
                                break;
                            }
                            i3++;
                        } else {
                            str3 = str6;
                            break;
                        }
                    }
                    String name = getName(str3);
                    if (TextUtils.isEmpty(name)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.append(str5);
                            } else {
                                SpannableString am = am(context, str5);
                                if (am != null) {
                                    tbRichTextData.append(am);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.II(), name, str3);
                        if (b != null) {
                            tbRichTextData.append(b);
                        }
                    }
                    int i4 = i3;
                    str2 = str4;
                    i2 = i4;
                } else {
                    str2 = str5 + charAt;
                }
                i2++;
                str5 = str2;
            }
            if (!TextUtils.isEmpty(str5)) {
                if (i == 1) {
                    tbRichTextData.append(str5);
                } else {
                    SpannableString am2 = am(context, str5);
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
        int fz = TbFaceManager.DY().fz(str);
        if (fz != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a(TbadkCoreApplication.getInst(), fz);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            a.C0058a gb = TbFaceManager.DY().gb(str);
            if (gb != null) {
                int width = (int) (0.5d * gb.getWidth());
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
        return av.W(context, str);
    }
}
