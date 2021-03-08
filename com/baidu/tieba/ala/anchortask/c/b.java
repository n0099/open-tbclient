package com.baidu.tieba.ala.anchortask.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class b {
    private Context context;
    private boolean gNH = true;
    public TextView gNI;
    public TextView gNJ;
    private View mView;

    public b(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_new_anchor_aid_view, (ViewGroup) null);
        this.gNI = (TextView) this.mView.findViewById(a.f.currcompletion_textView);
        this.gNJ = (TextView) this.mView.findViewById(a.f.total_task_textView);
        this.mView.setVisibility(0);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.gNH = z;
        if (z) {
            this.mView.setVisibility(0);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void onDestroy() {
    }
}
