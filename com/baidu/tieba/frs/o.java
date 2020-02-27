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
    public static BdUniqueId gra = BdUniqueId.gen();
    private int dBa;
    private LinearLayout dtj;
    public TextView grb;
    public ImageView grc;
    private int grd;
    private CustomMessageListener gre;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public o(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.gre = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.o.1
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
        this.dtj = (LinearLayout) view.findViewById(R.id.container);
        this.grc = (ImageView) view.findViewById(R.id.emotion_view);
        this.grb = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.setImageResource(this.grc, R.drawable.new_pic_emotion_06);
        this.gre.setTag(gra);
        MessageManager.getInstance().registerListener(this.gre);
        bFp();
    }

    private void bFp() {
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
            if (this.dBa <= 0) {
                this.dBa = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.grd != Integer.MAX_VALUE) {
                this.grd = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.dtj.getTop());
                    int abs2 = i2 - Math.abs(this.dtj.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.dtj.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.dBa) {
                            marginLayoutParams.topMargin = this.dBa;
                            this.dtj.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.dBa) {
                            if (abs2 > this.dBa) {
                                marginLayoutParams.topMargin = ((abs2 - this.dBa) / 2) + this.dBa;
                                this.dtj.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.dBa) {
                            if (abs2 < this.dBa) {
                                marginLayoutParams.topMargin = this.dBa;
                            } else if (abs2 == this.dBa) {
                                marginLayoutParams.topMargin = this.dBa;
                            } else if (abs2 > this.dBa) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.dtj.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
