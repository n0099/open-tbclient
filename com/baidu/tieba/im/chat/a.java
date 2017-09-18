package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> dpQ = new HashMap<>();

    static {
        dpQ.put("#(呵呵)", "image_emoticon");
        dpQ.put("#(哈哈)", "image_emoticon2");
        dpQ.put("#(吐舌)", "image_emoticon3");
        dpQ.put("#(啊)", "image_emoticon4");
        dpQ.put("#(啊?)", "image_emoticon4");
        dpQ.put("#(酷)", "image_emoticon5");
        dpQ.put("#(怒)", "image_emoticon6");
        dpQ.put("#(开心)", "image_emoticon7");
        dpQ.put("#(汗)", "image_emoticon8");
        dpQ.put("#(泪)", "image_emoticon9");
        dpQ.put("#(黑线)", "image_emoticon10");
        dpQ.put("#(鄙视)", "image_emoticon11");
        dpQ.put("#(不高兴)", "image_emoticon12");
        dpQ.put("#(真棒)", "image_emoticon13");
        dpQ.put("#(钱)", "image_emoticon14");
        dpQ.put("#(疑问)", "image_emoticon15");
        dpQ.put("#(阴险)", "image_emoticon16");
        dpQ.put("#(吐)", "image_emoticon17");
        dpQ.put("#(咦)", "image_emoticon18");
        dpQ.put("#(咦?)", "image_emoticon18");
        dpQ.put("#(委屈)", "image_emoticon19");
        dpQ.put("#(花心)", "image_emoticon20");
        dpQ.put("#(呼~)", "image_emoticon21");
        dpQ.put("#(笑眼)", "image_emoticon22");
        dpQ.put("#(冷)", "image_emoticon23");
        dpQ.put("#(太开心)", "image_emoticon24");
        dpQ.put("#(滑稽)", "image_emoticon25");
        dpQ.put("#(勉强)", "image_emoticon26");
        dpQ.put("#(狂汗)", "image_emoticon27");
        dpQ.put("#(乖)", "image_emoticon28");
        dpQ.put("#(睡觉)", "image_emoticon29");
        dpQ.put("#(惊哭)", "image_emoticon30");
        dpQ.put("#(升起)", "image_emoticon31");
        dpQ.put("#(惊讶)", "image_emoticon32");
        dpQ.put("#(喷)", "image_emoticon33");
        dpQ.put("#(爱心)", "image_emoticon34");
        dpQ.put("#(心碎)", "image_emoticon35");
        dpQ.put("#(玫瑰)", "image_emoticon36");
        dpQ.put("#(礼物)", "image_emoticon37");
        dpQ.put("#(彩虹)", "image_emoticon38");
        dpQ.put("#(星星月亮)", "image_emoticon39");
        dpQ.put("#(太阳)", "image_emoticon40");
        dpQ.put("#(钱币)", "image_emoticon41");
        dpQ.put("#(灯泡)", "image_emoticon42");
        dpQ.put("#(茶杯)", "image_emoticon43");
        dpQ.put("#(蛋糕)", "image_emoticon44");
        dpQ.put("#(音乐)", "image_emoticon45");
        dpQ.put("#(haha)", "image_emoticon46");
        dpQ.put("#(胜利)", "image_emoticon47");
        dpQ.put("#(大拇指)", "image_emoticon48");
        dpQ.put("#(弱)", "image_emoticon49");
        dpQ.put("#(OK)", "image_emoticon50");
        dpQ.put("#(哼)", "image_emoticon61");
        dpQ.put("#(吃瓜)", "image_emoticon62");
        dpQ.put("#(扔便便)", "image_emoticon63");
        dpQ.put("#(惊恐)", "image_emoticon64");
        dpQ.put("#(哎呦)", "image_emoticon65");
        dpQ.put("#(小乖)", "image_emoticon66");
        dpQ.put("#(捂嘴笑)", "image_emoticon67");
        dpQ.put("#(你懂的)", "image_emoticon68");
        dpQ.put("#(what)", "image_emoticon69");
        dpQ.put("#(酸爽)", "image_emoticon70");
        dpQ.put("#(呀咩爹)", "image_emoticon71");
        dpQ.put("#(笑尿)", "image_emoticon72");
        dpQ.put("#(挖鼻)", "image_emoticon73");
        dpQ.put("#(犀利)", "image_emoticon74");
        dpQ.put("#(小红脸)", "image_emoticon75");
        dpQ.put("#(懒得理)", "image_emoticon76");
        dpQ.put("#(沙发)", "image_emoticon77");
        dpQ.put("#(手纸)", "image_emoticon78");
        dpQ.put("#(香蕉)", "image_emoticon79");
        dpQ.put("#(便便)", "image_emoticon80");
        dpQ.put("#(药丸)", "image_emoticon81");
        dpQ.put("#(红领巾)", "image_emoticon82");
        dpQ.put("#(蜡烛)", "image_emoticon83");
        dpQ.put("#(三道杠)", "image_emoticon84");
        dpQ.put("#(赖皮)", "ali_001");
        dpQ.put("#(感动)", "ali_002");
        dpQ.put("#(十分惊讶)", "ali_003");
        dpQ.put("#(怒气)", "ali_004");
        dpQ.put("#(哭泣)", "ali_005");
        dpQ.put("#(吃惊)", "ali_006");
        dpQ.put("#(嘲弄)", "ali_007");
        dpQ.put("#(飘过)", "ali_008");
        dpQ.put("#(转圈哭)", "ali_009");
        dpQ.put("#(神经病)", "ali_010");
        dpQ.put("#(揪耳朵)", "ali_011");
        dpQ.put("#(惊汗)", "ali_012");
        dpQ.put("#(隐身)", "ali_013");
        dpQ.put("#(不要嘛)", "ali_014");
        dpQ.put("#(遁)", "ali_015");
        dpQ.put("#(不公平)", "ali_016");
        dpQ.put("#(爬来了)", "ali_017");
        dpQ.put("#(蛋花哭)", "ali_018");
        dpQ.put("#(温暖)", "ali_019");
        dpQ.put("#(点头)", "ali_020");
        dpQ.put("#(撒钱)", "ali_021");
        dpQ.put("#(献花)", "ali_022");
        dpQ.put("#(寒)", "ali_023");
        dpQ.put("#(傻笑)", "ali_024");
        dpQ.put("#(扭扭)", "ali_025");
        dpQ.put("#(疯)", "ali_026");
        dpQ.put("#(抓狂)", "ali_027");
        dpQ.put("#(抓)", "ali_028");
        dpQ.put("#(蜷)", "ali_029");
        dpQ.put("#(挠墙)", "ali_030");
        dpQ.put("#(狂笑)", "ali_031");
        dpQ.put("#(抱枕)", "ali_032");
        dpQ.put("#(吼叫)", "ali_033");
        dpQ.put("#(嚷)", "ali_034");
        dpQ.put("#(唠叨)", "ali_035");
        dpQ.put("#(捏脸)", "ali_036");
        dpQ.put("#(爆笑)", "ali_037");
        dpQ.put("#(郁闷)", "ali_038");
        dpQ.put("#(潜水)", "ali_039");
        dpQ.put("#(十分开心)", "ali_040");
        dpQ.put("#(冷笑话)", "ali_041");
        dpQ.put("#(顶！)", "ali_042");
        dpQ.put("#(潜)", "ali_043");
        dpQ.put("#(画圈圈)", "ali_044");
        dpQ.put("#(玩电脑)", "ali_045");
        dpQ.put("#(狂吐)", "ali_046");
        dpQ.put("#(哭着跑)", "ali_047");
        dpQ.put("#(阿狸侠)", "ali_048");
        dpQ.put("#(冷死了)", "ali_049");
        dpQ.put("#(惆怅~)", "ali_050");
        dpQ.put("#(摸头)", "ali_051");
        dpQ.put("#(蹭)", "ali_052");
        dpQ.put("#(打滚)", "ali_053");
        dpQ.put("#(叩拜)", "ali_054");
        dpQ.put("#(摸)", "ali_055");
        dpQ.put("#(数钱)", "ali_056");
        dpQ.put("#(拖走)", "ali_057");
        dpQ.put("#(热)", "ali_058");
        dpQ.put("#(加1)", "ali_059");
        dpQ.put("#(压力)", "ali_060");
        dpQ.put("#(表逼我)", "ali_061");
        dpQ.put("#(人呢)", "ali_062");
        dpQ.put("#(摇晃)", "ali_063");
        dpQ.put("#(打地鼠)", "ali_064");
        dpQ.put("#(这个屌)", "ali_065");
        dpQ.put("#(恐慌)", "ali_066");
        dpQ.put("#(晕乎乎)", "ali_067");
        dpQ.put("#(浮云)", "ali_068");
        dpQ.put("#(给力)", "ali_069");
        dpQ.put("#(杯具了)", "ali_070");
        dpQ.put("#(焦糖舞)", "yz_001");
        dpQ.put("#(翻滚)", "yz_002");
        dpQ.put("#(拍屁股做鬼脸)", "yz_003");
        dpQ.put("#(不)", "yz_004");
        dpQ.put("#(河蟹掉啦)", "yz_005");
        dpQ.put("#(哦耶)", "yz_006");
        dpQ.put("#(我倒)", "yz_007");
        dpQ.put("#(投降)", "yz_008");
        dpQ.put("#(微笑)", "b01");
        dpQ.put("#(帅哥)", "b02");
        dpQ.put("#(美女)", "b03");
        dpQ.put("#(老大)", "b04");
        dpQ.put("#(哈哈哈)", "b05");
        dpQ.put("#(奸笑)", "b06");
        dpQ.put("#(傻乐)", "b07");
        dpQ.put("#(飞吻)", "b08");
        dpQ.put("#(害羞)", "b09");
        dpQ.put("#(花痴)", "b10");
        dpQ.put("#(憧憬)", "b11");
        dpQ.put("#(你牛)", "b12");
        dpQ.put("#(鼓掌)", "b13");
        dpQ.put("#(可爱)", "b14");
        dpQ.put("#(太委屈)", "b15");
        dpQ.put("#(大哭)", "b16");
        dpQ.put("#(泪奔)", "b17");
        dpQ.put("#(寻死)", "b18");
        dpQ.put("#(非常惊讶)", "b19");
        dpQ.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return dpQ.get(str);
    }

    public static List<TbFaceManager.RichUnit> lY(String str) {
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
                        arrayList.add(lZ(str2));
                        str4 = "";
                    }
                    arrayList.add(bj(str3, name));
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
            arrayList.add(lZ(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit lZ(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit bj(String str, String str2) {
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
                        SpannableString b = b(tbRichTextData.IA(), name, str3);
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
        int fG = TbFaceManager.Eu().fG(str);
        if (fG != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a(TbadkCoreApplication.getInst(), fG);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            a.C0059a gh = TbFaceManager.Eu().gh(str);
            if (gh != null) {
                int width = (int) (0.5d * gh.getWidth());
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
        return au.W(context, str);
    }
}
