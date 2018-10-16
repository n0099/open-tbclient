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
    private static final HashMap<String, String> eyT = new HashMap<>();

    static {
        eyT.put("#(呵呵)", "image_emoticon");
        eyT.put("#(哈哈)", "image_emoticon2");
        eyT.put("#(吐舌)", "image_emoticon3");
        eyT.put("#(啊)", "image_emoticon4");
        eyT.put("#(啊?)", "image_emoticon4");
        eyT.put("#(酷)", "image_emoticon5");
        eyT.put("#(怒)", "image_emoticon6");
        eyT.put("#(开心)", "image_emoticon7");
        eyT.put("#(汗)", "image_emoticon8");
        eyT.put("#(泪)", "image_emoticon9");
        eyT.put("#(黑线)", "image_emoticon10");
        eyT.put("#(鄙视)", "image_emoticon11");
        eyT.put("#(不高兴)", "image_emoticon12");
        eyT.put("#(真棒)", "image_emoticon13");
        eyT.put("#(钱)", "image_emoticon14");
        eyT.put("#(疑问)", "image_emoticon15");
        eyT.put("#(阴险)", "image_emoticon16");
        eyT.put("#(吐)", "image_emoticon17");
        eyT.put("#(咦)", "image_emoticon18");
        eyT.put("#(咦?)", "image_emoticon18");
        eyT.put("#(委屈)", "image_emoticon19");
        eyT.put("#(花心)", "image_emoticon20");
        eyT.put("#(呼~)", "image_emoticon21");
        eyT.put("#(笑眼)", "image_emoticon22");
        eyT.put("#(冷)", "image_emoticon23");
        eyT.put("#(太开心)", "image_emoticon24");
        eyT.put("#(滑稽)", "image_emoticon25");
        eyT.put("#(勉强)", "image_emoticon26");
        eyT.put("#(狂汗)", "image_emoticon27");
        eyT.put("#(乖)", "image_emoticon28");
        eyT.put("#(睡觉)", "image_emoticon29");
        eyT.put("#(惊哭)", "image_emoticon30");
        eyT.put("#(升起)", "image_emoticon31");
        eyT.put("#(惊讶)", "image_emoticon32");
        eyT.put("#(喷)", "image_emoticon33");
        eyT.put("#(爱心)", "image_emoticon34");
        eyT.put("#(心碎)", "image_emoticon35");
        eyT.put("#(玫瑰)", "image_emoticon36");
        eyT.put("#(礼物)", "image_emoticon37");
        eyT.put("#(彩虹)", "image_emoticon38");
        eyT.put("#(星星月亮)", "image_emoticon39");
        eyT.put("#(太阳)", "image_emoticon40");
        eyT.put("#(钱币)", "image_emoticon41");
        eyT.put("#(灯泡)", "image_emoticon42");
        eyT.put("#(茶杯)", "image_emoticon43");
        eyT.put("#(蛋糕)", "image_emoticon44");
        eyT.put("#(音乐)", "image_emoticon45");
        eyT.put("#(haha)", "image_emoticon46");
        eyT.put("#(胜利)", "image_emoticon47");
        eyT.put("#(大拇指)", "image_emoticon48");
        eyT.put("#(弱)", "image_emoticon49");
        eyT.put("#(OK)", "image_emoticon50");
        eyT.put("#(哼)", "image_emoticon61");
        eyT.put("#(吃瓜)", "image_emoticon62");
        eyT.put("#(扔便便)", "image_emoticon63");
        eyT.put("#(惊恐)", "image_emoticon64");
        eyT.put("#(哎呦)", "image_emoticon65");
        eyT.put("#(小乖)", "image_emoticon66");
        eyT.put("#(捂嘴笑)", "image_emoticon67");
        eyT.put("#(你懂的)", "image_emoticon68");
        eyT.put("#(what)", "image_emoticon69");
        eyT.put("#(酸爽)", "image_emoticon70");
        eyT.put("#(呀咩爹)", "image_emoticon71");
        eyT.put("#(笑尿)", "image_emoticon72");
        eyT.put("#(挖鼻)", "image_emoticon73");
        eyT.put("#(犀利)", "image_emoticon74");
        eyT.put("#(小红脸)", "image_emoticon75");
        eyT.put("#(懒得理)", "image_emoticon76");
        eyT.put("#(沙发)", "image_emoticon77");
        eyT.put("#(手纸)", "image_emoticon78");
        eyT.put("#(香蕉)", "image_emoticon79");
        eyT.put("#(便便)", "image_emoticon80");
        eyT.put("#(药丸)", "image_emoticon81");
        eyT.put("#(红领巾)", "image_emoticon82");
        eyT.put("#(蜡烛)", "image_emoticon83");
        eyT.put("#(三道杠)", "image_emoticon84");
        eyT.put("#(赖皮)", "ali_001");
        eyT.put("#(感动)", "ali_002");
        eyT.put("#(十分惊讶)", "ali_003");
        eyT.put("#(怒气)", "ali_004");
        eyT.put("#(哭泣)", "ali_005");
        eyT.put("#(吃惊)", "ali_006");
        eyT.put("#(嘲弄)", "ali_007");
        eyT.put("#(飘过)", "ali_008");
        eyT.put("#(转圈哭)", "ali_009");
        eyT.put("#(神经病)", "ali_010");
        eyT.put("#(揪耳朵)", "ali_011");
        eyT.put("#(惊汗)", "ali_012");
        eyT.put("#(隐身)", "ali_013");
        eyT.put("#(不要嘛)", "ali_014");
        eyT.put("#(遁)", "ali_015");
        eyT.put("#(不公平)", "ali_016");
        eyT.put("#(爬来了)", "ali_017");
        eyT.put("#(蛋花哭)", "ali_018");
        eyT.put("#(温暖)", "ali_019");
        eyT.put("#(点头)", "ali_020");
        eyT.put("#(撒钱)", "ali_021");
        eyT.put("#(献花)", "ali_022");
        eyT.put("#(寒)", "ali_023");
        eyT.put("#(傻笑)", "ali_024");
        eyT.put("#(扭扭)", "ali_025");
        eyT.put("#(疯)", "ali_026");
        eyT.put("#(抓狂)", "ali_027");
        eyT.put("#(抓)", "ali_028");
        eyT.put("#(蜷)", "ali_029");
        eyT.put("#(挠墙)", "ali_030");
        eyT.put("#(狂笑)", "ali_031");
        eyT.put("#(抱枕)", "ali_032");
        eyT.put("#(吼叫)", "ali_033");
        eyT.put("#(嚷)", "ali_034");
        eyT.put("#(唠叨)", "ali_035");
        eyT.put("#(捏脸)", "ali_036");
        eyT.put("#(爆笑)", "ali_037");
        eyT.put("#(郁闷)", "ali_038");
        eyT.put("#(潜水)", "ali_039");
        eyT.put("#(十分开心)", "ali_040");
        eyT.put("#(冷笑话)", "ali_041");
        eyT.put("#(顶！)", "ali_042");
        eyT.put("#(潜)", "ali_043");
        eyT.put("#(画圈圈)", "ali_044");
        eyT.put("#(玩电脑)", "ali_045");
        eyT.put("#(狂吐)", "ali_046");
        eyT.put("#(哭着跑)", "ali_047");
        eyT.put("#(阿狸侠)", "ali_048");
        eyT.put("#(冷死了)", "ali_049");
        eyT.put("#(惆怅~)", "ali_050");
        eyT.put("#(摸头)", "ali_051");
        eyT.put("#(蹭)", "ali_052");
        eyT.put("#(打滚)", "ali_053");
        eyT.put("#(叩拜)", "ali_054");
        eyT.put("#(摸)", "ali_055");
        eyT.put("#(数钱)", "ali_056");
        eyT.put("#(拖走)", "ali_057");
        eyT.put("#(热)", "ali_058");
        eyT.put("#(加1)", "ali_059");
        eyT.put("#(压力)", "ali_060");
        eyT.put("#(表逼我)", "ali_061");
        eyT.put("#(人呢)", "ali_062");
        eyT.put("#(摇晃)", "ali_063");
        eyT.put("#(打地鼠)", "ali_064");
        eyT.put("#(这个屌)", "ali_065");
        eyT.put("#(恐慌)", "ali_066");
        eyT.put("#(晕乎乎)", "ali_067");
        eyT.put("#(浮云)", "ali_068");
        eyT.put("#(给力)", "ali_069");
        eyT.put("#(杯具了)", "ali_070");
        eyT.put("#(焦糖舞)", "yz_001");
        eyT.put("#(翻滚)", "yz_002");
        eyT.put("#(拍屁股做鬼脸)", "yz_003");
        eyT.put("#(不)", "yz_004");
        eyT.put("#(河蟹掉啦)", "yz_005");
        eyT.put("#(哦耶)", "yz_006");
        eyT.put("#(我倒)", "yz_007");
        eyT.put("#(投降)", "yz_008");
        eyT.put("#(微笑)", "b01");
        eyT.put("#(帅哥)", "b02");
        eyT.put("#(美女)", "b03");
        eyT.put("#(老大)", "b04");
        eyT.put("#(哈哈哈)", "b05");
        eyT.put("#(奸笑)", "b06");
        eyT.put("#(傻乐)", "b07");
        eyT.put("#(飞吻)", "b08");
        eyT.put("#(害羞)", "b09");
        eyT.put("#(花痴)", "b10");
        eyT.put("#(憧憬)", "b11");
        eyT.put("#(你牛)", "b12");
        eyT.put("#(鼓掌)", "b13");
        eyT.put("#(可爱)", "b14");
        eyT.put("#(太委屈)", "b15");
        eyT.put("#(大哭)", "b16");
        eyT.put("#(泪奔)", "b17");
        eyT.put("#(寻死)", "b18");
        eyT.put("#(非常惊讶)", "b19");
        eyT.put("#(表示疑问)", "b20");
        eyT.put("#(暗中观察)", "image_emoticon85");
        eyT.put("#(吃瓜)", "image_emoticon86");
        eyT.put("#(喝酒)", "image_emoticon87");
        eyT.put("#(嘿嘿嘿)", "image_emoticon88");
        eyT.put("#(噗)", "image_emoticon89");
        eyT.put("#(困成狗)", "image_emoticon90");
        eyT.put("#(微微一笑)", "image_emoticon91");
        eyT.put("#(托腮)", "image_emoticon92");
        eyT.put("#(摊手)", "image_emoticon93");
        eyT.put("#(柯基暗中观察)", "image_emoticon94");
        eyT.put("#(欢呼)", "image_emoticon95");
        eyT.put("#(炸药)", "image_emoticon96");
        eyT.put("#(突然兴奋)", "image_emoticon97");
        eyT.put("#(紧张)", "image_emoticon98");
        eyT.put("#(黑头瞪眼)", "image_emoticon99");
        eyT.put("#(黑头高兴)", "image_emoticon100");
        eyT.put("#(不跟丑人说话)", "image_emoticon101");
        eyT.put("#(么么哒)", "image_emoticon102");
        eyT.put("#(亲亲才能起来)", "image_emoticon103");
        eyT.put("#(伦家只是宝宝)", "image_emoticon104");
        eyT.put("#(你是我的人)", "image_emoticon105");
        eyT.put("#(假装看不见)", "image_emoticon106");
        eyT.put("#(单身等撩)", "image_emoticon107");
        eyT.put("#(吓到宝宝了)", "image_emoticon108");
        eyT.put("#(哈哈哈)", "image_emoticon109");
        eyT.put("#(嗯嗯)", "image_emoticon110");
        eyT.put("#(好幸福)", "image_emoticon111");
        eyT.put("#(宝宝不开心)", "image_emoticon112");
        eyT.put("#(小姐姐别走)", "image_emoticon113");
        eyT.put("#(小姐姐在吗)", "image_emoticon114");
        eyT.put("#(小姐姐来啦)", "image_emoticon115");
        eyT.put("#(小姐姐来玩呀)", "image_emoticon116");
        eyT.put("#(我养你)", "image_emoticon117");
        eyT.put("#(我是不会骗你的)", "image_emoticon118");
        eyT.put("#(扎心了)", "image_emoticon119");
        eyT.put("#(无聊)", "image_emoticon120");
        eyT.put("#(月亮代表我的心)", "image_emoticon121");
        eyT.put("#(来追我呀)", "image_emoticon122");
        eyT.put("#(爱你的形状)", "image_emoticon123");
        eyT.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return eyT.get(str);
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
