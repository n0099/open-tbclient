package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> jVC = new HashMap<>();

    static {
        jVC.put("#(呵呵)", "image_emoticon");
        jVC.put("#(哈哈)", "image_emoticon2");
        jVC.put("#(吐舌)", "image_emoticon3");
        jVC.put("#(啊)", "image_emoticon4");
        jVC.put("#(啊?)", "image_emoticon4");
        jVC.put("#(酷)", "image_emoticon5");
        jVC.put("#(怒)", "image_emoticon6");
        jVC.put("#(开心)", "image_emoticon7");
        jVC.put("#(汗)", "image_emoticon8");
        jVC.put("#(泪)", "image_emoticon9");
        jVC.put("#(黑线)", "image_emoticon10");
        jVC.put("#(鄙视)", "image_emoticon11");
        jVC.put("#(不高兴)", "image_emoticon12");
        jVC.put("#(真棒)", "image_emoticon13");
        jVC.put("#(钱)", "image_emoticon14");
        jVC.put("#(疑问)", "image_emoticon15");
        jVC.put("#(阴险)", "image_emoticon16");
        jVC.put("#(吐)", "image_emoticon17");
        jVC.put("#(咦)", "image_emoticon18");
        jVC.put("#(咦?)", "image_emoticon18");
        jVC.put("#(委屈)", "image_emoticon19");
        jVC.put("#(花心)", "image_emoticon20");
        jVC.put("#(呼~)", "image_emoticon21");
        jVC.put("#(笑眼)", "image_emoticon22");
        jVC.put("#(冷)", "image_emoticon23");
        jVC.put("#(太开心)", "image_emoticon24");
        jVC.put("#(滑稽)", "image_emoticon25");
        jVC.put("#(勉强)", "image_emoticon26");
        jVC.put("#(狂汗)", "image_emoticon27");
        jVC.put("#(乖)", "image_emoticon28");
        jVC.put("#(睡觉)", "image_emoticon29");
        jVC.put("#(惊哭)", "image_emoticon30");
        jVC.put("#(升起)", "image_emoticon31");
        jVC.put("#(惊讶)", "image_emoticon32");
        jVC.put("#(喷)", "image_emoticon33");
        jVC.put("#(爱心)", "image_emoticon34");
        jVC.put("#(心碎)", "image_emoticon35");
        jVC.put("#(玫瑰)", "image_emoticon36");
        jVC.put("#(礼物)", "image_emoticon37");
        jVC.put("#(彩虹)", "image_emoticon38");
        jVC.put("#(星星月亮)", "image_emoticon39");
        jVC.put("#(太阳)", "image_emoticon40");
        jVC.put("#(钱币)", "image_emoticon41");
        jVC.put("#(灯泡)", "image_emoticon42");
        jVC.put("#(茶杯)", "image_emoticon43");
        jVC.put("#(蛋糕)", "image_emoticon44");
        jVC.put("#(音乐)", "image_emoticon45");
        jVC.put("#(haha)", "image_emoticon46");
        jVC.put("#(胜利)", "image_emoticon47");
        jVC.put("#(大拇指)", "image_emoticon48");
        jVC.put("#(弱)", "image_emoticon49");
        jVC.put("#(OK)", "image_emoticon50");
        jVC.put("#(哼)", "image_emoticon61");
        jVC.put("#(吃瓜)", "image_emoticon62");
        jVC.put("#(扔便便)", "image_emoticon63");
        jVC.put("#(惊恐)", "image_emoticon64");
        jVC.put("#(哎呦)", "image_emoticon65");
        jVC.put("#(小乖)", "image_emoticon66");
        jVC.put("#(捂嘴笑)", "image_emoticon67");
        jVC.put("#(你懂的)", "image_emoticon68");
        jVC.put("#(what)", "image_emoticon69");
        jVC.put("#(酸爽)", "image_emoticon70");
        jVC.put("#(呀咩爹)", "image_emoticon71");
        jVC.put("#(笑尿)", "image_emoticon72");
        jVC.put("#(挖鼻)", "image_emoticon73");
        jVC.put("#(犀利)", "image_emoticon74");
        jVC.put("#(小红脸)", "image_emoticon75");
        jVC.put("#(懒得理)", "image_emoticon76");
        jVC.put("#(沙发)", "image_emoticon77");
        jVC.put("#(手纸)", "image_emoticon78");
        jVC.put("#(香蕉)", "image_emoticon79");
        jVC.put("#(便便)", "image_emoticon80");
        jVC.put("#(药丸)", "image_emoticon81");
        jVC.put("#(红领巾)", "image_emoticon82");
        jVC.put("#(蜡烛)", "image_emoticon83");
        jVC.put("#(三道杠)", "image_emoticon84");
        jVC.put("#(赖皮)", "ali_001");
        jVC.put("#(感动)", "ali_002");
        jVC.put("#(十分惊讶)", "ali_003");
        jVC.put("#(怒气)", "ali_004");
        jVC.put("#(哭泣)", "ali_005");
        jVC.put("#(吃惊)", "ali_006");
        jVC.put("#(嘲弄)", "ali_007");
        jVC.put("#(飘过)", "ali_008");
        jVC.put("#(转圈哭)", "ali_009");
        jVC.put("#(神经病)", "ali_010");
        jVC.put("#(揪耳朵)", "ali_011");
        jVC.put("#(惊汗)", "ali_012");
        jVC.put("#(隐身)", "ali_013");
        jVC.put("#(不要嘛)", "ali_014");
        jVC.put("#(遁)", "ali_015");
        jVC.put("#(不公平)", "ali_016");
        jVC.put("#(爬来了)", "ali_017");
        jVC.put("#(蛋花哭)", "ali_018");
        jVC.put("#(温暖)", "ali_019");
        jVC.put("#(点头)", "ali_020");
        jVC.put("#(撒钱)", "ali_021");
        jVC.put("#(献花)", "ali_022");
        jVC.put("#(寒)", "ali_023");
        jVC.put("#(傻笑)", "ali_024");
        jVC.put("#(扭扭)", "ali_025");
        jVC.put("#(疯)", "ali_026");
        jVC.put("#(抓狂)", "ali_027");
        jVC.put("#(抓)", "ali_028");
        jVC.put("#(蜷)", "ali_029");
        jVC.put("#(挠墙)", "ali_030");
        jVC.put("#(狂笑)", "ali_031");
        jVC.put("#(抱枕)", "ali_032");
        jVC.put("#(吼叫)", "ali_033");
        jVC.put("#(嚷)", "ali_034");
        jVC.put("#(唠叨)", "ali_035");
        jVC.put("#(捏脸)", "ali_036");
        jVC.put("#(爆笑)", "ali_037");
        jVC.put("#(郁闷)", "ali_038");
        jVC.put("#(潜水)", "ali_039");
        jVC.put("#(十分开心)", "ali_040");
        jVC.put("#(冷笑话)", "ali_041");
        jVC.put("#(顶！)", "ali_042");
        jVC.put("#(潜)", "ali_043");
        jVC.put("#(画圈圈)", "ali_044");
        jVC.put("#(玩电脑)", "ali_045");
        jVC.put("#(狂吐)", "ali_046");
        jVC.put("#(哭着跑)", "ali_047");
        jVC.put("#(阿狸侠)", "ali_048");
        jVC.put("#(冷死了)", "ali_049");
        jVC.put("#(惆怅~)", "ali_050");
        jVC.put("#(摸头)", "ali_051");
        jVC.put("#(蹭)", "ali_052");
        jVC.put("#(打滚)", "ali_053");
        jVC.put("#(叩拜)", "ali_054");
        jVC.put("#(摸)", "ali_055");
        jVC.put("#(数钱)", "ali_056");
        jVC.put("#(拖走)", "ali_057");
        jVC.put("#(热)", "ali_058");
        jVC.put("#(加1)", "ali_059");
        jVC.put("#(压力)", "ali_060");
        jVC.put("#(表逼我)", "ali_061");
        jVC.put("#(人呢)", "ali_062");
        jVC.put("#(摇晃)", "ali_063");
        jVC.put("#(打地鼠)", "ali_064");
        jVC.put("#(这个屌)", "ali_065");
        jVC.put("#(恐慌)", "ali_066");
        jVC.put("#(晕乎乎)", "ali_067");
        jVC.put("#(浮云)", "ali_068");
        jVC.put("#(给力)", "ali_069");
        jVC.put("#(杯具了)", "ali_070");
        jVC.put("#(焦糖舞)", "yz_001");
        jVC.put("#(翻滚)", "yz_002");
        jVC.put("#(拍屁股做鬼脸)", "yz_003");
        jVC.put("#(不)", "yz_004");
        jVC.put("#(河蟹掉啦)", "yz_005");
        jVC.put("#(哦耶)", "yz_006");
        jVC.put("#(我倒)", "yz_007");
        jVC.put("#(投降)", "yz_008");
        jVC.put("#(微笑)", "b01");
        jVC.put("#(帅哥)", "b02");
        jVC.put("#(美女)", "b03");
        jVC.put("#(老大)", "b04");
        jVC.put("#(哈哈哈)", "b05");
        jVC.put("#(奸笑)", "b06");
        jVC.put("#(傻乐)", "b07");
        jVC.put("#(飞吻)", "b08");
        jVC.put("#(害羞)", "b09");
        jVC.put("#(花痴)", "b10");
        jVC.put("#(憧憬)", "b11");
        jVC.put("#(你牛)", "b12");
        jVC.put("#(鼓掌)", "b13");
        jVC.put("#(可爱)", "b14");
        jVC.put("#(太委屈)", "b15");
        jVC.put("#(大哭)", "b16");
        jVC.put("#(泪奔)", "b17");
        jVC.put("#(寻死)", "b18");
        jVC.put("#(非常惊讶)", "b19");
        jVC.put("#(表示疑问)", "b20");
        jVC.put("#(暗中观察)", "image_emoticon85");
        jVC.put("#(吃瓜)", "image_emoticon86");
        jVC.put("#(喝酒)", "image_emoticon87");
        jVC.put("#(嘿嘿嘿)", "image_emoticon88");
        jVC.put("#(噗)", "image_emoticon89");
        jVC.put("#(困成狗)", "image_emoticon90");
        jVC.put("#(微微一笑)", "image_emoticon91");
        jVC.put("#(托腮)", "image_emoticon92");
        jVC.put("#(摊手)", "image_emoticon93");
        jVC.put("#(柯基暗中观察)", "image_emoticon94");
        jVC.put("#(欢呼)", "image_emoticon95");
        jVC.put("#(炸药)", "image_emoticon96");
        jVC.put("#(突然兴奋)", "image_emoticon97");
        jVC.put("#(紧张)", "image_emoticon98");
        jVC.put("#(黑头瞪眼)", "image_emoticon99");
        jVC.put("#(黑头高兴)", "image_emoticon100");
        jVC.put("#(不跟丑人说话)", "image_emoticon101");
        jVC.put("#(么么哒)", "image_emoticon102");
        jVC.put("#(亲亲才能起来)", "image_emoticon103");
        jVC.put("#(伦家只是宝宝)", "image_emoticon104");
        jVC.put("#(你是我的人)", "image_emoticon105");
        jVC.put("#(假装看不见)", "image_emoticon106");
        jVC.put("#(单身等撩)", "image_emoticon107");
        jVC.put("#(吓到宝宝了)", "image_emoticon108");
        jVC.put("#(哈哈哈)", "image_emoticon109");
        jVC.put("#(嗯嗯)", "image_emoticon110");
        jVC.put("#(好幸福)", "image_emoticon111");
        jVC.put("#(宝宝不开心)", "image_emoticon112");
        jVC.put("#(小姐姐别走)", "image_emoticon113");
        jVC.put("#(小姐姐在吗)", "image_emoticon114");
        jVC.put("#(小姐姐来啦)", "image_emoticon115");
        jVC.put("#(小姐姐来玩呀)", "image_emoticon116");
        jVC.put("#(我养你)", "image_emoticon117");
        jVC.put("#(我是不会骗你的)", "image_emoticon118");
        jVC.put("#(扎心了)", "image_emoticon119");
        jVC.put("#(无聊)", "image_emoticon120");
        jVC.put("#(月亮代表我的心)", "image_emoticon121");
        jVC.put("#(来追我呀)", "image_emoticon122");
        jVC.put("#(爱你的形状)", "image_emoticon123");
        jVC.put("#(白眼)", "image_emoticon124");
    }

    private static String LE(String str) {
        return jVC.get(str);
    }

    public static ArrayList<TbRichTextData> d(Context context, String str, int i) {
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
                    String LE = LE(str3);
                    if (TextUtils.isEmpty(LE)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.p(str5);
                            } else {
                                SpannableString aM = aM(context, str5);
                                if (aM != null) {
                                    tbRichTextData.p(aM);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a2 = a(tbRichTextData.bFg(), LE, str3);
                        if (a2 != null) {
                            tbRichTextData.p(a2);
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
                    tbRichTextData.p(str5);
                } else {
                    SpannableString aM2 = aM(context, str5);
                    if (aM2 != null) {
                        tbRichTextData.p(aM2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int Dc = TbFaceManager.bAs().Dc(str);
        if (Dc != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), Dc);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0592a Dx = TbFaceManager.bAs().Dx(str);
            if (Dx != null) {
                int width = (int) (0.5d * Dx.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aM(Context context, String str) {
        if (str == null) {
            return null;
        }
        return bf.ar(context, str);
    }
}
