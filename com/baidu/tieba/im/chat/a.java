package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> iJJ = new HashMap<>();

    static {
        iJJ.put("#(呵呵)", "image_emoticon");
        iJJ.put("#(哈哈)", "image_emoticon2");
        iJJ.put("#(吐舌)", "image_emoticon3");
        iJJ.put("#(啊)", "image_emoticon4");
        iJJ.put("#(啊?)", "image_emoticon4");
        iJJ.put("#(酷)", "image_emoticon5");
        iJJ.put("#(怒)", "image_emoticon6");
        iJJ.put("#(开心)", "image_emoticon7");
        iJJ.put("#(汗)", "image_emoticon8");
        iJJ.put("#(泪)", "image_emoticon9");
        iJJ.put("#(黑线)", "image_emoticon10");
        iJJ.put("#(鄙视)", "image_emoticon11");
        iJJ.put("#(不高兴)", "image_emoticon12");
        iJJ.put("#(真棒)", "image_emoticon13");
        iJJ.put("#(钱)", "image_emoticon14");
        iJJ.put("#(疑问)", "image_emoticon15");
        iJJ.put("#(阴险)", "image_emoticon16");
        iJJ.put("#(吐)", "image_emoticon17");
        iJJ.put("#(咦)", "image_emoticon18");
        iJJ.put("#(咦?)", "image_emoticon18");
        iJJ.put("#(委屈)", "image_emoticon19");
        iJJ.put("#(花心)", "image_emoticon20");
        iJJ.put("#(呼~)", "image_emoticon21");
        iJJ.put("#(笑眼)", "image_emoticon22");
        iJJ.put("#(冷)", "image_emoticon23");
        iJJ.put("#(太开心)", "image_emoticon24");
        iJJ.put("#(滑稽)", "image_emoticon25");
        iJJ.put("#(勉强)", "image_emoticon26");
        iJJ.put("#(狂汗)", "image_emoticon27");
        iJJ.put("#(乖)", "image_emoticon28");
        iJJ.put("#(睡觉)", "image_emoticon29");
        iJJ.put("#(惊哭)", "image_emoticon30");
        iJJ.put("#(升起)", "image_emoticon31");
        iJJ.put("#(惊讶)", "image_emoticon32");
        iJJ.put("#(喷)", "image_emoticon33");
        iJJ.put("#(爱心)", "image_emoticon34");
        iJJ.put("#(心碎)", "image_emoticon35");
        iJJ.put("#(玫瑰)", "image_emoticon36");
        iJJ.put("#(礼物)", "image_emoticon37");
        iJJ.put("#(彩虹)", "image_emoticon38");
        iJJ.put("#(星星月亮)", "image_emoticon39");
        iJJ.put("#(太阳)", "image_emoticon40");
        iJJ.put("#(钱币)", "image_emoticon41");
        iJJ.put("#(灯泡)", "image_emoticon42");
        iJJ.put("#(茶杯)", "image_emoticon43");
        iJJ.put("#(蛋糕)", "image_emoticon44");
        iJJ.put("#(音乐)", "image_emoticon45");
        iJJ.put("#(haha)", "image_emoticon46");
        iJJ.put("#(胜利)", "image_emoticon47");
        iJJ.put("#(大拇指)", "image_emoticon48");
        iJJ.put("#(弱)", "image_emoticon49");
        iJJ.put("#(OK)", "image_emoticon50");
        iJJ.put("#(哼)", "image_emoticon61");
        iJJ.put("#(吃瓜)", "image_emoticon62");
        iJJ.put("#(扔便便)", "image_emoticon63");
        iJJ.put("#(惊恐)", "image_emoticon64");
        iJJ.put("#(哎呦)", "image_emoticon65");
        iJJ.put("#(小乖)", "image_emoticon66");
        iJJ.put("#(捂嘴笑)", "image_emoticon67");
        iJJ.put("#(你懂的)", "image_emoticon68");
        iJJ.put("#(what)", "image_emoticon69");
        iJJ.put("#(酸爽)", "image_emoticon70");
        iJJ.put("#(呀咩爹)", "image_emoticon71");
        iJJ.put("#(笑尿)", "image_emoticon72");
        iJJ.put("#(挖鼻)", "image_emoticon73");
        iJJ.put("#(犀利)", "image_emoticon74");
        iJJ.put("#(小红脸)", "image_emoticon75");
        iJJ.put("#(懒得理)", "image_emoticon76");
        iJJ.put("#(沙发)", "image_emoticon77");
        iJJ.put("#(手纸)", "image_emoticon78");
        iJJ.put("#(香蕉)", "image_emoticon79");
        iJJ.put("#(便便)", "image_emoticon80");
        iJJ.put("#(药丸)", "image_emoticon81");
        iJJ.put("#(红领巾)", "image_emoticon82");
        iJJ.put("#(蜡烛)", "image_emoticon83");
        iJJ.put("#(三道杠)", "image_emoticon84");
        iJJ.put("#(赖皮)", "ali_001");
        iJJ.put("#(感动)", "ali_002");
        iJJ.put("#(十分惊讶)", "ali_003");
        iJJ.put("#(怒气)", "ali_004");
        iJJ.put("#(哭泣)", "ali_005");
        iJJ.put("#(吃惊)", "ali_006");
        iJJ.put("#(嘲弄)", "ali_007");
        iJJ.put("#(飘过)", "ali_008");
        iJJ.put("#(转圈哭)", "ali_009");
        iJJ.put("#(神经病)", "ali_010");
        iJJ.put("#(揪耳朵)", "ali_011");
        iJJ.put("#(惊汗)", "ali_012");
        iJJ.put("#(隐身)", "ali_013");
        iJJ.put("#(不要嘛)", "ali_014");
        iJJ.put("#(遁)", "ali_015");
        iJJ.put("#(不公平)", "ali_016");
        iJJ.put("#(爬来了)", "ali_017");
        iJJ.put("#(蛋花哭)", "ali_018");
        iJJ.put("#(温暖)", "ali_019");
        iJJ.put("#(点头)", "ali_020");
        iJJ.put("#(撒钱)", "ali_021");
        iJJ.put("#(献花)", "ali_022");
        iJJ.put("#(寒)", "ali_023");
        iJJ.put("#(傻笑)", "ali_024");
        iJJ.put("#(扭扭)", "ali_025");
        iJJ.put("#(疯)", "ali_026");
        iJJ.put("#(抓狂)", "ali_027");
        iJJ.put("#(抓)", "ali_028");
        iJJ.put("#(蜷)", "ali_029");
        iJJ.put("#(挠墙)", "ali_030");
        iJJ.put("#(狂笑)", "ali_031");
        iJJ.put("#(抱枕)", "ali_032");
        iJJ.put("#(吼叫)", "ali_033");
        iJJ.put("#(嚷)", "ali_034");
        iJJ.put("#(唠叨)", "ali_035");
        iJJ.put("#(捏脸)", "ali_036");
        iJJ.put("#(爆笑)", "ali_037");
        iJJ.put("#(郁闷)", "ali_038");
        iJJ.put("#(潜水)", "ali_039");
        iJJ.put("#(十分开心)", "ali_040");
        iJJ.put("#(冷笑话)", "ali_041");
        iJJ.put("#(顶！)", "ali_042");
        iJJ.put("#(潜)", "ali_043");
        iJJ.put("#(画圈圈)", "ali_044");
        iJJ.put("#(玩电脑)", "ali_045");
        iJJ.put("#(狂吐)", "ali_046");
        iJJ.put("#(哭着跑)", "ali_047");
        iJJ.put("#(阿狸侠)", "ali_048");
        iJJ.put("#(冷死了)", "ali_049");
        iJJ.put("#(惆怅~)", "ali_050");
        iJJ.put("#(摸头)", "ali_051");
        iJJ.put("#(蹭)", "ali_052");
        iJJ.put("#(打滚)", "ali_053");
        iJJ.put("#(叩拜)", "ali_054");
        iJJ.put("#(摸)", "ali_055");
        iJJ.put("#(数钱)", "ali_056");
        iJJ.put("#(拖走)", "ali_057");
        iJJ.put("#(热)", "ali_058");
        iJJ.put("#(加1)", "ali_059");
        iJJ.put("#(压力)", "ali_060");
        iJJ.put("#(表逼我)", "ali_061");
        iJJ.put("#(人呢)", "ali_062");
        iJJ.put("#(摇晃)", "ali_063");
        iJJ.put("#(打地鼠)", "ali_064");
        iJJ.put("#(这个屌)", "ali_065");
        iJJ.put("#(恐慌)", "ali_066");
        iJJ.put("#(晕乎乎)", "ali_067");
        iJJ.put("#(浮云)", "ali_068");
        iJJ.put("#(给力)", "ali_069");
        iJJ.put("#(杯具了)", "ali_070");
        iJJ.put("#(焦糖舞)", "yz_001");
        iJJ.put("#(翻滚)", "yz_002");
        iJJ.put("#(拍屁股做鬼脸)", "yz_003");
        iJJ.put("#(不)", "yz_004");
        iJJ.put("#(河蟹掉啦)", "yz_005");
        iJJ.put("#(哦耶)", "yz_006");
        iJJ.put("#(我倒)", "yz_007");
        iJJ.put("#(投降)", "yz_008");
        iJJ.put("#(微笑)", "b01");
        iJJ.put("#(帅哥)", "b02");
        iJJ.put("#(美女)", "b03");
        iJJ.put("#(老大)", "b04");
        iJJ.put("#(哈哈哈)", "b05");
        iJJ.put("#(奸笑)", "b06");
        iJJ.put("#(傻乐)", "b07");
        iJJ.put("#(飞吻)", "b08");
        iJJ.put("#(害羞)", "b09");
        iJJ.put("#(花痴)", "b10");
        iJJ.put("#(憧憬)", "b11");
        iJJ.put("#(你牛)", "b12");
        iJJ.put("#(鼓掌)", "b13");
        iJJ.put("#(可爱)", "b14");
        iJJ.put("#(太委屈)", "b15");
        iJJ.put("#(大哭)", "b16");
        iJJ.put("#(泪奔)", "b17");
        iJJ.put("#(寻死)", "b18");
        iJJ.put("#(非常惊讶)", "b19");
        iJJ.put("#(表示疑问)", "b20");
        iJJ.put("#(暗中观察)", "image_emoticon85");
        iJJ.put("#(吃瓜)", "image_emoticon86");
        iJJ.put("#(喝酒)", "image_emoticon87");
        iJJ.put("#(嘿嘿嘿)", "image_emoticon88");
        iJJ.put("#(噗)", "image_emoticon89");
        iJJ.put("#(困成狗)", "image_emoticon90");
        iJJ.put("#(微微一笑)", "image_emoticon91");
        iJJ.put("#(托腮)", "image_emoticon92");
        iJJ.put("#(摊手)", "image_emoticon93");
        iJJ.put("#(柯基暗中观察)", "image_emoticon94");
        iJJ.put("#(欢呼)", "image_emoticon95");
        iJJ.put("#(炸药)", "image_emoticon96");
        iJJ.put("#(突然兴奋)", "image_emoticon97");
        iJJ.put("#(紧张)", "image_emoticon98");
        iJJ.put("#(黑头瞪眼)", "image_emoticon99");
        iJJ.put("#(黑头高兴)", "image_emoticon100");
        iJJ.put("#(不跟丑人说话)", "image_emoticon101");
        iJJ.put("#(么么哒)", "image_emoticon102");
        iJJ.put("#(亲亲才能起来)", "image_emoticon103");
        iJJ.put("#(伦家只是宝宝)", "image_emoticon104");
        iJJ.put("#(你是我的人)", "image_emoticon105");
        iJJ.put("#(假装看不见)", "image_emoticon106");
        iJJ.put("#(单身等撩)", "image_emoticon107");
        iJJ.put("#(吓到宝宝了)", "image_emoticon108");
        iJJ.put("#(哈哈哈)", "image_emoticon109");
        iJJ.put("#(嗯嗯)", "image_emoticon110");
        iJJ.put("#(好幸福)", "image_emoticon111");
        iJJ.put("#(宝宝不开心)", "image_emoticon112");
        iJJ.put("#(小姐姐别走)", "image_emoticon113");
        iJJ.put("#(小姐姐在吗)", "image_emoticon114");
        iJJ.put("#(小姐姐来啦)", "image_emoticon115");
        iJJ.put("#(小姐姐来玩呀)", "image_emoticon116");
        iJJ.put("#(我养你)", "image_emoticon117");
        iJJ.put("#(我是不会骗你的)", "image_emoticon118");
        iJJ.put("#(扎心了)", "image_emoticon119");
        iJJ.put("#(无聊)", "image_emoticon120");
        iJJ.put("#(月亮代表我的心)", "image_emoticon121");
        iJJ.put("#(来追我呀)", "image_emoticon122");
        iJJ.put("#(爱你的形状)", "image_emoticon123");
        iJJ.put("#(白眼)", "image_emoticon124");
    }

    private static String Gs(String str) {
        return iJJ.get(str);
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
                    String Gs = Gs(str3);
                    if (TextUtils.isEmpty(Gs)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.n(str5);
                            } else {
                                SpannableString aF = aF(context, str5);
                                if (aF != null) {
                                    tbRichTextData.n(aF);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.bkU(), Gs, str3);
                        if (a != null) {
                            tbRichTextData.n(a);
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
                    tbRichTextData.n(str5);
                } else {
                    SpannableString aF2 = aF(context, str5);
                    if (aF2 != null) {
                        tbRichTextData.n(aF2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int yr = TbFaceManager.bgy().yr(str);
        if (yr != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), yr);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0496a yL = TbFaceManager.bgy().yL(str);
            if (yL != null) {
                int width = (int) (0.5d * yL.getWidth());
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
        return bc.ai(context, str);
    }
}
