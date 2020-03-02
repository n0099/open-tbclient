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
    private static final HashMap<String, String> hrC = new HashMap<>();

    static {
        hrC.put("#(呵呵)", "image_emoticon");
        hrC.put("#(哈哈)", "image_emoticon2");
        hrC.put("#(吐舌)", "image_emoticon3");
        hrC.put("#(啊)", "image_emoticon4");
        hrC.put("#(啊?)", "image_emoticon4");
        hrC.put("#(酷)", "image_emoticon5");
        hrC.put("#(怒)", "image_emoticon6");
        hrC.put("#(开心)", "image_emoticon7");
        hrC.put("#(汗)", "image_emoticon8");
        hrC.put("#(泪)", "image_emoticon9");
        hrC.put("#(黑线)", "image_emoticon10");
        hrC.put("#(鄙视)", "image_emoticon11");
        hrC.put("#(不高兴)", "image_emoticon12");
        hrC.put("#(真棒)", "image_emoticon13");
        hrC.put("#(钱)", "image_emoticon14");
        hrC.put("#(疑问)", "image_emoticon15");
        hrC.put("#(阴险)", "image_emoticon16");
        hrC.put("#(吐)", "image_emoticon17");
        hrC.put("#(咦)", "image_emoticon18");
        hrC.put("#(咦?)", "image_emoticon18");
        hrC.put("#(委屈)", "image_emoticon19");
        hrC.put("#(花心)", "image_emoticon20");
        hrC.put("#(呼~)", "image_emoticon21");
        hrC.put("#(笑眼)", "image_emoticon22");
        hrC.put("#(冷)", "image_emoticon23");
        hrC.put("#(太开心)", "image_emoticon24");
        hrC.put("#(滑稽)", "image_emoticon25");
        hrC.put("#(勉强)", "image_emoticon26");
        hrC.put("#(狂汗)", "image_emoticon27");
        hrC.put("#(乖)", "image_emoticon28");
        hrC.put("#(睡觉)", "image_emoticon29");
        hrC.put("#(惊哭)", "image_emoticon30");
        hrC.put("#(升起)", "image_emoticon31");
        hrC.put("#(惊讶)", "image_emoticon32");
        hrC.put("#(喷)", "image_emoticon33");
        hrC.put("#(爱心)", "image_emoticon34");
        hrC.put("#(心碎)", "image_emoticon35");
        hrC.put("#(玫瑰)", "image_emoticon36");
        hrC.put("#(礼物)", "image_emoticon37");
        hrC.put("#(彩虹)", "image_emoticon38");
        hrC.put("#(星星月亮)", "image_emoticon39");
        hrC.put("#(太阳)", "image_emoticon40");
        hrC.put("#(钱币)", "image_emoticon41");
        hrC.put("#(灯泡)", "image_emoticon42");
        hrC.put("#(茶杯)", "image_emoticon43");
        hrC.put("#(蛋糕)", "image_emoticon44");
        hrC.put("#(音乐)", "image_emoticon45");
        hrC.put("#(haha)", "image_emoticon46");
        hrC.put("#(胜利)", "image_emoticon47");
        hrC.put("#(大拇指)", "image_emoticon48");
        hrC.put("#(弱)", "image_emoticon49");
        hrC.put("#(OK)", "image_emoticon50");
        hrC.put("#(哼)", "image_emoticon61");
        hrC.put("#(吃瓜)", "image_emoticon62");
        hrC.put("#(扔便便)", "image_emoticon63");
        hrC.put("#(惊恐)", "image_emoticon64");
        hrC.put("#(哎呦)", "image_emoticon65");
        hrC.put("#(小乖)", "image_emoticon66");
        hrC.put("#(捂嘴笑)", "image_emoticon67");
        hrC.put("#(你懂的)", "image_emoticon68");
        hrC.put("#(what)", "image_emoticon69");
        hrC.put("#(酸爽)", "image_emoticon70");
        hrC.put("#(呀咩爹)", "image_emoticon71");
        hrC.put("#(笑尿)", "image_emoticon72");
        hrC.put("#(挖鼻)", "image_emoticon73");
        hrC.put("#(犀利)", "image_emoticon74");
        hrC.put("#(小红脸)", "image_emoticon75");
        hrC.put("#(懒得理)", "image_emoticon76");
        hrC.put("#(沙发)", "image_emoticon77");
        hrC.put("#(手纸)", "image_emoticon78");
        hrC.put("#(香蕉)", "image_emoticon79");
        hrC.put("#(便便)", "image_emoticon80");
        hrC.put("#(药丸)", "image_emoticon81");
        hrC.put("#(红领巾)", "image_emoticon82");
        hrC.put("#(蜡烛)", "image_emoticon83");
        hrC.put("#(三道杠)", "image_emoticon84");
        hrC.put("#(赖皮)", "ali_001");
        hrC.put("#(感动)", "ali_002");
        hrC.put("#(十分惊讶)", "ali_003");
        hrC.put("#(怒气)", "ali_004");
        hrC.put("#(哭泣)", "ali_005");
        hrC.put("#(吃惊)", "ali_006");
        hrC.put("#(嘲弄)", "ali_007");
        hrC.put("#(飘过)", "ali_008");
        hrC.put("#(转圈哭)", "ali_009");
        hrC.put("#(神经病)", "ali_010");
        hrC.put("#(揪耳朵)", "ali_011");
        hrC.put("#(惊汗)", "ali_012");
        hrC.put("#(隐身)", "ali_013");
        hrC.put("#(不要嘛)", "ali_014");
        hrC.put("#(遁)", "ali_015");
        hrC.put("#(不公平)", "ali_016");
        hrC.put("#(爬来了)", "ali_017");
        hrC.put("#(蛋花哭)", "ali_018");
        hrC.put("#(温暖)", "ali_019");
        hrC.put("#(点头)", "ali_020");
        hrC.put("#(撒钱)", "ali_021");
        hrC.put("#(献花)", "ali_022");
        hrC.put("#(寒)", "ali_023");
        hrC.put("#(傻笑)", "ali_024");
        hrC.put("#(扭扭)", "ali_025");
        hrC.put("#(疯)", "ali_026");
        hrC.put("#(抓狂)", "ali_027");
        hrC.put("#(抓)", "ali_028");
        hrC.put("#(蜷)", "ali_029");
        hrC.put("#(挠墙)", "ali_030");
        hrC.put("#(狂笑)", "ali_031");
        hrC.put("#(抱枕)", "ali_032");
        hrC.put("#(吼叫)", "ali_033");
        hrC.put("#(嚷)", "ali_034");
        hrC.put("#(唠叨)", "ali_035");
        hrC.put("#(捏脸)", "ali_036");
        hrC.put("#(爆笑)", "ali_037");
        hrC.put("#(郁闷)", "ali_038");
        hrC.put("#(潜水)", "ali_039");
        hrC.put("#(十分开心)", "ali_040");
        hrC.put("#(冷笑话)", "ali_041");
        hrC.put("#(顶！)", "ali_042");
        hrC.put("#(潜)", "ali_043");
        hrC.put("#(画圈圈)", "ali_044");
        hrC.put("#(玩电脑)", "ali_045");
        hrC.put("#(狂吐)", "ali_046");
        hrC.put("#(哭着跑)", "ali_047");
        hrC.put("#(阿狸侠)", "ali_048");
        hrC.put("#(冷死了)", "ali_049");
        hrC.put("#(惆怅~)", "ali_050");
        hrC.put("#(摸头)", "ali_051");
        hrC.put("#(蹭)", "ali_052");
        hrC.put("#(打滚)", "ali_053");
        hrC.put("#(叩拜)", "ali_054");
        hrC.put("#(摸)", "ali_055");
        hrC.put("#(数钱)", "ali_056");
        hrC.put("#(拖走)", "ali_057");
        hrC.put("#(热)", "ali_058");
        hrC.put("#(加1)", "ali_059");
        hrC.put("#(压力)", "ali_060");
        hrC.put("#(表逼我)", "ali_061");
        hrC.put("#(人呢)", "ali_062");
        hrC.put("#(摇晃)", "ali_063");
        hrC.put("#(打地鼠)", "ali_064");
        hrC.put("#(这个屌)", "ali_065");
        hrC.put("#(恐慌)", "ali_066");
        hrC.put("#(晕乎乎)", "ali_067");
        hrC.put("#(浮云)", "ali_068");
        hrC.put("#(给力)", "ali_069");
        hrC.put("#(杯具了)", "ali_070");
        hrC.put("#(焦糖舞)", "yz_001");
        hrC.put("#(翻滚)", "yz_002");
        hrC.put("#(拍屁股做鬼脸)", "yz_003");
        hrC.put("#(不)", "yz_004");
        hrC.put("#(河蟹掉啦)", "yz_005");
        hrC.put("#(哦耶)", "yz_006");
        hrC.put("#(我倒)", "yz_007");
        hrC.put("#(投降)", "yz_008");
        hrC.put("#(微笑)", "b01");
        hrC.put("#(帅哥)", "b02");
        hrC.put("#(美女)", "b03");
        hrC.put("#(老大)", "b04");
        hrC.put("#(哈哈哈)", "b05");
        hrC.put("#(奸笑)", "b06");
        hrC.put("#(傻乐)", "b07");
        hrC.put("#(飞吻)", "b08");
        hrC.put("#(害羞)", "b09");
        hrC.put("#(花痴)", "b10");
        hrC.put("#(憧憬)", "b11");
        hrC.put("#(你牛)", "b12");
        hrC.put("#(鼓掌)", "b13");
        hrC.put("#(可爱)", "b14");
        hrC.put("#(太委屈)", "b15");
        hrC.put("#(大哭)", "b16");
        hrC.put("#(泪奔)", "b17");
        hrC.put("#(寻死)", "b18");
        hrC.put("#(非常惊讶)", "b19");
        hrC.put("#(表示疑问)", "b20");
        hrC.put("#(暗中观察)", "image_emoticon85");
        hrC.put("#(吃瓜)", "image_emoticon86");
        hrC.put("#(喝酒)", "image_emoticon87");
        hrC.put("#(嘿嘿嘿)", "image_emoticon88");
        hrC.put("#(噗)", "image_emoticon89");
        hrC.put("#(困成狗)", "image_emoticon90");
        hrC.put("#(微微一笑)", "image_emoticon91");
        hrC.put("#(托腮)", "image_emoticon92");
        hrC.put("#(摊手)", "image_emoticon93");
        hrC.put("#(柯基暗中观察)", "image_emoticon94");
        hrC.put("#(欢呼)", "image_emoticon95");
        hrC.put("#(炸药)", "image_emoticon96");
        hrC.put("#(突然兴奋)", "image_emoticon97");
        hrC.put("#(紧张)", "image_emoticon98");
        hrC.put("#(黑头瞪眼)", "image_emoticon99");
        hrC.put("#(黑头高兴)", "image_emoticon100");
        hrC.put("#(不跟丑人说话)", "image_emoticon101");
        hrC.put("#(么么哒)", "image_emoticon102");
        hrC.put("#(亲亲才能起来)", "image_emoticon103");
        hrC.put("#(伦家只是宝宝)", "image_emoticon104");
        hrC.put("#(你是我的人)", "image_emoticon105");
        hrC.put("#(假装看不见)", "image_emoticon106");
        hrC.put("#(单身等撩)", "image_emoticon107");
        hrC.put("#(吓到宝宝了)", "image_emoticon108");
        hrC.put("#(哈哈哈)", "image_emoticon109");
        hrC.put("#(嗯嗯)", "image_emoticon110");
        hrC.put("#(好幸福)", "image_emoticon111");
        hrC.put("#(宝宝不开心)", "image_emoticon112");
        hrC.put("#(小姐姐别走)", "image_emoticon113");
        hrC.put("#(小姐姐在吗)", "image_emoticon114");
        hrC.put("#(小姐姐来啦)", "image_emoticon115");
        hrC.put("#(小姐姐来玩呀)", "image_emoticon116");
        hrC.put("#(我养你)", "image_emoticon117");
        hrC.put("#(我是不会骗你的)", "image_emoticon118");
        hrC.put("#(扎心了)", "image_emoticon119");
        hrC.put("#(无聊)", "image_emoticon120");
        hrC.put("#(月亮代表我的心)", "image_emoticon121");
        hrC.put("#(来追我呀)", "image_emoticon122");
        hrC.put("#(爱你的形状)", "image_emoticon123");
        hrC.put("#(白眼)", "image_emoticon124");
    }

    private static String Cv(String str) {
        return hrC.get(str);
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
                    String Cv = Cv(str3);
                    if (TextUtils.isEmpty(Cv)) {
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
                        SpannableString a = a(tbRichTextData.aTX(), Cv, str3);
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
        int vb = TbFaceManager.aPP().vb(str);
        if (vb != 0) {
            spannableString = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), vb);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0391a vu = TbFaceManager.aPP().vu(str);
            if (vu != null) {
                int width = (int) (0.5d * vu.getWidth());
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
