package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> auG = new HashMap<>();
    public static final ArrayList<Integer> auH = new ArrayList<>();
    public static final HashMap<String, Integer> auI = new HashMap<>();
    private static final HashMap<String, String> auJ = new HashMap<>();

    static {
        auJ.put("image_emoticon", "呵呵");
        auJ.put("image_emoticon2", "哈哈");
        auJ.put("image_emoticon3", "吐舌");
        auJ.put("image_emoticon4", "啊");
        auJ.put("image_emoticon5", "酷");
        auJ.put("image_emoticon6", "怒");
        auJ.put("image_emoticon7", "开心");
        auJ.put("image_emoticon8", "汗");
        auJ.put("image_emoticon9", "泪");
        auJ.put("image_emoticon10", "黑线");
        auJ.put("image_emoticon11", "鄙视");
        auJ.put("image_emoticon12", "不高兴");
        auJ.put("image_emoticon13", "真棒");
        auJ.put("image_emoticon14", "钱");
        auJ.put("image_emoticon15", "疑问");
        auJ.put("image_emoticon16", "阴险");
        auJ.put("image_emoticon17", "吐");
        auJ.put("image_emoticon18", "咦");
        auJ.put("image_emoticon19", "委屈");
        auJ.put("image_emoticon20", "花心");
        auJ.put("image_emoticon21", "呼~");
        auJ.put("image_emoticon22", "笑眼");
        auJ.put("image_emoticon23", "冷");
        auJ.put("image_emoticon24", "太开心");
        auJ.put("image_emoticon25", "滑稽");
        auJ.put("image_emoticon26", "勉强");
        auJ.put("image_emoticon27", "狂汗");
        auJ.put("image_emoticon28", "乖");
        auJ.put("image_emoticon29", "睡觉");
        auJ.put("image_emoticon30", "惊哭");
        auJ.put("image_emoticon31", "生气");
        auJ.put("image_emoticon32", "惊讶");
        auJ.put("image_emoticon33", "喷");
        auJ.put("image_emoticon34", "爱心");
        auJ.put("image_emoticon35", "心碎");
        auJ.put("image_emoticon36", "玫瑰");
        auJ.put("image_emoticon37", "礼物");
        auJ.put("image_emoticon38", "彩虹");
        auJ.put("image_emoticon39", "星星月亮");
        auJ.put("image_emoticon40", "太阳");
        auJ.put("image_emoticon41", "钱币");
        auJ.put("image_emoticon42", "灯泡");
        auJ.put("image_emoticon43", "茶杯");
        auJ.put("image_emoticon44", "蛋糕");
        auJ.put("image_emoticon45", "音乐");
        auJ.put("image_emoticon46", "haha");
        auJ.put("image_emoticon47", "胜利");
        auJ.put("image_emoticon48", "大拇指");
        auJ.put("image_emoticon49", "弱");
        auJ.put("image_emoticon50", "OK");
        auJ.put("image_emoticon61", "哼");
        auJ.put("image_emoticon62", "吃瓜");
        auJ.put("image_emoticon63", "扔便便");
        auJ.put("image_emoticon64", "惊恐");
        auJ.put("image_emoticon65", "哎呦");
        auJ.put("image_emoticon66", "小乖");
        auJ.put("image_emoticon67", "捂嘴笑");
        auJ.put("image_emoticon68", "你懂的");
        auJ.put("image_emoticon69", "what");
        auJ.put("image_emoticon70", "酸爽");
        auJ.put("image_emoticon71", "呀咩爹");
        auJ.put("image_emoticon72", "笑尿");
        auJ.put("image_emoticon73", "挖鼻");
        auJ.put("image_emoticon74", "犀利");
        auJ.put("image_emoticon75", "小红脸");
        auJ.put("image_emoticon76", "懒得理");
        auJ.put("image_emoticon77", "沙发");
        auJ.put("image_emoticon78", "手纸");
        auJ.put("image_emoticon79", "香蕉");
        auJ.put("image_emoticon80", "便便");
        auJ.put("image_emoticon81", "药丸");
        auJ.put("image_emoticon82", "红领巾");
        auJ.put("image_emoticon83", "蜡烛");
        auJ.put("image_emoticon84", "三道杠");
        auJ.put("ali_001", "赖皮");
        auJ.put("ali_002", "感动");
        auJ.put("ali_003", "十分惊讶");
        auJ.put("ali_004", "怒气");
        auJ.put("ali_005", "哭泣");
        auJ.put("ali_006", "吃惊");
        auJ.put("ali_007", "嘲弄");
        auJ.put("ali_008", "飘过");
        auJ.put("ali_009", "转圈哭");
        auJ.put("ali_010", "神经病");
        auJ.put("ali_011", "揪耳朵");
        auJ.put("ali_012", "惊汗");
        auJ.put("ali_013", "隐身");
        auJ.put("ali_014", "不要嘛");
        auJ.put("ali_015", "遁");
        auJ.put("ali_016", "不公平");
        auJ.put("ali_017", "爬来了");
        auJ.put("ali_018", "蛋花哭");
        auJ.put("ali_019", "温暖");
        auJ.put("ali_020", "点头");
        auJ.put("ali_021", "撒钱");
        auJ.put("ali_022", "献花");
        auJ.put("ali_023", "寒");
        auJ.put("ali_024", "傻笑");
        auJ.put("ali_025", "扭扭");
        auJ.put("ali_026", "疯");
        auJ.put("ali_027", "抓狂");
        auJ.put("ali_028", "抓");
        auJ.put("ali_029", "蜷");
        auJ.put("ali_030", "挠墙");
        auJ.put("ali_031", "狂笑");
        auJ.put("ali_032", "抱枕");
        auJ.put("ali_033", "吼叫");
        auJ.put("ali_034", "嚷");
        auJ.put("ali_035", "唠叨");
        auJ.put("ali_036", "捏脸");
        auJ.put("ali_037", "爆笑");
        auJ.put("ali_038", "郁闷");
        auJ.put("ali_039", "潜水");
        auJ.put("ali_040", "十分开心");
        auJ.put("ali_041", "冷笑话");
        auJ.put("ali_042", "顶！");
        auJ.put("ali_043", "潜");
        auJ.put("ali_044", "画圈圈");
        auJ.put("ali_045", "玩电脑");
        auJ.put("ali_046", "狂吐");
        auJ.put("ali_047", "哭着跑");
        auJ.put("ali_048", "阿狸侠");
        auJ.put("ali_049", "冷死了");
        auJ.put("ali_050", "惆怅~");
        auJ.put("ali_051", "摸头");
        auJ.put("ali_052", "蹭");
        auJ.put("ali_053", "打滚");
        auJ.put("ali_054", "叩拜");
        auJ.put("ali_055", "摸");
        auJ.put("ali_056", "数钱");
        auJ.put("ali_057", "拖走");
        auJ.put("ali_058", "热");
        auJ.put("ali_059", "加1");
        auJ.put("ali_060", "压力");
        auJ.put("ali_061", "表逼我");
        auJ.put("ali_062", "人呢");
        auJ.put("ali_063", "摇晃");
        auJ.put("ali_064", "打地鼠");
        auJ.put("ali_065", "这个屌");
        auJ.put("ali_066", "恐慌");
        auJ.put("ali_067", "晕乎乎");
        auJ.put("ali_068", "浮云");
        auJ.put("ali_069", "给力");
        auJ.put("ali_070", "杯具了");
        auJ.put("b01", "微笑");
        auJ.put("b02", "帅哥");
        auJ.put("b03", "美女");
        auJ.put("b04", "老大");
        auJ.put("b05", "哈哈哈");
        auJ.put("b06", "奸笑");
        auJ.put("b07", "傻乐");
        auJ.put("b08", "飞吻");
        auJ.put("b09", "害羞");
        auJ.put("b10", "花痴");
        auJ.put("b11", "憧憬");
        auJ.put("b12", "你牛");
        auJ.put("b13", "鼓掌");
        auJ.put("b14", "可爱");
        auJ.put("b15", "太委屈");
        auJ.put("b16", "大哭");
        auJ.put("b17", "泪奔");
        auJ.put("b18", "寻死");
        auJ.put("b19", "非常惊讶");
        auJ.put("b20", "表示疑问");
        auJ.put("yz_001", "焦糖舞");
        auJ.put("yz_002", "翻滚");
        auJ.put("yz_003", "拍屁股做鬼脸");
        auJ.put("yz_004", "不");
        auJ.put("yz_005", "河蟹掉啦");
        auJ.put("yz_006", "哦耶");
        auJ.put("yz_007", "我倒");
        auJ.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fr(String str) {
        Integer num = auG.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(r.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fs(String str) {
        Integer num = auI.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String ft(String str) {
        return auJ.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int CY() {
        return auH.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0044a y(Context context, String str) {
        return null;
    }
}
