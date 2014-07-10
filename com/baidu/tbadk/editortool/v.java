package com.baidu.tbadk.editortool;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.b {
    protected static final HashMap<String, Integer> a = new HashMap<>();
    public static final ArrayList<Integer> b = new ArrayList<>();
    public static final HashMap<String, Integer> c = new HashMap<>();
    private static final HashMap<String, String> d = new HashMap<>();

    static {
        d.put("image_emoticon", "呵呵");
        d.put("image_emoticon2", "哈哈");
        d.put("image_emoticon3", "吐舌");
        d.put("image_emoticon4", "啊?");
        d.put("image_emoticon5", "酷");
        d.put("image_emoticon6", "怒");
        d.put("image_emoticon7", "开心");
        d.put("image_emoticon8", "汗");
        d.put("image_emoticon9", "泪");
        d.put("image_emoticon10", "黑线");
        d.put("image_emoticon11", "鄙视");
        d.put("image_emoticon12", "不高兴");
        d.put("image_emoticon13", "真棒");
        d.put("image_emoticon14", "钱");
        d.put("image_emoticon15", "疑问");
        d.put("image_emoticon16", "阴险");
        d.put("image_emoticon17", "吐");
        d.put("image_emoticon18", "咦?");
        d.put("image_emoticon19", "委屈");
        d.put("image_emoticon20", "花心");
        d.put("image_emoticon21", "呼~");
        d.put("image_emoticon22", "笑眼");
        d.put("image_emoticon23", "冷");
        d.put("image_emoticon24", "太开心");
        d.put("image_emoticon25", "滑稽");
        d.put("image_emoticon26", "勉强");
        d.put("image_emoticon27", "狂汗");
        d.put("image_emoticon28", "乖");
        d.put("image_emoticon29", "睡觉");
        d.put("image_emoticon30", "惊哭");
        d.put("image_emoticon31", "升起");
        d.put("image_emoticon32", "惊讶");
        d.put("image_emoticon33", "喷");
        d.put("image_emoticon34", "爱心");
        d.put("image_emoticon35", "心碎");
        d.put("image_emoticon36", "玫瑰");
        d.put("image_emoticon37", "礼物");
        d.put("image_emoticon38", "彩虹");
        d.put("image_emoticon39", "星星月亮");
        d.put("image_emoticon40", "太阳");
        d.put("image_emoticon41", "钱币");
        d.put("image_emoticon42", "灯泡");
        d.put("image_emoticon43", "茶杯");
        d.put("image_emoticon44", "蛋糕");
        d.put("image_emoticon45", "音乐");
        d.put("image_emoticon46", "haha");
        d.put("image_emoticon47", "胜利");
        d.put("image_emoticon48", "大拇指");
        d.put("image_emoticon49", "弱");
        d.put("image_emoticon50", "OK");
        d.put("ali_047", "哭着跑");
        d.put("ali_050", "惆怅~");
        d.put("ali_051", "摸头");
        d.put("ali_052", "蹭");
        d.put("ali_053", "打滚");
        d.put("ali_054", "叩拜");
        d.put("ali_055", "摸");
        d.put("ali_056", "数钱");
        d.put("ali_059", "加1");
        d.put("ali_060", "压力");
        d.put("ali_061", "表逼我");
        d.put("ali_062", "人呢");
        d.put("ali_063", "摇晃");
        d.put("ali_064", "打地鼠");
        d.put("ali_065", "这个屌");
        d.put("ali_066", "恐慌");
        d.put("ali_067", "晕乎乎");
        d.put("ali_068", "浮云");
        d.put("ali_069", "给力");
        d.put("ali_070", "杯具了");
        d.put("b01", "微笑");
        d.put("b02", "帅哥");
        d.put("b03", "美女");
        d.put("b04", "老大");
        d.put("b05", "哈哈哈");
        d.put("b06", "奸笑");
        d.put("b07", "傻乐");
        d.put("b08", "飞吻");
        d.put("b09", "害羞");
        d.put("b10", "花痴");
        d.put("b11", "憧憬");
        d.put("b12", "你牛");
        d.put("b13", "鼓掌");
        d.put("b14", "可爱");
        d.put("b15", "太委屈");
        d.put("b16", "大哭");
        d.put("b17", "泪奔");
        d.put("b18", "寻死");
        d.put("b19", "非常惊讶");
        d.put("b20", "表示疑问");
        d.put("yz_001", "焦糖舞");
        d.put("yz_002", "翻滚");
        d.put("yz_003", "拍屁股做鬼脸");
        d.put("yz_004", "不");
        d.put("yz_005", "河蟹掉啦");
        d.put("yz_006", "哦耶");
        d.put("yz_007", "我倒");
        d.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int a(String str) {
        Integer num = a.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.u.ico_link_video_1 : com.baidu.tieba.u.ico_link_video).intValue();
        } else if (num != null) {
            return num.intValue();
        } else {
            return 0;
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int b(String str) {
        Integer num = c.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public String c(String str) {
        return d.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.b
    public int a() {
        return b.size();
    }

    @Override // com.baidu.tbadk.imageManager.b
    public com.baidu.tbadk.imageManager.c a(Context context, String str) {
        return null;
    }
}
