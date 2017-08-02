package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aBC = new HashMap<>(200);
    public static final ArrayList<Integer> aBD = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aBE = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aBF = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aBF.put("image_emoticon", "呵呵");
        aBF.put("image_emoticon2", "哈哈");
        aBF.put("image_emoticon3", "吐舌");
        aBF.put("image_emoticon4", "啊");
        aBF.put("image_emoticon5", "酷");
        aBF.put("image_emoticon6", "怒");
        aBF.put("image_emoticon7", "开心");
        aBF.put("image_emoticon8", "汗");
        aBF.put("image_emoticon9", "泪");
        aBF.put("image_emoticon10", "黑线");
        aBF.put("image_emoticon11", "鄙视");
        aBF.put("image_emoticon12", "不高兴");
        aBF.put("image_emoticon13", "真棒");
        aBF.put("image_emoticon14", "钱");
        aBF.put("image_emoticon15", "疑问");
        aBF.put("image_emoticon16", "阴险");
        aBF.put("image_emoticon17", "吐");
        aBF.put("image_emoticon18", "咦");
        aBF.put("image_emoticon19", "委屈");
        aBF.put("image_emoticon20", "花心");
        aBF.put("image_emoticon21", "呼~");
        aBF.put("image_emoticon22", "笑眼");
        aBF.put("image_emoticon23", "冷");
        aBF.put("image_emoticon24", "太开心");
        aBF.put("image_emoticon25", "滑稽");
        aBF.put("image_emoticon26", "勉强");
        aBF.put("image_emoticon27", "狂汗");
        aBF.put("image_emoticon28", "乖");
        aBF.put("image_emoticon29", "睡觉");
        aBF.put("image_emoticon30", "惊哭");
        aBF.put("image_emoticon31", "生气");
        aBF.put("image_emoticon32", "惊讶");
        aBF.put("image_emoticon33", "喷");
        aBF.put("image_emoticon34", "爱心");
        aBF.put("image_emoticon35", "心碎");
        aBF.put("image_emoticon36", "玫瑰");
        aBF.put("image_emoticon37", "礼物");
        aBF.put("image_emoticon38", "彩虹");
        aBF.put("image_emoticon39", "星星月亮");
        aBF.put("image_emoticon40", "太阳");
        aBF.put("image_emoticon41", "钱币");
        aBF.put("image_emoticon42", "灯泡");
        aBF.put("image_emoticon43", "茶杯");
        aBF.put("image_emoticon44", "蛋糕");
        aBF.put("image_emoticon45", "音乐");
        aBF.put("image_emoticon46", "haha");
        aBF.put("image_emoticon47", "胜利");
        aBF.put("image_emoticon48", "大拇指");
        aBF.put("image_emoticon49", "弱");
        aBF.put("image_emoticon50", "OK");
        aBF.put("image_emoticon61", "哼");
        aBF.put("image_emoticon62", "吃瓜");
        aBF.put("image_emoticon63", "扔便便");
        aBF.put("image_emoticon64", "惊恐");
        aBF.put("image_emoticon65", "哎呦");
        aBF.put("image_emoticon66", "小乖");
        aBF.put("image_emoticon67", "捂嘴笑");
        aBF.put("image_emoticon68", "你懂的");
        aBF.put("image_emoticon69", "what");
        aBF.put("image_emoticon70", "酸爽");
        aBF.put("image_emoticon71", "呀咩爹");
        aBF.put("image_emoticon72", "笑尿");
        aBF.put("image_emoticon73", "挖鼻");
        aBF.put("image_emoticon74", "犀利");
        aBF.put("image_emoticon75", "小红脸");
        aBF.put("image_emoticon76", "懒得理");
        aBF.put("image_emoticon77", "沙发");
        aBF.put("image_emoticon78", "手纸");
        aBF.put("image_emoticon79", "香蕉");
        aBF.put("image_emoticon80", "便便");
        aBF.put("image_emoticon81", "药丸");
        aBF.put("image_emoticon82", "红领巾");
        aBF.put("image_emoticon83", "蜡烛");
        aBF.put("image_emoticon84", "三道杠");
        aBF.put("ali_001", "赖皮");
        aBF.put("ali_002", "感动");
        aBF.put("ali_003", "十分惊讶");
        aBF.put("ali_004", "怒气");
        aBF.put("ali_005", "哭泣");
        aBF.put("ali_006", "吃惊");
        aBF.put("ali_007", "嘲弄");
        aBF.put("ali_008", "飘过");
        aBF.put("ali_009", "转圈哭");
        aBF.put("ali_010", "神经病");
        aBF.put("ali_011", "揪耳朵");
        aBF.put("ali_012", "惊汗");
        aBF.put("ali_013", "隐身");
        aBF.put("ali_014", "不要嘛");
        aBF.put("ali_015", "遁");
        aBF.put("ali_016", "不公平");
        aBF.put("ali_017", "爬来了");
        aBF.put("ali_018", "蛋花哭");
        aBF.put("ali_019", "温暖");
        aBF.put("ali_020", "点头");
        aBF.put("ali_021", "撒钱");
        aBF.put("ali_022", "献花");
        aBF.put("ali_023", "寒");
        aBF.put("ali_024", "傻笑");
        aBF.put("ali_025", "扭扭");
        aBF.put("ali_026", "疯");
        aBF.put("ali_027", "抓狂");
        aBF.put("ali_028", "抓");
        aBF.put("ali_029", "蜷");
        aBF.put("ali_030", "挠墙");
        aBF.put("ali_031", "狂笑");
        aBF.put("ali_032", "抱枕");
        aBF.put("ali_033", "吼叫");
        aBF.put("ali_034", "嚷");
        aBF.put("ali_035", "唠叨");
        aBF.put("ali_036", "捏脸");
        aBF.put("ali_037", "爆笑");
        aBF.put("ali_038", "郁闷");
        aBF.put("ali_039", "潜水");
        aBF.put("ali_040", "十分开心");
        aBF.put("ali_041", "冷笑话");
        aBF.put("ali_042", "顶！");
        aBF.put("ali_043", "潜");
        aBF.put("ali_044", "画圈圈");
        aBF.put("ali_045", "玩电脑");
        aBF.put("ali_046", "狂吐");
        aBF.put("ali_047", "哭着跑");
        aBF.put("ali_048", "阿狸侠");
        aBF.put("ali_049", "冷死了");
        aBF.put("ali_050", "惆怅~");
        aBF.put("ali_051", "摸头");
        aBF.put("ali_052", "蹭");
        aBF.put("ali_053", "打滚");
        aBF.put("ali_054", "叩拜");
        aBF.put("ali_055", "摸");
        aBF.put("ali_056", "数钱");
        aBF.put("ali_057", "拖走");
        aBF.put("ali_058", "热");
        aBF.put("ali_059", "加1");
        aBF.put("ali_060", "压力");
        aBF.put("ali_061", "表逼我");
        aBF.put("ali_062", "人呢");
        aBF.put("ali_063", "摇晃");
        aBF.put("ali_064", "打地鼠");
        aBF.put("ali_065", "这个屌");
        aBF.put("ali_066", "恐慌");
        aBF.put("ali_067", "晕乎乎");
        aBF.put("ali_068", "浮云");
        aBF.put("ali_069", "给力");
        aBF.put("ali_070", "杯具了");
        aBF.put("b01", "微笑");
        aBF.put("b02", "帅哥");
        aBF.put("b03", "美女");
        aBF.put("b04", "老大");
        aBF.put("b05", "哈哈哈");
        aBF.put("b06", "奸笑");
        aBF.put("b07", "傻乐");
        aBF.put("b08", "飞吻");
        aBF.put("b09", "害羞");
        aBF.put("b10", "花痴");
        aBF.put("b11", "憧憬");
        aBF.put("b12", "你牛");
        aBF.put("b13", "鼓掌");
        aBF.put("b14", "可爱");
        aBF.put("b15", "太委屈");
        aBF.put("b16", "大哭");
        aBF.put("b17", "泪奔");
        aBF.put("b18", "寻死");
        aBF.put("b19", "非常惊讶");
        aBF.put("b20", "表示疑问");
        aBF.put("yz_001", "焦糖舞");
        aBF.put("yz_002", "翻滚");
        aBF.put("yz_003", "拍屁股做鬼脸");
        aBF.put("yz_004", "不");
        aBF.put("yz_005", "河蟹掉啦");
        aBF.put("yz_006", "哦耶");
        aBF.put("yz_007", "我倒");
        aBF.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fB(String str) {
        Integer num = aBC.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.g.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fC(String str) {
        Integer num = aBE.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fD(String str) {
        return aBF.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Df() {
        return aBD.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0057a X(Context context, String str) {
        return null;
    }
}
