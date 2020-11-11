package com.baidu.tbadk.util;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class af {
    public static TextView fzf;

    public static int getCharLength(char c) {
        if (isCharacter(c)) {
            return 1;
        }
        return 2;
    }

    public static boolean isCharacter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == ' ');
    }

    public static int getTextLength(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (isCharacter(str.charAt(i2))) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    public static int getTextLengthWithEmoji(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int codePointCount = str.codePointCount(0, str.length());
        int i = 0;
        for (int i2 = 1; i2 <= codePointCount; i2++) {
            String substring = str.substring(str.offsetByCodePoints(0, i2 - 1), str.offsetByCodePoints(0, i2));
            if (substring.length() >= 2) {
                i += 2;
            } else {
                i += getTextLength(substring);
            }
        }
        return i;
    }

    public static int getTextLengthAllOne(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int codePointCount = str.codePointCount(0, str.length());
        int i = 0;
        for (int i2 = 1; i2 <= codePointCount; i2++) {
            if (str.substring(str.offsetByCodePoints(0, i2 - 1), str.offsetByCodePoints(0, i2)).length() >= 2) {
            }
            i++;
        }
        return i;
    }

    public static String subStringWithAllOne(String str, int i) {
        int codePointCount = str.codePointCount(0, str.length());
        int i2 = 1;
        String str2 = str;
        while (i2 <= codePointCount) {
            String substring = str.substring(0, str.offsetByCodePoints(0, i2));
            if (getTextLengthAllOne(substring) > i) {
                break;
            }
            i2++;
            str2 = substring;
        }
        return str2;
    }

    public static String interceptString(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (getTextLength(str) > i) {
            return subString(str, 0, i - 2) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public static String subString(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str) || i > i2) {
            return sb.toString();
        }
        if (i >= 0 && i2 >= 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                char charAt = str.charAt(i4);
                if (i3 >= i2) {
                    if (i3 == i2) {
                        if (d(sb.charAt(sb.length() - 1))) {
                            return sb.append(charAt).toString();
                        }
                        return sb.toString();
                    } else if (sb.length() > 2 && d(sb.charAt(sb.length() - 2))) {
                        return sb.toString();
                    } else {
                        return sb.deleteCharAt(sb.length() - 1).toString();
                    }
                }
                if (i3 >= i) {
                    sb.append(charAt);
                }
                if (isCharacter(charAt)) {
                    i3++;
                } else {
                    i3 += 2;
                }
            }
        }
        return sb.toString();
    }

    public static boolean d(char c) {
        return c >= 55296 && c <= 56319;
    }

    public static boolean isCharacterExceptCapital(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == ' ';
    }

    public static String subString(String str, int i) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return sb.toString();
        }
        if (i > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                if (i2 >= i) {
                    if (i2 == i) {
                        return sb.toString();
                    }
                    return sb.deleteCharAt(sb.length() - 1).toString();
                }
                if (i2 >= 0) {
                    sb.append(charAt);
                }
                if (isCharacterExceptCapital(charAt)) {
                    i2++;
                } else {
                    i2 += 2;
                }
            }
        }
        return sb.toString();
    }

    public static String subStringWithEmoji(String str, int i) {
        int codePointCount = str.codePointCount(0, str.length());
        int i2 = 1;
        String str2 = str;
        while (i2 <= codePointCount) {
            String substring = str.substring(0, str.offsetByCodePoints(0, i2));
            if (getTextLengthWithEmoji(substring) > i) {
                break;
            }
            i2++;
            str2 = substring;
        }
        return str2;
    }

    public static Pair<Integer, Integer> t(String str, int i, int i2) {
        try {
            if (fzf == null) {
                fzf = new TextView(TbadkCoreApplication.getInst().getContext());
            }
            TextView textView = fzf;
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            textView.setText(str);
            textView.setTextSize(0, i);
            textView.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            return new Pair<>(Integer.valueOf(textView.getMeasuredHeight()), Integer.valueOf(textView.getLineCount()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
