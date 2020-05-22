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
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class q extends aa.a {
    public static BdUniqueId hqf = BdUniqueId.gen();
    private LinearLayout ehT;
    private int epD;
    public TextView hqg;
    public ImageView hqh;
    private int hqi;
    private CustomMessageListener hqj;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public q(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.hqj = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    q.this.ns(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.ehT = (LinearLayout) view.findViewById(R.id.container);
        this.hqh = (ImageView) view.findViewById(R.id.emotion_view);
        this.hqg = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.setImageResource(this.hqh, R.drawable.new_pic_emotion_06);
        this.hqj.setTag(hqf);
        MessageManager.getInstance().registerListener(this.hqj);
        bWA();
    }

    private void bWA() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.q.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (q.this.bV(view)) {
                        q.this.ns(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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
    public void ns(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.epD <= 0) {
                this.epD = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.hqi != Integer.MAX_VALUE) {
                this.hqi = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.ehT.getTop());
                    int abs2 = i2 - Math.abs(this.ehT.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.ehT.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.epD) {
                            marginLayoutParams.topMargin = this.epD;
                            this.ehT.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.epD) {
                            if (abs2 > this.epD) {
                                marginLayoutParams.topMargin = ((abs2 - this.epD) / 2) + this.epD;
                                this.ehT.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.epD) {
                            if (abs2 < this.epD) {
                                marginLayoutParams.topMargin = this.epD;
                            } else if (abs2 == this.epD) {
                                marginLayoutParams.topMargin = this.epD;
                            } else if (abs2 > this.epD) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.ehT.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
