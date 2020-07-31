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
/* loaded from: classes15.dex */
public class s extends ad.a {
    public static BdUniqueId hIX = BdUniqueId.gen();
    private int eEL;
    private LinearLayout ewV;
    public TextView hIY;
    public ImageView hIZ;
    private int hJa;
    private CustomMessageListener hJb;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public s(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.hJb = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    s.this.oh(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.ewV = (LinearLayout) view.findViewById(R.id.container);
        this.hIZ = (ImageView) view.findViewById(R.id.emotion_view);
        this.hIY = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.ao.setImageResource(this.hIZ, R.drawable.new_pic_emotion_06);
        this.hJb.setTag(hIX);
        MessageManager.getInstance().registerListener(this.hJb);
        cdk();
    }

    private void cdk() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.s.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (s.this.cc(view)) {
                        s.this.oh(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cc(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oh(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.eEL <= 0) {
                this.eEL = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.hJa != Integer.MAX_VALUE) {
                this.hJa = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.ewV.getTop());
                    int abs2 = i2 - Math.abs(this.ewV.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.ewV.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.eEL) {
                            marginLayoutParams.topMargin = this.eEL;
                            this.ewV.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.eEL) {
                            if (abs2 > this.eEL) {
                                marginLayoutParams.topMargin = ((abs2 - this.eEL) / 2) + this.eEL;
                                this.ewV.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.eEL) {
                            if (abs2 < this.eEL) {
                                marginLayoutParams.topMargin = this.eEL;
                            } else if (abs2 == this.eEL) {
                                marginLayoutParams.topMargin = this.eEL;
                            } else if (abs2 > this.eEL) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.ewV.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
