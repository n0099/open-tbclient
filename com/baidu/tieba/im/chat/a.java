package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> eKG = new HashMap<>();

    static {
        eKG.put("#(呵呵)", "image_emoticon");
        eKG.put("#(哈哈)", "image_emoticon2");
        eKG.put("#(吐舌)", "image_emoticon3");
        eKG.put("#(啊)", "image_emoticon4");
        eKG.put("#(啊?)", "image_emoticon4");
        eKG.put("#(酷)", "image_emoticon5");
        eKG.put("#(怒)", "image_emoticon6");
        eKG.put("#(开心)", "image_emoticon7");
        eKG.put("#(汗)", "image_emoticon8");
        eKG.put("#(泪)", "image_emoticon9");
        eKG.put("#(黑线)", "image_emoticon10");
        eKG.put("#(鄙视)", "image_emoticon11");
        eKG.put("#(不高兴)", "image_emoticon12");
        eKG.put("#(真棒)", "image_emoticon13");
        eKG.put("#(钱)", "image_emoticon14");
        eKG.put("#(疑问)", "image_emoticon15");
        eKG.put("#(阴险)", "image_emoticon16");
        eKG.put("#(吐)", "image_emoticon17");
        eKG.put("#(咦)", "image_emoticon18");
        eKG.put("#(咦?)", "image_emoticon18");
        eKG.put("#(委屈)", "image_emoticon19");
        eKG.put("#(花心)", "image_emoticon20");
        eKG.put("#(呼~)", "image_emoticon21");
        eKG.put("#(笑眼)", "image_emoticon22");
        eKG.put("#(冷)", "image_emoticon23");
        eKG.put("#(太开心)", "image_emoticon24");
        eKG.put("#(滑稽)", "image_emoticon25");
        eKG.put("#(勉强)", "image_emoticon26");
        eKG.put("#(狂汗)", "image_emoticon27");
        eKG.put("#(乖)", "image_emoticon28");
        eKG.put("#(睡觉)", "image_emoticon29");
        eKG.put("#(惊哭)", "image_emoticon30");
        eKG.put("#(升起)", "image_emoticon31");
        eKG.put("#(惊讶)", "image_emoticon32");
        eKG.put("#(喷)", "image_emoticon33");
        eKG.put("#(爱心)", "image_emoticon34");
        eKG.put("#(心碎)", "image_emoticon35");
        eKG.put("#(玫瑰)", "image_emoticon36");
        eKG.put("#(礼物)", "image_emoticon37");
        eKG.put("#(彩虹)", "image_emoticon38");
        eKG.put("#(星星月亮)", "image_emoticon39");
        eKG.put("#(太阳)", "image_emoticon40");
        eKG.put("#(钱币)", "image_emoticon41");
        eKG.put("#(灯泡)", "image_emoticon42");
        eKG.put("#(茶杯)", "image_emoticon43");
        eKG.put("#(蛋糕)", "image_emoticon44");
        eKG.put("#(音乐)", "image_emoticon45");
        eKG.put("#(haha)", "image_emoticon46");
        eKG.put("#(胜利)", "image_emoticon47");
        eKG.put("#(大拇指)", "image_emoticon48");
        eKG.put("#(弱)", "image_emoticon49");
        eKG.put("#(OK)", "image_emoticon50");
        eKG.put("#(哼)", "image_emoticon61");
        eKG.put("#(吃瓜)", "image_emoticon62");
        eKG.put("#(扔便便)", "image_emoticon63");
        eKG.put("#(惊恐)", "image_emoticon64");
        eKG.put("#(哎呦)", "image_emoticon65");
        eKG.put("#(小乖)", "image_emoticon66");
        eKG.put("#(捂嘴笑)", "image_emoticon67");
        eKG.put("#(你懂的)", "image_emoticon68");
        eKG.put("#(what)", "image_emoticon69");
        eKG.put("#(酸爽)", "image_emoticon70");
        eKG.put("#(呀咩爹)", "image_emoticon71");
        eKG.put("#(笑尿)", "image_emoticon72");
        eKG.put("#(挖鼻)", "image_emoticon73");
        eKG.put("#(犀利)", "image_emoticon74");
        eKG.put("#(小红脸)", "image_emoticon75");
        eKG.put("#(懒得理)", "image_emoticon76");
        eKG.put("#(沙发)", "image_emoticon77");
        eKG.put("#(手纸)", "image_emoticon78");
        eKG.put("#(香蕉)", "image_emoticon79");
        eKG.put("#(便便)", "image_emoticon80");
        eKG.put("#(药丸)", "image_emoticon81");
        eKG.put("#(红领巾)", "image_emoticon82");
        eKG.put("#(蜡烛)", "image_emoticon83");
        eKG.put("#(三道杠)", "image_emoticon84");
        eKG.put("#(赖皮)", "ali_001");
        eKG.put("#(感动)", "ali_002");
        eKG.put("#(十分惊讶)", "ali_003");
        eKG.put("#(怒气)", "ali_004");
        eKG.put("#(哭泣)", "ali_005");
        eKG.put("#(吃惊)", "ali_006");
        eKG.put("#(嘲弄)", "ali_007");
        eKG.put("#(飘过)", "ali_008");
        eKG.put("#(转圈哭)", "ali_009");
        eKG.put("#(神经病)", "ali_010");
        eKG.put("#(揪耳朵)", "ali_011");
        eKG.put("#(惊汗)", "ali_012");
        eKG.put("#(隐身)", "ali_013");
        eKG.put("#(不要嘛)", "ali_014");
        eKG.put("#(遁)", "ali_015");
        eKG.put("#(不公平)", "ali_016");
        eKG.put("#(爬来了)", "ali_017");
        eKG.put("#(蛋花哭)", "ali_018");
        eKG.put("#(温暖)", "ali_019");
        eKG.put("#(点头)", "ali_020");
        eKG.put("#(撒钱)", "ali_021");
        eKG.put("#(献花)", "ali_022");
        eKG.put("#(寒)", "ali_023");
        eKG.put("#(傻笑)", "ali_024");
        eKG.put("#(扭扭)", "ali_025");
        eKG.put("#(疯)", "ali_026");
        eKG.put("#(抓狂)", "ali_027");
        eKG.put("#(抓)", "ali_028");
        eKG.put("#(蜷)", "ali_029");
        eKG.put("#(挠墙)", "ali_030");
        eKG.put("#(狂笑)", "ali_031");
        eKG.put("#(抱枕)", "ali_032");
        eKG.put("#(吼叫)", "ali_033");
        eKG.put("#(嚷)", "ali_034");
        eKG.put("#(唠叨)", "ali_035");
        eKG.put("#(捏脸)", "ali_036");
        eKG.put("#(爆笑)", "ali_037");
        eKG.put("#(郁闷)", "ali_038");
        eKG.put("#(潜水)", "ali_039");
        eKG.put("#(十分开心)", "ali_040");
        eKG.put("#(冷笑话)", "ali_041");
        eKG.put("#(顶！)", "ali_042");
        eKG.put("#(潜)", "ali_043");
        eKG.put("#(画圈圈)", "ali_044");
        eKG.put("#(玩电脑)", "ali_045");
        eKG.put("#(狂吐)", "ali_046");
        eKG.put("#(哭着跑)", "ali_047");
        eKG.put("#(阿狸侠)", "ali_048");
        eKG.put("#(冷死了)", "ali_049");
        eKG.put("#(惆怅~)", "ali_050");
        eKG.put("#(摸头)", "ali_051");
        eKG.put("#(蹭)", "ali_052");
        eKG.put("#(打滚)", "ali_053");
        eKG.put("#(叩拜)", "ali_054");
        eKG.put("#(摸)", "ali_055");
        eKG.put("#(数钱)", "ali_056");
        eKG.put("#(拖走)", "ali_057");
        eKG.put("#(热)", "ali_058");
        eKG.put("#(加1)", "ali_059");
        eKG.put("#(压力)", "ali_060");
        eKG.put("#(表逼我)", "ali_061");
        eKG.put("#(人呢)", "ali_062");
        eKG.put("#(摇晃)", "ali_063");
        eKG.put("#(打地鼠)", "ali_064");
        eKG.put("#(这个屌)", "ali_065");
        eKG.put("#(恐慌)", "ali_066");
        eKG.put("#(晕乎乎)", "ali_067");
        eKG.put("#(浮云)", "ali_068");
        eKG.put("#(给力)", "ali_069");
        eKG.put("#(杯具了)", "ali_070");
        eKG.put("#(焦糖舞)", "yz_001");
        eKG.put("#(翻滚)", "yz_002");
        eKG.put("#(拍屁股做鬼脸)", "yz_003");
        eKG.put("#(不)", "yz_004");
        eKG.put("#(河蟹掉啦)", "yz_005");
        eKG.put("#(哦耶)", "yz_006");
        eKG.put("#(我倒)", "yz_007");
        eKG.put("#(投降)", "yz_008");
        eKG.put("#(微笑)", "b01");
        eKG.put("#(帅哥)", "b02");
        eKG.put("#(美女)", "b03");
        eKG.put("#(老大)", "b04");
        eKG.put("#(哈哈哈)", "b05");
        eKG.put("#(奸笑)", "b06");
        eKG.put("#(傻乐)", "b07");
        eKG.put("#(飞吻)", "b08");
        eKG.put("#(害羞)", "b09");
        eKG.put("#(花痴)", "b10");
        eKG.put("#(憧憬)", "b11");
        eKG.put("#(你牛)", "b12");
        eKG.put("#(鼓掌)", "b13");
        eKG.put("#(可爱)", "b14");
        eKG.put("#(太委屈)", "b15");
        eKG.put("#(大哭)", "b16");
        eKG.put("#(泪奔)", "b17");
        eKG.put("#(寻死)", "b18");
        eKG.put("#(非常惊讶)", "b19");
        eKG.put("#(表示疑问)", "b20");
        eKG.put("#(暗中观察)", "image_emoticon85");
        eKG.put("#(吃瓜)", "image_emoticon86");
        eKG.put("#(喝酒)", "image_emoticon87");
        eKG.put("#(嘿嘿嘿)", "image_emoticon88");
        eKG.put("#(噗)", "image_emoticon89");
        eKG.put("#(困成狗)", "image_emoticon90");
        eKG.put("#(微微一笑)", "image_emoticon91");
        eKG.put("#(托腮)", "image_emoticon92");
        eKG.put("#(摊手)", "image_emoticon93");
        eKG.put("#(柯基暗中观察)", "image_emoticon94");
        eKG.put("#(欢呼)", "image_emoticon95");
        eKG.put("#(炸药)", "image_emoticon96");
        eKG.put("#(突然兴奋)", "image_emoticon97");
        eKG.put("#(紧张)", "image_emoticon98");
        eKG.put("#(黑头瞪眼)", "image_emoticon99");
        eKG.put("#(黑头高兴)", "image_emoticon100");
        eKG.put("#(不跟丑人说话)", "image_emoticon101");
        eKG.put("#(么么哒)", "image_emoticon102");
        eKG.put("#(亲亲才能起来)", "image_emoticon103");
        eKG.put("#(伦家只是宝宝)", "image_emoticon104");
        eKG.put("#(你是我的人)", "image_emoticon105");
        eKG.put("#(假装看不见)", "image_emoticon106");
        eKG.put("#(单身等撩)", "image_emoticon107");
        eKG.put("#(吓到宝宝了)", "image_emoticon108");
        eKG.put("#(哈哈哈)", "image_emoticon109");
        eKG.put("#(嗯嗯)", "image_emoticon110");
        eKG.put("#(好幸福)", "image_emoticon111");
        eKG.put("#(宝宝不开心)", "image_emoticon112");
        eKG.put("#(小姐姐别走)", "image_emoticon113");
        eKG.put("#(小姐姐在吗)", "image_emoticon114");
        eKG.put("#(小姐姐来啦)", "image_emoticon115");
        eKG.put("#(小姐姐来玩呀)", "image_emoticon116");
        eKG.put("#(我养你)", "image_emoticon117");
        eKG.put("#(我是不会骗你的)", "image_emoticon118");
        eKG.put("#(扎心了)", "image_emoticon119");
        eKG.put("#(无聊)", "image_emoticon120");
        eKG.put("#(月亮代表我的心)", "image_emoticon121");
        eKG.put("#(来追我呀)", "image_emoticon122");
        eKG.put("#(爱你的形状)", "image_emoticon123");
        eKG.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return eKG.get(str);
    }

    public static ArrayList<TbRichTextData> h(Context context, String str, int i) {
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
                                SpannableString ax = ax(context, str5);
                                if (ax != null) {
                                    tbRichTextData.append(ax);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.SC(), name, str3);
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
                    SpannableString ax2 = ax(context, str5);
                    if (ax2 != null) {
                        tbRichTextData.append(ax2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int hS = TbFaceManager.NL().hS(str);
        if (hS != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), hS);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0171a ir = TbFaceManager.NL().ir(str);
            if (ir != null) {
                int width = (int) (0.5d * ir.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString ax(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ay.ai(context, str);
    }
}
