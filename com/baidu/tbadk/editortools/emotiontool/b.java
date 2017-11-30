package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aCH = new HashMap<>(200);
    public static final ArrayList<Integer> aCI = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aCJ = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aCK = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aCK.put("image_emoticon", "呵呵");
        aCK.put("image_emoticon2", "哈哈");
        aCK.put("image_emoticon3", "吐舌");
        aCK.put("image_emoticon4", "啊");
        aCK.put("image_emoticon5", "酷");
        aCK.put("image_emoticon6", "怒");
        aCK.put("image_emoticon7", "开心");
        aCK.put("image_emoticon8", "汗");
        aCK.put("image_emoticon9", "泪");
        aCK.put("image_emoticon10", "黑线");
        aCK.put("image_emoticon11", "鄙视");
        aCK.put("image_emoticon12", "不高兴");
        aCK.put("image_emoticon13", "真棒");
        aCK.put("image_emoticon14", "钱");
        aCK.put("image_emoticon15", "疑问");
        aCK.put("image_emoticon16", "阴险");
        aCK.put("image_emoticon17", "吐");
        aCK.put("image_emoticon18", "咦");
        aCK.put("image_emoticon19", "委屈");
        aCK.put("image_emoticon20", "花心");
        aCK.put("image_emoticon21", "呼~");
        aCK.put("image_emoticon22", "笑眼");
        aCK.put("image_emoticon23", "冷");
        aCK.put("image_emoticon24", "太开心");
        aCK.put("image_emoticon25", "滑稽");
        aCK.put("image_emoticon26", "勉强");
        aCK.put("image_emoticon27", "狂汗");
        aCK.put("image_emoticon28", "乖");
        aCK.put("image_emoticon29", "睡觉");
        aCK.put("image_emoticon30", "惊哭");
        aCK.put("image_emoticon31", "生气");
        aCK.put("image_emoticon32", "惊讶");
        aCK.put("image_emoticon33", "喷");
        aCK.put("image_emoticon34", "爱心");
        aCK.put("image_emoticon35", "心碎");
        aCK.put("image_emoticon36", "玫瑰");
        aCK.put("image_emoticon37", "礼物");
        aCK.put("image_emoticon38", "彩虹");
        aCK.put("image_emoticon39", "星星月亮");
        aCK.put("image_emoticon40", "太阳");
        aCK.put("image_emoticon41", "钱币");
        aCK.put("image_emoticon42", "灯泡");
        aCK.put("image_emoticon43", "茶杯");
        aCK.put("image_emoticon44", "蛋糕");
        aCK.put("image_emoticon45", "音乐");
        aCK.put("image_emoticon46", "haha");
        aCK.put("image_emoticon47", "胜利");
        aCK.put("image_emoticon48", "大拇指");
        aCK.put("image_emoticon49", "弱");
        aCK.put("image_emoticon50", "OK");
        aCK.put("image_emoticon61", "哼");
        aCK.put("image_emoticon62", "吃瓜");
        aCK.put("image_emoticon63", "扔便便");
        aCK.put("image_emoticon64", "惊恐");
        aCK.put("image_emoticon65", "哎呦");
        aCK.put("image_emoticon66", "小乖");
        aCK.put("image_emoticon67", "捂嘴笑");
        aCK.put("image_emoticon68", "你懂的");
        aCK.put("image_emoticon69", "what");
        aCK.put("image_emoticon70", "酸爽");
        aCK.put("image_emoticon71", "呀咩爹");
        aCK.put("image_emoticon72", "笑尿");
        aCK.put("image_emoticon73", "挖鼻");
        aCK.put("image_emoticon74", "犀利");
        aCK.put("image_emoticon75", "小红脸");
        aCK.put("image_emoticon76", "懒得理");
        aCK.put("image_emoticon77", "沙发");
        aCK.put("image_emoticon78", "手纸");
        aCK.put("image_emoticon79", "香蕉");
        aCK.put("image_emoticon80", "便便");
        aCK.put("image_emoticon81", "药丸");
        aCK.put("image_emoticon82", "红领巾");
        aCK.put("image_emoticon83", "蜡烛");
        aCK.put("image_emoticon84", "三道杠");
        aCK.put("ali_001", "赖皮");
        aCK.put("ali_002", "感动");
        aCK.put("ali_003", "十分惊讶");
        aCK.put("ali_004", "怒气");
        aCK.put("ali_005", "哭泣");
        aCK.put("ali_006", "吃惊");
        aCK.put("ali_007", "嘲弄");
        aCK.put("ali_008", "飘过");
        aCK.put("ali_009", "转圈哭");
        aCK.put("ali_010", "神经病");
        aCK.put("ali_011", "揪耳朵");
        aCK.put("ali_012", "惊汗");
        aCK.put("ali_013", "隐身");
        aCK.put("ali_014", "不要嘛");
        aCK.put("ali_015", "遁");
        aCK.put("ali_016", "不公平");
        aCK.put("ali_017", "爬来了");
        aCK.put("ali_018", "蛋花哭");
        aCK.put("ali_019", "温暖");
        aCK.put("ali_020", "点头");
        aCK.put("ali_021", "撒钱");
        aCK.put("ali_022", "献花");
        aCK.put("ali_023", "寒");
        aCK.put("ali_024", "傻笑");
        aCK.put("ali_025", "扭扭");
        aCK.put("ali_026", "疯");
        aCK.put("ali_027", "抓狂");
        aCK.put("ali_028", "抓");
        aCK.put("ali_029", "蜷");
        aCK.put("ali_030", "挠墙");
        aCK.put("ali_031", "狂笑");
        aCK.put("ali_032", "抱枕");
        aCK.put("ali_033", "吼叫");
        aCK.put("ali_034", "嚷");
        aCK.put("ali_035", "唠叨");
        aCK.put("ali_036", "捏脸");
        aCK.put("ali_037", "爆笑");
        aCK.put("ali_038", "郁闷");
        aCK.put("ali_039", "潜水");
        aCK.put("ali_040", "十分开心");
        aCK.put("ali_041", "冷笑话");
        aCK.put("ali_042", "顶！");
        aCK.put("ali_043", "潜");
        aCK.put("ali_044", "画圈圈");
        aCK.put("ali_045", "玩电脑");
        aCK.put("ali_046", "狂吐");
        aCK.put("ali_047", "哭着跑");
        aCK.put("ali_048", "阿狸侠");
        aCK.put("ali_049", "冷死了");
        aCK.put("ali_050", "惆怅~");
        aCK.put("ali_051", "摸头");
        aCK.put("ali_052", "蹭");
        aCK.put("ali_053", "打滚");
        aCK.put("ali_054", "叩拜");
        aCK.put("ali_055", "摸");
        aCK.put("ali_056", "数钱");
        aCK.put("ali_057", "拖走");
        aCK.put("ali_058", "热");
        aCK.put("ali_059", "加1");
        aCK.put("ali_060", "压力");
        aCK.put("ali_061", "表逼我");
        aCK.put("ali_062", "人呢");
        aCK.put("ali_063", "摇晃");
        aCK.put("ali_064", "打地鼠");
        aCK.put("ali_065", "这个屌");
        aCK.put("ali_066", "恐慌");
        aCK.put("ali_067", "晕乎乎");
        aCK.put("ali_068", "浮云");
        aCK.put("ali_069", "给力");
        aCK.put("ali_070", "杯具了");
        aCK.put("b01", "微笑");
        aCK.put("b02", "帅哥");
        aCK.put("b03", "美女");
        aCK.put("b04", "老大");
        aCK.put("b05", "哈哈哈");
        aCK.put("b06", "奸笑");
        aCK.put("b07", "傻乐");
        aCK.put("b08", "飞吻");
        aCK.put("b09", "害羞");
        aCK.put("b10", "花痴");
        aCK.put("b11", "憧憬");
        aCK.put("b12", "你牛");
        aCK.put("b13", "鼓掌");
        aCK.put("b14", "可爱");
        aCK.put("b15", "太委屈");
        aCK.put("b16", "大哭");
        aCK.put("b17", "泪奔");
        aCK.put("b18", "寻死");
        aCK.put("b19", "非常惊讶");
        aCK.put("b20", "表示疑问");
        aCK.put("yz_001", "焦糖舞");
        aCK.put("yz_002", "翻滚");
        aCK.put("yz_003", "拍屁股做鬼脸");
        aCK.put("yz_004", "不");
        aCK.put("yz_005", "河蟹掉啦");
        aCK.put("yz_006", "哦耶");
        aCK.put("yz_007", "我倒");
        aCK.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fM(String str) {
        Integer num = aCH.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fN(String str) {
        Integer num = aCJ.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fO(String str) {
        return aCK.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Dq() {
        return aCI.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0058a T(Context context, String str) {
        return null;
    }
}
