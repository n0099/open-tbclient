package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> crA = new HashMap<>(200);
    public static final ArrayList<Integer> crB = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> crC = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> crD = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        crD.put("image_emoticon", "呵呵");
        crD.put("image_emoticon2", "哈哈");
        crD.put("image_emoticon3", "吐舌");
        crD.put("image_emoticon4", "啊");
        crD.put("image_emoticon5", "酷");
        crD.put("image_emoticon6", "怒");
        crD.put("image_emoticon7", "开心");
        crD.put("image_emoticon8", "汗");
        crD.put("image_emoticon9", "泪");
        crD.put("image_emoticon10", "黑线");
        crD.put("image_emoticon11", "鄙视");
        crD.put("image_emoticon12", "不高兴");
        crD.put("image_emoticon13", "真棒");
        crD.put("image_emoticon14", "钱");
        crD.put("image_emoticon15", "疑问");
        crD.put("image_emoticon16", "阴险");
        crD.put("image_emoticon17", "吐");
        crD.put("image_emoticon18", "咦");
        crD.put("image_emoticon19", "委屈");
        crD.put("image_emoticon20", "花心");
        crD.put("image_emoticon21", "呼~");
        crD.put("image_emoticon22", "笑眼");
        crD.put("image_emoticon23", "冷");
        crD.put("image_emoticon24", "太开心");
        crD.put("image_emoticon25", "滑稽");
        crD.put("image_emoticon26", "勉强");
        crD.put("image_emoticon27", "狂汗");
        crD.put("image_emoticon28", "乖");
        crD.put("image_emoticon29", "睡觉");
        crD.put("image_emoticon30", "惊哭");
        crD.put("image_emoticon31", "生气");
        crD.put("image_emoticon32", "惊讶");
        crD.put("image_emoticon33", "喷");
        crD.put("image_emoticon34", "爱心");
        crD.put("image_emoticon35", "心碎");
        crD.put("image_emoticon36", "玫瑰");
        crD.put("image_emoticon37", "礼物");
        crD.put("image_emoticon38", "彩虹");
        crD.put("image_emoticon39", "星星月亮");
        crD.put("image_emoticon40", "太阳");
        crD.put("image_emoticon41", "钱币");
        crD.put("image_emoticon42", "灯泡");
        crD.put("image_emoticon43", "茶杯");
        crD.put("image_emoticon44", "蛋糕");
        crD.put("image_emoticon45", "音乐");
        crD.put("image_emoticon46", "haha");
        crD.put("image_emoticon47", "胜利");
        crD.put("image_emoticon48", "大拇指");
        crD.put("image_emoticon49", "弱");
        crD.put("image_emoticon50", "OK");
        crD.put("image_emoticon61", "哼");
        crD.put("image_emoticon62", "吃瓜");
        crD.put("image_emoticon63", "扔便便");
        crD.put("image_emoticon64", "惊恐");
        crD.put("image_emoticon65", "哎呦");
        crD.put("image_emoticon66", "小乖");
        crD.put("image_emoticon67", "捂嘴笑");
        crD.put("image_emoticon68", "你懂的");
        crD.put("image_emoticon69", "what");
        crD.put("image_emoticon70", "酸爽");
        crD.put("image_emoticon71", "呀咩爹");
        crD.put("image_emoticon72", "笑尿");
        crD.put("image_emoticon73", "挖鼻");
        crD.put("image_emoticon74", "犀利");
        crD.put("image_emoticon75", "小红脸");
        crD.put("image_emoticon76", "懒得理");
        crD.put("image_emoticon77", "沙发");
        crD.put("image_emoticon78", "手纸");
        crD.put("image_emoticon79", "香蕉");
        crD.put("image_emoticon80", "便便");
        crD.put("image_emoticon81", "药丸");
        crD.put("image_emoticon82", "红领巾");
        crD.put("image_emoticon83", "蜡烛");
        crD.put("image_emoticon84", "三道杠");
        crD.put("image_emoticon101", "不跟丑人说话");
        crD.put("image_emoticon102", "么么哒");
        crD.put("image_emoticon103", "亲亲才能起来");
        crD.put("image_emoticon104", "伦家只是宝宝");
        crD.put("image_emoticon105", "你是我的人");
        crD.put("image_emoticon106", "假装看不见");
        crD.put("image_emoticon107", "单身等撩");
        crD.put("image_emoticon108", "吓到宝宝了");
        crD.put("image_emoticon109", "哈哈哈");
        crD.put("image_emoticon110", "嗯嗯");
        crD.put("image_emoticon111", "好幸福");
        crD.put("image_emoticon112", "宝宝不开心");
        crD.put("image_emoticon113", "小姐姐别走");
        crD.put("image_emoticon114", "小姐姐在吗");
        crD.put("image_emoticon115", "小姐姐来啦");
        crD.put("image_emoticon116", "小姐姐来玩呀");
        crD.put("image_emoticon117", "我养你");
        crD.put("image_emoticon118", "我是不会骗你的");
        crD.put("image_emoticon119", "扎心了");
        crD.put("image_emoticon120", "无聊");
        crD.put("image_emoticon121", "月亮代表我的心");
        crD.put("image_emoticon122", "来追我呀");
        crD.put("image_emoticon123", "爱你的形状");
        crD.put("image_emoticon124", "白眼");
        crD.put("ali_001", "赖皮");
        crD.put("ali_002", "感动");
        crD.put("ali_003", "十分惊讶");
        crD.put("ali_004", "怒气");
        crD.put("ali_005", "哭泣");
        crD.put("ali_006", "吃惊");
        crD.put("ali_007", "嘲弄");
        crD.put("ali_008", "飘过");
        crD.put("ali_009", "转圈哭");
        crD.put("ali_010", "神经病");
        crD.put("ali_011", "揪耳朵");
        crD.put("ali_012", "惊汗");
        crD.put("ali_013", "隐身");
        crD.put("ali_014", "不要嘛");
        crD.put("ali_015", "遁");
        crD.put("ali_016", "不公平");
        crD.put("ali_017", "爬来了");
        crD.put("ali_018", "蛋花哭");
        crD.put("ali_019", "温暖");
        crD.put("ali_020", "点头");
        crD.put("ali_021", "撒钱");
        crD.put("ali_022", "献花");
        crD.put("ali_023", "寒");
        crD.put("ali_024", "傻笑");
        crD.put("ali_025", "扭扭");
        crD.put("ali_026", "疯");
        crD.put("ali_027", "抓狂");
        crD.put("ali_028", "抓");
        crD.put("ali_029", "蜷");
        crD.put("ali_030", "挠墙");
        crD.put("ali_031", "狂笑");
        crD.put("ali_032", "抱枕");
        crD.put("ali_033", "吼叫");
        crD.put("ali_034", "嚷");
        crD.put("ali_035", "唠叨");
        crD.put("ali_036", "捏脸");
        crD.put("ali_037", "爆笑");
        crD.put("ali_038", "郁闷");
        crD.put("ali_039", "潜水");
        crD.put("ali_040", "十分开心");
        crD.put("ali_041", "冷笑话");
        crD.put("ali_042", "顶！");
        crD.put("ali_043", "潜");
        crD.put("ali_044", "画圈圈");
        crD.put("ali_045", "玩电脑");
        crD.put("ali_046", "狂吐");
        crD.put("ali_047", "哭着跑");
        crD.put("ali_048", "阿狸侠");
        crD.put("ali_049", "冷死了");
        crD.put("ali_050", "惆怅~");
        crD.put("ali_051", "摸头");
        crD.put("ali_052", "蹭");
        crD.put("ali_053", "打滚");
        crD.put("ali_054", "叩拜");
        crD.put("ali_055", "摸");
        crD.put("ali_056", "数钱");
        crD.put("ali_057", "拖走");
        crD.put("ali_058", "热");
        crD.put("ali_059", "加1");
        crD.put("ali_060", "压力");
        crD.put("ali_061", "表逼我");
        crD.put("ali_062", "人呢");
        crD.put("ali_063", "摇晃");
        crD.put("ali_064", "打地鼠");
        crD.put("ali_065", "这个屌");
        crD.put("ali_066", "恐慌");
        crD.put("ali_067", "晕乎乎");
        crD.put("ali_068", "浮云");
        crD.put("ali_069", "给力");
        crD.put("ali_070", "杯具了");
        crD.put("b01", "微笑");
        crD.put("b02", "帅哥");
        crD.put("b03", "美女");
        crD.put("b04", "老大");
        crD.put("b05", "哈哈哈");
        crD.put("b06", "奸笑");
        crD.put("b07", "傻乐");
        crD.put("b08", "飞吻");
        crD.put("b09", "害羞");
        crD.put("b10", "花痴");
        crD.put("b11", "憧憬");
        crD.put("b12", "你牛");
        crD.put("b13", "鼓掌");
        crD.put("b14", "可爱");
        crD.put("b15", "太委屈");
        crD.put("b16", "大哭");
        crD.put("b17", "泪奔");
        crD.put("b18", "寻死");
        crD.put("b19", "非常惊讶");
        crD.put("b20", "表示疑问");
        crD.put("yz_001", "焦糖舞");
        crD.put("yz_002", "翻滚");
        crD.put("yz_003", "拍屁股做鬼脸");
        crD.put("yz_004", "不");
        crD.put("yz_005", "河蟹掉啦");
        crD.put("yz_006", "哦耶");
        crD.put("yz_007", "我倒");
        crD.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int pO(String str) {
        Integer num = crA.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf((int) R.drawable.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int pP(String str) {
        Integer num = crC.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String pQ(String str) {
        return crD.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int arg() {
        return crB.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0253a ak(Context context, String str) {
        return null;
    }
}
