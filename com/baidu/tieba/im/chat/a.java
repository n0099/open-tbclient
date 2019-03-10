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
import com.baidu.tbadk.widget.richText.b;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<String, String> gaI = new HashMap<>();

    static {
        gaI.put("#(呵呵)", "image_emoticon");
        gaI.put("#(哈哈)", "image_emoticon2");
        gaI.put("#(吐舌)", "image_emoticon3");
        gaI.put("#(啊)", "image_emoticon4");
        gaI.put("#(啊?)", "image_emoticon4");
        gaI.put("#(酷)", "image_emoticon5");
        gaI.put("#(怒)", "image_emoticon6");
        gaI.put("#(开心)", "image_emoticon7");
        gaI.put("#(汗)", "image_emoticon8");
        gaI.put("#(泪)", "image_emoticon9");
        gaI.put("#(黑线)", "image_emoticon10");
        gaI.put("#(鄙视)", "image_emoticon11");
        gaI.put("#(不高兴)", "image_emoticon12");
        gaI.put("#(真棒)", "image_emoticon13");
        gaI.put("#(钱)", "image_emoticon14");
        gaI.put("#(疑问)", "image_emoticon15");
        gaI.put("#(阴险)", "image_emoticon16");
        gaI.put("#(吐)", "image_emoticon17");
        gaI.put("#(咦)", "image_emoticon18");
        gaI.put("#(咦?)", "image_emoticon18");
        gaI.put("#(委屈)", "image_emoticon19");
        gaI.put("#(花心)", "image_emoticon20");
        gaI.put("#(呼~)", "image_emoticon21");
        gaI.put("#(笑眼)", "image_emoticon22");
        gaI.put("#(冷)", "image_emoticon23");
        gaI.put("#(太开心)", "image_emoticon24");
        gaI.put("#(滑稽)", "image_emoticon25");
        gaI.put("#(勉强)", "image_emoticon26");
        gaI.put("#(狂汗)", "image_emoticon27");
        gaI.put("#(乖)", "image_emoticon28");
        gaI.put("#(睡觉)", "image_emoticon29");
        gaI.put("#(惊哭)", "image_emoticon30");
        gaI.put("#(升起)", "image_emoticon31");
        gaI.put("#(惊讶)", "image_emoticon32");
        gaI.put("#(喷)", "image_emoticon33");
        gaI.put("#(爱心)", "image_emoticon34");
        gaI.put("#(心碎)", "image_emoticon35");
        gaI.put("#(玫瑰)", "image_emoticon36");
        gaI.put("#(礼物)", "image_emoticon37");
        gaI.put("#(彩虹)", "image_emoticon38");
        gaI.put("#(星星月亮)", "image_emoticon39");
        gaI.put("#(太阳)", "image_emoticon40");
        gaI.put("#(钱币)", "image_emoticon41");
        gaI.put("#(灯泡)", "image_emoticon42");
        gaI.put("#(茶杯)", "image_emoticon43");
        gaI.put("#(蛋糕)", "image_emoticon44");
        gaI.put("#(音乐)", "image_emoticon45");
        gaI.put("#(haha)", "image_emoticon46");
        gaI.put("#(胜利)", "image_emoticon47");
        gaI.put("#(大拇指)", "image_emoticon48");
        gaI.put("#(弱)", "image_emoticon49");
        gaI.put("#(OK)", "image_emoticon50");
        gaI.put("#(哼)", "image_emoticon61");
        gaI.put("#(吃瓜)", "image_emoticon62");
        gaI.put("#(扔便便)", "image_emoticon63");
        gaI.put("#(惊恐)", "image_emoticon64");
        gaI.put("#(哎呦)", "image_emoticon65");
        gaI.put("#(小乖)", "image_emoticon66");
        gaI.put("#(捂嘴笑)", "image_emoticon67");
        gaI.put("#(你懂的)", "image_emoticon68");
        gaI.put("#(what)", "image_emoticon69");
        gaI.put("#(酸爽)", "image_emoticon70");
        gaI.put("#(呀咩爹)", "image_emoticon71");
        gaI.put("#(笑尿)", "image_emoticon72");
        gaI.put("#(挖鼻)", "image_emoticon73");
        gaI.put("#(犀利)", "image_emoticon74");
        gaI.put("#(小红脸)", "image_emoticon75");
        gaI.put("#(懒得理)", "image_emoticon76");
        gaI.put("#(沙发)", "image_emoticon77");
        gaI.put("#(手纸)", "image_emoticon78");
        gaI.put("#(香蕉)", "image_emoticon79");
        gaI.put("#(便便)", "image_emoticon80");
        gaI.put("#(药丸)", "image_emoticon81");
        gaI.put("#(红领巾)", "image_emoticon82");
        gaI.put("#(蜡烛)", "image_emoticon83");
        gaI.put("#(三道杠)", "image_emoticon84");
        gaI.put("#(赖皮)", "ali_001");
        gaI.put("#(感动)", "ali_002");
        gaI.put("#(十分惊讶)", "ali_003");
        gaI.put("#(怒气)", "ali_004");
        gaI.put("#(哭泣)", "ali_005");
        gaI.put("#(吃惊)", "ali_006");
        gaI.put("#(嘲弄)", "ali_007");
        gaI.put("#(飘过)", "ali_008");
        gaI.put("#(转圈哭)", "ali_009");
        gaI.put("#(神经病)", "ali_010");
        gaI.put("#(揪耳朵)", "ali_011");
        gaI.put("#(惊汗)", "ali_012");
        gaI.put("#(隐身)", "ali_013");
        gaI.put("#(不要嘛)", "ali_014");
        gaI.put("#(遁)", "ali_015");
        gaI.put("#(不公平)", "ali_016");
        gaI.put("#(爬来了)", "ali_017");
        gaI.put("#(蛋花哭)", "ali_018");
        gaI.put("#(温暖)", "ali_019");
        gaI.put("#(点头)", "ali_020");
        gaI.put("#(撒钱)", "ali_021");
        gaI.put("#(献花)", "ali_022");
        gaI.put("#(寒)", "ali_023");
        gaI.put("#(傻笑)", "ali_024");
        gaI.put("#(扭扭)", "ali_025");
        gaI.put("#(疯)", "ali_026");
        gaI.put("#(抓狂)", "ali_027");
        gaI.put("#(抓)", "ali_028");
        gaI.put("#(蜷)", "ali_029");
        gaI.put("#(挠墙)", "ali_030");
        gaI.put("#(狂笑)", "ali_031");
        gaI.put("#(抱枕)", "ali_032");
        gaI.put("#(吼叫)", "ali_033");
        gaI.put("#(嚷)", "ali_034");
        gaI.put("#(唠叨)", "ali_035");
        gaI.put("#(捏脸)", "ali_036");
        gaI.put("#(爆笑)", "ali_037");
        gaI.put("#(郁闷)", "ali_038");
        gaI.put("#(潜水)", "ali_039");
        gaI.put("#(十分开心)", "ali_040");
        gaI.put("#(冷笑话)", "ali_041");
        gaI.put("#(顶！)", "ali_042");
        gaI.put("#(潜)", "ali_043");
        gaI.put("#(画圈圈)", "ali_044");
        gaI.put("#(玩电脑)", "ali_045");
        gaI.put("#(狂吐)", "ali_046");
        gaI.put("#(哭着跑)", "ali_047");
        gaI.put("#(阿狸侠)", "ali_048");
        gaI.put("#(冷死了)", "ali_049");
        gaI.put("#(惆怅~)", "ali_050");
        gaI.put("#(摸头)", "ali_051");
        gaI.put("#(蹭)", "ali_052");
        gaI.put("#(打滚)", "ali_053");
        gaI.put("#(叩拜)", "ali_054");
        gaI.put("#(摸)", "ali_055");
        gaI.put("#(数钱)", "ali_056");
        gaI.put("#(拖走)", "ali_057");
        gaI.put("#(热)", "ali_058");
        gaI.put("#(加1)", "ali_059");
        gaI.put("#(压力)", "ali_060");
        gaI.put("#(表逼我)", "ali_061");
        gaI.put("#(人呢)", "ali_062");
        gaI.put("#(摇晃)", "ali_063");
        gaI.put("#(打地鼠)", "ali_064");
        gaI.put("#(这个屌)", "ali_065");
        gaI.put("#(恐慌)", "ali_066");
        gaI.put("#(晕乎乎)", "ali_067");
        gaI.put("#(浮云)", "ali_068");
        gaI.put("#(给力)", "ali_069");
        gaI.put("#(杯具了)", "ali_070");
        gaI.put("#(焦糖舞)", "yz_001");
        gaI.put("#(翻滚)", "yz_002");
        gaI.put("#(拍屁股做鬼脸)", "yz_003");
        gaI.put("#(不)", "yz_004");
        gaI.put("#(河蟹掉啦)", "yz_005");
        gaI.put("#(哦耶)", "yz_006");
        gaI.put("#(我倒)", "yz_007");
        gaI.put("#(投降)", "yz_008");
        gaI.put("#(微笑)", "b01");
        gaI.put("#(帅哥)", "b02");
        gaI.put("#(美女)", "b03");
        gaI.put("#(老大)", "b04");
        gaI.put("#(哈哈哈)", "b05");
        gaI.put("#(奸笑)", "b06");
        gaI.put("#(傻乐)", "b07");
        gaI.put("#(飞吻)", "b08");
        gaI.put("#(害羞)", "b09");
        gaI.put("#(花痴)", "b10");
        gaI.put("#(憧憬)", "b11");
        gaI.put("#(你牛)", "b12");
        gaI.put("#(鼓掌)", "b13");
        gaI.put("#(可爱)", "b14");
        gaI.put("#(太委屈)", "b15");
        gaI.put("#(大哭)", "b16");
        gaI.put("#(泪奔)", "b17");
        gaI.put("#(寻死)", "b18");
        gaI.put("#(非常惊讶)", "b19");
        gaI.put("#(表示疑问)", "b20");
        gaI.put("#(暗中观察)", "image_emoticon85");
        gaI.put("#(吃瓜)", "image_emoticon86");
        gaI.put("#(喝酒)", "image_emoticon87");
        gaI.put("#(嘿嘿嘿)", "image_emoticon88");
        gaI.put("#(噗)", "image_emoticon89");
        gaI.put("#(困成狗)", "image_emoticon90");
        gaI.put("#(微微一笑)", "image_emoticon91");
        gaI.put("#(托腮)", "image_emoticon92");
        gaI.put("#(摊手)", "image_emoticon93");
        gaI.put("#(柯基暗中观察)", "image_emoticon94");
        gaI.put("#(欢呼)", "image_emoticon95");
        gaI.put("#(炸药)", "image_emoticon96");
        gaI.put("#(突然兴奋)", "image_emoticon97");
        gaI.put("#(紧张)", "image_emoticon98");
        gaI.put("#(黑头瞪眼)", "image_emoticon99");
        gaI.put("#(黑头高兴)", "image_emoticon100");
        gaI.put("#(不跟丑人说话)", "image_emoticon101");
        gaI.put("#(么么哒)", "image_emoticon102");
        gaI.put("#(亲亲才能起来)", "image_emoticon103");
        gaI.put("#(伦家只是宝宝)", "image_emoticon104");
        gaI.put("#(你是我的人)", "image_emoticon105");
        gaI.put("#(假装看不见)", "image_emoticon106");
        gaI.put("#(单身等撩)", "image_emoticon107");
        gaI.put("#(吓到宝宝了)", "image_emoticon108");
        gaI.put("#(哈哈哈)", "image_emoticon109");
        gaI.put("#(嗯嗯)", "image_emoticon110");
        gaI.put("#(好幸福)", "image_emoticon111");
        gaI.put("#(宝宝不开心)", "image_emoticon112");
        gaI.put("#(小姐姐别走)", "image_emoticon113");
        gaI.put("#(小姐姐在吗)", "image_emoticon114");
        gaI.put("#(小姐姐来啦)", "image_emoticon115");
        gaI.put("#(小姐姐来玩呀)", "image_emoticon116");
        gaI.put("#(我养你)", "image_emoticon117");
        gaI.put("#(我是不会骗你的)", "image_emoticon118");
        gaI.put("#(扎心了)", "image_emoticon119");
        gaI.put("#(无聊)", "image_emoticon120");
        gaI.put("#(月亮代表我的心)", "image_emoticon121");
        gaI.put("#(来追我呀)", "image_emoticon122");
        gaI.put("#(爱你的形状)", "image_emoticon123");
        gaI.put("#(白眼)", "image_emoticon124");
    }

    private static String getName(String str) {
        return gaI.get(str);
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
                                SpannableString aL = aL(context, str5);
                                if (aL != null) {
                                    tbRichTextData.append(aL);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString b = b(tbRichTextData.asD(), name, str3);
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
                    SpannableString aL2 = aL(context, str5);
                    if (aL2 != null) {
                        tbRichTextData.append(aL2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString b(ArrayList<b> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int oG = TbFaceManager.anp().oG(str);
        if (oG != 0) {
            spannableString = new SpannableString(str2 + " ");
            b bVar = new b(TbadkCoreApplication.getInst(), oG);
            if (arrayList != null) {
                arrayList.add(bVar);
            }
            a.C0204a pd = TbFaceManager.anp().pd(str);
            if (pd != null) {
                int width = (int) (0.5d * pd.getWidth());
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aL(Context context, String str) {
        if (str == null) {
            return null;
        }
        return ba.av(context, str);
    }
}
