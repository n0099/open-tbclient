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
    private static final HashMap<String, String> hlY = new HashMap<>();

    static {
        hlY.put("#(呵呵)", "image_emoticon");
        hlY.put("#(哈哈)", "image_emoticon2");
        hlY.put("#(吐舌)", "image_emoticon3");
        hlY.put("#(啊)", "image_emoticon4");
        hlY.put("#(啊?)", "image_emoticon4");
        hlY.put("#(酷)", "image_emoticon5");
        hlY.put("#(怒)", "image_emoticon6");
        hlY.put("#(开心)", "image_emoticon7");
        hlY.put("#(汗)", "image_emoticon8");
        hlY.put("#(泪)", "image_emoticon9");
        hlY.put("#(黑线)", "image_emoticon10");
        hlY.put("#(鄙视)", "image_emoticon11");
        hlY.put("#(不高兴)", "image_emoticon12");
        hlY.put("#(真棒)", "image_emoticon13");
        hlY.put("#(钱)", "image_emoticon14");
        hlY.put("#(疑问)", "image_emoticon15");
        hlY.put("#(阴险)", "image_emoticon16");
        hlY.put("#(吐)", "image_emoticon17");
        hlY.put("#(咦)", "image_emoticon18");
        hlY.put("#(咦?)", "image_emoticon18");
        hlY.put("#(委屈)", "image_emoticon19");
        hlY.put("#(花心)", "image_emoticon20");
        hlY.put("#(呼~)", "image_emoticon21");
        hlY.put("#(笑眼)", "image_emoticon22");
        hlY.put("#(冷)", "image_emoticon23");
        hlY.put("#(太开心)", "image_emoticon24");
        hlY.put("#(滑稽)", "image_emoticon25");
        hlY.put("#(勉强)", "image_emoticon26");
        hlY.put("#(狂汗)", "image_emoticon27");
        hlY.put("#(乖)", "image_emoticon28");
        hlY.put("#(睡觉)", "image_emoticon29");
        hlY.put("#(惊哭)", "image_emoticon30");
        hlY.put("#(升起)", "image_emoticon31");
        hlY.put("#(惊讶)", "image_emoticon32");
        hlY.put("#(喷)", "image_emoticon33");
        hlY.put("#(爱心)", "image_emoticon34");
        hlY.put("#(心碎)", "image_emoticon35");
        hlY.put("#(玫瑰)", "image_emoticon36");
        hlY.put("#(礼物)", "image_emoticon37");
        hlY.put("#(彩虹)", "image_emoticon38");
        hlY.put("#(星星月亮)", "image_emoticon39");
        hlY.put("#(太阳)", "image_emoticon40");
        hlY.put("#(钱币)", "image_emoticon41");
        hlY.put("#(灯泡)", "image_emoticon42");
        hlY.put("#(茶杯)", "image_emoticon43");
        hlY.put("#(蛋糕)", "image_emoticon44");
        hlY.put("#(音乐)", "image_emoticon45");
        hlY.put("#(haha)", "image_emoticon46");
        hlY.put("#(胜利)", "image_emoticon47");
        hlY.put("#(大拇指)", "image_emoticon48");
        hlY.put("#(弱)", "image_emoticon49");
        hlY.put("#(OK)", "image_emoticon50");
        hlY.put("#(哼)", "image_emoticon61");
        hlY.put("#(吃瓜)", "image_emoticon62");
        hlY.put("#(扔便便)", "image_emoticon63");
        hlY.put("#(惊恐)", "image_emoticon64");
        hlY.put("#(哎呦)", "image_emoticon65");
        hlY.put("#(小乖)", "image_emoticon66");
        hlY.put("#(捂嘴笑)", "image_emoticon67");
        hlY.put("#(你懂的)", "image_emoticon68");
        hlY.put("#(what)", "image_emoticon69");
        hlY.put("#(酸爽)", "image_emoticon70");
        hlY.put("#(呀咩爹)", "image_emoticon71");
        hlY.put("#(笑尿)", "image_emoticon72");
        hlY.put("#(挖鼻)", "image_emoticon73");
        hlY.put("#(犀利)", "image_emoticon74");
        hlY.put("#(小红脸)", "image_emoticon75");
        hlY.put("#(懒得理)", "image_emoticon76");
        hlY.put("#(沙发)", "image_emoticon77");
        hlY.put("#(手纸)", "image_emoticon78");
        hlY.put("#(香蕉)", "image_emoticon79");
        hlY.put("#(便便)", "image_emoticon80");
        hlY.put("#(药丸)", "image_emoticon81");
        hlY.put("#(红领巾)", "image_emoticon82");
        hlY.put("#(蜡烛)", "image_emoticon83");
        hlY.put("#(三道杠)", "image_emoticon84");
        hlY.put("#(赖皮)", "ali_001");
        hlY.put("#(感动)", "ali_002");
        hlY.put("#(十分惊讶)", "ali_003");
        hlY.put("#(怒气)", "ali_004");
        hlY.put("#(哭泣)", "ali_005");
        hlY.put("#(吃惊)", "ali_006");
        hlY.put("#(嘲弄)", "ali_007");
        hlY.put("#(飘过)", "ali_008");
        hlY.put("#(转圈哭)", "ali_009");
        hlY.put("#(神经病)", "ali_010");
        hlY.put("#(揪耳朵)", "ali_011");
        hlY.put("#(惊汗)", "ali_012");
        hlY.put("#(隐身)", "ali_013");
        hlY.put("#(不要嘛)", "ali_014");
        hlY.put("#(遁)", "ali_015");
        hlY.put("#(不公平)", "ali_016");
        hlY.put("#(爬来了)", "ali_017");
        hlY.put("#(蛋花哭)", "ali_018");
        hlY.put("#(温暖)", "ali_019");
        hlY.put("#(点头)", "ali_020");
        hlY.put("#(撒钱)", "ali_021");
        hlY.put("#(献花)", "ali_022");
        hlY.put("#(寒)", "ali_023");
        hlY.put("#(傻笑)", "ali_024");
        hlY.put("#(扭扭)", "ali_025");
        hlY.put("#(疯)", "ali_026");
        hlY.put("#(抓狂)", "ali_027");
        hlY.put("#(抓)", "ali_028");
        hlY.put("#(蜷)", "ali_029");
        hlY.put("#(挠墙)", "ali_030");
        hlY.put("#(狂笑)", "ali_031");
        hlY.put("#(抱枕)", "ali_032");
        hlY.put("#(吼叫)", "ali_033");
        hlY.put("#(嚷)", "ali_034");
        hlY.put("#(唠叨)", "ali_035");
        hlY.put("#(捏脸)", "ali_036");
        hlY.put("#(爆笑)", "ali_037");
        hlY.put("#(郁闷)", "ali_038");
        hlY.put("#(潜水)", "ali_039");
        hlY.put("#(十分开心)", "ali_040");
        hlY.put("#(冷笑话)", "ali_041");
        hlY.put("#(顶！)", "ali_042");
        hlY.put("#(潜)", "ali_043");
        hlY.put("#(画圈圈)", "ali_044");
        hlY.put("#(玩电脑)", "ali_045");
        hlY.put("#(狂吐)", "ali_046");
        hlY.put("#(哭着跑)", "ali_047");
        hlY.put("#(阿狸侠)", "ali_048");
        hlY.put("#(冷死了)", "ali_049");
        hlY.put("#(惆怅~)", "ali_050");
        hlY.put("#(摸头)", "ali_051");
        hlY.put("#(蹭)", "ali_052");
        hlY.put("#(打滚)", "ali_053");
        hlY.put("#(叩拜)", "ali_054");
        hlY.put("#(摸)", "ali_055");
        hlY.put("#(数钱)", "ali_056");
        hlY.put("#(拖走)", "ali_057");
        hlY.put("#(热)", "ali_058");
        hlY.put("#(加1)", "ali_059");
        hlY.put("#(压力)", "ali_060");
        hlY.put("#(表逼我)", "ali_061");
        hlY.put("#(人呢)", "ali_062");
        hlY.put("#(摇晃)", "ali_063");
        hlY.put("#(打地鼠)", "ali_064");
        hlY.put("#(这个屌)", "ali_065");
        hlY.put("#(恐慌)", "ali_066");
        hlY.put("#(晕乎乎)", "ali_067");
        hlY.put("#(浮云)", "ali_068");
        hlY.put("#(给力)", "ali_069");
        hlY.put("#(杯具了)", "ali_070");
        hlY.put("#(焦糖舞)", "yz_001");
        hlY.put("#(翻滚)", "yz_002");
        hlY.put("#(拍屁股做鬼脸)", "yz_003");
        hlY.put("#(不)", "yz_004");
        hlY.put("#(河蟹掉啦)", "yz_005");
        hlY.put("#(哦耶)", "yz_006");
        hlY.put("#(我倒)", "yz_007");
        hlY.put("#(投降)", "yz_008");
        hlY.put("#(微笑)", "b01");
        hlY.put("#(帅哥)", "b02");
        hlY.put("#(美女)", "b03");
        hlY.put("#(老大)", "b04");
        hlY.put("#(哈哈哈)", "b05");
        hlY.put("#(奸笑)", "b06");
        hlY.put("#(傻乐)", "b07");
        hlY.put("#(飞吻)", "b08");
        hlY.put("#(害羞)", "b09");
        hlY.put("#(花痴)", "b10");
        hlY.put("#(憧憬)", "b11");
        hlY.put("#(你牛)", "b12");
        hlY.put("#(鼓掌)", "b13");
        hlY.put("#(可爱)", "b14");
        hlY.put("#(太委屈)", "b15");
        hlY.put("#(大哭)", "b16");
        hlY.put("#(泪奔)", "b17");
        hlY.put("#(寻死)", "b18");
        hlY.put("#(非常惊讶)", "b19");
        hlY.put("#(表示疑问)", "b20");
        hlY.put("#(暗中观察)", "image_emoticon85");
        hlY.put("#(吃瓜)", "image_emoticon86");
        hlY.put("#(喝酒)", "image_emoticon87");
        hlY.put("#(嘿嘿嘿)", "image_emoticon88");
        hlY.put("#(噗)", "image_emoticon89");
        hlY.put("#(困成狗)", "image_emoticon90");
        hlY.put("#(微微一笑)", "image_emoticon91");
        hlY.put("#(托腮)", "image_emoticon92");
        hlY.put("#(摊手)", "image_emoticon93");
        hlY.put("#(柯基暗中观察)", "image_emoticon94");
        hlY.put("#(欢呼)", "image_emoticon95");
        hlY.put("#(炸药)", "image_emoticon96");
        hlY.put("#(突然兴奋)", "image_emoticon97");
        hlY.put("#(紧张)", "image_emoticon98");
        hlY.put("#(黑头瞪眼)", "image_emoticon99");
        hlY.put("#(黑头高兴)", "image_emoticon100");
        hlY.put("#(不跟丑人说话)", "image_emoticon101");
        hlY.put("#(么么哒)", "image_emoticon102");
        hlY.put("#(亲亲才能起来)", "image_emoticon103");
        hlY.put("#(伦家只是宝宝)", "image_emoticon104");
        hlY.put("#(你是我的人)", "image_emoticon105");
        hlY.put("#(假装看不见)", "image_emoticon106");
        hlY.put("#(单身等撩)", "image_emoticon107");
        hlY.put("#(吓到宝宝了)", "image_emoticon108");
        hlY.put("#(哈哈哈)", "image_emoticon109");
        hlY.put("#(嗯嗯)", "image_emoticon110");
        hlY.put("#(好幸福)", "image_emoticon111");
        hlY.put("#(宝宝不开心)", "image_emoticon112");
        hlY.put("#(小姐姐别走)", "image_emoticon113");
        hlY.put("#(小姐姐在吗)", "image_emoticon114");
        hlY.put("#(小姐姐来啦)", "image_emoticon115");
        hlY.put("#(小姐姐来玩呀)", "image_emoticon116");
        hlY.put("#(我养你)", "image_emoticon117");
        hlY.put("#(我是不会骗你的)", "image_emoticon118");
        hlY.put("#(扎心了)", "image_emoticon119");
        hlY.put("#(无聊)", "image_emoticon120");
        hlY.put("#(月亮代表我的心)", "image_emoticon121");
        hlY.put("#(来追我呀)", "image_emoticon122");
        hlY.put("#(爱你的形状)", "image_emoticon123");
        hlY.put("#(白眼)", "image_emoticon124");
    }

    private static String BV(String str) {
        return hlY.get(str);
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
                    String BV = BV(str3);
                    if (TextUtils.isEmpty(BV)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.j(str5);
                            } else {
                                SpannableString aU = aU(context, str5);
                                if (aU != null) {
                                    tbRichTextData.j(aU);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.aRk(), BV, str3);
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
                    SpannableString aU2 = aU(context, str5);
                    if (aU2 != null) {
                        tbRichTextData.j(aU2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int uF = TbFaceManager.aMY().uF(str);
        if (uF != 0) {
            spannableString = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), uF);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0379a uY = TbFaceManager.aMY().uY(str);
            if (uY != null) {
                int width = (int) (0.5d * uY.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aU(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ba.ay(context, str);
    }
}
