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
    private static final HashMap<String, String> gav = new HashMap<>();

    static {
        gav.put("#(呵呵)", "image_emoticon");
        gav.put("#(哈哈)", "image_emoticon2");
        gav.put("#(吐舌)", "image_emoticon3");
        gav.put("#(啊)", "image_emoticon4");
        gav.put("#(啊?)", "image_emoticon4");
        gav.put("#(酷)", "image_emoticon5");
        gav.put("#(怒)", "image_emoticon6");
        gav.put("#(开心)", "image_emoticon7");
        gav.put("#(汗)", "image_emoticon8");
        gav.put("#(泪)", "image_emoticon9");
        gav.put("#(黑线)", "image_emoticon10");
        gav.put("#(鄙视)", "image_emoticon11");
        gav.put("#(不高兴)", "image_emoticon12");
        gav.put("#(真棒)", "image_emoticon13");
        gav.put("#(钱)", "image_emoticon14");
        gav.put("#(疑问)", "image_emoticon15");
        gav.put("#(阴险)", "image_emoticon16");
        gav.put("#(吐)", "image_emoticon17");
        gav.put("#(咦)", "image_emoticon18");
        gav.put("#(咦?)", "image_emoticon18");
        gav.put("#(委屈)", "image_emoticon19");
        gav.put("#(花心)", "image_emoticon20");
        gav.put("#(呼~)", "image_emoticon21");
        gav.put("#(笑眼)", "image_emoticon22");
        gav.put("#(冷)", "image_emoticon23");
        gav.put("#(太开心)", "image_emoticon24");
        gav.put("#(滑稽)", "image_emoticon25");
        gav.put("#(勉强)", "image_emoticon26");
        gav.put("#(狂汗)", "image_emoticon27");
        gav.put("#(乖)", "image_emoticon28");
        gav.put("#(睡觉)", "image_emoticon29");
        gav.put("#(惊哭)", "image_emoticon30");
        gav.put("#(升起)", "image_emoticon31");
        gav.put("#(惊讶)", "image_emoticon32");
        gav.put("#(喷)", "image_emoticon33");
        gav.put("#(爱心)", "image_emoticon34");
        gav.put("#(心碎)", "image_emoticon35");
        gav.put("#(玫瑰)", "image_emoticon36");
        gav.put("#(礼物)", "image_emoticon37");
        gav.put("#(彩虹)", "image_emoticon38");
        gav.put("#(星星月亮)", "image_emoticon39");
        gav.put("#(太阳)", "image_emoticon40");
        gav.put("#(钱币)", "image_emoticon41");
        gav.put("#(灯泡)", "image_emoticon42");
        gav.put("#(茶杯)", "image_emoticon43");
        gav.put("#(蛋糕)", "image_emoticon44");
        gav.put("#(音乐)", "image_emoticon45");
        gav.put("#(haha)", "image_emoticon46");
        gav.put("#(胜利)", "image_emoticon47");
        gav.put("#(大拇指)", "image_emoticon48");
        gav.put("#(弱)", "image_emoticon49");
        gav.put("#(OK)", "image_emoticon50");
        gav.put("#(哼)", "image_emoticon61");
        gav.put("#(吃瓜)", "image_emoticon62");
        gav.put("#(扔便便)", "image_emoticon63");
        gav.put("#(惊恐)", "image_emoticon64");
        gav.put("#(哎呦)", "image_emoticon65");
        gav.put("#(小乖)", "image_emoticon66");
        gav.put("#(捂嘴笑)", "image_emoticon67");
        gav.put("#(你懂的)", "image_emoticon68");
        gav.put("#(what)", "image_emoticon69");
        gav.put("#(酸爽)", "image_emoticon70");
        gav.put("#(呀咩爹)", "image_emoticon71");
        gav.put("#(笑尿)", "image_emoticon72");
        gav.put("#(挖鼻)", "image_emoticon73");
        gav.put("#(犀利)", "image_emoticon74");
        gav.put("#(小红脸)", "image_emoticon75");
        gav.put("#(懒得理)", "image_emoticon76");
        gav.put("#(沙发)", "image_emoticon77");
        gav.put("#(手纸)", "image_emoticon78");
        gav.put("#(香蕉)", "image_emoticon79");
        gav.put("#(便便)", "image_emoticon80");
        gav.put("#(药丸)", "image_emoticon81");
        gav.put("#(红领巾)", "image_emoticon82");
        gav.put("#(蜡烛)", "image_emoticon83");
        gav.put("#(三道杠)", "image_emoticon84");
        gav.put("#(赖皮)", "ali_001");
        gav.put("#(感动)", "ali_002");
        gav.put("#(十分惊讶)", "ali_003");
        gav.put("#(怒气)", "ali_004");
        gav.put("#(哭泣)", "ali_005");
        gav.put("#(吃惊)", "ali_006");
        gav.put("#(嘲弄)", "ali_007");
        gav.put("#(飘过)", "ali_008");
        gav.put("#(转圈哭)", "ali_009");
        gav.put("#(神经病)", "ali_010");
        gav.put("#(揪耳朵)", "ali_011");
        gav.put("#(惊汗)", "ali_012");
        gav.put("#(隐身)", "ali_013");
        gav.put("#(不要嘛)", "ali_014");
        gav.put("#(遁)", "ali_015");
        gav.put("#(不公平)", "ali_016");
        gav.put("#(爬来了)", "ali_017");
        gav.put("#(蛋花哭)", "ali_018");
        gav.put("#(温暖)", "ali_019");
        gav.put("#(点头)", "ali_020");
        gav.put("#(撒钱)", "ali_021");
        gav.put("#(献花)", "ali_022");
        gav.put("#(寒)", "ali_023");
        gav.put("#(傻笑)", "ali_024");
        gav.put("#(扭扭)", "ali_025");
        gav.put("#(疯)", "ali_026");
        gav.put("#(抓狂)", "ali_027");
        gav.put("#(抓)", "ali_028");
        gav.put("#(蜷)", "ali_029");
        gav.put("#(挠墙)", "ali_030");
        gav.put("#(狂笑)", "ali_031");
        gav.put("#(抱枕)", "ali_032");
        gav.put("#(吼叫)", "ali_033");
        gav.put("#(嚷)", "ali_034");
        gav.put("#(唠叨)", "ali_035");
        gav.put("#(捏脸)", "ali_036");
        gav.put("#(爆笑)", "ali_037");
        gav.put("#(郁闷)", "ali_038");
        gav.put("#(潜水)", "ali_039");
        gav.put("#(十分开心)", "ali_040");
        gav.put("#(冷笑话)", "ali_041");
        gav.put("#(顶！)", "ali_042");
        gav.put("#(潜)", "ali_043");
        gav.put("#(画圈圈)", "ali_044");
        gav.put("#(玩电脑)", "ali_045");
        gav.put("#(狂吐)", "ali_046");
        gav.put("#(哭着跑)", "ali_047");
        gav.put("#(阿狸侠)", "ali_048");
        gav.put("#(冷死了)", "ali_049");
        gav.put("#(惆怅~)", "ali_050");
        gav.put("#(摸头)", "ali_051");
        gav.put("#(蹭)", "ali_052");
        gav.put("#(打滚)", "ali_053");
        gav.put("#(叩拜)", "ali_054");
        gav.put("#(摸)", "ali_055");
        gav.put("#(数钱)", "ali_056");
        gav.put("#(拖走)", "ali_057");
        gav.put("#(热)", "ali_058");
        gav.put("#(加1)", "ali_059");
        gav.put("#(压力)", "ali_060");
        gav.put("#(表逼我)", "ali_061");
        gav.put("#(人呢)", "ali_062");
        gav.put("#(摇晃)", "ali_063");
        gav.put("#(打地鼠)", "ali_064");
        gav.put("#(这个屌)", "ali_065");
        gav.put("#(恐慌)", "ali_066");
        gav.put("#(晕乎乎)", "ali_067");
        gav.put("#(浮云)", "ali_068");
        gav.put("#(给力)", "ali_069");
        gav.put("#(杯具了)", "ali_070");
        gav.put("#(焦糖舞)", "yz_001");
        gav.put("#(翻滚)", "yz_002");
        gav.put("#(拍屁股做鬼脸)", "yz_003");
        gav.put("#(不)", "yz_004");
        gav.put("#(河蟹掉啦)", "yz_005");
        gav.put("#(哦耶)", "yz_006");
        gav.put("#(我倒)", "yz_007");
        gav.put("#(投降)", "yz_008");
        gav.put("#(微笑)", "b01");
        gav.put("#(帅哥)", "b02");
        gav.put("#(美女)", "b03");
        gav.put("#(老大)", "b04");
        gav.put("#(哈哈哈)", "b05");
        gav.put("#(奸笑)", "b06");
        gav.put("#(傻乐)", "b07");
        gav.put("#(飞吻)", "b08");
        gav.put("#(害羞)", "b09");
        gav.put("#(花痴)", "b10");
        gav.put("#(憧憬)", "b11");
        gav.put("#(你牛)", "b12");
        gav.put("#(鼓掌)", "b13");
        gav.put("#(可爱)", "b14");
        gav.put("#(太委屈)", "b15");
        gav.put("#(大哭)", "b16");
        gav.put("#(泪奔)", "b17");
        gav.put("#(寻死)", "b18");
        gav.put("#(非常惊讶)", "b19");
        gav.put("#(表示疑问)", "b20");
        gav.put("#(暗中观察)", "image_emoticon85");
        gav.put("#(吃瓜)", "image_emoticon86");
        gav.put("#(喝酒)", "image_emoticon87");
        gav.put("#(嘿嘿嘿)", "image_emoticon88");
        gav.put("#(噗)", "image_emoticon89");
        gav.put("#(困成狗)", "image_emoticon90");
        gav.put("#(微微一笑)", "image_emoticon91");
        gav.put("#(托腮)", "image_emoticon92");
        gav.put("#(摊手)", "image_emoticon93");
        gav.put("#(柯基暗中观察)", "image_emoticon94");
        gav.put("#(欢呼)", "image_emoticon95");
        gav.put("#(炸药)", "image_emoticon96");
        gav.put("#(突然兴奋)", "image_emoticon97");
        gav.put("#(紧张)", "image_emoticon98");
        gav.put("#(黑头瞪眼)", "image_emoticon99");
        gav.put("#(黑头高兴)", "image_emoticon100");
        gav.put("#(不跟丑人说话)", "image_emoticon101");
        gav.put("#(么么哒)", "image_emoticon102");
        gav.put("#(亲亲才能起来)", "image_emoticon103");
        gav.put("#(伦家只是宝宝)", "image_emoticon104");
        gav.put("#(你是我的人)", "image_emoticon105");
        gav.put("#(假装看不见)", "image_emoticon106");
        gav.put("#(单身等撩)", "image_emoticon107");
        gav.put("#(吓到宝宝了)", "image_emoticon108");
        gav.put("#(哈哈哈)", "image_emoticon109");
        gav.put("#(嗯嗯)", "image_emoticon110");
        gav.put("#(好幸福)", "image_emoticon111");
        gav.put("#(宝宝不开心)", "image_emoticon112");
        gav.put("#(小姐姐别走)", "image_emoticon113");
        gav.put("#(小姐姐在吗)", "image_emoticon114");
        gav.put("#(小姐姐来啦)", "image_emoticon115");
        gav.put("#(小姐姐来玩呀)", "image_emoticon116");
        gav.put("#(我养你)", "image_emoticon117");
        gav.put("#(我是不会骗你的)", "image_emoticon118");
        gav.put("#(扎心了)", "image_emoticon119");
        gav.put("#(无聊)", "image_emoticon120");
        gav.put("#(月亮代表我的心)", "image_emoticon121");
        gav.put("#(来追我呀)", "image_emoticon122");
        gav.put("#(爱你的形状)", "image_emoticon123");
        gav.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return gav.get(str);
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
                                SpannableString aK = aK(context, str5);
                                if (aK != null) {
                                    tbRichTextData.append(aK);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.asz(), name, str3);
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
                    SpannableString aK2 = aK(context, str5);
                    if (aK2 != null) {
                        tbRichTextData.append(aK2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<com.baidu.tbadk.widget.richText.b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int oH = TbFaceManager.anl().oH(str);
        if (oH != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst(), oH);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0238a pe = TbFaceManager.anl().pe(str);
            if (pe != null) {
                int width = (int) (0.5d * pe.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aK(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ba.av(context, str);
    }
}
