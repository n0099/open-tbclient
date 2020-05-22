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
    private static final HashMap<String, String> irQ = new HashMap<>();

    static {
        irQ.put("#(呵呵)", "image_emoticon");
        irQ.put("#(哈哈)", "image_emoticon2");
        irQ.put("#(吐舌)", "image_emoticon3");
        irQ.put("#(啊)", "image_emoticon4");
        irQ.put("#(啊?)", "image_emoticon4");
        irQ.put("#(酷)", "image_emoticon5");
        irQ.put("#(怒)", "image_emoticon6");
        irQ.put("#(开心)", "image_emoticon7");
        irQ.put("#(汗)", "image_emoticon8");
        irQ.put("#(泪)", "image_emoticon9");
        irQ.put("#(黑线)", "image_emoticon10");
        irQ.put("#(鄙视)", "image_emoticon11");
        irQ.put("#(不高兴)", "image_emoticon12");
        irQ.put("#(真棒)", "image_emoticon13");
        irQ.put("#(钱)", "image_emoticon14");
        irQ.put("#(疑问)", "image_emoticon15");
        irQ.put("#(阴险)", "image_emoticon16");
        irQ.put("#(吐)", "image_emoticon17");
        irQ.put("#(咦)", "image_emoticon18");
        irQ.put("#(咦?)", "image_emoticon18");
        irQ.put("#(委屈)", "image_emoticon19");
        irQ.put("#(花心)", "image_emoticon20");
        irQ.put("#(呼~)", "image_emoticon21");
        irQ.put("#(笑眼)", "image_emoticon22");
        irQ.put("#(冷)", "image_emoticon23");
        irQ.put("#(太开心)", "image_emoticon24");
        irQ.put("#(滑稽)", "image_emoticon25");
        irQ.put("#(勉强)", "image_emoticon26");
        irQ.put("#(狂汗)", "image_emoticon27");
        irQ.put("#(乖)", "image_emoticon28");
        irQ.put("#(睡觉)", "image_emoticon29");
        irQ.put("#(惊哭)", "image_emoticon30");
        irQ.put("#(升起)", "image_emoticon31");
        irQ.put("#(惊讶)", "image_emoticon32");
        irQ.put("#(喷)", "image_emoticon33");
        irQ.put("#(爱心)", "image_emoticon34");
        irQ.put("#(心碎)", "image_emoticon35");
        irQ.put("#(玫瑰)", "image_emoticon36");
        irQ.put("#(礼物)", "image_emoticon37");
        irQ.put("#(彩虹)", "image_emoticon38");
        irQ.put("#(星星月亮)", "image_emoticon39");
        irQ.put("#(太阳)", "image_emoticon40");
        irQ.put("#(钱币)", "image_emoticon41");
        irQ.put("#(灯泡)", "image_emoticon42");
        irQ.put("#(茶杯)", "image_emoticon43");
        irQ.put("#(蛋糕)", "image_emoticon44");
        irQ.put("#(音乐)", "image_emoticon45");
        irQ.put("#(haha)", "image_emoticon46");
        irQ.put("#(胜利)", "image_emoticon47");
        irQ.put("#(大拇指)", "image_emoticon48");
        irQ.put("#(弱)", "image_emoticon49");
        irQ.put("#(OK)", "image_emoticon50");
        irQ.put("#(哼)", "image_emoticon61");
        irQ.put("#(吃瓜)", "image_emoticon62");
        irQ.put("#(扔便便)", "image_emoticon63");
        irQ.put("#(惊恐)", "image_emoticon64");
        irQ.put("#(哎呦)", "image_emoticon65");
        irQ.put("#(小乖)", "image_emoticon66");
        irQ.put("#(捂嘴笑)", "image_emoticon67");
        irQ.put("#(你懂的)", "image_emoticon68");
        irQ.put("#(what)", "image_emoticon69");
        irQ.put("#(酸爽)", "image_emoticon70");
        irQ.put("#(呀咩爹)", "image_emoticon71");
        irQ.put("#(笑尿)", "image_emoticon72");
        irQ.put("#(挖鼻)", "image_emoticon73");
        irQ.put("#(犀利)", "image_emoticon74");
        irQ.put("#(小红脸)", "image_emoticon75");
        irQ.put("#(懒得理)", "image_emoticon76");
        irQ.put("#(沙发)", "image_emoticon77");
        irQ.put("#(手纸)", "image_emoticon78");
        irQ.put("#(香蕉)", "image_emoticon79");
        irQ.put("#(便便)", "image_emoticon80");
        irQ.put("#(药丸)", "image_emoticon81");
        irQ.put("#(红领巾)", "image_emoticon82");
        irQ.put("#(蜡烛)", "image_emoticon83");
        irQ.put("#(三道杠)", "image_emoticon84");
        irQ.put("#(赖皮)", "ali_001");
        irQ.put("#(感动)", "ali_002");
        irQ.put("#(十分惊讶)", "ali_003");
        irQ.put("#(怒气)", "ali_004");
        irQ.put("#(哭泣)", "ali_005");
        irQ.put("#(吃惊)", "ali_006");
        irQ.put("#(嘲弄)", "ali_007");
        irQ.put("#(飘过)", "ali_008");
        irQ.put("#(转圈哭)", "ali_009");
        irQ.put("#(神经病)", "ali_010");
        irQ.put("#(揪耳朵)", "ali_011");
        irQ.put("#(惊汗)", "ali_012");
        irQ.put("#(隐身)", "ali_013");
        irQ.put("#(不要嘛)", "ali_014");
        irQ.put("#(遁)", "ali_015");
        irQ.put("#(不公平)", "ali_016");
        irQ.put("#(爬来了)", "ali_017");
        irQ.put("#(蛋花哭)", "ali_018");
        irQ.put("#(温暖)", "ali_019");
        irQ.put("#(点头)", "ali_020");
        irQ.put("#(撒钱)", "ali_021");
        irQ.put("#(献花)", "ali_022");
        irQ.put("#(寒)", "ali_023");
        irQ.put("#(傻笑)", "ali_024");
        irQ.put("#(扭扭)", "ali_025");
        irQ.put("#(疯)", "ali_026");
        irQ.put("#(抓狂)", "ali_027");
        irQ.put("#(抓)", "ali_028");
        irQ.put("#(蜷)", "ali_029");
        irQ.put("#(挠墙)", "ali_030");
        irQ.put("#(狂笑)", "ali_031");
        irQ.put("#(抱枕)", "ali_032");
        irQ.put("#(吼叫)", "ali_033");
        irQ.put("#(嚷)", "ali_034");
        irQ.put("#(唠叨)", "ali_035");
        irQ.put("#(捏脸)", "ali_036");
        irQ.put("#(爆笑)", "ali_037");
        irQ.put("#(郁闷)", "ali_038");
        irQ.put("#(潜水)", "ali_039");
        irQ.put("#(十分开心)", "ali_040");
        irQ.put("#(冷笑话)", "ali_041");
        irQ.put("#(顶！)", "ali_042");
        irQ.put("#(潜)", "ali_043");
        irQ.put("#(画圈圈)", "ali_044");
        irQ.put("#(玩电脑)", "ali_045");
        irQ.put("#(狂吐)", "ali_046");
        irQ.put("#(哭着跑)", "ali_047");
        irQ.put("#(阿狸侠)", "ali_048");
        irQ.put("#(冷死了)", "ali_049");
        irQ.put("#(惆怅~)", "ali_050");
        irQ.put("#(摸头)", "ali_051");
        irQ.put("#(蹭)", "ali_052");
        irQ.put("#(打滚)", "ali_053");
        irQ.put("#(叩拜)", "ali_054");
        irQ.put("#(摸)", "ali_055");
        irQ.put("#(数钱)", "ali_056");
        irQ.put("#(拖走)", "ali_057");
        irQ.put("#(热)", "ali_058");
        irQ.put("#(加1)", "ali_059");
        irQ.put("#(压力)", "ali_060");
        irQ.put("#(表逼我)", "ali_061");
        irQ.put("#(人呢)", "ali_062");
        irQ.put("#(摇晃)", "ali_063");
        irQ.put("#(打地鼠)", "ali_064");
        irQ.put("#(这个屌)", "ali_065");
        irQ.put("#(恐慌)", "ali_066");
        irQ.put("#(晕乎乎)", "ali_067");
        irQ.put("#(浮云)", "ali_068");
        irQ.put("#(给力)", "ali_069");
        irQ.put("#(杯具了)", "ali_070");
        irQ.put("#(焦糖舞)", "yz_001");
        irQ.put("#(翻滚)", "yz_002");
        irQ.put("#(拍屁股做鬼脸)", "yz_003");
        irQ.put("#(不)", "yz_004");
        irQ.put("#(河蟹掉啦)", "yz_005");
        irQ.put("#(哦耶)", "yz_006");
        irQ.put("#(我倒)", "yz_007");
        irQ.put("#(投降)", "yz_008");
        irQ.put("#(微笑)", "b01");
        irQ.put("#(帅哥)", "b02");
        irQ.put("#(美女)", "b03");
        irQ.put("#(老大)", "b04");
        irQ.put("#(哈哈哈)", "b05");
        irQ.put("#(奸笑)", "b06");
        irQ.put("#(傻乐)", "b07");
        irQ.put("#(飞吻)", "b08");
        irQ.put("#(害羞)", "b09");
        irQ.put("#(花痴)", "b10");
        irQ.put("#(憧憬)", "b11");
        irQ.put("#(你牛)", "b12");
        irQ.put("#(鼓掌)", "b13");
        irQ.put("#(可爱)", "b14");
        irQ.put("#(太委屈)", "b15");
        irQ.put("#(大哭)", "b16");
        irQ.put("#(泪奔)", "b17");
        irQ.put("#(寻死)", "b18");
        irQ.put("#(非常惊讶)", "b19");
        irQ.put("#(表示疑问)", "b20");
        irQ.put("#(暗中观察)", "image_emoticon85");
        irQ.put("#(吃瓜)", "image_emoticon86");
        irQ.put("#(喝酒)", "image_emoticon87");
        irQ.put("#(嘿嘿嘿)", "image_emoticon88");
        irQ.put("#(噗)", "image_emoticon89");
        irQ.put("#(困成狗)", "image_emoticon90");
        irQ.put("#(微微一笑)", "image_emoticon91");
        irQ.put("#(托腮)", "image_emoticon92");
        irQ.put("#(摊手)", "image_emoticon93");
        irQ.put("#(柯基暗中观察)", "image_emoticon94");
        irQ.put("#(欢呼)", "image_emoticon95");
        irQ.put("#(炸药)", "image_emoticon96");
        irQ.put("#(突然兴奋)", "image_emoticon97");
        irQ.put("#(紧张)", "image_emoticon98");
        irQ.put("#(黑头瞪眼)", "image_emoticon99");
        irQ.put("#(黑头高兴)", "image_emoticon100");
        irQ.put("#(不跟丑人说话)", "image_emoticon101");
        irQ.put("#(么么哒)", "image_emoticon102");
        irQ.put("#(亲亲才能起来)", "image_emoticon103");
        irQ.put("#(伦家只是宝宝)", "image_emoticon104");
        irQ.put("#(你是我的人)", "image_emoticon105");
        irQ.put("#(假装看不见)", "image_emoticon106");
        irQ.put("#(单身等撩)", "image_emoticon107");
        irQ.put("#(吓到宝宝了)", "image_emoticon108");
        irQ.put("#(哈哈哈)", "image_emoticon109");
        irQ.put("#(嗯嗯)", "image_emoticon110");
        irQ.put("#(好幸福)", "image_emoticon111");
        irQ.put("#(宝宝不开心)", "image_emoticon112");
        irQ.put("#(小姐姐别走)", "image_emoticon113");
        irQ.put("#(小姐姐在吗)", "image_emoticon114");
        irQ.put("#(小姐姐来啦)", "image_emoticon115");
        irQ.put("#(小姐姐来玩呀)", "image_emoticon116");
        irQ.put("#(我养你)", "image_emoticon117");
        irQ.put("#(我是不会骗你的)", "image_emoticon118");
        irQ.put("#(扎心了)", "image_emoticon119");
        irQ.put("#(无聊)", "image_emoticon120");
        irQ.put("#(月亮代表我的心)", "image_emoticon121");
        irQ.put("#(来追我呀)", "image_emoticon122");
        irQ.put("#(爱你的形状)", "image_emoticon123");
        irQ.put("#(白眼)", "image_emoticon124");
    }

    private static String FQ(String str) {
        return irQ.get(str);
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
                    String FQ = FQ(str3);
                    if (TextUtils.isEmpty(FQ)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.j(str5);
                            } else {
                                SpannableString aF = aF(context, str5);
                                if (aF != null) {
                                    tbRichTextData.j(aF);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.biv(), FQ, str3);
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
                    SpannableString aF2 = aF(context, str5);
                    if (aF2 != null) {
                        tbRichTextData.j(aF2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int xY = TbFaceManager.bes().xY(str);
        if (xY != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), xY);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0490a ys = TbFaceManager.bes().ys(str);
            if (ys != null) {
                int width = (int) (0.5d * ys.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aF(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ba.ai(context, str);
    }
}
