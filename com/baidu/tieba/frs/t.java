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
/* loaded from: classes15.dex */
public class t extends af.a {
    public static BdUniqueId hWn = BdUniqueId.gen();
    private LinearLayout eHv;
    private int ePm;
    public TextView hWo;
    public ImageView hWp;
    private int hWq;
    private CustomMessageListener hWr;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public t(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.hWr = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    t.this.qs(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.eHv = (LinearLayout) view.findViewById(R.id.container);
        this.hWp = (ImageView) view.findViewById(R.id.emotion_view);
        this.hWo = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.ap.setImageResource(this.hWp, R.drawable.new_pic_emotion_06);
        this.hWr.setTag(hWn);
        MessageManager.getInstance().registerListener(this.hWr);
        cnH();
    }

    private void cnH() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.t.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (t.this.ce(view)) {
                        t.this.qs(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ce(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qs(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.ePm <= 0) {
                this.ePm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.hWq != Integer.MAX_VALUE) {
                this.hWq = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.eHv.getTop());
                    int abs2 = i2 - Math.abs(this.eHv.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.eHv.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.ePm) {
                            marginLayoutParams.topMargin = this.ePm;
                            this.eHv.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.ePm) {
                            if (abs2 > this.ePm) {
                                marginLayoutParams.topMargin = ((abs2 - this.ePm) / 2) + this.ePm;
                                this.eHv.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.ePm) {
                            if (abs2 < this.ePm) {
                                marginLayoutParams.topMargin = this.ePm;
                            } else if (abs2 == this.ePm) {
                                marginLayoutParams.topMargin = this.ePm;
                            } else if (abs2 > this.ePm) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.eHv.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
