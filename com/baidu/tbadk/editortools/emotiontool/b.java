package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> cjo = new HashMap<>(200);
    public static final ArrayList<Integer> cjp = new ArrayList<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    public static final HashMap<String, Integer> cjq = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);
    private static final HashMap<String, String> cjr = new HashMap<>((int) SubsamplingScaleImageView.ORIENTATION_180);

    static {
        cjr.put("image_emoticon", "呵呵");
        cjr.put("image_emoticon2", "哈哈");
        cjr.put("image_emoticon3", "吐舌");
        cjr.put("image_emoticon4", "啊");
        cjr.put("image_emoticon5", "酷");
        cjr.put("image_emoticon6", "怒");
        cjr.put("image_emoticon7", "开心");
        cjr.put("image_emoticon8", "汗");
        cjr.put("image_emoticon9", "泪");
        cjr.put("image_emoticon10", "黑线");
        cjr.put("image_emoticon11", "鄙视");
        cjr.put("image_emoticon12", "不高兴");
        cjr.put("image_emoticon13", "真棒");
        cjr.put("image_emoticon14", "钱");
        cjr.put("image_emoticon15", "疑问");
        cjr.put("image_emoticon16", "阴险");
        cjr.put("image_emoticon17", "吐");
        cjr.put("image_emoticon18", "咦");
        cjr.put("image_emoticon19", "委屈");
        cjr.put("image_emoticon20", "花心");
        cjr.put("image_emoticon21", "呼~");
        cjr.put("image_emoticon22", "笑眼");
        cjr.put("image_emoticon23", "冷");
        cjr.put("image_emoticon24", "太开心");
        cjr.put("image_emoticon25", "滑稽");
        cjr.put("image_emoticon26", "勉强");
        cjr.put("image_emoticon27", "狂汗");
        cjr.put("image_emoticon28", "乖");
        cjr.put("image_emoticon29", "睡觉");
        cjr.put("image_emoticon30", "惊哭");
        cjr.put("image_emoticon31", "生气");
        cjr.put("image_emoticon32", "惊讶");
        cjr.put("image_emoticon33", "喷");
        cjr.put("image_emoticon34", "爱心");
        cjr.put("image_emoticon35", "心碎");
        cjr.put("image_emoticon36", "玫瑰");
        cjr.put("image_emoticon37", "礼物");
        cjr.put("image_emoticon38", "彩虹");
        cjr.put("image_emoticon39", "星星月亮");
        cjr.put("image_emoticon40", "太阳");
        cjr.put("image_emoticon41", "钱币");
        cjr.put("image_emoticon42", "灯泡");
        cjr.put("image_emoticon43", "茶杯");
        cjr.put("image_emoticon44", "蛋糕");
        cjr.put("image_emoticon45", "音乐");
        cjr.put("image_emoticon46", "haha");
        cjr.put("image_emoticon47", "胜利");
        cjr.put("image_emoticon48", "大拇指");
        cjr.put("image_emoticon49", "弱");
        cjr.put("image_emoticon50", "OK");
        cjr.put("image_emoticon61", "哼");
        cjr.put("image_emoticon62", "吃瓜");
        cjr.put("image_emoticon63", "扔便便");
        cjr.put("image_emoticon64", "惊恐");
        cjr.put("image_emoticon65", "哎呦");
        cjr.put("image_emoticon66", "小乖");
        cjr.put("image_emoticon67", "捂嘴笑");
        cjr.put("image_emoticon68", "你懂的");
        cjr.put("image_emoticon69", "what");
        cjr.put("image_emoticon70", "酸爽");
        cjr.put("image_emoticon71", "呀咩爹");
        cjr.put("image_emoticon72", "笑尿");
        cjr.put("image_emoticon73", "挖鼻");
        cjr.put("image_emoticon74", "犀利");
        cjr.put("image_emoticon75", "小红脸");
        cjr.put("image_emoticon76", "懒得理");
        cjr.put("image_emoticon77", "沙发");
        cjr.put("image_emoticon78", "手纸");
        cjr.put("image_emoticon79", "香蕉");
        cjr.put("image_emoticon80", "便便");
        cjr.put("image_emoticon81", "药丸");
        cjr.put("image_emoticon82", "红领巾");
        cjr.put("image_emoticon83", "蜡烛");
        cjr.put("image_emoticon84", "三道杠");
        cjr.put("image_emoticon101", "不跟丑人说话");
        cjr.put("image_emoticon102", "么么哒");
        cjr.put("image_emoticon103", "亲亲才能起来");
        cjr.put("image_emoticon104", "伦家只是宝宝");
        cjr.put("image_emoticon105", "你是我的人");
        cjr.put("image_emoticon106", "假装看不见");
        cjr.put("image_emoticon107", "单身等撩");
        cjr.put("image_emoticon108", "吓到宝宝了");
        cjr.put("image_emoticon109", "哈哈哈");
        cjr.put("image_emoticon110", "嗯嗯");
        cjr.put("image_emoticon111", "好幸福");
        cjr.put("image_emoticon112", "宝宝不开心");
        cjr.put("image_emoticon113", "小姐姐别走");
        cjr.put("image_emoticon114", "小姐姐在吗");
        cjr.put("image_emoticon115", "小姐姐来啦");
        cjr.put("image_emoticon116", "小姐姐来玩呀");
        cjr.put("image_emoticon117", "我养你");
        cjr.put("image_emoticon118", "我是不会骗你的");
        cjr.put("image_emoticon119", "扎心了");
        cjr.put("image_emoticon120", "无聊");
        cjr.put("image_emoticon121", "月亮代表我的心");
        cjr.put("image_emoticon122", "来追我呀");
        cjr.put("image_emoticon123", "爱你的形状");
        cjr.put("image_emoticon124", "白眼");
        cjr.put("ali_001", "赖皮");
        cjr.put("ali_002", "感动");
        cjr.put("ali_003", "十分惊讶");
        cjr.put("ali_004", "怒气");
        cjr.put("ali_005", "哭泣");
        cjr.put("ali_006", "吃惊");
        cjr.put("ali_007", "嘲弄");
        cjr.put("ali_008", "飘过");
        cjr.put("ali_009", "转圈哭");
        cjr.put("ali_010", "神经病");
        cjr.put("ali_011", "揪耳朵");
        cjr.put("ali_012", "惊汗");
        cjr.put("ali_013", "隐身");
        cjr.put("ali_014", "不要嘛");
        cjr.put("ali_015", "遁");
        cjr.put("ali_016", "不公平");
        cjr.put("ali_017", "爬来了");
        cjr.put("ali_018", "蛋花哭");
        cjr.put("ali_019", "温暖");
        cjr.put("ali_020", "点头");
        cjr.put("ali_021", "撒钱");
        cjr.put("ali_022", "献花");
        cjr.put("ali_023", "寒");
        cjr.put("ali_024", "傻笑");
        cjr.put("ali_025", "扭扭");
        cjr.put("ali_026", "疯");
        cjr.put("ali_027", "抓狂");
        cjr.put("ali_028", "抓");
        cjr.put("ali_029", "蜷");
        cjr.put("ali_030", "挠墙");
        cjr.put("ali_031", "狂笑");
        cjr.put("ali_032", "抱枕");
        cjr.put("ali_033", "吼叫");
        cjr.put("ali_034", "嚷");
        cjr.put("ali_035", "唠叨");
        cjr.put("ali_036", "捏脸");
        cjr.put("ali_037", "爆笑");
        cjr.put("ali_038", "郁闷");
        cjr.put("ali_039", "潜水");
        cjr.put("ali_040", "十分开心");
        cjr.put("ali_041", "冷笑话");
        cjr.put("ali_042", "顶！");
        cjr.put("ali_043", "潜");
        cjr.put("ali_044", "画圈圈");
        cjr.put("ali_045", "玩电脑");
        cjr.put("ali_046", "狂吐");
        cjr.put("ali_047", "哭着跑");
        cjr.put("ali_048", "阿狸侠");
        cjr.put("ali_049", "冷死了");
        cjr.put("ali_050", "惆怅~");
        cjr.put("ali_051", "摸头");
        cjr.put("ali_052", "蹭");
        cjr.put("ali_053", "打滚");
        cjr.put("ali_054", "叩拜");
        cjr.put("ali_055", "摸");
        cjr.put("ali_056", "数钱");
        cjr.put("ali_057", "拖走");
        cjr.put("ali_058", "热");
        cjr.put("ali_059", "加1");
        cjr.put("ali_060", "压力");
        cjr.put("ali_061", "表逼我");
        cjr.put("ali_062", "人呢");
        cjr.put("ali_063", "摇晃");
        cjr.put("ali_064", "打地鼠");
        cjr.put("ali_065", "这个屌");
        cjr.put("ali_066", "恐慌");
        cjr.put("ali_067", "晕乎乎");
        cjr.put("ali_068", "浮云");
        cjr.put("ali_069", "给力");
        cjr.put("ali_070", "杯具了");
        cjr.put("b01", "微笑");
        cjr.put("b02", "帅哥");
        cjr.put("b03", "美女");
        cjr.put("b04", "老大");
        cjr.put("b05", "哈哈哈");
        cjr.put("b06", "奸笑");
        cjr.put("b07", "傻乐");
        cjr.put("b08", "飞吻");
        cjr.put("b09", "害羞");
        cjr.put("b10", "花痴");
        cjr.put("b11", "憧憬");
        cjr.put("b12", "你牛");
        cjr.put("b13", "鼓掌");
        cjr.put("b14", "可爱");
        cjr.put("b15", "太委屈");
        cjr.put("b16", "大哭");
        cjr.put("b17", "泪奔");
        cjr.put("b18", "寻死");
        cjr.put("b19", "非常惊讶");
        cjr.put("b20", "表示疑问");
        cjr.put("yz_001", "焦糖舞");
        cjr.put("yz_002", "翻滚");
        cjr.put("yz_003", "拍屁股做鬼脸");
        cjr.put("yz_004", "不");
        cjr.put("yz_005", "河蟹掉啦");
        cjr.put("yz_006", "哦耶");
        cjr.put("yz_007", "我倒");
        cjr.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int oG(String str) {
        Integer num = cjo.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(d.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int oH(String str) {
        Integer num = cjq.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String oI(String str) {
        return cjr.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int amg() {
        return cjp.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0238a aw(Context context, String str) {
        return null;
    }
}
