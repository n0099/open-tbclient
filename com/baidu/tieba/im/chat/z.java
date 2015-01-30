package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class z {
    private static final HashMap<String, String> str2faceName = new HashMap<>();

    static {
        str2faceName.put("#(呵呵)", "image_emoticon");
        str2faceName.put("#(哈哈)", "image_emoticon2");
        str2faceName.put("#(吐舌)", "image_emoticon3");
        str2faceName.put("#(啊)", "image_emoticon4");
        str2faceName.put("#(啊?)", "image_emoticon4");
        str2faceName.put("#(酷)", "image_emoticon5");
        str2faceName.put("#(怒)", "image_emoticon6");
        str2faceName.put("#(开心)", "image_emoticon7");
        str2faceName.put("#(汗)", "image_emoticon8");
        str2faceName.put("#(泪)", "image_emoticon9");
        str2faceName.put("#(黑线)", "image_emoticon10");
        str2faceName.put("#(鄙视)", "image_emoticon11");
        str2faceName.put("#(不高兴)", "image_emoticon12");
        str2faceName.put("#(真棒)", "image_emoticon13");
        str2faceName.put("#(钱)", "image_emoticon14");
        str2faceName.put("#(疑问)", "image_emoticon15");
        str2faceName.put("#(阴险)", "image_emoticon16");
        str2faceName.put("#(吐)", "image_emoticon17");
        str2faceName.put("#(咦)", "image_emoticon18");
        str2faceName.put("#(咦?)", "image_emoticon18");
        str2faceName.put("#(委屈)", "image_emoticon19");
        str2faceName.put("#(花心)", "image_emoticon20");
        str2faceName.put("#(呼~)", "image_emoticon21");
        str2faceName.put("#(笑眼)", "image_emoticon22");
        str2faceName.put("#(冷)", "image_emoticon23");
        str2faceName.put("#(太开心)", "image_emoticon24");
        str2faceName.put("#(滑稽)", "image_emoticon25");
        str2faceName.put("#(勉强)", "image_emoticon26");
        str2faceName.put("#(狂汗)", "image_emoticon27");
        str2faceName.put("#(乖)", "image_emoticon28");
        str2faceName.put("#(睡觉)", "image_emoticon29");
        str2faceName.put("#(惊哭)", "image_emoticon30");
        str2faceName.put("#(升起)", "image_emoticon31");
        str2faceName.put("#(惊讶)", "image_emoticon32");
        str2faceName.put("#(喷)", "image_emoticon33");
        str2faceName.put("#(爱心)", "image_emoticon34");
        str2faceName.put("#(心碎)", "image_emoticon35");
        str2faceName.put("#(玫瑰)", "image_emoticon36");
        str2faceName.put("#(礼物)", "image_emoticon37");
        str2faceName.put("#(彩虹)", "image_emoticon38");
        str2faceName.put("#(星星月亮)", "image_emoticon39");
        str2faceName.put("#(太阳)", "image_emoticon40");
        str2faceName.put("#(钱币)", "image_emoticon41");
        str2faceName.put("#(灯泡)", "image_emoticon42");
        str2faceName.put("#(茶杯)", "image_emoticon43");
        str2faceName.put("#(蛋糕)", "image_emoticon44");
        str2faceName.put("#(音乐)", "image_emoticon45");
        str2faceName.put("#(haha)", "image_emoticon46");
        str2faceName.put("#(胜利)", "image_emoticon47");
        str2faceName.put("#(大拇指)", "image_emoticon48");
        str2faceName.put("#(弱)", "image_emoticon49");
        str2faceName.put("#(OK)", "image_emoticon50");
        str2faceName.put("#(哭着跑)", "ali_047");
        str2faceName.put("#(惆怅~)", "ali_050");
        str2faceName.put("#(摸头)", "ali_051");
        str2faceName.put("#(蹭)", "ali_052");
        str2faceName.put("#(打滚)", "ali_053");
        str2faceName.put("#(叩拜)", "ali_054");
        str2faceName.put("#(摸)", "ali_055");
        str2faceName.put("#(数钱)", "ali_056");
        str2faceName.put("#(加1)", "ali_059");
        str2faceName.put("#(压力)", "ali_060");
        str2faceName.put("#(表逼我)", "ali_061");
        str2faceName.put("#(摇晃)", "ali_063");
        str2faceName.put("#(打地鼠)", "ali_064");
        str2faceName.put("#(这个屌)", "ali_065");
        str2faceName.put("#(恐慌)", "ali_066");
        str2faceName.put("#(晕乎乎)", "ali_067");
        str2faceName.put("#(浮云)", "ali_068");
        str2faceName.put("#(给力)", "ali_069");
        str2faceName.put("#(杯具了)", "ali_070");
        str2faceName.put("#(焦糖舞)", "yz_001");
        str2faceName.put("#(翻滚)", "yz_002");
        str2faceName.put("#(拍屁股做鬼脸)", "yz_003");
        str2faceName.put("#(不)", "yz_004");
        str2faceName.put("#(河蟹掉啦)", "yz_005");
        str2faceName.put("#(哦耶)", "yz_006");
        str2faceName.put("#(我倒)", "yz_007");
        str2faceName.put("#(投降)", "yz_008");
        str2faceName.put("#(微笑)", "b01");
        str2faceName.put("#(帅哥)", "b02");
        str2faceName.put("#(美女)", "b03");
        str2faceName.put("#(老大)", "b04");
        str2faceName.put("#(哈哈哈)", "b05");
        str2faceName.put("#(奸笑)", "b06");
        str2faceName.put("#(傻乐)", "b07");
        str2faceName.put("#(飞吻)", "b08");
        str2faceName.put("#(害羞)", "b09");
        str2faceName.put("#(花痴)", "b10");
        str2faceName.put("#(憧憬)", "b11");
        str2faceName.put("#(你牛)", "b12");
        str2faceName.put("#(鼓掌)", "b13");
        str2faceName.put("#(可爱)", "b14");
        str2faceName.put("#(太委屈)", "b15");
        str2faceName.put("#(大哭)", "b16");
        str2faceName.put("#(泪奔)", "b17");
        str2faceName.put("#(寻死)", "b18");
        str2faceName.put("#(非常惊讶)", "b19");
        str2faceName.put("#(表示疑问)", "b20");
    }

    private static String getName(String str) {
        return str2faceName.get(str);
    }

    public static ArrayList<com.baidu.tbadk.widget.richText.c> parsonData(Context context, String str) {
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
                            SpannableString L = L(context, str2);
                            if (L != null) {
                                cVar.append(L);
                            }
                            str2 = "";
                        }
                        SpannableString faceSpannableString = getFaceSpannableString(cVar.Aj(), name, str3);
                        if (faceSpannableString != null) {
                            cVar.append(faceSpannableString);
                        }
                    }
                } else {
                    str2 = String.valueOf(str2) + charAt;
                }
                i++;
            }
            if (!TextUtils.isEmpty(str2)) {
                SpannableString L2 = L(context, str2);
                if (L2 != null) {
                    cVar.append(L2);
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    private static SpannableString getFaceSpannableString(ArrayList<com.baidu.tbadk.widget.richText.f> arrayList, String str, String str2) {
        SpannableString spannableString = null;
        int dZ = TbFaceManager.wd().dZ(str);
        if (dZ != 0) {
            spannableString = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(TbadkCoreApplication.m255getInst(), dZ);
            if (arrayList != null) {
                arrayList.add(fVar);
            }
            com.baidu.tbadk.imageManager.c ej = TbFaceManager.wd().ej(str);
            if (ej != null) {
                int width = (int) (0.5d * ej.getWidth());
                fVar.setBounds(new Rect(0, 0, width, width));
            } else {
                fVar.setBounds(new Rect(0, 0, 0, 0));
            }
            spannableString.setSpan(new ImageSpan(fVar, 0), 0, str2.length(), 33);
        }
        return spannableString;
    }

    private static SpannableString L(Context context, String str) {
        if (str == null) {
            return null;
        }
        return com.baidu.tbadk.core.util.bm.C(context, str);
    }
}
