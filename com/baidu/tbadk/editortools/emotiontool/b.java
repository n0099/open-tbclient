package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.e;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aQn = new HashMap<>(200);
    public static final ArrayList<Integer> aQo = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> aQp = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> aQq = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        aQq.put("image_emoticon", "呵呵");
        aQq.put("image_emoticon2", "哈哈");
        aQq.put("image_emoticon3", "吐舌");
        aQq.put("image_emoticon4", "啊");
        aQq.put("image_emoticon5", "酷");
        aQq.put("image_emoticon6", "怒");
        aQq.put("image_emoticon7", "开心");
        aQq.put("image_emoticon8", "汗");
        aQq.put("image_emoticon9", "泪");
        aQq.put("image_emoticon10", "黑线");
        aQq.put("image_emoticon11", "鄙视");
        aQq.put("image_emoticon12", "不高兴");
        aQq.put("image_emoticon13", "真棒");
        aQq.put("image_emoticon14", "钱");
        aQq.put("image_emoticon15", "疑问");
        aQq.put("image_emoticon16", "阴险");
        aQq.put("image_emoticon17", "吐");
        aQq.put("image_emoticon18", "咦");
        aQq.put("image_emoticon19", "委屈");
        aQq.put("image_emoticon20", "花心");
        aQq.put("image_emoticon21", "呼~");
        aQq.put("image_emoticon22", "笑眼");
        aQq.put("image_emoticon23", "冷");
        aQq.put("image_emoticon24", "太开心");
        aQq.put("image_emoticon25", "滑稽");
        aQq.put("image_emoticon26", "勉强");
        aQq.put("image_emoticon27", "狂汗");
        aQq.put("image_emoticon28", "乖");
        aQq.put("image_emoticon29", "睡觉");
        aQq.put("image_emoticon30", "惊哭");
        aQq.put("image_emoticon31", "生气");
        aQq.put("image_emoticon32", "惊讶");
        aQq.put("image_emoticon33", "喷");
        aQq.put("image_emoticon34", "爱心");
        aQq.put("image_emoticon35", "心碎");
        aQq.put("image_emoticon36", "玫瑰");
        aQq.put("image_emoticon37", "礼物");
        aQq.put("image_emoticon38", "彩虹");
        aQq.put("image_emoticon39", "星星月亮");
        aQq.put("image_emoticon40", "太阳");
        aQq.put("image_emoticon41", "钱币");
        aQq.put("image_emoticon42", "灯泡");
        aQq.put("image_emoticon43", "茶杯");
        aQq.put("image_emoticon44", "蛋糕");
        aQq.put("image_emoticon45", "音乐");
        aQq.put("image_emoticon46", "haha");
        aQq.put("image_emoticon47", "胜利");
        aQq.put("image_emoticon48", "大拇指");
        aQq.put("image_emoticon49", "弱");
        aQq.put("image_emoticon50", "OK");
        aQq.put("image_emoticon61", "哼");
        aQq.put("image_emoticon62", "吃瓜");
        aQq.put("image_emoticon63", "扔便便");
        aQq.put("image_emoticon64", "惊恐");
        aQq.put("image_emoticon65", "哎呦");
        aQq.put("image_emoticon66", "小乖");
        aQq.put("image_emoticon67", "捂嘴笑");
        aQq.put("image_emoticon68", "你懂的");
        aQq.put("image_emoticon69", "what");
        aQq.put("image_emoticon70", "酸爽");
        aQq.put("image_emoticon71", "呀咩爹");
        aQq.put("image_emoticon72", "笑尿");
        aQq.put("image_emoticon73", "挖鼻");
        aQq.put("image_emoticon74", "犀利");
        aQq.put("image_emoticon75", "小红脸");
        aQq.put("image_emoticon76", "懒得理");
        aQq.put("image_emoticon77", "沙发");
        aQq.put("image_emoticon78", "手纸");
        aQq.put("image_emoticon79", "香蕉");
        aQq.put("image_emoticon80", "便便");
        aQq.put("image_emoticon81", "药丸");
        aQq.put("image_emoticon82", "红领巾");
        aQq.put("image_emoticon83", "蜡烛");
        aQq.put("image_emoticon84", "三道杠");
        aQq.put("image_emoticon101", "不跟丑人说话");
        aQq.put("image_emoticon102", "么么哒");
        aQq.put("image_emoticon103", "亲亲才能起来");
        aQq.put("image_emoticon104", "伦家只是宝宝");
        aQq.put("image_emoticon105", "你是我的人");
        aQq.put("image_emoticon106", "假装看不见");
        aQq.put("image_emoticon107", "单身等撩");
        aQq.put("image_emoticon108", "吓到宝宝了");
        aQq.put("image_emoticon109", "哈哈哈");
        aQq.put("image_emoticon110", "嗯嗯");
        aQq.put("image_emoticon111", "好幸福");
        aQq.put("image_emoticon112", "宝宝不开心");
        aQq.put("image_emoticon113", "小姐姐别走");
        aQq.put("image_emoticon114", "小姐姐在吗");
        aQq.put("image_emoticon115", "小姐姐来啦");
        aQq.put("image_emoticon116", "小姐姐来玩呀");
        aQq.put("image_emoticon117", "我养你");
        aQq.put("image_emoticon118", "我是不会骗你的");
        aQq.put("image_emoticon119", "扎心了");
        aQq.put("image_emoticon120", "无聊");
        aQq.put("image_emoticon121", "月亮代表我的心");
        aQq.put("image_emoticon122", "来追我呀");
        aQq.put("image_emoticon123", "爱你的形状");
        aQq.put("image_emoticon124", "白眼");
        aQq.put("ali_001", "赖皮");
        aQq.put("ali_002", "感动");
        aQq.put("ali_003", "十分惊讶");
        aQq.put("ali_004", "怒气");
        aQq.put("ali_005", "哭泣");
        aQq.put("ali_006", "吃惊");
        aQq.put("ali_007", "嘲弄");
        aQq.put("ali_008", "飘过");
        aQq.put("ali_009", "转圈哭");
        aQq.put("ali_010", "神经病");
        aQq.put("ali_011", "揪耳朵");
        aQq.put("ali_012", "惊汗");
        aQq.put("ali_013", "隐身");
        aQq.put("ali_014", "不要嘛");
        aQq.put("ali_015", "遁");
        aQq.put("ali_016", "不公平");
        aQq.put("ali_017", "爬来了");
        aQq.put("ali_018", "蛋花哭");
        aQq.put("ali_019", "温暖");
        aQq.put("ali_020", "点头");
        aQq.put("ali_021", "撒钱");
        aQq.put("ali_022", "献花");
        aQq.put("ali_023", "寒");
        aQq.put("ali_024", "傻笑");
        aQq.put("ali_025", "扭扭");
        aQq.put("ali_026", "疯");
        aQq.put("ali_027", "抓狂");
        aQq.put("ali_028", "抓");
        aQq.put("ali_029", "蜷");
        aQq.put("ali_030", "挠墙");
        aQq.put("ali_031", "狂笑");
        aQq.put("ali_032", "抱枕");
        aQq.put("ali_033", "吼叫");
        aQq.put("ali_034", "嚷");
        aQq.put("ali_035", "唠叨");
        aQq.put("ali_036", "捏脸");
        aQq.put("ali_037", "爆笑");
        aQq.put("ali_038", "郁闷");
        aQq.put("ali_039", "潜水");
        aQq.put("ali_040", "十分开心");
        aQq.put("ali_041", "冷笑话");
        aQq.put("ali_042", "顶！");
        aQq.put("ali_043", "潜");
        aQq.put("ali_044", "画圈圈");
        aQq.put("ali_045", "玩电脑");
        aQq.put("ali_046", "狂吐");
        aQq.put("ali_047", "哭着跑");
        aQq.put("ali_048", "阿狸侠");
        aQq.put("ali_049", "冷死了");
        aQq.put("ali_050", "惆怅~");
        aQq.put("ali_051", "摸头");
        aQq.put("ali_052", "蹭");
        aQq.put("ali_053", "打滚");
        aQq.put("ali_054", "叩拜");
        aQq.put("ali_055", "摸");
        aQq.put("ali_056", "数钱");
        aQq.put("ali_057", "拖走");
        aQq.put("ali_058", "热");
        aQq.put("ali_059", "加1");
        aQq.put("ali_060", "压力");
        aQq.put("ali_061", "表逼我");
        aQq.put("ali_062", "人呢");
        aQq.put("ali_063", "摇晃");
        aQq.put("ali_064", "打地鼠");
        aQq.put("ali_065", "这个屌");
        aQq.put("ali_066", "恐慌");
        aQq.put("ali_067", "晕乎乎");
        aQq.put("ali_068", "浮云");
        aQq.put("ali_069", "给力");
        aQq.put("ali_070", "杯具了");
        aQq.put("b01", "微笑");
        aQq.put("b02", "帅哥");
        aQq.put("b03", "美女");
        aQq.put("b04", "老大");
        aQq.put("b05", "哈哈哈");
        aQq.put("b06", "奸笑");
        aQq.put("b07", "傻乐");
        aQq.put("b08", "飞吻");
        aQq.put("b09", "害羞");
        aQq.put("b10", "花痴");
        aQq.put("b11", "憧憬");
        aQq.put("b12", "你牛");
        aQq.put("b13", "鼓掌");
        aQq.put("b14", "可爱");
        aQq.put("b15", "太委屈");
        aQq.put("b16", "大哭");
        aQq.put("b17", "泪奔");
        aQq.put("b18", "寻死");
        aQq.put("b19", "非常惊讶");
        aQq.put("b20", "表示疑问");
        aQq.put("yz_001", "焦糖舞");
        aQq.put("yz_002", "翻滚");
        aQq.put("yz_003", "拍屁股做鬼脸");
        aQq.put("yz_004", "不");
        aQq.put("yz_005", "河蟹掉啦");
        aQq.put("yz_006", "哦耶");
        aQq.put("yz_007", "我倒");
        aQq.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gW(String str) {
        Integer num = aQn.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(e.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int gX(String str) {
        Integer num = aQp.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String gY(String str) {
        return aQq.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int IW() {
        return aQo.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0113a ak(Context context, String str) {
        return null;
    }
}
