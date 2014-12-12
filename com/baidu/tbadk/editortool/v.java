package com.baidu.tbadk.editortool;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.b {
    protected static final HashMap<String, Integer> Yi = new HashMap<>();
    public static final ArrayList<Integer> Yj = new ArrayList<>();
    public static final HashMap<String, Integer> Yk = new HashMap<>();
    private static final HashMap<String, String> Yl = new HashMap<>();

    static {
        Yl.put("image_emoticon", "呵呵");
        Yl.put("image_emoticon2", "哈哈");
        Yl.put("image_emoticon3", "吐舌");
        Yl.put("image_emoticon4", "啊?");
        Yl.put("image_emoticon5", "酷");
        Yl.put("image_emoticon6", "怒");
        Yl.put("image_emoticon7", "开心");
        Yl.put("image_emoticon8", "汗");
        Yl.put("image_emoticon9", "泪");
        Yl.put("image_emoticon10", "黑线");
        Yl.put("image_emoticon11", "鄙视");
        Yl.put("image_emoticon12", "不高兴");
        Yl.put("image_emoticon13", "真棒");
        Yl.put("image_emoticon14", "钱");
        Yl.put("image_emoticon15", "疑问");
        Yl.put("image_emoticon16", "阴险");
        Yl.put("image_emoticon17", "吐");
        Yl.put("image_emoticon18", "咦?");
        Yl.put("image_emoticon19", "委屈");
        Yl.put("image_emoticon20", "花心");
        Yl.put("image_emoticon21", "呼~");
        Yl.put("image_emoticon22", "笑眼");
        Yl.put("image_emoticon23", "冷");
        Yl.put("image_emoticon24", "太开心");
        Yl.put("image_emoticon25", "滑稽");
        Yl.put("image_emoticon26", "勉强");
        Yl.put("image_emoticon27", "狂汗");
        Yl.put("image_emoticon28", "乖");
        Yl.put("image_emoticon29", "睡觉");
        Yl.put("image_emoticon30", "惊哭");
        Yl.put("image_emoticon31", "升起");
        Yl.put("image_emoticon32", "惊讶");
        Yl.put("image_emoticon33", "喷");
        Yl.put("image_emoticon34", "爱心");
        Yl.put("image_emoticon35", "心碎");
        Yl.put("image_emoticon36", "玫瑰");
        Yl.put("image_emoticon37", "礼物");
        Yl.put("image_emoticon38", "彩虹");
        Yl.put("image_emoticon39", "星星月亮");
        Yl.put("image_emoticon40", "太阳");
        Yl.put("image_emoticon41", "钱币");
        Yl.put("image_emoticon42", "灯泡");
        Yl.put("image_emoticon43", "茶杯");
        Yl.put("image_emoticon44", "蛋糕");
        Yl.put("image_emoticon45", "音乐");
        Yl.put("image_emoticon46", "haha");
        Yl.put("image_emoticon47", "胜利");
        Yl.put("image_emoticon48", "大拇指");
        Yl.put("image_emoticon49", "弱");
        Yl.put("image_emoticon50", "OK");
        Yl.put("ali_047", "哭着跑");
        Yl.put("ali_050", "惆怅~");
        Yl.put("ali_051", "摸头");
        Yl.put("ali_052", "蹭");
        Yl.put("ali_053", "打滚");
        Yl.put("ali_054", "叩拜");
        Yl.put("ali_055", "摸");
        Yl.put("ali_056", "数钱");
        Yl.put("ali_059", "加1");
        Yl.put("ali_060", "压力");
        Yl.put("ali_061", "表逼我");
        Yl.put("ali_062", "人呢");
        Yl.put("ali_063", "摇晃");
        Yl.put("ali_064", "打地鼠");
        Yl.put("ali_065", "这个屌");
        Yl.put("ali_066", "恐慌");
        Yl.put("ali_067", "晕乎乎");
        Yl.put("ali_068", "浮云");
        Yl.put("ali_069", "给力");
        Yl.put("ali_070", "杯具了");
        Yl.put("b01", "微笑");
        Yl.put("b02", "帅哥");
        Yl.put("b03", "美女");
        Yl.put("b04", "老大");
        Yl.put("b05", "哈哈哈");
        Yl.put("b06", "奸笑");
        Yl.put("b07", "傻乐");
        Yl.put("b08", "飞吻");
        Yl.put("b09", "害羞");
        Yl.put("b10", "花痴");
        Yl.put("b11", "憧憬");
        Yl.put("b12", "你牛");
        Yl.put("b13", "鼓掌");
        Yl.put("b14", "可爱");
        Yl.put("b15", "太委屈");
        Yl.put("b16", "大哭");
        Yl.put("b17", "泪奔");
        Yl.put("b18", "寻死");
        Yl.put("b19", "非常惊讶");
        Yl.put("b20", "表示疑问");
        Yl.put("yz_001", "焦糖舞");
        Yl.put("yz_002", "翻滚");
        Yl.put("yz_003", "拍屁股做鬼脸");
        Yl.put("yz_004", "不");
        Yl.put("yz_005", "河蟹掉啦");
        Yl.put("yz_006", "哦耶");
        Yl.put("yz_007", "我倒");
        Yl.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int dZ(String str) {
        Integer num = Yi.get(str);
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
        Integer num = Yk.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public String eb(String str) {
        return Yl.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int va() {
        return Yj.size();
    }

    @Override // com.baidu.tbadk.imageManager.b
    public com.baidu.tbadk.imageManager.c E(Context context, String str) {
        return null;
    }
}
