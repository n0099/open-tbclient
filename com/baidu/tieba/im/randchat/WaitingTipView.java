package com.baidu.tieba.im.randchat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class WaitingTipView extends RelativeLayout {
    private Context a;
    private CircleBgView b;
    private HeadImageView c;
    private TextView d;
    private TextView e;
    private Button f;
    private Button g;

    /* loaded from: classes.dex */
    public enum Type {
        TOPIC_UPDATE,
        ORIGINAL_ENTER,
        PERSON_ENTER,
        PERSONS_READY,
        WAIT_LONG,
        PERSON_LEAVE,
        WAIT_TIP,
        CLEAR,
        WAIT_TIP_RAND;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] valuesCustom = values();
            int length = valuesCustom.length;
            Type[] typeArr = new Type[length];
            System.arraycopy(valuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }
    }

    public WaitingTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public WaitingTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public WaitingTipView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.im_waitting_tip, (ViewGroup) null);
        this.b = (CircleBgView) inflate.findViewById(R.id.tip_head_layout);
        this.c = (HeadImageView) inflate.findViewById(R.id.tip_head_image);
        this.d = (TextView) inflate.findViewById(R.id.tip_head_text);
        this.e = (TextView) inflate.findViewById(R.id.tip_text);
        this.f = (Button) inflate.findViewById(R.id.tip_wait);
        this.g = (Button) inflate.findViewById(R.id.tip_quit);
        this.c.setIsRound(true);
        addView(inflate);
    }

    public final void a(HeadImageView headImageView, boolean z) {
        int c = BdUtilHelper.c(this.a, R.dimen.head_view_circle_bg);
        int c2 = BdUtilHelper.c(this.a, R.dimen.tip_view_image_width);
        int c3 = BdUtilHelper.c(this.a, R.dimen.tip_view_image_height);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) headImageView.getLayoutParams();
        if (z) {
            layoutParams.width = c2 - c;
            layoutParams.height = c3 - c;
        } else {
            layoutParams.width = c2;
            layoutParams.height = c3;
        }
        headImageView.setLayoutParams(layoutParams);
    }

    public HeadImageView getTipImageHead() {
        return this.c;
    }

    public void setTipImageHead(HeadImageView headImageView) {
        this.c = headImageView;
    }

    public TextView getTipImageText() {
        return this.d;
    }

    public void setTipImageText(TextView textView) {
        this.d = textView;
    }

    public TextView getTipText() {
        return this.e;
    }

    public void setTipText(TextView textView) {
        this.e = textView;
    }

    public Button getWaitButton() {
        return this.f;
    }

    public void setWaitButton(Button button) {
        this.f = button;
    }

    public Button getQuitButton() {
        return this.g;
    }

    public void setQuitButton(Button button) {
        this.g = button;
    }

    public CircleBgView getCircelBgView() {
        return this.b;
    }

    public void setCircelBgView(CircleBgView circleBgView) {
        this.b = circleBgView;
    }
}
