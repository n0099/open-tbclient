package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, String> f1462a = new HashMap<>();

    static {
        f1462a.put("#(呵呵)", "image_emoticon");
        f1462a.put("#(哈哈)", "image_emoticon2");
        f1462a.put("#(吐舌)", "image_emoticon3");
        f1462a.put("#(啊)", "image_emoticon4");
        f1462a.put("#(啊?)", "image_emoticon4");
        f1462a.put("#(酷)", "image_emoticon5");
        f1462a.put("#(怒)", "image_emoticon6");
        f1462a.put("#(开心)", "image_emoticon7");
        f1462a.put("#(汗)", "image_emoticon8");
        f1462a.put("#(泪)", "image_emoticon9");
        f1462a.put("#(黑线)", "image_emoticon10");
        f1462a.put("#(鄙视)", "image_emoticon11");
        f1462a.put("#(不高兴)", "image_emoticon12");
        f1462a.put("#(真棒)", "image_emoticon13");
        f1462a.put("#(钱)", "image_emoticon14");
        f1462a.put("#(疑问)", "image_emoticon15");
        f1462a.put("#(阴险)", "image_emoticon16");
        f1462a.put("#(吐)", "image_emoticon17");
        f1462a.put("#(咦)", "image_emoticon18");
        f1462a.put("#(咦?)", "image_emoticon18");
        f1462a.put("#(委屈)", "image_emoticon19");
        f1462a.put("#(花心)", "image_emoticon20");
        f1462a.put("#(呼~)", "image_emoticon21");
        f1462a.put("#(笑眼)", "image_emoticon22");
        f1462a.put("#(冷)", "image_emoticon23");
        f1462a.put("#(太开心)", "image_emoticon24");
        f1462a.put("#(滑稽)", "image_emoticon25");
        f1462a.put("#(勉强)", "image_emoticon26");
        f1462a.put("#(狂汗)", "image_emoticon27");
        f1462a.put("#(乖)", "image_emoticon28");
        f1462a.put("#(睡觉)", "image_emoticon29");
        f1462a.put("#(惊哭)", "image_emoticon30");
        f1462a.put("#(升起)", "image_emoticon31");
        f1462a.put("#(惊讶)", "image_emoticon32");
        f1462a.put("#(喷)", "image_emoticon33");
        f1462a.put("#(爱心)", "image_emoticon34");
        f1462a.put("#(心碎)", "image_emoticon35");
        f1462a.put("#(玫瑰)", "image_emoticon36");
        f1462a.put("#(礼物)", "image_emoticon37");
        f1462a.put("#(彩虹)", "image_emoticon38");
        f1462a.put("#(星星月亮)", "image_emoticon39");
        f1462a.put("#(太阳)", "image_emoticon40");
        f1462a.put("#(钱币)", "image_emoticon41");
        f1462a.put("#(灯泡)", "image_emoticon42");
        f1462a.put("#(茶杯)", "image_emoticon43");
        f1462a.put("#(蛋糕)", "image_emoticon44");
        f1462a.put("#(音乐)", "image_emoticon45");
        f1462a.put("#(haha)", "image_emoticon46");
        f1462a.put("#(胜利)", "image_emoticon47");
        f1462a.put("#(大拇指)", "image_emoticon48");
        f1462a.put("#(弱)", "image_emoticon49");
        f1462a.put("#(OK)", "image_emoticon50");
        f1462a.put("#(哭着跑)", "ali_047");
        f1462a.put("#(惆怅~)", "ali_050");
        f1462a.put("#(摸头)", "ali_051");
        f1462a.put("#(蹭)", "ali_052");
        f1462a.put("#(打滚)", "ali_053");
        f1462a.put("#(叩拜)", "ali_054");
        f1462a.put("#(摸)", "ali_055");
        f1462a.put("#(数钱)", "ali_056");
        f1462a.put("#(加1)", "ali_059");
        f1462a.put("#(压力)", "ali_060");
        f1462a.put("#(表逼我)", "ali_061");
        f1462a.put("#(摇晃)", "ali_063");
        f1462a.put("#(打地鼠)", "ali_064");
        f1462a.put("#(这个屌)", "ali_065");
        f1462a.put("#(恐慌)", "ali_066");
        f1462a.put("#(晕乎乎)", "ali_067");
        f1462a.put("#(浮云)", "ali_068");
        f1462a.put("#(给力)", "ali_069");
        f1462a.put("#(杯具了)", "ali_070");
        f1462a.put("#(焦糖舞)", "yz_001");
        f1462a.put("#(翻滚)", "yz_002");
        f1462a.put("#(拍屁股做鬼脸)", "yz_003");
        f1462a.put("#(不)", "yz_004");
        f1462a.put("#(河蟹掉啦)", "yz_005");
        f1462a.put("#(哦耶)", "yz_006");
        f1462a.put("#(我倒)", "yz_007");
        f1462a.put("#(投降)", "yz_008");
        f1462a.put("#(听音乐)", "yz_009");
        f1462a.put("#(被砸)", "yz_010");
        f1462a.put("#(吐舌头)", "yz_011");
        f1462a.put("#(太好啦)", "yz_012");
        f1462a.put("#(财源滚滚)", "yz_013");
        f1462a.put("#(人去哪了)", "yz_014");
        f1462a.put("#(偷笑)", "yz_016");
        f1462a.put("#(卷被)", "yz_017");
        f1462a.put("#(看楼上)", "yz_018");
        f1462a.put("#(我抽)", "yz_019");
        f1462a.put("#(有木有)", "yz_020");
        f1462a.put("#(哭)", "yz_021");
        f1462a.put("#(微笑)", "b01");
        f1462a.put("#(帅哥)", "b02");
        f1462a.put("#(美女)", "b03");
        f1462a.put("#(老大)", "b04");
        f1462a.put("#(哈哈哈)", "b05");
        f1462a.put("#(奸笑)", "b06");
        f1462a.put("#(傻乐)", "b07");
        f1462a.put("#(飞吻)", "b08");
        f1462a.put("#(害羞)", "b09");
        f1462a.put("#(花痴)", "b10");
        f1462a.put("#(憧憬)", "b11");
        f1462a.put("#(你牛)", "b12");
        f1462a.put("#(鼓掌)", "b13");
        f1462a.put("#(可爱)", "b14");
        f1462a.put("#(太委屈)", "b15");
        f1462a.put("#(大哭)", "b16");
        f1462a.put("#(泪奔)", "b17");
        f1462a.put("#(寻死)", "b18");
        f1462a.put("#(非常惊讶)", "b19");
        f1462a.put("#(表示疑问)", "b20");
        f1462a.put("#(打人)", "B_0028");
        f1462a.put("#(摇摆)", "B_0053");
        f1462a.put("#(理想)", "B_0059");
        f1462a.put("#(鬼脸~)", "B_0010");
        f1462a.put("#(十分惊讶)", "ali_003");
        f1462a.put("#(思考者)", "yz_043");
        f1462a.put("#(流泪)", "B_0016");
        f1462a.put("#(吃惊)", "ali_006");
        f1462a.put("#(狂笑)", "ali_031");
        f1462a.put("#(苹果)", "B_0041");
        f1462a.put("#(嚷)", "ali_034");
        f1462a.put("#(转圈哭)", "ali_009");
        f1462a.put("#(套娃娃)", "B_0047");
        f1462a.put("#(人呢)", "ali_062");
        f1462a.put("#(爆笑)", "ali_037");
        f1462a.put("#(不要)", "B_0004");
        f1462a.put("#(没有钱)", "yz_031");
        f1462a.put("#(隆重介绍)", "yz_037");
        f1462a.put("#(大变身)", "B_0035");
        f1462a.put("#(殴打)", "B_0060");
        f1462a.put("#(拍手)", "yz_025");
        f1462a.put("#(点头)", "ali_020");
        f1462a.put("#(汗~)", "B_0023");
        f1462a.put("#(寒)", "ali_023");
        f1462a.put("#(疯)", "ali_026");
        f1462a.put("#(蹦跳)", "B_0029");
        f1462a.put("#(蜷)", "ali_029");
        f1462a.put("#(杂耍)", "B_0054");
        f1462a.put("#(拖走)", "ali_057");
        f1462a.put("#(害羞~)", "B_0011");
        f1462a.put("#(抽风)", "yz_044");
        f1462a.put("#(生气)", "B_0017");
        f1462a.put("#(亲)", "B_0042");
        f1462a.put("#(捅捅)", "B_0048");
        f1462a.put("#(变脸)", "B_0030");
        f1462a.put("#(惊汗)", "ali_012");
        f1462a.put("#(扯花)", "B_0005");
        f1462a.put("#(拿玩偶)", "yz_032");
        f1462a.put("#(十分开心)", "ali_040");
        f1462a.put("#(遁)", "ali_015");
        f1462a.put("#(飞天舞)", "B_0036");
        f1462a.put("#(蛋花哭)", "ali_018");
        f1462a.put("#(潜)", "ali_043");
        f1462a.put("#(呕吐~)", "B_0061");
        f1462a.put("#(狂吐)", "ali_046");
        f1462a.put("#(求你了)", "yz_038");
        f1462a.put("#(冷死了)", "ali_049");
        f1462a.put("#(紧张)", "yz_026");
        f1462a.put("#(鄙视！)", "B_0024");
        f1462a.put("#(招财)", "B_0055");
        f1462a.put("#(赖皮)", "ali_001");
        f1462a.put("#(口水)", "B_0012");
        f1462a.put("#(怒气)", "ali_004");
        f1462a.put("#(吃苹果)", "yz_045");
        f1462a.put("#(抱枕)", "ali_032");
        f1462a.put("#(嘲弄)", "ali_007");
        f1462a.put("#(吐舌~)", "B_0018");
        f1462a.put("#(耍赖)", "B_0043");
        f1462a.put("#(唠叨)", "ali_035");
        f1462a.put("#(舞倒)", "B_0049");
        f1462a.put("#(郁闷)", "ali_038");
        f1462a.put("#(扯肉)", "B_0031");
        f1462a.put("#(大心)", "B_0006");
        f1462a.put("#(来看看)", "yz_033");
        f1462a.put("#(撞玻璃)", "yz_039");
        f1462a.put("#(回眸)", "B_0037");
        f1462a.put("#(碎)", "B_0062");
        f1462a.put("#(撒钱)", "ali_021");
        f1462a.put("#(洗澡)", "yz_027");
        f1462a.put("#(拜~)", "B_0025");
        f1462a.put("#(西红柿)", "B_0050");
        f1462a.put("#(傻笑)", "ali_024");
        f1462a.put("#(抓狂)", "ali_027");
        f1462a.put("#(被殴)", "B_0056");
        f1462a.put("#(热)", "ali_058");
        f1462a.put("#(挥手帕)", "yz_015");
        f1462a.put("#(狂哭)", "B_0013");
        f1462a.put("#(眺望)", "yz_040");
        f1462a.put("#(光棍)", "yz_046");
        f1462a.put("#(喜欢)", "B_0019");
        f1462a.put("#(骚舞)", "B_0044");
        f1462a.put("#(HI)", "B_0001");
        f1462a.put("#(神经病)", "ali_010");
        f1462a.put("#(哇哇叫)", "yz_034");
        f1462a.put("#(顶)", "B_0007");
        f1462a.put("#(吃To)", "B_0032");
        f1462a.put("#(隐身)", "ali_013");
        f1462a.put("#(不公平)", "ali_016");
        f1462a.put("#(冷笑话)", "ali_041");
        f1462a.put("#(可怜)", "B_0038");
        f1462a.put("#(画圈圈)", "ali_044");
        f1462a.put("#(温暖)", "ali_019");
        f1462a.put("#(吐痰)", "B_0063");
        f1462a.put("#(欢呼)", "yz_022");
        f1462a.put("#(旋转~)", "B_0020");
        f1462a.put("#(耶)", "yz_028");
        f1462a.put("#(吐血)", "B_0026");
        f1462a.put("#(爱慕)", "B_0051");
        f1462a.put("#(被球闷)", "B_0057");
        f1462a.put("#(感动)", "ali_002");
        f1462a.put("#(来)", "B_0014");
        f1462a.put("#(挠墙)", "ali_030");
        f1462a.put("#(哭泣)", "ali_005");
        f1462a.put("#(撒花)", "yz_041");
        f1462a.put("#(飘过)", "ali_008");
        f1462a.put("#(吼叫)", "ali_033");
        f1462a.put("#(捏脸)", "ali_036");
        f1462a.put("#(烧香)", "B_0045");
        f1462a.put("#(潜水)", "ali_039");
        f1462a.put("#(KISS)", "B_0002");
        f1462a.put("#(招财猫)", "yz_035");
        f1462a.put("#(大惊)", "B_0008");
        f1462a.put("#(吃花)", "B_0033");
        f1462a.put("#(猛抽)", "B_0039");
        f1462a.put("#(傻兮兮)", "yz_023");
        f1462a.put("#(再见)", "B_0021");
        f1462a.put("#(献花)", "ali_022");
        f1462a.put("#(嘘)", "B_0027");
        f1462a.put("#(扭扭)", "ali_025");
        f1462a.put("#(摇)", "B_0052");
        f1462a.put("#(吃西瓜)", "yz_029");
        f1462a.put("#(抓)", "ali_028");
        f1462a.put("#(大惊~)", "B_0058");
        f1462a.put("#(玩铃铛)", "yz_042");
        f1462a.put("#(泪眼)", "B_0015");
        f1462a.put("#(泡泡)", "B_0040");
        f1462a.put("#(睡)", "B_0046");
        f1462a.put("#(不说)", "B_0003");
        f1462a.put("#(揪耳朵)", "ali_011");
        f1462a.put("#(纳尼)", "yz_030");
        f1462a.put("#(放屁)", "yz_036");
        f1462a.put("#(不要嘛)", "ali_014");
        f1462a.put("#(吹泡泡糖)", "B_0034");
        f1462a.put("#(飞个吻)", "B_0009");
        f1462a.put("#(顶！)", "ali_042");
        f1462a.put("#(爬来了)", "ali_017");
        f1462a.put("#(玩电脑)", "ali_045");
        f1462a.put("#(阿狸侠)", "ali_048");
        f1462a.put("#(扇扇子)", "yz_024");
        f1462a.put("#(抓狂~)", "B_0022");
    }

    private static String a(String str) {
        return f1462a.get(str);
    }

    public static ArrayList<com.baidu.tbadk.widget.richText.c> a(Context context, String str) {
        String str2;
        String str3;
        String str4;
        ArrayList<com.baidu.tbadk.widget.richText.c> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        com.baidu.tbadk.widget.richText.c cVar = new com.baidu.tbadk.widget.richText.c(1);
        arrayList.add(cVar);
        try {
            String str5 = "";
            int length = str.length();
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt == '#' && i < length - 1 && str.charAt(i + 1) == '(') {
                    int i2 = i + 2;
                    String str6 = "#(";
                    while (true) {
                        if (i2 >= length) {
                            str3 = str6;
                            break;
                        }
                        char charAt2 = str.charAt(i2);
                        str6 = str6 + charAt2;
                        if (charAt2 != ')') {
                            if (i2 + 1 < length && str.charAt(i2 + 1) == '#') {
                                str3 = str6;
                                break;
                            }
                            i2++;
                        } else {
                            str3 = str6;
                            break;
                        }
                    }
                    String a2 = a(str3);
                    if (TextUtils.isEmpty(a2)) {
                        str4 = str5 + str3;
                    } else {
                        if (TextUtils.isEmpty(str5)) {
                            str4 = str5;
                        } else {
                            SpannableString spannableString = new SpannableString(str5);
                            if (spannableString != null) {
                                cVar.a(spannableString);
                            }
                            str4 = "";
                        }
                        SpannableString a3 = a(context, cVar.b(), a2, str3);
                        if (a3 != null) {
                            cVar.a(a3);
                        }
                    }
                    int i3 = i2;
                    str2 = str4;
                    i = i3;
                } else {
                    str2 = str5 + charAt;
                }
                i++;
                str5 = str2;
            }
            if (!TextUtils.isEmpty(str5)) {
                SpannableString spannableString2 = new SpannableString(str5);
                if (spannableString2 != null) {
                    cVar.a(spannableString2);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.a("error = " + e.getMessage());
        }
        return arrayList;
    }

    private static SpannableString a(Context context, ArrayList<com.baidu.tbadk.widget.richText.d> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int b = TbFaceManager.a().b(str);
        if (b != 0) {
            spannableString = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(context, b);
            if (arrayList != null) {
                arrayList.add(dVar);
            }
            com.baidu.tbadk.imageManager.b c = TbFaceManager.a().c(str);
            if (c != null) {
                dVar.setBounds(new Rect(0, 0, c.a(), c.b()));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }
}
