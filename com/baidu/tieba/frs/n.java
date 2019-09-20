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
    public static BdUniqueId fyX = BdUniqueId.gen();
    private LinearLayout cpd;
    private int cye;
    private Rect cyf;
    public TextView fyY;
    public ImageView fyZ;
    private int fza;
    private CustomMessageListener fzb;
    private ViewGroup mParent;
    private View mRootView;

    public n(View view, ViewGroup viewGroup) {
        super(view);
        this.cyf = new Rect();
        this.fzb = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    n.this.kL(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.cpd = (LinearLayout) view.findViewById(R.id.container);
        this.fyZ = (ImageView) view.findViewById(R.id.emotion_view);
        this.fyY = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.c(this.fyZ, (int) R.drawable.new_pic_emotion_gray_06);
        this.fzb.setTag(fyX);
        MessageManager.getInstance().registerListener(this.fzb);
        bol();
    }

    private void bol() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.n.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (n.this.bQ(view)) {
                        n.this.kL(Integer.MAX_VALUE);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQ(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.cyf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kL(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.cye <= 0) {
                this.cye = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.fza != Integer.MAX_VALUE) {
                this.fza = i;
                if (this.mParent.getLocalVisibleRect(this.cyf)) {
                    int i2 = this.cyf.bottom;
                    int abs = Math.abs(this.cpd.getTop());
                    int abs2 = i2 - Math.abs(this.cpd.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.cpd.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.cye) {
                            marginLayoutParams.topMargin = this.cye;
                            this.cpd.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.cye) {
                            if (abs2 > this.cye) {
                                marginLayoutParams.topMargin = ((abs2 - this.cye) / 2) + this.cye;
                                this.cpd.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.cye) {
                            if (abs2 < this.cye) {
                                marginLayoutParams.topMargin = this.cye;
                            } else if (abs2 == this.cye) {
                                marginLayoutParams.topMargin = this.cye;
                            } else if (abs2 > this.cye) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.cpd.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
