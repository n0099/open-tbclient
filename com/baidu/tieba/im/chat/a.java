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
    private static final HashMap<String, String> dir = new HashMap<>();

    static {
        dir.put("#(呵呵)", "image_emoticon");
        dir.put("#(哈哈)", "image_emoticon2");
        dir.put("#(吐舌)", "image_emoticon3");
        dir.put("#(啊)", "image_emoticon4");
        dir.put("#(啊?)", "image_emoticon4");
        dir.put("#(酷)", "image_emoticon5");
        dir.put("#(怒)", "image_emoticon6");
        dir.put("#(开心)", "image_emoticon7");
        dir.put("#(汗)", "image_emoticon8");
        dir.put("#(泪)", "image_emoticon9");
        dir.put("#(黑线)", "image_emoticon10");
        dir.put("#(鄙视)", "image_emoticon11");
        dir.put("#(不高兴)", "image_emoticon12");
        dir.put("#(真棒)", "image_emoticon13");
        dir.put("#(钱)", "image_emoticon14");
        dir.put("#(疑问)", "image_emoticon15");
        dir.put("#(阴险)", "image_emoticon16");
        dir.put("#(吐)", "image_emoticon17");
        dir.put("#(咦)", "image_emoticon18");
        dir.put("#(咦?)", "image_emoticon18");
        dir.put("#(委屈)", "image_emoticon19");
        dir.put("#(花心)", "image_emoticon20");
        dir.put("#(呼~)", "image_emoticon21");
        dir.put("#(笑眼)", "image_emoticon22");
        dir.put("#(冷)", "image_emoticon23");
        dir.put("#(太开心)", "image_emoticon24");
        dir.put("#(滑稽)", "image_emoticon25");
        dir.put("#(勉强)", "image_emoticon26");
        dir.put("#(狂汗)", "image_emoticon27");
        dir.put("#(乖)", "image_emoticon28");
        dir.put("#(睡觉)", "image_emoticon29");
        dir.put("#(惊哭)", "image_emoticon30");
        dir.put("#(升起)", "image_emoticon31");
        dir.put("#(惊讶)", "image_emoticon32");
        dir.put("#(喷)", "image_emoticon33");
        dir.put("#(爱心)", "image_emoticon34");
        dir.put("#(心碎)", "image_emoticon35");
        dir.put("#(玫瑰)", "image_emoticon36");
        dir.put("#(礼物)", "image_emoticon37");
        dir.put("#(彩虹)", "image_emoticon38");
        dir.put("#(星星月亮)", "image_emoticon39");
        dir.put("#(太阳)", "image_emoticon40");
        dir.put("#(钱币)", "image_emoticon41");
        dir.put("#(灯泡)", "image_emoticon42");
        dir.put("#(茶杯)", "image_emoticon43");
        dir.put("#(蛋糕)", "image_emoticon44");
        dir.put("#(音乐)", "image_emoticon45");
        dir.put("#(haha)", "image_emoticon46");
        dir.put("#(胜利)", "image_emoticon47");
        dir.put("#(大拇指)", "image_emoticon48");
        dir.put("#(弱)", "image_emoticon49");
        dir.put("#(OK)", "image_emoticon50");
        dir.put("#(哼)", "image_emoticon61");
        dir.put("#(吃瓜)", "image_emoticon62");
        dir.put("#(扔便便)", "image_emoticon63");
        dir.put("#(惊恐)", "image_emoticon64");
        dir.put("#(哎呦)", "image_emoticon65");
        dir.put("#(小乖)", "image_emoticon66");
        dir.put("#(捂嘴笑)", "image_emoticon67");
        dir.put("#(你懂的)", "image_emoticon68");
        dir.put("#(what)", "image_emoticon69");
        dir.put("#(酸爽)", "image_emoticon70");
        dir.put("#(呀咩爹)", "image_emoticon71");
        dir.put("#(笑尿)", "image_emoticon72");
        dir.put("#(挖鼻)", "image_emoticon73");
        dir.put("#(犀利)", "image_emoticon74");
        dir.put("#(小红脸)", "image_emoticon75");
        dir.put("#(懒得理)", "image_emoticon76");
        dir.put("#(沙发)", "image_emoticon77");
        dir.put("#(手纸)", "image_emoticon78");
        dir.put("#(香蕉)", "image_emoticon79");
        dir.put("#(便便)", "image_emoticon80");
        dir.put("#(药丸)", "image_emoticon81");
        dir.put("#(红领巾)", "image_emoticon82");
        dir.put("#(蜡烛)", "image_emoticon83");
        dir.put("#(三道杠)", "image_emoticon84");
        dir.put("#(赖皮)", "ali_001");
        dir.put("#(感动)", "ali_002");
        dir.put("#(十分惊讶)", "ali_003");
        dir.put("#(怒气)", "ali_004");
        dir.put("#(哭泣)", "ali_005");
        dir.put("#(吃惊)", "ali_006");
        dir.put("#(嘲弄)", "ali_007");
        dir.put("#(飘过)", "ali_008");
        dir.put("#(转圈哭)", "ali_009");
        dir.put("#(神经病)", "ali_010");
        dir.put("#(揪耳朵)", "ali_011");
        dir.put("#(惊汗)", "ali_012");
        dir.put("#(隐身)", "ali_013");
        dir.put("#(不要嘛)", "ali_014");
        dir.put("#(遁)", "ali_015");
        dir.put("#(不公平)", "ali_016");
        dir.put("#(爬来了)", "ali_017");
        dir.put("#(蛋花哭)", "ali_018");
        dir.put("#(温暖)", "ali_019");
        dir.put("#(点头)", "ali_020");
        dir.put("#(撒钱)", "ali_021");
        dir.put("#(献花)", "ali_022");
        dir.put("#(寒)", "ali_023");
        dir.put("#(傻笑)", "ali_024");
        dir.put("#(扭扭)", "ali_025");
        dir.put("#(疯)", "ali_026");
        dir.put("#(抓狂)", "ali_027");
        dir.put("#(抓)", "ali_028");
        dir.put("#(蜷)", "ali_029");
        dir.put("#(挠墙)", "ali_030");
        dir.put("#(狂笑)", "ali_031");
        dir.put("#(抱枕)", "ali_032");
        dir.put("#(吼叫)", "ali_033");
        dir.put("#(嚷)", "ali_034");
        dir.put("#(唠叨)", "ali_035");
        dir.put("#(捏脸)", "ali_036");
        dir.put("#(爆笑)", "ali_037");
        dir.put("#(郁闷)", "ali_038");
        dir.put("#(潜水)", "ali_039");
        dir.put("#(十分开心)", "ali_040");
        dir.put("#(冷笑话)", "ali_041");
        dir.put("#(顶！)", "ali_042");
        dir.put("#(潜)", "ali_043");
        dir.put("#(画圈圈)", "ali_044");
        dir.put("#(玩电脑)", "ali_045");
        dir.put("#(狂吐)", "ali_046");
        dir.put("#(哭着跑)", "ali_047");
        dir.put("#(阿狸侠)", "ali_048");
        dir.put("#(冷死了)", "ali_049");
        dir.put("#(惆怅~)", "ali_050");
        dir.put("#(摸头)", "ali_051");
        dir.put("#(蹭)", "ali_052");
        dir.put("#(打滚)", "ali_053");
        dir.put("#(叩拜)", "ali_054");
        dir.put("#(摸)", "ali_055");
        dir.put("#(数钱)", "ali_056");
        dir.put("#(拖走)", "ali_057");
        dir.put("#(热)", "ali_058");
        dir.put("#(加1)", "ali_059");
        dir.put("#(压力)", "ali_060");
        dir.put("#(表逼我)", "ali_061");
        dir.put("#(人呢)", "ali_062");
        dir.put("#(摇晃)", "ali_063");
        dir.put("#(打地鼠)", "ali_064");
        dir.put("#(这个屌)", "ali_065");
        dir.put("#(恐慌)", "ali_066");
        dir.put("#(晕乎乎)", "ali_067");
        dir.put("#(浮云)", "ali_068");
        dir.put("#(给力)", "ali_069");
        dir.put("#(杯具了)", "ali_070");
        dir.put("#(焦糖舞)", "yz_001");
        dir.put("#(翻滚)", "yz_002");
        dir.put("#(拍屁股做鬼脸)", "yz_003");
        dir.put("#(不)", "yz_004");
        dir.put("#(河蟹掉啦)", "yz_005");
        dir.put("#(哦耶)", "yz_006");
        dir.put("#(我倒)", "yz_007");
        dir.put("#(投降)", "yz_008");
        dir.put("#(微笑)", "b01");
        dir.put("#(帅哥)", "b02");
        dir.put("#(美女)", "b03");
        dir.put("#(老大)", "b04");
        dir.put("#(哈哈哈)", "b05");
        dir.put("#(奸笑)", "b06");
        dir.put("#(傻乐)", "b07");
        dir.put("#(飞吻)", "b08");
        dir.put("#(害羞)", "b09");
        dir.put("#(花痴)", "b10");
        dir.put("#(憧憬)", "b11");
        dir.put("#(你牛)", "b12");
        dir.put("#(鼓掌)", "b13");
        dir.put("#(可爱)", "b14");
        dir.put("#(太委屈)", "b15");
        dir.put("#(大哭)", "b16");
        dir.put("#(泪奔)", "b17");
        dir.put("#(寻死)", "b18");
        dir.put("#(非常惊讶)", "b19");
        dir.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return dir.get(str);
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
                    arrayList.add(be(str3, name));
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

    private static TbFaceManager.RichUnit be(String str, String str2) {
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
