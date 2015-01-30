package com.baidu.tbadk.editortool;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.b {
    protected static final HashMap<String, Integer> YO = new HashMap<>();
    public static final ArrayList<Integer> YP = new ArrayList<>();
    public static final HashMap<String, Integer> YQ = new HashMap<>();
    private static final HashMap<String, String> YR = new HashMap<>();

    static {
        YR.put("image_emoticon", "呵呵");
        YR.put("image_emoticon2", "哈哈");
        YR.put("image_emoticon3", "吐舌");
        YR.put("image_emoticon4", "啊?");
        YR.put("image_emoticon5", "酷");
        YR.put("image_emoticon6", "怒");
        YR.put("image_emoticon7", "开心");
        YR.put("image_emoticon8", "汗");
        YR.put("image_emoticon9", "泪");
        YR.put("image_emoticon10", "黑线");
        YR.put("image_emoticon11", "鄙视");
        YR.put("image_emoticon12", "不高兴");
        YR.put("image_emoticon13", "真棒");
        YR.put("image_emoticon14", "钱");
        YR.put("image_emoticon15", "疑问");
        YR.put("image_emoticon16", "阴险");
        YR.put("image_emoticon17", "吐");
        YR.put("image_emoticon18", "咦?");
        YR.put("image_emoticon19", "委屈");
        YR.put("image_emoticon20", "花心");
        YR.put("image_emoticon21", "呼~");
        YR.put("image_emoticon22", "笑眼");
        YR.put("image_emoticon23", "冷");
        YR.put("image_emoticon24", "太开心");
        YR.put("image_emoticon25", "滑稽");
        YR.put("image_emoticon26", "勉强");
        YR.put("image_emoticon27", "狂汗");
        YR.put("image_emoticon28", "乖");
        YR.put("image_emoticon29", "睡觉");
        YR.put("image_emoticon30", "惊哭");
        YR.put("image_emoticon31", "升起");
        YR.put("image_emoticon32", "惊讶");
        YR.put("image_emoticon33", "喷");
        YR.put("image_emoticon34", "爱心");
        YR.put("image_emoticon35", "心碎");
        YR.put("image_emoticon36", "玫瑰");
        YR.put("image_emoticon37", "礼物");
        YR.put("image_emoticon38", "彩虹");
        YR.put("image_emoticon39", "星星月亮");
        YR.put("image_emoticon40", "太阳");
        YR.put("image_emoticon41", "钱币");
        YR.put("image_emoticon42", "灯泡");
        YR.put("image_emoticon43", "茶杯");
        YR.put("image_emoticon44", "蛋糕");
        YR.put("image_emoticon45", "音乐");
        YR.put("image_emoticon46", "haha");
        YR.put("image_emoticon47", "胜利");
        YR.put("image_emoticon48", "大拇指");
        YR.put("image_emoticon49", "弱");
        YR.put("image_emoticon50", "OK");
        YR.put("ali_047", "哭着跑");
        YR.put("ali_050", "惆怅~");
        YR.put("ali_051", "摸头");
        YR.put("ali_052", "蹭");
        YR.put("ali_053", "打滚");
        YR.put("ali_054", "叩拜");
        YR.put("ali_055", "摸");
        YR.put("ali_056", "数钱");
        YR.put("ali_059", "加1");
        YR.put("ali_060", "压力");
        YR.put("ali_061", "表逼我");
        YR.put("ali_062", "人呢");
        YR.put("ali_063", "摇晃");
        YR.put("ali_064", "打地鼠");
        YR.put("ali_065", "这个屌");
        YR.put("ali_066", "恐慌");
        YR.put("ali_067", "晕乎乎");
        YR.put("ali_068", "浮云");
        YR.put("ali_069", "给力");
        YR.put("ali_070", "杯具了");
        YR.put("b01", "微笑");
        YR.put("b02", "帅哥");
        YR.put("b03", "美女");
        YR.put("b04", "老大");
        YR.put("b05", "哈哈哈");
        YR.put("b06", "奸笑");
        YR.put("b07", "傻乐");
        YR.put("b08", "飞吻");
        YR.put("b09", "害羞");
        YR.put("b10", "花痴");
        YR.put("b11", "憧憬");
        YR.put("b12", "你牛");
        YR.put("b13", "鼓掌");
        YR.put("b14", "可爱");
        YR.put("b15", "太委屈");
        YR.put("b16", "大哭");
        YR.put("b17", "泪奔");
        YR.put("b18", "寻死");
        YR.put("b19", "非常惊讶");
        YR.put("b20", "表示疑问");
        YR.put("yz_001", "焦糖舞");
        YR.put("yz_002", "翻滚");
        YR.put("yz_003", "拍屁股做鬼脸");
        YR.put("yz_004", "不");
        YR.put("yz_005", "河蟹掉啦");
        YR.put("yz_006", "哦耶");
        YR.put("yz_007", "我倒");
        YR.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int dZ(String str) {
        Integer num = YO.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(com.baidu.tieba.v.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int ea(String str) {
        Integer num = YQ.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public String eb(String str) {
        return YR.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int vr() {
        return YP.size();
    }

    @Override // com.baidu.tbadk.imageManager.b
    public com.baidu.tbadk.imageManager.c D(Context context, String str) {
        return null;
    }
}
