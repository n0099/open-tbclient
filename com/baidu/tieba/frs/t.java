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
/* loaded from: classes20.dex */
public class t extends af.a {
    public static BdUniqueId idw = BdUniqueId.gen();
    private Rect bry;
    private LinearLayout eJG;
    private int eSh;
    private int idA;
    private CustomMessageListener idB;
    public TextView idy;
    public ImageView idz;
    private ViewGroup mParent;
    private View mRootView;

    public t(View view, ViewGroup viewGroup) {
        super(view);
        this.bry = new Rect();
        this.idB = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    t.this.qJ(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.eJG = (LinearLayout) view.findViewById(R.id.container);
        this.idz = (ImageView) view.findViewById(R.id.emotion_view);
        this.idy = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.ap.setImageResource(this.idz, R.drawable.new_pic_emotion_06);
        this.idB.setTag(idw);
        MessageManager.getInstance().registerListener(this.idB);
        cqV();
    }

    private void cqV() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.t.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (t.this.cn(view)) {
                        t.this.qJ(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cn(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.bry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qJ(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.eSh <= 0) {
                this.eSh = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.idA != Integer.MAX_VALUE) {
                this.idA = i;
                if (this.mParent.getLocalVisibleRect(this.bry)) {
                    int i2 = this.bry.bottom;
                    int abs = Math.abs(this.eJG.getTop());
                    int abs2 = i2 - Math.abs(this.eJG.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.eJG.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.eSh) {
                            marginLayoutParams.topMargin = this.eSh;
                            this.eJG.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.eSh) {
                            if (abs2 > this.eSh) {
                                marginLayoutParams.topMargin = ((abs2 - this.eSh) / 2) + this.eSh;
                                this.eJG.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.eSh) {
                            if (abs2 < this.eSh) {
                                marginLayoutParams.topMargin = this.eSh;
                            } else if (abs2 == this.eSh) {
                                marginLayoutParams.topMargin = this.eSh;
                            } else if (abs2 > this.eSh) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.eJG.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
