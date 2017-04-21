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
    private static final HashMap<String, String> cOX = new HashMap<>();

    static {
        cOX.put("#(呵呵)", "image_emoticon");
        cOX.put("#(哈哈)", "image_emoticon2");
        cOX.put("#(吐舌)", "image_emoticon3");
        cOX.put("#(啊)", "image_emoticon4");
        cOX.put("#(啊?)", "image_emoticon4");
        cOX.put("#(酷)", "image_emoticon5");
        cOX.put("#(怒)", "image_emoticon6");
        cOX.put("#(开心)", "image_emoticon7");
        cOX.put("#(汗)", "image_emoticon8");
        cOX.put("#(泪)", "image_emoticon9");
        cOX.put("#(黑线)", "image_emoticon10");
        cOX.put("#(鄙视)", "image_emoticon11");
        cOX.put("#(不高兴)", "image_emoticon12");
        cOX.put("#(真棒)", "image_emoticon13");
        cOX.put("#(钱)", "image_emoticon14");
        cOX.put("#(疑问)", "image_emoticon15");
        cOX.put("#(阴险)", "image_emoticon16");
        cOX.put("#(吐)", "image_emoticon17");
        cOX.put("#(咦)", "image_emoticon18");
        cOX.put("#(咦?)", "image_emoticon18");
        cOX.put("#(委屈)", "image_emoticon19");
        cOX.put("#(花心)", "image_emoticon20");
        cOX.put("#(呼~)", "image_emoticon21");
        cOX.put("#(笑眼)", "image_emoticon22");
        cOX.put("#(冷)", "image_emoticon23");
        cOX.put("#(太开心)", "image_emoticon24");
        cOX.put("#(滑稽)", "image_emoticon25");
        cOX.put("#(勉强)", "image_emoticon26");
        cOX.put("#(狂汗)", "image_emoticon27");
        cOX.put("#(乖)", "image_emoticon28");
        cOX.put("#(睡觉)", "image_emoticon29");
        cOX.put("#(惊哭)", "image_emoticon30");
        cOX.put("#(升起)", "image_emoticon31");
        cOX.put("#(惊讶)", "image_emoticon32");
        cOX.put("#(喷)", "image_emoticon33");
        cOX.put("#(爱心)", "image_emoticon34");
        cOX.put("#(心碎)", "image_emoticon35");
        cOX.put("#(玫瑰)", "image_emoticon36");
        cOX.put("#(礼物)", "image_emoticon37");
        cOX.put("#(彩虹)", "image_emoticon38");
        cOX.put("#(星星月亮)", "image_emoticon39");
        cOX.put("#(太阳)", "image_emoticon40");
        cOX.put("#(钱币)", "image_emoticon41");
        cOX.put("#(灯泡)", "image_emoticon42");
        cOX.put("#(茶杯)", "image_emoticon43");
        cOX.put("#(蛋糕)", "image_emoticon44");
        cOX.put("#(音乐)", "image_emoticon45");
        cOX.put("#(haha)", "image_emoticon46");
        cOX.put("#(胜利)", "image_emoticon47");
        cOX.put("#(大拇指)", "image_emoticon48");
        cOX.put("#(弱)", "image_emoticon49");
        cOX.put("#(OK)", "image_emoticon50");
        cOX.put("#(哼)", "image_emoticon61");
        cOX.put("#(吃瓜)", "image_emoticon62");
        cOX.put("#(扔便便)", "image_emoticon63");
        cOX.put("#(惊恐)", "image_emoticon64");
        cOX.put("#(哎呦)", "image_emoticon65");
        cOX.put("#(小乖)", "image_emoticon66");
        cOX.put("#(捂嘴笑)", "image_emoticon67");
        cOX.put("#(你懂的)", "image_emoticon68");
        cOX.put("#(what)", "image_emoticon69");
        cOX.put("#(酸爽)", "image_emoticon70");
        cOX.put("#(呀咩爹)", "image_emoticon71");
        cOX.put("#(笑尿)", "image_emoticon72");
        cOX.put("#(挖鼻)", "image_emoticon73");
        cOX.put("#(犀利)", "image_emoticon74");
        cOX.put("#(小红脸)", "image_emoticon75");
        cOX.put("#(懒得理)", "image_emoticon76");
        cOX.put("#(沙发)", "image_emoticon77");
        cOX.put("#(手纸)", "image_emoticon78");
        cOX.put("#(香蕉)", "image_emoticon79");
        cOX.put("#(便便)", "image_emoticon80");
        cOX.put("#(药丸)", "image_emoticon81");
        cOX.put("#(红领巾)", "image_emoticon82");
        cOX.put("#(蜡烛)", "image_emoticon83");
        cOX.put("#(三道杠)", "image_emoticon84");
        cOX.put("#(赖皮)", "ali_001");
        cOX.put("#(感动)", "ali_002");
        cOX.put("#(十分惊讶)", "ali_003");
        cOX.put("#(怒气)", "ali_004");
        cOX.put("#(哭泣)", "ali_005");
        cOX.put("#(吃惊)", "ali_006");
        cOX.put("#(嘲弄)", "ali_007");
        cOX.put("#(飘过)", "ali_008");
        cOX.put("#(转圈哭)", "ali_009");
        cOX.put("#(神经病)", "ali_010");
        cOX.put("#(揪耳朵)", "ali_011");
        cOX.put("#(惊汗)", "ali_012");
        cOX.put("#(隐身)", "ali_013");
        cOX.put("#(不要嘛)", "ali_014");
        cOX.put("#(遁)", "ali_015");
        cOX.put("#(不公平)", "ali_016");
        cOX.put("#(爬来了)", "ali_017");
        cOX.put("#(蛋花哭)", "ali_018");
        cOX.put("#(温暖)", "ali_019");
        cOX.put("#(点头)", "ali_020");
        cOX.put("#(撒钱)", "ali_021");
        cOX.put("#(献花)", "ali_022");
        cOX.put("#(寒)", "ali_023");
        cOX.put("#(傻笑)", "ali_024");
        cOX.put("#(扭扭)", "ali_025");
        cOX.put("#(疯)", "ali_026");
        cOX.put("#(抓狂)", "ali_027");
        cOX.put("#(抓)", "ali_028");
        cOX.put("#(蜷)", "ali_029");
        cOX.put("#(挠墙)", "ali_030");
        cOX.put("#(狂笑)", "ali_031");
        cOX.put("#(抱枕)", "ali_032");
        cOX.put("#(吼叫)", "ali_033");
        cOX.put("#(嚷)", "ali_034");
        cOX.put("#(唠叨)", "ali_035");
        cOX.put("#(捏脸)", "ali_036");
        cOX.put("#(爆笑)", "ali_037");
        cOX.put("#(郁闷)", "ali_038");
        cOX.put("#(潜水)", "ali_039");
        cOX.put("#(十分开心)", "ali_040");
        cOX.put("#(冷笑话)", "ali_041");
        cOX.put("#(顶！)", "ali_042");
        cOX.put("#(潜)", "ali_043");
        cOX.put("#(画圈圈)", "ali_044");
        cOX.put("#(玩电脑)", "ali_045");
        cOX.put("#(狂吐)", "ali_046");
        cOX.put("#(哭着跑)", "ali_047");
        cOX.put("#(阿狸侠)", "ali_048");
        cOX.put("#(冷死了)", "ali_049");
        cOX.put("#(惆怅~)", "ali_050");
        cOX.put("#(摸头)", "ali_051");
        cOX.put("#(蹭)", "ali_052");
        cOX.put("#(打滚)", "ali_053");
        cOX.put("#(叩拜)", "ali_054");
        cOX.put("#(摸)", "ali_055");
        cOX.put("#(数钱)", "ali_056");
        cOX.put("#(拖走)", "ali_057");
        cOX.put("#(热)", "ali_058");
        cOX.put("#(加1)", "ali_059");
        cOX.put("#(压力)", "ali_060");
        cOX.put("#(表逼我)", "ali_061");
        cOX.put("#(人呢)", "ali_062");
        cOX.put("#(摇晃)", "ali_063");
        cOX.put("#(打地鼠)", "ali_064");
        cOX.put("#(这个屌)", "ali_065");
        cOX.put("#(恐慌)", "ali_066");
        cOX.put("#(晕乎乎)", "ali_067");
        cOX.put("#(浮云)", "ali_068");
        cOX.put("#(给力)", "ali_069");
        cOX.put("#(杯具了)", "ali_070");
        cOX.put("#(焦糖舞)", "yz_001");
        cOX.put("#(翻滚)", "yz_002");
        cOX.put("#(拍屁股做鬼脸)", "yz_003");
        cOX.put("#(不)", "yz_004");
        cOX.put("#(河蟹掉啦)", "yz_005");
        cOX.put("#(哦耶)", "yz_006");
        cOX.put("#(我倒)", "yz_007");
        cOX.put("#(投降)", "yz_008");
        cOX.put("#(微笑)", "b01");
        cOX.put("#(帅哥)", "b02");
        cOX.put("#(美女)", "b03");
        cOX.put("#(老大)", "b04");
        cOX.put("#(哈哈哈)", "b05");
        cOX.put("#(奸笑)", "b06");
        cOX.put("#(傻乐)", "b07");
        cOX.put("#(飞吻)", "b08");
        cOX.put("#(害羞)", "b09");
        cOX.put("#(花痴)", "b10");
        cOX.put("#(憧憬)", "b11");
        cOX.put("#(你牛)", "b12");
        cOX.put("#(鼓掌)", "b13");
        cOX.put("#(可爱)", "b14");
        cOX.put("#(太委屈)", "b15");
        cOX.put("#(大哭)", "b16");
        cOX.put("#(泪奔)", "b17");
        cOX.put("#(寻死)", "b18");
        cOX.put("#(非常惊讶)", "b19");
        cOX.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cOX.get(str);
    }

    public static List<TbFaceManager.RichUnit> jS(String str) {
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
                        arrayList.add(jT(str2));
                        str2 = "";
                    }
                    arrayList.add(aY(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(jT(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit jT(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aY(String str, String str2) {
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
