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
    private static final HashMap<String, String> doV = new HashMap<>();

    static {
        doV.put("#(呵呵)", "image_emoticon");
        doV.put("#(哈哈)", "image_emoticon2");
        doV.put("#(吐舌)", "image_emoticon3");
        doV.put("#(啊)", "image_emoticon4");
        doV.put("#(啊?)", "image_emoticon4");
        doV.put("#(酷)", "image_emoticon5");
        doV.put("#(怒)", "image_emoticon6");
        doV.put("#(开心)", "image_emoticon7");
        doV.put("#(汗)", "image_emoticon8");
        doV.put("#(泪)", "image_emoticon9");
        doV.put("#(黑线)", "image_emoticon10");
        doV.put("#(鄙视)", "image_emoticon11");
        doV.put("#(不高兴)", "image_emoticon12");
        doV.put("#(真棒)", "image_emoticon13");
        doV.put("#(钱)", "image_emoticon14");
        doV.put("#(疑问)", "image_emoticon15");
        doV.put("#(阴险)", "image_emoticon16");
        doV.put("#(吐)", "image_emoticon17");
        doV.put("#(咦)", "image_emoticon18");
        doV.put("#(咦?)", "image_emoticon18");
        doV.put("#(委屈)", "image_emoticon19");
        doV.put("#(花心)", "image_emoticon20");
        doV.put("#(呼~)", "image_emoticon21");
        doV.put("#(笑眼)", "image_emoticon22");
        doV.put("#(冷)", "image_emoticon23");
        doV.put("#(太开心)", "image_emoticon24");
        doV.put("#(滑稽)", "image_emoticon25");
        doV.put("#(勉强)", "image_emoticon26");
        doV.put("#(狂汗)", "image_emoticon27");
        doV.put("#(乖)", "image_emoticon28");
        doV.put("#(睡觉)", "image_emoticon29");
        doV.put("#(惊哭)", "image_emoticon30");
        doV.put("#(升起)", "image_emoticon31");
        doV.put("#(惊讶)", "image_emoticon32");
        doV.put("#(喷)", "image_emoticon33");
        doV.put("#(爱心)", "image_emoticon34");
        doV.put("#(心碎)", "image_emoticon35");
        doV.put("#(玫瑰)", "image_emoticon36");
        doV.put("#(礼物)", "image_emoticon37");
        doV.put("#(彩虹)", "image_emoticon38");
        doV.put("#(星星月亮)", "image_emoticon39");
        doV.put("#(太阳)", "image_emoticon40");
        doV.put("#(钱币)", "image_emoticon41");
        doV.put("#(灯泡)", "image_emoticon42");
        doV.put("#(茶杯)", "image_emoticon43");
        doV.put("#(蛋糕)", "image_emoticon44");
        doV.put("#(音乐)", "image_emoticon45");
        doV.put("#(haha)", "image_emoticon46");
        doV.put("#(胜利)", "image_emoticon47");
        doV.put("#(大拇指)", "image_emoticon48");
        doV.put("#(弱)", "image_emoticon49");
        doV.put("#(OK)", "image_emoticon50");
        doV.put("#(哼)", "image_emoticon61");
        doV.put("#(吃瓜)", "image_emoticon62");
        doV.put("#(扔便便)", "image_emoticon63");
        doV.put("#(惊恐)", "image_emoticon64");
        doV.put("#(哎呦)", "image_emoticon65");
        doV.put("#(小乖)", "image_emoticon66");
        doV.put("#(捂嘴笑)", "image_emoticon67");
        doV.put("#(你懂的)", "image_emoticon68");
        doV.put("#(what)", "image_emoticon69");
        doV.put("#(酸爽)", "image_emoticon70");
        doV.put("#(呀咩爹)", "image_emoticon71");
        doV.put("#(笑尿)", "image_emoticon72");
        doV.put("#(挖鼻)", "image_emoticon73");
        doV.put("#(犀利)", "image_emoticon74");
        doV.put("#(小红脸)", "image_emoticon75");
        doV.put("#(懒得理)", "image_emoticon76");
        doV.put("#(沙发)", "image_emoticon77");
        doV.put("#(手纸)", "image_emoticon78");
        doV.put("#(香蕉)", "image_emoticon79");
        doV.put("#(便便)", "image_emoticon80");
        doV.put("#(药丸)", "image_emoticon81");
        doV.put("#(红领巾)", "image_emoticon82");
        doV.put("#(蜡烛)", "image_emoticon83");
        doV.put("#(三道杠)", "image_emoticon84");
        doV.put("#(赖皮)", "ali_001");
        doV.put("#(感动)", "ali_002");
        doV.put("#(十分惊讶)", "ali_003");
        doV.put("#(怒气)", "ali_004");
        doV.put("#(哭泣)", "ali_005");
        doV.put("#(吃惊)", "ali_006");
        doV.put("#(嘲弄)", "ali_007");
        doV.put("#(飘过)", "ali_008");
        doV.put("#(转圈哭)", "ali_009");
        doV.put("#(神经病)", "ali_010");
        doV.put("#(揪耳朵)", "ali_011");
        doV.put("#(惊汗)", "ali_012");
        doV.put("#(隐身)", "ali_013");
        doV.put("#(不要嘛)", "ali_014");
        doV.put("#(遁)", "ali_015");
        doV.put("#(不公平)", "ali_016");
        doV.put("#(爬来了)", "ali_017");
        doV.put("#(蛋花哭)", "ali_018");
        doV.put("#(温暖)", "ali_019");
        doV.put("#(点头)", "ali_020");
        doV.put("#(撒钱)", "ali_021");
        doV.put("#(献花)", "ali_022");
        doV.put("#(寒)", "ali_023");
        doV.put("#(傻笑)", "ali_024");
        doV.put("#(扭扭)", "ali_025");
        doV.put("#(疯)", "ali_026");
        doV.put("#(抓狂)", "ali_027");
        doV.put("#(抓)", "ali_028");
        doV.put("#(蜷)", "ali_029");
        doV.put("#(挠墙)", "ali_030");
        doV.put("#(狂笑)", "ali_031");
        doV.put("#(抱枕)", "ali_032");
        doV.put("#(吼叫)", "ali_033");
        doV.put("#(嚷)", "ali_034");
        doV.put("#(唠叨)", "ali_035");
        doV.put("#(捏脸)", "ali_036");
        doV.put("#(爆笑)", "ali_037");
        doV.put("#(郁闷)", "ali_038");
        doV.put("#(潜水)", "ali_039");
        doV.put("#(十分开心)", "ali_040");
        doV.put("#(冷笑话)", "ali_041");
        doV.put("#(顶！)", "ali_042");
        doV.put("#(潜)", "ali_043");
        doV.put("#(画圈圈)", "ali_044");
        doV.put("#(玩电脑)", "ali_045");
        doV.put("#(狂吐)", "ali_046");
        doV.put("#(哭着跑)", "ali_047");
        doV.put("#(阿狸侠)", "ali_048");
        doV.put("#(冷死了)", "ali_049");
        doV.put("#(惆怅~)", "ali_050");
        doV.put("#(摸头)", "ali_051");
        doV.put("#(蹭)", "ali_052");
        doV.put("#(打滚)", "ali_053");
        doV.put("#(叩拜)", "ali_054");
        doV.put("#(摸)", "ali_055");
        doV.put("#(数钱)", "ali_056");
        doV.put("#(拖走)", "ali_057");
        doV.put("#(热)", "ali_058");
        doV.put("#(加1)", "ali_059");
        doV.put("#(压力)", "ali_060");
        doV.put("#(表逼我)", "ali_061");
        doV.put("#(人呢)", "ali_062");
        doV.put("#(摇晃)", "ali_063");
        doV.put("#(打地鼠)", "ali_064");
        doV.put("#(这个屌)", "ali_065");
        doV.put("#(恐慌)", "ali_066");
        doV.put("#(晕乎乎)", "ali_067");
        doV.put("#(浮云)", "ali_068");
        doV.put("#(给力)", "ali_069");
        doV.put("#(杯具了)", "ali_070");
        doV.put("#(焦糖舞)", "yz_001");
        doV.put("#(翻滚)", "yz_002");
        doV.put("#(拍屁股做鬼脸)", "yz_003");
        doV.put("#(不)", "yz_004");
        doV.put("#(河蟹掉啦)", "yz_005");
        doV.put("#(哦耶)", "yz_006");
        doV.put("#(我倒)", "yz_007");
        doV.put("#(投降)", "yz_008");
        doV.put("#(微笑)", "b01");
        doV.put("#(帅哥)", "b02");
        doV.put("#(美女)", "b03");
        doV.put("#(老大)", "b04");
        doV.put("#(哈哈哈)", "b05");
        doV.put("#(奸笑)", "b06");
        doV.put("#(傻乐)", "b07");
        doV.put("#(飞吻)", "b08");
        doV.put("#(害羞)", "b09");
        doV.put("#(花痴)", "b10");
        doV.put("#(憧憬)", "b11");
        doV.put("#(你牛)", "b12");
        doV.put("#(鼓掌)", "b13");
        doV.put("#(可爱)", "b14");
        doV.put("#(太委屈)", "b15");
        doV.put("#(大哭)", "b16");
        doV.put("#(泪奔)", "b17");
        doV.put("#(寻死)", "b18");
        doV.put("#(非常惊讶)", "b19");
        doV.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return doV.get(str);
    }

    public static List<TbFaceManager.RichUnit> lW(String str) {
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
                        arrayList.add(lX(str2));
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
            arrayList.add(lX(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit lX(String str) {
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
            a.C0060a gh = TbFaceManager.Eu().gh(str);
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
