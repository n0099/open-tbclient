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
    public static BdUniqueId isu = BdUniqueId.gen();
    private Rect bvm;
    private LinearLayout eVN;
    private int fep;
    public TextView isv;
    public ImageView isw;
    private int isx;
    private CustomMessageListener isy;
    private ViewGroup mParent;
    private View mRootView;

    public t(View view, ViewGroup viewGroup) {
        super(view);
        this.bvm = new Rect();
        this.isy = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    t.this.rh(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.eVN = (LinearLayout) view.findViewById(R.id.container);
        this.isw = (ImageView) view.findViewById(R.id.emotion_view);
        this.isv = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.ap.setImageResource(this.isw, R.drawable.new_pic_emotion_06);
        this.isy.setTag(isu);
        MessageManager.getInstance().registerListener(this.isy);
        cut();
    }

    private void cut() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.t.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (t.this.cr(view)) {
                        t.this.rh(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cr(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.bvm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.fep <= 0) {
                this.fep = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.isx != Integer.MAX_VALUE) {
                this.isx = i;
                if (this.mParent.getLocalVisibleRect(this.bvm)) {
                    int i2 = this.bvm.bottom;
                    int abs = Math.abs(this.eVN.getTop());
                    int abs2 = i2 - Math.abs(this.eVN.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.eVN.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.fep) {
                            marginLayoutParams.topMargin = this.fep;
                            this.eVN.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.fep) {
                            if (abs2 > this.fep) {
                                marginLayoutParams.topMargin = ((abs2 - this.fep) / 2) + this.fep;
                                this.eVN.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.fep) {
                            if (abs2 < this.fep) {
                                marginLayoutParams.topMargin = this.fep;
                            } else if (abs2 == this.fep) {
                                marginLayoutParams.topMargin = this.fep;
                            } else if (abs2 > this.fep) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.eVN.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
