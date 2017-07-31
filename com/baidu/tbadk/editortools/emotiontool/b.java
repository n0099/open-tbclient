package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aCT = new HashMap<>(200);
    public static final ArrayList<Integer> aCU = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aCV = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aCW = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aCW.put("image_emoticon", "呵呵");
        aCW.put("image_emoticon2", "哈哈");
        aCW.put("image_emoticon3", "吐舌");
        aCW.put("image_emoticon4", "啊");
        aCW.put("image_emoticon5", "酷");
        aCW.put("image_emoticon6", "怒");
        aCW.put("image_emoticon7", "开心");
        aCW.put("image_emoticon8", "汗");
        aCW.put("image_emoticon9", "泪");
        aCW.put("image_emoticon10", "黑线");
        aCW.put("image_emoticon11", "鄙视");
        aCW.put("image_emoticon12", "不高兴");
        aCW.put("image_emoticon13", "真棒");
        aCW.put("image_emoticon14", "钱");
        aCW.put("image_emoticon15", "疑问");
        aCW.put("image_emoticon16", "阴险");
        aCW.put("image_emoticon17", "吐");
        aCW.put("image_emoticon18", "咦");
        aCW.put("image_emoticon19", "委屈");
        aCW.put("image_emoticon20", "花心");
        aCW.put("image_emoticon21", "呼~");
        aCW.put("image_emoticon22", "笑眼");
        aCW.put("image_emoticon23", "冷");
        aCW.put("image_emoticon24", "太开心");
        aCW.put("image_emoticon25", "滑稽");
        aCW.put("image_emoticon26", "勉强");
        aCW.put("image_emoticon27", "狂汗");
        aCW.put("image_emoticon28", "乖");
        aCW.put("image_emoticon29", "睡觉");
        aCW.put("image_emoticon30", "惊哭");
        aCW.put("image_emoticon31", "生气");
        aCW.put("image_emoticon32", "惊讶");
        aCW.put("image_emoticon33", "喷");
        aCW.put("image_emoticon34", "爱心");
        aCW.put("image_emoticon35", "心碎");
        aCW.put("image_emoticon36", "玫瑰");
        aCW.put("image_emoticon37", "礼物");
        aCW.put("image_emoticon38", "彩虹");
        aCW.put("image_emoticon39", "星星月亮");
        aCW.put("image_emoticon40", "太阳");
        aCW.put("image_emoticon41", "钱币");
        aCW.put("image_emoticon42", "灯泡");
        aCW.put("image_emoticon43", "茶杯");
        aCW.put("image_emoticon44", "蛋糕");
        aCW.put("image_emoticon45", "音乐");
        aCW.put("image_emoticon46", "haha");
        aCW.put("image_emoticon47", "胜利");
        aCW.put("image_emoticon48", "大拇指");
        aCW.put("image_emoticon49", "弱");
        aCW.put("image_emoticon50", "OK");
        aCW.put("image_emoticon61", "哼");
        aCW.put("image_emoticon62", "吃瓜");
        aCW.put("image_emoticon63", "扔便便");
        aCW.put("image_emoticon64", "惊恐");
        aCW.put("image_emoticon65", "哎呦");
        aCW.put("image_emoticon66", "小乖");
        aCW.put("image_emoticon67", "捂嘴笑");
        aCW.put("image_emoticon68", "你懂的");
        aCW.put("image_emoticon69", "what");
        aCW.put("image_emoticon70", "酸爽");
        aCW.put("image_emoticon71", "呀咩爹");
        aCW.put("image_emoticon72", "笑尿");
        aCW.put("image_emoticon73", "挖鼻");
        aCW.put("image_emoticon74", "犀利");
        aCW.put("image_emoticon75", "小红脸");
        aCW.put("image_emoticon76", "懒得理");
        aCW.put("image_emoticon77", "沙发");
        aCW.put("image_emoticon78", "手纸");
        aCW.put("image_emoticon79", "香蕉");
        aCW.put("image_emoticon80", "便便");
        aCW.put("image_emoticon81", "药丸");
        aCW.put("image_emoticon82", "红领巾");
        aCW.put("image_emoticon83", "蜡烛");
        aCW.put("image_emoticon84", "三道杠");
        aCW.put("ali_001", "赖皮");
        aCW.put("ali_002", "感动");
        aCW.put("ali_003", "十分惊讶");
        aCW.put("ali_004", "怒气");
        aCW.put("ali_005", "哭泣");
        aCW.put("ali_006", "吃惊");
        aCW.put("ali_007", "嘲弄");
        aCW.put("ali_008", "飘过");
        aCW.put("ali_009", "转圈哭");
        aCW.put("ali_010", "神经病");
        aCW.put("ali_011", "揪耳朵");
        aCW.put("ali_012", "惊汗");
        aCW.put("ali_013", "隐身");
        aCW.put("ali_014", "不要嘛");
        aCW.put("ali_015", "遁");
        aCW.put("ali_016", "不公平");
        aCW.put("ali_017", "爬来了");
        aCW.put("ali_018", "蛋花哭");
        aCW.put("ali_019", "温暖");
        aCW.put("ali_020", "点头");
        aCW.put("ali_021", "撒钱");
        aCW.put("ali_022", "献花");
        aCW.put("ali_023", "寒");
        aCW.put("ali_024", "傻笑");
        aCW.put("ali_025", "扭扭");
        aCW.put("ali_026", "疯");
        aCW.put("ali_027", "抓狂");
        aCW.put("ali_028", "抓");
        aCW.put("ali_029", "蜷");
        aCW.put("ali_030", "挠墙");
        aCW.put("ali_031", "狂笑");
        aCW.put("ali_032", "抱枕");
        aCW.put("ali_033", "吼叫");
        aCW.put("ali_034", "嚷");
        aCW.put("ali_035", "唠叨");
        aCW.put("ali_036", "捏脸");
        aCW.put("ali_037", "爆笑");
        aCW.put("ali_038", "郁闷");
        aCW.put("ali_039", "潜水");
        aCW.put("ali_040", "十分开心");
        aCW.put("ali_041", "冷笑话");
        aCW.put("ali_042", "顶！");
        aCW.put("ali_043", "潜");
        aCW.put("ali_044", "画圈圈");
        aCW.put("ali_045", "玩电脑");
        aCW.put("ali_046", "狂吐");
        aCW.put("ali_047", "哭着跑");
        aCW.put("ali_048", "阿狸侠");
        aCW.put("ali_049", "冷死了");
        aCW.put("ali_050", "惆怅~");
        aCW.put("ali_051", "摸头");
        aCW.put("ali_052", "蹭");
        aCW.put("ali_053", "打滚");
        aCW.put("ali_054", "叩拜");
        aCW.put("ali_055", "摸");
        aCW.put("ali_056", "数钱");
        aCW.put("ali_057", "拖走");
        aCW.put("ali_058", "热");
        aCW.put("ali_059", "加1");
        aCW.put("ali_060", "压力");
        aCW.put("ali_061", "表逼我");
        aCW.put("ali_062", "人呢");
        aCW.put("ali_063", "摇晃");
        aCW.put("ali_064", "打地鼠");
        aCW.put("ali_065", "这个屌");
        aCW.put("ali_066", "恐慌");
        aCW.put("ali_067", "晕乎乎");
        aCW.put("ali_068", "浮云");
        aCW.put("ali_069", "给力");
        aCW.put("ali_070", "杯具了");
        aCW.put("b01", "微笑");
        aCW.put("b02", "帅哥");
        aCW.put("b03", "美女");
        aCW.put("b04", "老大");
        aCW.put("b05", "哈哈哈");
        aCW.put("b06", "奸笑");
        aCW.put("b07", "傻乐");
        aCW.put("b08", "飞吻");
        aCW.put("b09", "害羞");
        aCW.put("b10", "花痴");
        aCW.put("b11", "憧憬");
        aCW.put("b12", "你牛");
        aCW.put("b13", "鼓掌");
        aCW.put("b14", "可爱");
        aCW.put("b15", "太委屈");
        aCW.put("b16", "大哭");
        aCW.put("b17", "泪奔");
        aCW.put("b18", "寻死");
        aCW.put("b19", "非常惊讶");
        aCW.put("b20", "表示疑问");
        aCW.put("yz_001", "焦糖舞");
        aCW.put("yz_002", "翻滚");
        aCW.put("yz_003", "拍屁股做鬼脸");
        aCW.put("yz_004", "不");
        aCW.put("yz_005", "河蟹掉啦");
        aCW.put("yz_006", "哦耶");
        aCW.put("yz_007", "我倒");
        aCW.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fH(String str) {
        Integer num = aCT.get(str);
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
        Integer num = aCV.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fJ(String str) {
        return aCW.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Dn() {
        return aCU.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0057a X(Context context, String str) {
        return null;
    }
}
