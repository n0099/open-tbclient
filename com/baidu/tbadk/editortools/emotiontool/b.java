package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aCV = new HashMap<>(200);
    public static final ArrayList<Integer> aCW = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aCX = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aCY = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aCY.put("image_emoticon", "呵呵");
        aCY.put("image_emoticon2", "哈哈");
        aCY.put("image_emoticon3", "吐舌");
        aCY.put("image_emoticon4", "啊");
        aCY.put("image_emoticon5", "酷");
        aCY.put("image_emoticon6", "怒");
        aCY.put("image_emoticon7", "开心");
        aCY.put("image_emoticon8", "汗");
        aCY.put("image_emoticon9", "泪");
        aCY.put("image_emoticon10", "黑线");
        aCY.put("image_emoticon11", "鄙视");
        aCY.put("image_emoticon12", "不高兴");
        aCY.put("image_emoticon13", "真棒");
        aCY.put("image_emoticon14", "钱");
        aCY.put("image_emoticon15", "疑问");
        aCY.put("image_emoticon16", "阴险");
        aCY.put("image_emoticon17", "吐");
        aCY.put("image_emoticon18", "咦");
        aCY.put("image_emoticon19", "委屈");
        aCY.put("image_emoticon20", "花心");
        aCY.put("image_emoticon21", "呼~");
        aCY.put("image_emoticon22", "笑眼");
        aCY.put("image_emoticon23", "冷");
        aCY.put("image_emoticon24", "太开心");
        aCY.put("image_emoticon25", "滑稽");
        aCY.put("image_emoticon26", "勉强");
        aCY.put("image_emoticon27", "狂汗");
        aCY.put("image_emoticon28", "乖");
        aCY.put("image_emoticon29", "睡觉");
        aCY.put("image_emoticon30", "惊哭");
        aCY.put("image_emoticon31", "生气");
        aCY.put("image_emoticon32", "惊讶");
        aCY.put("image_emoticon33", "喷");
        aCY.put("image_emoticon34", "爱心");
        aCY.put("image_emoticon35", "心碎");
        aCY.put("image_emoticon36", "玫瑰");
        aCY.put("image_emoticon37", "礼物");
        aCY.put("image_emoticon38", "彩虹");
        aCY.put("image_emoticon39", "星星月亮");
        aCY.put("image_emoticon40", "太阳");
        aCY.put("image_emoticon41", "钱币");
        aCY.put("image_emoticon42", "灯泡");
        aCY.put("image_emoticon43", "茶杯");
        aCY.put("image_emoticon44", "蛋糕");
        aCY.put("image_emoticon45", "音乐");
        aCY.put("image_emoticon46", "haha");
        aCY.put("image_emoticon47", "胜利");
        aCY.put("image_emoticon48", "大拇指");
        aCY.put("image_emoticon49", "弱");
        aCY.put("image_emoticon50", "OK");
        aCY.put("image_emoticon61", "哼");
        aCY.put("image_emoticon62", "吃瓜");
        aCY.put("image_emoticon63", "扔便便");
        aCY.put("image_emoticon64", "惊恐");
        aCY.put("image_emoticon65", "哎呦");
        aCY.put("image_emoticon66", "小乖");
        aCY.put("image_emoticon67", "捂嘴笑");
        aCY.put("image_emoticon68", "你懂的");
        aCY.put("image_emoticon69", "what");
        aCY.put("image_emoticon70", "酸爽");
        aCY.put("image_emoticon71", "呀咩爹");
        aCY.put("image_emoticon72", "笑尿");
        aCY.put("image_emoticon73", "挖鼻");
        aCY.put("image_emoticon74", "犀利");
        aCY.put("image_emoticon75", "小红脸");
        aCY.put("image_emoticon76", "懒得理");
        aCY.put("image_emoticon77", "沙发");
        aCY.put("image_emoticon78", "手纸");
        aCY.put("image_emoticon79", "香蕉");
        aCY.put("image_emoticon80", "便便");
        aCY.put("image_emoticon81", "药丸");
        aCY.put("image_emoticon82", "红领巾");
        aCY.put("image_emoticon83", "蜡烛");
        aCY.put("image_emoticon84", "三道杠");
        aCY.put("ali_001", "赖皮");
        aCY.put("ali_002", "感动");
        aCY.put("ali_003", "十分惊讶");
        aCY.put("ali_004", "怒气");
        aCY.put("ali_005", "哭泣");
        aCY.put("ali_006", "吃惊");
        aCY.put("ali_007", "嘲弄");
        aCY.put("ali_008", "飘过");
        aCY.put("ali_009", "转圈哭");
        aCY.put("ali_010", "神经病");
        aCY.put("ali_011", "揪耳朵");
        aCY.put("ali_012", "惊汗");
        aCY.put("ali_013", "隐身");
        aCY.put("ali_014", "不要嘛");
        aCY.put("ali_015", "遁");
        aCY.put("ali_016", "不公平");
        aCY.put("ali_017", "爬来了");
        aCY.put("ali_018", "蛋花哭");
        aCY.put("ali_019", "温暖");
        aCY.put("ali_020", "点头");
        aCY.put("ali_021", "撒钱");
        aCY.put("ali_022", "献花");
        aCY.put("ali_023", "寒");
        aCY.put("ali_024", "傻笑");
        aCY.put("ali_025", "扭扭");
        aCY.put("ali_026", "疯");
        aCY.put("ali_027", "抓狂");
        aCY.put("ali_028", "抓");
        aCY.put("ali_029", "蜷");
        aCY.put("ali_030", "挠墙");
        aCY.put("ali_031", "狂笑");
        aCY.put("ali_032", "抱枕");
        aCY.put("ali_033", "吼叫");
        aCY.put("ali_034", "嚷");
        aCY.put("ali_035", "唠叨");
        aCY.put("ali_036", "捏脸");
        aCY.put("ali_037", "爆笑");
        aCY.put("ali_038", "郁闷");
        aCY.put("ali_039", "潜水");
        aCY.put("ali_040", "十分开心");
        aCY.put("ali_041", "冷笑话");
        aCY.put("ali_042", "顶！");
        aCY.put("ali_043", "潜");
        aCY.put("ali_044", "画圈圈");
        aCY.put("ali_045", "玩电脑");
        aCY.put("ali_046", "狂吐");
        aCY.put("ali_047", "哭着跑");
        aCY.put("ali_048", "阿狸侠");
        aCY.put("ali_049", "冷死了");
        aCY.put("ali_050", "惆怅~");
        aCY.put("ali_051", "摸头");
        aCY.put("ali_052", "蹭");
        aCY.put("ali_053", "打滚");
        aCY.put("ali_054", "叩拜");
        aCY.put("ali_055", "摸");
        aCY.put("ali_056", "数钱");
        aCY.put("ali_057", "拖走");
        aCY.put("ali_058", "热");
        aCY.put("ali_059", "加1");
        aCY.put("ali_060", "压力");
        aCY.put("ali_061", "表逼我");
        aCY.put("ali_062", "人呢");
        aCY.put("ali_063", "摇晃");
        aCY.put("ali_064", "打地鼠");
        aCY.put("ali_065", "这个屌");
        aCY.put("ali_066", "恐慌");
        aCY.put("ali_067", "晕乎乎");
        aCY.put("ali_068", "浮云");
        aCY.put("ali_069", "给力");
        aCY.put("ali_070", "杯具了");
        aCY.put("b01", "微笑");
        aCY.put("b02", "帅哥");
        aCY.put("b03", "美女");
        aCY.put("b04", "老大");
        aCY.put("b05", "哈哈哈");
        aCY.put("b06", "奸笑");
        aCY.put("b07", "傻乐");
        aCY.put("b08", "飞吻");
        aCY.put("b09", "害羞");
        aCY.put("b10", "花痴");
        aCY.put("b11", "憧憬");
        aCY.put("b12", "你牛");
        aCY.put("b13", "鼓掌");
        aCY.put("b14", "可爱");
        aCY.put("b15", "太委屈");
        aCY.put("b16", "大哭");
        aCY.put("b17", "泪奔");
        aCY.put("b18", "寻死");
        aCY.put("b19", "非常惊讶");
        aCY.put("b20", "表示疑问");
        aCY.put("yz_001", "焦糖舞");
        aCY.put("yz_002", "翻滚");
        aCY.put("yz_003", "拍屁股做鬼脸");
        aCY.put("yz_004", "不");
        aCY.put("yz_005", "河蟹掉啦");
        aCY.put("yz_006", "哦耶");
        aCY.put("yz_007", "我倒");
        aCY.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fL(String str) {
        Integer num = aCV.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.g.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fM(String str) {
        Integer num = aCX.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fN(String str) {
        return aCY.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Dn() {
        return aCW.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0057a X(Context context, String str) {
        return null;
    }
}
