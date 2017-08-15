package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aCU = new HashMap<>(200);
    public static final ArrayList<Integer> aCV = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aCW = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aCX = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aCX.put("image_emoticon", "呵呵");
        aCX.put("image_emoticon2", "哈哈");
        aCX.put("image_emoticon3", "吐舌");
        aCX.put("image_emoticon4", "啊");
        aCX.put("image_emoticon5", "酷");
        aCX.put("image_emoticon6", "怒");
        aCX.put("image_emoticon7", "开心");
        aCX.put("image_emoticon8", "汗");
        aCX.put("image_emoticon9", "泪");
        aCX.put("image_emoticon10", "黑线");
        aCX.put("image_emoticon11", "鄙视");
        aCX.put("image_emoticon12", "不高兴");
        aCX.put("image_emoticon13", "真棒");
        aCX.put("image_emoticon14", "钱");
        aCX.put("image_emoticon15", "疑问");
        aCX.put("image_emoticon16", "阴险");
        aCX.put("image_emoticon17", "吐");
        aCX.put("image_emoticon18", "咦");
        aCX.put("image_emoticon19", "委屈");
        aCX.put("image_emoticon20", "花心");
        aCX.put("image_emoticon21", "呼~");
        aCX.put("image_emoticon22", "笑眼");
        aCX.put("image_emoticon23", "冷");
        aCX.put("image_emoticon24", "太开心");
        aCX.put("image_emoticon25", "滑稽");
        aCX.put("image_emoticon26", "勉强");
        aCX.put("image_emoticon27", "狂汗");
        aCX.put("image_emoticon28", "乖");
        aCX.put("image_emoticon29", "睡觉");
        aCX.put("image_emoticon30", "惊哭");
        aCX.put("image_emoticon31", "生气");
        aCX.put("image_emoticon32", "惊讶");
        aCX.put("image_emoticon33", "喷");
        aCX.put("image_emoticon34", "爱心");
        aCX.put("image_emoticon35", "心碎");
        aCX.put("image_emoticon36", "玫瑰");
        aCX.put("image_emoticon37", "礼物");
        aCX.put("image_emoticon38", "彩虹");
        aCX.put("image_emoticon39", "星星月亮");
        aCX.put("image_emoticon40", "太阳");
        aCX.put("image_emoticon41", "钱币");
        aCX.put("image_emoticon42", "灯泡");
        aCX.put("image_emoticon43", "茶杯");
        aCX.put("image_emoticon44", "蛋糕");
        aCX.put("image_emoticon45", "音乐");
        aCX.put("image_emoticon46", "haha");
        aCX.put("image_emoticon47", "胜利");
        aCX.put("image_emoticon48", "大拇指");
        aCX.put("image_emoticon49", "弱");
        aCX.put("image_emoticon50", "OK");
        aCX.put("image_emoticon61", "哼");
        aCX.put("image_emoticon62", "吃瓜");
        aCX.put("image_emoticon63", "扔便便");
        aCX.put("image_emoticon64", "惊恐");
        aCX.put("image_emoticon65", "哎呦");
        aCX.put("image_emoticon66", "小乖");
        aCX.put("image_emoticon67", "捂嘴笑");
        aCX.put("image_emoticon68", "你懂的");
        aCX.put("image_emoticon69", "what");
        aCX.put("image_emoticon70", "酸爽");
        aCX.put("image_emoticon71", "呀咩爹");
        aCX.put("image_emoticon72", "笑尿");
        aCX.put("image_emoticon73", "挖鼻");
        aCX.put("image_emoticon74", "犀利");
        aCX.put("image_emoticon75", "小红脸");
        aCX.put("image_emoticon76", "懒得理");
        aCX.put("image_emoticon77", "沙发");
        aCX.put("image_emoticon78", "手纸");
        aCX.put("image_emoticon79", "香蕉");
        aCX.put("image_emoticon80", "便便");
        aCX.put("image_emoticon81", "药丸");
        aCX.put("image_emoticon82", "红领巾");
        aCX.put("image_emoticon83", "蜡烛");
        aCX.put("image_emoticon84", "三道杠");
        aCX.put("ali_001", "赖皮");
        aCX.put("ali_002", "感动");
        aCX.put("ali_003", "十分惊讶");
        aCX.put("ali_004", "怒气");
        aCX.put("ali_005", "哭泣");
        aCX.put("ali_006", "吃惊");
        aCX.put("ali_007", "嘲弄");
        aCX.put("ali_008", "飘过");
        aCX.put("ali_009", "转圈哭");
        aCX.put("ali_010", "神经病");
        aCX.put("ali_011", "揪耳朵");
        aCX.put("ali_012", "惊汗");
        aCX.put("ali_013", "隐身");
        aCX.put("ali_014", "不要嘛");
        aCX.put("ali_015", "遁");
        aCX.put("ali_016", "不公平");
        aCX.put("ali_017", "爬来了");
        aCX.put("ali_018", "蛋花哭");
        aCX.put("ali_019", "温暖");
        aCX.put("ali_020", "点头");
        aCX.put("ali_021", "撒钱");
        aCX.put("ali_022", "献花");
        aCX.put("ali_023", "寒");
        aCX.put("ali_024", "傻笑");
        aCX.put("ali_025", "扭扭");
        aCX.put("ali_026", "疯");
        aCX.put("ali_027", "抓狂");
        aCX.put("ali_028", "抓");
        aCX.put("ali_029", "蜷");
        aCX.put("ali_030", "挠墙");
        aCX.put("ali_031", "狂笑");
        aCX.put("ali_032", "抱枕");
        aCX.put("ali_033", "吼叫");
        aCX.put("ali_034", "嚷");
        aCX.put("ali_035", "唠叨");
        aCX.put("ali_036", "捏脸");
        aCX.put("ali_037", "爆笑");
        aCX.put("ali_038", "郁闷");
        aCX.put("ali_039", "潜水");
        aCX.put("ali_040", "十分开心");
        aCX.put("ali_041", "冷笑话");
        aCX.put("ali_042", "顶！");
        aCX.put("ali_043", "潜");
        aCX.put("ali_044", "画圈圈");
        aCX.put("ali_045", "玩电脑");
        aCX.put("ali_046", "狂吐");
        aCX.put("ali_047", "哭着跑");
        aCX.put("ali_048", "阿狸侠");
        aCX.put("ali_049", "冷死了");
        aCX.put("ali_050", "惆怅~");
        aCX.put("ali_051", "摸头");
        aCX.put("ali_052", "蹭");
        aCX.put("ali_053", "打滚");
        aCX.put("ali_054", "叩拜");
        aCX.put("ali_055", "摸");
        aCX.put("ali_056", "数钱");
        aCX.put("ali_057", "拖走");
        aCX.put("ali_058", "热");
        aCX.put("ali_059", "加1");
        aCX.put("ali_060", "压力");
        aCX.put("ali_061", "表逼我");
        aCX.put("ali_062", "人呢");
        aCX.put("ali_063", "摇晃");
        aCX.put("ali_064", "打地鼠");
        aCX.put("ali_065", "这个屌");
        aCX.put("ali_066", "恐慌");
        aCX.put("ali_067", "晕乎乎");
        aCX.put("ali_068", "浮云");
        aCX.put("ali_069", "给力");
        aCX.put("ali_070", "杯具了");
        aCX.put("b01", "微笑");
        aCX.put("b02", "帅哥");
        aCX.put("b03", "美女");
        aCX.put("b04", "老大");
        aCX.put("b05", "哈哈哈");
        aCX.put("b06", "奸笑");
        aCX.put("b07", "傻乐");
        aCX.put("b08", "飞吻");
        aCX.put("b09", "害羞");
        aCX.put("b10", "花痴");
        aCX.put("b11", "憧憬");
        aCX.put("b12", "你牛");
        aCX.put("b13", "鼓掌");
        aCX.put("b14", "可爱");
        aCX.put("b15", "太委屈");
        aCX.put("b16", "大哭");
        aCX.put("b17", "泪奔");
        aCX.put("b18", "寻死");
        aCX.put("b19", "非常惊讶");
        aCX.put("b20", "表示疑问");
        aCX.put("yz_001", "焦糖舞");
        aCX.put("yz_002", "翻滚");
        aCX.put("yz_003", "拍屁股做鬼脸");
        aCX.put("yz_004", "不");
        aCX.put("yz_005", "河蟹掉啦");
        aCX.put("yz_006", "哦耶");
        aCX.put("yz_007", "我倒");
        aCX.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fH(String str) {
        Integer num = aCU.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.g.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fI(String str) {
        Integer num = aCW.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fJ(String str) {
        return aCX.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Dn() {
        return aCV.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0057a X(Context context, String str) {
        return null;
    }
}
