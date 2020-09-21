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
    private static final HashMap<String, String> jnz = new HashMap<>();

    static {
        jnz.put("#(呵呵)", "image_emoticon");
        jnz.put("#(哈哈)", "image_emoticon2");
        jnz.put("#(吐舌)", "image_emoticon3");
        jnz.put("#(啊)", "image_emoticon4");
        jnz.put("#(啊?)", "image_emoticon4");
        jnz.put("#(酷)", "image_emoticon5");
        jnz.put("#(怒)", "image_emoticon6");
        jnz.put("#(开心)", "image_emoticon7");
        jnz.put("#(汗)", "image_emoticon8");
        jnz.put("#(泪)", "image_emoticon9");
        jnz.put("#(黑线)", "image_emoticon10");
        jnz.put("#(鄙视)", "image_emoticon11");
        jnz.put("#(不高兴)", "image_emoticon12");
        jnz.put("#(真棒)", "image_emoticon13");
        jnz.put("#(钱)", "image_emoticon14");
        jnz.put("#(疑问)", "image_emoticon15");
        jnz.put("#(阴险)", "image_emoticon16");
        jnz.put("#(吐)", "image_emoticon17");
        jnz.put("#(咦)", "image_emoticon18");
        jnz.put("#(咦?)", "image_emoticon18");
        jnz.put("#(委屈)", "image_emoticon19");
        jnz.put("#(花心)", "image_emoticon20");
        jnz.put("#(呼~)", "image_emoticon21");
        jnz.put("#(笑眼)", "image_emoticon22");
        jnz.put("#(冷)", "image_emoticon23");
        jnz.put("#(太开心)", "image_emoticon24");
        jnz.put("#(滑稽)", "image_emoticon25");
        jnz.put("#(勉强)", "image_emoticon26");
        jnz.put("#(狂汗)", "image_emoticon27");
        jnz.put("#(乖)", "image_emoticon28");
        jnz.put("#(睡觉)", "image_emoticon29");
        jnz.put("#(惊哭)", "image_emoticon30");
        jnz.put("#(升起)", "image_emoticon31");
        jnz.put("#(惊讶)", "image_emoticon32");
        jnz.put("#(喷)", "image_emoticon33");
        jnz.put("#(爱心)", "image_emoticon34");
        jnz.put("#(心碎)", "image_emoticon35");
        jnz.put("#(玫瑰)", "image_emoticon36");
        jnz.put("#(礼物)", "image_emoticon37");
        jnz.put("#(彩虹)", "image_emoticon38");
        jnz.put("#(星星月亮)", "image_emoticon39");
        jnz.put("#(太阳)", "image_emoticon40");
        jnz.put("#(钱币)", "image_emoticon41");
        jnz.put("#(灯泡)", "image_emoticon42");
        jnz.put("#(茶杯)", "image_emoticon43");
        jnz.put("#(蛋糕)", "image_emoticon44");
        jnz.put("#(音乐)", "image_emoticon45");
        jnz.put("#(haha)", "image_emoticon46");
        jnz.put("#(胜利)", "image_emoticon47");
        jnz.put("#(大拇指)", "image_emoticon48");
        jnz.put("#(弱)", "image_emoticon49");
        jnz.put("#(OK)", "image_emoticon50");
        jnz.put("#(哼)", "image_emoticon61");
        jnz.put("#(吃瓜)", "image_emoticon62");
        jnz.put("#(扔便便)", "image_emoticon63");
        jnz.put("#(惊恐)", "image_emoticon64");
        jnz.put("#(哎呦)", "image_emoticon65");
        jnz.put("#(小乖)", "image_emoticon66");
        jnz.put("#(捂嘴笑)", "image_emoticon67");
        jnz.put("#(你懂的)", "image_emoticon68");
        jnz.put("#(what)", "image_emoticon69");
        jnz.put("#(酸爽)", "image_emoticon70");
        jnz.put("#(呀咩爹)", "image_emoticon71");
        jnz.put("#(笑尿)", "image_emoticon72");
        jnz.put("#(挖鼻)", "image_emoticon73");
        jnz.put("#(犀利)", "image_emoticon74");
        jnz.put("#(小红脸)", "image_emoticon75");
        jnz.put("#(懒得理)", "image_emoticon76");
        jnz.put("#(沙发)", "image_emoticon77");
        jnz.put("#(手纸)", "image_emoticon78");
        jnz.put("#(香蕉)", "image_emoticon79");
        jnz.put("#(便便)", "image_emoticon80");
        jnz.put("#(药丸)", "image_emoticon81");
        jnz.put("#(红领巾)", "image_emoticon82");
        jnz.put("#(蜡烛)", "image_emoticon83");
        jnz.put("#(三道杠)", "image_emoticon84");
        jnz.put("#(赖皮)", "ali_001");
        jnz.put("#(感动)", "ali_002");
        jnz.put("#(十分惊讶)", "ali_003");
        jnz.put("#(怒气)", "ali_004");
        jnz.put("#(哭泣)", "ali_005");
        jnz.put("#(吃惊)", "ali_006");
        jnz.put("#(嘲弄)", "ali_007");
        jnz.put("#(飘过)", "ali_008");
        jnz.put("#(转圈哭)", "ali_009");
        jnz.put("#(神经病)", "ali_010");
        jnz.put("#(揪耳朵)", "ali_011");
        jnz.put("#(惊汗)", "ali_012");
        jnz.put("#(隐身)", "ali_013");
        jnz.put("#(不要嘛)", "ali_014");
        jnz.put("#(遁)", "ali_015");
        jnz.put("#(不公平)", "ali_016");
        jnz.put("#(爬来了)", "ali_017");
        jnz.put("#(蛋花哭)", "ali_018");
        jnz.put("#(温暖)", "ali_019");
        jnz.put("#(点头)", "ali_020");
        jnz.put("#(撒钱)", "ali_021");
        jnz.put("#(献花)", "ali_022");
        jnz.put("#(寒)", "ali_023");
        jnz.put("#(傻笑)", "ali_024");
        jnz.put("#(扭扭)", "ali_025");
        jnz.put("#(疯)", "ali_026");
        jnz.put("#(抓狂)", "ali_027");
        jnz.put("#(抓)", "ali_028");
        jnz.put("#(蜷)", "ali_029");
        jnz.put("#(挠墙)", "ali_030");
        jnz.put("#(狂笑)", "ali_031");
        jnz.put("#(抱枕)", "ali_032");
        jnz.put("#(吼叫)", "ali_033");
        jnz.put("#(嚷)", "ali_034");
        jnz.put("#(唠叨)", "ali_035");
        jnz.put("#(捏脸)", "ali_036");
        jnz.put("#(爆笑)", "ali_037");
        jnz.put("#(郁闷)", "ali_038");
        jnz.put("#(潜水)", "ali_039");
        jnz.put("#(十分开心)", "ali_040");
        jnz.put("#(冷笑话)", "ali_041");
        jnz.put("#(顶！)", "ali_042");
        jnz.put("#(潜)", "ali_043");
        jnz.put("#(画圈圈)", "ali_044");
        jnz.put("#(玩电脑)", "ali_045");
        jnz.put("#(狂吐)", "ali_046");
        jnz.put("#(哭着跑)", "ali_047");
        jnz.put("#(阿狸侠)", "ali_048");
        jnz.put("#(冷死了)", "ali_049");
        jnz.put("#(惆怅~)", "ali_050");
        jnz.put("#(摸头)", "ali_051");
        jnz.put("#(蹭)", "ali_052");
        jnz.put("#(打滚)", "ali_053");
        jnz.put("#(叩拜)", "ali_054");
        jnz.put("#(摸)", "ali_055");
        jnz.put("#(数钱)", "ali_056");
        jnz.put("#(拖走)", "ali_057");
        jnz.put("#(热)", "ali_058");
        jnz.put("#(加1)", "ali_059");
        jnz.put("#(压力)", "ali_060");
        jnz.put("#(表逼我)", "ali_061");
        jnz.put("#(人呢)", "ali_062");
        jnz.put("#(摇晃)", "ali_063");
        jnz.put("#(打地鼠)", "ali_064");
        jnz.put("#(这个屌)", "ali_065");
        jnz.put("#(恐慌)", "ali_066");
        jnz.put("#(晕乎乎)", "ali_067");
        jnz.put("#(浮云)", "ali_068");
        jnz.put("#(给力)", "ali_069");
        jnz.put("#(杯具了)", "ali_070");
        jnz.put("#(焦糖舞)", "yz_001");
        jnz.put("#(翻滚)", "yz_002");
        jnz.put("#(拍屁股做鬼脸)", "yz_003");
        jnz.put("#(不)", "yz_004");
        jnz.put("#(河蟹掉啦)", "yz_005");
        jnz.put("#(哦耶)", "yz_006");
        jnz.put("#(我倒)", "yz_007");
        jnz.put("#(投降)", "yz_008");
        jnz.put("#(微笑)", "b01");
        jnz.put("#(帅哥)", "b02");
        jnz.put("#(美女)", "b03");
        jnz.put("#(老大)", "b04");
        jnz.put("#(哈哈哈)", "b05");
        jnz.put("#(奸笑)", "b06");
        jnz.put("#(傻乐)", "b07");
        jnz.put("#(飞吻)", "b08");
        jnz.put("#(害羞)", "b09");
        jnz.put("#(花痴)", "b10");
        jnz.put("#(憧憬)", "b11");
        jnz.put("#(你牛)", "b12");
        jnz.put("#(鼓掌)", "b13");
        jnz.put("#(可爱)", "b14");
        jnz.put("#(太委屈)", "b15");
        jnz.put("#(大哭)", "b16");
        jnz.put("#(泪奔)", "b17");
        jnz.put("#(寻死)", "b18");
        jnz.put("#(非常惊讶)", "b19");
        jnz.put("#(表示疑问)", "b20");
        jnz.put("#(暗中观察)", "image_emoticon85");
        jnz.put("#(吃瓜)", "image_emoticon86");
        jnz.put("#(喝酒)", "image_emoticon87");
        jnz.put("#(嘿嘿嘿)", "image_emoticon88");
        jnz.put("#(噗)", "image_emoticon89");
        jnz.put("#(困成狗)", "image_emoticon90");
        jnz.put("#(微微一笑)", "image_emoticon91");
        jnz.put("#(托腮)", "image_emoticon92");
        jnz.put("#(摊手)", "image_emoticon93");
        jnz.put("#(柯基暗中观察)", "image_emoticon94");
        jnz.put("#(欢呼)", "image_emoticon95");
        jnz.put("#(炸药)", "image_emoticon96");
        jnz.put("#(突然兴奋)", "image_emoticon97");
        jnz.put("#(紧张)", "image_emoticon98");
        jnz.put("#(黑头瞪眼)", "image_emoticon99");
        jnz.put("#(黑头高兴)", "image_emoticon100");
        jnz.put("#(不跟丑人说话)", "image_emoticon101");
        jnz.put("#(么么哒)", "image_emoticon102");
        jnz.put("#(亲亲才能起来)", "image_emoticon103");
        jnz.put("#(伦家只是宝宝)", "image_emoticon104");
        jnz.put("#(你是我的人)", "image_emoticon105");
        jnz.put("#(假装看不见)", "image_emoticon106");
        jnz.put("#(单身等撩)", "image_emoticon107");
        jnz.put("#(吓到宝宝了)", "image_emoticon108");
        jnz.put("#(哈哈哈)", "image_emoticon109");
        jnz.put("#(嗯嗯)", "image_emoticon110");
        jnz.put("#(好幸福)", "image_emoticon111");
        jnz.put("#(宝宝不开心)", "image_emoticon112");
        jnz.put("#(小姐姐别走)", "image_emoticon113");
        jnz.put("#(小姐姐在吗)", "image_emoticon114");
        jnz.put("#(小姐姐来啦)", "image_emoticon115");
        jnz.put("#(小姐姐来玩呀)", "image_emoticon116");
        jnz.put("#(我养你)", "image_emoticon117");
        jnz.put("#(我是不会骗你的)", "image_emoticon118");
        jnz.put("#(扎心了)", "image_emoticon119");
        jnz.put("#(无聊)", "image_emoticon120");
        jnz.put("#(月亮代表我的心)", "image_emoticon121");
        jnz.put("#(来追我呀)", "image_emoticon122");
        jnz.put("#(爱你的形状)", "image_emoticon123");
        jnz.put("#(白眼)", "image_emoticon124");
    }

    private static String Kz(String str) {
        return jnz.get(str);
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
                    String Kz = Kz(str3);
                    if (TextUtils.isEmpty(Kz)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            if (i == 1) {
                                tbRichTextData.n(str5);
                            } else {
                                SpannableString aL = aL(context, str5);
                                if (aL != null) {
                                    tbRichTextData.n(aL);
                                }
                            }
                            str4 = "";
                        }
                        SpannableString a = a(tbRichTextData.byL(), Kz, str3);
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
                    SpannableString aL2 = aL(context, str5);
                    if (aL2 != null) {
                        tbRichTextData.n(aL2);
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int Ck = TbFaceManager.bua().Ck(str);
        if (Ck != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst(), Ck);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            a.C0550a CF = TbFaceManager.bua().CF(str);
            if (CF != null) {
                int width = (int) (0.5d * CF.getWidth());
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString aL(Context context, String str) {
        if (str == null) {
            return null;
        }
        return be.aq(context, str);
    }
}
