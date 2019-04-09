package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> cjr = new HashMap<>(200);
    public static final ArrayList<Integer> cjs = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> cjt = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> cju = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        cju.put("image_emoticon", "呵呵");
        cju.put("image_emoticon2", "哈哈");
        cju.put("image_emoticon3", "吐舌");
        cju.put("image_emoticon4", "啊");
        cju.put("image_emoticon5", "酷");
        cju.put("image_emoticon6", "怒");
        cju.put("image_emoticon7", "开心");
        cju.put("image_emoticon8", "汗");
        cju.put("image_emoticon9", "泪");
        cju.put("image_emoticon10", "黑线");
        cju.put("image_emoticon11", "鄙视");
        cju.put("image_emoticon12", "不高兴");
        cju.put("image_emoticon13", "真棒");
        cju.put("image_emoticon14", "钱");
        cju.put("image_emoticon15", "疑问");
        cju.put("image_emoticon16", "阴险");
        cju.put("image_emoticon17", "吐");
        cju.put("image_emoticon18", "咦");
        cju.put("image_emoticon19", "委屈");
        cju.put("image_emoticon20", "花心");
        cju.put("image_emoticon21", "呼~");
        cju.put("image_emoticon22", "笑眼");
        cju.put("image_emoticon23", "冷");
        cju.put("image_emoticon24", "太开心");
        cju.put("image_emoticon25", "滑稽");
        cju.put("image_emoticon26", "勉强");
        cju.put("image_emoticon27", "狂汗");
        cju.put("image_emoticon28", "乖");
        cju.put("image_emoticon29", "睡觉");
        cju.put("image_emoticon30", "惊哭");
        cju.put("image_emoticon31", "生气");
        cju.put("image_emoticon32", "惊讶");
        cju.put("image_emoticon33", "喷");
        cju.put("image_emoticon34", "爱心");
        cju.put("image_emoticon35", "心碎");
        cju.put("image_emoticon36", "玫瑰");
        cju.put("image_emoticon37", "礼物");
        cju.put("image_emoticon38", "彩虹");
        cju.put("image_emoticon39", "星星月亮");
        cju.put("image_emoticon40", "太阳");
        cju.put("image_emoticon41", "钱币");
        cju.put("image_emoticon42", "灯泡");
        cju.put("image_emoticon43", "茶杯");
        cju.put("image_emoticon44", "蛋糕");
        cju.put("image_emoticon45", "音乐");
        cju.put("image_emoticon46", "haha");
        cju.put("image_emoticon47", "胜利");
        cju.put("image_emoticon48", "大拇指");
        cju.put("image_emoticon49", "弱");
        cju.put("image_emoticon50", "OK");
        cju.put("image_emoticon61", "哼");
        cju.put("image_emoticon62", "吃瓜");
        cju.put("image_emoticon63", "扔便便");
        cju.put("image_emoticon64", "惊恐");
        cju.put("image_emoticon65", "哎呦");
        cju.put("image_emoticon66", "小乖");
        cju.put("image_emoticon67", "捂嘴笑");
        cju.put("image_emoticon68", "你懂的");
        cju.put("image_emoticon69", "what");
        cju.put("image_emoticon70", "酸爽");
        cju.put("image_emoticon71", "呀咩爹");
        cju.put("image_emoticon72", "笑尿");
        cju.put("image_emoticon73", "挖鼻");
        cju.put("image_emoticon74", "犀利");
        cju.put("image_emoticon75", "小红脸");
        cju.put("image_emoticon76", "懒得理");
        cju.put("image_emoticon77", "沙发");
        cju.put("image_emoticon78", "手纸");
        cju.put("image_emoticon79", "香蕉");
        cju.put("image_emoticon80", "便便");
        cju.put("image_emoticon81", "药丸");
        cju.put("image_emoticon82", "红领巾");
        cju.put("image_emoticon83", "蜡烛");
        cju.put("image_emoticon84", "三道杠");
        cju.put("image_emoticon101", "不跟丑人说话");
        cju.put("image_emoticon102", "么么哒");
        cju.put("image_emoticon103", "亲亲才能起来");
        cju.put("image_emoticon104", "伦家只是宝宝");
        cju.put("image_emoticon105", "你是我的人");
        cju.put("image_emoticon106", "假装看不见");
        cju.put("image_emoticon107", "单身等撩");
        cju.put("image_emoticon108", "吓到宝宝了");
        cju.put("image_emoticon109", "哈哈哈");
        cju.put("image_emoticon110", "嗯嗯");
        cju.put("image_emoticon111", "好幸福");
        cju.put("image_emoticon112", "宝宝不开心");
        cju.put("image_emoticon113", "小姐姐别走");
        cju.put("image_emoticon114", "小姐姐在吗");
        cju.put("image_emoticon115", "小姐姐来啦");
        cju.put("image_emoticon116", "小姐姐来玩呀");
        cju.put("image_emoticon117", "我养你");
        cju.put("image_emoticon118", "我是不会骗你的");
        cju.put("image_emoticon119", "扎心了");
        cju.put("image_emoticon120", "无聊");
        cju.put("image_emoticon121", "月亮代表我的心");
        cju.put("image_emoticon122", "来追我呀");
        cju.put("image_emoticon123", "爱你的形状");
        cju.put("image_emoticon124", "白眼");
        cju.put("ali_001", "赖皮");
        cju.put("ali_002", "感动");
        cju.put("ali_003", "十分惊讶");
        cju.put("ali_004", "怒气");
        cju.put("ali_005", "哭泣");
        cju.put("ali_006", "吃惊");
        cju.put("ali_007", "嘲弄");
        cju.put("ali_008", "飘过");
        cju.put("ali_009", "转圈哭");
        cju.put("ali_010", "神经病");
        cju.put("ali_011", "揪耳朵");
        cju.put("ali_012", "惊汗");
        cju.put("ali_013", "隐身");
        cju.put("ali_014", "不要嘛");
        cju.put("ali_015", "遁");
        cju.put("ali_016", "不公平");
        cju.put("ali_017", "爬来了");
        cju.put("ali_018", "蛋花哭");
        cju.put("ali_019", "温暖");
        cju.put("ali_020", "点头");
        cju.put("ali_021", "撒钱");
        cju.put("ali_022", "献花");
        cju.put("ali_023", "寒");
        cju.put("ali_024", "傻笑");
        cju.put("ali_025", "扭扭");
        cju.put("ali_026", "疯");
        cju.put("ali_027", "抓狂");
        cju.put("ali_028", "抓");
        cju.put("ali_029", "蜷");
        cju.put("ali_030", "挠墙");
        cju.put("ali_031", "狂笑");
        cju.put("ali_032", "抱枕");
        cju.put("ali_033", "吼叫");
        cju.put("ali_034", "嚷");
        cju.put("ali_035", "唠叨");
        cju.put("ali_036", "捏脸");
        cju.put("ali_037", "爆笑");
        cju.put("ali_038", "郁闷");
        cju.put("ali_039", "潜水");
        cju.put("ali_040", "十分开心");
        cju.put("ali_041", "冷笑话");
        cju.put("ali_042", "顶！");
        cju.put("ali_043", "潜");
        cju.put("ali_044", "画圈圈");
        cju.put("ali_045", "玩电脑");
        cju.put("ali_046", "狂吐");
        cju.put("ali_047", "哭着跑");
        cju.put("ali_048", "阿狸侠");
        cju.put("ali_049", "冷死了");
        cju.put("ali_050", "惆怅~");
        cju.put("ali_051", "摸头");
        cju.put("ali_052", "蹭");
        cju.put("ali_053", "打滚");
        cju.put("ali_054", "叩拜");
        cju.put("ali_055", "摸");
        cju.put("ali_056", "数钱");
        cju.put("ali_057", "拖走");
        cju.put("ali_058", "热");
        cju.put("ali_059", "加1");
        cju.put("ali_060", "压力");
        cju.put("ali_061", "表逼我");
        cju.put("ali_062", "人呢");
        cju.put("ali_063", "摇晃");
        cju.put("ali_064", "打地鼠");
        cju.put("ali_065", "这个屌");
        cju.put("ali_066", "恐慌");
        cju.put("ali_067", "晕乎乎");
        cju.put("ali_068", "浮云");
        cju.put("ali_069", "给力");
        cju.put("ali_070", "杯具了");
        cju.put("b01", "微笑");
        cju.put("b02", "帅哥");
        cju.put("b03", "美女");
        cju.put("b04", "老大");
        cju.put("b05", "哈哈哈");
        cju.put("b06", "奸笑");
        cju.put("b07", "傻乐");
        cju.put("b08", "飞吻");
        cju.put("b09", "害羞");
        cju.put("b10", "花痴");
        cju.put("b11", "憧憬");
        cju.put("b12", "你牛");
        cju.put("b13", "鼓掌");
        cju.put("b14", "可爱");
        cju.put("b15", "太委屈");
        cju.put("b16", "大哭");
        cju.put("b17", "泪奔");
        cju.put("b18", "寻死");
        cju.put("b19", "非常惊讶");
        cju.put("b20", "表示疑问");
        cju.put("yz_001", "焦糖舞");
        cju.put("yz_002", "翻滚");
        cju.put("yz_003", "拍屁股做鬼脸");
        cju.put("yz_004", "不");
        cju.put("yz_005", "河蟹掉啦");
        cju.put("yz_006", "哦耶");
        cju.put("yz_007", "我倒");
        cju.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int oH(String str) {
        Integer num = cjr.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int oI(String str) {
        Integer num = cjt.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String oJ(String str) {
        return cju.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int amd() {
        return cjs.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0238a aw(Context context, String str) {
        return null;
    }
}
