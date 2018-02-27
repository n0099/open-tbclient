package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> btc = new HashMap<>(200);
    public static final ArrayList<Integer> btd = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> bte = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> btf = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        btf.put("image_emoticon", "呵呵");
        btf.put("image_emoticon2", "哈哈");
        btf.put("image_emoticon3", "吐舌");
        btf.put("image_emoticon4", "啊");
        btf.put("image_emoticon5", "酷");
        btf.put("image_emoticon6", "怒");
        btf.put("image_emoticon7", "开心");
        btf.put("image_emoticon8", "汗");
        btf.put("image_emoticon9", "泪");
        btf.put("image_emoticon10", "黑线");
        btf.put("image_emoticon11", "鄙视");
        btf.put("image_emoticon12", "不高兴");
        btf.put("image_emoticon13", "真棒");
        btf.put("image_emoticon14", "钱");
        btf.put("image_emoticon15", "疑问");
        btf.put("image_emoticon16", "阴险");
        btf.put("image_emoticon17", "吐");
        btf.put("image_emoticon18", "咦");
        btf.put("image_emoticon19", "委屈");
        btf.put("image_emoticon20", "花心");
        btf.put("image_emoticon21", "呼~");
        btf.put("image_emoticon22", "笑眼");
        btf.put("image_emoticon23", "冷");
        btf.put("image_emoticon24", "太开心");
        btf.put("image_emoticon25", "滑稽");
        btf.put("image_emoticon26", "勉强");
        btf.put("image_emoticon27", "狂汗");
        btf.put("image_emoticon28", "乖");
        btf.put("image_emoticon29", "睡觉");
        btf.put("image_emoticon30", "惊哭");
        btf.put("image_emoticon31", "生气");
        btf.put("image_emoticon32", "惊讶");
        btf.put("image_emoticon33", "喷");
        btf.put("image_emoticon34", "爱心");
        btf.put("image_emoticon35", "心碎");
        btf.put("image_emoticon36", "玫瑰");
        btf.put("image_emoticon37", "礼物");
        btf.put("image_emoticon38", "彩虹");
        btf.put("image_emoticon39", "星星月亮");
        btf.put("image_emoticon40", "太阳");
        btf.put("image_emoticon41", "钱币");
        btf.put("image_emoticon42", "灯泡");
        btf.put("image_emoticon43", "茶杯");
        btf.put("image_emoticon44", "蛋糕");
        btf.put("image_emoticon45", "音乐");
        btf.put("image_emoticon46", "haha");
        btf.put("image_emoticon47", "胜利");
        btf.put("image_emoticon48", "大拇指");
        btf.put("image_emoticon49", "弱");
        btf.put("image_emoticon50", "OK");
        btf.put("image_emoticon61", "哼");
        btf.put("image_emoticon62", "吃瓜");
        btf.put("image_emoticon63", "扔便便");
        btf.put("image_emoticon64", "惊恐");
        btf.put("image_emoticon65", "哎呦");
        btf.put("image_emoticon66", "小乖");
        btf.put("image_emoticon67", "捂嘴笑");
        btf.put("image_emoticon68", "你懂的");
        btf.put("image_emoticon69", "what");
        btf.put("image_emoticon70", "酸爽");
        btf.put("image_emoticon71", "呀咩爹");
        btf.put("image_emoticon72", "笑尿");
        btf.put("image_emoticon73", "挖鼻");
        btf.put("image_emoticon74", "犀利");
        btf.put("image_emoticon75", "小红脸");
        btf.put("image_emoticon76", "懒得理");
        btf.put("image_emoticon77", "沙发");
        btf.put("image_emoticon78", "手纸");
        btf.put("image_emoticon79", "香蕉");
        btf.put("image_emoticon80", "便便");
        btf.put("image_emoticon81", "药丸");
        btf.put("image_emoticon82", "红领巾");
        btf.put("image_emoticon83", "蜡烛");
        btf.put("image_emoticon84", "三道杠");
        btf.put("image_emoticon101", "不跟丑人说话");
        btf.put("image_emoticon102", "么么哒");
        btf.put("image_emoticon103", "亲亲才能起来");
        btf.put("image_emoticon104", "伦家只是宝宝");
        btf.put("image_emoticon105", "你是我的人");
        btf.put("image_emoticon106", "假装看不见");
        btf.put("image_emoticon107", "单身等撩");
        btf.put("image_emoticon108", "吓到宝宝了");
        btf.put("image_emoticon109", "哈哈哈");
        btf.put("image_emoticon110", "嗯嗯");
        btf.put("image_emoticon111", "好幸福");
        btf.put("image_emoticon112", "宝宝不开心");
        btf.put("image_emoticon113", "小姐姐别走");
        btf.put("image_emoticon114", "小姐姐在吗");
        btf.put("image_emoticon115", "小姐姐来啦");
        btf.put("image_emoticon116", "小姐姐来玩呀");
        btf.put("image_emoticon117", "我养你");
        btf.put("image_emoticon118", "我是不会骗你的");
        btf.put("image_emoticon119", "扎心了");
        btf.put("image_emoticon120", "无聊");
        btf.put("image_emoticon121", "月亮代表我的心");
        btf.put("image_emoticon122", "来追我呀");
        btf.put("image_emoticon123", "爱你的形状");
        btf.put("image_emoticon124", "白眼");
        btf.put("ali_001", "赖皮");
        btf.put("ali_002", "感动");
        btf.put("ali_003", "十分惊讶");
        btf.put("ali_004", "怒气");
        btf.put("ali_005", "哭泣");
        btf.put("ali_006", "吃惊");
        btf.put("ali_007", "嘲弄");
        btf.put("ali_008", "飘过");
        btf.put("ali_009", "转圈哭");
        btf.put("ali_010", "神经病");
        btf.put("ali_011", "揪耳朵");
        btf.put("ali_012", "惊汗");
        btf.put("ali_013", "隐身");
        btf.put("ali_014", "不要嘛");
        btf.put("ali_015", "遁");
        btf.put("ali_016", "不公平");
        btf.put("ali_017", "爬来了");
        btf.put("ali_018", "蛋花哭");
        btf.put("ali_019", "温暖");
        btf.put("ali_020", "点头");
        btf.put("ali_021", "撒钱");
        btf.put("ali_022", "献花");
        btf.put("ali_023", "寒");
        btf.put("ali_024", "傻笑");
        btf.put("ali_025", "扭扭");
        btf.put("ali_026", "疯");
        btf.put("ali_027", "抓狂");
        btf.put("ali_028", "抓");
        btf.put("ali_029", "蜷");
        btf.put("ali_030", "挠墙");
        btf.put("ali_031", "狂笑");
        btf.put("ali_032", "抱枕");
        btf.put("ali_033", "吼叫");
        btf.put("ali_034", "嚷");
        btf.put("ali_035", "唠叨");
        btf.put("ali_036", "捏脸");
        btf.put("ali_037", "爆笑");
        btf.put("ali_038", "郁闷");
        btf.put("ali_039", "潜水");
        btf.put("ali_040", "十分开心");
        btf.put("ali_041", "冷笑话");
        btf.put("ali_042", "顶！");
        btf.put("ali_043", "潜");
        btf.put("ali_044", "画圈圈");
        btf.put("ali_045", "玩电脑");
        btf.put("ali_046", "狂吐");
        btf.put("ali_047", "哭着跑");
        btf.put("ali_048", "阿狸侠");
        btf.put("ali_049", "冷死了");
        btf.put("ali_050", "惆怅~");
        btf.put("ali_051", "摸头");
        btf.put("ali_052", "蹭");
        btf.put("ali_053", "打滚");
        btf.put("ali_054", "叩拜");
        btf.put("ali_055", "摸");
        btf.put("ali_056", "数钱");
        btf.put("ali_057", "拖走");
        btf.put("ali_058", "热");
        btf.put("ali_059", "加1");
        btf.put("ali_060", "压力");
        btf.put("ali_061", "表逼我");
        btf.put("ali_062", "人呢");
        btf.put("ali_063", "摇晃");
        btf.put("ali_064", "打地鼠");
        btf.put("ali_065", "这个屌");
        btf.put("ali_066", "恐慌");
        btf.put("ali_067", "晕乎乎");
        btf.put("ali_068", "浮云");
        btf.put("ali_069", "给力");
        btf.put("ali_070", "杯具了");
        btf.put("b01", "微笑");
        btf.put("b02", "帅哥");
        btf.put("b03", "美女");
        btf.put("b04", "老大");
        btf.put("b05", "哈哈哈");
        btf.put("b06", "奸笑");
        btf.put("b07", "傻乐");
        btf.put("b08", "飞吻");
        btf.put("b09", "害羞");
        btf.put("b10", "花痴");
        btf.put("b11", "憧憬");
        btf.put("b12", "你牛");
        btf.put("b13", "鼓掌");
        btf.put("b14", "可爱");
        btf.put("b15", "太委屈");
        btf.put("b16", "大哭");
        btf.put("b17", "泪奔");
        btf.put("b18", "寻死");
        btf.put("b19", "非常惊讶");
        btf.put("b20", "表示疑问");
        btf.put("yz_001", "焦糖舞");
        btf.put("yz_002", "翻滚");
        btf.put("yz_003", "拍屁股做鬼脸");
        btf.put("yz_004", "不");
        btf.put("yz_005", "河蟹掉啦");
        btf.put("yz_006", "哦耶");
        btf.put("yz_007", "我倒");
        btf.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gk(String str) {
        Integer num = btc.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gl(String str) {
        Integer num = bte.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String gm(String str) {
        return btf.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Lo() {
        return btd.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0109a V(Context context, String str) {
        return null;
    }
}
