package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aDG = new HashMap<>(200);
    public static final ArrayList<Integer> aDH = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aDI = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aDJ = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aDJ.put("image_emoticon", "呵呵");
        aDJ.put("image_emoticon2", "哈哈");
        aDJ.put("image_emoticon3", "吐舌");
        aDJ.put("image_emoticon4", "啊");
        aDJ.put("image_emoticon5", "酷");
        aDJ.put("image_emoticon6", "怒");
        aDJ.put("image_emoticon7", "开心");
        aDJ.put("image_emoticon8", "汗");
        aDJ.put("image_emoticon9", "泪");
        aDJ.put("image_emoticon10", "黑线");
        aDJ.put("image_emoticon11", "鄙视");
        aDJ.put("image_emoticon12", "不高兴");
        aDJ.put("image_emoticon13", "真棒");
        aDJ.put("image_emoticon14", "钱");
        aDJ.put("image_emoticon15", "疑问");
        aDJ.put("image_emoticon16", "阴险");
        aDJ.put("image_emoticon17", "吐");
        aDJ.put("image_emoticon18", "咦");
        aDJ.put("image_emoticon19", "委屈");
        aDJ.put("image_emoticon20", "花心");
        aDJ.put("image_emoticon21", "呼~");
        aDJ.put("image_emoticon22", "笑眼");
        aDJ.put("image_emoticon23", "冷");
        aDJ.put("image_emoticon24", "太开心");
        aDJ.put("image_emoticon25", "滑稽");
        aDJ.put("image_emoticon26", "勉强");
        aDJ.put("image_emoticon27", "狂汗");
        aDJ.put("image_emoticon28", "乖");
        aDJ.put("image_emoticon29", "睡觉");
        aDJ.put("image_emoticon30", "惊哭");
        aDJ.put("image_emoticon31", "生气");
        aDJ.put("image_emoticon32", "惊讶");
        aDJ.put("image_emoticon33", "喷");
        aDJ.put("image_emoticon34", "爱心");
        aDJ.put("image_emoticon35", "心碎");
        aDJ.put("image_emoticon36", "玫瑰");
        aDJ.put("image_emoticon37", "礼物");
        aDJ.put("image_emoticon38", "彩虹");
        aDJ.put("image_emoticon39", "星星月亮");
        aDJ.put("image_emoticon40", "太阳");
        aDJ.put("image_emoticon41", "钱币");
        aDJ.put("image_emoticon42", "灯泡");
        aDJ.put("image_emoticon43", "茶杯");
        aDJ.put("image_emoticon44", "蛋糕");
        aDJ.put("image_emoticon45", "音乐");
        aDJ.put("image_emoticon46", "haha");
        aDJ.put("image_emoticon47", "胜利");
        aDJ.put("image_emoticon48", "大拇指");
        aDJ.put("image_emoticon49", "弱");
        aDJ.put("image_emoticon50", "OK");
        aDJ.put("image_emoticon61", "哼");
        aDJ.put("image_emoticon62", "吃瓜");
        aDJ.put("image_emoticon63", "扔便便");
        aDJ.put("image_emoticon64", "惊恐");
        aDJ.put("image_emoticon65", "哎呦");
        aDJ.put("image_emoticon66", "小乖");
        aDJ.put("image_emoticon67", "捂嘴笑");
        aDJ.put("image_emoticon68", "你懂的");
        aDJ.put("image_emoticon69", "what");
        aDJ.put("image_emoticon70", "酸爽");
        aDJ.put("image_emoticon71", "呀咩爹");
        aDJ.put("image_emoticon72", "笑尿");
        aDJ.put("image_emoticon73", "挖鼻");
        aDJ.put("image_emoticon74", "犀利");
        aDJ.put("image_emoticon75", "小红脸");
        aDJ.put("image_emoticon76", "懒得理");
        aDJ.put("image_emoticon77", "沙发");
        aDJ.put("image_emoticon78", "手纸");
        aDJ.put("image_emoticon79", "香蕉");
        aDJ.put("image_emoticon80", "便便");
        aDJ.put("image_emoticon81", "药丸");
        aDJ.put("image_emoticon82", "红领巾");
        aDJ.put("image_emoticon83", "蜡烛");
        aDJ.put("image_emoticon84", "三道杠");
        aDJ.put("image_emoticon101", "不跟丑人说话");
        aDJ.put("image_emoticon102", "么么哒");
        aDJ.put("image_emoticon103", "亲亲才能起来");
        aDJ.put("image_emoticon104", "伦家只是宝宝");
        aDJ.put("image_emoticon105", "你是我的人");
        aDJ.put("image_emoticon106", "假装看不见");
        aDJ.put("image_emoticon107", "单身等撩");
        aDJ.put("image_emoticon108", "吓到宝宝了");
        aDJ.put("image_emoticon109", "哈哈哈");
        aDJ.put("image_emoticon110", "嗯嗯");
        aDJ.put("image_emoticon111", "好幸福");
        aDJ.put("image_emoticon112", "宝宝不开心");
        aDJ.put("image_emoticon113", "小姐姐别走");
        aDJ.put("image_emoticon114", "小姐姐在吗");
        aDJ.put("image_emoticon115", "小姐姐来啦");
        aDJ.put("image_emoticon116", "小姐姐来玩呀");
        aDJ.put("image_emoticon117", "我养你");
        aDJ.put("image_emoticon118", "我是不会骗你的");
        aDJ.put("image_emoticon119", "扎心了");
        aDJ.put("image_emoticon120", "无聊");
        aDJ.put("image_emoticon121", "月亮代表我的心");
        aDJ.put("image_emoticon122", "来追我呀");
        aDJ.put("image_emoticon123", "爱你的形状");
        aDJ.put("image_emoticon124", "白眼");
        aDJ.put("ali_001", "赖皮");
        aDJ.put("ali_002", "感动");
        aDJ.put("ali_003", "十分惊讶");
        aDJ.put("ali_004", "怒气");
        aDJ.put("ali_005", "哭泣");
        aDJ.put("ali_006", "吃惊");
        aDJ.put("ali_007", "嘲弄");
        aDJ.put("ali_008", "飘过");
        aDJ.put("ali_009", "转圈哭");
        aDJ.put("ali_010", "神经病");
        aDJ.put("ali_011", "揪耳朵");
        aDJ.put("ali_012", "惊汗");
        aDJ.put("ali_013", "隐身");
        aDJ.put("ali_014", "不要嘛");
        aDJ.put("ali_015", "遁");
        aDJ.put("ali_016", "不公平");
        aDJ.put("ali_017", "爬来了");
        aDJ.put("ali_018", "蛋花哭");
        aDJ.put("ali_019", "温暖");
        aDJ.put("ali_020", "点头");
        aDJ.put("ali_021", "撒钱");
        aDJ.put("ali_022", "献花");
        aDJ.put("ali_023", "寒");
        aDJ.put("ali_024", "傻笑");
        aDJ.put("ali_025", "扭扭");
        aDJ.put("ali_026", "疯");
        aDJ.put("ali_027", "抓狂");
        aDJ.put("ali_028", "抓");
        aDJ.put("ali_029", "蜷");
        aDJ.put("ali_030", "挠墙");
        aDJ.put("ali_031", "狂笑");
        aDJ.put("ali_032", "抱枕");
        aDJ.put("ali_033", "吼叫");
        aDJ.put("ali_034", "嚷");
        aDJ.put("ali_035", "唠叨");
        aDJ.put("ali_036", "捏脸");
        aDJ.put("ali_037", "爆笑");
        aDJ.put("ali_038", "郁闷");
        aDJ.put("ali_039", "潜水");
        aDJ.put("ali_040", "十分开心");
        aDJ.put("ali_041", "冷笑话");
        aDJ.put("ali_042", "顶！");
        aDJ.put("ali_043", "潜");
        aDJ.put("ali_044", "画圈圈");
        aDJ.put("ali_045", "玩电脑");
        aDJ.put("ali_046", "狂吐");
        aDJ.put("ali_047", "哭着跑");
        aDJ.put("ali_048", "阿狸侠");
        aDJ.put("ali_049", "冷死了");
        aDJ.put("ali_050", "惆怅~");
        aDJ.put("ali_051", "摸头");
        aDJ.put("ali_052", "蹭");
        aDJ.put("ali_053", "打滚");
        aDJ.put("ali_054", "叩拜");
        aDJ.put("ali_055", "摸");
        aDJ.put("ali_056", "数钱");
        aDJ.put("ali_057", "拖走");
        aDJ.put("ali_058", "热");
        aDJ.put("ali_059", "加1");
        aDJ.put("ali_060", "压力");
        aDJ.put("ali_061", "表逼我");
        aDJ.put("ali_062", "人呢");
        aDJ.put("ali_063", "摇晃");
        aDJ.put("ali_064", "打地鼠");
        aDJ.put("ali_065", "这个屌");
        aDJ.put("ali_066", "恐慌");
        aDJ.put("ali_067", "晕乎乎");
        aDJ.put("ali_068", "浮云");
        aDJ.put("ali_069", "给力");
        aDJ.put("ali_070", "杯具了");
        aDJ.put("b01", "微笑");
        aDJ.put("b02", "帅哥");
        aDJ.put("b03", "美女");
        aDJ.put("b04", "老大");
        aDJ.put("b05", "哈哈哈");
        aDJ.put("b06", "奸笑");
        aDJ.put("b07", "傻乐");
        aDJ.put("b08", "飞吻");
        aDJ.put("b09", "害羞");
        aDJ.put("b10", "花痴");
        aDJ.put("b11", "憧憬");
        aDJ.put("b12", "你牛");
        aDJ.put("b13", "鼓掌");
        aDJ.put("b14", "可爱");
        aDJ.put("b15", "太委屈");
        aDJ.put("b16", "大哭");
        aDJ.put("b17", "泪奔");
        aDJ.put("b18", "寻死");
        aDJ.put("b19", "非常惊讶");
        aDJ.put("b20", "表示疑问");
        aDJ.put("yz_001", "焦糖舞");
        aDJ.put("yz_002", "翻滚");
        aDJ.put("yz_003", "拍屁股做鬼脸");
        aDJ.put("yz_004", "不");
        aDJ.put("yz_005", "河蟹掉啦");
        aDJ.put("yz_006", "哦耶");
        aDJ.put("yz_007", "我倒");
        aDJ.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gb(String str) {
        Integer num = aDG.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gc(String str) {
        Integer num = aDI.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String gd(String str) {
        return aDJ.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int DQ() {
        return aDH.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0098a Q(Context context, String str) {
        return null;
    }
}
