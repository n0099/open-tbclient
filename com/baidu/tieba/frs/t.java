package com.baidu.tieba.frs;

import android.graphics.Rect;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class t extends af.a {
    public static BdUniqueId iLA = BdUniqueId.gen();
    private Rect bCa;
    private LinearLayout fjk;
    private int frP;
    public TextView iLB;
    public ImageView iLC;
    private int iLD;
    private CustomMessageListener iLE;
    private ViewGroup mParent;
    private View mRootView;

    public t(View view, ViewGroup viewGroup) {
        super(view);
        this.bCa = new Rect();
        this.iLE = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    t.this.sa(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.fjk = (LinearLayout) view.findViewById(R.id.container);
        this.iLC = (ImageView) view.findViewById(R.id.emotion_view);
        this.iLB = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.ap.setImageResource(this.iLC, R.drawable.new_pic_emotion_06);
        this.iLE.setTag(iLA);
        MessageManager.getInstance().registerListener(this.iLE);
        czE();
    }

    private void czE() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.t.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (t.this.cE(view)) {
                        t.this.sa(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cE(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.bCa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.frP <= 0) {
                this.frP = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.iLD != Integer.MAX_VALUE) {
                this.iLD = i;
                if (this.mParent.getLocalVisibleRect(this.bCa)) {
                    int i2 = this.bCa.bottom;
                    int abs = Math.abs(this.fjk.getTop());
                    int abs2 = i2 - Math.abs(this.fjk.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.fjk.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.frP) {
                            marginLayoutParams.topMargin = this.frP;
                            this.fjk.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.frP) {
                            if (abs2 > this.frP) {
                                marginLayoutParams.topMargin = ((abs2 - this.frP) / 2) + this.frP;
                                this.fjk.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.frP) {
                            if (abs2 < this.frP) {
                                marginLayoutParams.topMargin = this.frP;
                            } else if (abs2 == this.frP) {
                                marginLayoutParams.topMargin = this.frP;
                            } else if (abs2 > this.frP) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.fjk.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
