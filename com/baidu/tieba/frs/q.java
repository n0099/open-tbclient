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
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class q extends y.a {
    public static BdUniqueId hbr = BdUniqueId.gen();
    private LinearLayout dTK;
    private int ebr;
    public TextView hbs;
    public ImageView hbt;
    private int hbu;
    private CustomMessageListener hbv;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public q(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.hbv = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    q.this.mQ(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.dTK = (LinearLayout) view.findViewById(R.id.container);
        this.hbt = (ImageView) view.findViewById(R.id.emotion_view);
        this.hbs = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.setImageResource(this.hbt, R.drawable.new_pic_emotion_06);
        this.hbv.setTag(hbr);
        MessageManager.getInstance().registerListener(this.hbv);
        bQe();
    }

    private void bQe() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.q.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (q.this.bV(view)) {
                        q.this.mQ(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bV(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mQ(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.ebr <= 0) {
                this.ebr = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.hbu != Integer.MAX_VALUE) {
                this.hbu = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.dTK.getTop());
                    int abs2 = i2 - Math.abs(this.dTK.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.dTK.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.ebr) {
                            marginLayoutParams.topMargin = this.ebr;
                            this.dTK.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.ebr) {
                            if (abs2 > this.ebr) {
                                marginLayoutParams.topMargin = ((abs2 - this.ebr) / 2) + this.ebr;
                                this.dTK.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.ebr) {
                            if (abs2 < this.ebr) {
                                marginLayoutParams.topMargin = this.ebr;
                            } else if (abs2 == this.ebr) {
                                marginLayoutParams.topMargin = this.ebr;
                            } else if (abs2 > this.ebr) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.dTK.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
