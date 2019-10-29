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
    private static final HashMap<String, String> gyG = new HashMap<>();

    static {
        gyG.put("#(呵呵)", "image_emoticon");
        gyG.put("#(哈哈)", "image_emoticon2");
        gyG.put("#(吐舌)", "image_emoticon3");
        gyG.put("#(啊)", "image_emoticon4");
        gyG.put("#(啊?)", "image_emoticon4");
        gyG.put("#(酷)", "image_emoticon5");
        gyG.put("#(怒)", "image_emoticon6");
        gyG.put("#(开心)", "image_emoticon7");
        gyG.put("#(汗)", "image_emoticon8");
        gyG.put("#(泪)", "image_emoticon9");
        gyG.put("#(黑线)", "image_emoticon10");
        gyG.put("#(鄙视)", "image_emoticon11");
        gyG.put("#(不高兴)", "image_emoticon12");
        gyG.put("#(真棒)", "image_emoticon13");
        gyG.put("#(钱)", "image_emoticon14");
        gyG.put("#(疑问)", "image_emoticon15");
        gyG.put("#(阴险)", "image_emoticon16");
        gyG.put("#(吐)", "image_emoticon17");
        gyG.put("#(咦)", "image_emoticon18");
        gyG.put("#(咦?)", "image_emoticon18");
        gyG.put("#(委屈)", "image_emoticon19");
        gyG.put("#(花心)", "image_emoticon20");
        gyG.put("#(呼~)", "image_emoticon21");
        gyG.put("#(笑眼)", "image_emoticon22");
        gyG.put("#(冷)", "image_emoticon23");
        gyG.put("#(太开心)", "image_emoticon24");
        gyG.put("#(滑稽)", "image_emoticon25");
        gyG.put("#(勉强)", "image_emoticon26");
        gyG.put("#(狂汗)", "image_emoticon27");
        gyG.put("#(乖)", "image_emoticon28");
        gyG.put("#(睡觉)", "image_emoticon29");
        gyG.put("#(惊哭)", "image_emoticon30");
        gyG.put("#(升起)", "image_emoticon31");
        gyG.put("#(惊讶)", "image_emoticon32");
        gyG.put("#(喷)", "image_emoticon33");
        gyG.put("#(爱心)", "image_emoticon34");
        gyG.put("#(心碎)", "image_emoticon35");
        gyG.put("#(玫瑰)", "image_emoticon36");
        gyG.put("#(礼物)", "image_emoticon37");
        gyG.put("#(彩虹)", "image_emoticon38");
        gyG.put("#(星星月亮)", "image_emoticon39");
        gyG.put("#(太阳)", "image_emoticon40");
        gyG.put("#(钱币)", "image_emoticon41");
        gyG.put("#(灯泡)", "image_emoticon42");
        gyG.put("#(茶杯)", "image_emoticon43");
        gyG.put("#(蛋糕)", "image_emoticon44");
        gyG.put("#(音乐)", "image_emoticon45");
        gyG.put("#(haha)", "image_emoticon46");
        gyG.put("#(胜利)", "image_emoticon47");
        gyG.put("#(大拇指)", "image_emoticon48");
        gyG.put("#(弱)", "image_emoticon49");
        gyG.put("#(OK)", "image_emoticon50");
        gyG.put("#(哼)", "image_emoticon61");
        gyG.put("#(吃瓜)", "image_emoticon62");
        gyG.put("#(扔便便)", "image_emoticon63");
        gyG.put("#(惊恐)", "image_emoticon64");
        gyG.put("#(哎呦)", "image_emoticon65");
        gyG.put("#(小乖)", "image_emoticon66");
        gyG.put("#(捂嘴笑)", "image_emoticon67");
        gyG.put("#(你懂的)", "image_emoticon68");
        gyG.put("#(what)", "image_emoticon69");
        gyG.put("#(酸爽)", "image_emoticon70");
        gyG.put("#(呀咩爹)", "image_emoticon71");
        gyG.put("#(笑尿)", "image_emoticon72");
        gyG.put("#(挖鼻)", "image_emoticon73");
        gyG.put("#(犀利)", "image_emoticon74");
        gyG.put("#(小红脸)", "image_emoticon75");
        gyG.put("#(懒得理)", "image_emoticon76");
        gyG.put("#(沙发)", "image_emoticon77");
        gyG.put("#(手纸)", "image_emoticon78");
        gyG.put("#(香蕉)", "image_emoticon79");
        gyG.put("#(便便)", "image_emoticon80");
        gyG.put("#(药丸)", "image_emoticon81");
        gyG.put("#(红领巾)", "image_emoticon82");
        gyG.put("#(蜡烛)", "image_emoticon83");
        gyG.put("#(三道杠)", "image_emoticon84");
        gyG.put("#(赖皮)", "ali_001");
        gyG.put("#(感动)", "ali_002");
        gyG.put("#(十分惊讶)", "ali_003");
        gyG.put("#(怒气)", "ali_004");
        gyG.put("#(哭泣)", "ali_005");
        gyG.put("#(吃惊)", "ali_006");
        gyG.put("#(嘲弄)", "ali_007");
        gyG.put("#(飘过)", "ali_008");
        gyG.put("#(转圈哭)", "ali_009");
        gyG.put("#(神经病)", "ali_010");
        gyG.put("#(揪耳朵)", "ali_011");
        gyG.put("#(惊汗)", "ali_012");
        gyG.put("#(隐身)", "ali_013");
        gyG.put("#(不要嘛)", "ali_014");
        gyG.put("#(遁)", "ali_015");
        gyG.put("#(不公平)", "ali_016");
        gyG.put("#(爬来了)", "ali_017");
        gyG.put("#(蛋花哭)", "ali_018");
        gyG.put("#(温暖)", "ali_019");
        gyG.put("#(点头)", "ali_020");
        gyG.put("#(撒钱)", "ali_021");
        gyG.put("#(献花)", "ali_022");
        gyG.put("#(寒)", "ali_023");
        gyG.put("#(傻笑)", "ali_024");
        gyG.put("#(扭扭)", "ali_025");
        gyG.put("#(疯)", "ali_026");
        gyG.put("#(抓狂)", "ali_027");
        gyG.put("#(抓)", "ali_028");
        gyG.put("#(蜷)", "ali_029");
        gyG.put("#(挠墙)", "ali_030");
        gyG.put("#(狂笑)", "ali_031");
        gyG.put("#(抱枕)", "ali_032");
        gyG.put("#(吼叫)", "ali_033");
        gyG.put("#(嚷)", "ali_034");
        gyG.put("#(唠叨)", "ali_035");
        gyG.put("#(捏脸)", "ali_036");
        gyG.put("#(爆笑)", "ali_037");
        gyG.put("#(郁闷)", "ali_038");
        gyG.put("#(潜水)", "ali_039");
        gyG.put("#(十分开心)", "ali_040");
        gyG.put("#(冷笑话)", "ali_041");
        gyG.put("#(顶！)", "ali_042");
        gyG.put("#(潜)", "ali_043");
        gyG.put("#(画圈圈)", "ali_044");
        gyG.put("#(玩电脑)", "ali_045");
        gyG.put("#(狂吐)", "ali_046");
        gyG.put("#(哭着跑)", "ali_047");
        gyG.put("#(阿狸侠)", "ali_048");
        gyG.put("#(冷死了)", "ali_049");
        gyG.put("#(惆怅~)", "ali_050");
        gyG.put("#(摸头)", "ali_051");
        gyG.put("#(蹭)", "ali_052");
        gyG.put("#(打滚)", "ali_053");
        gyG.put("#(叩拜)", "ali_054");
        gyG.put("#(摸)", "ali_055");
        gyG.put("#(数钱)", "ali_056");
        gyG.put("#(拖走)", "ali_057");
        gyG.put("#(热)", "ali_058");
        gyG.put("#(加1)", "ali_059");
        gyG.put("#(压力)", "ali_060");
        gyG.put("#(表逼我)", "ali_061");
        gyG.put("#(人呢)", "ali_062");
        gyG.put("#(摇晃)", "ali_063");
        gyG.put("#(打地鼠)", "ali_064");
        gyG.put("#(这个屌)", "ali_065");
        gyG.put("#(恐慌)", "ali_066");
        gyG.put("#(晕乎乎)", "ali_067");
        gyG.put("#(浮云)", "ali_068");
        gyG.put("#(给力)", "ali_069");
        gyG.put("#(杯具了)", "ali_070");
        gyG.put("#(焦糖舞)", "yz_001");
        gyG.put("#(翻滚)", "yz_002");
        gyG.put("#(拍屁股做鬼脸)", "yz_003");
        gyG.put("#(不)", "yz_004");
        gyG.put("#(河蟹掉啦)", "yz_005");
        gyG.put("#(哦耶)", "yz_006");
        gyG.put("#(我倒)", "yz_007");
        gyG.put("#(投降)", "yz_008");
        gyG.put("#(微笑)", "b01");
        gyG.put("#(帅哥)", "b02");
        gyG.put("#(美女)", "b03");
        gyG.put("#(老大)", "b04");
        gyG.put("#(哈哈哈)", "b05");
        gyG.put("#(奸笑)", "b06");
        gyG.put("#(傻乐)", "b07");
        gyG.put("#(飞吻)", "b08");
        gyG.put("#(害羞)", "b09");
        gyG.put("#(花痴)", "b10");
        gyG.put("#(憧憬)", "b11");
        gyG.put("#(你牛)", "b12");
        gyG.put("#(鼓掌)", "b13");
        gyG.put("#(可爱)", "b14");
        gyG.put("#(太委屈)", "b15");
        gyG.put("#(大哭)", "b16");
        gyG.put("#(泪奔)", "b17");
        gyG.put("#(寻死)", "b18");
        gyG.put("#(非常惊讶)", "b19");
        gyG.put("#(表示疑问)", "b20");
        gyG.put("#(暗中观察)", "image_emoticon85");
        gyG.put("#(吃瓜)", "image_emoticon86");
        gyG.put("#(喝酒)", "image_emoticon87");
        gyG.put("#(嘿嘿嘿)", "image_emoticon88");
        gyG.put("#(噗)", "image_emoticon89");
        gyG.put("#(困成狗)", "image_emoticon90");
        gyG.put("#(微微一笑)", "image_emoticon91");
        gyG.put("#(托腮)", "image_emoticon92");
        gyG.put("#(摊手)", "image_emoticon93");
        gyG.put("#(柯基暗中观察)", "image_emoticon94");
        gyG.put("#(欢呼)", "image_emoticon95");
        gyG.put("#(炸药)", "image_emoticon96");
        gyG.put("#(突然兴奋)", "image_emoticon97");
        gyG.put("#(紧张)", "image_emoticon98");
        gyG.put("#(黑头瞪眼)", "image_emoticon99");
        gyG.put("#(黑头高兴)", "image_emoticon100");
        gyG.put("#(不跟丑人说话)", "image_emoticon101");
        gyG.put("#(么么哒)", "image_emoticon102");
        gyG.put("#(亲亲才能起来)", "image_emoticon103");
        gyG.put("#(伦家只是宝宝)", "image_emoticon104");
        gyG.put("#(你是我的人)", "image_emoticon105");
        gyG.put("#(假装看不见)", "image_emoticon106");
        gyG.put("#(单身等撩)", "image_emoticon107");
        gyG.put("#(吓到宝宝了)", "image_emoticon108");
        gyG.put("#(哈哈哈)", "image_emoticon109");
        gyG.put("#(嗯嗯)", "image_emoticon110");
        gyG.put("#(好幸福)", "image_emoticon111");
        gyG.put("#(宝宝不开心)", "image_emoticon112");
        gyG.put("#(小姐姐别走)", "image_emoticon113");
        gyG.put("#(小姐姐在吗)", "image_emoticon114");
        gyG.put("#(小姐姐来啦)", "image_emoticon115");
        gyG.put("#(小姐姐来玩呀)", "image_emoticon116");
        gyG.put("#(我养你)", "image_emoticon117");
        gyG.put("#(我是不会骗你的)", "image_emoticon118");
        gyG.put("#(扎心了)", "image_emoticon119");
        gyG.put("#(无聊)", "image_emoticon120");
        gyG.put("#(月亮代表我的心)", "image_emoticon121");
        gyG.put("#(来追我呀)", "image_emoticon122");
        gyG.put("#(爱你的形状)", "image_emoticon123");
        gyG.put("#(白眼)", "image_emoticon124");
    }

    private static String xm(String str) {
        return gyG.get(str);
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
                        SpannableString a = a(tbRichTextData.azo(), xm, str3);
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
        int pz = TbFaceManager.avt().pz(str);
        if (pz != 0) {
            spannableString = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), pz);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0296a pV = TbFaceManager.avt().pV(str);
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
