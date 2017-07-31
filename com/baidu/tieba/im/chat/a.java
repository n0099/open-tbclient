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
    private static final HashMap<String, String> dgu = new HashMap<>();

    static {
        dgu.put("#(呵呵)", "image_emoticon");
        dgu.put("#(哈哈)", "image_emoticon2");
        dgu.put("#(吐舌)", "image_emoticon3");
        dgu.put("#(啊)", "image_emoticon4");
        dgu.put("#(啊?)", "image_emoticon4");
        dgu.put("#(酷)", "image_emoticon5");
        dgu.put("#(怒)", "image_emoticon6");
        dgu.put("#(开心)", "image_emoticon7");
        dgu.put("#(汗)", "image_emoticon8");
        dgu.put("#(泪)", "image_emoticon9");
        dgu.put("#(黑线)", "image_emoticon10");
        dgu.put("#(鄙视)", "image_emoticon11");
        dgu.put("#(不高兴)", "image_emoticon12");
        dgu.put("#(真棒)", "image_emoticon13");
        dgu.put("#(钱)", "image_emoticon14");
        dgu.put("#(疑问)", "image_emoticon15");
        dgu.put("#(阴险)", "image_emoticon16");
        dgu.put("#(吐)", "image_emoticon17");
        dgu.put("#(咦)", "image_emoticon18");
        dgu.put("#(咦?)", "image_emoticon18");
        dgu.put("#(委屈)", "image_emoticon19");
        dgu.put("#(花心)", "image_emoticon20");
        dgu.put("#(呼~)", "image_emoticon21");
        dgu.put("#(笑眼)", "image_emoticon22");
        dgu.put("#(冷)", "image_emoticon23");
        dgu.put("#(太开心)", "image_emoticon24");
        dgu.put("#(滑稽)", "image_emoticon25");
        dgu.put("#(勉强)", "image_emoticon26");
        dgu.put("#(狂汗)", "image_emoticon27");
        dgu.put("#(乖)", "image_emoticon28");
        dgu.put("#(睡觉)", "image_emoticon29");
        dgu.put("#(惊哭)", "image_emoticon30");
        dgu.put("#(升起)", "image_emoticon31");
        dgu.put("#(惊讶)", "image_emoticon32");
        dgu.put("#(喷)", "image_emoticon33");
        dgu.put("#(爱心)", "image_emoticon34");
        dgu.put("#(心碎)", "image_emoticon35");
        dgu.put("#(玫瑰)", "image_emoticon36");
        dgu.put("#(礼物)", "image_emoticon37");
        dgu.put("#(彩虹)", "image_emoticon38");
        dgu.put("#(星星月亮)", "image_emoticon39");
        dgu.put("#(太阳)", "image_emoticon40");
        dgu.put("#(钱币)", "image_emoticon41");
        dgu.put("#(灯泡)", "image_emoticon42");
        dgu.put("#(茶杯)", "image_emoticon43");
        dgu.put("#(蛋糕)", "image_emoticon44");
        dgu.put("#(音乐)", "image_emoticon45");
        dgu.put("#(haha)", "image_emoticon46");
        dgu.put("#(胜利)", "image_emoticon47");
        dgu.put("#(大拇指)", "image_emoticon48");
        dgu.put("#(弱)", "image_emoticon49");
        dgu.put("#(OK)", "image_emoticon50");
        dgu.put("#(哼)", "image_emoticon61");
        dgu.put("#(吃瓜)", "image_emoticon62");
        dgu.put("#(扔便便)", "image_emoticon63");
        dgu.put("#(惊恐)", "image_emoticon64");
        dgu.put("#(哎呦)", "image_emoticon65");
        dgu.put("#(小乖)", "image_emoticon66");
        dgu.put("#(捂嘴笑)", "image_emoticon67");
        dgu.put("#(你懂的)", "image_emoticon68");
        dgu.put("#(what)", "image_emoticon69");
        dgu.put("#(酸爽)", "image_emoticon70");
        dgu.put("#(呀咩爹)", "image_emoticon71");
        dgu.put("#(笑尿)", "image_emoticon72");
        dgu.put("#(挖鼻)", "image_emoticon73");
        dgu.put("#(犀利)", "image_emoticon74");
        dgu.put("#(小红脸)", "image_emoticon75");
        dgu.put("#(懒得理)", "image_emoticon76");
        dgu.put("#(沙发)", "image_emoticon77");
        dgu.put("#(手纸)", "image_emoticon78");
        dgu.put("#(香蕉)", "image_emoticon79");
        dgu.put("#(便便)", "image_emoticon80");
        dgu.put("#(药丸)", "image_emoticon81");
        dgu.put("#(红领巾)", "image_emoticon82");
        dgu.put("#(蜡烛)", "image_emoticon83");
        dgu.put("#(三道杠)", "image_emoticon84");
        dgu.put("#(赖皮)", "ali_001");
        dgu.put("#(感动)", "ali_002");
        dgu.put("#(十分惊讶)", "ali_003");
        dgu.put("#(怒气)", "ali_004");
        dgu.put("#(哭泣)", "ali_005");
        dgu.put("#(吃惊)", "ali_006");
        dgu.put("#(嘲弄)", "ali_007");
        dgu.put("#(飘过)", "ali_008");
        dgu.put("#(转圈哭)", "ali_009");
        dgu.put("#(神经病)", "ali_010");
        dgu.put("#(揪耳朵)", "ali_011");
        dgu.put("#(惊汗)", "ali_012");
        dgu.put("#(隐身)", "ali_013");
        dgu.put("#(不要嘛)", "ali_014");
        dgu.put("#(遁)", "ali_015");
        dgu.put("#(不公平)", "ali_016");
        dgu.put("#(爬来了)", "ali_017");
        dgu.put("#(蛋花哭)", "ali_018");
        dgu.put("#(温暖)", "ali_019");
        dgu.put("#(点头)", "ali_020");
        dgu.put("#(撒钱)", "ali_021");
        dgu.put("#(献花)", "ali_022");
        dgu.put("#(寒)", "ali_023");
        dgu.put("#(傻笑)", "ali_024");
        dgu.put("#(扭扭)", "ali_025");
        dgu.put("#(疯)", "ali_026");
        dgu.put("#(抓狂)", "ali_027");
        dgu.put("#(抓)", "ali_028");
        dgu.put("#(蜷)", "ali_029");
        dgu.put("#(挠墙)", "ali_030");
        dgu.put("#(狂笑)", "ali_031");
        dgu.put("#(抱枕)", "ali_032");
        dgu.put("#(吼叫)", "ali_033");
        dgu.put("#(嚷)", "ali_034");
        dgu.put("#(唠叨)", "ali_035");
        dgu.put("#(捏脸)", "ali_036");
        dgu.put("#(爆笑)", "ali_037");
        dgu.put("#(郁闷)", "ali_038");
        dgu.put("#(潜水)", "ali_039");
        dgu.put("#(十分开心)", "ali_040");
        dgu.put("#(冷笑话)", "ali_041");
        dgu.put("#(顶！)", "ali_042");
        dgu.put("#(潜)", "ali_043");
        dgu.put("#(画圈圈)", "ali_044");
        dgu.put("#(玩电脑)", "ali_045");
        dgu.put("#(狂吐)", "ali_046");
        dgu.put("#(哭着跑)", "ali_047");
        dgu.put("#(阿狸侠)", "ali_048");
        dgu.put("#(冷死了)", "ali_049");
        dgu.put("#(惆怅~)", "ali_050");
        dgu.put("#(摸头)", "ali_051");
        dgu.put("#(蹭)", "ali_052");
        dgu.put("#(打滚)", "ali_053");
        dgu.put("#(叩拜)", "ali_054");
        dgu.put("#(摸)", "ali_055");
        dgu.put("#(数钱)", "ali_056");
        dgu.put("#(拖走)", "ali_057");
        dgu.put("#(热)", "ali_058");
        dgu.put("#(加1)", "ali_059");
        dgu.put("#(压力)", "ali_060");
        dgu.put("#(表逼我)", "ali_061");
        dgu.put("#(人呢)", "ali_062");
        dgu.put("#(摇晃)", "ali_063");
        dgu.put("#(打地鼠)", "ali_064");
        dgu.put("#(这个屌)", "ali_065");
        dgu.put("#(恐慌)", "ali_066");
        dgu.put("#(晕乎乎)", "ali_067");
        dgu.put("#(浮云)", "ali_068");
        dgu.put("#(给力)", "ali_069");
        dgu.put("#(杯具了)", "ali_070");
        dgu.put("#(焦糖舞)", "yz_001");
        dgu.put("#(翻滚)", "yz_002");
        dgu.put("#(拍屁股做鬼脸)", "yz_003");
        dgu.put("#(不)", "yz_004");
        dgu.put("#(河蟹掉啦)", "yz_005");
        dgu.put("#(哦耶)", "yz_006");
        dgu.put("#(我倒)", "yz_007");
        dgu.put("#(投降)", "yz_008");
        dgu.put("#(微笑)", "b01");
        dgu.put("#(帅哥)", "b02");
        dgu.put("#(美女)", "b03");
        dgu.put("#(老大)", "b04");
        dgu.put("#(哈哈哈)", "b05");
        dgu.put("#(奸笑)", "b06");
        dgu.put("#(傻乐)", "b07");
        dgu.put("#(飞吻)", "b08");
        dgu.put("#(害羞)", "b09");
        dgu.put("#(花痴)", "b10");
        dgu.put("#(憧憬)", "b11");
        dgu.put("#(你牛)", "b12");
        dgu.put("#(鼓掌)", "b13");
        dgu.put("#(可爱)", "b14");
        dgu.put("#(太委屈)", "b15");
        dgu.put("#(大哭)", "b16");
        dgu.put("#(泪奔)", "b17");
        dgu.put("#(寻死)", "b18");
        dgu.put("#(非常惊讶)", "b19");
        dgu.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return dgu.get(str);
    }

    public static List<TbFaceManager.RichUnit> ly(String str) {
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
                        arrayList.add(lz(str2));
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
            arrayList.add(lz(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit lz(String str) {
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
                        SpannableString b = b(tbRichTextData.Is(), name, str3);
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
        int fH = TbFaceManager.Ew().fH(str);
        if (fH != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a(TbadkCoreApplication.getInst(), fH);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            a.C0057a gj = TbFaceManager.Ew().gj(str);
            if (gj != null) {
                int width = (int) (0.5d * gj.getWidth());
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
