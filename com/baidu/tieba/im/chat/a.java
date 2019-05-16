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
    private static final HashMap<String, String> grL = new HashMap<>();

    static {
        grL.put("#(呵呵)", "image_emoticon");
        grL.put("#(哈哈)", "image_emoticon2");
        grL.put("#(吐舌)", "image_emoticon3");
        grL.put("#(啊)", "image_emoticon4");
        grL.put("#(啊?)", "image_emoticon4");
        grL.put("#(酷)", "image_emoticon5");
        grL.put("#(怒)", "image_emoticon6");
        grL.put("#(开心)", "image_emoticon7");
        grL.put("#(汗)", "image_emoticon8");
        grL.put("#(泪)", "image_emoticon9");
        grL.put("#(黑线)", "image_emoticon10");
        grL.put("#(鄙视)", "image_emoticon11");
        grL.put("#(不高兴)", "image_emoticon12");
        grL.put("#(真棒)", "image_emoticon13");
        grL.put("#(钱)", "image_emoticon14");
        grL.put("#(疑问)", "image_emoticon15");
        grL.put("#(阴险)", "image_emoticon16");
        grL.put("#(吐)", "image_emoticon17");
        grL.put("#(咦)", "image_emoticon18");
        grL.put("#(咦?)", "image_emoticon18");
        grL.put("#(委屈)", "image_emoticon19");
        grL.put("#(花心)", "image_emoticon20");
        grL.put("#(呼~)", "image_emoticon21");
        grL.put("#(笑眼)", "image_emoticon22");
        grL.put("#(冷)", "image_emoticon23");
        grL.put("#(太开心)", "image_emoticon24");
        grL.put("#(滑稽)", "image_emoticon25");
        grL.put("#(勉强)", "image_emoticon26");
        grL.put("#(狂汗)", "image_emoticon27");
        grL.put("#(乖)", "image_emoticon28");
        grL.put("#(睡觉)", "image_emoticon29");
        grL.put("#(惊哭)", "image_emoticon30");
        grL.put("#(升起)", "image_emoticon31");
        grL.put("#(惊讶)", "image_emoticon32");
        grL.put("#(喷)", "image_emoticon33");
        grL.put("#(爱心)", "image_emoticon34");
        grL.put("#(心碎)", "image_emoticon35");
        grL.put("#(玫瑰)", "image_emoticon36");
        grL.put("#(礼物)", "image_emoticon37");
        grL.put("#(彩虹)", "image_emoticon38");
        grL.put("#(星星月亮)", "image_emoticon39");
        grL.put("#(太阳)", "image_emoticon40");
        grL.put("#(钱币)", "image_emoticon41");
        grL.put("#(灯泡)", "image_emoticon42");
        grL.put("#(茶杯)", "image_emoticon43");
        grL.put("#(蛋糕)", "image_emoticon44");
        grL.put("#(音乐)", "image_emoticon45");
        grL.put("#(haha)", "image_emoticon46");
        grL.put("#(胜利)", "image_emoticon47");
        grL.put("#(大拇指)", "image_emoticon48");
        grL.put("#(弱)", "image_emoticon49");
        grL.put("#(OK)", "image_emoticon50");
        grL.put("#(哼)", "image_emoticon61");
        grL.put("#(吃瓜)", "image_emoticon62");
        grL.put("#(扔便便)", "image_emoticon63");
        grL.put("#(惊恐)", "image_emoticon64");
        grL.put("#(哎呦)", "image_emoticon65");
        grL.put("#(小乖)", "image_emoticon66");
        grL.put("#(捂嘴笑)", "image_emoticon67");
        grL.put("#(你懂的)", "image_emoticon68");
        grL.put("#(what)", "image_emoticon69");
        grL.put("#(酸爽)", "image_emoticon70");
        grL.put("#(呀咩爹)", "image_emoticon71");
        grL.put("#(笑尿)", "image_emoticon72");
        grL.put("#(挖鼻)", "image_emoticon73");
        grL.put("#(犀利)", "image_emoticon74");
        grL.put("#(小红脸)", "image_emoticon75");
        grL.put("#(懒得理)", "image_emoticon76");
        grL.put("#(沙发)", "image_emoticon77");
        grL.put("#(手纸)", "image_emoticon78");
        grL.put("#(香蕉)", "image_emoticon79");
        grL.put("#(便便)", "image_emoticon80");
        grL.put("#(药丸)", "image_emoticon81");
        grL.put("#(红领巾)", "image_emoticon82");
        grL.put("#(蜡烛)", "image_emoticon83");
        grL.put("#(三道杠)", "image_emoticon84");
        grL.put("#(赖皮)", "ali_001");
        grL.put("#(感动)", "ali_002");
        grL.put("#(十分惊讶)", "ali_003");
        grL.put("#(怒气)", "ali_004");
        grL.put("#(哭泣)", "ali_005");
        grL.put("#(吃惊)", "ali_006");
        grL.put("#(嘲弄)", "ali_007");
        grL.put("#(飘过)", "ali_008");
        grL.put("#(转圈哭)", "ali_009");
        grL.put("#(神经病)", "ali_010");
        grL.put("#(揪耳朵)", "ali_011");
        grL.put("#(惊汗)", "ali_012");
        grL.put("#(隐身)", "ali_013");
        grL.put("#(不要嘛)", "ali_014");
        grL.put("#(遁)", "ali_015");
        grL.put("#(不公平)", "ali_016");
        grL.put("#(爬来了)", "ali_017");
        grL.put("#(蛋花哭)", "ali_018");
        grL.put("#(温暖)", "ali_019");
        grL.put("#(点头)", "ali_020");
        grL.put("#(撒钱)", "ali_021");
        grL.put("#(献花)", "ali_022");
        grL.put("#(寒)", "ali_023");
        grL.put("#(傻笑)", "ali_024");
        grL.put("#(扭扭)", "ali_025");
        grL.put("#(疯)", "ali_026");
        grL.put("#(抓狂)", "ali_027");
        grL.put("#(抓)", "ali_028");
        grL.put("#(蜷)", "ali_029");
        grL.put("#(挠墙)", "ali_030");
        grL.put("#(狂笑)", "ali_031");
        grL.put("#(抱枕)", "ali_032");
        grL.put("#(吼叫)", "ali_033");
        grL.put("#(嚷)", "ali_034");
        grL.put("#(唠叨)", "ali_035");
        grL.put("#(捏脸)", "ali_036");
        grL.put("#(爆笑)", "ali_037");
        grL.put("#(郁闷)", "ali_038");
        grL.put("#(潜水)", "ali_039");
        grL.put("#(十分开心)", "ali_040");
        grL.put("#(冷笑话)", "ali_041");
        grL.put("#(顶！)", "ali_042");
        grL.put("#(潜)", "ali_043");
        grL.put("#(画圈圈)", "ali_044");
        grL.put("#(玩电脑)", "ali_045");
        grL.put("#(狂吐)", "ali_046");
        grL.put("#(哭着跑)", "ali_047");
        grL.put("#(阿狸侠)", "ali_048");
        grL.put("#(冷死了)", "ali_049");
        grL.put("#(惆怅~)", "ali_050");
        grL.put("#(摸头)", "ali_051");
        grL.put("#(蹭)", "ali_052");
        grL.put("#(打滚)", "ali_053");
        grL.put("#(叩拜)", "ali_054");
        grL.put("#(摸)", "ali_055");
        grL.put("#(数钱)", "ali_056");
        grL.put("#(拖走)", "ali_057");
        grL.put("#(热)", "ali_058");
        grL.put("#(加1)", "ali_059");
        grL.put("#(压力)", "ali_060");
        grL.put("#(表逼我)", "ali_061");
        grL.put("#(人呢)", "ali_062");
        grL.put("#(摇晃)", "ali_063");
        grL.put("#(打地鼠)", "ali_064");
        grL.put("#(这个屌)", "ali_065");
        grL.put("#(恐慌)", "ali_066");
        grL.put("#(晕乎乎)", "ali_067");
        grL.put("#(浮云)", "ali_068");
        grL.put("#(给力)", "ali_069");
        grL.put("#(杯具了)", "ali_070");
        grL.put("#(焦糖舞)", "yz_001");
        grL.put("#(翻滚)", "yz_002");
        grL.put("#(拍屁股做鬼脸)", "yz_003");
        grL.put("#(不)", "yz_004");
        grL.put("#(河蟹掉啦)", "yz_005");
        grL.put("#(哦耶)", "yz_006");
        grL.put("#(我倒)", "yz_007");
        grL.put("#(投降)", "yz_008");
        grL.put("#(微笑)", "b01");
        grL.put("#(帅哥)", "b02");
        grL.put("#(美女)", "b03");
        grL.put("#(老大)", "b04");
        grL.put("#(哈哈哈)", "b05");
        grL.put("#(奸笑)", "b06");
        grL.put("#(傻乐)", "b07");
        grL.put("#(飞吻)", "b08");
        grL.put("#(害羞)", "b09");
        grL.put("#(花痴)", "b10");
        grL.put("#(憧憬)", "b11");
        grL.put("#(你牛)", "b12");
        grL.put("#(鼓掌)", "b13");
        grL.put("#(可爱)", "b14");
        grL.put("#(太委屈)", "b15");
        grL.put("#(大哭)", "b16");
        grL.put("#(泪奔)", "b17");
        grL.put("#(寻死)", "b18");
        grL.put("#(非常惊讶)", "b19");
        grL.put("#(表示疑问)", "b20");
        grL.put("#(暗中观察)", "image_emoticon85");
        grL.put("#(吃瓜)", "image_emoticon86");
        grL.put("#(喝酒)", "image_emoticon87");
        grL.put("#(嘿嘿嘿)", "image_emoticon88");
        grL.put("#(噗)", "image_emoticon89");
        grL.put("#(困成狗)", "image_emoticon90");
        grL.put("#(微微一笑)", "image_emoticon91");
        grL.put("#(托腮)", "image_emoticon92");
        grL.put("#(摊手)", "image_emoticon93");
        grL.put("#(柯基暗中观察)", "image_emoticon94");
        grL.put("#(欢呼)", "image_emoticon95");
        grL.put("#(炸药)", "image_emoticon96");
        grL.put("#(突然兴奋)", "image_emoticon97");
        grL.put("#(紧张)", "image_emoticon98");
        grL.put("#(黑头瞪眼)", "image_emoticon99");
        grL.put("#(黑头高兴)", "image_emoticon100");
        grL.put("#(不跟丑人说话)", "image_emoticon101");
        grL.put("#(么么哒)", "image_emoticon102");
        grL.put("#(亲亲才能起来)", "image_emoticon103");
        grL.put("#(伦家只是宝宝)", "image_emoticon104");
        grL.put("#(你是我的人)", "image_emoticon105");
        grL.put("#(假装看不见)", "image_emoticon106");
        grL.put("#(单身等撩)", "image_emoticon107");
        grL.put("#(吓到宝宝了)", "image_emoticon108");
        grL.put("#(哈哈哈)", "image_emoticon109");
        grL.put("#(嗯嗯)", "image_emoticon110");
        grL.put("#(好幸福)", "image_emoticon111");
        grL.put("#(宝宝不开心)", "image_emoticon112");
        grL.put("#(小姐姐别走)", "image_emoticon113");
        grL.put("#(小姐姐在吗)", "image_emoticon114");
        grL.put("#(小姐姐来啦)", "image_emoticon115");
        grL.put("#(小姐姐来玩呀)", "image_emoticon116");
        grL.put("#(我养你)", "image_emoticon117");
        grL.put("#(我是不会骗你的)", "image_emoticon118");
        grL.put("#(扎心了)", "image_emoticon119");
        grL.put("#(无聊)", "image_emoticon120");
        grL.put("#(月亮代表我的心)", "image_emoticon121");
        grL.put("#(来追我呀)", "image_emoticon122");
        grL.put("#(爱你的形状)", "image_emoticon123");
        grL.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return grL.get(str);
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
                        SpannableString a = a(tbRichTextData.axE(), name, str3);
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
        int pP = TbFaceManager.aso().pP(str);
        if (pP != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), pP);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0253a qm = TbFaceManager.aso().qm(str);
            if (qm != null) {
                int width = (int) (0.5d * qm.getWidth());
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
