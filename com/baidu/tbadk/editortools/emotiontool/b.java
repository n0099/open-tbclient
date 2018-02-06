package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> btq = new HashMap<>(200);
    public static final ArrayList<Integer> btr = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> bts = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> btt = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        btt.put("image_emoticon", "呵呵");
        btt.put("image_emoticon2", "哈哈");
        btt.put("image_emoticon3", "吐舌");
        btt.put("image_emoticon4", "啊");
        btt.put("image_emoticon5", "酷");
        btt.put("image_emoticon6", "怒");
        btt.put("image_emoticon7", "开心");
        btt.put("image_emoticon8", "汗");
        btt.put("image_emoticon9", "泪");
        btt.put("image_emoticon10", "黑线");
        btt.put("image_emoticon11", "鄙视");
        btt.put("image_emoticon12", "不高兴");
        btt.put("image_emoticon13", "真棒");
        btt.put("image_emoticon14", "钱");
        btt.put("image_emoticon15", "疑问");
        btt.put("image_emoticon16", "阴险");
        btt.put("image_emoticon17", "吐");
        btt.put("image_emoticon18", "咦");
        btt.put("image_emoticon19", "委屈");
        btt.put("image_emoticon20", "花心");
        btt.put("image_emoticon21", "呼~");
        btt.put("image_emoticon22", "笑眼");
        btt.put("image_emoticon23", "冷");
        btt.put("image_emoticon24", "太开心");
        btt.put("image_emoticon25", "滑稽");
        btt.put("image_emoticon26", "勉强");
        btt.put("image_emoticon27", "狂汗");
        btt.put("image_emoticon28", "乖");
        btt.put("image_emoticon29", "睡觉");
        btt.put("image_emoticon30", "惊哭");
        btt.put("image_emoticon31", "生气");
        btt.put("image_emoticon32", "惊讶");
        btt.put("image_emoticon33", "喷");
        btt.put("image_emoticon34", "爱心");
        btt.put("image_emoticon35", "心碎");
        btt.put("image_emoticon36", "玫瑰");
        btt.put("image_emoticon37", "礼物");
        btt.put("image_emoticon38", "彩虹");
        btt.put("image_emoticon39", "星星月亮");
        btt.put("image_emoticon40", "太阳");
        btt.put("image_emoticon41", "钱币");
        btt.put("image_emoticon42", "灯泡");
        btt.put("image_emoticon43", "茶杯");
        btt.put("image_emoticon44", "蛋糕");
        btt.put("image_emoticon45", "音乐");
        btt.put("image_emoticon46", "haha");
        btt.put("image_emoticon47", "胜利");
        btt.put("image_emoticon48", "大拇指");
        btt.put("image_emoticon49", "弱");
        btt.put("image_emoticon50", "OK");
        btt.put("image_emoticon61", "哼");
        btt.put("image_emoticon62", "吃瓜");
        btt.put("image_emoticon63", "扔便便");
        btt.put("image_emoticon64", "惊恐");
        btt.put("image_emoticon65", "哎呦");
        btt.put("image_emoticon66", "小乖");
        btt.put("image_emoticon67", "捂嘴笑");
        btt.put("image_emoticon68", "你懂的");
        btt.put("image_emoticon69", "what");
        btt.put("image_emoticon70", "酸爽");
        btt.put("image_emoticon71", "呀咩爹");
        btt.put("image_emoticon72", "笑尿");
        btt.put("image_emoticon73", "挖鼻");
        btt.put("image_emoticon74", "犀利");
        btt.put("image_emoticon75", "小红脸");
        btt.put("image_emoticon76", "懒得理");
        btt.put("image_emoticon77", "沙发");
        btt.put("image_emoticon78", "手纸");
        btt.put("image_emoticon79", "香蕉");
        btt.put("image_emoticon80", "便便");
        btt.put("image_emoticon81", "药丸");
        btt.put("image_emoticon82", "红领巾");
        btt.put("image_emoticon83", "蜡烛");
        btt.put("image_emoticon84", "三道杠");
        btt.put("image_emoticon101", "不跟丑人说话");
        btt.put("image_emoticon102", "么么哒");
        btt.put("image_emoticon103", "亲亲才能起来");
        btt.put("image_emoticon104", "伦家只是宝宝");
        btt.put("image_emoticon105", "你是我的人");
        btt.put("image_emoticon106", "假装看不见");
        btt.put("image_emoticon107", "单身等撩");
        btt.put("image_emoticon108", "吓到宝宝了");
        btt.put("image_emoticon109", "哈哈哈");
        btt.put("image_emoticon110", "嗯嗯");
        btt.put("image_emoticon111", "好幸福");
        btt.put("image_emoticon112", "宝宝不开心");
        btt.put("image_emoticon113", "小姐姐别走");
        btt.put("image_emoticon114", "小姐姐在吗");
        btt.put("image_emoticon115", "小姐姐来啦");
        btt.put("image_emoticon116", "小姐姐来玩呀");
        btt.put("image_emoticon117", "我养你");
        btt.put("image_emoticon118", "我是不会骗你的");
        btt.put("image_emoticon119", "扎心了");
        btt.put("image_emoticon120", "无聊");
        btt.put("image_emoticon121", "月亮代表我的心");
        btt.put("image_emoticon122", "来追我呀");
        btt.put("image_emoticon123", "爱你的形状");
        btt.put("image_emoticon124", "白眼");
        btt.put("ali_001", "赖皮");
        btt.put("ali_002", "感动");
        btt.put("ali_003", "十分惊讶");
        btt.put("ali_004", "怒气");
        btt.put("ali_005", "哭泣");
        btt.put("ali_006", "吃惊");
        btt.put("ali_007", "嘲弄");
        btt.put("ali_008", "飘过");
        btt.put("ali_009", "转圈哭");
        btt.put("ali_010", "神经病");
        btt.put("ali_011", "揪耳朵");
        btt.put("ali_012", "惊汗");
        btt.put("ali_013", "隐身");
        btt.put("ali_014", "不要嘛");
        btt.put("ali_015", "遁");
        btt.put("ali_016", "不公平");
        btt.put("ali_017", "爬来了");
        btt.put("ali_018", "蛋花哭");
        btt.put("ali_019", "温暖");
        btt.put("ali_020", "点头");
        btt.put("ali_021", "撒钱");
        btt.put("ali_022", "献花");
        btt.put("ali_023", "寒");
        btt.put("ali_024", "傻笑");
        btt.put("ali_025", "扭扭");
        btt.put("ali_026", "疯");
        btt.put("ali_027", "抓狂");
        btt.put("ali_028", "抓");
        btt.put("ali_029", "蜷");
        btt.put("ali_030", "挠墙");
        btt.put("ali_031", "狂笑");
        btt.put("ali_032", "抱枕");
        btt.put("ali_033", "吼叫");
        btt.put("ali_034", "嚷");
        btt.put("ali_035", "唠叨");
        btt.put("ali_036", "捏脸");
        btt.put("ali_037", "爆笑");
        btt.put("ali_038", "郁闷");
        btt.put("ali_039", "潜水");
        btt.put("ali_040", "十分开心");
        btt.put("ali_041", "冷笑话");
        btt.put("ali_042", "顶！");
        btt.put("ali_043", "潜");
        btt.put("ali_044", "画圈圈");
        btt.put("ali_045", "玩电脑");
        btt.put("ali_046", "狂吐");
        btt.put("ali_047", "哭着跑");
        btt.put("ali_048", "阿狸侠");
        btt.put("ali_049", "冷死了");
        btt.put("ali_050", "惆怅~");
        btt.put("ali_051", "摸头");
        btt.put("ali_052", "蹭");
        btt.put("ali_053", "打滚");
        btt.put("ali_054", "叩拜");
        btt.put("ali_055", "摸");
        btt.put("ali_056", "数钱");
        btt.put("ali_057", "拖走");
        btt.put("ali_058", "热");
        btt.put("ali_059", "加1");
        btt.put("ali_060", "压力");
        btt.put("ali_061", "表逼我");
        btt.put("ali_062", "人呢");
        btt.put("ali_063", "摇晃");
        btt.put("ali_064", "打地鼠");
        btt.put("ali_065", "这个屌");
        btt.put("ali_066", "恐慌");
        btt.put("ali_067", "晕乎乎");
        btt.put("ali_068", "浮云");
        btt.put("ali_069", "给力");
        btt.put("ali_070", "杯具了");
        btt.put("b01", "微笑");
        btt.put("b02", "帅哥");
        btt.put("b03", "美女");
        btt.put("b04", "老大");
        btt.put("b05", "哈哈哈");
        btt.put("b06", "奸笑");
        btt.put("b07", "傻乐");
        btt.put("b08", "飞吻");
        btt.put("b09", "害羞");
        btt.put("b10", "花痴");
        btt.put("b11", "憧憬");
        btt.put("b12", "你牛");
        btt.put("b13", "鼓掌");
        btt.put("b14", "可爱");
        btt.put("b15", "太委屈");
        btt.put("b16", "大哭");
        btt.put("b17", "泪奔");
        btt.put("b18", "寻死");
        btt.put("b19", "非常惊讶");
        btt.put("b20", "表示疑问");
        btt.put("yz_001", "焦糖舞");
        btt.put("yz_002", "翻滚");
        btt.put("yz_003", "拍屁股做鬼脸");
        btt.put("yz_004", "不");
        btt.put("yz_005", "河蟹掉啦");
        btt.put("yz_006", "哦耶");
        btt.put("yz_007", "我倒");
        btt.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gk(String str) {
        Integer num = btq.get(str);
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
        Integer num = bts.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String gm(String str) {
        return btt.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Lp() {
        return btr.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0108a V(Context context, String str) {
        return null;
    }
}
