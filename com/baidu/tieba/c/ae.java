package com.baidu.tieba.c;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ae {
    private static String a = "skinType not support";

    public static void a(TextView textView, int i) {
        if (textView != null) {
            TiebaApplication b = TiebaApplication.b();
            if (i == 1) {
                textView.setTextColor(b.getResources().getColor(R.color.skin_1_common_button_color));
            } else {
                textView.setTextColor(b.getResources().getColor(R.color.white));
            }
        }
    }

    public static void b(TextView textView, int i) {
        if (textView != null) {
            TiebaApplication b = TiebaApplication.b();
            if (i == 1) {
                textView.setTextColor(b.getResources().getColor(R.color.skin_1_common_color));
            } else {
                textView.setTextColor(b.getResources().getColor(R.color.black));
            }
        }
    }

    public static void a(View view, int i) {
        if (view != null) {
            TiebaApplication b = TiebaApplication.b();
            if (i == 1) {
                view.setBackgroundColor(b.getResources().getColor(R.color.skin_1_common_bg));
            } else {
                view.setBackgroundColor(b.getResources().getColor(R.color.backgroundcolor));
            }
        }
    }

    public static void b(View view, int i) {
        if (view != null) {
            TiebaApplication b = TiebaApplication.b();
            if (i == 1) {
                view.setBackgroundColor(b.getResources().getColor(R.color.skin_1_common_bg));
            } else {
                view.setBackgroundColor(b.getResources().getColor(R.color.login_bg_color));
            }
        }
    }

    public static void c(TextView textView, int i) {
        if (textView != null) {
            TiebaApplication b = TiebaApplication.b();
            if (i == 1) {
                textView.setTextColor(b.getResources().getColor(R.color.skin_1_common_color));
            } else {
                textView.setTextColor(b.getResources().getColor(R.color.white));
            }
        }
    }

    public static void c(View view, int i) {
        if (view != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            if (i == 1) {
                view.setBackgroundResource(R.drawable.title_bg_1);
            } else {
                view.setBackgroundResource(R.drawable.title_bg);
            }
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public static void d(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                textView.setBackgroundResource(R.drawable.title_comm_1);
            } else {
                textView.setBackgroundResource(R.drawable.title_comm);
            }
        }
        c(textView, i);
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                textView.setBackgroundResource(R.drawable.title_back_1);
            } else {
                textView.setBackgroundResource(R.drawable.title_back);
            }
            c(textView, i);
        }
    }

    public static void d(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundResource(R.drawable.home_radio_button_1);
            } else {
                view.setBackgroundResource(R.drawable.home_radio_button);
            }
        }
    }

    public static void e(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundResource(R.drawable.title_refresh_1);
            } else {
                view.setBackgroundResource(R.drawable.title_refresh);
            }
        }
    }

    public static void f(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundResource(R.drawable.title_search_1);
            } else {
                view.setBackgroundResource(R.drawable.title_search);
            }
        }
    }

    public static void g(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundResource(R.drawable.title_login_1);
            } else {
                view.setBackgroundResource(R.drawable.title_login);
            }
        }
    }

    public static void h(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundResource(R.drawable.title_home_1);
            } else {
                view.setBackgroundResource(R.drawable.title_home);
            }
        }
    }

    public static int a(int i) {
        if (i == 1) {
            return TiebaApplication.b().getResources().getColor(R.color.skin_1_common_color);
        }
        throw new IllegalArgumentException(a);
    }

    public static int b(int i) {
        if (i == 1) {
            return TiebaApplication.b().getResources().getColor(R.color.skin_1_second_common_color);
        }
        throw new IllegalArgumentException(a);
    }

    public static int c(int i) {
        if (i == 1) {
            return TiebaApplication.b().getResources().getColor(R.color.skin_1_third_common_color);
        }
        throw new IllegalArgumentException(a);
    }

    public static int d(int i) {
        TiebaApplication b = TiebaApplication.b();
        return i == 1 ? b.getResources().getColor(R.color.skin_1_common_bg) : b.getResources().getColor(R.color.backgroundcolor);
    }

    public static void i(View view, int i) {
        if (view != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundResource(i);
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void a(ListView listView, int i) {
        if (listView != null) {
            if (i == 1) {
                listView.setSelector(R.drawable.list_selector_1);
            } else {
                listView.setSelector(R.drawable.list_selector);
            }
        }
    }

    public static void b(ListView listView, int i) {
        if (listView != null) {
            TiebaApplication b = TiebaApplication.b();
            if (i == 1) {
                listView.setBackgroundColor(b.getResources().getColor(R.color.skin_1_common_bg));
                listView.setCacheColorHint(b.getResources().getColor(17170445));
                listView.setDivider(b.getResources().getDrawable(R.drawable.list_divider_1));
                listView.setSelector(R.drawable.list_selector_1);
                return;
            }
            listView.setBackgroundColor(b.getResources().getColor(R.color.backgroundcolor));
            listView.setCacheColorHint(b.getResources().getColor(17170445));
            listView.setDivider(b.getResources().getDrawable(R.drawable.list_divider));
            listView.setSelector(R.drawable.list_selector);
        }
    }

    public static void c(ListView listView, int i) {
        if (listView != null) {
            TiebaApplication b = TiebaApplication.b();
            if (i == 1) {
                listView.setBackgroundColor(b.getResources().getColor(R.color.skin_1_common_bg));
                listView.setCacheColorHint(b.getResources().getColor(17170445));
                listView.setSelector(R.drawable.list_selector_1);
                return;
            }
            listView.setBackgroundColor(b.getResources().getColor(R.color.backgroundcolor));
            listView.setCacheColorHint(b.getResources().getColor(17170445));
            listView.setSelector(R.drawable.list_selector);
        }
    }
}
