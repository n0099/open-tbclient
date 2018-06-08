package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aMc = new HashMap<>(200);
    public static final ArrayList<Integer> aMd = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aMe = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aMf = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aMf.put("image_emoticon", "呵呵");
        aMf.put("image_emoticon2", "哈哈");
        aMf.put("image_emoticon3", "吐舌");
        aMf.put("image_emoticon4", "啊");
        aMf.put("image_emoticon5", "酷");
        aMf.put("image_emoticon6", "怒");
        aMf.put("image_emoticon7", "开心");
        aMf.put("image_emoticon8", "汗");
        aMf.put("image_emoticon9", "泪");
        aMf.put("image_emoticon10", "黑线");
        aMf.put("image_emoticon11", "鄙视");
        aMf.put("image_emoticon12", "不高兴");
        aMf.put("image_emoticon13", "真棒");
        aMf.put("image_emoticon14", "钱");
        aMf.put("image_emoticon15", "疑问");
        aMf.put("image_emoticon16", "阴险");
        aMf.put("image_emoticon17", "吐");
        aMf.put("image_emoticon18", "咦");
        aMf.put("image_emoticon19", "委屈");
        aMf.put("image_emoticon20", "花心");
        aMf.put("image_emoticon21", "呼~");
        aMf.put("image_emoticon22", "笑眼");
        aMf.put("image_emoticon23", "冷");
        aMf.put("image_emoticon24", "太开心");
        aMf.put("image_emoticon25", "滑稽");
        aMf.put("image_emoticon26", "勉强");
        aMf.put("image_emoticon27", "狂汗");
        aMf.put("image_emoticon28", "乖");
        aMf.put("image_emoticon29", "睡觉");
        aMf.put("image_emoticon30", "惊哭");
        aMf.put("image_emoticon31", "生气");
        aMf.put("image_emoticon32", "惊讶");
        aMf.put("image_emoticon33", "喷");
        aMf.put("image_emoticon34", "爱心");
        aMf.put("image_emoticon35", "心碎");
        aMf.put("image_emoticon36", "玫瑰");
        aMf.put("image_emoticon37", "礼物");
        aMf.put("image_emoticon38", "彩虹");
        aMf.put("image_emoticon39", "星星月亮");
        aMf.put("image_emoticon40", "太阳");
        aMf.put("image_emoticon41", "钱币");
        aMf.put("image_emoticon42", "灯泡");
        aMf.put("image_emoticon43", "茶杯");
        aMf.put("image_emoticon44", "蛋糕");
        aMf.put("image_emoticon45", "音乐");
        aMf.put("image_emoticon46", "haha");
        aMf.put("image_emoticon47", "胜利");
        aMf.put("image_emoticon48", "大拇指");
        aMf.put("image_emoticon49", "弱");
        aMf.put("image_emoticon50", "OK");
        aMf.put("image_emoticon61", "哼");
        aMf.put("image_emoticon62", "吃瓜");
        aMf.put("image_emoticon63", "扔便便");
        aMf.put("image_emoticon64", "惊恐");
        aMf.put("image_emoticon65", "哎呦");
        aMf.put("image_emoticon66", "小乖");
        aMf.put("image_emoticon67", "捂嘴笑");
        aMf.put("image_emoticon68", "你懂的");
        aMf.put("image_emoticon69", "what");
        aMf.put("image_emoticon70", "酸爽");
        aMf.put("image_emoticon71", "呀咩爹");
        aMf.put("image_emoticon72", "笑尿");
        aMf.put("image_emoticon73", "挖鼻");
        aMf.put("image_emoticon74", "犀利");
        aMf.put("image_emoticon75", "小红脸");
        aMf.put("image_emoticon76", "懒得理");
        aMf.put("image_emoticon77", "沙发");
        aMf.put("image_emoticon78", "手纸");
        aMf.put("image_emoticon79", "香蕉");
        aMf.put("image_emoticon80", "便便");
        aMf.put("image_emoticon81", "药丸");
        aMf.put("image_emoticon82", "红领巾");
        aMf.put("image_emoticon83", "蜡烛");
        aMf.put("image_emoticon84", "三道杠");
        aMf.put("image_emoticon101", "不跟丑人说话");
        aMf.put("image_emoticon102", "么么哒");
        aMf.put("image_emoticon103", "亲亲才能起来");
        aMf.put("image_emoticon104", "伦家只是宝宝");
        aMf.put("image_emoticon105", "你是我的人");
        aMf.put("image_emoticon106", "假装看不见");
        aMf.put("image_emoticon107", "单身等撩");
        aMf.put("image_emoticon108", "吓到宝宝了");
        aMf.put("image_emoticon109", "哈哈哈");
        aMf.put("image_emoticon110", "嗯嗯");
        aMf.put("image_emoticon111", "好幸福");
        aMf.put("image_emoticon112", "宝宝不开心");
        aMf.put("image_emoticon113", "小姐姐别走");
        aMf.put("image_emoticon114", "小姐姐在吗");
        aMf.put("image_emoticon115", "小姐姐来啦");
        aMf.put("image_emoticon116", "小姐姐来玩呀");
        aMf.put("image_emoticon117", "我养你");
        aMf.put("image_emoticon118", "我是不会骗你的");
        aMf.put("image_emoticon119", "扎心了");
        aMf.put("image_emoticon120", "无聊");
        aMf.put("image_emoticon121", "月亮代表我的心");
        aMf.put("image_emoticon122", "来追我呀");
        aMf.put("image_emoticon123", "爱你的形状");
        aMf.put("image_emoticon124", "白眼");
        aMf.put("ali_001", "赖皮");
        aMf.put("ali_002", "感动");
        aMf.put("ali_003", "十分惊讶");
        aMf.put("ali_004", "怒气");
        aMf.put("ali_005", "哭泣");
        aMf.put("ali_006", "吃惊");
        aMf.put("ali_007", "嘲弄");
        aMf.put("ali_008", "飘过");
        aMf.put("ali_009", "转圈哭");
        aMf.put("ali_010", "神经病");
        aMf.put("ali_011", "揪耳朵");
        aMf.put("ali_012", "惊汗");
        aMf.put("ali_013", "隐身");
        aMf.put("ali_014", "不要嘛");
        aMf.put("ali_015", "遁");
        aMf.put("ali_016", "不公平");
        aMf.put("ali_017", "爬来了");
        aMf.put("ali_018", "蛋花哭");
        aMf.put("ali_019", "温暖");
        aMf.put("ali_020", "点头");
        aMf.put("ali_021", "撒钱");
        aMf.put("ali_022", "献花");
        aMf.put("ali_023", "寒");
        aMf.put("ali_024", "傻笑");
        aMf.put("ali_025", "扭扭");
        aMf.put("ali_026", "疯");
        aMf.put("ali_027", "抓狂");
        aMf.put("ali_028", "抓");
        aMf.put("ali_029", "蜷");
        aMf.put("ali_030", "挠墙");
        aMf.put("ali_031", "狂笑");
        aMf.put("ali_032", "抱枕");
        aMf.put("ali_033", "吼叫");
        aMf.put("ali_034", "嚷");
        aMf.put("ali_035", "唠叨");
        aMf.put("ali_036", "捏脸");
        aMf.put("ali_037", "爆笑");
        aMf.put("ali_038", "郁闷");
        aMf.put("ali_039", "潜水");
        aMf.put("ali_040", "十分开心");
        aMf.put("ali_041", "冷笑话");
        aMf.put("ali_042", "顶！");
        aMf.put("ali_043", "潜");
        aMf.put("ali_044", "画圈圈");
        aMf.put("ali_045", "玩电脑");
        aMf.put("ali_046", "狂吐");
        aMf.put("ali_047", "哭着跑");
        aMf.put("ali_048", "阿狸侠");
        aMf.put("ali_049", "冷死了");
        aMf.put("ali_050", "惆怅~");
        aMf.put("ali_051", "摸头");
        aMf.put("ali_052", "蹭");
        aMf.put("ali_053", "打滚");
        aMf.put("ali_054", "叩拜");
        aMf.put("ali_055", "摸");
        aMf.put("ali_056", "数钱");
        aMf.put("ali_057", "拖走");
        aMf.put("ali_058", "热");
        aMf.put("ali_059", "加1");
        aMf.put("ali_060", "压力");
        aMf.put("ali_061", "表逼我");
        aMf.put("ali_062", "人呢");
        aMf.put("ali_063", "摇晃");
        aMf.put("ali_064", "打地鼠");
        aMf.put("ali_065", "这个屌");
        aMf.put("ali_066", "恐慌");
        aMf.put("ali_067", "晕乎乎");
        aMf.put("ali_068", "浮云");
        aMf.put("ali_069", "给力");
        aMf.put("ali_070", "杯具了");
        aMf.put("b01", "微笑");
        aMf.put("b02", "帅哥");
        aMf.put("b03", "美女");
        aMf.put("b04", "老大");
        aMf.put("b05", "哈哈哈");
        aMf.put("b06", "奸笑");
        aMf.put("b07", "傻乐");
        aMf.put("b08", "飞吻");
        aMf.put("b09", "害羞");
        aMf.put("b10", "花痴");
        aMf.put("b11", "憧憬");
        aMf.put("b12", "你牛");
        aMf.put("b13", "鼓掌");
        aMf.put("b14", "可爱");
        aMf.put("b15", "太委屈");
        aMf.put("b16", "大哭");
        aMf.put("b17", "泪奔");
        aMf.put("b18", "寻死");
        aMf.put("b19", "非常惊讶");
        aMf.put("b20", "表示疑问");
        aMf.put("yz_001", "焦糖舞");
        aMf.put("yz_002", "翻滚");
        aMf.put("yz_003", "拍屁股做鬼脸");
        aMf.put("yz_004", "不");
        aMf.put("yz_005", "河蟹掉啦");
        aMf.put("yz_006", "哦耶");
        aMf.put("yz_007", "我倒");
        aMf.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gA(String str) {
        Integer num = aMc.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gB(String str) {
        Integer num = aMe.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String gC(String str) {
        return aMf.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Ht() {
        return aMd.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0115a T(Context context, String str) {
        return null;
    }
}
