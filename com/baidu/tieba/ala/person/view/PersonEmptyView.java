package com.baidu.tieba.ala.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class PersonEmptyView extends LinearLayout {
    private ImageView gFs;
    private TextView gFt;
    private TextView gFu;

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
        LayoutInflater.from(getContext()).inflate(a.g.ala_person_empty_view, this);
        this.gFs = (ImageView) findViewById(a.f.empty_image);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            ViewGroup.LayoutParams layoutParams = this.gFs.getLayoutParams();
            layoutParams.height = (int) getContext().getResources().getDimension(a.d.sdk_ds250);
            layoutParams.width = (int) getContext().getResources().getDimension(a.d.sdk_ds334);
            this.gFs.setPadding(0, (int) getContext().getResources().getDimension(a.d.sdk_ds64), 0, 0);
            this.gFs.setLayoutParams(layoutParams);
        }
        this.gFt = (TextView) findViewById(a.f.empty_text);
        this.gFu = (TextView) findViewById(a.f.empty_sub_text);
    }

    public void setParams(int i, int i2, int i3) {
        if (i != -1) {
            this.gFs.setImageResource(i);
        } else {
            this.gFs.setVisibility(8);
        }
        if (i2 != -1) {
            this.gFt.setText(i2);
        } else {
            this.gFt.setVisibility(8);
        }
        if (i3 != -1) {
            this.gFu.setText(i3);
        } else {
            this.gFu.setVisibility(8);
        }
    }
}
