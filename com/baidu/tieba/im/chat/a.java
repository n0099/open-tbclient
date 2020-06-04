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
    private static final HashMap<String, String> isD = new HashMap<>();

    static {
        isD.put("#(呵呵)", "image_emoticon");
        isD.put("#(哈哈)", "image_emoticon2");
        isD.put("#(吐舌)", "image_emoticon3");
        isD.put("#(啊)", "image_emoticon4");
        isD.put("#(啊?)", "image_emoticon4");
        isD.put("#(酷)", "image_emoticon5");
        isD.put("#(怒)", "image_emoticon6");
        isD.put("#(开心)", "image_emoticon7");
        isD.put("#(汗)", "image_emoticon8");
        isD.put("#(泪)", "image_emoticon9");
        isD.put("#(黑线)", "image_emoticon10");
        isD.put("#(鄙视)", "image_emoticon11");
        isD.put("#(不高兴)", "image_emoticon12");
        isD.put("#(真棒)", "image_emoticon13");
        isD.put("#(钱)", "image_emoticon14");
        isD.put("#(疑问)", "image_emoticon15");
        isD.put("#(阴险)", "image_emoticon16");
        isD.put("#(吐)", "image_emoticon17");
        isD.put("#(咦)", "image_emoticon18");
        isD.put("#(咦?)", "image_emoticon18");
        isD.put("#(委屈)", "image_emoticon19");
        isD.put("#(花心)", "image_emoticon20");
        isD.put("#(呼~)", "image_emoticon21");
        isD.put("#(笑眼)", "image_emoticon22");
        isD.put("#(冷)", "image_emoticon23");
        isD.put("#(太开心)", "image_emoticon24");
        isD.put("#(滑稽)", "image_emoticon25");
        isD.put("#(勉强)", "image_emoticon26");
        isD.put("#(狂汗)", "image_emoticon27");
        isD.put("#(乖)", "image_emoticon28");
        isD.put("#(睡觉)", "image_emoticon29");
        isD.put("#(惊哭)", "image_emoticon30");
        isD.put("#(升起)", "image_emoticon31");
        isD.put("#(惊讶)", "image_emoticon32");
        isD.put("#(喷)", "image_emoticon33");
        isD.put("#(爱心)", "image_emoticon34");
        isD.put("#(心碎)", "image_emoticon35");
        isD.put("#(玫瑰)", "image_emoticon36");
        isD.put("#(礼物)", "image_emoticon37");
        isD.put("#(彩虹)", "image_emoticon38");
        isD.put("#(星星月亮)", "image_emoticon39");
        isD.put("#(太阳)", "image_emoticon40");
        isD.put("#(钱币)", "image_emoticon41");
        isD.put("#(灯泡)", "image_emoticon42");
        isD.put("#(茶杯)", "image_emoticon43");
        isD.put("#(蛋糕)", "image_emoticon44");
        isD.put("#(音乐)", "image_emoticon45");
        isD.put("#(haha)", "image_emoticon46");
        isD.put("#(胜利)", "image_emoticon47");
        isD.put("#(大拇指)", "image_emoticon48");
        isD.put("#(弱)", "image_emoticon49");
        isD.put("#(OK)", "image_emoticon50");
        isD.put("#(哼)", "image_emoticon61");
        isD.put("#(吃瓜)", "image_emoticon62");
        isD.put("#(扔便便)", "image_emoticon63");
        isD.put("#(惊恐)", "image_emoticon64");
        isD.put("#(哎呦)", "image_emoticon65");
        isD.put("#(小乖)", "image_emoticon66");
        isD.put("#(捂嘴笑)", "image_emoticon67");
        isD.put("#(你懂的)", "image_emoticon68");
        isD.put("#(what)", "image_emoticon69");
        isD.put("#(酸爽)", "image_emoticon70");
        isD.put("#(呀咩爹)", "image_emoticon71");
        isD.put("#(笑尿)", "image_emoticon72");
        isD.put("#(挖鼻)", "image_emoticon73");
        isD.put("#(犀利)", "image_emoticon74");
        isD.put("#(小红脸)", "image_emoticon75");
        isD.put("#(懒得理)", "image_emoticon76");
        isD.put("#(沙发)", "image_emoticon77");
        isD.put("#(手纸)", "image_emoticon78");
        isD.put("#(香蕉)", "image_emoticon79");
        isD.put("#(便便)", "image_emoticon80");
        isD.put("#(药丸)", "image_emoticon81");
        isD.put("#(红领巾)", "image_emoticon82");
        isD.put("#(蜡烛)", "image_emoticon83");
        isD.put("#(三道杠)", "image_emoticon84");
        isD.put("#(赖皮)", "ali_001");
        isD.put("#(感动)", "ali_002");
        isD.put("#(十分惊讶)", "ali_003");
        isD.put("#(怒气)", "ali_004");
        isD.put("#(哭泣)", "ali_005");
        isD.put("#(吃惊)", "ali_006");
        isD.put("#(嘲弄)", "ali_007");
        isD.put("#(飘过)", "ali_008");
        isD.put("#(转圈哭)", "ali_009");
        isD.put("#(神经病)", "ali_010");
        isD.put("#(揪耳朵)", "ali_011");
        isD.put("#(惊汗)", "ali_012");
        isD.put("#(隐身)", "ali_013");
        isD.put("#(不要嘛)", "ali_014");
        isD.put("#(遁)", "ali_015");
        isD.put("#(不公平)", "ali_016");
        isD.put("#(爬来了)", "ali_017");
        isD.put("#(蛋花哭)", "ali_018");
        isD.put("#(温暖)", "ali_019");
        isD.put("#(点头)", "ali_020");
        isD.put("#(撒钱)", "ali_021");
        isD.put("#(献花)", "ali_022");
        isD.put("#(寒)", "ali_023");
        isD.put("#(傻笑)", "ali_024");
        isD.put("#(扭扭)", "ali_025");
        isD.put("#(疯)", "ali_026");
        isD.put("#(抓狂)", "ali_027");
        isD.put("#(抓)", "ali_028");
        isD.put("#(蜷)", "ali_029");
        isD.put("#(挠墙)", "ali_030");
        isD.put("#(狂笑)", "ali_031");
        isD.put("#(抱枕)", "ali_032");
        isD.put("#(吼叫)", "ali_033");
        isD.put("#(嚷)", "ali_034");
        isD.put("#(唠叨)", "ali_035");
        isD.put("#(捏脸)", "ali_036");
        isD.put("#(爆笑)", "ali_037");
        isD.put("#(郁闷)", "ali_038");
        isD.put("#(潜水)", "ali_039");
        isD.put("#(十分开心)", "ali_040");
        isD.put("#(冷笑话)", "ali_041");
        isD.put("#(顶！)", "ali_042");
        isD.put("#(潜)", "ali_043");
        isD.put("#(画圈圈)", "ali_044");
        isD.put("#(玩电脑)", "ali_045");
        isD.put("#(狂吐)", "ali_046");
        isD.put("#(哭着跑)", "ali_047");
        isD.put("#(阿狸侠)", "ali_048");
        isD.put("#(冷死了)", "ali_049");
        isD.put("#(惆怅~)", "ali_050");
        isD.put("#(摸头)", "ali_051");
        isD.put("#(蹭)", "ali_052");
        isD.put("#(打滚)", "ali_053");
        isD.put("#(叩拜)", "ali_054");
        isD.put("#(摸)", "ali_055");
        isD.put("#(数钱)", "ali_056");
        isD.put("#(拖走)", "ali_057");
        isD.put("#(热)", "ali_058");
        isD.put("#(加1)", "ali_059");
        isD.put("#(压力)", "ali_060");
        isD.put("#(表逼我)", "ali_061");
        isD.put("#(人呢)", "ali_062");
        isD.put("#(摇晃)", "ali_063");
        isD.put("#(打地鼠)", "ali_064");
        isD.put("#(这个屌)", "ali_065");
        isD.put("#(恐慌)", "ali_066");
        isD.put("#(晕乎乎)", "ali_067");
        isD.put("#(浮云)", "ali_068");
        isD.put("#(给力)", "ali_069");
        isD.put("#(杯具了)", "ali_070");
        isD.put("#(焦糖舞)", "yz_001");
        isD.put("#(翻滚)", "yz_002");
        isD.put("#(拍屁股做鬼脸)", "yz_003");
        isD.put("#(不)", "yz_004");
        isD.put("#(河蟹掉啦)", "yz_005");
        isD.put("#(哦耶)", "yz_006");
        isD.put("#(我倒)", "yz_007");
        isD.put("#(投降)", "yz_008");
        isD.put("#(微笑)", "b01");
        isD.put("#(帅哥)", "b02");
        isD.put("#(美女)", "b03");
        isD.put("#(老大)", "b04");
        isD.put("#(哈哈哈)", "b05");
        isD.put("#(奸笑)", "b06");
        isD.put("#(傻乐)", "b07");
        isD.put("#(飞吻)", "b08");
        isD.put("#(害羞)", "b09");
        isD.put("#(花痴)", "b10");
        isD.put("#(憧憬)", "b11");
        isD.put("#(你牛)", "b12");
        isD.put("#(鼓掌)", "b13");
        isD.put("#(可爱)", "b14");
        isD.put("#(太委屈)", "b15");
        isD.put("#(大哭)", "b16");
        isD.put("#(泪奔)", "b17");
        isD.put("#(寻死)", "b18");
        isD.put("#(非常惊讶)", "b19");
        isD.put("#(表示疑问)", "b20");
        isD.put("#(暗中观察)", "image_emoticon85");
        isD.put("#(吃瓜)", "image_emoticon86");
        isD.put("#(喝酒)", "image_emoticon87");
        isD.put("#(嘿嘿嘿)", "image_emoticon88");
        isD.put("#(噗)", "image_emoticon89");
        isD.put("#(困成狗)", "image_emoticon90");
        isD.put("#(微微一笑)", "image_emoticon91");
        isD.put("#(托腮)", "image_emoticon92");
        isD.put("#(摊手)", "image_emoticon93");
        isD.put("#(柯基暗中观察)", "image_emoticon94");
        isD.put("#(欢呼)", "image_emoticon95");
        isD.put("#(炸药)", "image_emoticon96");
        isD.put("#(突然兴奋)", "image_emoticon97");
        isD.put("#(紧张)", "image_emoticon98");
        isD.put("#(黑头瞪眼)", "image_emoticon99");
        isD.put("#(黑头高兴)", "image_emoticon100");
        isD.put("#(不跟丑人说话)", "image_emoticon101");
        isD.put("#(么么哒)", "image_emoticon102");
        isD.put("#(亲亲才能起来)", "image_emoticon103");
        isD.put("#(伦家只是宝宝)", "image_emoticon104");
        isD.put("#(你是我的人)", "image_emoticon105");
        isD.put("#(假装看不见)", "image_emoticon106");
        isD.put("#(单身等撩)", "image_emoticon107");
        isD.put("#(吓到宝宝了)", "image_emoticon108");
        isD.put("#(哈哈哈)", "image_emoticon109");
        isD.put("#(嗯嗯)", "image_emoticon110");
        isD.put("#(好幸福)", "image_emoticon111");
        isD.put("#(宝宝不开心)", "image_emoticon112");
        isD.put("#(小姐姐别走)", "image_emoticon113");
        isD.put("#(小姐姐在吗)", "image_emoticon114");
        isD.put("#(小姐姐来啦)", "image_emoticon115");
        isD.put("#(小姐姐来玩呀)", "image_emoticon116");
        isD.put("#(我养你)", "image_emoticon117");
        isD.put("#(我是不会骗你的)", "image_emoticon118");
        isD.put("#(扎心了)", "image_emoticon119");
        isD.put("#(无聊)", "image_emoticon120");
        isD.put("#(月亮代表我的心)", "image_emoticon121");
        isD.put("#(来追我呀)", "image_emoticon122");
        isD.put("#(爱你的形状)", "image_emoticon123");
        isD.put("#(白眼)", "image_emoticon124");
    }

    private static String FQ(String str) {
        return isD.get(str);
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
                        SpannableString a = a(tbRichTextData.bix(), FQ, str3);
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
        int xY = TbFaceManager.bet().xY(str);
        if (xY != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), xY);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0490a ys = TbFaceManager.bet().ys(str);
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
