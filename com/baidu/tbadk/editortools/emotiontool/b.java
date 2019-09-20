package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.R;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> ctQ = new HashMap<>(200);
    public static final ArrayList<Integer> ctR = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> ctS = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> ctT = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        ctT.put("image_emoticon", "呵呵");
        ctT.put("image_emoticon2", "哈哈");
        ctT.put("image_emoticon3", "吐舌");
        ctT.put("image_emoticon4", "啊");
        ctT.put("image_emoticon5", "酷");
        ctT.put("image_emoticon6", "怒");
        ctT.put("image_emoticon7", "开心");
        ctT.put("image_emoticon8", "汗");
        ctT.put("image_emoticon9", "泪");
        ctT.put("image_emoticon10", "黑线");
        ctT.put("image_emoticon11", "鄙视");
        ctT.put("image_emoticon12", "不高兴");
        ctT.put("image_emoticon13", "真棒");
        ctT.put("image_emoticon14", "钱");
        ctT.put("image_emoticon15", "疑问");
        ctT.put("image_emoticon16", "阴险");
        ctT.put("image_emoticon17", "吐");
        ctT.put("image_emoticon18", "咦");
        ctT.put("image_emoticon19", "委屈");
        ctT.put("image_emoticon20", "花心");
        ctT.put("image_emoticon21", "呼~");
        ctT.put("image_emoticon22", "笑眼");
        ctT.put("image_emoticon23", "冷");
        ctT.put("image_emoticon24", "太开心");
        ctT.put("image_emoticon25", "滑稽");
        ctT.put("image_emoticon26", "勉强");
        ctT.put("image_emoticon27", "狂汗");
        ctT.put("image_emoticon28", "乖");
        ctT.put("image_emoticon29", "睡觉");
        ctT.put("image_emoticon30", "惊哭");
        ctT.put("image_emoticon31", "生气");
        ctT.put("image_emoticon32", "惊讶");
        ctT.put("image_emoticon33", "喷");
        ctT.put("image_emoticon34", "爱心");
        ctT.put("image_emoticon35", "心碎");
        ctT.put("image_emoticon36", "玫瑰");
        ctT.put("image_emoticon37", "礼物");
        ctT.put("image_emoticon38", "彩虹");
        ctT.put("image_emoticon39", "星星月亮");
        ctT.put("image_emoticon40", "太阳");
        ctT.put("image_emoticon41", "钱币");
        ctT.put("image_emoticon42", "灯泡");
        ctT.put("image_emoticon43", "茶杯");
        ctT.put("image_emoticon44", "蛋糕");
        ctT.put("image_emoticon45", "音乐");
        ctT.put("image_emoticon46", "haha");
        ctT.put("image_emoticon47", "胜利");
        ctT.put("image_emoticon48", "大拇指");
        ctT.put("image_emoticon49", "弱");
        ctT.put("image_emoticon50", "OK");
        ctT.put("image_emoticon61", "哼");
        ctT.put("image_emoticon62", "吃瓜");
        ctT.put("image_emoticon63", "扔便便");
        ctT.put("image_emoticon64", "惊恐");
        ctT.put("image_emoticon65", "哎呦");
        ctT.put("image_emoticon66", "小乖");
        ctT.put("image_emoticon67", "捂嘴笑");
        ctT.put("image_emoticon68", "你懂的");
        ctT.put("image_emoticon69", "what");
        ctT.put("image_emoticon70", "酸爽");
        ctT.put("image_emoticon71", "呀咩爹");
        ctT.put("image_emoticon72", "笑尿");
        ctT.put("image_emoticon73", "挖鼻");
        ctT.put("image_emoticon74", "犀利");
        ctT.put("image_emoticon75", "小红脸");
        ctT.put("image_emoticon76", "懒得理");
        ctT.put("image_emoticon77", "沙发");
        ctT.put("image_emoticon78", "手纸");
        ctT.put("image_emoticon79", "香蕉");
        ctT.put("image_emoticon80", "便便");
        ctT.put("image_emoticon81", "药丸");
        ctT.put("image_emoticon82", "红领巾");
        ctT.put("image_emoticon83", "蜡烛");
        ctT.put("image_emoticon84", "三道杠");
        ctT.put("image_emoticon101", "不跟丑人说话");
        ctT.put("image_emoticon102", "么么哒");
        ctT.put("image_emoticon103", "亲亲才能起来");
        ctT.put("image_emoticon104", "伦家只是宝宝");
        ctT.put("image_emoticon105", "你是我的人");
        ctT.put("image_emoticon106", "假装看不见");
        ctT.put("image_emoticon107", "单身等撩");
        ctT.put("image_emoticon108", "吓到宝宝了");
        ctT.put("image_emoticon109", "哈哈哈");
        ctT.put("image_emoticon110", "嗯嗯");
        ctT.put("image_emoticon111", "好幸福");
        ctT.put("image_emoticon112", "宝宝不开心");
        ctT.put("image_emoticon113", "小姐姐别走");
        ctT.put("image_emoticon114", "小姐姐在吗");
        ctT.put("image_emoticon115", "小姐姐来啦");
        ctT.put("image_emoticon116", "小姐姐来玩呀");
        ctT.put("image_emoticon117", "我养你");
        ctT.put("image_emoticon118", "我是不会骗你的");
        ctT.put("image_emoticon119", "扎心了");
        ctT.put("image_emoticon120", "无聊");
        ctT.put("image_emoticon121", "月亮代表我的心");
        ctT.put("image_emoticon122", "来追我呀");
        ctT.put("image_emoticon123", "爱你的形状");
        ctT.put("image_emoticon124", "白眼");
        ctT.put("ali_001", "赖皮");
        ctT.put("ali_002", "感动");
        ctT.put("ali_003", "十分惊讶");
        ctT.put("ali_004", "怒气");
        ctT.put("ali_005", "哭泣");
        ctT.put("ali_006", "吃惊");
        ctT.put("ali_007", "嘲弄");
        ctT.put("ali_008", "飘过");
        ctT.put("ali_009", "转圈哭");
        ctT.put("ali_010", "神经病");
        ctT.put("ali_011", "揪耳朵");
        ctT.put("ali_012", "惊汗");
        ctT.put("ali_013", "隐身");
        ctT.put("ali_014", "不要嘛");
        ctT.put("ali_015", "遁");
        ctT.put("ali_016", "不公平");
        ctT.put("ali_017", "爬来了");
        ctT.put("ali_018", "蛋花哭");
        ctT.put("ali_019", "温暖");
        ctT.put("ali_020", "点头");
        ctT.put("ali_021", "撒钱");
        ctT.put("ali_022", "献花");
        ctT.put("ali_023", "寒");
        ctT.put("ali_024", "傻笑");
        ctT.put("ali_025", "扭扭");
        ctT.put("ali_026", "疯");
        ctT.put("ali_027", "抓狂");
        ctT.put("ali_028", "抓");
        ctT.put("ali_029", "蜷");
        ctT.put("ali_030", "挠墙");
        ctT.put("ali_031", "狂笑");
        ctT.put("ali_032", "抱枕");
        ctT.put("ali_033", "吼叫");
        ctT.put("ali_034", "嚷");
        ctT.put("ali_035", "唠叨");
        ctT.put("ali_036", "捏脸");
        ctT.put("ali_037", "爆笑");
        ctT.put("ali_038", "郁闷");
        ctT.put("ali_039", "潜水");
        ctT.put("ali_040", "十分开心");
        ctT.put("ali_041", "冷笑话");
        ctT.put("ali_042", "顶！");
        ctT.put("ali_043", "潜");
        ctT.put("ali_044", "画圈圈");
        ctT.put("ali_045", "玩电脑");
        ctT.put("ali_046", "狂吐");
        ctT.put("ali_047", "哭着跑");
        ctT.put("ali_048", "阿狸侠");
        ctT.put("ali_049", "冷死了");
        ctT.put("ali_050", "惆怅~");
        ctT.put("ali_051", "摸头");
        ctT.put("ali_052", "蹭");
        ctT.put("ali_053", "打滚");
        ctT.put("ali_054", "叩拜");
        ctT.put("ali_055", "摸");
        ctT.put("ali_056", "数钱");
        ctT.put("ali_057", "拖走");
        ctT.put("ali_058", "热");
        ctT.put("ali_059", "加1");
        ctT.put("ali_060", "压力");
        ctT.put("ali_061", "表逼我");
        ctT.put("ali_062", "人呢");
        ctT.put("ali_063", "摇晃");
        ctT.put("ali_064", "打地鼠");
        ctT.put("ali_065", "这个屌");
        ctT.put("ali_066", "恐慌");
        ctT.put("ali_067", "晕乎乎");
        ctT.put("ali_068", "浮云");
        ctT.put("ali_069", "给力");
        ctT.put("ali_070", "杯具了");
        ctT.put("b01", "微笑");
        ctT.put("b02", "帅哥");
        ctT.put("b03", "美女");
        ctT.put("b04", "老大");
        ctT.put("b05", "哈哈哈");
        ctT.put("b06", "奸笑");
        ctT.put("b07", "傻乐");
        ctT.put("b08", "飞吻");
        ctT.put("b09", "害羞");
        ctT.put("b10", "花痴");
        ctT.put("b11", "憧憬");
        ctT.put("b12", "你牛");
        ctT.put("b13", "鼓掌");
        ctT.put("b14", "可爱");
        ctT.put("b15", "太委屈");
        ctT.put("b16", "大哭");
        ctT.put("b17", "泪奔");
        ctT.put("b18", "寻死");
        ctT.put("b19", "非常惊讶");
        ctT.put("b20", "表示疑问");
        ctT.put("yz_001", "焦糖舞");
        ctT.put("yz_002", "翻滚");
        ctT.put("yz_003", "拍屁股做鬼脸");
        ctT.put("yz_004", "不");
        ctT.put("yz_005", "河蟹掉啦");
        ctT.put("yz_006", "哦耶");
        ctT.put("yz_007", "我倒");
        ctT.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int qq(String str) {
        Integer num = ctQ.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf((int) R.drawable.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int qr(String str) {
        Integer num = ctS.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String qs(String str) {
        return ctT.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int asA() {
        return ctR.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0264a aj(Context context, String str) {
        return null;
    }
}
