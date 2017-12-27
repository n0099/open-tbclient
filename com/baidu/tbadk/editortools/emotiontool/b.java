package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> bqK = new HashMap<>(200);
    public static final ArrayList<Integer> bqL = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> bqM = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> bqN = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        bqN.put("image_emoticon", "呵呵");
        bqN.put("image_emoticon2", "哈哈");
        bqN.put("image_emoticon3", "吐舌");
        bqN.put("image_emoticon4", "啊");
        bqN.put("image_emoticon5", "酷");
        bqN.put("image_emoticon6", "怒");
        bqN.put("image_emoticon7", "开心");
        bqN.put("image_emoticon8", "汗");
        bqN.put("image_emoticon9", "泪");
        bqN.put("image_emoticon10", "黑线");
        bqN.put("image_emoticon11", "鄙视");
        bqN.put("image_emoticon12", "不高兴");
        bqN.put("image_emoticon13", "真棒");
        bqN.put("image_emoticon14", "钱");
        bqN.put("image_emoticon15", "疑问");
        bqN.put("image_emoticon16", "阴险");
        bqN.put("image_emoticon17", "吐");
        bqN.put("image_emoticon18", "咦");
        bqN.put("image_emoticon19", "委屈");
        bqN.put("image_emoticon20", "花心");
        bqN.put("image_emoticon21", "呼~");
        bqN.put("image_emoticon22", "笑眼");
        bqN.put("image_emoticon23", "冷");
        bqN.put("image_emoticon24", "太开心");
        bqN.put("image_emoticon25", "滑稽");
        bqN.put("image_emoticon26", "勉强");
        bqN.put("image_emoticon27", "狂汗");
        bqN.put("image_emoticon28", "乖");
        bqN.put("image_emoticon29", "睡觉");
        bqN.put("image_emoticon30", "惊哭");
        bqN.put("image_emoticon31", "生气");
        bqN.put("image_emoticon32", "惊讶");
        bqN.put("image_emoticon33", "喷");
        bqN.put("image_emoticon34", "爱心");
        bqN.put("image_emoticon35", "心碎");
        bqN.put("image_emoticon36", "玫瑰");
        bqN.put("image_emoticon37", "礼物");
        bqN.put("image_emoticon38", "彩虹");
        bqN.put("image_emoticon39", "星星月亮");
        bqN.put("image_emoticon40", "太阳");
        bqN.put("image_emoticon41", "钱币");
        bqN.put("image_emoticon42", "灯泡");
        bqN.put("image_emoticon43", "茶杯");
        bqN.put("image_emoticon44", "蛋糕");
        bqN.put("image_emoticon45", "音乐");
        bqN.put("image_emoticon46", "haha");
        bqN.put("image_emoticon47", "胜利");
        bqN.put("image_emoticon48", "大拇指");
        bqN.put("image_emoticon49", "弱");
        bqN.put("image_emoticon50", "OK");
        bqN.put("image_emoticon61", "哼");
        bqN.put("image_emoticon62", "吃瓜");
        bqN.put("image_emoticon63", "扔便便");
        bqN.put("image_emoticon64", "惊恐");
        bqN.put("image_emoticon65", "哎呦");
        bqN.put("image_emoticon66", "小乖");
        bqN.put("image_emoticon67", "捂嘴笑");
        bqN.put("image_emoticon68", "你懂的");
        bqN.put("image_emoticon69", "what");
        bqN.put("image_emoticon70", "酸爽");
        bqN.put("image_emoticon71", "呀咩爹");
        bqN.put("image_emoticon72", "笑尿");
        bqN.put("image_emoticon73", "挖鼻");
        bqN.put("image_emoticon74", "犀利");
        bqN.put("image_emoticon75", "小红脸");
        bqN.put("image_emoticon76", "懒得理");
        bqN.put("image_emoticon77", "沙发");
        bqN.put("image_emoticon78", "手纸");
        bqN.put("image_emoticon79", "香蕉");
        bqN.put("image_emoticon80", "便便");
        bqN.put("image_emoticon81", "药丸");
        bqN.put("image_emoticon82", "红领巾");
        bqN.put("image_emoticon83", "蜡烛");
        bqN.put("image_emoticon84", "三道杠");
        bqN.put("image_emoticon101", "不跟丑人说话");
        bqN.put("image_emoticon102", "么么哒");
        bqN.put("image_emoticon103", "亲亲才能起来");
        bqN.put("image_emoticon104", "伦家只是宝宝");
        bqN.put("image_emoticon105", "你是我的人");
        bqN.put("image_emoticon106", "假装看不见");
        bqN.put("image_emoticon107", "单身等撩");
        bqN.put("image_emoticon108", "吓到宝宝了");
        bqN.put("image_emoticon109", "哈哈哈");
        bqN.put("image_emoticon110", "嗯嗯");
        bqN.put("image_emoticon111", "好幸福");
        bqN.put("image_emoticon112", "宝宝不开心");
        bqN.put("image_emoticon113", "小姐姐别走");
        bqN.put("image_emoticon114", "小姐姐在吗");
        bqN.put("image_emoticon115", "小姐姐来啦");
        bqN.put("image_emoticon116", "小姐姐来玩呀");
        bqN.put("image_emoticon117", "我养你");
        bqN.put("image_emoticon118", "我是不会骗你的");
        bqN.put("image_emoticon119", "扎心了");
        bqN.put("image_emoticon120", "无聊");
        bqN.put("image_emoticon121", "月亮代表我的心");
        bqN.put("image_emoticon122", "来追我呀");
        bqN.put("image_emoticon123", "爱你的形状");
        bqN.put("image_emoticon124", "白眼");
        bqN.put("ali_001", "赖皮");
        bqN.put("ali_002", "感动");
        bqN.put("ali_003", "十分惊讶");
        bqN.put("ali_004", "怒气");
        bqN.put("ali_005", "哭泣");
        bqN.put("ali_006", "吃惊");
        bqN.put("ali_007", "嘲弄");
        bqN.put("ali_008", "飘过");
        bqN.put("ali_009", "转圈哭");
        bqN.put("ali_010", "神经病");
        bqN.put("ali_011", "揪耳朵");
        bqN.put("ali_012", "惊汗");
        bqN.put("ali_013", "隐身");
        bqN.put("ali_014", "不要嘛");
        bqN.put("ali_015", "遁");
        bqN.put("ali_016", "不公平");
        bqN.put("ali_017", "爬来了");
        bqN.put("ali_018", "蛋花哭");
        bqN.put("ali_019", "温暖");
        bqN.put("ali_020", "点头");
        bqN.put("ali_021", "撒钱");
        bqN.put("ali_022", "献花");
        bqN.put("ali_023", "寒");
        bqN.put("ali_024", "傻笑");
        bqN.put("ali_025", "扭扭");
        bqN.put("ali_026", "疯");
        bqN.put("ali_027", "抓狂");
        bqN.put("ali_028", "抓");
        bqN.put("ali_029", "蜷");
        bqN.put("ali_030", "挠墙");
        bqN.put("ali_031", "狂笑");
        bqN.put("ali_032", "抱枕");
        bqN.put("ali_033", "吼叫");
        bqN.put("ali_034", "嚷");
        bqN.put("ali_035", "唠叨");
        bqN.put("ali_036", "捏脸");
        bqN.put("ali_037", "爆笑");
        bqN.put("ali_038", "郁闷");
        bqN.put("ali_039", "潜水");
        bqN.put("ali_040", "十分开心");
        bqN.put("ali_041", "冷笑话");
        bqN.put("ali_042", "顶！");
        bqN.put("ali_043", "潜");
        bqN.put("ali_044", "画圈圈");
        bqN.put("ali_045", "玩电脑");
        bqN.put("ali_046", "狂吐");
        bqN.put("ali_047", "哭着跑");
        bqN.put("ali_048", "阿狸侠");
        bqN.put("ali_049", "冷死了");
        bqN.put("ali_050", "惆怅~");
        bqN.put("ali_051", "摸头");
        bqN.put("ali_052", "蹭");
        bqN.put("ali_053", "打滚");
        bqN.put("ali_054", "叩拜");
        bqN.put("ali_055", "摸");
        bqN.put("ali_056", "数钱");
        bqN.put("ali_057", "拖走");
        bqN.put("ali_058", "热");
        bqN.put("ali_059", "加1");
        bqN.put("ali_060", "压力");
        bqN.put("ali_061", "表逼我");
        bqN.put("ali_062", "人呢");
        bqN.put("ali_063", "摇晃");
        bqN.put("ali_064", "打地鼠");
        bqN.put("ali_065", "这个屌");
        bqN.put("ali_066", "恐慌");
        bqN.put("ali_067", "晕乎乎");
        bqN.put("ali_068", "浮云");
        bqN.put("ali_069", "给力");
        bqN.put("ali_070", "杯具了");
        bqN.put("b01", "微笑");
        bqN.put("b02", "帅哥");
        bqN.put("b03", "美女");
        bqN.put("b04", "老大");
        bqN.put("b05", "哈哈哈");
        bqN.put("b06", "奸笑");
        bqN.put("b07", "傻乐");
        bqN.put("b08", "飞吻");
        bqN.put("b09", "害羞");
        bqN.put("b10", "花痴");
        bqN.put("b11", "憧憬");
        bqN.put("b12", "你牛");
        bqN.put("b13", "鼓掌");
        bqN.put("b14", "可爱");
        bqN.put("b15", "太委屈");
        bqN.put("b16", "大哭");
        bqN.put("b17", "泪奔");
        bqN.put("b18", "寻死");
        bqN.put("b19", "非常惊讶");
        bqN.put("b20", "表示疑问");
        bqN.put("yz_001", "焦糖舞");
        bqN.put("yz_002", "翻滚");
        bqN.put("yz_003", "拍屁股做鬼脸");
        bqN.put("yz_004", "不");
        bqN.put("yz_005", "河蟹掉啦");
        bqN.put("yz_006", "哦耶");
        bqN.put("yz_007", "我倒");
        bqN.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fS(String str) {
        Integer num = bqK.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fT(String str) {
        Integer num = bqM.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fU(String str) {
        return bqN.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int KS() {
        return bqL.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0085a V(Context context, String str) {
        return null;
    }
}
