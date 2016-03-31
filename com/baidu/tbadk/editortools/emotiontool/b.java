package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.a {
    protected static final HashMap<String, Integer> aus = new HashMap<>();
    public static final ArrayList<Integer> aut = new ArrayList<>();
    public static final HashMap<String, Integer> auu = new HashMap<>();
    private static final HashMap<String, String> auv = new HashMap<>();

    static {
        auv.put("image_emoticon", "呵呵");
        auv.put("image_emoticon2", "哈哈");
        auv.put("image_emoticon3", "吐舌");
        auv.put("image_emoticon4", "啊");
        auv.put("image_emoticon5", "酷");
        auv.put("image_emoticon6", "怒");
        auv.put("image_emoticon7", "开心");
        auv.put("image_emoticon8", "汗");
        auv.put("image_emoticon9", "泪");
        auv.put("image_emoticon10", "黑线");
        auv.put("image_emoticon11", "鄙视");
        auv.put("image_emoticon12", "不高兴");
        auv.put("image_emoticon13", "真棒");
        auv.put("image_emoticon14", "钱");
        auv.put("image_emoticon15", "疑问");
        auv.put("image_emoticon16", "阴险");
        auv.put("image_emoticon17", "吐");
        auv.put("image_emoticon18", "咦");
        auv.put("image_emoticon19", "委屈");
        auv.put("image_emoticon20", "花心");
        auv.put("image_emoticon21", "呼~");
        auv.put("image_emoticon22", "笑眼");
        auv.put("image_emoticon23", "冷");
        auv.put("image_emoticon24", "太开心");
        auv.put("image_emoticon25", "滑稽");
        auv.put("image_emoticon26", "勉强");
        auv.put("image_emoticon27", "狂汗");
        auv.put("image_emoticon28", "乖");
        auv.put("image_emoticon29", "睡觉");
        auv.put("image_emoticon30", "惊哭");
        auv.put("image_emoticon31", "生气");
        auv.put("image_emoticon32", "惊讶");
        auv.put("image_emoticon33", "喷");
        auv.put("image_emoticon34", "爱心");
        auv.put("image_emoticon35", "心碎");
        auv.put("image_emoticon36", "玫瑰");
        auv.put("image_emoticon37", "礼物");
        auv.put("image_emoticon38", "彩虹");
        auv.put("image_emoticon39", "星星月亮");
        auv.put("image_emoticon40", "太阳");
        auv.put("image_emoticon41", "钱币");
        auv.put("image_emoticon42", "灯泡");
        auv.put("image_emoticon43", "茶杯");
        auv.put("image_emoticon44", "蛋糕");
        auv.put("image_emoticon45", "音乐");
        auv.put("image_emoticon46", "haha");
        auv.put("image_emoticon47", "胜利");
        auv.put("image_emoticon48", "大拇指");
        auv.put("image_emoticon49", "弱");
        auv.put("image_emoticon50", "OK");
        auv.put("image_emoticon61", "哼");
        auv.put("ali_001", "赖皮");
        auv.put("ali_002", "感动");
        auv.put("ali_003", "十分惊讶");
        auv.put("ali_004", "怒气");
        auv.put("ali_005", "哭泣");
        auv.put("ali_006", "吃惊");
        auv.put("ali_007", "嘲弄");
        auv.put("ali_008", "飘过");
        auv.put("ali_009", "转圈哭");
        auv.put("ali_010", "神经病");
        auv.put("ali_011", "揪耳朵");
        auv.put("ali_012", "惊汗");
        auv.put("ali_013", "隐身");
        auv.put("ali_014", "不要嘛");
        auv.put("ali_015", "遁");
        auv.put("ali_016", "不公平");
        auv.put("ali_017", "爬来了");
        auv.put("ali_018", "蛋花哭");
        auv.put("ali_019", "温暖");
        auv.put("ali_020", "点头");
        auv.put("ali_021", "撒钱");
        auv.put("ali_022", "献花");
        auv.put("ali_023", "寒");
        auv.put("ali_024", "傻笑");
        auv.put("ali_025", "扭扭");
        auv.put("ali_026", "疯");
        auv.put("ali_027", "抓狂");
        auv.put("ali_028", "抓");
        auv.put("ali_029", "蜷");
        auv.put("ali_030", "挠墙");
        auv.put("ali_031", "狂笑");
        auv.put("ali_032", "抱枕");
        auv.put("ali_033", "吼叫");
        auv.put("ali_034", "嚷");
        auv.put("ali_035", "唠叨");
        auv.put("ali_036", "捏脸");
        auv.put("ali_037", "爆笑");
        auv.put("ali_038", "郁闷");
        auv.put("ali_039", "潜水");
        auv.put("ali_040", "十分开心");
        auv.put("ali_041", "冷笑话");
        auv.put("ali_042", "顶！");
        auv.put("ali_043", "潜");
        auv.put("ali_044", "画圈圈");
        auv.put("ali_045", "玩电脑");
        auv.put("ali_046", "狂吐");
        auv.put("ali_047", "哭着跑");
        auv.put("ali_048", "阿狸侠");
        auv.put("ali_049", "冷死了");
        auv.put("ali_050", "惆怅~");
        auv.put("ali_051", "摸头");
        auv.put("ali_052", "蹭");
        auv.put("ali_053", "打滚");
        auv.put("ali_054", "叩拜");
        auv.put("ali_055", "摸");
        auv.put("ali_056", "数钱");
        auv.put("ali_057", "拖走");
        auv.put("ali_058", "热");
        auv.put("ali_059", "加1");
        auv.put("ali_060", "压力");
        auv.put("ali_061", "表逼我");
        auv.put("ali_062", "人呢");
        auv.put("ali_063", "摇晃");
        auv.put("ali_064", "打地鼠");
        auv.put("ali_065", "这个屌");
        auv.put("ali_066", "恐慌");
        auv.put("ali_067", "晕乎乎");
        auv.put("ali_068", "浮云");
        auv.put("ali_069", "给力");
        auv.put("ali_070", "杯具了");
        auv.put("b01", "微笑");
        auv.put("b02", "帅哥");
        auv.put("b03", "美女");
        auv.put("b04", "老大");
        auv.put("b05", "哈哈哈");
        auv.put("b06", "奸笑");
        auv.put("b07", "傻乐");
        auv.put("b08", "飞吻");
        auv.put("b09", "害羞");
        auv.put("b10", "花痴");
        auv.put("b11", "憧憬");
        auv.put("b12", "你牛");
        auv.put("b13", "鼓掌");
        auv.put("b14", "可爱");
        auv.put("b15", "太委屈");
        auv.put("b16", "大哭");
        auv.put("b17", "泪奔");
        auv.put("b18", "寻死");
        auv.put("b19", "非常惊讶");
        auv.put("b20", "表示疑问");
        auv.put("yz_001", "焦糖舞");
        auv.put("yz_002", "翻滚");
        auv.put("yz_003", "拍屁股做鬼脸");
        auv.put("yz_004", "不");
        auv.put("yz_005", "河蟹掉啦");
        auv.put("yz_006", "哦耶");
        auv.put("yz_007", "我倒");
        auv.put("yz_008", "投降");
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fl(String str) {
        Integer num = aus.get(str);
        if ("video_icon".equals(str)) {
            return Integer.valueOf(t.f.ico_link_video).intValue();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int fm(String str) {
        Integer num = auu.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.imageManager.a
    public String fn(String str) {
        return auv.get(str);
    }

    @Override // com.baidu.tbadk.imageManager.a
    public int Dz() {
        return aut.size();
    }

    @Override // com.baidu.tbadk.imageManager.a
    public a.C0052a w(Context context, String str) {
        return null;
    }
}
