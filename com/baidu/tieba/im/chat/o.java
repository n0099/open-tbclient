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
    private static final HashMap<String, String> cOy = new HashMap<>();

    static {
        cOy.put("#(呵呵)", "image_emoticon");
        cOy.put("#(哈哈)", "image_emoticon2");
        cOy.put("#(吐舌)", "image_emoticon3");
        cOy.put("#(啊)", "image_emoticon4");
        cOy.put("#(啊?)", "image_emoticon4");
        cOy.put("#(酷)", "image_emoticon5");
        cOy.put("#(怒)", "image_emoticon6");
        cOy.put("#(开心)", "image_emoticon7");
        cOy.put("#(汗)", "image_emoticon8");
        cOy.put("#(泪)", "image_emoticon9");
        cOy.put("#(黑线)", "image_emoticon10");
        cOy.put("#(鄙视)", "image_emoticon11");
        cOy.put("#(不高兴)", "image_emoticon12");
        cOy.put("#(真棒)", "image_emoticon13");
        cOy.put("#(钱)", "image_emoticon14");
        cOy.put("#(疑问)", "image_emoticon15");
        cOy.put("#(阴险)", "image_emoticon16");
        cOy.put("#(吐)", "image_emoticon17");
        cOy.put("#(咦)", "image_emoticon18");
        cOy.put("#(咦?)", "image_emoticon18");
        cOy.put("#(委屈)", "image_emoticon19");
        cOy.put("#(花心)", "image_emoticon20");
        cOy.put("#(呼~)", "image_emoticon21");
        cOy.put("#(笑眼)", "image_emoticon22");
        cOy.put("#(冷)", "image_emoticon23");
        cOy.put("#(太开心)", "image_emoticon24");
        cOy.put("#(滑稽)", "image_emoticon25");
        cOy.put("#(勉强)", "image_emoticon26");
        cOy.put("#(狂汗)", "image_emoticon27");
        cOy.put("#(乖)", "image_emoticon28");
        cOy.put("#(睡觉)", "image_emoticon29");
        cOy.put("#(惊哭)", "image_emoticon30");
        cOy.put("#(升起)", "image_emoticon31");
        cOy.put("#(惊讶)", "image_emoticon32");
        cOy.put("#(喷)", "image_emoticon33");
        cOy.put("#(爱心)", "image_emoticon34");
        cOy.put("#(心碎)", "image_emoticon35");
        cOy.put("#(玫瑰)", "image_emoticon36");
        cOy.put("#(礼物)", "image_emoticon37");
        cOy.put("#(彩虹)", "image_emoticon38");
        cOy.put("#(星星月亮)", "image_emoticon39");
        cOy.put("#(太阳)", "image_emoticon40");
        cOy.put("#(钱币)", "image_emoticon41");
        cOy.put("#(灯泡)", "image_emoticon42");
        cOy.put("#(茶杯)", "image_emoticon43");
        cOy.put("#(蛋糕)", "image_emoticon44");
        cOy.put("#(音乐)", "image_emoticon45");
        cOy.put("#(haha)", "image_emoticon46");
        cOy.put("#(胜利)", "image_emoticon47");
        cOy.put("#(大拇指)", "image_emoticon48");
        cOy.put("#(弱)", "image_emoticon49");
        cOy.put("#(OK)", "image_emoticon50");
        cOy.put("#(哼)", "image_emoticon61");
        cOy.put("#(吃瓜)", "image_emoticon62");
        cOy.put("#(扔便便)", "image_emoticon63");
        cOy.put("#(惊恐)", "image_emoticon64");
        cOy.put("#(哎呦)", "image_emoticon65");
        cOy.put("#(小乖)", "image_emoticon66");
        cOy.put("#(捂嘴笑)", "image_emoticon67");
        cOy.put("#(你懂的)", "image_emoticon68");
        cOy.put("#(what)", "image_emoticon69");
        cOy.put("#(酸爽)", "image_emoticon70");
        cOy.put("#(呀咩爹)", "image_emoticon71");
        cOy.put("#(笑尿)", "image_emoticon72");
        cOy.put("#(挖鼻)", "image_emoticon73");
        cOy.put("#(犀利)", "image_emoticon74");
        cOy.put("#(小红脸)", "image_emoticon75");
        cOy.put("#(懒得理)", "image_emoticon76");
        cOy.put("#(沙发)", "image_emoticon77");
        cOy.put("#(手纸)", "image_emoticon78");
        cOy.put("#(香蕉)", "image_emoticon79");
        cOy.put("#(便便)", "image_emoticon80");
        cOy.put("#(药丸)", "image_emoticon81");
        cOy.put("#(红领巾)", "image_emoticon82");
        cOy.put("#(蜡烛)", "image_emoticon83");
        cOy.put("#(三道杠)", "image_emoticon84");
        cOy.put("#(赖皮)", "ali_001");
        cOy.put("#(感动)", "ali_002");
        cOy.put("#(十分惊讶)", "ali_003");
        cOy.put("#(怒气)", "ali_004");
        cOy.put("#(哭泣)", "ali_005");
        cOy.put("#(吃惊)", "ali_006");
        cOy.put("#(嘲弄)", "ali_007");
        cOy.put("#(飘过)", "ali_008");
        cOy.put("#(转圈哭)", "ali_009");
        cOy.put("#(神经病)", "ali_010");
        cOy.put("#(揪耳朵)", "ali_011");
        cOy.put("#(惊汗)", "ali_012");
        cOy.put("#(隐身)", "ali_013");
        cOy.put("#(不要嘛)", "ali_014");
        cOy.put("#(遁)", "ali_015");
        cOy.put("#(不公平)", "ali_016");
        cOy.put("#(爬来了)", "ali_017");
        cOy.put("#(蛋花哭)", "ali_018");
        cOy.put("#(温暖)", "ali_019");
        cOy.put("#(点头)", "ali_020");
        cOy.put("#(撒钱)", "ali_021");
        cOy.put("#(献花)", "ali_022");
        cOy.put("#(寒)", "ali_023");
        cOy.put("#(傻笑)", "ali_024");
        cOy.put("#(扭扭)", "ali_025");
        cOy.put("#(疯)", "ali_026");
        cOy.put("#(抓狂)", "ali_027");
        cOy.put("#(抓)", "ali_028");
        cOy.put("#(蜷)", "ali_029");
        cOy.put("#(挠墙)", "ali_030");
        cOy.put("#(狂笑)", "ali_031");
        cOy.put("#(抱枕)", "ali_032");
        cOy.put("#(吼叫)", "ali_033");
        cOy.put("#(嚷)", "ali_034");
        cOy.put("#(唠叨)", "ali_035");
        cOy.put("#(捏脸)", "ali_036");
        cOy.put("#(爆笑)", "ali_037");
        cOy.put("#(郁闷)", "ali_038");
        cOy.put("#(潜水)", "ali_039");
        cOy.put("#(十分开心)", "ali_040");
        cOy.put("#(冷笑话)", "ali_041");
        cOy.put("#(顶！)", "ali_042");
        cOy.put("#(潜)", "ali_043");
        cOy.put("#(画圈圈)", "ali_044");
        cOy.put("#(玩电脑)", "ali_045");
        cOy.put("#(狂吐)", "ali_046");
        cOy.put("#(哭着跑)", "ali_047");
        cOy.put("#(阿狸侠)", "ali_048");
        cOy.put("#(冷死了)", "ali_049");
        cOy.put("#(惆怅~)", "ali_050");
        cOy.put("#(摸头)", "ali_051");
        cOy.put("#(蹭)", "ali_052");
        cOy.put("#(打滚)", "ali_053");
        cOy.put("#(叩拜)", "ali_054");
        cOy.put("#(摸)", "ali_055");
        cOy.put("#(数钱)", "ali_056");
        cOy.put("#(拖走)", "ali_057");
        cOy.put("#(热)", "ali_058");
        cOy.put("#(加1)", "ali_059");
        cOy.put("#(压力)", "ali_060");
        cOy.put("#(表逼我)", "ali_061");
        cOy.put("#(人呢)", "ali_062");
        cOy.put("#(摇晃)", "ali_063");
        cOy.put("#(打地鼠)", "ali_064");
        cOy.put("#(这个屌)", "ali_065");
        cOy.put("#(恐慌)", "ali_066");
        cOy.put("#(晕乎乎)", "ali_067");
        cOy.put("#(浮云)", "ali_068");
        cOy.put("#(给力)", "ali_069");
        cOy.put("#(杯具了)", "ali_070");
        cOy.put("#(焦糖舞)", "yz_001");
        cOy.put("#(翻滚)", "yz_002");
        cOy.put("#(拍屁股做鬼脸)", "yz_003");
        cOy.put("#(不)", "yz_004");
        cOy.put("#(河蟹掉啦)", "yz_005");
        cOy.put("#(哦耶)", "yz_006");
        cOy.put("#(我倒)", "yz_007");
        cOy.put("#(投降)", "yz_008");
        cOy.put("#(微笑)", "b01");
        cOy.put("#(帅哥)", "b02");
        cOy.put("#(美女)", "b03");
        cOy.put("#(老大)", "b04");
        cOy.put("#(哈哈哈)", "b05");
        cOy.put("#(奸笑)", "b06");
        cOy.put("#(傻乐)", "b07");
        cOy.put("#(飞吻)", "b08");
        cOy.put("#(害羞)", "b09");
        cOy.put("#(花痴)", "b10");
        cOy.put("#(憧憬)", "b11");
        cOy.put("#(你牛)", "b12");
        cOy.put("#(鼓掌)", "b13");
        cOy.put("#(可爱)", "b14");
        cOy.put("#(太委屈)", "b15");
        cOy.put("#(大哭)", "b16");
        cOy.put("#(泪奔)", "b17");
        cOy.put("#(寻死)", "b18");
        cOy.put("#(非常惊讶)", "b19");
        cOy.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return cOy.get(str);
    }

    public static List<TbFaceManager.RichUnit> kg(String str) {
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
                        arrayList.add(kh(str2));
                        str2 = "";
                    }
                    arrayList.add(aW(str3, name));
                }
            } else {
                str2 = String.valueOf(str2) + charAt;
            }
            i++;
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(kh(str2));
        }
        return arrayList;
    }

    private static TbFaceManager.RichUnit kh(String str) {
        TbFaceManager.RichUnit richUnit = new TbFaceManager.RichUnit();
        richUnit.text = str;
        richUnit.type = 0;
        return richUnit;
    }

    private static TbFaceManager.RichUnit aW(String str, String str2) {
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
                                SpannableString al = al(context, str2);
                                if (al != null) {
                                    tbRichTextData.append(al);
                                }
                            }
                            str2 = "";
                        }
                        SpannableString a = a(tbRichTextData.HC(), name, str3);
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
                    SpannableString al2 = al(context, str2);
                    if (al2 != null) {
                        tbRichTextData.append(al2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.a> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fd = TbFaceManager.DG().fd(str);
        if (fd != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a(TbadkCoreApplication.m9getInst(), fd);
            if (arrayList != null) {
                arrayList.add(aVar);
            }
            a.C0045a fF = TbFaceManager.DG().fF(str);
            if (fF != null) {
                int width = (int) (0.5d * fF.getWidth());
                aVar.setBounds(new Rect(0, 0, width, width));
            } else {
                aVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(aVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString al(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.bb.V(context, str);
    }
}
