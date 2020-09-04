package com.baidu.tbadk.widget.timepicker.a.e;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class a {
    private static final long[] fhZ = {19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42416, 83315, 21168, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448, 84835, 37744, 18936, 18800, 25776, 92326, 59984, 27424, 108228, 43744, 41696, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 84821, 19296, 42352, 21732, 53600, 59752, 54560, 55968, 92838, 22224, 19168, 43476, 41680, 53584, 62034, 54560};
    private static final String[] fia = {"", "正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬", "腊"};
    private static final String[] fib = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    private static final String[] fic = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    private static final String[] fie = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};
    private static SimpleDateFormat fif = new SimpleDateFormat("yyyy年M月d日 EEEEE");

    public static final int rD(int i) {
        if (rE(i) != 0) {
            if ((fhZ[i - 1900] & 65536) != 0) {
                return 30;
            }
            return 29;
        }
        return 0;
    }

    public static final int rE(int i) {
        return (int) (fhZ[i - 1900] & 15);
    }

    public static final int bu(int i, int i2) {
        return (fhZ[i + (-1900)] & ((long) (65536 >> i2))) == 0 ? 29 : 30;
    }

    public static final String rF(int i) {
        String str = "";
        if (i == 10) {
            return "初十";
        }
        if (i == 20) {
            return "二十";
        }
        if (i == 30) {
            return "三十";
        }
        int i2 = i / 10;
        if (i2 == 0) {
            str = "初";
        }
        if (i2 == 1) {
            str = "十";
        }
        if (i2 == 2) {
            str = "廿";
        }
        if (i2 == 3) {
            str = "三";
        }
        switch (i % 10) {
            case 1:
                return str + "一";
            case 2:
                return str + "二";
            case 3:
                return str + "三";
            case 4:
                return str + "四";
            case 5:
                return str + "五";
            case 6:
                return str + "六";
            case 7:
                return str + "七";
            case 8:
                return str + "八";
            case 9:
                return str + "九";
            default:
                return str;
        }
    }

    public static String rG(int i) {
        return fib[(i - 4) % 10] + fic[(i - 4) % 12] + "年";
    }

    public static ArrayList<String> bv(int i, int i2) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (i < i2) {
            arrayList.add(String.format("%s(%d)", rG(i), Integer.valueOf(i)));
            i++;
        }
        return arrayList;
    }

    public static ArrayList<String> rH(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 1; i2 < fia.length; i2++) {
            arrayList.add(fia[i2] + "月");
        }
        if (rE(i) != 0) {
            arrayList.add(rE(i), "闰" + fia[rE(i)] + "月");
        }
        return arrayList;
    }

    public static ArrayList<String> rI(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 1; i2 <= i; i2++) {
            arrayList.add(rF(i2));
        }
        return arrayList;
    }
}
