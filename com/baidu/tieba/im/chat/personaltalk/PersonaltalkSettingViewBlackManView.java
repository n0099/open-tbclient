package com.baidu.tieba.im.chat.personaltalk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PersonaltalkSettingViewBlackManView extends LinearLayout {
    private TextView aUf;

    public PersonaltalkSettingViewBlackManView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    public PersonaltalkSettingViewBlackManView(Context context) {
        super(context);
        initUI();
    }

    private void initUI() {
        inflate(getContext(), x.p2ptalk_setting_black_man_view, this);
        setOrientation(1);
        this.aUf = (TextView) findViewById(w.black_man_text);
    }

    public void setSex(int i) {
        String string;
        switch (i) {
            case 1:
                string = getResources().getString(z.he);
                break;
            case 2:
                string = getResources().getString(z.she);
                break;
            default:
                string = getResources().getString(z.it);
                break;
        }
        this.aUf.setText(getResources().getString(z.in_black_desc_1, string));
    }
}
