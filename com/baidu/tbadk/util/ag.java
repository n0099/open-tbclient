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
public class ag {
    public static TextView fPa;

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
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= str.length()) {
                return i3;
            }
            if (isCharacter(str.charAt(i2))) {
                i = i3 + 1;
            } else {
                i = i3 + 2;
            }
            i2++;
        }
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
        int i3 = 0;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str) || i > i2) {
            return sb.toString();
        }
        if (i >= 0 && i2 >= 0) {
            int i4 = 0;
            while (true) {
                int i5 = i3;
                if (i4 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i4);
                if (i5 >= i2) {
                    if (i5 == i2) {
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
                if (i5 >= i) {
                    sb.append(charAt);
                }
                if (isCharacter(charAt)) {
                    i3 = i5 + 1;
                } else {
                    i3 = i5 + 2;
                }
                i4++;
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
        int i2 = 0;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return sb.toString();
        }
        if (i > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i2;
                if (i3 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i3);
                if (i4 >= i) {
                    if (i4 == i) {
                        return sb.toString();
                    }
                    return sb.deleteCharAt(sb.length() - 1).toString();
                }
                if (i4 >= 0) {
                    sb.append(charAt);
                }
                if (isCharacterExceptCapital(charAt)) {
                    i2 = i4 + 1;
                } else {
                    i2 = i4 + 2;
                }
                i3++;
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

    public static Pair<Integer, Integer> u(String str, int i, int i2) {
        try {
            if (fPa == null) {
                fPa = new TextView(TbadkCoreApplication.getInst().getContext());
            }
            TextView textView = fPa;
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
