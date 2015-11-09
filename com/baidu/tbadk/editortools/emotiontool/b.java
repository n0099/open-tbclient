package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> apy = new HashMap<>();
    public static final ArrayList<Integer> apz = new ArrayList<>();
    public static final HashMap<String, Integer> apA = new HashMap<>();
    private static final HashMap<String, String> apB = new HashMap<>();

    static {
        apB.put("image_emoticon", "呵呵");
        apB.put("image_emoticon2", "哈哈");
        apB.put("image_emoticon3", "吐舌");
        apB.put("image_emoticon4", "啊");
        apB.put("image_emoticon5", "酷");
        apB.put("image_emoticon6", "怒");
        apB.put("image_emoticon7", "开心");
        apB.put("image_emoticon8", "汗");
        apB.put("image_emoticon9", "泪");
        apB.put("image_emoticon10", "黑线");
        apB.put("image_emoticon11", "鄙视");
        apB.put("image_emoticon12", "不高兴");
        apB.put("image_emoticon13", "真棒");
        apB.put("image_emoticon14", "钱");
        apB.put("image_emoticon15", "疑问");
        apB.put("image_emoticon16", "阴险");
        apB.put("image_emoticon17", "吐");
        apB.put("image_emoticon18", "咦");
        apB.put("image_emoticon19", "委屈");
        apB.put("image_emoticon20", "花心");
        apB.put("image_emoticon21", "呼~");
        apB.put("image_emoticon22", "笑眼");
        apB.put("image_emoticon23", "冷");
        apB.put("image_emoticon24", "太开心");
        apB.put("image_emoticon25", "滑稽");
        apB.put("image_emoticon26", "勉强");
        apB.put("image_emoticon27", "狂汗");
        apB.put("image_emoticon28", "乖");
        apB.put("image_emoticon29", "睡觉");
        apB.put("image_emoticon30", "惊哭");
        apB.put("image_emoticon31", "升起");
        apB.put("image_emoticon32", "惊讶");
        apB.put("image_emoticon33", "喷");
        apB.put("image_emoticon34", "爱心");
        apB.put("image_emoticon35", "心碎");
        apB.put("image_emoticon36", "玫瑰");
        apB.put("image_emoticon37", "礼物");
        apB.put("image_emoticon38", "彩虹");
        apB.put("image_emoticon39", "星星月亮");
        apB.put("image_emoticon40", "太阳");
        apB.put("image_emoticon41", "钱币");
        apB.put("image_emoticon42", "灯泡");
        apB.put("image_emoticon43", "茶杯");
        apB.put("image_emoticon44", "蛋糕");
        apB.put("image_emoticon45", "音乐");
        apB.put("image_emoticon46", "haha");
        apB.put("image_emoticon47", "胜利");
        apB.put("image_emoticon48", "大拇指");
        apB.put("image_emoticon49", "弱");
        apB.put("image_emoticon50", "OK");
        apB.put("ali_001", "赖皮");
        apB.put("ali_002", "感动");
        apB.put("ali_003", "十分惊讶");
        apB.put("ali_004", "怒气");
        apB.put("ali_005", "哭泣");
        apB.put("ali_006", "吃惊");
        apB.put("ali_007", "嘲弄");
        apB.put("ali_008", "飘过");
        apB.put("ali_009", "转圈哭");
        apB.put("ali_010", "神经病");
        apB.put("ali_011", "揪耳朵");
        apB.put("ali_012", "惊汗");
        apB.put("ali_013", "隐身");
        apB.put("ali_014", "不要嘛");
        apB.put("ali_015", "遁");
        apB.put("ali_016", "不公平");
        apB.put("ali_017", "爬来了");
        apB.put("ali_018", "蛋花哭");
        apB.put("ali_019", "温暖");
        apB.put("ali_020", "点头");
        apB.put("ali_021", "撒钱");
        apB.put("ali_022", "献花");
        apB.put("ali_023", "寒");
        apB.put("ali_024", "傻笑");
        apB.put("ali_025", "扭扭");
        apB.put("ali_026", "疯");
        apB.put("ali_027", "抓狂");
        apB.put("ali_028", "抓");
        apB.put("ali_029", "蜷");
        apB.put("ali_030", "挠墙");
        apB.put("ali_031", "狂笑");
        apB.put("ali_032", "抱枕");
        apB.put("ali_033", "吼叫");
        apB.put("ali_034", "嚷");
        apB.put("ali_035", "唠叨");
        apB.put("ali_036", "捏脸");
        apB.put("ali_037", "爆笑");
        apB.put("ali_038", "郁闷");
        apB.put("ali_039", "潜水");
        apB.put("ali_040", "十分开心");
        apB.put("ali_041", "冷笑话");
        apB.put("ali_042", "顶！");
        apB.put("ali_043", "潜");
        apB.put("ali_044", "画圈圈");
        apB.put("ali_045", "玩电脑");
        apB.put("ali_046", "狂吐");
        apB.put("ali_047", "哭着跑");
        apB.put("ali_048", "阿狸侠");
        apB.put("ali_049", "冷死了");
        apB.put("ali_050", "惆怅~");
        apB.put("ali_051", "摸头");
        apB.put("ali_052", "蹭");
        apB.put("ali_053", "打滚");
        apB.put("ali_054", "叩拜");
        apB.put("ali_055", "摸");
        apB.put("ali_056", "数钱");
        apB.put("ali_057", "拖走");
        apB.put("ali_058", "热");
        apB.put("ali_059", "加1");
        apB.put("ali_060", "压力");
        apB.put("ali_061", "表逼我");
        apB.put("ali_062", "人呢");
        apB.put("ali_063", "摇晃");
        apB.put("ali_064", "打地鼠");
        apB.put("ali_065", "这个屌");
        apB.put("ali_066", "恐慌");
        apB.put("ali_067", "晕乎乎");
        apB.put("ali_068", "浮云");
        apB.put("ali_069", "给力");
        apB.put("ali_070", "杯具了");
        apB.put("b01", "微笑");
        apB.put("b02", "帅哥");
        apB.put("b03", "美女");
        apB.put("b04", "老大");
        apB.put("b05", "哈哈哈");
        apB.put("b06", "奸笑");
        apB.put("b07", "傻乐");
        apB.put("b08", "飞吻");
        apB.put("b09", "害羞");
        apB.put("b10", "花痴");
        apB.put("b11", "憧憬");
        apB.put("b12", "你牛");
        apB.put("b13", "鼓掌");
        apB.put("b14", "可爱");
        apB.put("b15", "太委屈");
        apB.put("b16", "大哭");
        apB.put("b17", "泪奔");
        apB.put("b18", "寻死");
        apB.put("b19", "非常惊讶");
        apB.put("b20", "表示疑问");
        apB.put("yz_001", "焦糖舞");
        apB.put("yz_002", "翻滚");
        apB.put("yz_003", "拍屁股做鬼脸");
        apB.put("yz_004", "不");
        apB.put("yz_005", "河蟹掉啦");
        apB.put("yz_006", "哦耶");
        apB.put("yz_007", "我倒");
        apB.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int eM(String str) {
        Integer num = apy.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(i.e.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int eN(String str) {
        Integer num = apA.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String eO(String str) {
        return apB.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int AN() {
        return apz.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0049a F(Context context, String str) {
        return null;
    }
}
