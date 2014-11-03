package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ba {
    private static final HashMap<String, String> aOp = new HashMap<>();

    static {
        aOp.put("#(呵呵)", "image_emoticon");
        aOp.put("#(哈哈)", "image_emoticon2");
        aOp.put("#(吐舌)", "image_emoticon3");
        aOp.put("#(啊)", "image_emoticon4");
        aOp.put("#(啊?)", "image_emoticon4");
        aOp.put("#(酷)", "image_emoticon5");
        aOp.put("#(怒)", "image_emoticon6");
        aOp.put("#(开心)", "image_emoticon7");
        aOp.put("#(汗)", "image_emoticon8");
        aOp.put("#(泪)", "image_emoticon9");
        aOp.put("#(黑线)", "image_emoticon10");
        aOp.put("#(鄙视)", "image_emoticon11");
        aOp.put("#(不高兴)", "image_emoticon12");
        aOp.put("#(真棒)", "image_emoticon13");
        aOp.put("#(钱)", "image_emoticon14");
        aOp.put("#(疑问)", "image_emoticon15");
        aOp.put("#(阴险)", "image_emoticon16");
        aOp.put("#(吐)", "image_emoticon17");
        aOp.put("#(咦)", "image_emoticon18");
        aOp.put("#(咦?)", "image_emoticon18");
        aOp.put("#(委屈)", "image_emoticon19");
        aOp.put("#(花心)", "image_emoticon20");
        aOp.put("#(呼~)", "image_emoticon21");
        aOp.put("#(笑眼)", "image_emoticon22");
        aOp.put("#(冷)", "image_emoticon23");
        aOp.put("#(太开心)", "image_emoticon24");
        aOp.put("#(滑稽)", "image_emoticon25");
        aOp.put("#(勉强)", "image_emoticon26");
        aOp.put("#(狂汗)", "image_emoticon27");
        aOp.put("#(乖)", "image_emoticon28");
        aOp.put("#(睡觉)", "image_emoticon29");
        aOp.put("#(惊哭)", "image_emoticon30");
        aOp.put("#(升起)", "image_emoticon31");
        aOp.put("#(惊讶)", "image_emoticon32");
        aOp.put("#(喷)", "image_emoticon33");
        aOp.put("#(爱心)", "image_emoticon34");
        aOp.put("#(心碎)", "image_emoticon35");
        aOp.put("#(玫瑰)", "image_emoticon36");
        aOp.put("#(礼物)", "image_emoticon37");
        aOp.put("#(彩虹)", "image_emoticon38");
        aOp.put("#(星星月亮)", "image_emoticon39");
        aOp.put("#(太阳)", "image_emoticon40");
        aOp.put("#(钱币)", "image_emoticon41");
        aOp.put("#(灯泡)", "image_emoticon42");
        aOp.put("#(茶杯)", "image_emoticon43");
        aOp.put("#(蛋糕)", "image_emoticon44");
        aOp.put("#(音乐)", "image_emoticon45");
        aOp.put("#(haha)", "image_emoticon46");
        aOp.put("#(胜利)", "image_emoticon47");
        aOp.put("#(大拇指)", "image_emoticon48");
        aOp.put("#(弱)", "image_emoticon49");
        aOp.put("#(OK)", "image_emoticon50");
        aOp.put("#(哭着跑)", "ali_047");
        aOp.put("#(惆怅~)", "ali_050");
        aOp.put("#(摸头)", "ali_051");
        aOp.put("#(蹭)", "ali_052");
        aOp.put("#(打滚)", "ali_053");
        aOp.put("#(叩拜)", "ali_054");
        aOp.put("#(摸)", "ali_055");
        aOp.put("#(数钱)", "ali_056");
        aOp.put("#(加1)", "ali_059");
        aOp.put("#(压力)", "ali_060");
        aOp.put("#(表逼我)", "ali_061");
        aOp.put("#(摇晃)", "ali_063");
        aOp.put("#(打地鼠)", "ali_064");
        aOp.put("#(这个屌)", "ali_065");
        aOp.put("#(恐慌)", "ali_066");
        aOp.put("#(晕乎乎)", "ali_067");
        aOp.put("#(浮云)", "ali_068");
        aOp.put("#(给力)", "ali_069");
        aOp.put("#(杯具了)", "ali_070");
        aOp.put("#(焦糖舞)", "yz_001");
        aOp.put("#(翻滚)", "yz_002");
        aOp.put("#(拍屁股做鬼脸)", "yz_003");
        aOp.put("#(不)", "yz_004");
        aOp.put("#(河蟹掉啦)", "yz_005");
        aOp.put("#(哦耶)", "yz_006");
        aOp.put("#(我倒)", "yz_007");
        aOp.put("#(投降)", "yz_008");
        aOp.put("#(微笑)", "b01");
        aOp.put("#(帅哥)", "b02");
        aOp.put("#(美女)", "b03");
        aOp.put("#(老大)", "b04");
        aOp.put("#(哈哈哈)", "b05");
        aOp.put("#(奸笑)", "b06");
        aOp.put("#(傻乐)", "b07");
        aOp.put("#(飞吻)", "b08");
        aOp.put("#(害羞)", "b09");
        aOp.put("#(花痴)", "b10");
        aOp.put("#(憧憬)", "b11");
        aOp.put("#(你牛)", "b12");
        aOp.put("#(鼓掌)", "b13");
        aOp.put("#(可爱)", "b14");
        aOp.put("#(太委屈)", "b15");
        aOp.put("#(大哭)", "b16");
        aOp.put("#(泪奔)", "b17");
        aOp.put("#(寻死)", "b18");
        aOp.put("#(非常惊讶)", "b19");
        aOp.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return aOp.get(str);
    }

    public static ArrayList<com.baidu.tbadk.widget.richText.c> C(Context context, String str) {
        ArrayList<com.baidu.tbadk.widget.richText.c> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        com.baidu.tbadk.widget.richText.c cVar = new com.baidu.tbadk.widget.richText.c(1);
        arrayList.add(cVar);
        try {
            String str2 = "";
            int length = str.length();
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt == '#' && i < length - 1 && str.charAt(i + 1) == '(') {
                    String str3 = "#(";
                    i += 2;
                    while (i < length) {
                        char charAt2 = str.charAt(i);
                        str3 = String.valueOf(str3) + charAt2;
                        if (charAt2 == ')' || (i + 1 < length && str.charAt(i + 1) == '#')) {
                            break;
                        }
                        i++;
                    }
                    String name = getName(str3);
                    if (TextUtils.isEmpty(name)) {
                        str2 = String.valueOf(str2) + str3;
                    } else {
                        if (!TextUtils.isEmpty(str2)) {
                            SpannableString D = D(context, str2);
                            if (D != null) {
                                cVar.append(D);
                            }
                            str2 = "";
                        }
                        SpannableString a = a(cVar.vE(), name, str3);
                        if (a != null) {
                            cVar.append(a);
                        }
                    }
                } else {
                    str2 = String.valueOf(str2) + charAt;
                }
                i++;
            }
            if (!TextUtils.isEmpty(str2)) {
                SpannableString D2 = D(context, str2);
                if (D2 != null) {
                    cVar.append(D2);
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString a(ArrayList<com.baidu.tbadk.widget.richText.f> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int dd = TbFaceManager.sh().dd(str);
        if (dd != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(TbadkApplication.m251getInst(), dd);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            com.baidu.tbadk.imageManager.c dp = TbFaceManager.sh().dp(str);
            if (dp != null) {
                fVar.setBounds(new Rect(0, 0, dp.getWidth(), dp.getHeight()));
            } else {
                fVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(fVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString D(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.bg.n(context, str);
    }
}
