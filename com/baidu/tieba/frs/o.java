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
/* loaded from: classes9.dex */
public class o extends v.a {
    public static BdUniqueId grc = BdUniqueId.gen();
    private int dBb;
    private LinearLayout dtk;
    public TextView grd;
    public ImageView gre;
    private int grf;
    private CustomMessageListener grg;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public o(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.grg = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    o.this.mD(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.dtk = (LinearLayout) view.findViewById(R.id.container);
        this.gre = (ImageView) view.findViewById(R.id.emotion_view);
        this.grd = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.setImageResource(this.gre, R.drawable.new_pic_emotion_06);
        this.grg.setTag(grc);
        MessageManager.getInstance().registerListener(this.grg);
        bFr();
    }

    private void bFr() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.o.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (o.this.bN(view)) {
                        o.this.mD(Integer.MAX_VALUE);
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
        return view.getGlobalVisibleRect(this.rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mD(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.dBb <= 0) {
                this.dBb = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.grf != Integer.MAX_VALUE) {
                this.grf = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.dtk.getTop());
                    int abs2 = i2 - Math.abs(this.dtk.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.dtk.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.dBb) {
                            marginLayoutParams.topMargin = this.dBb;
                            this.dtk.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.dBb) {
                            if (abs2 > this.dBb) {
                                marginLayoutParams.topMargin = ((abs2 - this.dBb) / 2) + this.dBb;
                                this.dtk.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.dBb) {
                            if (abs2 < this.dBb) {
                                marginLayoutParams.topMargin = this.dBb;
                            } else if (abs2 == this.dBb) {
                                marginLayoutParams.topMargin = this.dBb;
                            } else if (abs2 > this.dBb) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.dtk.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
