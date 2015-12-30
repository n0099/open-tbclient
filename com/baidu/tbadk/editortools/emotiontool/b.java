package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> asZ = new HashMap<>();
    public static final ArrayList<Integer> ata = new ArrayList<>();
    public static final HashMap<String, Integer> atb = new HashMap<>();
    private static final HashMap<String, String> atc = new HashMap<>();

    static {
        atc.put("image_emoticon", "呵呵");
        atc.put("image_emoticon2", "哈哈");
        atc.put("image_emoticon3", "吐舌");
        atc.put("image_emoticon4", "啊");
        atc.put("image_emoticon5", "酷");
        atc.put("image_emoticon6", "怒");
        atc.put("image_emoticon7", "开心");
        atc.put("image_emoticon8", "汗");
        atc.put("image_emoticon9", "泪");
        atc.put("image_emoticon10", "黑线");
        atc.put("image_emoticon11", "鄙视");
        atc.put("image_emoticon12", "不高兴");
        atc.put("image_emoticon13", "真棒");
        atc.put("image_emoticon14", "钱");
        atc.put("image_emoticon15", "疑问");
        atc.put("image_emoticon16", "阴险");
        atc.put("image_emoticon17", "吐");
        atc.put("image_emoticon18", "咦");
        atc.put("image_emoticon19", "委屈");
        atc.put("image_emoticon20", "花心");
        atc.put("image_emoticon21", "呼~");
        atc.put("image_emoticon22", "笑眼");
        atc.put("image_emoticon23", "冷");
        atc.put("image_emoticon24", "太开心");
        atc.put("image_emoticon25", "滑稽");
        atc.put("image_emoticon26", "勉强");
        atc.put("image_emoticon27", "狂汗");
        atc.put("image_emoticon28", "乖");
        atc.put("image_emoticon29", "睡觉");
        atc.put("image_emoticon30", "惊哭");
        atc.put("image_emoticon31", "生气");
        atc.put("image_emoticon32", "惊讶");
        atc.put("image_emoticon33", "喷");
        atc.put("image_emoticon34", "爱心");
        atc.put("image_emoticon35", "心碎");
        atc.put("image_emoticon36", "玫瑰");
        atc.put("image_emoticon37", "礼物");
        atc.put("image_emoticon38", "彩虹");
        atc.put("image_emoticon39", "星星月亮");
        atc.put("image_emoticon40", "太阳");
        atc.put("image_emoticon41", "钱币");
        atc.put("image_emoticon42", "灯泡");
        atc.put("image_emoticon43", "茶杯");
        atc.put("image_emoticon44", "蛋糕");
        atc.put("image_emoticon45", "音乐");
        atc.put("image_emoticon46", "haha");
        atc.put("image_emoticon47", "胜利");
        atc.put("image_emoticon48", "大拇指");
        atc.put("image_emoticon49", "弱");
        atc.put("image_emoticon50", "OK");
        atc.put("image_emoticon61", "哼");
        atc.put("ali_001", "赖皮");
        atc.put("ali_002", "感动");
        atc.put("ali_003", "十分惊讶");
        atc.put("ali_004", "怒气");
        atc.put("ali_005", "哭泣");
        atc.put("ali_006", "吃惊");
        atc.put("ali_007", "嘲弄");
        atc.put("ali_008", "飘过");
        atc.put("ali_009", "转圈哭");
        atc.put("ali_010", "神经病");
        atc.put("ali_011", "揪耳朵");
        atc.put("ali_012", "惊汗");
        atc.put("ali_013", "隐身");
        atc.put("ali_014", "不要嘛");
        atc.put("ali_015", "遁");
        atc.put("ali_016", "不公平");
        atc.put("ali_017", "爬来了");
        atc.put("ali_018", "蛋花哭");
        atc.put("ali_019", "温暖");
        atc.put("ali_020", "点头");
        atc.put("ali_021", "撒钱");
        atc.put("ali_022", "献花");
        atc.put("ali_023", "寒");
        atc.put("ali_024", "傻笑");
        atc.put("ali_025", "扭扭");
        atc.put("ali_026", "疯");
        atc.put("ali_027", "抓狂");
        atc.put("ali_028", "抓");
        atc.put("ali_029", "蜷");
        atc.put("ali_030", "挠墙");
        atc.put("ali_031", "狂笑");
        atc.put("ali_032", "抱枕");
        atc.put("ali_033", "吼叫");
        atc.put("ali_034", "嚷");
        atc.put("ali_035", "唠叨");
        atc.put("ali_036", "捏脸");
        atc.put("ali_037", "爆笑");
        atc.put("ali_038", "郁闷");
        atc.put("ali_039", "潜水");
        atc.put("ali_040", "十分开心");
        atc.put("ali_041", "冷笑话");
        atc.put("ali_042", "顶！");
        atc.put("ali_043", "潜");
        atc.put("ali_044", "画圈圈");
        atc.put("ali_045", "玩电脑");
        atc.put("ali_046", "狂吐");
        atc.put("ali_047", "哭着跑");
        atc.put("ali_048", "阿狸侠");
        atc.put("ali_049", "冷死了");
        atc.put("ali_050", "惆怅~");
        atc.put("ali_051", "摸头");
        atc.put("ali_052", "蹭");
        atc.put("ali_053", "打滚");
        atc.put("ali_054", "叩拜");
        atc.put("ali_055", "摸");
        atc.put("ali_056", "数钱");
        atc.put("ali_057", "拖走");
        atc.put("ali_058", "热");
        atc.put("ali_059", "加1");
        atc.put("ali_060", "压力");
        atc.put("ali_061", "表逼我");
        atc.put("ali_062", "人呢");
        atc.put("ali_063", "摇晃");
        atc.put("ali_064", "打地鼠");
        atc.put("ali_065", "这个屌");
        atc.put("ali_066", "恐慌");
        atc.put("ali_067", "晕乎乎");
        atc.put("ali_068", "浮云");
        atc.put("ali_069", "给力");
        atc.put("ali_070", "杯具了");
        atc.put("b01", "微笑");
        atc.put("b02", "帅哥");
        atc.put("b03", "美女");
        atc.put("b04", "老大");
        atc.put("b05", "哈哈哈");
        atc.put("b06", "奸笑");
        atc.put("b07", "傻乐");
        atc.put("b08", "飞吻");
        atc.put("b09", "害羞");
        atc.put("b10", "花痴");
        atc.put("b11", "憧憬");
        atc.put("b12", "你牛");
        atc.put("b13", "鼓掌");
        atc.put("b14", "可爱");
        atc.put("b15", "太委屈");
        atc.put("b16", "大哭");
        atc.put("b17", "泪奔");
        atc.put("b18", "寻死");
        atc.put("b19", "非常惊讶");
        atc.put("b20", "表示疑问");
        atc.put("yz_001", "焦糖舞");
        atc.put("yz_002", "翻滚");
        atc.put("yz_003", "拍屁股做鬼脸");
        atc.put("yz_004", "不");
        atc.put("yz_005", "河蟹掉啦");
        atc.put("yz_006", "哦耶");
        atc.put("yz_007", "我倒");
        atc.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fe(String str) {
        Integer num = asZ.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(n.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int ff(String str) {
        Integer num = atb.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fg(String str) {
        return atc.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int BA() {
        return ata.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0051a F(Context context, String str) {
        return null;
    }
}
