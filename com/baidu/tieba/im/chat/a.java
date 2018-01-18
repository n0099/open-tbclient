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
import com.baidu.tbadk.widget.richText.b;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> eqx = new HashMap<>();

    static {
        eqx.put("#(呵呵)", "image_emoticon");
        eqx.put("#(哈哈)", "image_emoticon2");
        eqx.put("#(吐舌)", "image_emoticon3");
        eqx.put("#(啊)", "image_emoticon4");
        eqx.put("#(啊?)", "image_emoticon4");
        eqx.put("#(酷)", "image_emoticon5");
        eqx.put("#(怒)", "image_emoticon6");
        eqx.put("#(开心)", "image_emoticon7");
        eqx.put("#(汗)", "image_emoticon8");
        eqx.put("#(泪)", "image_emoticon9");
        eqx.put("#(黑线)", "image_emoticon10");
        eqx.put("#(鄙视)", "image_emoticon11");
        eqx.put("#(不高兴)", "image_emoticon12");
        eqx.put("#(真棒)", "image_emoticon13");
        eqx.put("#(钱)", "image_emoticon14");
        eqx.put("#(疑问)", "image_emoticon15");
        eqx.put("#(阴险)", "image_emoticon16");
        eqx.put("#(吐)", "image_emoticon17");
        eqx.put("#(咦)", "image_emoticon18");
        eqx.put("#(咦?)", "image_emoticon18");
        eqx.put("#(委屈)", "image_emoticon19");
        eqx.put("#(花心)", "image_emoticon20");
        eqx.put("#(呼~)", "image_emoticon21");
        eqx.put("#(笑眼)", "image_emoticon22");
        eqx.put("#(冷)", "image_emoticon23");
        eqx.put("#(太开心)", "image_emoticon24");
        eqx.put("#(滑稽)", "image_emoticon25");
        eqx.put("#(勉强)", "image_emoticon26");
        eqx.put("#(狂汗)", "image_emoticon27");
        eqx.put("#(乖)", "image_emoticon28");
        eqx.put("#(睡觉)", "image_emoticon29");
        eqx.put("#(惊哭)", "image_emoticon30");
        eqx.put("#(升起)", "image_emoticon31");
        eqx.put("#(惊讶)", "image_emoticon32");
        eqx.put("#(喷)", "image_emoticon33");
        eqx.put("#(爱心)", "image_emoticon34");
        eqx.put("#(心碎)", "image_emoticon35");
        eqx.put("#(玫瑰)", "image_emoticon36");
        eqx.put("#(礼物)", "image_emoticon37");
        eqx.put("#(彩虹)", "image_emoticon38");
        eqx.put("#(星星月亮)", "image_emoticon39");
        eqx.put("#(太阳)", "image_emoticon40");
        eqx.put("#(钱币)", "image_emoticon41");
        eqx.put("#(灯泡)", "image_emoticon42");
        eqx.put("#(茶杯)", "image_emoticon43");
        eqx.put("#(蛋糕)", "image_emoticon44");
        eqx.put("#(音乐)", "image_emoticon45");
        eqx.put("#(haha)", "image_emoticon46");
        eqx.put("#(胜利)", "image_emoticon47");
        eqx.put("#(大拇指)", "image_emoticon48");
        eqx.put("#(弱)", "image_emoticon49");
        eqx.put("#(OK)", "image_emoticon50");
        eqx.put("#(哼)", "image_emoticon61");
        eqx.put("#(吃瓜)", "image_emoticon62");
        eqx.put("#(扔便便)", "image_emoticon63");
        eqx.put("#(惊恐)", "image_emoticon64");
        eqx.put("#(哎呦)", "image_emoticon65");
        eqx.put("#(小乖)", "image_emoticon66");
        eqx.put("#(捂嘴笑)", "image_emoticon67");
        eqx.put("#(你懂的)", "image_emoticon68");
        eqx.put("#(what)", "image_emoticon69");
        eqx.put("#(酸爽)", "image_emoticon70");
        eqx.put("#(呀咩爹)", "image_emoticon71");
        eqx.put("#(笑尿)", "image_emoticon72");
        eqx.put("#(挖鼻)", "image_emoticon73");
        eqx.put("#(犀利)", "image_emoticon74");
        eqx.put("#(小红脸)", "image_emoticon75");
        eqx.put("#(懒得理)", "image_emoticon76");
        eqx.put("#(沙发)", "image_emoticon77");
        eqx.put("#(手纸)", "image_emoticon78");
        eqx.put("#(香蕉)", "image_emoticon79");
        eqx.put("#(便便)", "image_emoticon80");
        eqx.put("#(药丸)", "image_emoticon81");
        eqx.put("#(红领巾)", "image_emoticon82");
        eqx.put("#(蜡烛)", "image_emoticon83");
        eqx.put("#(三道杠)", "image_emoticon84");
        eqx.put("#(赖皮)", "ali_001");
        eqx.put("#(感动)", "ali_002");
        eqx.put("#(十分惊讶)", "ali_003");
        eqx.put("#(怒气)", "ali_004");
        eqx.put("#(哭泣)", "ali_005");
        eqx.put("#(吃惊)", "ali_006");
        eqx.put("#(嘲弄)", "ali_007");
        eqx.put("#(飘过)", "ali_008");
        eqx.put("#(转圈哭)", "ali_009");
        eqx.put("#(神经病)", "ali_010");
        eqx.put("#(揪耳朵)", "ali_011");
        eqx.put("#(惊汗)", "ali_012");
        eqx.put("#(隐身)", "ali_013");
        eqx.put("#(不要嘛)", "ali_014");
        eqx.put("#(遁)", "ali_015");
        eqx.put("#(不公平)", "ali_016");
        eqx.put("#(爬来了)", "ali_017");
        eqx.put("#(蛋花哭)", "ali_018");
        eqx.put("#(温暖)", "ali_019");
        eqx.put("#(点头)", "ali_020");
        eqx.put("#(撒钱)", "ali_021");
        eqx.put("#(献花)", "ali_022");
        eqx.put("#(寒)", "ali_023");
        eqx.put("#(傻笑)", "ali_024");
        eqx.put("#(扭扭)", "ali_025");
        eqx.put("#(疯)", "ali_026");
        eqx.put("#(抓狂)", "ali_027");
        eqx.put("#(抓)", "ali_028");
        eqx.put("#(蜷)", "ali_029");
        eqx.put("#(挠墙)", "ali_030");
        eqx.put("#(狂笑)", "ali_031");
        eqx.put("#(抱枕)", "ali_032");
        eqx.put("#(吼叫)", "ali_033");
        eqx.put("#(嚷)", "ali_034");
        eqx.put("#(唠叨)", "ali_035");
        eqx.put("#(捏脸)", "ali_036");
        eqx.put("#(爆笑)", "ali_037");
        eqx.put("#(郁闷)", "ali_038");
        eqx.put("#(潜水)", "ali_039");
        eqx.put("#(十分开心)", "ali_040");
        eqx.put("#(冷笑话)", "ali_041");
        eqx.put("#(顶！)", "ali_042");
        eqx.put("#(潜)", "ali_043");
        eqx.put("#(画圈圈)", "ali_044");
        eqx.put("#(玩电脑)", "ali_045");
        eqx.put("#(狂吐)", "ali_046");
        eqx.put("#(哭着跑)", "ali_047");
        eqx.put("#(阿狸侠)", "ali_048");
        eqx.put("#(冷死了)", "ali_049");
        eqx.put("#(惆怅~)", "ali_050");
        eqx.put("#(摸头)", "ali_051");
        eqx.put("#(蹭)", "ali_052");
        eqx.put("#(打滚)", "ali_053");
        eqx.put("#(叩拜)", "ali_054");
        eqx.put("#(摸)", "ali_055");
        eqx.put("#(数钱)", "ali_056");
        eqx.put("#(拖走)", "ali_057");
        eqx.put("#(热)", "ali_058");
        eqx.put("#(加1)", "ali_059");
        eqx.put("#(压力)", "ali_060");
        eqx.put("#(表逼我)", "ali_061");
        eqx.put("#(人呢)", "ali_062");
        eqx.put("#(摇晃)", "ali_063");
        eqx.put("#(打地鼠)", "ali_064");
        eqx.put("#(这个屌)", "ali_065");
        eqx.put("#(恐慌)", "ali_066");
        eqx.put("#(晕乎乎)", "ali_067");
        eqx.put("#(浮云)", "ali_068");
        eqx.put("#(给力)", "ali_069");
        eqx.put("#(杯具了)", "ali_070");
        eqx.put("#(焦糖舞)", "yz_001");
        eqx.put("#(翻滚)", "yz_002");
        eqx.put("#(拍屁股做鬼脸)", "yz_003");
        eqx.put("#(不)", "yz_004");
        eqx.put("#(河蟹掉啦)", "yz_005");
        eqx.put("#(哦耶)", "yz_006");
        eqx.put("#(我倒)", "yz_007");
        eqx.put("#(投降)", "yz_008");
        eqx.put("#(微笑)", "b01");
        eqx.put("#(帅哥)", "b02");
        eqx.put("#(美女)", "b03");
        eqx.put("#(老大)", "b04");
        eqx.put("#(哈哈哈)", "b05");
        eqx.put("#(奸笑)", "b06");
        eqx.put("#(傻乐)", "b07");
        eqx.put("#(飞吻)", "b08");
        eqx.put("#(害羞)", "b09");
        eqx.put("#(花痴)", "b10");
        eqx.put("#(憧憬)", "b11");
        eqx.put("#(你牛)", "b12");
        eqx.put("#(鼓掌)", "b13");
        eqx.put("#(可爱)", "b14");
        eqx.put("#(太委屈)", "b15");
        eqx.put("#(大哭)", "b16");
        eqx.put("#(泪奔)", "b17");
        eqx.put("#(寻死)", "b18");
        eqx.put("#(非常惊讶)", "b19");
        eqx.put("#(表示疑问)", "b20");
        eqx.put("#(暗中观察)", "image_emoticon85");
        eqx.put("#(吃瓜)", "image_emoticon86");
        eqx.put("#(喝酒)", "image_emoticon87");
        eqx.put("#(嘿嘿嘿)", "image_emoticon88");
        eqx.put("#(噗)", "image_emoticon89");
        eqx.put("#(困成狗)", "image_emoticon90");
        eqx.put("#(微微一笑)", "image_emoticon91");
        eqx.put("#(托腮)", "image_emoticon92");
        eqx.put("#(摊手)", "image_emoticon93");
        eqx.put("#(柯基暗中观察)", "image_emoticon94");
        eqx.put("#(欢呼)", "image_emoticon95");
        eqx.put("#(炸药)", "image_emoticon96");
        eqx.put("#(突然兴奋)", "image_emoticon97");
        eqx.put("#(紧张)", "image_emoticon98");
        eqx.put("#(黑头瞪眼)", "image_emoticon99");
        eqx.put("#(黑头高兴)", "image_emoticon100");
    }

    private static String getName(String str) {
        return eqx.get(str);
    }

    public static ArrayList<TbRichTextData> g(Context context, String str, int i) {
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
                        SpannableString b = b(tbRichTextData.QG(), name, str3);
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

    private static SpannableString b(ArrayList<b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int fT = TbFaceManager.LO().fT(str);
        if (fT != 0) {
            spannableString = new SpannableString(str2 + " ");
            b bVar = new b(TbadkCoreApplication.getInst(), fT);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0084a gt = TbFaceManager.LO().gt(str);
            if (gt != null) {
                int width = (int) (0.5d * gt.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString ah(Context context, String str) {
        if (str == null) {
            return null;
        }
        return av.T(context, str);
    }
}
