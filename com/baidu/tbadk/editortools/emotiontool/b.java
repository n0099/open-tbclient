package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aCe = new HashMap<>(200);
    public static final ArrayList<Integer> aCf = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aCg = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aCh = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aCh.put("image_emoticon", "呵呵");
        aCh.put("image_emoticon2", "哈哈");
        aCh.put("image_emoticon3", "吐舌");
        aCh.put("image_emoticon4", "啊");
        aCh.put("image_emoticon5", "酷");
        aCh.put("image_emoticon6", "怒");
        aCh.put("image_emoticon7", "开心");
        aCh.put("image_emoticon8", "汗");
        aCh.put("image_emoticon9", "泪");
        aCh.put("image_emoticon10", "黑线");
        aCh.put("image_emoticon11", "鄙视");
        aCh.put("image_emoticon12", "不高兴");
        aCh.put("image_emoticon13", "真棒");
        aCh.put("image_emoticon14", "钱");
        aCh.put("image_emoticon15", "疑问");
        aCh.put("image_emoticon16", "阴险");
        aCh.put("image_emoticon17", "吐");
        aCh.put("image_emoticon18", "咦");
        aCh.put("image_emoticon19", "委屈");
        aCh.put("image_emoticon20", "花心");
        aCh.put("image_emoticon21", "呼~");
        aCh.put("image_emoticon22", "笑眼");
        aCh.put("image_emoticon23", "冷");
        aCh.put("image_emoticon24", "太开心");
        aCh.put("image_emoticon25", "滑稽");
        aCh.put("image_emoticon26", "勉强");
        aCh.put("image_emoticon27", "狂汗");
        aCh.put("image_emoticon28", "乖");
        aCh.put("image_emoticon29", "睡觉");
        aCh.put("image_emoticon30", "惊哭");
        aCh.put("image_emoticon31", "生气");
        aCh.put("image_emoticon32", "惊讶");
        aCh.put("image_emoticon33", "喷");
        aCh.put("image_emoticon34", "爱心");
        aCh.put("image_emoticon35", "心碎");
        aCh.put("image_emoticon36", "玫瑰");
        aCh.put("image_emoticon37", "礼物");
        aCh.put("image_emoticon38", "彩虹");
        aCh.put("image_emoticon39", "星星月亮");
        aCh.put("image_emoticon40", "太阳");
        aCh.put("image_emoticon41", "钱币");
        aCh.put("image_emoticon42", "灯泡");
        aCh.put("image_emoticon43", "茶杯");
        aCh.put("image_emoticon44", "蛋糕");
        aCh.put("image_emoticon45", "音乐");
        aCh.put("image_emoticon46", "haha");
        aCh.put("image_emoticon47", "胜利");
        aCh.put("image_emoticon48", "大拇指");
        aCh.put("image_emoticon49", "弱");
        aCh.put("image_emoticon50", "OK");
        aCh.put("image_emoticon61", "哼");
        aCh.put("image_emoticon62", "吃瓜");
        aCh.put("image_emoticon63", "扔便便");
        aCh.put("image_emoticon64", "惊恐");
        aCh.put("image_emoticon65", "哎呦");
        aCh.put("image_emoticon66", "小乖");
        aCh.put("image_emoticon67", "捂嘴笑");
        aCh.put("image_emoticon68", "你懂的");
        aCh.put("image_emoticon69", "what");
        aCh.put("image_emoticon70", "酸爽");
        aCh.put("image_emoticon71", "呀咩爹");
        aCh.put("image_emoticon72", "笑尿");
        aCh.put("image_emoticon73", "挖鼻");
        aCh.put("image_emoticon74", "犀利");
        aCh.put("image_emoticon75", "小红脸");
        aCh.put("image_emoticon76", "懒得理");
        aCh.put("image_emoticon77", "沙发");
        aCh.put("image_emoticon78", "手纸");
        aCh.put("image_emoticon79", "香蕉");
        aCh.put("image_emoticon80", "便便");
        aCh.put("image_emoticon81", "药丸");
        aCh.put("image_emoticon82", "红领巾");
        aCh.put("image_emoticon83", "蜡烛");
        aCh.put("image_emoticon84", "三道杠");
        aCh.put("ali_001", "赖皮");
        aCh.put("ali_002", "感动");
        aCh.put("ali_003", "十分惊讶");
        aCh.put("ali_004", "怒气");
        aCh.put("ali_005", "哭泣");
        aCh.put("ali_006", "吃惊");
        aCh.put("ali_007", "嘲弄");
        aCh.put("ali_008", "飘过");
        aCh.put("ali_009", "转圈哭");
        aCh.put("ali_010", "神经病");
        aCh.put("ali_011", "揪耳朵");
        aCh.put("ali_012", "惊汗");
        aCh.put("ali_013", "隐身");
        aCh.put("ali_014", "不要嘛");
        aCh.put("ali_015", "遁");
        aCh.put("ali_016", "不公平");
        aCh.put("ali_017", "爬来了");
        aCh.put("ali_018", "蛋花哭");
        aCh.put("ali_019", "温暖");
        aCh.put("ali_020", "点头");
        aCh.put("ali_021", "撒钱");
        aCh.put("ali_022", "献花");
        aCh.put("ali_023", "寒");
        aCh.put("ali_024", "傻笑");
        aCh.put("ali_025", "扭扭");
        aCh.put("ali_026", "疯");
        aCh.put("ali_027", "抓狂");
        aCh.put("ali_028", "抓");
        aCh.put("ali_029", "蜷");
        aCh.put("ali_030", "挠墙");
        aCh.put("ali_031", "狂笑");
        aCh.put("ali_032", "抱枕");
        aCh.put("ali_033", "吼叫");
        aCh.put("ali_034", "嚷");
        aCh.put("ali_035", "唠叨");
        aCh.put("ali_036", "捏脸");
        aCh.put("ali_037", "爆笑");
        aCh.put("ali_038", "郁闷");
        aCh.put("ali_039", "潜水");
        aCh.put("ali_040", "十分开心");
        aCh.put("ali_041", "冷笑话");
        aCh.put("ali_042", "顶！");
        aCh.put("ali_043", "潜");
        aCh.put("ali_044", "画圈圈");
        aCh.put("ali_045", "玩电脑");
        aCh.put("ali_046", "狂吐");
        aCh.put("ali_047", "哭着跑");
        aCh.put("ali_048", "阿狸侠");
        aCh.put("ali_049", "冷死了");
        aCh.put("ali_050", "惆怅~");
        aCh.put("ali_051", "摸头");
        aCh.put("ali_052", "蹭");
        aCh.put("ali_053", "打滚");
        aCh.put("ali_054", "叩拜");
        aCh.put("ali_055", "摸");
        aCh.put("ali_056", "数钱");
        aCh.put("ali_057", "拖走");
        aCh.put("ali_058", "热");
        aCh.put("ali_059", "加1");
        aCh.put("ali_060", "压力");
        aCh.put("ali_061", "表逼我");
        aCh.put("ali_062", "人呢");
        aCh.put("ali_063", "摇晃");
        aCh.put("ali_064", "打地鼠");
        aCh.put("ali_065", "这个屌");
        aCh.put("ali_066", "恐慌");
        aCh.put("ali_067", "晕乎乎");
        aCh.put("ali_068", "浮云");
        aCh.put("ali_069", "给力");
        aCh.put("ali_070", "杯具了");
        aCh.put("b01", "微笑");
        aCh.put("b02", "帅哥");
        aCh.put("b03", "美女");
        aCh.put("b04", "老大");
        aCh.put("b05", "哈哈哈");
        aCh.put("b06", "奸笑");
        aCh.put("b07", "傻乐");
        aCh.put("b08", "飞吻");
        aCh.put("b09", "害羞");
        aCh.put("b10", "花痴");
        aCh.put("b11", "憧憬");
        aCh.put("b12", "你牛");
        aCh.put("b13", "鼓掌");
        aCh.put("b14", "可爱");
        aCh.put("b15", "太委屈");
        aCh.put("b16", "大哭");
        aCh.put("b17", "泪奔");
        aCh.put("b18", "寻死");
        aCh.put("b19", "非常惊讶");
        aCh.put("b20", "表示疑问");
        aCh.put("yz_001", "焦糖舞");
        aCh.put("yz_002", "翻滚");
        aCh.put("yz_003", "拍屁股做鬼脸");
        aCh.put("yz_004", "不");
        aCh.put("yz_005", "河蟹掉啦");
        aCh.put("yz_006", "哦耶");
        aCh.put("yz_007", "我倒");
        aCh.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fG(String str) {
        Integer num = aCe.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fH(String str) {
        Integer num = aCg.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fI(String str) {
        return aCh.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Dg() {
        return aCf.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0058a S(Context context, String str) {
        return null;
    }
}
