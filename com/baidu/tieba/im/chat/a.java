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
    private static final HashMap<String, String> idd = new HashMap<>();

    static {
        idd.put("#(呵呵)", "image_emoticon");
        idd.put("#(哈哈)", "image_emoticon2");
        idd.put("#(吐舌)", "image_emoticon3");
        idd.put("#(啊)", "image_emoticon4");
        idd.put("#(啊?)", "image_emoticon4");
        idd.put("#(酷)", "image_emoticon5");
        idd.put("#(怒)", "image_emoticon6");
        idd.put("#(开心)", "image_emoticon7");
        idd.put("#(汗)", "image_emoticon8");
        idd.put("#(泪)", "image_emoticon9");
        idd.put("#(黑线)", "image_emoticon10");
        idd.put("#(鄙视)", "image_emoticon11");
        idd.put("#(不高兴)", "image_emoticon12");
        idd.put("#(真棒)", "image_emoticon13");
        idd.put("#(钱)", "image_emoticon14");
        idd.put("#(疑问)", "image_emoticon15");
        idd.put("#(阴险)", "image_emoticon16");
        idd.put("#(吐)", "image_emoticon17");
        idd.put("#(咦)", "image_emoticon18");
        idd.put("#(咦?)", "image_emoticon18");
        idd.put("#(委屈)", "image_emoticon19");
        idd.put("#(花心)", "image_emoticon20");
        idd.put("#(呼~)", "image_emoticon21");
        idd.put("#(笑眼)", "image_emoticon22");
        idd.put("#(冷)", "image_emoticon23");
        idd.put("#(太开心)", "image_emoticon24");
        idd.put("#(滑稽)", "image_emoticon25");
        idd.put("#(勉强)", "image_emoticon26");
        idd.put("#(狂汗)", "image_emoticon27");
        idd.put("#(乖)", "image_emoticon28");
        idd.put("#(睡觉)", "image_emoticon29");
        idd.put("#(惊哭)", "image_emoticon30");
        idd.put("#(升起)", "image_emoticon31");
        idd.put("#(惊讶)", "image_emoticon32");
        idd.put("#(喷)", "image_emoticon33");
        idd.put("#(爱心)", "image_emoticon34");
        idd.put("#(心碎)", "image_emoticon35");
        idd.put("#(玫瑰)", "image_emoticon36");
        idd.put("#(礼物)", "image_emoticon37");
        idd.put("#(彩虹)", "image_emoticon38");
        idd.put("#(星星月亮)", "image_emoticon39");
        idd.put("#(太阳)", "image_emoticon40");
        idd.put("#(钱币)", "image_emoticon41");
        idd.put("#(灯泡)", "image_emoticon42");
        idd.put("#(茶杯)", "image_emoticon43");
        idd.put("#(蛋糕)", "image_emoticon44");
        idd.put("#(音乐)", "image_emoticon45");
        idd.put("#(haha)", "image_emoticon46");
        idd.put("#(胜利)", "image_emoticon47");
        idd.put("#(大拇指)", "image_emoticon48");
        idd.put("#(弱)", "image_emoticon49");
        idd.put("#(OK)", "image_emoticon50");
        idd.put("#(哼)", "image_emoticon61");
        idd.put("#(吃瓜)", "image_emoticon62");
        idd.put("#(扔便便)", "image_emoticon63");
        idd.put("#(惊恐)", "image_emoticon64");
        idd.put("#(哎呦)", "image_emoticon65");
        idd.put("#(小乖)", "image_emoticon66");
        idd.put("#(捂嘴笑)", "image_emoticon67");
        idd.put("#(你懂的)", "image_emoticon68");
        idd.put("#(what)", "image_emoticon69");
        idd.put("#(酸爽)", "image_emoticon70");
        idd.put("#(呀咩爹)", "image_emoticon71");
        idd.put("#(笑尿)", "image_emoticon72");
        idd.put("#(挖鼻)", "image_emoticon73");
        idd.put("#(犀利)", "image_emoticon74");
        idd.put("#(小红脸)", "image_emoticon75");
        idd.put("#(懒得理)", "image_emoticon76");
        idd.put("#(沙发)", "image_emoticon77");
        idd.put("#(手纸)", "image_emoticon78");
        idd.put("#(香蕉)", "image_emoticon79");
        idd.put("#(便便)", "image_emoticon80");
        idd.put("#(药丸)", "image_emoticon81");
        idd.put("#(红领巾)", "image_emoticon82");
        idd.put("#(蜡烛)", "image_emoticon83");
        idd.put("#(三道杠)", "image_emoticon84");
        idd.put("#(赖皮)", "ali_001");
        idd.put("#(感动)", "ali_002");
        idd.put("#(十分惊讶)", "ali_003");
        idd.put("#(怒气)", "ali_004");
        idd.put("#(哭泣)", "ali_005");
        idd.put("#(吃惊)", "ali_006");
        idd.put("#(嘲弄)", "ali_007");
        idd.put("#(飘过)", "ali_008");
        idd.put("#(转圈哭)", "ali_009");
        idd.put("#(神经病)", "ali_010");
        idd.put("#(揪耳朵)", "ali_011");
        idd.put("#(惊汗)", "ali_012");
        idd.put("#(隐身)", "ali_013");
        idd.put("#(不要嘛)", "ali_014");
        idd.put("#(遁)", "ali_015");
        idd.put("#(不公平)", "ali_016");
        idd.put("#(爬来了)", "ali_017");
        idd.put("#(蛋花哭)", "ali_018");
        idd.put("#(温暖)", "ali_019");
        idd.put("#(点头)", "ali_020");
        idd.put("#(撒钱)", "ali_021");
        idd.put("#(献花)", "ali_022");
        idd.put("#(寒)", "ali_023");
        idd.put("#(傻笑)", "ali_024");
        idd.put("#(扭扭)", "ali_025");
        idd.put("#(疯)", "ali_026");
        idd.put("#(抓狂)", "ali_027");
        idd.put("#(抓)", "ali_028");
        idd.put("#(蜷)", "ali_029");
        idd.put("#(挠墙)", "ali_030");
        idd.put("#(狂笑)", "ali_031");
        idd.put("#(抱枕)", "ali_032");
        idd.put("#(吼叫)", "ali_033");
        idd.put("#(嚷)", "ali_034");
        idd.put("#(唠叨)", "ali_035");
        idd.put("#(捏脸)", "ali_036");
        idd.put("#(爆笑)", "ali_037");
        idd.put("#(郁闷)", "ali_038");
        idd.put("#(潜水)", "ali_039");
        idd.put("#(十分开心)", "ali_040");
        idd.put("#(冷笑话)", "ali_041");
        idd.put("#(顶！)", "ali_042");
        idd.put("#(潜)", "ali_043");
        idd.put("#(画圈圈)", "ali_044");
        idd.put("#(玩电脑)", "ali_045");
        idd.put("#(狂吐)", "ali_046");
        idd.put("#(哭着跑)", "ali_047");
        idd.put("#(阿狸侠)", "ali_048");
        idd.put("#(冷死了)", "ali_049");
        idd.put("#(惆怅~)", "ali_050");
        idd.put("#(摸头)", "ali_051");
        idd.put("#(蹭)", "ali_052");
        idd.put("#(打滚)", "ali_053");
        idd.put("#(叩拜)", "ali_054");
        idd.put("#(摸)", "ali_055");
        idd.put("#(数钱)", "ali_056");
        idd.put("#(拖走)", "ali_057");
        idd.put("#(热)", "ali_058");
        idd.put("#(加1)", "ali_059");
        idd.put("#(压力)", "ali_060");
        idd.put("#(表逼我)", "ali_061");
        idd.put("#(人呢)", "ali_062");
        idd.put("#(摇晃)", "ali_063");
        idd.put("#(打地鼠)", "ali_064");
        idd.put("#(这个屌)", "ali_065");
        idd.put("#(恐慌)", "ali_066");
        idd.put("#(晕乎乎)", "ali_067");
        idd.put("#(浮云)", "ali_068");
        idd.put("#(给力)", "ali_069");
        idd.put("#(杯具了)", "ali_070");
        idd.put("#(焦糖舞)", "yz_001");
        idd.put("#(翻滚)", "yz_002");
        idd.put("#(拍屁股做鬼脸)", "yz_003");
        idd.put("#(不)", "yz_004");
        idd.put("#(河蟹掉啦)", "yz_005");
        idd.put("#(哦耶)", "yz_006");
        idd.put("#(我倒)", "yz_007");
        idd.put("#(投降)", "yz_008");
        idd.put("#(微笑)", "b01");
        idd.put("#(帅哥)", "b02");
        idd.put("#(美女)", "b03");
        idd.put("#(老大)", "b04");
        idd.put("#(哈哈哈)", "b05");
        idd.put("#(奸笑)", "b06");
        idd.put("#(傻乐)", "b07");
        idd.put("#(飞吻)", "b08");
        idd.put("#(害羞)", "b09");
        idd.put("#(花痴)", "b10");
        idd.put("#(憧憬)", "b11");
        idd.put("#(你牛)", "b12");
        idd.put("#(鼓掌)", "b13");
        idd.put("#(可爱)", "b14");
        idd.put("#(太委屈)", "b15");
        idd.put("#(大哭)", "b16");
        idd.put("#(泪奔)", "b17");
        idd.put("#(寻死)", "b18");
        idd.put("#(非常惊讶)", "b19");
        idd.put("#(表示疑问)", "b20");
        idd.put("#(暗中观察)", "image_emoticon85");
        idd.put("#(吃瓜)", "image_emoticon86");
        idd.put("#(喝酒)", "image_emoticon87");
        idd.put("#(嘿嘿嘿)", "image_emoticon88");
        idd.put("#(噗)", "image_emoticon89");
        idd.put("#(困成狗)", "image_emoticon90");
        idd.put("#(微微一笑)", "image_emoticon91");
        idd.put("#(托腮)", "image_emoticon92");
        idd.put("#(摊手)", "image_emoticon93");
        idd.put("#(柯基暗中观察)", "image_emoticon94");
        idd.put("#(欢呼)", "image_emoticon95");
        idd.put("#(炸药)", "image_emoticon96");
        idd.put("#(突然兴奋)", "image_emoticon97");
        idd.put("#(紧张)", "image_emoticon98");
        idd.put("#(黑头瞪眼)", "image_emoticon99");
        idd.put("#(黑头高兴)", "image_emoticon100");
        idd.put("#(不跟丑人说话)", "image_emoticon101");
        idd.put("#(么么哒)", "image_emoticon102");
        idd.put("#(亲亲才能起来)", "image_emoticon103");
        idd.put("#(伦家只是宝宝)", "image_emoticon104");
        idd.put("#(你是我的人)", "image_emoticon105");
        idd.put("#(假装看不见)", "image_emoticon106");
        idd.put("#(单身等撩)", "image_emoticon107");
        idd.put("#(吓到宝宝了)", "image_emoticon108");
        idd.put("#(哈哈哈)", "image_emoticon109");
        idd.put("#(嗯嗯)", "image_emoticon110");
        idd.put("#(好幸福)", "image_emoticon111");
        idd.put("#(宝宝不开心)", "image_emoticon112");
        idd.put("#(小姐姐别走)", "image_emoticon113");
        idd.put("#(小姐姐在吗)", "image_emoticon114");
        idd.put("#(小姐姐来啦)", "image_emoticon115");
        idd.put("#(小姐姐来玩呀)", "image_emoticon116");
        idd.put("#(我养你)", "image_emoticon117");
        idd.put("#(我是不会骗你的)", "image_emoticon118");
        idd.put("#(扎心了)", "image_emoticon119");
        idd.put("#(无聊)", "image_emoticon120");
        idd.put("#(月亮代表我的心)", "image_emoticon121");
        idd.put("#(来追我呀)", "image_emoticon122");
        idd.put("#(爱你的形状)", "image_emoticon123");
        idd.put("#(白眼)", "image_emoticon124");
    }

    private static String Eh(String str) {
        return idd.get(str);
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
                    String Eh = Eh(str3);
                    if (TextUtils.isEmpty(Eh)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.j(str5);
                            } else {
                                SpannableString aE = aE(context, str5);
                                if (aE != null) {
                                    tbRichTextData.j(aE);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.bck(), Eh, str3);
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
                    SpannableString aE2 = aE(context, str5);
                    if (aE2 != null) {
                        tbRichTextData.j(aE2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int ws = TbFaceManager.aYj().ws(str);
        if (ws != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), ws);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0443a wM = TbFaceManager.aYj().wM(str);
            if (wM != null) {
                int width = (int) (0.5d * wM.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aE(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ba.ah(context, str);
    }
}
