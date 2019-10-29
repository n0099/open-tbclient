package com.baidu.tieba.frs;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class n extends v.a {
    public static BdUniqueId fyk = BdUniqueId.gen();
    private Rect apc;
    private LinearLayout cBY;
    private int cJS;
    public TextView fyl;
    public ImageView fym;
    private int fyn;
    private CustomMessageListener fyo;
    private ViewGroup mParent;
    private View mRootView;

    public n(View view, ViewGroup viewGroup) {
        super(view);
        this.apc = new Rect();
        this.fyo = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    n.this.jZ(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.cBY = (LinearLayout) view.findViewById(R.id.container);
        this.fym = (ImageView) view.findViewById(R.id.emotion_view);
        this.fyl = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.setImageResource(this.fym, R.drawable.new_pic_emotion_gray_06);
        this.fyo.setTag(fyk);
        MessageManager.getInstance().registerListener(this.fyo);
        blp();
    }

    private void blp() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.n.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (n.this.bN(view)) {
                        n.this.jZ(Integer.MAX_VALUE);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bN(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.apc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jZ(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.cJS <= 0) {
                this.cJS = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.fyn != Integer.MAX_VALUE) {
                this.fyn = i;
                if (this.mParent.getLocalVisibleRect(this.apc)) {
                    int i2 = this.apc.bottom;
                    int abs = Math.abs(this.cBY.getTop());
                    int abs2 = i2 - Math.abs(this.cBY.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.cBY.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.cJS) {
                            marginLayoutParams.topMargin = this.cJS;
                            this.cBY.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.cJS) {
                            if (abs2 > this.cJS) {
                                marginLayoutParams.topMargin = ((abs2 - this.cJS) / 2) + this.cJS;
                                this.cBY.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.cJS) {
                            if (abs2 < this.cJS) {
                                marginLayoutParams.topMargin = this.cJS;
                            } else if (abs2 == this.cJS) {
                                marginLayoutParams.topMargin = this.cJS;
                            } else if (abs2 > this.cJS) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.cBY.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
