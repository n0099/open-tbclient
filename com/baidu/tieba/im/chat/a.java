package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> gxP = new HashMap<>();

    static {
        gxP.put("#(呵呵)", "image_emoticon");
        gxP.put("#(哈哈)", "image_emoticon2");
        gxP.put("#(吐舌)", "image_emoticon3");
        gxP.put("#(啊)", "image_emoticon4");
        gxP.put("#(啊?)", "image_emoticon4");
        gxP.put("#(酷)", "image_emoticon5");
        gxP.put("#(怒)", "image_emoticon6");
        gxP.put("#(开心)", "image_emoticon7");
        gxP.put("#(汗)", "image_emoticon8");
        gxP.put("#(泪)", "image_emoticon9");
        gxP.put("#(黑线)", "image_emoticon10");
        gxP.put("#(鄙视)", "image_emoticon11");
        gxP.put("#(不高兴)", "image_emoticon12");
        gxP.put("#(真棒)", "image_emoticon13");
        gxP.put("#(钱)", "image_emoticon14");
        gxP.put("#(疑问)", "image_emoticon15");
        gxP.put("#(阴险)", "image_emoticon16");
        gxP.put("#(吐)", "image_emoticon17");
        gxP.put("#(咦)", "image_emoticon18");
        gxP.put("#(咦?)", "image_emoticon18");
        gxP.put("#(委屈)", "image_emoticon19");
        gxP.put("#(花心)", "image_emoticon20");
        gxP.put("#(呼~)", "image_emoticon21");
        gxP.put("#(笑眼)", "image_emoticon22");
        gxP.put("#(冷)", "image_emoticon23");
        gxP.put("#(太开心)", "image_emoticon24");
        gxP.put("#(滑稽)", "image_emoticon25");
        gxP.put("#(勉强)", "image_emoticon26");
        gxP.put("#(狂汗)", "image_emoticon27");
        gxP.put("#(乖)", "image_emoticon28");
        gxP.put("#(睡觉)", "image_emoticon29");
        gxP.put("#(惊哭)", "image_emoticon30");
        gxP.put("#(升起)", "image_emoticon31");
        gxP.put("#(惊讶)", "image_emoticon32");
        gxP.put("#(喷)", "image_emoticon33");
        gxP.put("#(爱心)", "image_emoticon34");
        gxP.put("#(心碎)", "image_emoticon35");
        gxP.put("#(玫瑰)", "image_emoticon36");
        gxP.put("#(礼物)", "image_emoticon37");
        gxP.put("#(彩虹)", "image_emoticon38");
        gxP.put("#(星星月亮)", "image_emoticon39");
        gxP.put("#(太阳)", "image_emoticon40");
        gxP.put("#(钱币)", "image_emoticon41");
        gxP.put("#(灯泡)", "image_emoticon42");
        gxP.put("#(茶杯)", "image_emoticon43");
        gxP.put("#(蛋糕)", "image_emoticon44");
        gxP.put("#(音乐)", "image_emoticon45");
        gxP.put("#(haha)", "image_emoticon46");
        gxP.put("#(胜利)", "image_emoticon47");
        gxP.put("#(大拇指)", "image_emoticon48");
        gxP.put("#(弱)", "image_emoticon49");
        gxP.put("#(OK)", "image_emoticon50");
        gxP.put("#(哼)", "image_emoticon61");
        gxP.put("#(吃瓜)", "image_emoticon62");
        gxP.put("#(扔便便)", "image_emoticon63");
        gxP.put("#(惊恐)", "image_emoticon64");
        gxP.put("#(哎呦)", "image_emoticon65");
        gxP.put("#(小乖)", "image_emoticon66");
        gxP.put("#(捂嘴笑)", "image_emoticon67");
        gxP.put("#(你懂的)", "image_emoticon68");
        gxP.put("#(what)", "image_emoticon69");
        gxP.put("#(酸爽)", "image_emoticon70");
        gxP.put("#(呀咩爹)", "image_emoticon71");
        gxP.put("#(笑尿)", "image_emoticon72");
        gxP.put("#(挖鼻)", "image_emoticon73");
        gxP.put("#(犀利)", "image_emoticon74");
        gxP.put("#(小红脸)", "image_emoticon75");
        gxP.put("#(懒得理)", "image_emoticon76");
        gxP.put("#(沙发)", "image_emoticon77");
        gxP.put("#(手纸)", "image_emoticon78");
        gxP.put("#(香蕉)", "image_emoticon79");
        gxP.put("#(便便)", "image_emoticon80");
        gxP.put("#(药丸)", "image_emoticon81");
        gxP.put("#(红领巾)", "image_emoticon82");
        gxP.put("#(蜡烛)", "image_emoticon83");
        gxP.put("#(三道杠)", "image_emoticon84");
        gxP.put("#(赖皮)", "ali_001");
        gxP.put("#(感动)", "ali_002");
        gxP.put("#(十分惊讶)", "ali_003");
        gxP.put("#(怒气)", "ali_004");
        gxP.put("#(哭泣)", "ali_005");
        gxP.put("#(吃惊)", "ali_006");
        gxP.put("#(嘲弄)", "ali_007");
        gxP.put("#(飘过)", "ali_008");
        gxP.put("#(转圈哭)", "ali_009");
        gxP.put("#(神经病)", "ali_010");
        gxP.put("#(揪耳朵)", "ali_011");
        gxP.put("#(惊汗)", "ali_012");
        gxP.put("#(隐身)", "ali_013");
        gxP.put("#(不要嘛)", "ali_014");
        gxP.put("#(遁)", "ali_015");
        gxP.put("#(不公平)", "ali_016");
        gxP.put("#(爬来了)", "ali_017");
        gxP.put("#(蛋花哭)", "ali_018");
        gxP.put("#(温暖)", "ali_019");
        gxP.put("#(点头)", "ali_020");
        gxP.put("#(撒钱)", "ali_021");
        gxP.put("#(献花)", "ali_022");
        gxP.put("#(寒)", "ali_023");
        gxP.put("#(傻笑)", "ali_024");
        gxP.put("#(扭扭)", "ali_025");
        gxP.put("#(疯)", "ali_026");
        gxP.put("#(抓狂)", "ali_027");
        gxP.put("#(抓)", "ali_028");
        gxP.put("#(蜷)", "ali_029");
        gxP.put("#(挠墙)", "ali_030");
        gxP.put("#(狂笑)", "ali_031");
        gxP.put("#(抱枕)", "ali_032");
        gxP.put("#(吼叫)", "ali_033");
        gxP.put("#(嚷)", "ali_034");
        gxP.put("#(唠叨)", "ali_035");
        gxP.put("#(捏脸)", "ali_036");
        gxP.put("#(爆笑)", "ali_037");
        gxP.put("#(郁闷)", "ali_038");
        gxP.put("#(潜水)", "ali_039");
        gxP.put("#(十分开心)", "ali_040");
        gxP.put("#(冷笑话)", "ali_041");
        gxP.put("#(顶！)", "ali_042");
        gxP.put("#(潜)", "ali_043");
        gxP.put("#(画圈圈)", "ali_044");
        gxP.put("#(玩电脑)", "ali_045");
        gxP.put("#(狂吐)", "ali_046");
        gxP.put("#(哭着跑)", "ali_047");
        gxP.put("#(阿狸侠)", "ali_048");
        gxP.put("#(冷死了)", "ali_049");
        gxP.put("#(惆怅~)", "ali_050");
        gxP.put("#(摸头)", "ali_051");
        gxP.put("#(蹭)", "ali_052");
        gxP.put("#(打滚)", "ali_053");
        gxP.put("#(叩拜)", "ali_054");
        gxP.put("#(摸)", "ali_055");
        gxP.put("#(数钱)", "ali_056");
        gxP.put("#(拖走)", "ali_057");
        gxP.put("#(热)", "ali_058");
        gxP.put("#(加1)", "ali_059");
        gxP.put("#(压力)", "ali_060");
        gxP.put("#(表逼我)", "ali_061");
        gxP.put("#(人呢)", "ali_062");
        gxP.put("#(摇晃)", "ali_063");
        gxP.put("#(打地鼠)", "ali_064");
        gxP.put("#(这个屌)", "ali_065");
        gxP.put("#(恐慌)", "ali_066");
        gxP.put("#(晕乎乎)", "ali_067");
        gxP.put("#(浮云)", "ali_068");
        gxP.put("#(给力)", "ali_069");
        gxP.put("#(杯具了)", "ali_070");
        gxP.put("#(焦糖舞)", "yz_001");
        gxP.put("#(翻滚)", "yz_002");
        gxP.put("#(拍屁股做鬼脸)", "yz_003");
        gxP.put("#(不)", "yz_004");
        gxP.put("#(河蟹掉啦)", "yz_005");
        gxP.put("#(哦耶)", "yz_006");
        gxP.put("#(我倒)", "yz_007");
        gxP.put("#(投降)", "yz_008");
        gxP.put("#(微笑)", "b01");
        gxP.put("#(帅哥)", "b02");
        gxP.put("#(美女)", "b03");
        gxP.put("#(老大)", "b04");
        gxP.put("#(哈哈哈)", "b05");
        gxP.put("#(奸笑)", "b06");
        gxP.put("#(傻乐)", "b07");
        gxP.put("#(飞吻)", "b08");
        gxP.put("#(害羞)", "b09");
        gxP.put("#(花痴)", "b10");
        gxP.put("#(憧憬)", "b11");
        gxP.put("#(你牛)", "b12");
        gxP.put("#(鼓掌)", "b13");
        gxP.put("#(可爱)", "b14");
        gxP.put("#(太委屈)", "b15");
        gxP.put("#(大哭)", "b16");
        gxP.put("#(泪奔)", "b17");
        gxP.put("#(寻死)", "b18");
        gxP.put("#(非常惊讶)", "b19");
        gxP.put("#(表示疑问)", "b20");
        gxP.put("#(暗中观察)", "image_emoticon85");
        gxP.put("#(吃瓜)", "image_emoticon86");
        gxP.put("#(喝酒)", "image_emoticon87");
        gxP.put("#(嘿嘿嘿)", "image_emoticon88");
        gxP.put("#(噗)", "image_emoticon89");
        gxP.put("#(困成狗)", "image_emoticon90");
        gxP.put("#(微微一笑)", "image_emoticon91");
        gxP.put("#(托腮)", "image_emoticon92");
        gxP.put("#(摊手)", "image_emoticon93");
        gxP.put("#(柯基暗中观察)", "image_emoticon94");
        gxP.put("#(欢呼)", "image_emoticon95");
        gxP.put("#(炸药)", "image_emoticon96");
        gxP.put("#(突然兴奋)", "image_emoticon97");
        gxP.put("#(紧张)", "image_emoticon98");
        gxP.put("#(黑头瞪眼)", "image_emoticon99");
        gxP.put("#(黑头高兴)", "image_emoticon100");
        gxP.put("#(不跟丑人说话)", "image_emoticon101");
        gxP.put("#(么么哒)", "image_emoticon102");
        gxP.put("#(亲亲才能起来)", "image_emoticon103");
        gxP.put("#(伦家只是宝宝)", "image_emoticon104");
        gxP.put("#(你是我的人)", "image_emoticon105");
        gxP.put("#(假装看不见)", "image_emoticon106");
        gxP.put("#(单身等撩)", "image_emoticon107");
        gxP.put("#(吓到宝宝了)", "image_emoticon108");
        gxP.put("#(哈哈哈)", "image_emoticon109");
        gxP.put("#(嗯嗯)", "image_emoticon110");
        gxP.put("#(好幸福)", "image_emoticon111");
        gxP.put("#(宝宝不开心)", "image_emoticon112");
        gxP.put("#(小姐姐别走)", "image_emoticon113");
        gxP.put("#(小姐姐在吗)", "image_emoticon114");
        gxP.put("#(小姐姐来啦)", "image_emoticon115");
        gxP.put("#(小姐姐来玩呀)", "image_emoticon116");
        gxP.put("#(我养你)", "image_emoticon117");
        gxP.put("#(我是不会骗你的)", "image_emoticon118");
        gxP.put("#(扎心了)", "image_emoticon119");
        gxP.put("#(无聊)", "image_emoticon120");
        gxP.put("#(月亮代表我的心)", "image_emoticon121");
        gxP.put("#(来追我呀)", "image_emoticon122");
        gxP.put("#(爱你的形状)", "image_emoticon123");
        gxP.put("#(白眼)", "image_emoticon124");
    }

    private static String xm(String str) {
        return gxP.get(str);
    }

    public static ArrayList<TbRichTextData> e(Context context, String str, int i) {
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
                    String xm = xm(str3);
                    if (TextUtils.isEmpty(xm)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.i(str5);
                            } else {
                                SpannableString aD = aD(context, str5);
                                if (aD != null) {
                                    tbRichTextData.i(aD);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.azm(), xm, str3);
                        if (a != null) {
                            tbRichTextData.i(a);
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
                    tbRichTextData.i(str5);
                } else {
                    SpannableString aD2 = aD(context, str5);
                    if (aD2 != null) {
                        tbRichTextData.i(aD2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int pz = TbFaceManager.avr().pz(str);
        if (pz != 0) {
            spannableString = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), pz);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0291a pV = TbFaceManager.avr().pV(str);
            if (pV != null) {
                int width = (int) (0.5d * pV.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aD(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ba.af(context, str);
    }
}
