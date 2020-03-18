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
public class p extends v.a {
    public static BdUniqueId grZ = BdUniqueId.gen();
    private int dBB;
    private LinearLayout dtK;
    public TextView gsa;
    public ImageView gsb;
    private int gsc;
    private CustomMessageListener gsd;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public p(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.gsd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    p.this.mF(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.dtK = (LinearLayout) view.findViewById(R.id.container);
        this.gsb = (ImageView) view.findViewById(R.id.emotion_view);
        this.gsa = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.setImageResource(this.gsb, R.drawable.new_pic_emotion_06);
        this.gsd.setTag(grZ);
        MessageManager.getInstance().registerListener(this.gsd);
        bFC();
    }

    private void bFC() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.p.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (p.this.bN(view)) {
                        p.this.mF(Integer.MAX_VALUE);
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
    public void mF(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.dBB <= 0) {
                this.dBB = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.gsc != Integer.MAX_VALUE) {
                this.gsc = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.dtK.getTop());
                    int abs2 = i2 - Math.abs(this.dtK.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.dtK.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.dBB) {
                            marginLayoutParams.topMargin = this.dBB;
                            this.dtK.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.dBB) {
                            if (abs2 > this.dBB) {
                                marginLayoutParams.topMargin = ((abs2 - this.dBB) / 2) + this.dBB;
                                this.dtK.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.dBB) {
                            if (abs2 < this.dBB) {
                                marginLayoutParams.topMargin = this.dBB;
                            } else if (abs2 == this.dBB) {
                                marginLayoutParams.topMargin = this.dBB;
                            } else if (abs2 > this.dBB) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.dtK.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
