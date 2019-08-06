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
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class n extends v.a {
    public static BdUniqueId fxk = BdUniqueId.gen();
    private LinearLayout coi;
    private int cxi;
    private Rect cxj;
    public TextView fxl;
    public ImageView fxm;
    private int fxn;
    private CustomMessageListener fxo;
    private ViewGroup mParent;
    private View mRootView;

    public n(View view, ViewGroup viewGroup) {
        super(view);
        this.cxj = new Rect();
        this.fxo = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    n.this.kI(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.coi = (LinearLayout) view.findViewById(R.id.container);
        this.fxm = (ImageView) view.findViewById(R.id.emotion_view);
        this.fxl = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.c(this.fxm, (int) R.drawable.new_pic_emotion_gray_06);
        this.fxo.setTag(fxk);
        MessageManager.getInstance().registerListener(this.fxo);
        bnA();
    }

    private void bnA() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.n.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (n.this.bQ(view)) {
                        n.this.kI(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQ(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.cxj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kI(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.cxi <= 0) {
                this.cxi = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.fxn != Integer.MAX_VALUE) {
                this.fxn = i;
                if (this.mParent.getLocalVisibleRect(this.cxj)) {
                    int i2 = this.cxj.bottom;
                    int abs = Math.abs(this.coi.getTop());
                    int abs2 = i2 - Math.abs(this.coi.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.coi.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.cxi) {
                            marginLayoutParams.topMargin = this.cxi;
                            this.coi.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.cxi) {
                            if (abs2 > this.cxi) {
                                marginLayoutParams.topMargin = ((abs2 - this.cxi) / 2) + this.cxi;
                                this.coi.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.cxi) {
                            if (abs2 < this.cxi) {
                                marginLayoutParams.topMargin = this.cxi;
                            } else if (abs2 == this.cxi) {
                                marginLayoutParams.topMargin = this.cxi;
                            } else if (abs2 > this.cxi) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.coi.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
