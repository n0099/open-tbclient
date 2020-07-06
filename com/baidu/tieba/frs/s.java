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
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class s extends ad.a {
    public static BdUniqueId hCZ = BdUniqueId.gen();
    private LinearLayout eqD;
    private int eyv;
    public TextView hDa;
    public ImageView hDb;
    private int hDc;
    private CustomMessageListener hDd;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public s(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.hDd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    s.this.nP(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.eqD = (LinearLayout) view.findViewById(R.id.container);
        this.hDb = (ImageView) view.findViewById(R.id.emotion_view);
        this.hDa = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.an.setImageResource(this.hDb, R.drawable.new_pic_emotion_06);
        this.hDd.setTag(hCZ);
        MessageManager.getInstance().registerListener(this.hDd);
        bZN();
    }

    private void bZN() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.s.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (s.this.bW(view)) {
                        s.this.nP(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bW(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.eyv <= 0) {
                this.eyv = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.hDc != Integer.MAX_VALUE) {
                this.hDc = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.eqD.getTop());
                    int abs2 = i2 - Math.abs(this.eqD.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.eqD.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.eyv) {
                            marginLayoutParams.topMargin = this.eyv;
                            this.eqD.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.eyv) {
                            if (abs2 > this.eyv) {
                                marginLayoutParams.topMargin = ((abs2 - this.eyv) / 2) + this.eyv;
                                this.eqD.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.eyv) {
                            if (abs2 < this.eyv) {
                                marginLayoutParams.topMargin = this.eyv;
                            } else if (abs2 == this.eyv) {
                                marginLayoutParams.topMargin = this.eyv;
                            } else if (abs2 > this.eyv) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.eqD.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
