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
    private static final HashMap<String, String> hto = new HashMap<>();

    static {
        hto.put("#(呵呵)", "image_emoticon");
        hto.put("#(哈哈)", "image_emoticon2");
        hto.put("#(吐舌)", "image_emoticon3");
        hto.put("#(啊)", "image_emoticon4");
        hto.put("#(啊?)", "image_emoticon4");
        hto.put("#(酷)", "image_emoticon5");
        hto.put("#(怒)", "image_emoticon6");
        hto.put("#(开心)", "image_emoticon7");
        hto.put("#(汗)", "image_emoticon8");
        hto.put("#(泪)", "image_emoticon9");
        hto.put("#(黑线)", "image_emoticon10");
        hto.put("#(鄙视)", "image_emoticon11");
        hto.put("#(不高兴)", "image_emoticon12");
        hto.put("#(真棒)", "image_emoticon13");
        hto.put("#(钱)", "image_emoticon14");
        hto.put("#(疑问)", "image_emoticon15");
        hto.put("#(阴险)", "image_emoticon16");
        hto.put("#(吐)", "image_emoticon17");
        hto.put("#(咦)", "image_emoticon18");
        hto.put("#(咦?)", "image_emoticon18");
        hto.put("#(委屈)", "image_emoticon19");
        hto.put("#(花心)", "image_emoticon20");
        hto.put("#(呼~)", "image_emoticon21");
        hto.put("#(笑眼)", "image_emoticon22");
        hto.put("#(冷)", "image_emoticon23");
        hto.put("#(太开心)", "image_emoticon24");
        hto.put("#(滑稽)", "image_emoticon25");
        hto.put("#(勉强)", "image_emoticon26");
        hto.put("#(狂汗)", "image_emoticon27");
        hto.put("#(乖)", "image_emoticon28");
        hto.put("#(睡觉)", "image_emoticon29");
        hto.put("#(惊哭)", "image_emoticon30");
        hto.put("#(升起)", "image_emoticon31");
        hto.put("#(惊讶)", "image_emoticon32");
        hto.put("#(喷)", "image_emoticon33");
        hto.put("#(爱心)", "image_emoticon34");
        hto.put("#(心碎)", "image_emoticon35");
        hto.put("#(玫瑰)", "image_emoticon36");
        hto.put("#(礼物)", "image_emoticon37");
        hto.put("#(彩虹)", "image_emoticon38");
        hto.put("#(星星月亮)", "image_emoticon39");
        hto.put("#(太阳)", "image_emoticon40");
        hto.put("#(钱币)", "image_emoticon41");
        hto.put("#(灯泡)", "image_emoticon42");
        hto.put("#(茶杯)", "image_emoticon43");
        hto.put("#(蛋糕)", "image_emoticon44");
        hto.put("#(音乐)", "image_emoticon45");
        hto.put("#(haha)", "image_emoticon46");
        hto.put("#(胜利)", "image_emoticon47");
        hto.put("#(大拇指)", "image_emoticon48");
        hto.put("#(弱)", "image_emoticon49");
        hto.put("#(OK)", "image_emoticon50");
        hto.put("#(哼)", "image_emoticon61");
        hto.put("#(吃瓜)", "image_emoticon62");
        hto.put("#(扔便便)", "image_emoticon63");
        hto.put("#(惊恐)", "image_emoticon64");
        hto.put("#(哎呦)", "image_emoticon65");
        hto.put("#(小乖)", "image_emoticon66");
        hto.put("#(捂嘴笑)", "image_emoticon67");
        hto.put("#(你懂的)", "image_emoticon68");
        hto.put("#(what)", "image_emoticon69");
        hto.put("#(酸爽)", "image_emoticon70");
        hto.put("#(呀咩爹)", "image_emoticon71");
        hto.put("#(笑尿)", "image_emoticon72");
        hto.put("#(挖鼻)", "image_emoticon73");
        hto.put("#(犀利)", "image_emoticon74");
        hto.put("#(小红脸)", "image_emoticon75");
        hto.put("#(懒得理)", "image_emoticon76");
        hto.put("#(沙发)", "image_emoticon77");
        hto.put("#(手纸)", "image_emoticon78");
        hto.put("#(香蕉)", "image_emoticon79");
        hto.put("#(便便)", "image_emoticon80");
        hto.put("#(药丸)", "image_emoticon81");
        hto.put("#(红领巾)", "image_emoticon82");
        hto.put("#(蜡烛)", "image_emoticon83");
        hto.put("#(三道杠)", "image_emoticon84");
        hto.put("#(赖皮)", "ali_001");
        hto.put("#(感动)", "ali_002");
        hto.put("#(十分惊讶)", "ali_003");
        hto.put("#(怒气)", "ali_004");
        hto.put("#(哭泣)", "ali_005");
        hto.put("#(吃惊)", "ali_006");
        hto.put("#(嘲弄)", "ali_007");
        hto.put("#(飘过)", "ali_008");
        hto.put("#(转圈哭)", "ali_009");
        hto.put("#(神经病)", "ali_010");
        hto.put("#(揪耳朵)", "ali_011");
        hto.put("#(惊汗)", "ali_012");
        hto.put("#(隐身)", "ali_013");
        hto.put("#(不要嘛)", "ali_014");
        hto.put("#(遁)", "ali_015");
        hto.put("#(不公平)", "ali_016");
        hto.put("#(爬来了)", "ali_017");
        hto.put("#(蛋花哭)", "ali_018");
        hto.put("#(温暖)", "ali_019");
        hto.put("#(点头)", "ali_020");
        hto.put("#(撒钱)", "ali_021");
        hto.put("#(献花)", "ali_022");
        hto.put("#(寒)", "ali_023");
        hto.put("#(傻笑)", "ali_024");
        hto.put("#(扭扭)", "ali_025");
        hto.put("#(疯)", "ali_026");
        hto.put("#(抓狂)", "ali_027");
        hto.put("#(抓)", "ali_028");
        hto.put("#(蜷)", "ali_029");
        hto.put("#(挠墙)", "ali_030");
        hto.put("#(狂笑)", "ali_031");
        hto.put("#(抱枕)", "ali_032");
        hto.put("#(吼叫)", "ali_033");
        hto.put("#(嚷)", "ali_034");
        hto.put("#(唠叨)", "ali_035");
        hto.put("#(捏脸)", "ali_036");
        hto.put("#(爆笑)", "ali_037");
        hto.put("#(郁闷)", "ali_038");
        hto.put("#(潜水)", "ali_039");
        hto.put("#(十分开心)", "ali_040");
        hto.put("#(冷笑话)", "ali_041");
        hto.put("#(顶！)", "ali_042");
        hto.put("#(潜)", "ali_043");
        hto.put("#(画圈圈)", "ali_044");
        hto.put("#(玩电脑)", "ali_045");
        hto.put("#(狂吐)", "ali_046");
        hto.put("#(哭着跑)", "ali_047");
        hto.put("#(阿狸侠)", "ali_048");
        hto.put("#(冷死了)", "ali_049");
        hto.put("#(惆怅~)", "ali_050");
        hto.put("#(摸头)", "ali_051");
        hto.put("#(蹭)", "ali_052");
        hto.put("#(打滚)", "ali_053");
        hto.put("#(叩拜)", "ali_054");
        hto.put("#(摸)", "ali_055");
        hto.put("#(数钱)", "ali_056");
        hto.put("#(拖走)", "ali_057");
        hto.put("#(热)", "ali_058");
        hto.put("#(加1)", "ali_059");
        hto.put("#(压力)", "ali_060");
        hto.put("#(表逼我)", "ali_061");
        hto.put("#(人呢)", "ali_062");
        hto.put("#(摇晃)", "ali_063");
        hto.put("#(打地鼠)", "ali_064");
        hto.put("#(这个屌)", "ali_065");
        hto.put("#(恐慌)", "ali_066");
        hto.put("#(晕乎乎)", "ali_067");
        hto.put("#(浮云)", "ali_068");
        hto.put("#(给力)", "ali_069");
        hto.put("#(杯具了)", "ali_070");
        hto.put("#(焦糖舞)", "yz_001");
        hto.put("#(翻滚)", "yz_002");
        hto.put("#(拍屁股做鬼脸)", "yz_003");
        hto.put("#(不)", "yz_004");
        hto.put("#(河蟹掉啦)", "yz_005");
        hto.put("#(哦耶)", "yz_006");
        hto.put("#(我倒)", "yz_007");
        hto.put("#(投降)", "yz_008");
        hto.put("#(微笑)", "b01");
        hto.put("#(帅哥)", "b02");
        hto.put("#(美女)", "b03");
        hto.put("#(老大)", "b04");
        hto.put("#(哈哈哈)", "b05");
        hto.put("#(奸笑)", "b06");
        hto.put("#(傻乐)", "b07");
        hto.put("#(飞吻)", "b08");
        hto.put("#(害羞)", "b09");
        hto.put("#(花痴)", "b10");
        hto.put("#(憧憬)", "b11");
        hto.put("#(你牛)", "b12");
        hto.put("#(鼓掌)", "b13");
        hto.put("#(可爱)", "b14");
        hto.put("#(太委屈)", "b15");
        hto.put("#(大哭)", "b16");
        hto.put("#(泪奔)", "b17");
        hto.put("#(寻死)", "b18");
        hto.put("#(非常惊讶)", "b19");
        hto.put("#(表示疑问)", "b20");
        hto.put("#(暗中观察)", "image_emoticon85");
        hto.put("#(吃瓜)", "image_emoticon86");
        hto.put("#(喝酒)", "image_emoticon87");
        hto.put("#(嘿嘿嘿)", "image_emoticon88");
        hto.put("#(噗)", "image_emoticon89");
        hto.put("#(困成狗)", "image_emoticon90");
        hto.put("#(微微一笑)", "image_emoticon91");
        hto.put("#(托腮)", "image_emoticon92");
        hto.put("#(摊手)", "image_emoticon93");
        hto.put("#(柯基暗中观察)", "image_emoticon94");
        hto.put("#(欢呼)", "image_emoticon95");
        hto.put("#(炸药)", "image_emoticon96");
        hto.put("#(突然兴奋)", "image_emoticon97");
        hto.put("#(紧张)", "image_emoticon98");
        hto.put("#(黑头瞪眼)", "image_emoticon99");
        hto.put("#(黑头高兴)", "image_emoticon100");
        hto.put("#(不跟丑人说话)", "image_emoticon101");
        hto.put("#(么么哒)", "image_emoticon102");
        hto.put("#(亲亲才能起来)", "image_emoticon103");
        hto.put("#(伦家只是宝宝)", "image_emoticon104");
        hto.put("#(你是我的人)", "image_emoticon105");
        hto.put("#(假装看不见)", "image_emoticon106");
        hto.put("#(单身等撩)", "image_emoticon107");
        hto.put("#(吓到宝宝了)", "image_emoticon108");
        hto.put("#(哈哈哈)", "image_emoticon109");
        hto.put("#(嗯嗯)", "image_emoticon110");
        hto.put("#(好幸福)", "image_emoticon111");
        hto.put("#(宝宝不开心)", "image_emoticon112");
        hto.put("#(小姐姐别走)", "image_emoticon113");
        hto.put("#(小姐姐在吗)", "image_emoticon114");
        hto.put("#(小姐姐来啦)", "image_emoticon115");
        hto.put("#(小姐姐来玩呀)", "image_emoticon116");
        hto.put("#(我养你)", "image_emoticon117");
        hto.put("#(我是不会骗你的)", "image_emoticon118");
        hto.put("#(扎心了)", "image_emoticon119");
        hto.put("#(无聊)", "image_emoticon120");
        hto.put("#(月亮代表我的心)", "image_emoticon121");
        hto.put("#(来追我呀)", "image_emoticon122");
        hto.put("#(爱你的形状)", "image_emoticon123");
        hto.put("#(白眼)", "image_emoticon124");
    }

    private static String Cw(String str) {
        return hto.get(str);
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
                    String Cw = Cw(str3);
                    if (TextUtils.isEmpty(Cw)) {
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
                        SpannableString a = a(tbRichTextData.aUc(), Cw, str3);
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
        int vc = TbFaceManager.aPU().vc(str);
        if (vc != 0) {
            spannableString = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), vc);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0391a vv = TbFaceManager.aPU().vv(str);
            if (vv != null) {
                int width = (int) (0.5d * vv.getWidth());
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
