package com.baidu.tbadk.editortool;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.imageManager.b {
    protected static final HashMap<String, Integer> aji = new HashMap<>();
    public static final ArrayList<Integer> ajj = new ArrayList<>();
    public static final HashMap<String, Integer> ajk = new HashMap<>();
    private static final HashMap<String, String> ajl = new HashMap<>();

    static {
        ajl.put("image_emoticon", "呵呵");
        ajl.put("image_emoticon2", "哈哈");
        ajl.put("image_emoticon3", "吐舌");
        ajl.put("image_emoticon4", "啊?");
        ajl.put("image_emoticon5", "酷");
        ajl.put("image_emoticon6", "怒");
        ajl.put("image_emoticon7", "开心");
        ajl.put("image_emoticon8", "汗");
        ajl.put("image_emoticon9", "泪");
        ajl.put("image_emoticon10", "黑线");
        ajl.put("image_emoticon11", "鄙视");
        ajl.put("image_emoticon12", "不高兴");
        ajl.put("image_emoticon13", "真棒");
        ajl.put("image_emoticon14", "钱");
        ajl.put("image_emoticon15", "疑问");
        ajl.put("image_emoticon16", "阴险");
        ajl.put("image_emoticon17", "吐");
        ajl.put("image_emoticon18", "咦?");
        ajl.put("image_emoticon19", "委屈");
        ajl.put("image_emoticon20", "花心");
        ajl.put("image_emoticon21", "呼~");
        ajl.put("image_emoticon22", "笑眼");
        ajl.put("image_emoticon23", "冷");
        ajl.put("image_emoticon24", "太开心");
        ajl.put("image_emoticon25", "滑稽");
        ajl.put("image_emoticon26", "勉强");
        ajl.put("image_emoticon27", "狂汗");
        ajl.put("image_emoticon28", "乖");
        ajl.put("image_emoticon29", "睡觉");
        ajl.put("image_emoticon30", "惊哭");
        ajl.put("image_emoticon31", "升起");
        ajl.put("image_emoticon32", "惊讶");
        ajl.put("image_emoticon33", "喷");
        ajl.put("image_emoticon34", "爱心");
        ajl.put("image_emoticon35", "心碎");
        ajl.put("image_emoticon36", "玫瑰");
        ajl.put("image_emoticon37", "礼物");
        ajl.put("image_emoticon38", "彩虹");
        ajl.put("image_emoticon39", "星星月亮");
        ajl.put("image_emoticon40", "太阳");
        ajl.put("image_emoticon41", "钱币");
        ajl.put("image_emoticon42", "灯泡");
        ajl.put("image_emoticon43", "茶杯");
        ajl.put("image_emoticon44", "蛋糕");
        ajl.put("image_emoticon45", "音乐");
        ajl.put("image_emoticon46", "haha");
        ajl.put("image_emoticon47", "胜利");
        ajl.put("image_emoticon48", "大拇指");
        ajl.put("image_emoticon49", "弱");
        ajl.put("image_emoticon50", "OK");
        ajl.put("ali_047", "哭着跑");
        ajl.put("ali_050", "惆怅~");
        ajl.put("ali_051", "摸头");
        ajl.put("ali_052", "蹭");
        ajl.put("ali_053", "打滚");
        ajl.put("ali_054", "叩拜");
        ajl.put("ali_055", "摸");
        ajl.put("ali_056", "数钱");
        ajl.put("ali_059", "加1");
        ajl.put("ali_060", "压力");
        ajl.put("ali_061", "表逼我");
        ajl.put("ali_062", "人呢");
        ajl.put("ali_063", "摇晃");
        ajl.put("ali_064", "打地鼠");
        ajl.put("ali_065", "这个屌");
        ajl.put("ali_066", "恐慌");
        ajl.put("ali_067", "晕乎乎");
        ajl.put("ali_068", "浮云");
        ajl.put("ali_069", "给力");
        ajl.put("ali_070", "杯具了");
        ajl.put("b01", "微笑");
        ajl.put("b02", "帅哥");
        ajl.put("b03", "美女");
        ajl.put("b04", "老大");
        ajl.put("b05", "哈哈哈");
        ajl.put("b06", "奸笑");
        ajl.put("b07", "傻乐");
        ajl.put("b08", "飞吻");
        ajl.put("b09", "害羞");
        ajl.put("b10", "花痴");
        ajl.put("b11", "憧憬");
        ajl.put("b12", "你牛");
        ajl.put("b13", "鼓掌");
        ajl.put("b14", "可爱");
        ajl.put("b15", "太委屈");
        ajl.put("b16", "大哭");
        ajl.put("b17", "泪奔");
        ajl.put("b18", "寻死");
        ajl.put("b19", "非常惊讶");
        ajl.put("b20", "表示疑问");
        ajl.put("yz_001", "焦糖舞");
        ajl.put("yz_002", "翻滚");
        ajl.put("yz_003", "拍屁股做鬼脸");
        ajl.put("yz_004", "不");
        ajl.put("yz_005", "河蟹掉啦");
        ajl.put("yz_006", "哦耶");
        ajl.put("yz_007", "我倒");
        ajl.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int ed(String str) {
        Integer num = aji.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(com.baidu.tieba.u.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int ee(String str) {
        Integer num = ajk.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public String ef(String str) {
        return ajl.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int yF() {
        return ajj.size();
    }

    @Override // com.baidu.tbadk.imageManager.b
    public com.baidu.tbadk.imageManager.c D(Context context, String str) {
        return null;
    }
}
