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
    public static BdUniqueId iWv = BdUniqueId.gen();
    private Rect bHi;
    private LinearLayout fqI;
    private int fzD;
    public TextView iWw;
    public ImageView iWx;
    private int iWy;
    private CustomMessageListener iWz;
    private ViewGroup mParent;
    private View mRootView;

    public t(View view, ViewGroup viewGroup) {
        super(view);
        this.bHi = new Rect();
        this.iWz = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    t.this.sB(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.fqI = (LinearLayout) view.findViewById(R.id.container);
        this.iWx = (ImageView) view.findViewById(R.id.emotion_view);
        this.iWw = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.ap.setImageResource(this.iWx, R.drawable.new_pic_emotion_06);
        this.iWz.setTag(iWv);
        MessageManager.getInstance().registerListener(this.iWz);
        cDV();
    }

    private void cDV() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.t.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (t.this.cL(view)) {
                        t.this.sB(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cL(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.bHi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sB(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.fzD <= 0) {
                this.fzD = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.iWy != Integer.MAX_VALUE) {
                this.iWy = i;
                if (this.mParent.getLocalVisibleRect(this.bHi)) {
                    int i2 = this.bHi.bottom;
                    int abs = Math.abs(this.fqI.getTop());
                    int abs2 = i2 - Math.abs(this.fqI.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.fqI.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.fzD) {
                            marginLayoutParams.topMargin = this.fzD;
                            this.fqI.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.fzD) {
                            if (abs2 > this.fzD) {
                                marginLayoutParams.topMargin = ((abs2 - this.fzD) / 2) + this.fzD;
                                this.fqI.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.fzD) {
                            if (abs2 < this.fzD) {
                                marginLayoutParams.topMargin = this.fzD;
                            } else if (abs2 == this.fzD) {
                                marginLayoutParams.topMargin = this.fzD;
                            } else if (abs2 > this.fzD) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.fqI.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
