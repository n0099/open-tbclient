package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> avd = new HashMap<>();
    public static final ArrayList<Integer> ave = new ArrayList<>();
    public static final HashMap<String, Integer> avf = new HashMap<>();
    private static final HashMap<String, String> avg = new HashMap<>();

    static {
        avg.put("image_emoticon", "呵呵");
        avg.put("image_emoticon2", "哈哈");
        avg.put("image_emoticon3", "吐舌");
        avg.put("image_emoticon4", "啊");
        avg.put("image_emoticon5", "酷");
        avg.put("image_emoticon6", "怒");
        avg.put("image_emoticon7", "开心");
        avg.put("image_emoticon8", "汗");
        avg.put("image_emoticon9", "泪");
        avg.put("image_emoticon10", "黑线");
        avg.put("image_emoticon11", "鄙视");
        avg.put("image_emoticon12", "不高兴");
        avg.put("image_emoticon13", "真棒");
        avg.put("image_emoticon14", "钱");
        avg.put("image_emoticon15", "疑问");
        avg.put("image_emoticon16", "阴险");
        avg.put("image_emoticon17", "吐");
        avg.put("image_emoticon18", "咦");
        avg.put("image_emoticon19", "委屈");
        avg.put("image_emoticon20", "花心");
        avg.put("image_emoticon21", "呼~");
        avg.put("image_emoticon22", "笑眼");
        avg.put("image_emoticon23", "冷");
        avg.put("image_emoticon24", "太开心");
        avg.put("image_emoticon25", "滑稽");
        avg.put("image_emoticon26", "勉强");
        avg.put("image_emoticon27", "狂汗");
        avg.put("image_emoticon28", "乖");
        avg.put("image_emoticon29", "睡觉");
        avg.put("image_emoticon30", "惊哭");
        avg.put("image_emoticon31", "生气");
        avg.put("image_emoticon32", "惊讶");
        avg.put("image_emoticon33", "喷");
        avg.put("image_emoticon34", "爱心");
        avg.put("image_emoticon35", "心碎");
        avg.put("image_emoticon36", "玫瑰");
        avg.put("image_emoticon37", "礼物");
        avg.put("image_emoticon38", "彩虹");
        avg.put("image_emoticon39", "星星月亮");
        avg.put("image_emoticon40", "太阳");
        avg.put("image_emoticon41", "钱币");
        avg.put("image_emoticon42", "灯泡");
        avg.put("image_emoticon43", "茶杯");
        avg.put("image_emoticon44", "蛋糕");
        avg.put("image_emoticon45", "音乐");
        avg.put("image_emoticon46", "haha");
        avg.put("image_emoticon47", "胜利");
        avg.put("image_emoticon48", "大拇指");
        avg.put("image_emoticon49", "弱");
        avg.put("image_emoticon50", "OK");
        avg.put("image_emoticon61", "哼");
        avg.put("image_emoticon62", "吃瓜");
        avg.put("image_emoticon63", "扔便便");
        avg.put("image_emoticon64", "惊恐");
        avg.put("image_emoticon65", "哎呦");
        avg.put("image_emoticon66", "小乖");
        avg.put("image_emoticon67", "捂嘴笑");
        avg.put("image_emoticon68", "你懂的");
        avg.put("image_emoticon69", "what");
        avg.put("image_emoticon70", "酸爽");
        avg.put("image_emoticon71", "呀咩爹");
        avg.put("image_emoticon72", "笑尿");
        avg.put("image_emoticon73", "挖鼻");
        avg.put("image_emoticon74", "犀利");
        avg.put("image_emoticon75", "小红脸");
        avg.put("image_emoticon76", "懒得理");
        avg.put("image_emoticon77", "沙发");
        avg.put("image_emoticon78", "手纸");
        avg.put("image_emoticon79", "香蕉");
        avg.put("image_emoticon80", "便便");
        avg.put("image_emoticon81", "药丸");
        avg.put("image_emoticon82", "红领巾");
        avg.put("image_emoticon83", "蜡烛");
        avg.put("image_emoticon84", "三道杠");
        avg.put("ali_001", "赖皮");
        avg.put("ali_002", "感动");
        avg.put("ali_003", "十分惊讶");
        avg.put("ali_004", "怒气");
        avg.put("ali_005", "哭泣");
        avg.put("ali_006", "吃惊");
        avg.put("ali_007", "嘲弄");
        avg.put("ali_008", "飘过");
        avg.put("ali_009", "转圈哭");
        avg.put("ali_010", "神经病");
        avg.put("ali_011", "揪耳朵");
        avg.put("ali_012", "惊汗");
        avg.put("ali_013", "隐身");
        avg.put("ali_014", "不要嘛");
        avg.put("ali_015", "遁");
        avg.put("ali_016", "不公平");
        avg.put("ali_017", "爬来了");
        avg.put("ali_018", "蛋花哭");
        avg.put("ali_019", "温暖");
        avg.put("ali_020", "点头");
        avg.put("ali_021", "撒钱");
        avg.put("ali_022", "献花");
        avg.put("ali_023", "寒");
        avg.put("ali_024", "傻笑");
        avg.put("ali_025", "扭扭");
        avg.put("ali_026", "疯");
        avg.put("ali_027", "抓狂");
        avg.put("ali_028", "抓");
        avg.put("ali_029", "蜷");
        avg.put("ali_030", "挠墙");
        avg.put("ali_031", "狂笑");
        avg.put("ali_032", "抱枕");
        avg.put("ali_033", "吼叫");
        avg.put("ali_034", "嚷");
        avg.put("ali_035", "唠叨");
        avg.put("ali_036", "捏脸");
        avg.put("ali_037", "爆笑");
        avg.put("ali_038", "郁闷");
        avg.put("ali_039", "潜水");
        avg.put("ali_040", "十分开心");
        avg.put("ali_041", "冷笑话");
        avg.put("ali_042", "顶！");
        avg.put("ali_043", "潜");
        avg.put("ali_044", "画圈圈");
        avg.put("ali_045", "玩电脑");
        avg.put("ali_046", "狂吐");
        avg.put("ali_047", "哭着跑");
        avg.put("ali_048", "阿狸侠");
        avg.put("ali_049", "冷死了");
        avg.put("ali_050", "惆怅~");
        avg.put("ali_051", "摸头");
        avg.put("ali_052", "蹭");
        avg.put("ali_053", "打滚");
        avg.put("ali_054", "叩拜");
        avg.put("ali_055", "摸");
        avg.put("ali_056", "数钱");
        avg.put("ali_057", "拖走");
        avg.put("ali_058", "热");
        avg.put("ali_059", "加1");
        avg.put("ali_060", "压力");
        avg.put("ali_061", "表逼我");
        avg.put("ali_062", "人呢");
        avg.put("ali_063", "摇晃");
        avg.put("ali_064", "打地鼠");
        avg.put("ali_065", "这个屌");
        avg.put("ali_066", "恐慌");
        avg.put("ali_067", "晕乎乎");
        avg.put("ali_068", "浮云");
        avg.put("ali_069", "给力");
        avg.put("ali_070", "杯具了");
        avg.put("b01", "微笑");
        avg.put("b02", "帅哥");
        avg.put("b03", "美女");
        avg.put("b04", "老大");
        avg.put("b05", "哈哈哈");
        avg.put("b06", "奸笑");
        avg.put("b07", "傻乐");
        avg.put("b08", "飞吻");
        avg.put("b09", "害羞");
        avg.put("b10", "花痴");
        avg.put("b11", "憧憬");
        avg.put("b12", "你牛");
        avg.put("b13", "鼓掌");
        avg.put("b14", "可爱");
        avg.put("b15", "太委屈");
        avg.put("b16", "大哭");
        avg.put("b17", "泪奔");
        avg.put("b18", "寻死");
        avg.put("b19", "非常惊讶");
        avg.put("b20", "表示疑问");
        avg.put("yz_001", "焦糖舞");
        avg.put("yz_002", "翻滚");
        avg.put("yz_003", "拍屁股做鬼脸");
        avg.put("yz_004", "不");
        avg.put("yz_005", "河蟹掉啦");
        avg.put("yz_006", "哦耶");
        avg.put("yz_007", "我倒");
        avg.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fp(String str) {
        Integer num = avd.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(t.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fq(String str) {
        Integer num = avf.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fr(String str) {
        return avg.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int CY() {
        return ave.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0044a y(Context context, String str) {
        return null;
    }
}
