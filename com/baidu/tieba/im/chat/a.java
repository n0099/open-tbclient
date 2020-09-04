package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> jeT = new HashMap<>();

    static {
        jeT.put("#(呵呵)", "image_emoticon");
        jeT.put("#(哈哈)", "image_emoticon2");
        jeT.put("#(吐舌)", "image_emoticon3");
        jeT.put("#(啊)", "image_emoticon4");
        jeT.put("#(啊?)", "image_emoticon4");
        jeT.put("#(酷)", "image_emoticon5");
        jeT.put("#(怒)", "image_emoticon6");
        jeT.put("#(开心)", "image_emoticon7");
        jeT.put("#(汗)", "image_emoticon8");
        jeT.put("#(泪)", "image_emoticon9");
        jeT.put("#(黑线)", "image_emoticon10");
        jeT.put("#(鄙视)", "image_emoticon11");
        jeT.put("#(不高兴)", "image_emoticon12");
        jeT.put("#(真棒)", "image_emoticon13");
        jeT.put("#(钱)", "image_emoticon14");
        jeT.put("#(疑问)", "image_emoticon15");
        jeT.put("#(阴险)", "image_emoticon16");
        jeT.put("#(吐)", "image_emoticon17");
        jeT.put("#(咦)", "image_emoticon18");
        jeT.put("#(咦?)", "image_emoticon18");
        jeT.put("#(委屈)", "image_emoticon19");
        jeT.put("#(花心)", "image_emoticon20");
        jeT.put("#(呼~)", "image_emoticon21");
        jeT.put("#(笑眼)", "image_emoticon22");
        jeT.put("#(冷)", "image_emoticon23");
        jeT.put("#(太开心)", "image_emoticon24");
        jeT.put("#(滑稽)", "image_emoticon25");
        jeT.put("#(勉强)", "image_emoticon26");
        jeT.put("#(狂汗)", "image_emoticon27");
        jeT.put("#(乖)", "image_emoticon28");
        jeT.put("#(睡觉)", "image_emoticon29");
        jeT.put("#(惊哭)", "image_emoticon30");
        jeT.put("#(升起)", "image_emoticon31");
        jeT.put("#(惊讶)", "image_emoticon32");
        jeT.put("#(喷)", "image_emoticon33");
        jeT.put("#(爱心)", "image_emoticon34");
        jeT.put("#(心碎)", "image_emoticon35");
        jeT.put("#(玫瑰)", "image_emoticon36");
        jeT.put("#(礼物)", "image_emoticon37");
        jeT.put("#(彩虹)", "image_emoticon38");
        jeT.put("#(星星月亮)", "image_emoticon39");
        jeT.put("#(太阳)", "image_emoticon40");
        jeT.put("#(钱币)", "image_emoticon41");
        jeT.put("#(灯泡)", "image_emoticon42");
        jeT.put("#(茶杯)", "image_emoticon43");
        jeT.put("#(蛋糕)", "image_emoticon44");
        jeT.put("#(音乐)", "image_emoticon45");
        jeT.put("#(haha)", "image_emoticon46");
        jeT.put("#(胜利)", "image_emoticon47");
        jeT.put("#(大拇指)", "image_emoticon48");
        jeT.put("#(弱)", "image_emoticon49");
        jeT.put("#(OK)", "image_emoticon50");
        jeT.put("#(哼)", "image_emoticon61");
        jeT.put("#(吃瓜)", "image_emoticon62");
        jeT.put("#(扔便便)", "image_emoticon63");
        jeT.put("#(惊恐)", "image_emoticon64");
        jeT.put("#(哎呦)", "image_emoticon65");
        jeT.put("#(小乖)", "image_emoticon66");
        jeT.put("#(捂嘴笑)", "image_emoticon67");
        jeT.put("#(你懂的)", "image_emoticon68");
        jeT.put("#(what)", "image_emoticon69");
        jeT.put("#(酸爽)", "image_emoticon70");
        jeT.put("#(呀咩爹)", "image_emoticon71");
        jeT.put("#(笑尿)", "image_emoticon72");
        jeT.put("#(挖鼻)", "image_emoticon73");
        jeT.put("#(犀利)", "image_emoticon74");
        jeT.put("#(小红脸)", "image_emoticon75");
        jeT.put("#(懒得理)", "image_emoticon76");
        jeT.put("#(沙发)", "image_emoticon77");
        jeT.put("#(手纸)", "image_emoticon78");
        jeT.put("#(香蕉)", "image_emoticon79");
        jeT.put("#(便便)", "image_emoticon80");
        jeT.put("#(药丸)", "image_emoticon81");
        jeT.put("#(红领巾)", "image_emoticon82");
        jeT.put("#(蜡烛)", "image_emoticon83");
        jeT.put("#(三道杠)", "image_emoticon84");
        jeT.put("#(赖皮)", "ali_001");
        jeT.put("#(感动)", "ali_002");
        jeT.put("#(十分惊讶)", "ali_003");
        jeT.put("#(怒气)", "ali_004");
        jeT.put("#(哭泣)", "ali_005");
        jeT.put("#(吃惊)", "ali_006");
        jeT.put("#(嘲弄)", "ali_007");
        jeT.put("#(飘过)", "ali_008");
        jeT.put("#(转圈哭)", "ali_009");
        jeT.put("#(神经病)", "ali_010");
        jeT.put("#(揪耳朵)", "ali_011");
        jeT.put("#(惊汗)", "ali_012");
        jeT.put("#(隐身)", "ali_013");
        jeT.put("#(不要嘛)", "ali_014");
        jeT.put("#(遁)", "ali_015");
        jeT.put("#(不公平)", "ali_016");
        jeT.put("#(爬来了)", "ali_017");
        jeT.put("#(蛋花哭)", "ali_018");
        jeT.put("#(温暖)", "ali_019");
        jeT.put("#(点头)", "ali_020");
        jeT.put("#(撒钱)", "ali_021");
        jeT.put("#(献花)", "ali_022");
        jeT.put("#(寒)", "ali_023");
        jeT.put("#(傻笑)", "ali_024");
        jeT.put("#(扭扭)", "ali_025");
        jeT.put("#(疯)", "ali_026");
        jeT.put("#(抓狂)", "ali_027");
        jeT.put("#(抓)", "ali_028");
        jeT.put("#(蜷)", "ali_029");
        jeT.put("#(挠墙)", "ali_030");
        jeT.put("#(狂笑)", "ali_031");
        jeT.put("#(抱枕)", "ali_032");
        jeT.put("#(吼叫)", "ali_033");
        jeT.put("#(嚷)", "ali_034");
        jeT.put("#(唠叨)", "ali_035");
        jeT.put("#(捏脸)", "ali_036");
        jeT.put("#(爆笑)", "ali_037");
        jeT.put("#(郁闷)", "ali_038");
        jeT.put("#(潜水)", "ali_039");
        jeT.put("#(十分开心)", "ali_040");
        jeT.put("#(冷笑话)", "ali_041");
        jeT.put("#(顶！)", "ali_042");
        jeT.put("#(潜)", "ali_043");
        jeT.put("#(画圈圈)", "ali_044");
        jeT.put("#(玩电脑)", "ali_045");
        jeT.put("#(狂吐)", "ali_046");
        jeT.put("#(哭着跑)", "ali_047");
        jeT.put("#(阿狸侠)", "ali_048");
        jeT.put("#(冷死了)", "ali_049");
        jeT.put("#(惆怅~)", "ali_050");
        jeT.put("#(摸头)", "ali_051");
        jeT.put("#(蹭)", "ali_052");
        jeT.put("#(打滚)", "ali_053");
        jeT.put("#(叩拜)", "ali_054");
        jeT.put("#(摸)", "ali_055");
        jeT.put("#(数钱)", "ali_056");
        jeT.put("#(拖走)", "ali_057");
        jeT.put("#(热)", "ali_058");
        jeT.put("#(加1)", "ali_059");
        jeT.put("#(压力)", "ali_060");
        jeT.put("#(表逼我)", "ali_061");
        jeT.put("#(人呢)", "ali_062");
        jeT.put("#(摇晃)", "ali_063");
        jeT.put("#(打地鼠)", "ali_064");
        jeT.put("#(这个屌)", "ali_065");
        jeT.put("#(恐慌)", "ali_066");
        jeT.put("#(晕乎乎)", "ali_067");
        jeT.put("#(浮云)", "ali_068");
        jeT.put("#(给力)", "ali_069");
        jeT.put("#(杯具了)", "ali_070");
        jeT.put("#(焦糖舞)", "yz_001");
        jeT.put("#(翻滚)", "yz_002");
        jeT.put("#(拍屁股做鬼脸)", "yz_003");
        jeT.put("#(不)", "yz_004");
        jeT.put("#(河蟹掉啦)", "yz_005");
        jeT.put("#(哦耶)", "yz_006");
        jeT.put("#(我倒)", "yz_007");
        jeT.put("#(投降)", "yz_008");
        jeT.put("#(微笑)", "b01");
        jeT.put("#(帅哥)", "b02");
        jeT.put("#(美女)", "b03");
        jeT.put("#(老大)", "b04");
        jeT.put("#(哈哈哈)", "b05");
        jeT.put("#(奸笑)", "b06");
        jeT.put("#(傻乐)", "b07");
        jeT.put("#(飞吻)", "b08");
        jeT.put("#(害羞)", "b09");
        jeT.put("#(花痴)", "b10");
        jeT.put("#(憧憬)", "b11");
        jeT.put("#(你牛)", "b12");
        jeT.put("#(鼓掌)", "b13");
        jeT.put("#(可爱)", "b14");
        jeT.put("#(太委屈)", "b15");
        jeT.put("#(大哭)", "b16");
        jeT.put("#(泪奔)", "b17");
        jeT.put("#(寻死)", "b18");
        jeT.put("#(非常惊讶)", "b19");
        jeT.put("#(表示疑问)", "b20");
        jeT.put("#(暗中观察)", "image_emoticon85");
        jeT.put("#(吃瓜)", "image_emoticon86");
        jeT.put("#(喝酒)", "image_emoticon87");
        jeT.put("#(嘿嘿嘿)", "image_emoticon88");
        jeT.put("#(噗)", "image_emoticon89");
        jeT.put("#(困成狗)", "image_emoticon90");
        jeT.put("#(微微一笑)", "image_emoticon91");
        jeT.put("#(托腮)", "image_emoticon92");
        jeT.put("#(摊手)", "image_emoticon93");
        jeT.put("#(柯基暗中观察)", "image_emoticon94");
        jeT.put("#(欢呼)", "image_emoticon95");
        jeT.put("#(炸药)", "image_emoticon96");
        jeT.put("#(突然兴奋)", "image_emoticon97");
        jeT.put("#(紧张)", "image_emoticon98");
        jeT.put("#(黑头瞪眼)", "image_emoticon99");
        jeT.put("#(黑头高兴)", "image_emoticon100");
        jeT.put("#(不跟丑人说话)", "image_emoticon101");
        jeT.put("#(么么哒)", "image_emoticon102");
        jeT.put("#(亲亲才能起来)", "image_emoticon103");
        jeT.put("#(伦家只是宝宝)", "image_emoticon104");
        jeT.put("#(你是我的人)", "image_emoticon105");
        jeT.put("#(假装看不见)", "image_emoticon106");
        jeT.put("#(单身等撩)", "image_emoticon107");
        jeT.put("#(吓到宝宝了)", "image_emoticon108");
        jeT.put("#(哈哈哈)", "image_emoticon109");
        jeT.put("#(嗯嗯)", "image_emoticon110");
        jeT.put("#(好幸福)", "image_emoticon111");
        jeT.put("#(宝宝不开心)", "image_emoticon112");
        jeT.put("#(小姐姐别走)", "image_emoticon113");
        jeT.put("#(小姐姐在吗)", "image_emoticon114");
        jeT.put("#(小姐姐来啦)", "image_emoticon115");
        jeT.put("#(小姐姐来玩呀)", "image_emoticon116");
        jeT.put("#(我养你)", "image_emoticon117");
        jeT.put("#(我是不会骗你的)", "image_emoticon118");
        jeT.put("#(扎心了)", "image_emoticon119");
        jeT.put("#(无聊)", "image_emoticon120");
        jeT.put("#(月亮代表我的心)", "image_emoticon121");
        jeT.put("#(来追我呀)", "image_emoticon122");
        jeT.put("#(爱你的形状)", "image_emoticon123");
        jeT.put("#(白眼)", "image_emoticon124");
    }

    private static String JX(String str) {
        return jeT.get(str);
    }

    public static ArrayList<TbRichTextData> d(Context context, String str, int i) {
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
                    String JX = JX(str3);
                    if (TextUtils.isEmpty(JX)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.n(str5);
                            } else {
                                SpannableString aI = aI(context, str5);
                                if (aI != null) {
                                    tbRichTextData.n(aI);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.bxC(), JX, str3);
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
                    SpannableString aI2 = aI(context, str5);
                    if (aI2 != null) {
                        tbRichTextData.n(aI2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int BO = TbFaceManager.bsW().BO(str);
        if (BO != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), BO);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0554a Cj = TbFaceManager.bsW().Cj(str);
            if (Cj != null) {
                int width = (int) (0.5d * Cj.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aI(Context context, String str) {
        if (str == null) {
            return null;
        }
        return be.an(context, str);
    }
}
