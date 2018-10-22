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
    private static final HashMap<String, String> eyU = new HashMap<>();

    static {
        eyU.put("#(呵呵)", "image_emoticon");
        eyU.put("#(哈哈)", "image_emoticon2");
        eyU.put("#(吐舌)", "image_emoticon3");
        eyU.put("#(啊)", "image_emoticon4");
        eyU.put("#(啊?)", "image_emoticon4");
        eyU.put("#(酷)", "image_emoticon5");
        eyU.put("#(怒)", "image_emoticon6");
        eyU.put("#(开心)", "image_emoticon7");
        eyU.put("#(汗)", "image_emoticon8");
        eyU.put("#(泪)", "image_emoticon9");
        eyU.put("#(黑线)", "image_emoticon10");
        eyU.put("#(鄙视)", "image_emoticon11");
        eyU.put("#(不高兴)", "image_emoticon12");
        eyU.put("#(真棒)", "image_emoticon13");
        eyU.put("#(钱)", "image_emoticon14");
        eyU.put("#(疑问)", "image_emoticon15");
        eyU.put("#(阴险)", "image_emoticon16");
        eyU.put("#(吐)", "image_emoticon17");
        eyU.put("#(咦)", "image_emoticon18");
        eyU.put("#(咦?)", "image_emoticon18");
        eyU.put("#(委屈)", "image_emoticon19");
        eyU.put("#(花心)", "image_emoticon20");
        eyU.put("#(呼~)", "image_emoticon21");
        eyU.put("#(笑眼)", "image_emoticon22");
        eyU.put("#(冷)", "image_emoticon23");
        eyU.put("#(太开心)", "image_emoticon24");
        eyU.put("#(滑稽)", "image_emoticon25");
        eyU.put("#(勉强)", "image_emoticon26");
        eyU.put("#(狂汗)", "image_emoticon27");
        eyU.put("#(乖)", "image_emoticon28");
        eyU.put("#(睡觉)", "image_emoticon29");
        eyU.put("#(惊哭)", "image_emoticon30");
        eyU.put("#(升起)", "image_emoticon31");
        eyU.put("#(惊讶)", "image_emoticon32");
        eyU.put("#(喷)", "image_emoticon33");
        eyU.put("#(爱心)", "image_emoticon34");
        eyU.put("#(心碎)", "image_emoticon35");
        eyU.put("#(玫瑰)", "image_emoticon36");
        eyU.put("#(礼物)", "image_emoticon37");
        eyU.put("#(彩虹)", "image_emoticon38");
        eyU.put("#(星星月亮)", "image_emoticon39");
        eyU.put("#(太阳)", "image_emoticon40");
        eyU.put("#(钱币)", "image_emoticon41");
        eyU.put("#(灯泡)", "image_emoticon42");
        eyU.put("#(茶杯)", "image_emoticon43");
        eyU.put("#(蛋糕)", "image_emoticon44");
        eyU.put("#(音乐)", "image_emoticon45");
        eyU.put("#(haha)", "image_emoticon46");
        eyU.put("#(胜利)", "image_emoticon47");
        eyU.put("#(大拇指)", "image_emoticon48");
        eyU.put("#(弱)", "image_emoticon49");
        eyU.put("#(OK)", "image_emoticon50");
        eyU.put("#(哼)", "image_emoticon61");
        eyU.put("#(吃瓜)", "image_emoticon62");
        eyU.put("#(扔便便)", "image_emoticon63");
        eyU.put("#(惊恐)", "image_emoticon64");
        eyU.put("#(哎呦)", "image_emoticon65");
        eyU.put("#(小乖)", "image_emoticon66");
        eyU.put("#(捂嘴笑)", "image_emoticon67");
        eyU.put("#(你懂的)", "image_emoticon68");
        eyU.put("#(what)", "image_emoticon69");
        eyU.put("#(酸爽)", "image_emoticon70");
        eyU.put("#(呀咩爹)", "image_emoticon71");
        eyU.put("#(笑尿)", "image_emoticon72");
        eyU.put("#(挖鼻)", "image_emoticon73");
        eyU.put("#(犀利)", "image_emoticon74");
        eyU.put("#(小红脸)", "image_emoticon75");
        eyU.put("#(懒得理)", "image_emoticon76");
        eyU.put("#(沙发)", "image_emoticon77");
        eyU.put("#(手纸)", "image_emoticon78");
        eyU.put("#(香蕉)", "image_emoticon79");
        eyU.put("#(便便)", "image_emoticon80");
        eyU.put("#(药丸)", "image_emoticon81");
        eyU.put("#(红领巾)", "image_emoticon82");
        eyU.put("#(蜡烛)", "image_emoticon83");
        eyU.put("#(三道杠)", "image_emoticon84");
        eyU.put("#(赖皮)", "ali_001");
        eyU.put("#(感动)", "ali_002");
        eyU.put("#(十分惊讶)", "ali_003");
        eyU.put("#(怒气)", "ali_004");
        eyU.put("#(哭泣)", "ali_005");
        eyU.put("#(吃惊)", "ali_006");
        eyU.put("#(嘲弄)", "ali_007");
        eyU.put("#(飘过)", "ali_008");
        eyU.put("#(转圈哭)", "ali_009");
        eyU.put("#(神经病)", "ali_010");
        eyU.put("#(揪耳朵)", "ali_011");
        eyU.put("#(惊汗)", "ali_012");
        eyU.put("#(隐身)", "ali_013");
        eyU.put("#(不要嘛)", "ali_014");
        eyU.put("#(遁)", "ali_015");
        eyU.put("#(不公平)", "ali_016");
        eyU.put("#(爬来了)", "ali_017");
        eyU.put("#(蛋花哭)", "ali_018");
        eyU.put("#(温暖)", "ali_019");
        eyU.put("#(点头)", "ali_020");
        eyU.put("#(撒钱)", "ali_021");
        eyU.put("#(献花)", "ali_022");
        eyU.put("#(寒)", "ali_023");
        eyU.put("#(傻笑)", "ali_024");
        eyU.put("#(扭扭)", "ali_025");
        eyU.put("#(疯)", "ali_026");
        eyU.put("#(抓狂)", "ali_027");
        eyU.put("#(抓)", "ali_028");
        eyU.put("#(蜷)", "ali_029");
        eyU.put("#(挠墙)", "ali_030");
        eyU.put("#(狂笑)", "ali_031");
        eyU.put("#(抱枕)", "ali_032");
        eyU.put("#(吼叫)", "ali_033");
        eyU.put("#(嚷)", "ali_034");
        eyU.put("#(唠叨)", "ali_035");
        eyU.put("#(捏脸)", "ali_036");
        eyU.put("#(爆笑)", "ali_037");
        eyU.put("#(郁闷)", "ali_038");
        eyU.put("#(潜水)", "ali_039");
        eyU.put("#(十分开心)", "ali_040");
        eyU.put("#(冷笑话)", "ali_041");
        eyU.put("#(顶！)", "ali_042");
        eyU.put("#(潜)", "ali_043");
        eyU.put("#(画圈圈)", "ali_044");
        eyU.put("#(玩电脑)", "ali_045");
        eyU.put("#(狂吐)", "ali_046");
        eyU.put("#(哭着跑)", "ali_047");
        eyU.put("#(阿狸侠)", "ali_048");
        eyU.put("#(冷死了)", "ali_049");
        eyU.put("#(惆怅~)", "ali_050");
        eyU.put("#(摸头)", "ali_051");
        eyU.put("#(蹭)", "ali_052");
        eyU.put("#(打滚)", "ali_053");
        eyU.put("#(叩拜)", "ali_054");
        eyU.put("#(摸)", "ali_055");
        eyU.put("#(数钱)", "ali_056");
        eyU.put("#(拖走)", "ali_057");
        eyU.put("#(热)", "ali_058");
        eyU.put("#(加1)", "ali_059");
        eyU.put("#(压力)", "ali_060");
        eyU.put("#(表逼我)", "ali_061");
        eyU.put("#(人呢)", "ali_062");
        eyU.put("#(摇晃)", "ali_063");
        eyU.put("#(打地鼠)", "ali_064");
        eyU.put("#(这个屌)", "ali_065");
        eyU.put("#(恐慌)", "ali_066");
        eyU.put("#(晕乎乎)", "ali_067");
        eyU.put("#(浮云)", "ali_068");
        eyU.put("#(给力)", "ali_069");
        eyU.put("#(杯具了)", "ali_070");
        eyU.put("#(焦糖舞)", "yz_001");
        eyU.put("#(翻滚)", "yz_002");
        eyU.put("#(拍屁股做鬼脸)", "yz_003");
        eyU.put("#(不)", "yz_004");
        eyU.put("#(河蟹掉啦)", "yz_005");
        eyU.put("#(哦耶)", "yz_006");
        eyU.put("#(我倒)", "yz_007");
        eyU.put("#(投降)", "yz_008");
        eyU.put("#(微笑)", "b01");
        eyU.put("#(帅哥)", "b02");
        eyU.put("#(美女)", "b03");
        eyU.put("#(老大)", "b04");
        eyU.put("#(哈哈哈)", "b05");
        eyU.put("#(奸笑)", "b06");
        eyU.put("#(傻乐)", "b07");
        eyU.put("#(飞吻)", "b08");
        eyU.put("#(害羞)", "b09");
        eyU.put("#(花痴)", "b10");
        eyU.put("#(憧憬)", "b11");
        eyU.put("#(你牛)", "b12");
        eyU.put("#(鼓掌)", "b13");
        eyU.put("#(可爱)", "b14");
        eyU.put("#(太委屈)", "b15");
        eyU.put("#(大哭)", "b16");
        eyU.put("#(泪奔)", "b17");
        eyU.put("#(寻死)", "b18");
        eyU.put("#(非常惊讶)", "b19");
        eyU.put("#(表示疑问)", "b20");
        eyU.put("#(暗中观察)", "image_emoticon85");
        eyU.put("#(吃瓜)", "image_emoticon86");
        eyU.put("#(喝酒)", "image_emoticon87");
        eyU.put("#(嘿嘿嘿)", "image_emoticon88");
        eyU.put("#(噗)", "image_emoticon89");
        eyU.put("#(困成狗)", "image_emoticon90");
        eyU.put("#(微微一笑)", "image_emoticon91");
        eyU.put("#(托腮)", "image_emoticon92");
        eyU.put("#(摊手)", "image_emoticon93");
        eyU.put("#(柯基暗中观察)", "image_emoticon94");
        eyU.put("#(欢呼)", "image_emoticon95");
        eyU.put("#(炸药)", "image_emoticon96");
        eyU.put("#(突然兴奋)", "image_emoticon97");
        eyU.put("#(紧张)", "image_emoticon98");
        eyU.put("#(黑头瞪眼)", "image_emoticon99");
        eyU.put("#(黑头高兴)", "image_emoticon100");
        eyU.put("#(不跟丑人说话)", "image_emoticon101");
        eyU.put("#(么么哒)", "image_emoticon102");
        eyU.put("#(亲亲才能起来)", "image_emoticon103");
        eyU.put("#(伦家只是宝宝)", "image_emoticon104");
        eyU.put("#(你是我的人)", "image_emoticon105");
        eyU.put("#(假装看不见)", "image_emoticon106");
        eyU.put("#(单身等撩)", "image_emoticon107");
        eyU.put("#(吓到宝宝了)", "image_emoticon108");
        eyU.put("#(哈哈哈)", "image_emoticon109");
        eyU.put("#(嗯嗯)", "image_emoticon110");
        eyU.put("#(好幸福)", "image_emoticon111");
        eyU.put("#(宝宝不开心)", "image_emoticon112");
        eyU.put("#(小姐姐别走)", "image_emoticon113");
        eyU.put("#(小姐姐在吗)", "image_emoticon114");
        eyU.put("#(小姐姐来啦)", "image_emoticon115");
        eyU.put("#(小姐姐来玩呀)", "image_emoticon116");
        eyU.put("#(我养你)", "image_emoticon117");
        eyU.put("#(我是不会骗你的)", "image_emoticon118");
        eyU.put("#(扎心了)", "image_emoticon119");
        eyU.put("#(无聊)", "image_emoticon120");
        eyU.put("#(月亮代表我的心)", "image_emoticon121");
        eyU.put("#(来追我呀)", "image_emoticon122");
        eyU.put("#(爱你的形状)", "image_emoticon123");
        eyU.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return eyU.get(str);
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
                                SpannableString ay = ay(context, str5);
                                if (ay != null) {
                                    tbRichTextData.append(ay);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.QP(), name, str3);
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

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int hk = TbFaceManager.Md().hk(str);
        if (hk != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), hk);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0137a hJ = TbFaceManager.Md().hJ(str);
            if (hJ != null) {
                int width = (int) (0.5d * hJ.getWidth());
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
        return ay.aj(context, str);
    }
}
