package com.baidu.tieba.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
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
        inflate(getContext(), R.layout.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.a = (TextView) findViewById(R.id.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(R.string.he);
                break;
            case 2:
                string = getResources().getString(R.string.she);
                break;
            default:
                string = getResources().getString(R.string.it);
                break;
        }
        this.a.setText(getResources().getString(R.string.in_black_desc_1, string));
    }
}
