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
    private static final HashMap<String, String> hpB = new HashMap<>();

    static {
        hpB.put("#(呵呵)", "image_emoticon");
        hpB.put("#(哈哈)", "image_emoticon2");
        hpB.put("#(吐舌)", "image_emoticon3");
        hpB.put("#(啊)", "image_emoticon4");
        hpB.put("#(啊?)", "image_emoticon4");
        hpB.put("#(酷)", "image_emoticon5");
        hpB.put("#(怒)", "image_emoticon6");
        hpB.put("#(开心)", "image_emoticon7");
        hpB.put("#(汗)", "image_emoticon8");
        hpB.put("#(泪)", "image_emoticon9");
        hpB.put("#(黑线)", "image_emoticon10");
        hpB.put("#(鄙视)", "image_emoticon11");
        hpB.put("#(不高兴)", "image_emoticon12");
        hpB.put("#(真棒)", "image_emoticon13");
        hpB.put("#(钱)", "image_emoticon14");
        hpB.put("#(疑问)", "image_emoticon15");
        hpB.put("#(阴险)", "image_emoticon16");
        hpB.put("#(吐)", "image_emoticon17");
        hpB.put("#(咦)", "image_emoticon18");
        hpB.put("#(咦?)", "image_emoticon18");
        hpB.put("#(委屈)", "image_emoticon19");
        hpB.put("#(花心)", "image_emoticon20");
        hpB.put("#(呼~)", "image_emoticon21");
        hpB.put("#(笑眼)", "image_emoticon22");
        hpB.put("#(冷)", "image_emoticon23");
        hpB.put("#(太开心)", "image_emoticon24");
        hpB.put("#(滑稽)", "image_emoticon25");
        hpB.put("#(勉强)", "image_emoticon26");
        hpB.put("#(狂汗)", "image_emoticon27");
        hpB.put("#(乖)", "image_emoticon28");
        hpB.put("#(睡觉)", "image_emoticon29");
        hpB.put("#(惊哭)", "image_emoticon30");
        hpB.put("#(升起)", "image_emoticon31");
        hpB.put("#(惊讶)", "image_emoticon32");
        hpB.put("#(喷)", "image_emoticon33");
        hpB.put("#(爱心)", "image_emoticon34");
        hpB.put("#(心碎)", "image_emoticon35");
        hpB.put("#(玫瑰)", "image_emoticon36");
        hpB.put("#(礼物)", "image_emoticon37");
        hpB.put("#(彩虹)", "image_emoticon38");
        hpB.put("#(星星月亮)", "image_emoticon39");
        hpB.put("#(太阳)", "image_emoticon40");
        hpB.put("#(钱币)", "image_emoticon41");
        hpB.put("#(灯泡)", "image_emoticon42");
        hpB.put("#(茶杯)", "image_emoticon43");
        hpB.put("#(蛋糕)", "image_emoticon44");
        hpB.put("#(音乐)", "image_emoticon45");
        hpB.put("#(haha)", "image_emoticon46");
        hpB.put("#(胜利)", "image_emoticon47");
        hpB.put("#(大拇指)", "image_emoticon48");
        hpB.put("#(弱)", "image_emoticon49");
        hpB.put("#(OK)", "image_emoticon50");
        hpB.put("#(哼)", "image_emoticon61");
        hpB.put("#(吃瓜)", "image_emoticon62");
        hpB.put("#(扔便便)", "image_emoticon63");
        hpB.put("#(惊恐)", "image_emoticon64");
        hpB.put("#(哎呦)", "image_emoticon65");
        hpB.put("#(小乖)", "image_emoticon66");
        hpB.put("#(捂嘴笑)", "image_emoticon67");
        hpB.put("#(你懂的)", "image_emoticon68");
        hpB.put("#(what)", "image_emoticon69");
        hpB.put("#(酸爽)", "image_emoticon70");
        hpB.put("#(呀咩爹)", "image_emoticon71");
        hpB.put("#(笑尿)", "image_emoticon72");
        hpB.put("#(挖鼻)", "image_emoticon73");
        hpB.put("#(犀利)", "image_emoticon74");
        hpB.put("#(小红脸)", "image_emoticon75");
        hpB.put("#(懒得理)", "image_emoticon76");
        hpB.put("#(沙发)", "image_emoticon77");
        hpB.put("#(手纸)", "image_emoticon78");
        hpB.put("#(香蕉)", "image_emoticon79");
        hpB.put("#(便便)", "image_emoticon80");
        hpB.put("#(药丸)", "image_emoticon81");
        hpB.put("#(红领巾)", "image_emoticon82");
        hpB.put("#(蜡烛)", "image_emoticon83");
        hpB.put("#(三道杠)", "image_emoticon84");
        hpB.put("#(赖皮)", "ali_001");
        hpB.put("#(感动)", "ali_002");
        hpB.put("#(十分惊讶)", "ali_003");
        hpB.put("#(怒气)", "ali_004");
        hpB.put("#(哭泣)", "ali_005");
        hpB.put("#(吃惊)", "ali_006");
        hpB.put("#(嘲弄)", "ali_007");
        hpB.put("#(飘过)", "ali_008");
        hpB.put("#(转圈哭)", "ali_009");
        hpB.put("#(神经病)", "ali_010");
        hpB.put("#(揪耳朵)", "ali_011");
        hpB.put("#(惊汗)", "ali_012");
        hpB.put("#(隐身)", "ali_013");
        hpB.put("#(不要嘛)", "ali_014");
        hpB.put("#(遁)", "ali_015");
        hpB.put("#(不公平)", "ali_016");
        hpB.put("#(爬来了)", "ali_017");
        hpB.put("#(蛋花哭)", "ali_018");
        hpB.put("#(温暖)", "ali_019");
        hpB.put("#(点头)", "ali_020");
        hpB.put("#(撒钱)", "ali_021");
        hpB.put("#(献花)", "ali_022");
        hpB.put("#(寒)", "ali_023");
        hpB.put("#(傻笑)", "ali_024");
        hpB.put("#(扭扭)", "ali_025");
        hpB.put("#(疯)", "ali_026");
        hpB.put("#(抓狂)", "ali_027");
        hpB.put("#(抓)", "ali_028");
        hpB.put("#(蜷)", "ali_029");
        hpB.put("#(挠墙)", "ali_030");
        hpB.put("#(狂笑)", "ali_031");
        hpB.put("#(抱枕)", "ali_032");
        hpB.put("#(吼叫)", "ali_033");
        hpB.put("#(嚷)", "ali_034");
        hpB.put("#(唠叨)", "ali_035");
        hpB.put("#(捏脸)", "ali_036");
        hpB.put("#(爆笑)", "ali_037");
        hpB.put("#(郁闷)", "ali_038");
        hpB.put("#(潜水)", "ali_039");
        hpB.put("#(十分开心)", "ali_040");
        hpB.put("#(冷笑话)", "ali_041");
        hpB.put("#(顶！)", "ali_042");
        hpB.put("#(潜)", "ali_043");
        hpB.put("#(画圈圈)", "ali_044");
        hpB.put("#(玩电脑)", "ali_045");
        hpB.put("#(狂吐)", "ali_046");
        hpB.put("#(哭着跑)", "ali_047");
        hpB.put("#(阿狸侠)", "ali_048");
        hpB.put("#(冷死了)", "ali_049");
        hpB.put("#(惆怅~)", "ali_050");
        hpB.put("#(摸头)", "ali_051");
        hpB.put("#(蹭)", "ali_052");
        hpB.put("#(打滚)", "ali_053");
        hpB.put("#(叩拜)", "ali_054");
        hpB.put("#(摸)", "ali_055");
        hpB.put("#(数钱)", "ali_056");
        hpB.put("#(拖走)", "ali_057");
        hpB.put("#(热)", "ali_058");
        hpB.put("#(加1)", "ali_059");
        hpB.put("#(压力)", "ali_060");
        hpB.put("#(表逼我)", "ali_061");
        hpB.put("#(人呢)", "ali_062");
        hpB.put("#(摇晃)", "ali_063");
        hpB.put("#(打地鼠)", "ali_064");
        hpB.put("#(这个屌)", "ali_065");
        hpB.put("#(恐慌)", "ali_066");
        hpB.put("#(晕乎乎)", "ali_067");
        hpB.put("#(浮云)", "ali_068");
        hpB.put("#(给力)", "ali_069");
        hpB.put("#(杯具了)", "ali_070");
        hpB.put("#(焦糖舞)", "yz_001");
        hpB.put("#(翻滚)", "yz_002");
        hpB.put("#(拍屁股做鬼脸)", "yz_003");
        hpB.put("#(不)", "yz_004");
        hpB.put("#(河蟹掉啦)", "yz_005");
        hpB.put("#(哦耶)", "yz_006");
        hpB.put("#(我倒)", "yz_007");
        hpB.put("#(投降)", "yz_008");
        hpB.put("#(微笑)", "b01");
        hpB.put("#(帅哥)", "b02");
        hpB.put("#(美女)", "b03");
        hpB.put("#(老大)", "b04");
        hpB.put("#(哈哈哈)", "b05");
        hpB.put("#(奸笑)", "b06");
        hpB.put("#(傻乐)", "b07");
        hpB.put("#(飞吻)", "b08");
        hpB.put("#(害羞)", "b09");
        hpB.put("#(花痴)", "b10");
        hpB.put("#(憧憬)", "b11");
        hpB.put("#(你牛)", "b12");
        hpB.put("#(鼓掌)", "b13");
        hpB.put("#(可爱)", "b14");
        hpB.put("#(太委屈)", "b15");
        hpB.put("#(大哭)", "b16");
        hpB.put("#(泪奔)", "b17");
        hpB.put("#(寻死)", "b18");
        hpB.put("#(非常惊讶)", "b19");
        hpB.put("#(表示疑问)", "b20");
        hpB.put("#(暗中观察)", "image_emoticon85");
        hpB.put("#(吃瓜)", "image_emoticon86");
        hpB.put("#(喝酒)", "image_emoticon87");
        hpB.put("#(嘿嘿嘿)", "image_emoticon88");
        hpB.put("#(噗)", "image_emoticon89");
        hpB.put("#(困成狗)", "image_emoticon90");
        hpB.put("#(微微一笑)", "image_emoticon91");
        hpB.put("#(托腮)", "image_emoticon92");
        hpB.put("#(摊手)", "image_emoticon93");
        hpB.put("#(柯基暗中观察)", "image_emoticon94");
        hpB.put("#(欢呼)", "image_emoticon95");
        hpB.put("#(炸药)", "image_emoticon96");
        hpB.put("#(突然兴奋)", "image_emoticon97");
        hpB.put("#(紧张)", "image_emoticon98");
        hpB.put("#(黑头瞪眼)", "image_emoticon99");
        hpB.put("#(黑头高兴)", "image_emoticon100");
        hpB.put("#(不跟丑人说话)", "image_emoticon101");
        hpB.put("#(么么哒)", "image_emoticon102");
        hpB.put("#(亲亲才能起来)", "image_emoticon103");
        hpB.put("#(伦家只是宝宝)", "image_emoticon104");
        hpB.put("#(你是我的人)", "image_emoticon105");
        hpB.put("#(假装看不见)", "image_emoticon106");
        hpB.put("#(单身等撩)", "image_emoticon107");
        hpB.put("#(吓到宝宝了)", "image_emoticon108");
        hpB.put("#(哈哈哈)", "image_emoticon109");
        hpB.put("#(嗯嗯)", "image_emoticon110");
        hpB.put("#(好幸福)", "image_emoticon111");
        hpB.put("#(宝宝不开心)", "image_emoticon112");
        hpB.put("#(小姐姐别走)", "image_emoticon113");
        hpB.put("#(小姐姐在吗)", "image_emoticon114");
        hpB.put("#(小姐姐来啦)", "image_emoticon115");
        hpB.put("#(小姐姐来玩呀)", "image_emoticon116");
        hpB.put("#(我养你)", "image_emoticon117");
        hpB.put("#(我是不会骗你的)", "image_emoticon118");
        hpB.put("#(扎心了)", "image_emoticon119");
        hpB.put("#(无聊)", "image_emoticon120");
        hpB.put("#(月亮代表我的心)", "image_emoticon121");
        hpB.put("#(来追我呀)", "image_emoticon122");
        hpB.put("#(爱你的形状)", "image_emoticon123");
        hpB.put("#(白眼)", "image_emoticon124");
    }

    private static String Cf(String str) {
        return hpB.get(str);
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
                    String Cf = Cf(str3);
                    if (TextUtils.isEmpty(Cf)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.j(str5);
                            } else {
                                SpannableString aV = aV(context, str5);
                                if (aV != null) {
                                    tbRichTextData.j(aV);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.aRE(), Cf, str3);
                        if (a != null) {
                            tbRichTextData.j(a);
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
                    tbRichTextData.j(str5);
                } else {
                    SpannableString aV2 = aV(context, str5);
                    if (aV2 != null) {
                        tbRichTextData.j(aV2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int uK = TbFaceManager.aNr().uK(str);
        if (uK != 0) {
            spannableString = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), uK);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0381a vd = TbFaceManager.aNr().vd(str);
            if (vd != null) {
                int width = (int) (0.5d * vd.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aV(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ba.az(context, str);
    }
}
