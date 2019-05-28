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
    private static final HashMap<String, String> grM = new HashMap<>();

    static {
        grM.put("#(呵呵)", "image_emoticon");
        grM.put("#(哈哈)", "image_emoticon2");
        grM.put("#(吐舌)", "image_emoticon3");
        grM.put("#(啊)", "image_emoticon4");
        grM.put("#(啊?)", "image_emoticon4");
        grM.put("#(酷)", "image_emoticon5");
        grM.put("#(怒)", "image_emoticon6");
        grM.put("#(开心)", "image_emoticon7");
        grM.put("#(汗)", "image_emoticon8");
        grM.put("#(泪)", "image_emoticon9");
        grM.put("#(黑线)", "image_emoticon10");
        grM.put("#(鄙视)", "image_emoticon11");
        grM.put("#(不高兴)", "image_emoticon12");
        grM.put("#(真棒)", "image_emoticon13");
        grM.put("#(钱)", "image_emoticon14");
        grM.put("#(疑问)", "image_emoticon15");
        grM.put("#(阴险)", "image_emoticon16");
        grM.put("#(吐)", "image_emoticon17");
        grM.put("#(咦)", "image_emoticon18");
        grM.put("#(咦?)", "image_emoticon18");
        grM.put("#(委屈)", "image_emoticon19");
        grM.put("#(花心)", "image_emoticon20");
        grM.put("#(呼~)", "image_emoticon21");
        grM.put("#(笑眼)", "image_emoticon22");
        grM.put("#(冷)", "image_emoticon23");
        grM.put("#(太开心)", "image_emoticon24");
        grM.put("#(滑稽)", "image_emoticon25");
        grM.put("#(勉强)", "image_emoticon26");
        grM.put("#(狂汗)", "image_emoticon27");
        grM.put("#(乖)", "image_emoticon28");
        grM.put("#(睡觉)", "image_emoticon29");
        grM.put("#(惊哭)", "image_emoticon30");
        grM.put("#(升起)", "image_emoticon31");
        grM.put("#(惊讶)", "image_emoticon32");
        grM.put("#(喷)", "image_emoticon33");
        grM.put("#(爱心)", "image_emoticon34");
        grM.put("#(心碎)", "image_emoticon35");
        grM.put("#(玫瑰)", "image_emoticon36");
        grM.put("#(礼物)", "image_emoticon37");
        grM.put("#(彩虹)", "image_emoticon38");
        grM.put("#(星星月亮)", "image_emoticon39");
        grM.put("#(太阳)", "image_emoticon40");
        grM.put("#(钱币)", "image_emoticon41");
        grM.put("#(灯泡)", "image_emoticon42");
        grM.put("#(茶杯)", "image_emoticon43");
        grM.put("#(蛋糕)", "image_emoticon44");
        grM.put("#(音乐)", "image_emoticon45");
        grM.put("#(haha)", "image_emoticon46");
        grM.put("#(胜利)", "image_emoticon47");
        grM.put("#(大拇指)", "image_emoticon48");
        grM.put("#(弱)", "image_emoticon49");
        grM.put("#(OK)", "image_emoticon50");
        grM.put("#(哼)", "image_emoticon61");
        grM.put("#(吃瓜)", "image_emoticon62");
        grM.put("#(扔便便)", "image_emoticon63");
        grM.put("#(惊恐)", "image_emoticon64");
        grM.put("#(哎呦)", "image_emoticon65");
        grM.put("#(小乖)", "image_emoticon66");
        grM.put("#(捂嘴笑)", "image_emoticon67");
        grM.put("#(你懂的)", "image_emoticon68");
        grM.put("#(what)", "image_emoticon69");
        grM.put("#(酸爽)", "image_emoticon70");
        grM.put("#(呀咩爹)", "image_emoticon71");
        grM.put("#(笑尿)", "image_emoticon72");
        grM.put("#(挖鼻)", "image_emoticon73");
        grM.put("#(犀利)", "image_emoticon74");
        grM.put("#(小红脸)", "image_emoticon75");
        grM.put("#(懒得理)", "image_emoticon76");
        grM.put("#(沙发)", "image_emoticon77");
        grM.put("#(手纸)", "image_emoticon78");
        grM.put("#(香蕉)", "image_emoticon79");
        grM.put("#(便便)", "image_emoticon80");
        grM.put("#(药丸)", "image_emoticon81");
        grM.put("#(红领巾)", "image_emoticon82");
        grM.put("#(蜡烛)", "image_emoticon83");
        grM.put("#(三道杠)", "image_emoticon84");
        grM.put("#(赖皮)", "ali_001");
        grM.put("#(感动)", "ali_002");
        grM.put("#(十分惊讶)", "ali_003");
        grM.put("#(怒气)", "ali_004");
        grM.put("#(哭泣)", "ali_005");
        grM.put("#(吃惊)", "ali_006");
        grM.put("#(嘲弄)", "ali_007");
        grM.put("#(飘过)", "ali_008");
        grM.put("#(转圈哭)", "ali_009");
        grM.put("#(神经病)", "ali_010");
        grM.put("#(揪耳朵)", "ali_011");
        grM.put("#(惊汗)", "ali_012");
        grM.put("#(隐身)", "ali_013");
        grM.put("#(不要嘛)", "ali_014");
        grM.put("#(遁)", "ali_015");
        grM.put("#(不公平)", "ali_016");
        grM.put("#(爬来了)", "ali_017");
        grM.put("#(蛋花哭)", "ali_018");
        grM.put("#(温暖)", "ali_019");
        grM.put("#(点头)", "ali_020");
        grM.put("#(撒钱)", "ali_021");
        grM.put("#(献花)", "ali_022");
        grM.put("#(寒)", "ali_023");
        grM.put("#(傻笑)", "ali_024");
        grM.put("#(扭扭)", "ali_025");
        grM.put("#(疯)", "ali_026");
        grM.put("#(抓狂)", "ali_027");
        grM.put("#(抓)", "ali_028");
        grM.put("#(蜷)", "ali_029");
        grM.put("#(挠墙)", "ali_030");
        grM.put("#(狂笑)", "ali_031");
        grM.put("#(抱枕)", "ali_032");
        grM.put("#(吼叫)", "ali_033");
        grM.put("#(嚷)", "ali_034");
        grM.put("#(唠叨)", "ali_035");
        grM.put("#(捏脸)", "ali_036");
        grM.put("#(爆笑)", "ali_037");
        grM.put("#(郁闷)", "ali_038");
        grM.put("#(潜水)", "ali_039");
        grM.put("#(十分开心)", "ali_040");
        grM.put("#(冷笑话)", "ali_041");
        grM.put("#(顶！)", "ali_042");
        grM.put("#(潜)", "ali_043");
        grM.put("#(画圈圈)", "ali_044");
        grM.put("#(玩电脑)", "ali_045");
        grM.put("#(狂吐)", "ali_046");
        grM.put("#(哭着跑)", "ali_047");
        grM.put("#(阿狸侠)", "ali_048");
        grM.put("#(冷死了)", "ali_049");
        grM.put("#(惆怅~)", "ali_050");
        grM.put("#(摸头)", "ali_051");
        grM.put("#(蹭)", "ali_052");
        grM.put("#(打滚)", "ali_053");
        grM.put("#(叩拜)", "ali_054");
        grM.put("#(摸)", "ali_055");
        grM.put("#(数钱)", "ali_056");
        grM.put("#(拖走)", "ali_057");
        grM.put("#(热)", "ali_058");
        grM.put("#(加1)", "ali_059");
        grM.put("#(压力)", "ali_060");
        grM.put("#(表逼我)", "ali_061");
        grM.put("#(人呢)", "ali_062");
        grM.put("#(摇晃)", "ali_063");
        grM.put("#(打地鼠)", "ali_064");
        grM.put("#(这个屌)", "ali_065");
        grM.put("#(恐慌)", "ali_066");
        grM.put("#(晕乎乎)", "ali_067");
        grM.put("#(浮云)", "ali_068");
        grM.put("#(给力)", "ali_069");
        grM.put("#(杯具了)", "ali_070");
        grM.put("#(焦糖舞)", "yz_001");
        grM.put("#(翻滚)", "yz_002");
        grM.put("#(拍屁股做鬼脸)", "yz_003");
        grM.put("#(不)", "yz_004");
        grM.put("#(河蟹掉啦)", "yz_005");
        grM.put("#(哦耶)", "yz_006");
        grM.put("#(我倒)", "yz_007");
        grM.put("#(投降)", "yz_008");
        grM.put("#(微笑)", "b01");
        grM.put("#(帅哥)", "b02");
        grM.put("#(美女)", "b03");
        grM.put("#(老大)", "b04");
        grM.put("#(哈哈哈)", "b05");
        grM.put("#(奸笑)", "b06");
        grM.put("#(傻乐)", "b07");
        grM.put("#(飞吻)", "b08");
        grM.put("#(害羞)", "b09");
        grM.put("#(花痴)", "b10");
        grM.put("#(憧憬)", "b11");
        grM.put("#(你牛)", "b12");
        grM.put("#(鼓掌)", "b13");
        grM.put("#(可爱)", "b14");
        grM.put("#(太委屈)", "b15");
        grM.put("#(大哭)", "b16");
        grM.put("#(泪奔)", "b17");
        grM.put("#(寻死)", "b18");
        grM.put("#(非常惊讶)", "b19");
        grM.put("#(表示疑问)", "b20");
        grM.put("#(暗中观察)", "image_emoticon85");
        grM.put("#(吃瓜)", "image_emoticon86");
        grM.put("#(喝酒)", "image_emoticon87");
        grM.put("#(嘿嘿嘿)", "image_emoticon88");
        grM.put("#(噗)", "image_emoticon89");
        grM.put("#(困成狗)", "image_emoticon90");
        grM.put("#(微微一笑)", "image_emoticon91");
        grM.put("#(托腮)", "image_emoticon92");
        grM.put("#(摊手)", "image_emoticon93");
        grM.put("#(柯基暗中观察)", "image_emoticon94");
        grM.put("#(欢呼)", "image_emoticon95");
        grM.put("#(炸药)", "image_emoticon96");
        grM.put("#(突然兴奋)", "image_emoticon97");
        grM.put("#(紧张)", "image_emoticon98");
        grM.put("#(黑头瞪眼)", "image_emoticon99");
        grM.put("#(黑头高兴)", "image_emoticon100");
        grM.put("#(不跟丑人说话)", "image_emoticon101");
        grM.put("#(么么哒)", "image_emoticon102");
        grM.put("#(亲亲才能起来)", "image_emoticon103");
        grM.put("#(伦家只是宝宝)", "image_emoticon104");
        grM.put("#(你是我的人)", "image_emoticon105");
        grM.put("#(假装看不见)", "image_emoticon106");
        grM.put("#(单身等撩)", "image_emoticon107");
        grM.put("#(吓到宝宝了)", "image_emoticon108");
        grM.put("#(哈哈哈)", "image_emoticon109");
        grM.put("#(嗯嗯)", "image_emoticon110");
        grM.put("#(好幸福)", "image_emoticon111");
        grM.put("#(宝宝不开心)", "image_emoticon112");
        grM.put("#(小姐姐别走)", "image_emoticon113");
        grM.put("#(小姐姐在吗)", "image_emoticon114");
        grM.put("#(小姐姐来啦)", "image_emoticon115");
        grM.put("#(小姐姐来玩呀)", "image_emoticon116");
        grM.put("#(我养你)", "image_emoticon117");
        grM.put("#(我是不会骗你的)", "image_emoticon118");
        grM.put("#(扎心了)", "image_emoticon119");
        grM.put("#(无聊)", "image_emoticon120");
        grM.put("#(月亮代表我的心)", "image_emoticon121");
        grM.put("#(来追我呀)", "image_emoticon122");
        grM.put("#(爱你的形状)", "image_emoticon123");
        grM.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return grM.get(str);
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
