package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.w;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> azz = new HashMap<>(200);
    public static final ArrayList<Integer> azA = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> azB = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> azC = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        azC.put("image_emoticon", "呵呵");
        azC.put("image_emoticon2", "哈哈");
        azC.put("image_emoticon3", "吐舌");
        azC.put("image_emoticon4", "啊");
        azC.put("image_emoticon5", "酷");
        azC.put("image_emoticon6", "怒");
        azC.put("image_emoticon7", "开心");
        azC.put("image_emoticon8", "汗");
        azC.put("image_emoticon9", "泪");
        azC.put("image_emoticon10", "黑线");
        azC.put("image_emoticon11", "鄙视");
        azC.put("image_emoticon12", "不高兴");
        azC.put("image_emoticon13", "真棒");
        azC.put("image_emoticon14", "钱");
        azC.put("image_emoticon15", "疑问");
        azC.put("image_emoticon16", "阴险");
        azC.put("image_emoticon17", "吐");
        azC.put("image_emoticon18", "咦");
        azC.put("image_emoticon19", "委屈");
        azC.put("image_emoticon20", "花心");
        azC.put("image_emoticon21", "呼~");
        azC.put("image_emoticon22", "笑眼");
        azC.put("image_emoticon23", "冷");
        azC.put("image_emoticon24", "太开心");
        azC.put("image_emoticon25", "滑稽");
        azC.put("image_emoticon26", "勉强");
        azC.put("image_emoticon27", "狂汗");
        azC.put("image_emoticon28", "乖");
        azC.put("image_emoticon29", "睡觉");
        azC.put("image_emoticon30", "惊哭");
        azC.put("image_emoticon31", "生气");
        azC.put("image_emoticon32", "惊讶");
        azC.put("image_emoticon33", "喷");
        azC.put("image_emoticon34", "爱心");
        azC.put("image_emoticon35", "心碎");
        azC.put("image_emoticon36", "玫瑰");
        azC.put("image_emoticon37", "礼物");
        azC.put("image_emoticon38", "彩虹");
        azC.put("image_emoticon39", "星星月亮");
        azC.put("image_emoticon40", "太阳");
        azC.put("image_emoticon41", "钱币");
        azC.put("image_emoticon42", "灯泡");
        azC.put("image_emoticon43", "茶杯");
        azC.put("image_emoticon44", "蛋糕");
        azC.put("image_emoticon45", "音乐");
        azC.put("image_emoticon46", "haha");
        azC.put("image_emoticon47", "胜利");
        azC.put("image_emoticon48", "大拇指");
        azC.put("image_emoticon49", "弱");
        azC.put("image_emoticon50", "OK");
        azC.put("image_emoticon61", "哼");
        azC.put("image_emoticon62", "吃瓜");
        azC.put("image_emoticon63", "扔便便");
        azC.put("image_emoticon64", "惊恐");
        azC.put("image_emoticon65", "哎呦");
        azC.put("image_emoticon66", "小乖");
        azC.put("image_emoticon67", "捂嘴笑");
        azC.put("image_emoticon68", "你懂的");
        azC.put("image_emoticon69", "what");
        azC.put("image_emoticon70", "酸爽");
        azC.put("image_emoticon71", "呀咩爹");
        azC.put("image_emoticon72", "笑尿");
        azC.put("image_emoticon73", "挖鼻");
        azC.put("image_emoticon74", "犀利");
        azC.put("image_emoticon75", "小红脸");
        azC.put("image_emoticon76", "懒得理");
        azC.put("image_emoticon77", "沙发");
        azC.put("image_emoticon78", "手纸");
        azC.put("image_emoticon79", "香蕉");
        azC.put("image_emoticon80", "便便");
        azC.put("image_emoticon81", "药丸");
        azC.put("image_emoticon82", "红领巾");
        azC.put("image_emoticon83", "蜡烛");
        azC.put("image_emoticon84", "三道杠");
        azC.put("ali_001", "赖皮");
        azC.put("ali_002", "感动");
        azC.put("ali_003", "十分惊讶");
        azC.put("ali_004", "怒气");
        azC.put("ali_005", "哭泣");
        azC.put("ali_006", "吃惊");
        azC.put("ali_007", "嘲弄");
        azC.put("ali_008", "飘过");
        azC.put("ali_009", "转圈哭");
        azC.put("ali_010", "神经病");
        azC.put("ali_011", "揪耳朵");
        azC.put("ali_012", "惊汗");
        azC.put("ali_013", "隐身");
        azC.put("ali_014", "不要嘛");
        azC.put("ali_015", "遁");
        azC.put("ali_016", "不公平");
        azC.put("ali_017", "爬来了");
        azC.put("ali_018", "蛋花哭");
        azC.put("ali_019", "温暖");
        azC.put("ali_020", "点头");
        azC.put("ali_021", "撒钱");
        azC.put("ali_022", "献花");
        azC.put("ali_023", "寒");
        azC.put("ali_024", "傻笑");
        azC.put("ali_025", "扭扭");
        azC.put("ali_026", "疯");
        azC.put("ali_027", "抓狂");
        azC.put("ali_028", "抓");
        azC.put("ali_029", "蜷");
        azC.put("ali_030", "挠墙");
        azC.put("ali_031", "狂笑");
        azC.put("ali_032", "抱枕");
        azC.put("ali_033", "吼叫");
        azC.put("ali_034", "嚷");
        azC.put("ali_035", "唠叨");
        azC.put("ali_036", "捏脸");
        azC.put("ali_037", "爆笑");
        azC.put("ali_038", "郁闷");
        azC.put("ali_039", "潜水");
        azC.put("ali_040", "十分开心");
        azC.put("ali_041", "冷笑话");
        azC.put("ali_042", "顶！");
        azC.put("ali_043", "潜");
        azC.put("ali_044", "画圈圈");
        azC.put("ali_045", "玩电脑");
        azC.put("ali_046", "狂吐");
        azC.put("ali_047", "哭着跑");
        azC.put("ali_048", "阿狸侠");
        azC.put("ali_049", "冷死了");
        azC.put("ali_050", "惆怅~");
        azC.put("ali_051", "摸头");
        azC.put("ali_052", "蹭");
        azC.put("ali_053", "打滚");
        azC.put("ali_054", "叩拜");
        azC.put("ali_055", "摸");
        azC.put("ali_056", "数钱");
        azC.put("ali_057", "拖走");
        azC.put("ali_058", "热");
        azC.put("ali_059", "加1");
        azC.put("ali_060", "压力");
        azC.put("ali_061", "表逼我");
        azC.put("ali_062", "人呢");
        azC.put("ali_063", "摇晃");
        azC.put("ali_064", "打地鼠");
        azC.put("ali_065", "这个屌");
        azC.put("ali_066", "恐慌");
        azC.put("ali_067", "晕乎乎");
        azC.put("ali_068", "浮云");
        azC.put("ali_069", "给力");
        azC.put("ali_070", "杯具了");
        azC.put("b01", "微笑");
        azC.put("b02", "帅哥");
        azC.put("b03", "美女");
        azC.put("b04", "老大");
        azC.put("b05", "哈哈哈");
        azC.put("b06", "奸笑");
        azC.put("b07", "傻乐");
        azC.put("b08", "飞吻");
        azC.put("b09", "害羞");
        azC.put("b10", "花痴");
        azC.put("b11", "憧憬");
        azC.put("b12", "你牛");
        azC.put("b13", "鼓掌");
        azC.put("b14", "可爱");
        azC.put("b15", "太委屈");
        azC.put("b16", "大哭");
        azC.put("b17", "泪奔");
        azC.put("b18", "寻死");
        azC.put("b19", "非常惊讶");
        azC.put("b20", "表示疑问");
        azC.put("yz_001", "焦糖舞");
        azC.put("yz_002", "翻滚");
        azC.put("yz_003", "拍屁股做鬼脸");
        azC.put("yz_004", "不");
        azC.put("yz_005", "河蟹掉啦");
        azC.put("yz_006", "哦耶");
        azC.put("yz_007", "我倒");
        azC.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fd(String str) {
        Integer num = azz.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(w.g.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fe(String str) {
        Integer num = azB.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String ff(String str) {
        return azC.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Cy() {
        return azA.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0045a W(Context context, String str) {
        return null;
    }
}
