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
/* loaded from: classes7.dex */
public class o extends v.a {
    public static BdUniqueId goZ = BdUniqueId.gen();
    private LinearLayout dpb;
    private int dwU;
    public TextView gpa;
    public ImageView gpb;
    private int gpc;
    private CustomMessageListener gpd;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public o(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.gpd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    o.this.ml(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.dpb = (LinearLayout) view.findViewById(R.id.container);
        this.gpb = (ImageView) view.findViewById(R.id.emotion_view);
        this.gpa = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.setImageResource(this.gpb, R.drawable.new_pic_emotion_06);
        this.gpd.setTag(goZ);
        MessageManager.getInstance().registerListener(this.gpd);
        bDM();
    }

    private void bDM() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.o.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (o.this.bN(view)) {
                        o.this.ml(Integer.MAX_VALUE);
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
    public void ml(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.dwU <= 0) {
                this.dwU = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.gpc != Integer.MAX_VALUE) {
                this.gpc = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.dpb.getTop());
                    int abs2 = i2 - Math.abs(this.dpb.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.dpb.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.dwU) {
                            marginLayoutParams.topMargin = this.dwU;
                            this.dpb.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.dwU) {
                            if (abs2 > this.dwU) {
                                marginLayoutParams.topMargin = ((abs2 - this.dwU) / 2) + this.dwU;
                                this.dpb.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.dwU) {
                            if (abs2 < this.dwU) {
                                marginLayoutParams.topMargin = this.dwU;
                            } else if (abs2 == this.dwU) {
                                marginLayoutParams.topMargin = this.dwU;
                            } else if (abs2 > this.dwU) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.dpb.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
