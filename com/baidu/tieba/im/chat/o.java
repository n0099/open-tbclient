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
    private static final HashMap<String, String> cMG = new HashMap<>();

    static {
        cMG.put("#(呵呵)", "image_emoticon");
        cMG.put("#(哈哈)", "image_emoticon2");
        cMG.put("#(吐舌)", "image_emoticon3");
        cMG.put("#(啊)", "image_emoticon4");
        cMG.put("#(啊?)", "image_emoticon4");
        cMG.put("#(酷)", "image_emoticon5");
        cMG.put("#(怒)", "image_emoticon6");
        cMG.put("#(开心)", "image_emoticon7");
        cMG.put("#(汗)", "image_emoticon8");
        cMG.put("#(泪)", "image_emoticon9");
        cMG.put("#(黑线)", "image_emoticon10");
        cMG.put("#(鄙视)", "image_emoticon11");
        cMG.put("#(不高兴)", "image_emoticon12");
        cMG.put("#(真棒)", "image_emoticon13");
        cMG.put("#(钱)", "image_emoticon14");
        cMG.put("#(疑问)", "image_emoticon15");
        cMG.put("#(阴险)", "image_emoticon16");
        cMG.put("#(吐)", "image_emoticon17");
        cMG.put("#(咦)", "image_emoticon18");
        cMG.put("#(咦?)", "image_emoticon18");
        cMG.put("#(委屈)", "image_emoticon19");
        cMG.put("#(花心)", "image_emoticon20");
        cMG.put("#(呼~)", "image_emoticon21");
        cMG.put("#(笑眼)", "image_emoticon22");
        cMG.put("#(冷)", "image_emoticon23");
        cMG.put("#(太开心)", "image_emoticon24");
        cMG.put("#(滑稽)", "image_emoticon25");
        cMG.put("#(勉强)", "image_emoticon26");
        cMG.put("#(狂汗)", "image_emoticon27");
        cMG.put("#(乖)", "image_emoticon28");
        cMG.put("#(睡觉)", "image_emoticon29");
        cMG.put("#(惊哭)", "image_emoticon30");
        cMG.put("#(升起)", "image_emoticon31");
        cMG.put("#(惊讶)", "image_emoticon32");
        cMG.put("#(喷)", "image_emoticon33");
        cMG.put("#(爱心)", "image_emoticon34");
        cMG.put("#(心碎)", "image_emoticon35");
        cMG.put("#(玫瑰)", "image_emoticon36");
        cMG.put("#(礼物)", "image_emoticon37");
        cMG.put("#(彩虹)", "image_emoticon38");
        cMG.put("#(星星月亮)", "image_emoticon39");
        cMG.put("#(太阳)", "image_emoticon40");
        cMG.put("#(钱币)", "image_emoticon41");
        cMG.put("#(灯泡)", "image_emoticon42");
        cMG.put("#(茶杯)", "image_emoticon43");
        cMG.put("#(蛋糕)", "image_emoticon44");
        cMG.put("#(音乐)", "image_emoticon45");
        cMG.put("#(haha)", "image_emoticon46");
        cMG.put("#(胜利)", "image_emoticon47");
        cMG.put("#(大拇指)", "image_emoticon48");
        cMG.put("#(弱)", "image_emoticon49");
        cMG.put("#(OK)", "image_emoticon50");
        cMG.put("#(哼)", "image_emoticon61");
        cMG.put("#(吃瓜)", "image_emoticon62");
        cMG.put("#(扔便便)", "image_emoticon63");
        cMG.put("#(惊恐)", "image_emoticon64");
        cMG.put("#(哎呦)", "image_emoticon65");
        cMG.put("#(小乖)", "image_emoticon66");
        cMG.put("#(捂嘴笑)", "image_emoticon67");
        cMG.put("#(你懂的)", "image_emoticon68");
        cMG.put("#(what)", "image_emoticon69");
        cMG.put("#(酸爽)", "image_emoticon70");
        cMG.put("#(呀咩爹)", "image_emoticon71");
        cMG.put("#(笑尿)", "image_emoticon72");
        cMG.put("#(挖鼻)", "image_emoticon73");
        cMG.put("#(犀利)", "image_emoticon74");
        cMG.put("#(小红脸)", "image_emoticon75");
        cMG.put("#(懒得理)", "image_emoticon76");
        cMG.put("#(沙发)", "image_emoticon77");
        cMG.put("#(手纸)", "image_emoticon78");
        cMG.put("#(香蕉)", "image_emoticon79");
        cMG.put("#(便便)", "image_emoticon80");
        cMG.put("#(药丸)", "image_emoticon81");
        cMG.put("#(红领巾)", "image_emoticon82");
        cMG.put("#(蜡烛)", "image_emoticon83");
        cMG.put("#(三道杠)", "image_emoticon84");
        cMG.put("#(赖皮)", "ali_001");
        cMG.put("#(感动)", "ali_002");
        cMG.put("#(十分惊讶)", "ali_003");
        cMG.put("#(怒气)", "ali_004");
        cMG.put("#(哭泣)", "ali_005");
        cMG.put("#(吃惊)", "ali_006");
        cMG.put("#(嘲弄)", "ali_007");
        cMG.put("#(飘过)", "ali_008");
        cMG.put("#(转圈哭)", "ali_009");
        cMG.put("#(神经病)", "ali_010");
        cMG.put("#(揪耳朵)", "ali_011");
        cMG.put("#(惊汗)", "ali_012");
        cMG.put("#(隐身)", "ali_013");
        cMG.put("#(不要嘛)", "ali_014");
        cMG.put("#(遁)", "ali_015");
        cMG.put("#(不公平)", "ali_016");
        cMG.put("#(爬来了)", "ali_017");
        cMG.put("#(蛋花哭)", "ali_018");
        cMG.put("#(温暖)", "ali_019");
        cMG.put("#(点头)", "ali_020");
        cMG.put("#(撒钱)", "ali_021");
        cMG.put("#(献花)", "ali_022");
        cMG.put("#(寒)", "ali_023");
        cMG.put("#(傻笑)", "ali_024");
        cMG.put("#(扭扭)", "ali_025");
        cMG.put("#(疯)", "ali_026");
        cMG.put("#(抓狂)", "ali_027");
        cMG.put("#(抓)", "ali_028");
        cMG.put("#(蜷)", "ali_029");
        cMG.put("#(挠墙)", "ali_030");
        cMG.put("#(狂笑)", "ali_031");
        cMG.put("#(抱枕)", "ali_032");
        cMG.put("#(吼叫)", "ali_033");
        cMG.put("#(嚷)", "ali_034");
        cMG.put("#(唠叨)", "ali_035");
        cMG.put("#(捏脸)", "ali_036");
        cMG.put("#(爆笑)", "ali_037");
        cMG.put("#(郁闷)", "ali_038");
        cMG.put("#(潜水)", "ali_039");
        cMG.put("#(十分开心)", "ali_040");
        cMG.put("#(冷笑话)", "ali_041");
        cMG.put("#(顶！)", "ali_042");
        cMG.put("#(潜)", "ali_043");
        cMG.put("#(画圈圈)", "ali_044");
        cMG.put("#(玩电脑)", "ali_045");
        cMG.put("#(狂吐)", "ali_046");
        cMG.put("#(哭着跑)", "ali_047");
        cMG.put("#(阿狸侠)", "ali_048");
        cMG.put("#(冷死了)", "ali_049");
        cMG.put("#(惆怅~)", "ali_050");
        cMG.put("#(摸头)", "ali_051");
        cMG.put("#(蹭)", "ali_052");
        cMG.put("#(打滚)", "ali_053");
        cMG.put("#(叩拜)", "ali_054");
        cMG.put("#(摸)", "ali_055");
        cMG.put("#(数钱)", "ali_056");
        cMG.put("#(拖走)", "ali_057");
        cMG.put("#(热)", "ali_058");
        cMG.put("#(加1)", "ali_059");
        cMG.put("#(压力)", "ali_060");
        cMG.put("#(表逼我)", "ali_061");
        cMG.put("#(人呢)", "ali_062");
        cMG.put("#(摇晃)", "ali_063");
        cMG.put("#(打地鼠)", "ali_064");
        cMG.put("#(这个屌)", "ali_065");
        cMG.put("#(恐慌)", "ali_066");
        cMG.put("#(晕乎乎)", "ali_067");
        cMG.put("#(浮云)", "ali_068");
        cMG.put("#(给力)", "ali_069");
        cMG.put("#(杯具了)", "ali_070");
        cMG.put("#(焦糖舞)", "yz_001");
        cMG.put("#(翻滚)", "yz_002");
        cMG.put("#(拍屁股做鬼脸)", "yz_003");
        cMG.put("#(不)", "yz_004");
        cMG.put("#(河蟹掉啦)", "yz_005");
        cMG.put("#(哦耶)", "yz_006");
        cMG.put("#(我倒)", "yz_007");
        cMG.put("#(投降)", "yz_008");
        cMG.put("#(微笑)", "b01");
        cMG.put("#(帅哥)", "b02");
        cMG.put("#(美女)", "b03");
        cMG.put("#(老大)", "b04");
        cMG.put("#(哈哈哈)", "b05");
        cMG.put("#(奸笑)", "b06");
        cMG.put("#(傻乐)", "b07");
        cMG.put("#(飞吻)", "b08");
        cMG.put("#(害羞)", "b09");
        cMG.put("#(花痴)", "b10");
        cMG.put("#(憧憬)", "b11");
        cMG.put("#(你牛)", "b12");
        cMG.put("#(鼓掌)", "b13");
        cMG.put("#(可爱)", "b14");
        cMG.put("#(太委屈)", "b15");
        cMG.put("#(大哭)", "b16");
        cMG.put("#(泪奔)", "b17");
        cMG.put("#(寻死)", "b18");
        cMG.put("#(非常惊讶)", "b19");
        cMG.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cMG.get(str);
    }

    public static List<TbFaceManager.RichUnit> jR(String str) {
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
                        arrayList.add(jS(str2));
                        str2 = "";
                    }
                    arrayList.add(aZ(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(jS(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit jS(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aZ(String str, String str2) {
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
                        SpannableString a = a(tbRichTextData.It(), name, str3);
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
        int fi = TbFaceManager.EI().fi(str);
        if (fi != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a(TbadkCoreApplication.m9getInst(), fi);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            a.C0041a fK = TbFaceManager.EI().fK(str);
            if (fK != null) {
                int width = (int) (0.5d * fK.getWidth());
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
