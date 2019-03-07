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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class n extends v.a {
    public static BdUniqueId fbM = BdUniqueId.gen();
    private LinearLayout ceE;
    private int cnC;
    public TextView fbN;
    public ImageView fbO;
    private int fbP;
    private CustomMessageListener fbQ;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public n(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.fbQ = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    n.this.jO(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.ceE = (LinearLayout) view.findViewById(d.g.container);
        this.fbO = (ImageView) view.findViewById(d.g.emotion_view);
        this.fbN = (TextView) view.findViewById(d.g.no_data_tips);
        com.baidu.tbadk.core.util.al.c(this.fbO, d.f.new_pic_emotion_gray_06);
        this.fbQ.setTag(fbM);
        MessageManager.getInstance().registerListener(this.fbQ);
        bdW();
    }

    private void bdW() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.n.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (n.this.bF(view)) {
                        n.this.jO(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bF(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jO(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.cnC <= 0) {
                this.cnC = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.fbP != Integer.MAX_VALUE) {
                this.fbP = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.ceE.getTop());
                    int abs2 = i2 - Math.abs(this.ceE.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.ceE.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.cnC) {
                            marginLayoutParams.topMargin = this.cnC;
                            this.ceE.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.cnC) {
                            if (abs2 > this.cnC) {
                                marginLayoutParams.topMargin = ((abs2 - this.cnC) / 2) + this.cnC;
                                this.ceE.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.cnC) {
                            if (abs2 < this.cnC) {
                                marginLayoutParams.topMargin = this.cnC;
                            } else if (abs2 == this.cnC) {
                                marginLayoutParams.topMargin = this.cnC;
                            } else if (abs2 > this.cnC) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.ceE.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
