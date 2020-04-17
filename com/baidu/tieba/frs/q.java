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
    public static BdUniqueId hbl = BdUniqueId.gen();
    private LinearLayout dTF;
    private int ebm;
    public TextView hbm;
    public ImageView hbn;
    private int hbo;
    private CustomMessageListener hbp;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public q(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.hbp = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.q.1
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
        this.dTF = (LinearLayout) view.findViewById(R.id.container);
        this.hbn = (ImageView) view.findViewById(R.id.emotion_view);
        this.hbm = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.setImageResource(this.hbn, R.drawable.new_pic_emotion_06);
        this.hbp.setTag(hbl);
        MessageManager.getInstance().registerListener(this.hbp);
        bQf();
    }

    private void bQf() {
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
            if (this.ebm <= 0) {
                this.ebm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.hbo != Integer.MAX_VALUE) {
                this.hbo = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.dTF.getTop());
                    int abs2 = i2 - Math.abs(this.dTF.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.dTF.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.ebm) {
                            marginLayoutParams.topMargin = this.ebm;
                            this.dTF.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.ebm) {
                            if (abs2 > this.ebm) {
                                marginLayoutParams.topMargin = ((abs2 - this.ebm) / 2) + this.ebm;
                                this.dTF.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.ebm) {
                            if (abs2 < this.ebm) {
                                marginLayoutParams.topMargin = this.ebm;
                            } else if (abs2 == this.ebm) {
                                marginLayoutParams.topMargin = this.ebm;
                            } else if (abs2 > this.ebm) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.dTF.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
