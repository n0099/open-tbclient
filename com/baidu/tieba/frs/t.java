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
/* loaded from: classes21.dex */
public class t extends af.a {
    public static BdUniqueId iEQ = BdUniqueId.gen();
    private Rect bxA;
    private LinearLayout fej;
    private int fmO;
    public TextView iER;
    public ImageView iES;
    private int iET;
    private CustomMessageListener iEU;
    private ViewGroup mParent;
    private View mRootView;

    public t(View view, ViewGroup viewGroup) {
        super(view);
        this.bxA = new Rect();
        this.iEU = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    t.this.rs(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.fej = (LinearLayout) view.findViewById(R.id.container);
        this.iES = (ImageView) view.findViewById(R.id.emotion_view);
        this.iER = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.ap.setImageResource(this.iES, R.drawable.new_pic_emotion_06);
        this.iEU.setTag(iEQ);
        MessageManager.getInstance().registerListener(this.iEU);
        cxA();
    }

    private void cxA() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.t.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (t.this.cv(view)) {
                        t.this.rs(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cv(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.bxA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.fmO <= 0) {
                this.fmO = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.iET != Integer.MAX_VALUE) {
                this.iET = i;
                if (this.mParent.getLocalVisibleRect(this.bxA)) {
                    int i2 = this.bxA.bottom;
                    int abs = Math.abs(this.fej.getTop());
                    int abs2 = i2 - Math.abs(this.fej.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.fej.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.fmO) {
                            marginLayoutParams.topMargin = this.fmO;
                            this.fej.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.fmO) {
                            if (abs2 > this.fmO) {
                                marginLayoutParams.topMargin = ((abs2 - this.fmO) / 2) + this.fmO;
                                this.fej.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.fmO) {
                            if (abs2 < this.fmO) {
                                marginLayoutParams.topMargin = this.fmO;
                            } else if (abs2 == this.fmO) {
                                marginLayoutParams.topMargin = this.fmO;
                            } else if (abs2 > this.fmO) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.fej.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
