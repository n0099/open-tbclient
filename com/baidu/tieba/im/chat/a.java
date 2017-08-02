package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> dfc = new HashMap<>();

    static {
        dfc.put("#(呵呵)", "image_emoticon");
        dfc.put("#(哈哈)", "image_emoticon2");
        dfc.put("#(吐舌)", "image_emoticon3");
        dfc.put("#(啊)", "image_emoticon4");
        dfc.put("#(啊?)", "image_emoticon4");
        dfc.put("#(酷)", "image_emoticon5");
        dfc.put("#(怒)", "image_emoticon6");
        dfc.put("#(开心)", "image_emoticon7");
        dfc.put("#(汗)", "image_emoticon8");
        dfc.put("#(泪)", "image_emoticon9");
        dfc.put("#(黑线)", "image_emoticon10");
        dfc.put("#(鄙视)", "image_emoticon11");
        dfc.put("#(不高兴)", "image_emoticon12");
        dfc.put("#(真棒)", "image_emoticon13");
        dfc.put("#(钱)", "image_emoticon14");
        dfc.put("#(疑问)", "image_emoticon15");
        dfc.put("#(阴险)", "image_emoticon16");
        dfc.put("#(吐)", "image_emoticon17");
        dfc.put("#(咦)", "image_emoticon18");
        dfc.put("#(咦?)", "image_emoticon18");
        dfc.put("#(委屈)", "image_emoticon19");
        dfc.put("#(花心)", "image_emoticon20");
        dfc.put("#(呼~)", "image_emoticon21");
        dfc.put("#(笑眼)", "image_emoticon22");
        dfc.put("#(冷)", "image_emoticon23");
        dfc.put("#(太开心)", "image_emoticon24");
        dfc.put("#(滑稽)", "image_emoticon25");
        dfc.put("#(勉强)", "image_emoticon26");
        dfc.put("#(狂汗)", "image_emoticon27");
        dfc.put("#(乖)", "image_emoticon28");
        dfc.put("#(睡觉)", "image_emoticon29");
        dfc.put("#(惊哭)", "image_emoticon30");
        dfc.put("#(升起)", "image_emoticon31");
        dfc.put("#(惊讶)", "image_emoticon32");
        dfc.put("#(喷)", "image_emoticon33");
        dfc.put("#(爱心)", "image_emoticon34");
        dfc.put("#(心碎)", "image_emoticon35");
        dfc.put("#(玫瑰)", "image_emoticon36");
        dfc.put("#(礼物)", "image_emoticon37");
        dfc.put("#(彩虹)", "image_emoticon38");
        dfc.put("#(星星月亮)", "image_emoticon39");
        dfc.put("#(太阳)", "image_emoticon40");
        dfc.put("#(钱币)", "image_emoticon41");
        dfc.put("#(灯泡)", "image_emoticon42");
        dfc.put("#(茶杯)", "image_emoticon43");
        dfc.put("#(蛋糕)", "image_emoticon44");
        dfc.put("#(音乐)", "image_emoticon45");
        dfc.put("#(haha)", "image_emoticon46");
        dfc.put("#(胜利)", "image_emoticon47");
        dfc.put("#(大拇指)", "image_emoticon48");
        dfc.put("#(弱)", "image_emoticon49");
        dfc.put("#(OK)", "image_emoticon50");
        dfc.put("#(哼)", "image_emoticon61");
        dfc.put("#(吃瓜)", "image_emoticon62");
        dfc.put("#(扔便便)", "image_emoticon63");
        dfc.put("#(惊恐)", "image_emoticon64");
        dfc.put("#(哎呦)", "image_emoticon65");
        dfc.put("#(小乖)", "image_emoticon66");
        dfc.put("#(捂嘴笑)", "image_emoticon67");
        dfc.put("#(你懂的)", "image_emoticon68");
        dfc.put("#(what)", "image_emoticon69");
        dfc.put("#(酸爽)", "image_emoticon70");
        dfc.put("#(呀咩爹)", "image_emoticon71");
        dfc.put("#(笑尿)", "image_emoticon72");
        dfc.put("#(挖鼻)", "image_emoticon73");
        dfc.put("#(犀利)", "image_emoticon74");
        dfc.put("#(小红脸)", "image_emoticon75");
        dfc.put("#(懒得理)", "image_emoticon76");
        dfc.put("#(沙发)", "image_emoticon77");
        dfc.put("#(手纸)", "image_emoticon78");
        dfc.put("#(香蕉)", "image_emoticon79");
        dfc.put("#(便便)", "image_emoticon80");
        dfc.put("#(药丸)", "image_emoticon81");
        dfc.put("#(红领巾)", "image_emoticon82");
        dfc.put("#(蜡烛)", "image_emoticon83");
        dfc.put("#(三道杠)", "image_emoticon84");
        dfc.put("#(赖皮)", "ali_001");
        dfc.put("#(感动)", "ali_002");
        dfc.put("#(十分惊讶)", "ali_003");
        dfc.put("#(怒气)", "ali_004");
        dfc.put("#(哭泣)", "ali_005");
        dfc.put("#(吃惊)", "ali_006");
        dfc.put("#(嘲弄)", "ali_007");
        dfc.put("#(飘过)", "ali_008");
        dfc.put("#(转圈哭)", "ali_009");
        dfc.put("#(神经病)", "ali_010");
        dfc.put("#(揪耳朵)", "ali_011");
        dfc.put("#(惊汗)", "ali_012");
        dfc.put("#(隐身)", "ali_013");
        dfc.put("#(不要嘛)", "ali_014");
        dfc.put("#(遁)", "ali_015");
        dfc.put("#(不公平)", "ali_016");
        dfc.put("#(爬来了)", "ali_017");
        dfc.put("#(蛋花哭)", "ali_018");
        dfc.put("#(温暖)", "ali_019");
        dfc.put("#(点头)", "ali_020");
        dfc.put("#(撒钱)", "ali_021");
        dfc.put("#(献花)", "ali_022");
        dfc.put("#(寒)", "ali_023");
        dfc.put("#(傻笑)", "ali_024");
        dfc.put("#(扭扭)", "ali_025");
        dfc.put("#(疯)", "ali_026");
        dfc.put("#(抓狂)", "ali_027");
        dfc.put("#(抓)", "ali_028");
        dfc.put("#(蜷)", "ali_029");
        dfc.put("#(挠墙)", "ali_030");
        dfc.put("#(狂笑)", "ali_031");
        dfc.put("#(抱枕)", "ali_032");
        dfc.put("#(吼叫)", "ali_033");
        dfc.put("#(嚷)", "ali_034");
        dfc.put("#(唠叨)", "ali_035");
        dfc.put("#(捏脸)", "ali_036");
        dfc.put("#(爆笑)", "ali_037");
        dfc.put("#(郁闷)", "ali_038");
        dfc.put("#(潜水)", "ali_039");
        dfc.put("#(十分开心)", "ali_040");
        dfc.put("#(冷笑话)", "ali_041");
        dfc.put("#(顶！)", "ali_042");
        dfc.put("#(潜)", "ali_043");
        dfc.put("#(画圈圈)", "ali_044");
        dfc.put("#(玩电脑)", "ali_045");
        dfc.put("#(狂吐)", "ali_046");
        dfc.put("#(哭着跑)", "ali_047");
        dfc.put("#(阿狸侠)", "ali_048");
        dfc.put("#(冷死了)", "ali_049");
        dfc.put("#(惆怅~)", "ali_050");
        dfc.put("#(摸头)", "ali_051");
        dfc.put("#(蹭)", "ali_052");
        dfc.put("#(打滚)", "ali_053");
        dfc.put("#(叩拜)", "ali_054");
        dfc.put("#(摸)", "ali_055");
        dfc.put("#(数钱)", "ali_056");
        dfc.put("#(拖走)", "ali_057");
        dfc.put("#(热)", "ali_058");
        dfc.put("#(加1)", "ali_059");
        dfc.put("#(压力)", "ali_060");
        dfc.put("#(表逼我)", "ali_061");
        dfc.put("#(人呢)", "ali_062");
        dfc.put("#(摇晃)", "ali_063");
        dfc.put("#(打地鼠)", "ali_064");
        dfc.put("#(这个屌)", "ali_065");
        dfc.put("#(恐慌)", "ali_066");
        dfc.put("#(晕乎乎)", "ali_067");
        dfc.put("#(浮云)", "ali_068");
        dfc.put("#(给力)", "ali_069");
        dfc.put("#(杯具了)", "ali_070");
        dfc.put("#(焦糖舞)", "yz_001");
        dfc.put("#(翻滚)", "yz_002");
        dfc.put("#(拍屁股做鬼脸)", "yz_003");
        dfc.put("#(不)", "yz_004");
        dfc.put("#(河蟹掉啦)", "yz_005");
        dfc.put("#(哦耶)", "yz_006");
        dfc.put("#(我倒)", "yz_007");
        dfc.put("#(投降)", "yz_008");
        dfc.put("#(微笑)", "b01");
        dfc.put("#(帅哥)", "b02");
        dfc.put("#(美女)", "b03");
        dfc.put("#(老大)", "b04");
        dfc.put("#(哈哈哈)", "b05");
        dfc.put("#(奸笑)", "b06");
        dfc.put("#(傻乐)", "b07");
        dfc.put("#(飞吻)", "b08");
        dfc.put("#(害羞)", "b09");
        dfc.put("#(花痴)", "b10");
        dfc.put("#(憧憬)", "b11");
        dfc.put("#(你牛)", "b12");
        dfc.put("#(鼓掌)", "b13");
        dfc.put("#(可爱)", "b14");
        dfc.put("#(太委屈)", "b15");
        dfc.put("#(大哭)", "b16");
        dfc.put("#(泪奔)", "b17");
        dfc.put("#(寻死)", "b18");
        dfc.put("#(非常惊讶)", "b19");
        dfc.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return dfc.get(str);
    }

    public static List<TbFaceManager.RichUnit> lu(String str) {
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
                        arrayList.add(lv(str2));
                        str4 = "";
                    }
                    arrayList.add(bd(str3, name));
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
            arrayList.add(lv(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit lv(String str) {
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
                        SpannableString b = b(tbRichTextData.Il(), name, str3);
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
        int fB = TbFaceManager.Eo().fB(str);
        if (fB != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a(TbadkCoreApplication.getInst(), fB);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            a.C0057a gd = TbFaceManager.Eo().gd(str);
            if (gd != null) {
                int width = (int) (0.5d * gd.getWidth());
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
        return at.W(context, str);
    }
}
