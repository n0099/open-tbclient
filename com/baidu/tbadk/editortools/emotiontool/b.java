package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aCf = new HashMap<>(200);
    public static final ArrayList<Integer> aCg = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aCh = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aCi = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aCi.put("image_emoticon", "呵呵");
        aCi.put("image_emoticon2", "哈哈");
        aCi.put("image_emoticon3", "吐舌");
        aCi.put("image_emoticon4", "啊");
        aCi.put("image_emoticon5", "酷");
        aCi.put("image_emoticon6", "怒");
        aCi.put("image_emoticon7", "开心");
        aCi.put("image_emoticon8", "汗");
        aCi.put("image_emoticon9", "泪");
        aCi.put("image_emoticon10", "黑线");
        aCi.put("image_emoticon11", "鄙视");
        aCi.put("image_emoticon12", "不高兴");
        aCi.put("image_emoticon13", "真棒");
        aCi.put("image_emoticon14", "钱");
        aCi.put("image_emoticon15", "疑问");
        aCi.put("image_emoticon16", "阴险");
        aCi.put("image_emoticon17", "吐");
        aCi.put("image_emoticon18", "咦");
        aCi.put("image_emoticon19", "委屈");
        aCi.put("image_emoticon20", "花心");
        aCi.put("image_emoticon21", "呼~");
        aCi.put("image_emoticon22", "笑眼");
        aCi.put("image_emoticon23", "冷");
        aCi.put("image_emoticon24", "太开心");
        aCi.put("image_emoticon25", "滑稽");
        aCi.put("image_emoticon26", "勉强");
        aCi.put("image_emoticon27", "狂汗");
        aCi.put("image_emoticon28", "乖");
        aCi.put("image_emoticon29", "睡觉");
        aCi.put("image_emoticon30", "惊哭");
        aCi.put("image_emoticon31", "生气");
        aCi.put("image_emoticon32", "惊讶");
        aCi.put("image_emoticon33", "喷");
        aCi.put("image_emoticon34", "爱心");
        aCi.put("image_emoticon35", "心碎");
        aCi.put("image_emoticon36", "玫瑰");
        aCi.put("image_emoticon37", "礼物");
        aCi.put("image_emoticon38", "彩虹");
        aCi.put("image_emoticon39", "星星月亮");
        aCi.put("image_emoticon40", "太阳");
        aCi.put("image_emoticon41", "钱币");
        aCi.put("image_emoticon42", "灯泡");
        aCi.put("image_emoticon43", "茶杯");
        aCi.put("image_emoticon44", "蛋糕");
        aCi.put("image_emoticon45", "音乐");
        aCi.put("image_emoticon46", "haha");
        aCi.put("image_emoticon47", "胜利");
        aCi.put("image_emoticon48", "大拇指");
        aCi.put("image_emoticon49", "弱");
        aCi.put("image_emoticon50", "OK");
        aCi.put("image_emoticon61", "哼");
        aCi.put("image_emoticon62", "吃瓜");
        aCi.put("image_emoticon63", "扔便便");
        aCi.put("image_emoticon64", "惊恐");
        aCi.put("image_emoticon65", "哎呦");
        aCi.put("image_emoticon66", "小乖");
        aCi.put("image_emoticon67", "捂嘴笑");
        aCi.put("image_emoticon68", "你懂的");
        aCi.put("image_emoticon69", "what");
        aCi.put("image_emoticon70", "酸爽");
        aCi.put("image_emoticon71", "呀咩爹");
        aCi.put("image_emoticon72", "笑尿");
        aCi.put("image_emoticon73", "挖鼻");
        aCi.put("image_emoticon74", "犀利");
        aCi.put("image_emoticon75", "小红脸");
        aCi.put("image_emoticon76", "懒得理");
        aCi.put("image_emoticon77", "沙发");
        aCi.put("image_emoticon78", "手纸");
        aCi.put("image_emoticon79", "香蕉");
        aCi.put("image_emoticon80", "便便");
        aCi.put("image_emoticon81", "药丸");
        aCi.put("image_emoticon82", "红领巾");
        aCi.put("image_emoticon83", "蜡烛");
        aCi.put("image_emoticon84", "三道杠");
        aCi.put("ali_001", "赖皮");
        aCi.put("ali_002", "感动");
        aCi.put("ali_003", "十分惊讶");
        aCi.put("ali_004", "怒气");
        aCi.put("ali_005", "哭泣");
        aCi.put("ali_006", "吃惊");
        aCi.put("ali_007", "嘲弄");
        aCi.put("ali_008", "飘过");
        aCi.put("ali_009", "转圈哭");
        aCi.put("ali_010", "神经病");
        aCi.put("ali_011", "揪耳朵");
        aCi.put("ali_012", "惊汗");
        aCi.put("ali_013", "隐身");
        aCi.put("ali_014", "不要嘛");
        aCi.put("ali_015", "遁");
        aCi.put("ali_016", "不公平");
        aCi.put("ali_017", "爬来了");
        aCi.put("ali_018", "蛋花哭");
        aCi.put("ali_019", "温暖");
        aCi.put("ali_020", "点头");
        aCi.put("ali_021", "撒钱");
        aCi.put("ali_022", "献花");
        aCi.put("ali_023", "寒");
        aCi.put("ali_024", "傻笑");
        aCi.put("ali_025", "扭扭");
        aCi.put("ali_026", "疯");
        aCi.put("ali_027", "抓狂");
        aCi.put("ali_028", "抓");
        aCi.put("ali_029", "蜷");
        aCi.put("ali_030", "挠墙");
        aCi.put("ali_031", "狂笑");
        aCi.put("ali_032", "抱枕");
        aCi.put("ali_033", "吼叫");
        aCi.put("ali_034", "嚷");
        aCi.put("ali_035", "唠叨");
        aCi.put("ali_036", "捏脸");
        aCi.put("ali_037", "爆笑");
        aCi.put("ali_038", "郁闷");
        aCi.put("ali_039", "潜水");
        aCi.put("ali_040", "十分开心");
        aCi.put("ali_041", "冷笑话");
        aCi.put("ali_042", "顶！");
        aCi.put("ali_043", "潜");
        aCi.put("ali_044", "画圈圈");
        aCi.put("ali_045", "玩电脑");
        aCi.put("ali_046", "狂吐");
        aCi.put("ali_047", "哭着跑");
        aCi.put("ali_048", "阿狸侠");
        aCi.put("ali_049", "冷死了");
        aCi.put("ali_050", "惆怅~");
        aCi.put("ali_051", "摸头");
        aCi.put("ali_052", "蹭");
        aCi.put("ali_053", "打滚");
        aCi.put("ali_054", "叩拜");
        aCi.put("ali_055", "摸");
        aCi.put("ali_056", "数钱");
        aCi.put("ali_057", "拖走");
        aCi.put("ali_058", "热");
        aCi.put("ali_059", "加1");
        aCi.put("ali_060", "压力");
        aCi.put("ali_061", "表逼我");
        aCi.put("ali_062", "人呢");
        aCi.put("ali_063", "摇晃");
        aCi.put("ali_064", "打地鼠");
        aCi.put("ali_065", "这个屌");
        aCi.put("ali_066", "恐慌");
        aCi.put("ali_067", "晕乎乎");
        aCi.put("ali_068", "浮云");
        aCi.put("ali_069", "给力");
        aCi.put("ali_070", "杯具了");
        aCi.put("b01", "微笑");
        aCi.put("b02", "帅哥");
        aCi.put("b03", "美女");
        aCi.put("b04", "老大");
        aCi.put("b05", "哈哈哈");
        aCi.put("b06", "奸笑");
        aCi.put("b07", "傻乐");
        aCi.put("b08", "飞吻");
        aCi.put("b09", "害羞");
        aCi.put("b10", "花痴");
        aCi.put("b11", "憧憬");
        aCi.put("b12", "你牛");
        aCi.put("b13", "鼓掌");
        aCi.put("b14", "可爱");
        aCi.put("b15", "太委屈");
        aCi.put("b16", "大哭");
        aCi.put("b17", "泪奔");
        aCi.put("b18", "寻死");
        aCi.put("b19", "非常惊讶");
        aCi.put("b20", "表示疑问");
        aCi.put("yz_001", "焦糖舞");
        aCi.put("yz_002", "翻滚");
        aCi.put("yz_003", "拍屁股做鬼脸");
        aCi.put("yz_004", "不");
        aCi.put("yz_005", "河蟹掉啦");
        aCi.put("yz_006", "哦耶");
        aCi.put("yz_007", "我倒");
        aCi.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fG(String str) {
        Integer num = aCf.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.g.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fH(String str) {
        Integer num = aCh.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fI(String str) {
        return aCi.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Di() {
        return aCg.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0059a X(Context context, String str) {
        return null;
    }
}
