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
    public static BdUniqueId fxt = BdUniqueId.gen();
    private Rect aoK;
    private LinearLayout cBh;
    private int cJb;
    public TextView fxu;
    public ImageView fxv;
    private int fxw;
    private CustomMessageListener fxx;
    private ViewGroup mParent;
    private View mRootView;

    public n(View view, ViewGroup viewGroup) {
        super(view);
        this.aoK = new Rect();
        this.fxx = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    n.this.jY(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.cBh = (LinearLayout) view.findViewById(R.id.container);
        this.fxv = (ImageView) view.findViewById(R.id.emotion_view);
        this.fxu = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.setImageResource(this.fxv, R.drawable.new_pic_emotion_gray_06);
        this.fxx.setTag(fxt);
        MessageManager.getInstance().registerListener(this.fxx);
        bln();
    }

    private void bln() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.n.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (n.this.bN(view)) {
                        n.this.jY(Integer.MAX_VALUE);
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
        return view.getGlobalVisibleRect(this.aoK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jY(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.cJb <= 0) {
                this.cJb = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.fxw != Integer.MAX_VALUE) {
                this.fxw = i;
                if (this.mParent.getLocalVisibleRect(this.aoK)) {
                    int i2 = this.aoK.bottom;
                    int abs = Math.abs(this.cBh.getTop());
                    int abs2 = i2 - Math.abs(this.cBh.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.cBh.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.cJb) {
                            marginLayoutParams.topMargin = this.cJb;
                            this.cBh.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.cJb) {
                            if (abs2 > this.cJb) {
                                marginLayoutParams.topMargin = ((abs2 - this.cJb) / 2) + this.cJb;
                                this.cBh.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.cJb) {
                            if (abs2 < this.cJb) {
                                marginLayoutParams.topMargin = this.cJb;
                            } else if (abs2 == this.cJb) {
                                marginLayoutParams.topMargin = this.cJb;
                            } else if (abs2 > this.cJb) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.cBh.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
