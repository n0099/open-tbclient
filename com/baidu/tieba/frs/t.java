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
    public static BdUniqueId iKN = BdUniqueId.gen();
    private Rect bDL;
    private LinearLayout fkc;
    private int fsH;
    public TextView iKO;
    public ImageView iKP;
    private int iKQ;
    private CustomMessageListener iKR;
    private ViewGroup mParent;
    private View mRootView;

    public t(View view, ViewGroup viewGroup) {
        super(view);
        this.bDL = new Rect();
        this.iKR = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    t.this.rC(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.fkc = (LinearLayout) view.findViewById(R.id.container);
        this.iKP = (ImageView) view.findViewById(R.id.emotion_view);
        this.iKO = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.ap.setImageResource(this.iKP, R.drawable.new_pic_emotion_06);
        this.iKR.setTag(iKN);
        MessageManager.getInstance().registerListener(this.iKR);
        cAb();
    }

    private void cAb() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.t.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (t.this.cA(view)) {
                        t.this.rC(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cA(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.bDL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.fsH <= 0) {
                this.fsH = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.iKQ != Integer.MAX_VALUE) {
                this.iKQ = i;
                if (this.mParent.getLocalVisibleRect(this.bDL)) {
                    int i2 = this.bDL.bottom;
                    int abs = Math.abs(this.fkc.getTop());
                    int abs2 = i2 - Math.abs(this.fkc.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.fkc.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.fsH) {
                            marginLayoutParams.topMargin = this.fsH;
                            this.fkc.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.fsH) {
                            if (abs2 > this.fsH) {
                                marginLayoutParams.topMargin = ((abs2 - this.fsH) / 2) + this.fsH;
                                this.fkc.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.fsH) {
                            if (abs2 < this.fsH) {
                                marginLayoutParams.topMargin = this.fsH;
                            } else if (abs2 == this.fsH) {
                                marginLayoutParams.topMargin = this.fsH;
                            } else if (abs2 > this.fsH) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.fkc.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
