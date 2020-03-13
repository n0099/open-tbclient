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
    public static BdUniqueId grp = BdUniqueId.gen();
    private int dBo;
    private LinearLayout dtx;
    public TextView grq;
    public ImageView grr;
    private int grs;
    private CustomMessageListener grt;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public o(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.grt = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.o.1
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
        this.dtx = (LinearLayout) view.findViewById(R.id.container);
        this.grr = (ImageView) view.findViewById(R.id.emotion_view);
        this.grq = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.setImageResource(this.grr, R.drawable.new_pic_emotion_06);
        this.grt.setTag(grp);
        MessageManager.getInstance().registerListener(this.grt);
        bFs();
    }

    private void bFs() {
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
            if (this.dBo <= 0) {
                this.dBo = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.grs != Integer.MAX_VALUE) {
                this.grs = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.dtx.getTop());
                    int abs2 = i2 - Math.abs(this.dtx.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.dtx.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.dBo) {
                            marginLayoutParams.topMargin = this.dBo;
                            this.dtx.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.dBo) {
                            if (abs2 > this.dBo) {
                                marginLayoutParams.topMargin = ((abs2 - this.dBo) / 2) + this.dBo;
                                this.dtx.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.dBo) {
                            if (abs2 < this.dBo) {
                                marginLayoutParams.topMargin = this.dBo;
                            } else if (abs2 == this.dBo) {
                                marginLayoutParams.topMargin = this.dBo;
                            } else if (abs2 > this.dBo) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.dtx.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
