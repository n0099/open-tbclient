package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.f;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aMV = new HashMap<>(200);
    public static final ArrayList<Integer> aMW = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aMX = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aMY = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aMY.put("image_emoticon", "呵呵");
        aMY.put("image_emoticon2", "哈哈");
        aMY.put("image_emoticon3", "吐舌");
        aMY.put("image_emoticon4", "啊");
        aMY.put("image_emoticon5", "酷");
        aMY.put("image_emoticon6", "怒");
        aMY.put("image_emoticon7", "开心");
        aMY.put("image_emoticon8", "汗");
        aMY.put("image_emoticon9", "泪");
        aMY.put("image_emoticon10", "黑线");
        aMY.put("image_emoticon11", "鄙视");
        aMY.put("image_emoticon12", "不高兴");
        aMY.put("image_emoticon13", "真棒");
        aMY.put("image_emoticon14", "钱");
        aMY.put("image_emoticon15", "疑问");
        aMY.put("image_emoticon16", "阴险");
        aMY.put("image_emoticon17", "吐");
        aMY.put("image_emoticon18", "咦");
        aMY.put("image_emoticon19", "委屈");
        aMY.put("image_emoticon20", "花心");
        aMY.put("image_emoticon21", "呼~");
        aMY.put("image_emoticon22", "笑眼");
        aMY.put("image_emoticon23", "冷");
        aMY.put("image_emoticon24", "太开心");
        aMY.put("image_emoticon25", "滑稽");
        aMY.put("image_emoticon26", "勉强");
        aMY.put("image_emoticon27", "狂汗");
        aMY.put("image_emoticon28", "乖");
        aMY.put("image_emoticon29", "睡觉");
        aMY.put("image_emoticon30", "惊哭");
        aMY.put("image_emoticon31", "生气");
        aMY.put("image_emoticon32", "惊讶");
        aMY.put("image_emoticon33", "喷");
        aMY.put("image_emoticon34", "爱心");
        aMY.put("image_emoticon35", "心碎");
        aMY.put("image_emoticon36", "玫瑰");
        aMY.put("image_emoticon37", "礼物");
        aMY.put("image_emoticon38", "彩虹");
        aMY.put("image_emoticon39", "星星月亮");
        aMY.put("image_emoticon40", "太阳");
        aMY.put("image_emoticon41", "钱币");
        aMY.put("image_emoticon42", "灯泡");
        aMY.put("image_emoticon43", "茶杯");
        aMY.put("image_emoticon44", "蛋糕");
        aMY.put("image_emoticon45", "音乐");
        aMY.put("image_emoticon46", "haha");
        aMY.put("image_emoticon47", "胜利");
        aMY.put("image_emoticon48", "大拇指");
        aMY.put("image_emoticon49", "弱");
        aMY.put("image_emoticon50", "OK");
        aMY.put("image_emoticon61", "哼");
        aMY.put("image_emoticon62", "吃瓜");
        aMY.put("image_emoticon63", "扔便便");
        aMY.put("image_emoticon64", "惊恐");
        aMY.put("image_emoticon65", "哎呦");
        aMY.put("image_emoticon66", "小乖");
        aMY.put("image_emoticon67", "捂嘴笑");
        aMY.put("image_emoticon68", "你懂的");
        aMY.put("image_emoticon69", "what");
        aMY.put("image_emoticon70", "酸爽");
        aMY.put("image_emoticon71", "呀咩爹");
        aMY.put("image_emoticon72", "笑尿");
        aMY.put("image_emoticon73", "挖鼻");
        aMY.put("image_emoticon74", "犀利");
        aMY.put("image_emoticon75", "小红脸");
        aMY.put("image_emoticon76", "懒得理");
        aMY.put("image_emoticon77", "沙发");
        aMY.put("image_emoticon78", "手纸");
        aMY.put("image_emoticon79", "香蕉");
        aMY.put("image_emoticon80", "便便");
        aMY.put("image_emoticon81", "药丸");
        aMY.put("image_emoticon82", "红领巾");
        aMY.put("image_emoticon83", "蜡烛");
        aMY.put("image_emoticon84", "三道杠");
        aMY.put("image_emoticon101", "不跟丑人说话");
        aMY.put("image_emoticon102", "么么哒");
        aMY.put("image_emoticon103", "亲亲才能起来");
        aMY.put("image_emoticon104", "伦家只是宝宝");
        aMY.put("image_emoticon105", "你是我的人");
        aMY.put("image_emoticon106", "假装看不见");
        aMY.put("image_emoticon107", "单身等撩");
        aMY.put("image_emoticon108", "吓到宝宝了");
        aMY.put("image_emoticon109", "哈哈哈");
        aMY.put("image_emoticon110", "嗯嗯");
        aMY.put("image_emoticon111", "好幸福");
        aMY.put("image_emoticon112", "宝宝不开心");
        aMY.put("image_emoticon113", "小姐姐别走");
        aMY.put("image_emoticon114", "小姐姐在吗");
        aMY.put("image_emoticon115", "小姐姐来啦");
        aMY.put("image_emoticon116", "小姐姐来玩呀");
        aMY.put("image_emoticon117", "我养你");
        aMY.put("image_emoticon118", "我是不会骗你的");
        aMY.put("image_emoticon119", "扎心了");
        aMY.put("image_emoticon120", "无聊");
        aMY.put("image_emoticon121", "月亮代表我的心");
        aMY.put("image_emoticon122", "来追我呀");
        aMY.put("image_emoticon123", "爱你的形状");
        aMY.put("image_emoticon124", "白眼");
        aMY.put("ali_001", "赖皮");
        aMY.put("ali_002", "感动");
        aMY.put("ali_003", "十分惊讶");
        aMY.put("ali_004", "怒气");
        aMY.put("ali_005", "哭泣");
        aMY.put("ali_006", "吃惊");
        aMY.put("ali_007", "嘲弄");
        aMY.put("ali_008", "飘过");
        aMY.put("ali_009", "转圈哭");
        aMY.put("ali_010", "神经病");
        aMY.put("ali_011", "揪耳朵");
        aMY.put("ali_012", "惊汗");
        aMY.put("ali_013", "隐身");
        aMY.put("ali_014", "不要嘛");
        aMY.put("ali_015", "遁");
        aMY.put("ali_016", "不公平");
        aMY.put("ali_017", "爬来了");
        aMY.put("ali_018", "蛋花哭");
        aMY.put("ali_019", "温暖");
        aMY.put("ali_020", "点头");
        aMY.put("ali_021", "撒钱");
        aMY.put("ali_022", "献花");
        aMY.put("ali_023", "寒");
        aMY.put("ali_024", "傻笑");
        aMY.put("ali_025", "扭扭");
        aMY.put("ali_026", "疯");
        aMY.put("ali_027", "抓狂");
        aMY.put("ali_028", "抓");
        aMY.put("ali_029", "蜷");
        aMY.put("ali_030", "挠墙");
        aMY.put("ali_031", "狂笑");
        aMY.put("ali_032", "抱枕");
        aMY.put("ali_033", "吼叫");
        aMY.put("ali_034", "嚷");
        aMY.put("ali_035", "唠叨");
        aMY.put("ali_036", "捏脸");
        aMY.put("ali_037", "爆笑");
        aMY.put("ali_038", "郁闷");
        aMY.put("ali_039", "潜水");
        aMY.put("ali_040", "十分开心");
        aMY.put("ali_041", "冷笑话");
        aMY.put("ali_042", "顶！");
        aMY.put("ali_043", "潜");
        aMY.put("ali_044", "画圈圈");
        aMY.put("ali_045", "玩电脑");
        aMY.put("ali_046", "狂吐");
        aMY.put("ali_047", "哭着跑");
        aMY.put("ali_048", "阿狸侠");
        aMY.put("ali_049", "冷死了");
        aMY.put("ali_050", "惆怅~");
        aMY.put("ali_051", "摸头");
        aMY.put("ali_052", "蹭");
        aMY.put("ali_053", "打滚");
        aMY.put("ali_054", "叩拜");
        aMY.put("ali_055", "摸");
        aMY.put("ali_056", "数钱");
        aMY.put("ali_057", "拖走");
        aMY.put("ali_058", "热");
        aMY.put("ali_059", "加1");
        aMY.put("ali_060", "压力");
        aMY.put("ali_061", "表逼我");
        aMY.put("ali_062", "人呢");
        aMY.put("ali_063", "摇晃");
        aMY.put("ali_064", "打地鼠");
        aMY.put("ali_065", "这个屌");
        aMY.put("ali_066", "恐慌");
        aMY.put("ali_067", "晕乎乎");
        aMY.put("ali_068", "浮云");
        aMY.put("ali_069", "给力");
        aMY.put("ali_070", "杯具了");
        aMY.put("b01", "微笑");
        aMY.put("b02", "帅哥");
        aMY.put("b03", "美女");
        aMY.put("b04", "老大");
        aMY.put("b05", "哈哈哈");
        aMY.put("b06", "奸笑");
        aMY.put("b07", "傻乐");
        aMY.put("b08", "飞吻");
        aMY.put("b09", "害羞");
        aMY.put("b10", "花痴");
        aMY.put("b11", "憧憬");
        aMY.put("b12", "你牛");
        aMY.put("b13", "鼓掌");
        aMY.put("b14", "可爱");
        aMY.put("b15", "太委屈");
        aMY.put("b16", "大哭");
        aMY.put("b17", "泪奔");
        aMY.put("b18", "寻死");
        aMY.put("b19", "非常惊讶");
        aMY.put("b20", "表示疑问");
        aMY.put("yz_001", "焦糖舞");
        aMY.put("yz_002", "翻滚");
        aMY.put("yz_003", "拍屁股做鬼脸");
        aMY.put("yz_004", "不");
        aMY.put("yz_005", "河蟹掉啦");
        aMY.put("yz_006", "哦耶");
        aMY.put("yz_007", "我倒");
        aMY.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gA(String str) {
        Integer num = aMV.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(f.C0146f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gB(String str) {
        Integer num = aMX.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String gC(String str) {
        return aMY.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int HG() {
        return aMW.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0113a V(Context context, String str) {
        return null;
    }
}
