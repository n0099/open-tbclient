package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> gAI = new HashMap<>();

    static {
        gAI.put("#(呵呵)", "image_emoticon");
        gAI.put("#(哈哈)", "image_emoticon2");
        gAI.put("#(吐舌)", "image_emoticon3");
        gAI.put("#(啊)", "image_emoticon4");
        gAI.put("#(啊?)", "image_emoticon4");
        gAI.put("#(酷)", "image_emoticon5");
        gAI.put("#(怒)", "image_emoticon6");
        gAI.put("#(开心)", "image_emoticon7");
        gAI.put("#(汗)", "image_emoticon8");
        gAI.put("#(泪)", "image_emoticon9");
        gAI.put("#(黑线)", "image_emoticon10");
        gAI.put("#(鄙视)", "image_emoticon11");
        gAI.put("#(不高兴)", "image_emoticon12");
        gAI.put("#(真棒)", "image_emoticon13");
        gAI.put("#(钱)", "image_emoticon14");
        gAI.put("#(疑问)", "image_emoticon15");
        gAI.put("#(阴险)", "image_emoticon16");
        gAI.put("#(吐)", "image_emoticon17");
        gAI.put("#(咦)", "image_emoticon18");
        gAI.put("#(咦?)", "image_emoticon18");
        gAI.put("#(委屈)", "image_emoticon19");
        gAI.put("#(花心)", "image_emoticon20");
        gAI.put("#(呼~)", "image_emoticon21");
        gAI.put("#(笑眼)", "image_emoticon22");
        gAI.put("#(冷)", "image_emoticon23");
        gAI.put("#(太开心)", "image_emoticon24");
        gAI.put("#(滑稽)", "image_emoticon25");
        gAI.put("#(勉强)", "image_emoticon26");
        gAI.put("#(狂汗)", "image_emoticon27");
        gAI.put("#(乖)", "image_emoticon28");
        gAI.put("#(睡觉)", "image_emoticon29");
        gAI.put("#(惊哭)", "image_emoticon30");
        gAI.put("#(升起)", "image_emoticon31");
        gAI.put("#(惊讶)", "image_emoticon32");
        gAI.put("#(喷)", "image_emoticon33");
        gAI.put("#(爱心)", "image_emoticon34");
        gAI.put("#(心碎)", "image_emoticon35");
        gAI.put("#(玫瑰)", "image_emoticon36");
        gAI.put("#(礼物)", "image_emoticon37");
        gAI.put("#(彩虹)", "image_emoticon38");
        gAI.put("#(星星月亮)", "image_emoticon39");
        gAI.put("#(太阳)", "image_emoticon40");
        gAI.put("#(钱币)", "image_emoticon41");
        gAI.put("#(灯泡)", "image_emoticon42");
        gAI.put("#(茶杯)", "image_emoticon43");
        gAI.put("#(蛋糕)", "image_emoticon44");
        gAI.put("#(音乐)", "image_emoticon45");
        gAI.put("#(haha)", "image_emoticon46");
        gAI.put("#(胜利)", "image_emoticon47");
        gAI.put("#(大拇指)", "image_emoticon48");
        gAI.put("#(弱)", "image_emoticon49");
        gAI.put("#(OK)", "image_emoticon50");
        gAI.put("#(哼)", "image_emoticon61");
        gAI.put("#(吃瓜)", "image_emoticon62");
        gAI.put("#(扔便便)", "image_emoticon63");
        gAI.put("#(惊恐)", "image_emoticon64");
        gAI.put("#(哎呦)", "image_emoticon65");
        gAI.put("#(小乖)", "image_emoticon66");
        gAI.put("#(捂嘴笑)", "image_emoticon67");
        gAI.put("#(你懂的)", "image_emoticon68");
        gAI.put("#(what)", "image_emoticon69");
        gAI.put("#(酸爽)", "image_emoticon70");
        gAI.put("#(呀咩爹)", "image_emoticon71");
        gAI.put("#(笑尿)", "image_emoticon72");
        gAI.put("#(挖鼻)", "image_emoticon73");
        gAI.put("#(犀利)", "image_emoticon74");
        gAI.put("#(小红脸)", "image_emoticon75");
        gAI.put("#(懒得理)", "image_emoticon76");
        gAI.put("#(沙发)", "image_emoticon77");
        gAI.put("#(手纸)", "image_emoticon78");
        gAI.put("#(香蕉)", "image_emoticon79");
        gAI.put("#(便便)", "image_emoticon80");
        gAI.put("#(药丸)", "image_emoticon81");
        gAI.put("#(红领巾)", "image_emoticon82");
        gAI.put("#(蜡烛)", "image_emoticon83");
        gAI.put("#(三道杠)", "image_emoticon84");
        gAI.put("#(赖皮)", "ali_001");
        gAI.put("#(感动)", "ali_002");
        gAI.put("#(十分惊讶)", "ali_003");
        gAI.put("#(怒气)", "ali_004");
        gAI.put("#(哭泣)", "ali_005");
        gAI.put("#(吃惊)", "ali_006");
        gAI.put("#(嘲弄)", "ali_007");
        gAI.put("#(飘过)", "ali_008");
        gAI.put("#(转圈哭)", "ali_009");
        gAI.put("#(神经病)", "ali_010");
        gAI.put("#(揪耳朵)", "ali_011");
        gAI.put("#(惊汗)", "ali_012");
        gAI.put("#(隐身)", "ali_013");
        gAI.put("#(不要嘛)", "ali_014");
        gAI.put("#(遁)", "ali_015");
        gAI.put("#(不公平)", "ali_016");
        gAI.put("#(爬来了)", "ali_017");
        gAI.put("#(蛋花哭)", "ali_018");
        gAI.put("#(温暖)", "ali_019");
        gAI.put("#(点头)", "ali_020");
        gAI.put("#(撒钱)", "ali_021");
        gAI.put("#(献花)", "ali_022");
        gAI.put("#(寒)", "ali_023");
        gAI.put("#(傻笑)", "ali_024");
        gAI.put("#(扭扭)", "ali_025");
        gAI.put("#(疯)", "ali_026");
        gAI.put("#(抓狂)", "ali_027");
        gAI.put("#(抓)", "ali_028");
        gAI.put("#(蜷)", "ali_029");
        gAI.put("#(挠墙)", "ali_030");
        gAI.put("#(狂笑)", "ali_031");
        gAI.put("#(抱枕)", "ali_032");
        gAI.put("#(吼叫)", "ali_033");
        gAI.put("#(嚷)", "ali_034");
        gAI.put("#(唠叨)", "ali_035");
        gAI.put("#(捏脸)", "ali_036");
        gAI.put("#(爆笑)", "ali_037");
        gAI.put("#(郁闷)", "ali_038");
        gAI.put("#(潜水)", "ali_039");
        gAI.put("#(十分开心)", "ali_040");
        gAI.put("#(冷笑话)", "ali_041");
        gAI.put("#(顶！)", "ali_042");
        gAI.put("#(潜)", "ali_043");
        gAI.put("#(画圈圈)", "ali_044");
        gAI.put("#(玩电脑)", "ali_045");
        gAI.put("#(狂吐)", "ali_046");
        gAI.put("#(哭着跑)", "ali_047");
        gAI.put("#(阿狸侠)", "ali_048");
        gAI.put("#(冷死了)", "ali_049");
        gAI.put("#(惆怅~)", "ali_050");
        gAI.put("#(摸头)", "ali_051");
        gAI.put("#(蹭)", "ali_052");
        gAI.put("#(打滚)", "ali_053");
        gAI.put("#(叩拜)", "ali_054");
        gAI.put("#(摸)", "ali_055");
        gAI.put("#(数钱)", "ali_056");
        gAI.put("#(拖走)", "ali_057");
        gAI.put("#(热)", "ali_058");
        gAI.put("#(加1)", "ali_059");
        gAI.put("#(压力)", "ali_060");
        gAI.put("#(表逼我)", "ali_061");
        gAI.put("#(人呢)", "ali_062");
        gAI.put("#(摇晃)", "ali_063");
        gAI.put("#(打地鼠)", "ali_064");
        gAI.put("#(这个屌)", "ali_065");
        gAI.put("#(恐慌)", "ali_066");
        gAI.put("#(晕乎乎)", "ali_067");
        gAI.put("#(浮云)", "ali_068");
        gAI.put("#(给力)", "ali_069");
        gAI.put("#(杯具了)", "ali_070");
        gAI.put("#(焦糖舞)", "yz_001");
        gAI.put("#(翻滚)", "yz_002");
        gAI.put("#(拍屁股做鬼脸)", "yz_003");
        gAI.put("#(不)", "yz_004");
        gAI.put("#(河蟹掉啦)", "yz_005");
        gAI.put("#(哦耶)", "yz_006");
        gAI.put("#(我倒)", "yz_007");
        gAI.put("#(投降)", "yz_008");
        gAI.put("#(微笑)", "b01");
        gAI.put("#(帅哥)", "b02");
        gAI.put("#(美女)", "b03");
        gAI.put("#(老大)", "b04");
        gAI.put("#(哈哈哈)", "b05");
        gAI.put("#(奸笑)", "b06");
        gAI.put("#(傻乐)", "b07");
        gAI.put("#(飞吻)", "b08");
        gAI.put("#(害羞)", "b09");
        gAI.put("#(花痴)", "b10");
        gAI.put("#(憧憬)", "b11");
        gAI.put("#(你牛)", "b12");
        gAI.put("#(鼓掌)", "b13");
        gAI.put("#(可爱)", "b14");
        gAI.put("#(太委屈)", "b15");
        gAI.put("#(大哭)", "b16");
        gAI.put("#(泪奔)", "b17");
        gAI.put("#(寻死)", "b18");
        gAI.put("#(非常惊讶)", "b19");
        gAI.put("#(表示疑问)", "b20");
        gAI.put("#(暗中观察)", "image_emoticon85");
        gAI.put("#(吃瓜)", "image_emoticon86");
        gAI.put("#(喝酒)", "image_emoticon87");
        gAI.put("#(嘿嘿嘿)", "image_emoticon88");
        gAI.put("#(噗)", "image_emoticon89");
        gAI.put("#(困成狗)", "image_emoticon90");
        gAI.put("#(微微一笑)", "image_emoticon91");
        gAI.put("#(托腮)", "image_emoticon92");
        gAI.put("#(摊手)", "image_emoticon93");
        gAI.put("#(柯基暗中观察)", "image_emoticon94");
        gAI.put("#(欢呼)", "image_emoticon95");
        gAI.put("#(炸药)", "image_emoticon96");
        gAI.put("#(突然兴奋)", "image_emoticon97");
        gAI.put("#(紧张)", "image_emoticon98");
        gAI.put("#(黑头瞪眼)", "image_emoticon99");
        gAI.put("#(黑头高兴)", "image_emoticon100");
        gAI.put("#(不跟丑人说话)", "image_emoticon101");
        gAI.put("#(么么哒)", "image_emoticon102");
        gAI.put("#(亲亲才能起来)", "image_emoticon103");
        gAI.put("#(伦家只是宝宝)", "image_emoticon104");
        gAI.put("#(你是我的人)", "image_emoticon105");
        gAI.put("#(假装看不见)", "image_emoticon106");
        gAI.put("#(单身等撩)", "image_emoticon107");
        gAI.put("#(吓到宝宝了)", "image_emoticon108");
        gAI.put("#(哈哈哈)", "image_emoticon109");
        gAI.put("#(嗯嗯)", "image_emoticon110");
        gAI.put("#(好幸福)", "image_emoticon111");
        gAI.put("#(宝宝不开心)", "image_emoticon112");
        gAI.put("#(小姐姐别走)", "image_emoticon113");
        gAI.put("#(小姐姐在吗)", "image_emoticon114");
        gAI.put("#(小姐姐来啦)", "image_emoticon115");
        gAI.put("#(小姐姐来玩呀)", "image_emoticon116");
        gAI.put("#(我养你)", "image_emoticon117");
        gAI.put("#(我是不会骗你的)", "image_emoticon118");
        gAI.put("#(扎心了)", "image_emoticon119");
        gAI.put("#(无聊)", "image_emoticon120");
        gAI.put("#(月亮代表我的心)", "image_emoticon121");
        gAI.put("#(来追我呀)", "image_emoticon122");
        gAI.put("#(爱你的形状)", "image_emoticon123");
        gAI.put("#(白眼)", "image_emoticon124");
    }

    private static String yT(String str) {
        return gAI.get(str);
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
                    String yT = yT(str3);
                    if (TextUtils.isEmpty(yT)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.k(str5);
                            } else {
                                SpannableString aG = aG(context, str5);
                                if (aG != null) {
                                    tbRichTextData.k(aG);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.azf(), yT, str3);
                        if (a != null) {
                            tbRichTextData.k(a);
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
                    tbRichTextData.k(str5);
                } else {
                    SpannableString aG2 = aG(context, str5);
                    if (aG2 != null) {
                        tbRichTextData.k(aG2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int qq = TbFaceManager.atJ().qq(str);
        if (qq != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), qq);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0264a qN = TbFaceManager.atJ().qN(str);
            if (qN != null) {
                int width = (int) (0.5d * qN.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aG(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ba.ai(context, str);
    }
}
