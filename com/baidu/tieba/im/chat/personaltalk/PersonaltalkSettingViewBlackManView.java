package com.baidu.tieba.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
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
        inflate(getContext(), v.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.a = (TextView) findViewById(u.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(x.he);
                break;
            case 2:
                string = getResources().getString(x.she);
                break;
            default:
                string = getResources().getString(x.it);
                break;
        }
        this.a.setText(getResources().getString(x.in_black_desc_1, string));
    }
}
