package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> auc = new HashMap<>();
    public static final ArrayList<Integer> aud = new ArrayList<>();
    public static final HashMap<String, Integer> aue = new HashMap<>();
    private static final HashMap<String, String> auf = new HashMap<>();

    static {
        auf.put("image_emoticon", "呵呵");
        auf.put("image_emoticon2", "哈哈");
        auf.put("image_emoticon3", "吐舌");
        auf.put("image_emoticon4", "啊");
        auf.put("image_emoticon5", "酷");
        auf.put("image_emoticon6", "怒");
        auf.put("image_emoticon7", "开心");
        auf.put("image_emoticon8", "汗");
        auf.put("image_emoticon9", "泪");
        auf.put("image_emoticon10", "黑线");
        auf.put("image_emoticon11", "鄙视");
        auf.put("image_emoticon12", "不高兴");
        auf.put("image_emoticon13", "真棒");
        auf.put("image_emoticon14", "钱");
        auf.put("image_emoticon15", "疑问");
        auf.put("image_emoticon16", "阴险");
        auf.put("image_emoticon17", "吐");
        auf.put("image_emoticon18", "咦");
        auf.put("image_emoticon19", "委屈");
        auf.put("image_emoticon20", "花心");
        auf.put("image_emoticon21", "呼~");
        auf.put("image_emoticon22", "笑眼");
        auf.put("image_emoticon23", "冷");
        auf.put("image_emoticon24", "太开心");
        auf.put("image_emoticon25", "滑稽");
        auf.put("image_emoticon26", "勉强");
        auf.put("image_emoticon27", "狂汗");
        auf.put("image_emoticon28", "乖");
        auf.put("image_emoticon29", "睡觉");
        auf.put("image_emoticon30", "惊哭");
        auf.put("image_emoticon31", "生气");
        auf.put("image_emoticon32", "惊讶");
        auf.put("image_emoticon33", "喷");
        auf.put("image_emoticon34", "爱心");
        auf.put("image_emoticon35", "心碎");
        auf.put("image_emoticon36", "玫瑰");
        auf.put("image_emoticon37", "礼物");
        auf.put("image_emoticon38", "彩虹");
        auf.put("image_emoticon39", "星星月亮");
        auf.put("image_emoticon40", "太阳");
        auf.put("image_emoticon41", "钱币");
        auf.put("image_emoticon42", "灯泡");
        auf.put("image_emoticon43", "茶杯");
        auf.put("image_emoticon44", "蛋糕");
        auf.put("image_emoticon45", "音乐");
        auf.put("image_emoticon46", "haha");
        auf.put("image_emoticon47", "胜利");
        auf.put("image_emoticon48", "大拇指");
        auf.put("image_emoticon49", "弱");
        auf.put("image_emoticon50", "OK");
        auf.put("image_emoticon61", "哼");
        auf.put("image_emoticon62", "吃瓜");
        auf.put("image_emoticon63", "扔便便");
        auf.put("image_emoticon64", "惊恐");
        auf.put("image_emoticon65", "哎呦");
        auf.put("image_emoticon66", "小乖");
        auf.put("image_emoticon67", "捂嘴笑");
        auf.put("image_emoticon68", "你懂的");
        auf.put("image_emoticon69", "what");
        auf.put("image_emoticon70", "酸爽");
        auf.put("image_emoticon71", "呀咩爹");
        auf.put("image_emoticon72", "笑尿");
        auf.put("image_emoticon73", "挖鼻");
        auf.put("image_emoticon74", "犀利");
        auf.put("image_emoticon75", "小红脸");
        auf.put("image_emoticon76", "懒得理");
        auf.put("image_emoticon77", "沙发");
        auf.put("image_emoticon78", "手纸");
        auf.put("image_emoticon79", "香蕉");
        auf.put("image_emoticon80", "便便");
        auf.put("image_emoticon81", "药丸");
        auf.put("image_emoticon82", "红领巾");
        auf.put("image_emoticon83", "蜡烛");
        auf.put("image_emoticon84", "三道杠");
        auf.put("ali_001", "赖皮");
        auf.put("ali_002", "感动");
        auf.put("ali_003", "十分惊讶");
        auf.put("ali_004", "怒气");
        auf.put("ali_005", "哭泣");
        auf.put("ali_006", "吃惊");
        auf.put("ali_007", "嘲弄");
        auf.put("ali_008", "飘过");
        auf.put("ali_009", "转圈哭");
        auf.put("ali_010", "神经病");
        auf.put("ali_011", "揪耳朵");
        auf.put("ali_012", "惊汗");
        auf.put("ali_013", "隐身");
        auf.put("ali_014", "不要嘛");
        auf.put("ali_015", "遁");
        auf.put("ali_016", "不公平");
        auf.put("ali_017", "爬来了");
        auf.put("ali_018", "蛋花哭");
        auf.put("ali_019", "温暖");
        auf.put("ali_020", "点头");
        auf.put("ali_021", "撒钱");
        auf.put("ali_022", "献花");
        auf.put("ali_023", "寒");
        auf.put("ali_024", "傻笑");
        auf.put("ali_025", "扭扭");
        auf.put("ali_026", "疯");
        auf.put("ali_027", "抓狂");
        auf.put("ali_028", "抓");
        auf.put("ali_029", "蜷");
        auf.put("ali_030", "挠墙");
        auf.put("ali_031", "狂笑");
        auf.put("ali_032", "抱枕");
        auf.put("ali_033", "吼叫");
        auf.put("ali_034", "嚷");
        auf.put("ali_035", "唠叨");
        auf.put("ali_036", "捏脸");
        auf.put("ali_037", "爆笑");
        auf.put("ali_038", "郁闷");
        auf.put("ali_039", "潜水");
        auf.put("ali_040", "十分开心");
        auf.put("ali_041", "冷笑话");
        auf.put("ali_042", "顶！");
        auf.put("ali_043", "潜");
        auf.put("ali_044", "画圈圈");
        auf.put("ali_045", "玩电脑");
        auf.put("ali_046", "狂吐");
        auf.put("ali_047", "哭着跑");
        auf.put("ali_048", "阿狸侠");
        auf.put("ali_049", "冷死了");
        auf.put("ali_050", "惆怅~");
        auf.put("ali_051", "摸头");
        auf.put("ali_052", "蹭");
        auf.put("ali_053", "打滚");
        auf.put("ali_054", "叩拜");
        auf.put("ali_055", "摸");
        auf.put("ali_056", "数钱");
        auf.put("ali_057", "拖走");
        auf.put("ali_058", "热");
        auf.put("ali_059", "加1");
        auf.put("ali_060", "压力");
        auf.put("ali_061", "表逼我");
        auf.put("ali_062", "人呢");
        auf.put("ali_063", "摇晃");
        auf.put("ali_064", "打地鼠");
        auf.put("ali_065", "这个屌");
        auf.put("ali_066", "恐慌");
        auf.put("ali_067", "晕乎乎");
        auf.put("ali_068", "浮云");
        auf.put("ali_069", "给力");
        auf.put("ali_070", "杯具了");
        auf.put("b01", "微笑");
        auf.put("b02", "帅哥");
        auf.put("b03", "美女");
        auf.put("b04", "老大");
        auf.put("b05", "哈哈哈");
        auf.put("b06", "奸笑");
        auf.put("b07", "傻乐");
        auf.put("b08", "飞吻");
        auf.put("b09", "害羞");
        auf.put("b10", "花痴");
        auf.put("b11", "憧憬");
        auf.put("b12", "你牛");
        auf.put("b13", "鼓掌");
        auf.put("b14", "可爱");
        auf.put("b15", "太委屈");
        auf.put("b16", "大哭");
        auf.put("b17", "泪奔");
        auf.put("b18", "寻死");
        auf.put("b19", "非常惊讶");
        auf.put("b20", "表示疑问");
        auf.put("yz_001", "焦糖舞");
        auf.put("yz_002", "翻滚");
        auf.put("yz_003", "拍屁股做鬼脸");
        auf.put("yz_004", "不");
        auf.put("yz_005", "河蟹掉啦");
        auf.put("yz_006", "哦耶");
        auf.put("yz_007", "我倒");
        auf.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fn(String str) {
        Integer num = auc.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(r.g.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fo(String str) {
        Integer num = aue.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fp(String str) {
        return auf.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int CK() {
        return aud.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0044a y(Context context, String str) {
        return null;
    }
}
