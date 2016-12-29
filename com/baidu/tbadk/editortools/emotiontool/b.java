package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> auX = new HashMap<>();
    public static final ArrayList<Integer> auY = new ArrayList<>();
    public static final HashMap<String, Integer> auZ = new HashMap<>();
    private static final HashMap<String, String> ava = new HashMap<>();

    static {
        ava.put("image_emoticon", "呵呵");
        ava.put("image_emoticon2", "哈哈");
        ava.put("image_emoticon3", "吐舌");
        ava.put("image_emoticon4", "啊");
        ava.put("image_emoticon5", "酷");
        ava.put("image_emoticon6", "怒");
        ava.put("image_emoticon7", "开心");
        ava.put("image_emoticon8", "汗");
        ava.put("image_emoticon9", "泪");
        ava.put("image_emoticon10", "黑线");
        ava.put("image_emoticon11", "鄙视");
        ava.put("image_emoticon12", "不高兴");
        ava.put("image_emoticon13", "真棒");
        ava.put("image_emoticon14", "钱");
        ava.put("image_emoticon15", "疑问");
        ava.put("image_emoticon16", "阴险");
        ava.put("image_emoticon17", "吐");
        ava.put("image_emoticon18", "咦");
        ava.put("image_emoticon19", "委屈");
        ava.put("image_emoticon20", "花心");
        ava.put("image_emoticon21", "呼~");
        ava.put("image_emoticon22", "笑眼");
        ava.put("image_emoticon23", "冷");
        ava.put("image_emoticon24", "太开心");
        ava.put("image_emoticon25", "滑稽");
        ava.put("image_emoticon26", "勉强");
        ava.put("image_emoticon27", "狂汗");
        ava.put("image_emoticon28", "乖");
        ava.put("image_emoticon29", "睡觉");
        ava.put("image_emoticon30", "惊哭");
        ava.put("image_emoticon31", "生气");
        ava.put("image_emoticon32", "惊讶");
        ava.put("image_emoticon33", "喷");
        ava.put("image_emoticon34", "爱心");
        ava.put("image_emoticon35", "心碎");
        ava.put("image_emoticon36", "玫瑰");
        ava.put("image_emoticon37", "礼物");
        ava.put("image_emoticon38", "彩虹");
        ava.put("image_emoticon39", "星星月亮");
        ava.put("image_emoticon40", "太阳");
        ava.put("image_emoticon41", "钱币");
        ava.put("image_emoticon42", "灯泡");
        ava.put("image_emoticon43", "茶杯");
        ava.put("image_emoticon44", "蛋糕");
        ava.put("image_emoticon45", "音乐");
        ava.put("image_emoticon46", "haha");
        ava.put("image_emoticon47", "胜利");
        ava.put("image_emoticon48", "大拇指");
        ava.put("image_emoticon49", "弱");
        ava.put("image_emoticon50", "OK");
        ava.put("image_emoticon61", "哼");
        ava.put("image_emoticon62", "吃瓜");
        ava.put("image_emoticon63", "扔便便");
        ava.put("image_emoticon64", "惊恐");
        ava.put("image_emoticon65", "哎呦");
        ava.put("image_emoticon66", "小乖");
        ava.put("image_emoticon67", "捂嘴笑");
        ava.put("image_emoticon68", "你懂的");
        ava.put("image_emoticon69", "what");
        ava.put("image_emoticon70", "酸爽");
        ava.put("image_emoticon71", "呀咩爹");
        ava.put("image_emoticon72", "笑尿");
        ava.put("image_emoticon73", "挖鼻");
        ava.put("image_emoticon74", "犀利");
        ava.put("image_emoticon75", "小红脸");
        ava.put("image_emoticon76", "懒得理");
        ava.put("image_emoticon77", "沙发");
        ava.put("image_emoticon78", "手纸");
        ava.put("image_emoticon79", "香蕉");
        ava.put("image_emoticon80", "便便");
        ava.put("image_emoticon81", "药丸");
        ava.put("image_emoticon82", "红领巾");
        ava.put("image_emoticon83", "蜡烛");
        ava.put("image_emoticon84", "三道杠");
        ava.put("ali_001", "赖皮");
        ava.put("ali_002", "感动");
        ava.put("ali_003", "十分惊讶");
        ava.put("ali_004", "怒气");
        ava.put("ali_005", "哭泣");
        ava.put("ali_006", "吃惊");
        ava.put("ali_007", "嘲弄");
        ava.put("ali_008", "飘过");
        ava.put("ali_009", "转圈哭");
        ava.put("ali_010", "神经病");
        ava.put("ali_011", "揪耳朵");
        ava.put("ali_012", "惊汗");
        ava.put("ali_013", "隐身");
        ava.put("ali_014", "不要嘛");
        ava.put("ali_015", "遁");
        ava.put("ali_016", "不公平");
        ava.put("ali_017", "爬来了");
        ava.put("ali_018", "蛋花哭");
        ava.put("ali_019", "温暖");
        ava.put("ali_020", "点头");
        ava.put("ali_021", "撒钱");
        ava.put("ali_022", "献花");
        ava.put("ali_023", "寒");
        ava.put("ali_024", "傻笑");
        ava.put("ali_025", "扭扭");
        ava.put("ali_026", "疯");
        ava.put("ali_027", "抓狂");
        ava.put("ali_028", "抓");
        ava.put("ali_029", "蜷");
        ava.put("ali_030", "挠墙");
        ava.put("ali_031", "狂笑");
        ava.put("ali_032", "抱枕");
        ava.put("ali_033", "吼叫");
        ava.put("ali_034", "嚷");
        ava.put("ali_035", "唠叨");
        ava.put("ali_036", "捏脸");
        ava.put("ali_037", "爆笑");
        ava.put("ali_038", "郁闷");
        ava.put("ali_039", "潜水");
        ava.put("ali_040", "十分开心");
        ava.put("ali_041", "冷笑话");
        ava.put("ali_042", "顶！");
        ava.put("ali_043", "潜");
        ava.put("ali_044", "画圈圈");
        ava.put("ali_045", "玩电脑");
        ava.put("ali_046", "狂吐");
        ava.put("ali_047", "哭着跑");
        ava.put("ali_048", "阿狸侠");
        ava.put("ali_049", "冷死了");
        ava.put("ali_050", "惆怅~");
        ava.put("ali_051", "摸头");
        ava.put("ali_052", "蹭");
        ava.put("ali_053", "打滚");
        ava.put("ali_054", "叩拜");
        ava.put("ali_055", "摸");
        ava.put("ali_056", "数钱");
        ava.put("ali_057", "拖走");
        ava.put("ali_058", "热");
        ava.put("ali_059", "加1");
        ava.put("ali_060", "压力");
        ava.put("ali_061", "表逼我");
        ava.put("ali_062", "人呢");
        ava.put("ali_063", "摇晃");
        ava.put("ali_064", "打地鼠");
        ava.put("ali_065", "这个屌");
        ava.put("ali_066", "恐慌");
        ava.put("ali_067", "晕乎乎");
        ava.put("ali_068", "浮云");
        ava.put("ali_069", "给力");
        ava.put("ali_070", "杯具了");
        ava.put("b01", "微笑");
        ava.put("b02", "帅哥");
        ava.put("b03", "美女");
        ava.put("b04", "老大");
        ava.put("b05", "哈哈哈");
        ava.put("b06", "奸笑");
        ava.put("b07", "傻乐");
        ava.put("b08", "飞吻");
        ava.put("b09", "害羞");
        ava.put("b10", "花痴");
        ava.put("b11", "憧憬");
        ava.put("b12", "你牛");
        ava.put("b13", "鼓掌");
        ava.put("b14", "可爱");
        ava.put("b15", "太委屈");
        ava.put("b16", "大哭");
        ava.put("b17", "泪奔");
        ava.put("b18", "寻死");
        ava.put("b19", "非常惊讶");
        ava.put("b20", "表示疑问");
        ava.put("yz_001", "焦糖舞");
        ava.put("yz_002", "翻滚");
        ava.put("yz_003", "拍屁股做鬼脸");
        ava.put("yz_004", "不");
        ava.put("yz_005", "河蟹掉啦");
        ava.put("yz_006", "哦耶");
        ava.put("yz_007", "我倒");
        ava.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fq(String str) {
        Integer num = auX.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(r.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fr(String str) {
        Integer num = auZ.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fs(String str) {
        return ava.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int CP() {
        return auY.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0044a y(Context context, String str) {
        return null;
    }
}
