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
    private static final HashMap<String, String> grO = new HashMap<>();

    static {
        grO.put("#(呵呵)", "image_emoticon");
        grO.put("#(哈哈)", "image_emoticon2");
        grO.put("#(吐舌)", "image_emoticon3");
        grO.put("#(啊)", "image_emoticon4");
        grO.put("#(啊?)", "image_emoticon4");
        grO.put("#(酷)", "image_emoticon5");
        grO.put("#(怒)", "image_emoticon6");
        grO.put("#(开心)", "image_emoticon7");
        grO.put("#(汗)", "image_emoticon8");
        grO.put("#(泪)", "image_emoticon9");
        grO.put("#(黑线)", "image_emoticon10");
        grO.put("#(鄙视)", "image_emoticon11");
        grO.put("#(不高兴)", "image_emoticon12");
        grO.put("#(真棒)", "image_emoticon13");
        grO.put("#(钱)", "image_emoticon14");
        grO.put("#(疑问)", "image_emoticon15");
        grO.put("#(阴险)", "image_emoticon16");
        grO.put("#(吐)", "image_emoticon17");
        grO.put("#(咦)", "image_emoticon18");
        grO.put("#(咦?)", "image_emoticon18");
        grO.put("#(委屈)", "image_emoticon19");
        grO.put("#(花心)", "image_emoticon20");
        grO.put("#(呼~)", "image_emoticon21");
        grO.put("#(笑眼)", "image_emoticon22");
        grO.put("#(冷)", "image_emoticon23");
        grO.put("#(太开心)", "image_emoticon24");
        grO.put("#(滑稽)", "image_emoticon25");
        grO.put("#(勉强)", "image_emoticon26");
        grO.put("#(狂汗)", "image_emoticon27");
        grO.put("#(乖)", "image_emoticon28");
        grO.put("#(睡觉)", "image_emoticon29");
        grO.put("#(惊哭)", "image_emoticon30");
        grO.put("#(升起)", "image_emoticon31");
        grO.put("#(惊讶)", "image_emoticon32");
        grO.put("#(喷)", "image_emoticon33");
        grO.put("#(爱心)", "image_emoticon34");
        grO.put("#(心碎)", "image_emoticon35");
        grO.put("#(玫瑰)", "image_emoticon36");
        grO.put("#(礼物)", "image_emoticon37");
        grO.put("#(彩虹)", "image_emoticon38");
        grO.put("#(星星月亮)", "image_emoticon39");
        grO.put("#(太阳)", "image_emoticon40");
        grO.put("#(钱币)", "image_emoticon41");
        grO.put("#(灯泡)", "image_emoticon42");
        grO.put("#(茶杯)", "image_emoticon43");
        grO.put("#(蛋糕)", "image_emoticon44");
        grO.put("#(音乐)", "image_emoticon45");
        grO.put("#(haha)", "image_emoticon46");
        grO.put("#(胜利)", "image_emoticon47");
        grO.put("#(大拇指)", "image_emoticon48");
        grO.put("#(弱)", "image_emoticon49");
        grO.put("#(OK)", "image_emoticon50");
        grO.put("#(哼)", "image_emoticon61");
        grO.put("#(吃瓜)", "image_emoticon62");
        grO.put("#(扔便便)", "image_emoticon63");
        grO.put("#(惊恐)", "image_emoticon64");
        grO.put("#(哎呦)", "image_emoticon65");
        grO.put("#(小乖)", "image_emoticon66");
        grO.put("#(捂嘴笑)", "image_emoticon67");
        grO.put("#(你懂的)", "image_emoticon68");
        grO.put("#(what)", "image_emoticon69");
        grO.put("#(酸爽)", "image_emoticon70");
        grO.put("#(呀咩爹)", "image_emoticon71");
        grO.put("#(笑尿)", "image_emoticon72");
        grO.put("#(挖鼻)", "image_emoticon73");
        grO.put("#(犀利)", "image_emoticon74");
        grO.put("#(小红脸)", "image_emoticon75");
        grO.put("#(懒得理)", "image_emoticon76");
        grO.put("#(沙发)", "image_emoticon77");
        grO.put("#(手纸)", "image_emoticon78");
        grO.put("#(香蕉)", "image_emoticon79");
        grO.put("#(便便)", "image_emoticon80");
        grO.put("#(药丸)", "image_emoticon81");
        grO.put("#(红领巾)", "image_emoticon82");
        grO.put("#(蜡烛)", "image_emoticon83");
        grO.put("#(三道杠)", "image_emoticon84");
        grO.put("#(赖皮)", "ali_001");
        grO.put("#(感动)", "ali_002");
        grO.put("#(十分惊讶)", "ali_003");
        grO.put("#(怒气)", "ali_004");
        grO.put("#(哭泣)", "ali_005");
        grO.put("#(吃惊)", "ali_006");
        grO.put("#(嘲弄)", "ali_007");
        grO.put("#(飘过)", "ali_008");
        grO.put("#(转圈哭)", "ali_009");
        grO.put("#(神经病)", "ali_010");
        grO.put("#(揪耳朵)", "ali_011");
        grO.put("#(惊汗)", "ali_012");
        grO.put("#(隐身)", "ali_013");
        grO.put("#(不要嘛)", "ali_014");
        grO.put("#(遁)", "ali_015");
        grO.put("#(不公平)", "ali_016");
        grO.put("#(爬来了)", "ali_017");
        grO.put("#(蛋花哭)", "ali_018");
        grO.put("#(温暖)", "ali_019");
        grO.put("#(点头)", "ali_020");
        grO.put("#(撒钱)", "ali_021");
        grO.put("#(献花)", "ali_022");
        grO.put("#(寒)", "ali_023");
        grO.put("#(傻笑)", "ali_024");
        grO.put("#(扭扭)", "ali_025");
        grO.put("#(疯)", "ali_026");
        grO.put("#(抓狂)", "ali_027");
        grO.put("#(抓)", "ali_028");
        grO.put("#(蜷)", "ali_029");
        grO.put("#(挠墙)", "ali_030");
        grO.put("#(狂笑)", "ali_031");
        grO.put("#(抱枕)", "ali_032");
        grO.put("#(吼叫)", "ali_033");
        grO.put("#(嚷)", "ali_034");
        grO.put("#(唠叨)", "ali_035");
        grO.put("#(捏脸)", "ali_036");
        grO.put("#(爆笑)", "ali_037");
        grO.put("#(郁闷)", "ali_038");
        grO.put("#(潜水)", "ali_039");
        grO.put("#(十分开心)", "ali_040");
        grO.put("#(冷笑话)", "ali_041");
        grO.put("#(顶！)", "ali_042");
        grO.put("#(潜)", "ali_043");
        grO.put("#(画圈圈)", "ali_044");
        grO.put("#(玩电脑)", "ali_045");
        grO.put("#(狂吐)", "ali_046");
        grO.put("#(哭着跑)", "ali_047");
        grO.put("#(阿狸侠)", "ali_048");
        grO.put("#(冷死了)", "ali_049");
        grO.put("#(惆怅~)", "ali_050");
        grO.put("#(摸头)", "ali_051");
        grO.put("#(蹭)", "ali_052");
        grO.put("#(打滚)", "ali_053");
        grO.put("#(叩拜)", "ali_054");
        grO.put("#(摸)", "ali_055");
        grO.put("#(数钱)", "ali_056");
        grO.put("#(拖走)", "ali_057");
        grO.put("#(热)", "ali_058");
        grO.put("#(加1)", "ali_059");
        grO.put("#(压力)", "ali_060");
        grO.put("#(表逼我)", "ali_061");
        grO.put("#(人呢)", "ali_062");
        grO.put("#(摇晃)", "ali_063");
        grO.put("#(打地鼠)", "ali_064");
        grO.put("#(这个屌)", "ali_065");
        grO.put("#(恐慌)", "ali_066");
        grO.put("#(晕乎乎)", "ali_067");
        grO.put("#(浮云)", "ali_068");
        grO.put("#(给力)", "ali_069");
        grO.put("#(杯具了)", "ali_070");
        grO.put("#(焦糖舞)", "yz_001");
        grO.put("#(翻滚)", "yz_002");
        grO.put("#(拍屁股做鬼脸)", "yz_003");
        grO.put("#(不)", "yz_004");
        grO.put("#(河蟹掉啦)", "yz_005");
        grO.put("#(哦耶)", "yz_006");
        grO.put("#(我倒)", "yz_007");
        grO.put("#(投降)", "yz_008");
        grO.put("#(微笑)", "b01");
        grO.put("#(帅哥)", "b02");
        grO.put("#(美女)", "b03");
        grO.put("#(老大)", "b04");
        grO.put("#(哈哈哈)", "b05");
        grO.put("#(奸笑)", "b06");
        grO.put("#(傻乐)", "b07");
        grO.put("#(飞吻)", "b08");
        grO.put("#(害羞)", "b09");
        grO.put("#(花痴)", "b10");
        grO.put("#(憧憬)", "b11");
        grO.put("#(你牛)", "b12");
        grO.put("#(鼓掌)", "b13");
        grO.put("#(可爱)", "b14");
        grO.put("#(太委屈)", "b15");
        grO.put("#(大哭)", "b16");
        grO.put("#(泪奔)", "b17");
        grO.put("#(寻死)", "b18");
        grO.put("#(非常惊讶)", "b19");
        grO.put("#(表示疑问)", "b20");
        grO.put("#(暗中观察)", "image_emoticon85");
        grO.put("#(吃瓜)", "image_emoticon86");
        grO.put("#(喝酒)", "image_emoticon87");
        grO.put("#(嘿嘿嘿)", "image_emoticon88");
        grO.put("#(噗)", "image_emoticon89");
        grO.put("#(困成狗)", "image_emoticon90");
        grO.put("#(微微一笑)", "image_emoticon91");
        grO.put("#(托腮)", "image_emoticon92");
        grO.put("#(摊手)", "image_emoticon93");
        grO.put("#(柯基暗中观察)", "image_emoticon94");
        grO.put("#(欢呼)", "image_emoticon95");
        grO.put("#(炸药)", "image_emoticon96");
        grO.put("#(突然兴奋)", "image_emoticon97");
        grO.put("#(紧张)", "image_emoticon98");
        grO.put("#(黑头瞪眼)", "image_emoticon99");
        grO.put("#(黑头高兴)", "image_emoticon100");
        grO.put("#(不跟丑人说话)", "image_emoticon101");
        grO.put("#(么么哒)", "image_emoticon102");
        grO.put("#(亲亲才能起来)", "image_emoticon103");
        grO.put("#(伦家只是宝宝)", "image_emoticon104");
        grO.put("#(你是我的人)", "image_emoticon105");
        grO.put("#(假装看不见)", "image_emoticon106");
        grO.put("#(单身等撩)", "image_emoticon107");
        grO.put("#(吓到宝宝了)", "image_emoticon108");
        grO.put("#(哈哈哈)", "image_emoticon109");
        grO.put("#(嗯嗯)", "image_emoticon110");
        grO.put("#(好幸福)", "image_emoticon111");
        grO.put("#(宝宝不开心)", "image_emoticon112");
        grO.put("#(小姐姐别走)", "image_emoticon113");
        grO.put("#(小姐姐在吗)", "image_emoticon114");
        grO.put("#(小姐姐来啦)", "image_emoticon115");
        grO.put("#(小姐姐来玩呀)", "image_emoticon116");
        grO.put("#(我养你)", "image_emoticon117");
        grO.put("#(我是不会骗你的)", "image_emoticon118");
        grO.put("#(扎心了)", "image_emoticon119");
        grO.put("#(无聊)", "image_emoticon120");
        grO.put("#(月亮代表我的心)", "image_emoticon121");
        grO.put("#(来追我呀)", "image_emoticon122");
        grO.put("#(爱你的形状)", "image_emoticon123");
        grO.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return grO.get(str);
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
                                SpannableString ay = ay(context, str5);
                                if (ay != null) {
                                    tbRichTextData.append(ay);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.axF(), name, str3);
                        if (a != null) {
                            tbRichTextData.append(a);
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
                    SpannableString ay2 = ay(context, str5);
                    if (ay2 != null) {
                        tbRichTextData.append(ay2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int pO = TbFaceManager.aso().pO(str);
        if (pO != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), pO);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0253a ql = TbFaceManager.aso().ql(str);
            if (ql != null) {
                int width = (int) (0.5d * ql.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString ay(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ba.aj(context, str);
    }
}
