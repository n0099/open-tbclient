package com.baidu.tieba.ala.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes6.dex */
public class PersonEmptyView extends LinearLayout {
    private ImageView dGv;
    private TextView dGw;
    private TextView dGx;

    public PersonEmptyView(Context context) {
        super(context);
        init();
    }

    public PersonEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PersonEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.ala_person_empty_view, this);
        this.dGv = (ImageView) findViewById(a.g.empty_image);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            ViewGroup.LayoutParams layoutParams = this.dGv.getLayoutParams();
            layoutParams.height = (int) getContext().getResources().getDimension(a.e.sdk_ds250);
            layoutParams.width = (int) getContext().getResources().getDimension(a.e.sdk_ds334);
            this.dGv.setPadding(0, (int) getContext().getResources().getDimension(a.e.sdk_ds64), 0, 0);
            this.dGv.setLayoutParams(layoutParams);
        }
        this.dGw = (TextView) findViewById(a.g.empty_text);
        this.dGx = (TextView) findViewById(a.g.empty_sub_text);
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.dGv.setImageResource(i);
        } else {
            this.dGv.setVisibility(8);
        }
        if (i2 != -1) {
            this.dGw.setText(i2);
        } else {
            this.dGw.setVisibility(8);
        }
        if (i3 != -1) {
            this.dGx.setText(i3);
        } else {
            this.dGx.setVisibility(8);
        }
    }
}
