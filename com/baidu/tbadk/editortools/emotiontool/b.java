package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> btf = new HashMap<>(200);
    public static final ArrayList<Integer> btg = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> bth = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> bti = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        bti.put("image_emoticon", "呵呵");
        bti.put("image_emoticon2", "哈哈");
        bti.put("image_emoticon3", "吐舌");
        bti.put("image_emoticon4", "啊");
        bti.put("image_emoticon5", "酷");
        bti.put("image_emoticon6", "怒");
        bti.put("image_emoticon7", "开心");
        bti.put("image_emoticon8", "汗");
        bti.put("image_emoticon9", "泪");
        bti.put("image_emoticon10", "黑线");
        bti.put("image_emoticon11", "鄙视");
        bti.put("image_emoticon12", "不高兴");
        bti.put("image_emoticon13", "真棒");
        bti.put("image_emoticon14", "钱");
        bti.put("image_emoticon15", "疑问");
        bti.put("image_emoticon16", "阴险");
        bti.put("image_emoticon17", "吐");
        bti.put("image_emoticon18", "咦");
        bti.put("image_emoticon19", "委屈");
        bti.put("image_emoticon20", "花心");
        bti.put("image_emoticon21", "呼~");
        bti.put("image_emoticon22", "笑眼");
        bti.put("image_emoticon23", "冷");
        bti.put("image_emoticon24", "太开心");
        bti.put("image_emoticon25", "滑稽");
        bti.put("image_emoticon26", "勉强");
        bti.put("image_emoticon27", "狂汗");
        bti.put("image_emoticon28", "乖");
        bti.put("image_emoticon29", "睡觉");
        bti.put("image_emoticon30", "惊哭");
        bti.put("image_emoticon31", "生气");
        bti.put("image_emoticon32", "惊讶");
        bti.put("image_emoticon33", "喷");
        bti.put("image_emoticon34", "爱心");
        bti.put("image_emoticon35", "心碎");
        bti.put("image_emoticon36", "玫瑰");
        bti.put("image_emoticon37", "礼物");
        bti.put("image_emoticon38", "彩虹");
        bti.put("image_emoticon39", "星星月亮");
        bti.put("image_emoticon40", "太阳");
        bti.put("image_emoticon41", "钱币");
        bti.put("image_emoticon42", "灯泡");
        bti.put("image_emoticon43", "茶杯");
        bti.put("image_emoticon44", "蛋糕");
        bti.put("image_emoticon45", "音乐");
        bti.put("image_emoticon46", "haha");
        bti.put("image_emoticon47", "胜利");
        bti.put("image_emoticon48", "大拇指");
        bti.put("image_emoticon49", "弱");
        bti.put("image_emoticon50", "OK");
        bti.put("image_emoticon61", "哼");
        bti.put("image_emoticon62", "吃瓜");
        bti.put("image_emoticon63", "扔便便");
        bti.put("image_emoticon64", "惊恐");
        bti.put("image_emoticon65", "哎呦");
        bti.put("image_emoticon66", "小乖");
        bti.put("image_emoticon67", "捂嘴笑");
        bti.put("image_emoticon68", "你懂的");
        bti.put("image_emoticon69", "what");
        bti.put("image_emoticon70", "酸爽");
        bti.put("image_emoticon71", "呀咩爹");
        bti.put("image_emoticon72", "笑尿");
        bti.put("image_emoticon73", "挖鼻");
        bti.put("image_emoticon74", "犀利");
        bti.put("image_emoticon75", "小红脸");
        bti.put("image_emoticon76", "懒得理");
        bti.put("image_emoticon77", "沙发");
        bti.put("image_emoticon78", "手纸");
        bti.put("image_emoticon79", "香蕉");
        bti.put("image_emoticon80", "便便");
        bti.put("image_emoticon81", "药丸");
        bti.put("image_emoticon82", "红领巾");
        bti.put("image_emoticon83", "蜡烛");
        bti.put("image_emoticon84", "三道杠");
        bti.put("image_emoticon101", "不跟丑人说话");
        bti.put("image_emoticon102", "么么哒");
        bti.put("image_emoticon103", "亲亲才能起来");
        bti.put("image_emoticon104", "伦家只是宝宝");
        bti.put("image_emoticon105", "你是我的人");
        bti.put("image_emoticon106", "假装看不见");
        bti.put("image_emoticon107", "单身等撩");
        bti.put("image_emoticon108", "吓到宝宝了");
        bti.put("image_emoticon109", "哈哈哈");
        bti.put("image_emoticon110", "嗯嗯");
        bti.put("image_emoticon111", "好幸福");
        bti.put("image_emoticon112", "宝宝不开心");
        bti.put("image_emoticon113", "小姐姐别走");
        bti.put("image_emoticon114", "小姐姐在吗");
        bti.put("image_emoticon115", "小姐姐来啦");
        bti.put("image_emoticon116", "小姐姐来玩呀");
        bti.put("image_emoticon117", "我养你");
        bti.put("image_emoticon118", "我是不会骗你的");
        bti.put("image_emoticon119", "扎心了");
        bti.put("image_emoticon120", "无聊");
        bti.put("image_emoticon121", "月亮代表我的心");
        bti.put("image_emoticon122", "来追我呀");
        bti.put("image_emoticon123", "爱你的形状");
        bti.put("image_emoticon124", "白眼");
        bti.put("ali_001", "赖皮");
        bti.put("ali_002", "感动");
        bti.put("ali_003", "十分惊讶");
        bti.put("ali_004", "怒气");
        bti.put("ali_005", "哭泣");
        bti.put("ali_006", "吃惊");
        bti.put("ali_007", "嘲弄");
        bti.put("ali_008", "飘过");
        bti.put("ali_009", "转圈哭");
        bti.put("ali_010", "神经病");
        bti.put("ali_011", "揪耳朵");
        bti.put("ali_012", "惊汗");
        bti.put("ali_013", "隐身");
        bti.put("ali_014", "不要嘛");
        bti.put("ali_015", "遁");
        bti.put("ali_016", "不公平");
        bti.put("ali_017", "爬来了");
        bti.put("ali_018", "蛋花哭");
        bti.put("ali_019", "温暖");
        bti.put("ali_020", "点头");
        bti.put("ali_021", "撒钱");
        bti.put("ali_022", "献花");
        bti.put("ali_023", "寒");
        bti.put("ali_024", "傻笑");
        bti.put("ali_025", "扭扭");
        bti.put("ali_026", "疯");
        bti.put("ali_027", "抓狂");
        bti.put("ali_028", "抓");
        bti.put("ali_029", "蜷");
        bti.put("ali_030", "挠墙");
        bti.put("ali_031", "狂笑");
        bti.put("ali_032", "抱枕");
        bti.put("ali_033", "吼叫");
        bti.put("ali_034", "嚷");
        bti.put("ali_035", "唠叨");
        bti.put("ali_036", "捏脸");
        bti.put("ali_037", "爆笑");
        bti.put("ali_038", "郁闷");
        bti.put("ali_039", "潜水");
        bti.put("ali_040", "十分开心");
        bti.put("ali_041", "冷笑话");
        bti.put("ali_042", "顶！");
        bti.put("ali_043", "潜");
        bti.put("ali_044", "画圈圈");
        bti.put("ali_045", "玩电脑");
        bti.put("ali_046", "狂吐");
        bti.put("ali_047", "哭着跑");
        bti.put("ali_048", "阿狸侠");
        bti.put("ali_049", "冷死了");
        bti.put("ali_050", "惆怅~");
        bti.put("ali_051", "摸头");
        bti.put("ali_052", "蹭");
        bti.put("ali_053", "打滚");
        bti.put("ali_054", "叩拜");
        bti.put("ali_055", "摸");
        bti.put("ali_056", "数钱");
        bti.put("ali_057", "拖走");
        bti.put("ali_058", "热");
        bti.put("ali_059", "加1");
        bti.put("ali_060", "压力");
        bti.put("ali_061", "表逼我");
        bti.put("ali_062", "人呢");
        bti.put("ali_063", "摇晃");
        bti.put("ali_064", "打地鼠");
        bti.put("ali_065", "这个屌");
        bti.put("ali_066", "恐慌");
        bti.put("ali_067", "晕乎乎");
        bti.put("ali_068", "浮云");
        bti.put("ali_069", "给力");
        bti.put("ali_070", "杯具了");
        bti.put("b01", "微笑");
        bti.put("b02", "帅哥");
        bti.put("b03", "美女");
        bti.put("b04", "老大");
        bti.put("b05", "哈哈哈");
        bti.put("b06", "奸笑");
        bti.put("b07", "傻乐");
        bti.put("b08", "飞吻");
        bti.put("b09", "害羞");
        bti.put("b10", "花痴");
        bti.put("b11", "憧憬");
        bti.put("b12", "你牛");
        bti.put("b13", "鼓掌");
        bti.put("b14", "可爱");
        bti.put("b15", "太委屈");
        bti.put("b16", "大哭");
        bti.put("b17", "泪奔");
        bti.put("b18", "寻死");
        bti.put("b19", "非常惊讶");
        bti.put("b20", "表示疑问");
        bti.put("yz_001", "焦糖舞");
        bti.put("yz_002", "翻滚");
        bti.put("yz_003", "拍屁股做鬼脸");
        bti.put("yz_004", "不");
        bti.put("yz_005", "河蟹掉啦");
        bti.put("yz_006", "哦耶");
        bti.put("yz_007", "我倒");
        bti.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gk(String str) {
        Integer num = btf.get(str);
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
        Integer num = bth.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String gm(String str) {
        return bti.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Lp() {
        return btg.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0109a V(Context context, String str) {
        return null;
    }
}
