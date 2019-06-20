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
    public static BdUniqueId frO = BdUniqueId.gen();
    private LinearLayout cmO;
    private int cvN;
    public TextView frP;
    public ImageView frQ;
    private int frR;
    private CustomMessageListener frS;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public n(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.frS = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    n.this.kB(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.cmO = (LinearLayout) view.findViewById(R.id.container);
        this.frQ = (ImageView) view.findViewById(R.id.emotion_view);
        this.frP = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.al.c(this.frQ, (int) R.drawable.new_pic_emotion_gray_06);
        this.frS.setTag(frO);
        MessageManager.getInstance().registerListener(this.frS);
        blp();
    }

    private void blp() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.n.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (n.this.bN(view)) {
                        n.this.kB(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bN(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kB(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.cvN <= 0) {
                this.cvN = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.frR != Integer.MAX_VALUE) {
                this.frR = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.cmO.getTop());
                    int abs2 = i2 - Math.abs(this.cmO.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.cmO.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.cvN) {
                            marginLayoutParams.topMargin = this.cvN;
                            this.cmO.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.cvN) {
                            if (abs2 > this.cvN) {
                                marginLayoutParams.topMargin = ((abs2 - this.cvN) / 2) + this.cvN;
                                this.cmO.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.cvN) {
                            if (abs2 < this.cvN) {
                                marginLayoutParams.topMargin = this.cvN;
                            } else if (abs2 == this.cvN) {
                                marginLayoutParams.topMargin = this.cvN;
                            } else if (abs2 > this.cvN) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.cmO.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
