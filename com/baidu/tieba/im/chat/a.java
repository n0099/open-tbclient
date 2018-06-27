package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> efX = new HashMap<>();

    static {
        efX.put("#(呵呵)", "image_emoticon");
        efX.put("#(哈哈)", "image_emoticon2");
        efX.put("#(吐舌)", "image_emoticon3");
        efX.put("#(啊)", "image_emoticon4");
        efX.put("#(啊?)", "image_emoticon4");
        efX.put("#(酷)", "image_emoticon5");
        efX.put("#(怒)", "image_emoticon6");
        efX.put("#(开心)", "image_emoticon7");
        efX.put("#(汗)", "image_emoticon8");
        efX.put("#(泪)", "image_emoticon9");
        efX.put("#(黑线)", "image_emoticon10");
        efX.put("#(鄙视)", "image_emoticon11");
        efX.put("#(不高兴)", "image_emoticon12");
        efX.put("#(真棒)", "image_emoticon13");
        efX.put("#(钱)", "image_emoticon14");
        efX.put("#(疑问)", "image_emoticon15");
        efX.put("#(阴险)", "image_emoticon16");
        efX.put("#(吐)", "image_emoticon17");
        efX.put("#(咦)", "image_emoticon18");
        efX.put("#(咦?)", "image_emoticon18");
        efX.put("#(委屈)", "image_emoticon19");
        efX.put("#(花心)", "image_emoticon20");
        efX.put("#(呼~)", "image_emoticon21");
        efX.put("#(笑眼)", "image_emoticon22");
        efX.put("#(冷)", "image_emoticon23");
        efX.put("#(太开心)", "image_emoticon24");
        efX.put("#(滑稽)", "image_emoticon25");
        efX.put("#(勉强)", "image_emoticon26");
        efX.put("#(狂汗)", "image_emoticon27");
        efX.put("#(乖)", "image_emoticon28");
        efX.put("#(睡觉)", "image_emoticon29");
        efX.put("#(惊哭)", "image_emoticon30");
        efX.put("#(升起)", "image_emoticon31");
        efX.put("#(惊讶)", "image_emoticon32");
        efX.put("#(喷)", "image_emoticon33");
        efX.put("#(爱心)", "image_emoticon34");
        efX.put("#(心碎)", "image_emoticon35");
        efX.put("#(玫瑰)", "image_emoticon36");
        efX.put("#(礼物)", "image_emoticon37");
        efX.put("#(彩虹)", "image_emoticon38");
        efX.put("#(星星月亮)", "image_emoticon39");
        efX.put("#(太阳)", "image_emoticon40");
        efX.put("#(钱币)", "image_emoticon41");
        efX.put("#(灯泡)", "image_emoticon42");
        efX.put("#(茶杯)", "image_emoticon43");
        efX.put("#(蛋糕)", "image_emoticon44");
        efX.put("#(音乐)", "image_emoticon45");
        efX.put("#(haha)", "image_emoticon46");
        efX.put("#(胜利)", "image_emoticon47");
        efX.put("#(大拇指)", "image_emoticon48");
        efX.put("#(弱)", "image_emoticon49");
        efX.put("#(OK)", "image_emoticon50");
        efX.put("#(哼)", "image_emoticon61");
        efX.put("#(吃瓜)", "image_emoticon62");
        efX.put("#(扔便便)", "image_emoticon63");
        efX.put("#(惊恐)", "image_emoticon64");
        efX.put("#(哎呦)", "image_emoticon65");
        efX.put("#(小乖)", "image_emoticon66");
        efX.put("#(捂嘴笑)", "image_emoticon67");
        efX.put("#(你懂的)", "image_emoticon68");
        efX.put("#(what)", "image_emoticon69");
        efX.put("#(酸爽)", "image_emoticon70");
        efX.put("#(呀咩爹)", "image_emoticon71");
        efX.put("#(笑尿)", "image_emoticon72");
        efX.put("#(挖鼻)", "image_emoticon73");
        efX.put("#(犀利)", "image_emoticon74");
        efX.put("#(小红脸)", "image_emoticon75");
        efX.put("#(懒得理)", "image_emoticon76");
        efX.put("#(沙发)", "image_emoticon77");
        efX.put("#(手纸)", "image_emoticon78");
        efX.put("#(香蕉)", "image_emoticon79");
        efX.put("#(便便)", "image_emoticon80");
        efX.put("#(药丸)", "image_emoticon81");
        efX.put("#(红领巾)", "image_emoticon82");
        efX.put("#(蜡烛)", "image_emoticon83");
        efX.put("#(三道杠)", "image_emoticon84");
        efX.put("#(赖皮)", "ali_001");
        efX.put("#(感动)", "ali_002");
        efX.put("#(十分惊讶)", "ali_003");
        efX.put("#(怒气)", "ali_004");
        efX.put("#(哭泣)", "ali_005");
        efX.put("#(吃惊)", "ali_006");
        efX.put("#(嘲弄)", "ali_007");
        efX.put("#(飘过)", "ali_008");
        efX.put("#(转圈哭)", "ali_009");
        efX.put("#(神经病)", "ali_010");
        efX.put("#(揪耳朵)", "ali_011");
        efX.put("#(惊汗)", "ali_012");
        efX.put("#(隐身)", "ali_013");
        efX.put("#(不要嘛)", "ali_014");
        efX.put("#(遁)", "ali_015");
        efX.put("#(不公平)", "ali_016");
        efX.put("#(爬来了)", "ali_017");
        efX.put("#(蛋花哭)", "ali_018");
        efX.put("#(温暖)", "ali_019");
        efX.put("#(点头)", "ali_020");
        efX.put("#(撒钱)", "ali_021");
        efX.put("#(献花)", "ali_022");
        efX.put("#(寒)", "ali_023");
        efX.put("#(傻笑)", "ali_024");
        efX.put("#(扭扭)", "ali_025");
        efX.put("#(疯)", "ali_026");
        efX.put("#(抓狂)", "ali_027");
        efX.put("#(抓)", "ali_028");
        efX.put("#(蜷)", "ali_029");
        efX.put("#(挠墙)", "ali_030");
        efX.put("#(狂笑)", "ali_031");
        efX.put("#(抱枕)", "ali_032");
        efX.put("#(吼叫)", "ali_033");
        efX.put("#(嚷)", "ali_034");
        efX.put("#(唠叨)", "ali_035");
        efX.put("#(捏脸)", "ali_036");
        efX.put("#(爆笑)", "ali_037");
        efX.put("#(郁闷)", "ali_038");
        efX.put("#(潜水)", "ali_039");
        efX.put("#(十分开心)", "ali_040");
        efX.put("#(冷笑话)", "ali_041");
        efX.put("#(顶！)", "ali_042");
        efX.put("#(潜)", "ali_043");
        efX.put("#(画圈圈)", "ali_044");
        efX.put("#(玩电脑)", "ali_045");
        efX.put("#(狂吐)", "ali_046");
        efX.put("#(哭着跑)", "ali_047");
        efX.put("#(阿狸侠)", "ali_048");
        efX.put("#(冷死了)", "ali_049");
        efX.put("#(惆怅~)", "ali_050");
        efX.put("#(摸头)", "ali_051");
        efX.put("#(蹭)", "ali_052");
        efX.put("#(打滚)", "ali_053");
        efX.put("#(叩拜)", "ali_054");
        efX.put("#(摸)", "ali_055");
        efX.put("#(数钱)", "ali_056");
        efX.put("#(拖走)", "ali_057");
        efX.put("#(热)", "ali_058");
        efX.put("#(加1)", "ali_059");
        efX.put("#(压力)", "ali_060");
        efX.put("#(表逼我)", "ali_061");
        efX.put("#(人呢)", "ali_062");
        efX.put("#(摇晃)", "ali_063");
        efX.put("#(打地鼠)", "ali_064");
        efX.put("#(这个屌)", "ali_065");
        efX.put("#(恐慌)", "ali_066");
        efX.put("#(晕乎乎)", "ali_067");
        efX.put("#(浮云)", "ali_068");
        efX.put("#(给力)", "ali_069");
        efX.put("#(杯具了)", "ali_070");
        efX.put("#(焦糖舞)", "yz_001");
        efX.put("#(翻滚)", "yz_002");
        efX.put("#(拍屁股做鬼脸)", "yz_003");
        efX.put("#(不)", "yz_004");
        efX.put("#(河蟹掉啦)", "yz_005");
        efX.put("#(哦耶)", "yz_006");
        efX.put("#(我倒)", "yz_007");
        efX.put("#(投降)", "yz_008");
        efX.put("#(微笑)", "b01");
        efX.put("#(帅哥)", "b02");
        efX.put("#(美女)", "b03");
        efX.put("#(老大)", "b04");
        efX.put("#(哈哈哈)", "b05");
        efX.put("#(奸笑)", "b06");
        efX.put("#(傻乐)", "b07");
        efX.put("#(飞吻)", "b08");
        efX.put("#(害羞)", "b09");
        efX.put("#(花痴)", "b10");
        efX.put("#(憧憬)", "b11");
        efX.put("#(你牛)", "b12");
        efX.put("#(鼓掌)", "b13");
        efX.put("#(可爱)", "b14");
        efX.put("#(太委屈)", "b15");
        efX.put("#(大哭)", "b16");
        efX.put("#(泪奔)", "b17");
        efX.put("#(寻死)", "b18");
        efX.put("#(非常惊讶)", "b19");
        efX.put("#(表示疑问)", "b20");
        efX.put("#(暗中观察)", "image_emoticon85");
        efX.put("#(吃瓜)", "image_emoticon86");
        efX.put("#(喝酒)", "image_emoticon87");
        efX.put("#(嘿嘿嘿)", "image_emoticon88");
        efX.put("#(噗)", "image_emoticon89");
        efX.put("#(困成狗)", "image_emoticon90");
        efX.put("#(微微一笑)", "image_emoticon91");
        efX.put("#(托腮)", "image_emoticon92");
        efX.put("#(摊手)", "image_emoticon93");
        efX.put("#(柯基暗中观察)", "image_emoticon94");
        efX.put("#(欢呼)", "image_emoticon95");
        efX.put("#(炸药)", "image_emoticon96");
        efX.put("#(突然兴奋)", "image_emoticon97");
        efX.put("#(紧张)", "image_emoticon98");
        efX.put("#(黑头瞪眼)", "image_emoticon99");
        efX.put("#(黑头高兴)", "image_emoticon100");
        efX.put("#(不跟丑人说话)", "image_emoticon101");
        efX.put("#(么么哒)", "image_emoticon102");
        efX.put("#(亲亲才能起来)", "image_emoticon103");
        efX.put("#(伦家只是宝宝)", "image_emoticon104");
        efX.put("#(你是我的人)", "image_emoticon105");
        efX.put("#(假装看不见)", "image_emoticon106");
        efX.put("#(单身等撩)", "image_emoticon107");
        efX.put("#(吓到宝宝了)", "image_emoticon108");
        efX.put("#(哈哈哈)", "image_emoticon109");
        efX.put("#(嗯嗯)", "image_emoticon110");
        efX.put("#(好幸福)", "image_emoticon111");
        efX.put("#(宝宝不开心)", "image_emoticon112");
        efX.put("#(小姐姐别走)", "image_emoticon113");
        efX.put("#(小姐姐在吗)", "image_emoticon114");
        efX.put("#(小姐姐来啦)", "image_emoticon115");
        efX.put("#(小姐姐来玩呀)", "image_emoticon116");
        efX.put("#(我养你)", "image_emoticon117");
        efX.put("#(我是不会骗你的)", "image_emoticon118");
        efX.put("#(扎心了)", "image_emoticon119");
        efX.put("#(无聊)", "image_emoticon120");
        efX.put("#(月亮代表我的心)", "image_emoticon121");
        efX.put("#(来追我呀)", "image_emoticon122");
        efX.put("#(爱你的形状)", "image_emoticon123");
        efX.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return efX.get(str);
    }

    public static ArrayList<TbRichTextData> f(Context context, String str, int i) {
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
                                SpannableString af = af(context, str5);
                                if (af != null) {
                                    tbRichTextData.append(af);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.NE(), name, str3);
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
                    SpannableString af2 = af(context, str5);
                    if (af2 != null) {
                        tbRichTextData.append(af2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int gE = TbFaceManager.IU().gE(str);
        if (gE != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), gE);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0116a hd = TbFaceManager.IU().hd(str);
            if (hd != null) {
                int width = (int) (0.5d * hd.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString af(Context context, String str) {
        if (str == null) {
            return null;
        }
        return az.S(context, str);
    }
}
