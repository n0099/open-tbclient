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
    private static final HashMap<String, String> dlS = new HashMap<>();

    static {
        dlS.put("#(呵呵)", "image_emoticon");
        dlS.put("#(哈哈)", "image_emoticon2");
        dlS.put("#(吐舌)", "image_emoticon3");
        dlS.put("#(啊)", "image_emoticon4");
        dlS.put("#(啊?)", "image_emoticon4");
        dlS.put("#(酷)", "image_emoticon5");
        dlS.put("#(怒)", "image_emoticon6");
        dlS.put("#(开心)", "image_emoticon7");
        dlS.put("#(汗)", "image_emoticon8");
        dlS.put("#(泪)", "image_emoticon9");
        dlS.put("#(黑线)", "image_emoticon10");
        dlS.put("#(鄙视)", "image_emoticon11");
        dlS.put("#(不高兴)", "image_emoticon12");
        dlS.put("#(真棒)", "image_emoticon13");
        dlS.put("#(钱)", "image_emoticon14");
        dlS.put("#(疑问)", "image_emoticon15");
        dlS.put("#(阴险)", "image_emoticon16");
        dlS.put("#(吐)", "image_emoticon17");
        dlS.put("#(咦)", "image_emoticon18");
        dlS.put("#(咦?)", "image_emoticon18");
        dlS.put("#(委屈)", "image_emoticon19");
        dlS.put("#(花心)", "image_emoticon20");
        dlS.put("#(呼~)", "image_emoticon21");
        dlS.put("#(笑眼)", "image_emoticon22");
        dlS.put("#(冷)", "image_emoticon23");
        dlS.put("#(太开心)", "image_emoticon24");
        dlS.put("#(滑稽)", "image_emoticon25");
        dlS.put("#(勉强)", "image_emoticon26");
        dlS.put("#(狂汗)", "image_emoticon27");
        dlS.put("#(乖)", "image_emoticon28");
        dlS.put("#(睡觉)", "image_emoticon29");
        dlS.put("#(惊哭)", "image_emoticon30");
        dlS.put("#(升起)", "image_emoticon31");
        dlS.put("#(惊讶)", "image_emoticon32");
        dlS.put("#(喷)", "image_emoticon33");
        dlS.put("#(爱心)", "image_emoticon34");
        dlS.put("#(心碎)", "image_emoticon35");
        dlS.put("#(玫瑰)", "image_emoticon36");
        dlS.put("#(礼物)", "image_emoticon37");
        dlS.put("#(彩虹)", "image_emoticon38");
        dlS.put("#(星星月亮)", "image_emoticon39");
        dlS.put("#(太阳)", "image_emoticon40");
        dlS.put("#(钱币)", "image_emoticon41");
        dlS.put("#(灯泡)", "image_emoticon42");
        dlS.put("#(茶杯)", "image_emoticon43");
        dlS.put("#(蛋糕)", "image_emoticon44");
        dlS.put("#(音乐)", "image_emoticon45");
        dlS.put("#(haha)", "image_emoticon46");
        dlS.put("#(胜利)", "image_emoticon47");
        dlS.put("#(大拇指)", "image_emoticon48");
        dlS.put("#(弱)", "image_emoticon49");
        dlS.put("#(OK)", "image_emoticon50");
        dlS.put("#(哼)", "image_emoticon61");
        dlS.put("#(吃瓜)", "image_emoticon62");
        dlS.put("#(扔便便)", "image_emoticon63");
        dlS.put("#(惊恐)", "image_emoticon64");
        dlS.put("#(哎呦)", "image_emoticon65");
        dlS.put("#(小乖)", "image_emoticon66");
        dlS.put("#(捂嘴笑)", "image_emoticon67");
        dlS.put("#(你懂的)", "image_emoticon68");
        dlS.put("#(what)", "image_emoticon69");
        dlS.put("#(酸爽)", "image_emoticon70");
        dlS.put("#(呀咩爹)", "image_emoticon71");
        dlS.put("#(笑尿)", "image_emoticon72");
        dlS.put("#(挖鼻)", "image_emoticon73");
        dlS.put("#(犀利)", "image_emoticon74");
        dlS.put("#(小红脸)", "image_emoticon75");
        dlS.put("#(懒得理)", "image_emoticon76");
        dlS.put("#(沙发)", "image_emoticon77");
        dlS.put("#(手纸)", "image_emoticon78");
        dlS.put("#(香蕉)", "image_emoticon79");
        dlS.put("#(便便)", "image_emoticon80");
        dlS.put("#(药丸)", "image_emoticon81");
        dlS.put("#(红领巾)", "image_emoticon82");
        dlS.put("#(蜡烛)", "image_emoticon83");
        dlS.put("#(三道杠)", "image_emoticon84");
        dlS.put("#(赖皮)", "ali_001");
        dlS.put("#(感动)", "ali_002");
        dlS.put("#(十分惊讶)", "ali_003");
        dlS.put("#(怒气)", "ali_004");
        dlS.put("#(哭泣)", "ali_005");
        dlS.put("#(吃惊)", "ali_006");
        dlS.put("#(嘲弄)", "ali_007");
        dlS.put("#(飘过)", "ali_008");
        dlS.put("#(转圈哭)", "ali_009");
        dlS.put("#(神经病)", "ali_010");
        dlS.put("#(揪耳朵)", "ali_011");
        dlS.put("#(惊汗)", "ali_012");
        dlS.put("#(隐身)", "ali_013");
        dlS.put("#(不要嘛)", "ali_014");
        dlS.put("#(遁)", "ali_015");
        dlS.put("#(不公平)", "ali_016");
        dlS.put("#(爬来了)", "ali_017");
        dlS.put("#(蛋花哭)", "ali_018");
        dlS.put("#(温暖)", "ali_019");
        dlS.put("#(点头)", "ali_020");
        dlS.put("#(撒钱)", "ali_021");
        dlS.put("#(献花)", "ali_022");
        dlS.put("#(寒)", "ali_023");
        dlS.put("#(傻笑)", "ali_024");
        dlS.put("#(扭扭)", "ali_025");
        dlS.put("#(疯)", "ali_026");
        dlS.put("#(抓狂)", "ali_027");
        dlS.put("#(抓)", "ali_028");
        dlS.put("#(蜷)", "ali_029");
        dlS.put("#(挠墙)", "ali_030");
        dlS.put("#(狂笑)", "ali_031");
        dlS.put("#(抱枕)", "ali_032");
        dlS.put("#(吼叫)", "ali_033");
        dlS.put("#(嚷)", "ali_034");
        dlS.put("#(唠叨)", "ali_035");
        dlS.put("#(捏脸)", "ali_036");
        dlS.put("#(爆笑)", "ali_037");
        dlS.put("#(郁闷)", "ali_038");
        dlS.put("#(潜水)", "ali_039");
        dlS.put("#(十分开心)", "ali_040");
        dlS.put("#(冷笑话)", "ali_041");
        dlS.put("#(顶！)", "ali_042");
        dlS.put("#(潜)", "ali_043");
        dlS.put("#(画圈圈)", "ali_044");
        dlS.put("#(玩电脑)", "ali_045");
        dlS.put("#(狂吐)", "ali_046");
        dlS.put("#(哭着跑)", "ali_047");
        dlS.put("#(阿狸侠)", "ali_048");
        dlS.put("#(冷死了)", "ali_049");
        dlS.put("#(惆怅~)", "ali_050");
        dlS.put("#(摸头)", "ali_051");
        dlS.put("#(蹭)", "ali_052");
        dlS.put("#(打滚)", "ali_053");
        dlS.put("#(叩拜)", "ali_054");
        dlS.put("#(摸)", "ali_055");
        dlS.put("#(数钱)", "ali_056");
        dlS.put("#(拖走)", "ali_057");
        dlS.put("#(热)", "ali_058");
        dlS.put("#(加1)", "ali_059");
        dlS.put("#(压力)", "ali_060");
        dlS.put("#(表逼我)", "ali_061");
        dlS.put("#(人呢)", "ali_062");
        dlS.put("#(摇晃)", "ali_063");
        dlS.put("#(打地鼠)", "ali_064");
        dlS.put("#(这个屌)", "ali_065");
        dlS.put("#(恐慌)", "ali_066");
        dlS.put("#(晕乎乎)", "ali_067");
        dlS.put("#(浮云)", "ali_068");
        dlS.put("#(给力)", "ali_069");
        dlS.put("#(杯具了)", "ali_070");
        dlS.put("#(焦糖舞)", "yz_001");
        dlS.put("#(翻滚)", "yz_002");
        dlS.put("#(拍屁股做鬼脸)", "yz_003");
        dlS.put("#(不)", "yz_004");
        dlS.put("#(河蟹掉啦)", "yz_005");
        dlS.put("#(哦耶)", "yz_006");
        dlS.put("#(我倒)", "yz_007");
        dlS.put("#(投降)", "yz_008");
        dlS.put("#(微笑)", "b01");
        dlS.put("#(帅哥)", "b02");
        dlS.put("#(美女)", "b03");
        dlS.put("#(老大)", "b04");
        dlS.put("#(哈哈哈)", "b05");
        dlS.put("#(奸笑)", "b06");
        dlS.put("#(傻乐)", "b07");
        dlS.put("#(飞吻)", "b08");
        dlS.put("#(害羞)", "b09");
        dlS.put("#(花痴)", "b10");
        dlS.put("#(憧憬)", "b11");
        dlS.put("#(你牛)", "b12");
        dlS.put("#(鼓掌)", "b13");
        dlS.put("#(可爱)", "b14");
        dlS.put("#(太委屈)", "b15");
        dlS.put("#(大哭)", "b16");
        dlS.put("#(泪奔)", "b17");
        dlS.put("#(寻死)", "b18");
        dlS.put("#(非常惊讶)", "b19");
        dlS.put("#(表示疑问)", "b20");
        dlS.put("#(暗中观察)", "image_emoticon85");
        dlS.put("#(吃瓜)", "image_emoticon86");
        dlS.put("#(喝酒)", "image_emoticon87");
        dlS.put("#(嘿嘿嘿)", "image_emoticon88");
        dlS.put("#(噗)", "image_emoticon89");
        dlS.put("#(困成狗)", "image_emoticon90");
        dlS.put("#(微微一笑)", "image_emoticon91");
        dlS.put("#(托腮)", "image_emoticon92");
        dlS.put("#(摊手)", "image_emoticon93");
        dlS.put("#(柯基暗中观察)", "image_emoticon94");
        dlS.put("#(欢呼)", "image_emoticon95");
        dlS.put("#(炸药)", "image_emoticon96");
        dlS.put("#(突然兴奋)", "image_emoticon97");
        dlS.put("#(紧张)", "image_emoticon98");
        dlS.put("#(黑头瞪眼)", "image_emoticon99");
        dlS.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return dlS.get(str);
    }

    public static List<TbFaceManager.RichUnit> lB(String str) {
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
                        arrayList.add(lC(str2));
                        str4 = "";
                    }
                    arrayList.add(bb(str3, name));
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
            arrayList.add(lC(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit lC(String str) {
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
                                SpannableString ah = ah(context, str5);
                                if (ah != null) {
                                    tbRichTextData.append(ah);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.IC(), name, str3);
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
                    SpannableString ah2 = ah(context, str5);
                    if (ah2 != null) {
                        tbRichTextData.append(ah2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.a> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fy = TbFaceManager.DS().fy(str);
        if (fy != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a(TbadkCoreApplication.getInst(), fy);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            a.C0058a ga = TbFaceManager.DS().ga(str);
            if (ga != null) {
                int width = (int) (0.5d * ga.getWidth());
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(aVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString ah(Context context, String str) {
        if (str == null) {
            return null;
        }
        return av.R(context, str);
    }
}
