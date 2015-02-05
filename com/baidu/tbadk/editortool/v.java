package com.baidu.tbadk.editortool;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.b {
    protected static final HashMap<String, Integer> YL = new HashMap<>();
    public static final ArrayList<Integer> YM = new ArrayList<>();
    public static final HashMap<String, Integer> YN = new HashMap<>();
    private static final HashMap<String, String> YO = new HashMap<>();

    static {
        YO.put("image_emoticon", "呵呵");
        YO.put("image_emoticon2", "哈哈");
        YO.put("image_emoticon3", "吐舌");
        YO.put("image_emoticon4", "啊?");
        YO.put("image_emoticon5", "酷");
        YO.put("image_emoticon6", "怒");
        YO.put("image_emoticon7", "开心");
        YO.put("image_emoticon8", "汗");
        YO.put("image_emoticon9", "泪");
        YO.put("image_emoticon10", "黑线");
        YO.put("image_emoticon11", "鄙视");
        YO.put("image_emoticon12", "不高兴");
        YO.put("image_emoticon13", "真棒");
        YO.put("image_emoticon14", "钱");
        YO.put("image_emoticon15", "疑问");
        YO.put("image_emoticon16", "阴险");
        YO.put("image_emoticon17", "吐");
        YO.put("image_emoticon18", "咦?");
        YO.put("image_emoticon19", "委屈");
        YO.put("image_emoticon20", "花心");
        YO.put("image_emoticon21", "呼~");
        YO.put("image_emoticon22", "笑眼");
        YO.put("image_emoticon23", "冷");
        YO.put("image_emoticon24", "太开心");
        YO.put("image_emoticon25", "滑稽");
        YO.put("image_emoticon26", "勉强");
        YO.put("image_emoticon27", "狂汗");
        YO.put("image_emoticon28", "乖");
        YO.put("image_emoticon29", "睡觉");
        YO.put("image_emoticon30", "惊哭");
        YO.put("image_emoticon31", "升起");
        YO.put("image_emoticon32", "惊讶");
        YO.put("image_emoticon33", "喷");
        YO.put("image_emoticon34", "爱心");
        YO.put("image_emoticon35", "心碎");
        YO.put("image_emoticon36", "玫瑰");
        YO.put("image_emoticon37", "礼物");
        YO.put("image_emoticon38", "彩虹");
        YO.put("image_emoticon39", "星星月亮");
        YO.put("image_emoticon40", "太阳");
        YO.put("image_emoticon41", "钱币");
        YO.put("image_emoticon42", "灯泡");
        YO.put("image_emoticon43", "茶杯");
        YO.put("image_emoticon44", "蛋糕");
        YO.put("image_emoticon45", "音乐");
        YO.put("image_emoticon46", "haha");
        YO.put("image_emoticon47", "胜利");
        YO.put("image_emoticon48", "大拇指");
        YO.put("image_emoticon49", "弱");
        YO.put("image_emoticon50", "OK");
        YO.put("ali_047", "哭着跑");
        YO.put("ali_050", "惆怅~");
        YO.put("ali_051", "摸头");
        YO.put("ali_052", "蹭");
        YO.put("ali_053", "打滚");
        YO.put("ali_054", "叩拜");
        YO.put("ali_055", "摸");
        YO.put("ali_056", "数钱");
        YO.put("ali_059", "加1");
        YO.put("ali_060", "压力");
        YO.put("ali_061", "表逼我");
        YO.put("ali_062", "人呢");
        YO.put("ali_063", "摇晃");
        YO.put("ali_064", "打地鼠");
        YO.put("ali_065", "这个屌");
        YO.put("ali_066", "恐慌");
        YO.put("ali_067", "晕乎乎");
        YO.put("ali_068", "浮云");
        YO.put("ali_069", "给力");
        YO.put("ali_070", "杯具了");
        YO.put("b01", "微笑");
        YO.put("b02", "帅哥");
        YO.put("b03", "美女");
        YO.put("b04", "老大");
        YO.put("b05", "哈哈哈");
        YO.put("b06", "奸笑");
        YO.put("b07", "傻乐");
        YO.put("b08", "飞吻");
        YO.put("b09", "害羞");
        YO.put("b10", "花痴");
        YO.put("b11", "憧憬");
        YO.put("b12", "你牛");
        YO.put("b13", "鼓掌");
        YO.put("b14", "可爱");
        YO.put("b15", "太委屈");
        YO.put("b16", "大哭");
        YO.put("b17", "泪奔");
        YO.put("b18", "寻死");
        YO.put("b19", "非常惊讶");
        YO.put("b20", "表示疑问");
        YO.put("yz_001", "焦糖舞");
        YO.put("yz_002", "翻滚");
        YO.put("yz_003", "拍屁股做鬼脸");
        YO.put("yz_004", "不");
        YO.put("yz_005", "河蟹掉啦");
        YO.put("yz_006", "哦耶");
        YO.put("yz_007", "我倒");
        YO.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int dW(String str) {
        Integer num = YL.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(com.baidu.tieba.v.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int dX(String str) {
        Integer num = YN.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public String dY(String str) {
        return YO.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int vl() {
        return YM.size();
    }

    @Override // com.baidu.tbadk.imageManager.b
    public com.baidu.tbadk.imageManager.c D(Context context, String str) {
        return null;
    }
}
