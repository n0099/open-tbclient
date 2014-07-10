package com.baidu.tieba.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView a;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        a();
    }

    private void a() {
        inflate(getContext(), w.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.a = (TextView) findViewById(v.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(y.he);
                break;
            case 2:
                string = getResources().getString(y.she);
                break;
            default:
                string = getResources().getString(y.it);
                break;
        }
        this.a.setText(getResources().getString(y.in_black_desc_1, string));
    }
}
