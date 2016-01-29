package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> atS = new HashMap<>();
    public static final ArrayList<Integer> atT = new ArrayList<>();
    public static final HashMap<String, Integer> atU = new HashMap<>();
    private static final HashMap<String, String> atV = new HashMap<>();

    static {
        atV.put("image_emoticon", "呵呵");
        atV.put("image_emoticon2", "哈哈");
        atV.put("image_emoticon3", "吐舌");
        atV.put("image_emoticon4", "啊");
        atV.put("image_emoticon5", "酷");
        atV.put("image_emoticon6", "怒");
        atV.put("image_emoticon7", "开心");
        atV.put("image_emoticon8", "汗");
        atV.put("image_emoticon9", "泪");
        atV.put("image_emoticon10", "黑线");
        atV.put("image_emoticon11", "鄙视");
        atV.put("image_emoticon12", "不高兴");
        atV.put("image_emoticon13", "真棒");
        atV.put("image_emoticon14", "钱");
        atV.put("image_emoticon15", "疑问");
        atV.put("image_emoticon16", "阴险");
        atV.put("image_emoticon17", "吐");
        atV.put("image_emoticon18", "咦");
        atV.put("image_emoticon19", "委屈");
        atV.put("image_emoticon20", "花心");
        atV.put("image_emoticon21", "呼~");
        atV.put("image_emoticon22", "笑眼");
        atV.put("image_emoticon23", "冷");
        atV.put("image_emoticon24", "太开心");
        atV.put("image_emoticon25", "滑稽");
        atV.put("image_emoticon26", "勉强");
        atV.put("image_emoticon27", "狂汗");
        atV.put("image_emoticon28", "乖");
        atV.put("image_emoticon29", "睡觉");
        atV.put("image_emoticon30", "惊哭");
        atV.put("image_emoticon31", "生气");
        atV.put("image_emoticon32", "惊讶");
        atV.put("image_emoticon33", "喷");
        atV.put("image_emoticon34", "爱心");
        atV.put("image_emoticon35", "心碎");
        atV.put("image_emoticon36", "玫瑰");
        atV.put("image_emoticon37", "礼物");
        atV.put("image_emoticon38", "彩虹");
        atV.put("image_emoticon39", "星星月亮");
        atV.put("image_emoticon40", "太阳");
        atV.put("image_emoticon41", "钱币");
        atV.put("image_emoticon42", "灯泡");
        atV.put("image_emoticon43", "茶杯");
        atV.put("image_emoticon44", "蛋糕");
        atV.put("image_emoticon45", "音乐");
        atV.put("image_emoticon46", "haha");
        atV.put("image_emoticon47", "胜利");
        atV.put("image_emoticon48", "大拇指");
        atV.put("image_emoticon49", "弱");
        atV.put("image_emoticon50", "OK");
        atV.put("image_emoticon61", "哼");
        atV.put("ali_001", "赖皮");
        atV.put("ali_002", "感动");
        atV.put("ali_003", "十分惊讶");
        atV.put("ali_004", "怒气");
        atV.put("ali_005", "哭泣");
        atV.put("ali_006", "吃惊");
        atV.put("ali_007", "嘲弄");
        atV.put("ali_008", "飘过");
        atV.put("ali_009", "转圈哭");
        atV.put("ali_010", "神经病");
        atV.put("ali_011", "揪耳朵");
        atV.put("ali_012", "惊汗");
        atV.put("ali_013", "隐身");
        atV.put("ali_014", "不要嘛");
        atV.put("ali_015", "遁");
        atV.put("ali_016", "不公平");
        atV.put("ali_017", "爬来了");
        atV.put("ali_018", "蛋花哭");
        atV.put("ali_019", "温暖");
        atV.put("ali_020", "点头");
        atV.put("ali_021", "撒钱");
        atV.put("ali_022", "献花");
        atV.put("ali_023", "寒");
        atV.put("ali_024", "傻笑");
        atV.put("ali_025", "扭扭");
        atV.put("ali_026", "疯");
        atV.put("ali_027", "抓狂");
        atV.put("ali_028", "抓");
        atV.put("ali_029", "蜷");
        atV.put("ali_030", "挠墙");
        atV.put("ali_031", "狂笑");
        atV.put("ali_032", "抱枕");
        atV.put("ali_033", "吼叫");
        atV.put("ali_034", "嚷");
        atV.put("ali_035", "唠叨");
        atV.put("ali_036", "捏脸");
        atV.put("ali_037", "爆笑");
        atV.put("ali_038", "郁闷");
        atV.put("ali_039", "潜水");
        atV.put("ali_040", "十分开心");
        atV.put("ali_041", "冷笑话");
        atV.put("ali_042", "顶！");
        atV.put("ali_043", "潜");
        atV.put("ali_044", "画圈圈");
        atV.put("ali_045", "玩电脑");
        atV.put("ali_046", "狂吐");
        atV.put("ali_047", "哭着跑");
        atV.put("ali_048", "阿狸侠");
        atV.put("ali_049", "冷死了");
        atV.put("ali_050", "惆怅~");
        atV.put("ali_051", "摸头");
        atV.put("ali_052", "蹭");
        atV.put("ali_053", "打滚");
        atV.put("ali_054", "叩拜");
        atV.put("ali_055", "摸");
        atV.put("ali_056", "数钱");
        atV.put("ali_057", "拖走");
        atV.put("ali_058", "热");
        atV.put("ali_059", "加1");
        atV.put("ali_060", "压力");
        atV.put("ali_061", "表逼我");
        atV.put("ali_062", "人呢");
        atV.put("ali_063", "摇晃");
        atV.put("ali_064", "打地鼠");
        atV.put("ali_065", "这个屌");
        atV.put("ali_066", "恐慌");
        atV.put("ali_067", "晕乎乎");
        atV.put("ali_068", "浮云");
        atV.put("ali_069", "给力");
        atV.put("ali_070", "杯具了");
        atV.put("b01", "微笑");
        atV.put("b02", "帅哥");
        atV.put("b03", "美女");
        atV.put("b04", "老大");
        atV.put("b05", "哈哈哈");
        atV.put("b06", "奸笑");
        atV.put("b07", "傻乐");
        atV.put("b08", "飞吻");
        atV.put("b09", "害羞");
        atV.put("b10", "花痴");
        atV.put("b11", "憧憬");
        atV.put("b12", "你牛");
        atV.put("b13", "鼓掌");
        atV.put("b14", "可爱");
        atV.put("b15", "太委屈");
        atV.put("b16", "大哭");
        atV.put("b17", "泪奔");
        atV.put("b18", "寻死");
        atV.put("b19", "非常惊讶");
        atV.put("b20", "表示疑问");
        atV.put("yz_001", "焦糖舞");
        atV.put("yz_002", "翻滚");
        atV.put("yz_003", "拍屁股做鬼脸");
        atV.put("yz_004", "不");
        atV.put("yz_005", "河蟹掉啦");
        atV.put("yz_006", "哦耶");
        atV.put("yz_007", "我倒");
        atV.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fd(String str) {
        Integer num = atS.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(t.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fe(String str) {
        Integer num = atU.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String ff(String str) {
        return atV.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int CR() {
        return atT.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0052a F(Context context, String str) {
        return null;
    }
}
