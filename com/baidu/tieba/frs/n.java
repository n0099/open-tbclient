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
    public static BdUniqueId fwL = BdUniqueId.gen();
    private LinearLayout cob;
    private int cxb;
    private Rect cxc;
    public TextView fwM;
    public ImageView fwN;
    private int fwO;
    private CustomMessageListener fwP;
    private ViewGroup mParent;
    private View mRootView;

    public n(View view, ViewGroup viewGroup) {
        super(view);
        this.cxc = new Rect();
        this.fwP = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    n.this.kH(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.cob = (LinearLayout) view.findViewById(R.id.container);
        this.fwN = (ImageView) view.findViewById(R.id.emotion_view);
        this.fwM = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.c(this.fwN, (int) R.drawable.new_pic_emotion_gray_06);
        this.fwP.setTag(fwL);
        MessageManager.getInstance().registerListener(this.fwP);
        bnq();
    }

    private void bnq() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.n.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (n.this.bP(view)) {
                        n.this.kH(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bP(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.cxc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kH(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.cxb <= 0) {
                this.cxb = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.fwO != Integer.MAX_VALUE) {
                this.fwO = i;
                if (this.mParent.getLocalVisibleRect(this.cxc)) {
                    int i2 = this.cxc.bottom;
                    int abs = Math.abs(this.cob.getTop());
                    int abs2 = i2 - Math.abs(this.cob.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.cob.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.cxb) {
                            marginLayoutParams.topMargin = this.cxb;
                            this.cob.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.cxb) {
                            if (abs2 > this.cxb) {
                                marginLayoutParams.topMargin = ((abs2 - this.cxb) / 2) + this.cxb;
                                this.cob.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.cxb) {
                            if (abs2 < this.cxb) {
                                marginLayoutParams.topMargin = this.cxb;
                            } else if (abs2 == this.cxb) {
                                marginLayoutParams.topMargin = this.cxb;
                            } else if (abs2 > this.cxb) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.cob.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
