package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aMY = new HashMap<>(200);
    public static final ArrayList<Integer> aMZ = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aNa = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aNb = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aNb.put("image_emoticon", "呵呵");
        aNb.put("image_emoticon2", "哈哈");
        aNb.put("image_emoticon3", "吐舌");
        aNb.put("image_emoticon4", "啊");
        aNb.put("image_emoticon5", "酷");
        aNb.put("image_emoticon6", "怒");
        aNb.put("image_emoticon7", "开心");
        aNb.put("image_emoticon8", "汗");
        aNb.put("image_emoticon9", "泪");
        aNb.put("image_emoticon10", "黑线");
        aNb.put("image_emoticon11", "鄙视");
        aNb.put("image_emoticon12", "不高兴");
        aNb.put("image_emoticon13", "真棒");
        aNb.put("image_emoticon14", "钱");
        aNb.put("image_emoticon15", "疑问");
        aNb.put("image_emoticon16", "阴险");
        aNb.put("image_emoticon17", "吐");
        aNb.put("image_emoticon18", "咦");
        aNb.put("image_emoticon19", "委屈");
        aNb.put("image_emoticon20", "花心");
        aNb.put("image_emoticon21", "呼~");
        aNb.put("image_emoticon22", "笑眼");
        aNb.put("image_emoticon23", "冷");
        aNb.put("image_emoticon24", "太开心");
        aNb.put("image_emoticon25", "滑稽");
        aNb.put("image_emoticon26", "勉强");
        aNb.put("image_emoticon27", "狂汗");
        aNb.put("image_emoticon28", "乖");
        aNb.put("image_emoticon29", "睡觉");
        aNb.put("image_emoticon30", "惊哭");
        aNb.put("image_emoticon31", "生气");
        aNb.put("image_emoticon32", "惊讶");
        aNb.put("image_emoticon33", "喷");
        aNb.put("image_emoticon34", "爱心");
        aNb.put("image_emoticon35", "心碎");
        aNb.put("image_emoticon36", "玫瑰");
        aNb.put("image_emoticon37", "礼物");
        aNb.put("image_emoticon38", "彩虹");
        aNb.put("image_emoticon39", "星星月亮");
        aNb.put("image_emoticon40", "太阳");
        aNb.put("image_emoticon41", "钱币");
        aNb.put("image_emoticon42", "灯泡");
        aNb.put("image_emoticon43", "茶杯");
        aNb.put("image_emoticon44", "蛋糕");
        aNb.put("image_emoticon45", "音乐");
        aNb.put("image_emoticon46", "haha");
        aNb.put("image_emoticon47", "胜利");
        aNb.put("image_emoticon48", "大拇指");
        aNb.put("image_emoticon49", "弱");
        aNb.put("image_emoticon50", "OK");
        aNb.put("image_emoticon61", "哼");
        aNb.put("image_emoticon62", "吃瓜");
        aNb.put("image_emoticon63", "扔便便");
        aNb.put("image_emoticon64", "惊恐");
        aNb.put("image_emoticon65", "哎呦");
        aNb.put("image_emoticon66", "小乖");
        aNb.put("image_emoticon67", "捂嘴笑");
        aNb.put("image_emoticon68", "你懂的");
        aNb.put("image_emoticon69", "what");
        aNb.put("image_emoticon70", "酸爽");
        aNb.put("image_emoticon71", "呀咩爹");
        aNb.put("image_emoticon72", "笑尿");
        aNb.put("image_emoticon73", "挖鼻");
        aNb.put("image_emoticon74", "犀利");
        aNb.put("image_emoticon75", "小红脸");
        aNb.put("image_emoticon76", "懒得理");
        aNb.put("image_emoticon77", "沙发");
        aNb.put("image_emoticon78", "手纸");
        aNb.put("image_emoticon79", "香蕉");
        aNb.put("image_emoticon80", "便便");
        aNb.put("image_emoticon81", "药丸");
        aNb.put("image_emoticon82", "红领巾");
        aNb.put("image_emoticon83", "蜡烛");
        aNb.put("image_emoticon84", "三道杠");
        aNb.put("image_emoticon101", "不跟丑人说话");
        aNb.put("image_emoticon102", "么么哒");
        aNb.put("image_emoticon103", "亲亲才能起来");
        aNb.put("image_emoticon104", "伦家只是宝宝");
        aNb.put("image_emoticon105", "你是我的人");
        aNb.put("image_emoticon106", "假装看不见");
        aNb.put("image_emoticon107", "单身等撩");
        aNb.put("image_emoticon108", "吓到宝宝了");
        aNb.put("image_emoticon109", "哈哈哈");
        aNb.put("image_emoticon110", "嗯嗯");
        aNb.put("image_emoticon111", "好幸福");
        aNb.put("image_emoticon112", "宝宝不开心");
        aNb.put("image_emoticon113", "小姐姐别走");
        aNb.put("image_emoticon114", "小姐姐在吗");
        aNb.put("image_emoticon115", "小姐姐来啦");
        aNb.put("image_emoticon116", "小姐姐来玩呀");
        aNb.put("image_emoticon117", "我养你");
        aNb.put("image_emoticon118", "我是不会骗你的");
        aNb.put("image_emoticon119", "扎心了");
        aNb.put("image_emoticon120", "无聊");
        aNb.put("image_emoticon121", "月亮代表我的心");
        aNb.put("image_emoticon122", "来追我呀");
        aNb.put("image_emoticon123", "爱你的形状");
        aNb.put("image_emoticon124", "白眼");
        aNb.put("ali_001", "赖皮");
        aNb.put("ali_002", "感动");
        aNb.put("ali_003", "十分惊讶");
        aNb.put("ali_004", "怒气");
        aNb.put("ali_005", "哭泣");
        aNb.put("ali_006", "吃惊");
        aNb.put("ali_007", "嘲弄");
        aNb.put("ali_008", "飘过");
        aNb.put("ali_009", "转圈哭");
        aNb.put("ali_010", "神经病");
        aNb.put("ali_011", "揪耳朵");
        aNb.put("ali_012", "惊汗");
        aNb.put("ali_013", "隐身");
        aNb.put("ali_014", "不要嘛");
        aNb.put("ali_015", "遁");
        aNb.put("ali_016", "不公平");
        aNb.put("ali_017", "爬来了");
        aNb.put("ali_018", "蛋花哭");
        aNb.put("ali_019", "温暖");
        aNb.put("ali_020", "点头");
        aNb.put("ali_021", "撒钱");
        aNb.put("ali_022", "献花");
        aNb.put("ali_023", "寒");
        aNb.put("ali_024", "傻笑");
        aNb.put("ali_025", "扭扭");
        aNb.put("ali_026", "疯");
        aNb.put("ali_027", "抓狂");
        aNb.put("ali_028", "抓");
        aNb.put("ali_029", "蜷");
        aNb.put("ali_030", "挠墙");
        aNb.put("ali_031", "狂笑");
        aNb.put("ali_032", "抱枕");
        aNb.put("ali_033", "吼叫");
        aNb.put("ali_034", "嚷");
        aNb.put("ali_035", "唠叨");
        aNb.put("ali_036", "捏脸");
        aNb.put("ali_037", "爆笑");
        aNb.put("ali_038", "郁闷");
        aNb.put("ali_039", "潜水");
        aNb.put("ali_040", "十分开心");
        aNb.put("ali_041", "冷笑话");
        aNb.put("ali_042", "顶！");
        aNb.put("ali_043", "潜");
        aNb.put("ali_044", "画圈圈");
        aNb.put("ali_045", "玩电脑");
        aNb.put("ali_046", "狂吐");
        aNb.put("ali_047", "哭着跑");
        aNb.put("ali_048", "阿狸侠");
        aNb.put("ali_049", "冷死了");
        aNb.put("ali_050", "惆怅~");
        aNb.put("ali_051", "摸头");
        aNb.put("ali_052", "蹭");
        aNb.put("ali_053", "打滚");
        aNb.put("ali_054", "叩拜");
        aNb.put("ali_055", "摸");
        aNb.put("ali_056", "数钱");
        aNb.put("ali_057", "拖走");
        aNb.put("ali_058", "热");
        aNb.put("ali_059", "加1");
        aNb.put("ali_060", "压力");
        aNb.put("ali_061", "表逼我");
        aNb.put("ali_062", "人呢");
        aNb.put("ali_063", "摇晃");
        aNb.put("ali_064", "打地鼠");
        aNb.put("ali_065", "这个屌");
        aNb.put("ali_066", "恐慌");
        aNb.put("ali_067", "晕乎乎");
        aNb.put("ali_068", "浮云");
        aNb.put("ali_069", "给力");
        aNb.put("ali_070", "杯具了");
        aNb.put("b01", "微笑");
        aNb.put("b02", "帅哥");
        aNb.put("b03", "美女");
        aNb.put("b04", "老大");
        aNb.put("b05", "哈哈哈");
        aNb.put("b06", "奸笑");
        aNb.put("b07", "傻乐");
        aNb.put("b08", "飞吻");
        aNb.put("b09", "害羞");
        aNb.put("b10", "花痴");
        aNb.put("b11", "憧憬");
        aNb.put("b12", "你牛");
        aNb.put("b13", "鼓掌");
        aNb.put("b14", "可爱");
        aNb.put("b15", "太委屈");
        aNb.put("b16", "大哭");
        aNb.put("b17", "泪奔");
        aNb.put("b18", "寻死");
        aNb.put("b19", "非常惊讶");
        aNb.put("b20", "表示疑问");
        aNb.put("yz_001", "焦糖舞");
        aNb.put("yz_002", "翻滚");
        aNb.put("yz_003", "拍屁股做鬼脸");
        aNb.put("yz_004", "不");
        aNb.put("yz_005", "河蟹掉啦");
        aNb.put("yz_006", "哦耶");
        aNb.put("yz_007", "我倒");
        aNb.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gE(String str) {
        Integer num = aMY.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gF(String str) {
        Integer num = aNa.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String gG(String str) {
        return aNb.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int HL() {
        return aMZ.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0116a T(Context context, String str) {
        return null;
    }
}
